package com.coderscampus.lesson1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomArrayListTest {

	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	// sut is system under test
	private CustomList<Character> sut;

	@BeforeEach
	void init_before_every_test() {
		System.out.println("Initiating the arrange of the test");
		sut = new CustomArrayList<>();
		// String alphabet = "abcdefghijklmnopqrstuvwxyz";

		for (int i = 0; i < ALPHABET.length(); i++) {
			sut.add(ALPHABET.charAt(i));

		}
	}

	@Test
	void should_verify_that_all_characters_are_lowercase() {

		// act

		int numberOfLettersInAlphabet = 0;

		for (int i = 0; i < sut.getSize(); i++) {

			if (sut.get(i).equals(ALPHABET.charAt(i))) {
				System.out.println(sut.get(i).equals(ALPHABET.charAt(i)));
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

}

