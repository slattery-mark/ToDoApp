package Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    Controller_NewTaskScene(Scene mainScene) {
        this.mainScene = mainScene;
    }

    @FXML
    void returnToMainScene(ActionEvent event) {
        Node source = (Node)event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.setScene(mainScene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Disable add task button until task name has been entered
        BtnAddTask.setDisable(true);
        TxtFieldTaskName.textProperty().addListener((observableValue, s, t1) -> {
            BtnAddTask.setDisable(t1.isEmpty());
        });
    }
}
