package com.bs.ninjagold;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class GoldController {
	@RequestMapping("/gold")
	public String gold(HttpSession session) {
		if(session.getAttribute("results") == null) {
			ArrayList<String> log = new ArrayList<String>();
			session.setAttribute("results", log);
		}
		return "gold.jsp";
	}
	
	@RequestMapping(value="/process_money", method=RequestMethod.POST)
	public String data(@RequestParam(value = "location") String location, HttpSession session) {
		
		ArrayList<String> log = (ArrayList<String>) session.getAttribute("results");  

		Random rand = new Random();
		LocalDateTime myDate = LocalDateTime.now();
		DateTimeFormatter time = DateTimeFormatter.ofPattern("EEEE dd yyyy hh:mm a");
		String timeStamp = myDate.format(time);
		
		Integer gold = (Integer) session.getAttribute("gold");
		
		if(gold == null) {
			session.setAttribute("gold", 0);
			gold= 0;
			return "redirect:/";
		}
		
		if(location.equals("farm")) {
			Integer number = rand.nextInt(11)+10;
			session.setAttribute("gold", gold = gold + number);
			String someLog = "Earned " + number + " gold from farm. " + timeStamp;
			log.add(someLog);
		}
		
		else if(location.equals("cave")) {
			Integer number = rand.nextInt(6)+5;
			session.setAttribute("gold", gold = gold + number);
			String someLog = "Earned " + number + " gold from cave. " + timeStamp;
			log.add(someLog);
		}
		
		else if(location.equals("house")) {
			Integer number = rand.nextInt(4)+2;
			session.setAttribute("gold", gold = gold + number);
			String someLog = "Earned " + number + " gold from house. " + timeStamp;
			log.add(someLog);
		}
		
		else if(location.equals("casino")) {
			Integer number = rand.nextInt(101)-50;
			session.setAttribute("gold", gold = gold + number);
			if(number > 0 ) {
				String someLog = "Earned " + number + " gold from casino. " + timeStamp;
				log.add(someLog);
			} else {
				String someLog = "Lost " + number*-1 + " gold from casino. " + timeStamp;
				log.add(someLog);
			}
		}
		session.setAttribute("results", log);
		return "redirect:/gold";		
	}
	
	@RequestMapping("/restart")
	public String restart(HttpSession session) {
		session.setAttribute("gold", 0);
		session.setAttribute("results", new ArrayList<String>());
        return "redirect:/gold";
	}
	
}
