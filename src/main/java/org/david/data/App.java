package org.david.data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.david.data.file.CsvGenerator;
import org.david.data.file.CsvRequirement;
import org.david.data.table.Column;
import org.david.data.table.ColumnRelation;
import org.david.data.table.SchemaBuilder;

public class App {
  public static void main(String[] args) throws InterruptedException {

    ExecutorService service = Executors.newFixedThreadPool(3);

    service.submit(new Runnable() {
      @Override public void run() {
        generateFile("/opt/bigdata/data/test/datafile1.csv", 1000000, 1);
      }
    });

    service.submit(new Runnable() {
      @Override public void run() {
        generateFile("/opt/bigdata/data/test/datafile2.csv", 1000000, 1000001);
      }
    });

    service.shutdown();
    service.awaitTermination(1, TimeUnit.DAYS);

  }

  private static void generateFile(String filePath, long rowCount, long startId) {
    long t1 = System.currentTimeMillis();
    System.out.println("Start to generate data file ......");

    CsvRequirement requirement = new CsvRequirement(filePath, rowCount, ",", "\r\n");

    System.out.println("file path: " + requirement.getFilePath());

    Column[] columns = createSchema(startId);
    // SORT_COLUMNS: 39,40,41    53
    ColumnRelation columnRelation = new ColumnRelation(38, new int[] { 39, 40 });

    CsvGenerator generator = new CsvGenerator(columns);
    generator.run(requirement, columnRelation);

    System.out.println("finished");

    long t2 = System.currentTimeMillis();
    System.out.println("taken " + (t2 - t1) + " ms");
  }

