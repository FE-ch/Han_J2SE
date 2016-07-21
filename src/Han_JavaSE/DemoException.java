package Han_JavaSE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class DemoException {

	public static void main(String[] args) {
		//检查性异常
		//1、打开文件
		
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
		
		//2、连接端口
		
//		建议catch异常的时候不要太细，一次性catch所有异常即可
		
//		try {
//			Socket socket = new Socket("192.168.1.23", 78);
//			System.out.println(socket.getInetAddress());
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//运行异常
		//1、分母为0
//		int a = 4/0;
		
		//2、数组越界
//		int[] a = {1, 2, 3};
//		try {
//			if ()
//			System.out.println(a[123]);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//错误
		
	}

}
