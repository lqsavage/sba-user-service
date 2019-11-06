package com.iihtibm.sba.reprository;

import java.util.Date;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.iihtibm.sba.entity.User;

/**
 * @author savagelee
 */
public interface UserRepository extends MongoRepository<User, Long> {

	@Override
	@Query(value = "{ 'role':{$ne:'ADMIN'} }")
	Page<User> findAll(Pageable pageable);

	@Override
	@Query(value = "{ '_id':?0 }")
	Optional<User> findById(Long userId);

	@Query(value = "{ 'userName':?0 }")
	Optional<User> findByName(String userName);

	@Query(value = "{ 'userName':?0, 'role':?1 }")
	User findByName(String userName, String userType);

	@Query(value = "{ 'userName':?0, 'confirmedSignUp':true, 'active':true, 'resetPassword':false }")
	public User findByActiveNonResetPasswdUser(String userName);

	@Query(value = "{ 'userName':?0, 'confirmedSignUp':true, 'active':true}")
	public User findByActiveUser(String userName);
	
	@Query(value = "{ 'userName':?0, 'regCode':?1 }")
	public User findUserByNameRegCodeForSignUp(String userName, String token);

	@Query(value = "{'userName':?0, 'regCode':?1, 'confirmedSignUp':true, 'resetPasswordDate':{ $lte:?2 } }")
	public User findUserByNameRegCodeForPwdReset(String userName, String token, Date expiryDate);

}
