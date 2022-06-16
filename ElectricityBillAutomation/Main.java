import java.util.*;
import java.util.List;
import java.util.ArrayList;
public class Main {

   public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       
       String filePath = "src/ElectricityBill.txt";
       
       List<ElectricityBill> list = new ArrayList<>();
       
       ElectricityBoard eb = new ElectricityBoard();
       list = eb.generateBill(filePath);
       
       for(ElectricityBill obj: list){
           System.out.println(obj.getConsumerNumber() + " " + obj.getConsumerName() + " " + obj.getBillAmount());
           
       }
       
       eb.addBill(list);
       
       System.out.println("Successfully Inserted");
       
       sc.close();
	   //fill your code here
   
   }

}
          