package Controllers;

import TaskResources.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
        // Disable edit/delete buttons if the list is empty
        ListViewTasks.getSelectionModel().selectedItemProperty().addListener((observableValue, task, t1) -> {
            if (ListViewTasks.getSelectionModel().isEmpty()) {
                BtnDeleteTask.setDisable(true);
                BtnEditTask.setDisable(true);
            } else {
                BtnDeleteTask.setDisable(false);
                BtnEditTask.setDisable(false);
            }
        });
        // Delete the selected task when delete key is pressed
        ListViewTasks.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.DELETE) {
                DeleteTaskBtnPress(new ActionEvent());
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
    void EditTaskBtnPress(ActionEvent event) throws IOException {
        // Create an instance of mainScene to send to Controller_EditTaskScene
        Node source = (Node) event.getSource();
        Scene mainScene = source.getScene();
        mainScene.setUserData(source.getUserData()); // What does this do??

        // Create instance of Controller_EditTaskScene, send the selected task and the instance of mainScene to return to
        Controller_EditTaskScene controller_editTaskScene = new Controller_EditTaskScene(mainScene, this);
        controller_editTaskScene.initData(ListViewTasks.getSelectionModel().getSelectedItem());

        // Set the controller for scene_edittask
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes/scene_edittask.fxml"));
        loader.setController(controller_editTaskScene);
        controller_editTaskScene.initData(ListViewTasks.getSelectionModel().getSelectedItem());

        // Change the scene to scene_edittask
        Scene editTaskScene = new Scene(loader.load());
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setScene(editTaskScene);
    }

    @FXML
    void NewTaskBtnPress(ActionEvent event) throws IOException {

    }

    @FXML
    public void DeleteFromEdit(Task task){
        ListViewTasks.getSelectionModel().select(task);
        ListViewTasks.getItems().remove(ListViewTasks.getSelectionModel().getSelectedItem());
    }
}