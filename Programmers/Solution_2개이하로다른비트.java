package Problem;

import java.util.Arrays;

public class Solution_2개이하로다른비트 {

	public static void main(String[] args) {
		long[] numbers = {
				2,7
		};
		
		long[] answer = solution(numbers);
		System.out.println(Arrays.toString(answer));
	}
	public static long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];
        
        for(int i=0; i<len; i++) {
        	// 가장 뒤쪽에 오는 0을 1로 바꾸고, 바꾼 위치 뒤에 가장 먼저 오는 1을 0으로 바꾼다.
        	String binary = Long.toBinaryString(numbers[i]);
        	int zeroInd = binary.lastIndexOf("0");
        	if(zeroInd == -1) {
        		binary = "10" + binary.substring(1);
        	} else {
        		int oneInd = binary.indexOf("1", zeroInd);
        		if(oneInd == -1) {
        			binary = binary.substring(0, zeroInd) + "1" + binary.substring(zeroInd+1);
        		} else {
        			binary = binary.substring(0, zeroInd) + "1" + binary.substring(zeroInd+1, oneInd) + 
        					"0" + binary.substring(oneInd+1);
        		}
        	}
        	answer[i] = Long.parseLong(binary, 2);
        }
        
        return answer;
    }
}
