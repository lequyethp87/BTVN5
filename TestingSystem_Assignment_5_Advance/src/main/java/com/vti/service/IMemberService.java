/**
 * 
 */
package com.vti.service;

import java.util.List;

import com.vti.dto.MemberCreationDTO;
import com.vti.entity.Member;

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
public interface IMemberService {
	public List<Member> getAllMember();
	public Member getMemberById(int id);
	public void createMember(MemberCreationDTO memberCreationDTO);
	public void updateMember(Member member);
	public void deleteMember(int id);

}
