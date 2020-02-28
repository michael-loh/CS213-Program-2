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
		int credit = stdin.next();
		int funds = stdin.next();
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
	
	private void invalidCredit() {
		System.out.println("Invalid credit amount!");
	}
	private void invalidFunds() {
		System.out.println("Invalid fund amount!");
	}
	private void studentInListError() {
		System.out.println("Student is already in list");
	}

}

