package com.server.presenter;

import java.rmi.Remote;
import java.rmi.RemoteException;

import tell.server.model.User;

public interface UserManage extends Remote{
	public boolean register(User user) throws RemoteException;
	
	public boolean login(User user) throws RemoteException;
	
	public boolean logout(int userId) throws RemoteException;
	
	public boolean modify(User user) throws RemoteException;
}
