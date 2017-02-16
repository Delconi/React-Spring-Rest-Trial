package com.greglturnquist.payroll;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class FormGroup {

	private @Id @GeneratedValue Long gid;
	private String name;
	private String label;
	
	@OneToMany(targetEntity = TextField.class, mappedBy = "formGroup",cascade = CascadeType.ALL)
	private List<TextField> textFields = new ArrayList<TextField>();

	@ManyToOne(targetEntity = Page.class)
	@JoinColumn(name="pid")
	private Page page;

	private FormGroup() {}

	public FormGroup(String name, String label, List<TextField> textFields) {
		this.name = name;
		this.label = label;
		this.textFields = textFields;
	}
	
	public String getName(){
		return name;
	}	

	public void setName(String name){
		this.name = name;
	}

	public String getLabel(){
		return label;
	}

	public void setLabel(String label){
		this.label = label;
	}

	public List<TextField> getTextFields(){
		return textFields;
	}

	public void setTextFields(List<TextField> textFields){
		this.textFields = textFields;
	}

	//public Page getPage(){
	//	return page;
	//}	

	public void setPage(Page page){
		this.page = page;
	}
}
// end::code[]