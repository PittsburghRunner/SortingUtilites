/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.sorting;

import java.util.Random;

/**
 * Class to test the SortUtility
 *
 * @author christopher.eckles
 */
public class SortClient {

    public static final int TEST_SIZE = 10000;

    public static void main(String[] args) {
        Long[] times = new Long[TEST_SIZE];

        //       SorterUnitTests.runTest();
//           callMyself(10);
//        System.out.println("Creating a new sort utility");
        Sorter su;
//
//        System.out.println("Turning on debugging");
//        su.setDebug(true);
//
//        System.out.println("FIRST TEST......");
//
        su = new Sorter();

        for (int i = 0; i < TEST_SIZE; i++) {
            int[] array1 = getRandomArray(100);
            int[] result1 = su.bucketSort(array1);
            //printArray(array1);
            //printArray(result1);
            Long time = su.getRunTime()[1] - su.getRunTime()[0];
            System.out.println("Time to process: " + time);
            times[i] = time;

        }

//        for (int i = 0; i < TEST_SIZE; i++) {
//            int[] array1 = getRandomArray(10000);
//            int[] result1 = su.bubbleSort(array1);
//            Long time = su.getRunTime()[1] - su.getRunTime()[0];
//            System.out.println("Time to process: " + time);
//            times[i] = time;
//
//        }

    }

    public static void printArray(int[] array) {
        System.out.print("Printing Array:   ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ((array.length - 1) == i ? "\n\n\n" : ", "));
        }
    }

    public static void printArray(Object[] array) {
        System.out.print("Printing Array:   ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].toString() + ((array.length - 1) == i ? "\n\n\n" : ", "));
        }
    }

    public static int[] getRandomArray(int size) {

        if (size > 0) {
            int[] randomArray = new int[size];
            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                randomArray[i] = rand.nextInt(100000000);//& Integer.MAX_VALUE;
                //may change this to next(int)
            }
            return randomArray;
        }
        return new int[0];
    }

}
