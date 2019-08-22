package zyy.wxt.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zyy.wxt.dao.StudenDao;
import zyy.wxt.pojo.Student;

/**
 * Servlet implementation class student
 */
@WebServlet("/studentservlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		StudentServlet s = new StudentServlet();
		try {
			s.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void forward(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, 
			SQLException, ClassNotFoundException {
		RequestDispatcher rd = request.getRequestDispatcher("html/student.jsp");
		//第一种编码方式
		request.setCharacterEncoding("utf-8");
		//第二种编码方式
		// if(sname!=null){
		// byte[] tempArr=sname.getBytes("ISO-8859-1");
		// sname=new String(tempArr,"UTF-8");
		// }
		String sname = request.getParameter("sname");
        String stuno=request.getParameter("stuno");
		System.out.println(sname);
		System.out.println(stuno);
		StudenDao sd = new StudenDao();
		List<Student> list = sd.query(sname, stuno);
		request.setAttribute("studentList", list);
		rd.forward(request, response);

	}
	//回应
	public void red(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		    response.sendRedirect("https://www.baidu.com");

	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		    doGet(request, response);
	}

}
