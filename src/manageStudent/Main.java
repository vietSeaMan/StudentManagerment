package manageStudent;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Student>  studentList = new ArrayList<Student>();
		Operation op = new Operation();
	
		int optionForMenu = 0;
		do {
			op.showMenu();
			optionForMenu = inputInt(sc);
			if(optionForMenu==1) op.createNewStudent(studentList);
			else if(optionForMenu==2) op.sortOrFindStudentByName(studentList);
			else if(optionForMenu==3) op.updateOrDeleteById(studentList);
			else if(optionForMenu==4) op.report(studentList);
		}while(optionForMenu != 5);
		System.out.println("________________________\nEND");
	}
	
	//Check input for Integer variable
	public static int inputInt(Scanner sc) {
		int num = 0;
		boolean check = true;
		do {
			//Use try catch to keep program flow continue when exception across
			try {
				num = sc.nextInt();
				check = true;
			}catch(Exception ex) {
				check = false;
				System.out.println("Data format is wrong, Pls try again!...");
				sc.nextLine();
			}
		}while(!check);
		return num;
	}
}
//45 - 8 = 37 LOC
//Total 329 LOC