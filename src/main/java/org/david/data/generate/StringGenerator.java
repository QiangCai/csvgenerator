package org.david.data.generate;

import java.util.Random;

import org.david.data.datatype.StringType;
import org.david.data.table.Column;

public class StringGenerator implements Generator {

  private StringType type;
  private Random random = new Random();
  private int maxLen;
  private int minLen;
  private int rangeLen;

  private char[] contentBuffer;
  private int actualLen;

  public StringGenerator(Column column) {
    init(column);
  }

  private void init(Column column) {
    type = (StringType) column.getDataType();
    minLen = type.getMinLen();
    maxLen = type.getMaxLen();
    rangeLen = maxLen - minLen;
    contentBuffer = new char[maxLen];
  }

  @Override public void generate(StringBuilder row) {
    int randomLen = 0;
    if (rangeLen >= 1) {
      randomLen = random.nextInt(rangeLen);
    }
    actualLen = minLen + randomLen;

    for (int index = 0; index < actualLen; index++) {
      contentBuffer[index] = GeneratorUtil.letters[random.nextInt(GeneratorUtil.letterCount)];
    }

    row.append(contentBuffer, 0, actualLen);
  }

  @Override public void repeat(StringBuilder row) {
    row.append(contentBuffer, 0, actualLen);
  }

}
