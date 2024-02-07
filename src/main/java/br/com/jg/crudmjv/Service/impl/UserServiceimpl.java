package br.com.jg.crudmjv.Service.impl;

import br.com.jg.crudmjv.DTO.UserDTO;
import br.com.jg.crudmjv.Mapper.UserMapper;
import br.com.jg.crudmjv.Model.User;
import br.com.jg.crudmjv.Repository.UserRepository;
import br.com.jg.crudmjv.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserMapper userMapper;

    public UserServiceimpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseEntity saveUser(UserDTO userDTO) {
        User userToAdd = userMapper.toUser(userDTO);
        if (userRepository.findByEmail(userToAdd.getEmail()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse email já está cadastrado no sistema");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.toUserDTO(userRepository.save(userToAdd)));
    }

    @Override
    public ResponseEntity getAll() {
        if (userRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Não existem usuarios cadastrados");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(userMapper.listDTO(userRepository.findAll()));
    }

    @Override
    public ResponseEntity getById(Long id) {
        if (userRepository.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe usuario com esse ID");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(userMapper.toUserDTO(userRepository.findById(id).get()));

    }

    @Override
    public ResponseEntity getByAge(Long age) {
        if (userRepository.findByAge(age).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum usuario encontrado com essa idade");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(userMapper.listDTO(userRepository.findByAge(age)));
    }

    @Override
    public ResponseEntity updateUser(UserDTO user, Long id) {
        Optional<User> userToUpdate = userRepository.findById(id);
        if (userToUpdate.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum usuario encontrado");
        }
        userToUpdate.get().setAge(user.getAge());
        userToUpdate.get().setName(user.getName());
        userToUpdate.get().setEmail(user.getEmail());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userMapper.toUserDTO(userRepository.save(userToUpdate.get())));
    }

    @Override
    public ResponseEntity deleteUser(Long id) {
        if (!userRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }
        userRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Usuario removido");
    }
}
