import java.io.*;
import java.util.*;

public class baek_10709 {
	static int H, W;
	static char[][] arr;
	static int[][] res;

	static boolean range(int x, int y) {
		if (x >= 0 && x < H && y >= 0 && y < W)
			return true;
		else
			return false;
	}

	static class XY {
		int x;
		int y;

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		//입력받을 구름 배열
		arr = new char[H][W];
		//구름이 흘러간 결과 배열
		res = new int[H][W];
		//입력받기, 어차피 구름일때 처리해줄꺼니까 미리 -1로 다 채워놓기
		for (int i = 0; i < H; i++) {
			String str = br.readLine();
			arr[i] = str.toCharArray();
			Arrays.fill(res[i], -1);
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				//구름 만나면 
				if (arr[i][j] == 'c') {
					//결과 배열에 0으로 처리
					res[i][j] = 0;
					//구름이 갈 방향 값
					int cnt = 1;
					
					Queue<XY> queue = new LinkedList<>();
					queue.add(new XY(i, j));
					while (!queue.isEmpty()) {
						//먼저 큐에서 빼주고 오른쪽으로만 가니까 j값에 1추가하기
						XY tmp = queue.poll();
						int ny = tmp.y+1;
						if (!range(i, ny))//범위 벗어나면 패스
							continue;
						if (arr[i][ny] == 'c') {//다음에 구름이면 바로 끝내야해
							queue.clear();
							continue;
						}
						//조건에 맞다면 결과 배열에 구름 이동 값 넣어주기
						res[i][ny] = cnt;
						cnt++; //이동값 추가
						queue.add(new XY(i, ny));
					}
				}
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(res[i][j]+" ");
			}System.out.println();
		}
	}

}
