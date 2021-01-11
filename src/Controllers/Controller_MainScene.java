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
        // Disable edit/delete buttons if the list is empty, if list isn't empty set selection to first task
        // May need to adjust this code after save/load, for now assumes list is empty at start
        BtnDeleteTask.setDisable(true);
        BtnEditTask.setDisable(true);
        ListViewTasks.getSelectionModel().selectedItemProperty().addListener((observableValue, task, t1) -> {
            if (ListViewTasks.getSelectionModel().getSelectedIndex() == -1) {
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
    }

    @FXML
    void DeleteTaskBtnPress(ActionEvent event) {
        if (!ListViewTasks.getItems().isEmpty())
            ListViewTasks.getItems().remove(ListViewTasks.getSelectionModel().getSelectedIndex());
    }

    @FXML
    void EditTaskBtnPress(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes/scene_edittask.fxml"));
        // get source of button press action
        Node source = (Node) event.getSource();
        // create a scene object from the source of button press action
        Scene mainScene = source.getScene();

        mainScene.setUserData(source.getUserData());


        // create edit task scene controller instance
        Controller_EditTaskScene controller_editTaskScene = new Controller_EditTaskScene(mainScene, this);
        // set the controller for edit task scene
        loader.setController(controller_editTaskScene);
        // send the selected task to edit task scene controller
        controller_editTaskScene.initData(ListViewTasks.getSelectionModel().getSelectedItem());
        // create a new scene object
        Scene editTaskScene = new Scene(loader.load());
        // set the stage to the new scene
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setScene(editTaskScene);
    }

    @FXML
    public void DeleteFromEdit(Task task){
        ListViewTasks.getSelectionModel().select(task);
        ListViewTasks.getItems().remove(ListViewTasks.getSelectionModel().getSelectedItem());
    }

    @FXML
    void NewTaskBtnPress(ActionEvent event) throws IOException {
        // Create an instance of mainScene to send to Controller_NewTaskScene
        Node source = (Node) event.getSource();
        Scene mainScene = source.getScene();

        // Create instance of Controller_NewTaskScene, send the selected task and the instance of mainScene to return to
        Controller_NewTaskScene controller_newTaskScene = new Controller_NewTaskScene(mainScene, this);

        // Set the controller for scene_newtask
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes/scene_newtask.fxml"));
        loader.setController(controller_newTaskScene);

        // Change the scene to scene_newtask
        Scene newTaskScene = new Scene(loader.load());
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setScene(newTaskScene);
    }

    public void addTaskFromAdd(Task task){
        ListViewTasks.getItems().add(task);
    }

}