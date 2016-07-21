package Han_JavaSE;

import java.util.*;

/**
 * @author 先生 冒泡、选择、插入排序的实现，快速、合并尝试ing...
 *         产生随机不重复数的几种实现（双循环、hashSet、hashMap、arrayList）
 */
public class Sorting {
	public final static int LEN = 50;

	/*
	 * 随机产生指定范围内n个不重复整数
	 * 
	 * @param max 指定范围的上限
	 * 
	 * @param min 指定范围的下限
	 * 
	 * @param n 产生个数
	 */

	public static int[] randomArr_doubleLoop(int max, int min, int n) {
		int[] result = new int[n];

		if (n > max - min + 1 || n < 0) {
			return null;
		}

		int count = 0;
		while (count < n) {
			boolean flag = false;

			int num = (int) (Math.random() * (max - min)) + min;
			for (int i = 0; i < n; i++) {
				if (num == result[i]) {
					flag = true;
					break;
				}
			}

			if (!flag) {
				result[count] = num;
				count++;
			}
		}

		return result;
	}

	/*
	 * 用hashMap来产生N个不重复整数
	 */

	public static int[] randomArr_hashMap() {

		int[] result = new int[LEN];
		Object[] arr = new Object[LEN];

		// 相对Math.random()，定义Random对象更灵活
		Random random = new Random();
		HashMap<Object, Object> hashMap = new HashMap<>();

		// 生成随机数字并存入HashMap
		/*
		 * ？？？此处nextInt(N)里的N和数组的length关系到底是什么，经验证，
		 * N越接近length，数组直接出来的结果越趋于有序（增序）。并且当N不是足够大， 会产生不足length的数组。如：N=1000,
		 * length=50, 仅产生约48个数
		 */
		for (int i = 0; i < arr.length; i++) {
			int number = random.nextInt(2000) + 1;
			hashMap.put(number, i);		//因为后面导入数组用的是keySet， 所以这里把number 和i 的顺序反过来存入hashMap
		}

		// 从HashMap导入数组
		arr = hashMap.keySet().toArray();

		// 遍历数组并打印数据
		// for(int i = 0;i < arr.length;i++){
		// System.out.print(arr[i] + "\t");
		//
		// if(( i + 1 ) % 9 == 0){
		// System.out.println("\n");
		// }
		// }
		// System.out.println();
		// System.out.println(arr.length);

		for (int i = 0; i < arr.length; i++) {
			result[i] = (int) arr[i];
		}

		return result;
	}

	public static void main(String[] args) {

		/*
		 * 用这种方法存在两个问题：1，没有查重；2，只能产生自然数
		 */
		// int[] arr = new int[LEN];
		// for ( int i = 0; i < LEN; i ++) {
		// arr[i] = (int) (Math.random()*LEN);
		// }

		// 第一种方案：双循环实现（其中一重循环来查重）
		// int[] arr = randomArr_doubleLoop(1000, -1000, 1000);

		// 第二种方案：用HashSMap来定义，不会出现重复数
		int[] arr = randomArr_hashMap();
		// System.out.println(Arrays.toString(arr));

		/*
		 * 以上几种相比较而言，使用HashMap的效率是比较高的， 其实是HashSet，再次是数组，最后是ArrayList。
		 * 如果我们生成10000个数据将会发现，使用HashMap花费时间是：0.05s，
		 * HashSet是0.07s，数组是：0.20s，而ArrayList是0.25s。
		 * 
		 */

		System.out.println("排序前：");
		System.out.println(Arrays.toString(arr));

		/*
		 * //bubble类实现 BubbleSorting bubbleSorting = new BubbleSorting();
		 * System.out.println(bubbleSorting.sort(arr));
		 */

		// bubble排序后，arr顺序已经改变
		// System.out.println(Arrays.toString(arr));

		// 选择排序的实现
		SelectSorting selectSorting = new SelectSorting();

		// 用calendar来统计时间
		// Calendar calendar = Calendar.getInstance();
		// calendar.getTime();

		System.out.println("排序后：");
		System.out.println(selectSorting.sort(arr));

	}

}

class BubbleSorting {
	public String sort(int[] arr) {
		int[] result;
		int temp = 0;
		// 外层循环，决定一共排几遍
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}

		}

		// 数组可以直传
		result = arr;

		return Arrays.toString(result);
	}
}

class SelectSorting {
	public String sort(int[] arr) {
		int[] result;

		for (int i = 0; i < arr.length - 1; i++) {

			// minValue 和 Index每一遍都是要变的，所以不宜放在for外面初始化
			int minValue = arr[i];
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < minValue) {
					minValue = arr[j];
					index = j;
				}
			}

			// 这种交换是没有意义的，第一遍找到-4，第二次没有比-4更小，下标不会变，更新不了
			// int temp = minValue;
			// minValue = arr[i];
			// arr[i] = temp;

			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}

		result = arr;
		return Arrays.toString(result);
	}
}

class InsertSorting {
	public String sort(int[] arr) {
		int[] result;

		for (int i = 1; i < arr.length; i++) {
			int insertValue = arr[i];
			// arr[index]是左边有序数组和右边无序数组的分界
			int index = i - 1;
			while (index >= 0 && arr[index] > insertValue) {
				// arr[index]向右移动
				arr[index + 1] = arr[index];
				// index继续相左查找，直到合适的位置插入insertValue
				// 即insertValue大于arr[index]
				index--;
			}
			// 将当前最小值插入到index找到位置的右边一位
			arr[index + 1] = insertValue;
		}

		result = arr;
		return Arrays.toString(result);
	}
}

class QuickSorting {
	public <T extends Comparable<?super T>>String sort(T[] arr, int start, int end) {
		T[] result;
		int i = start;
		int j = end;
		T key = arr[start];
		
		while (i < j) {
			while (i < j && arr[j].compareTo(key) >= 0) {
				j --;
			}
			
			if (i < j) {
				arr[i] = arr[j];
				i ++;
			}
			
			while (i < j && arr[i].compareTo(key) <= 0) {
				i ++;
			}
			
			if (i < j) {
				arr[j] = arr[i];
				j --;
			}
			
		}
		arr[i] = key;
		
		this.sort(arr, start, i - 1);
		
		this.sort(arr, j + 1, end);

	result=arr;return Arrays.toString(result);
}

/*
 * 合并排序：需要对文件流进行操作 每次从硬盘调一部分数据到内存进行排序，然后合并，适合数据量非常庞大的排序
 */

class MergeSorting {
	public String sort(int[] arr) {
		int[] result;

		result = arr;
		return Arrays.toString(result);
	}
}}