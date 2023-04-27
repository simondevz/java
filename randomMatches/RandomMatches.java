import java.util.*;
import java.util.Arrays;

public class RandomMatches {
    static int[] arrayGenerator(int N) {
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            double j = Math.random();
            if (j < 0.1) {
                i--; 
                continue;
            }
            double k = j * 1e6;
            arr[i] = (int) k;
        }
        
        return arr;
    }
    
    static boolean search(int[] arr, int key, int N) {
        int lo = 0;
        int hi = arr.length;
        int mid = (lo + hi)/2;
        
        boolean bool = false;
        while (mid != lo) {
            if(arr[hi-1] == key || arr[lo] == key) {
                bool = true;
                break;
            }
            
            if (arr[mid] == key) {
                bool = true;
                break;
            }
            
            if (arr[mid] > key) lo = mid;
            if (arr[mid] < key) hi = mid;
            
            mid = (lo + hi)/2;
        } 
        
        return bool; 
    }
    
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        int[] Num = {(int) 1e3, (int) 1e4, (int)1e5, (int) 1e6};
        
        System.out.printf("%10s|%10s\n", "N", "Average repetitions in " + T + " tries.");
        for (int N : Num) {
            int[] arr3 = new int[T];
            for (int j = 0; j < T; j++) {
                int[] arr1 = arrayGenerator(N);
                int[] arr2 = arrayGenerator(N);
                Arrays.sort(arr1);
                
                int reocurrence = 0;
                for (int i = 0; i < arr2.length; i++) {
                    if (search(arr1, arr2[i], arr1.length)) reocurrence++;
                }
                
                arr3[j] = reocurrence;
            }
            
            int sum = 0;
            for (int k = 0; k < arr3.length; k++) {
                sum += arr3[k];
            }
            double average = (double) (sum/2);
            System.out.printf("%10s|%10s\n", N, average);
        }
    }
}