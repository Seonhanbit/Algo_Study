package a20번전까지;

import java.util.Scanner;

public class CodeUp_1085 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt(); //소리강약체크
		int b = sc.nextInt(); //비트 
		int c = sc.nextInt(); //채널
		int s = sc.nextInt(); //시간
		int hap = h * b * c * s;
		double result = ((hap / 8) / Math.pow(2, 10)) / Math.pow(2, 10);
		System.out.format("%.1f MB", result);
	}

}
