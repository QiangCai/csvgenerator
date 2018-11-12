package org.david.data.datatype;

public class StringType extends DataType {

  private int minLen;

  private int maxLen;

  public StringType(int minLen, int maxLen) {
    super();
    this.minLen = minLen;
    this.maxLen = maxLen;
  }

  public int getMinLen() {
    return minLen;
  }

  public void setMinLen(int minLen) {
    this.minLen = minLen;
  }

  public int getMaxLen() {
    return maxLen;
  }

  public void setMaxLen(int maxLen) {
    this.maxLen = maxLen;
  }
}
