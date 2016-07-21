package Han_JavaSE;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author 先生
 * @category hashMap实现（？？？怎么用模板）
 * 注意：hashTable 是基于陈旧的Dictionary类 , hashMap是map接口的实现
 * 1、hashTable是同步的，性能开销大，线程安全
 * 2、hashMap是异步的，效率高，非线程安全
 * 3、hashTable中不能放入null值，hashMap可以
 */
public class DemoLinkedList {

	public static void main(String[] args) {
		Clerk clerk_1 = new Clerk("001", "Shawn", 24, 4000);
		Clerk clerk_2 = new Clerk("002", "Henry", 23, 4500);
		Clerk clerk_3 = new Clerk("003", "Fauk", 23, 4300);
		
		HashMap<String, Clerk> hashMap = new HashMap<>();
		
		//增
		hashMap.put(clerk_1.getNumber(), clerk_1);
		hashMap.put(clerk_2.getNumber(), clerk_2);
		hashMap.put(clerk_3.getNumber(), clerk_3);
		
		//删
		hashMap.remove("003");
		
		//查 (002) & 改
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
		
		//遍历，因为不能提前知道number值，所以用迭代器
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
