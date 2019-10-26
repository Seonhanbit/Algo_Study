import java.io.*;
import java.util.*;

public class baek_14502 {
	// N은 row, M은 col, max는 답
	static int N, M, max;
	// arr는 원래 배열, tmp는 dfs돌고 영역 검사할때 복사한 배열
	static int[][] arr;
	static int[][] tmp;
	static boolean[][] visited;
	// bfs 돌때 2인 애들만 돌려고 list에 넣어줌
	static ArrayList<XY> list;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean range(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static class XY {
		int x;
		int y;

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		tmp = new int[N][M];
		max = Integer.MIN_VALUE;
		list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				//2일때 바이러스가 퍼져야되니까 미리 리스트에 담아주기
				if (arr[i][j] == 2)
					list.add(new XY(i, j));
				//벽이 하나도 없을때는 무조건 답은 3
				if (arr[i][j] == 1)
					count++;
			}
		}
		if (count == 0) {
			max = 3;
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					//먼저 0일때 dfs를 돌건데,
					if (arr[i][j] == 0) {
						//벽을 세워주고 한개 세웠으니까 벽은 이제 2개만 설치할 수 있음
						//처음부터 완전 탐색으로 벽세우기
						arr[i][j] = 1;
						dfs(2);
						//돌고나서 다시 0으로 바꿔주기
						arr[i][j] = 0;
					}
				}
			}
		}
		bw.append(max + "\n");
		bw.flush();
		bw.close();
	}

	static void dfs(int wall) {
		//기저 조건은 벽이 다 세워졌을때 (0일때)
		if (wall == 0) {
			//진짜 배열을 바이러스 퍼진 상태로 바꿔버리면 안되고,
			//현재까지 벽 세운 배열을 복사해주면서 바이러스를 퍼뜨리자			
			for (int i = 0; i < N; i++) {
				tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
			}
			bfs();
			//0개수 체크하기
			//미리 input 받을때 0개수 세주고, 그 cnt에서 벽 개수 3개 빼줌
			//그리고 bfs돌때 바이러스 퍼진만큼 cnt를 빼주면 사실 check 함수는 필요 없음
			int cnt = check();
			if (cnt > max)
				max = cnt;
			return;
		}
		//두번째 벽을 세번쨰 벽을 세울때 까지 또 완탐해줌
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(wall - 1);
					//백트래킹 해줌
					arr[i][j] = 0;
				}
			}
		}
	}

	static void bfs() {
		//bfs 돌때마다 다시 새로 리셋해줌
		visited = new boolean[N][M];
		Queue<XY> queue = new LinkedList<>();
		//바이러스를 큐에 다 넣어주고 시작
		for (int i = 0; i < list.size(); i++) {
			int x = list.get(i).x;
			int y = list.get(i).y;
			queue.add(new XY(x, y));
			// 방문 체크
			visited[x][y] = true;
		}
		while (!queue.isEmpty()) {
			XY tmpxy = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmpxy.x + dx[i], ny = tmpxy.y + dy[i];
				if (!range(nx, ny))
					continue;
				//0이 아닐때 그냥 넘겨
				if (tmp[nx][ny] != 0)
					continue;
				if (visited[nx][ny])
					continue;
				//체크해주고 바이러스 퍼뜨려주고 큐에 넣어주기
				visited[nx][ny] = true;
				tmp[nx][ny] = 2;
				queue.add(new XY(nx, ny));
			}
		}
	}

	static int check() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmp[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}
}
