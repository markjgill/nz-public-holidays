package net.markgillnz.nzpublicholidays.holidays.national;

import net.markgillnz.nzpublicholidays.holidays.Holiday;

import static net.markgillnz.nzpublicholidays.adjusters.DateAdjuster.APRIL;
import static net.markgillnz.nzpublicholidays.adjusters.DayAdjuster.MONDAYISATION;
import static net.markgillnz.nzpublicholidays.adjusters.DayAdjuster.TWENTY_FIFTH;

public class AnzacDay extends Holiday {

    public AnzacDay() {
        super(APRIL, TWENTY_FIFTH, MONDAYISATION);
    }

    @Override
    public String name() {
        return "ANZAC Day";
    }
}
