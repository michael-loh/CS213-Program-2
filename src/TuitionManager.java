/**
 * The TuitionManager class is the interface class which processes user commands.
 * @author Varun Vasudevan
 */
import java.util.Scanner;

public class TuitionManager {
	Scanner stdin;
	StudentList list;


	
	private void run() {
		stdin = new Scanner(System.in);
		list = new StudentList();
		boolean done = false;
		
	      
		while ( !done )
		{
			String command = stdin.next();
			
			switch ( command )  
			{   
				case "I":  
					instateAdd();
					break; 
				case "O": 
					outstateAdd();
					break;
				case "N": 
					internationalAdd();
					break;
				case "R": 
					remove();
					break;
				case "P":
					print();
					break;
				case "Q":
					quit();
					done = true;
				default: 
					System.out.println("Command '" + command + "' is not supported!");
					stdin.nextLine();
			}  
		}
	}
	
	private void instateAdd() {
		String fname = stdin.next();
		String lname = stdin.next();
		int credit = Integer.parseInt(stdin.next());
		int funds = Integer.parseInt(stdin.next());
		if (credit <1) {
			invalidCredit();
			return;
		}
		if (funds<0) {
			invalidFunds();
			return;
		}
		Instate s = new Instate(fname,lname,credit,funds);
		 if (list.contains(s)){
			 studentInListError();
			 return;
		 }
		 list.add(s);
	}
	
	private void outstateAdd() {
		String fname = stdin.next();
		String lname = stdin.next();
		
		String num = stdin.next();
		int credit = Integer.parseInt(num);
		if(credit < 1) {
			invalidCredit();
			return;
		}
		
		String bool = stdin.next();
		if(! ( (bool.equals("T") || bool.contentEquals("F") ) ) ){
			invalidTriState();
			return;
		}
		boolean tristate = (bool.equals("T"))? true: false;
		
		Outstate s = new Outstate(fname, lname, credit, tristate);
		
		if(list.contains(s)) {
			studentInListError();
			return;
		}
		
		list.add(s);
	}
	
	public void remove() {
		String fname = stdin.next();
		String lname = stdin.next();
		
		Student s = new Instate(fname, lname, 0, 0);
		
		if(!list.contains(s)) {
			notInListError(fname, lname);
			return;
		}
		
		list.remove(s);
	}
	
	private void invalidCredit() {
		System.out.println("Invalid credit amount!");
	}
	private void invalidFunds() {
		System.out.println("Invalid fund amount!");
	}
	private void studentInListError() {
		System.out.println("Student is already in list");
	}
	private void invalidTriState() {
		System.out.println("Invalid tri-state value");
	}
	private void notInListError(String fname, String lname) {
		System.out.println(fname + " " + lname + " was not found in the list");
	}
}
