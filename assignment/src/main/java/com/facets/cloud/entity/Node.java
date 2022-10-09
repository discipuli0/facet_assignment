package com.facets.cloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Node {
	@Id
	private int id;
	private String name;
	@Column(name = "connection_group_id")
	private Integer connectionGroupId;
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
	public Integer getConnectionGroupId() {
		return connectionGroupId;
	}
	public void setConnectionGroupId(int connectionGroupId) {
		this.connectionGroupId = connectionGroupId;
	}
}
