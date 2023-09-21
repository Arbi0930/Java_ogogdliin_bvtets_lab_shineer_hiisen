package biy_daalt_1;

public class Lessons {
	public Subject learned;
	public float score;
	
	public Lessons(Subject learned, float score) {
		this.learned = learned;
		this.score = score;
	}
	
	public String toString() {
		return learned + " - " + score;
	}
}
