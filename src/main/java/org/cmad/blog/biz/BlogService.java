package org.cmad.blog.biz;

import java.util.List;

import org.cmad.blog.api.BlogPost;
import org.cmad.blog.api.Comment;
import org.cmad.blog.api.Post;
import org.cmad.blog.api.Topic;
import org.cmad.blog.api.exception.BlogException;
import org.cmad.blog.api.exception.InvalidCommentException;
import org.cmad.blog.api.exception.InvalidPostException;
import org.cmad.blog.api.exception.PostNotFoundException;
import org.cmad.blog.api.exception.UserNotFoundException;
import org.cmad.blog.data.AppBlogDAO;
import org.cmad.blog.data.BlogDAO;

public class BlogService implements BlogPost{
	private BlogDAO blogDAO = new AppBlogDAO();

	public BlogService() {
		super();
		this.blogDAO = new AppBlogDAO();
	}
	
	public BlogService(AppBlogDAO userDao) {
		super();
		this.blogDAO = userDao;
	}
	@Override
	public void addBlogPost(Post post) throws BlogException {
		System.out.println("BlogService.addPost()post: "+post);
//		Post blogPost = null;
		int postId = -1;
		if(isPostValid(post)){
//			blogPost = blogDAO.createBlogPost(post);
			blogDAO.createBlogPost(post);
			if(post!=null){
				System.out.println("BlogService.addBlogPost() Id: "+post.getId());
				System.out.println("BlogService.addBlogPost() AppUserId: "+post.getAppUserId());
				System.out.println("BlogService.addBlogPost() Title: "+post.getTitle());
				System.out.println("BlogService.addBlogPost() Descriptio: "+post.getDescription());
			}
		} else {
			throw new InvalidPostException();
		}
		System.out.println("BlogService.addPost()postId: "+postId);

//		return blogPost;
	}
	
	@Override
	public int addBlogPost(int postId) throws BlogException {
		// TODO Auto-generated method stub
		return postId;
	}

	@Override
	public boolean addUserPost(int appUserId) throws BlogException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Post> getAppUserPosts(int appUserId) throws PostNotFoundException, UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	


	@Override
	public boolean addComment(Comment comment) throws BlogException {
		boolean isCommentAdded = false;
		if(isCommentValid(comment)){
			blogDAO.addComment(comment);
			isCommentAdded = true;
		}
		return isCommentAdded;
	}

	@Override
	public List<Post> getBlogPosts() throws BlogException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getBlogPosts(Topic topic) throws BlogException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getBlogPost(int postId) throws PostNotFoundException, BlogException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean isPostValid(Post post) throws InvalidPostException{
		boolean isPostValid = false;
		if(isPostTitleValid(post) && isPostDescValid(post)){
			isPostValid = true;
		} 
		return isPostValid;
	}

	private boolean isPostTitleValid(Post post) throws InvalidPostException{
		boolean isPostTitleValid = false;
		if(post!=null && post.getTitle()!=null && post.getTitle().trim().length() >0){
			isPostTitleValid = true;
		} else{
			throw new InvalidPostException(InvalidPostException.INVALID_POST_TITLE);
		}
		System.out.println("BlogService.isPostTitleValid()isPostTitleValid : "+isPostTitleValid);
		return isPostTitleValid;
	}
	
	private boolean isPostDescValid(Post post) throws InvalidPostException{
		boolean isPostDescValid = false;
		if(post!=null && post.getDescription()!=null && post.getDescription().trim().length() >0){
			isPostDescValid = true;
		} else{
			throw new InvalidPostException(InvalidPostException.INVALID_POST_DESCRIPTION);
		}
		System.out.println("BlogService.isPostDescValid()isPostDescValid: "+isPostDescValid);
		return isPostDescValid;
	}
	
	private boolean isCommentValid(Comment comment)  throws InvalidCommentException{
		boolean isValidComment = false;
		if(comment!=null && comment.getCommentDesc()!=null && comment.getCommentDesc().trim().length()>0){
			isValidComment = true;
		}else{
			throw new InvalidCommentException(InvalidCommentException.INVALID_COMMENT);
		}
		return isValidComment;
	}

	
}