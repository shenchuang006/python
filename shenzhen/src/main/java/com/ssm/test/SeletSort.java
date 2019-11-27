package com.ssm.test;

public class SeletSort {
    public static void main(String[] args) {
        int a[] = { 2, 3, 6, 4, 0, 1, 7, 8, 5, 9 };
        //seletSort(a);
        System.err.println(">---real----<");
        seletSortReal(a);
    }

    public static void toString(int[] a) {
    	StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            //System.out.println(a[i]);
            sb.append(a[i]+",");
        }
        System.err.println(sb.toString());
    }
    
    
    //int a[] = { 2, 3, 6, 4, 0, 1, 7, 8, 5, 9 };
    private static void seletSort(int[] a) {
        int length = a.length;
        int temp = 0;
        for (int j = 0; j <length- 1;j++) {
            for (int i = j; i < length- 1; i++) {
                if (a[j] > a[i + 1]) {
                    // change
                    temp = a[j];
                    a[j] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
        toString(a);
    }
    
    // int a[] = { 2, 3, 6, 4, 0, 1, 7, 8, 5, 9 };
    private static void seletSortReal(int[] a) {
        int length = a.length;
        int temp = 0;
        int minIndex;
        for (int j = 0; j <length- 1;j++) {
            minIndex = j;
            for (int i = j; i < length- 1; i++) {
                if (a[minIndex] > a[i + 1]) {
                    minIndex = i+1;
                }
            }
            System.err.println(minIndex);
            temp = a[minIndex];
            a[minIndex]= a[j];
            a[j]=temp;
            toString(a);
        }
        toString(a);
    }
}
