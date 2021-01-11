package Controllers;

import TaskResources.Task;
import javafx.collections.ObservableList;
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
import java.time.LocalDate;
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
    private ChoiceBox<Integer> ChoiceBoxHour;

    @FXML
    private ChoiceBox<String> ChoiceBoxMinute;

    @FXML
    private ChoiceBox<String> ChoiceBoxAMPM;

    @FXML
    private Button BtnAddTask;

    Controller_NewTaskScene(Scene mainScene, Controller_MainScene ctrl_main) {
        this.mainScene = mainScene;
        this.ctrl_main = ctrl_main;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initChoiceBoxes();
        setDefaults();

        // Set button actions (done here instead of FXML arbitrarily
        BtnCancel.setOnAction(this::returnToMainScene);
        BtnAddTask.setOnAction(this::addTask);

        // Disable add task button until task name has been entered
        BtnAddTask.setDisable(true);
        TxtFieldTaskName.textProperty().addListener((observableValue, s, t1) -> BtnAddTask.setDisable(t1.isEmpty()));
    }

    private void initChoiceBoxes() {
        for (int i = 1; i <= 12; i++) ChoiceBoxHour.getItems().add(i);

        for (int i = 1; i <= 59; i++)
            if (i < 10) ChoiceBoxMinute.getItems().add("0"+i);
            else ChoiceBoxMinute.getItems().add(String.valueOf(i));

        ChoiceBoxAMPM.getItems().add("AM");
        ChoiceBoxAMPM.getItems().add("PM");
    }

    private void setDefaults() {
        ChoiceBoxHour.setValue(11);
        ChoiceBoxMinute.setValue("59");
        ChoiceBoxAMPM.setValue("PM");
        DatePickerDueDate.setValue(LocalDate.now());
    }

    void returnToMainScene(ActionEvent event) {
        Node source = (Node)event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.setScene(mainScene);
    }

    void addTask(ActionEvent event) {
        returnToMainScene(event);
        // Get info from fields
        int hour = (ChoiceBoxAMPM.getValue().equals("AM")) ? ChoiceBoxHour.getValue() : ChoiceBoxHour.getValue() + 12;
        int minute = Integer.parseInt(ChoiceBoxMinute.getValue());
        Task task = new Task(TxtFieldTaskName.getText(), TxtAreaTaskDescription.getText(), DatePickerDueDate.getValue(), hour, minute);
        ctrl_main.addTaskFromAdd(task);
    }

}
