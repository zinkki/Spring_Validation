package kr.co.test.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.co.test.bean.DataBean3;

public class DataBean1Validator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return DataBean3.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "data2", "error2");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data3", "error3");
		
		DataBean3 bean3 = (DataBean3)target;
		
		String data2 = bean3.getData2();
		String data3 = bean3.getData3();
		
		if(data2.length() > 10) {
			errors.rejectValue("data2", "error4");
		}
		if(data3.contains("@")==false) {
			errors.rejectValue("data3","error5");
		}
	}

}
