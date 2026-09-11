package com.devcollab.controller;

import com.devcollab.model.Project;
import com.devcollab.service.ProjectService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects(@RequestParam(required = false) String tag) {
        return ResponseEntity.ok(projectService.getAllProjects(tag));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectRequest request, Authentication authentication) {
        String userEmail = authentication.getName();
        Project project = projectService.createProject(
                request.getTitle(), request.getDescription(), request.getTechStack(),
                request.getRepoUrl(), request.getLiveUrl(), userEmail);
        return ResponseEntity.status(201).body(project);
    }

    @Data
    public static class ProjectRequest {
        private String title;
        private String description;
        private String techStack;
        private String repoUrl;
        private String liveUrl;
    }
}