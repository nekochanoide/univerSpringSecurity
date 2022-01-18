package com.nekochanoide.univerSpringSecurity.repositories;

import com.nekochanoide.univerSpringSecurity.models.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildrenRepository extends JpaRepository<Child, Long> {
}
