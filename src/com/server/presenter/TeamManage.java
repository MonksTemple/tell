package com.server.presenter;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;
import tell.server.model.*;

public interface TeamManage extends Remote{

	public void createTeam(Team team) throws RemoteException;
	
	public void addMember(int tId,int userId) throws RemoteException;
	
	public void modifyInfo(Team team) throws RemoteException;
	
	public void deleteTeam(int tId) throws RemoteException;
	
	public Set<Team> ShowTeamList() throws RemoteException;
	
	public void deleteMember(int tId,int userId) throws RemoteException;
	
	public Set<User> showMemberList(int tId) throws RemoteException;
	
}
