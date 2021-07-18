package com.project.charity.repository;

import com.project.charity.domain.Role;
import com.project.charity.domain.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);


    List<User> findAllByRolesOrderByCreatedOnDesc(Role role);

    List<User> findAllByRoles(Role role, Sort sort);

}
