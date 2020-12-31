package Controllers;

import TaskResources.Task;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    void AddTask(MouseEvent event) {
        Task task = new Task(TaskNameField.getText(), TaskDescriptionField.getText());

    }

}
