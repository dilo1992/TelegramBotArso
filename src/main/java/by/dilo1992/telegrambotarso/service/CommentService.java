package by.dilo1992.telegrambotarso.service;

import by.dilo1992.telegrambotarso.entity.Comment;
import by.dilo1992.telegrambotarso.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Comment findById(Long id) {
        return commentRepository.findById(id).orElseThrow();
    }

}
