package labs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import dataStructures.Chain;
import dataStructures.ChainNode;

public class MyChain extends Chain {

    static MyChain mychain = new MyChain();

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        mychain.add(0, 100);
        mychain.add(1, 10);
        mychain.add(2, 88);
        mychain.add(3, 99);
        mychain.add(4, 50);

        Object[] obj = { 20, 31, 40 };

        MyChain secChain = new MyChain();
        secChain.add(0, 10);
        secChain.add(1, 10);
        secChain.add(2, 20);
        secChain.add(3, 30);
        secChain.add(4, 40);
        secChain.add(5, 50);

        System.out.println("Команд:");
        System.out.println("\t1 toArray\n\t2 addRange\n\t3 union\n\t4 intersection\n\t5 exit");

        while (true) {
            System.out.println("Сонголт:");
            String songolt = sc.next();
            switch (songolt) {
                case "1":
                    System.out.println("Массив болгон хэвлэвэл.");
                    Object[] temp = mychain.toArray();
                    for (int i = 0; i < temp.length; i++) {
                        System.out.println(temp[i]);
                    }
                    break;
                case "2":
                    System.out.println("");
                    mychain.addRange(obj);
                    System.out.println(mychain.toString());
                    break;
                case "3":
                    System.out.println("Утга давхцаагүй нийлбэр");
                    System.out.println(mychain.union(secChain).toString());
                    break;
                case "4":
                    System.out.println("Огтолцол");
                    System.out.println(mychain.intersection(secChain).toString());
                    break;
                case "5":
                    System.out.println("Амжилттай хаалаа.");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Тодорхойгүй команд. Дахин оруулна уу.");
                    break;
            }
        }
        
    }

    // Rest of your methods...
    // Implement the toArray method
    public Object[] toArray() {
        Object[] newArray = new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            newArray[i] = this.get(i);
        }
        return newArray;
    }

    // Implement the addRange method
    public void addRange(Object[] elements) {
        for (int i = 0; i < elements.length; i++) {
            this.add(size, elements[i]);
        }
    }

    public boolean contains(Object element) {
        ChainNode current = firstNode;
        while (current != null) {
            if (element == null) {
                if (current.element == null) {
                    return true;
                }
            } else {
                if (element.equals(current.element)) {
                    return true;
                }
            }
            current = current.next;
        }
        return false;
    }

    // Implement the union method
    public MyChain union(MyChain chain) {
        MyChain uchain = new MyChain();
        for (int i = 0; i < this.size(); i++) {
            Object element = this.get(i);
            if (!uchain.contains(element)) {
                uchain.add(uchain.size, element);
            }
        }
        for (int i = 0; i < chain.size(); i++) {
            Object element = chain.get(i);
            if (!uchain.contains(element)) {
                uchain.add(uchain.size, element);
            }
        }
        return uchain;
    }

    // Implement the intersection method
    public MyChain intersection(MyChain chain) {
        MyChain ichain = new MyChain();
        for (int i = 0; i < this.size(); i++) {
            Object element = this.get(i);
            if (chain.contains(element) && !ichain.contains(element)) {
                ichain.add(ichain.size, element);
            }
        }
        return ichain;
    }

}
