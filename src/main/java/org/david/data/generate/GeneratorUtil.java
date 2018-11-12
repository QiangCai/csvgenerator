package org.david.data.generate;

import org.david.data.datatype.BigIntType;
import org.david.data.datatype.DoubleType;
import org.david.data.datatype.IntType;
import org.david.data.datatype.StringType;
import org.david.data.datatype.TimestampType;
import org.david.data.table.Column;

public class GeneratorUtil {

  public static String letterString = "abcdefghijklmnopqrstuvwxyz";
  public static char[] letters = letterString.toCharArray();
  public static int letterCount = letters.length;
  public static String digitString = "0123456789";
  public static char[] digits = digitString.toCharArray();
  public static int digitCount = digits.length;
  public static char[] letterAndDigits = (letterString + digitString).toCharArray();
  public static int letterAndDigitCount = letterAndDigits.length;

  public static Generator getGenerator(Column column) {
    if (column.getDataType() instanceof StringType) {
      return new StringGenerator(column);
    } else if (column.getDataType() instanceof IntType) {
      return new IntGenerator(column);
    } else if (column.getDataType() instanceof BigIntType) {
      if (column.isIncreamental()) {
        return new IdGenerator(column);
      } else {
        return new BigIntGenerator(column);
      }
    } else if (column.getDataType() instanceof DoubleType) {
      return new DoubleGenerator(column);
    } else if (column.getDataType() instanceof TimestampType) {
      return new TimestampGenerator(column);
    }

    return new DefaultGenerator();
  }

  public static Generator getRelatedGenerator(Column column, Generator generator) {
    return new RelatedGenerator(column, generator);
  }

}
