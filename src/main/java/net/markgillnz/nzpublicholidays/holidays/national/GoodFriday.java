package net.markgillnz.nzpublicholidays.holidays.national;

import net.markgillnz.nzpublicholidays.holidays.Holiday;

import static net.markgillnz.nzpublicholidays.adjusters.DateAdjuster.EASTER_SUNDAY;
import static net.markgillnz.nzpublicholidays.adjusters.DayAdjuster.PREVIOUS_FRIDAY;

public class GoodFriday extends Holiday {

    public GoodFriday() {
        super(EASTER_SUNDAY, PREVIOUS_FRIDAY);
    }

    @Override
    public String name() {
        return "Good Friday";
    }
}
