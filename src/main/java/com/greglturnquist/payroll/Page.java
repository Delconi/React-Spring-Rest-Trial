/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greglturnquist.payroll;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Entity
public class Page {

	private @Id @GeneratedValue Long pid;
	private String name;
	private String label;
	
	@OneToMany(targetEntity = FormGroup.class, mappedBy = "page",cascade = CascadeType.ALL)
	private List<FormGroup> formGroups = new ArrayList<FormGroup>();

	private Page() {}

	public Page(String name, String label, List<FormGroup> formGroups) {
		this.name = name;
		this.label = label;
		this.formGroups = formGroups;
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

	public void setLabel(){
		this.label = label;
	}

	public List<FormGroup> getFormGroups(){
		return formGroups;
	}

	public void setFormGroups(List<FormGroup> formGroups){
		this.formGroups = formGroups;
	}
}
// end::code[]