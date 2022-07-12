package com.yjj.jpatest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="jpa_member") // DB테이블 이름을 입력
public class MemberDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long num;
	
	String id;
	
	String name;
	
	
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Builder
	public MemberDto(Long num, String id, String name) {
		super();
		this.num = num;
		this.id = id;
		this.name = name;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
