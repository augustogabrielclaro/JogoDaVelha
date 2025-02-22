package jogodavelha;

import javafx.scene.input.MouseEvent;
import java.util.Arrays;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.function.Predicate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Pane janela;

    @FXML
    private Label a1;

    @FXML
    private Label a2;

    @FXML
    private Label a3;

    @FXML
    private Label b1;

    @FXML
    private Label b2;

    @FXML
    private Label b3;

    @FXML
    private Label c1;

    @FXML
    private Label c2;

    @FXML
    private Label c3;

    static int nJogada = 1;

    
    @FXML
    public void velha() {
        if (nJogada >= 9) {
            mensagem.setTitle("Aviso");
            mensagem.setHeaderText("Deu velha!");
            mensagem.showAndWait();
            nJogada = 1;
            limparCampos();
        }
    }
    
    @FXML
    public void limparCampos() {
        a1.setText("");
        a2.setText("");
        a3.setText("");
        b1.setText("");
        b2.setText("");
        b3.setText("");
        c1.setText("");
        c2.setText("");
        c3.setText("");
    }

    Alert mensagem = new Alert(Alert.AlertType.INFORMATION);
    
    @FXML
    public void chamarLetra(Label label) {
        if (nJogada % 2 != 0) {
            label.setText("X");
            velha();
        } else {
            label.setText("O");
            velha();
        }
        label.setStyle("-fx-font-size: 40px; -fx-alignment: center;");
        nJogada++;

        if (nJogada > 5) {
            if ((!a1.getText().isEmpty() && a1.getText().equals(a2.getText()) && a2.getText().equals(a3.getText()))
            || (!a1.getText().isEmpty() && a1.getText().equals(b1.getText()) && b1.getText().equals(c1.getText()))
            || (!a1.getText().isEmpty() && a1.getText().equals(b2.getText()) && b2.getText().equals(c3.getText()))
            || (!b1.getText().isEmpty() && b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText()))
            || (!c1.getText().isEmpty() && c1.getText().equals(c2.getText()) && c2.getText().equals(c3.getText()))
            || (!c1.getText().isEmpty() && c1.getText().equals(b2.getText()) && b2.getText().equals(a3.getText()))
            || (!a3.getText().isEmpty() && a3.getText().equals(b3.getText()) && b3.getText().equals(c3.getText()))
            || (!a2.getText().isEmpty() && a2.getText().equals(b2.getText()) && b2.getText().equals(c2.getText()))) {
                mensagem.setTitle("Aviso");
                mensagem.setHeaderText("Voce ganhou o jogo!");
                mensagem.showAndWait();
                nJogada = 1;
                limparCampos();
            }
        }

    }

    @FXML
    private void colocarLetra(MouseEvent event) {
        Label labelClicada = (Label) event.getSource();

        if (event.getButton() == MouseButton.PRIMARY) {
            if (labelClicada.getText().isEmpty()) {
                chamarLetra(labelClicada);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
