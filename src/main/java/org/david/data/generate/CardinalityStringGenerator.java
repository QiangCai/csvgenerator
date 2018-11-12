package org.david.data.generate;

import java.util.Random;

import org.david.data.datatype.StringType;
import org.david.data.table.Column;

public class CardinalityStringGenerator implements Generator {

  private StringType type;
  private int cardinality;
  private long start;
  private Random random = new Random();
  private long content;

  public CardinalityStringGenerator(Column column) {
    init(column);
  }

  private void init(Column column) {
    type = (StringType) column.getDataType();
    cardinality = column.getCardinality();
    int minLen = type.getMinLen();
    char[] chars  = new char[minLen];
    chars[0] = '1';
    for (int index = 1; index < minLen; index++) {
      chars[index] = '0';
    }
    start = Long.parseLong(new String(chars));
  }

  @Override public void generate(StringBuilder row) {
    content = start + random.nextInt(cardinality);
    row.append(content);
  }

  @Override public void repeat(StringBuilder row) {
    row.append(content);
  }
}
