package net.markgillnz.nzpublicholidays.holidays.national;

import net.markgillnz.nzpublicholidays.holidays.Holiday;

import static net.markgillnz.nzpublicholidays.adjusters.DateAdjuster.OCTOBER;
import static net.markgillnz.nzpublicholidays.adjusters.DayAdjuster.FOURTH_MONDAY;

public class LabourDay extends Holiday {

    public LabourDay() {
        super(OCTOBER, FOURTH_MONDAY);
    }

    @Override
    public String name() {
        return "Labour Day";
    }
}
