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

import com.retrocoll.server.dao.face.server.LocationDao;
import com.retrocoll.server.domain.server.Location;

/**
 *
 * <p>Title: LocationResource</p>
 *
 * <p>Description: remote interface for LocationResource service </p>
 *
 */
@Path ("/rest/xml/locations")
@Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Service
@Transactional
public class LocationResource  {
 

	@Autowired
	@Qualifier("locationDao")
	LocationDao locationDao;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @FIND_ALL-location@
    @GET
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})	
    public List<Location> findAll () {
		List<Location> r = new ArrayList<Location>();
        List<Location> l = locationDao.searchPrototypeLocation(new Location());
		for (Location location : l) {
			r.add(location.flat());
		}
		return r;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @FIND_BY_ID-location@
    @GET
    @Path("{locationId}")
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})		
    public Location findById (@PathParam ("locationId") java.lang.Integer locationId) {

		return locationDao.loadLocation(locationId);
    }
//MP-MANAGED-UPDATABLE-ENDING

    @DELETE
    @Path("{locationId}")
    public void delete (@PathParam ("locationId") Integer locationId) {
        Location _location = new Location ();
        _location.setLocationId(locationId);
        locationDao.deleteLocation(_location);
    }

    @POST
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})	
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Location create (
        @FormParam("locationId") Integer locationId,
        @FormParam("locationName") String locationName,
        @Context HttpServletResponse servletResponse
        ) throws IOException {
        Location _location = new Location (
           locationId,
           locationName);
        return save(_location);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Location save(JAXBElement<Location> jaxbLocation) {
        Location location = jaxbLocation.getValue();
        if (location.getLocationId()!=null)
            return locationDao.updateLocation(location);
        return save(location);
    }

	public Location save (Location location) {
		locationDao.saveLocation(location);
		return location;
	}


}