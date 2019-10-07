package a20번전까지;

import java.util.Scanner;

public class CodeUp_1092 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		int cnt = 0;
		
			while (true) {
				cnt++;
				if(cnt % x == 0 && 
						cnt % y == 0 &&
						cnt % z == 0 ){
					break;
				}
			}
		
		System.out.println(cnt);



	}

}
