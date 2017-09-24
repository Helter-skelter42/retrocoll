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
	* - name      : BslaJPADaoImplUML
	* - file name : DB.API.JPA2DaoImpl.vm
	* - time      : 2017/09/16 ap. J.-C. at 19:38:23 CEST
*/
package com.retrocoll.server.dao.impl.jpa.server;

import java.lang.reflect.InvocationTargetException;
import java.sql.Clob;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.transaction.annotation.Transactional;

import org.apache.commons.lang.StringUtils;

import net.sf.minuteProject.architecture.query.QueryWhatInit;
import net.sf.minuteProject.architecture.query.impl.QueryCountInit;
import net.sf.minuteProject.architecture.query.impl.QuerySelectCountInit;
import net.sf.minuteProject.architecture.query.impl.QuerySelectInit;
import net.sf.minuteProject.architecture.query.impl.QuerySelectDistinctInit;
import net.sf.minuteProject.architecture.cache.SimpleCache;
import net.sf.minuteProject.architecture.filter.data.ClauseCriterion;
import net.sf.minuteProject.architecture.filter.data.Criteria;
import net.sf.minuteProject.architecture.filter.data.Criterion;
import net.sf.minuteProject.architecture.filter.data.InCriterion;
import net.sf.minuteProject.architecture.filter.data.OrderCriteria;
import net.sf.minuteProject.model.service.GenericService;
import net.sf.minuteProject.model.data.criteria.EntityCriteria;
import net.sf.minuteProject.model.data.criteria.EntitySort;
import net.sf.minuteProject.model.data.criteria.QueryData;
import net.sf.minuteProject.model.data.criteria.constant.QuerySortOrder;
import net.sf.minuteProject.model.data.criteria.constant.EntityMatchType;
import net.sf.minuteProject.model.data.criteria.constant.OperandType;
import static net.sf.minuteProject.model.utils.BuilderUtils.*;

import net.sf.minuteProject.architecture.utils.BeanUtils;

import com.retrocoll.server.dao.face.server.HardwareDao;
import com.retrocoll.server.domain.server.Hardware;
import com.retrocoll.server.domain.server.Producer;
import com.retrocoll.server.domain.server.ValueList;
import com.retrocoll.server.domain.server.Location;
import com.retrocoll.server.domain.server.ValueList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.retrocoll.server.dao.impl.ServerGenericDaoJpaImpl;


import com.retrocoll.server.domain.server.Photo;
import com.retrocoll.server.dao.impl.jpa.server.PhotoJPAImpl;
import com.retrocoll.server.dao.impl.jpa.server.ProducerJPAImpl;
import com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl;
import com.retrocoll.server.dao.impl.jpa.server.LocationJPAImpl;
import com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl;
/**
 *
 * <p>Title: HardwareJPAImpl</p>
 *
 * <p>Description: Interface of a Data access object dealing with HardwareJPAImpl
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching HardwareJPAImpl objects</p>
 *
 */


@org.springframework.stereotype.Repository(value="hardwareDao")

public class HardwareJPAImpl extends ServerGenericDaoJpaImpl<Hardware> implements HardwareDao {
	public HardwareJPAImpl () {}
	
    /**
     * Inserts a Hardware entity 
     * @param Hardware hardware
     */
    public void insertHardware(Hardware hardware) {
       entityManager.persist(hardware);
    }

    protected void insertHardware(EntityManager emForRecursiveDao, Hardware hardware) {
       emForRecursiveDao.persist(hardware);
    } 

    /**
     * Updates a Hardware entity 
     * @param Hardware hardware
     */
    public Hardware updateHardware(Hardware hardware) {
       return entityManager.merge(hardware);
    }

	/**
     * Updates a Hardware entity with only the attributes set into Hardware.
	 * The primary keys are to be set for this method to operate.
	 * This is a performance friendly feature, which remove the udibiquous full load and full update when an
	 * update is issued
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param Hardware hardware
    */ 
    @Transactional
    public Integer updateNotNullOnlyHardware(Hardware hardware) {
        Query jpaQuery = getEntityManager().createQuery(getUpdateNotNullOnlyHardwareQueryChunk(hardware));
        if (hardware.getHardwareId() != null) {
           jpaQuery.setParameter ("hardwareId", hardware.getHardwareId());
        }   
        if (hardware.getName() != null) {
           jpaQuery.setParameter ("name", hardware.getName());
        }   
        if (hardware.getDescription() != null) {
           jpaQuery.setParameter ("description", hardware.getDescription());
        }   
        if (hardware.getBrand_() != null) {
           jpaQuery.setParameter ("brand_", hardware.getBrand_());
        }   
        if (hardware.getColor_() != null) {
           jpaQuery.setParameter ("color_", hardware.getColor_());
        }   
        if (hardware.getSerialNumber() != null) {
           jpaQuery.setParameter ("serialNumber", hardware.getSerialNumber());
        }   
        if (hardware.getRegion_() != null) {
           jpaQuery.setParameter ("region_", hardware.getRegion_());
        }   
        if (hardware.getSubRegionCode() != null) {
           jpaQuery.setParameter ("subRegionCode", hardware.getSubRegionCode());
        }   
        if (hardware.getReleaseDate() != null) {
           jpaQuery.setParameter ("releaseDate", hardware.getReleaseDate());
        }   
        if (hardware.getAcquiringDate() != null) {
           jpaQuery.setParameter ("acquiringDate", hardware.getAcquiringDate());
        }   
        if (hardware.getAcquiringPrice() != null) {
           jpaQuery.setParameter ("acquiringPrice", hardware.getAcquiringPrice());
        }   
        if (hardware.getAcquiredPriceFree() != null) {
           jpaQuery.setParameter ("acquiredPriceFree", hardware.getAcquiredPriceFree());
        }   
        if (hardware.getAcquiredPriceUnknown() != null) {
           jpaQuery.setParameter ("acquiredPriceUnknown", hardware.getAcquiredPriceUnknown());
        }   
        if (hardware.getAcquiringSellerName() != null) {
           jpaQuery.setParameter ("acquiringSellerName", hardware.getAcquiringSellerName());
        }   
        if (hardware.getAcquiringPlace() != null) {
           jpaQuery.setParameter ("acquiringPlace", hardware.getAcquiringPlace());
        }   
        if (hardware.getLocation_() != null) {
           jpaQuery.setParameter ("location_", hardware.getLocation_());
        }   
        if (hardware.getHasBox() != null) {
           jpaQuery.setParameter ("hasBox", hardware.getHasBox());
        }   
        if (hardware.getHasManual() != null) {
           jpaQuery.setParameter ("hasManual", hardware.getHasManual());
        }   
        if (hardware.getHasInserts() != null) {
           jpaQuery.setParameter ("hasInserts", hardware.getHasInserts());
        }   
        if (hardware.getIsSealed() != null) {
           jpaQuery.setParameter ("isSealed", hardware.getIsSealed());
        }   
        if (hardware.getIsNew() != null) {
           jpaQuery.setParameter ("isNew", hardware.getIsNew());
        }   
        if (hardware.getIsCompleteInBox() != null) {
           jpaQuery.setParameter ("isCompleteInBox", hardware.getIsCompleteInBox());
        }   
        if (hardware.getHardwareStateRating() != null) {
           jpaQuery.setParameter ("hardwareStateRating", hardware.getHardwareStateRating());
        }   
        if (hardware.getBoxStateRating() != null) {
           jpaQuery.setParameter ("boxStateRating", hardware.getBoxStateRating());
        }   
        if (hardware.getManualStateRating() != null) {
           jpaQuery.setParameter ("manualStateRating", hardware.getManualStateRating());
        }   
        if (hardware.getComment() != null) {
           jpaQuery.setParameter ("comment", hardware.getComment());
        }   
        if (hardware.getBarcode() != null) {
           jpaQuery.setParameter ("barcode", hardware.getBarcode());
        }   
		return jpaQuery.executeUpdate();
    }

