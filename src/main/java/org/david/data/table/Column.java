package org.david.data.table;

import org.david.data.datatype.DataType;

public class Column {

  private String name;

  private DataType dataType;

  private boolean isIncreamental;

  public Column(String name, DataType dataType) {
    this(name, dataType, false);
  }

  public Column(String name, DataType dataType, boolean isIncreamental) {
    this.name = name;
    this.dataType = dataType;
    this.isIncreamental = isIncreamental;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DataType getDataType() {
    return dataType;
  }

  public void setDataType(DataType dataType) {
    this.dataType = dataType;
  }

  public boolean isIncreamental() {
    return isIncreamental;
  }

  public void setIncreamental(boolean increamental) {
    isIncreamental = increamental;
  }
}
