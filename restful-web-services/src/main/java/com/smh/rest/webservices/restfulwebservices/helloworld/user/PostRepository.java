package com.smh.rest.webservices.restfulwebservices.helloworld.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
