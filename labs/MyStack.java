package labs;
import java.util.*;
import java.util.EmptyStackException;
import dataStructures.*;


public class MyStack extends DerivedArrayStack {
	
	// БайгуулагЧ
	public MyStack(int initialCapacity) {
		super(initialCapacity);
	}
	public MyStack() {
		this(10);
	}
	
	// МетоД
	public boolean empty() {
		return isEmpty();
	}
	public Object peek() {
		return get(size() - 1);
	}
	public void push (Object theElements) {
		add(size(), theElements);
	}
	public Object pop() {
		return remove(size() - 1);
	}
	public MyStack random() {
		MyStack buffer = new MyStack();
		ArrayLinearList arr = new ArrayLinearList(10);
//		int index = 0;
		while (! this.empty()) {
			Object pop = this.pop();
			arr.add(arr.size(), pop);
//			  index = index + 1;
		}
//		System.out.println("arr: " + arr.toString());
//        System.out.println("stack " + this.toString());
        Random rn = new Random();
        while (!arr.isEmpty()) {
        	int answer = rn.nextInt(arr.size());
//    		System.out.println(answer);
        	buffer.push(arr.remove(answer));
        }
//        System.out.println("arr: " + arr.toString());
//        System.out.println("stack " + buffer.toString());
		return buffer;
	}
	public MyStack unique() {
		MyStack buffer = new MyStack();
		ArrayLinearList arr = new ArrayLinearList(10);
//		System.out.println("this " + this.toString());
		while (! this.empty()) {
			Object pop = this.pop();
			int index = arr.indexOf(pop);
			if (index > -1) {
				arr.remove(index);
			}
			arr.add(arr.size(), pop);
		}
//		System.out.println("arr: " + arr.toString());
//        System.out.println("stack " + temp.toString());
        while (!arr.isEmpty()) {
        	buffer.push(arr.remove(arr.size() - 1));
        }
//        System.out.println("arr: " + arr.toString());
//        System.out.println("stack " + buffer.toString());
        return buffer;
	}
	public MyStack addRange (int[] elements) {
		for (int i = 0; i < elements.length; i++) {
			this.push(elements[i]);
		}
		return this;
	}

	public static void main(String[] args) {
		MyStack rstack1 = new MyStack();
		rstack1.push(new Integer(1));
		rstack1.push(new Integer(2));
		rstack1.push(new Integer(3));
		rstack1.push(new Integer(4));
		rstack1.push(new Integer(5));
		rstack1.push(new Integer(6));
		System.out.println("Random function");
		System.out.println("stack1: " + rstack1);
		MyStack rstack2 = rstack1.random();
		System.out.println("stack2: " + rstack2);
		MyStack ustack1 = new MyStack();
		ustack1.push(new Integer(1));
		ustack1.push(new Integer(2));
		ustack1.push(new Integer(2));
		ustack1.push(new Integer(3));
		ustack1.push(new Integer(4));
		ustack1.push(new Integer(1));
		System.out.println("Unique function");
		System.out.println("stack1: " + ustack1);
		MyStack ustack2 = ustack1.unique();
		System.out.println("stack2: " + ustack2);
		MyStack astack1= new MyStack();
		astack1.push(new Integer(1));
		astack1.push(new Integer(2));
		astack1.push(new Integer(3));
		astack1.push(new Integer(4));
		astack1.push(new Integer(5));
		astack1.push(new Integer(6));
		System.out.println("AddRange function");
		System.out.println("stack1: " + astack1);
		int [] range = {11, 12, 13};
		MyStack astack2 = astack1.addRange(range);
		System.out.println("stack2: " + astack2);
		
	}
}