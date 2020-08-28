package co.grandcircus.capstone6;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.capstone6.dao.UserDao;
import co.grandcircus.capstone6.entity.User;

@Controller
public class AuthController {

	@Autowired
	UserDao userDao;

	@Autowired
	HttpSession session;

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String submitLoginForm(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, RedirectAttributes redir) {
		User user = userDao.findByUsername(username);
		if (user == null || !password.equals(user.getPassword())) {
			model.addAttribute("message", "Incorrect username or password.");
			return "login";
		}

		session.setAttribute("user", user);

		redir.addFlashAttribute("message", "Logged in.");
		return "redirect:/";
	}

	@RequestMapping("/logout")
	public String logout(RedirectAttributes redir) {
		session.invalidate();

		redir.addFlashAttribute("message", "Logged out.");
		return "redirect:/";
	}

	@RequestMapping("/signup")
	public String showSignupForm() {
		return "signup";
	}

	@PostMapping("/signup")
	public String submitSignupForm(User user, @RequestParam("confirm-password") String confirmPassword, Model model,
			RedirectAttributes redir) {
		User existingUser = userDao.findByUsername(user.getUsername());
		if (existingUser != null) {
			model.addAttribute("message", "A user with that username already exists.");
			return "signup";
		}

		if (!confirmPassword.equals(user.getPassword())) {
			model.addAttribute("message", "Passwords do not match.");
			return "signup";
		}

		userDao.save(user);

		session.setAttribute("user", user);
		redir.addFlashAttribute("message", "Thanks for signing up!");
		return "redirect:/";
	}

	@RequestMapping("/addTask")
	public String showAddTask(Model model) {
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		return "addTask";
	}

}
