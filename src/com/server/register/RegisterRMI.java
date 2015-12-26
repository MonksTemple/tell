package com.server.register;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.server.presenter.ActivityManage;
import com.server.presenter.NotificationManage;
import com.server.presenter.TeamManage;
import com.server.presenter.UserManage;

import tell.server.presenter.impl.ActivityManageImpl;
import tell.server.presenter.impl.NotificationManageImpl;
import tell.server.presenter.impl.TeamManageImpl;
import tell.server.presenter.impl.UserManageImpl;

public class RegisterRMI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		int rmiPortNum = 1099;
		try {
			if(System.getSecurityManager() == null){
				System.setSecurityManager(new RMISecurityManager());
			}
			
			startRegistry(rmiPortNum);
			String registryURL = "rmi://localhost:"+String.valueOf(rmiPortNum)+"/";

			UserManage userManage = new UserManageImpl();
			NotificationManage notificationManage = new NotificationManageImpl();
			TeamManage teamManage = new TeamManageImpl();
			ActivityManage activityManage = new ActivityManageImpl();
			
			Naming.rebind(registryURL+"user", userManage);
			Naming.rebind(registryURL+"notification", notificationManage);
			Naming.rebind(registryURL+"team", teamManage);
			Naming.rebind(registryURL+"activity", activityManage);
			
			System.out.println("Server registered.");			
			listRegistry(registryURL);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	private static void startRegistry(int rmiPortNum) throws RemoteException{
	      try {
	         Registry registry = LocateRegistry.getRegistry(rmiPortNum);
	         registry.list( );  // This call will throw an exception
	                            // if the registry does not already exist
	      }
	      catch (RemoteException e) { 	         
	    	  System.out.println
	        ("RMI registry cannot be located at port " 
	        + rmiPortNum);

	            LocateRegistry.createRegistry(rmiPortNum);
	         	System.out.println(
	           "RMI registry created at port " + rmiPortNum);
	      }
	   }
	private static void listRegistry(String registryURL) throws RemoteException, MalformedURLException {
	       System.out.println("Registry " + registryURL + " contains: ");
	       String[] names = Naming.list(registryURL);
	       for (int i=0; i < names.length; i++)
	          System.out.println(names[i]);
	  } 

}
