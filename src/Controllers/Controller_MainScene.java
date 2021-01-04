package Controllers;

import TaskResources.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_MainScene implements Initializable {


    @FXML
    private MenuItem File_NewTask;

    @FXML
    private ListView<Task> TaskList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize some tasks and populate TaskList
        Task task1 = new Task("test1name", "test1description");
        Task task2 = new Task("test2name", "test2description");
        Task task3 = new Task("test3name", "test3description");

        TaskList.getItems().add(task1);
        TaskList.getItems().add(task2);
        TaskList.getItems().add(task3);

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
            TaskList.getItems().add(task);
        }
    }
}
