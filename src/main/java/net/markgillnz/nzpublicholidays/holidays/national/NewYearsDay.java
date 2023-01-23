package net.markgillnz.nzpublicholidays.holidays.national;

import net.markgillnz.nzpublicholidays.holidays.Holiday;

import static net.markgillnz.nzpublicholidays.adjusters.DateAdjuster.JANUARY;
import static net.markgillnz.nzpublicholidays.adjusters.DayAdjuster.FIRST;
import static net.markgillnz.nzpublicholidays.adjusters.DayAdjuster.TUESDAYISATION;

public class NewYearsDay extends Holiday {

    public NewYearsDay() {
        super(JANUARY, FIRST, TUESDAYISATION);
    }

    @Override
    public String name() {
        return "New Years Day";
    }
}
