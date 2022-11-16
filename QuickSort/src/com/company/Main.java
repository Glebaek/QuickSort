package com.company;


import java.util.Random;

public class Main {


    private static void swap(int[] array, int left, int right){

        int temp = 0;
        temp = array[left];
        array[left] = array[right];
        array[right] = temp;

    }


    private static int part(int[] array, int low, int high) {

        int pivotInd = new Random().nextInt(high - low) + low;
        int pivot = array[pivotInd];
        swap(array, pivotInd, high);
        int left = low;
        int right = high;

        while (left < right) {

            while ((array[left] < pivot) && (left < right)) {
                left++;
            }

            while ((array[right] >= pivot) && (right > left)) {
                right--;
            }

            swap(array, left, right);
        }
        swap(array, left ,high);

        return left;
    }


    private static void quickSort(int[] array, int low, int high) {

        if (low < high) {
            int pivot = part(array, low, high);
                quickSort(array, low, pivot - 1);
                quickSort(array, pivot + 1, high);
        }
    }


    private static void printArr(int[] array){

        System.out.println(" ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");

        System.out.println(" ");
    }


    private static int[] bubbleSort(int[] array){

        for (int i = 0; i < array.length; i++){
            for (int j = i; j < array.length; j++){

                if (array[i] > array[j])
                    swap(array, i, j);

            }
        }

        return array;
    }


    public static void main(String[] args) {

        Random rand = new Random();
        int[] array = new int [10000];

        for (int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(10000);
        }

        System.out.print("Initial array:");
        printArr(array);


        long startTime = System.nanoTime();

        quickSort(array,0, array.length - 1);
        //bubbleSort(array);
        long elapsedTime = System.nanoTime() - startTime;

        System.out.print("Sorted array:");
        printArr(array);

        System.out.println(" ");
        System.out.print((double)elapsedTime/1000000000 + " seconds");
    }
}
