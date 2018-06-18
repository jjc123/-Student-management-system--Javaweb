package background;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取服务器内置的账号密码信息
		String name=this.getInitParameter("name");
		String pwd=this.getInitParameter("pwd");
		
		//response.setCharacterEncoding("utf-8");
		//response.setHeader("content-type", "text/html");
		resp.setContentType("text/html;charset=utf-8");//和上面代码等价。推荐使用此方法
		
		PrintWriter out = resp.getWriter();
		if(req.getParameter("username").equals(name)&&req.getParameter("password").equals(pwd)) {
	        resp.getWriter().write("<script language=javascript>alert('登陆成功！');window.location = 'index.html';</script>");
	        
		}else {
			//out.println("<script type='text/javascript'> alert('账号或者密码错误')</script>");
			//resp.sendRedirect("/Student/Login.html");
			//因为无法提示信息后再跳转 故不用页面跳转，sendRedirect是页面跳转
			resp.getWriter().write("<script language=javascript>alert('账号或者密码错误，请重新输入');window.location = 'Login.html';</script>");
		}
	}

}
