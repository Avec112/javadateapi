package io.avec.javadateapi;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateTest {

    @Test
    void getZuluTime() {
        Instant zulu = Instant.now();
        System.out.println(zulu);

        ZonedDateTime losAngles = ZonedDateTime.ofInstant(zulu, ZoneId.of("America/Los_Angeles"));
        System.out.println(losAngles);

        ZonedDateTime oslo = ZonedDateTime.ofInstant(losAngles.toInstant(), ZoneId.of("Europe/Oslo"));
        System.out.println("LA -> Oslo = " + losAngles.toLocalTime() + " ("+losAngles.getOffset()+") -> " + oslo.toLocalTime()+ " ("+oslo.getOffset()+")");
    }

    @Test
    void dateToLocalDateTime() {
        Date today = new Date();
        System.out.println(today);
        LocalDateTime ldt = LocalDateTime.ofInstant(today.toInstant(),
                ZoneId.systemDefault());
        System.out.println(ldt);
    }

    @Test
    void localDateTimeToDate() {
        Instant zulu = Instant.now();
        System.out.println("zulu " + zulu);
//        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldt = LocalDateTime.ofInstant(zulu, ZoneId.systemDefault());
        System.out.println("ldt " + ldt);
        System.out.println("ldt " + ldt.toLocalDate());
        System.out.println("ldt " + ldt.toLocalTime());
        ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault());
        System.out.println("zdt " + zdt);
        System.out.println("zdt " + zdt.toLocalDate());
        System.out.println("zdt " + zdt.toLocalTime());
        Date output = Date.from(zdt.toInstant());
        System.out.println(output);

        assertEquals(output.getTime(), zdt.toInstant().toEpochMilli());
    }
}
