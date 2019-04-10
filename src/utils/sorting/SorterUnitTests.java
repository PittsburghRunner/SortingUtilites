/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.sorting;

import utils.sorting.Sorter;

/**
 *
 * @author christopher.eckles
 */
public class SorterUnitTests {

    public static boolean runTest() {
        boolean testPassed = true;
        Sorter sorter = new Sorter();
        //unit test 1 -- bubble sort
//        int[] given1 = new int[]{10, 6, 4, 1};
//        int[] expected1 = new int[]{1, 4, 6, 10};
//        int[] result1 = sorter.bubbleSort(given1);
//
//        if (result1.length == expected1.length) {
//            for (int i = 0; i < result1.length; i++) {
//                System.out.println(given1[i] + " " + expected1[i]);
//
//                if (given1[i] != expected1[i]) {
//                    System.out.println("test 1 failed");
//                    return false;
//                }
//            }
//        } else {
//            System.out.println("test 1 failed");
//            return false;
//        }

        //unit test 2 -- bubble sort
//        int[] given2 = new int[]{6, 4, 1, 7, 3, 2};
//        int[] expected2 = new int[]{1, 2, 3, 4, 6, 7};
//        int[] result2 = sorter.bubbleSort(given2);
//
//        if (result2.length == expected2.length) {
//            for (int i = 0; i < result2.length; i++) {
//                System.out.println(given2[i] + " " + expected2[i]);
//                if (given2[i] != expected2[i]) {
//                    System.out.println("test 2 failed on item");
//                    return false;
//                }
//            }
//        } else {
//            System.out.println("test 2 failed on length");
//            return false;
//        }

        //unit test 3 -- bucket sort
        int[] given3 = new int[]{10, 6, 4, 1};
        int[] expected3 = new int[]{1, 4, 6, 10};
        int[] result3 = sorter.bucketSort(given3);

        if (result3.length == expected3.length) {
            for (int i = 0; i < result3.length; i++) {
                if (given3[i] != expected3[i]) {
                    System.out.println("test 3 failed");
                    return false;
                }
            }
        } else {
            System.out.println("test 3 failed");
            return false;
        }

        //unit test 4 -- bucket sort
        int[] given4 = new int[]{6, 4, 1, 7, 3, 2};
        int[] expected4 = new int[]{1, 2, 3, 4, 5, 6};
        int[] result4 = sorter.bucketSort(given4);
        
        if (result4.length == expected4.length) {
            for (int i = 0; i < result4.length; i++) {
                if (given4[i] != expected4[i]) {
                    System.out.println("test 4 failed");
                    return false;
                }
            }
        } else {
            System.out.println("test 4 failed");
            return false;
        }

        return testPassed;
    }

}
