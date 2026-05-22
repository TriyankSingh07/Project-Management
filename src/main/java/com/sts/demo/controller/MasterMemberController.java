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

import com.sts.demo.dto.MasterMemberFormDto;
import com.sts.demo.entity.MasterMember;
import com.sts.demo.service.MasterMemberService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/master-member")
public class MasterMemberController {

	@Autowired
	private MasterMemberService memberService;

	@GetMapping("/list")
	public String list(Model model) {
		List<MasterMember> list = memberService.getAll();
		model.addAttribute("list", list);
		return "master-member/list";
	}

	@GetMapping("/add")
	public String addPage(Model model) {
		model.addAttribute("member", new MasterMemberFormDto());
		return "master-member/form";
	}

	@GetMapping("/edit/{id}")
	public String editPage(@PathVariable Integer id, Model model) {
		MasterMember existing = memberService.getById(id);
		if (existing == null) {
			return "redirect:/master-member/list";
		}
		model.addAttribute("member", MasterMemberFormDto.from(existing));
		return "master-member/form";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("member") MasterMemberFormDto member, BindingResult bindingResult) {
		boolean isUpdate = member.getId() != null;
		if (isUpdate && member.getStatus() == null) {
			bindingResult.rejectValue("status", "NotNull", "Status is required");
		}
		if (bindingResult.hasErrors()) {
			return "master-member/form";
		}
		MasterMember entity = member.toEntity();
		if (!isUpdate) {
			entity.setStatus(1);
		}
		memberService.save(entity);
		return "redirect:/master-member/list";
	}
}
