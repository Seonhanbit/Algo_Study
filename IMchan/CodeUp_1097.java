package a20번전까지;

import java.util.Scanner;

public class CodeUp_1097 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] input = new int[20][20];
		for (int i = 1; i < 20; i++) { //1부터 19까지 
			for (int j = 1; j < 20; j++) { //1부터 19까지 ㅇ
				input[i][j] = sc.nextInt(); //입력을 받는다  바둑판.

			}
		}

		int tc = sc.nextInt(); //좌표개수 2
		for (int i = 1; i <= tc; i++) { // 즉 2번반복
			
			int a = sc.nextInt();
			for (int x = 1; x < 20; x++) {
				if (input[a][x] == 0) {
					input[a][x] = 1;
				}else {
					input[a][x] = 0;
				}
			}
			int b = sc.nextInt();
			for (int y = 1; y < 20; y++) {
				if (input[y][b] == 0) {
					input[y][b] = 1;
				}else {
					input[y][b] = 0;
			}
		}
	}
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				System.out.print(input[i][j]+" ");
			}
			System.out.println();
		}
	}

}
