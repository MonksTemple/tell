package com.server.presenter;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;
import tell.server.model.Activity;
import tell.server.model.User;

public interface ActivityManage extends Remote{
	
	public void addActivity(Activity activity) throws RemoteException;
	
	public void modifyActivity(Activity activity) throws RemoteException;
	
	public void deleteActivity(int aId) throws RemoteException;
	
	public Set<Activity> showActivitiesByTeamId(int tId) throws RemoteException;
	
	public Set<Activity> showActivitiesByUserId(int userId) throws RemoteException;
	
	public Set<Activity> showIsolateActivities() throws RemoteException;
	
	public Set<User> showMembers(int aId) throws RemoteException;
}
