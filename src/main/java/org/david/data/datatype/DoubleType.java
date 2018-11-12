package org.david.data.datatype;

public class DoubleType extends DataType {

  private int min;

  private int max;

  private int scale;

  public DoubleType(int min, int max, int scale) {
    super();
    this.min = min;
    this.max = max;
    this.scale = scale;
  }

  public int getMin() {
    return min;
  }

  public void setMin(int min) {
    this.min = min;
  }

  public int getMax() {
    return max;
  }

  public void setMax(int max) {
    this.max = max;
  }

  public int getScale() {
    return scale;
  }

  public void setScale(int scale) {
    this.scale = scale;
  }
}
