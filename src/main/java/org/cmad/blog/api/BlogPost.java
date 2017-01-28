package org.cmad.blog.api;


import java.util.List;

import org.cmad.blog.api.exception.BlogException;
import org.cmad.blog.api.exception.PostNotFoundException;
import org.cmad.blog.api.exception.TopicNotFoundExcetion;
import org.cmad.blog.api.exception.UserNotFoundException;

public interface BlogPost{
	
	
	public void addBlogPost(Post post) throws PostNotFoundException,BlogException;
	
	public int addBlogPost(int postId) throws BlogException;

	public boolean addUserPost(int appUserId) throws BlogException;

	public List<Post> getBlogPosts() throws PostNotFoundException,BlogException;

	public List<Post> getBlogPosts(Topic topic) throws TopicNotFoundExcetion,PostNotFoundException,BlogException;

	public Post getBlogPost(int postId) throws PostNotFoundException, BlogException;
	
	public  List<Post> getAppUserPosts(int appUserId) throws PostNotFoundException, UserNotFoundException;
	
	public boolean addComment(Comment comment) throws BlogException;

}
