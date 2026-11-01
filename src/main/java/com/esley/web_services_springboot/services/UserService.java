package com.esley.web_services_springboot.services;

import com.esley.web_services_springboot.entities.User;
import com.esley.web_services_springboot.repositories.UserRepository;
import com.esley.web_services_springboot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return  userRepository.findAll();
    }

    public User FindbyId(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id)); //tenta fazer o get, se n tiver user, ele lança a exceção
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User update(Long id, User user){
        User entity = userRepository.getReferenceById(id); // Não vai no banco de dados ainda, ele deixa o objeto gerenciado pelo banco de dados p ser trabalhado, e dps eu posso fazer alguma operação p chamar o bd
        updateData(entity, user);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
