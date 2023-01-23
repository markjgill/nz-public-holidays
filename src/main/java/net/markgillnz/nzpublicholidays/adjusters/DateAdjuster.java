package net.markgillnz.nzpublicholidays.adjusters;

import com.aldaviva.easter4j.Easter4J;

import java.time.LocalDate;
import java.time.Month;
import java.util.function.Function;

public enum DateAdjuster {

    JANUARY(firstOfMonth(Month.JANUARY)),
    FEBRUARY(firstOfMonth(Month.FEBRUARY)),
    APRIL(firstOfMonth(Month.APRIL)),
    JUNE(firstOfMonth(Month.JUNE)),
    OCTOBER(firstOfMonth(Month.OCTOBER)),
    DECEMBER(firstOfMonth(Month.DECEMBER)),
    EASTER_SUNDAY(easter());

    private Function<Integer, LocalDate> adjuster;

    DateAdjuster(Function<Integer, LocalDate> adjuster) {
        this.adjuster = adjuster;
    }

    public Function<Integer, LocalDate> get() {
        return adjuster;
    }

    private static Function<Integer, LocalDate> firstOfMonth(Month month) {
        return year -> LocalDate.of(year, month, 1);
    }

    private static Function<Integer, LocalDate> easter() {
        return year -> Easter4J.getEaster(year);
    }
}