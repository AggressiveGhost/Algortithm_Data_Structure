package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    static int[] size = {
            60000,
            120000,
            180000,
            240000,
            300000,
            360000
    };

    public static int getMax(String[] ascii){
        String max = ascii[0];
        for (int i=1; i<ascii.length; i++){
            if(max.length() < ascii[i].length()){
                max = ascii[i];
            }else if(max.length() == ascii[i].length() && Character.getNumericValue(max.charAt(0))
                    < Character.getNumericValue(ascii[i].charAt(0))) {
                max = ascii[i];
            }
        }
        return Integer.parseInt(max);
    }

    public static void countSort(String[] list, int n, int exp){
        int output[] = new int[n];
        int count[] = new int[36];
        Arrays.fill(count, 0);

        for (int i=0; i<list.length; i++)
            count[ (Integer.parseInt(list[i])/exp)%100 ]++;

        for (int i=1; i<count.length; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[ (Integer.parseInt(list[i])/exp)%100 ] - 1] = Integer.parseInt(list[i]);
            count[ (Integer.parseInt(list[i])/exp)%100 ]--;
        }

        for (int i = 0; i < n; i++)
            list[i] = String.valueOf(output[i]);
    }

    static void stringRadix(String[] list ,String[] ascii, int n){
        int m  = getMax(ascii);

        for (int exp = 1; m/exp > 0; exp *= 100){
            countSort(ascii, n , exp);
        }

        for (String s: ascii){
            System.out.printf(s + " ");
        }
        System.out.println();

        int i = 0, j = 2;
        for (int x = 0; x<ascii.length; x++){
            String word = "";
            while (j<=ascii[x].length()){
                int acsiiFinal = Integer.parseInt(ascii[x].substring(i, j)) + 87;
                word += (char)acsiiFinal;
                i+=2;j+=2;
            }i=0;j=2;
            list[x] = word;
        }
    }

    public static int[] fillArray(int n){
        Random random = new Random();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = random.nextInt(1000);
        }
        return arr;
    }

    public static int  sortT(int[] arr, int n){
        Sort sort = new Sort();
        long startTime = System.currentTimeMillis();
        switch (n){
            case 1:
                sort.MergeSort(arr, 0, arr.length-1);
                break;
            case 2:
                sort.BubbleSort(arr);
                break;
            case 3:
                sort.QuickSort(arr, 0, arr.length - 1);
                break;
            case 4:
                sort.HeapSort(arr);
                break;
            case 5:
                sort.RadixSort(arr, arr.length);
                break;
            default:
                System.out.println("wow");
                break;
        }
        long endTime  = System.currentTimeMillis();

        return Math.toIntExact(endTime - startTime);
    }

    public static void main(String[] args) {
        Sort sort = new Sort();

        //2 task

//        int j = 0;
//        String[] list = {"adb", "ab", "pqrs", "f", "fxp", "bcd", "sr", "w", "b", "abcf", "zzzz"};
//        String[] ascii = new String[list.length];
//        Arrays.fill(ascii, "");
//
//        for (String s: list){
//            for (int i = 0 ; i<s.length(); i++){ ascii[j] += Character.getNumericValue(s.charAt(i)); }
//            j++;
//        }
//
//        for (String s:list){
//            System.out.printf(s + " ");
//        }
//        System.out.println();
//        for (String s:ascii){
//            System.out.printf(s + " ");
//        }
//        System.out.println();
//
//        stringRadix(list ,ascii, list.length);
//        for (String s:list){
//            System.out.printf(s + " ");
//        }

//         */



        //3 task

        System.out.println("Array size | Merge | Bubble | Quick | Heap | Radix ");
        for (int i = 0; i<size.length; i++){
            int [] arr = fillArray(size[i]);
            System.out.printf(size[i] + "\t\t  ");
            for (int j = 1; j<=5; j++){
                int [] a = arr.clone();
                long x = System.currentTimeMillis();
                sortT(a, j);
                long y = System.currentTimeMillis();
                System.out.printf(y-x + "\t\t");
            }

            System.out.println();
        }



    }
}