    protected String getUpdateNotNullOnlyHardwareQueryChunkPrototype (Hardware hardware) {
        boolean isSetSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update Hardware hardware ");
        if (hardware.getName() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.name = :name");
        }
        if (hardware.getDescription() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.description = :description");
        }
        if (hardware.getBrand() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.brand = :brand");
        }
        if (hardware.getColor() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.color = :color");
        }
        if (hardware.getSerialNumber() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.serialNumber = :serialNumber");
        }
        if (hardware.getRegion() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.region = :region");
        }
        if (hardware.getSubRegionCode() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.subRegionCode = :subRegionCode");
        }
        if (hardware.getReleaseDate() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.releaseDate = :releaseDate");
        }
        if (hardware.getAcquiringDate() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.acquiringDate = :acquiringDate");
        }
        if (hardware.getAcquiringPrice() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.acquiringPrice = :acquiringPrice");
        }
        if (hardware.getAcquiredPriceFree() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.acquiredPriceFree = :acquiredPriceFree");
        }
        if (hardware.getAcquiredPriceUnknown() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.acquiredPriceUnknown = :acquiredPriceUnknown");
        }
        if (hardware.getAcquiringSellerName() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.acquiringSellerName = :acquiringSellerName");
        }
        if (hardware.getAcquiringPlace() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.acquiringPlace = :acquiringPlace");
        }
        if (hardware.getLocation() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.location = :location");
        }
        if (hardware.getHasBox() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.hasBox = :hasBox");
        }
        if (hardware.getHasManual() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.hasManual = :hasManual");
        }
        if (hardware.getHasInserts() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.hasInserts = :hasInserts");
        }
        if (hardware.getIsSealed() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.isSealed = :isSealed");
        }
        if (hardware.getIsNew() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.isNew = :isNew");
        }
        if (hardware.getIsCompleteInBox() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.isCompleteInBox = :isCompleteInBox");
        }
        if (hardware.getHardwareStateRating() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.hardwareStateRating = :hardwareStateRating");
        }
        if (hardware.getBoxStateRating() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.boxStateRating = :boxStateRating");
        }
        if (hardware.getManualStateRating() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.manualStateRating = :manualStateRating");
        }
        if (hardware.getComment() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.comment = :comment");
        }
        if (hardware.getBarcode() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" hardware.barcode = :barcode");
        }
        if (isSetSet==false)
			throw new IllegalArgumentException("hardware mask should contain updatable fields");
        return query.toString();
    }
    
    protected String getUpdateNotNullOnlyHardwareQueryChunk (Hardware hardware) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer(getUpdateNotNullOnlyHardwareQueryChunkPrototype(hardware));
        if (hardware.getHardwareId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
			     query.append(" hardware.hardwareId = :hardwareId");
        }
        if (isWhereSet==false)
			throw new IllegalArgumentException("hardware mask should contain primary key");
        return query.toString();
    }
    
                
	protected Hardware assignBlankToNull (Hardware hardware) {
        if (hardware==null)
			return null;
        if (hardware.getName()!=null && hardware.getName().equals(""))
           hardware.setName((String)null);
        if (hardware.getDescription()!=null && hardware.getDescription().equals(""))
           hardware.setDescription((String)null);
        if (hardware.getSerialNumber()!=null && hardware.getSerialNumber().equals(""))
           hardware.setSerialNumber((String)null);
        if (hardware.getSubRegionCode()!=null && hardware.getSubRegionCode().equals(""))
           hardware.setSubRegionCode((String)null);
        if (hardware.getAcquiringSellerName()!=null && hardware.getAcquiringSellerName().equals(""))
           hardware.setAcquiringSellerName((String)null);
        if (hardware.getAcquiringPlace()!=null && hardware.getAcquiringPlace().equals(""))
           hardware.setAcquiringPlace((String)null);
        if (hardware.getHasInserts()!=null && hardware.getHasInserts().equals(""))
           hardware.setHasInserts((String)null);
        if (hardware.getComment()!=null && hardware.getComment().equals(""))
           hardware.setComment((String)null);
        if (hardware.getBarcode()!=null && hardware.getBarcode().equals(""))
           hardware.setBarcode((String)null);
		return hardware;
	}
	
	protected boolean isAllNull (Hardware hardware) {
	    if (hardware==null)
			return true;
        if (hardware.getHardwareId()!=null) 
            return false;
        if (hardware.getName()!=null) 
            return false;
        if (hardware.getDescription()!=null) 
            return false;
        if (hardware.getBrand()!=null) 
            return false;
        if (hardware.getColor()!=null) 
            return false;
        if (hardware.getSerialNumber()!=null) 
            return false;
        if (hardware.getRegion()!=null) 
            return false;
        if (hardware.getSubRegionCode()!=null) 
            return false;
        if (hardware.getReleaseDate()!=null) 
            return false;
        if (hardware.getAcquiringDate()!=null) 
            return false;
        if (hardware.getAcquiringPrice()!=null) 
            return false;
        if (hardware.getAcquiredPriceFree()!=null) 
            return false;
        if (hardware.getAcquiredPriceUnknown()!=null) 
            return false;
        if (hardware.getAcquiringSellerName()!=null) 
            return false;
        if (hardware.getAcquiringPlace()!=null) 
            return false;
        if (hardware.getLocation()!=null) 
            return false;
        if (hardware.getHasBox()!=null) 
            return false;
        if (hardware.getHasManual()!=null) 
            return false;
        if (hardware.getHasInserts()!=null) 
            return false;
        if (hardware.getIsSealed()!=null) 
            return false;
        if (hardware.getIsNew()!=null) 
            return false;
        if (hardware.getIsCompleteInBox()!=null) 
            return false;
        if (hardware.getHardwareStateRating()!=null) 
            return false;
        if (hardware.getBoxStateRating()!=null) 
            return false;
        if (hardware.getManualStateRating()!=null) 
            return false;
        if (hardware.getComment()!=null) 
            return false;
        if (hardware.getBarcode()!=null) 
            return false;
		return true;
	}
		
    @Transactional
    public Integer updateNotNullOnlyPrototypeHardware(Hardware hardware, Hardware prototypeCriteria) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update Hardware hardware ");
        if (hardware.getHardwareId() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.hardwareId = "+ hardware.getHardwareId() + " ");
        }
        if (hardware.getName() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.name = '"+ hardware.getName()+"' ");
        }
        if (hardware.getDescription() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.description = '"+ hardware.getDescription()+"' ");
        }
        if (hardware.getBrand_() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.brand_ = "+ hardware.getBrand_() + " ");
        }
        if (hardware.getColor_() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.color_ = "+ hardware.getColor_() + " ");
        }
        if (hardware.getSerialNumber() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.serialNumber = '"+ hardware.getSerialNumber()+"' ");
        }
        if (hardware.getRegion_() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.region_ = "+ hardware.getRegion_() + " ");
        }
        if (hardware.getSubRegionCode() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.subRegionCode = '"+ hardware.getSubRegionCode()+"' ");
        }
        if (hardware.getReleaseDate() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.releaseDate = '"+ hardware.getReleaseDate()+"' ");
        }
        if (hardware.getAcquiringDate() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.acquiringDate = '"+ hardware.getAcquiringDate()+"' ");
        }
        if (hardware.getAcquiringPrice() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.acquiringPrice = "+ hardware.getAcquiringPrice() + " ");
        }
        if (hardware.getAcquiredPriceFree() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.acquiredPriceFree = '"+ hardware.getAcquiredPriceFree()+"' ");
        }
        if (hardware.getAcquiredPriceUnknown() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.acquiredPriceUnknown = '"+ hardware.getAcquiredPriceUnknown()+"' ");
        }
        if (hardware.getAcquiringSellerName() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.acquiringSellerName = '"+ hardware.getAcquiringSellerName()+"' ");
        }
        if (hardware.getAcquiringPlace() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.acquiringPlace = '"+ hardware.getAcquiringPlace()+"' ");
        }
        if (hardware.getLocation_() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.location_ = "+ hardware.getLocation_() + " ");
        }
        if (hardware.getHasBox() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.hasBox = '"+ hardware.getHasBox()+"' ");
        }
        if (hardware.getHasManual() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.hasManual = '"+ hardware.getHasManual()+"' ");
        }
        if (hardware.getHasInserts() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.hasInserts = '"+ hardware.getHasInserts()+"' ");
        }
        if (hardware.getIsSealed() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.isSealed = '"+ hardware.getIsSealed()+"' ");
        }
        if (hardware.getIsNew() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.isNew = '"+ hardware.getIsNew()+"' ");
        }
        if (hardware.getIsCompleteInBox() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.isCompleteInBox = '"+ hardware.getIsCompleteInBox()+"' ");
        }
        if (hardware.getHardwareStateRating() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.hardwareStateRating = "+ hardware.getHardwareStateRating() + " ");
        }
        if (hardware.getBoxStateRating() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.boxStateRating = "+ hardware.getBoxStateRating() + " ");
        }
        if (hardware.getManualStateRating() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.manualStateRating = "+ hardware.getManualStateRating() + " ");
        }
        if (hardware.getComment() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.comment = '"+ hardware.getComment()+"' ");
        }
        if (hardware.getBarcode() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" hardware.barcode = '"+ hardware.getBarcode()+"' ");
        }
		isWhereSet = false; 
        if (prototypeCriteria.getHardwareId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.hardwareId = "+ prototypeCriteria.getHardwareId() + " ");
        }
        if (prototypeCriteria.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.name = '"+ prototypeCriteria.getName()+"' ");
        }
        if (prototypeCriteria.getDescription() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.description = '"+ prototypeCriteria.getDescription()+"' ");
        }
        if (prototypeCriteria.getBrand_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.brand_ = "+ prototypeCriteria.getBrand_() + " ");
        }
        if (prototypeCriteria.getColor_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.color_ = "+ prototypeCriteria.getColor_() + " ");
        }
        if (prototypeCriteria.getSerialNumber() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.serialNumber = '"+ prototypeCriteria.getSerialNumber()+"' ");
        }
        if (prototypeCriteria.getRegion_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.region_ = "+ prototypeCriteria.getRegion_() + " ");
        }
        if (prototypeCriteria.getSubRegionCode() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.subRegionCode = '"+ prototypeCriteria.getSubRegionCode()+"' ");
        }
        if (prototypeCriteria.getReleaseDate() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.releaseDate = '"+ prototypeCriteria.getReleaseDate()+"' ");
        }
        if (prototypeCriteria.getAcquiringDate() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.acquiringDate = '"+ prototypeCriteria.getAcquiringDate()+"' ");
        }
        if (prototypeCriteria.getAcquiringPrice() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.acquiringPrice = "+ prototypeCriteria.getAcquiringPrice() + " ");
        }
        if (prototypeCriteria.getAcquiredPriceFree() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.acquiredPriceFree = '"+ prototypeCriteria.getAcquiredPriceFree()+"' ");
        }
        if (prototypeCriteria.getAcquiredPriceUnknown() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.acquiredPriceUnknown = '"+ prototypeCriteria.getAcquiredPriceUnknown()+"' ");
        }
        if (prototypeCriteria.getAcquiringSellerName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.acquiringSellerName = '"+ prototypeCriteria.getAcquiringSellerName()+"' ");
        }
        if (prototypeCriteria.getAcquiringPlace() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.acquiringPlace = '"+ prototypeCriteria.getAcquiringPlace()+"' ");
        }
        if (prototypeCriteria.getLocation_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.location_ = "+ prototypeCriteria.getLocation_() + " ");
        }
        if (prototypeCriteria.getHasBox() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.hasBox = '"+ prototypeCriteria.getHasBox()+"' ");
        }
        if (prototypeCriteria.getHasManual() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.hasManual = '"+ prototypeCriteria.getHasManual()+"' ");
        }
        if (prototypeCriteria.getHasInserts() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.hasInserts = '"+ prototypeCriteria.getHasInserts()+"' ");
        }
        if (prototypeCriteria.getIsSealed() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.isSealed = '"+ prototypeCriteria.getIsSealed()+"' ");
        }
        if (prototypeCriteria.getIsNew() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.isNew = '"+ prototypeCriteria.getIsNew()+"' ");
        }
        if (prototypeCriteria.getIsCompleteInBox() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.isCompleteInBox = '"+ prototypeCriteria.getIsCompleteInBox()+"' ");
        }
        if (prototypeCriteria.getHardwareStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.hardwareStateRating = "+ prototypeCriteria.getHardwareStateRating() + " ");
        }
        if (prototypeCriteria.getBoxStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.boxStateRating = "+ prototypeCriteria.getBoxStateRating() + " ");
        }
        if (prototypeCriteria.getManualStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.manualStateRating = "+ prototypeCriteria.getManualStateRating() + " ");
        }
        if (prototypeCriteria.getComment() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.comment = '"+ prototypeCriteria.getComment()+"' ");
        }
        if (prototypeCriteria.getBarcode() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.barcode = '"+ prototypeCriteria.getBarcode()+"' ");
        }
        Query jpaQuery = getEntityManager().createQuery(query.toString());
		return jpaQuery.executeUpdate();
    }
     
     /**
     * Saves a Hardware entity 
     * @param Hardware hardware
     */
    public void saveHardware(Hardware hardware) {
       //entityManager.persist(hardware);
       if (entityManager.contains(hardware)) {
          entityManager.merge(hardware);
       } else {
          entityManager.persist(hardware);
       }
       entityManager.flush(); 
    }
       
    /**
     * Deletes a Hardware entity 
     * @param Hardware hardware
     */
    public void deleteHardware(Hardware hardware) {
      entityManager.remove(hardware);
    }
    
    /**
     * Loads the Hardware entity which is related to an instance of
     * Hardware
     * @param Long id
     * @return Hardware The Hardware entity
     
    public Hardware loadHardware(Long id) {
    	return (Hardware)entityManager.get(Hardware.class, id);
    }
*/
  
    /**
     * Loads the Hardware entity which is related to an instance of
     * Hardware
     * @param java.lang.Integer HardwareId
     * @return Hardware The Hardware entity
     */
    public Hardware loadHardware(java.lang.Integer hardwareId) {
    	return (Hardware)entityManager.find(Hardware.class, hardwareId);
    }
    
    /**
     * Loads the Hardware entity which is related to an instance of
     * Hardware and its dependent one to many objects
     * @param Long id
     * @return Hardware The Hardware entity
     */
    public Hardware loadFullFirstLevelHardware(java.lang.Integer hardwareId) {
        List list = getResultList(
                     "SELECT hardware FROM Hardware hardware "
                     + " LEFT JOIN hardware.photoHardwareViaHardwareIdFk "   
                     + " WHERE hardware.hardwareId = "+hardwareId
               );
         if (list!=null && !list.isEmpty())
            return (Hardware)list.get(0);
         return null;
    	//return null;//(Hardware) entityManager.queryForObject("loadFullFirstLevelHardware", id);
    }

    /**
     * Loads the Hardware entity which is related to an instance of
     * Hardware
     * @param Hardware hardware
     * @return Hardware The Hardware entity
     */
    public Hardware loadFullFirstLevelHardware(Hardware hardware) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT hardware FROM Hardware hardware ");
        query.append (" LEFT JOIN hardware.photoHardwareViaHardwareIdFk ");
        if (hardware.getHardwareId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.hardwareId = "+ hardware.getHardwareId() + " ");
         }
        List list = getResultList(query.toString());
        if (list!=null && !list.isEmpty())
           return (Hardware)list.get(0);    
        return null;
    }  

    /**
     * Searches a list of Hardware entity 
     * @param Hardware hardware
     * @return List
     */  
    public List<Hardware> searchPrototypeHardware(Hardware hardware) {
       return searchPrototype (hardware, null);
    }  
	
    public List<Hardware> searchPrototypeAnyHardware(Hardware hardware) {
       return searchPrototypeAny (hardware, null);
    }  

	// indirection
    public List<Hardware> find (Hardware criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
       return find (criteriaMask, matchType, operandType, caseSensitivenessType, null, null); 
	}
	
	// indirection
	protected List<Hardware> find (Hardware criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, Integer startPosition, Integer maxResults) {
       return find (criteriaMask, null, matchType, operandType, caseSensitivenessType, null, startPosition, maxResults); 
    }
	
	// indirection
	protected List<Hardware> find (Hardware criteriaMask, Hardware orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
       return find (null, criteriaMask, orderMask, matchType, operandType, caseSensitivenessType, sortOrder, startPosition, maxResults);
    }
	
	// main find implementation
	protected List<Hardware> find (Hardware whatMask, Hardware criteriaMask, Hardware orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
       Query hquery = null;
	   Map beanPath = new Hashtable();
	   if (isAllNull(whatMask))
		  hquery = getEntityManager().createQuery(findQuery (criteriaMask, orderMask, matchType, operandType, caseSensitivenessType, sortOrder));
	   else
		  hquery = getEntityManager().createQuery(findPartialQuery (whatMask, criteriaMask, orderMask, matchType, operandType, caseSensitivenessType, sortOrder, beanPath));

       if (startPosition!=null)
          hquery.setFirstResult(startPosition);
       if (maxResults!=null)
          hquery.setMaxResults(maxResults);
	   List result = hquery.getResultList();
	   if (isAllNull(whatMask))
	      return result; 
	   else
	      return handlePartialLoadWithParentResult (whatMask, result, beanPath);
    }

	/**
	 *   find * on entity
	 *
	 */
    public String findQuery (Hardware criteriaMask, Hardware orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String what = "SELECT hardware FROM Hardware hardware ";
		return findQuery (criteriaMask, orderMask, what, matchType, operandType, caseSensitivenessType, sortOrder);
    }

    protected String findQuery (Hardware criteriaMask, Hardware orderMask, String what, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String queryWhere = findWhere (criteriaMask, false, isAll(matchType), operandType, caseSensitivenessType);
		String queryOrder = findOrder (orderMask, sortOrder);
	    return getHQuery(what, queryWhere, queryOrder);
    }
	
    protected List<Hardware> searchPrototype (Hardware hardware, Hardware orderMask, QuerySortOrder sortOrder, Integer maxResults) {
       return searchPrototype(getHardwareSelectQuery (getWhereEqualWhereQueryChunk(hardware), orderMask, sortOrder), maxResults);
    }

    protected List<Hardware> searchPrototype (Hardware hardware, Integer maxResults) {
       return searchPrototype(hardware, null, null, maxResults);
    }
    
    protected List<Hardware> searchPrototypeAny (Hardware hardware, Integer maxResults) { 
       return searchPrototype(getSearchEqualAnyQuery (hardware), maxResults);
    }
    
    protected List<Hardware> searchPrototype (String query, Integer maxResults) { 
       Query hquery = getEntityManager().createQuery(query);
       if (maxResults!=null)
          hquery.setMaxResults(maxResults);
       return hquery.getResultList();
    }

    public List<Hardware> searchPrototypeHardware (List<Hardware> hardwares) {
       return searchPrototype (hardwares, null);
    }

    protected List<Hardware> searchPrototype (List<Hardware> hardwares, Integer maxResults) {    
	   return getResultList(getHardwareSearchEqualQuery (null, hardwares));
	}    

    protected List<Hardware> getResultList (String query) {    
	   Query hquery = entityManager.createQuery(query);            
	   return hquery.getResultList();
	}    
 

    public List<Hardware> searchDistinctPrototypeHardware (Hardware hardwareMask, List<Hardware> hardwares) {
        return getResultList(getHardwareSearchEqualQuery (hardwareMask, hardwares));    
    }
        
	/**
     * Searches a list of Hardware entity 
     * @param Hardware positiveMask
     * @param Hardware negativeMask
     * @return List
     */
    public List<Hardware> searchPrototypeHardware(Hardware positiveMask, Hardware negativeMask) {
	    return getResultList(getHardwareSearchEqualQuery (positiveMask, negativeMask));  
    }

    /**
    * return a string query search on a Hardware prototype
    */
    protected String getHardwareSelectQuery (String where, Hardware orderMask, QuerySortOrder sortOrder) {
       return getHardwareSelectQuery (where, findOrder (orderMask, sortOrder));
    }
    protected String getHardwareSelectQuery (String where, String order) {
       StringBuffer query = new StringBuffer();
       query.append ("SELECT hardware FROM Hardware hardware ");
       return (order!=null)? getHQuery(query.toString(), where, order):getHQuery(query.toString(), where);
    }
    /**
    * return a jql query search on a Hardware prototype
    */
    protected String getSearchEqualQuery (Hardware hardware) {
       return getHardwareSelectQuery (getWhereEqualWhereQueryChunk(hardware),null);
    }
    protected String getWhereEqualWhereQueryChunk (Hardware hardware) {
       return getWhereEqualWhereQueryChunk(hardware, false);
    }
    /**
    * return a jql query search on a Hardware with any prototype
    */
    protected String getSearchEqualAnyQuery (Hardware hardware) {
       return getHardwareSelectQuery (getWhereEqualAnyWhereQueryChunk(hardware), null);   
    }
    protected String getWhereEqualAnyWhereQueryChunk (Hardware hardware) {
       return getWhereEqualAnyWhereQueryChunk(hardware, false);   
    }

    /**
    * return a jql search for a list of Hardware prototype
    */
    protected String getHardwareSearchEqualQuery (Hardware hardwareMask, List<Hardware> hardwares) {
        boolean isOrSet = false;
        StringBuffer query = new StringBuffer();
        if (hardwareMask !=null)
           query.append (getHardwareMaskWhat (hardwareMask));
        query.append (" FROM Hardware hardware ");
        StringBuffer queryWhere = new StringBuffer();
        for (Hardware hardware : hardwares) {
           if (!isAllNull(hardware)) {        
	           queryWhere.append (getQueryOR (isOrSet));
	           isOrSet = true;
	           queryWhere.append (" ("+getWhereEqualWhereQueryChunk(hardware, false)+") ");
           }
        }
	    return getHQuery(query.toString(), queryWhere.toString());
    }	

    
    protected String getHardwareMaskWhat (Hardware hardwareMask) {
        boolean isCommaSet = false;
        StringBuffer query = new StringBuffer("SELECT DISTINCT ");
        if (hardwareMask.getHardwareId() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" hardwareId ");
        }
        if (hardwareMask.getName() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" name ");
        }
        if (hardwareMask.getDescription() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" description ");
        }
        if (hardwareMask.getBrand() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" brand ");
        }
        if (hardwareMask.getColor() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" color ");
        }
        if (hardwareMask.getSerialNumber() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" serialNumber ");
        }
        if (hardwareMask.getRegion() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" region ");
        }
        if (hardwareMask.getSubRegionCode() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" subRegionCode ");
        }
        if (hardwareMask.getReleaseDate() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" releaseDate ");
        }
        if (hardwareMask.getAcquiringDate() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" acquiringDate ");
        }
        if (hardwareMask.getAcquiringPrice() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" acquiringPrice ");
        }
        if (hardwareMask.getAcquiredPriceFree() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" acquiredPriceFree ");
        }
        if (hardwareMask.getAcquiredPriceUnknown() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" acquiredPriceUnknown ");
        }
        if (hardwareMask.getAcquiringSellerName() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" acquiringSellerName ");
        }
        if (hardwareMask.getAcquiringPlace() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" acquiringPlace ");
        }
        if (hardwareMask.getLocation() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" location ");
        }
        if (hardwareMask.getHasBox() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" hasBox ");
        }
        if (hardwareMask.getHasManual() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" hasManual ");
        }
        if (hardwareMask.getHasInserts() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" hasInserts ");
        }
        if (hardwareMask.getIsSealed() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" isSealed ");
        }
        if (hardwareMask.getIsNew() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" isNew ");
        }
        if (hardwareMask.getIsCompleteInBox() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" isCompleteInBox ");
        }
        if (hardwareMask.getHardwareStateRating() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" hardwareStateRating ");
        }
        if (hardwareMask.getBoxStateRating() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" boxStateRating ");
        }
        if (hardwareMask.getManualStateRating() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" manualStateRating ");
        }
        if (hardwareMask.getComment() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" comment ");
        }
        if (hardwareMask.getBarcode() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" barcode ");
        }
        if (!isCommaSet)
           return "";
	    return query.toString();
    }
    
    protected String getWhereEqualAnyWhereQueryChunk (Hardware hardware, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (hardware, isAndSet, false);	
	}
	
    protected String getWhereEqualWhereQueryChunk (Hardware hardware, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (hardware, isAndSet, true);
	}
	
    protected String getSearchEqualWhereQueryChunk (Hardware hardware, boolean isAndSet, boolean isAll) {
        StringBuffer query = new StringBuffer();
        if (hardware.getHardwareId() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.hardwareId = "+ hardware.getHardwareId() + " ");
        }
        if (hardware.getName() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.name = '"+ hardware.getName()+"' ");
        }
        if (hardware.getDescription() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.description = '"+ hardware.getDescription()+"' ");
        }
        if (hardware.getBrand_() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.brand_ = "+ hardware.getBrand_() + " ");
        }
        if (hardware.getColor_() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.color_ = "+ hardware.getColor_() + " ");
        }
        if (hardware.getSerialNumber() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.serialNumber = '"+ hardware.getSerialNumber()+"' ");
        }
        if (hardware.getRegion_() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.region_ = "+ hardware.getRegion_() + " ");
        }
        if (hardware.getSubRegionCode() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.subRegionCode = '"+ hardware.getSubRegionCode()+"' ");
        }
        if (hardware.getReleaseDate() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.releaseDate = '"+ hardware.getReleaseDate()+"' ");
        }
        if (hardware.getAcquiringDate() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.acquiringDate = '"+ hardware.getAcquiringDate()+"' ");
        }
        if (hardware.getAcquiringPrice() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.acquiringPrice = "+ hardware.getAcquiringPrice() + " ");
        }
        if (hardware.getAcquiredPriceFree() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.acquiredPriceFree = '"+ hardware.getAcquiredPriceFree()+"' ");
        }
        if (hardware.getAcquiredPriceUnknown() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.acquiredPriceUnknown = '"+ hardware.getAcquiredPriceUnknown()+"' ");
        }
        if (hardware.getAcquiringSellerName() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.acquiringSellerName = '"+ hardware.getAcquiringSellerName()+"' ");
        }
        if (hardware.getAcquiringPlace() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.acquiringPlace = '"+ hardware.getAcquiringPlace()+"' ");
        }
        if (hardware.getLocation_() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.location_ = "+ hardware.getLocation_() + " ");
        }
        if (hardware.getHasBox() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.hasBox = '"+ hardware.getHasBox()+"' ");
        }
        if (hardware.getHasManual() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.hasManual = '"+ hardware.getHasManual()+"' ");
        }
        if (hardware.getHasInserts() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.hasInserts = '"+ hardware.getHasInserts()+"' ");
        }
        if (hardware.getIsSealed() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.isSealed = '"+ hardware.getIsSealed()+"' ");
        }
        if (hardware.getIsNew() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.isNew = '"+ hardware.getIsNew()+"' ");
        }
        if (hardware.getIsCompleteInBox() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.isCompleteInBox = '"+ hardware.getIsCompleteInBox()+"' ");
        }
        if (hardware.getHardwareStateRating() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.hardwareStateRating = "+ hardware.getHardwareStateRating() + " ");
        }
        if (hardware.getBoxStateRating() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.boxStateRating = "+ hardware.getBoxStateRating() + " ");
        }
        if (hardware.getManualStateRating() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.manualStateRating = "+ hardware.getManualStateRating() + " ");
        }
        if (hardware.getComment() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.comment = '"+ hardware.getComment()+"' ");
        }
        if (hardware.getBarcode() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" hardware.barcode = '"+ hardware.getBarcode()+"' ");
        }
	    return query.toString();
    }

    protected String findOrder (Hardware orderMask, QuerySortOrder sortOrder) {
        if (orderMask!=null) {
            String orderColumn = getFirstNotNullColumnOtherWiseNull(orderMask);
            if (orderColumn!=null)
               return orderColumn + " " + sortOrder;
        }
        return "";
    }

	@Override
    protected String findWhere (Hardware hardware, boolean isAndSet, boolean isAll, OperandType operandType, Boolean caseSensitive) {
		return findWhere (null, hardware, isAndSet, isAll, operandType, caseSensitive);
	}
	
	protected static String findWhere (String alias, Hardware hardware, boolean isAndSet, boolean isAll, OperandType operandType, boolean caseSensitive) {
        if (alias==null)
			alias = "hardware";
		StringBuffer query = new StringBuffer();
		String operand = getOperand (operandType);
		String evaluatorPrefix = getEvaluatorPrefix (operandType);		
		String evaluatorSuffix = getEvaluatorSuffix (operandType);		
        if (hardware.getHardwareId() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".hardwareId = "+ hardware.getHardwareId() + " ");
        }
        if (hardware.getName() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = hardware.getName();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".name) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".name "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (hardware.getDescription() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".description = '"+ hardware.getDescription()+"' ");
        }
        if (hardware.getBrand_() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".brand_ = "+ hardware.getBrand_() + " ");
        }
        if (hardware.getColor_() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".color_ = "+ hardware.getColor_() + " ");
        }
        if (hardware.getSerialNumber() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = hardware.getSerialNumber();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".serialNumber) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".serialNumber "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (hardware.getRegion_() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".region_ = "+ hardware.getRegion_() + " ");
        }
        if (hardware.getSubRegionCode() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = hardware.getSubRegionCode();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".subRegionCode) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".subRegionCode "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (hardware.getReleaseDate() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".releaseDate = '"+ hardware.getReleaseDate()+"' ");
        }
        if (hardware.getAcquiringDate() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".acquiringDate = '"+ hardware.getAcquiringDate()+"' ");
        }
        if (hardware.getAcquiringPrice() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".acquiringPrice = "+ hardware.getAcquiringPrice() + " ");
        }
        if (hardware.getAcquiredPriceFree() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".acquiredPriceFree = '"+ hardware.getAcquiredPriceFree()+"' ");
        }
        if (hardware.getAcquiredPriceUnknown() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".acquiredPriceUnknown = '"+ hardware.getAcquiredPriceUnknown()+"' ");
        }
        if (hardware.getAcquiringSellerName() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = hardware.getAcquiringSellerName();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".acquiringSellerName) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".acquiringSellerName "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (hardware.getAcquiringPlace() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = hardware.getAcquiringPlace();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".acquiringPlace) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".acquiringPlace "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (hardware.getLocation_() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".location_ = "+ hardware.getLocation_() + " ");
        }
        if (hardware.getHasBox() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".hasBox = '"+ hardware.getHasBox()+"' ");
        }
        if (hardware.getHasManual() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".hasManual = '"+ hardware.getHasManual()+"' ");
        }
        if (hardware.getHasInserts() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = hardware.getHasInserts();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".hasInserts) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".hasInserts "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (hardware.getIsSealed() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".isSealed = '"+ hardware.getIsSealed()+"' ");
        }
        if (hardware.getIsNew() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".isNew = '"+ hardware.getIsNew()+"' ");
        }
        if (hardware.getIsCompleteInBox() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".isCompleteInBox = '"+ hardware.getIsCompleteInBox()+"' ");
        }
        if (hardware.getHardwareStateRating() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".hardwareStateRating = "+ hardware.getHardwareStateRating() + " ");
        }
        if (hardware.getBoxStateRating() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".boxStateRating = "+ hardware.getBoxStateRating() + " ");
        }
        if (hardware.getManualStateRating() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".manualStateRating = "+ hardware.getManualStateRating() + " ");
        }
        if (hardware.getComment() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = hardware.getComment();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".comment) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".comment "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (hardware.getBarcode() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".barcode = '"+ hardware.getBarcode()+"' ");
        }
        return query.toString();
    }
	
	protected String getFirstNotNullColumnOtherWiseNull (Hardware mask) {
        if (mask == null) return null;
        if (mask.getHardwareId() != null) return "hardwareId";
        if (mask.getName() != null) return "name";
        if (mask.getDescription() != null) return "description";
        if (mask.getBrand_() != null) return "brand";
        if (mask.getColor_() != null) return "color";
        if (mask.getSerialNumber() != null) return "serialNumber";
        if (mask.getRegion_() != null) return "region";
        if (mask.getSubRegionCode() != null) return "subRegionCode";
        if (mask.getReleaseDate() != null) return "releaseDate";
        if (mask.getAcquiringDate() != null) return "acquiringDate";
        if (mask.getAcquiringPrice() != null) return "acquiringPrice";
        if (mask.getAcquiredPriceFree() != null) return "acquiredPriceFree";
        if (mask.getAcquiredPriceUnknown() != null) return "acquiredPriceUnknown";
        if (mask.getAcquiringSellerName() != null) return "acquiringSellerName";
        if (mask.getAcquiringPlace() != null) return "acquiringPlace";
        if (mask.getLocation_() != null) return "location";
        if (mask.getHasBox() != null) return "hasBox";
        if (mask.getHasManual() != null) return "hasManual";
        if (mask.getHasInserts() != null) return "hasInserts";
        if (mask.getIsSealed() != null) return "isSealed";
        if (mask.getIsNew() != null) return "isNew";
        if (mask.getIsCompleteInBox() != null) return "isCompleteInBox";
        if (mask.getHardwareStateRating() != null) return "hardwareStateRating";
        if (mask.getBoxStateRating() != null) return "boxStateRating";
        if (mask.getManualStateRating() != null) return "manualStateRating";
        if (mask.getComment() != null) return "comment";
        if (mask.getBarcode() != null) return "barcode";
        return null;	
	}
    
    /**
    * return a jql search on a Hardware prototype with positive and negative beans
    */
    protected String getHardwareSearchEqualQuery (Hardware positiveMask, Hardware negativeMask) {
		StringBuffer query = new StringBuffer();    	
		query.append(getSelectFrom());
		query.append(getHardwarePositiveNegativeCriteria(positiveMask, negativeMask));
		return query.toString();
	}

	protected String getHardwarePositiveNegativeCriteria (Hardware positiveMask, Hardware negativeMask) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        if (positiveMask!=null && positiveMask.getHardwareId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.hardwareId = "+ positiveMask.getHardwareId() + " ");
        } 
		if (negativeMask!=null && negativeMask.getHardwareId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.hardwareId is null ");
        }
        if (positiveMask!=null && positiveMask.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.name = '"+ positiveMask.getName()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.name is null ");
        }
        if (positiveMask!=null && positiveMask.getDescription() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.description = '"+ positiveMask.getDescription()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getDescription() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.description is null ");
        }
        if (positiveMask!=null && positiveMask.getBrand_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.brand_ = "+ positiveMask.getBrand_() + " ");
        } 
		if (negativeMask!=null && negativeMask.getBrand_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.brand_ is null ");
        }
        if (positiveMask!=null && positiveMask.getColor_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.color_ = "+ positiveMask.getColor_() + " ");
        } 
		if (negativeMask!=null && negativeMask.getColor_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.color_ is null ");
        }
        if (positiveMask!=null && positiveMask.getSerialNumber() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.serialNumber = '"+ positiveMask.getSerialNumber()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getSerialNumber() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.serialNumber is null ");
        }
        if (positiveMask!=null && positiveMask.getRegion_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.region_ = "+ positiveMask.getRegion_() + " ");
        } 
		if (negativeMask!=null && negativeMask.getRegion_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.region_ is null ");
        }
        if (positiveMask!=null && positiveMask.getSubRegionCode() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.subRegionCode = '"+ positiveMask.getSubRegionCode()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getSubRegionCode() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.subRegionCode is null ");
        }
        if (positiveMask!=null && positiveMask.getReleaseDate() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.releaseDate = '"+ positiveMask.getReleaseDate()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getReleaseDate() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.releaseDate is null ");
        }
        if (positiveMask!=null && positiveMask.getAcquiringDate() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.acquiringDate = '"+ positiveMask.getAcquiringDate()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getAcquiringDate() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.acquiringDate is null ");
        }
        if (positiveMask!=null && positiveMask.getAcquiringPrice() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.acquiringPrice = "+ positiveMask.getAcquiringPrice() + " ");
        } 
		if (negativeMask!=null && negativeMask.getAcquiringPrice() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.acquiringPrice is null ");
        }
        if (positiveMask!=null && positiveMask.getAcquiredPriceFree() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.acquiredPriceFree = '"+ positiveMask.getAcquiredPriceFree()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getAcquiredPriceFree() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.acquiredPriceFree is null ");
        }
        if (positiveMask!=null && positiveMask.getAcquiredPriceUnknown() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.acquiredPriceUnknown = '"+ positiveMask.getAcquiredPriceUnknown()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getAcquiredPriceUnknown() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.acquiredPriceUnknown is null ");
        }
        if (positiveMask!=null && positiveMask.getAcquiringSellerName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.acquiringSellerName = '"+ positiveMask.getAcquiringSellerName()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getAcquiringSellerName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.acquiringSellerName is null ");
        }
        if (positiveMask!=null && positiveMask.getAcquiringPlace() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.acquiringPlace = '"+ positiveMask.getAcquiringPlace()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getAcquiringPlace() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.acquiringPlace is null ");
        }
        if (positiveMask!=null && positiveMask.getLocation_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.location_ = "+ positiveMask.getLocation_() + " ");
        } 
		if (negativeMask!=null && negativeMask.getLocation_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.location_ is null ");
        }
        if (positiveMask!=null && positiveMask.getHasBox() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.hasBox = '"+ positiveMask.getHasBox()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getHasBox() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.hasBox is null ");
        }
        if (positiveMask!=null && positiveMask.getHasManual() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.hasManual = '"+ positiveMask.getHasManual()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getHasManual() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.hasManual is null ");
        }
        if (positiveMask!=null && positiveMask.getHasInserts() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.hasInserts = '"+ positiveMask.getHasInserts()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getHasInserts() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.hasInserts is null ");
        }
        if (positiveMask!=null && positiveMask.getIsSealed() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.isSealed = '"+ positiveMask.getIsSealed()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getIsSealed() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.isSealed is null ");
        }
        if (positiveMask!=null && positiveMask.getIsNew() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.isNew = '"+ positiveMask.getIsNew()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getIsNew() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.isNew is null ");
        }
        if (positiveMask!=null && positiveMask.getIsCompleteInBox() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.isCompleteInBox = '"+ positiveMask.getIsCompleteInBox()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getIsCompleteInBox() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.isCompleteInBox is null ");
        }
        if (positiveMask!=null && positiveMask.getHardwareStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.hardwareStateRating = "+ positiveMask.getHardwareStateRating() + " ");
        } 
		if (negativeMask!=null && negativeMask.getHardwareStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.hardwareStateRating is null ");
        }
        if (positiveMask!=null && positiveMask.getBoxStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.boxStateRating = "+ positiveMask.getBoxStateRating() + " ");
        } 
		if (negativeMask!=null && negativeMask.getBoxStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.boxStateRating is null ");
        }
        if (positiveMask!=null && positiveMask.getManualStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.manualStateRating = "+ positiveMask.getManualStateRating() + " ");
        } 
		if (negativeMask!=null && negativeMask.getManualStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.manualStateRating is null ");
        }
        if (positiveMask!=null && positiveMask.getComment() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.comment = '"+ positiveMask.getComment()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getComment() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.comment is null ");
        }
        if (positiveMask!=null && positiveMask.getBarcode() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" hardware.barcode = '"+ positiveMask.getBarcode()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getBarcode() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" hardware.barcode is null ");
        }
	    return query.toString();
    }
 
	
	
    private Logger log = Logger.getLogger(this.getClass());
    
    private SimpleCache simpleCache = new SimpleCache();
    private PhotoJPAImpl photoextendedjpaimpl;
    private EntityManager emForRecursiveDao; // dao that needs other dao in a recursive manner not support by spring configuration

    /**
     * generic to move after in superclass
     */
    public HardwareJPAImpl (EntityManager emForRecursiveDao) {
       this.emForRecursiveDao = emForRecursiveDao;
    }
            
    /**
     * generic to move after in superclass
     */
    private List<Object[]> getSQLQueryResult(String query) {
		   Query queryJ = getEntityManager().createNativeQuery(query);
		   return queryJ.getResultList();
    }

    /**
     * Inserts a Hardware entity with cascade of its children
     * @param Hardware hardware
     */
    public void insertHardwareWithCascade(Hardware hardware) {
    	HardwareJPAImpl hardwarejpaimpl = new HardwareJPAImpl(getEntityManager());
    	hardwarejpaimpl.insertHardwareWithCascade(hardwarejpaimpl.getEntityManagerForRecursiveDao(), hardware);
    }
     
    public void insertHardwareWithCascade(EntityManager emForRecursiveDao, Hardware hardware) {
       insertHardware(emForRecursiveDao, hardware);
       if (!hardware.getPhotoHardwareViaHardwareIdFk().isEmpty()) {
          PhotoJPAImpl photoextendedjpaimpl = new PhotoJPAImpl (emForRecursiveDao);
          for (Photo _photoHardwareViaHardwareIdFk : hardware.getPhotoHardwareViaHardwareIdFk()) {
             photoextendedjpaimpl.insertPhotoWithCascade(emForRecursiveDao, _photoHardwareViaHardwareIdFk);
          }
       } 
    }
        
    /**
     * Inserts a list of Hardware entity with cascade of its children
     * @param List<Hardware> hardwares
     */
    public void insertHardwaresWithCascade(List<Hardware> hardwares) {
       for (Hardware hardware : hardwares) {
          insertHardwareWithCascade(hardware);
       }
    } 
        
    /**
     * lookup Hardware entity Hardware, criteria and max result number
     */
    public List<Hardware> lookupHardware(Hardware hardware, Criteria criteria, Integer numberOfResult, EntityManager em) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT hardware FROM Hardware hardware ");
        for (Criterion criterion : criteria.getClauseCriterions()) {
            query.append (getQueryWHERE_AND (isWhereSet));
            isWhereSet = true;   
            query.append(criterion.getExpression());
        }
        OrderCriteria orderCriteria = criteria.getOrderCriteria();
        if (criteria.getOrderCriteria()!=null)
        	query.append(orderCriteria.getExpression());
        Query hquery = em.createQuery(query.toString());
        if (numberOfResult!=null)
            hquery.setMaxResults(numberOfResult);
        return hquery.getResultList();
    }
    
    public List<Hardware> lookupHardware(Hardware hardware, Criteria criteria, Integer numberOfResult) {
		return lookupHardware(hardware, criteria, numberOfResult, getEntityManager());
    }

    public Integer updateNotNullOnlyHardware (Hardware hardware, Criteria criteria) {
        String queryWhat = getUpdateNotNullOnlyHardwareQueryChunkPrototype (hardware);
        StringBuffer query = new StringBuffer (queryWhat);
        boolean isWhereSet = false;
        for (Criterion criterion : criteria.getClauseCriterions()) {
            query.append (getQueryWHERE_AND (isWhereSet));
            isWhereSet = true;   
            query.append(criterion.getExpression());			
        }  
        Query jpaQuery = getEntityManager().createQuery(query.toString());
        isWhereSet = false;
        if (hardware.getHardwareId() != null) {
           jpaQuery.setParameter ("hardwareId", hardware.getHardwareId());
        }   
        if (hardware.getName() != null) {
           jpaQuery.setParameter ("name", hardware.getName());
        }   
        if (hardware.getDescription() != null) {
           jpaQuery.setParameter ("description", hardware.getDescription());
        }   
        if (hardware.getBrand() != null) {
           jpaQuery.setParameter ("brand", hardware.getBrand());
        }   
        if (hardware.getColor() != null) {
           jpaQuery.setParameter ("color", hardware.getColor());
        }   
        if (hardware.getSerialNumber() != null) {
           jpaQuery.setParameter ("serialNumber", hardware.getSerialNumber());
        }   
        if (hardware.getRegion() != null) {
           jpaQuery.setParameter ("region", hardware.getRegion());
        }   
        if (hardware.getSubRegionCode() != null) {
           jpaQuery.setParameter ("subRegionCode", hardware.getSubRegionCode());
        }   
        if (hardware.getReleaseDate() != null) {
           jpaQuery.setParameter ("releaseDate", hardware.getReleaseDate());
        }   
        if (hardware.getAcquiringDate() != null) {
           jpaQuery.setParameter ("acquiringDate", hardware.getAcquiringDate());
        }   
        if (hardware.getAcquiringPrice() != null) {
           jpaQuery.setParameter ("acquiringPrice", hardware.getAcquiringPrice());
        }   
        if (hardware.getAcquiredPriceFree() != null) {
           jpaQuery.setParameter ("acquiredPriceFree", hardware.getAcquiredPriceFree());
        }   
        if (hardware.getAcquiredPriceUnknown() != null) {
           jpaQuery.setParameter ("acquiredPriceUnknown", hardware.getAcquiredPriceUnknown());
        }   
        if (hardware.getAcquiringSellerName() != null) {
           jpaQuery.setParameter ("acquiringSellerName", hardware.getAcquiringSellerName());
        }   
        if (hardware.getAcquiringPlace() != null) {
           jpaQuery.setParameter ("acquiringPlace", hardware.getAcquiringPlace());
        }   
        if (hardware.getLocation() != null) {
           jpaQuery.setParameter ("location", hardware.getLocation());
        }   
        if (hardware.getHasBox() != null) {
           jpaQuery.setParameter ("hasBox", hardware.getHasBox());
        }   
        if (hardware.getHasManual() != null) {
           jpaQuery.setParameter ("hasManual", hardware.getHasManual());
        }   
        if (hardware.getHasInserts() != null) {
           jpaQuery.setParameter ("hasInserts", hardware.getHasInserts());
        }   
        if (hardware.getIsSealed() != null) {
           jpaQuery.setParameter ("isSealed", hardware.getIsSealed());
        }   
        if (hardware.getIsNew() != null) {
           jpaQuery.setParameter ("isNew", hardware.getIsNew());
        }   
        if (hardware.getIsCompleteInBox() != null) {
           jpaQuery.setParameter ("isCompleteInBox", hardware.getIsCompleteInBox());
        }   
        if (hardware.getHardwareStateRating() != null) {
           jpaQuery.setParameter ("hardwareStateRating", hardware.getHardwareStateRating());
        }   
        if (hardware.getBoxStateRating() != null) {
           jpaQuery.setParameter ("boxStateRating", hardware.getBoxStateRating());
        }   
        if (hardware.getManualStateRating() != null) {
           jpaQuery.setParameter ("manualStateRating", hardware.getManualStateRating());
        }   
        if (hardware.getComment() != null) {
           jpaQuery.setParameter ("comment", hardware.getComment());
        }   
        if (hardware.getBarcode() != null) {
           jpaQuery.setParameter ("barcode", hardware.getBarcode());
        }   
		return jpaQuery.executeUpdate();
    }
	
	public Hardware affectHardware (Hardware hardware) {
	    return referHardware (hardware, null, false);		    
	}
		
	/**
	 * Assign the first hardware retrieved corresponding to the hardware criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no hardware corresponding in the database. Then hardware is inserted and returned with its primary key(s). 
	 */
	public Hardware assignHardware (Hardware hardware) {
		return referHardware (hardware, null, true);
	}

	/**
	 * Assign the first hardware retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no hardware corresponding in the database. 
	 * Then hardware is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public Hardware assignHardware (Hardware hardware, Hardware mask) {
		return referHardware (hardware, mask, true);
	}

	public Hardware referHardware (Hardware hardware, Hardware mask, boolean isAssign) {
		hardware = assignBlankToNull (hardware);
		if (isAllNull(hardware))
			return null;
		else {
			List<Hardware> list;
			if (mask==null)
				list = searchPrototypeHardware(hardware);
			else
				list = searchPrototypeHardware(mask);
			if (list.isEmpty()) {
			    if (isAssign)
			       insertHardware(hardware);
			    else
				   return null;
			}
			else if (list.size()==1)
				hardware.copy(list.get(0));
			else 
				//TODO log error
				hardware.copy(list.get(0));
		}
		return hardware;		    
	}

   public Hardware assignHardwareUseCache (Hardware hardware) {
      return referHardwareUseCache (hardware, true);
   }
      		
   public Hardware affectHardwareUseCache (Hardware hardware) {
      return referHardwareUseCache (hardware, false);
   }
      		
   public Hardware referHardwareUseCache (Hardware hardware, boolean isAssign) {
	  String key = getCacheKey(null, hardware, null, "assignHardware");
      Hardware hardwareCache = (Hardware)simpleCache.get(key);
      if (hardwareCache==null) {
         hardwareCache = referHardware (hardware, null, isAssign);
         if (key!=null)
         	simpleCache.put(key, hardwareCache);
      }
      hardware.copy(hardwareCache);
      return hardwareCache;
   }	

	private String getCacheKey (Hardware hardwareWhat, Hardware positiveHardware, Hardware negativeHardware, String queryKey) {
	    StringBuffer sb = new StringBuffer();
	    sb.append(queryKey);
	    if (hardwareWhat!=null)
	       sb.append(hardwareWhat.toStringWithParents());
	    if (positiveHardware!=null)
	       sb.append(positiveHardware.toStringWithParents());
	    if (negativeHardware!=null)
	       sb.append(negativeHardware.toStringWithParents());
	    return sb.toString();
	}
	
    public Hardware partialLoadWithParentFirstHardware(Hardware hardwareWhat, Hardware positiveHardware, Hardware negativeHardware){
		List <Hardware> list = partialLoadWithParentHardware(hardwareWhat, positiveHardware, negativeHardware);
		return (!list.isEmpty())?(Hardware)list.get(0):null;
    }
    
    public Hardware partialLoadWithParentFirstHardwareUseCache(Hardware hardwareWhat, Hardware positiveHardware, Hardware negativeHardware, Boolean useCache){
		List <Hardware> list = partialLoadWithParentHardwareUseCache(hardwareWhat, positiveHardware, negativeHardware, useCache);
		return (!list.isEmpty())?(Hardware)list.get(0):null;
    }
	
	public Hardware partialLoadWithParentFirstHardwareUseCacheOnResult(Hardware hardwareWhat, Hardware positiveHardware, Hardware negativeHardware, Boolean useCache){
		List <Hardware> list = partialLoadWithParentHardwareUseCacheOnResult(hardwareWhat, positiveHardware, negativeHardware, useCache);
		return (!list.isEmpty())?(Hardware)list.get(0):null;
    }
	//
	protected List<Hardware> partialLoadWithParentHardware(Hardware hardwareWhat, Hardware positiveHardware, Hardware negativeHardware, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentHardware(hardwareWhat, positiveHardware, negativeHardware, new QuerySelectInit(), nbOfResult, useCache);
	}	  

	protected List partialLoadWithParentHardwareQueryResult (Hardware hardwareWhat, Hardware positiveHardware, Hardware negativeHardware, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentHardwareQueryResult (hardwareWhat, positiveHardware, negativeHardware, new QuerySelectInit(), nbOfResult, useCache);
	}	
    
    public List<Hardware> getDistinctHardware(Hardware hardwareWhat, Hardware positiveHardware, Hardware negativeHardware) {
		 return partialLoadWithParentHardware(hardwareWhat, positiveHardware, negativeHardware, new QuerySelectDistinctInit(), null, false);
	}
	
	public List<Hardware> partialLoadWithParentHardware(Hardware hardwareWhat, Hardware positiveHardware, Hardware negativeHardware) {
		 return partialLoadWithParentHardware(hardwareWhat, positiveHardware, negativeHardware, new QuerySelectInit(), null, false);
	}	
  
	public List<Hardware> partialLoadWithParentHardwareUseCacheOnResult(Hardware hardwareWhat, Hardware positiveHardware, Hardware negativeHardware, Boolean useCache) {
		String key = getCacheKey(hardwareWhat, positiveHardware, negativeHardware, "partialLoadWithParentHardware");
		List<Hardware> list = (List<Hardware>)simpleCache.get(key);
		if (list==null || list.isEmpty()) {
			list = partialLoadWithParentHardware(hardwareWhat, positiveHardware, negativeHardware);
			if (!list.isEmpty())
			   simpleCache.put(key, list);
		}
		return list;	
	}	

	public List<Hardware> partialLoadWithParentHardwareUseCache(Hardware hardwareWhat, Hardware positiveHardware, Hardware negativeHardware, Boolean useCache) {
		String key = getCacheKey(hardwareWhat, positiveHardware, negativeHardware, "partialLoadWithParentHardware");
		List<Hardware> list = (List<Hardware>)simpleCache.get(key);
		if (list==null) {
			list = partialLoadWithParentHardware(hardwareWhat, positiveHardware, negativeHardware);
			simpleCache.put(key, list);
		}
		return list;	
	}	
	
	private List<Hardware> handleLoadWithParentHardware(Map beanPath, List list, Hardware hardwareWhat) {
	    return handleLoadWithParentHardware(beanPath, list, hardwareWhat, true);  
	}
	
	private List<Hardware> handleLoadWithParentHardware(Map beanPath, List list, Hardware hardwareWhat, boolean isHql) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentHardwareWithOneElementInRow(list, beanPath, hardwareWhat, isHql);
		}
		return handlePartialLoadWithParentHardware(list, beanPath, hardwareWhat, isHql);	
	}
	
    	// to set in super class	
	protected void populateHardware (Hardware hardware, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(hardware, beanPath, value);
	}
	
	protected void populateHardwareFromSQL (Hardware hardware, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(hardware, beanPath, value);
	}
    	// to set in super class BEWARE: genericity is only one level!!!!! first level is a copy second level is a reference!!! change to hardware.clone() instead
	private Hardware cloneHardware (Hardware hardware) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		//return (Hardware) BeanUtils.cloneBeanObject(hardware);
	   if (hardware==null) return new Hardware();
	   return hardware.clone();
	}
    
    // to set in super class
	private Object getBeanObjectInstance (Object bean) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
       return BeanUtils.getBeanObjectInstance(bean);	
	}
	// to set in super class
	protected void populateObject (Object bean, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException {
       BeanUtils.populateObject(bean, value, beanPath);
	}
	
	protected void populateObjectFromSQL (Object bean, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException {
       BeanUtils.populateObject(bean, value, beanPath);
	}
	
    public List<Hardware> countDistinct (Hardware whatMask, Hardware whereEqCriteria) {
       return partialLoadWithParentHardware(whatMask, whereEqCriteria, null, new QuerySelectCountInit("hardware"), null, false);
    }   
  	
    public Long count(Hardware whereEqCriteria) {
	    return count(null, whereEqCriteria, EntityMatchType.ALL, OperandType.EQUALS, true); 
/*        Query query = getEntityManager().createQuery(getSelectCountPrototype(whereEqCriteria));
        List<Long> list = query.getResultList();
    	if (!list.isEmpty()) {
            return list.get(0);
    	}
    	return 0L;
*/
    }


    public Long count(Hardware whatMask, Hardware whereCriteria, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
        Query query = null;
		if (isAllNull(whatMask))
			query = getEntityManager().createQuery(countQuery(whereCriteria, matchType, operandType, caseSensitivenessType));
		else {
			query = getEntityManager().createQuery(countPartialLoadWithParentRawHsqlQuery(whatMask, whereCriteria, matchType, operandType, caseSensitivenessType));
		}
        List<Long> list = query.getResultList();
    	if (!list.isEmpty()) {
            return list.get(0);
    	}
    	return 0L;
    }

	protected String countQuery (Hardware hardware, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
        String what = "SELECT count(*) FROM Hardware hardware ";
		return findQuery (hardware, null, what, matchType, operandType, caseSensitivenessType, null);
    }
	

   private List getFirstResultWhereConditionsAre (Hardware hardware) {
      return partialLoadWithParentHardwareQueryResult(getDefaultHardwareWhat(), hardware, null, 1, false);	
   }
   
   protected Hardware getDefaultHardwareWhat() {
      Hardware hardware = new Hardware();
      hardware.setHardwareId(Integer.valueOf(-1));
      return hardware;
   }
   
	public Hardware getFirstHardware (Hardware hardware) {
		if (isAllNull(hardware))
			return null;
		else {
			List<Hardware> list = searchPrototype (hardware, 1);
			if (list.isEmpty()) {
				return null;
			}
			else if (list.size()==1)
				return list.get(0);
			else 
				//TODO log error
				return list.get(0);	
		}
	}
	
    /**
    * checks if the Hardware entity exists
    */           
    public boolean existsHardware (Hardware hardware) {
       if (getFirstHardware(hardware)!=null)
          return true;
       return false;  
    }
        
    public boolean existsHardwareWhereConditionsAre (Hardware hardware) {
       if (getFirstResultWhereConditionsAre (hardware).isEmpty())
          return false;
       return true;  
    }

	private int countPartialField (Hardware hardware) {
	   int cpt = 0;
       if (hardware.getHardwareId() != null) {
          cpt++;
       }
       if (hardware.getName() != null) {
          cpt++;
       }
       if (hardware.getDescription() != null) {
          cpt++;
       }
       if (hardware.getBrand_() != null) {
          cpt++;
       }
       if (hardware.getColor_() != null) {
          cpt++;
       }
       if (hardware.getSerialNumber() != null) {
          cpt++;
       }
       if (hardware.getRegion_() != null) {
          cpt++;
       }
       if (hardware.getSubRegionCode() != null) {
          cpt++;
       }
       if (hardware.getReleaseDate() != null) {
          cpt++;
       }
       if (hardware.getAcquiringDate() != null) {
          cpt++;
       }
       if (hardware.getAcquiringPrice() != null) {
          cpt++;
       }
       if (hardware.getAcquiredPriceFree() != null) {
          cpt++;
       }
       if (hardware.getAcquiredPriceUnknown() != null) {
          cpt++;
       }
       if (hardware.getAcquiringSellerName() != null) {
          cpt++;
       }
       if (hardware.getAcquiringPlace() != null) {
          cpt++;
       }
       if (hardware.getLocation_() != null) {
          cpt++;
       }
       if (hardware.getHasBox() != null) {
          cpt++;
       }
       if (hardware.getHasManual() != null) {
          cpt++;
       }
       if (hardware.getHasInserts() != null) {
          cpt++;
       }
       if (hardware.getIsSealed() != null) {
          cpt++;
       }
       if (hardware.getIsNew() != null) {
          cpt++;
       }
       if (hardware.getIsCompleteInBox() != null) {
          cpt++;
       }
       if (hardware.getHardwareStateRating() != null) {
          cpt++;
       }
       if (hardware.getBoxStateRating() != null) {
          cpt++;
       }
       if (hardware.getManualStateRating() != null) {
          cpt++;
       }
       if (hardware.getComment() != null) {
          cpt++;
       }
       if (hardware.getBarcode() != null) {
          cpt++;
       }
       return cpt;
	}   

	public List<Hardware> partialLoadWithParentHardware(Hardware what, Hardware positiveHardware, Hardware negativeHardware, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		Map beanPath = new Hashtable();
		List list = partialLoadWithParentHardwareJPAQueryResult (what, positiveHardware, negativeHardware, queryWhatInit, beanPath, nbOfResult, useCache);
		return handlePartialLoadWithParentResult(what, list, beanPath);
	}
	
	public List<Hardware> handlePartialLoadWithParentResult(Hardware what, List list, Map beanPath) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentHardwareWithOneElementInRow(list, beanPath, what, true);
		}
		return handlePartialLoadWithParentHardware(list, beanPath, what, true);
	}	

	private List partialLoadWithParentHardwareQueryResult(Hardware hardwareWhat, Hardware positiveHardware, Hardware negativeHardware, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		return partialLoadWithParentHardwareJPAQueryResult (hardwareWhat, positiveHardware, negativeHardware, queryWhatInit, new Hashtable(), nbOfResult, useCache);
    }	
  
	private List partialLoadWithParentHardwareJPAQueryResult(Hardware hardwareWhat, Hardware positiveHardware, Hardware negativeHardware, QueryWhatInit queryWhatInit, Map beanPath, Integer nbOfResult, Boolean useCache) {
		Query hquery = getPartialLoadWithParentJPAQuery (hardwareWhat, positiveHardware, negativeHardware, beanPath, queryWhatInit, nbOfResult);
		return hquery.getResultList();
    }	
   /**
    * @returns an JPA Hsql query based on entity Hardware and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPAQuery (Hardware hardwareWhat, Hardware positiveHardware, Hardware negativeHardware, Map beanPath, QueryWhatInit queryWhatInit, Integer nbOfResult) {
	   Query query = getPartialLoadWithParentJPARawQuery (hardwareWhat, positiveHardware, negativeHardware, beanPath, queryWhatInit);
	   if (nbOfResult!=null)
	      query.setMaxResults(nbOfResult);
	   return query;
    }
  	
   /**
    * @returns an JPA Raw Hsql query based on entity Hardware and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPARawQuery (Hardware hardwareWhat, Hardware positiveHardware, Hardware negativeHardware, Map beanPath, QueryWhatInit queryWhatInit) {
	   return getEntityManager().createQuery(getPartialLoadWithParentRawHsqlQuery (hardwareWhat, positiveHardware, negativeHardware, beanPath, queryWhatInit));
    }
	
	private List<Hardware> handlePartialLoadWithParentHardware(List<Object[]> list, Map<Integer, String> beanPath, Hardware hardwareWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentHardware(list, beanPath, hardwareWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentHardware, message:"+ex.getMessage());
			return new ArrayList<Hardware>();
		}
    }

	private List<Hardware> handlePartialLoadWithParentHardwareWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, Hardware hardwareWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentHardwareWithOneElementInRow(list, beanPath, hardwareWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentHardwareWithOneElementInRow, message:"+ex.getMessage());
			return new ArrayList<Hardware>();
		}
    }
    	
	 private List<Hardware> convertPartialLoadWithParentHardware(List<Object[]> list, Map<Integer, String> beanPath, Hardware hardwareWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<Hardware> resultList = new ArrayList<Hardware>();
		 for (Object[] row : list) {		
		    Hardware hardware = cloneHardware (hardwareWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populateHardware (hardware, row[(Integer)entry.getKey()], (String)entry.getValue());
		    }
		    resultList.add(hardware);
		 }
		 return resultList;		
	 }	
    
	 private List<Hardware> convertPartialLoadWithParentHardwareWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, Hardware hardwareWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<Hardware> resultList = new ArrayList<Hardware>();
		 for (Object row : list) {		
		    Hardware hardware = cloneHardware (hardwareWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populateHardware (hardware, row, (String)entry.getValue());
		    }
		    resultList.add(hardware);
		 }		 
		 return resultList;		
	 }

	
	// to set in super class
	private String getFieldFromBeanPath(String beanPath) {
	   String result = StringUtils.substringAfterLast(beanPath, ".");
	   if (result.equals(""))
		 return beanPath;
	   return result;
	}

   /**
    * 
    * partial on entity and its parents load enables to specify the fields you want to load explicitly
    */
	public String getPartialLoadWithParentRawHsqlQuery (Hardware hardware, Hardware positiveHardware, Hardware negativeHardware, Map beanPath, QueryWhatInit queryWhatInit) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentHardwareQuery (hardware, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
		Hashtable aliasWhereHt = new Hashtable();
		String where = getPartialLoadWithParentWhereQuery (positiveHardware, null, aliasWhatHt, aliasWhereHt, null, null);
		String whereHow = reconciliateWherePath(aliasWhatHt, aliasWhereHt);
		String how = reconciliateHowPath(aliasWhatHt, aliasWhereHt);
		String andConcat = "";
		if (where!=null && !where.equals("") && whereHow!=null && !whereHow.equals(""))
			andConcat=" AND ";
		return what+" FROM "+how +" WHERE "+whereHow+ andConcat +where;
	}

   /**
    * 
    * partial on entity and its parents load enables to specify the fields you want to load explicitly
    */
	public String findPartialLoadWithParentRawHsqlQuery (Hardware whatMask, Hardware criteriaMask, Map beanPath, QueryWhatInit queryWhatInit,  Hardware orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentHardwareQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
		Hashtable aliasWhereHt = new Hashtable();
		String where = getPartialLoadWithParentWhereQuery (criteriaMask, null, aliasWhatHt, aliasWhereHt, null, null, matchType, operandType, caseSensitivenessType);
		String whereHow = reconciliateWherePath(aliasWhatHt, aliasWhereHt);
		String how = reconciliateHowPath(aliasWhatHt, aliasWhereHt);
		String whereConcat = "";
		if (whereHow!=null && !whereHow.equals(""))
			whereConcat=" WHERE ";
		String andConcat = "";
		if (where!=null && !where.equals("") && whereHow!=null && !whereHow.equals(""))
			andConcat=" AND ";
		String order = findOrder (orderMask, sortOrder);
		String orderConcat = "";
		if (order!=null && !order.equals(""))
			orderConcat=" ORDER BY ";
		return what + " FROM " +how + whereConcat + whereHow + andConcat + where + orderConcat + order;
	}
   /**
    * 
    * count number of entity matching criteria on entity and its parents load enables to specify the fields you want to load explicitly
    */
	public String countPartialLoadWithParentRawHsqlQuery (Hardware whatMask, Hardware criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
		Map beanPath = new Hashtable();
		Hashtable aliasWhatHt = new Hashtable();
		// used to initiate the how part of the what
		getPartialLoadWithParentHardwareQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", new QuerySelectInit());
		String what = "select count(hardware) ";
		Hashtable aliasWhereHt = new Hashtable();
		String where = getPartialLoadWithParentWhereQuery (criteriaMask, null, aliasWhatHt, aliasWhereHt, null, null, matchType, operandType, caseSensitivenessType);
		String whereHow = reconciliateWherePath(aliasWhatHt, aliasWhereHt);
		String how = reconciliateHowPath(aliasWhatHt, aliasWhereHt);
        String whereConcat = "";
        if (whereHow!=null && !whereHow.equals(""))
            whereConcat=" WHERE ";
		String andConcat = "";
		if (where!=null && !where.equals("") && whereHow!=null && !whereHow.equals(""))
            andConcat=" AND ";
		return what+" FROM "+how +whereConcat+whereHow+ andConcat +where;
	}
    	
	public String findPartialQuery (Hardware whatMask, Hardware criteriaMask, Hardware orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Map beanPath) {
        QueryWhatInit queryWhatInit = new QuerySelectInit();
        return findPartialLoadWithParentRawHsqlQuery(whatMask, criteriaMask, beanPath, queryWhatInit, orderMask, matchType, operandType, caseSensitivenessType,  sortOrder);
    }
	
	/**
    * partial on a single entity load enables to specify the fields you want to load explicitly
    */         
	public List<Hardware> partialLoadHardware(Hardware hardware, Hardware positiveHardware, Hardware negativeHardware) {
	    Query hquery = getEntityManager().createQuery(getPartialLoadHardwareQuery (hardware, positiveHardware, negativeHardware));
		int countPartialField = countPartialField(hardware);
		if (countPartialField==0) 
			return new ArrayList<Hardware>();
		List list = hquery.getResultList();
		Iterator iter = list.iterator();
		List<Hardware> returnList = new ArrayList<Hardware>();
		while(iter.hasNext()) {
			int index = 0;
			Object[] row;
			if (countPartialField==1) {
				row = new Object[1];
				row[0] = iter.next();
				} 
			else 
				row = (Object[]) iter.next();
			Hardware hardwareResult = new Hardware();
			if (hardware.getHardwareId() != null) {
                hardwareResult.setHardwareId((Integer) row[index]);
				index++;
			}
			if (hardware.getName() != null) {
                hardwareResult.setName((String) row[index]);
				index++;
			}
			if (hardware.getDescription() != null) {
                hardwareResult.setDescription((String) row[index]);
				index++;
			}
			if (hardware.getBrand_() != null) {
                hardwareResult.setBrand_((Integer) row[index]);
				index++;
			}
			if (hardware.getColor_() != null) {
                hardwareResult.setColor_((Integer) row[index]);
				index++;
			}
			if (hardware.getSerialNumber() != null) {
                hardwareResult.setSerialNumber((String) row[index]);
				index++;
			}
			if (hardware.getRegion_() != null) {
                hardwareResult.setRegion_((Integer) row[index]);
				index++;
			}
			if (hardware.getSubRegionCode() != null) {
                hardwareResult.setSubRegionCode((String) row[index]);
				index++;
			}
			if (hardware.getReleaseDate() != null) {
                hardwareResult.setReleaseDate((java.util.Date) row[index]);
				index++;
			}
			if (hardware.getAcquiringDate() != null) {
                hardwareResult.setAcquiringDate((java.util.Date) row[index]);
				index++;
			}
			if (hardware.getAcquiringPrice() != null) {
                hardwareResult.setAcquiringPrice((java.math.BigDecimal) row[index]);
				index++;
			}
			if (hardware.getAcquiredPriceFree() != null) {
                hardwareResult.setAcquiredPriceFree((Boolean) row[index]);
				index++;
			}
			if (hardware.getAcquiredPriceUnknown() != null) {
                hardwareResult.setAcquiredPriceUnknown((Boolean) row[index]);
				index++;
			}
			if (hardware.getAcquiringSellerName() != null) {
                hardwareResult.setAcquiringSellerName((String) row[index]);
				index++;
			}
			if (hardware.getAcquiringPlace() != null) {
                hardwareResult.setAcquiringPlace((String) row[index]);
				index++;
			}
			if (hardware.getLocation_() != null) {
                hardwareResult.setLocation_((Integer) row[index]);
				index++;
			}
			if (hardware.getHasBox() != null) {
                hardwareResult.setHasBox((Boolean) row[index]);
				index++;
			}
			if (hardware.getHasManual() != null) {
                hardwareResult.setHasManual((Boolean) row[index]);
				index++;
			}
			if (hardware.getHasInserts() != null) {
                hardwareResult.setHasInserts((String) row[index]);
				index++;
			}
			if (hardware.getIsSealed() != null) {
                hardwareResult.setIsSealed((Boolean) row[index]);
				index++;
			}
			if (hardware.getIsNew() != null) {
                hardwareResult.setIsNew((Boolean) row[index]);
				index++;
			}
			if (hardware.getIsCompleteInBox() != null) {
                hardwareResult.setIsCompleteInBox((Boolean) row[index]);
				index++;
			}
			if (hardware.getHardwareStateRating() != null) {
                hardwareResult.setHardwareStateRating((Integer) row[index]);
				index++;
			}
			if (hardware.getBoxStateRating() != null) {
                hardwareResult.setBoxStateRating((Integer) row[index]);
				index++;
			}
			if (hardware.getManualStateRating() != null) {
                hardwareResult.setManualStateRating((Integer) row[index]);
				index++;
			}
			if (hardware.getComment() != null) {
                hardwareResult.setComment((String) row[index]);
				index++;
			}
			if (hardware.getBarcode() != null) {
                hardwareResult.setBarcode((String) row[index]);
				index++;
			}
			returnList.add(hardwareResult);
        }
	    return returnList;
	}

	public static String getPartialLoadWithParentWhereQuery (
	   Hardware criteriaMask, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias,
	   EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
	   if (criteriaMask==null)
	      return "";
	   String alias = null;
	   if (aliasWhereHt == null) {
	      aliasWhereHt = new Hashtable();
	   } 
	   if (isLookedUp(criteriaMask)){
	      alias = getNextAlias (aliasWhereHt, criteriaMask);
		  aliasWhereHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
	   return findWhere (alias, criteriaMask, false, isAll(matchType), operandType, caseSensitivenessType); 
	}

	public static String getPartialLoadWithParentWhereQuery (
	   Hardware hardware, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias) {
	   if (hardware==null)
	      return "";
	   String alias = null;
	   if (aliasWhereHt == null) {
	      aliasWhereHt = new Hashtable();
	   } 
	   if (isLookedUp(hardware)){
	      alias = getNextAlias (aliasWhereHt, hardware);
		  aliasWhereHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (hardware.getHardwareId() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".hardwareId = "+ hardware.getHardwareId() + " ");
       }
       if (hardware.getName() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".name = '"+ hardware.getName()+"' ");
       }
       if (hardware.getDescription() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".description = '"+ hardware.getDescription()+"' ");
       }
       if (hardware.getBrand() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".brand = "+ hardware.getBrand() + " ");
       }
       if (hardware.getColor() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".color = "+ hardware.getColor() + " ");
       }
       if (hardware.getSerialNumber() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".serialNumber = '"+ hardware.getSerialNumber()+"' ");
       }
       if (hardware.getRegion() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".region = "+ hardware.getRegion() + " ");
       }
       if (hardware.getSubRegionCode() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".subRegionCode = '"+ hardware.getSubRegionCode()+"' ");
       }
       if (hardware.getReleaseDate() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".releaseDate = '"+ hardware.getReleaseDate()+"' ");
       }
       if (hardware.getAcquiringDate() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".acquiringDate = '"+ hardware.getAcquiringDate()+"' ");
       }
       if (hardware.getAcquiringPrice() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".acquiringPrice = "+ hardware.getAcquiringPrice() + " ");
       }
       if (hardware.getAcquiredPriceFree() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".acquiredPriceFree = '"+ hardware.getAcquiredPriceFree()+"' ");
       }
       if (hardware.getAcquiredPriceUnknown() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".acquiredPriceUnknown = '"+ hardware.getAcquiredPriceUnknown()+"' ");
       }
       if (hardware.getAcquiringSellerName() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".acquiringSellerName = '"+ hardware.getAcquiringSellerName()+"' ");
       }
       if (hardware.getAcquiringPlace() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".acquiringPlace = '"+ hardware.getAcquiringPlace()+"' ");
       }
       if (hardware.getLocation() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".location = "+ hardware.getLocation() + " ");
       }
       if (hardware.getHasBox() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".hasBox = '"+ hardware.getHasBox()+"' ");
       }
       if (hardware.getHasManual() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".hasManual = '"+ hardware.getHasManual()+"' ");
       }
       if (hardware.getHasInserts() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".hasInserts = '"+ hardware.getHasInserts()+"' ");
       }
       if (hardware.getIsSealed() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".isSealed = '"+ hardware.getIsSealed()+"' ");
       }
       if (hardware.getIsNew() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".isNew = '"+ hardware.getIsNew()+"' ");
       }
       if (hardware.getIsCompleteInBox() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".isCompleteInBox = '"+ hardware.getIsCompleteInBox()+"' ");
       }
       if (hardware.getHardwareStateRating() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".hardwareStateRating = "+ hardware.getHardwareStateRating() + " ");
       }
       if (hardware.getBoxStateRating() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".boxStateRating = "+ hardware.getBoxStateRating() + " ");
       }
       if (hardware.getManualStateRating() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".manualStateRating = "+ hardware.getManualStateRating() + " ");
       }
       if (hardware.getComment() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".comment = '"+ hardware.getComment()+"' ");
       }
       if (hardware.getBarcode() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".barcode = '"+ hardware.getBarcode()+"' ");
       }
       if (hardware.getBrand()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ProducerJPAImpl.getPartialLoadWithParentWhereQuery(
		      hardware.getBrand(), 
			  isWhereSet, aliasHt, aliasWhereHt, alias, "brand");
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  }  	  
	   }
       if (hardware.getColor()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl.getPartialLoadWithParentWhereQuery(
		      hardware.getColor(), 
			  isWhereSet, aliasHt, aliasWhereHt, alias, "color");
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  }  	  
	   }
       if (hardware.getLocation()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.LocationJPAImpl.getPartialLoadWithParentWhereQuery(
		      hardware.getLocation(), 
			  isWhereSet, aliasHt, aliasWhereHt, alias, "location");
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  }  	  
	   }
       if (hardware.getRegion()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl.getPartialLoadWithParentWhereQuery(
		      hardware.getRegion(), 
			  isWhereSet, aliasHt, aliasWhereHt, alias, "region");
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  }  	  
	   }
	   return query.toString(); 
    }
	
	public static String reconciliateWherePath(Hashtable aliasWhatHt, Hashtable aliasWhereHt) {
	   StringBuffer sb = new StringBuffer();
	   boolean isBlankSet = false;
	   aliasWhatHt.putAll(aliasWhereHt);
	   Enumeration<String> elements = aliasWhatHt.elements();
	   while (elements.hasMoreElements()) {
		  String element = elements.nextElement();
		  if (!element.equals("")) {
		     sb.append (getQueryBLANK_AND (isBlankSet));
		     isBlankSet=true;
		     sb.append(element);
		  }
	   }
	   return sb.toString();
	}
	
	public static String reconciliateHowPath(Hashtable aliasWhatHt, Hashtable aliasWhereHt) {
	   StringBuffer sb = new StringBuffer();
	   boolean isBlankSet = false;
	   aliasWhatHt.putAll(aliasWhereHt);
	   Enumeration<String> _keys = aliasWhatHt.keys();
	   while (_keys.hasMoreElements()) {
		  String _key = _keys.nextElement();
		  sb.append (getQueryBLANK_COMMA (isBlankSet));
		  isBlankSet = true;
		  sb.append(getAliasKeyDomain(_key)+" "+getAliasKeyAlias(_key));
	   }
	   return sb.toString();
	}
	
	protected static String getRootDomainName (String domainName) {
		return StringUtils.substringBefore(domainName, "_");
	}
	
    public static String getPartialLoadWithParentHardwareQuery (
	   Hardware hardware, Boolean isWhereSet, Hashtable aliasHt, String childAlias, String childFKAlias, Map beanPath, String rootPath, QueryWhatInit queryWhatInit) {
	   if (hardware==null)
	      return "";
	   String alias = null;
	   if (aliasHt == null) {
	      aliasHt = new Hashtable();
	   } 
	   if (isLookedUp(hardware)){
	      alias = getNextAlias (aliasHt, hardware);
		  aliasHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (hardware.getHardwareId() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"hardwareId");
          query.append(" "+alias+".hardwareId ");
       }
       if (hardware.getName() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"name");
          query.append(" "+alias+".name ");
       }
       if (hardware.getDescription() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"description");
          query.append(" "+alias+".description ");
       }
       if (hardware.getBrand() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"brand");
          query.append(" "+alias+".brand ");
       }
       if (hardware.getColor() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"color");
          query.append(" "+alias+".color ");
       }
       if (hardware.getSerialNumber() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"serialNumber");
          query.append(" "+alias+".serialNumber ");
       }
       if (hardware.getRegion() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"region");
          query.append(" "+alias+".region ");
       }
       if (hardware.getSubRegionCode() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"subRegionCode");
          query.append(" "+alias+".subRegionCode ");
       }
       if (hardware.getReleaseDate() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"releaseDate");
          query.append(" "+alias+".releaseDate ");
       }
       if (hardware.getAcquiringDate() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"acquiringDate");
          query.append(" "+alias+".acquiringDate ");
       }
       if (hardware.getAcquiringPrice() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"acquiringPrice");
          query.append(" "+alias+".acquiringPrice ");
       }
       if (hardware.getAcquiredPriceFree() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"acquiredPriceFree");
          query.append(" "+alias+".acquiredPriceFree ");
       }
       if (hardware.getAcquiredPriceUnknown() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"acquiredPriceUnknown");
          query.append(" "+alias+".acquiredPriceUnknown ");
       }
       if (hardware.getAcquiringSellerName() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"acquiringSellerName");
          query.append(" "+alias+".acquiringSellerName ");
       }
       if (hardware.getAcquiringPlace() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"acquiringPlace");
          query.append(" "+alias+".acquiringPlace ");
       }
       if (hardware.getLocation() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"location");
          query.append(" "+alias+".location ");
       }
       if (hardware.getHasBox() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"hasBox");
          query.append(" "+alias+".hasBox ");
       }
       if (hardware.getHasManual() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"hasManual");
          query.append(" "+alias+".hasManual ");
       }
       if (hardware.getHasInserts() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"hasInserts");
          query.append(" "+alias+".hasInserts ");
       }
       if (hardware.getIsSealed() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"isSealed");
          query.append(" "+alias+".isSealed ");
       }
       if (hardware.getIsNew() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"isNew");
          query.append(" "+alias+".isNew ");
       }
       if (hardware.getIsCompleteInBox() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"isCompleteInBox");
          query.append(" "+alias+".isCompleteInBox ");
       }
       if (hardware.getHardwareStateRating() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"hardwareStateRating");
          query.append(" "+alias+".hardwareStateRating ");
       }
       if (hardware.getBoxStateRating() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"boxStateRating");
          query.append(" "+alias+".boxStateRating ");
       }
       if (hardware.getManualStateRating() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"manualStateRating");
          query.append(" "+alias+".manualStateRating ");
       }
       if (hardware.getComment() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"comment");
          query.append(" "+alias+".comment ");
       }
       if (hardware.getBarcode() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"barcode");
          query.append(" "+alias+".barcode ");
       }
       if (hardware.getBrand()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ProducerJPAImpl.getPartialLoadWithParentProducerQuery(
		      hardware.getBrand(), 
			  isWhereSet, aliasHt, alias, "brand", beanPath, rootPath+"brand.", queryWhatInit);
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  } 
	   }  
       if (hardware.getColor()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl.getPartialLoadWithParentValueListQuery(
		      hardware.getColor(), 
			  isWhereSet, aliasHt, alias, "color", beanPath, rootPath+"color.", queryWhatInit);
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  } 
	   }  
       if (hardware.getLocation()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.LocationJPAImpl.getPartialLoadWithParentLocationQuery(
		      hardware.getLocation(), 
			  isWhereSet, aliasHt, alias, "location", beanPath, rootPath+"location.", queryWhatInit);
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  } 
	   }  
       if (hardware.getRegion()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl.getPartialLoadWithParentValueListQuery(
		      hardware.getRegion(), 
			  isWhereSet, aliasHt, alias, "region", beanPath, rootPath+"region.", queryWhatInit);
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  } 
	   }  
