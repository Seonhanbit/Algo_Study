import java.io.*;
import java.util.*;

public class baek_2589 {
	static int N, M, res;
	static char[][] arr;
	static boolean[][] check;
	static Queue<XY> queue;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	//큐에 담아갈 정보를 가져가는 클래스 생성(x,y좌표와 거리수)
	static class XY {
		int x;
		int y;
		int cnt;

		XY(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	//범위 체크하는 함수 생성
	static boolean range(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		//가장 큰 값을 구해야하니까 비교할 변수 생성
		int max = Integer.MIN_VALUE;
		//bfs 돌 큐를 생성
		queue = new LinkedList<>();
		//input 받기
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			arr[i] = str.toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//모든 L에 대해 최단거리를 알아야하니까 방문 배열 초기화
				check = new boolean[N][M];
				//L일때 bfs 돌꺼야
				if (arr[i][j] == 'L') {
					//큐에 먼저 넣어주고 돌기
					queue.add(new XY(i, j, 0));
					bfs();
					//모든 L에 대한 최대로 긴 곳을 구하기
					if (res > max)
						max = res;
				}
			}
		}
		System.out.println(max);
	}

	static void bfs() {
		//큐가 없어질때까지 돌거야
		while (!queue.isEmpty()) {
			//큐에 있는것 빼주고
			XY tmp = queue.poll();
			//마지막 cnt를 변수에 저장해주기
			res = tmp.cnt;
			//방문 했다는 것을 체크하고
			check[tmp.x][tmp.y] = true;
			//네방향으로 돌아보자
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
				if (!range(nx, ny)) //범위초과는 안해
					continue;
				if (check[nx][ny]) //방문한 곳도 안해
					continue;
				if (arr[nx][ny] == 'W') //바다면 안해
					continue;
				check[nx][ny] = true; //조건이 맞으니까 방문해주고
				queue.add(new XY(nx,ny,tmp.cnt+1)); //또 bfs돌자
			}
		}
	}

}
