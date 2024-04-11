package com.AtvAvaliativa12.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AtvAvaliativa12.entity.Funcionario;
import com.AtvAvaliativa12.repository.FuncionarioRepository;

@Service
public class FuncionarioService  {
	
private final FuncionarioRepository funcionarioRepository;
	
	@Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }
	
	  public List<Funcionario> getAllFuncionario() {
	        return funcionarioRepository.findAll();
	    }

	    public Funcionario getFuncionarioById(Long id) {
	        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
	        return funcionario.orElse(null);
	    }
	  //Query Method
	    public List<Funcionario> buscarFuncionariosPorNome(String nome){
	    	return funcionarioRepository.findByNome(nome);
	    }
	  //Query Method
	    public List<Funcionario> buscarFuncionariosPorNomeAndSalario(String nome, String salario){
	    	return funcionarioRepository.findByNomeAndSalario(nome,salario);
	    }

	  
	    public Funcionario salvarFuncionario(Funcionario funcionario) {
	        return funcionarioRepository.save(funcionario);
	    }

	    public Funcionario updateFuncionario(Long id, Funcionario updatedeFuncionario) {
	        Optional<Funcionario> existingFuncionario = funcionarioRepository.findById(id);
	        if (existingFuncionario.isPresent()) {
	            updatedFuncionario.setId(id);
	            return funcionarioRepository.save(updatedFuncionario);
	        }
	        return null;
	    }

	    public boolean deleteFuncionario(Long id) {
	        Optional<Funcionario> existingFuncionario = funcionarioRepository.findById(id);
	        if (existingFuncionario.isPresent()) {
	        	funcionarioRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	  
}


