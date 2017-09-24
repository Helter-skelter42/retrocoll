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

import com.retrocoll.server.dao.face.server.PhotoDao;
import com.retrocoll.server.domain.server.Photo;

/**
 *
 * <p>Title: PhotoResource</p>
 *
 * <p>Description: remote interface for PhotoResource service </p>
 *
 */
@Path ("/rest/xml/photos")
@Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Service
@Transactional
public class PhotoResource  {
 

	@Autowired
	@Qualifier("photoDao")
	PhotoDao photoDao;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @FIND_ALL-photo@
    @GET
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})	
    public List<Photo> findAll () {
		List<Photo> r = new ArrayList<Photo>();
        List<Photo> l = photoDao.searchPrototypePhoto(new Photo());
		for (Photo photo : l) {
			r.add(photo.flat());
		}
		return r;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @FIND_BY_ID-photo@
    @GET
    @Path("{photoId}")
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})		
    public Photo findById (@PathParam ("photoId") java.lang.Integer photoId) {

		return photoDao.loadPhoto(photoId);
    }
//MP-MANAGED-UPDATABLE-ENDING

    @DELETE
    @Path("{photoId}")
    public void delete (@PathParam ("photoId") Integer photoId) {
        Photo _photo = new Photo ();
        _photo.setPhotoId(photoId);
        photoDao.deletePhoto(_photo);
    }

    @POST
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})	
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Photo create (
        @FormParam("photoId") Integer photoId,
        @FormParam("photo") String photo,
        @FormParam("name") String name,
        @FormParam("description") String description,
        @FormParam("hardwareIdFk") Integer hardwareIdFk,
        @FormParam("softwareIdPk") Integer softwareIdPk,
        @FormParam("accessorieIdPk") Integer accessorieIdPk,
        @Context HttpServletResponse servletResponse
        ) throws IOException {
        Photo _photo = new Photo (
           photoId,
           photo,
           name,
           description,
           hardwareIdFk,
           softwareIdPk,
           accessorieIdPk);
        return save(_photo);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Photo save(JAXBElement<Photo> jaxbPhoto) {
        Photo photo = jaxbPhoto.getValue();
        if (photo.getPhotoId()!=null)
            return photoDao.updatePhoto(photo);
        return save(photo);
    }

	public Photo save (Photo photo) {
		photoDao.savePhoto(photo);
		return photo;
	}


}