package net.markgillnz.nzpublicholidays.adjusters;

import io.vavr.collection.Array;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Function;

import static io.vavr.API.*;
import static java.time.DayOfWeek.*;

public enum DayAdjuster {

    FIRST(dayOfMonth(1)),
    SECOND(dayOfMonth(2)),
    SIXTH(dayOfMonth(6)),
    TWENTY_FIFTH(dayOfMonth(25)),
    TWENTY_SIXTH(dayOfMonth(26)),
    TWENTY_NINTH(dayOfMonth(29)),
    FIRST_MONDAY(firstMondayOfMonth()),
    FOURTH_MONDAY(fourthMondayOfMonth()),
    PREVIOUS_FRIDAY(previousFriday()),
    NEXT_MONDAY(nextMonday()),
    CLOSEST_MONDAY(closestMonday()),
    MONDAYISATION(mondayisation()),
    TUESDAYISATION(tuesdayisation());

    private Function<LocalDate, LocalDate> adjuster;

    DayAdjuster(Function<LocalDate, LocalDate> adjuster) {
        this.adjuster = adjuster;
    }

    public Function<LocalDate, LocalDate> get() {
        return adjuster;
    }

    private static Function<LocalDate, LocalDate> dayOfMonth(Integer day) {
        return date -> date.withDayOfMonth(day);
    }

    private static Function<LocalDate, LocalDate> firstMondayOfMonth() {
        return date -> date.with(TemporalAdjusters.firstInMonth(MONDAY));
    }

    private static Function<LocalDate, LocalDate> fourthMondayOfMonth() {
        return date -> date.with(TemporalAdjusters.dayOfWeekInMonth(4, MONDAY));
    }

    private static Function<LocalDate, LocalDate> previousMonday() {
        return date -> date.with(TemporalAdjusters.previousOrSame(MONDAY));
    }

    private static Function<LocalDate, LocalDate> previousFriday() {
        return date -> date.with(TemporalAdjusters.previousOrSame(FRIDAY));
    }

    private static Function<LocalDate, LocalDate> nextMonday() {
        return date -> date.with(TemporalAdjusters.nextOrSame(MONDAY));
    }

    private static Function<LocalDate, LocalDate> nextTuesday() {
        return date -> date.with(TemporalAdjusters.nextOrSame(TUESDAY));
    }

    private static Function<LocalDate, LocalDate> closestMonday() {
        return date -> {
            LocalDate previousMonday = previousMonday().apply(date);
            LocalDate nextMonday = nextMonday().apply(date);

            return previousMonday.until(date).getDays() < 4 ? previousMonday : nextMonday;
        };
    }

    private static Function<LocalDate, LocalDate> mondayisation() {
        return date -> Array.of(SATURDAY, SUNDAY).contains(date.getDayOfWeek())
            ? nextMonday().apply(date)
            : date;
    }

    private static Function<LocalDate, LocalDate> tuesdayisation() {
        return date -> Match(date.getDayOfWeek()).of(
            Case($(SATURDAY), DayAdjuster::nextMonday),
            Case($(SUNDAY), DayAdjuster::nextTuesday),
            Case($(), Function::<LocalDate>identity)
        ).apply(date);
    }
}