import java.io.*;
import java.util.*;

public class baek_12791 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int Q = Integer.parseInt(br.readLine());
		// 먼저 모든 데이빗 포위 앨범을 행열에 넣어주기
		String[][] arr = new String[25][2];
		String str = "1967 DavidBowie " + "1969 SpaceOddity " + "1970 TheManWhoSoldTheWorld " + "1971 HunkyDory "
				+ "1972 TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars " + "1973 AladdinSane " + "1973 PinUps "
				+ "1974 DiamondDogs " + "1975 YoungAmericans " + "1976 StationToStation " + "1977 Low " + "1977 Heroes "
				+ "1979 Lodger " + "1980 ScaryMonstersAndSuperCreeps " + "1983 LetsDance " + "1984 Tonight "
				+ "1987 NeverLetMeDown " + "1993 BlackTieWhiteNoise " + "1995 1.Outside " + "1997 Earthling "
				+ "1999 Hours " + "2002 Heathen " + "2003 Reality " + "2013 TheNextDay " + "2016 BlackStar";
		StringTokenizer st = new StringTokenizer(str);
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = st.nextToken();
			}
		}
		StringBuilder sb = new StringBuilder();

		for (int k = 0; k < Q; k++) {
			// 앨범 숫자를 세줄 변수
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 25; i++) {
				//년도는 배열의 0번째 칸에 들어있으니까, a랑 b사이에 있을때 ! 
				if (Integer.parseInt(arr[i][0]) >= a && Integer.parseInt(arr[i][0]) <= b) {
					for (int j = 0; j < 2; j++) {
						//빌더에 더해줌
						sb.append(arr[i][j] + " ");
					}
					cnt++;
					sb.append("\n");
				}
			}
			//먼저 cnt담아주고 sb 넣어주기
			bw.append(cnt + "\n").append(sb);
			//sb를 초기화 시키는 방법!!!!!!!!!!!!!!!!
			sb.setLength(0);
		}
		bw.flush();
		bw.close();
	}
}
