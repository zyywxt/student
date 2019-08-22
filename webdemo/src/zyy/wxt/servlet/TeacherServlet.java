package zyy.wxt.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
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
import zyy.wxt.dao.TeacherDao;
import zyy.wxt.pojo.Student;
import zyy.wxt.pojo.Teacher;

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TeacherServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String act = request.getParameter("act");
		try {
			if ("query".equals(act)) {
				System.out.println("进行query方法。。。");
				query(request, response);

			} else if ("edit".equals(act)) {
				edit(request, response);
				System.out.println("根据id获取原始数据,进行edit方法。。。");
			} else if ("updateInit".equals(act)) {
				System.out.println("根据id获取原始数据,进行updateInit方法。。。");
				updateInit(request, response);
			} else if ("delete".equals(act)) {
				delete(request, response);
				System.out.println("根据id获取原始数据,进行delete方法。。。");
			} else {
				query(request, response);
				System.out.println("操作失败");
			}
		} catch (Exception e) {
			System.out.println("程序运行时发生异常" + e.getMessage());
			e.printStackTrace();
		}

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher rd = request.getRequestDispatcher("html/teacher.jsp");
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		TeacherDao dao=new TeacherDao();
	    try {
			dao.delete(id);
		   rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 
	}

	private void updateInit(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException,
			SQLException, ServletException, IOException {
		String id = request.getParameter("id");
		Map<String, String> map = new HashMap<>();

		if (id != null && !"".equals(id)) {
			map.put("id", id);
			TeacherDao dao = new TeacherDao();
			List<Teacher> list = dao.query(map);

			if (list.size() > 0) {
				Teacher t = list.get(0);
				request.setAttribute("teacher", t);
			}
			RequestDispatcher rs = request.getRequestDispatcher("html/teacher_add.jsp");
			rs.forward(request, response);

		} else {
			request.setAttribute("mes", "要修改的数据异常,数据中没有id");
			query(request, response);
		}
		

	}

	private void edit(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("html/teacher.jsp");
		request.setCharacterEncoding("UTF-8");
		String tname = request.getParameter("tname");
		String salary = request.getParameter("salary");
		String clzss = request.getParameter("clzss");
		String institusion = request.getParameter("institusion");
		String id = request.getParameter("id");
		System.out.println(id);
		Teacher t = new Teacher();
		if (id != null && !"".equals(id)) {
			t.setId(Integer.valueOf(id));
		}
		if (tname != null && !"".equals(tname)) {
			t.setTname(tname);
			}
		if (clzss!= null && !"".equals(clzss)) {
			t.setClzss(clzss);
		}
		if (institusion!= null && !"".equals(institusion)) {
			t.setInstitusion(institusion);
		}
		
		if (salary != null && !"".equals(salary)) {
			t.setSalary(salary);
		}
		TeacherDao dao = new TeacherDao();
		
		if (id != null && !"".equals(id)) {
			dao.update(t);

		} else {
			dao.insert(t);
		}
		rd.forward(request, response);
	}

	

	public void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException,
			SQLException {
		String tName = request.getParameter("tName");
		String salary = request.getParameter("salary");
		String clzss = request.getParameter("clzss");
		String is = request.getParameter("is");
		Map<String, String> map = new HashMap<>();
		if (tName != null && !"".equals(tName)) {
			map.put("tname", "%" + (tName == null ? "" : tName) + "%");
		}
		if (salary != null && !"".equals(salary)) {
			map.put("salary", "%" + (salary == null ? "" : salary) + "%");
		}
		if (clzss != null && !"".equals(clzss)) {
			map.put("clzss", "%" + (clzss == null ? "" : clzss) + "%");
		}
		if (is != null && !"".equals(is)) {
			map.put("institusion", "%" + (is == null ? "" : is) + "%");

		}
		System.out.println(tName + "," + salary + "," + clzss + "," + is + ",");
		TeacherDao td = new TeacherDao();
		List<Teacher> list = td.query(map);
		System.out.println("我进行了query");
		request.setAttribute("teacherist", list);
		RequestDispatcher rd = request.getRequestDispatcher("html/teacher.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
