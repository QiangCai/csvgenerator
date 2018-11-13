package org.david.data.generate;

import java.util.Random;

import org.david.data.table.Column;

public class PhoneNumberGenerator implements Generator {

  private long[] numbers =
      new long[] { 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 145, 147, 149, 150, 151, 152,
          153, 155, 156, 157, 158, 159, 166, 171, 172, 173, 175, 176, 177, 178, 180, 181, 182, 183,
          184, 185, 186, 187, 188, 189, 198, 199 };
  private int numberCount = numbers.length;
  private int cardinality;
  private Random random = new Random();
  private long content;

  public PhoneNumberGenerator(Column column) {
    init(column);
  }

  private void init(Column column) {
    cardinality = column.getCardinality();
    for (int index = 0; index < numberCount; index++) {
      numbers[index] = numbers[index] * 100000000;
    }
  }

  @Override public void generate(StringBuilder row) {
    content = numbers[random.nextInt(numberCount)] + random.nextInt(cardinality);
    row.append(content);
  }

  @Override public void repeat(StringBuilder row) {
    row.append(content);
  }
}
