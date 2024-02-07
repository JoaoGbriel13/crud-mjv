package br.com.jg.crudmjv.Mapper;

import br.com.jg.crudmjv.DTO.UserDTO;
import br.com.jg.crudmjv.Model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class UserMapper {
    @Autowired
    private ModelMapper mapper;

    public UserDTO toUserDTO(User user){
        return mapper.map(user, UserDTO.class);
    }
    public User toUser(UserDTO userDTO){
        return mapper.map(userDTO, User.class);
    }

    public List<UserDTO> listDTO(List<User> users){
        return users.stream().map(user -> mapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }
}
