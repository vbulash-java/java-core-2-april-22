import ru.bulash.exceptions.MyArrayDataException;
import ru.bulash.exceptions.MyArraySizeException;

import static java.lang.Integer.parseInt;

/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
MyArrayDataException, и вывести результат расчета.
 */

public class Main {
	public static void checkSize(String[][] arr) {
		if (arr.length > 4 || arr[0].length > 4) throw new MyArraySizeException();
	}

	public static int sumCells(String[][] arr) {
		int result = 0;
		int irow = 0;
		int icolumn = 0;
		for (String[] row : arr) {
			for (String cell : row) {
				try {
					result += parseInt(cell);
				} catch (NumberFormatException e) {
					throw new MyArrayDataException(irow, icolumn);
				}
				icolumn++;
			}
			irow++;
			icolumn = 0;
		}
		return result;
	}

	public static void main(String[] args) {
		String[][] arr = {
				{"0", "1", "2", "3"},
				{"4", "5", "6", "7"},
				{"8", "9aaa", "10", "11"},
				//{"8", "9", "10", "11"},
				{"12", "13", "14", "15"},
				//{"16", "17", "18", "19"},
		};

		try {
			checkSize(arr);
			System.out.println("Проверка размерности массива - успешно");
			System.out.printf("Суммирование ячеек массива - результат = %d\n", sumCells(arr));
		} catch (MyArraySizeException | MyArrayDataException e) {
			System.out.printf("Перехвачено исключение: %s", e.getMessage());
		}
	}
}