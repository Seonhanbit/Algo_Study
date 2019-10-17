import java.io.*;
import java.util.*;

public class baek_1547 {
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		M = Integer.parseInt(br.readLine());
		// 컵 위치 배열
		int[] arr = new int[4];
		// 현재 컵은 3개고, 볼은 arr[1]에 저장되어있음
		for (int i = 1; i < 4; i++) {
			arr[i] = i;
		}
		int ball = 1;
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int tmpa = 0;
			int tmpb = 0;
			// 볼이 맞는지 검사하기...근데 더 빠른 방법이 있다
/*			if (a == ball)
				ball = b;
			if (b == ball)
				ball = a;*/
			//무식하게 풀어서 눈물 ㅠ.ㅠ
			//3개의 컵을 확인할때 a랑 같으면 변수 저장, b랑 같으면 변수 저장
			for (int j = 1; j < 4; j++) {
				if (arr[j] == a)
					tmpa = j;
				if (arr[j] == b)
					tmpb = j;
			}
			//해당 값이랑 swap
			int tmp = a;
			arr[tmpa] = b;
			arr[tmpb] = tmp;
		}
		System.out.println(arr[1]);
	}
}
