package com.coderscampus.testDrivenDevelopment;

public class ArrayListChecking {

	private static final String ALPHABET = "abcdefgh";
	private static CustomList<Character> sut = new CustomArrayList<>();
	
	
	public static void main(String[] args) {
		
	   
       filltheList();
       showArray();
       System.out.println("\n---------");
	   sut.add(3,'x');
	   sut.add(4,'x');
	   sut.add(5,'x');
	   showArray();
       System.out.println("\n---------");
	   sut.remove(3);
	   sut.remove(4);
	   sut.remove(5);
	   sut.remove(3);
	   showArray();
       System.out.println("\n---------");
		
		
		
	}
	

	private static void showArray() {
		for (int i = 0; i < sut.getSize(); i++) {
            System.out.print(sut.get(i));
           
		}
	}
     

	private static void filltheList() {
		for (int i = 0; i < ALPHABET.length(); i++) {
			sut.add(ALPHABET.charAt(i));
            
		}
	}
	

}
