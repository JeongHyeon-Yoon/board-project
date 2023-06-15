package com.yoondev.boardproject.repository;

import com.yoondev.boardproject.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
