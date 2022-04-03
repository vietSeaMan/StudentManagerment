package manageStudent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Operation {
	
	Scanner sc = new Scanner(System.in);
	
	public void showMenu() {
		System.out.println("HE THONG QUAN LY SINH VIEN \n-----------------------------");
		System.out.println("1. Tao\n2. Tim kiem va Sap xep\n3. Cap Nhap / Xoa\n4. Bao cao \n5. Thoat");
	}
	
	/**
	 * Create a new student
	 * @param studentList
	 */
	public void createNewStudent(ArrayList<Student> studentList) {
		System.out.println("--------------------------");
		System.out.println("Nhap so sinh vien can tao moi: ");
		int numberOfNewStuden = inputInt(sc);
		
		System.out.println();
		boolean continute = true;
		int countNewStudent = 0;
		
		do {
			if(numberOfNewStuden==0) break;
			System.out.println("so sinh vien cho phep them moi: " + (numberOfNewStuden-countNewStudent));
			countNewStudent++;
			System.out.println("Nhap ID Sinh vien:");
			int id = inputInt(sc);
			if(findById(studentList, id) == null) {
				sc.nextLine();
				System.out.println("Nhap ten Sinh vien:");
				String studenName = sc.nextLine();
				Student newStuden = new Student(id, studenName);
				
				System.out.println("Nhap Hoc ky:");
				int semester = inputInt(sc);
				
				sc.nextLine();
				System.out.println("Nhap ten khoa hoc");
				String courseName = checkNameOfCourse(sc);
				Semester newSemester = new Semester(semester, courseName);
				System.out.println();
				
				newStuden.addSemester(newSemester);
				studentList.add(newStuden);
				
				if(numberOfNewStuden <= countNewStudent) {
					System.out.println("Ban da them moi "+ countNewStudent+ " sinh vien, ban co  muon tiep tuc khong?");
					System.out.println("1. Yes");
					System.out.println("2. No");
					int subOption1 = inputInt(sc);
					if(subOption1 == 1) countNewStudent=0;
					else continute = false;
				}
			}
			else {
				System.out.println("ID: " + id + " ung voi sinh vien: " + findById(studentList, id).getStudentName());
				System.out.println("Ban muon them thong tin cho sinh vien nay?\n1. Yes\n2. No");
				int subOption2 = inputInt(sc);
				if(subOption2==1) {
					System.out.println("Nhap Hoc ky:");
					int nameSemester = inputInt(sc);
					
					sc.nextLine();
					System.out.println("Nhap ten khoa hoc");
					String courseName1 = checkNameOfCourse(sc);
					Semester newSemester1 = new Semester(nameSemester, courseName1);
					findById(studentList, id).addSemester(newSemester1);
					countNewStudent--;
				}else {
					countNewStudent--;
				}
			}
		}while(continute);
		System.out.println();
	}
	
	/**
	 * Sort list of student or find a student by name
	 * @param studentList
	 */
	public void sortOrFindStudentByName(ArrayList<Student> studentList) {
		System.out.println("Chon hanh dong?");
		int subOption = 0;
		do {
			System.out.println("1. Tim kiem theo ten\n2. Sap xep danh sach theo ten");
			subOption  = inputInt(sc);
			if(subOption == 1) findByName(studentList);
			else if(subOption == 2) sortByName(studentList);
			
			if(subOption != 1 && subOption != 2) System.out.println("Chua nhap dung lua chon!");
			
		}while(subOption != 1 && subOption != 2);
	}
	
	/**
	 * update information for student or delete a studen by ID
	 * @param studentList
	 */
	public void updateOrDeleteById(ArrayList<Student> studentList) {
		System.out.println("Nhap ID sv can tim kiem: ");
		int id = inputInt(sc);
		Student studentTagetById = null;
		studentTagetById = findById(studentList, id);
		if(studentTagetById ==null) System.out.println("EMPTY LIST!");
		else System.out.println(studentTagetById);
		
		System.out.println("Chon hanh dong?"); 
		int subOption = 0;
		do {
			System.out.println("1. Cap nhap sinh vien - Update (U)\n2. Xoa sinh vien - Deleta (D)");
			subOption  = inputInt(sc);
			if(subOption == 1) update(studentTagetById);
			else if(subOption == 2) deleteStudent(studentList, studentTagetById);
			
			if(subOption != 1 && subOption != 2) System.out.println("Chua nhap dung lua chon!");
			
		}while(subOption != 1 && subOption != 2);
	}
	
	/**
	 * print out report for all student
	 * @param studentList
	 */
	public void report(ArrayList<Student> studentList) {
		for(Student x : studentList) 
			x.getNumberOfCourse();
	}
	
	/********************************************************************************Sub Function*****************/
	/**
	 * find a student in list by name
	 * @param studentList
	 */
	public void findByName(ArrayList<Student> studentList) {
		if(studentList.isEmpty()) {
			System.out.println("EMPTY LIST");
			return;
		}
		boolean found = false;
		System.out.println("Nhap ten sv can tim kiem: ");
		String strForFindName = sc.next();
		for(Student x : studentList) {
			if(x.getStudentName().indexOf(strForFindName)>=0) {
				System.out.println(x);
				found = true;
			}
		}
		if(found == false) System.out.println("Ten SV khong ton tai!");
		System.out.println();
	}
	
	/**
	 * Sort list of student using Coleection.sort method (Library of Java)
	 * @param studentList
	 */
	public void sortByName(ArrayList<Student> studentList) {
		ArrayList<Student> tempList = new ArrayList<Student>();
		tempList.addAll(studentList);
		Collections.sort(tempList);
		System.out.println("Before Sorting:");
		printOut(studentList);
		System.out.println("After Sorting:");
		printOut(tempList);
	}
	
	/**
	 * print out information of students
	 * @param studentList
	 */
	public void printOut(ArrayList<Student> studentList) {
		System.out.println("\tID\tTen SV\t    Hoc ky\tKhoa hoc");
		System.out.println("\t-------------------------------------------");
		for(Student x : studentList) {
			System.out.println(x);
		}
		System.out.println();
	}
	
	/**
	 * update information for student
	 * @param student
	 */
	public void update(Student student) {
		System.out.println("Cap nhap ID moi: ");
		student.setId(inputInt(sc));
		System.out.println("Update ten sinh vien: ");
		sc.nextLine();
		student.setStudentName(sc.nextLine());
		for(Semester x: student.getSemester()) {
			System.out.println("Cap nhap cho hoc ky: \t"+ x.getName() + " - "+ x.getcourseName());
			System.out.println("Cap nhap ten hoc ky");
			x.setName(inputInt(sc));
			System.out.println("Cap nhap khoa hoc");
			x.setcourseName(checkNameOfCourse(sc));
		}
	}
	
	/**
	 * delete a student from list
	 * @param studentList
	 * @param student
	 */
	public void deleteStudent(ArrayList<Student> studentList, Student student) {
		studentList.remove(student);
		System.out.println("DONE!");
	}
	
	/**
	 * Find student by ID and return student Object
	 * @param studentList
	 * @param id
	 * @return
	 */
	public Student findById(ArrayList<Student> studentList, int id) {
		if(studentList.isEmpty()) return null;
		Student studentTaget = null;
		for(Student x : studentList) {
			if(x.getId() == id ) {
				studentTaget = x;
				break;
			}
		}
		return studentTaget;
	}
	
	/*
	 * //Check input for Integer variable
	 */
	public int inputInt(Scanner sc) {
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
			//Input cannot less than Zero
		}while(!check);
		return num;
	}
	
	/**
	 * check name of course from user
	 * @param sc
	 * @return
	 */
	public String checkNameOfCourse(Scanner sc) {
		String str;
		do {
			str = sc.next();
			if(str.compareTo("Java")!= 0 && str.compareTo(".Net")!= 0 && str.compareTo("C/C++")!= 0) {
				System.out.println("Ten khoa hoc chi bao gom: \"Java\", \".Net\", \"C/C++\"");
				System.out.println("Vui long nhap lai");
			}
		}while(str.compareTo("Java")!= 0 && str.compareTo(".Net")!= 0 && str.compareTo("C/C++")!= 0);
		return str;
	}
}
//271 - 80 = 191 LOC