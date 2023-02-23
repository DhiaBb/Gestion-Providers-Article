package com.sip.ams.repository;

import org.springframework.data.repository.CrudRepository;

import com.sip.ams.entities.Article;

public interface ArticleRepository extends CrudRepository<Article,Long> {

}
