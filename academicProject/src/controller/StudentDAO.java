package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.DBUtil;
import model.StudentVO;

public class StudentDAO {
	// 학생 등록
	public void setStudentRegiste(StudentVO svo) throws Exception {
		String sql = "insert into student values(student_no_seq.nextval, ?,?,?<?,?,?,?,?,?,sysdate";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, svo.getSd_num());
			pstmt.setString(2, svo.getSd_name());
			pstmt.setString(3, svo.getSd_id());
			pstmt.setString(4, svo.getSd_passwd());
			pstmt.setString(5, svo.getS_num());
			pstmt.setString(6, svo.getSd_birthday());
			pstmt.setString(7, svo.getSd_phone());
			pstmt.setString(8, svo.getSd_address());
			pstmt.setString(9, svo.getSd_email());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println(svo.getSd_name() + "학생 등록 완료.");

			} else {
				System.out.println("학생 등록 실패");
			}
		} catch (SQLException se) {
			System.out.println("se =[" + se + "]");
		} catch (Exception e) {
			System.out.println("e =[" + e + "]");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {

			}
		}

	}

	// 학생 정보 수정
	public void setStudentUpdate(StudentVO svo) throws Exception {

		String sql = "update student set sd_pass=?, sd_phone=?m sd_address=?, sd_email=? where sd_num =?";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, svo.getSd_passwd());
			pstmt.setString(2, svo.getSd_phone());
			pstmt.setString(3, svo.getSd_address());
			pstmt.setString(4, svo.getSd_email());
			pstmt.setString(5, svo.getSd_num());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println(svo.getSd_num() + " : 학생 정보 수정 완료");

			} else {
				System.out.println("학생 정보 수정 실패");
			}
		} catch (SQLException se) {
			System.out.println("se =[" + se + "]");
		} catch (Exception e) {
			System.out.println("e =[" + e + "]");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {

			}
		}
	}

	// 동일 학과 학생 일련번호
	public String getStudentCount(String subjectNum) throws Exception {

		String sql = "select LPAD(count(*)+1, 4,'0' as studentCount from student where s_num = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String serialNumber = "";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, subjectNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				serialNumber = rs.getString("studentCount");
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				System.out.println(se);
			}
		}

		return serialNumber;

	}

	// 학생 아이디 중복 체크

	public boolean getStudnetIdOverlap(String idOverlap) throws Exception {

		String sql = "select * from student where sd_id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean idOverlapResult = false;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idOverlap);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				idOverlapResult = true; // 중복된 아이디가 있다.
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException se) {
				System.out.println(se);
			}

		}
		return idOverlapResult;
	}

	// 학생 로그인
	public boolean getStudentLogin(String id, String pw) throws Exception {

		String sql = "select * from student where sd_id = ? and sd_passwd = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean loginSuccess = false;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				loginSuccess = true; // 로그인 성공
			}

		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				System.out.println(se);
			}
		}
		return loginSuccess;
	}

	// 학생 번호
	public String getStudentNum(String id, String pw) throws Exception {

		String sql = "select sd_num from student where sd_id = ? and sd_passwd = ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sd_num = "";

		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sd_num = rs.getString("sd_num");
			}

		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException se) {
				System.out.println(se);
			}
		}
		return sd_num;
	}

	// 학생 정보
	public void getStudent(String id, String pw) throws Exception {

	}

}
