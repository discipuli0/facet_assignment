package com.facets.cloud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facets.cloud.DTO.ConnectionGroupDTO;
import com.facets.cloud.DTO.ConnectionsDTO;
import com.facets.cloud.DTO.NodeDTO;
import com.facets.cloud.entity.ConnectionGroup;
import com.facets.cloud.entity.Connections;
import com.facets.cloud.entity.Node;
import com.facets.cloud.exception.InvalidConnectionException;
import com.facets.cloud.exception.NodeNotFoundException;
import com.facets.cloud.repository.ConnectionGroupRepository;
import com.facets.cloud.repository.ConnectionsRepository;
import com.facets.cloud.repository.NodeRepository;

@Service
public class ConnectionService {

	@Autowired
	NodeRepository nodeRepo;
	@Autowired
	ConnectionsRepository connectionsRepo;
	@Autowired
	ConnectionGroupRepository connectionGroupRepo;
	
	public Node registerNode(NodeDTO nodeDTO) {
		Node node = nodeDTO.toNode(nodeDTO);
		nodeRepo.save(node);
		return node;
	}
	
	public String getConnectionGroup(int nodeId) throws NodeNotFoundException {
		Optional<Node> node = nodeRepo.findById(nodeId);
		if(node.isEmpty())
			throw new NodeNotFoundException("This node does not exist in the system");
		System.out.println(node.get().getConnectionGroupId());
		return "Connection group of node "+nodeId+ " is "+node.get().getConnectionGroupId();
	}
	
	public String createConnectionGroup(ConnectionGroupDTO connectionGroupDTO) {
		ConnectionGroup connectionGroup = connectionGroupDTO.toConnectionGroup(connectionGroupDTO);
		connectionGroupRepo.save(connectionGroup);
		return "Group Created";
	}
	
	public String createConnections(ConnectionsDTO connectionsDTO) throws InvalidConnectionException {
		Optional<Node> nodeFrom = nodeRepo.findById(connectionsDTO.getFromNodeId());
		Optional<Node> nodeTo = nodeRepo.findById(connectionsDTO.getToNodeId());
		
		if(nodeFrom.get().getConnectionGroupId() != nodeTo.get().getConnectionGroupId()) {
			throw new InvalidConnectionException("both nodes belog to different group");
		}
		Connections connections = connectionsDTO.toConnections(connectionsDTO);
		connectionsRepo.save(connections);
		return "connection from "+connectionsDTO.getFromNodeId()+" to "+connectionsDTO.getToNodeId()+" is created";
	}
}
