package com.axhiao.aer.others;

import java.util.Random;

public class Bfprt {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int randomized_partition(int[] arr, int p, int r) {
        Random rand = new Random(133);
        swap(arr, rand.nextInt(r-p+1)+p, r);
        return partition(arr, p, r);
    }

    public static int partition(int[] arr, int p, int r) {
        /**
        * |----------|----------|---------------|
        *     <=           >          unvisited
        */
        if (p > r)
            throw new RuntimeException(String.format("p=%d cannot be greater than r=%d", p, r));
        // here it can handle the case of p == r
        int i = p, j = p - 1;
        while (++j < r) {
            if (arr[j] <= arr[r]) {
                swap(arr, i++, j);
            }
        }
        swap(arr, i, r);
        return i;
    }

    public static void qsort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            qsort(arr, p, q -1);
            qsort(arr, q+1, r);
        }
    }

    public static int select(int[] arr, int begin, int end, int i) {
        /**
         * return i(not i-th) smallest element in the array
         */
        if (begin == end) {
            return arr[begin];
        }
        int pivotValue = getMedianOfMedians(arr, begin, end);
        int[] range = partition(arr, begin, end, pivotValue);
        if (range[0] <= i && range[1] >= i) {
            return arr[i];
        } else if (range[0] > i) {
            return select(arr, begin, range[0]-1, i);
        } else {
            return select(arr, range[1]+1, end, i);
        }
    }

    public static int[] getMinKNumsByBFPRT(int[] arr, int k) {
        if (k < 1 || k > arr.length)
            return arr;
        int minKth = getMinKthByBFPRT(arr, k);
        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minKth) {
                res[index++] = arr[i];
            }
        }
        for(; index < res.length; index++) {
            res[index] = minKth;
        }
        return res;
    }

    public static int getMinKthByBFPRT(int[] arr, int K) {
        int[] copyArr = copy(arr);
        return select(copyArr, 0, copyArr.length - 1, K - 1);
    }

    public static int[] copy(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static int getMedianOfMedians(int[] arr, int begin, int end) {
        int num = end - begin + 1;
        int oneMore = num % 5 == 0 ? 0 : 1;
        int[] mArr = new int[num / 5 + oneMore];
        for (int i = 0; i < mArr.length; i++) {
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mArr[i] = getMedian(arr, beginI, endI);
        }
        // median of medians
        return select(mArr, 0, mArr.length - 1, mArr.length/2);
    }

    public static int[] partition(int[] arr, int begin, int end, int pivotValue) {
        /**
         * |--------|----------|-------------|
         *     <=     unvisited      >
         */
        int small = begin - 1;
        int big = end + 1;
        int curr = begin;

        while (curr < big) {
            if (arr[curr] < pivotValue) {
                swap(arr, ++small, curr++);
            } else if (arr[curr] > pivotValue) {
                swap(arr, curr, --big);
            } else {
                curr++;
            }
        }
        int[] range = new int[2];
        range[0] = small + 1;
        range[1] = big - 1;
        return range;
    }

    public static int getMedian(int[] arr, int begin, int end) {
        int sum = begin + end;
        int m = (sum>>1) + (sum&1);
        insertSort(arr, begin, end);
        return arr[m];
    }
    public static void insertSort(int[] arr, int begin, int end) {
        // [begin, end], both inclusive
        for (int i = begin + 1; i < end + 1; i++) {
            for (int j = i; j > begin; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {


        int[] arr = new int[]{9, 3, 5, 3, 8, 2, 3};
//        insertSort(arr, 0, arr.length-1);
        int[] range = partition(arr, 0, arr.length-1, 3);
        System.out.println(range[0] + ", " + range[1]);
////        int k = partition(arr, 0, arr.length-1);
////        System.out.println(k);
//        qsort(arr, 0, arr.length - 1 );
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

}
