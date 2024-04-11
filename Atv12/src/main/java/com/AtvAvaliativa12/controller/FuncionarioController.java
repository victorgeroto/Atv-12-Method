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

import com.AtvAvaliativa12.entity.Funcionario;
import com.AtvAvaliativa12.service.FuncionarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	private final FuncionarioService funcionarioService;

	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getfuncionarioById(@PathVariable Long id) {
		Funcionario funcionario = funcionarioService.getFuncionarioById(id);
		if (funcionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Funcionario>> getAllFuncionario() {
		List<Funcionario> funcionario = funcionarioService.getAllFuncionario();
		return ResponseEntity.ok(funcionario);
	}
	//Query Method
		@GetMapping("/nome/{nome}")
		public ResponseEntity<List<Funcionario>> buscarFuncionariosPorNome(@PathVariable String nome){
			List<Funcionario> Funcionarios = funcionarioService.buscarFuncionariosPorNome (nome);
			return ResponseEntity.ok(Funcionarios);
	}
	//Query Method
			@GetMapping("/nome/{nome}/salario/{salario}")
			public ResponseEntity<List<Funcionario>> buscarFuncionariosPorNomeAndSalario(@PathVariable String nome, String salario){
				List<Funcionario> funcionarios = funcionarioService.buscarFuncionariosPorNomeAndSalario (nome, salario);
				return ResponseEntity.ok(funcionarios);
	}


	@PostMapping("/")
	public ResponseEntity<Funcionario> criarFuncionario(@RequestBody @Valid Funcionario funcionario) {
		Funcionario criarFuncionario = funcionarioService.salvarFuncionario(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarFuncionario);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody @Valid Funcionario funcionario) {
		Funcionario updatedFuncionario = funcionarioService.updateFuncionario(id, funcionario);
		if (updatedFuncionario != null) {
			return ResponseEntity.ok(updatedFuncionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFuncionario(@PathVariable Long id) {
		boolean deleted = funcionarioService.deleteFuncionario(id);
		if (deleted) {
			return ResponseEntity.ok().body("o Funcionario foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}

