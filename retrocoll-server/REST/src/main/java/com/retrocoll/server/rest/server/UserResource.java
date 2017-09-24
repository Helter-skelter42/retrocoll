/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - Minuteproject version : 0.9.10
	* - name      : CXFSpringEntityResource
	* - file name : CXFSpringEntityResource.vm
	* - time      : 2017/09/16 ap. J.-C. at 19:38:24 CEST
*/
package com.retrocoll.server.rest.server;


import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.sql.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import com.retrocoll.server.dao.face.server.UserDao;
import com.retrocoll.server.domain.server.User;

/**
 *
 * <p>Title: UserResource</p>
 *
 * <p>Description: remote interface for UserResource service </p>
 *
 */
@Path ("/rest/xml/users")
@Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Service
@Transactional
public class UserResource  {
 

	@Autowired
	@Qualifier("userDao")
	UserDao userDao;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @FIND_ALL-user@
    @GET
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})	
    public List<User> findAll () {
		List<User> r = new ArrayList<User>();
        List<User> l = userDao.searchPrototypeUser(new User());
		for (User user : l) {
			r.add(user.flat());
		}
		return r;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @FIND_BY_ID-user@
    @GET
    @Path("{email}")
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})		
    public User findById (@PathParam ("email") java.lang.String email) {

		return userDao.loadUser(email);
    }
//MP-MANAGED-UPDATABLE-ENDING

    @DELETE
    @Path("{email}")
    public void delete (@PathParam ("email") String email) {
        User _user = new User ();
        _user.setEmail(email);
        userDao.deleteUser(_user);
    }

    @POST
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})	
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public User create (
        @FormParam("username") String username,
        @FormParam("email") String email,
        @FormParam("password") String password,
        @FormParam("createTime") java.util.Date createTime,
        @Context HttpServletResponse servletResponse
        ) throws IOException {
        User _user = new User (
           username,
           email,
           password,
           createTime);
        return save(_user);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User save(JAXBElement<User> jaxbUser) {
        User user = jaxbUser.getValue();
        if (user.getEmail()!=null)
            return userDao.updateUser(user);
        return save(user);
    }

	public User save (User user) {
		userDao.saveUser(user);
		return user;
	}


}