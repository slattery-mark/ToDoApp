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
    public Task(String name, String description, int year) {
        this.name = name;
        this.description = description;
        deadline = LocalDateTime.of(year, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth(), 23, 59);
    }
    public Task(String name, String description, int year, int month) {
        this.name = name;
        this.description = description;
        deadline = LocalDateTime.of(year, month, LocalDate.now().getDayOfMonth(), 23, 59);
    }
    public Task(String name, String description, int year, int month, int day) {
        this.name = name;
        this.description = description;
        deadline = LocalDateTime.of(year, month, day, 23, 59);
    }
    public Task(String name, String description, int year, int month, int day, int hour) {
        this.name = name;
        this.description = description;
        deadline = LocalDateTime.of(year, month, day, hour, 59);
    }
    public Task(String name, String description, int year, int month, int day, int hour, int minute) {
        this.name = name;
        this.description = description;
        deadline = LocalDateTime.of(year, month, day, hour, minute);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
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
    @Override
    public String toString() {
        String str = name
                +"\n"+deadline.format(DateTimeFormatter.ofPattern("MMM dd yyyy \nh:mm"));
        return (deadline.getHour() < 12) ? str+" AM" : str+" PM";
    }
}


/*
package TaskResources;

import java.util.*;

public class Task {
    //class to create objects for each individual task
    private String name;
    private Calendar deadline;
    private String description="";

    public Task(String name){
        this.name = name;

        //sets deadline as the current date at 11:59 pm by default
        deadline = Calendar.getInstance();
        deadline.set(Calendar.HOUR, 11);
        deadline.set(Calendar.MINUTE, 59);
        deadline.set(Calendar.SECOND, 00);

    }
    public Task(String name, String description){
        this.name = name;
        this.description = description;

        deadline = Calendar.getInstance();
        deadline.set(Calendar.HOUR, 11);
        deadline.set(Calendar.MINUTE, 59);
        deadline.set(Calendar.SECOND, 00);
    }
    public Task(String name, String description, int day, int month, int year){
        this.name = name; //set name
        this.description = description; //set description

        this.setDeadlineDate(day, month, year); // set deadline date
        deadline.set(Calendar.HOUR, 11);
        deadline.set(Calendar.MINUTE, 59);
        deadline.set(Calendar.SECOND, 00);

    }
    public Task(String name, String description, int day, int month, int year, int hour, int min) {
        this.name = name; //set name
        this.description = description; //set description
        this.setDeadlineDate(day, month, year); // set deadline date
        this.setDeadlineTime(hour, min);// set deadline time

    }

    // Setter Functions
    public void setName(String name){
        //set name of the task
        this.name = name;
    }
    public void setDeadlineDate(int day, int month, int year){
        //set the deadline date for the task
        deadline.set(year, month, day);
    }
    public void setDeadlineTime(int hour, int min)
    {
        //set the deadline time for the task - seconds are always zero.
        deadline.set(Calendar.HOUR, hour);
        deadline.set(Calendar.MINUTE, min);
        deadline.set(Calendar.SECOND, 0);
    }
    public void setDescription(String description){
        //set description of the task
        this.description = description;
    }

    // Getter Functions
    public String getName(){ return name;}
    public Date getDeadline() {return deadline.getTime();}
    public String getDescription(){return description;}

    @Override
    public String toString(){
        //override toString method to output task data
        return name+"\n"+description+"\n"+deadline.getTime();

    }

    public void display(){}

}
*/
