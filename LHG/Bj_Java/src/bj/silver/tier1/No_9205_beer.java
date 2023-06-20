package bj.silver.tier1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_9205_beer {
	static int[] home;
	static int[][] store;
	static boolean[] visited;
	static int[] goal;
	static int n;
	static boolean isCanGo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			// �ʱ�ȭ
			isCanGo = false;
			
			n = Integer.parseInt(br.readLine());
			
			store = new int[n][2];
			visited = new boolean[n];
			
			// ��� ��ǥ��� ����
			st = new StringTokenizer(br.readLine());
			home = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken());
				store[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			goal = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			dfs(home[0], home[1]);
			
			if (isCanGo) System.out.println("happy");
			else System.out.println("sad");
		}
	}
	
	static void dfs(int x, int y) {
		// ���� ����
		if (Math.abs(goal[0] - x) + Math.abs(goal[1] - y) <= 1000) {
			isCanGo = true;
		}

		// ���� ���� false ���� ����
		for (int i = 0; i < n; i++) {
			if (!visited[i] && Math.abs(store[i][0] - x) + Math.abs(store[i][1] - y) <= 1000) {
				visited[i] = true;
				dfs(store[i][0], store[i][1]);
			}
		}
	}
}





















