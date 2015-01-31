package animal;

import org.springframework.beans.factory.annotation.Value;

public class Lion implements Animal {
	@Value("사자")
	String name;
	@Value("100")
	int age;

	public Lion() {
	}

	public Lion(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Lion [name=" + name + ", age=" + age + "]";
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
