package Han_JavaSE;

import java.util.*;

/**
 * @author ���� ð�ݡ�ѡ�񡢲��������ʵ�֣����١��ϲ�����ing...
 *         ����������ظ����ļ���ʵ�֣�˫ѭ����hashSet��hashMap��arrayList��
 */
public class Sorting {
	public final static int LEN = 50;

	/*
	 * �������ָ����Χ��n�����ظ�����
	 * 
	 * @param max ָ����Χ������
	 * 
	 * @param min ָ����Χ������
	 * 
	 * @param n ��������
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
	 * ��hashMap������N�����ظ�����
	 */

	public static int[] randomArr_hashMap() {

		int[] result = new int[LEN];
		Object[] arr = new Object[LEN];

		// ���Math.random()������Random��������
		Random random = new Random();
		HashMap<Object, Object> hashMap = new HashMap<>();

		// ����������ֲ�����HashMap
		/*
		 * �������˴�nextInt(N)���N�������length��ϵ������ʲô������֤��
		 * NԽ�ӽ�length������ֱ�ӳ����Ľ��Խ�����������򣩡����ҵ�N�����㹻�� ���������length�����顣�磺N=1000,
		 * length=50, ������Լ48����
		 */
		for (int i = 0; i < arr.length; i++) {
			int number = random.nextInt(2000) + 1;
			hashMap.put(number, i);		//��Ϊ���浼�������õ���keySet�� ���������number ��i ��˳�򷴹�������hashMap
		}

		// ��HashMap��������
		arr = hashMap.keySet().toArray();

		// �������鲢��ӡ����
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
		 * �����ַ��������������⣺1��û�в��أ�2��ֻ�ܲ�����Ȼ��
		 */
		// int[] arr = new int[LEN];
		// for ( int i = 0; i < LEN; i ++) {
		// arr[i] = (int) (Math.random()*LEN);
		// }

		// ��һ�ַ�����˫ѭ��ʵ�֣�����һ��ѭ�������أ�
		// int[] arr = randomArr_doubleLoop(1000, -1000, 1000);

		// �ڶ��ַ�������HashSMap�����壬��������ظ���
		int[] arr = randomArr_hashMap();
		// System.out.println(Arrays.toString(arr));

		/*
		 * ���ϼ�����Ƚ϶��ԣ�ʹ��HashMap��Ч���ǱȽϸߵģ� ��ʵ��HashSet���ٴ������飬�����ArrayList��
		 * �����������10000�����ݽ��ᷢ�֣�ʹ��HashMap����ʱ���ǣ�0.05s��
		 * HashSet��0.07s�������ǣ�0.20s����ArrayList��0.25s��
		 * 
		 */

		System.out.println("����ǰ��");
		System.out.println(Arrays.toString(arr));

		/*
		 * //bubble��ʵ�� BubbleSorting bubbleSorting = new BubbleSorting();
		 * System.out.println(bubbleSorting.sort(arr));
		 */

		// bubble�����arr˳���Ѿ��ı�
		// System.out.println(Arrays.toString(arr));

		// ѡ�������ʵ��
		SelectSorting selectSorting = new SelectSorting();

		// ��calendar��ͳ��ʱ��
		// Calendar calendar = Calendar.getInstance();
		// calendar.getTime();

		System.out.println("�����");
		System.out.println(selectSorting.sort(arr));

	}

}

class BubbleSorting {
	public String sort(int[] arr) {
		int[] result;
		int temp = 0;
		// ���ѭ��������һ���ż���
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}

		}

		// �������ֱ��
		result = arr;

		return Arrays.toString(result);
	}
}

class SelectSorting {
	public String sort(int[] arr) {
		int[] result;

		for (int i = 0; i < arr.length - 1; i++) {

			// minValue �� Indexÿһ�鶼��Ҫ��ģ����Բ��˷���for�����ʼ��
			int minValue = arr[i];
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < minValue) {
					minValue = arr[j];
					index = j;
				}
			}

			// ���ֽ�����û������ģ���һ���ҵ�-4���ڶ���û�б�-4��С���±겻��䣬���²���
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
			// arr[index]���������������ұ���������ķֽ�
			int index = i - 1;
			while (index >= 0 && arr[index] > insertValue) {
				// arr[index]�����ƶ�
				arr[index + 1] = arr[index];
				// index����������ң�ֱ�����ʵ�λ�ò���insertValue
				// ��insertValue����arr[index]
				index--;
			}
			// ����ǰ��Сֵ���뵽index�ҵ�λ�õ��ұ�һλ
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
 * �ϲ�������Ҫ���ļ������в��� ÿ�δ�Ӳ�̵�һ�������ݵ��ڴ��������Ȼ��ϲ����ʺ��������ǳ��Ӵ������
 */

class MergeSorting {
	public String sort(int[] arr) {
		int[] result;

		result = arr;
		return Arrays.toString(result);
	}
}}