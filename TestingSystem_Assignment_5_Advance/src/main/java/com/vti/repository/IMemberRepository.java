/**
 * 
 */
package com.vti.repository;

import java.util.List;

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
public interface IMemberRepository {
	public List<Member> getAllMember();
	public Member getMemberById(int id);
	public void createMember(Member member);
	public void updateMember(Member member);
	public void deleteMember(int id);
}
