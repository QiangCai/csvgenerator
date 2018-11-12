package org.david.data.generate;

import java.util.Random;

import org.david.data.datatype.DoubleType;
import org.david.data.table.Column;

public class DoubleGenerator implements Generator {

  private Random random = new Random();
  private DoubleType type;
  private int minValue;
  private int maxValue;
  private int scale;
  private int rangeValue;

  private char[] contentBuffer;

  public DoubleGenerator(Column column) {
    init(column);
  }

  private void init(Column column) {
    type = (DoubleType) column.getDataType();
    minValue = type.getMin();
    maxValue = type.getMax();
    rangeValue = maxValue - minValue;
    scale = type.getScale();
    contentBuffer = new char[1 + scale];
    contentBuffer[0] = '.';
  }

  @Override public void generate(StringBuilder row) {
    int randomValue = 0;
    if (rangeValue >= 1) {
      randomValue = random.nextInt(rangeValue);
    }
    int actualValue = minValue + randomValue;

    for (int index = 1; index <= scale; index++) {
      contentBuffer[index] = GeneratorUtil.digits[random.nextInt(GeneratorUtil.digitCount)];
    }

    row.append(actualValue).append(contentBuffer);
  }

  @Override public void repeat(StringBuilder row) {

  }
}
