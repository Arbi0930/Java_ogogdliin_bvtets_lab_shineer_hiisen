package biy_daalt_1;

public class Major {
	public String code;// код(оюутны кодын эхний 2 үсэг)
	public String name;// нэр
	
	public Major(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public String toString() {
		return "\tМэргэжлийн код: " + code +
				"\tМэргэжлийн нэр: " + name;
	}
}