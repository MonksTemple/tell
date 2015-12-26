package tell.server.dao;
import tell.server.model.User;

public interface UserDao {
	
	//�ж��Ƿ���ڸ��û�
	public Boolean exist(User user);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	//ɾ���û���ʱ�򣬻�ɾ�������ж�Ӧ���Ŷӳ�Ա�ͻ��Ա��¼         
	//---ע�����ô˷���ǰҪ���� TeamDaoImpl �е�deleteTeam����ɾ�������䴴�����Ŷӣ�
	//                    ���� NotificationDaoImpl �е�deleteNotification����ɾ�����������е�֪ͨ��Ϣ��
	public void deleteUser(int userId);
	

}