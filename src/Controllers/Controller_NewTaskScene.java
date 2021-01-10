package Controllers;

import TaskResources.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_NewTaskScene implements Initializable {

    private final Scene mainScene;
    private final Controller_MainScene ctrl_main;

    @FXML
    private Button BtnCancel;

    @FXML
    private TextField TxtFieldTaskName;

    @FXML
    private TextArea TxtAreaTaskDescription;

    @FXML
    private DatePicker DatePickerDueDate;

    @FXML
    private ChoiceBox<?> ChoiceBoxHour;

    @FXML
    private ChoiceBox<?> ChoiceBoxMinute;

    @FXML
    private ChoiceBox<?> ChoiceBoxAMPM;

    @FXML
    private Button BtnAddTask;

    Controller_NewTaskScene(Scene mainScene, Controller_MainScene ctrl_main) {
        this.mainScene = mainScene;
        this.ctrl_main = ctrl_main;
    }

    void returnToMainScene(ActionEvent event) {
        Node source = (Node)event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.setScene(mainScene);
    }

    void addTask(ActionEvent event) {
        returnToMainScene(event);
        // Get info from fields
        Task task = new Task("constructor 8", "descrip + year + month + day + hour + minute", 2024, 5, 3, 1, 30);
        ctrl_main.addTaskFromAdd(task);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BtnCancel.setOnAction(this::returnToMainScene);
        BtnAddTask.setOnAction(this::addTask);

        // Disable add task button until task name has been entered
        BtnAddTask.setDisable(true);
        TxtFieldTaskName.textProperty().addListener((observableValue, s, t1) -> {
            BtnAddTask.setDisable(t1.isEmpty());
        });
    }
}
