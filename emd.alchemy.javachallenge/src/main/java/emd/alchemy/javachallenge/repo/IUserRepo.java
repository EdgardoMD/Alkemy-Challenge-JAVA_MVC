package emd.alchemy.javachallenge.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import emd.alchemy.javachallenge.model.User;


public interface IUserRepo extends JpaRepository<User, Integer> {
	
	Optional<User> findByDni(String dni);

}
