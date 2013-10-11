/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mybuntu;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

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
    private ListView tableList;
    
    private MysqlDb mysqldb;
    private Connection conn;

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        mylabel.setText("My test text");
    }
    
    /*@FXML
    private void onChangeDbList(ObservableValue selected, String oldValue, String newValue)
    {
        System.out.println("On change. " + "Old: "+oldValue+ " New: "+newValue);
    }*/        
    @FXML
    private void onChangeDbList(ActionEvent event)
    {
        try {
            //выбранная БД из combobox
            String dbName = dbList.getValue().toString();
            
            ObservableList dbtables = mysqldb.getTableList( dbName, conn);
            tableList.setItems(dbtables);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /*private void comboBoxSelection(ActionEvent event) {
        categoryComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() 
        {
            public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
                //Don't know what to put here
                String categoryStr =  getCategoryComboBox().getValue().toString(); 
            }
        }
    }*/
    

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
       try { 
       //MysqlDb mysqldb = new MysqlDb();
       mysqldb = new MysqlDb();    
       //Connection conn = mysqldb.getConnection("root", "root");
       conn = mysqldb.getConnection("root", "root");
       
       dbList.getItems().clear();
       dbList.getItems().addAll( mysqldb.getDbList(conn) );
       }  
       catch (SQLException | InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
       }
    }
}
