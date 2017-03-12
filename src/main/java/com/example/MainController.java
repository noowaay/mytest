package com.example;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Controller
public class MainController {
	@Autowired
	RoleRepository repo;

	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	@ResponseBody
	public List<Role> getRoles() {
		List<Role> result = (List<Role>) repo.findAll();
		return result;
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null) {
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/";
	}
	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.POST, headers =
	 * "Content-type: application/json", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public String postLogin(@RequestBody
	 * User user) { Authentication auth =
	 * SecurityContextHolder.getContext().getAuthentication(); String username =
	 * auth.getName(); return username; }
	 */
}
