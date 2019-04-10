package com.namle.controller;

import java.util.ArrayList;

import com.namle.data.XuLyFile;
import com.namle.model.ThanhVien;

public class QuanLy {
	private XuLyFile xuLyFile ;
	private static ArrayList<ThanhVien> arrThanhVien;
	public QuanLy() {
		super();
		xuLyFile = new XuLyFile();
		arrThanhVien = new ArrayList<ThanhVien>();
		
	}
	
	public void saveDB() {
		xuLyFile.readFileData1(arrThanhVien); 
		for(ThanhVien tv : arrThanhVien) {
			tv.saveDB();
		}
		
	}
	
	public void updateDB() {
		xuLyFile.readFileData2(arrThanhVien);
		for(ThanhVien tv : arrThanhVien) {
			//update database
			tv.updateDB();
		}
	}
	
	

}
