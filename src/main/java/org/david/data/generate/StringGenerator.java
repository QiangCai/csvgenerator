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

  //private char[] contentBuffer;
  private int actualLen;

  private String[] list = new String[100];
  private String currentContent = null;

  public StringGenerator(Column column) {
    init(column);
  }

  private void init(Column column) {
    type = (StringType) column.getDataType();
    minLen = type.getMinLen();
    maxLen = type.getMaxLen();
    rangeLen = maxLen - minLen;
    //contentBuffer = new char[maxLen];

    for (int index = 0; index < 100; index ++) {
      int randomLen = 0;
      if (rangeLen >= 1) {
        randomLen = random.nextInt(rangeLen);
      }
      actualLen = minLen + randomLen;
      StringBuilder builder = new StringBuilder(actualLen);
      for (int i = 0; i < actualLen; i++) {
        builder.append(GeneratorUtil.letters[random.nextInt(GeneratorUtil.letterCount)]);
      }
      list[index] = builder.toString();
    }

  }

  @Override public void generate(StringBuilder row) {
//    int randomLen = 0;
//    if (rangeLen >= 1) {
//      randomLen = random.nextInt(rangeLen);
//    }
//    actualLen = minLen + randomLen;
//
//    for (int index = 0; index < actualLen; index++) {
//      contentBuffer[index] = GeneratorUtil.letters[random.nextInt(GeneratorUtil.letterCount)];
//    }
    currentContent = list[random.nextInt(100)];
    row.append(currentContent);
  }

  @Override public void repeat(StringBuilder row) {
    row.append(currentContent);
  }

}
