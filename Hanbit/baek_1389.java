import java.io.*;
import java.util.*;

//케빈 베이컨의 6단계 법칙
//인접행렬을 만들어서 큐를 이용하면 될 것 같음
public class baek_1389 {
	static int N, M, sum, res, result;
	static int[][] arr;
	static Queue<point> queue;

	//검사할 j와 depth를 저장할 cnt
	static class point {
		int x;
		int cnt;

		point(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		//인접행렬로 바로 넣기위해 N+1씩 만들어주기
		arr = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//서로 연결되었다고 표기해주기
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		//각 번호 i에 대한 연결 깊이를 모두 더해줄 sum
		sum = 0;
		//연결 깊이 중 가장 작은애를 구할건데, 결과 값(해당 번호)를 출력할 변수 result 생성
		res = Integer.MAX_VALUE;
		result = 0;
		//연결이 된 놈을 검사할꺼니까 queue에 담아주고, list에는 연결이 안된 놈을 넣어줌
		queue = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		//i번호를 이제부터 검사할거야(j를 돌면서 한바퀴 돌고, 그 깊이를 다 더해주면서 검사하기)
		for (int i = 1; i < N + 1; i++) {
			//각각의 깊이 값을 저장해 줄 행렬을 준비해두자, sum은 한줄 돌때마다 초기화
			int[] tmp = new int[N + 1];
			sum = 0;
			//이제부터 한줄씩 검사해보자
			for (int j = 1; j < N + 1; j++) {
				//만약 연결이 되어 있으면 tmp에 바로 첫번째로 갈 수 있으니 1을 넣어주기
				//연결된 놈은 queue에 넣어주고 깊이는 1이니까 cnt에 1을 넣어주
				//그리고 연결된 놈은 list에 넣어주지 않기			
				if (arr[i][j] == 1) {
					tmp[j] = 1;
					queue.add(new point(j, 1));
					continue;
				} else if (i == j) //자기 자신은 리스트에 넣을 필요도 없고, tmp도 상관 ㄴㄴ
					continue;
				list.add(j);
			}
			//이제부터 queue를 계속 돌건데, 
			//기저 조건은 안된놈list 사이즈가 0일때 바로 끝나
			while (!queue.isEmpty()) {
				if (list.size() == 0)
					break;
				point ptmp = queue.poll();
				//list삭제해주면 인덱스 꼬이니까 뒤부터 시작
				for (int d = list.size() - 1; d >= 0; d--) {
					//i의 기준은 현재 연결된 놈(queue에서 꺼낸놈)
					//j의 기준은 리스트(연결안된놈)에서 꺼낸 놈
					if (arr[ptmp.x][list.get(d)] == 1) {
						//연결되어있으면 현재 연결된놈 cnt보다 1더해주기(깊이가 1 늘어난거야)
						tmp[list.get(d)] = ptmp.cnt + 1;
						//연결된 놈이니까 queue에 넣어주고 해당 cnt보다 1깊이가 늘어난것
						queue.add(new point(list.get(d), ptmp.cnt + 1));
						//이제 연결되었으니까 list에서는 지워주기
						list.remove(d);
					}
				}
			}
			//아직 큐에 많이 남았고, 혹시 모르니까 다 클리어해주기
			queue.clear();
			list.clear();
			//tmp배열의 깊이값을 모조리 더해주자.
			for (int k = 1; k < N + 1; k++) {
				sum += tmp[k];
			}
			//작은 값 갱신하고 해당 번호를 result에 담아주기
			if (sum < res) {
				result = i;
				res = sum;
			}
		}
		bw.append(result + "\n");
		bw.flush();
		bw.close();
	}
}
