/**
 * Assignment #3:
 * Use What you learned in session 8 to implement the following:
 * Method that returns the minimum value of integer array
 * Method that returns the maximum value of integer array
 * Method that returns the average of integer array values (make the return type return double)
 * Method that returns sorted array of passed array of integers (method accept array of integers
 * and return sorted one without modifying the passed one)
 */

import java.util.Arrays;

public class Assignment3 {

    public static void main(String[] args) {
        int[] test = { 2, 12, 5, 2, 3, -3, -1};

        System.out.println("Test array " + Arrays.toString(test));

        System.out.println("Min = " + minArray(test));
        System.out.println("Max = " + maxArray(test));
        System.out.println("Avg = " + avgArray(test));

        System.out.println("Sorted array" + Arrays.toString(sortArray(test)));
    }

    public static int minArray(int[] arr) {
        if(arr == null || arr.length < 1) {
            throw new IllegalArgumentException("passed array is null or empty");
        }

        int min = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int maxArray(int[] arr) {
        if(arr == null || arr.length < 1) {
            throw new IllegalArgumentException("passed array is null or empty");
        }

        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static double avgArray(int[] arr) {
        if(arr == null || arr.length < 1) {
            throw new IllegalArgumentException("passed array is null or empty");
        }
        double sum = 0;
        for(int item : arr) {
            sum += item;
        }
        return sum / arr.length;
    }

    public static int[] sortArray(int[] arr) {
        if(arr == null || arr.length < 1) {
            throw new IllegalArgumentException("passed array is null or empty");
        }

        int[] result = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < result.length; i++) {
            for (int j = i + 1; j < result.length; j++) {
                int tmp;
                if (result[i] > result[j]) {
                    tmp = result[i];
                    result[i] = result[j];
                    result[j] = tmp;
                }
            }
        }

        return result;
    }

}
