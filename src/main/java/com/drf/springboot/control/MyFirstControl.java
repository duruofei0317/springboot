package com.drf.springboot.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyFirstControl {

	@RequestMapping("/first")
	@ResponseBody
	public Object first()
	{
		int[] a= {1,1,1};
		return a;
	}
}
