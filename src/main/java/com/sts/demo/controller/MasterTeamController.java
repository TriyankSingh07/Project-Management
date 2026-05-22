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

import com.sts.demo.dto.MasterTeamFormDto;
import com.sts.demo.entity.MasterTeam;
import com.sts.demo.service.MasterTeamService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/master-team")
public class MasterTeamController {

	@Autowired
	private MasterTeamService teamService;

	@GetMapping("/list")
	public String list(Model model) {
		List<MasterTeam> list = teamService.getAll();
		model.addAttribute("list", list);
		return "master-team/list";
	}

	@GetMapping("/add")
	public String addPage(Model model) {
		model.addAttribute("team", new MasterTeamFormDto());
		return "master-team/form";
	}

	@GetMapping("/edit/{id}")
	public String editPage(@PathVariable Integer id, Model model) {
		MasterTeam existing = teamService.getById(id);
		if (existing == null) {
			return "redirect:/master-team/list";
		}
		model.addAttribute("team", MasterTeamFormDto.from(existing));
		return "master-team/form";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("team") MasterTeamFormDto team, BindingResult bindingResult) {
		boolean isUpdate = team.getId() != null;
		if (isUpdate && team.getStatus() == null) {
			bindingResult.rejectValue("status", "NotNull", "Status is required");
		}
		if (bindingResult.hasErrors()) {
			return "master-team/form";
		}
		MasterTeam entity = team.toEntity();
		if (!isUpdate) {
			entity.setStatus(1);
		}
		teamService.save(entity);
		return "redirect:/master-team/list";
	}
}
