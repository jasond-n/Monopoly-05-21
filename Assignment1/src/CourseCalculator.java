/* CourseCalculator.java
 * 
 * This program calculates your final grade for CPSC 233 as a weighted average
 * given a set of raw grades in each of five grading categories and the corresponding
 * weights.
 */

public class CourseCalculator {

	public static void main(String[] args) {
		
		// Raw grades 
		// Values should be between 0 and 4 (U of C's 4-point grading scale)
		// These values can be changed to test whether the grade calculation is accurate
		int iAssignmentGrade = 2;
		int iQuizGrade = 1;
		int iCodingChallengeGrade = 1;
		int tQuizGrade = 1;
		int tProjectGrade = 1;
		
		// Final grade (should be a calculated value)
		int finalGrade = 0;
		
		// Weights for each grade category
		double iAssignmentGradeWeight = 0.1;
		double iQuizGradeWeight = 0.2;
		double iCodingChallengeGradeWeight = 0.3;
		double tQuizGradeWeight = 0.1;
		double tProjectGradeWeight = 0.3;
	
		// Calculated grade. It is a weighted average of all grade categories.
		finalGrade = (int) (iAssignmentGrade * iAssignmentGradeWeight +
				iQuizGrade * iQuizGradeWeight +
				iCodingChallengeGrade * iCodingChallengeGradeWeight + 
				tQuizGrade * tQuizGradeWeight +
				tProjectGrade * tProjectGradeWeight);
		
		System.out.println("Your final grade will be " + finalGrade);

	}

	
	
}


