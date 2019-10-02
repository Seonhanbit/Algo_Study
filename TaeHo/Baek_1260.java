import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//dfs와 bfs
public class Baek_1260 {
	
	static int[][] arr;
	static boolean[] isUse;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int startNode = sc.nextInt();
		
		arr = new int[N+1][N+1];
		isUse = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y]=1;
			arr[y][x]=1;
		}
		dfs(startNode,N);
		System.out.println();
		//방문체크 배열 초기화
		for (int i = 0; i < N+1; i++) {
			isUse[i]=false;
		}
		bfs(startNode,N);
	}

	private static void bfs(int startNode, int n) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		//시작점 넣기
		q.add(startNode);
		//시작점 방문
		isUse[startNode] =true;
		
		while(!q.isEmpty()) {
			//빼서 출력
			int temp = q.poll();
			System.out.print(temp + " ");
			for (int k = 1; k <= n; k++) {
				//인접행렬이고 방문하지 않았다면 큐에 add
				if(arr[temp][k]==1 && isUse[k]==false) {
					q.add(k);
					//방문
					isUse[k] = true;
				}
			}
		}
	}

	private static void dfs(int startNode, int N) {
		// TODO Auto-generated method stub
		//시작점 출력
		System.out.print(startNode + " ");
		//시작점 방문
		isUse[startNode] = true;
		for (int i = 1; i <= N; i++) {
			//방문하지 않았고 인접행렬 이라면 
			if(isUse[i]==false && arr[startNode][i]==1) {
				dfs(i,N);
			}
		}
		
	}
}