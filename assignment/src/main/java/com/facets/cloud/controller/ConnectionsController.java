package com.facets.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facets.cloud.DTO.ConnectionGroupDTO;
import com.facets.cloud.DTO.ConnectionsDTO;
import com.facets.cloud.DTO.NodeDTO;
import com.facets.cloud.entity.Node;
import com.facets.cloud.exception.InvalidConnectionException;
import com.facets.cloud.exception.NodeNotFoundException;
import com.facets.cloud.service.ConnectionService;

@RestController
@RequestMapping("/connections/api/v1")
public class ConnectionsController {
	
	@Autowired
	ConnectionService connectionService;

	@GetMapping("/{id}")
	public ResponseEntity<String> getNodeById(@PathVariable("id") int id) throws NodeNotFoundException{

		return new ResponseEntity<>(connectionService.getConnectionGroup(id), HttpStatus.OK);
	}
	
	@PostMapping("/registernode")
	public ResponseEntity<Node> registerNode(@RequestBody NodeDTO nodeDTO) {

		return new ResponseEntity<>(connectionService.registerNode(nodeDTO), HttpStatus.OK);
	}
	
	@PostMapping("/creategroup")
	public ResponseEntity<String> createConnectionGroup(@RequestBody ConnectionGroupDTO connectionGroupDTO){	
		
		return new ResponseEntity<>(connectionService.createConnectionGroup(connectionGroupDTO), HttpStatus.OK);
	}
	
	@PostMapping("/createconnections")
	public ResponseEntity<String> createConnections(@RequestBody ConnectionsDTO connectionsDTO) throws InvalidConnectionException{	
			return new ResponseEntity<>(connectionService.createConnections(connectionsDTO), HttpStatus.OK);
	}
}
