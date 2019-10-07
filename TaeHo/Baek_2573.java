import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//����

//�̹����� �̻�����
//�и��� ���������� ������ �Ѱ��� ���´ٰ� �ߴµ�
//���δ� 0���� ���� ���� ������ ���ɶ�
//�ƴϸ� ������ ���ʿ� 2���� ������ ���ɰ� �����ϴ°Ű���
//�װͶ����� while������ Ż����ؼ� �ð��ʰ��� �߻���

//Ǯ�̽ð� 10.05 5�ð�

public class Baek_2573 {
	//��ǲ �迭
	static int[][] map;
	//���� �� �迭 
	//�湮 üũ���ؼ� ����� ��ǲ�迭 ���� �Ѱ�,
	//�ּ� ���鼭 �����غ��� boolean �迭 ���°Ŷ� �������̾���
	//�޸� �����ؼ� ������ ©���� boolean��߁���
	static int[][] clone_map;
	//ũ�� ����
	static int N, M;

	//��Ÿ(�����¿� ��)
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// ������ �ִ� ĭ��ã��
		// �����¿쿡�� ������ �ִµ������� 0�� ������ ī��Ʈ
		// �迭�� �ϳ� ������ ������ �ִ� ĭ�� 0�� ������ �����
		// ������ ����
		// dfs �� ������ ������ ��
		// ������ ������ 2�̻��̸� ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//��ǲ
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		//ũ�� �Է�
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		clone_map = new int[N][M];
		//����� ����� result����
		int result = 0;
		//�����¿��� 0�� ī��Ʈ�ؼ� ������ �迭 ����
		int[][] count_map = new int[N][M];
		//�����¿� 0�� ������ ī��Ʈ
		int count = 0;
		//input
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//�迭 Ŭ��
				clone_map[i][j] = map[i][j];
			}
		}
		//�迭�� ���� 0������ Ȯ���� sum
		//�迭�� ���� �� ���ؼ� 0�̸� Ż���� ����
		int sum =0;
		//������ 2���̻��� ��� Ż���ϱ����� check ����
		boolean check = false;
		
		out2: while (true) {
			//sum �� �� ����
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sum+=map[i][j];
				}
			}
			//�� 0�̸� Ż��
			if(sum==0) {
				result=0;
				break out2;
			}
			//�ʱ�ȭ
			sum=0;
			//������ ���� ���ºκ�
			//-----------------
			//Ǫ��
			//���� ������ �ʹ� ��û�ѰŰ�����
			//�ƿ� �ٽ� ¥�����ҵ�
			//-----------------
			
			//��ǥ�� ã�Ƽ� dfsȣ��
			//ȣ�� ���Ŀ��� clone_map���� dfs���� Ž���� �κ��� �� 0���� �Ǿ�����
			out: for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (clone_map[i][j] > 0) {
						dfs(i, j);
						//�ѹ����� Ż��
						break out;
					}
				}
			}
			//���� �����̶� ��ĥ�� ���� 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					//���ϰ� ���� ����������(0���� ū�� ������ ������)
					if (clone_map[i][j] > 0) {
						//���ϰ� 2�� �̻��̶�� ����
						check = true;
						//while �� Ż��
						break out2;
					}
				}
			}
			result++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// ������ �ִ� ĭ�� ã��
					if (map[i][j] != 0) {
						//���Ž�� �ؼ� �ֺ� 0���� ī��Ʈ
						for (int j2 = 0; j2 < 4; j2++) {
							int nr = i + dr[j2];
							int nc = j + dc[j2];
							if (check(nr, nc) && map[nr][nc] == 0) {
								count++;
							}
						}
						//ī��Ʈ �迭�� ����
						count_map[i][j] += count;
						//ī��Ʈ�� �ʱ�ȭ
						count = 0;
					}
				}
			}
			//1�� ���� ���� ����
			//map���� count_map�� ����
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] -= count_map[i][j];
					count_map[i][j] = 0;
					if (map[i][j] < 0) {
						map[i][j] = 0;
					}
				}
			}
			// �迭 ����
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					clone_map[i][j] = map[i][j];
				}
			}
		}
		//����� ���
		System.out.println(result);
	}
	//
	private static void dfs(int r, int c) {
		// TODO Auto-generated method stub
		//üũ�迭 ��� clone_map�̿��ؼ� �湮üũ
		//���̷�������..
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (check(nr, nc) && clone_map[nr][nc] != 0) {
				clone_map[nr][nc] = 0;
				dfs(nr, nc);
			}
		}
	}
	//���� ����
	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}