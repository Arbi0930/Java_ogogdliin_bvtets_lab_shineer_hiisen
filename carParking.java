import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dataStructures.ArrayLinearList;
import dataStructures.ArrayStack;

public class carParking implements Runnable{

	public static carParking parking;
	public static ArrayStack stack;
	public Scanner input;
	public ArrayLinearList out;
	
	public carParking() {
		stack = new ArrayStack();
		out = new ArrayLinearList();
	}
	
	public static void main(String[] args) throws InterruptedException {
		parking = new carParking();
		parking.input();
		parking.process();
		parking.output();
	}
	public void input() {
		try {
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Biy daalt 2\\cars.txt");
			input = new Scanner(file);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void process() {
		int garageSize = 1, availableSize = 0;
		if(input != null) {
			String line;
			while(input.hasNextLine()) {
				line = input.nextLine();
				String values[] = line.split(" ");
				if(values[0].equals("A")) {
					if(garageSize <= 10) {
						stack.push(new Car(values[1]));
						availableSize = 10 - garageSize;
						out.add(out.size(), values[1]+" car entered.Available Space "+availableSize);
						garageSize++;
					}else {
						out.add(out.size(), "Garage is full");
					}
				}else {
					int i = 0; 
					boolean checkCar = false;
					ArrayStack stack2 = new ArrayStack();
					
					while(!stack.empty()) {
						if(((Car)stack.peek()).number.equals(values[1])) {
							stack.pop();
							checkCar = true;
							out.add(out.size(), i+" car moved out " + "("+values[1]+").Available Space:"+availableSize);
							while(!stack2.empty()) {
								stack.push(stack2.pop());
							}
							garageSize--;
							break;
						}else {
							stack2.push(stack.pop());
							i++;
						}
					}
					
					if(!checkCar) {
						while(!stack2.empty()) {
							stack.push(stack2.pop());
						}
						out.add(out.size(), "This car is not in garage. "+"("+values[1]+")");
					}
				}
			}input.close();
		}
	}
	
	public void output() {
		for(int i = 0; i < out.size(); i++) {
			System.out.println(out.get(i));
			System.out.println();
		}
		
		while(!stack.empty()) {
			System.out.println(stack.peek());
			stack.pop();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
