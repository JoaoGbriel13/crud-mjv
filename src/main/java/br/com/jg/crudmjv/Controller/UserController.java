package br.com.jg.crudmjv.Controller;

import br.com.jg.crudmjv.DTO.UserDTO;
import br.com.jg.crudmjv.Model.User;
import br.com.jg.crudmjv.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        return userService.getAll();
    }
    @GetMapping("/all-by-age")
    public ResponseEntity getByAge(Long age){
        return userService.getByAge(age);
    }
    @GetMapping("get-by-id")
    public ResponseEntity getById(Long id){
        return userService.getById(id);
    }
    @PostMapping("/save-user")
    public ResponseEntity saveUser(@RequestBody UserDTO user){
        return userService.saveUser(user);
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, UserDTO userDTO){
        return userService.updateUser(userDTO, id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
