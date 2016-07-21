package Han_JavaSE;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author 先生
 * @category 简易的管理系统
 */
public class DemoCollection {

	public static <T> void main(String[] args) throws NumberFormatException, IOException {

//		ArrayList<T> arrayList = new ArrayList<>();
//		Clerk clerk_1 = new Clerk("Henry", 23, 3500);
//		Clerk clerk_2 = new Clerk("Shawn", 24, 4000);
//		Clerk clerk_3 = new Clerk("Babara", 20, 3200);
//		
////		注意：可重复添加，每次都添加到列表末端
//		arrayList.add((T) clerk_1);
//		arrayList.add((T) clerk_2);
//		arrayList.add((T) clerk_3);
//		
//		//删除
//		arrayList.add((T) clerk_1);
//		arrayList.remove(0);
//		
//		
//		//遍历
//		for (int i = 0; i < arrayList.size(); i ++) {
//			Clerk temp = (Clerk) arrayList.get(i);
//			System.out.println(temp.getName());
//		}
		
		ManageClerk manageClerk = new ManageClerk();
		
		while(true) {
			System.out.println("Please choose your operation:");
			System.out.println("1.Add a clerk");
			System.out.println("2.Show the information of an certain clerk");
			System.out.println("3.Set someone's salary");
			System.out.println("4.Delete someone from your system");
			System.out.println("5.Exit");
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			switch (bufferedReader.readLine()) {
			case "1":
				System.out.println("Please input the number of clerk:");
				String number = bufferedReader.readLine();
				System.out.println("Please input the name of the clerk");
				String name = bufferedReader.readLine();
				System.out.println("Please input the age of the clerk");
				int age = Integer.parseInt(bufferedReader.readLine());
				System.out.println("Please input the salary of the clerk");
				double salary = Double.parseDouble(bufferedReader.readLine());
				manageClerk.addClerk(new Clerk(number, name, age, salary));
				break;
			case "2":
				System.out.println("Please input the number of the clerk you want to check");
				String checkNumber = bufferedReader.readLine();
				manageClerk.showClerkInfo(checkNumber);
				break;
			case "3":
				System.out.println("Please input the number of the clerk");
				String setNumber = bufferedReader.readLine();
				System.out.println("Please input the salary you want to give");
				double setSalary = Double.parseDouble(bufferedReader.readLine());
				manageClerk.setSalary(setNumber, setSalary);
				break;
			case "4":
				System.out.println("Please input the number of the clerk you want to delete");
				String delNumber = bufferedReader.readLine();
				manageClerk.deleteClerk(delNumber);
				break;
			case "5":
				System.exit(0);

			default:
				break;
			}
			
		}
		
		
	}

}

class ManageClerk {
	private ArrayList arrayList = null;
	
	public ManageClerk() {
		arrayList = new ArrayList();
 	}
	
	//Here comes a freshman
	public void addClerk(Clerk clerk) {
		arrayList.add(clerk);
	}
	
	//Show the information of an certain clerk
	public void showClerkInfo(String number) {
		for (int i = 0; i < arrayList.size(); i ++) {
			Clerk temp = (Clerk) arrayList.get(i);
			if (temp.getNumber().equals(number)) {		//此处千万不要用==
				System.out.println("No." + number + "\'s info has been found as follows:");
				System.out.println("Name: " + temp.getName());
				System.out.println("Age: " + temp.getAge());
				System.out.println("Salary: " + temp.getSalary());
			}
		}
	}
	
	//Set the salary of an certain clerk
	public void setSalary(String number, double salary) {
		for (int i = 0; i < arrayList.size(); i ++) {
			Clerk temp = (Clerk) arrayList.get(i);
			
			if (temp.getNumber().equals(number)) {
				temp.setSalary(salary);
			}
		}
	}
	
	//Remove the information of an certain clerk when leave
	public void deleteClerk(String number) {
		for (int i = 0; i < arrayList.size(); i ++) {
			Clerk temp = (Clerk) arrayList.get(i);
			
			if (temp.getNumber().equals(number)) {
				arrayList.remove(i);
			}
		}
	}
}

class Clerk {
	private String number;
	public void setNumber(String number) {
		this.number = number;
	}
	private String name;
	private int age;
	private double salary;
	
	public Clerk(String number, String name, int age, double salary) {
		super();
		this.number = number;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getNumber() {
		return number;
	}
	
	
}