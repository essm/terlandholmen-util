package no.terlandholmen.util.date;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;


public class DateUtilTest {

    @Test
    public void verify_Date() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2020, 11, 31);
        Date time = gregorianCalendar.getTime();
        LocalDate actual = DateUtil.convertToLocalDate(time);
        LocalDate parsed = LocalDate.parse("2020-12-31");
        assertEquals(parsed, actual);
    }
}

