package com.example.imran.Library.Management.System.repository;

import com.example.imran.Library.Management.System.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
