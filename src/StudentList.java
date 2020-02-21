
public class StudentList {
	
	private final int GROW_SIZE = 10;
	private Student[] list;
	private int totalStudents;
	
	public StudentList() {
		list = new Student[10];
		totalStudents = 0;
	}
	
	public void add(Student s) {
		if( totalStudents == list.length ) {
			grow();
		}
		list[totalStudents++] = s;
	}
	
	public void remove(Student s) {
	
		int index = findStudent(s);
		
		if(index == -1) {
			return;
		}
		
		for(int i = index; i < totalStudents - 1; i++) {
			list[i] = list[i+1];
		}
		totalStudents--;
		list[totalStudents] = null;
	}
	
	public void print() {
		for(int i = 0; i < totalStudents; i++) {
			System.out.println(list[i].toString());
			System.out.println("Tuition due: " + list[i].tuitionDue());
			System.out.println();
		}
	}
	
	private void grow() {
		Student[] newList = new Student[list.length + GROW_SIZE];
		for(int i = 0; i < list.length; i++) {
			newList[i] = list[i];
		}
		
		list = newList;
	}
	
	private int findStudent(Student s) {
		
		for(int i = 0; i < list.length; i++) {
			if(s.compareTo(list[i]) == 0) 
				return i;
		}
		
		return -1;
	}
	
	public boolean contains(Student s) {
		
		for(Student t: list) {
			if(s.compareTo(t) == 0)
				return true;
		}
		return false;
	}
	
	public static void main(String[]args) {
		
		StudentList list = new StudentList();
		
		Instate s1 = new Instate("Michael", "Loh", 15, 1000);
		
		list.add(s1);
		//list.print();
		
		Outstate s2 = new Outstate("Eric", "He", 17, true);
		list.add(s2);
		//list.print();
		list.print();
		
		System.out.println(s1.compareTo(s1));
	}
}
