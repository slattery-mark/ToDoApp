package TaskResources;
import java.util.*;

public class TaskList {
    //class to create lists of tasks
    Scanner input = new Scanner(System.in);
    private String topic;
    ArrayList<Task> list = new ArrayList<Task>();

    public TaskList(String topic){
        this.topic = topic;
        list = new ArrayList<Task>();
    }
    public void display(){
        for( int i =0; i<list.size(); i++){ //loop through Array list
            //for each index, get the object at that index and display the toString representation of the object
            System.out.println((list.get(i).toString()));

        }
    }
    public void AddTask(Task task) {
        list.add(task);
    }
    public void assignDeadline(String taskName, Calendar deadline){
        System.out.println("Enter deadline information:");
        System.out.print("Date: ");
        int date = input.nextInt();
        System.out.print("\nMonth: ");
        int month = input.nextInt();
        System.out.println("\nYear: ");
        int year = input.nextInt();

        System.out.print("\nHour (optional): ");
        int hour = input.nextInt();
        System.out.print("\nMinute (optional): ");
        int minute = input.nextInt();
    }
    public void createTask(){
        System.out.println("Enter task name: ");
        String taskName = input.nextLine();
        System.out.println("Enter description or press enter to leave blank:");
        String taskDesc = input.nextLine();
        System.out.println("Would you like to set a deadline now? (Y/N)");
        char choice = Character.toUpperCase(input.nextLine().charAt(0));

        while(choice != 'Y' && choice != 'N')
        {
            System.out.println("Invalid choice. Please try again.");
            System.out.println("Would you like to set a deadline now? (Y/N)");
            choice = Character.toUpperCase(input.nextLine().charAt(0));
        }

        if(choice == 'Y')
        {
            /*                                                                  */
            /*Will need to implement exception handling to handle input mismatch*/
            /*                                                                  */

            System.out.println("Enter deadline information:");
            System.out.print("Date: ");
            int date = input.nextInt();
            System.out.print("\nMonth: ");
            int month = input.nextInt();
            System.out.println("\nYear: ");
            int year = input.nextInt();

            list.add(new Task(taskName, taskDesc, date, month, year));
//            System.out.print("\nHour (optional): ");
//            int hour = input.nextInt();
//            System.out.print("\nMinute (optional): ");
//            int minute = input.nextInt();


        }
        else if(choice =='N'){
            System.out.println("Deadline may be set later.");
            list.add(new Task(taskName, taskDesc));
        }



    }
    public void markComplete(String taskName){
        //implement markers for task objects? (e.g. markComplete, markOverdue, etc.)
    }
    public void removeTask(String taskName){
        //use array list.remove() to remove task from the array list

    }
    public void renameTask(String oldName, String newName){
        //copy all data except for the old name into a new object
    }
}
