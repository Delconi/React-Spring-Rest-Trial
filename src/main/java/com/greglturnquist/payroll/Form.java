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
public class Form {

	private @Id @GeneratedValue Long fid;
	private String name;
	private String label;
	
	@OneToMany(targetEntity = Page.class, mappedBy = "form",cascade = CascadeType.ALL)
	private List<Page> pages = new ArrayList<Page>();

	private Form() {}

	public Form(String name, String label, List<Page> pages) {
		this.name = name;
		this.label = label;
		this.pages = pages;
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

	public List<Page> getPages(){
		return pages;
	}

	public void setgetPages(List<Page> getPages){
		this.pages = pages;
	}
}
// end::code[]