package Han_JavaSE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class DemoException {

	public static void main(String[] args) {
		//������쳣
		//1�����ļ�
		
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("D:\\S\\reumen.txt");
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
					
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//2�����Ӷ˿�
		
//		����catch�쳣��ʱ��Ҫ̫ϸ��һ����catch�����쳣����
		
//		try {
//			Socket socket = new Socket("192.168.1.23", 78);
//			System.out.println(socket.getInetAddress());
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//�����쳣
		//1����ĸΪ0
//		int a = 4/0;
		
		//2������Խ��
//		int[] a = {1, 2, 3};
//		try {
//			if ()
//			System.out.println(a[123]);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//����
		
	}

}
