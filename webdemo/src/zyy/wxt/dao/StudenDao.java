package zyy.wxt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zyy.wxt.pojo.Student;
import Utils.JDBC;

public class StudenDao {

	public List<Student> query(String sname, String stuno)
			throws ClassNotFoundException, SQLException {
		List<Student> list = new ArrayList<>();
		Connection conn = JDBC.getConnection();
		String sql = "select * from t_student where stu_name like ?";
		if (stuno!=null&&!"".equals(stuno)) {
			sql += " and stu_no=? ";
		}
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, "%" + (sname==null?"":sname)+ "%");
		if (stuno!=null&&!"".equals(stuno)) {
			pstm.setString(2, stuno);
		}

		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			Student s = new Student();
			s.setId(rs.getInt("id"));
			s.setStuNo(rs.getString("stu_no"));
			s.setStuName(rs.getString("stu_name"));
			s.setSex(rs.getString("sex"));
			s.setAge(rs.getInt("age"));
			s.setClzss(rs.getString("clzss"));
			list.add(s);
		}

		return list;
	}
//插入操作
	public void insert(String stuName, String stuNo, String sex, String age,
			String stuClzss) throws ClassNotFoundException, SQLException {
		Connection conn = JDBC.getConnection();
		String sql = "insert into t_student (stu_name,stu_no,sex,age,clzss) values(?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, stuName);
		pstm.setString(2, stuNo);
		pstm.setString(3, sex);
		pstm.setString(4, age);
		pstm.setString(5, stuClzss);
		pstm.executeUpdate();
	}

	public void delete(String id) throws ClassNotFoundException, SQLException {
		Connection conn = JDBC.getConnection();
		String sql = "delete from t_student where id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		if (id!= null && !"".equals(id)) {
			pstm.setInt(1,Integer.valueOf(id));
		} else {
			pstm.setInt(1, 0);
		}

		pstm.executeUpdate();
	}
	
    //更新操作
	public void update(String stuName, String stuNo, String sex, String age, String stuClzss, String id) throws ClassNotFoundException, SQLException {
             Connection   conn=JDBC.getConnection();	
             String sql="update t_student set stu_name=?,stu_no=?,sex=?,age=?,clzss=?  where id=?";
             PreparedStatement pstm=conn.prepareStatement(sql);
             pstm.setString(1, stuName);
             pstm.setString(2, stuNo);
             pstm.setString(3, sex);
             pstm.setString(4, age);
             pstm.setString(5, stuClzss);
             pstm.setInt(6, Integer.valueOf(id));
             
             pstm.executeUpdate();
             
	}

}
