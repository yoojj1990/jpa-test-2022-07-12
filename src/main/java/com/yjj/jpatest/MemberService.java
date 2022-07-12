package com.yjj.jpatest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	public void deleteById(Long num) {  // 특정 num으로 조회해서 삭제(delete)
		memberRepository.deleteById(num);
	}
	
	public Optional<MemberDto> findById(Long num) { // 특정 num으로 조회 (select)
		
		Optional<MemberDto> member = memberRepository.findById(num);
		
		return member;
	}
	
	public MemberDto save(MemberDto member) {  // 새로운 member 삽입 (insert)
		
		memberRepository.save(member);
		
		return member;
	}
	
	
	public void updateById(Long num, MemberDto member) { // 데이터 수정 (update)
		
		Optional<MemberDto> member_temp = memberRepository.findById(num);
		// 기존 해당 id의 데이터(dto) 불러오기
		
		if(member_temp.isPresent()) {
			member_temp.get().setNum(member.getNum());
			member_temp.get().setId(member.getId());
			member_temp.get().setName(member.getName());
			memberRepository.save(member);
		} // 새로 수정된 내용으로 업데이트
		
	}
	
	
}
