package com.AtvAvaliativa12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AtvAvaliativa12.entity.Departamento;
import com.AtvAvaliativa12.service.DepartamentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	private final DepartamentoService departamentoService;

	@Autowired
	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Departamento> getdepartamentoById(@PathVariable Long id) {
		Departamento departamento = departamentoService.getDepartamentoById(id);
		if (departamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Departamento>> getAllDepartamento() {
		List<Departamento> departamento = departamentoService.getAllDepartamento();
		return ResponseEntity.ok(departamento);
	}
	//Query Method
		@GetMapping("/nome/{nome}")
		public ResponseEntity<List<Departamento>> buscarDepartamentosPorNome(@PathVariable String nome){
			List<Departamento> Departamentos = departamentoService.buscarDepartamentosPorNome (nome);
			return ResponseEntity.ok(Departamentos);
	}

	@PostMapping("/")
	public ResponseEntity<Departamento> criarDepartamento(@RequestBody @Valid Departamento departamento) {
		Departamento criarDepartamento = departamentoService.salvarDepartamento(departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarDepartamento);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Departamento> updateDepartamento(@PathVariable Long id, @RequestBody @Valid Departamento departamento) {
		Departamento updatedDepartamento = departamentoService.updateDepartamento(id, departamento);
		if (updatedDepartamento != null) {
			return ResponseEntity.ok(updatedDepartamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDepartamento(@PathVariable Long id) {
		boolean deleted = departamentoService.deleteDepartamento(id);
		if (deleted) {
			return ResponseEntity.ok().body("o Departamento foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}

