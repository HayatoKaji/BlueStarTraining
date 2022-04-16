package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.model.User;
import com.example.demo.domain.service.StaffappService;

@Controller
public class StaffappController {

	@Autowired
	StaffappService service;

	@GetMapping("/home")
	public String getHome(Model model) { // Model modelでcontrollerから画面に渡すことを定義
		String engineer = "0001";
		String sales = "0002";
		String corporation = "0003"; // staffDepartmentにそって定義
		List<User> enjineerList = service.findDepart(engineer);
		List<User> salesList = service.findDepart(sales);
		List<User> corporationList = service.findDepart(corporation); // daoimplからデータを選択してくる
		model.addAttribute("enjineerList", enjineerList);// htmlに送るキーと値
		model.addAttribute("salesList", salesList);
		model.addAttribute("corporationList", corporationList);
		return "/home";

	}
	// homeを表示

	@GetMapping("/stafflist")
	public String getStaff(Model model) {
		List<User> staffList = service.findAll();
		model.addAttribute("staffList", staffList);
		return "/staffList";
	}
	// staffeditを表示(検索時）

	@RequestMapping(value = "/stafflist", method = RequestMethod.POST)
	public String editBtn(Model model) {
		List<User> staffList = service.findAll();
		model.addAttribute("staffList", staffList);
		return "/staffList";
	}
	// staffeditに遷移

	@GetMapping(value = "/edit/{staffCode}")
	public String displayEdit(Model model, @PathVariable("staffCode") String staffCode) {
		User user = service.findById(staffCode);
		model.addAttribute("user", user);
		return "/update";
	}
	// staff更新画面を表示させる

	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public String updateBtn(Model model, User user, @RequestParam String beforeStaffCode) {
		service.updateStaff(beforeStaffCode, user);
		return "/result3";
	}
	// sql文を用いてupdateする

	@GetMapping(value = "/delete/{staffCode}")
	public String displayDelete(Model model, @PathVariable("staffCode") String staffCode) {
		User user = service.findById(staffCode);
		model.addAttribute("user", user);
		return "/delete";
	}
	// staff削除画面を表示させる

	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public String deleteBtn(Model model, User user, @RequestParam String staffCode) {
		service.deleteStaff(staffCode, user);
		return "/result2";
	}
	// sql文を用いてdeleteする

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
	// DBへ反映,resultに遷移

	@RequestMapping(value = "/backStaff", method = RequestMethod.POST)
	public String backStaffBtn() {
		return "redirect:/staff";
	}
	// newからstaffeditに遷移

}
