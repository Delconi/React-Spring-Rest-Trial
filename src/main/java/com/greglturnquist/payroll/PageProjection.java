package com.greglturnquist.payroll;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="projection" , types = {Page.class,FormGroup.class,TextField.class})
public interface PageProjection {
	String getName();
	String getLabel();
	List<FormGroup> getFormGroups();
}
