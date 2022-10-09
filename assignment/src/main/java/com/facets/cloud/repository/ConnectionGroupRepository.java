package com.facets.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facets.cloud.entity.ConnectionGroup;

@Repository
public interface ConnectionGroupRepository extends JpaRepository<ConnectionGroup, Integer>{

}
