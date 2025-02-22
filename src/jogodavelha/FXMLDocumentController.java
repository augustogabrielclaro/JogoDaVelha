
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
import javafx.fxml.Initializable;
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
    public void chamarLetra(Label label) {
        if (nJogada > 9) {
            a1.setText("");
            a2.setText("");
            a3.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            c1.setText("");
            c2.setText("");
            c3.setText("");
            nJogada = 1;
        }
        
        if (nJogada % 2 != 0) {
            label.setText("X");
        } else {
            label.setText("O");
        }
        label.setStyle("-fx-font-size: 40px; -fx-alignment: center;");
        nJogada++;
        
        if (a1.getText() == a2.getText() && a2.getText() == a3.getText()) {
            // Não é pra ter esse return
            return;
        }
    }
    
    @FXML
    private void colocarLetra(MouseEvent event) {
        Label labelClicada = (Label) event.getSource();
        
        if (event.getButton() == MouseButton.PRIMARY) {
            chamarLetra(labelClicada);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
