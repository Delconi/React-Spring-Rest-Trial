package com.greglturnquist.payroll;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="projection" , types = {FormGroup.class,TextField.class})
public interface FormGroupProjection {
	String getName();
	String getLabel();
	List<TextField> getTextFields();
}
