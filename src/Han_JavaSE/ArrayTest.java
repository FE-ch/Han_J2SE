package Han_JavaSE;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Dog[] dogs = new Dog[3];	//����Ĵ�С���ܴӿ���̨����

		BufferedReader bufferedReader = new 
				BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < dogs.length; i ++) {
			
			dogs[i] = new Dog();
			System.out.println("Please input the " + (i + 1) + " dog's name: ");
			String dogName = bufferedReader.readLine();
			dogs[i].setDogName(dogName);
			
			System.out.println("Please input the " + (i + 1) + " dog's weight: ");
//			int dogWeight = buffereeader.read();
//			������read(),ֻ�ܶ�һ����
			String dogWeight = bufferedReader.readLine();
			dogs[i].setDogWeight(Integer.parseInt(dogWeight));
		
		}
		
	}

}

/**
 * @author ���� ����dog��
 */
class Dog {
	public String dogName;
	public int dogWeight;
	
	public String getDogName() {
		return dogName;
	}
	public void setDogName(String dogName) {
		this.dogName = dogName;
	}
	public int getDogWeight() {
		return dogWeight;
	}
	public void setDogWeight(int dogWeight) {
		this.dogWeight = dogWeight;
	}
	
	public int getAvrWeight(Dog[] dogs) {
		
		int totalWeight = 0;
		int avrWeight = 0;
		for (int i = 0; i < dogs.length; i ++) {
			dogs[i] = new Dog();
			totalWeight += dogs[i].getDogWeight();
		}
		
		avrWeight = totalWeight/dogs.length;
		return avrWeight;
	}
	
	public int getMaxWeight(Dog[] dogs) {
		int maxWeight = 0;
		int maxIndex = 0;
		for (int i = 0; i < dogs.length; i ++) {
			dogs[i] = new Dog();
			
			if (dogs[i].getDogWeight() > maxWeight) {
				maxWeight = dogs[i].getDogWeight();
				maxIndex = i;
			}
			
		}
		
		return maxWeight;
	}
	
}