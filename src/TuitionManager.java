/**
 * The TuitionManager class is the interface class which processes user commands.
 * @author Varun Vasudevan
 */
import java.util.Scanner;

public class TuitionManager {
	Scanner stdin;
	StudentList list;
	/**
	 * This method initializes a scanner and goes through the commands inputed
	 * Command I calls instateAdd()
	 * Command O calls outstateAdd()
	 * Command N calls international()
	 * Command R calls remove()
	 * Command P calls print()
	 * Command Q calls quit() and ends the loop
	 * Defaults when the command is invalid and moves to the next line 
	 * 
	 */
	void run() {
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
					quitMessage();
					done = true;
				default: 
					System.out.println("Command '" + command + "' is not supported!");
					stdin.nextLine();
			}  
		}
	}
	/**
	 *This method adds an in-state student to the list of students
	 *It reads the student's first name, last name, number of credits, and amount of funds.
	 *It checks whether the amount of credits and  funds is valid and also checks if the student is already in the list
	 */
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
	/**
	 * This method adds an international student to the list of students
	 * It reads the first name, last name, number of credits, and the exchange status of the student
	 * It checks whether the number of credits is below 9, if the exchange status is valid and if the student is already contained in the list
	 */
	private void internationalAdd() {
		String fname = stdin.next();
		String lname = stdin.next();
		int credit = Integer.parseInt(stdin.next());
		boolean exchangeStatus;
		String bool = stdin.next();
		if(bool.equals("T")) 
			exchangeStatus=true;
		else if (bool.equals("F"))
			exchangeStatus = false;
		else {
			invalidExchangeStatus();
			return;
		}
		
		if (credit <9) {
			invalidCredit();
			return;
		}
		International i = new International(fname,lname,credit,exchangeStatus);
		 if (list.contains(i)){
			 studentInListError();
			 return;
		 }
		 list.add(i);
	}
	/**
	 * This method checks if the list is empty and prints if it is not empty
	 */
	private void print() {
		if (list.isEmpty()){
			listEmptyError();
			return;
		}
		list.print();
	}
	
	private void remove() {
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
	private void invalidExchangeStatus(){
		System.out.println("Invalid exchange student Status");	
	}
	private void listEmptyError() {
		System.out.println("Printing an empty list");
	}
	private void quitMessage() {
		System.out.println("Program Terminated");
	}
}

