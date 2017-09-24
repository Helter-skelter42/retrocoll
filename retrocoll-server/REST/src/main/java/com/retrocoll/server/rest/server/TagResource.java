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

import com.retrocoll.server.dao.face.server.TagDao;
import com.retrocoll.server.domain.server.Tag;

/**
 *
 * <p>Title: TagResource</p>
 *
 * <p>Description: remote interface for TagResource service </p>
 *
 */
@Path ("/rest/xml/tags")
@Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Service
@Transactional
public class TagResource  {
 

	@Autowired
	@Qualifier("tagDao")
	TagDao tagDao;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @FIND_ALL-tag@
    @GET
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})	
    public List<Tag> findAll () {
		List<Tag> r = new ArrayList<Tag>();
        List<Tag> l = tagDao.searchPrototypeTag(new Tag());
		for (Tag tag : l) {
			r.add(tag.flat());
		}
		return r;
    }
//MP-MANAGED-UPDATABLE-ENDING


    @POST
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})	
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Tag create (
        @FormParam("tagId") Integer tagId,
        @FormParam("name") String name,
        @Context HttpServletResponse servletResponse
        ) throws IOException {
        Tag _tag = new Tag (
           tagId,
           name);
        return save(_tag);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Tag save(JAXBElement<Tag> jaxbTag) {
        Tag tag = jaxbTag.getValue();
		if (tag.getTagId_()!=null)
            return tagDao.updateTag(tag);
        return save(tag);
    }

	public Tag save (Tag tag) {
		tagDao.saveTag(tag);
		return tag;
	}


}