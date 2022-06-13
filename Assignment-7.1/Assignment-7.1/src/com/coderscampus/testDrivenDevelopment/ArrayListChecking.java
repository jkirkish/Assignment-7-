package com.coderscampus.testDrivenDevelopment;

public class ArrayListChecking {

	private static final String ALPHABET = "abcdefghij";
	private static CustomList<Character> sut = new CustomArrayList<>();
	
	
	public static void main(String[] args) {
		
	    
		filltheList();
		showArray();
		sut.remove(9);
		System.out.println("");
		showArray();
		
		
		
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
