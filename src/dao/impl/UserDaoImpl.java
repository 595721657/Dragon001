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
	@Override
	public void save(Users user) {
     //����һ�����ϱ�����Ϣ
	  List<Users> list=new ArrayList<Users>();
	  list.add(user);
	  for (Users users : list) {
		System.out.println(users.getName()+","+users.getAge());
	   }
	}

}
