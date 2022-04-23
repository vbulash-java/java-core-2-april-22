package ru.bulash.exceptions;

public class MyArrayDataException extends NumberFormatException {
	private int row;
	private int column;

	public MyArrayDataException(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}
	@Override
	public String getMessage() {
		return String.format("Невозможно преобразование ячейки [%d][%d] массива в число", this.row, this.column);
	}
}
