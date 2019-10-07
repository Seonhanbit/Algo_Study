import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Puyo Puyo 

public class Baek_11559 {
	//�湮 üũ�迭 ����
	static boolean[][] isUse;
	//��ǲ �迭 ����
	static char[][] map;
	//�ѿ�ѿ� ���� ũ��
	static int N, M;
	//�Ź� ��ü Ž���������ʰ� �ѿ��� ��ġ�� ����ϱ� ���ؼ� ����
	static ArrayList<Pos> list;
	//��Ÿ (�����¿� ��)
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	//��ǥ�� ���� Ŭ����
	static public class Pos{
		int r;
		int c;
		public Pos(int r, int c){
			this.r=r;
			this.c=c;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// DFS�� �̿��ؼ� �����ִ� �ѿ��� ������ ī��Ʈ,
		// list�� ī��Ʈ�� �ѿ��� ��ǥ���� ����
		// �ѿ��� ������ 4�̻��̸� delete�ؾ���
		// �ѹ��� ������ �� 1combo�� ī��Ʈ
		// while������ ���Ͽ� ���� ������ ���� üũ
		// �ѹ��� ����� �Ǿƴ�,
		// ���������ȿ��� dfs�� ȣ���ؼ� list�� ���� �� 4�̻��̸�
		// �׶�������
		// ���������� �� ���Ƽ� ���Ͽ� ������ ���Ŀ� ����
		// �����°� ť �����ؼ� Į���� �� �Ʒ��ٺ��� ť�� add��
		// ť�� �������� �Ʒ������� ä���Ŀ� �������� . ���� ä��
		// üũ�迭�� �ʿ����
		// while�� Ż�� boolean�ʿ�

		// �ʿ��Ѱ� ���Ž��-��Ÿ
		// Dfs or Bfs
		Scanner sc = new Scanner(System.in);
		N = 12;
		M = 6;
		map = new char[N][M];
		list = new ArrayList<>();
		isUse = new boolean[N][M];
		//��� ���� ���� ����
		int result =0;
		//��Ʈ�� �ѿ䰡 �ִ��� Ȯ���ϴ� ����
		boolean isOK;
		//input
		for (int i = 0; i < N; i++) {
			map[i] = sc.nextLine().toCharArray();
		}
	
		while(true) {
			//�ʱ�ȭ 
			isOK = false;
			//
			//�̰� ���� ����Ʈ�� ��ǥ�ִ°� ����Ҽ� �����Ͱ�����... �������غ����ҵ�
			
			//�湮�迭 �ʱ�ȭ
			//isUse = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					isUse[i][j]=false;
				}
			}
			
			//�ѿ並 ã��
			//ã�� ������ �ѿ並 ��Ʈ����
			//�ѹ� ������ �� �� �Ŀ� �ѿ並 �����鼭 �޺��� ������Ŵ(result++) 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if( map[i][j]!='.') {
						//����Ʈ �ʱ�ȭ
						list.clear();
						//ã�� ��ġ�� ������ dfs��ȣ��(�ѿ��� ��ġ�� ����Ʈ�� ����)
						dfs(i,j,map[i][j]);
						//���� �ѿ䰡 4�� �̻��̸�
						if(list.size() >=4) {
							//��Ʈ��
							deletePuyo();
							//-----------------------
							//Ǫ�� ����
							//isUse �ʱ�ȭ�� ��� �ؾ� list�̿��ؼ� �Ҽ�������...?
							//���⼭ �ϸ� �ȵ� 
							//---------------------
//							for (Pos p : list) {
//								isUse[p.r][p.c]=false;
//							}
							
							//�ѿ並 ��Ʈ�ȴٰ� üũ
							isOK = true;
						}
					}
				}
			}
			if(isOK==true){
				//�ѿ並 �� ��Ʈ������ result�� �ѹ�����
				result++;
				//�ѿ並 ����
				downPuyo();
			}
			//��Ʈ�� �ѿ䰡 ������ �ݺ��� Ż��
			else if (isOK==false) {
				
				break;
			}
		}
		//output
		System.out.println(result);
	}
	//�ѿ並 ������ �Լ�
	private static void downPuyo() {
		// TODO Auto-generated method stub
		//���̵�� 
		//map �迭�� column ���� �� ����
		//�Ʒ����� .�� �ƴѰ��� ť�� �ְ�
		//ť���ִ°��� �Ʒ����� ä��
		//ť�� ��� �������� .���� ä������
		
		//ť����
		Queue<Character> q = new LinkedList<>();
		//column�� ��������  
		for (int c = 0; c < M; c++) {
			//�Ʒ������� Ȯ��
			for (int r = N - 1; r >= 0; r--) {
				//.�̾ƴϸ� ť�� ����
				if (map[r][c] != '.') {
					q.add(map[r][c]);
				}
			}
			//ť�������� ���� map�� �ִ� �κ�
			
			//�Ʒ�������
			for (int r = N - 1; r >= 0; r--) {
				//ť�� ���� �ʾ�����
				if (!q.isEmpty()) {
					//ť���ִ°� ���� ����
					map[r][c] = q.poll();
				} 
				//������� .���� ä��
				else {
					map[r][c] = '.';
				}
			}
		}
	}
	
	//����Ʈ�� �ִ°� 
	private static void deletePuyo() {
		// TODO Auto-generated method stub
		//����Ʈ �����ŭ
		for (int i = 0; i < list.size(); i++) {
			//����Ʈ�� �ִ°� .���� �ٲ�
			Pos p = list.get(i);
			map[p.r][p.c]= '.'; 
		}
	}
	//��������
	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < 12 && c < 6;
	}

	private static void dfs(int r, int c, char puyo) {
		// TODO Auto-generated method stub
		//��Ÿ �̿�
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			//���� ����, �湮 ���� �ʾ�����, ���� �ѿ��϶�
			if (check(nr, nc)  && !isUse[nr][nc] && map[nr][nc] == puyo) {
				//����Ʈ�� ����
				list.add(new Pos(nr,nc));
				//�湮üũ 
				isUse[nr][nc]= true;
				//���ȣ��
				dfs(nr, nc, puyo);
			}
		}
	}
}