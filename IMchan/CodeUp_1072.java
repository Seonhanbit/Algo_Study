package 코드업;

import java.util.Scanner;

public class CodeUp_1072 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int [num];
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
			System.out.println(arr[i]);
		}
	}

}
