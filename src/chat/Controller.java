package chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button buttonSend;

    @FXML
    private TextArea chatText;

    @FXML
    private TextField inputText;

    @FXML
    public void btnClickAction(ActionEvent actionEvent) {
        if (!inputText.getText().isEmpty()) {
            chatText.appendText("\n" + inputText.getText() + "\n");
            inputText.clear();
        }
        inputText.requestFocus();
    }
}
