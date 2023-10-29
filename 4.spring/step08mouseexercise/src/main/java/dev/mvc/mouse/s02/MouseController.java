package dev.mvc.mouse.s02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MouseController {
	
	@RequestMapping(value = "/s02/mouse-controller", method = RequestMethod.GET)
	public void handleReques() {
		System.out.println("mouseController called");
	}
}
