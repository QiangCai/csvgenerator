package org.david.data.generate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.david.data.datatype.TimestampType;
import org.david.data.table.Column;

public class TimestampGenerator implements Generator {

  private TimestampType type;
  private int rangeDays;
  private SimpleDateFormat dateFormat;
  private Date startDate;
  private Calendar calendar = Calendar.getInstance();
  private Random random = new Random();

  public TimestampGenerator(Column column) {
    init(column);
  }

  private void init(Column column) {
    type = (TimestampType) column.getDataType();
    rangeDays = type.getDays();

    try {
      startDate = new SimpleDateFormat("yyyy-MM-dd").parse(type.getStart());
    } catch (ParseException e) {
      startDate = new Date("yyyy-MM-dd");
    }

    dateFormat = new SimpleDateFormat(type.getFormat());

    calendar.setTime(startDate);

  }

  @Override public void generate(StringBuilder row) {
    calendar.add(Calendar.DATE, random.nextInt(rangeDays));
    String newDate = dateFormat.format(calendar.getTime());
    row.append(newDate);
    calendar.setTime(startDate);
  }

  @Override public void repeat(StringBuilder row) {

  }
}
