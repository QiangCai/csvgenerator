package org.david.data.generate;

import org.david.data.datatype.BigIntType;
import org.david.data.table.Column;

public class IdGenerator implements Generator {

  private BigIntType type;
  private long start = 0;

  public IdGenerator(Column column) {
    init(column);
  }

  private void init(Column column) {
    type = (BigIntType) column.getDataType();
    start = type.getMin();
  }

  @Override public void generate(StringBuilder row) {
    row.append(start++);
  }

  @Override public void repeat(StringBuilder row) {
  }
}
