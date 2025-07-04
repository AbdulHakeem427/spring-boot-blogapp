package com.spring.blogapp.articles;

import com.spring.blogapp.users.UsersRepository;
import org.springframework.stereotype.Service;

import com.spring.blogapp.articles.dtos.CreateArticleRequest;
import com.spring.blogapp.articles.dtos.UpdateArticleRequest;



@Service
public class ArticlesService {
	
	private final ArticlesRepository articlesRepository;
	private final UsersRepository usersRepository;
	
	public ArticlesService(ArticlesRepository articlesRepository,UsersRepository usersRepository) {
		// TODO Auto-generated constructor stub
		this.articlesRepository=articlesRepository;
		this.usersRepository=usersRepository;
	}
	
	public Iterable<ArticleEntity> getAllArticles(){
		return articlesRepository.findAll();
	}
	
	public ArticleEntity createArticles(CreateArticleRequest art, Long authorId) {
		var author= usersRepository.findById(authorId).orElseThrow(()->new UserNotFoundException(authorId));
		
		return articlesRepository.save(ArticleEntity.builder()
				.title(art.getTitle())
				.body(art.getBody())
				.slug(art.getTitle().toLowerCase().replaceAll("\\s", "-"))
				.subtitle(art.getSubtitle())
				.author(author)
				.build());
	}
	
	public ArticleEntity updateArticles(Long articleId, UpdateArticleRequest a) {
		var article=articlesRepository.findById(articleId).orElseThrow(()->new UserNotFoundException(articleId));
		
		if(a.getBody() != null) {
			article.setBody(a.getBody());
		}
		
		if(a.getTitle() != null) {
			article.setTitle(a.getTitle());
			article.setSlug(a.getTitle().toLowerCase().replaceAll("\\s", "-"));
		}
		
		if(a.getSubtitle() != null) {
			article.setSubtitle(a.getSubtitle());
		}
		
		return articlesRepository.save(article);

		
	}
	
	public ArticleEntity getArticleBySlug(String slug)  {
		var user=articlesRepository.findBySlug(slug);
		if(user == null) {
			throw new ArticleNotFoundException(slug);
		}
		
		return user;
	}
	
	public static class ArticleNotFoundException extends IllegalArgumentException{
		public ArticleNotFoundException(String slug) {
			super("Article with slug " +slug + "not found");
		}
		public ArticleNotFoundException(Long id) {
			super("Article with id " +id + "not found");
		}
	}
	
	public static class UserNotFoundException extends IllegalArgumentException{
		public UserNotFoundException(String username) {
			super("user with username " +username + "not found");
		}
		
		public UserNotFoundException(Long userId) {
			super("user with id " +userId + "not found");
		}
	}
	
}
