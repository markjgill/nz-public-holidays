package net.markgillnz.nzpublicholidays.holidays.national;

import net.markgillnz.nzpublicholidays.holidays.Holiday;

import static net.markgillnz.nzpublicholidays.adjusters.DateAdjuster.FEBRUARY;
import static net.markgillnz.nzpublicholidays.adjusters.DayAdjuster.MONDAYISATION;
import static net.markgillnz.nzpublicholidays.adjusters.DayAdjuster.SIXTH;

public class WaitangiDay extends Holiday {

    public WaitangiDay() {
        super(FEBRUARY, SIXTH, MONDAYISATION);
    }

    @Override
    public String name() {
        return "Waitangi Day";
    }
}
