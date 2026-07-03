package ch11.practice;

import java.io.IOException;

//11강 확인문제 8
class FileWriter implements AutoCloseable{
	public FileWriter(String filepath) throws IOException{
		System.out.println(filepath + "파일을 엽니다.");
	}
	public void write(String data) throws IOException{
		System.out.println(data + "를 파일에 저장합니다.");
	}
	@Override
	public void close() throws IOException {
		System.out.println("파일을 닫습니다.");		
	}
}
public class FileWriterExample {
	public static void main(String[] args) {
		try(FileWriter fw = new FileWriter("file.txt")){
			fw.write("Java");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
