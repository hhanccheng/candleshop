package csec.vulnerable.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity 
@Table(name = "ecom_tag")
public class Tag {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "TAG_SEQ")
	@SequenceGenerator(name = "TAG_SEQ",sequenceName = "ECOM_TAG_SEQ",allocationSize = 1)
	private int id;
	@Column
	@NotEmpty
	private String name;
	@ManyToMany(mappedBy = "tags")
    private Set<Product> products;
	
	
	public Tag(int id, @NotEmpty String name, Set<Product> products) {
		this.id = id;
		this.name = name;
		this.products = products;
	}
	public Tag(int id, @NotEmpty String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	
	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", products=" + products + "]";
	}
    

}
