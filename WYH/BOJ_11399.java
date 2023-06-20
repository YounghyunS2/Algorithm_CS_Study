import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11399 {
    public static void main(String[] args) {
        // N명의 사람이 줄을 서있음
        // 1~N i번 사람이 돈 인출 하는데 걸리는 시간 Pi
        // 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // i번째 사람의 걸리는 시간 => 누적합
        // 순열 (순서 상관 있음)

        // 전체 사람의 시간 => 누적합의 누적합

        int[] arr = new int[N]; // 순서대로 걸리는 시간

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }



//        System.out.print(Arrays.toString(time));
        int ans = perm(arr,0,N,N);
        System.out.print(ans);



    }


    static int perm(int[] arr, int depth, int n, int r){

        int[] time = new int[n]; // 각 사람의 시간 (누적합)
        int minTime = Integer.MAX_VALUE;
        int total = 0;
        if(depth==r){
//            System.out.print(Arrays.toString(arr));
                time[0] = arr[0];
            for(int i=1;i<n;i++){
                for(int j=i;j>=0;j--){
                    time[i] += arr[j];
                }
            }
//          System.out.print(Arrays.toString(time));
            for(int i=0;i<n;i++){
                total += time[i];
            }
//                System.out.println(total);
                if(total<minTime){
                    minTime = total;
                }

            return minTime;
        }

        for (int i=depth;i<n;i++){
            swap(arr,depth,i);
            perm(arr,depth+1,n,r);
            swap(arr,depth,i);
        }
        return 0;
    }

    static void swap(int[] arr, int depth, int i){
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
