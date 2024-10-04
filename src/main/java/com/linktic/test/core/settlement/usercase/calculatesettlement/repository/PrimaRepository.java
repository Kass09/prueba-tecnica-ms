package com.linktic.test.core.settlement.usercase.calculatesettlement.repository;

import com.linktic.test.core.settlement.usercase.calculatesettlement.entity.PrimaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaRepository extends JpaRepository<PrimaEntity, Long> {

  @Query("SELECT p FROM PrimaEntity p WHERE p.minimumAge <= :age AND maximumAge >= :age")
  List<PrimaEntity> findByAgeRange(int age);
}
