package adapter.calendar_adapter;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        CalendarToNewDateAdapter calendarToNewDateAdapter = new CalendarToNewDateAdapter(calendar);

        System.out.println(calendar.getTime());
        System.out.println(calendarToNewDateAdapter);
        System.out.println();

        calendarToNewDateAdapter.setDay(3);
        System.out.println(calendarToNewDateAdapter.getDay());
        System.out.println();

        calendarToNewDateAdapter.setMonth(8);
        calendarToNewDateAdapter.setYear(2030);
        System.out.println(calendarToNewDateAdapter);
        System.out.println();

        calendarToNewDateAdapter.advanceDays(4);
        System.out.println(calendarToNewDateAdapter);
        calendarToNewDateAdapter.advanceDays(40);
        System.out.println(calendarToNewDateAdapter);

    }
}
