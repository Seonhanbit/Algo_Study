import java.io.*;
import java.util.*;

public class baek_5532 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int L = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine()); //국어
		int B = Integer.parseInt(br.readLine()); //수학
		int C = Integer.parseInt(br.readLine()); //국어 하루에 풀 수 있는 문제수
		int D = Integer.parseInt(br.readLine()); //수학 하루에 풀 수 있는 문제수

		int max = 0;
		//국어를 나눌때 0으로 떨어지면 몫
		if(A%C==0)
			max = A/C;
		else
			max= A/C+1; //아니면 하루를 더 투자해야해
		if(B%D==0)
			max = Math.max(max, B/D); // 국어와 수학을 풀 수 있는 날짜 중에 큰것
		else
			max = Math.max(max, B/D+1);
		bw.write(L-max+"\n");
		
		bw.flush();
		bw.close();
	}

}
