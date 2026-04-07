package adapter.calendar_adapter;

import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface {
    private Calendar calendar;

    public CalendarToNewDateAdapter(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void setDay(int day) {
        this.calendar.set(Calendar.DATE, day);
    }

    @Override
    public void setMonth(int month) {
        this.calendar.set(Calendar.MONTH, month);
    }

    @Override
    public void setYear(int year) {
        this.calendar.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return this.calendar.get(Calendar.DATE);
    }

    @Override
    public int getMonth() {
        return this.calendar.get(Calendar.MONTH);
    }

    @Override
    public int getYear() {
        return this.calendar.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        this.calendar.add(Calendar.DATE, days);
    }

    @Override
    public String toString() {
        return String.valueOf(this.calendar.getTime());
    }
}
