package it.dstech.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.dstech.connessioneDb.ConnessioneDb;


public class Controller {
	
	private List<String> continent = new ArrayList<String>();
	
	//properties
	@Value("${welcome.message}")
    private String message;
	
	@GetMapping("/")
	public String main(Model model) throws ClassNotFoundException, SQLException {
			
	ConnessioneDb cd = new ConnessioneDb();		
		continent = (cd.cercaContinenti());
		
		model.addAttribute("message", message);
		
		
		return "Welcome";
	}
	
	
	
}