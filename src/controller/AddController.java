package controller;
/**
 * 操作用户信息的servlet
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Users;
import service.impl.UsersServiceImpl;
@WebServlet("/Add")
public class AddController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("text/charset");
		//创建一个service对象
		UsersServiceImpl us=new UsersServiceImpl();
		//获得前端页面的内容
		String name=request.getParameter("names");
		int age=Integer.parseInt(request.getParameter("ages"));
		//创建一个用户对象
		Users user=new Users();
		user.setName("张三");
		user.setAge(12);
		//保存用户的方法
		us.save(user);
	}

}
