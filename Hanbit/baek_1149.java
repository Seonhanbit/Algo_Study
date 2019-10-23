import java.io.*;
import java.util.*;

public class baek_1149 {
	//input값 담을 클래스
	//r,g,b컬러를 담고 있음
	 static class Color{
	        
	        int r;
	        int g;
	        int b;
	        
	        public Color() {}
	        public Color(int r, int g, int b) {
	            this.r = r;
	            this.g = g;
	            this.b = b;
	        }
	        @Override
	        public String toString() {
	            return "Color [r=" + r + ", g=" + g + ", b=" + b + "]";
	        }
	    }
	    
	    public static void main(String[] args) throws NumberFormatException, IOException {
	        
	        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        
	        int n = Integer.parseInt(bf.readLine());
	        //컬러는 n개
	        Color[] c = new Color[n];
	        //그 전 값을 비교하면서 쌓아갈 것이니까 n+1개
	        int[][] sum = new int[n+1][3];
	        
	        for(int i=0; i<n; i++) {	            
	            StringTokenizer st = new StringTokenizer(bf.readLine());
	            int rcost = Integer.parseInt(st.nextToken());
	            int gcost = Integer.parseInt(st.nextToken());
	            int bcost = Integer.parseInt(st.nextToken());
	            c[i] = new Color(rcost, gcost, bcost);
	        }
	        
	        for(int i=1; i<=n; i++) {
	            //0번쨰는 r, 1번째는 g, 2번쨰는 b
	        	//c배열은 0부터 시작하니까 i-1이 현재 색깔임 
	        	//sum 1번쨰 행부터, c 배열의 현재 색상을 선택했다고 가정하고,
	        	//그 위에 선택하지 않은 색상 중에 가장 작은 값을 더해주는 과정을 n까지 함
	            sum[i][0] = Math.min(sum[i-1][1], sum[i-1][2]) + c[i-1].r;
	            sum[i][1] = Math.min(sum[i-1][0], sum[i-1][2]) + c[i-1].g;
	            sum[i][2] = Math.min(sum[i-1][0], sum[i-1][1]) + c[i-1].b;
	        }
	        
	        int min = Integer.MAX_VALUE;
	        for(int i=0; i<3; i++) {
	            //sum의 n번째에는 그동안에 가장 최적으로 쌓아온 값들이 담겨있음
	        	//그 중에 마지막 r,g,b 선택한 것 중에 가장 작은 값을 min에 넣어주기
	            if(min > sum[n][i])
	                min = sum[n][i];
	        }
	        
	        bw.write(min +"\n");
	        bw.flush();
	        bw.close();
	    }
}