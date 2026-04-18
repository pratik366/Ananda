package com.Main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Main.entity.ItemMaster;

@Repository
public interface ItemMasterRepository extends JpaRepository<ItemMaster, Long>{

}
