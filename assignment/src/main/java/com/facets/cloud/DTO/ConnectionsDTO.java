package com.facets.cloud.DTO;

import com.facets.cloud.entity.Connections;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ConnectionsDTO {

	@JsonProperty("from_node_id")
	int fromNodeId;
	@JsonProperty("to_node_id")
	int toNodeId;
	public int getFromNodeId() {
		return fromNodeId;
	}
	public void setFromNodeId(int fromNodeId) {
		this.fromNodeId = fromNodeId;
	}
	public int getToNodeId() {
		return toNodeId;
	}
	public void setToNodeId(int toNodeId) {
		this.toNodeId = toNodeId;
	}
	
	
	public ConnectionsDTO() {
		super();
	}
	public ConnectionsDTO(int fromNodeId, int toNodeId) {
		super();
		this.fromNodeId = fromNodeId;
		this.toNodeId = toNodeId;
	}
	public Connections toConnections(ConnectionsDTO connectionsDTO) {
		Connections connections = new Connections();
		Connections.ConnectionId connectionId = new Connections.ConnectionId();
		connectionId.setFromNodeId(connectionsDTO.getFromNodeId());
		connectionId.setToNodeId(connectionsDTO.getToNodeId());
		connections.setId(connectionId);
		return connections;
	}
	public ConnectionsDTO toConnectionsDTO(Connections connections) {
		ConnectionsDTO connectionsDTO = new ConnectionsDTO();
		Connections.ConnectionId connectionId = connections.getId();
		connectionsDTO.setFromNodeId(connectionId.getFromNodeId());
		connectionsDTO.setToNodeId(connectionId.getToNodeId());
		return connectionsDTO;
	}
}
