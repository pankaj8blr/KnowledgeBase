package org.cmad.blog.data;

import org.cmad.blog.api.Comment;
import org.cmad.blog.api.Post;

public interface BlogDAO {
	
	public Post createBlogPost(int postID);
	public void createBlogPost(Post post);

	public Post getBlogPost(int postID);
	
	public Post updateBlogPost(int postID) ;
	public Post updateBlogPost(Post post) ;
	
	public boolean deleteBlogPost(Post post);
	public boolean deleteBlogPost(int postID);
	
	public boolean addComment(Comment comment);
	public Comment readComment();
	public Comment updateComment(Comment comment) ;
	public boolean deleteComment(Comment comment); 

}
