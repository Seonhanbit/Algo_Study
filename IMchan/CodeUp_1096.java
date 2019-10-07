package a20번전까지;

import java.util.Scanner;

public class CodeUp_1096 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] input = new int[20][20];
		int x, y = 0; //x,y 초기화한 상태에서
		for (int i = 1; i <= n; i++) { //for문을 돌리고
			x = sc.nextInt(); 
			y = sc.nextInt();
			input[x][y] = 1;
		}
		
		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				
				System.out.printf("%d ", input[i][j]);
			}
			
			System.out.println(" ");

		}
	}

}
