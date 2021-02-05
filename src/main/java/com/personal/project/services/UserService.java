package com.personal.project.services;

import com.personal.project.entities.User;
import com.personal.project.repositories.UserRepository;
import com.personal.project.services.exceptions.DataBaseException;
import com.personal.project.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        try {
        repository.deleteById(id);

        } catch(EmptyResultDataAccessException e) {
           throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    public User update(Long id, User user){
        try {
            User entity = repository.getOne(id); //prepara o objeto monitorado para depois mexer
            updateData(entity, user);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
