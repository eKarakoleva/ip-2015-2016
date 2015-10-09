package org.elsysbg.ip.java;

public class ClassExample {

	public static void main(String[] args) {
		// navigate cursor to Room(), press Ctrl+2 L
		// to create local variable automatically
		// press Ctrl+2 F to create class field
		// create object of type Room
		// final means that reference 'room' can't be changed
		// to other object
		final Room room = new Room();
		// compile error, because of final keyword:
		// room = new Room();
	}

}
