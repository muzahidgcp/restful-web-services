package com.smh.rest.webservices.restfulwebservices.self.repo;

import com.smh.rest.webservices.restfulwebservices.self.beans.SelfUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelfUserRepository extends JpaRepository<SelfUser, Long> {

}
