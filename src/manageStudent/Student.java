package manageStudent;

import java.util.ArrayList;
import java.util.Collections;

public class Student implements Comparable<Student> {
	
	//information of each students
	private int id;
	private String studentName;
	private ArrayList<Semester> semesterList;
	private int javaCourse;
	private int netCourse;
	private int cCourse;;
	
	/**
	 * initialization method
	 * @param id
	 * @param studentName
	 */
	public Student(int id, String studentName) {
		this.id = id;
		this.studentName = studentName;
		semesterList = new ArrayList<Semester>();
		this.javaCourse = 0;
		this.netCourse = 0;
		this.cCourse = 0;
	}
	
	public int getId() {
		return id;
	}
	public String getStudentName() {
		return studentName;
	}
	public ArrayList<Semester> getSemester() {
		return semesterList;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void addSemester(Semester semester) {
		semesterList.add(semester);
		Collections.sort(semesterList);
	}
	
	//Calculation courses of each student and print out
	public void getNumberOfCourse() {
		for(Semester x : semesterList) {
			if(x.getcourseName().compareTo("Java") == 0) javaCourse++;
			if(x.getcourseName().compareTo(".Net") == 0) netCourse++;
			if(x.getcourseName().compareTo("C/C++") == 0) cCourse++;
		}
		if(javaCourse != 0)
			System.out.println("\t"+ this.getStudentName() + " | Java  | "+ javaCourse);
		if(netCourse != 0)
			System.out.println("\t"+ this.getStudentName() + " | .Net  | "+ netCourse);
		if(cCourse != 0)
			System.out.println("\t"+ this.getStudentName() + " | C/C++ | "+ cCourse);
		//reset the result for the next turn
		javaCourse=0;
		netCourse=0;
		cCourse=0;
	}
	
	@Override
	public int compareTo(Student other) {
		return this.getStudentName().compareTo(other.getStudentName());
	}
	
	/**
	 * return a string include information of semester for this student
	 * @return
	 */
	public String getStringFromSemesterList() {
		String str = "";
		for(Semester x : semesterList) {
			str += "\t\t\t\t" + x.getName() + "\t" + x.getcourseName() + "\n";
		}
		return str;
	}
	@Override
	public String toString() {
		String str = "\t" + id + "\t" + studentName + "  \n" + getStringFromSemesterList();
				str+="\t-------------------------------------------";
		return str;
	}
}
//93-21 = 72 LOC