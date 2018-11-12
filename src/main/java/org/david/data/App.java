package org.david.data;

import org.david.data.file.CsvGenerator;
import org.david.data.file.CsvRequirement;
import org.david.data.table.Column;
import org.david.data.table.ColumnRelation;
import org.david.data.table.SchemaBuilder;

public class App {
  public static void main(String[] args) {
    long t1 = System.currentTimeMillis();
    System.out.println("Start to generate data file ......");

    CsvRequirement requirement =
        new CsvRequirement("/opt/bigdata/data/test/datafile.csv", 1000000, ",", "\r\n");

    System.out.println("file path: " + requirement.getFilePath());

    Column[] columns = createSchema();
    // SORT_COLUMNS: 39,40,41    53
    ColumnRelation columnRelation = new ColumnRelation(38, new int[]{39, 40});

    CsvGenerator generator = new CsvGenerator(columns);
    generator.run(requirement, columnRelation);

    System.out.println("finished");

    long t2 = System.currentTimeMillis();
    System.out.println("taken " + (t2 -t1) + " ms");
  }

  public static Column[] createSchema() {

    SchemaBuilder builder = SchemaBuilder.builder(107)
        //001 BIGINT
        .bigintColumn(0, 100000000, true)
        //002 STRING
        .stringColumn(5, 10)
        //003 INT
        .intColumn(1, 1000000)
        //004 INT
        .intColumn(1, 1000000)
        //005 STRING
        .stringColumn(5, 10)
        //006 STRING
        .stringColumn(5, 10)
        //007 INT
        .intColumn(1, 1000000)
        //008 STRING
        .stringColumn(5, 10)
        //009 TIMESTAMP
        .timestampColumn("yyyy-MM-dd HH:mm:ss", "2016-01-01", 100)
        //010 STRING
        .stringColumn(5, 10)
        //011 STRING
        .stringColumn(5, 10)
        //012 INT
        .intColumn(1, 1000000)
        //013 STRING
        .stringColumn(5, 10)
        //014 STRING
        .stringColumn(5, 10)
        //015 STRING
        .stringColumn(5, 10)
        //016 STRING
        .stringColumn(5, 10)
        //017 STRING
        .stringColumn(5, 10)
        //018 STRING
        .stringColumn(5, 10)
        //019 STRING
        .stringColumn(5, 10)
        //020 STRING
        .stringColumn(5, 10)
        //021 STRING
        .stringColumn(5, 10)
        //022 STRING
        .stringColumn(5, 10)
        //023 STRING
        .stringColumn(5, 10)
        //024 STRING
        .stringColumn(5, 10)
        //025 STRING
        .stringColumn(5, 10)
        //026 INT
        .intColumn(1, 1000000)
        //027 INT
        .intColumn(1, 1000000)
        //028 STRING
        .stringColumn(5, 10)
        //029 BIGINT
        .stringColumn(5, 10)
        //030 BIGINT
        .stringColumn(5, 10)
        //031 STRING
        .stringColumn(5, 10)
        //032 STRING
        .stringColumn(5, 10)
        //033 STRING
        .stringColumn(5, 10)
        //034 STRING
        .stringColumn(5, 10)
        //035 STRING
        .stringColumn(5, 10)
        //036 STRING
        .stringColumn(5, 10)
        //037 INT
        .intColumn(1, 1000000)
        //038 STRING
        .stringColumn(5, 10)
        //039 STRING
        .stringColumn(11, 11)
        //040 STRING
        .stringColumn(5, 10)
        //041 STRING
        .stringColumn(5, 10)
        //042 STRING
        .stringColumn(5, 10)
        //043 STRING
        .stringColumn(5, 10)
        //044 DOUBLE
        .doubleColumn(1, 10000, 2)
        //045 DOUBLE
        .doubleColumn(1, 10000, 2)
        //046 STRING
        .stringColumn(5, 10)
        //047 STRING
        .stringColumn(5, 10)
        //048 STRING
        .stringColumn(5, 10)
        //049 STRING
        .stringColumn(5, 10)
        //050 STRING
        .stringColumn(5, 10)
        //051 STRING
        .stringColumn(5, 10)
        //052 STRING
        .stringColumn(5, 10)
        //053 STRING
        .stringColumn(5, 10)
        //054 STRING
        .stringColumn(5, 10)
        //055 STRING
        .stringColumn(5, 10)
        //056 STRING
        .stringColumn(5, 10)
        //057 STRING
        .stringColumn(5, 10)
        //058 DOUBLE
        .doubleColumn(1, 10000, 2)
        //059 DOUBLE
        .doubleColumn(1, 10000, 2)
        //060 STRING
        .stringColumn(5, 10)
        //061 STRING
        .stringColumn(5, 10)
        //062 STRING
        .stringColumn(5, 10)
        //063 STRING
        .stringColumn(5, 10)
        //064 STRING
        .stringColumn(5, 10)
        //065 STRING
        .stringColumn(5, 10)
        //066 TIMESTAMP
        .timestampColumn("yyyy-MM-dd HH:mm:ss", "2016-01-01", 100)
        //067 TIMESTAMP
        .timestampColumn("yyyy-MM-dd HH:mm:ss", "2016-01-01", 100)
        //068 TIMESTAMP
        .timestampColumn("yyyy-MM-dd HH:mm:ss", "2016-01-01", 100)
        //069 BIGINT
        .bigintColumn(0, 100000000)
        //070 INT
        .intColumn(1, 1000000)
        //071 STRING
        .stringColumn(5, 10)
        //072 STRING
        .stringColumn(5, 10)
        //073 STRING
        .stringColumn(5, 10)
        //074 STRING
        .stringColumn(5, 10)
        //075 TIMESTAMP
        .timestampColumn("yyyy-MM-dd HH:mm:ss", "2016-01-01", 100)
        //076 STRING
        .stringColumn(5, 10)
        //077 INT
        .intColumn(1, 1000000)
        //078 STRING
        .stringColumn(5, 10)
        //079 INT
        .intColumn(1, 1000000)
        //080 INT
        .intColumn(1, 1000000)
        //081 STRING
        .stringColumn(5, 10)
        //082 INT
        .intColumn(1, 1000000)
        //083 BIGINT
        .bigintColumn(0, 100000000)
        //084 INT
        .intColumn(1, 1000000)
        //085 INT
        .intColumn(1, 1000000)
        //086 INT
        .intColumn(1, 1000000)
        //087 STRING
        .stringColumn(5, 10)
        //088 STRING
        .stringColumn(5, 10)
        //089 STRING
        .stringColumn(5, 10)
        //090 STRING
        .stringColumn(5, 10)
        //091 STRING
        .stringColumn(5, 10)
        //092 STRING
        .stringColumn(5, 10)
        //093 INT
        .intColumn(1, 1000000)
        //094 TIMESTAMP
        .timestampColumn("yyyy-MM-dd HH:mm:ss", "2016-01-01", 100)
        //095 STRING
        .stringColumn(5, 10)
        //096 STRING
        .stringColumn(5, 10)
        //097 STRING
        .stringColumn(5, 10)
        //098 STRING
        .stringColumn(5, 10)
        //099 BIGINT
        .bigintColumn(0, 100000000)
        //100 BIGINT
        .bigintColumn(0, 100000000)
        //101 STRING
        .stringColumn(5, 10)
        //102 DOUBLE
        .doubleColumn(1, 10000, 2)
        //103 DOUBLE
        .doubleColumn(1, 10000, 2)
        //104 STRING
        .stringColumn(5, 10)
        //105 STRING
        .stringColumn(5, 10)
        //106 BIGINT
        .bigintColumn(0, 100000000)
        //107 INT
        .intColumn(1, 1000000);

    return builder.getColumns();
  }

}
