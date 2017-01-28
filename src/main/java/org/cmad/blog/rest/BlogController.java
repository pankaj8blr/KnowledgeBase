package org.cmad.blog.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.cmad.blog.api.BlogPost;
import org.cmad.blog.api.Comment;
import org.cmad.blog.api.Post;
import org.cmad.blog.api.User;
import org.cmad.blog.biz.BlogService;

@Path("/blogpost")
public class BlogController {
	public BlogController() {
		System.out.println("BlogController.BlogController()");
	}
	/*@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addblog")
	public Response addBlog(Post post) {
		System.out.println("BlogController.addBlog() post: "+post);
		Blog blog = new UserBlog();
		System.out.println("BlogController.addBlog()blog: "+blog);
		int postId = blog.addPost(post);
		System.out.println("postId: "+postId);;
		return Response.ok().entity(postId + "").build();
	}*/
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/createblog")
	public Response createBlogPost(Post post) {
		System.out.println("BlogController.createBlogPost() post: "+post);
		BlogPost blogPostService = new BlogService();
		System.out.println("BlogController.createBlogPost()blogPostService: "+blogPostService);
		/*Post blogPost = blogPostService.addBlogPost(post);*/
		blogPostService.addBlogPost(post);
		/*System.out.println("blogPost: "+blogPost);*/
		if(post!=null)
		{
			System.out.println("BlogController.createBlogPost() Id: "+post.getId());
			System.out.println("BlogController.createBlogPost() AppUserId: "+post.getAppUserId());
			System.out.println("BlogController.createBlogPost() Title: "+post.getTitle());
			System.out.println("BlogController.createBlogPost() Descriptio: "+post.getDescription());
		}
		Response res = Response.ok().entity(post + "").build();
		System.out.println("BlogController.createBlogPost()res: "+res);
		System.out.println("BlogController.createBlogPost()res.status: "+res.getStatus());
		return res;
	}



	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateblog")
	public Response updateBlogPost(User blog) {
		return Response.ok().entity(blog).build();
	}
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/blog/{no}")
	public Response read(@PathParam("no") int number) {
		
		Blog blog = new UserBlog();
		Post post = new Post();
		
		post = blog.getPost(number);
		return Response.ok().entity(post).build();
	}*/
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/comment")
	public Response addComment(Comment comment) {
		return Response.ok().entity(comment).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user")
	public Response updateComment(Comment comment) {
		return Response.ok().entity(comment).build();
	}
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/blog/{no}")
	public Response read(@PathParam("no") int number) {
		
	}*/

	
}
