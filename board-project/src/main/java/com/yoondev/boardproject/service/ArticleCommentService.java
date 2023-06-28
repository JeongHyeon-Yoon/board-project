package com.yoondev.boardproject.service;

import com.yoondev.boardproject.dto.ArticleCommentDto;
import com.yoondev.boardproject.repository.ArticleCommentRepository;
import com.yoondev.boardproject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class ArticleCommentService {
    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticlesComment(Long articleId) {
        return List.of();
    }

    public void saveArticleComment(String dto) {
    }
}
