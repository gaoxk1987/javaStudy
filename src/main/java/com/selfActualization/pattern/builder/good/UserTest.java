package com.selfActualization.pattern.builder.good;
public class UserTest {

	public static void main(String[] args) {
		User user = new User.UserBuilder("aaa","123")
		.age(1)
		.address("11")
		.phone("1371641")
		.build();
		
		System.out.println(user.getAddress());
		System.out.println(user.getAge());

	}

}
