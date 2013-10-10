/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mybuntu;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import mybuntu.model.MysqlDb;

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
    private ComboBox dbList;

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
       try { 
       MysqlDb mysqldb = new MysqlDb();
       Connection conn = mysqldb.getConnection("root", "root");
       
       dbList.getItems().clear();
       dbList.getItems().addAll( mysqldb.getDbList(conn) );
       }  
       catch (SQLException | InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
       }
    }
}
