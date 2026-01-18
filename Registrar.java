/**
 * Utility class that handles grade conversions and GPA calculation.
 * Provides static academic grading methods.
 * @author Arshdeep Singh Sharma
 */


import java.util.ArrayList;

public class Registrar {
	
	public static double letterToPoint(String gradeLetter) {
		double gradePoint;
		switch(gradeLetter) {
		case "A+": gradePoint = 4.3;
					break;
		case "A":  gradePoint = 4.0;
					break;
		case "A-": gradePoint = 3.7;
					break;
		case "B+": gradePoint = 3.3;
					break;
		case "B": gradePoint = 3.0;
					break;
		case "B-": gradePoint = 2.7;
					break;
		case "C+": gradePoint = 2.3;
					break;
		case "C": gradePoint = 2.0;
					break;
		case "D": gradePoint = 1.0;
					break;
		case "F": gradePoint = 0.0;
					break;
		case "WF": gradePoint = 0.0;
					break;
		default: throw new IllegalArgumentException("Invalid grade letter.");
		}
		return gradePoint;
	}
	
	public static String pointToLetter(double gradePoint) {
		String gradeLetter;
		
		if(gradePoint>=4.3) {
			gradeLetter = "A+";
		}else if(gradePoint>=4.0) {
			gradeLetter = "A";
		}else if(gradePoint>=3.7) {
			gradeLetter = "A-";
		}else if(gradePoint>=3.3) {
			gradeLetter = "B+";
		}else if(gradePoint>=3.0) {
			gradeLetter = "B";
		}else if(gradePoint>=2.7) {
			gradeLetter = "B-";
		}else if(gradePoint>=2.3) {
			gradeLetter = "C+";
		}else if(gradePoint>=2.0) {
			gradeLetter = "C";
		}else if(gradePoint>=1.0) {
			gradeLetter = "D";
		}else {
			gradeLetter = "F";
		}

		return gradeLetter;
	}
	
	public static double floorGradePoint(double gradePoint) {
		double points;
		
		if(gradePoint>=4.3) {
			points = 4.3;
		}else if(gradePoint>=4.0) {
			points = 4.0;
		}else if(gradePoint>=3.7) {
			points = 3.7;
		}else if(gradePoint>=3.3) {
			points = 3.3;
		}else if(gradePoint>=3.0) {
			points = 3.0;
		}else if(gradePoint>=2.7) {
			points = 2.7;
		}else if(gradePoint>=2.3) {
			points = 2.3;
		}else if(gradePoint>=2.0) {
			points = 2.0;
		}else if(gradePoint>=1.0) {
			points = 1.0;
		}else {
			points = 0.0;
		}

		return points;
	}
	
	public static double calcGpa(ArrayList<Grade> grades) {
		if(grades.isEmpty()) {
			return Double.NaN;
		}
		double totalPoints = 0.0;
		int totalCreditHours = 0;
		
		for(Grade g: grades) {
			totalPoints += g.getGradePoint() * g.getCreditHour();
			totalCreditHours+= g.getCreditHour();
		}
		return totalPoints / totalCreditHours;
		
	}

}
