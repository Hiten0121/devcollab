package com.devcollab.repository;

import com.devcollab.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByOrderByCreatedAtDesc();
    
    @Query("SELECT p FROM Project p WHERE LOWER(p.techStack) LIKE LOWER(CONCAT('%', :tag, '%')) ORDER BY p.createdAt DESC")
    List<Project> findByTechStackContainingIgnoreCase(@Param("tag") String tag);
}