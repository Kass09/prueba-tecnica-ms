package com.linktic.test.core.settlement.usercase.calculatesettlement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity()
@Table(name = "primas")
public class PrimaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "minimum_age")
  private int minimumAge;

  @Column(name = "maximum_age")
  private int maximumAge;

  @Column(name = "prima_percentage")
  private BigDecimal primaPercent;

  @OneToOne()
  @JoinColumn(name = "amparo_id")
  private AmparoEntity amparo;
}
