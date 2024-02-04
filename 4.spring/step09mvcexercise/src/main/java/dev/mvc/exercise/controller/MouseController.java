package dev.mvc.exercise.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.exercise.model.Mouse;
import dev.mvc.exercise.service.MouserService;

@Controller
public class MouseController {

	private MouserService ms;
	
	@Autowired
	public MouseController(MouserService ms) {
		super();
		this.ms = ms;
	}

	@RequestMapping(value="/mouse-api/mice/add", method= RequestMethod.POST)
	public void mouseAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		int id = 1;
		
		System.out.println(name);
		Mouse mouse = new Mouse(id, name, country, address);
		System.out.println(mouse.toString());
		
		ms.add(mouse);
		response.sendRedirect("/exercise/mouse-api/mice");
	}
	
	@RequestMapping(value="/mouse-api/mice", method= RequestMethod.GET)
	public ModelAndView mouseList(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		ModelAndView mnv = new ModelAndView();
		List<Mouse> mice = ms.findAll();
		model.addAttribute("mice", mice);
		
		mnv.setViewName("mouseList");
		return mnv;
	}
	

}
