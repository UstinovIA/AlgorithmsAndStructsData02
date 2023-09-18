import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for(int i=0; i<array.length; i++) {
            array[i] = random.nextInt(-100, 101);
        }
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    static void buildHeap(int[] arr) {
        for(int i=arr.length/2; i>=0; i--) {
            maxHeap(arr, i, arr.length);
        }
    }

    static void maxHeap(int[] arr, int i, int length) {
        int largest = i;
        int left = i*2+1;
        int right = i*2+2;
        if(left < length && arr[largest] < arr[left]) {
            largest = left;
        }
        if(right < length && arr[largest] < arr[right]) {
            largest = right;
        }
        if(largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            maxHeap(arr, largest, length);
        }
    }

    static void sort(int[] arr) {
        buildHeap(arr);
        int length = arr.length-1;
        while (length>0) {
            int temp = arr[0];
            arr[0] = arr[length];
            arr[length] = temp;
            maxHeap(arr, 0, length--);
        }
    }
}