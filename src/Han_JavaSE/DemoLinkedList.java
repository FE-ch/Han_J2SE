package Han_JavaSE;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author ����
 * @category hashMapʵ�֣���������ô��ģ�壩
 * ע�⣺hashTable �ǻ��ڳ¾ɵ�Dictionary�� , hashMap��map�ӿڵ�ʵ��
 * 1��hashTable��ͬ���ģ����ܿ������̰߳�ȫ
 * 2��hashMap���첽�ģ�Ч�ʸߣ����̰߳�ȫ
 * 3��hashTable�в��ܷ���nullֵ��hashMap����
 */
public class DemoLinkedList {

	public static void main(String[] args) {
		Clerk clerk_1 = new Clerk("001", "Shawn", 24, 4000);
		Clerk clerk_2 = new Clerk("002", "Henry", 23, 4500);
		Clerk clerk_3 = new Clerk("003", "Fauk", 23, 4300);
		
		HashMap<String, Clerk> hashMap = new HashMap<>();
		
		//��
		hashMap.put(clerk_1.getNumber(), clerk_1);
		hashMap.put(clerk_2.getNumber(), clerk_2);
		hashMap.put(clerk_3.getNumber(), clerk_3);
		
		//ɾ
		hashMap.remove("003");
		
		//�� (002) & ��
		if (hashMap.containsKey("002")) {
			Clerk temp = (Clerk) hashMap.get("002");
			System.out.println("The information of number 002 is: ");
			System.out.printf("[%s\t%s\t%d\t%.2f]\n", temp.getNumber(), 
					temp.getName(), temp.getAge(), temp.getSalary());
			System.out.println("Reset salary:");
			temp.setSalary(6000);
			System.out.printf("[%s\t%s\t%d\t%.2f]\n", temp.getNumber(), 
					temp.getName(), temp.getAge(), temp.getSalary());
		} else {
			System.out.println("Not found.");
		}
		
		//��������Ϊ������ǰ֪��numberֵ�������õ�����
		System.out.println("Show all the clerks' info:");
		Iterator<String> iterator = hashMap.keySet().iterator();
		
		while (iterator.hasNext()) {
			String key = iterator.next().toString();
			Clerk temp = (Clerk) hashMap.get(key);
			System.out.printf("[%s\t%s\t%d\t%.2f]\n", temp.getNumber(), 
					temp.getName(), temp.getAge(), temp.getSalary());
		}
		
	}

}
