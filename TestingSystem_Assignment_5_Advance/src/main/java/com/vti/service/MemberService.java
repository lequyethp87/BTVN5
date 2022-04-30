/**
 * 
 */
package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.dto.MemberCreationDTO;
import com.vti.entity.Member;
import com.vti.repository.IMemberRepository;

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
@Service
public class MemberService implements IMemberService{
	@Autowired
	private IMemberRepository repository;
	@Autowired
	private IPositionService positionService;
	@Override
	public List<Member> getAllMember() {
		return repository.getAllMember();
	}

	@Override
	public Member getMemberById(int id) {
		return repository.getMemberById(id);
	}

	@Override
	public void createMember(MemberCreationDTO memberCreationDTO) {
		
		// todo:chueyn tu DTO sang Member
		Member member = new Member();
		member.setName(memberCreationDTO.getName());
		
		// dung possition servicelay Object Position voi id = memberCreationDTO.getPositionId(); l)	
		member.setPositionId(positionService.getPositionById(memberCreationDTO.getPositionId()));
		
		repository.createMember(member);
		
	}

	@Override
	public void updateMember(Member member) {
		repository.updateMember(member);
		
	}

	@Override
	public void deleteMember(int id) {
		repository.deleteMember(id);
		
	}

}
