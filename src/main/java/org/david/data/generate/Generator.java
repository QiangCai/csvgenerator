package org.david.data.generate;

public interface Generator {

  void generate(StringBuilder row);

  void repeat(StringBuilder row);
}
