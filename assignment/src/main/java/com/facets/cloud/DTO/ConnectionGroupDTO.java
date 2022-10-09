package com.facets.cloud.DTO;

import javax.persistence.Id;

import com.facets.cloud.entity.ConnectionGroup;

public class ConnectionGroupDTO {

	@Id
	private int id;
	private String name;
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
	
	public ConnectionGroup toConnectionGroup(ConnectionGroupDTO connectionGroupDTO) {
		ConnectionGroup connectionGroup = new ConnectionGroup();
		connectionGroup.setId(connectionGroupDTO.getId());
		connectionGroup.setName(connectionGroupDTO.getName());
		return connectionGroup;
	}
	
	public ConnectionGroupDTO toConnectionGroupDTO(ConnectionGroup connectionGroup) {
		ConnectionGroupDTO connectionGroupDTO = new ConnectionGroupDTO();
		connectionGroupDTO.setId(connectionGroup.getId());
		connectionGroupDTO.setName(connectionGroup.getName());
		return connectionGroupDTO;
	}
	public ConnectionGroupDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public ConnectionGroupDTO() {
		super();
	}
	
}
