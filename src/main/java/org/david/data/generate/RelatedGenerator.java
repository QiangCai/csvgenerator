package org.david.data.generate;

import java.util.Random;

import org.david.data.table.Column;

public class RelatedGenerator implements Generator {

  private Generator generator;
  private Random random = new Random();

  public RelatedGenerator(Column column, Generator generator) {
    this.generator = generator;
  }

  @Override public void generate(StringBuilder row) {
    generator.repeat(row);
    row.append(random.nextInt(10));
  }

  @Override public void repeat(StringBuilder row) {

  }
}
