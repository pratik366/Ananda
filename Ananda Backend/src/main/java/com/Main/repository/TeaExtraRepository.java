package com.Main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Main.entity.TeaExtra;

@Repository
public interface TeaExtraRepository extends JpaRepository<TeaExtra, Long> {

}
