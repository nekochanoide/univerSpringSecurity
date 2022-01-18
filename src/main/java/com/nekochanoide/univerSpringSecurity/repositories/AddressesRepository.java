package com.nekochanoide.univerSpringSecurity.repositories;

import com.nekochanoide.univerSpringSecurity.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressesRepository extends JpaRepository<Address, Long> {
}
