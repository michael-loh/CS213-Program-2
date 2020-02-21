
public class Outstate extends Student{

	private final int TUITION = 756;
	
	private boolean tristate;
	
	public Outstate(String fname, String lname, int credits, boolean tristate) {
		super(fname, lname, credits);
		this.tristate = tristate;
	}

	@Override
	public int tuitionDue() {
		int bill = 0;
		
		int creditAmount = Math.min(15, credit);
		
		int tuition = TUITION;
		if(tristate) {
			tuition -= 200;
		}
		
		bill += tuition * creditAmount;
		
		if(creditAmount >= 12) {
			bill += 1441;
		}
		else {
			bill += 846;
		}
		
		return bill;
	}
	
	@Override
	public String toString() {
		return super.toString() + ",[tristate:" + tristate + "]";
	}
	
	public static void main(String[]args) {
		Outstate o1 = new Outstate("Henry", "Wang", 17, true);
		System.out.println(o1.toString());
		System.out.println(o1.tuitionDue());
	}
}
