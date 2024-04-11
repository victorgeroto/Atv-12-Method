package com.AtvAvaliativa12.repository;

	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;

	import com.AtvAvaliativa12.entity.Departamento;

	public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
		List<Departamento> findByNome(String nome);
		
}
