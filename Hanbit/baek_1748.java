import java.io.*;
import java.util.*;

public class baek_1748 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		//쉽게 생각해보기 차근차근 !!!
		int length = 10;
		int cnt = 1;
		int tmp = 0;

		//우선 1부터 내가 받은 n까지 돌아가면서 숫자의 수를 세줄건데,
		//length는 10자리, 100자리, 1000자리 늘어갈 것
		//cnt는 십의 자리가 올라갈때마다 숫자 수가 늘어나니까 더해줄 변수(일의자리는 1개)
		//tmp는 마지막 결과값(새로운 수의 자릿수를 계산해줄 것)
		for (int i = 1; i <= n; i++) {
			//더해주는 i값이 십의 자리가 바뀐다면....
			if (i == length) {
				//십의 자리가 늘어나니까 자릿수는 더해질 것 
				//10을 곱해서 미리 십의 자리를 준비해둘 것
				cnt++;
				length *= 10;
			}
			//tmp에 자릿수를 계속 쌓아두자.
			tmp += cnt;
		}
		
		bw.write(tmp+"\n");
		bw.flush();
		bw.close();

	}
}
