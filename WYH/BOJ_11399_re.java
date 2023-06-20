import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11399_re {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int[] time = new int[N];

        for(int i=0;i<N;i++){
            for(int j=i;j>=0;j--){
                time[i] += arr[j];
            }
        }
        int total = 0;
        for(int i=0;i<N;i++){
            total += time[i];
        }

        System.out.print(total);
    }
}
