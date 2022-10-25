package in.ls.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ls.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Serializable> {

	
}
