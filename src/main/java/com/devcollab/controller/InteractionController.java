package com.devcollab.controller;

import com.devcollab.model.Comment;
import com.devcollab.service.InteractionService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/projects/{projectId}")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class InteractionController {

    private final InteractionService interactionService;

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable Long projectId) {
        return ResponseEntity.ok(interactionService.getComments(projectId));
    }

    @PostMapping("/comments")
    public ResponseEntity<Comment> addComment(@PathVariable Long projectId, @RequestBody CommentRequest request, Authentication authentication) {
        Comment comment = interactionService.addComment(projectId, request.getContent(), authentication.getName());
        return ResponseEntity.status(201).body(comment);
    }

    @GetMapping("/likes")
    public ResponseEntity<?> getLikes(@PathVariable Long projectId) {
        long count = interactionService.getLikesCount(projectId);
        return ResponseEntity.ok(Map.of("likesCount", count));
    }

    @PostMapping("/likes")
    public ResponseEntity<?> toggleLike(@PathVariable Long projectId, Authentication authentication) {
        boolean liked = interactionService.toggleLike(projectId, authentication.getName());
        long count = interactionService.getLikesCount(projectId);
        return ResponseEntity.ok(Map.of("liked", liked, "likesCount", count));
    }

    @Data
    public static class CommentRequest {
        private String content;
    }
}