package com.spring.blogapp.comments;

import java.util.Date;

import com.spring.blogapp.users.UserEntity;
import org.springframework.data.annotation.CreatedDate;

import com.spring.blogapp.articles.ArticleEntity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "comments")
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@NonNull
	private String boby;
	
	@Nullable
	private String title;
	
	@CreatedDate
	private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name = "articleId", nullable = false)
	private ArticleEntity article;
	

	@ManyToOne
	@JoinColumn(name = "authorId", nullable = false)
	private UserEntity author;
}
