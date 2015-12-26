package tell.server.presenter.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Set;
import com.server.presenter.TeamManage;
import tell.server.dao.ActivityDao;
import tell.server.dao.TeamDao;
import tell.server.dao.impl.ActivityDaoImpl;
import tell.server.dao.impl.TeamDaoImpl;
import tell.server.model.*;

public class TeamManageImpl extends UnicastRemoteObject implements TeamManage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TeamManageImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	public void createTeam(Team team){
		TeamDao teamDao = new TeamDaoImpl();
		teamDao.addTeam(team);
	}
	public void addMember(int tId,int userId){
		TeamDao teamDao = new TeamDaoImpl();
		teamDao.addMember(tId, userId);
	}
	
	public void modifyInfo(Team team){
		TeamDao teamDao = new TeamDaoImpl();
		teamDao.updateTeam(team);
	}
	public void deleteTeam(int tId){
		TeamDao teamDao = new TeamDaoImpl();
		ActivityDao activityDao = new ActivityDaoImpl();
		activityDao.deleteActivites(tId);
		teamDao.deleteTeam(tId);
		
	}
	public Set<Team> ShowTeamList(){ 
		TeamDao teamDao = new TeamDaoImpl();
		return teamDao.getAllTeams();
		
	}
	public void deleteMember(int tId,int userId){
		TeamDao teamDao = new TeamDaoImpl();
		teamDao.deleteMember(tId, userId);
	}
	public Set<User> showMemberList(int tId){
		TeamDao teamDao = new TeamDaoImpl();
		return teamDao.getMembers(tId);
		
	}
	
	
}
