package it.dstech.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.dstech.connessioneDb.ConnessioneDb;

@Controller
public class ControllerOne {

	private List<String> continent = new ArrayList<String>();

	// properties
	@Value("${welcome.message}")
	private String message;

	@GetMapping("/")
	public String main(Model model) throws ClassNotFoundException, SQLException {

		ConnessioneDb cd = new ConnessioneDb();
		continent = (cd.cercaContinenti());

		model.addAttribute("message", message);
		model.addAttribute("continent", continent);

		return "Welcome";
	}

	@PostMapping("/cercaStato")
	public String cercaStato(@RequestParam(name = "continent", required = true, defaultValue = "") String continente,
			Model model) throws ClassNotFoundException, SQLException {
		ConnessioneDb cd = new ConnessioneDb();
		ArrayList<String> lista = new ArrayList<String>();
		lista.addAll(cd.cercaStati(continente));
		return "visualizzaStati";
	}
}
