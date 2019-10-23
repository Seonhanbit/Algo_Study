import java.io.*;
import java.util.*;

public class baek_10798 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//최대 문자열의 길이는 15개
		char[][] arr = new char[5][15];
		//각 문자열의 길이를 저장할 배열
		int[] len = new int[5];

		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			arr[i] = str.toCharArray();
			//길이는 인덱스비교를 위해 -1해주기
			//맥스 값을 미리 구해주면 더 빠를 것 같음 (15까지도 안 돌아도 돼)
			len[i] = str.length()-1;
		}

		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < 15; j++) {
			for (int i = 0; i < 5; i++) {
				int idx = len[i];
				//검사해야할 배열의 j가 현재 문자열의 길이보다 크면 아무것도 안하기
				if(j>idx)
					continue;
				sb.append(arr[i][j]);
			}
		}
		bw.write(sb + "\n");
		bw.flush();
		bw.close();
	}
}
