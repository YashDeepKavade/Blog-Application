package in.ls.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ls.bindings.User;
import in.ls.entities.UserEntity;
import in.ls.exceptions.ResourceNotFoundException;
import in.ls.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public User addUser(User user) {
		
		UserEntity userEntity=new UserEntity();
		mapper.map(user,userEntity);
		UserEntity save = userRepo.save(userEntity);
		mapper.map(save,user);
		return user;
	}

	@Override
	public User getUserById(Integer userId) {

		UserEntity findById = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", " Id ", userId));
		
		return this.entityToDto(findById);
		/*User user=new User();
		BeanUtils.copyProperties(findById,user);*/
		
	}

	@Override
	public User updateUser(User user, Integer userId) {

		UserEntity entity = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User"," Id ", userId));
		
		mapper.map(user,UserEntity.class);
		/*entity.setName(user.getName());a
		entity.setEmail(user.getEmail());
		entity.setPassword(user.getPassword());
		entity.setAbout(user.getAbout());*/
		
		UserEntity updatedUser = userRepo.save(entity);
		return this.entityToDto(updatedUser);

		/*BeanUtils.copyProperties(user,findById);
		UserEntity entity=new UserEntity();
		UserEntity save = userRepo.save(entity);
		BeanUtils.copyProperties(save,user);*/
	}

	@Override
	public void deleteUser(Integer userId) {
			userRepo.deleteById(userId);
		
	}

	@Override
	public List<User> getAllUsers() {
		List<UserEntity> findAll = userRepo.findAll();
		List<User> userList=new ArrayList<>();
		for(UserEntity entity:findAll) {
			User user=new User();
			BeanUtils.copyProperties(entity,user);
			userList.add(user);
		}
		return userList;
	}
	
	public UserEntity dtoToEntity(User user) {
		UserEntity entity = mapper.map(user,UserEntity.class);
		
		/*entity.setUserId(user.getUserId());
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPassword(user.getPassword());
		entity.setAbout(user.getAbout());*/
		return entity;
	}
	
	public User entityToDto(UserEntity entity) {
		User user = mapper.map(entity,User.class);
		/*user.setUserId(entity.getUserId());
		user.setName(entity.getName());
		user.setEmail(entity.getName());
		user.setPassword(entity.getPassword());
		user.setAbout(entity.getAbout());*/
		return user;
	}

}
