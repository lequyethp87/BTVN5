/**
 * 
 */
package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Member;
import com.vti.entity.Position;
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
public class PositionRepository implements IPositionRepository {
	private HibernateUtils hibernateUtils;

	/**
	 * Contructor for class PositionRepository.
	 *
	 * @Description: .
	 * @Author: LDQuyet
	 * @Create_Date: 2022/04/29
	 * @Version: 1.0
	 * @Modifier: LDQuyet
	 * @Modifier_Date: 2022/04/29
	 */
	public PositionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@Override
	@SuppressWarnings("null")
	public Position getPositionById(int id) {
		Session session = null;
		try {
			Position position = session.get(Position.class, id);
			return position;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	@SuppressWarnings({ "unchecked", "null" })
	public List<Position> getAllPosition() {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			Query<Position> queries = session.createQuery("FROM Position");

			return queries.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void createPosition(Position position) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			session.save(position);
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Override
	public void updatePosition(Position position) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			if (position.getName() == null) {
				Position postionDB = getPositionById(position.getId());
				if (position.getCreateDate() != null) {
					postionDB.setCreateDate(position.getCreateDate());
				}
				position = null;
				session.update(postionDB);
				session.getTransaction().commit();
			} else {
				session.update(position);
				session.getTransaction().commit();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Override
	public void deletePosition(int id) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			Position position = session.load(Position.class, id);
			session.delete(position);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
