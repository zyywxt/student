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
 * Servlet implementation class StuUpdateServlet
 */
@WebServlet("/StuUpdateServlet")
public class StuUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String stuName=request.getParameter("stuName");
		if(stuName!=null){
			stuName=new String(stuName.getBytes("ISO-8859-1"),"UTF-8");
		}
		String stuNo=request.getParameter("stuNo");
		String sex=request.getParameter("sex");
		String  age=request.getParameter("age");
		String stuClzss=request.getParameter("clzss");
		if(stuClzss!=null){
			stuClzss=new String(stuClzss.getBytes("ISO-8859-1"),"UTF-8");
		}
		request.setAttribute("id",id);
		request.setAttribute("stuName", stuName);
		request.setAttribute("stuNo", stuNo);
		request.setAttribute("sex", sex);
		request.setAttribute("age", age);
		request.setAttribute("clzss", stuClzss);
		RequestDispatcher  rd=request.getRequestDispatcher("html/studentAdd.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
