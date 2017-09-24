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

import com.retrocoll.server.dao.face.server.HardwareDao;
import com.retrocoll.server.domain.server.Hardware;

/**
 *
 * <p>Title: HardwareResource</p>
 *
 * <p>Description: remote interface for HardwareResource service </p>
 *
 */
@Path ("/rest/xml/hardwares")
@Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Service
@Transactional
public class HardwareResource  {
 

	@Autowired
	@Qualifier("hardwareDao")
	HardwareDao hardwareDao;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @FIND_ALL-hardware@
    @GET
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})	
    public List<Hardware> findAll () {
		List<Hardware> r = new ArrayList<Hardware>();
        List<Hardware> l = hardwareDao.searchPrototypeHardware(new Hardware());
		for (Hardware hardware : l) {
			r.add(hardware.flat());
		}
		return r;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @FIND_BY_ID-hardware@
    @GET
    @Path("{hardwareId}")
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})		
    public Hardware findById (@PathParam ("hardwareId") java.lang.Integer hardwareId) {

		return hardwareDao.loadHardware(hardwareId);
    }
//MP-MANAGED-UPDATABLE-ENDING

    @DELETE
    @Path("{hardwareId}")
    public void delete (@PathParam ("hardwareId") Integer hardwareId) {
        Hardware _hardware = new Hardware ();
        _hardware.setHardwareId(hardwareId);
        hardwareDao.deleteHardware(_hardware);
    }

    @POST
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})	
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Hardware create (
        @FormParam("hardwareId") Integer hardwareId,
        @FormParam("name") String name,
        @FormParam("description") String description,
        @FormParam("brand") Integer brand,
        @FormParam("color") Integer color,
        @FormParam("serialNumber") String serialNumber,
        @FormParam("region") Integer region,
        @FormParam("subRegionCode") String subRegionCode,
        @FormParam("releaseDate") java.util.Date releaseDate,
        @FormParam("acquiringDate") java.util.Date acquiringDate,
        @FormParam("acquiringPrice") java.math.BigDecimal acquiringPrice,
        @FormParam("acquiredPriceFree") Boolean acquiredPriceFree,
        @FormParam("acquiredPriceUnknown") Boolean acquiredPriceUnknown,
        @FormParam("acquiringSellerName") String acquiringSellerName,
        @FormParam("acquiringPlace") String acquiringPlace,
        @FormParam("location") Integer location,
        @FormParam("hasBox") Boolean hasBox,
        @FormParam("hasManual") Boolean hasManual,
        @FormParam("hasInserts") String hasInserts,
        @FormParam("isSealed") Boolean isSealed,
        @FormParam("isNew") Boolean isNew,
        @FormParam("isCompleteInBox") Boolean isCompleteInBox,
        @FormParam("hardwareStateRating") Integer hardwareStateRating,
        @FormParam("boxStateRating") Integer boxStateRating,
        @FormParam("manualStateRating") Integer manualStateRating,
        @FormParam("comment") String comment,
        @FormParam("barcode") String barcode,
        @Context HttpServletResponse servletResponse
        ) throws IOException {
        Hardware _hardware = new Hardware (
           hardwareId,
           name,
           description,
           brand,
           color,
           serialNumber,
           region,
           subRegionCode,
           releaseDate,
           acquiringDate,
           acquiringPrice,
           acquiredPriceFree,
           acquiredPriceUnknown,
           acquiringSellerName,
           acquiringPlace,
           location,
           hasBox,
           hasManual,
           hasInserts,
           isSealed,
           isNew,
           isCompleteInBox,
           hardwareStateRating,
           boxStateRating,
           manualStateRating,
           comment,
           barcode);
        return save(_hardware);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Hardware save(JAXBElement<Hardware> jaxbHardware) {
        Hardware hardware = jaxbHardware.getValue();
        if (hardware.getHardwareId()!=null)
            return hardwareDao.updateHardware(hardware);
        return save(hardware);
    }

	public Hardware save (Hardware hardware) {
		hardwareDao.saveHardware(hardware);
		return hardware;
	}


}