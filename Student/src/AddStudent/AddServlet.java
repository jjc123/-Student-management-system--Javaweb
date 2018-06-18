package AddStudent;

import java.io.IOException;
import Student.studentsx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Student.Student;
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Student student=new Student();
		student.setAdress(request.getParameter("adress"));
		student.setAge(Integer.parseInt(request.getParameter("age")));
		student.setGender(request.getParameter("gender"));
		student.setId(request.getParameter("id"));
		student.setName(request.getParameter("name"));
		student.setPhone(request.getParameter("phone"));
		student.setQQ(request.getParameter("QQ"));
		String choise=request.getParameter("field＿name");
		if("Add".equals(choise)) {
			new studentsx().addStudent(student);
			response.getWriter().write("<script language=javascript>alert('修改成功！');</script>");
		}else if("Change".equals(choise)) {
			if(new studentsx().updateStudent(student)) {
				response.getWriter().write("<script language=javascript>alert('修改成功！');</script>");
			}else {
				response.getWriter().write("<script language=javascript>alert('修改失败，重新输入！');;</script>");
			}
		}
	}
}
