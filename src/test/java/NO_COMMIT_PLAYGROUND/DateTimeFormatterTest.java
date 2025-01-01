package NO_COMMIT_PLAYGROUND;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Date;

public class DateTimeFormatterTest {

    @Test
    public void printerTest(){

        //String mKitFormater = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        String mKitFormater = "yyyy-MM-dd['T']HH:mm:ss[XXXXX]";


        DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;

        String dateStr2 = "2023-07-14T23:59:59Z";
        String dateStr3 = "2023-07-14T23:59:59+00:00";

        ZonedDateTime d1 = ZonedDateTime.parse(dateStr2, formatter);
        ZonedDateTime d2 = ZonedDateTime.from(formatter.parse(dateStr3));
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d1.equals(d2));
    }
}
