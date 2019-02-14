package com.paulmalland.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulmalland.boot.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {

}
