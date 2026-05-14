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

		return "master-transaction/add";
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