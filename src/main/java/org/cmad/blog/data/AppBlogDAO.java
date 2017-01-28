package org.cmad.blog.data;

import org.cmad.blog.api.Comment;
import org.cmad.blog.api.Post;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppBlogDAO implements BlogDAO {

	@Override
	public Post createBlogPost(int postID) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void createBlogPost(Post blogPost) {
		Session ses = HibernateUtil.currentSession();
		try {
			Transaction tx = ses.beginTransaction();
			ses.save(blogPost);
			tx.commit();
		}finally{
			HibernateUtil.closeSession();
		}
	}


	@Override
	public Post getBlogPost(int postID) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Post updateBlogPost(int postID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post updateBlogPost(Post post) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean deleteBlogPost(int postID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBlogPost(Post post) {
		boolean isBlogDeleted = false;
		if(isPostValid(post)){
			//to-do deleteBlog
			isBlogDeleted = true;
		}
		return isBlogDeleted;
	}

	@Override
	public boolean addComment(Comment comment) {
		boolean isCommentAdded = false;
		if(isCommentValid(comment)){
			//to-do Add comment
		}
		return isCommentAdded;
	}

	@Override
	public Comment readComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment updateComment(Comment comment) {
		Comment updatedComment=null;
		if(isCommentValid(comment)){
			
		}
		return updatedComment;
	}

	@Override
	public boolean deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		boolean isCommentDeleted = false;
		if(isCommentValid(comment)){
			//to-do delete comment
		}
		return isCommentDeleted;
		
	}

	
	private boolean isPostValid(Post post) {
		boolean isPostValid = false;
		if(isPostTitleValid(post) && isPostDescValid(post)){
			isPostValid = true;
		} 
		return isPostValid;
	}

	private boolean isPostTitleValid(Post post) {
		boolean isPostTitleValid = false;
		if(post!=null && post.getTitle()!=null && post.getTitle().trim().length() >0){
			isPostTitleValid = true;
		} 
		return isPostTitleValid;
	}
	
	private boolean isPostDescValid(Post post) {
		boolean isPostDescValid = false;
		if(post!=null && post.getDescription()!=null && post.getDescription().trim().length() >0){
			isPostDescValid = true;
		}
		return isPostDescValid;
	}
	
	private boolean isCommentValid(Comment comment){
		boolean isValidComment = false;
		if(comment!=null && comment.getCommentDesc()!=null && comment.getCommentDesc().trim().length()>0){
			isValidComment = true;
		}
		return isValidComment;
	}
}
