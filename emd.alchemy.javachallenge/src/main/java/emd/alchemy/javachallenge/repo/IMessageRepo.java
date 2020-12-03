package emd.alchemy.javachallenge.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import emd.alchemy.javachallenge.model.Message;


public interface IMessageRepo extends JpaRepository<Message, Integer> {

}
