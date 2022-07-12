package com.yjj.jpatest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	public List<MemberDto> findAll() {  // 모든 리스트 출력 메서드 (select)
		List<MemberDto> members = new ArrayList<>();
		memberRepository.findAll().forEach(e -> members.add(e));
		return members;
	}
	
	public void deleteById(Long num) {
		memberRepository.deleteById(num);
	}
	
}
