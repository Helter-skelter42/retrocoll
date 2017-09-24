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

import com.retrocoll.server.dao.face.server.SettingsDao;
import com.retrocoll.server.domain.server.Settings;

/**
 *
 * <p>Title: SettingsResource</p>
 *
 * <p>Description: remote interface for SettingsResource service </p>
 *
 */
@Path ("/rest/xml/settingses")
@Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Service
@Transactional
public class SettingsResource  {
 

	@Autowired
	@Qualifier("settingsDao")
	SettingsDao settingsDao;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @FIND_ALL-settings@
    @GET
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})	
    public List<Settings> findAll () {
		List<Settings> r = new ArrayList<Settings>();
        List<Settings> l = settingsDao.searchPrototypeSettings(new Settings());
		for (Settings settings : l) {
			r.add(settings.flat());
		}
		return r;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @FIND_BY_ID-settings@
    @GET
    @Path("{name}")
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})		
    public Settings findById (@PathParam ("name") java.lang.String name) {

		return settingsDao.loadSettings(name);
    }
//MP-MANAGED-UPDATABLE-ENDING

    @DELETE
    @Path("{name}")
    public void delete (@PathParam ("name") String name) {
        Settings _settings = new Settings ();
        _settings.setName(name);
        settingsDao.deleteSettings(_settings);
    }

    @POST
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})	
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Settings create (
        @FormParam("name") String name,
        @FormParam("value") String value,
        @Context HttpServletResponse servletResponse
        ) throws IOException {
        Settings _settings = new Settings (
           name,
           value);
        return save(_settings);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Settings save(JAXBElement<Settings> jaxbSettings) {
        Settings settings = jaxbSettings.getValue();
        if (settings.getName()!=null)
            return settingsDao.updateSettings(settings);
        return save(settings);
    }

	public Settings save (Settings settings) {
		settingsDao.saveSettings(settings);
		return settings;
	}


}