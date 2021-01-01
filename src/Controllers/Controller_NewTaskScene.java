package Controllers;

import TaskResources.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Controller_NewTaskScene {

    @FXML
    private TextField TaskNameField;

    @FXML
    private TextField TaskDescriptionField;

    @FXML
    private Button AddTaskButton;

    @FXML
    private Button CancelButton;

    @FXML
    void AddTask(ActionEvent event) {
        if (TaskNameField.getText().trim().isEmpty()) {

        }
        else {
            Task task = new Task(TaskNameField.getText(), TaskDescriptionField.getText());
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setUserData(task);
            CloseStage(event);
        }
    }

    @FXML
    public void CloseStage(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        stage.getOnCloseRequest();
        stage.close();
    }
}
