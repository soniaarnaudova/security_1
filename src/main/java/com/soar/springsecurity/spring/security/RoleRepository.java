package com.soar.springsecurity.spring.security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
     Role getRoleById(Long id);
}
