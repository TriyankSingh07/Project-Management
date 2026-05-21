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

import com.sts.demo.dto.MasterClientFormDto;
import com.sts.demo.entity.MasterClient;
import com.sts.demo.service.MasterClientService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/master-client")
public class MasterClientController {

	@Autowired
	private MasterClientService clientService;

	@GetMapping("/list")
	public String list(Model model) {
		List<MasterClient> list = clientService.getAll();
		model.addAttribute("list", list);
		return "master-client/list";
	}

	@GetMapping("/add")
	public String addPage(Model model) {
		model.addAttribute("client", new MasterClientFormDto());
		return "master-client/form";
	}

	@GetMapping("/edit/{id}")
	public String editPage(@PathVariable Integer id, Model model) {
		MasterClient existing = clientService.getById(id);
		if (existing == null) {
			return "redirect:/master-client/list";
		}
		model.addAttribute("client", MasterClientFormDto.from(existing));
		return "master-client/form";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("client") MasterClientFormDto client, BindingResult bindingResult) {
		boolean isUpdate = client.getId() != null;
		if (isUpdate && client.getStatus() == null) {
			bindingResult.rejectValue("status", "NotNull", "Status is required");
		}
		if (bindingResult.hasErrors()) {
			return "master-client/form";
		}
		MasterClient entity = client.toEntity();
		if (!isUpdate) {
			entity.setStatus(1);
		}
		clientService.save(entity);
		return "redirect:/master-client/list";
	}
}
