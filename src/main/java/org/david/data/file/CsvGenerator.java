package org.david.data.file;

import java.io.FileWriter;
import java.io.IOException;

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

    try (FileWriter writer = new FileWriter(requirement.getFilePath())) {
      rowBuilder = new StringBuilder(columnCount * 20);

      generateRow0();
      writer.write(rowBuilder.toString());
      rowBuilder.setLength(0);

      for (long index = 1; index < rowCount; index++) {
        generateRow();
        writer.write(rowBuilder.toString());
        rowBuilder.setLength(0);
        if (index % 20000 == 0) {
          System.out.println(index);
          writer.flush();
        }
      }
      writer.flush();
    } catch (IOException e) {
      e.printStackTrace();
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