  private static Column[] createSchema(long startId) {
    SchemaBuilder builder = SchemaBuilder.builder(107)
        //001 BIGINT
        .bigintColumn(startId, true)
        //002 STRING
        .stringColumn(4, 6)
        //003 INT
        .intColumn(1, 1000000)
        //004 INT
        .intColumn(1, 1)
        //005 STRING
        .stringColumn(4, 6)
        //006 STRING
        .stringColumn(0, 0)
        //007 INT
        .intColumn(1, 1)
        //008 STRING
        .stringColumn(4, 6)
        //009 TIMESTAMP
        .timestampColumn("yyyy-MM-dd HH:mm:ss", "2016-01-01", 100)
        //010 STRING
        .stringColumn(4, 6)
        //011 STRING
        .stringColumn(0, 0)
        //012 INT
        .intColumn(1, 1)
        //013 STRING
        .stringColumn(4, 6)
        //014 STRING
        .stringColumn(0, 0)
        //015 STRING
        .stringColumn(4, 6)
        //016 STRING
        .stringColumn(0, 0)
        //017 STRING
        .stringColumn(4, 6)
        //018 STRING
        .stringColumn(0, 0)
        //019 STRING
        .stringColumn(4, 6)
        //020 STRING
        .stringColumn(0, 0)
        //021 STRING
        .stringColumn(4, 6)
        //022 STRING
        .stringColumn(0, 0)
        //023 STRING
        .stringColumn(4, 6)
        //024 STRING
        .stringColumn(0, 0)
        //025 STRING
        .stringColumn(4, 6)
        //026 INT
        .intColumn(1, 1000000)
        //027 INT
        .intColumn(1, 1000000)
        //028 STRING
        .stringColumn(0, 0)
        //029 BIGINT
        .stringColumn(4, 6)
        //030 BIGINT
        .stringColumn(0, 0)
        //031 STRING
        .stringColumn(4, 6)
        //032 STRING
        .stringColumn(0, 0)
        //033 STRING
        .stringColumn(4, 6)
        //034 STRING
        .stringColumn(0, 0)
        //035 STRING
        .stringColumn(4, 6)
        //036 STRING
        .stringColumn(4, 6)
        //037 INT
        .intColumn(1, 1000000)
        //038 STRING
        .stringColumn(4, 6)
        //039 STRING
        .cardinalityStringColumn(11, 10000000)
        //040 STRING
        .stringColumn(4, 6)
        //041 STRING
        .stringColumn(4, 6)
        //042 STRING
        .stringColumn(4, 6)
        //043 STRING
        .stringColumn(4, 6)
        //044 DOUBLE
        .doubleColumn(1, 10000, 2)
        //045 DOUBLE
        .doubleColumn(1, 10000, 2)
        //046 STRING
        .stringColumn(0, 0)
        //047 STRING
        .stringColumn(4, 6)
        //048 STRING
        .stringColumn(0, 0)
        //049 STRING
        .stringColumn(4, 6)
        //050 STRING
        .stringColumn(0, 0)
        //051 STRING
        .stringColumn(4, 6)
        //052 STRING
        .stringColumn(0, 0)
        //053 STRING
        .cardinalityStringColumn(11, 10000000)
        //054 STRING
        .stringColumn(4, 6)
        //055 STRING
        .stringColumn(0, 0)
        //056 STRING
        .stringColumn(4, 6)
        //057 STRING
        .stringColumn(0, 0)
        //058 DOUBLE
        .doubleColumn(1, 10000, 2)
        //059 DOUBLE
        .doubleColumn(1, 10000, 2)
        //060 STRING
        .stringColumn(4, 6)
        //061 STRING
        .stringColumn(0, 0)
        //062 STRING
        .stringColumn(4, 6)
        //063 STRING
        .stringColumn(0, 0)
        //064 STRING
        .stringColumn(4, 6)
        //065 STRING
        .stringColumn(0, 0)
        //066 TIMESTAMP
        //.timestampColumn("yyyy-MM-dd HH:mm:ss", "2016-01-01", 100)
        .stringColumn(0, 0)
        //067 TIMESTAMP
        //.timestampColumn("yyyy-MM-dd HH:mm:ss", "2016-01-01", 100)
        .stringColumn(0, 0)
        //068 TIMESTAMP
        //.timestampColumn("yyyy-MM-dd HH:mm:ss", "2016-01-01", 100)
        .stringColumn(0, 0)
        //069 BIGINT
        .bigintColumn(0, 10000000)
        //070 INT
        .intColumn(1, 1000000)
        //071 STRING
        .stringColumn(0, 0)
        //072 STRING
        .stringColumn(4, 6)
        //073 STRING
        .stringColumn(0, 0)
        //074 STRING
        .stringColumn(4, 6)
        //075 TIMESTAMP
        .timestampColumn("yyyy-MM-dd HH:mm:ss", "2016-01-01", 100)
        //076 STRING
        .stringColumn(4, 6)
        //077 INT
        .intColumn(1, 1000000)
        //078 STRING
        .stringColumn(4, 6)
        //079 INT
        .intColumn(1, 1000000)
        //080 INT
        .intColumn(1, 1000000)
        //081 STRING
        .stringColumn(4, 6)
        //082 INT
        .intColumn(1, 1000000)
        //083 BIGINT
        .bigintColumn(0, 10000000)
        //084 INT
        .intColumn(1, 1000000)
        //085 INT
        .intColumn(1, 1000000)
        //086 INT
        .intColumn(1, 1000000)
        //087 STRING
        .stringColumn(0, 0)
        //088 STRING
        .stringColumn(4, 6)
        //089 STRING
        .stringColumn(0, 0)
        //090 STRING
        .stringColumn(4, 6)
        //091 STRING
        .stringColumn(0, 0)
        //092 STRING
        .stringColumn(4, 6)
        //093 INT
        .intColumn(1, 1000000)
        //094 TIMESTAMP
        .timestampColumn("yyyy-MM-dd HH:mm:ss", "2016-01-01", 100)
        //095 STRING
        .stringColumn(0, 0)
        //096 STRING
        .stringColumn(4, 6)
        //097 STRING
        .stringColumn(0, 0)
        //098 STRING
        .stringColumn(4, 6)
        //099 BIGINT
        .bigintColumn(0, 10000000)
        //100 BIGINT
        .bigintColumn(0, 10000000)
        //101 STRING
        .stringColumn(0, 0)
        //102 DOUBLE
        .doubleColumn(1, 10000, 2)
        //103 DOUBLE
        .doubleColumn(1, 10000, 2)
        //104 STRING
        .stringColumn(0, 0)
        //105 STRING
        .stringColumn(4, 6)
        //106 BIGINT
        .bigintColumn(0, 10000000)
        //107 INT
        .intColumn(1, 1000000);

    return builder.getColumns();
  }

}
