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

import com.sts.demo.dto.MasterTechnologyFormDto;
import com.sts.demo.entity.MasterTechnology;
import com.sts.demo.service.MasterTechnologyService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/master-technology")
public class MasterTechnologyController {

	@Autowired
	private MasterTechnologyService technologyService;

	@GetMapping("/list")
	public String list(Model model) {
		List<MasterTechnology> list = technologyService.getAll();
		model.addAttribute("list", list);
		return "master-technology/list";
	}

	@GetMapping("/add")
	public String addPage(Model model) {
		model.addAttribute("technology", new MasterTechnologyFormDto());
		return "master-technology/form";
	}

	@GetMapping("/edit/{id}")
	public String editPage(@PathVariable Integer id, Model model) {
		MasterTechnology existing = technologyService.getById(id);
		if (existing == null) {
			return "redirect:/master-technology/list";
		}
		model.addAttribute("technology", MasterTechnologyFormDto.from(existing));
		return "master-technology/form";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("technology") MasterTechnologyFormDto technology,
			BindingResult bindingResult) {
		boolean isUpdate = technology.getId() != null;
		if (isUpdate && technology.getStatus() == null) {
			bindingResult.rejectValue("status", "NotNull", "Status is required");
		}
		if (bindingResult.hasErrors()) {
			return "master-technology/form";
		}
		MasterTechnology entity = technology.toEntity();
		if (!isUpdate) {
			entity.setStatus(1);
		}
		technologyService.save(entity);
		return "redirect:/master-technology/list";
	}
}
