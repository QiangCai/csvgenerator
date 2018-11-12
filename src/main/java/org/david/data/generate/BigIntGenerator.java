package org.david.data.generate;

import java.util.Random;

import org.david.data.datatype.BigIntType;
import org.david.data.table.Column;

public class BigIntGenerator implements Generator {

  private BigIntType type;
  private Random random = new Random();
  private long minValue;
  private long maxValue;
  private long rangeValue;

  public BigIntGenerator(Column column) {
    init(column);
  }

  private void init(Column column) {
    type = (BigIntType) column.getDataType();
    minValue = type.getMin();
    maxValue = type.getMax();
    rangeValue = maxValue - minValue;
  }

  @Override public void generate(StringBuilder row) {
    long randomValue;
    if (rangeValue >= 1) {
      if (rangeValue <= Integer.MAX_VALUE) {
        randomValue = random.nextInt((int) rangeValue);
        row.append(minValue + randomValue);
      } else {
        randomValue = random.nextLong();
        if (randomValue >= minValue && randomValue <= maxValue) {
          row.append(randomValue);
        } else {
          randomValue = random.nextInt(Integer.MAX_VALUE);
          row.append(minValue + randomValue);
        }
      }
    }
  }

  @Override public void repeat(StringBuilder row) {
  }
}
