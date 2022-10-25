package in.ls.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ls.entities.CategoryEntity;
import in.ls.entities.PostsEntity;
import in.ls.entities.UserEntity;

@Repository
public interface PostsRepository extends JpaRepository<PostsEntity,Serializable>{

	public List<PostsEntity> findByCategory(CategoryEntity category);
	
	public List<PostsEntity> findByUser(UserEntity user);
}
