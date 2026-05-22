package com.sts.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.demo.entity.MasterMember;
import com.sts.demo.repository.MasterMemberRepository;
import com.sts.demo.service.MasterMemberService;

@Service
public class MasterMemberServiceImpl implements MasterMemberService {

	@Autowired
	private MasterMemberRepository repository;

	@Override
	public List<MasterMember> getAll() {
		return repository.findAll();
	}

	@Override
	public MasterMember save(MasterMember member) {
		return repository.save(member);
	}

	@Override
	public MasterMember getById(Integer id) {
		return repository.findById(id).orElse(null);
	}
}
