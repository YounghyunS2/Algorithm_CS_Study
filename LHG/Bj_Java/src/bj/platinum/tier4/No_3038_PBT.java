package bj.platinum.tier4;

import java.io.*;
import java.util.*;

public class No_3038_PBT {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		dfs(1, 1, n);
	}
	//��Ʈ ����� ���̸� 1�� �д�.
	static void dfs(int col, int depth, int n) {
		if (depth == n) {
			System.out.print(col + " ");
			return;
		}
		
		int node = (int) (Math.pow(2, n) - Math.pow(2, depth - 1) - col + 1);
		
		System.out.print(node + " ");
		dfs(col, depth + 1, n);
		dfs(col + (int) Math.pow(2, depth-1), depth + 1, n);
	}
}