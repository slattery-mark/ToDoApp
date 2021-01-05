package Controllers;

import TaskResources.Task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_MainScene implements Initializable {

    public Button NewTaskButton;
    @FXML
    private TextArea DetailsPane;
    @FXML
    private MenuItem File_NewTask;
    @FXML
    private ListView<Task> TaskList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Add a listener to the TaskList in order to display a task's details on the details pane
        TaskList.getSelectionModel().selectedItemProperty().addListener((observableValue, task, t1) -> {
            System.out.println("Selected Task: " + t1.toString());
            DetailsPane.setText(t1.getDescription());
        });
        // Initialize TaskList with some tasks
        TaskList.getItems().add(new Task("constructor 1 (name only)"));
        TaskList.getItems().add(new Task("constructor 2", "name and description"));
        TaskList.getItems().add(new Task("constructor 3", "descrip + year", 2020));
        TaskList.getItems().add(new Task("constructor 4", "descrip + year + month", 2021, 2));
        TaskList.getItems().add(new Task("constructor 5", "descrip + year + month + day", 2022, 3, 1));
        TaskList.getItems().add(new Task("constructor 6", "descrip + year + month + day + hour", 2023, 4, 2, 12));
        TaskList.getItems().add(new Task("constructor 7", "descrip + year + month + day + hour + minute", 2024, 5, 3, 1, 30));
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