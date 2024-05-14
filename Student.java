
import java.util.*;
abstract class Student {
	protected int id;
	protected String name;
	protected List<Course> courses;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
		this.courses = new ArrayList<>();
	}

	public abstract void addCourse(Course course) throws PrerequisiteException;

	public abstract void dropCourse(Course course); 

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}
class RegisteredStudent extends Student implements Comparable<RegisteredStudent>{
	public RegisteredStudent(int id, String name) {
		super(id, name);
	}


	public void addCourse(Course course) throws PrerequisiteException {
		if (course.getPrerequisite() != null && !courses.contains(course.getPrerequisite())) {
			throw new PrerequisiteException("Prerequisite of the course is not completed");
		} else if (!course.isOffered()) {
			throw new PrerequisiteException("Course is not offered ");
		}

		else if (!courses.contains(course)) {
			courses.add(course);
		}
	}


	public void dropCourse(Course course) {
		courses.remove(course);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		RegisteredStudent that = (RegisteredStudent) obj;
		return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(courses, that.courses);
	}


	public int hashCode() {
		return Objects.hash(id, name, courses);
	}

	public int compareTo(RegisteredStudent std) {
		return Integer.compare(this.id, std.id);
		// TODO Auto-generated method stub
	}
}

class Course {
	protected String name;
	protected Course prerequisite;
	protected boolean offered;

	public Course(String name, boolean offered) {
		
		this.name = name;
		this.offered = offered;
	}

	

	public Course(String name, Course prerequiste, boolean offered) {
		
		this.name = name;
		this.prerequisite = prerequiste;
		this.offered = offered;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequiste(Course prerequiste) {
		this.prerequisite = prerequiste;
	}

	public boolean isOffered() {
		return offered;
	}

	public void setOffered(boolean offered) {
		this.offered = offered;
	}

	public boolean equals(Course obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Course other = obj;
		if (offered != other.offered)
			return true;
		return false;
		
	}

}

class RegistrationException extends Exception {
	private static final long serialVersionUID = 1L;

	public RegistrationException() {
		super();
	}

	public RegistrationException(String name) {
		super(name);
	}

}

class PrerequisiteException extends RegistrationException {
	private static final long serialVersionUID = 1L;

	public PrerequisiteException() {
		super();
	}

	public PrerequisiteException(String name) {
		super(name);
	}
}