package Controllers;

import TaskResources.Task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_MainScene implements Initializable {

    @FXML
    private ListView<Task> ListTasks;
    @FXML
    private Button BtnNewTask;
    @FXML
    private TextField TxtFieldTaskName;
    @FXML
    private MenuButton MenuBtnSettings;
    @FXML
    private MenuItem DeleteButton;
    @FXML
    private TextArea TxtAreaTaskDetails;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Add a listener to the TaskList in order to display a task's details on the details pane
        ListTasks.getSelectionModel().selectedItemProperty().addListener((observableValue, task, t1) -> {
            TxtFieldTaskName.setText(t1.getName());
            TxtAreaTaskDetails.setText(t1.getDescription());
        });

        // Initialize TaskList with some tasks
        ListTasks.getItems().add(new Task("constructor 1 (name only)"));
        ListTasks.getItems().add(new Task("constructor 2", "name and description"));
        ListTasks.getItems().add(new Task("constructor 3", "descrip + year", 2020));
        ListTasks.getItems().add(new Task("constructor 4", "descrip + year + month", 2021, 2));
        ListTasks.getItems().add(new Task("constructor 5", "descrip + year + month + day", 2022, 3, 1));
        ListTasks.getItems().add(new Task("constructor 6", "descrip + year + month + day + hour", 2023, 4, 2, 12));
        ListTasks.getItems().add(new Task("constructor 7", "descrip + year + month + day + hour + minute", 2024, 5, 3, 1, 30));
    }

    @FXML // Launch Scene scene_newtask
    public void NewTaskButtonPress(ActionEvent event) throws IOException {
        // Create a Parent object (Inherits from Node object) - loads scene_newtask.fxml
        Parent newTaskScreenRoot = FXMLLoader.load(getClass().getResource("../Scenes/scene_newtask.fxml"));
        // Create a Scene object using Parent
        Scene newTaskScreen = new Scene(newTaskScreenRoot);
        // Create a Stage object
        Stage secondaryStage = new Stage();
        // Alter some of the Stage settings
        secondaryStage.initModality(Modality.APPLICATION_MODAL);
        secondaryStage.setTitle("Add a Task");
        // Apply the Scene to the Stage
        secondaryStage.setScene(newTaskScreen);
        // Show the stage & wait until it is closed to execute rest of code
        secondaryStage.showAndWait();
        // If a task was added, get the task & add it to TaskList ListView object
        if (secondaryStage.getUserData() != null) {
            Task task = (Task) secondaryStage.getUserData();
            ListTasks.getItems().add(task);
        }
    }

    @FXML
    public void DeleteButtonPress(ActionEvent event) throws Exception {
        //Get index of selected item
        final int selectedIndex = ListTasks.getSelectionModel().getSelectedIndex();

        //Get task object of the item to be removed
        Task itemToDelete = null; //Declare task variable to store the item to be deleted
        if (selectedIndex != -1) {
            itemToDelete = ListTasks.getSelectionModel().getSelectedItem(); //If proper index is selected, store item in variable
        }

        //Find new index to be selected once item is removed
        int newSelectedIndex = -1; //Declare variable for new selected index, initialize to -1
        if (selectedIndex == ListTasks.getItems().size() - 1)
            newSelectedIndex = selectedIndex - 1;
        else
            newSelectedIndex = selectedIndex;


        ListTasks.getItems().remove(selectedIndex); //Remove the item
        ListTasks.getSelectionModel().select(newSelectedIndex); //Select the new item

        //Output deleted item info to console
        System.out.println("selectedIdx: " + selectedIndex);
        System.out.println("item: " + itemToDelete.toString());


    }

}