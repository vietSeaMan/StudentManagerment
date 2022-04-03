package manageStudent;

public class Semester implements Comparable<Semester>{
	//Name of semester
	private int name;
	//name of course in this semester
	private String courseName;
	
	/**
	 * initialization method
	 * @param name
	 * @param courseName
	 */
	public Semester(int name, String courseName) {
		this.name = name;
		this.courseName = courseName;
	}
	public int getName() {
		return name;
	}
	public String getcourseName() {
		return courseName;
	}
	public void setName(int name) {
		this.name = name;
	}
	public void setcourseName(String courseName) {
		this.courseName = courseName;
	}
	
	//Override compareTo method use for sort function in collection
	@Override
	public int compareTo(Semester other) {
		int result = 0;
		if(this.name < other.getName()) result = -1;
		else if(this.name > other.getName()) result = 1;
		else  result = 0;
		return result;
	}
}
//41 - 12 = 29 LOC