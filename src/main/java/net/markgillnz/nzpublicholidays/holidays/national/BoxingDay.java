package net.markgillnz.nzpublicholidays.holidays.national;

import net.markgillnz.nzpublicholidays.holidays.Holiday;

import static net.markgillnz.nzpublicholidays.adjusters.DateAdjuster.DECEMBER;
import static net.markgillnz.nzpublicholidays.adjusters.DayAdjuster.TUESDAYISATION;
import static net.markgillnz.nzpublicholidays.adjusters.DayAdjuster.TWENTY_SIXTH;

public class BoxingDay extends Holiday {

    public BoxingDay() {
        super(DECEMBER, TWENTY_SIXTH, TUESDAYISATION);
    }

    @Override
    public String name() {
        return "Boxing Day";
    }
}
