/**
 * Stores and manages a student's transcript and course grades.
 * Supports GPA calculation and sorted transcript output.
 * @author Arshdeep Singh Sharma
 */


import java.util.ArrayList;
import java.util.Collections;

public class Transcript {
	private final int studentId;
	private ArrayList<Grade> grades;
	
	public Transcript(int studentId) {
		this.studentId = studentId;
		this.grades = new ArrayList<Grade>();
	}
	
	public void clearGrades() {
		grades.clear();
	}
	
	public ArrayList<Grade> getGrades(){
		ArrayList<Grade> copy = new ArrayList<Grade>(grades.size());
		
		for(Grade g: grades) {
			copy.add(new Grade(g));
		}
		return copy;
	}
	
	public double getGpa() {
		return Registrar.calcGpa(getGrades());
	}
	
	public void addGrade(Grade grade) {
		
		if(!(grades.contains(grade))){
			grades.add(grade);
		}
	}
	
	public void printTranscript() {
		double gpa = getGpa();
		
		String gPa = Double.isNaN(gpa) ? "NaN" : String.format("%.2f",gpa);
		System.out.println(String.format("Student %d: GPA %s",studentId,gPa));
		
		ArrayList<Grade> sortedGrades = getGrades();
		Collections.sort(sortedGrades);
		
		for(Grade g:sortedGrades) {
			System.out.println(g);
		}
	}
	
	public void remove(String courseNum,String gradeLetter) {
		Grade dummy = new Grade(courseNum,4,gradeLetter);
		grades.remove(dummy);
	}
	
	public void removeAll(String courseNum) {
		ArrayList<Grade> toRemove = new ArrayList<Grade>();
		
		for(Grade g:grades) {
			if(g.getCourseNum().equals(courseNum)) {
				toRemove.add(g);
			}
		}
		grades.removeAll(toRemove);
	}
}
