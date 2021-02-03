package kr.co.test.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.test.bean.DataBean1;
import kr.co.test.bean.DataBean2;

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
		}
		return "input_success";
	}
	
	@GetMapping("/input_data2")
	public String input_data2(DataBean2 dataBean2) {
		return "input_data2";
	}
	@PostMapping("/input_pro2")
	public String input_pro2(@Valid DataBean2 dataBean2, BindingResult result) {
		if(result.hasErrors()) {
			return "input_data2";
		}
		return "input_success2";
	}
}
