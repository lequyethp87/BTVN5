/**
 * 
 */
package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Position;
import com.vti.repository.IPositionRepository;

/**
 * This class is .
 *
 * @Description: .
 * @Author: LDQuyet
 * @Create_Date: 2022/04/30
 * @Version: 1.0
 * @Modifier: LDQuyet
 * @Modifier_Date: 2022/04/30
 */
@Service
public class PositionService implements IPositionService {
	@Autowired
	private IPositionRepository repository;

	@Override
	public List<Position> getAllPosition() {
		return repository.getAllPosition();
	}

	@Override
	public Position getPositionById(int id) {
		return repository.getPositionById(id);
	}

	@Override
	public void createPosition(Position position) {
		repository.createPosition(position);

	}

	@Override
	public void updatePosition(Position position) {
		repository.updatePosition(position);

	}

	@Override
	public void deletePosition(int id) {
		repository.deletePosition(id);

	}

}
