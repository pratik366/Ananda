package com.Main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Main.entity.Milk;

@Repository
public interface MilkRepository extends JpaRepository<Milk, Long> {
}