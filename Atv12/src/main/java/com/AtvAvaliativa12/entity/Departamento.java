package com.AtvAvaliativa12.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Departamento")
public class Departamento {


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
		private Long id;

		private String nome;


}