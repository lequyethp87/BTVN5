/**
 * 
 */
package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Member;
import com.vti.utils.HibernateUtils;

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
@Repository
public class MemberRepository implements IMemberRepository {
	private HibernateUtils hibernateUtils;

	/**
	 * Contructor for class MemberRepository.
	 *
	 * @Description: .
	 * @Author: LDQuyet
	 * @Create_Date: 2022/04/29
	 * @Version: 1.0
	 * @Modifier: LDQuyet
	 * @Modifier_Date: 2022/04/29
	 */
	public MemberRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> getAllMember() {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			Query<Member> queries = session.createQuery("FROM Member");
			List<Member> listMember = queries.list();
			return listMember;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Member getMemberById(int id) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			Member member = session.get(Member.class, id);
			return member;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void createMember(Member member) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			session.save(member);
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Override
	public void updateMember(Member member) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			Member memberDB = null;
			if (member.getName() == null) {
				memberDB = session.get(Member.class, member.getId());
				if (member.getPositionId() != null) {
					memberDB.setPositionId(member.getPositionId());
				}
				if (member.getSalary() != 0) {
					memberDB.setSalary(member.getSalary());
				}
				member = null;
				session.update(memberDB);
				session.getTransaction().commit();
			} else {
				session.update(member);
				session.getTransaction().commit();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Override
	public void deleteMember(int id) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			Member member = session.load(Member.class, id);
			session.delete(member);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
