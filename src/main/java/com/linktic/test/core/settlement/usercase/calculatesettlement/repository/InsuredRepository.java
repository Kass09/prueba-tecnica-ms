package com.linktic.test.core.settlement.usercase.calculatesettlement.repository;

import com.linktic.test.core.settlement.usercase.calculatesettlement.entity.InsuredEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuredRepository extends JpaRepository<InsuredEntity, Long> {

  @Query(value = "SELECT i.* FROM insured i " +
      "JOIN type_identification ti ON i.type_identification_id = ti.id " +
      "WHERE ti.code = :typeIdentificationCode " +
      "AND i.numb_identification = :numbIdentification", nativeQuery = true)
  Optional<InsuredEntity> findByTypeIdentificationAndNumbIdentification(
      String typeIdentificationCode,
      String numbIdentification);

}
