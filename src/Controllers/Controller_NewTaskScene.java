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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller_NewTaskScene implements Initializable {

    private final Scene mainScene;
    private final Controller_MainScene ctrl_main;
    private final int TASK_NAME_LIMIT = 25;
    private final int TASK_DETAILS_LIMIT = 999;

    @FXML
    private Button BtnCancel;

    @FXML
    private TextField TxtFieldTaskName;

    @FXML
    private Label LblTaskNameCounter;

    @FXML
    private Label LblTaskDetailsCounter;

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
        setMaxTextLengths();

        // Set button actions (done here instead of FXML arbitrarily)
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
        LblTaskNameCounter.setText(String.valueOf(TASK_NAME_LIMIT));
        LblTaskDetailsCounter.setText(String.valueOf(TASK_DETAILS_LIMIT));
    }

    private void setMaxTextLengths() {
        TxtFieldTaskName.lengthProperty().addListener((observableValue, oldVal, newVal) -> {
            LblTaskNameCounter.setText(String.valueOf(TASK_NAME_LIMIT - newVal.intValue()));
            if (newVal.intValue() > oldVal.intValue()) {
                if (TxtFieldTaskName.getText().length() >= TASK_NAME_LIMIT) {
                    TxtFieldTaskName.setText(TxtFieldTaskName.getText().substring(0,TASK_NAME_LIMIT));
                }
            }
        });
        TxtAreaTaskDescription.lengthProperty().addListener((observableValue, oldVal, newVal) -> {
            LblTaskDetailsCounter.setText(String.valueOf(TASK_DETAILS_LIMIT - newVal.intValue()));
            if (newVal.intValue() > oldVal.intValue()) {
                if (TxtAreaTaskDescription.getText().length() >= TASK_DETAILS_LIMIT) {
                    TxtAreaTaskDescription.setText(TxtAreaTaskDescription.getText().substring(0,TASK_DETAILS_LIMIT));
                }
            }
        });
    }

    void returnToMainScene(ActionEvent event) {
        Node source = (Node)event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.setScene(mainScene);
    }

    void addTask(ActionEvent event) {
        returnToMainScene(event);

        int hour = (ChoiceBoxAMPM.getValue().equals("AM")) ? ChoiceBoxHour.getValue() : ChoiceBoxHour.getValue() + 12;
        int minute = Integer.parseInt(ChoiceBoxMinute.getValue());
        Task task = new Task(TxtFieldTaskName.getText(), TxtAreaTaskDescription.getText(), DatePickerDueDate.getValue(), hour, minute);
        ctrl_main.addTaskFromAdd(task);
    }

}
