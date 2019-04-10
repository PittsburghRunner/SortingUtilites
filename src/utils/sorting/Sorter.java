package utils.sorting;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Date;

/**
 * This utility contains a few methods that can be used to sort numbers.
 *
 * @author christopher.eckles
 */
public class Sorter {
    private boolean debug = false;
    int cycles = 0;
    int calculations = 0;
    int swaps = 0;
    int offset = 0;
    Boolean swapped = true;
    Instant runTimeStart = Instant.now();
    Instant runTimeEnd = Instant.now();

/**
 * This utility sorts a set of integers by placing them in buckets 
 * and then iterating over the bucket
 * @param list a primitive array of ints.
 * @return returns a sorted array
 */
    public int[] bucketSort(int[] list) {
        initializeSorting();
        if (list.length > 1) {
            int[] finished = new int[list.length];
            //create buckets up to largest number
            int[] buckets = new int[maxIntArrayValue(list) + 1];
            //initialize count in each bucket
            for (int i = 0; i < buckets.length; i++){
                buckets[i]=0;
            }
            // cycle through original list and place 
            // each number in its respective bucket
            for (int i = 0; i<list.length; i++){
                buckets[list[i]]++;
            }
            //declare and initialize an set output position to 0
            int outputPosition = 0;
            
            //now that they're all in the buckets
            //put each number back in the correct order.
            for(int eachBucket = 0; eachBucket < buckets.length ; eachBucket++){
                for(int bucketCount = 0; bucketCount<buckets[eachBucket]; bucketCount++ ){
                    finished[outputPosition++] = eachBucket;
                }
            }
            finalizeSorting();
            return finished;
        } //close if
        finalizeSorting();
        return list;
    }//close method

    public int maxIntArrayValue(int[] list) {
        int largest = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > largest) {
                largest = list[i];
            }
        }
        return largest;
    }

    /**
     * Sorts an array of ints in ascending order by bubbling up
     * the larger numbers and iterating over the list until its sorted.
     *
     * @param list a primitive array of ints.
     * @return returns a sorted array
    */
    public int[] bubbleSort(int[] list) {
        initializeSorting();
        int[] result = list.clone();
        while (swapped == true) {
            cycles++;
            swapped = false;
            for (int i = 0; i < result.length - 1 - offset; i++) {
                calculations++;
                int first = result[i];
                int second = result[i + 1];
                if (first > second) {
                    result[i] = second;
                    result[i + 1] = first;
                    swaps++;
                    swapped = true;
                    if (debug) {
                        System.out.println(cycles + ":" + calculations + ":" + swaps + ": Swapping " + second + " for " + first);
                    }
                }
            }
            offset++;
        }
        if (debug) {
            System.out.println("Total Cycles: " + cycles + "  Calculations: " + calculations + "  Swaps: " + swaps);
        }
        finalizeSorting();
        return result;
    }

     /**
     * Sorts an array of ints in ascending order by 
     * splitting the array and half and sorting smallest to 
     * largest the lists are then iterated over until its sorted.
     *
     * @param list a primitive array of ints.
     * @return returns a sorted array
    */
    public int[] mergeSort(int[] list) {
        initializeSorting();
        if (list.length > 1) {
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            finalizeSorting();
            return merge(firstHalf, secondHalf, list);
            //runs "on the folding back up"
        } //close if
        finalizeSorting();
        return list;
    } //close merge sort

    /**
     * Utility for completing merge sort by taking in two int arrays
     * and merging them to a third.
     * @param list1
     * @param list2
     * @param temp
     * @return 
     */
    public int[] merge(int[] list1, int[] list2, int temp[]) {
        initializeSorting();
        int current1 = 0;  //current index in list 1
        int current2 = 0;  //current index in list 2
        int current3 = 0;  //current index in temp list

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2]) {
                temp[current3++] = list1[current1++];
            } else {
                temp[current3++] = list2[current2++];
            }

            while (current1 < list1.length) {
                temp[current3++] = list1[current1++];
            }
            while (current2 < list2.length) {
                temp[current3++] = list2[current2++];
            }

        } //close merge while
        finalizeSorting();
        return temp;
    } //close merge

    /**
     * bubble sorts big integers
     * @param list big integer array to be sorted
     * @return  sorted array
     */
    public BigInteger[] bubbleSort(BigInteger[] list) {
        initializeSorting();
        Boolean swapped = true;
        while (swapped == true) {
            swapped = false;
            for (int i = 0; i < list.length - 1; i++) {
                BigInteger first = list[i];
                BigInteger second = list[i + 1];
                if (first.compareTo(second) > 0) {
                    list[i] = second;
                    list[i + 1] = first;
                    swapped = true;
                }
            }
        }
        finalizeSorting();
        return list;
    }

    
     /**
     * bubble sorts any comparable
     * @param list big integer array to be sorted
     * @return  sorted array
     */
    public Object[] bubbleSort(Comparable[] list) {
        initializeSorting();
        while (swapped == true) {
            cycles++;
            swapped = false;
            for (int i = 0; i < list.length - 1; i++) {
                calculations++;
                Comparable first = list[i];
                Comparable second = list[i + 1];
                if (first.compareTo(second) > 0) {
                    list[i] = second;
                    list[i + 1] = first;
                    swaps++;
                    swapped = true;

                    if (debug) {
                        System.out.println(cycles + ":" + calculations + ":" + swaps + ": Swapping " + second + " for " + first);
                    }
                }
            }
        }
        if (debug) {
            System.out.println("Total Cycles: " + cycles + "  Calculations: " + calculations + "  Swaps: " + swaps);
        }
        finalizeSorting();
        return list;
    }
    
    /** starts the sorting process by zeroing out values and setting the start date
     * 
     */
    private void initializeSorting(){
    cycles = 0;
    calculations = 0;
    swaps = 0;
    offset = 0;
    swapped = true;
    runTimeStart = Instant.now();
    }
    
    /** finishes the sorting process by setting the end date
     * 
     */ 
    private void finalizeSorting(){
    runTimeEnd = Instant.now();
    }

    public int getCycles() {
        return cycles;
    }

    public int getCalculations() {
        return calculations;
    }

    public int getSwaps() {
        return swaps;
    }

    public int getOffset() {
        return offset;
    }

    public Boolean getSwapped() {
        return swapped;
    }

    /**
     * returns runtime of last sorted 
     * @return 
     */
    public Long[] getRunTime() {
        Long[] runTime = new Long[2];
        runTime[0] = runTimeStart.toEpochMilli();
        runTime[1] = runTimeEnd.toEpochMilli();
        return runTime;
    }

    

    
    
    
}
