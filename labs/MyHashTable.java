package labs;

import java.util.*;

import dataStructures.HashTable;

public class MyHashTable extends HashTable {

	public MyHashTable(int theDivisor) {
		super(theDivisor);
		// TODO Auto-generated constructor stub
	}
	
  	public Object updateElement(Object theKey, Object theNewElement) {
  		Object elementToUpdate = this.get(theKey);
  		if(elementToUpdate != null) {
  			this.delete(theKey);
  			this.put(theKey, theNewElement);
  		}
  		return elementToUpdate;
	}
  	
  	public Object updateKey(Object theKey, Object theNewKey) {
		Object elementToUpdate = this.get(theKey);
		if(elementToUpdate != null ) {			
			this.delete(theKey);
			this.put(theNewKey, elementToUpdate);
		}
		return elementToUpdate;
	}
	
	public Object delete(Object theKey) {
		Object elementToDelete = this.get(theKey);
		if(elementToDelete != null) {
			this.put(theKey, null);
			this.size--;
		}
		return elementToDelete;
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashTable myhash = new MyHashTable(10);
		
		myhash.put("if", "нөхцөл шалгах");
		myhash.put("for", "параметрт давталт");
		myhash.put("class", "класс");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("=============== MENU ================");
		System.out.println("isEmpty\nsize\nget\nput\noutput\nexit\n\n");
		System.out.println("updateElement\nupdateKey\ndelete");
		System.out.println("=====================================");
		for(;;) {
			System.out.print("\n***Enter command: ");
			String songolt = sc.next();
			
			switch(songolt) {
			case "isEmpty": {System.out.println("is empty >>> " + myhash.isEmpty()); break;}
			case "size": {System.out.println("size >>> " + myhash.size()); break;}
			case "get": {
				System.out.print("Enter key: "); 
				String myhash_key = sc.next();
				if(myhash.get(myhash_key) != null)
					System.out.println("Key>>> " + myhash_key + "\tElement>>> " + myhash.get(myhash_key));
				else
					System.out.println("There is no element with such key.");
				break;
			}
			case "put": {				
				System.out.print("Enter key: "); 
				String myhash_key = sc.next(); 
				
				System.out.print("Enter element: ");
				String myhash_element = sc.next(); 
				try {
					myhash.put(myhash_key, myhash_element);
				} 
				catch(Exception e) {System.out.println("Error!!!");}
				break;
			}
			case "output": {myhash.output();break;}
			
			case "updateElement": {
				System.out.print("Enter key: "); 
				String myhash_key = sc.next(); 
				
				System.out.print("Enter element: ");
				String myhash_element = sc.next(); 
				Object e = myhash.updateElement(myhash_key, myhash_element);
				if(e != null) 
					System.out.println(myhash_key + " түлхүүртэй элементийг солилоо");
				else
					System.out.println("Сольж чадсангүй");
				break;
			}
			
 			case "updateKey": {	
 				System.out.print("Enter key: "); 
				String myhash_key = sc.next(); 
				
				System.out.print("Enter theNewKey: ");
				String myhash_theNewKey = sc.next(); 
				if(myhash.get(myhash_theNewKey) == null) {
					Object e = myhash.updateKey(myhash_key, myhash_theNewKey);
					if(e != null) 
						System.out.println(myhash_key + " түлхүүрийг " + myhash_theNewKey + " болголоо");
					else
						System.out.println("Сольж чадсангүй");
				}else
					System.out.println("Таны оруулсан түлхүүр байна");
				break;
			}
			
			case "delete": {			
				System.out.print("Enter key:");
				String myhash_key = sc.next();
				Object e = myhash.delete(myhash_key);
				if(e != null) 
					System.out.println(myhash_key + " түлхүүртэй элементийг устгалаа");
				else
					System.out.println("Таны оруулсан элемент байхгүй байна");
				break;
			}
			
			case "exit": {System.exit(0); sc.close(); break;}
			default: {System.out.println("Your command is wrong! Enter another command.");break;}
			}
		}		
	}

}
