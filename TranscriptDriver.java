/**
 * Driver class for testing the Transcript Management System.
 * Demonstrates adding, removing, and displaying grades.
 * @author Arshdeep Singh Sharma
 */



public class TranscriptDriver {

	public static void main(String[] args) {
		
		Transcript transcript = new Transcript(8510804);
		
		transcript.addGrade(new Grade("CS1003",4,"B"));
		transcript.addGrade(new Grade("CS1003",4,"B"));
		transcript.addGrade(new Grade("CS2043",4,"A"));
		transcript.addGrade(new Grade("CS1003",4,"C"));
		transcript.addGrade(new Grade("CS2043",4,"D"));
		transcript.addGrade(new Grade("CS2033",4,3.3));
		transcript.addGrade(new Grade("AB1001",4,2.0));
		transcript.addGrade(new Grade("CS2043",4,"C"));
		
		transcript.printTranscript();
		
		System.out.println();
		
		transcript.remove("CS2043","C");
		transcript.printTranscript();
		
		System.out.println();
		
		transcript.removeAll("CS1003");
		transcript.printTranscript();
		
	}

}
