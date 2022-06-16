import java.util.List;
import java.util.*;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Pattern;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ElectricityBoard {

    //write the required business logic methods as expected in the question description
    public void addBill(List<ElectricityBill> billList) {
        
        DBHandler db =  new DBHandler();
        
        try(Connection con = db.establishConnection()){
            
            PreparedStatement stmt = con.prepareStatement("insert into ElectricityBill values(?,?,?,?,?);");
            
            // for loop to insert the values into the table
            for(ElectricityBill obj : billList){
                stmt.setString(1,obj.getConsumerNumber());
                stmt.setString(2,obj.getConsumerName());
                stmt.setString(3,obj.getConsumerAddress());
                stmt.setInt(4,obj.getUnitsConsumed());
                stmt.setDouble(5,obj.getBillAmount());
                
                stmt.execute();
            }
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
        catch(SQLException e){
            e.printStackTrace();
        }
        
        
        
    
        //fill the code

    }
    
    public List<ElectricityBill> generateBill(String filePath) {
        
        List <ElectricityBill> list = new ArrayList<>();
        File f = new File (filePath);
        
        // this try block is for opening and reading the file
        try(BufferedReader br = new BufferedReader(new FileReader(f)))
        {
            String line = null;
            
            while((line = br.readLine())!= null)
            {
                String records[] = null;
                String consumerNumber = "";
                String consumerName = "";
                String consumerAddress = "";
                int unitsConsumed = 0;
                
                records = line.split(",");
                consumerNumber = records[0];
                consumerName = records[1];
                consumerAddress = records[2];
                unitsConsumed = Integer.parseInt(records[3]);
                
                
            //this try block checks for the validated consumerNumber
                try{
                    if(validate(consumerNumber)){
                        ElectricityBill obj = new ElectricityBill();
                        obj.setConsumerNumber(consumerNumber);
                        obj.setConsumerName(consumerName);
                        obj.setConsumerAddress(consumerAddress);
                        obj.setUnitsConsumed(unitsConsumed);
                        obj.calculateBillAmount();
                        
                        list.add(obj);
                    }
                }
                catch(InvalidConsumerNumberException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    return list;
        //fill the code
    	
    }
    
    public boolean validate(String consumerNumber) throws InvalidConsumerNumberException {
        
        // method for validating the consumerNumber
            boolean isValid = Pattern.matches("^[0][0-9]{9}" , consumerNumber);
            
            if(!isValid){
                throw new InvalidConsumerNumberException("Invalid Consumer Number");
            }
             
            return true;
	
    		//fill the code
    
    }
    
}
