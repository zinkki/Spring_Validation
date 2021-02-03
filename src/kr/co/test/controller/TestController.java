package kr.co.test.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.test.bean.DataBean1;
import kr.co.test.bean.DataBean2;
import kr.co.test.bean.DataBean3;
import kr.co.test.validator.DataBean1Validator;

@Controller
public class TestController {

	@GetMapping("/input_data")
	public String input_data(DataBean1 dataBean1) {
		return "input_data";
	}
	@PostMapping("/input_pro")
	public String input_pro(@Valid DataBean1 dataBean1, BindingResult result) {
		if(result.hasErrors()) {
			return "input_data";
		} return "input_success";
	}
	
	@GetMapping("/input_data2")
	public String input_data2(DataBean2 dataBean2) {
		return "input_data2";
	}
	@PostMapping("/input_pro2")
	public String input_pro2(@Valid DataBean2 dataBean2, BindingResult result) {
		if(result.hasErrors()) {
			return "input_data2";
		} return "input_success2";
	}
	
	@GetMapping("/input_data3")
	public String input_data3(DataBean3 dataBean3) {
		return "input_data3";
	}
	@PostMapping("/input_pro3")
	public String input_pro3(@Valid DataBean3 dataBean3, BindingResult result) {
		if(result.hasErrors()) {
			return "input_data3";
		} return "input_success3";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DataBean1Validator validator1 = new DataBean1Validator();
	//  binder.setValidator(validator1);     validator가 1개일때	
		binder.addValidators(validator1);  //validator가 여려개일때
	}
}
