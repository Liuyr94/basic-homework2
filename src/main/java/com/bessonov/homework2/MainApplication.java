package com.bessonov.homework2;

import java.util.Arrays;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {

        int num = 12;
        MainApplication.printSpecifiedNumberTimes("Java", num);

        int[] arr1 = new int[3];
        int[] arr2 = new int[4];
        int[] arr3 = new int[6];

        sumElementsGreaterThanFive(arrayRandom(arr1));

        fillingArray(arrayRandom(arr1), num);

        incrementElementArray(arrayRandom(arr1), num);

        sumElementsHalf(arrayRandom(arr1));

        arrayIncomingSumm(arrayRandom(arr1), arrayRandom(arr2), arrayRandom(arr3));

        dotArray(new int[]{7, 2, 2, 2});

        Scanner scanner = new Scanner(System.in);
        System.out.println("Если вы хотите проверить идут ли все элементы массива в возрастающей последовательности " + "то введите - 1.\nЕсли вы хотите проверить идут ли все элементы массива в убывающей " + "последовательности" + " " + "то нажмите - 2.\nЕсли вы хотите выйти нажмите любую другой символ или их набор.");
        String userSelection = scanner.nextLine();
        int[] arr = {1, 2, 3, 4, 5};
        while (true) {
            if (userSelection.equals("1")) {
                arrayElements(new int[]{1, 2, 3, 4, 5}, userSelection);
                break;
            } else if (userSelection.equals("2")) {
                arrayElements(new int[]{1, 2, 3, 4, 5}, userSelection);
                break;
            } else {
                break;
            }
        }

        reverseArray(arr);
    }

    /**
     * Заполняет массив случайными числами от 0 до 10
     *
     * @param array
     * @return
     */
    private static int[] arrayRandom(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 11);
        }
        return array;
    }

    /**
     * Печатает строку count раз
     */
    private static void printSpecifiedNumberTimes(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    /**
     * принимает в качестве аргумента целочисленный массив, суммирует все элементы, значение которых больше 5, и
     * печатает полученную сумму в консоль
     */
    private static void sumElementsGreaterThanFive(int[] list) {
        int result = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > 5) {
                result += list[i];
            }
        }
        System.out.println("Сумма всех элементов массива привышающие 5: \n" + result);
    }

    /**
     * Метод, принимает в качестве аргументов целое число и ссылку на целочисленный
     * массив, метод заполняет каждую ячейку массива указанным числом
     */
    private static void fillingArray(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            array[i] = number;
        }
        System.out.println("Заполнили весь массив числом = " + number + ": \n" + Arrays.toString(array));
    }

    /**
     * Метод, принимает в качестве аргументов целое число и ссылку на целочисленный
     * массив, увеличивающий каждый элемент массива на указанное число
     */
    private static void incrementElementArray(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            array[i] += number;
        }
        System.out.println("Увеличили каждый элемент массива на число = " + number + ": \n" + Arrays.toString(array));
    }

    /**
     * Метод, принимает в качестве аргумента целочисленный массив, и печатаеет в
     * консоль информацию о том, сумма элементов какой из половин массива больше
     */
    private static void sumElementsHalf(int[] array) {
        int leftHalf = 0;
        int rightHalf = 0;
        for (int i = 0; i < array.length / 2; i++) {
            leftHalf += array[i];
        }

        for (int j = array.length / 2; j < array.length; j++) {
            rightHalf += array[j];
        }

        if (leftHalf > rightHalf) {
            System.out.println("Левая половина больше правой. Левая =  " + leftHalf + " Правая равна = " + rightHalf);
        } else if (leftHalf < rightHalf) {
            System.out.println("Правая половина больше левой. Левая =  " + leftHalf + " Правая равна = " + rightHalf);
        } else {
            System.out.println("Половины равны. Левая =  " + leftHalf + " Правая равна = " + rightHalf);
        }
    }

    /**
     * Метод, принимает на вход набор целочисленных массивов, и получает новый
     * массив равный сумме входящих
     */
    private static void arrayIncomingSumm(int[]... array) {
        //Переменная для хранения длины самого длинного массива из нашего массива
        int length = 0;

        //Циклы для определения самого длинного массива в нашем массиве
        for (int[] ints : array) {
            length = ints.length;
            System.out.println(Arrays.toString(ints));
            for (int j = 1; j < array.length; j++) {
                if (length < array[j].length) {
                    length = array[j].length;
                }
            }
        }

        //Присваем длину самого длинного массива нашему массиву который будем потом выводить в консоль
        int[] sumArray = new int[length];

        //Сумируем элементы из наших массивов в результирующий
        for (int[] ints : array) {
            for (int j = 0; j < ints.length; j++) {
                sumArray[j] += ints[j];
            }
        }

        //Выводим в консоль результат работы метода
        System.out.println(Arrays.toString(sumArray));
    }

    /**
     * Метод, проверяет что есть “точка” в массиве, в которой сумма левой и правой части
     * равны. “Точка находится между элементами”
     */
    private static void dotArray(int[] array) {
        int sum = 0;
        int dot;
        String result = "В массиве нету точки в корой лева часть равно правой";
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            dot = 0;
            for (int j = i + 1; j < array.length; j++) {
                dot += array[j];
            }
            if (sum == dot) {
                result = "Точка в массиве, в которой сумма левой и правой части равны мне жду собой = array[" + i + "]";
                break;
            }
        }
        System.out.println(result);
    }

    /**
     * Реализуйте метод, проверяющий что все элементы массива идут в порядке убывания или
     * возрастания (по выбору пользователя)
     */
    private static void arrayElements(int[] array, String order) {
        String result = null;
        if (order.equals("1")) {
            for (int i = 1; i < array.length; i++) {
                if (array[i] <= array[i - 1]) {
                    result = "Все элементы массива идут в поряде убывания";
                } else {
                    result = "Элементы массива не идут в порядке убывания";
                    break;
                }
            }
            System.out.println(result);
        } else if (order.equals("2")) {
            for (int i = 1; i < array.length; i++) {
                if (array[i] >= array[i - 1]) {
                    result = "Все элементы массива идут в порядке возростания";
                } else {
                    result = "Элементы массива не идут в порядке возростания";
                    break;
                }
            }
            System.out.println(result);
        } else {
            result = "Вы не хотите ничего проверять. До свидания";
            System.out.println(result);
        }
    }

    /**
     * Метод, “переворачивающий” входящий массив.
     */
    private static void reverseArray(int[] array) {
        int count = array[0];
        for (int i = 0; i < array.length / 2; i++) {
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = count;
            count = array[i + 1];
        }
        System.out.println("Перевернутый массив = " + Arrays.toString(array));
    }
}