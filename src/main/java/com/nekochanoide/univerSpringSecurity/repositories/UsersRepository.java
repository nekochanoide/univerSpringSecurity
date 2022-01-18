package com.nekochanoide.univerSpringSecurity.repositories;

import com.nekochanoide.univerSpringSecurity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
