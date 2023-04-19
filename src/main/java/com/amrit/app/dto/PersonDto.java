package com.amrit.app.dto;

public class PersonDto {

	private Integer id;

	private String name;

	private Long phone;

	public PersonDto() {

	}

	public PersonDto(Integer id, String name, Long phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "PersonDto [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}

}
