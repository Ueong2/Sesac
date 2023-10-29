package dev.mvc.mouse.s02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MouseViewController {
	
	@RequestMapping(value = "/s02/mouse-view-controller", method = RequestMethod.GET)
	public ModelAndView handleRequest() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("index");
		
		return mnv;
	}
}
