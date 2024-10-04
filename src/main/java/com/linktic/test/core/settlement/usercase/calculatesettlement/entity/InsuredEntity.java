package com.linktic.test.core.settlement.usercase.calculatesettlement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "insured")
public class InsuredEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "numb_identification")
  private String numbIdentification;

  @Column(name = "lastname")
  private String lastname;

  @Column(name = "full_name")
  private String fullName;

  @ManyToOne
  @JoinColumn(name = "type_identification_id", nullable = false)
  private TypeIdentificationEntity typeIdentification;

  @ManyToOne
  @JoinColumn(name = "gender_id", nullable = false)
  private GenderEntity gender;

  @Column(name = "birthdate")
  private LocalDateTime birthdate;
}
