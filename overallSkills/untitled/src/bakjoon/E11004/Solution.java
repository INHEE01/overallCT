package bakjoon.E11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void quickSort(int[] arr, int s, int e, int k) {
        if(s < e) {
            int pivot = partition(arr, s, e);
            if(pivot == k) {
                return;
            } else if(k < pivot) {
                quickSort(arr, s, pivot-1, k);
            } else {
                quickSort(arr, pivot+1, e, k);
            }
        }
    }

    public static int partition(int[] a, int s, int e) {
        if(s+1 == e) {
            return e;
        }

        int m = (s+e)/2;
        swap(a, s, m);
        int pivot = a[s];
        int i = s + 1, j=e;
        while(i <= j) {
            while(j >= s+1 && pivot < a[j]) {
               j--;
            }
            while(i <= e && pivot > a[i]) {
                i++;
            }
            if(i <= j) {
                swap(a, i++, j--);
            }
        }

        a[s] = a[j];
        a[j] = pivot;
        return j;
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
