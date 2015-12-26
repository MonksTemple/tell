package com.server.presenter;

import java.rmi.Remote;
import java.rmi.RemoteException;

import tell.server.model.Notification;

public interface NotificationManage extends Remote{

	public void addNotification(Notification notification) throws RemoteException;
	
	public void updateNotification(Notification notification) throws RemoteException;
}
