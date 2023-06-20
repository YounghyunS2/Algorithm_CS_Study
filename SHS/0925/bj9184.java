package pracprac.bj.study.d0925;
//https://reakwon.tistory.com/3
//https://codeinleonis.tistory.com/28
//dp는 답을 한번 계산하고 여러번 사용. 즉 재활용
//메모이제이션Memoization : 문제를 한 번 풀고 정답을 구해 메모(배열에 저장)
//이후 재귀로 반복

import java.util.Scanner;

public class bj9184 {
	
	static int a,b,c;
	static int[][][] dp = new int[21][21][21];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			
			if(a==-1 && b==-1 && c==-1) {
				break;
			}
			
			System.out.println("w("+a+", "+b+", "+c+") = "+w(a,b,c));
			
		}
		
	}

	private static int w(int a, int b, int c) {
		
		if(0<=a && a<=20 && 0<=b && b<=20 && 0<=c && c<=20 &&dp[a][b][c]!=0 ) {			
			return dp[a][b][c];		
		}
		
		if(a<=0 || b<=0 || c<=0) {
			return 1;
		}
		
		if(a>20||b>20||c>20) {
			return dp[20][20][20] = w(20,20,20);
		}
		
		if(a<b && b<c) {
			return dp[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1)-w(a,b-1,c);
		}
		
		return dp[a][b][c] = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
	}

}
