package net.markgillnz.nzpublicholidays.holidays.national;

import net.markgillnz.nzpublicholidays.holidays.Holiday;

import static net.markgillnz.nzpublicholidays.adjusters.DateAdjuster.DECEMBER;
import static net.markgillnz.nzpublicholidays.adjusters.DayAdjuster.TUESDAYISATION;
import static net.markgillnz.nzpublicholidays.adjusters.DayAdjuster.TWENTY_FIFTH;

public class ChristmasDay extends Holiday {

    public ChristmasDay() {
        super(DECEMBER, TWENTY_FIFTH, TUESDAYISATION);
    }

    @Override
    public String name() {
        return "Christmas Day";
    }
}
