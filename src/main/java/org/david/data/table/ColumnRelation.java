package org.david.data.table;

public class ColumnRelation {

  private int baseColumnIndex;
  private int[] relatedColumnIndexs;

  public ColumnRelation(int baseColumnIndex, int[] relatedColumnIndexs) {
    this.baseColumnIndex = baseColumnIndex;
    this.relatedColumnIndexs = relatedColumnIndexs;
  }

  public int getBaseColumnIndex() {
    return baseColumnIndex;
  }

  public void setBaseColumnIndex(int baseColumnIndex) {
    this.baseColumnIndex = baseColumnIndex;
  }

  public int[] getRelatedColumnIndexs() {
    return relatedColumnIndexs;
  }

  public void setRelatedColumnIndexs(int[] relatedColumnIndexs) {
    this.relatedColumnIndexs = relatedColumnIndexs;
  }
}
