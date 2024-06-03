package com.tinybeans.backend.evaluation.repository;

import com.tinybeans.backend.evaluation.data.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
