package dev.mvc.mouse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	void process(HttpServletRequest request, HttpServletResponse Response) throws ServletException, IOException;
}
