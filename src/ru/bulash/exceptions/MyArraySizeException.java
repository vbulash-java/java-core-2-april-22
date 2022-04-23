package ru.bulash.exceptions;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
	@Override
	public String getMessage() {
		return "Размеры массива превышают 4 на 4";
	}
}
