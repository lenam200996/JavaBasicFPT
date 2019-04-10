package com.namle.data;

import java.util.ArrayList;

import com.namle.model.ThanhVien;
import com.namle.sql.ConnectSQL;

public class KiemTraLoi {
 public static String kiemTraLoiDuLieu(String[] data, ArrayList<ThanhVien> arrThanhVien) {
	 ConnectSQL con = new ConnectSQL();
	 con.connectDB();
	 String err = "";
	 boolean ktMa = true;
	 
	 for(ThanhVien tv: arrThanhVien) {
		 if(tv.getMaThanhVien().equals(data[0])) {
			 ktMa = false;
		 }
	 }
	 if(ktMa) {
		 err += "Ma thanh vien khong ton tai!,";
	 }
	 
	 
	 if(Double.parseDouble(data[1]) <0.0 ) {
		 err += " Diem thuong khong phai la so nguyen duong,";
	 }
	 

	 if(Double.parseDouble(data[1]) > 500 ) {
		 err += " Diem thuong lon hon 500,";
	 }
	 
	 if(!data[2].equals("VIP") && !data[2].equals("NOR")) {
		 err+= " Level khong phai dang VIP hoac NOR";
	 }
	 return err;
 }
}
