package com.mianshi.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 
 * 方法引用  必须接收者是个函数接口
 * @author HK
 * http://www.cnblogs.com/chenpi/p/5885706.html
 * 什么场景适合使用方法引用
*当一个Lambda表达式调用了一个已存在的方法

*什么场景不适合使用方法引用
*当我们需要往引用的方法传其它参数的时候，不适合，如下示例：
*IsReferable demo = () -> ReferenceDemo.commonMethod("Argument in method.");
 *
 */
public class MethodReference {
	  public static void main(String[] args) {
	        // 方法引用::引用构造函数
	        PersonFactory factory = new PersonFactory(Person::new);

	        List<Person> personList = new ArrayList<Person>();

	        Person p1 = factory.getPerson();
	        p1.setName("Kobe");
	        personList.add(p1);
	        Person p2 = factory.getPerson();
	        p2.setName("James");
	        personList.add(p2);
	        Person p3 = factory.getPerson();
	        p3.setName("Paul");
	        personList.add(p3);

	        Person[] persons1 = personList.toArray(new Person[personList.size()]);
	        System.out.print("排序前: ");
	        printArray(persons1);

	        // 方法引用::引用静态方法
	        Arrays.sort(persons1, MethodReference::myCompare);
	        System.out.print("排序后: ");
	        printArray(persons1);
	        System.out.println();

	        Person[] persons2 = personList.toArray(new Person[personList.size()]);
	        System.out.print("排序前: ");
	        printArray(persons2);

	        // 方法引用::用特定对象的实例方法
	        Arrays.sort(persons2, p1::compare);
	        System.out.print("排序后: ");
	        printArray(persons2);
	        System.out.println();

	        Person[] persons3 = personList.toArray(new Person[personList.size()]);
	        System.out.print("排序前: ");
	        printArray(persons3);

	        // 方法引用::引用特定类型的任意对象的实例方法
	        Arrays.sort(persons3, Person::compareTo);
	        System.out.print("排序后: ");
	        printArray(persons3);
	    }

	    public static void printArray(Person[] persons) {
	        for (Person p : persons) {
	            System.out.print(p.name + "  ");
	        }
	        System.out.println();
	    }

	    public static int myCompare(Person p1, Person p2) {
	        return p1.getName().compareTo(p2.getName());
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
