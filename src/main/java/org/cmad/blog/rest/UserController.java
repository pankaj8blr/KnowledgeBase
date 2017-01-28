package org.cmad.blog.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.cmad.blog.api.AppUser;
import org.cmad.blog.api.User;
import org.cmad.blog.biz.UserService;


@Path("/account")
public class UserController {
	public UserController() {
		System.out.println("UserController.UserController()");
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
	@Path("/adduser")
	public Response addUser(AppUser user) {
		System.out.println("UserController.addUser() user: "+user);
		User userService = new UserService();
		System.out.println("UserController.addUser()userService: "+userService);
		int appUserId = userService.addAppUser(user);
		System.out.println("appUserId: "+appUserId);
		Response res = Response.ok().entity(appUserId + "").build();
		System.out.println("UserController.addUser()res: "+res);
		System.out.println("UserController.addUser()res.status: "+res.getStatus());
		return res;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
	@Path("/authenticateuser")
	public Response authenticateUser(AppUser user) {
		System.out.println("UserController.authenticateUser() user: "+user);
		User blog = new UserService();
		System.out.println("UserController.authenticateUser()blog: "+blog);
		int appUserId = blog.authenticatedAppUser(user);
		System.out.println("appUserId: "+appUserId);
		/*Response res = Response.ok().entity("appUserId:" +appUserId).build();
		System.out.println("UserController.authenticateUser()res: "+res);
		System.out.println("UserController.authenticateUser() res.status: "+res.getStatus());
		if(user!=null && user.getAppUserId()!=appUserId){
			res = Response.noContent().entity(appUserId + "").build();
		}else{
			res = Response.ok().entity(appUserId + "").build();
		}
		return res;*/
		return Response.ok().entity(appUserId + "").build();
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateuser")
	public Response updateUser(AppUser user) {
		System.out.println("UserController.updateUser() user: "+user);
		User userService = new UserService();
		System.out.println("UserController.updateUser()userService: "+userService);
		AppUser updatedUser = userService.updateAppUser(user);
		System.out.println("updatedUser: "+updatedUser);
		if(updatedUser!=null){
			System.out.println("UserController.updateUser() "+updatedUser.getAppUserId());
		}
		Response res = Response.ok().entity(updatedUser + "").build();
		System.out.println("UserController.updateUser()res: "+res);
		System.out.println("UserController.updateUser()res.status: "+res.getStatus());
		return res;
	}
	
}
