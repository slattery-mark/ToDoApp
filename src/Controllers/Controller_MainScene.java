package Controllers;

import TaskResources.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class Controller_MainScene implements Initializable {

    @FXML
    private ListView<Task> ListViewTasks;

    @FXML
    private Button BtnNewTask;

    @FXML
    private Button BtnEditTask;

    @FXML
    private Button BtnDeleteTask;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListViewTasks.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.DELETE) {
                    DeleteTaskBtnPress(new ActionEvent());
                }
            }
        });
        ListViewTasks.getItems().add(new Task("constructor 1 (name only)"));
        ListViewTasks.getItems().add(new Task("constructor 2", "name and description"));
        ListViewTasks.getItems().add(new Task("constructor 3", "descrip + year", 2020));
        ListViewTasks.getItems().add(new Task("constructor 4", "descrip + year + month", 2021, 2));
        ListViewTasks.getItems().add(new Task("constructor 5", "descrip + year + month + day", 2022, 3, 1));
        ListViewTasks.getItems().add(new Task("constructor 6", "descrip + year + month + day + hour", 2023, 4, 2, 12));
        ListViewTasks.getItems().add(new Task("constructor 7", "descrip + year + month + day + hour + minute", 2024, 5, 3, 1, 30));
    }
    @FXML
    void DeleteTaskBtnPress(ActionEvent event) {
        if (!ListViewTasks.getItems().isEmpty())
            ListViewTasks.getItems().remove(ListViewTasks.getSelectionModel().getSelectedIndex());
    }

    @FXML
    void EditTaskBtnPress(ActionEvent event) {

    }

    @FXML
    void NewTaskBtnPress(ActionEvent event) {

    }
}
/*
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
        ListTasks.getItems().remove(ListTasks.getSelectionModel().getSelectedIndex());
    }
    @FXML
    void TxtAreaTaskDetailsUpdate(KeyEvent event) {
        ListTasks.getSelectionModel().getSelectedItem().setDescription(TxtAreaTaskDetails.getText());
    }

    @FXML
    void TxtFieldTaskNameUpdate(KeyEvent event) {
        ListTasks.getSelectionModel().getSelectedItem().setName(TxtFieldTaskName.getText());
    }

}
 */