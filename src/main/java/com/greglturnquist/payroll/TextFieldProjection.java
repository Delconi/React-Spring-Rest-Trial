package com.greglturnquist.payroll;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="projection" , types = TextField.class)
public interface TextFieldProjection {
	String getName();
	String getValue();
	//FormGroup getFormGroup();
}
