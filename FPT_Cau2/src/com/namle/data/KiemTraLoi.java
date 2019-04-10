package com.namle.data;

import java.util.ArrayList;

import com.namle.model.ThanhVien;

public class KiemTraLoi {

	public static String kiemTraLoiDuLieu(String[] arrDataLine , ArrayList<ThanhVien> arrThanhVien) {
		String err = ""; // chuỗi tổng hợp lỗi nếu có
		//Bắt được lỗi không tồn tại mã thành viên trong database
		// có 2 cách : c1: các bạn truy vẫn vào database ứng với mã đọc được từ file
		//c2:  mình sẽ kiểm tra ngay trong arraylist
		
		boolean kiemTraMa = true;
		for(ThanhVien tv : arrThanhVien) {
			if(tv.getMaThanhVien().equals(arrDataLine[0])) {
				kiemTraMa = false;
			}
		}
		
		// kiểm tra và lưu kết quả lỗi nếu có
		
		if(kiemTraMa) {
			err += "Ma thanh vien chua ton tai!, ";
		}
		
		//Nếu điểm thưởng không phải là số nguyên dương
		 if(Double.parseDouble(arrDataLine[1]) < 0.0) {
			 err += "Diem thuong khong phai la so nguyen duong!, ";
		 }
		 
		 //Nếu điểm thưởng là số vượt quá 500 thì bị lỗi
		 
		 if(Double.parseDouble(arrDataLine[1]) > 500) {
			 err += "Diem thuong lon hon 500!, ";
		 }
		//Bắt được lỗi sai định dạng Level
		 
		 
		 if(!arrDataLine[2].equals("VIP") && !arrDataLine[2].equals("NOR")) {
			 err += "Level khong dung dinh dang!";
		 }
		 
		 
		 //== trả về tập hợp lỗi
		 return err;
	}
}
