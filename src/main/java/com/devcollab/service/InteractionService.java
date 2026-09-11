package com.devcollab.service;

import com.devcollab.model.Comment;
import com.devcollab.model.Like;
import com.devcollab.model.Project;
import com.devcollab.model.User;
import com.devcollab.repository.CommentRepository;
import com.devcollab.repository.LikeRepository;
import com.devcollab.repository.ProjectRepository;
import com.devcollab.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InteractionService {

    private final CommentRepository commentRepository;
    private final LikeRepository likeRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public List<Comment> getComments(Long projectId) {
        return commentRepository.findByProjectIdOrderByCreatedAtDesc(projectId);
    }

    @Transactional
    public Comment addComment(Long projectId, String content, String userEmail) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Comment comment = Comment.builder()
                .content(content)
                .project(project)
                .user(user)
                .build();

        return commentRepository.save(comment);
    }

    public long getLikesCount(Long projectId) {
        return likeRepository.countByProjectId(projectId);
    }

    @Transactional
    public boolean toggleLike(Long projectId, String userEmail) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        var existingLike = likeRepository.findByProjectIdAndUserId(projectId, user.getId());
        if (existingLike.isPresent()) {
            likeRepository.delete(existingLike.get());
            return false; // unliked
        } else {
            Like like = Like.builder().project(project).user(user).build();
            likeRepository.save(like);
            return true; // liked
        }
    }
}