package bj.gold.tier5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_7576_Tomato {
	
	static int n;
	static int m;
	
	static int[][] arr;
	static Queue<int[]> codi = new LinkedList<>();
	
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	
	static boolean isfix;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m][n];
		
		for (int r = 0; r < m; r++) {
			
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < n; c++) {
				
				arr[r][c] = Integer.parseInt(st.nextToken());
				
				if (arr[r][c] == 1) {
					int[] temp = {r, c};
					codi.add(temp);
				}
			}
		}
		
		bfs(0);
	}
	
	static void bfs(int day) {
		
		// ��� �;��ٸ�
		if (isgoal(day)) {
			System.out.println(day);
			return;
		}
		
		day++;
		isfix = true;
		
		int daysize = codi.size();
		
		for (int i = 0; i < daysize; i++) {
			int r = codi.peek()[0];
			int c = codi.poll()[1];
			for (int j = 0; j < 4; j++) {
				int tempr = r + dr[j];
				int tempc = c + dc[j];
				
				//�������
				if (tempr < 0 || tempr >= m || tempc < 0 || tempc >= n) continue;
				
				//�丶�� Ȯ��
				if (arr[tempr][tempc] == 0) {
					arr[tempr][tempc] = 1;
					int[] temp = {tempr, tempc};
					codi.add(temp);
					isfix = false;
				}
			}
		}
		
		// ��ȭ�� ���ٸ� ��
		if (isfix) {
			System.out.println(-1);
			return;
		}
		
		bfs(day);
	}
	
	static boolean isgoal(int day) {
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				//���� ������ �丶�䰡 �ִٸ� Ż��
				if (arr[r][c] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
