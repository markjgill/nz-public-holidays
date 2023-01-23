package net.markgillnz.nzpublicholidays;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.vavr.Tuple;
import io.vavr.collection.Stream;
import net.markgillnz.nzpublicholidays.holidays.Holiday;
import net.markgillnz.nzpublicholidays.holidays.anniversary.Auckland;
import net.markgillnz.nzpublicholidays.holidays.national.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Map;

import static java.util.Comparator.naturalOrder;

public class LambdaFunction implements RequestStreamHandler {

    private static final Stream<Holiday> PUBLIC_HOLIDAYS = Stream.of(
        new NewYearsDay(),
        new DayAfterNewYearsDay(),
        new WaitangiDay(),
        new GoodFriday(),
        new EasterMonday(),
        new AnzacDay(),
        new KingsBirthday(),
        new LabourDay(),
        new ChristmasDay(),
        new BoxingDay()
    );

    private static final ObjectMapper MAPPER = new ObjectMapper()
        .registerModule(new JavaTimeModule())
        .setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        Request request = MAPPER.readValue(input, Request.class);

        Stream<Holiday> holidays = PUBLIC_HOLIDAYS.append(new Auckland());

        Map<Integer, Map<LocalDate, String>> holidayDates = Stream.ofAll(request.getYears())
            .toJavaMap(year -> Tuple.of(
                year,
                holidays.toSortedMap(
                    naturalOrder(),
                    holiday -> Tuple.of(holiday.get(year), holiday.name())
                ).toJavaMap()
            ));
            
        MAPPER.writeValue(output, holidayDates);
    }
}