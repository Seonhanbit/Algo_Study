import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Puyo Puyo 

public class Baek_11559 {
	//방문 체크배열 생성
	static boolean[][] isUse;
	//인풋 배열 생성
	static char[][] map;
	//뿌요뿌요 맵의 크기
	static int N, M;
	//매번 전체 탐색을하지않고 뿌요의 위치를 기억하기 위해서 생성
	static ArrayList<Pos> list;
	//델타 (상하좌우 순)
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	//좌표를 받을 클래스
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
		// DFS를 이용해서 같이있는 뿌요의 개수를 카운트,
		// list에 카운트한 뿌요의 좌표값을 저장
		// 뿌요의 개수가 4이상이면 delete해야함
		// 한번에 터지는 건 1combo로 카운트
		// while문으로 한턴에 같이 터질것 까지 체크
		// 한번에 지우는 건아님,
		// 이중포문안에서 dfs를 호출해서 list에 넣은 게 4이상이면
		// 그때에지움
		// 이중포문이 다 돌아서 한턴에 지워진 이후에 내림
		// 내리는건 큐 생성해서 칼럼의 맨 아랫줄부터 큐에 add함
		// 큐가 빌때까지 아래서부터 채운후에 나머지는 . 으로 채움
		// 체크배열이 필요없음
		// while문 탈출 boolean필요

		// 필요한거 사방탐색-델타
		// Dfs or Bfs
		Scanner sc = new Scanner(System.in);
		N = 12;
		M = 6;
		map = new char[N][M];
		list = new ArrayList<>();
		isUse = new boolean[N][M];
		//결과 담을 변수 생성
		int result =0;
		//터트릴 뿌요가 있는지 확인하는 변수
		boolean isOK;
		//input
		for (int i = 0; i < N; i++) {
			map[i] = sc.nextLine().toCharArray();
		}
	
		while(true) {
			//초기화 
			isOK = false;
			//
			//이거 말고 리스트에 좌표있는거 사용할수 있을것같은데... 생각더해봐야할듯
			
			//방문배열 초기화
			//isUse = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					isUse[i][j]=false;
				}
			}
			
			//뿌요를 찾음
			//찾을 때마다 뿌요를 터트리고
			//한번 끝까지 다 돈 후에 뿌요를 내리면서 콤보를 증가시킴(result++) 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if( map[i][j]!='.') {
						//리스트 초기화
						list.clear();
						//찾은 위치를 가지고 dfs를호출(뿌요의 위치를 리스트에 담음)
						dfs(i,j,map[i][j]);
						//같은 뿌요가 4개 이상이면
						if(list.size() >=4) {
							//터트림
							deletePuyo();
							//-----------------------
							//푸념 구간
							//isUse 초기화를 어디서 해야 list이용해서 할수있을까...?
							//여기서 하면 안됨 
							//---------------------
//							for (Pos p : list) {
//								isUse[p.r][p.c]=false;
//							}
							
							//뿌요를 터트렸다고 체크
							isOK = true;
						}
					}
				}
			}
			if(isOK==true){
				//뿌요를 다 터트렸으니 result를 한번증가
				result++;
				//뿌요를 내림
				downPuyo();
			}
			//터트릴 뿌요가 없으면 반복문 탈출
			else if (isOK==false) {
				
				break;
			}
		}
		//output
		System.out.println(result);
	}
	//뿌요를 내리는 함수
	private static void downPuyo() {
		// TODO Auto-generated method stub
		//아이디어 
		//map 배열을 column 으로 뜯어서 생각
		//아래부터 .이 아닌것을 큐에 넣고
		//큐에있는것을 아래부터 채움
		//큐가 비면 나머지는 .으로 채워넣음
		
		//큐생성
		Queue<Character> q = new LinkedList<>();
		//column을 기준으로  
		for (int c = 0; c < M; c++) {
			//아래서부터 확인
			for (int r = N - 1; r >= 0; r--) {
				//.이아니면 큐에 넣음
				if (map[r][c] != '.') {
					q.add(map[r][c]);
				}
			}
			//큐에있을걸 뺴서 map에 넣는 부분
			
			//아래서부터
			for (int r = N - 1; r >= 0; r--) {
				//큐가 비지 않았으면
				if (!q.isEmpty()) {
					//큐에있는걸 빼서 넣음
					map[r][c] = q.poll();
				} 
				//비었으면 .으로 채움
				else {
					map[r][c] = '.';
				}
			}
		}
	}
	
	//리스트에 있는걸 
	private static void deletePuyo() {
		// TODO Auto-generated method stub
		//리스트 사이즈만큼
		for (int i = 0; i < list.size(); i++) {
			//리스트에 있는걸 .으로 바꿈
			Pos p = list.get(i);
			map[p.r][p.c]= '.'; 
		}
	}
	//범위제한
	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < 12 && c < 6;
	}

	private static void dfs(int r, int c, char puyo) {
		// TODO Auto-generated method stub
		//델타 이용
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			//범위 제한, 방문 하지 않았으면, 같은 뿌요일때
			if (check(nr, nc)  && !isUse[nr][nc] && map[nr][nc] == puyo) {
				//리스트에 넣음
				list.add(new Pos(nr,nc));
				//방문체크 
				isUse[nr][nc]= true;
				//재귀호출
				dfs(nr, nc, puyo);
			}
		}
	}
}