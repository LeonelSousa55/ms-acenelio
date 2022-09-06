package br.com.leonel.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leonel.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{
    
}
