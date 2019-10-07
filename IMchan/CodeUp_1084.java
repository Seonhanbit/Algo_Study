package a20번전까지;

import java.util.Scanner;

public class CodeUp_1084 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int r = sc.nextInt();
		int g = sc.nextInt();
		int b = sc.nextInt();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < g; j++) {
				for (int z = 0; z < b; z++) {
					System.out.println(i+" "+j+" "+z);
					sum = sum+1;
				}
			}
		}
		System.out.print(sum);
	}
}
