package com.coderscampus.lesson1;

public class CustomArrayList<T> implements CustomList<T> {
	
	Object[]items = new Object[10];
	int itemCounter = 0;
	
	
	@Override
	public boolean add(T item) {
		add(itemCounter, item);

		return true;
	}
	@Override
	public boolean add(int index, Object item) throws IndexOutOfBoundsException {
		if (itemCounter == items.length) {
			items = growArray();
		}
		for(int i = itemCounter-1; i>index; i--) {
			items[i+1] = items[i];
		}
		items[index] = item;
		itemCounter++;
		return true;
	}
	@Override
	public int getSize() {
		return itemCounter;
	}
	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		// cast the arraylist you want to return to T
		return (T) items[index];
	}
	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		
		T removedItem = (T) items[index];
		
		int i = index;
		while(i<(itemCounter-1))
			{
			   items[i]=items[i+1];
			   i++;
			  
			}
		 itemCounter--;
		return removedItem;
	}
	private Object[] growArray() {

		Object[] backingArray = new Object[items.length * 2];
		int counter = 0;
		while (counter < items.length) {
			backingArray[counter] = items[counter];
			counter++;
		}
		return backingArray;

	}
}

