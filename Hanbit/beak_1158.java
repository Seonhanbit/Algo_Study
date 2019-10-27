import java.io.*;
import java.util.*;

//조세퍼스 순열 문제
public class beak_1158 {
	static int N, K;
	static Queue<Integer> queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 원래 순열인 큐와 바뀔 결과값 list 준비(큐를 준비해도 가능)
		queue = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i < N + 1; i++)
			queue.add(i);
		//count는 1부터 시작해서 큐가 없어질때까지 돌거야
		//큐는 K의 배수일때만 정확히 빼주고 계속 돌기
		int count = 1;
		while (!queue.isEmpty()) {
			//K의 배수면 list에 넣어주기(큐는 자연스럽게 1개 없어짐)
			if (count % K == 0) {
				list.add(queue.poll());
			} else {
				//배수가 아닐떄는 첫번째 인자를 맨 뒤에 넣어주자
				queue.add(queue.poll());
			}
			//카운트는 1개씩 증가하기
			count++;
		}
		bw.append('<');
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				bw.append(list.get(i) + ">");
			} else {
				bw.append(list.get(i) + ", ");
			}
		}
		bw.flush();
		bw.close();
	}

}
