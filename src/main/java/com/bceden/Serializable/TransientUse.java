
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 上午10:09:39
 * Version: 1.0
 *
 */

package com.bceden.Serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-5-12 上午10:09:39   
 */

public class TransientUse implements Serializable {
	 private String user;
	 private transient String pwd;
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	/**
	*
	*/
	
	private static final long serialVersionUID = 1489149175514803456L;

	/**
	 * 
	 * @author Gao xingkun
	 * @version 1.0
	 * @date 2014-5-12 上午10:09:39
	 * @param args void
	 */

	
	/**
	 * 
	 * @author Gao xingkun
	 * @version 1.0
	 * @date 2014-5-12 上午10:17:55
	 * @param args void
	 */
	public static void main(String[] args) {
		TransientUse tu =new TransientUse();
		tu.setPwd("123");
		tu.setUser("小明！");
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("c:/transient.dat"));
			os.writeObject(tu);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/******************读取完成***********************/
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/transient.dat"));
			TransientUse tur = (TransientUse)ois.readObject();
			if(tur!=null){
				System.out.println(tur.getUser());
				System.out.println(tur.getPwd());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
