package com.namle.model;

import com.namle.sql.CoSoDuLieu;

public class ThanhVien {
	private String maThanhVien;
	private String hoTenThanhVien;
	private String ngaySinh;
	private String diaChi;
	private String email;
	private String soDienThoai;
	private Double chiPhiNhan;

	public String getMaThanhVien() {
		return maThanhVien;
	}

	public void setMaThanhVien(String maThanhVien) {
		this.maThanhVien = maThanhVien;
	}

	public String getHoTenThanhVien() {
		return hoTenThanhVien;
	}

	public void setHoTenThanhVien(String hoTenThanhVien) {
		this.hoTenThanhVien = hoTenThanhVien;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public Double getChiPhiNhan() {
		return chiPhiNhan;
	}

	public void setChiPhiNhan(Double chiPhiNhan) {
		this.chiPhiNhan = chiPhiNhan;
	}

	public ThanhVien(String maThanhVien, String hoTenThanhVien, String ngaySinh, String diaChi, String email,
			String soDienThoai, Double chiPhiNhan) {
		super();
		this.maThanhVien = maThanhVien;
		this.hoTenThanhVien = hoTenThanhVien;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.chiPhiNhan = chiPhiNhan;
	}

	public ThanhVien() {
		super();
		this.chiPhiNhan = 0.0; // khởi tạo giá trị ban đầu cho chi phí nhận
	}

	@Override
	public String toString() {
		return "ThanhVien [maThanhVien=" + maThanhVien + ", hoTenThanhVien=" + hoTenThanhVien + ", ngaySinh=" + ngaySinh
				+ ", diaChi=" + diaChi + ", email=" + email + ", soDienThoai=" + soDienThoai + ", chiPhiNhan="
				+ chiPhiNhan + "]";
	}

	public void saveDB() {
		CoSoDuLieu coSoDuLieu = new CoSoDuLieu(); // tạo đối tượng cosodulieu để kết nối database

		// tạo câu lệnh sql để insert một bản ghi
		String sql = "insert into THANHVIEN values ('" + this.getMaThanhVien() + "','" + this.getHoTenThanhVien()
				+ "','" + this.getNgaySinh() + "','" + this.getDiaChi() + "','" + this.getEmail() + "','"
				+ this.getSoDienThoai() + "'," + this.getChiPhiNhan() + " )";

		coSoDuLieu.saveDB(sql);

	}
	
	public void updateDB() {
		CoSoDuLieu coSoDuLieu = new CoSoDuLieu(); // tạo đối tượng cosodulieu để kết nối database
		String sql = "update THANHVIEN set ChiPhiNhan = ChiPhiNhan +" +this.getChiPhiNhan() + "where MaThanhVien = '"+this.getMaThanhVien()+"'";
		coSoDuLieu.saveDB(sql);
	}

}
