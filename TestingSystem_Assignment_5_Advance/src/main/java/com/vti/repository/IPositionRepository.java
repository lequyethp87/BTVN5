/**
 * 
 */
package com.vti.repository;

import java.util.List;

import com.vti.entity.Position;

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
public interface IPositionRepository {
	public List<Position> getAllPosition();

	public Position getPositionById(int id);

	public void createPosition(Position position);

	public void updatePosition(Position position);

	public void deletePosition(int id);
}
