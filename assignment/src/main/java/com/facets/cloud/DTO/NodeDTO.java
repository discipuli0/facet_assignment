package com.facets.cloud.DTO;

import com.facets.cloud.entity.Node;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NodeDTO {
	
	private int id;
	private String name;
	@JsonProperty("connection_group_id")
	private int connectionGroupId;
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
	public int getConnectionGroupId() {
		return connectionGroupId;
	}
	public void setConnectionGroupId(int connectionGroupId) {
		this.connectionGroupId = connectionGroupId;
	}
	@Override
	public String toString() {
		return "NodeDTO [id=" + id + ", name=" + name + ", connectionGroup=" + connectionGroupId + "]";
	}
	
	public Node toNode(NodeDTO nodeDTO) {
		Node node = new Node();
		node.setId(nodeDTO.getId());
		node.setName(nodeDTO.getName());
		node.setConnectionGroupId(nodeDTO.getConnectionGroupId());
		return node;
	}
	
	public NodeDTO toNodeDTO(Node node) {
		NodeDTO nodeDTO = new NodeDTO();
		nodeDTO.setId(node.getId());
		nodeDTO.setName(node.getName());
		nodeDTO.setConnectionGroupId(node.getConnectionGroupId());
		return nodeDTO;
	}
	public NodeDTO(int id, String name, int connectionGroupId) {
		super();
		this.id = id;
		this.name = name;
		this.connectionGroupId = connectionGroupId;
	}
	public NodeDTO() {
		super();
	}
	
}
