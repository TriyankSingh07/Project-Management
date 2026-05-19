package com.sts.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sts.demo.entity.MasterTransaction;
import com.sts.demo.service.MasterTransactionService;

@Controller
@RequestMapping("/master-transaction")
public class MasterTransactionController {

	@Autowired
	private MasterTransactionService service;

	@GetMapping("/list")
	public String list(Model model) {

		List<MasterTransaction> list = service.getAll();

		model.addAttribute("list", list);

		return "master-transaction/list";
	}

	@GetMapping("/add")
	public String addPage(Model model) {

		model.addAttribute("transaction", new MasterTransaction());

		return "master-transaction/form";
	}

	@GetMapping("/edit/{id}")
	public String editPage(@PathVariable Integer id, Model model) {

		MasterTransaction transaction = service.getById(id);
		if (transaction == null) {
			return "redirect:/master-transaction/list";
		}
		model.addAttribute("transaction", transaction);

		return "master-transaction/form";
	}

	@GetMapping("/view/{id}")
	public String view(@PathVariable Integer id, Model model) {

		MasterTransaction transaction = service.getById(id);
		if (transaction == null) {
			return "redirect:/master-transaction/list";
		}
		model.addAttribute("transaction", transaction);

		return "master-transaction/view";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute MasterTransaction transaction) {

		service.save(transaction);

		return "redirect:/master-transaction/list";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {

		service.delete(id);

		return "redirect:/master-transaction/list";
	}
}