package org.david.data.datatype;

public class BigIntType extends DataType {

  private long min;

  private long max;

  public BigIntType(long min, long max) {
    super();
    this.min = min;
    this.max = max;
  }

  public long getMin() {
    return min;
  }

  public void setMin(long min) {
    this.min = min;
  }

  public long getMax() {
    return max;
  }

  public void setMax(long max) {
    this.max = max;
  }
}
