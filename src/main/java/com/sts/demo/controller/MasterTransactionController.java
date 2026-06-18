package com.sts.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sts.demo.dto.MasterTransactionFormDto;
import com.sts.demo.entity.MasterTransaction;
import com.sts.demo.search.MasterTransactionSearch;
import com.sts.demo.service.MasterTransactionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/master-transaction")
public class MasterTransactionController {

	@Autowired
	private MasterTransactionService transactionService;

	/** Binds search form fields (transactionName, status) from GET query params. */
	@GetMapping("/list")
	public String list(@ModelAttribute("search") MasterTransactionSearch search, Model model) {
		List<MasterTransaction> list = transactionService.search(search);
		model.addAttribute("list", list);
		return "master-transaction/list";
	}

	// @GetMapping("/add")
	// public String addPage(Model model) {
	// 	model.addAttribute("transaction", new MasterTransactionFormDto());
	// 	return "master-transaction/form";
	// }

	@GetMapping("/add")
	public String addPage(Model model) {
		MasterTransactionFormDto transaction = new MasterTransactionFormDto();
		transaction.setStatus(1); 
		model.addAttribute("transaction", transaction);
		return "master-transaction/form";
	}	

	@GetMapping("/edit/{id}")
	public String editPage(@PathVariable Integer id, Model model) {
		MasterTransaction existing = transactionService.getById(id);
		if (existing == null) {
			return "redirect:/master-transaction/list";
		}
		model.addAttribute("transaction", MasterTransactionFormDto.from(existing));
		return "master-transaction/form";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("transaction") MasterTransactionFormDto transaction,
			BindingResult bindingResult) {
		boolean isUpdate = transaction.getId() != null;
		if (isUpdate && transaction.getStatus() == null) {
			bindingResult.rejectValue("status", "NotNull", "Status is required");
		}
		if (bindingResult.hasErrors()) {
			return "master-transaction/form";
		}
		MasterTransaction entity = transaction.toEntity();
		if (!isUpdate) {
			entity.setStatus(1);
		}
		transactionService.save(entity);
		return "redirect:/master-transaction/list";
	}
}
