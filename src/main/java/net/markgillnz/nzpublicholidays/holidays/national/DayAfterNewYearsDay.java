package net.markgillnz.nzpublicholidays.holidays.national;

import net.markgillnz.nzpublicholidays.holidays.Holiday;

import static net.markgillnz.nzpublicholidays.adjusters.DateAdjuster.JANUARY;
import static net.markgillnz.nzpublicholidays.adjusters.DayAdjuster.SECOND;
import static net.markgillnz.nzpublicholidays.adjusters.DayAdjuster.TUESDAYISATION;

public class DayAfterNewYearsDay extends Holiday {

    public DayAfterNewYearsDay() {
        super(JANUARY, SECOND, TUESDAYISATION);
    }

    @Override
    public String name() {
        return "Day After New Years Day";
    }
}
