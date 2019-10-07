package a20번전까지;

import java.util.Arrays;
import java.util.Scanner;

public class CodeUp_1095 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		int temp = 0;
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		int max = input[0];
		int min = input[0];
		for(int i =0; i<input.length;i++) {
		/*if(max<input[i]) {
			max = input[i];
		}*/
		if(min > input[i]) {
			min = input[i];
		}
		}
		
		/*for (int j = 0; j < n - 1; j++) {
			for (int k = j + 1; k < n; k++) {
				if (input[j] > input[k]) {
					temp = input[j];
					input[j] = input[k];
					input[k] = temp;
				}
			}
		}*/
		//Arrays.sort(input);
		System.out.println(min);

	}

}
