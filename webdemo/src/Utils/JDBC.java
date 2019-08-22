package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class JDBC {
	static Connection conn = null;
	static PreparedStatement psmt = null;
	static ResultSet rs = null;

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		// ��������
		Class.forName("com.mysql.jdbc.Driver");
		//���ݿ�����
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/qau?characterEncoding=utf-8",
				"root", "root");
		return conn;
	}
          //��ѯ����
	public static ResultSet query(String sql, Map map) throws SQLException,
			ClassNotFoundException {
		conn = JDBC.getConnection();
		for (Object key : map.keySet()) {
			sql += ("  and  " + key.toString() + "   =?  ");

		}

		psmt = conn.prepareStatement(sql);
		int index = 1;
		for (Object key : map.keySet()) {
			psmt.setString(index, map.get(key).toString());
			;
			index++;
		}
		// ��ѯ�������
		rs = psmt.executeQuery();
		return rs;

	}
        //���²���
	public static int edit(String sql) throws ClassNotFoundException,
			SQLException {
		getConnection();
		return conn.prepareStatement(sql).executeUpdate();

	}

}
