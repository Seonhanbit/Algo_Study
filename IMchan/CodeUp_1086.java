package a20번전까지;

import java.util.Scanner;

public class CodeUp_1086 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt(); //가로해상도
		int h = sc.nextInt(); //세로해상도
		int b = sc.nextInt(); //비트
		int hap = w * h * b;
		double result = ((hap / 8) / Math.pow(2, 10)) / Math.pow(2, 10); //1024비트 1kb = 1024bit  1mb =1000kb 2^10으로 2번 나눠야된다 !!
																		//Math.pow(더블만 인식가능)
		System.out.printf("%.2f MB", result);

	}

}
