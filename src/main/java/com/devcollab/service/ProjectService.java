package com.devcollab.service;

import com.devcollab.model.Project;
import com.devcollab.model.User;
import com.devcollab.repository.ProjectRepository;
import com.devcollab.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<Project> getAllProjects(String tag) {
        if (tag == null || tag.trim().isEmpty() || tag.equalsIgnoreCase("All Projects")) {
            return projectRepository.findAllByOrderByCreatedAtDesc();
        }
        return projectRepository.findByTechStackContainingIgnoreCase(tag);
    }

    @Transactional(readOnly = true)
    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
    }

    @Transactional
    public Project createProject(String title, String description, String techStack, String repoUrl, String liveUrl,
            String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + userEmail));

        Project project = new Project();
        project.setTitle(title);
        project.setDescription(description);
        project.setTechStack(techStack);
        project.setRepoUrl(repoUrl);
        project.setLiveUrl(liveUrl);
        project.setAuthor(user); // or project.setAuthor(user) based on your setter name

        return projectRepository.save(project);
    }
}