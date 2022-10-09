package com.facets.cloud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facets.cloud.entity.Node;

@Repository
public interface NodeRepository extends JpaRepository<Node, Integer>{

	public List<Node> findByName(String name);
	public Optional<Node> findById(int id);
}
