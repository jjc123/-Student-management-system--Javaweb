package DeleteStudent;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Student.Student;
import Student.studentsx;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Student student=new Student();
		student.setId(request.getParameter("id"));
		boolean delete=new studentsx().deleteStudent(student);
		response.setContentType("text/html;charset=utf-8");
		if(delete) {
			response.getWriter().write("<script language=javascript>alert('删除成功！');top.showframe.location.href='DeleteStudent.html';</script>");
		}else {
			response.getWriter().write("<script language=javascript>alert('删除失败！');top.showframe.location.href='DeleteStudent.html';</script>");
		}
	}

}
