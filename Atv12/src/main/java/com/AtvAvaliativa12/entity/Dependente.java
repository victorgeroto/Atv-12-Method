package com.AtvAvaliativa12.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Dependente")
public class Dependente {


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
		private Long id;

		private String nome;
		
		@ManyToOne
		@JoinColumn(name = "id_funcionario")
		private Departamento funcionario;


}
