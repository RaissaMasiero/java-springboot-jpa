package com.mavenproject.course.services;

import com.mavenproject.course.entities.User;
import com.mavenproject.course.repositories.UserRepository;
import com.mavenproject.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // registra a classe como componente para que possa ser injetada com autowired
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(Long id, User obj){
        User entidade = repository.getReferenceById(id); // instancia usuário temporário
        updateData(entidade, obj);
        return repository.save(entidade);
    }

    private void updateData(User entidade, User obj) {
        entidade.setNome(obj.getNome());
        entidade.setEmail(obj.getEmail());
        entidade.setFone(obj.getFone());
    }
}
