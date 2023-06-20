import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11047 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        for(int i=0;i<N;i++){
            coin[i] = Integer.parseInt(br.readLine());
        }


        // 각 코인들의 최소 개수로 K 만들기

        int num = 0; // 개수
            int i = N-1;
        while(i >= 0 && K > 0){
            if(K / coin[i] == 0){
                i--;
//                System.out.print("안됨");
            }
            else if(K / coin[i] > 0){
                num += K / coin[i];
                K = K % coin[i];
//                System.out.println(K/coin[i]);
//                System.out.println("개수 : " + num);
//                System.out.println("남은 값 : " + K);
                i--;
            }

        }





    System.out.print(num);

//        System.out.print(Arrays.toString(coin));

    }

}
