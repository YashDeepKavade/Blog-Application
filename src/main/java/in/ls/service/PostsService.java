package in.ls.service;

import java.util.List;

import in.ls.bindings.Posts;

public interface PostsService {

	public Posts createPost(Posts posts,Integer categoryId,Integer userId);
	
	public Posts updatePost(Posts posts,Integer postId);
	
	public void deletePost(Integer postId);
	
	public List<Posts> getAllPosts();
	
	public Posts getPost(Integer postId);
	
	List<Posts> getPostsByCategory(Integer categoryId);
	
	List<Posts> getPostsByUser(Integer userId);
	
	List<Posts> searchPosts(String keyword);
	
	
	
}
