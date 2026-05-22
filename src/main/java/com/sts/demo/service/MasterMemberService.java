package com.sts.demo.service;

import java.util.List;

import com.sts.demo.entity.MasterMember;

public interface MasterMemberService {

	MasterMember save(MasterMember member);

	List<MasterMember> getAll();

	MasterMember getById(Integer id);
}
