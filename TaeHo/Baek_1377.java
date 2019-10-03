import java.util.Arrays;
import java.util.Scanner;
//�����Ʈ
//�����Ʈ�� �����Ҷ� ������ �Ϸ�ɶ������� ������ �߻��ϴ� Ƚ��(����Ƚ���� �ƴ�)
//���̵�� ������..
//
public class Baek_1377 {
	//������ ���� ���� �ε����� ������ ��ü ����
	static class Data implements Comparable<Data> {
		int num;
		int idx;
		Data(int n, int i) {
			this.num = n;
			this.idx = i;
		}
		//�������� ����
		@Override
		public int compareTo(Data o) {
			return this.num - o.num;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Data[] d = new Data[n];
		//�ε��� ����
		for (int i = 0; i < n; i++) {
			d[i] = new Data(sc.nextInt(), i+1);
		}
		//nlogn���� ����
		Arrays.sort(d);
		//����� ���� ����
		int ans = 0;
		//���� �ε��� - ���� �ε��� �� ���� ū��
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, d[i].idx - i);
		}
		System.out.println(ans);
	}
}