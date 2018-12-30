package com.mianshi.java8.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class Java8CollectionTest {

	public static void main(String[] args) {
		List<Person> personList = new ArrayList<Person>();
		PersonFactory factory = new PersonFactory(Person::new);
		Person p1 = factory.getPerson();
		p1.setName("p1");
		personList.add(p1);
		Person p2 = factory.getPerson();
		p2.setName("p2");
		personList.add(p2);
		Person p3 = factory.getPerson();
		p3.setName("p3");
		personList.add(p3);
		
		personList.forEach(
			person->{
					System.out.println(person.getName());
					
					}
			);
		
		
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));

		items.forEach((k,v)->{
		    System.out.println("Item : " + k + " Count : " + v);
		    if("E".equals(k)){
		        System.out.println("Hello E");
		    }
		});
		
		List<String> itemsList = new ArrayList<>();
		itemsList.add("A");
		itemsList.add("B");
		itemsList.add("C");
		itemsList.add("D");
		itemsList.add("E");

		//lambda
		//Output : A,B,C,D,E
		itemsList.forEach(item->System.out.println(item));

		//Output : C
		itemsList.forEach(item->{
		    if("C".equals(item)){
		        System.out.println(item);
		    }
		});

		//method reference
		//Output : A,B,C,D,E
		itemsList.forEach(System.out::println);

		//Stream and filter
		//Output : B
		itemsList.stream()
		    .filter(s->s.contains("B"))
		    .forEach(System.out::println);
		
		//Stream API不是多核 简单遍历的话不如手动实现
		Optional<Person> filterPerson =personList.stream().filter(person->person.getName().equals("p2")).findFirst();
//		filterPerson.

	}
	  static class Person {
	        private String name;

	        public Person() {
	        }

	        public String getName() {
	            return name;
	        }

	        public void setName(String name) {
	            this.name = name;
	        }

	        public int compare(Person p1, Person p2) {
	            return p1.getName().compareTo(p2.getName());
	        }

	        public int compareTo(Person p) {
	            return this.getName().compareTo(p.getName());
	        }
	    }
	  static class PersonFactory {
	        private Supplier<Person> supplier;

	        public PersonFactory(Supplier<Person> supplier) {
	            this.supplier = supplier;
	        }

	        public Person getPerson() {
	            return supplier.get();
	        }
	    }
}
