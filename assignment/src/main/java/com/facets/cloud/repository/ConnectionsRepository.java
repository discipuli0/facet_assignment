package com.facets.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facets.cloud.entity.Connections;
import com.facets.cloud.entity.Connections.ConnectionId;

@Repository
public interface ConnectionsRepository extends JpaRepository<Connections, ConnectionId>{

	
}
