package com.yoondev.boardproject.repository;

import com.yoondev.boardproject.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {

}
