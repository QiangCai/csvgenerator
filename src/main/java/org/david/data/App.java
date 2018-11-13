package org.david.data;

import org.david.data.file.CsvGenerator;
import org.david.data.file.CsvRequirement;
import org.david.data.table.Column;
import org.david.data.table.ColumnRelation;
import org.david.data.table.SchemaBuilder;

public class App {
  public static void main(String[] args) throws InterruptedException {
    if (args.length < 4) {
      System.err.println("Usage: App <file path> <row count> <start id> <phone number cardinality>");
      System.exit(0);
    }

    String filePath = args[0];
    long rowCount = Long.parseLong(args[1]);
    long startId = Long.parseLong(args[2]);
    int cardinality = Integer.parseInt(args[3]);
    generateFile(filePath, rowCount, startId, cardinality);
  }

  private static void generateFile(String filePath, long rowCount, long startId, int cardinality) {
    long t1 = System.currentTimeMillis();
    System.out.println("Start to generate data file ......");

    CsvRequirement requirement = new CsvRequirement(filePath, rowCount, ",", "\r\n");

    System.out.println("file path: " + requirement.getFilePath());

    Column[] columns = createSchema(startId, cardinality);
    // SORT_COLUMNS: 39,40,41    53
    ColumnRelation columnRelation = new ColumnRelation(38, new int[] { 39, 40 });

    CsvGenerator generator = new CsvGenerator(columns);
    generator.run(requirement, columnRelation);

    System.out.println("finished");

    long t2 = System.currentTimeMillis();
    System.out.println("taken " + (t2 - t1) + " ms");
  }

