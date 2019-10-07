package a20번전까지;

import java.util.Scanner;

public class CodeUp_1093 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] list = new int[23];
		int[] input = new int[n];
		int hap = 0;
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		for (int j = 0; j < input.length; j++) {
			for (int i = 1; i <= 23; i++) {
				if (input[j] == i) {
					list[i - 1] = list[i - 1] + 1;
				}
			}
		}
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i]);
		}
	}

}
