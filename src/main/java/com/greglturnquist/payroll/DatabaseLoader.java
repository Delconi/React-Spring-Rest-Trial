package com.greglturnquist.payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final TextFieldRepository tfRepository;
	private final FormGroupRepository fgRepository;
	private final PageRepository pRepository;

	@Autowired
	public DatabaseLoader(TextFieldRepository tfRepository, FormGroupRepository fgRepository, PageRepository pRepository) {
		this.tfRepository = tfRepository;
		this.fgRepository = fgRepository;
		this.pRepository = pRepository;
	}

	public void run(String... strings) throws Exception {
	
		//Group 1//
		List<TextField> g1tf = new ArrayList<TextField>();
		FormGroup group1 = new FormGroup("mainGroup", "MainGroup", g1tf);

		TextField textField1 = new TextField("name", "Name");
		textField1.setFormGroup(group1);
		g1tf.add(textField1);
		
		TextField textField2 = new TextField("age", "Age");
		textField2.setFormGroup(group1);
		g1tf.add(textField2);

		TextField textField3 = new TextField("dob", "Date Of Birth");
		textField3.setFormGroup(group1);
		g1tf.add(textField3);

		//Group 2//
		List<TextField> g2tf = new ArrayList<TextField>();
		FormGroup group2 = new FormGroup("secGroup", "Second Group", g2tf);

		TextField textField4 = new TextField("hobby", "Hobby");
		textField4.setFormGroup(group2);
		g2tf.add(textField4);

		TextField textField5 = new TextField("description", "Description");
		textField5.setFormGroup(group2);
		g2tf.add(textField5);

		//Page//
		List<FormGroup> formGroups = new ArrayList<FormGroup>();
		Page mainPage = new Page("mainPage","Main Page", formGroups);
		
		group1.setPage(mainPage);
		formGroups.add(group1);
		
		group2.setPage(mainPage);
		formGroups.add(group2);
		
		this.pRepository.save(mainPage);

	}
}