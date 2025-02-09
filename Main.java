// Quick sort in Java
package com.company;

import java.util.Arrays;
import java.util.Random;

class Quicksort {

    // method to find the partition position
    static int partition(int array[], int low, int high) {

        // choose the rightmost element as pivot
        int pivot = array[high];

        // pointer for greater element
        int i = (low - 1);

        // traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {

                // if element smaller than pivot is found
                // swap it with the greatr element pointed by i
                i++;

                // swapping element at i with element at j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }

        // swapt the pivot element with the greater element specified by i
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // return the position from where partition is done
        return (i + 1);
    }

    static void quickSort(int array[], int low, int high) {
        if (low < high) {

            // find pivot element such that
            // elements smaller than pivot are on the left
            // elements greater than pivot are on the right
            int pi = partition(array, low, high);

            // recursive call on the left of pivot
            quickSort(array, low, pi - 1);

            // recursive call on the right of pivot
            quickSort(array, pi + 1, high);
        }
    }
}

// Main class
class Main {
    public static void main(String args[]) {
        System.out.println("algo");
        int[] data = new int[1000000];
        long start, stop;
        double diff;

        int n = data.length;

        Random rand = new Random();
        for (int i=0; i<n; i++)
            data[i] = rand.nextInt(1000000);

        //System.out.println("Unsorted Array");
        //System.out.println(Arrays.toString(data));

        // call quicksort() on array data
        start = System.currentTimeMillis();
        Quicksort.quickSort(data, 0, n - 1);
        stop = System.currentTimeMillis();

        diff = ((double)(stop-start)/1000);

        System.out.println("Tiempo: " + diff);

        //System.out.println("Sorted Array in Ascending Order: ");
        //System.out.println(Arrays.toString(data));
    }
}
