package com.coderscampus.testDrivenDevelopment;

public class ArrayListChecking {

	public static final String ALPHABET1 = "abcdefghij";
	public static CustomList<Character> sut = new CustomArrayList<>();

	public static Object[] items = new Object[10];
	public static int itemCounter = 0;
	
	public static void main(String[] args) {
		
	    
		filltheList();
		showArray();
		System.out.println("");
		showArray();
		
		
		
	}
	

	private static void showArray() {
		for (int i = 0; i < sut.getSize(); i++) {
            System.out.print(sut.get(i));
            
            
           
		}
	}
	
	

	private static void filltheList() {
		for (int i = 0; i < ALPHABET1.length(); i++) {
			sut.add(ALPHABET1.charAt(i));
            
		}
	}
	

}
