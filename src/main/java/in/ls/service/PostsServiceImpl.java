package in.ls.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ls.bindings.Posts;
import in.ls.entities.CategoryEntity;
import in.ls.entities.PostsEntity;
import in.ls.entities.UserEntity;
import in.ls.exceptions.ResourceNotFoundException;
import in.ls.repository.CategoryRepository;
import in.ls.repository.PostsRepository;
import in.ls.repository.UserRepository;

@Service
public class PostsServiceImpl implements PostsService{

	@Autowired
	private PostsRepository postRepo;
	
	@Autowired
	private CategoryRepository catRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Posts createPost(Posts posts, Integer categoryId, Integer userId) {

		CategoryEntity category = catRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id", categoryId));
		UserEntity user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "User Id", userId));
		PostsEntity postsEntity = mapper.map(posts,PostsEntity.class);
		postsEntity.setImageName("default.png");
		postsEntity.setAddedDate(new Date());
		postsEntity.setCategory(category);
		postsEntity.setUser(user);
		PostsEntity newPost = postRepo.save(postsEntity);
		Posts posts1 = mapper.map(newPost,Posts.class);
		return posts1;
	}

	@Override
	public Posts updatePost(Posts posts, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Posts> getAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Posts getPost(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Posts> getPostsByCategory(Integer categoryId) {

		CategoryEntity category = catRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id", categoryId));
		List<PostsEntity> posts = postRepo.findByCategory(category);
		List<Posts> posts1 = posts.stream().map((post)->mapper.map(post,Posts.class)).collect(Collectors.toList());
		return posts1;
	}

	@Override
	public List<Posts> getPostsByUser(Integer userId) {

		UserEntity user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User Id", userId));
		List<PostsEntity> posts = postRepo.findByUser(user);
		List<Posts> posts1 = posts.stream().map((post)->mapper.map(post,Posts.class)).collect(Collectors.toList());
		return posts1;
	}

	@Override
	public List<Posts> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}


}
