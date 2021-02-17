package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //--------------------------------------------------------------
        int[] test = new int[]{97, 25, 42, 90, 71, 16, 82, 39, 36, 74};
        System.out.println(Arrays.toString(test));
        sort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
        //--------------------------------------------------------------
        int[] test2 = new int[]{7, 4, 6, 0, 3, 8};
        System.out.println(Arrays.toString(test2));
        sort(test2, 0, test2.length - 1);
        System.out.println(Arrays.toString(test2));
        //--------------------------------------------------------------
        int[] test3 = new int[]{7};
        System.out.println(Arrays.toString(test3));
        sort(test3, 0, test3.length - 1);
        System.out.println(Arrays.toString(test3));
        //--------------------------------------------------------------
        int[] test4 = new int[]{3, 4, 2, 4, 1, 5};
        System.out.println(Arrays.toString(test4));
        sort(test4, 0, test4.length - 1);
        System.out.println(Arrays.toString(test4));
        //--------------------------------------------------------------
    }


    public static void sort(int[] array, int start, int stop) {
        int section = stop - start + 1; //с учетом нуля
        if (section / 2 == 0)
            return;
        int[] storage = Arrays.copyOf(array, array.length);
        //находим среднее входящего
        int sum = 0;
        int average;
        for (int i = start; i <= stop; i++)
            sum += array[i];
        average = sum / section;
        //расставляем элементы относительного среднего, с концов к середине массива
        int stepRight = 0;
        int stepLeft = 0;
        for (int i = start; i <= stop; i++) {
            if (array[i] <= average) {
                storage[start + stepLeft] = array[i];
                stepLeft++;
            } else {
                storage[stop - stepRight] = array[i];
                stepRight++;
            }
        }
        //сортируем по половинам результат
        for (int i = start; i <= stop; i++)
            array[i] = storage[i];
        int part = start + (section - 1) / 2;
        sort(array, start, part); //левая половина
        sort(array, part + 1, stop); //правая

    }

}
