package org.david.data.file;

import java.io.IOException;
import java.text.NumberFormat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.david.data.generate.Generator;
import org.david.data.generate.GeneratorUtil;
import org.david.data.table.Column;
import org.david.data.table.ColumnRelation;

public class CsvGenerator {

  private Column[] columns;
  private int columnCount;
  private Generator[] generators;

  private StringBuilder rowBuilder;

  private char[] columnSeparator;
  private char[] rowSeparator;
  private ColumnRelation columnRelation;

  public CsvGenerator(Column[] columns) {
    this.columns = columns;
    this.columnCount = columns.length;
  }

  public void run(CsvRequirement requirement, ColumnRelation columnRelation) {
    long rowCount = requirement.getRowCount();
    this.columnSeparator = requirement.getColumnSeparator().toCharArray();
    this.rowSeparator = requirement.getRowSeparator().toCharArray();
    this.columnRelation = columnRelation;
    createGenerators();

    Path filePath = new Path(requirement.getFilePath());

    FileSystem fileSystem = null;
    FSDataOutputStream writer = null;
    try {
      Configuration hadoopConfig = new Configuration();
      hadoopConfig.set("fs.hdfs.impl",
          org.apache.hadoop.hdfs.DistributedFileSystem.class.getName()
      );
      hadoopConfig.set("fs.file.impl",
          org.apache.hadoop.fs.LocalFileSystem.class.getName()
      );
      hadoopConfig.addResource(new Path("core-site.xml"));
      hadoopConfig.addResource(new Path("hdfs-site.xml"));

      fileSystem = filePath.getFileSystem(hadoopConfig);

      writer = fileSystem.create(filePath, true, 1024 * 1024, (short) 2, 64 * 1024 * 1024);
      rowBuilder = new StringBuilder(columnCount * 20);

      generateRow0();
      writer.write(rowBuilder.toString().getBytes());
      rowBuilder.setLength(0);

      NumberFormat numberFormat = NumberFormat.getInstance();
      long index = 1;
      for (; index < rowCount; index++) {
        generateRow();
        writer.write(rowBuilder.toString().getBytes());
        rowBuilder.setLength(0);
        if (index % 200000 == 0) {
          System.out.println(numberFormat.format(index));
          // writer.flush();
        }
      }
      writer.flush();
      System.out.println(numberFormat.format(index));
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (writer != null) {
        try {
          writer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (fileSystem != null) {
        try {
          fileSystem.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private void createGenerators() {
    generators = new Generator[columns.length];

    generators[columnRelation.getBaseColumnIndex()] =
        GeneratorUtil.getGenerator(columns[columnRelation.getBaseColumnIndex()]);
    for (int columnIndex : columnRelation.getRelatedColumnIndexs()) {
      generators[columnIndex] = GeneratorUtil.getRelatedGenerator(columns[columnIndex],
          generators[columnRelation.getBaseColumnIndex()]);
    }

    for (int index = 0; index < columnCount; index++) {
      if (generators[index] == null) {
        generators[index] = GeneratorUtil.getGenerator(columns[index]);
      }
    }
  }

  private void generateRow0() {
    generators[0].generate(rowBuilder);
    for (int index = 1; index < columnCount; index++) {
      rowBuilder.append(columnSeparator);
      generators[index].generate(rowBuilder);
    }
  }

  private void generateRow() {
    rowBuilder.append(rowSeparator);
    generateRow0();
  }

}
