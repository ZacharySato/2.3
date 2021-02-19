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
        int[] test4 = new int[]{33, 12, 25, 17, 78, 66, 7};
        System.out.println(Arrays.toString(test4));
        sort(test4, 0, test4.length - 1);
        System.out.println(Arrays.toString(test4));
        //--------------------------------------------------------------
    }


    public static void sort(int[] array, int start, int stop) {
        int section = stop - start + 1; //с учетом нуля
        if (section < 2)
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
        //(исправление) для повторяющихся значений
        if(stepRight==0)
            return;

        for (int i = start; i <= stop; i++)
            array[i] = storage[i];
        //(исправление) сортируем относительно положения среднего
        sort(array, start, start + stepLeft - 1);
        sort(array, start + stepLeft, stop);
    }

}
