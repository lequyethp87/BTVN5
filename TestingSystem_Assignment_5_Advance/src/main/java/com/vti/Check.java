/**
 * 
 */
package com.vti;

import java.util.Iterator;

import com.vti.entity.Member;
import com.vti.entity.Position;
import com.vti.repository.MemberRepository;
import com.vti.repository.PositionRepository;

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
public class Check {

	/**
	 * This method is.
	 *
	 * @Description: .
	 * @Author: LDQuyet
	 * @Create_Date: 2022/04/29
	 * @Version: 1.0
	 * @Modifier: LDQuyet
	 * @Modifier_Date: 2022/04/29
	 * @param args
	 */
	public static void main(String[] args) {
		MemberRepository re= new MemberRepository();
////		Member member = new Member();
//////		member.setName("Le Phu An");
////		member.setId(2);
////		member.setPositionId(10);
////		member.setSalary(20000);
////		
//////		member.setName("haha22");
////		re.updateMember(member);
//		
		PositionRepository re1 = new PositionRepository();
//		for (Member string : re.getAllMember()) {
//			System.out.println(string);
//			System.out.println(string.getPositionId());
//		}
		for (Position string : re1.getAllPosition()) {
			System.out.println(string);
		}
		

	}

}
