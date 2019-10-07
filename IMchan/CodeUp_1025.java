package a20번전까지;

import java.util.Scanner;

public class CodeUp1025 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String num1 = String.valueOf(num);
		int zero = 4;
		
			for(int i = 0; i < 5; i++){
			String char1 = String.valueOf(num1.charAt(i));
			for (int j = 0; j < zero; j++) {
			char1 = char1.concat("0");
			}
			System.out.println("[" + char1 + "]");
			zero--;
			}



	}

}

