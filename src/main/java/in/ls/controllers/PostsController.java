package in.ls.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ls.bindings.Posts;
import in.ls.service.PostsService;

@RestController
public class PostsController {

	@Autowired
	private PostsService postService;
	
	@PostMapping("/createpost/category/{categoryId}/user/{userId}")
	public ResponseEntity<Posts> createPost(@RequestBody Posts post,
			@PathVariable Integer categoryId,
			@PathVariable Integer userId){
		Posts createPost = postService.createPost(post, categoryId, userId);
		return new ResponseEntity<Posts>(createPost,HttpStatus.CREATED);
	}
	
	@GetMapping("/getpostsbycategory/{categoryId}")
	public ResponseEntity<List<Posts>> getPostsByCategory(@PathVariable Integer categoryId){
		List<Posts> posts = postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<Posts>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/getpostsbyuser/{userId}")
	public ResponseEntity<List<Posts>> getPostsByUser(@PathVariable Integer userId){
		List<Posts> posts = postService.getPostsByUser(userId);
		return new ResponseEntity<List<Posts>>(posts,HttpStatus.OK);
	}
}
