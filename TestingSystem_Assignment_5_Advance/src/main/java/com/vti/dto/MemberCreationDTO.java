/**
 * 
 */
package com.vti.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class MemberCreationDTO {

	private String name;

	private Integer positionId;

	private Double salary;

	private String profileImgUrl;

	private String fbLink;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getProfileImgUrl() {
		return profileImgUrl;
	}

	public void setProfileImgUrl(String profileImgUrl) {
		this.profileImgUrl = profileImgUrl;
	}

	public String getFbLink() {
		return fbLink;
	}

	public void setFbLink(String fbLink) {
		this.fbLink = fbLink;
	}
	
	

}
