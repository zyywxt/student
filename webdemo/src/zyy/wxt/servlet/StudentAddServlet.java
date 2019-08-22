package zyy.wxt.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zyy.wxt.dao.StudenDao;

/**
 * Servlet implementation class StudentAddServlet
 */
@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public StudentAddServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
		//System.out.println("添加信息成功");
		String id=request.getParameter("id");
	     String stuName=request.getParameter("stuName");
	     String stuNo=request.getParameter("stuNo");
	      String sex=request.getParameter("sex");
	        String  age=request.getParameter("age");
	          String stuClzss=request.getParameter("clzss");
	       StudenDao dao=new StudenDao();
	     try {
		 if(id!=null&&!"".equals(id)){
			dao.update(stuName,stuNo,sex,age,stuClzss,id);
			
		  }else {
			dao.insert(stuName, stuNo, sex, age, stuClzss);
		}
		
			
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 RequestDispatcher  rd=request.getRequestDispatcher("html/student.jsp");
			rd.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doGet(request,response);}
           
}
