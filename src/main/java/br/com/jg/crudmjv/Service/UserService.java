package br.com.jg.crudmjv.Service;

import br.com.jg.crudmjv.DTO.UserDTO;
import br.com.jg.crudmjv.Model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity saveUser(UserDTO user);
    public ResponseEntity getAll();
    public ResponseEntity getById(Long id);
    public ResponseEntity getByAge(Long age);
    public ResponseEntity updateUser(UserDTO user, Long id);
    public ResponseEntity deleteUser(Long id);
}
