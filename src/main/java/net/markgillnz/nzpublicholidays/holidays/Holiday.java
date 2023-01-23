package net.markgillnz.nzpublicholidays.holidays;

import io.vavr.collection.Array;
import net.markgillnz.nzpublicholidays.adjusters.DateAdjuster;
import net.markgillnz.nzpublicholidays.adjusters.DayAdjuster;

import java.time.LocalDate;
import java.util.function.Function;

public abstract class Holiday {

    private final DateAdjuster dateAdjuster;
    private final Array<DayAdjuster> dayAdjusters;

    public Holiday(DateAdjuster dateAdjuster, DayAdjuster... dayAdjusters) {
        this.dateAdjuster = dateAdjuster;
        this.dayAdjusters = Array.of(dayAdjusters);
    }

    public final LocalDate get(int year) {
        return dayAdjusters.map(DayAdjuster::get)
            .fold(Function.<LocalDate>identity(), (a, b) -> b.compose(a))
            .compose(dateAdjuster.get())
            .apply(year);
    }

    public abstract String name();
}
