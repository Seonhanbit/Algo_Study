import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//빙산

//이문제의 이상한점
//분명히 문제에서는 빙산이 한개로 들어온다고 했는데
//전부다 0으로 빙산 없이 들어오는 테케랑
//아니면 빙산이 애초에 2개로 들어오는 테케가 존재하는거같음
//그것때문에 while문에서 탈출못해서 시간초과가 발생함

//풀이시간 10.05 5시간

public class Baek_2573 {
	//인풋 배열
	static int[][] map;
	//복사 할 배열 
	//방문 체크겸해서 사용한 인풋배열 복사 한거,
	//주석 쓰면서 생각해보니 boolean 배열 쓰는거랑 차이점이없음
	//메모리 생각해서 다음에 짤때는 boolean써야곘음
	static int[][] clone_map;
	//크기 세팅
	static int N, M;

	//델타(상하좌우 순)
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 빙산이 있는 칸을찾음
		// 상하좌우에서 빙산이 있는데까지의 0의 개수를 카운트
		// 배열을 하나 더놓고 빙산이 있는 칸에 0의 개수를 적어둠
		// 빙산을 없앰
		// dfs 로 빙산의 개수를 셈
		// 빙산의 개수가 2이상이면 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//인풋
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		//크기 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		clone_map = new int[N][M];
		//결과로 출력할 result생성
		int result = 0;
		//상하좌우의 0을 카운트해서 저장할 배열 생성
		int[][] count_map = new int[N][M];
		//상하좌우 0의 개수를 카운트
		int count = 0;
		//input
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//배열 클론
				clone_map[i][j] = map[i][j];
			}
		}
		//배열이 전부 0인지를 확인할 sum
		//배열이 값을 다 더해서 0이면 탈출할 예정
		int sum =0;
		//빙산이 2개이상일 경우 탈출하기위해 check 새성
		boolean check = false;
		
		out2: while (true) {
			//sum 에 다 넣음
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sum+=map[i][j];
				}
			}
			//다 0이면 탈출
			if(sum==0) {
				result=0;
				break out2;
			}
			//초기화
			sum=0;
			//빙하의 개수 세는부분
			//-----------------
			//푸념
			//여기 로직이 너무 멍청한거같은데
			//아예 다시 짜봐야할듯
			//-----------------
			
			//좌표를 찾아서 dfs호출
			//호출 한후에는 clone_map에서 dfs에서 탐색한 부분이 다 0으로 되어있음
			out: for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (clone_map[i][j] > 0) {
						dfs(i, j);
						//한번돌고 탈출
						break out;
					}
				}
			}
			//위에 포문이랑 합칠수 있음 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					//빙하가 아직 남아있으면(0보다 큰게 아직도 있으면)
					if (clone_map[i][j] > 0) {
						//빙하가 2개 이상이라고 보고
						check = true;
						//while 문 탈출
						break out2;
					}
				}
			}
			result++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 빙산이 있는 칸을 찾아
					if (map[i][j] != 0) {
						//사방탐색 해서 주변 0개수 카운트
						for (int j2 = 0; j2 < 4; j2++) {
							int nr = i + dr[j2];
							int nc = j + dc[j2];
							if (check(nr, nc) && map[nr][nc] == 0) {
								count++;
							}
						}
						//카운트 배열에 저장
						count_map[i][j] += count;
						//카운트를 초기화
						count = 0;
					}
				}
			}
			//1년 후의 빙산 세팅
			//map에서 count_map을 뺴줌
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] -= count_map[i][j];
					count_map[i][j] = 0;
					if (map[i][j] < 0) {
						map[i][j] = 0;
					}
				}
			}
			// 배열 복사
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					clone_map[i][j] = map[i][j];
				}
			}
		}
		//결과값 출력
		System.out.println(result);
	}
	//
	private static void dfs(int r, int c) {
		// TODO Auto-generated method stub
		//체크배열 대신 clone_map이용해서 방문체크
		//왜이렇게했지..
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (check(nr, nc) && clone_map[nr][nc] != 0) {
				clone_map[nr][nc] = 0;
				dfs(nr, nc);
			}
		}
	}
	//범위 제한
	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}