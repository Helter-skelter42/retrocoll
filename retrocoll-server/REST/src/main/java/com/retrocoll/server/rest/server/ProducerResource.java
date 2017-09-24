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

import com.retrocoll.server.dao.face.server.ProducerDao;
import com.retrocoll.server.domain.server.Producer;

/**
 *
 * <p>Title: ProducerResource</p>
 *
 * <p>Description: remote interface for ProducerResource service </p>
 *
 */
@Path ("/rest/xml/producers")
@Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Service
@Transactional
public class ProducerResource  {
 

	@Autowired
	@Qualifier("producerDao")
	ProducerDao producerDao;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @FIND_ALL-producer@
    @GET
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})	
    public List<Producer> findAll () {
		List<Producer> r = new ArrayList<Producer>();
        List<Producer> l = producerDao.searchPrototypeProducer(new Producer());
		for (Producer producer : l) {
			r.add(producer.flat());
		}
		return r;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @FIND_BY_ID-producer@
    @GET
    @Path("{producerId}")
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})		
    public Producer findById (@PathParam ("producerId") java.lang.Integer producerId) {

		return producerDao.loadProducer(producerId);
    }
//MP-MANAGED-UPDATABLE-ENDING

    @DELETE
    @Path("{producerId}")
    public void delete (@PathParam ("producerId") Integer producerId) {
        Producer _producer = new Producer ();
        _producer.setProducerId(producerId);
        producerDao.deleteProducer(_producer);
    }

    @POST
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})	
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Producer create (
        @FormParam("producerId") Integer producerId,
        @FormParam("name") String name,
        @FormParam("desciption") String desciption,
        @FormParam("logo") String logo,
        @Context HttpServletResponse servletResponse
        ) throws IOException {
        Producer _producer = new Producer (
           producerId,
           name,
           desciption,
           logo);
        return save(_producer);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Producer save(JAXBElement<Producer> jaxbProducer) {
        Producer producer = jaxbProducer.getValue();
        if (producer.getProducerId()!=null)
            return producerDao.updateProducer(producer);
        return save(producer);
    }

	public Producer save (Producer producer) {
		producerDao.saveProducer(producer);
		return producer;
	}


}