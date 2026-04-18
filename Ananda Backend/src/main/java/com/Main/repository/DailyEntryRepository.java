package com.Main.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Main.entity.DailyEntry;
import com.Main.entity.ItemMaster;

@Repository
public interface DailyEntryRepository extends JpaRepository<DailyEntry, Long> {

Optional<DailyEntry> findByItem_ItemIdAndDailyItemTotal_EntryDate(
        Long itemId, LocalDate entryDate);}