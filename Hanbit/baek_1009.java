import java.io.*;
import java.util.*;

//분산처리
public class baek_1009 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int r, a, b;
		// 나머지는 곱셈에 닫혀있으므로,
		// 나머지에 나머지를 곱해도 결국 나머지는 똑같음
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			System.out.println("==="+b);
			r = 1;
			// a^b는 무진장 큰수이기때문에 지수승을 바로 하지말고 나머지의 나머지를 곱해주자
			for (int j = 0; j < b; j++) {
				r = (r * a) % 10;
			}
			// r이 0이라면 결국 10번째 컴퓨터가 처리하는 것
			if (r == 0)
				r = 10;
			bw.append(r + "\n");
		}
		bw.flush();
		bw.close();
	}
}

/*//일의 자리가 중복될 때까지만 계산한다.
for(int j=1; j<=b; j++) {
	long num = (long)Math.pow(a%10, j+1);		// 10으로 나누기 때문에 끝자리만 계산한다.
	
	int tmpNum = (int)(num%10);				// 배수의 나머지
	if(list.get(0) == tmpNum ) {			// 배수의 나머지가 첫번째와 같아지면 끝낸다.
		break;
	} else {
		list.add(tmpNum);
	}
}*/
