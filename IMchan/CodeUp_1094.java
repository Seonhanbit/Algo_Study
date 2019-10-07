package a20번전까지;

import java.util.Scanner;

public class CodeUp_1094 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];

		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		for (int j = n - 1; j >= 0; j--) {
			System.out.print(input[j]+" ");

		}
	}

}
