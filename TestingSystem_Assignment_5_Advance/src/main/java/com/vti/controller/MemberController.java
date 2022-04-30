/**
 * 
 */
package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.MemberCreationDTO;
import com.vti.entity.Member;
import com.vti.service.IMemberService;

/**
 * This class is .
 *
 * @Description: .
 * @Author: LDQuyet
 * @Create_Date: 2022/04/29
 * @Version: 1.0
 * @Modifier: LDQuyet
 * @Modifier_Date: 2022/04/29
 */
@RestController
@RequestMapping(value = "api/v1/members")
//@CrossOrigin("*")
public class MemberController {
	@Autowired
	private IMemberService service;

	@GetMapping()
	public List<Member> getAllMember() {
		return service.getAllMember();
	}

	@GetMapping(value = "/{id}")
	public Member getMemberById(@PathVariable(name = "id") int id) {
		return service.getMemberById(id);
	}

	@PostMapping
	public void createMember(@RequestBody MemberCreationDTO memberCreationDTO) {
		service.createMember(memberCreationDTO);

	}

	@PutMapping(value = "/{id}")
	public void updateMember(@PathVariable(name = "id") int id, @RequestBody Member member) {
		member.setId(id);
		service.updateMember(member);

	}

	@DeleteMapping(value = "/{id}")
	public void deleteMember(@PathVariable(name = "id") int id) {
		service.deleteMember(id);

	}
}
