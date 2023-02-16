//Задача № 2. Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class HomeWork003 {
    private static File log;
    private static FileWriter fileWriter;

    public static void main(String[] args) {
        try {
            log = new File("log.txt"); // Создание файла txt для записи
            log.createNewFile();
            fileWriter = new FileWriter(log);
            int[] sortArr = { 33, 66, 1, -10, -3, 8 }; // Создание списка, для выполнения сортировки. Здесь можно менять
                                                       // элементы
            bubbleSort(sortArr); // Вызов метода сортировки
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void bubbleSort(int[] sortArr) { // Сортировка ПУЗЫРЬКОМ
        for (int i = 0; i < sortArr.length - 1; i++) { // Внешний цикл
            for (int j = 0; j < sortArr.length - i - 1; j++) { // Внутренний цикл
                if (sortArr[j + 1] < sortArr[j]) { // Проверка элементов для смены их позиций
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
            writeLog(Arrays.toString(sortArr));
        }
    }

    public static void writeLog(String note) {

        try (FileWriter writer = new FileWriter("log.txt")) {
            fileWriter.write(note + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}