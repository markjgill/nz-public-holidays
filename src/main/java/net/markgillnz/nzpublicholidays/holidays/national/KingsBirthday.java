package net.markgillnz.nzpublicholidays.holidays.national;

import net.markgillnz.nzpublicholidays.holidays.Holiday;

import static net.markgillnz.nzpublicholidays.adjusters.DateAdjuster.JUNE;
import static net.markgillnz.nzpublicholidays.adjusters.DayAdjuster.FIRST_MONDAY;

public class KingsBirthday extends Holiday {

    public KingsBirthday() {
        super(JUNE, FIRST_MONDAY);
    }

    @Override
    public String name() {
        return "Kings Birthday";
    }
}
