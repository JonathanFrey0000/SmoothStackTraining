package Week_1.Week1_day5.DateTimeAPI;

import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.ChronoField;
import java.lang.Boolean;
/**
 *  Copyright (c) 2013, Oracle
 */
public class FridayThirteenQuery implements TemporalQuery<Boolean> {

    // Returns TRUE if the date occurs on Friday the 13th.
    public Boolean queryFrom(TemporalAccessor date) {

        return ((date.get(ChronoField.DAY_OF_MONTH) == 13) &&
                (date.get(ChronoField.DAY_OF_WEEK) == 5));
    }
}