package dev.mvc.step07.s02resolvingview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecondController {
	
	@RequestMapping(value = "/s02/second-controller", method = RequestMethod.GET)
	public void handleReques() {
		System.out.println("secondController called");
	}
}
