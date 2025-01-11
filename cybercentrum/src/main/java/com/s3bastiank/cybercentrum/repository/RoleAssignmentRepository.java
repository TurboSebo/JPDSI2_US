package com.s3bastiank.cybercentrum.repository;

import com.s3bastiank.cybercentrum.entity.RoleAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleAssignmentRepository extends JpaRepository<RoleAssignment, Integer> {
}