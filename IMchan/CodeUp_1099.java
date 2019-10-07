package a20번전까지;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CodeUp_1099 {
	public static void main(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[10][10];
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// String str = sc.nextLine();
			for (int j = 0; j < 10; j++) {
				// arr[i][j] = sc.nextInt();
				// arr[i][j] = str.charAt(2*j) - '0';
				arr[i][j] = st.nextToken().charAt(0) - '0';
			}//문장을 하나씩 집어넣는구만 오케이 그러면 이런문제같은경우는    arr[i][j] = st.nextToken().charAt(0) - '0';
		}

		/*
		 * for(int i=0; i<10; i++) { System.out.println(Arrays.toString(arr[i])); }
		 */

		boolean ispath = false; //불린형으로 while문 벗어나게끔 만들어놓고 false
		boolean ispath2 = false; 
		int x = 1;  //죄표값 x=1
		int y = 1; //좌표값  y=1;
		while (!ispath || !ispath2) { // for문이아니라 while문이기 때문에 좌표값을 내가 다 지정해야줘야합니다
			arr[x][y] = 9; // 처음 0값을 9로
			if (arr[x][y + 1] == 1) {
				if (arr[x + 1][y] == 1) {
					break; // 이건 조건문이니까 못가는곳이있다면 break;
				} else if (arr[x + 1][y] == 0 || arr[x + 1][y] == 2) {
					x++; // 오른쪽+1이0 또는 아래가 2이면 아래로 움직이기
				}
			} else if (arr[x + 1][y] == 0) {
				y++; // 아래가 0이라면 오른쪽으로 움지기이기
			}
			if (arr[x][y] == 2) {
				arr[x][y] = 9; // 마지막 먹이값을 9로 변환//지나간길 다 9로
				ispath = true; // 여기서 반복문 깨지고
			}
			if(arr[x][y] != 2 || arr[8][8] == 1) {
				ispath2 = true;
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
