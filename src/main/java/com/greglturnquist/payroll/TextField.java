
package com.greglturnquist.payroll;

import javax.persistence.*;

@Entity
public class TextField {

	private @Id @GeneratedValue Long tfid;
	private String name;
	private String value;

	@ManyToOne(targetEntity = FormGroup.class)
	@JoinColumn(name="gid")
	private FormGroup formGroup;

	private TextField() {}

	public TextField(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getValue(){
		return value;
	}

	public void setValue(String value){
		this.value = value;
	}

	public void setFormGroup(FormGroup formGroup){
		this.formGroup = formGroup;
	}	
}
