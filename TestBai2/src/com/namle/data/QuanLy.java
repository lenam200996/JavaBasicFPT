package com.namle.data;

import java.util.ArrayList;

import com.namle.model.ThanhVien;

public class QuanLy {

	private XuLyFile xuLyFile;
	private static ArrayList<ThanhVien> arrThanhVien;
	public QuanLy() {
		super();
		xuLyFile = new XuLyFile();
		arrThanhVien = new ArrayList<ThanhVien>();
		
		
		
	}
	
	public void saveDB() {
		xuLyFile.readFile(arrThanhVien);
	
		for(ThanhVien tv : arrThanhVien) {
			tv.saveDB();
		}
		
		
	}
	
	
	public void updateDB() {
		xuLyFile.readFileData2(arrThanhVien);
		for(ThanhVien tv : arrThanhVien) {
			tv.updateDB();
		}
	}
	
}
