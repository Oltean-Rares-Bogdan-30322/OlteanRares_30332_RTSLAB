import java.util.Random;

public class Ex3 {
    public static void main(String[] args) {
        Random random = new Random();
        int array[]=new int[10];
        for(int i=0;i<10;i++){
            int randomNumber = random.nextInt();
            array[i]=randomNumber;
        }
        printarr(array);
        
        Bsort(array);

        printarr(array);
    }
    public static void Bsort(int[] arr){
        int n= arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void printarr(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
