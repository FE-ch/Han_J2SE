package Han_JavaSE;
import java.util.*;

/**
 * @author 先生
 * @category 二分查找
 */
public class Search {
	public final static int LENGTH = 20;
	public final static int BOUND = 500;
	
	/*
	 * ？？？会间歇性出现ArraysOutofBoundException
	 * */
	public static int[] randomArr_hashMap(int len, int bound) {
		int[] result = new int[len];
		Object[] arr = new Object[len];
		
		Random random = new Random();
		HashMap<Object, Object> hashMap = new HashMap<>();
		
		for (int i = 0; i < arr.length; i ++) {
			int num = random.nextInt(bound) + 1;
			hashMap.put(num, i);
		}
		
		arr = hashMap.keySet().toArray();
		
		for (int i = 0; i < result.length; i ++) {
			result[i] = (int) arr[i];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
//		int[] arr = randomArr_hashMap(LENGTH, BOUND);
//		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		
		int[] arr = {3, 7, 9, 10, 15, 21, 23, 32, 41, 67};
		int[] de = arr.clone();
		
		//改为静态方法不用new 新对象
//		BinarySearch binarySearch = new BinarySearch();
	
		System.out.println("找到" + 10 + "的下标" + BinarySearch.searchRecur(0, arr.length - 1, arr, 10));
		System.out.println("找到" + 10 + "的下标" + BinarySearch.searchNonrecur(de, 10));
	}

}


class BinarySearch {
	public static int searchRecur(int left, int right, int[] srcArray, int des) {
		
		int leftIndex = left;
		int rightIndex = right;
		int midIndex = (leftIndex + rightIndex) / 2;

//		if (leftIndex > rightIndex || arr.length == 0) {
//			System.err.println("none value.");;
//		}

//		boolean found = false;
		if (leftIndex <= rightIndex) {
			if (des < srcArray[midIndex]) {
				return searchRecur(leftIndex, midIndex - 1, srcArray, des);
			} else if (des > srcArray[midIndex]) {
				return searchRecur(midIndex + 1, rightIndex, srcArray, des);
			} else if (des == srcArray[midIndex]) {
//				found = true;
				return midIndex;
			} else {
				System.out.println("没有找到" + des);
			}
		}
		return -1;
	}
	
	public static int searchNonrecur(int[] srcArray, int des) {
		int leftIndex = 0;
		int rightIndex = srcArray.length - 1;
		
		while ((leftIndex <= rightIndex) && (leftIndex < srcArray.length) 
				&& (rightIndex < srcArray.length)) {
			int midIndex = leftIndex + ((rightIndex - leftIndex) >> 1);
			if (des < srcArray[midIndex]) {
				rightIndex = midIndex - 1;
			} else if (des > srcArray[midIndex]) {
				leftIndex = midIndex + 1;
			} else if (des == srcArray[midIndex]) {
				return midIndex;
			}
		}
		
		return -1;
	}
}
