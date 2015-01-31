package animal;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class Zoo {

	@Autowired
	@Qualifier("tiger")
	Animal tiger;
	@Autowired
	@Qualifier("lion")
	Animal lion;
	@Value("서울")
	String addr;

	public Zoo() {}
	
	private List<String> names;

	private Set<Animal> animals;

	public Set<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(Set<Animal> animals) {
		this.animals = animals;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public Zoo(String addr) {
		this.addr = addr;
	}

	public Animal getTiger() {
		return tiger;
	}

	public void setTiger(Animal tiger) {
		this.tiger = tiger;
	}

	public Animal getLion() {
		return lion;
	}

	public void setLion(Animal lion) {
		this.lion = lion;
	}

	@Override
	public String toString() {
		return "Zoo [tiger=" + tiger + ", lion=" + lion + ", addr=" + addr
				+ ", names=" + names + ", animals=" + animals + "]";
	}


}
