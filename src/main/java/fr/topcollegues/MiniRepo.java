package fr.topcollegues;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MiniRepo extends JpaRepository<Collegues, String> {

	Optional<Collegues> findByEmail(String email);
	
}
