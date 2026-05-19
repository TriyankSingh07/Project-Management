package com.sts.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sts.demo.entity.MasterClient;
import com.sts.demo.entity.MasterTransaction;
import com.sts.demo.service.MasterClientService;

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
		model.addAttribute("client", new MasterClient());
		return "master-client/form";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute MasterClient client) {
		clientService.save(client);
		return "redirect:/master-client/list";
	}
}