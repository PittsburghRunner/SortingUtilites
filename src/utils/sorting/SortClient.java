/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Class to test the SortUtility
 *
 * @author christopher.eckles
 */
public class SortClient {

    public static final int TEST_SIZE = 10000;

    public static void main(String[] args) {
        boolean debug = false;
        int[] bucketSortTimes = new int[TEST_SIZE];
        int[] bubbleSortTimes = new int[TEST_SIZE];
    //   int[] mergeSortTimes = new int[TEST_SIZE];

        
        Sorter su;

        su = new Sorter();
        for (int i = 0; i < TEST_SIZE; i++) {
            int[] array = getRandomArray(1000);
            int[] result;
            
            if(debug)System.out.println("\n\n\n\n\n ");
            if(i %100 == 0)System.out.println("Position " + i );
            if(debug)System.out.println(" Array to process: ");
            if(debug)printArray(array);
            
            result = su.bubbleSort(array);
            bubbleSortTimes[i] = (int)(su.getRunTimes()[1] - su.getRunTimes()[0]);
            if(debug)System.out.println("Time to process: " + bubbleSortTimes[i]);
            if(debug) System.out.println("Bubble Sorted ");
            if(debug)printArray(result);
            
            if(debug)System.out.println("Array to process: ");
            if(debug)printArray(array);

            result = su.bucketSort(array);
            bucketSortTimes[i] = (int)(su.getRunTimes()[1] - su.getRunTimes()[0]);
            if(debug)System.out.println("Time to process: " + bucketSortTimes[i]);
            if(debug)System.out.println("Bucket Sorted ");
            if(debug)printArray(result);
            
//            System.out.println("Array to process: ");
//            printArray(array);
//            
//            result = su.mergeSort(array);
//            mergeSortTimes[i] = (int)(su.getRunTime()[1] - su.getRunTime()[0]);
//            if(debug)System.out.println("Time to process: " + mergeSortTimes[i]);
//            if(debug)System.out.println("Merge Sorted ");
//            if(debug)printArray(result);
            

        }

        
        System.out.println("Bucket Sort Average: " + findAverageUsingStream(bucketSortTimes));
        System.out.println("Bubble Sort Average: " + findAverageUsingStream(bubbleSortTimes));
//        System.out.println("Merge Sort Average: " + findAverageUsingStream(mergeSortTimes));


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

    public static double findAverageUsingStream(int[] array) {
        return Arrays.stream(array).average().orElse(Double.NaN);
    }

}
