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

import com.retrocoll.server.dao.face.server.ValueListDao;
import com.retrocoll.server.domain.server.ValueList;

/**
 *
 * <p>Title: ValueListResource</p>
 *
 * <p>Description: remote interface for ValueListResource service </p>
 *
 */
@Path ("/rest/xml/valuelists")
@Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Service
@Transactional
public class ValueListResource  {
 

	@Autowired
	@Qualifier("valueListDao")
	ValueListDao valueListDao;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @FIND_ALL-value_list@
    @GET
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})	
    public List<ValueList> findAll () {
		List<ValueList> r = new ArrayList<ValueList>();
        List<ValueList> l = valueListDao.searchPrototypeValueList(new ValueList());
		for (ValueList valueList : l) {
			r.add(valueList.flat());
		}
		return r;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @FIND_BY_ID-value_list@
    @GET
    @Path("{valueId}")
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})		
    public ValueList findById (@PathParam ("valueId") java.lang.Integer valueId) {

		return valueListDao.loadValueList(valueId);
    }
//MP-MANAGED-UPDATABLE-ENDING

    @DELETE
    @Path("{valueId}")
    public void delete (@PathParam ("valueId") Integer valueId) {
        ValueList _valueList = new ValueList ();
        _valueList.setValueId(valueId);
        valueListDao.deleteValueList(_valueList);
    }

    @POST
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})	
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public ValueList create (
        @FormParam("valueId") Integer valueId,
        @FormParam("name") String name,
        @FormParam("group") String group,
        @Context HttpServletResponse servletResponse
        ) throws IOException {
        ValueList _valueList = new ValueList (
           valueId,
           name,
           group);
        return save(_valueList);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ValueList save(JAXBElement<ValueList> jaxbValueList) {
        ValueList valueList = jaxbValueList.getValue();
        if (valueList.getValueId()!=null)
            return valueListDao.updateValueList(valueList);
        return save(valueList);
    }

	public ValueList save (ValueList valueList) {
		valueListDao.saveValueList(valueList);
		return valueList;
	}


}