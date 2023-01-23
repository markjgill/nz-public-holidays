package net.markgillnz.nzpublicholidays.holidays.anniversary;

import net.markgillnz.nzpublicholidays.holidays.Holiday;

import static net.markgillnz.nzpublicholidays.adjusters.DateAdjuster.JANUARY;
import static net.markgillnz.nzpublicholidays.adjusters.DayAdjuster.CLOSEST_MONDAY;
import static net.markgillnz.nzpublicholidays.adjusters.DayAdjuster.TWENTY_NINTH;

public class Auckland extends Holiday {

    public Auckland() {
        super(JANUARY, TWENTY_NINTH, CLOSEST_MONDAY);
    }

    @Override
    public String name() {
        return "Auckland Anniversary Day";
    }
}
