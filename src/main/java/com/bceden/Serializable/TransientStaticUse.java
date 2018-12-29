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

public class TransientStaticUse implements Serializable {
	private String user;
	private static String girlFriendName;
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

	public static String getGirlFriendName() {
		return girlFriendName;
	}

	public static void setGirlFriendName(String girlFriendName) {
		TransientStaticUse.girlFriendName = girlFriendName;
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
		TransientStaticUse tu =new TransientStaticUse();
		tu.setPwd("123");
		tu.setUser("李雷！");
		tu.setGirlFriendName("韩梅梅！");
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
		// 在反序列化之前改变girl的值
		TransientStaticUse.girlFriendName = "王爽";//注销和存在该条 效果是不同的
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/transient.dat"));
			TransientStaticUse tur = (TransientStaticUse)ois.readObject();
			if(tur!=null){
				System.out.println(tur.getUser());
				System.out.println(tur.getPwd());
				System.out.println(tur.getGirlFriendName());
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