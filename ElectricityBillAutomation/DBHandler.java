import java.sql.Connection;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.io.FileNotFoundException;

public class DBHandler {

	public Connection establishConnection() throws ClassNotFoundException, SQLException, FileNotFoundException {
	    
	    Connection con = null;
	    Properties props = new Properties();
	    // this try block reads the db Properties file and establishConnection.
	    try{
	        FileInputStream fis = new FileInputStream("src/db.properties");
	        props.load(fis);
	        
	        Class.forName(props.getProperty("db.classname"));
	        
	        con = DriverManager.getConnection(props.getProperty("db.url"),props.getProperty("db.username"),props.getProperty("db.password"));
	    }
	    catch(IOException e){
	        e.printStackTrace();
	    }
	    
	    return con;
	    

        //fill code here
		
	}
}
