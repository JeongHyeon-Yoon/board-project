package com.yoondev.boardproject.service;

import com.yoondev.boardproject.domain.Article;
import com.yoondev.boardproject.domain.type.SearchType;
import com.yoondev.boardproject.dto.ArticleDto;
import com.yoondev.boardproject.dto.ArticleUpdateDto;
import com.yoondev.boardproject.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

@DisplayName("비지니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {
    @InjectMocks private ArticleService sut;
    @Mock private ArticleRepository articleRepository;

    @Test
    @DisplayName("게시글을 검색하면, 게시글 리스트를 반환")
    void givenSearchParameters_whenSearchingArticle_thenReturnArticleList() {
        // Given

        // When
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "seach keyword"); //제목, 본문, 아이디, 닉네임, 헤시태그

        // Then
        assertThat(articles).isNotNull();

    }
    @Test
    @DisplayName("게시글을 조회하면, 게시글을 반환")
    void givenArticleId_whenSearchingArticle_thenReturnArticle() {
        // Given

        // When
        ArticleDto article = sut.searchArticle(1L);

        // Then
        assertThat(article).isNotNull();

    }
    @Test
    @DisplayName("게시글을 정보를 입력하면, 게시글을 생성한다")
    void givenArticleInfo_whenSavingArticle_thenSavesArticle() {
        // Given
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // When
        sut.saveArticle(ArticleDto.of(LocalDateTime.now(), "yoondev","titile", "content", "hashtag"));

        // Then
        then(articleRepository).should().save(any(Article.class));

    }

    @Test
    @DisplayName("게시글의 ID와 수정 정보를 입력하면, 게시글을 수정한다")
    void givenArticleIdAndModifedInfo_whenSavingArticle_thenUpdateArticle() {
        // Given
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // When
        sut.updateArticle(1L, ArticleUpdateDto.of("titile", "content", "hashtag"));

        // Then
        then(articleRepository).should().save(any(Article.class));

    }
    @Test
    @DisplayName("게시글의 ID를 입력하면, 게시글을 삭제한다")
    void givenArticleId_whenSavingArticle_thenDeletingArticle() {
        // Given
        willDoNothing().given(articleRepository).delete(any(Article.class));

        // When
        sut.deleteArticle(1L);

        // Then
        then(articleRepository).should().save(any(Article.class));

    }



}