//       query.append(getHardwareSearchEqualQuery (positiveHardware, negativeHardware));
	   return query.toString(); 
    }
	
	protected static String getAliasConnection(String existingAlias, String childAlias, String childFKAlias) {
		if (childAlias==null)
		   return "";
		return childAlias+"."+childFKAlias+" = "+existingAlias+"."+"hardwareId";
	}
	
	protected static String getAliasKey (String alias) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return "Hardware|"+alias;
	}
	
	protected static String getAliasKeyAlias (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return StringUtils.substringAfter(aliasKey, "|");
	}
	
	protected static String getAliasKeyDomain (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
	  return StringUtils.substringBefore(aliasKey, "|");
	}
	
	protected static String getNextAlias (Hashtable aliasHt, Hardware hardware) {
		int cptSameAlias = 0;
		Enumeration<String> _keys = aliasHt.keys();
		while (_keys.hasMoreElements()) {
			String _key = _keys.nextElement();
			if (_key.startsWith("hardware"))
				cptSameAlias++;
		}
		if (cptSameAlias==0)
			return "hardware";
		else
			return "hardware_"+cptSameAlias;
	}
	
	
	protected static boolean isLookedUp (Hardware hardware) {
	   if (hardware==null)
		  return false;
       if (hardware.getHardwareId() != null) {
	      return true;
       }
       if (hardware.getName() != null) {
	      return true;
       }
       if (hardware.getDescription() != null) {
	      return true;
       }
       if (hardware.getBrand() != null) {
	      return true;
       }
       if (hardware.getColor() != null) {
	      return true;
       }
       if (hardware.getSerialNumber() != null) {
	      return true;
       }
       if (hardware.getRegion() != null) {
	      return true;
       }
       if (hardware.getSubRegionCode() != null) {
	      return true;
       }
       if (hardware.getReleaseDate() != null) {
	      return true;
       }
       if (hardware.getAcquiringDate() != null) {
	      return true;
       }
       if (hardware.getAcquiringPrice() != null) {
	      return true;
       }
       if (hardware.getAcquiredPriceFree() != null) {
	      return true;
       }
       if (hardware.getAcquiredPriceUnknown() != null) {
	      return true;
       }
       if (hardware.getAcquiringSellerName() != null) {
	      return true;
       }
       if (hardware.getAcquiringPlace() != null) {
	      return true;
       }
       if (hardware.getLocation() != null) {
	      return true;
       }
       if (hardware.getHasBox() != null) {
	      return true;
       }
       if (hardware.getHasManual() != null) {
	      return true;
       }
       if (hardware.getHasInserts() != null) {
	      return true;
       }
       if (hardware.getIsSealed() != null) {
	      return true;
       }
       if (hardware.getIsNew() != null) {
	      return true;
       }
       if (hardware.getIsCompleteInBox() != null) {
	      return true;
       }
       if (hardware.getHardwareStateRating() != null) {
	      return true;
       }
       if (hardware.getBoxStateRating() != null) {
	      return true;
       }
       if (hardware.getManualStateRating() != null) {
	      return true;
       }
       if (hardware.getComment() != null) {
	      return true;
       }
       if (hardware.getBarcode() != null) {
	      return true;
       }
       if (hardware.getBrand()!=null) {
	      return true;
	   }  
       if (hardware.getColor()!=null) {
	      return true;
	   }  
       if (hardware.getLocation()!=null) {
	      return true;
	   }  
       if (hardware.getRegion()!=null) {
	      return true;
	   }  
       return false;   
	}
	
    public String getPartialLoadHardwareQuery(
	   Hardware hardware, 
	   Hardware positiveHardware, 
	   Hardware negativeHardware) {
       boolean isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (hardware.getHardwareId() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" hardwareId ");
       }
       if (hardware.getName() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" name ");
       }
       if (hardware.getDescription() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" description ");
       }
       if (hardware.getBrand_() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" brand_ ");
       }
       if (hardware.getColor_() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" color_ ");
       }
       if (hardware.getSerialNumber() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" serialNumber ");
       }
       if (hardware.getRegion_() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" region_ ");
       }
       if (hardware.getSubRegionCode() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" subRegionCode ");
       }
       if (hardware.getReleaseDate() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" releaseDate ");
       }
       if (hardware.getAcquiringDate() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" acquiringDate ");
       }
       if (hardware.getAcquiringPrice() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" acquiringPrice ");
       }
       if (hardware.getAcquiredPriceFree() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" acquiredPriceFree ");
       }
       if (hardware.getAcquiredPriceUnknown() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" acquiredPriceUnknown ");
       }
       if (hardware.getAcquiringSellerName() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" acquiringSellerName ");
       }
       if (hardware.getAcquiringPlace() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" acquiringPlace ");
       }
       if (hardware.getLocation_() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" location_ ");
       }
       if (hardware.getHasBox() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" hasBox ");
       }
       if (hardware.getHasManual() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" hasManual ");
       }
       if (hardware.getHasInserts() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" hasInserts ");
       }
       if (hardware.getIsSealed() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" isSealed ");
       }
       if (hardware.getIsNew() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" isNew ");
       }
       if (hardware.getIsCompleteInBox() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" isCompleteInBox ");
       }
       if (hardware.getHardwareStateRating() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" hardwareStateRating ");
       }
       if (hardware.getBoxStateRating() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" boxStateRating ");
       }
       if (hardware.getManualStateRating() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" manualStateRating ");
       }
       if (hardware.getComment() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" comment ");
       }
       if (hardware.getBarcode() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" barcode ");
       }
	   query.append(getFromEntity());
       query.append(getHardwarePositiveNegativeCriteria (positiveHardware, negativeHardware));
	   return query.toString(); 
    }
	
	public List<Hardware> searchPrototypeWithCacheHardware(Hardware hardware) {
		SimpleCache simpleCache = new SimpleCache();
		List<Hardware> list = (List<Hardware>)simpleCache.get(hardware.toString());
		if (list==null) {
			list = searchPrototypeHardware(hardware);
			simpleCache.put(hardware.toString(), list);
		}
		return list;
	}

    public List<Hardware> loadGraph(Hardware graphMaskWhat, List<Hardware> whereMask) {
        return loadGraphOneLevel(graphMaskWhat, whereMask);
    }

	public List<Hardware> loadGraphOneLevel(Hardware graphMaskWhat, List<Hardware> whereMask) {
		//first get roots element from where list mask
		// this brings the level 0 of the graph (root level)
 		graphMaskWhat.setHardwareId(graphMaskWhat.integerMask__);
		List<Hardware> hardwares = searchPrototypeHardware (whereMask);
		// for each sub level perform the search with a subquery then reassemble
		// 1. get all sublevel queries
		// 2. perform queries on the correct dao
		// 3. reassemble
		return getLoadGraphOneLevel (graphMaskWhat, hardwares);
	}

	private List<Hardware> copy(List<Hardware> inputs) {
		List<Hardware> l = new ArrayList<Hardware>();
		for (Hardware input : inputs) {
			Hardware copy = new Hardware();
			copy.copy(input);
			l.add(copy);
		}
		return l;
	}
	   
	private List<Hardware> getLoadGraphOneLevel (Hardware graphMaskWhat, List<Hardware> parents) {
	    return loadGraphFromParentKey (graphMaskWhat, parents);
	} 
	
	public List<Hardware> loadGraphFromParentKey (Hardware graphMaskWhat, List<Hardware> parents) {
		//foreach children:
		//check if not empty take first
		parents = copy (parents); //working with detached entities to avoid unnecessary sql calls
		if (parents==null || parents.isEmpty())
		   return parents;
		List<String> ids = getPk (parents);
		if (graphMaskWhat.getPhotoHardwareViaHardwareIdFk()!=null && !graphMaskWhat.getPhotoHardwareViaHardwareIdFk().isEmpty()) {
			for (Photo childWhat : graphMaskWhat.getPhotoHardwareViaHardwareIdFk()) {
				childWhat.setHardwareIdFk_(graphMaskWhat.integerMask__); // add to the what mask, usefull for reconciliation
				PhotoJPAImpl photoextendedjpaimpl = new PhotoJPAImpl ();
				List<Photo> children = photoextendedjpaimpl.lookupPhoto(childWhat, getFkCriteria(" hardwareId ", ids), null, getEntityManager());
				reassemblePhoto (children, parents);				
				break;
			}
		}
		return parents;
	}
	
	private void reassemblePhoto (List<Photo> children, List<Hardware> parents) {
		for (Photo child : children) {
			for (Hardware parent : parents) {
				if (parent.getHardwareId()!=null && parent.getHardwareId().toString().equals(child.getHardwareIdFk()+"")) {
					parent.addPhotoHardwareViaHardwareIdFk(child); 
					child.setHardwareIdFk(parent);
					break;
				}
			}
		}
	}
	
	private List<String> getPk(List<Hardware> input) {
		List<String> s = new ArrayList<String>();
		for (Hardware t : input) {
			s.add(t.getHardwareId()+"");
		}
		return s;
	}

	private Criteria getFkCriteria(String field, List<String> ids) {
		Criteria criteria = new Criteria();
		criteria.addCriterion(getInPk(field, ids));
		return criteria;
	}

	private ClauseCriterion getInPk(String field, List<String> ids) {
		InCriterion inCriterion = new InCriterion(field, ids, true);
		return inCriterion;
	}	    

    // generic part
	public void find (QueryData<Hardware> data) {
		EntityCriteria<Hardware> filter = data.getEntityCriteria();
		Hardware entityWhat = data.getEntityWhat();
		Hardware criteriaMask = filter.getEntity();
		int start = data.getStart();
		int max = data.getMax();
		EntitySort<Hardware> entitySort = data.getEntitySort();
		QuerySortOrder sortOrder = entitySort.getOrder();
		Hardware sortMask = entitySort.getEntity();	

		List<Hardware> results = find(entityWhat, criteriaMask, sortMask, filter.getMatchType(), filter.getOperandType(), filter.getCaseSensitivenessType(), sortOrder, start, max);
		data.setResult(results);
		int size = results.size();
		if (size<max) 
			data.setTotalResultCount(Long.valueOf(size));
		else
			data.setTotalResultCount(count(entityWhat, criteriaMask, filter.getMatchType(), filter.getOperandType(), filter.getCaseSensitivenessType()));

	}
	


    public EntityManager getEntityManagerForRecursiveDao() {
		return emForRecursiveDao;
	}

	public void setEntityManagerForRecursiveDao(EntityManager emForRecursiveDao) {
		this.emForRecursiveDao = emForRecursiveDao;
	}
	
    public void setPhotoJPAImpl (PhotoJPAImpl photoextendedjpaimpl) {
       this.photoextendedjpaimpl = photoextendedjpaimpl;
    }
    
    public PhotoJPAImpl getPhotoJPAImpl () {
       return photoextendedjpaimpl;
    }
    

    /**
     * return a list of Hardware entities 
     */
    public List<Hardware> getList () {
        //first lightweight implementation
        return searchPrototypeHardware(new Hardware());
    }
    /**
     * return a list of Hardware entities and sort
     */
    public List<Hardware> getList (Hardware orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(new Hardware(), orderMask, sortOrder, null);
    }
    /**
     * return a list of Hardware entities and sort based on a Hardware prototype
     */
    public List<Hardware> list (Hardware mask, Hardware orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(mask, orderMask, sortOrder, null);
    }

	@Override
    protected String getSelectFrom() {
        return "SELECT hardware "+getFromEntity();
    }

    protected String getFromEntity() {
        return " FROM Hardware hardware ";
    }

    @Override
    protected String getQuerySelectFromEntity() {
        return getSelectFrom();
    }
	



}
