/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mybuntu.model;

import com.sun.org.apache.xpath.internal.functions.FuncBoolean;
import java.sql.*;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
 *
 * @author
 * alextcy
 */
public class MysqlDb
{
    
    public Connection getConnection(String userName, String password) throws InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException
    {
        String url = "jdbc:mysql://localhost:3306/";
        String driver = "com.mysql.jdbc.Driver";

        Class.forName(driver).newInstance();
        return DriverManager.getConnection(url,userName,password);
    }
    
    
    public ObservableList getDbList(Connection conn) throws SQLException
    {
        ObservableList<String> dbnames = FXCollections.observableArrayList();
        
        DatabaseMetaData meta = conn.getMetaData();

        //Список БД
        ResultSet catalogs = meta.getCatalogs();
        while (catalogs.next()) {
            String catalogName = catalogs.getString("TABLE_CAT");
            dbnames.add(catalogName);
        }
        
        return dbnames;
    }        
    
    
    public ObservableList getTableList(String dbname, Connection conn) throws SQLException
    {
        ObservableList<String> dbtables = FXCollections.observableArrayList();
        
        DatabaseMetaData meta = conn.getMetaData();
        
        String[] tableTypes = {"TABLE"};
        ResultSet tables = meta.getTables(dbname, null, null, tableTypes);
        
        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            dbtables.add(tableName);
        }
        
        return dbtables;
    }        
           
    
}
