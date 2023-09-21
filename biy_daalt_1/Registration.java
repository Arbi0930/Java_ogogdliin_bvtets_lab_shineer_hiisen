package biy_daalt_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import dataStructures.ArrayLinearList;
import dataStructures.Chain;

public class Registration {

	public static Registration reg;
	public ArrayLinearList studentList; // Оюутны мэдээлэл хадгалах жагсаалт
	public ArrayLinearList subjectList; // Хичээлийн мэдээлэл хадгалах жагсаалт
	public ArrayLinearList majorList; // Мэргэжлийн мэдээлэл хадгалах жагсаалт
	public float average_gpa;
	public boolean checkF = false;

	public Registration() { /* Жагсаалтуудыг үүсгэнэ. */
		studentList = new ArrayLinearList();
		subjectList = new ArrayLinearList();
		majorList = new ArrayLinearList();
	}

	public static void main(String[] args) {
		reg = new Registration();
		Scanner in = new Scanner(System.in);

		while (true) { /* Програмыг зогсоох хүртэл давталт хийнэ. */
			reg.commands();
			System.out.println();
			System.out.print("Сонголт: ");
			int sel = in.nextInt();
			reg.display(sel);
		}
	}

	public void commands() { /* Програмын цэс */
		System.out.println("+------------------------------------+");
		System.out.println("| 1.Файл уншуулах                    |");
		System.out.println("| 2.Хичээлийн жагсаалт               |");
		System.out.println("| 3.Мэргэжлийн жагсаалт              |");
		System.out.println("| 4.Оюутны дүнгийн мэдээлэл          |");
		System.out.println("| 5.Хичээл бүрээр оюутаны жагсаалт   |");
		System.out.println("| 6.Мэргэжил бүрээр оюутаны жагсаалт |");
		System.out.println("| 0.Гарах                            |");
		System.out.println("+------------------------------------+");
	}

	public void display(int val) {
		switch (val) {
		case 1:
			/* Хичээлийн мэдээллийг файлаас уншина. */
			Scanner subFile = reg.input("Subjects.txt");

			if (subFile != null) {
				String line;
				while (subFile.hasNextLine()) {
					line = subFile.nextLine();
					String values[] = line.split("/");
					subjectList.add(subjectList.size(), new Subject(values[0], values[1], Float.parseFloat(values[2])));
				}
				subFile.close();
			}

			/* Мэргэжлийн мэдээллийг файлаас уншина. */
			Scanner majFile = reg.input("Professions.txt");

			if (majFile != null) {
				String line;

				while (majFile.hasNextLine()) {
					line = majFile.nextLine();
					String values[] = line.split("/");
					majorList.add(majorList.size(), new Major(values[0], values[1]));
				}
				majFile.close();
			}

			/* Оюутны дүнгийн мэдээллийг файлаас уншина. */
			Scanner exFile = reg.input("C:\\Users\\Admin\\eclipse-workspace\\BiyDaalt\\src\\Exams.txt");

			if (exFile != null) {
				String line;
				int index = 0;

				while (exFile.hasNextLine()) {
					line = exFile.nextLine();
					String values[] = line.split("/");
					Student studentObj = new Student();
					studentObj.code = values[0];
					int hjndex = 0;

					for (int i = 0; i < subjectList.size(); i++) {
						if (((Subject) subjectList.get(i)).code.equals(values[1])) {
							studentObj.lessons = new Chain();
							Lessons lesson = new Lessons((Subject) subjectList.get(i), Float.parseFloat(values[2]));
							studentObj.lessons.add(hjndex, lesson);
						}
					}
					studentList.add(index++, studentObj);
				}
				exFile.close();
			}

			break;

		case 2: /* Хичээлийн жагсаалтуудыг хэвлэнэ. */

			for (int i = 0; i < subjectList.size(); i++) {
				System.out.println(subjectList.get(i).toString());
			}
			break;

		case 3: /* Мэргэжлийн жагсаалтуудыг хэвлэнэ. */

			for (int i = 0; i < majorList.size(); i++) {
				System.out.println(majorList.get(i).toString());
			}
			break;

		case 4: /* Оюутны дүнгийн мэдээллүүдийг сонголт. */

			Scanner in = new Scanner(System.in);
			System.out.println("1.Дүнгийн дундаж харах");
			System.out.println("2.Дүнгийн мэдээлэл нэмэх");
			System.out.println("0.Буцах");
			System.out.print("\nСонголт: ");
			int c = in.nextInt();
			reg.subMenu(c);
			break;

		case 5: /* Хичээл бүрээр оюутаны жагсаалт хэвлэнэ. */
			listBySubject();
			break;

		case 6: /* Мэргэжил бүрээр оюутаны жагсаалт хэвлэнэ. */
			listByMajor();
			break;

		case 0: /* 0 оруулсан тохиолдолд програм зогсоно. */
			System.out.println("Системээс гарлаа...");
			System.exit(0);
			break;

		default:
			/* Цэсэнд зааснаас өөр тоонд дарах үед програмаас мэдэгдэл хийнэ. */
			System.out.println("Буруу сонголт!");
			break;
		}
	}

