package org.david.data.file;

public class CsvRequirement {

  private String filePath;

  private long rowCount;

  private String columnSeparator;

  private String rowSeparator;

  public CsvRequirement(String filePath, long rowCount, String columnSeparator,
      String rowSeparator) {
    this.filePath = filePath;
    this.rowCount = rowCount;
    this.columnSeparator = columnSeparator;
    this.rowSeparator = rowSeparator;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public long getRowCount() {
    return rowCount;
  }

  public void setRowCount(long rowCount) {
    this.rowCount = rowCount;
  }

  public String getColumnSeparator() {
    return columnSeparator;
  }

  public void setColumnSeparator(String columnSeparator) {
    this.columnSeparator = columnSeparator;
  }

  public String getRowSeparator() {
    return rowSeparator;
  }

  public void setRowSeparator(String rowSeparator) {
    this.rowSeparator = rowSeparator;
  }
}
