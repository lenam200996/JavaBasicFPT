package com.namle.main;

import com.namle.controller.QuanLy;
import com.namle.sql.CoSoDuLieu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuanLy quanLy = new QuanLy();
		quanLy.saveDB();
		quanLy.updateDB(); 
	}

}
