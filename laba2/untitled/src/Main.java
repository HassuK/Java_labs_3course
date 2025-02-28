import java.util.Scanner;
import java.util.Arrays;
import java.lang.String;

public class Main {
    //Лабораторная работа №2
    static Scanner in = new Scanner(System.in);

    static String TaskOne(String str) {
        System.out.print("\n1. Найти наибольшую подстроку без повторяющихся символов. ");
        String max_subline = "";
        boolean flag = true;
        int last_index = 0;

        while (flag) {
            String current_line = "";
            for (int i = last_index; i < str.length(); i++) {
                if (current_line.contains(String.valueOf(str.charAt(i)))) {
                    if (max_subline.length() < current_line.length()) {
                        max_subline = current_line;
                    }
                    last_index++;
                    break;
                }
                else {
                    current_line += str.charAt(i);
                    if (i == str.length() - 1) {
                        if (max_subline.length() < current_line.length()) {
                            max_subline = current_line;
                        }
                        flag = false;
                    }
                }
            }
        }
        return "\nОтвет: " + max_subline;
    }

    static int[] TaskTwo(int[] array1, int[] array2) {
        System.out.print("\n2. Объединить два отсортированных массива. ");
        int[] array = new int[array1.length + array2.length];

        for(int i = 0; i < array1.length; i++) {
            array[i] = array1[i];
        }

        for(int j = array1.length; j < array.length; j++) {
            array[j] = array2[j - array1.length];
        }

        Arrays.sort(array);
        System.out.print("\nОтвет: ");
        return array;
    }

    static int TaskThree(int[] array3) {
        System.out.print("\n3.  Найти максимальную сумму подмассива. ");
        int max_sum = Integer.MIN_VALUE;
        int current_sum = 0;

        for (int num : array3) {
            current_sum += num;

            if (current_sum > max_sum) {
                max_sum = current_sum;
            }

            if (current_sum < 0) {
                current_sum = 0;
            }
        }
        System.out.print("\nОтвет: ");
        return max_sum;
    }

    static int[][] TaskFour(int[][] array)
    {
        System.out.print("\n4. Задача: Повернуть массив на 90 градусов по часовой стрелке.");
        int rows = array.length;
        int columns = array[0].length;
        int[][] transpose = new int[columns][rows];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < columns; j++) {
                transpose[j][rows - i - 1] = array[i][j];
            }
        }
        return transpose;
    }

    static int[] TaskFive(int[] array, int target) {
        System.out.print("\n5. Найти пару элементов в массиве, сумма которых равна заданному числу. \nОтвет: ");
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length; j++)
                if (i != j)
                    if (array[i] + array[j] == target) {
                        return new int[]{array[i], array[j]};
                    }
        return null;
    }

    static int TaskSix(int[][] array) {
        System.out.print("\n6. Найти сумму всех элементов в двумерном массиве. \nОтвет: ");
        int sum = 0;
        for (int[] line: array)
            for (int element : line)
                sum += element;
        return sum;
    }

    static int[] TaskSeven(int[][] array) {
        System.out.print("\n7. Найти максимальный элемент в каждой строке двумерного массива. ");
        int[] answer = new int[array.length];
        for (int line = 0; line < array.length; line++) {
            int max_element = Integer.MIN_VALUE;
            for (int el = 0; el < array[line].length; el++)
                if (max_element < array[line][el])
                    max_element = array[line][el];
            answer[line] = max_element;
        }
        System.out.print("\nОтвет: ");
        return answer;
    }

    static int[][] TaskEight(int[][] array) {
        System.out.println("\n8. Повернуть двумерный массив на 90 градусов против часовой стрелке. \nОтвет: \n");
        int rows = array.length;
        int collumns = array[0].length;
        int[][] answer = new int[collumns][rows];
        for (int i = 0; i < rows; i++)
            for (int j = collumns - 1; j >= 0; j--)
                answer[collumns - j - 1][i] = array[i][j];
        return answer;
    }

    public static void main(String[] args)
    {
        // задание 1
        System.out.println(TaskOne("popippopopipo"));
        // задание 2
        int[] array1 = {10, 1, 3, 7, 1};
        int[] array2 = {2, 0, 14, 0, 4};
        System.out.println(Arrays.toString(TaskTwo(array1, array2)));
        // задание 3 : Напишите метод, который принимает массив целых чисел и возвращает максимальную сумму подмассива (последовательных элементов)
        int[] array3 = {1, 3, 8, -2, 6, -8, 5};
        System.out.println(TaskThree(array3));
        // задание 4
        int[][] array4 = {
                {3, 6, 9, 12},
                {2, 5, 8, 11},
                {1, 4, 7, 10}};
        int[][] array = TaskFour(array4);
        System.out.print("\nОтвет: \n");
        for (int[] rows : array) {
            for (int element : rows) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        // задание 5
        int[] array5 = {11, 2, 612, 8, 3};
        int target = 13;
        System.out.println(Arrays.toString(TaskFive(array5, target)));
        // задание 6
        int[][] array6 = {
                {1, 1, 1, 1, 1},
                {9, 8, 7, 6, 5}};
        System.out.println(TaskSix(array6));
        // задание 7
        System.out.println(Arrays.toString(TaskSeven(array4)));
        // задание 8
        int[][] answer = TaskEight(array4);
        for (int[] rows : answer) {
            for (int element : rows) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
