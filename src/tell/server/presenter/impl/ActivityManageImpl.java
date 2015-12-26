package tell.server.presenter.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Set;

import com.server.presenter.ActivityManage;
import tell.server.dao.ActivityDao;
import tell.server.dao.impl.ActivityDaoImpl;
import tell.server.model.Activity;
import tell.server.model.User;

public class ActivityManageImpl extends UnicastRemoteObject implements ActivityManage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActivityManageImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addActivity(Activity activity){
		ActivityDao activityDao = new ActivityDaoImpl();
		activityDao.addActivity(activity);
	}
	
	public void modifyActivity(Activity activity){
		ActivityDao activityDao = new ActivityDaoImpl();
		activityDao.updateActivity(activity);
	}
	
	public void deleteActivity(int aId){
		ActivityDao activityDao = new ActivityDaoImpl();
		activityDao.deleteActivity(aId);
		
	}
	
	public Set<Activity> showActivitiesByTeamId(int tId) {
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.getActivities(tId);
		
	}
	public Set<Activity> showActivitiesByUserId(int userId) {
		ActivityDao activityDao = new ActivityDaoImpl();
		
		return activityDao.getActivites(userId);
		
	}
	public Set<Activity> showIsolateActivities() {
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.getIsolateActivites();
		
	}
	
	public Set<User> showMembers(int aId) {
		ActivityDao activityDao = new ActivityDaoImpl();
		return activityDao.getParticipants(aId);
		
	}
}
