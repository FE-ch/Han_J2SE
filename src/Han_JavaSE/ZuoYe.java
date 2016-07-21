package Han_JavaSE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author ����
 * @category ��bufferedreader�������ݣ��洢��ArrayList�У���ƽ��ֵ
 */
public class ZuoYe {

	public static void main(String[] args) {
		BufferedReader bufferedReader = new 
				BufferedReader(new InputStreamReader(System.in));
		
		HashMap<Double, String> hashMap = new HashMap<>();
		
		for (int i = 0; i < hashMap.size(); i ++) {
			try {
				hashMap.put(Double.parseDouble(bufferedReader.readLine()), 
						bufferedReader.readLine());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(AvrScore.getAvrScore(hashMap));
	}

}

class AvrScore {
	public static double getAvrScore(HashMap<Double, String> hm) {
		double avrScore = 0;
		Object[] arr = hm.keySet().toArray();
		
		Arrays.sort(arr);
		arr[0] = 0;
		arr[arr.length - 1] = 0;
		double sum = 0;
		
		for (int i = 0; i < arr.length; i ++) {
			sum += Double.parseDouble(arr[i].toString());
		}
		
		avrScore = sum / (arr.length - 2);
		return avrScore;
	}
}


/*
 * ����һ��arraylist���õ�һ���������Сֵ֮���ƽ��ֵ
 * �������޷���ʹ��ģ���ʱ��ʹ��Collections.sort()����ArrayList�����������
 * 
 * */

//class AvrScore {
//	public double getAvrScore(ArrayList scoreArr) {
//		double avrScore = 0;
//		
//		
//		Collections.sort(scoreArr);;
//		scoreArr.remove(scoreArr.get(scoreArr.size() - 1));
//		scoreArr.remove(scoreArr.get(0));
//		
//		double sum = 0;
//		for (int i = 0; i < scoreArr.size(); i ++) {
//			sum += (Double) scoreArr.get(i);
//		}
//		return avrScore;
//		
//	}
//}