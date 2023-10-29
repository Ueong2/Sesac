package dev.mouse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.mouse.service.MouseService;

public interface Controller {
	void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
