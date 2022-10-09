package com.facets.cloud.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.facets.cloud.DTO.ConnectionGroupDTO;
import com.facets.cloud.DTO.ConnectionsDTO;
import com.facets.cloud.DTO.NodeDTO;
import com.facets.cloud.entity.Node;
import com.facets.cloud.exception.InvalidConnectionException;
import com.facets.cloud.exception.NodeNotFoundException;
import com.facets.cloud.service.ConnectionService;

@ExtendWith(MockitoExtension.class)
public class ConnectionsControllerTest {

	@InjectMocks ConnectionsController connectionsController;
	@Mock ConnectionService connectionService;
	
	@Test
	public void testGetNodeById_valid() throws NodeNotFoundException {
		when(connectionService.getConnectionGroup(1)).thenReturn("1");
		ResponseEntity<String> response = connectionsController.getNodeById(1);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody(), "1");
	}
	
	@Test()
	public void testGetNodeById_invalid() throws NodeNotFoundException {
		NodeNotFoundException dummyException = new NodeNotFoundException("This node does not exist in the system");
		when(connectionService.getConnectionGroup(1)).thenThrow(dummyException);
		
		NodeNotFoundException exception = assertThrows(NodeNotFoundException.class, () -> {
			connectionsController.getNodeById(1);
	    });
		
		assertEquals("This node does not exist in the system", exception.getMessage());
	}
	
	@Test
	public void testCreateConnectionGroup_valid() {
		ConnectionGroupDTO connectionGroupDTO = new ConnectionGroupDTO(1,"group 1");
		when(connectionService.createConnectionGroup(connectionGroupDTO)).thenReturn("Group Created");
		ResponseEntity<String> response = connectionsController.createConnectionGroup(connectionGroupDTO);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody(), "Group Created");
		
	}
	
	@Test
	public void testRegisterNode_valid() {
		NodeDTO nodeDTO = new NodeDTO(1,"node 1",1);
		Node node = nodeDTO.toNode(nodeDTO);
		when(connectionService.registerNode(nodeDTO)).thenReturn(node);
		ResponseEntity<Node> response = connectionsController.registerNode(nodeDTO);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody().toString(), node.toString());
		
	}
	
	@Test
	public void testCreateconnections_valid() throws InvalidConnectionException {
		ConnectionsDTO connectionsDTO = new ConnectionsDTO(1,2);
		String message = "connection from "+connectionsDTO.getFromNodeId()+" to "+connectionsDTO.getToNodeId()+" is created";
		when(connectionService.createConnections(connectionsDTO)).thenReturn(message);
		ResponseEntity<String> response = connectionsController.createConnections(connectionsDTO);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody(), message);
		
	}
	
	@Test
	public void testCreateconnections_invalid() throws InvalidConnectionException {
		ConnectionsDTO connectionsDTO = new ConnectionsDTO(1,2);
		when(connectionService.createConnections(connectionsDTO))
			.thenThrow(new InvalidConnectionException("both nodes belog to different group"));
		InvalidConnectionException exception = assertThrows(InvalidConnectionException.class, () -> {
			connectionsController.createConnections(connectionsDTO);
	    });
		assertEquals("both nodes belog to different group", exception.getMessage());
		
	}
	
}
