    package com.smh.rest.webservices.restfulwebservices.helloworld.user;

    import jakarta.validation.Valid;
    import org.springframework.context.MessageSource;
    import org.springframework.context.i18n.LocaleContextHolder;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

    import java.net.URI;
    import java.util.List;
    import java.util.Locale;

    @RestController
    public class UserResourceController {

        private MessageSource source;

        private UserDAOService service;

        public UserResourceController(UserDAOService service, MessageSource source) {
            this.service = service;
            this.source = source;
        }

        @GetMapping("/users/{id}")
        public User findUser(@PathVariable int id) {
            User user = service.findOne(id);
            if (user==null) {
                throw new UserNotFoundException("Id :"+id);
            }
            return user;
        }

        @GetMapping("/users")
        public List<User> findAllUsers() {
            return service.findAll();
        }

        @PostMapping("/users")
        public ResponseEntity<User> createUser(@Valid @RequestBody User user){
            User savedUser = service.save(user);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
            return ResponseEntity.created(location).build();
        }

        @DeleteMapping("/users/{id}")
        public void deleteUser(@PathVariable int id) {
            service.delete(id);
        }

        @GetMapping("/hello-world/internationalization")
        public String helloWorldInternationalization() {
            Locale locale = LocaleContextHolder.getLocale();
            return source.getMessage("good.morning.message",null,"Default Message", locale);
        }
    }
