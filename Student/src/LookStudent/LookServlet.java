package LookStudent;
import Student.Student;
import Student.studentsx;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LookServlet")
public class LookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		String referer=request.getHeader("referer");
		if(referer.contains("/Student/LookStudentOne.html")) {
			Student student=new Student();
			student.setId(request.getParameter("id"));
			student=new studentsx().findOne(student);
			response.getWriter().write(student.toString());
			
		}else if(referer.contains("/Student/left.html")){
			StringBuilder stringBuilder=new StringBuilder();
			List<Student> list=new studentsx().findAll();
			for(Student student:list) {
				stringBuilder.append(student.toString()).append("<br />");
			}
			response.getWriter().write(stringBuilder.toString());
		}
	}

}
