//http://a2oj.com/Submission.jsp?ID=68963


package countinginv;
import java.util.Scanner;

public class CountingInv {
    
    public static long mergeSort(int[] arr, int length) {
        int temp[];
        temp = arr.clone();
        return mergeSortImpl(arr, temp, 0, arr.length-1);

    }

    public static long mergeSortImpl(int[] arr, int[] tmp, int left, int right) {
        int mid;
        long count = 0;
        if (right > left) {
            mid = (right+left) / 2;

            count = mergeSortImpl(arr, tmp, left, mid);
            count = count + mergeSortImpl(arr, tmp, mid+1, right);
            count = count + countInversions(arr, tmp, left, mid+1, right);
        }
        return count;
    }

    public static long countInversions(int arr[], int tmp[], int left, int mid, int right) {
        int i = left, j = mid, k = left;
        long Invcount = 0;

        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j])
                tmp[k++] = arr[i++];
            else {
                tmp[k++] = arr[j++];
                Invcount = Invcount + (mid-i);
            }
        }
        while (i <= mid - 1) 
            tmp[k++] = arr[i++];
        while (j <= right) 
            tmp[k++] = arr[j++];
        for (i = left; i <= right; i++) 
            arr[i] = tmp[i];  

        return Invcount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        long [] finalC = new long [T];

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int arr[] = new int[N];
            for (int j = 0; j < N; j++) 
                arr[j] = scanner.nextInt();
            finalC[i] = mergeSort(arr, arr.length);
        }
        for(int i=0; i<T; i++) System.out.println(finalC[i]);
    }
}
