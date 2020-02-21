
public class International extends Student {

	private final int TUITION = 945;
	private final int INTERNATIONAL_STUDENT_FEE = 350;
	
	private boolean exchange;
	
	public International(String fname, String lname, int credit, boolean exchange) {
		super(fname, lname, credit);
		this.exchange = exchange;
	}

	@Override
	public int tuitionDue() {
		
		int bill = 0;
		
		int creditAmount = Math.min(15, credit);
		
		if(exchange) {
			bill += FULL_TIME_FEE;
		}
		else {
			bill += TUITION * creditAmount;
			if(credit >= 12) {
				bill += FULL_TIME_FEE;
			}
			else {
				bill += PART_TIME_FEE;
			}
		}
		
		bill += INTERNATIONAL_STUDENT_FEE;
		
		return bill;
	}
	
	@Override
	public String toString() {
		return super.toString() + ",[exchange:" + exchange + "]";
	}
	
	public static void main(String[]args) {
		International i1 = new International("Soo-Hyeuk", "Kim", 12, true);
		System.out.println(i1.toString());
		System.out.println(i1.tuitionDue());
	}
}
