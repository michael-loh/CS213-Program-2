
public abstract class Student implements Comparable {
	private String fname;
	private String lname;
	private int credit;
	
	public Student(String fname, String lname, int credit) {
		this.fname = fname;
		this.lname = lname;
		this.credit = credit;
	} //constructor
	
	//must implement compareTo method because Student class implements the Comparable Interface
	//return 0 if fname and lname are equal, -1 if this < obj, 1 if this > obj	
	public int compareTo(Object obj) {
		
		if(obj.getClass().getSuperclass() != this.getClass().getSuperclass()) {
			return -1;
		}
		
	}
	//return a string with fname, lname and credit hours; subclasses will be using this method.
	public String toString() {
		return fname + " " + lname + ": " + credit;
	}
	//compute the tuition due; concrete implementation is required in the subclasses.
	public abstract int tuitionDue();
}