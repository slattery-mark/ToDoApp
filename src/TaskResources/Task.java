package TaskResources;
import java.util.*;

public class Task {
    //class to create objects for each individual task
    private String name;
    private Date deadline;
    private String description="";


    Task(String name){
        this.name = name;
        deadline = new Date(); //sets deadline as the current date by default



    }
    public void setName(String name){
        this.name = name;
    }
    public void setDeadline(Date date){
        this.deadline = date;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @Override
    public String toString(){
        //override toString method to output task data
        return name+"\n"+description+"\n"+deadline;

    }
    public void display(){}





}
