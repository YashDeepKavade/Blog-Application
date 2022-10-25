package in.ls.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ls.entities.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Serializable>{

}
