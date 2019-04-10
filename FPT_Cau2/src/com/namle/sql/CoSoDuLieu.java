package com.namle.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CoSoDuLieu {
	private static Connection con  = null;
	private static Statement st = null;
	
	public void connectDB() { // phương thức kết nối sql server
		// các tham số cần khi kết nối có tài khoản sa
		String connectString = "jdbc:sqlserver://localhost:1433;databaseName=DBTourDuLich_00001";
		String username = "sa"; // tài khoản
		String password = "123456"; // mật khẩu
		// kết nối không cần tài khoản sa
		//String connectString = "jdbc:sqlserver://localhost:1433;databaseName=DBTourDuLich_00001;integratedSecurity=True";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//DriverManager.getConnection(connectString); // với trường hợp kết nối với sqlserver không cần tài khoản sa
			con = DriverManager.getConnection(connectString, username, password); //cần tài khoản sa
			System.out.println("Thanh cong"); // kiem tra kết nối
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveDB(String sql) {
		connectDB();  // chúng ta chuyển hàm connectDB qua đây để đảm bảo mọi hoạt động về database chỉ nằm trong class này!!
		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			
			System.out.println("Insert thanh cong!"); // kiểm tra xem đã lưu thành công hay chưa?
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
