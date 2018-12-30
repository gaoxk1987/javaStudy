package com.selfActualization.pattern.builder.self;
public class User {
	
	private String username;
	private String passworld;
	private String telnum;
	private String address;
	
	
	
	private User() {
	}

	private User(UserBuilder userBuilder) {
		super();
		this.username = userBuilder.username;
		this.passworld = userBuilder.passworld;
		this.telnum = userBuilder.telnum;
		this.address = userBuilder.address;
	}

	private String getUsername() {
		return username;
	}

	public String getPassworld() {
		return passworld;
	}

	public String getTelnum() {
		return telnum;
	}

	public String getAddress() {
		return address;
	}
	
	

	public static class  UserBuilder{
		private String username;
		private String passworld;
		private String telnum;
		private String address;
		
		
		public UserBuilder(String username, String passworld) {
			super();
			this.username = username;
			this.passworld = passworld;
		}

		public UserBuilder setUsername(String username) {
			this.username = username;
			return this;
		}

		public UserBuilder setPassworld(String passworld) {
			this.passworld = passworld;
			return this;
		}



		public UserBuilder setTelnum(String telnum) {
			this.telnum = telnum;
			return this;
		}



		public UserBuilder setAddress(String address) {
			this.address = address;
			return this;
		}

		public User build(){
			//有线程安全问题，设置属性时
			return new User(this);
		} 
	}
}

