package dao.impl;
import java.util.ArrayList;
import java.util.List;

/**
 * ʵ��dao�ӿ��еĲ�����
 */
import dao.UserDao;
import entity.Users;

public class UserDaoImpl implements UserDao {
    //�����û���Ϣ�ķ���
    //����һ�����ϱ�����Ϣ
	  List<Users> list=new ArrayList<Users>();
	@Override
	public void save(Users user) {
	  list.add(user);
	  for (Users users : list) {
		System.out.println(users.getName()+","+users.getAge());
	   }
	}

	@Override
	public void updat(Users user) {
		System.out.println("ִ���޸��û��ķ���������");
	}

}
