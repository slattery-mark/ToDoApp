package TaskResources;
import java.util.*;

public class Task {
    //class to create objects for each individual task
    private String name;
    private Calendar deadline;
    private String description="";



    Task(String name){
        this.name = name;

        //sets deadline as the current date at 11:59 pm by default
        deadline = Calendar.getInstance();
        deadline.set(Calendar.HOUR, 11);
        deadline.set(Calendar.MINUTE, 59);
        deadline.set(Calendar.SECOND, 00);

    }
    Task(String name, String description){
        this.name = name;
        this.description = description;

        deadline = Calendar.getInstance();
        deadline.set(Calendar.HOUR, 11);
        deadline.set(Calendar.MINUTE, 59);
        deadline.set(Calendar.SECOND, 00);
    }
    Task(String name, String description, int date, int month, int year){
        this.name = name; //set name
        this.description = description; //set description

        this.setDeadlineDate(date, month, year); // set deadline date
        deadline.set(Calendar.HOUR, 11);
        deadline.set(Calendar.MINUTE, 59);
        deadline.set(Calendar.SECOND, 00);

    }
    Task(String name, String description, int date, int month, int year, int hour, int min) {
        this.name = name; //set name
        this.description = description; //set description
        this.setDeadlineDate(date, month, year); // set deadline date
        this.setDeadlineTime(hour, min);// set deadline time

    }

    /*Setter Functions*/
    public void setName(String name){
        //set name of the task
        this.name = name;
    }
    public void setDeadlineDate(int date, int month, int year){
        //set the deadline date for the task
        deadline.set(year,month,date);
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

    /*Getter Functions*/
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
