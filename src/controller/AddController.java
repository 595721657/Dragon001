package controller;
/**
 * �����û���Ϣ��servlet
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
		//���ñ����ʽ
		request.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("text/charset");
		//����һ��service����
		UsersServiceImpl us=new UsersServiceImpl();
		//���ǰ��ҳ�������
		String name=request.getParameter("names");
		int age=Integer.parseInt(request.getParameter("ages"));
		//����һ���û�����
		Users user=new Users();
		user.setName("����");
		user.setAge(12);
		//�����û��ķ���
		us.save(user);
	}

}
