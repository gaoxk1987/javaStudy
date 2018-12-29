
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 上午10:09:39
 * Version: 1.0
 *
 */

package com.bceden.Serializable;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-5-12 上午10:09:39   
 */

public class TransientExterUse implements Externalizable{
	private transient String content = "是的，我将会被序列化，不管我是否被transient关键字修饰";
	
	/**
	*
	*/
	
	private static final long serialVersionUID = 1489149175514803456L;
	/* (non-Javadoc)
	* @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	*/
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(content);
	}

	
	/* (non-Javadoc)
	* @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	*/
	
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		content = (String) in.readObject();
	}
	
	/**
	 * 
	 * @author Gao xingkun
	 * @version 1.0
	 * @date 2014-5-12 上午10:17:55
	 * @param args void
	 */
	public static void main(String[] args) {     
	TransientExterUse et = new TransientExterUse();
   
	try {
		 ObjectOutput out = new ObjectOutputStream(new FileOutputStream( new File("test")));
		    out.writeObject(et);

		    ObjectInput in;
		in = new ObjectInputStream(new FileInputStream(new File("test")));
	    et = (TransientExterUse) in.readObject();
	    System.out.println(et.content);

	    out.close();
	    in.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}

  }

	
}