package com.axel.chapter1.learn.binary_search;

import com.axel.algs4.base.In;
import com.axel.algs4.base.StdIn;
import com.axel.algs4.base.StdOut;

import java.util.Arrays;

/**
 * Created by ChenAxel on 2017/11/13.
 */
public class BinarySearch {

    public static int search(int key, int[] array) {

        int length = array.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (key < array[mid]) {
                right = mid - 1;
            } else if (key > array[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (search(key, whitelist) < 0) {
                StdOut.println(key);
            }
        }
    }
}
