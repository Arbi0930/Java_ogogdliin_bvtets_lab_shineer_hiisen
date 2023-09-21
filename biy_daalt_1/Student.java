package biy_daalt_1;
import dataStructures.Chain;
public class Student {
	public String code;// код
	public float GPA;// голч дүн
	public Chain lessons;// үзсэн хичээлүүд
	
	//Point To GPA Converter
	private float convertGPA(float gpa) {
		float newGPA = 0;
		if(gpa >= 97 && gpa <= 100) newGPA = 4;
		else if(gpa >= 93 && gpa <= 96) newGPA = (float) 3.75;
		else if(gpa >= 90 && gpa <= 92) newGPA = (float) 3.5;
		else if(gpa >= 87 && gpa <= 89) newGPA = (float) 3.25;
		else if(gpa >= 83 && gpa <= 86) newGPA = (int)3;
		else if(gpa >= 80 && gpa <= 82) newGPA = (float) 2.75;
		else if(gpa >= 77 && gpa <= 79) newGPA = (float) 2.5;
		else if(gpa >= 73 && gpa <= 76) newGPA = (float) 2.25;
		else if(gpa >= 70 && gpa <= 72) newGPA = (int)2;
		else if(gpa >= 67 && gpa <= 69) newGPA = (float) 1.75;
		else if(gpa >= 63 && gpa <= 66) newGPA = (float) 1.5;
		else if(gpa >= 60 && gpa <= 62) newGPA = (float) 1.25;
		else newGPA = 0;
		return newGPA;
	}
	
	public void calculateGPA() {
		float sum = 0;
		float credit = 0;
		for(int i = 0; i < lessons.size(); i++){
			float score = ((Lessons) lessons.get(i)).score;
			credit += ((Lessons) lessons.get(i)).learned.credit;
			sum += convertGPA(score) * ((Lessons) lessons.get(i)).learned.credit;
		}
		this.GPA = sum / credit;
	}
}