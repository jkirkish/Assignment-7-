package com.coderscampus.testDrivenDevelopment;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.coderscampus.testDrivenDevelopment.CustomArrayList;
import com.coderscampus.testDrivenDevelopment.CustomList;

public class CustomArrayListTest {

	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	// private static final String ALPHABET = "abc";
	// sut is system under test
	private CustomList<Character> sut;

	@BeforeEach
	void init_before_every_test() {
		System.out.println("Initiating the arrange of the test");
		sut = new CustomArrayList<>();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";

		for (int i = 0; i < ALPHABET.length(); i++) {
			sut.add(ALPHABET.charAt(i));

		}
	}

	//https://stackoverflow.com/questions/11638123/how-to-add-an-element-to-array-and-shift-indexes
	@Test
	void should_verify_that_all_characters_are_lowercase() {

		// act

		int numberOfLettersInAlphabet = 0;
		for (int i = 0; i < sut.getSize(); i++) {

			if (sut.get(i).equals(ALPHABET.charAt(i))) {
				System.out.print(sut.get(i).equals(ALPHABET.charAt(i)));
				numberOfLettersInAlphabet++;
			}
		}
		Integer actual = numberOfLettersInAlphabet;

		// Assert
		Integer expected = 26;
		assertEquals(expected, actual);
	}

	@Test
	void should_verify_that_one_character_is_added_at_end_of_arraylist() {

		// Act
		boolean actual = false;
		sut.add('0');

		if (sut.get(sut.getSize() - 1).equals('0')) {
			actual = true;
		}

		// Assert
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	void should_verify_that_one_character_is_added_at_middle_of_arraylist() {

		// Act
		boolean actual = false;
		sut.add((sut.getSize() / 2), '*');

		if (sut.get((sut.getSize() - 1) / 2).equals('*')) {
			actual = true;
		}

		// Assert
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	void a_value_should_be_removed_from_the_array_and_size_is_one_less() {

		// act
		Integer beforeRemoval = sut.getSize();
		Character itemRemoved = sut.remove(10);
		Integer afterRemoval = sut.getSize();

		// Assert

		assertEquals(26, beforeRemoval);
		assertEquals('k', itemRemoved);
		assertEquals(25, afterRemoval);

	}

	@SuppressWarnings("deprecation")
	@Test
	void a_value_retrieved_outside_of_the_start_and_end_of_the_arraylist_should_be_an_arraysOutsOfBoundsException() {

		// act
		int i = -5;
		int j = 45;
		while (i < 0) {
			try {
				sut.get(i);

			} catch (IndexOutOfBoundsException e) {
				// Assert
				assertThat(e.getMessage(), is("Index " + i + " out of bounds for length 40"));
				System.out.println(e.getMessage());
			}
			i++;
		}

		// act

		while (j > 40) {
			try {
				sut.get(j);
			} catch (IndexOutOfBoundsException e) {
				// Assert
				assertThat(e.getMessage(), is("Index " + j + " out of bounds for length 40"));
				System.out.println(e.getMessage());
			}
			j--;
		}
	}

	@Test
	void a_given_index_with_actual_value_should_match_the_expected_value() {

		// act
		char[] letters = new char[26];
		int i = 0;

		while (i < (letters.length - 1)) {
			if (sut.get(i) != null)
				letters[i] = sut.get(i);

			i++;
		}
		// assert
		for (int index = 0; index < letters.length - 1; index++) {
			assertEquals(letters[index], sut.get(index));

		}
	}

	@Test
	void the_added_item_with_given_index_should_not_override_the_existing_item_move_array_index_value_over() {
		/*
		 * The issue on the add is that the expected behavior when you add an item on a
		 * given index, it should not override the existing item of the index. It should
		 * be like an insert and not a replace.
		 *
		 * // the char array is what the sut custom array should look like after '1' is
		 * added in index 0
		 * 
		 */
		char[] letters = new char[] { '1', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
				'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

		for (int i = 0; i < sut.getSize(); i++) {
			System.out.print(sut.get(i));

		}
		System.out.println("\n----------------------------------");
		sut.add(0, '1');

		// assert
		for (int index = 0; index < letters.length - 1; index++) {
			assertEquals(letters[index], sut.get(index));

		}
		for (int i = 0; i < sut.getSize(); i++) {
			System.out.print(sut.get(i));
		}
		System.out.println();
	}

	@Test
	void the_removed_item_should_be_removed_on_the_array() {
		/*
		 * On the remove bug, the issue here is after sut.remove(9) was executed, the
		 * value on index 9 should be removed on the array but as you see on the
		 * encircled part of the screenshot, the item/value is still there
		 */

		//the char array letters has all the characters in alphabet except for 'j'
		char[] letters = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

		
		sut.remove(9);// remove j

		for (int i = 0; i < sut.getSize(); i++) {
			assertEquals(letters[i], sut.get(i));
		}

		assertEquals('k', sut.get(9));

	}

}
