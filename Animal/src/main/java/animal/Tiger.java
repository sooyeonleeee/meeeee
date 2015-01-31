package animal;

import org.springframework.beans.factory.annotation.Value;

public class Tiger implements Animal {

	@Value("호랑이")
	String name;
	@Value("200")
	int age;

	public Tiger() {
	}

	public Tiger(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Tiger [name=" + name + ", age=" + age + "]";
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}
