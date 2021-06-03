package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5430_AC {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			boolean isSuccess = true;
			String p = br.readLine();
			int len = Integer.parseInt(br.readLine());
			String arr_str = br.readLine();
			arr_str = arr_str.substring(1, arr_str.length()-1);
			String[] arr = arr_str.split(",");
			
			int left = 0;
			int right = len-1;
			boolean flag = true; // true : 삭제시 맨 앞꺼, false : 삭제시 맨 뒤꺼
			for(int i=0, pLen=p.length(); i<pLen; i++) {
				char c = p.charAt(i);
				if(c == 'R') {
					flag = flag ? false : true;
				} else {
					if(left > right) {
						isSuccess = false;
						break;
					}
					if(flag) {
						left++;
					} else {
						right--;
					}
				}
			}
			if(isSuccess) {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				if(flag) {
					for(int i=left; i<=right; i++) {
						sb.append(arr[i]);
						if(i != right) {
							sb.append(",");
						}
					}
				} else {
					for(int i=right; i>=left; i--) {
						sb.append(arr[i]);
						if(i != left) {
							sb.append(",");
						}
					}
				}
				sb.append("]");
				System.out.println(sb);
			} else {
				System.out.println("error");
			}
		}
	}
}
