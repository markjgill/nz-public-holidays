package net.markgillnz.nzpublicholidays.holidays.national;

import net.markgillnz.nzpublicholidays.holidays.Holiday;

import static net.markgillnz.nzpublicholidays.adjusters.DateAdjuster.EASTER_SUNDAY;
import static net.markgillnz.nzpublicholidays.adjusters.DayAdjuster.NEXT_MONDAY;

public class EasterMonday extends Holiday {

    public EasterMonday() {
        super(EASTER_SUNDAY, NEXT_MONDAY);
    }

    @Override
    public String name() {
        return "Easter Monday";
    }
}