	public void subMenu(int s) { /* Оюутны дүнгийн мэдээллүүдийн сонголтын функц */

		switch (s) {
		case 1: /* Оюутны дүнгийн дундажийг хэвлэнэ. */
			for (int i = 0; i < studentList.size(); i++) {
				((Student) studentList.get(i)).calculateGPA();
				average_gpa += ((Student) studentList.get(i)).GPA;
			}
			average_gpa /= studentList.size();
			System.out.println("Нийт оюутнуудын дундаж голч: " + average_gpa);
			break;

		case 2: /* Оюутны дүнгийн мэдээлэл нэмнэ. */
			Scanner in = new Scanner(System.in);
			System.out.print("Оюутны код ");
			String code = in.nextLine();
			System.out.print("Хичээлийн код ");
			String subjectCode = in.nextLine();
			System.out.print("Дүн ");
			int point = in.nextInt();
			reg.addStudentInfo(code, subjectCode, point);

			break;

		default: /* Бусад товч дарагдсан үед цэснээс гарна. */
			System.out.println("Үндсэн хэсэг рүү буцлаа.");
			break;
		}
	}

	public void addStudentInfo(String c, String lc, int p) { /* Шинээр оюутны мэдээлэл нэмэх хэсэг */
		Student studentObj = new Student();
		studentObj.code = c;
		int hjndex = 0;

		for (int i = 0; i < subjectList.size(); i++) {
			if (((Subject) subjectList.get(i)).code.equals(lc)) {
				studentObj.lessons = new Chain();
				Lessons lesson = new Lessons((Subject) subjectList.get(i), p);
				studentObj.lessons.add(hjndex, lesson);
			}
		}
		studentList.add(studentList.size(), studentObj); // StudentList-д шинээр оруулсан оюутны мэдээллийг хадгална.

		try {
			FileWriter pw = new FileWriter("C:\\Users\\Admin\\eclipse-workspace\\BiyDaalt\\src\\Exams.txt");
			int count = 0;
			for (int i = 0; i < studentList.size(); i++) {
				String student_code = ((Student) studentList.get(i)).code; // Жагсаалтын i-р оюутны кодыг student_code
																			// хувьсагчид өгнө.
				Student student = ((Student) studentList.get(i)); // Жагсаалтын i-р элементийг Student классын student
																	// обьектод өгнө.
				String subject_code = ((Lessons) student.lessons.get(0)).learned.code; // student обьектын lessons
																						// хувьсагчид хадгалагдсан кодыг
																						// subject_code өгнө.
				float score = ((Lessons) student.lessons.get(0)).score; // lessons хувьсагч дах дүнг score хувьсагчид
																		// өгнө.
				pw.write(student_code + "/" + subject_code + "/" + score + "\n");
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listBySubject() { /* Хичээл бүрийн оюутаны жагсаалт */
		for (int i = 0; i < subjectList.size(); i++) {
			String subject_name = ((Subject) subjectList.get(i)).name;
			System.out.println(i + 1 + ":" + " " + subject_name);
			int count = 1;
			for (int j = 0; j < studentList.size(); j++) {
				Student student = ((Student) studentList.get(j));
				for (int q = 0; q < student.lessons.size(); q++) {
					String subject_code = ((Subject) subjectList.get(i)).code;
					String student_subject_code = ((Lessons) student.lessons.get(q)).learned.code;
					if (subject_code.equals(student_subject_code)) {
						System.out.println("  " + count + "." + student.code);
						count++;
					}
				}
			}
			System.out.println();
		}
	}

	public void listByMajor() { /* Мэргэжлийн оюутнуудын жагсаалт */
		for (int i = 0; i < majorList.size(); i++) {
			String major_name = ((Major) majorList.get(i)).name;
			String major_code = ((Major) majorList.get(i)).code;
			System.out.println(major_name);
			int count = 1;
			for (int j = 0; j < studentList.size(); j++) {
				Student student = ((Student) studentList.get(j));
				if (major_code.equals(student.code.substring(5, 7))) {
					System.out.println("  " + count + "." + student.code);
					count++;
				}
			}
			System.out.println();
		}
	}

	public Scanner input(String filename) { /* Файлыг унших функц */
		try {
			File in = new File(filename);
			Scanner sc = new Scanner(in);
			return sc;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
