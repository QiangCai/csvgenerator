package org.david.data.datatype;

public class TimestampType extends DataType {

  private String start;

  private String format;

  private int days;

  public TimestampType(String format, String start, int days) {
    super();
    this.format = format;
    this.start = start;
    this.days = days;
  }

  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public int getDays() {
    return days;
  }

  public void setDays(int days) {
    this.days = days;
  }
}
