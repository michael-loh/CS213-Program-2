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
					inStateAdd();
					break; 
				case "O": 
					outStateAdd();
					break;
				case "N": 
					international();
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
	
	private void inStateAdd() {
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
	private void international() {
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
	
	private void print() {
		if (list.isEmpty()){
			listEmptyError();
			return;
		}
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
	private void invalidExchangeStatus(){
		System.out.println("Invalid exchange student Status");
		
	}
	private void listEmptyError() {
		System.out.println("Printing an empty list");
	}

}
