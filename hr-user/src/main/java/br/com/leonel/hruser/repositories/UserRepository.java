package br.com.leonel.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leonel.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    User findByEmail(String email);
}
