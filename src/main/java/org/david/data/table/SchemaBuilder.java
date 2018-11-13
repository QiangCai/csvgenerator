package org.david.data.table;

import org.david.data.datatype.BigIntType;
import org.david.data.datatype.DataType;
import org.david.data.datatype.DoubleType;
import org.david.data.datatype.IntType;
import org.david.data.datatype.StringType;
import org.david.data.datatype.TimestampType;

public class SchemaBuilder {

  private int columnIndex = 0;

  private int columnNum = 0;

  private Column[] columns;

  private SchemaBuilder(int columnNum) {
    this.columnNum = columnNum;
    this.columns = new Column[columnNum];
  }

  public static SchemaBuilder builder(int columnNum) {
    return new SchemaBuilder(columnNum);
  }

  private Column column(DataType dataType) {
    return new Column("col" + (columnIndex + 1), dataType);
  }

  private Column column(DataType dataType, boolean isIncreamental) {
    return new Column("col" + (columnIndex + 1), dataType, isIncreamental);
  }

  private Column column(DataType dataType, int cardinality) {
    return new Column("col" + (columnIndex + 1), dataType, cardinality);
  }

  public SchemaBuilder nullColumn() {
    columns[columnIndex] = column(new StringType(0, 0));
    columnIndex++;
    return this;
  }

  public SchemaBuilder stringColumn(int minLen, int maxLen) {
    columns[columnIndex] = column(new StringType(minLen, maxLen));
    columnIndex++;
    return this;
  }

  public SchemaBuilder phoneNumber(int cardinality) {
    columns[columnIndex] = column(new StringType(11, 11), cardinality);
    columnIndex++;
    return this;
  }

  public SchemaBuilder intColumn(int min, int max) {
    columns[columnIndex] = column(new IntType(min, max));
    columnIndex++;
    return this;
  }

  public SchemaBuilder bigintColumn(long min, long max) {
    columns[columnIndex] = column(new BigIntType(min, max));
    columnIndex++;
    return this;
  }

  public SchemaBuilder bigintColumn(long start, boolean isIncreamental) {
    columns[columnIndex] = column(new BigIntType(start, start), isIncreamental);
    columnIndex++;
    return this;
  }

  public SchemaBuilder doubleColumn(int min, int max, int scale) {
    columns[columnIndex] = column(new DoubleType(min, max, scale));
    columnIndex++;
    return this;
  }

  public SchemaBuilder timestampColumn(String format, String start, int days) {
    columns[columnIndex] = column(new TimestampType(format, start, days));
    columnIndex++;
    return this;
  }


  public Column[] getColumns() {
    return columns;
  }

}
