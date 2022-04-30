/**
 * 
 */
package com.vti.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.bind.annotation.Mapping;

import lombok.Data;

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
@Entity
@Data
@Table(name = "`Position`")
public class Position implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "PosID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "PositionName")
	private String name;

	@Column(name = "CreateDate")
//	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private LocalDate createDate;

	@OneToMany(mappedBy = "positionId", cascade = { CascadeType.PERSIST })
	private List<Member> members;

	@PreRemove
	private void preRemove() {
		for (Member s : members) {
			s.setPositionId(null);
			;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	/**
	 * Contructor for class Position.
	 *
	 * @Description: .
	 * @Author: LDQuyet
	 * @Create_Date: 2022/04/29
	 * @Version: 1.0
	 * @Modifier: LDQuyet
	 * @Modifier_Date: 2022/04/29
	 */

}
