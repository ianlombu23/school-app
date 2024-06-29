package com.school.app.accountservice.repository;

import com.school.app.accountservice.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<Class, String> {

    Optional<Class> findByClassName(String className);
}
