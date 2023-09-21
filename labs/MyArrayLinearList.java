package labs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

	public class MyArrayLinearList {
	    private List<Integer> list;

	    public MyArrayLinearList() {
	        list = new ArrayList<>();
	    }

	   //Жагсаалтад элемент нэмнэ
	    public void add(int value) {
	        list.add(value);
	    }

	    // Хамгийн их утгыг олно
	    public int max() {
	        if (list.isEmpty()) {
	            throw new IllegalStateException("List is empty");
	        }
	        return Collections.max(list);
	    }

	    // Хамгийн бага утгыг олно
	    public int min() {
	        if (list.isEmpty()) {
	            throw new IllegalStateException("List is empty");
	        }
	        return Collections.min(list);
	    }

	    // Нийлбэр
	    public int sum() {
	        int sum = 0;
	        for (int num : list) {
	            sum += num;
	        }
	        return sum;
	    }

	    // Дундаж утгыг олох
	    public double average() {
	        if (list.isEmpty()) {
	            throw new IllegalStateException("List is empty");
	        }
	        return (double) sum() / list.size();
	    }

	    // Сондгой тоог нь ялгах
	    public void removeOdd() {
	        list.removeIf(num -> num % 2 != 0);
	    }

	    // Өсөх дарааллаар нь эрэмбэлэх
	    public void sort() {
	        Collections.sort(list);
	    }
	    //Жагсаалт доторх давхардсан өгөгдлүүдийг устгаж буцаана.
	    public MyArrayLinearList unique() {
	        MyArrayLinearList uniqueList = new MyArrayLinearList();
	        Set<Integer> uniqueSet = new HashSet<>(list);
	        uniqueList.list.addAll(uniqueSet);
	        return uniqueList;
	    }
	    // Жагсаалтын өгөгдлүүдийн байрлалыг урвуулж буцаана
	    public MyArrayLinearList reverse() {
	        MyArrayLinearList reversedList = new MyArrayLinearList();
	        List<Integer> tempList = new ArrayList<>(list);
	        Collections.reverse(tempList);
	        reversedList.list.addAll(tempList);
	        return reversedList;
	    }
	    
	    // Жагсаалтын өгөгдлүүдийн байрлалыг санамсаргүйгээр хольж буцаана
	    public MyArrayLinearList rand() {
	        MyArrayLinearList randomizedList = new MyArrayLinearList();
	        List<Integer> tempList = new ArrayList<>(list);
	        Collections.shuffle(tempList, new Random());
	        randomizedList.list.addAll(tempList);
	        return randomizedList;
	    }

	    // Жагсаалтын ард өгөгдсөн жагсаалтыг залгаж буцаана
	    public MyArrayLinearList merge(MyArrayLinearList arrayList) {
	        MyArrayLinearList mergedList = new MyArrayLinearList();
	        mergedList.list.addAll(this.list);
	        mergedList.list.addAll(arrayList.list);
	        return mergedList;
	    }

	    public List<Integer> getList() {
	        return list;
	    }

	    public void printList() {
	        System.out.println(list);
	    }

	    public static void main(String[] args) {
	        MyArrayLinearList myList = addFromUserInput(); // Use this method to add values from user input

	        System.out.println("Original list:");
	        myList.printList();

	        System.out.println("Hamgiin ih utga: " + myList.max());
	        System.out.println("Hamgiin baga: " + myList.min());
	        System.out.println("Elementuudin niilber: " + myList.sum());
	        System.out.println("Dundaj utga: " + myList.average());

	        myList.removeOdd();
	        System.out.println("Sondgoi toog hassanii daraa:");
	        myList.printList();

	        myList.sort();
	        System.out.println("Usuh daraallaar erembelsen ni:");
	        myList.printList();

	        MyArrayLinearList uniqueList = myList.unique();
	        System.out.println("Dawhardsan ugugdul ustgasan:");
	        uniqueList.printList();

	        MyArrayLinearList reversedList = myList.reverse();
	        System.out.println("Reverse hiisen List:");
	        reversedList.printList();

	        MyArrayLinearList randomizedList = myList.rand();
	        System.out.println("Random List:");
	        randomizedList.printList();

	        // No need to call addFromUserInput() again here

	        MyArrayLinearList anotherList = new MyArrayLinearList();
	        anotherList.addFromUserInput(); // Use this method to add values from user input

	        MyArrayLinearList mergedList = myList.merge(anotherList);
	        System.out.println("Ugugdsun jagsaaltig zalgj butsaana:");
	        mergedList.printList();
	    }

	    // Add elements from user input
	    public static MyArrayLinearList addFromUserInput() {
	        Scanner scanner = new Scanner(System.in);
	        MyArrayLinearList myList = new MyArrayLinearList();

	        System.out.println("Жагсаалтад нэмэх бүхэл тоог оруулна уу (зогсохын тулд '0'-г оруулна уу):");
	        while (true) {
	            int value = scanner.nextInt();
	            if (value == 0) {
	                break;
	            }
	            myList.add(value);
	        }

	        // Don't close the scanner here
	        return myList;
	    }
	}