package com.sts.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sts.demo.entity.Category;
import com.sts.demo.service.CategoryService;

@Controller
@RequestMapping("/meta")
public class MetaController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/list")
	public String list(Model model) {
		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		return "meta/list";
	}
}
