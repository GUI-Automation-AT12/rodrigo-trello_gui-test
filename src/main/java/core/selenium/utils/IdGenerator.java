package core.selenium.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IdGenerator {

    static DateFormat hour;
    static DateFormat calendarDay;
    static Date actualDate;

    public IdGenerator() {
        hour = new SimpleDateFormat("HHmmss");
        calendarDay = new SimpleDateFormat("dd-MM-yyyy");
    }

    /**
     *This method generates an unique id.
     * @return Unique id
     */
    public String getGeneratedId() {
        actualDate = new Date();
        return calendarDay.format(actualDate) + hour.format(calendarDay);
    }
}
