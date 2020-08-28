package co.grandcircus.capstone6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskManController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
}
