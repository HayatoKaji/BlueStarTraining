package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.model.User;
import com.example.demo.domain.service.TrainingService;

@Controller
public class TrainingController {

	@Autowired
	TrainingService service;

	@GetMapping("/home")
	public String getHome() {
		return "/home";
	}
	// homeを表示

	@GetMapping("/staff")
	public String getStaff() {
		return "/staffedit";
	}
	// staffeditを表示

	@RequestMapping(value = "/staff", method = RequestMethod.POST)
	public String editBtn() {
		return "/staffedit";
	}
	// staffeditに遷移

	@RequestMapping(value = "/backHome", method = RequestMethod.POST)
	public String backHomeBtn() {
		return "redirect:/home";
	}
	// staffeditからhomeにリダイレクト

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newBtn() {
		return "/new";
	}
	// staffeditからnewに遷移

	@RequestMapping(value = "/new/insert", method = RequestMethod.POST)
	public String insertBtn(@ModelAttribute("from") User form, Model model) {
		service.newStaff(form);
		return "/result";
	}
	//DBへ反映

	@RequestMapping(value = "/backStaff", method = RequestMethod.POST)
	public String backStaffBtn() {
		return "redirect:/staff";
	}
	// newからstaffeditに遷移

}
