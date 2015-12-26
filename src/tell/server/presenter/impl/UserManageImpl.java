package tell.server.presenter.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.Set;

import com.server.presenter.UserManage;

import tell.server.dao.*;
import tell.server.dao.impl.*;
import tell.server.model.Team;
import tell.server.model.User;

public class UserManageImpl extends UnicastRemoteObject implements UserManage{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserManageImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean register(User user) {
		UserDao userDao = new UserDaoImpl();
		userDao.addUser(user);
		
		return true;
	}
	
	public boolean login(User user){
		boolean ret = false;
		UserDao userDao = new UserDaoImpl();
		ret = userDao.exist(user);
		return ret;
	}
	
	public boolean logout(int userId){
		UserDao userDao = new UserDaoImpl();
		TeamDao teamDao = new TeamDaoImpl();
		Set<Team> set = teamDao.getTeams(userId);

		Iterator<Team> it=set.iterator();
		while(it.hasNext()){
			Team team = (Team) it.next();
			ActivityDao activityDao = new ActivityDaoImpl();
			activityDao.deleteActivites(team.gettId());
			teamDao.deleteTeam(team.gettId());
		}
		userDao.deleteUser(userId);
		return true;
	}
	
	public boolean modify(User user){
		UserDao userDao = new UserDaoImpl();
		userDao.updateUser(user);
		return true;
	}
}
