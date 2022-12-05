package app;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //печать массива
    public static void printNumArray(int[] inputArray) {
        System.out.print("{");
        for (int i=0; i<inputArray.length-1; i++) {
            System.out.print(inputArray[i]+ ", ");
        }
        System.out.println(inputArray[inputArray.length-1] + "}");
    }

    //метод, возвращающий массив четных чисел из исходного
    public static int[] getEvenArray (int[] inputArray) {
        ArrayList<Integer> evenArrayList = new ArrayList<Integer>(inputArray.length);

        //формируем список четных чисел
        for (int i=0; i<inputArray.length; i++) {
            if (inputArray[i] % 2 == 0) {
                evenArrayList.add(inputArray[i]);
            }
        }
       //формируем возвращаемый массив из списка четных чисел
        int[] evenArray = new int[evenArrayList.size()];
        for (int i=0; i<evenArrayList.size(); i++) {
            evenArray[i] = evenArrayList.get(i);
        }
        return evenArray;
    }
    //метод, возвращающий массив неповторяющихся чисел из исходного
    public static int[] getNonRepeatedArray (int[] inputArray)  {
        ArrayList<Integer> nonRepeatedArrayList = new ArrayList<Integer>(inputArray.length);

        //добавляем в список только уникальные элементы
        for (int i=0; i<inputArray.length; i++)  {
            if (!nonRepeatedArrayList.contains(inputArray[i]))  {
                nonRepeatedArrayList.add(inputArray[i]);
            }
        }
        //формируем возвращаемый массив из списка уникальных чисел
        int[] nonRepeatedArray = new int[nonRepeatedArrayList.size()];
        for (int i=0; i<nonRepeatedArrayList.size(); i++) {
            nonRepeatedArray[i] = nonRepeatedArrayList.get(i);
        }
        return nonRepeatedArray;
    }
    public static void main(String[] args) {
        System.out.println("Введите массив целых чисел:1");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine() + ", ";
        in.close();

        Pattern p = Pattern.compile("[0-9]+(?=[, ])");
        Matcher m = p.matcher(input);

        ArrayList<Integer> inputArrayList = new ArrayList<Integer>();
        int i = 0;
        while (m.find()) {
            i++;
            inputArrayList.add (Integer.parseInt(m.group()));
        }

        int[] inputArray = new int[inputArrayList.size()];
        for(i=0; i<inputArrayList.size(); i++)  {
            inputArray[i] = inputArrayList.get(i);
        }
        int[] evenArray = new int[0];
        int[] nonRepeatedArray = new int[0];

        System.out.print("Исходный массив: ");
        printNumArray(inputArray);

        evenArray = getEvenArray(inputArray);
        System.out.print("Массив четных элементов: ");
        printNumArray(evenArray);

        nonRepeatedArray = getNonRepeatedArray(inputArray);
        System.out.print("Массив неповторяющихся элементов: ");
        printNumArray(nonRepeatedArray);
    }
}