  private static Column[] createSchema(long startId, int cardinality) {
    SchemaBuilder builder = SchemaBuilder.builder(107)
        //001 BIGINT
        .bigintColumn(startId, true)
        //002 STRING
        .stringColumn(4, 6)
        //003 INT
        //.intColumn(1, 1000000)
        .nullColumn()
        //004 INT
        //.intColumn(1, 1)
        .nullColumn()
        //005 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //006 STRING
        //.stringColumn(0, 0)
        .nullColumn()
        //007 INT
        //.intColumn(1, 1)
        .nullColumn()
        //008 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //009 TIMESTAMP
        .timestampColumn("yyyy-MM-dd", "2016-01-01", 1)
        //010 STRING
        //.stringColumn(0, 0)
        .nullColumn()
        //011 STRING
        //.stringColumn(0, 0)
        .nullColumn()
        //012 INT
        //.intColumn(1, 1)
        .nullColumn()
        //013 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //014 STRING
        //.stringColumn(0, 0)
        .nullColumn()
        //015 STRING
        //.stringColumn(0, 0)
        .nullColumn()
        //016 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //017 STRING
        //.stringColumn(0, 0)
        .nullColumn()
        //018 STRING
        //.stringColumn(0, 0)
        .nullColumn()
        //019 STRING
        //.stringColumn(0, 0)
        .nullColumn()
        //020 STRING
        //.stringColumn(0, 0)
        .nullColumn()
        //021 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //022 STRING
        //.stringColumn(0, 0)
        .nullColumn()
        //023 STRING
        //.stringColumn(0, 0)
        .nullColumn()
        //024 STRING
        //.stringColumn(0, 0)
        .nullColumn()
        //025 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //026 INT
        //.intColumn(1, 1000000)
        .nullColumn()
        //027 INT
        //.intColumn(1, 1000000)
        .nullColumn()
        //028 STRING
        //.stringColumn(0, 0)
        .nullColumn()
        //029 BIGINT
        //.stringColumn(4, 6)
        .nullColumn()
        //030 BIGINT
        //.stringColumn(0, 0)
        .nullColumn()
        //031 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //032 STRING
        //.stringColumn(0, 0)
        .nullColumn()
        //033 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //034 STRING
        //.stringColumn(0, 0)
        .nullColumn()
        //035 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //036 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //037 INT
        //.intColumn(1, 1000000)
        .nullColumn()
        //038 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //039 STRING
        .phoneNumber(cardinality)
        //040 STRING
        .stringColumn(4, 6)
        //041 STRING
        .stringColumn(4, 6)
        //042 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //043 STRING
        .stringColumn(4, 6)
        //044 DOUBLE
        //.doubleColumn(1, 10000, 2)
        .nullColumn()
        //045 DOUBLE
        //.doubleColumn(1, 10000, 2)
        .nullColumn()
        //046 STRING
        //.stringColumn(0, 0)
        .nullColumn()
        //047 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //048 STRING
        //.stringColumn(0, 0)
        .nullColumn()
        //049 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //050 STRING
        .stringColumn(0, 0)
        //051 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //052 STRING
        .stringColumn(0, 0)
        //053 STRING
        .phoneNumber(cardinality)
        //054 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //055 STRING
        .stringColumn(0, 0)
        //056 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //057 STRING
        .stringColumn(0, 0)
        //058 DOUBLE
        .doubleColumn(1, 100, 2)
        //059 DOUBLE
        //.doubleColumn(1, 10000, 2)
        .nullColumn()
        //060 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //061 STRING
        .stringColumn(0, 0)
        //062 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //063 STRING
        .stringColumn(0, 0)
        //064 STRING
        //.stringColumn(4, 6)
        .nullColumn()
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
        //.bigintColumn(0, 10000000)
        .nullColumn()
        //070 INT
        //.intColumn(1, 1000000)
        .nullColumn()
        //071 STRING
        .stringColumn(0, 0)
        //072 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //073 STRING
        .stringColumn(0, 0)
        //074 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //075 TIMESTAMP
        //.timestampColumn("yyyy-MM-dd HH:mm:ss", "2016-01-01", 100)
        .stringColumn(0, 0)
        //076 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //077 INT
        //.intColumn(1, 1000000)
        .stringColumn(0, 0)
        //078 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //079 INT
        //.intColumn(1, 1000000)
        .stringColumn(0, 0)
        //080 INT
        //.intColumn(1, 1000000)
        .stringColumn(0, 0)
        //081 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //082 INT
        //.intColumn(1, 1000000)
        .nullColumn()
        //083 BIGINT
        //.bigintColumn(0, 10000000)
        .nullColumn()
        //084 INT
        //.intColumn(1, 1000000)
        .nullColumn()
        //085 INT
        //.intColumn(1, 1000000)
        .nullColumn()
        //086 INT
        //.intColumn(1, 1000000)
        .nullColumn()
        //087 STRING
        .nullColumn()
        //088 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //089 STRING
        .nullColumn()
        //090 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //091 STRING
        .nullColumn()
        //092 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //093 INT
        //.intColumn(1, 1000000)
        .nullColumn()
        //094 TIMESTAMP
        //.timestampColumn("yyyy-MM-dd HH:mm:ss", "2016-01-01", 100)
        .nullColumn()
        //095 STRING
        .stringColumn(0, 0)
        //096 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //097 STRING
        .stringColumn(0, 0)
        //098 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //099 BIGINT
        .bigintColumn(0, 10000)
        //100 BIGINT
        //.bigintColumn(0, 10000000)
        .nullColumn()
        //101 STRING
        .stringColumn(0, 0)
        //102 DOUBLE
        //.doubleColumn(1, 10000, 2)
        .nullColumn()
        //103 DOUBLE
        //.doubleColumn(1, 10000, 2)
        .nullColumn()
        //104 STRING
        .stringColumn(0, 0)
        //105 STRING
        //.stringColumn(4, 6)
        .nullColumn()
        //106 BIGINT
        //.bigintColumn(0, 10000000)
        .nullColumn()
        //107 INT
        .intColumn(1, 1000);

    return builder.getColumns();
  }

}
