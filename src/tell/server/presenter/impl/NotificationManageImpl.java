package tell.server.presenter.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import com.server.presenter.NotificationManage;
import tell.server.dao.NotificationDao;
import tell.server.dao.TeamDao;
import tell.server.dao.impl.NotificationDaoImpl;
import tell.server.dao.impl.TeamDaoImpl;
import tell.server.model.Notification;

public class NotificationManageImpl extends UnicastRemoteObject implements NotificationManage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotificationManageImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addNotification(Notification notification) {
		NotificationDao notificationDao = new NotificationDaoImpl();
		notificationDao.addNotification(notification);
		
	}
	
	public void updateNotification(Notification notification) {
		NotificationDao notificationDao = new NotificationDaoImpl();
		notificationDao.updateNotification(notification);
		String str = notification.getDescription();
		if(str.contains("邀请您加入该团队")){            //如果是同意邀请信息则加入团队 用户信息
			String[] strBuf = str.split("<|:|>|+|+| "); 
			if(strBuf[4].equals("Y")){
				int no = Integer.valueOf(strBuf[1]);
				int userId = Integer.valueOf(strBuf[5]);
				TeamDao teamDao = new TeamDaoImpl();
				teamDao.addMember(no, userId);
			}

		}
	}
}
