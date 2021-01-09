package Controllers;

import TaskResources.Task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_NewTaskScene implements Initializable {

    @FXML
    private TextField TaskNameField;

    @FXML
    private TextField TaskDescriptionField;

    @FXML
    private Button AddTaskButton;

    @FXML
    private Button CancelButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Disable Add Task Button while there is no text in the Task Name Field
        AddTaskButton.setDisable(true);
        // Set a listener to the task name field so that it is required before adding a task
        TaskNameField.textProperty().addListener((observableValue, s, t1) -> {
            if(t1.equals(""))
                AddTaskButton.setDisable(true);
            else
                AddTaskButton.setDisable(false);
        });
    }

    @FXML // Add Task button execution
    void AddTask(ActionEvent event) {
        if (!TaskNameField.getText().trim().isEmpty()) {
            Task task = new Task(TaskNameField.getText(), TaskDescriptionField.getText());
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setUserData(task);
            //stage.getOnCloseRequest(); --commented out because i don't know what this does
            stage.close();
        }
    }

    @FXML
    public void CloseStage(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        //stage.getOnCloseRequest(); --commented out because i don't know what this does
        stage.close();
    }

}

