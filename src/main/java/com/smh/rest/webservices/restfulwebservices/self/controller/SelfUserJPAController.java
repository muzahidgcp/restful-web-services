package com.smh.rest.webservices.restfulwebservices.self.controller;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.smh.rest.webservices.restfulwebservices.self.SelfUserNotFoundException;
import com.smh.rest.webservices.restfulwebservices.self.beans.SelfUser;
import com.smh.rest.webservices.restfulwebservices.self.repo.SelfUserRepository;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/self-users")
public class SelfUserJPAController {

    private final SelfUserRepository selfUserRepository;

    public SelfUserJPAController(SelfUserRepository selfUserRepository) {
         this.selfUserRepository = selfUserRepository;
    }

    @GetMapping("/{id}")
    public SelfUser getSelfUserById(@PathVariable Long id){
        SelfUser selfUser = selfUserRepository
                .findById(id)
                .orElseThrow(() -> new SelfUserNotFoundException("User not found :"+id)
                );
        return selfUser;
    }

    @GetMapping
    public List<SelfUser> retrieveALlSelfUsers(){
        return selfUserRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<SelfUser> postSelfUser(@Valid @RequestBody SelfUser selfUser){
        SelfUser createdUser = selfUserRepository.save(selfUser);

        URI location = ServletUriComponentsBuilder
        			   .fromCurrentRequest()
        			   .path("/{id}")
        			   .buildAndExpand(createdUser.getId())
        			   .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public SelfUser deleteSelfUser(@PathVariable Long id){
        SelfUser deletedUser = this.getSelfUserById(id);
        if (deletedUser==null){
            throw new SelfUserNotFoundException("User not found :"+id);
        }
        selfUserRepository.delete(deletedUser);

        return deletedUser;
    }

}
