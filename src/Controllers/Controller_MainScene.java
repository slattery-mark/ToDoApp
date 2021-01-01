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
    private ListView<String> TaskList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize some tasks and populate TaskList
        Task task1 = new Task("test1name", "test1description");
        Task task2 = new Task("test2name", "test2description");
        Task task3 = new Task("test3name", "test3description");

        TaskList.getItems().add(task1.toString());
        TaskList.getItems().add(task2.toString());
        TaskList.getItems().add(task3.toString());

    }

    @FXML
    public void NewTaskButtonPress(ActionEvent event) throws IOException {
        // Launch scene_newtask
        Parent newTaskScreenRoot = FXMLLoader.load(getClass().getResource("../Scenes/scene_newtask.fxml"));
        Scene newTaskScreen = new Scene(newTaskScreenRoot);
        Stage secondaryStage = new Stage();
        secondaryStage.initModality(Modality.APPLICATION_MODAL);
        secondaryStage.setTitle("Add a Task");
        secondaryStage.setScene(newTaskScreen);
        secondaryStage.showAndWait();
        // If a task is added
        if (secondaryStage.getUserData() != null) {
            Task task = (Task) secondaryStage.getUserData();
            TaskList.getItems().add(task.toString());
        }
    }
}
