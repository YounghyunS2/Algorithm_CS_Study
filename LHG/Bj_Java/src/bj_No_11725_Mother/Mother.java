package bj_No_11725_Mother;

import java.util.*;

public class Mother {
	
	static int[] arr;
	static boolean[] visited;
	static Map<Integer, List<Integer>> input = new HashMap<Integer, List<Integer>>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		arr = new int[n+1];
		visited = new boolean[n+1];
		
		// ����Ʈ �����
		for (int i = 1; i <= n; i++) {
			input.put(i, new ArrayList<>());
		}
		
		// �迭 �����
		for (int i = 0; i < n-1; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			
			input.get(first).add(second);
			input.get(second).add(first);
		}
		
		dfs(1);
		
		for (int i = 2; i <= n; i++) {
			System.out.println(arr[i]);
		}
	}
	
	static void dfs(int target) {
		visited[target] = true;
		for (int i : input.get(target)) {
			if (!visited[i]) {
				arr[i] = target;
				dfs(i);
			}
		}
	}
}
