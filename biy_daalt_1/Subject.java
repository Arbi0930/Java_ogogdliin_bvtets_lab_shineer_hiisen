package biy_daalt_1;

import java.io.IOException;
import java.util.Arrays;

public class Subject {
	public String code;// код
	public String name;// нэр
	public float credit;// кредит
	
	public Subject(String code, String name, float cr) {
		this.code = code;
		this.name = name;
		credit = cr;
	}
	
	public String toString() {
		return "Хичээлийн код:" + code + 
				"\t\tХичээлийн нэр: " + name + 
				"\t\tКредит: " + credit; 
	}
}
