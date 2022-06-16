
//This is the POJO/model class

public class ElectricityBill {

    private String consumerNumber;
    private String consumerName;
    private String consumerAddress;
    private int unitsConsumed;
    private double billAmount;

    public String getConsumerNumber() {
		return consumerNumber;
	}

	public void setConsumerNumber(String consumerNumber) {
		this.consumerNumber = consumerNumber;
	}

	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	public String getConsumerAddress() {
		return consumerAddress;
	}

	public void setConsumerAddress(String consumerAddress) {
		this.consumerAddress = consumerAddress;
	}

	public int getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}


	//Write the required business logic as expected in the question description
	public void calculateBillAmount() {
	    // method for calaculating the bill amount.
	    int units = unitsConsumed;
	    double bill = 0;
	    
	    if(units <= 100){
	        bill = 0;
	    }
	    if(units > 100 && units <= 300){
	        bill = (units-100) * 1.5;
	    }
	    if(units > 300 && units <= 600){
	        bill = 200 * 1.5 + (units-300) * 3.5;
	    }
	    if(units > 600 && units <= 1000){
	        bill = 200 * 1.5 + 300 * 3.5 + (units-600) * 5.5;
	    }
	    if(units > 1000){
	        bill = 200 * 1.5 + 300 * 3.5 + 400 * 5.5 + (units-1000) * 7.5;
	    }
	    
	    setBillAmount(bill);
	    

    	//fill the code

    }
    
}