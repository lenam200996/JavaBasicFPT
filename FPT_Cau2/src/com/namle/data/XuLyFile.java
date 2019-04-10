package com.namle.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import com.namle.model.ThanhVien;

public class XuLyFile {
	private RandomAccessFile raf_data1;
	private RandomAccessFile raf_data2;
	private RandomAccessFile raf_error;
	
	private File file_data1;
	private File file_data2;
	private File file_error;
	public XuLyFile() {
		super();
		file_data1 = new File("D:\\JAVABasic\\FPT_Cau2\\src\\com\\namle\\data\\data1.txt"); // lấy đường dẫn file
		file_data2 = new File("D:\\JAVABasic\\FPT_Cau2\\src\\com\\namle\\data\\data2.txt");
		file_error = new File("D:\\JAVABasic\\FPT_Cau2\\src\\com\\namle\\data\\error.txt");
		
		try {
			raf_data1 = new RandomAccessFile(file_data1, "rw"); // rw là chế độ đọc/ghi 
			raf_data2 = new RandomAccessFile(file_data2,"rw");
			raf_error = new RandomAccessFile(file_error, "rw");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readFileData1(ArrayList<ThanhVien> arrThanhVien) {
		try {
			raf_data1.seek(0);// đưa con trỏ về đầu file
			while(raf_data1.getFilePointer() < raf_data1.length()) { // kiểm tra con trỏ đã ở cuối file hay chưa
				String dataLine = raf_data1.readLine(); // đọc từng dòng của file 
				String[] arrDataLine = dataLine.split(", "); // tạo mảng String lưu các giá trị tương ứng cách nhau bởi dấu phẩy và dấu cách
				
				ThanhVien tv = new ThanhVien(arrDataLine[0], arrDataLine[1], arrDataLine[2], arrDataLine[3], arrDataLine[4], arrDataLine[5], 0.0);
				// lưu giá trị của dòng vào đối tượng ThanhVien
				// bây giờ lưu vào mảng ThanhVien 
				
				arrThanhVien.add(tv);
				
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}


	public void readFileData2(ArrayList<ThanhVien> arrThanhVien) {
		try {
			raf_data2.seek(0);// đưa con trỏ về đầu file
			
			int line = 1; // tạo biến lưu số dòng đang đọc
			
			while(raf_data2.getFilePointer() < raf_data2.length()) {
				String dataLine = raf_data2.readLine(); /// đọc từng dòng
				String[] arrDataLine = dataLine.split(", "); 
				
				// cập nhật chi phí vào đối tượng ThanhVien trước !
				// lúc đọc file data1.txt ta mới chỉ gán giá trị chi phí nhận là 0
				
				if(KiemTraLoi.kiemTraLoiDuLieu(arrDataLine, arrThanhVien) != "") { // kiểm tra xem có lỗi hay không
					String err = "Dong "+line +": "+KiemTraLoi.kiemTraLoiDuLieu(arrDataLine, arrThanhVien) +"\n";
					writeFile(err); // lưu vào file error.txt
					
				}else {
				
					for(ThanhVien tv : arrThanhVien) {
						if(tv.getMaThanhVien().equals(arrDataLine[0])) { //Tìm mã thành viên tương ứng 
							//xác định level tương ứng
							if(arrDataLine[2].equals("VIP")) {
								tv.setChiPhiNhan(tv.getChiPhiNhan()+Double.parseDouble(arrDataLine[1])*50000);
							}else {
								tv.setChiPhiNhan(tv.getChiPhiNhan()+Double.parseDouble(arrDataLine[1])*20000);
							}
						}
					}
				}
				
				
				line++; // tăng số dòng sau mỗi vong while
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	public void writeFile(String output) { // phuwogn thức ghi file 
		try {
			raf_error.writeBytes(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
