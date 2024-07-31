package com.auth;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.User;

import com.auth.entity.Users;

@SpringBootApplication
public class RoleBasedAuthenticationApplication {

	public static void main(String[] args) {
//		SpringApplication.run(RoleBasedAuthenticationApplication.class, args);
		
		List<Users> users =new ArrayList<>();
		users.add(new Users(1,"jemish","1234","asd"));
		users.add(new Users(2,"jemish","1234","asd"));
		users.add(new Users(3,"jemish","1234","asd"));
		users.add(new Users(4,"jemish","1234","asd"));
		
		
		Map<Integer, String> map =new HashMap<>();
		
		map.put(1, "12");
		map.put(2, "23");
		map.put(3, "34");
		map.put(4, "56");
		
		
		users.sort(Comparator.comparing(Users::getEmail).thenComparing(Users::getId));
		
		
		Map<Integer, Object> map1 = users.stream()
			    .collect(Collectors.toMap(
			        Users::getId,
			        l -> map.get(l.getId())
			    ));
		
		System.out.println();
		
	}

}
