import java.util.Arrays;
import java.util.Scanner;

public class MergeSortedArrays {
    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length)
            result[k++] = arr1[i] <= arr2[j] ? arr1[i++] : arr2[j++];
        while (i < arr1.length) result[k++] = arr1[i++];
        while (j < arr2.length) result[k++] = arr2[j++];
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size of arr1: ");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) { System.out.print("arr1[" + i + "]: "); arr1[i] = sc.nextInt(); }
        System.out.print("Size of arr2: ");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) { System.out.print("arr2[" + i + "]: "); arr2[i] = sc.nextInt(); }
        System.out.println(Arrays.toString(mergeSortedArrays(arr1, arr2)));
        sc.close();
    }
}
