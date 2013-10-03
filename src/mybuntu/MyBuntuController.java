/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mybuntu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author alextcy
 */
public class MyBuntuController implements Initializable
{

    @FXML
    private Label label;
    
    @FXML
    private Label mylabel;

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        mylabel.setText("My test text");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }
}
