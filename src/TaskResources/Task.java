package TaskResources;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String name;
    private String description = "";
    private LocalDateTime deadline;

    public Task(String name) {
        this.name = name;
        deadline = LocalDateTime.of(LocalDate.now(), LocalTime.of(23,59));
    }
    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        deadline = LocalDateTime.of(LocalDate.now(), LocalTime.of(23,59));
    }
    public Task(String name, String description, LocalDate dueDate) {
        this.name = name;
        this.description = description;
        deadline = LocalDateTime.of(dueDate, LocalTime.of(23,59));
    }
    public Task(String name, String description, LocalDate dueDate, int hour, int minute) {
        this.name = name;
        this.description = description;
        deadline = LocalDateTime.of(dueDate, LocalTime.of(hour, minute));
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setYear(int year) {
        deadline = deadline.withYear(year);
    }
    public void setMonth(int month) {
        deadline = deadline.withMonth(month);
    }
    public void setDay(int day) {
        deadline = deadline.withDayOfMonth(day);
    }
    public void setHour(int hour) {
        deadline = deadline.withHour(hour);
    }
    public void setMinute(int minute) {
        deadline = deadline.withMinute(minute);
    }
    final public String getName() {
        return name;
    }
    final public String getDescription() {
        return description;
    }
    final public int getYear() {
        return deadline.getYear();
    }
    final public int getMonth() {
        return deadline.getMonthValue();
    }
    final public int getDay() {
        return deadline.getDayOfMonth();
    }
    final public int getHour() {
        return deadline.getHour();
    }
    final public int getMinute() {
        return deadline.getMinute();
    }

    @Override
    public String toString() {
        String str = name
                +"\n"+deadline.format(DateTimeFormatter.ofPattern("MMM dd yyyy \nh:mm"));
        return (deadline.getHour() < 12) ? str+" AM" : str+" PM";
    }
}


// Unnecessary contructors?
//    public Task(String name, String description, int year) {
//        this.name = name;
//        this.description = description;
//        deadline = LocalDateTime.of(year, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth(), 23, 59);
//    }
//    public Task(String name, String description, int year, int month) {
//        this.name = name;
//        this.description = description;
//        deadline = LocalDateTime.of(year, month, LocalDate.now().getDayOfMonth(), 23, 59);
//    }
//    public Task(String name, String description, int year, int month, int day) {
//        this.name = name;
//        this.description = description;
//        deadline = LocalDateTime.of(year, month, day, 23, 59);
//    }
//    public Task(String name, String description, int year, int month, int day, int hour) {
//        this.name = name;
//        this.description = description;
//        deadline = LocalDateTime.of(year, month, day, hour, 59);
//    }
//    public Task(String name, String description, int year, int month, int day, int hour, int minute) {
//        this.name = name;
//        this.description = description;
//        deadline = LocalDateTime.of(year, month, day, hour, minute);
//    }
