/**
 * Represents a course grade with credit hours and grading details.
 * Implements Comparable to support transcript sorting.
 * @author Arshdeep Singh Sharma
 */

import java.util.Objects;

public class Grade implements Comparable<Grade>{
	private final String courseNum;
	private final int creditHour;
	private final String gradeLetter;
	private final double gradePoint;
	
	public Grade(String courseNum,int creditHour,String gradeLetter) {
		if(courseNum == null || courseNum.trim().isEmpty()) {
			throw new IllegalArgumentException("Course Number cannnot be empty");
		}
		if(creditHour<= 0) {
			throw new IllegalArgumentException("Credit Hours must be positive");
		}
		if(gradeLetter == null || gradeLetter.trim().isEmpty()) {
			throw new IllegalArgumentException("Letter grade cannnot be empty");
		}
		this.courseNum = courseNum;
		this.creditHour = creditHour;
		this.gradeLetter = gradeLetter;
		this.gradePoint = Registrar.letterToPoint(gradeLetter);
	}
	
	public Grade(String courseNum,int creditHour,double gradePoint) {
		if(courseNum == null || courseNum.trim().isEmpty()) {
			throw new IllegalArgumentException("Course Number cannnot be empty");
		}
		if(creditHour<= 0) {
			throw new IllegalArgumentException("Credit Hours must be positive");
		}
		this.courseNum = courseNum;
		this.creditHour = creditHour;
		this.gradePoint = Registrar.floorGradePoint(gradePoint);
		this.gradeLetter = Registrar.pointToLetter(gradePoint);
	}
	
	public Grade(Grade g) {
		this.courseNum = g.courseNum;
		this.creditHour = g.creditHour;
		this.gradeLetter = g.gradeLetter;
		this.gradePoint = g.gradePoint;
	}
	
	public String getCourseNum() {
		return courseNum;
	}
	
	public int getCreditHour() {
		return creditHour;
	}
	
	public double getGradePoint() {
		return gradePoint;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %dch %.1f (%s)",courseNum,creditHour,gradePoint,gradeLetter); 
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(courseNum, creditHour, gradeLetter, gradePoint);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grade other = (Grade) obj;
		
		return courseNum.equals(other.courseNum) && gradeLetter.equals(other.gradeLetter);
	}
	
	@Override
	public int compareTo(Grade other) {
		int result = this.courseNum.compareTo(other.courseNum);
		
		if(result != 0) {
			return result;
		}
		return this.gradeLetter.compareTo(other.gradeLetter);
	}
		
}
