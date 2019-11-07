package com.iihtibm.sba.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.iihtibm.sba.entity.User;
import com.iihtibm.sba.reprository.UserRepository;
import com.iihtibm.sba.service.SequenceGeneratorService;

/**
 * @author savagelee
 */
@Component
public class DataLoader implements ApplicationRunner {

	private static Logger logger = LoggerFactory.getLogger(DataLoader.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SequenceGeneratorService sequencegenerator;

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {

		userRepository.findByName("admin").map(oldUser -> {
			logger.warn("admin user already exist");
			return oldUser;
		}).orElseGet(() -> {
			User newUser = new User();
			newUser.setId(sequencegenerator.generateSequence(User.SEQUENCE_NAME));
			newUser.setUserName("admin");
			newUser.setPassword("$2a$04$j5Px7Uk5a/sgJcHMlBkGk.GH0tFSrPpfn5VqA5MByr8vBWdN4qU3a");
			newUser.setFirstName("Admin");
			newUser.setLastName("Admin");
			newUser.setContactNumber(9434580584L);
			newUser.setRole("ADMIN");
			newUser.setActive(true);
			newUser.setConfirmedSignUp(true);
			newUser.setPersistent(true); // to create created_date
			userRepository.save(newUser);
			logger.info("admin user inserted");
			return newUser;
		});

		userRepository.findByName("mentor01@163.com").map(oldUser -> {
			logger.warn("mentor_01 user already exist");
			return oldUser;
		}).orElseGet(() -> {
			User newUser = new User();
			newUser.setId(sequencegenerator.generateSequence(User.SEQUENCE_NAME));
			newUser.setUserName("mentor01@163.com");
			newUser.setPassword("$2a$04$j5Px7Uk5a/sgJcHMlBkGk.GH0tFSrPpfn5VqA5MByr8vBWdN4qU3a");
			newUser.setFirstName("mentor_01");
			newUser.setLastName("LI");
			newUser.setContactNumber(9434580584L);
			newUser.setRole("MENTOR");
			newUser.setYearsOfExperience((float) 20);
			newUser.setLinkedinUrl("mentor01@163.com");
			newUser.setActive(true);
			newUser.setConfirmedSignUp(true);
			newUser.setPersistent(true); // to create created_date
			userRepository.save(newUser);
			logger.info("mentor_01 user inserted");
			return newUser;
		});

		userRepository.findByName("user01@163.com").map(oldUser -> {
			logger.warn("user_01 user already exist");
			return oldUser;
		}).orElseGet(() -> {
			User newUser = new User();
			newUser.setId(sequencegenerator.generateSequence(User.SEQUENCE_NAME));
			newUser.setUserName("user01@163.com");
			newUser.setPassword("$2a$04$j5Px7Uk5a/sgJcHMlBkGk.GH0tFSrPpfn5VqA5MByr8vBWdN4qU3a");
			newUser.setFirstName("user_01");
			newUser.setLastName("GU");
			newUser.setContactNumber(9434580584L);
			newUser.setRole("USER");
			newUser.setActive(true);
			newUser.setConfirmedSignUp(true);
			newUser.setPersistent(true); // to create created_date
			userRepository.save(newUser);
			logger.info("user_01 user inserted");
			return newUser;
		});

	}
}
