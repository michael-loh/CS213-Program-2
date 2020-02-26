/**
 * This class serves as an international student representation of the Student class.
 * This class implements the tuitionDue() method following the guidelines of an international student.
 * It also overrides the toString() method by appending on fields from this subclass.
 * @author Michael Loh
 */
public class International extends Student {

	private final int TUITION = 945;
	private final int INTERNATIONAL_STUDENT_FEE = 350;
	
	private boolean exchange;
	
	/**
	 * This constructor calls the super constructor with the provided parameters, and it also assigns a value to exchange
	 * @param fname is sent to the superclass constructor
	 * @param lname is sent to the superclass constructor
	 * @param credit is sent to the superclass constructor
	 * @param exchange describes whether the student is an exchange student or isn't
	 */
	public International(String fname, String lname, int credit, boolean exchange) {
		super(fname, lname, credit);
		this.exchange = exchange;
	}

	/**
	 * This method calculates the tuition due for an international student.
	 * If it is an exchange student, they avoid paying tuition, otherwise, they pay $945 per credit.
	 * An international student must also pay a full time fee if >= 12 credits and part time fee is < 12.
	 * An international student must also pay the international student fee, which is 350.
	 */
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
	
	/**
	 * This returns all the elements of this object in a string.
	 * It calls the super classes toString(), then appends on the "exchange" information onto the end of it.
	 */
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
