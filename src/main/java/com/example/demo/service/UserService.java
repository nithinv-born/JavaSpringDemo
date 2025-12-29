package com.example.demo.service;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    // ---------- CREATE USER (TRANSACTION) ----------
    @Transactional
    public User createUser(UserRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        return repo.save(user);
    }

    // ---------- PAGINATION + SORT + FILTER ----------
    public Page<User> getUsers(
            int page,
            int size,
            String sortBy,
            String direction,
            String name,
            String email
    ) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        if (name != null && email != null) {
            return repo.findByNameContainingIgnoreCaseAndEmailContainingIgnoreCase(
                    name, email, pageable);
        }

        if (name != null) {
            return repo.findByNameContainingIgnoreCase(name, pageable);
        }

        if (email != null) {
            return repo.findByEmailContainingIgnoreCase(email, pageable);
        }

        return repo.findAll(pageable);
    }
}
