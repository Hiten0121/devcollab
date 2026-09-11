package com.devcollab.repository;

import com.devcollab.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    long countByProjectId(Long projectId);
    boolean existsByProjectIdAndUserId(Long projectId, Long userId);
    Optional<Like> findByProjectIdAndUserId(Long projectId, Long userId);
}