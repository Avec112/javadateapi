package io.avec.javadateapi;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateTest {

    @Test
    void getZuluTime() {
        Instant zulu = Instant.now();
        System.out.println(zulu);

        ZonedDateTime losAngles = ZonedDateTime.ofInstant(zulu, ZoneId.of("America/Los_Angeles"));

        ZonedDateTime oslo = ZonedDateTime.ofInstant(losAngles.toInstant(), ZoneId.of("Europe/Oslo"));
        System.out.println("LA -> Oslo = " + losAngles.toLocalTime() + " ("+losAngles.getOffset()+") -> " + oslo.toLocalTime()+ " ("+oslo.getOffset()+")");
    }

    @Test
    void dateToLocalDateTime() {
        Date today = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(today.toInstant(),
                ZoneId.systemDefault());
        System.out.println(ldt);
    }

    @Test
    void localDateTimeToDate() {
        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault());
        Date output = Date.from(zdt.toInstant());
        assertEquals(output.getTime(), zdt.toInstant().toEpochMilli());
    }

    @Test
    void timeZoneDifference() {

        // time in Hawaii
        ZonedDateTime hawaii = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("US/Hawaii"));
        System.out.println(hawaii);

        // Convert Hawaii time to Kabul time
        ZonedDateTime kabul = ZonedDateTime.ofInstant(hawaii.toInstant(), ZoneId.of("Asia/Kabul"));
        System.out.println(kabul);

    }
}
