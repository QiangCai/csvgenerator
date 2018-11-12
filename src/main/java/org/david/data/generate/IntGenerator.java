package org.david.data.generate;

import java.util.Random;

import org.david.data.datatype.IntType;
import org.david.data.table.Column;

public class IntGenerator implements Generator {

  private IntType type;
  private int minValue;
  private int maxValue;
  private int rangeValue;

  private Random random = new Random();

  public IntGenerator(Column column) {
    init(column);
  }

  private void init(Column column) {
    type = (IntType) column.getDataType();
    this.minValue = type.getMin();
    this.maxValue = type.getMax();
    rangeValue = maxValue - minValue;
  }

  @Override public void generate(StringBuilder row) {
    int randomValue = 0;
    if (rangeValue >= 1) {
      randomValue = random.nextInt(rangeValue);
    }
    int actualValue = minValue + randomValue;

    row.append(actualValue);
  }

  @Override public void repeat(StringBuilder row) {
  }
}
