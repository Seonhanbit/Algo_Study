import java.util.Arrays;
import java.util.Scanner;
//버블소트
//버블소트로 정렬할때 정렬이 완료될때까지의 스왑이 발생하는 횟수(스왑횟수가 아님)
//아이디어 컨닝함..
//
public class Baek_1377 {
	//정렬할 값과 원래 인덱스를 저장할 객체 생성
	static class Data implements Comparable<Data> {
		int num;
		int idx;
		Data(int n, int i) {
			this.num = n;
			this.idx = i;
		}
		//오름차순 정렬
		@Override
		public int compareTo(Data o) {
			return this.num - o.num;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Data[] d = new Data[n];
		//인덱스 저장
		for (int i = 0; i < n; i++) {
			d[i] = new Data(sc.nextInt(), i+1);
		}
		//nlogn으로 정렬
		Arrays.sort(d);
		//결과값 담을 변수
		int ans = 0;
		//원래 인덱스 - 현재 인덱스 중 가장 큰값
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, d[i].idx - i);
		}
		System.out.println(ans);
	}
}