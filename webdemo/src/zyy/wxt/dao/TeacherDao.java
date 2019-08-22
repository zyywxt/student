package zyy.wxt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Utils.JDBC;
import zyy.wxt.pojo.Student;
import zyy.wxt.pojo.Teacher;

public class TeacherDao {

	

	public List<Teacher> query(Map<String, String>  map) throws SQLException,
			ClassNotFoundException {
		
		List<Teacher> list = new ArrayList<>();
		Connection conn = JDBC.getConnection();
		String sql = "select * from t_teacher where 1=1 ";
		for(String key : map.keySet()){
			if (key != null && !"".equals(key)) {
				sql += " and " + key + " like ? ";
			
			}
		}
		PreparedStatement pstm = conn.prepareStatement(sql);
		int index = 1;
		for (String key : map.keySet()) {
			if (key != null && !"".equals(key)) {
				pstm.setString(index, map.get(key));
				index ++;
			}
			
			
		
		}
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			Teacher t = new Teacher();
			t.setClzss(rs.getString("clzss"));
			t.setId(rs.getInt("id"));
			t.setInstitusion(rs.getString("institusion"));
			t.setSalary(rs.getString("salary"));
			t.setTname(rs.getString("tname"));

			list.add(t);
		}

		return list;
	}

	public void update(Teacher t) throws ClassNotFoundException, SQLException {
		Connection conn = JDBC.getConnection();
		String sql = "update t_teacher set tname=?,salary=?,clzss=?,institusion=? where id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, t.getTname());
		pstm.setString(2, t.getSalary());
		pstm.setString(3, t.getClzss());
		pstm.setString(4, t.getInstitusion());
		pstm.setInt(5, t.getId());
		pstm.executeUpdate();

	}

	public void insert(Teacher t) throws ClassNotFoundException, SQLException {
		Connection conn = JDBC.getConnection();
		String sql = "insert into t_teacher (tname,salary,clzss,institusion) values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, t.getTname());
		ps.setString(2, t.getSalary());
		ps.setString(3, t.getClzss());
		ps.setString(4, t.getInstitusion());
		ps.executeUpdate();
	}

	public void delete(String id) throws ClassNotFoundException, SQLException {
		Connection conn = JDBC.getConnection();
		String sql = "delete from t_teacher where id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		if (id!= null && !"".equals(id)) {
			pstm.setInt(1,Integer.valueOf(id));
		} else {
			pstm.setInt(1, 0);
		}

		pstm.executeUpdate();
	}
	
}
