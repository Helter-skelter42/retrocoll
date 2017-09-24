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
	* - time      : 2017/09/16 ap. J.-C. at 19:38:22 CEST
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

import com.retrocoll.server.dao.face.server.AccessorieDao;
import com.retrocoll.server.domain.server.Accessorie;
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
 * <p>Title: AccessorieJPAImpl</p>
 *
 * <p>Description: Interface of a Data access object dealing with AccessorieJPAImpl
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching AccessorieJPAImpl objects</p>
 *
 */


@org.springframework.stereotype.Repository(value="accessorieDao")

public class AccessorieJPAImpl extends ServerGenericDaoJpaImpl<Accessorie> implements AccessorieDao {
	public AccessorieJPAImpl () {}
	
    /**
     * Inserts a Accessorie entity 
     * @param Accessorie accessorie
     */
    public void insertAccessorie(Accessorie accessorie) {
       entityManager.persist(accessorie);
    }

    protected void insertAccessorie(EntityManager emForRecursiveDao, Accessorie accessorie) {
       emForRecursiveDao.persist(accessorie);
    } 

    /**
     * Updates a Accessorie entity 
     * @param Accessorie accessorie
     */
    public Accessorie updateAccessorie(Accessorie accessorie) {
       return entityManager.merge(accessorie);
    }

	/**
     * Updates a Accessorie entity with only the attributes set into Accessorie.
	 * The primary keys are to be set for this method to operate.
	 * This is a performance friendly feature, which remove the udibiquous full load and full update when an
	 * update is issued
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param Accessorie accessorie
    */ 
    @Transactional
    public Integer updateNotNullOnlyAccessorie(Accessorie accessorie) {
        Query jpaQuery = getEntityManager().createQuery(getUpdateNotNullOnlyAccessorieQueryChunk(accessorie));
        if (accessorie.getAccessorieId() != null) {
           jpaQuery.setParameter ("accessorieId", accessorie.getAccessorieId());
        }   
        if (accessorie.getName() != null) {
           jpaQuery.setParameter ("name", accessorie.getName());
        }   
        if (accessorie.getDescription() != null) {
           jpaQuery.setParameter ("description", accessorie.getDescription());
        }   
        if (accessorie.getBrand_() != null) {
           jpaQuery.setParameter ("brand_", accessorie.getBrand_());
        }   
        if (accessorie.getColor_() != null) {
           jpaQuery.setParameter ("color_", accessorie.getColor_());
        }   
        if (accessorie.getSerialNumber() != null) {
           jpaQuery.setParameter ("serialNumber", accessorie.getSerialNumber());
        }   
        if (accessorie.getRegion_() != null) {
           jpaQuery.setParameter ("region_", accessorie.getRegion_());
        }   
        if (accessorie.getSubRegionCode() != null) {
           jpaQuery.setParameter ("subRegionCode", accessorie.getSubRegionCode());
        }   
        if (accessorie.getReleaseDate() != null) {
           jpaQuery.setParameter ("releaseDate", accessorie.getReleaseDate());
        }   
        if (accessorie.getAcquiringDate() != null) {
           jpaQuery.setParameter ("acquiringDate", accessorie.getAcquiringDate());
        }   
        if (accessorie.getAcquiringPrice() != null) {
           jpaQuery.setParameter ("acquiringPrice", accessorie.getAcquiringPrice());
        }   
        if (accessorie.getAcquiredPriceFree() != null) {
           jpaQuery.setParameter ("acquiredPriceFree", accessorie.getAcquiredPriceFree());
        }   
        if (accessorie.getAcquiredPriceUnknown() != null) {
           jpaQuery.setParameter ("acquiredPriceUnknown", accessorie.getAcquiredPriceUnknown());
        }   
        if (accessorie.getAcquiringSellerName() != null) {
           jpaQuery.setParameter ("acquiringSellerName", accessorie.getAcquiringSellerName());
        }   
        if (accessorie.getAcquiringPlace() != null) {
           jpaQuery.setParameter ("acquiringPlace", accessorie.getAcquiringPlace());
        }   
        if (accessorie.getLocation_() != null) {
           jpaQuery.setParameter ("location_", accessorie.getLocation_());
        }   
        if (accessorie.getHasBox() != null) {
           jpaQuery.setParameter ("hasBox", accessorie.getHasBox());
        }   
        if (accessorie.getHasManual() != null) {
           jpaQuery.setParameter ("hasManual", accessorie.getHasManual());
        }   
        if (accessorie.getHasInserts() != null) {
           jpaQuery.setParameter ("hasInserts", accessorie.getHasInserts());
        }   
        if (accessorie.getIsSealed() != null) {
           jpaQuery.setParameter ("isSealed", accessorie.getIsSealed());
        }   
        if (accessorie.getIsNew() != null) {
           jpaQuery.setParameter ("isNew", accessorie.getIsNew());
        }   
        if (accessorie.getIsCompleteInBox() != null) {
           jpaQuery.setParameter ("isCompleteInBox", accessorie.getIsCompleteInBox());
        }   
        if (accessorie.getHardwareStateRating() != null) {
           jpaQuery.setParameter ("hardwareStateRating", accessorie.getHardwareStateRating());
        }   
        if (accessorie.getBoxStateRating() != null) {
           jpaQuery.setParameter ("boxStateRating", accessorie.getBoxStateRating());
        }   
        if (accessorie.getManualStateRating() != null) {
           jpaQuery.setParameter ("manualStateRating", accessorie.getManualStateRating());
        }   
        if (accessorie.getComment() != null) {
           jpaQuery.setParameter ("comment", accessorie.getComment());
        }   
        if (accessorie.getBarcode() != null) {
           jpaQuery.setParameter ("barcode", accessorie.getBarcode());
        }   
		return jpaQuery.executeUpdate();
    }

    protected String getUpdateNotNullOnlyAccessorieQueryChunkPrototype (Accessorie accessorie) {
        boolean isSetSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update Accessorie accessorie ");
        if (accessorie.getName() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.name = :name");
        }
        if (accessorie.getDescription() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.description = :description");
        }
        if (accessorie.getBrand() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.brand = :brand");
        }
        if (accessorie.getColor() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.color = :color");
        }
        if (accessorie.getSerialNumber() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.serialNumber = :serialNumber");
        }
        if (accessorie.getRegion() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.region = :region");
        }
        if (accessorie.getSubRegionCode() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.subRegionCode = :subRegionCode");
        }
        if (accessorie.getReleaseDate() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.releaseDate = :releaseDate");
        }
        if (accessorie.getAcquiringDate() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.acquiringDate = :acquiringDate");
        }
        if (accessorie.getAcquiringPrice() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.acquiringPrice = :acquiringPrice");
        }
        if (accessorie.getAcquiredPriceFree() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.acquiredPriceFree = :acquiredPriceFree");
        }
        if (accessorie.getAcquiredPriceUnknown() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.acquiredPriceUnknown = :acquiredPriceUnknown");
        }
        if (accessorie.getAcquiringSellerName() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.acquiringSellerName = :acquiringSellerName");
        }
        if (accessorie.getAcquiringPlace() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.acquiringPlace = :acquiringPlace");
        }
        if (accessorie.getLocation() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.location = :location");
        }
        if (accessorie.getHasBox() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.hasBox = :hasBox");
        }
        if (accessorie.getHasManual() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.hasManual = :hasManual");
        }
        if (accessorie.getHasInserts() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.hasInserts = :hasInserts");
        }
        if (accessorie.getIsSealed() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.isSealed = :isSealed");
        }
        if (accessorie.getIsNew() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.isNew = :isNew");
        }
        if (accessorie.getIsCompleteInBox() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.isCompleteInBox = :isCompleteInBox");
        }
        if (accessorie.getHardwareStateRating() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.hardwareStateRating = :hardwareStateRating");
        }
        if (accessorie.getBoxStateRating() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.boxStateRating = :boxStateRating");
        }
        if (accessorie.getManualStateRating() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.manualStateRating = :manualStateRating");
        }
        if (accessorie.getComment() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.comment = :comment");
        }
        if (accessorie.getBarcode() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" accessorie.barcode = :barcode");
        }
        if (isSetSet==false)
			throw new IllegalArgumentException("accessorie mask should contain updatable fields");
        return query.toString();
    }
    
    protected String getUpdateNotNullOnlyAccessorieQueryChunk (Accessorie accessorie) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer(getUpdateNotNullOnlyAccessorieQueryChunkPrototype(accessorie));
        if (accessorie.getAccessorieId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
			     query.append(" accessorie.accessorieId = :accessorieId");
        }
        if (isWhereSet==false)
			throw new IllegalArgumentException("accessorie mask should contain primary key");
        return query.toString();
    }
    
                
	protected Accessorie assignBlankToNull (Accessorie accessorie) {
        if (accessorie==null)
			return null;
        if (accessorie.getName()!=null && accessorie.getName().equals(""))
           accessorie.setName((String)null);
        if (accessorie.getDescription()!=null && accessorie.getDescription().equals(""))
           accessorie.setDescription((String)null);
        if (accessorie.getSerialNumber()!=null && accessorie.getSerialNumber().equals(""))
           accessorie.setSerialNumber((String)null);
        if (accessorie.getSubRegionCode()!=null && accessorie.getSubRegionCode().equals(""))
           accessorie.setSubRegionCode((String)null);
        if (accessorie.getAcquiringSellerName()!=null && accessorie.getAcquiringSellerName().equals(""))
           accessorie.setAcquiringSellerName((String)null);
        if (accessorie.getAcquiringPlace()!=null && accessorie.getAcquiringPlace().equals(""))
           accessorie.setAcquiringPlace((String)null);
        if (accessorie.getHasInserts()!=null && accessorie.getHasInserts().equals(""))
           accessorie.setHasInserts((String)null);
        if (accessorie.getComment()!=null && accessorie.getComment().equals(""))
           accessorie.setComment((String)null);
        if (accessorie.getBarcode()!=null && accessorie.getBarcode().equals(""))
           accessorie.setBarcode((String)null);
		return accessorie;
	}
	
	protected boolean isAllNull (Accessorie accessorie) {
	    if (accessorie==null)
			return true;
        if (accessorie.getAccessorieId()!=null) 
            return false;
        if (accessorie.getName()!=null) 
            return false;
        if (accessorie.getDescription()!=null) 
            return false;
        if (accessorie.getBrand()!=null) 
            return false;
        if (accessorie.getColor()!=null) 
            return false;
        if (accessorie.getSerialNumber()!=null) 
            return false;
        if (accessorie.getRegion()!=null) 
            return false;
        if (accessorie.getSubRegionCode()!=null) 
            return false;
        if (accessorie.getReleaseDate()!=null) 
            return false;
        if (accessorie.getAcquiringDate()!=null) 
            return false;
        if (accessorie.getAcquiringPrice()!=null) 
            return false;
        if (accessorie.getAcquiredPriceFree()!=null) 
            return false;
        if (accessorie.getAcquiredPriceUnknown()!=null) 
            return false;
        if (accessorie.getAcquiringSellerName()!=null) 
            return false;
        if (accessorie.getAcquiringPlace()!=null) 
            return false;
        if (accessorie.getLocation()!=null) 
            return false;
        if (accessorie.getHasBox()!=null) 
            return false;
        if (accessorie.getHasManual()!=null) 
            return false;
        if (accessorie.getHasInserts()!=null) 
            return false;
        if (accessorie.getIsSealed()!=null) 
            return false;
        if (accessorie.getIsNew()!=null) 
            return false;
        if (accessorie.getIsCompleteInBox()!=null) 
            return false;
        if (accessorie.getHardwareStateRating()!=null) 
            return false;
        if (accessorie.getBoxStateRating()!=null) 
            return false;
        if (accessorie.getManualStateRating()!=null) 
            return false;
        if (accessorie.getComment()!=null) 
            return false;
        if (accessorie.getBarcode()!=null) 
            return false;
		return true;
	}
		
    @Transactional
    public Integer updateNotNullOnlyPrototypeAccessorie(Accessorie accessorie, Accessorie prototypeCriteria) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update Accessorie accessorie ");
        if (accessorie.getAccessorieId() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.accessorieId = "+ accessorie.getAccessorieId() + " ");
        }
        if (accessorie.getName() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.name = '"+ accessorie.getName()+"' ");
        }
        if (accessorie.getDescription() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.description = '"+ accessorie.getDescription()+"' ");
        }
        if (accessorie.getBrand_() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.brand_ = "+ accessorie.getBrand_() + " ");
        }
        if (accessorie.getColor_() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.color_ = "+ accessorie.getColor_() + " ");
        }
        if (accessorie.getSerialNumber() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.serialNumber = '"+ accessorie.getSerialNumber()+"' ");
        }
        if (accessorie.getRegion_() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.region_ = "+ accessorie.getRegion_() + " ");
        }
        if (accessorie.getSubRegionCode() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.subRegionCode = '"+ accessorie.getSubRegionCode()+"' ");
        }
        if (accessorie.getReleaseDate() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.releaseDate = '"+ accessorie.getReleaseDate()+"' ");
        }
        if (accessorie.getAcquiringDate() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.acquiringDate = '"+ accessorie.getAcquiringDate()+"' ");
        }
        if (accessorie.getAcquiringPrice() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.acquiringPrice = "+ accessorie.getAcquiringPrice() + " ");
        }
        if (accessorie.getAcquiredPriceFree() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.acquiredPriceFree = '"+ accessorie.getAcquiredPriceFree()+"' ");
        }
        if (accessorie.getAcquiredPriceUnknown() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.acquiredPriceUnknown = '"+ accessorie.getAcquiredPriceUnknown()+"' ");
        }
        if (accessorie.getAcquiringSellerName() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.acquiringSellerName = '"+ accessorie.getAcquiringSellerName()+"' ");
        }
        if (accessorie.getAcquiringPlace() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.acquiringPlace = '"+ accessorie.getAcquiringPlace()+"' ");
        }
        if (accessorie.getLocation_() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.location_ = "+ accessorie.getLocation_() + " ");
        }
        if (accessorie.getHasBox() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.hasBox = '"+ accessorie.getHasBox()+"' ");
        }
        if (accessorie.getHasManual() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.hasManual = '"+ accessorie.getHasManual()+"' ");
        }
        if (accessorie.getHasInserts() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.hasInserts = '"+ accessorie.getHasInserts()+"' ");
        }
        if (accessorie.getIsSealed() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.isSealed = '"+ accessorie.getIsSealed()+"' ");
        }
        if (accessorie.getIsNew() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.isNew = '"+ accessorie.getIsNew()+"' ");
        }
        if (accessorie.getIsCompleteInBox() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.isCompleteInBox = '"+ accessorie.getIsCompleteInBox()+"' ");
        }
        if (accessorie.getHardwareStateRating() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.hardwareStateRating = "+ accessorie.getHardwareStateRating() + " ");
        }
        if (accessorie.getBoxStateRating() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.boxStateRating = "+ accessorie.getBoxStateRating() + " ");
        }
        if (accessorie.getManualStateRating() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.manualStateRating = "+ accessorie.getManualStateRating() + " ");
        }
        if (accessorie.getComment() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.comment = '"+ accessorie.getComment()+"' ");
        }
        if (accessorie.getBarcode() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" accessorie.barcode = '"+ accessorie.getBarcode()+"' ");
        }
		isWhereSet = false; 
        if (prototypeCriteria.getAccessorieId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.accessorieId = "+ prototypeCriteria.getAccessorieId() + " ");
        }
        if (prototypeCriteria.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.name = '"+ prototypeCriteria.getName()+"' ");
        }
        if (prototypeCriteria.getDescription() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.description = '"+ prototypeCriteria.getDescription()+"' ");
        }
        if (prototypeCriteria.getBrand_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.brand_ = "+ prototypeCriteria.getBrand_() + " ");
        }
        if (prototypeCriteria.getColor_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.color_ = "+ prototypeCriteria.getColor_() + " ");
        }
        if (prototypeCriteria.getSerialNumber() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.serialNumber = '"+ prototypeCriteria.getSerialNumber()+"' ");
        }
        if (prototypeCriteria.getRegion_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.region_ = "+ prototypeCriteria.getRegion_() + " ");
        }
        if (prototypeCriteria.getSubRegionCode() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.subRegionCode = '"+ prototypeCriteria.getSubRegionCode()+"' ");
        }
        if (prototypeCriteria.getReleaseDate() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.releaseDate = '"+ prototypeCriteria.getReleaseDate()+"' ");
        }
        if (prototypeCriteria.getAcquiringDate() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.acquiringDate = '"+ prototypeCriteria.getAcquiringDate()+"' ");
        }
        if (prototypeCriteria.getAcquiringPrice() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.acquiringPrice = "+ prototypeCriteria.getAcquiringPrice() + " ");
        }
        if (prototypeCriteria.getAcquiredPriceFree() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.acquiredPriceFree = '"+ prototypeCriteria.getAcquiredPriceFree()+"' ");
        }
        if (prototypeCriteria.getAcquiredPriceUnknown() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.acquiredPriceUnknown = '"+ prototypeCriteria.getAcquiredPriceUnknown()+"' ");
        }
        if (prototypeCriteria.getAcquiringSellerName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.acquiringSellerName = '"+ prototypeCriteria.getAcquiringSellerName()+"' ");
        }
        if (prototypeCriteria.getAcquiringPlace() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.acquiringPlace = '"+ prototypeCriteria.getAcquiringPlace()+"' ");
        }
        if (prototypeCriteria.getLocation_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.location_ = "+ prototypeCriteria.getLocation_() + " ");
        }
        if (prototypeCriteria.getHasBox() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.hasBox = '"+ prototypeCriteria.getHasBox()+"' ");
        }
        if (prototypeCriteria.getHasManual() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.hasManual = '"+ prototypeCriteria.getHasManual()+"' ");
        }
        if (prototypeCriteria.getHasInserts() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.hasInserts = '"+ prototypeCriteria.getHasInserts()+"' ");
        }
        if (prototypeCriteria.getIsSealed() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.isSealed = '"+ prototypeCriteria.getIsSealed()+"' ");
        }
        if (prototypeCriteria.getIsNew() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.isNew = '"+ prototypeCriteria.getIsNew()+"' ");
        }
        if (prototypeCriteria.getIsCompleteInBox() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.isCompleteInBox = '"+ prototypeCriteria.getIsCompleteInBox()+"' ");
        }
        if (prototypeCriteria.getHardwareStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.hardwareStateRating = "+ prototypeCriteria.getHardwareStateRating() + " ");
        }
        if (prototypeCriteria.getBoxStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.boxStateRating = "+ prototypeCriteria.getBoxStateRating() + " ");
        }
        if (prototypeCriteria.getManualStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.manualStateRating = "+ prototypeCriteria.getManualStateRating() + " ");
        }
        if (prototypeCriteria.getComment() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.comment = '"+ prototypeCriteria.getComment()+"' ");
        }
        if (prototypeCriteria.getBarcode() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.barcode = '"+ prototypeCriteria.getBarcode()+"' ");
        }
        Query jpaQuery = getEntityManager().createQuery(query.toString());
		return jpaQuery.executeUpdate();
    }
     
     /**
     * Saves a Accessorie entity 
     * @param Accessorie accessorie
     */
    public void saveAccessorie(Accessorie accessorie) {
       //entityManager.persist(accessorie);
       if (entityManager.contains(accessorie)) {
          entityManager.merge(accessorie);
       } else {
          entityManager.persist(accessorie);
       }
       entityManager.flush(); 
    }
       
    /**
     * Deletes a Accessorie entity 
     * @param Accessorie accessorie
     */
    public void deleteAccessorie(Accessorie accessorie) {
      entityManager.remove(accessorie);
    }
    
    /**
     * Loads the Accessorie entity which is related to an instance of
     * Accessorie
     * @param Long id
     * @return Accessorie The Accessorie entity
     
    public Accessorie loadAccessorie(Long id) {
    	return (Accessorie)entityManager.get(Accessorie.class, id);
    }
*/
  
    /**
     * Loads the Accessorie entity which is related to an instance of
     * Accessorie
     * @param java.lang.Integer AccessorieId
     * @return Accessorie The Accessorie entity
     */
    public Accessorie loadAccessorie(java.lang.Integer accessorieId) {
    	return (Accessorie)entityManager.find(Accessorie.class, accessorieId);
    }
    
    /**
     * Loads the Accessorie entity which is related to an instance of
     * Accessorie and its dependent one to many objects
     * @param Long id
     * @return Accessorie The Accessorie entity
     */
    public Accessorie loadFullFirstLevelAccessorie(java.lang.Integer accessorieId) {
        List list = getResultList(
                     "SELECT accessorie FROM Accessorie accessorie "
                     + " LEFT JOIN accessorie.photoAccessorieViaAccessorieIdPk "   
                     + " WHERE accessorie.accessorieId = "+accessorieId
               );
         if (list!=null && !list.isEmpty())
            return (Accessorie)list.get(0);
         return null;
    	//return null;//(Accessorie) entityManager.queryForObject("loadFullFirstLevelAccessorie", id);
    }

    /**
     * Loads the Accessorie entity which is related to an instance of
     * Accessorie
     * @param Accessorie accessorie
     * @return Accessorie The Accessorie entity
     */
    public Accessorie loadFullFirstLevelAccessorie(Accessorie accessorie) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT accessorie FROM Accessorie accessorie ");
        query.append (" LEFT JOIN accessorie.photoAccessorieViaAccessorieIdPk ");
        if (accessorie.getAccessorieId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.accessorieId = "+ accessorie.getAccessorieId() + " ");
         }
        List list = getResultList(query.toString());
        if (list!=null && !list.isEmpty())
           return (Accessorie)list.get(0);    
        return null;
    }  

    /**
     * Searches a list of Accessorie entity 
     * @param Accessorie accessorie
     * @return List
     */  
    public List<Accessorie> searchPrototypeAccessorie(Accessorie accessorie) {
       return searchPrototype (accessorie, null);
    }  
	
    public List<Accessorie> searchPrototypeAnyAccessorie(Accessorie accessorie) {
       return searchPrototypeAny (accessorie, null);
    }  

	// indirection
    public List<Accessorie> find (Accessorie criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
       return find (criteriaMask, matchType, operandType, caseSensitivenessType, null, null); 
	}
	
	// indirection
	protected List<Accessorie> find (Accessorie criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, Integer startPosition, Integer maxResults) {
       return find (criteriaMask, null, matchType, operandType, caseSensitivenessType, null, startPosition, maxResults); 
    }
	
	// indirection
	protected List<Accessorie> find (Accessorie criteriaMask, Accessorie orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
       return find (null, criteriaMask, orderMask, matchType, operandType, caseSensitivenessType, sortOrder, startPosition, maxResults);
    }
	
	// main find implementation
	protected List<Accessorie> find (Accessorie whatMask, Accessorie criteriaMask, Accessorie orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
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
    public String findQuery (Accessorie criteriaMask, Accessorie orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String what = "SELECT accessorie FROM Accessorie accessorie ";
		return findQuery (criteriaMask, orderMask, what, matchType, operandType, caseSensitivenessType, sortOrder);
    }

    protected String findQuery (Accessorie criteriaMask, Accessorie orderMask, String what, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String queryWhere = findWhere (criteriaMask, false, isAll(matchType), operandType, caseSensitivenessType);
		String queryOrder = findOrder (orderMask, sortOrder);
	    return getHQuery(what, queryWhere, queryOrder);
    }
	
    protected List<Accessorie> searchPrototype (Accessorie accessorie, Accessorie orderMask, QuerySortOrder sortOrder, Integer maxResults) {
       return searchPrototype(getAccessorieSelectQuery (getWhereEqualWhereQueryChunk(accessorie), orderMask, sortOrder), maxResults);
    }

    protected List<Accessorie> searchPrototype (Accessorie accessorie, Integer maxResults) {
       return searchPrototype(accessorie, null, null, maxResults);
    }
    
    protected List<Accessorie> searchPrototypeAny (Accessorie accessorie, Integer maxResults) { 
       return searchPrototype(getSearchEqualAnyQuery (accessorie), maxResults);
    }
    
    protected List<Accessorie> searchPrototype (String query, Integer maxResults) { 
       Query hquery = getEntityManager().createQuery(query);
       if (maxResults!=null)
          hquery.setMaxResults(maxResults);
       return hquery.getResultList();
    }

    public List<Accessorie> searchPrototypeAccessorie (List<Accessorie> accessories) {
       return searchPrototype (accessories, null);
    }

    protected List<Accessorie> searchPrototype (List<Accessorie> accessories, Integer maxResults) {    
	   return getResultList(getAccessorieSearchEqualQuery (null, accessories));
	}    

    protected List<Accessorie> getResultList (String query) {    
	   Query hquery = entityManager.createQuery(query);            
	   return hquery.getResultList();
	}    
 

    public List<Accessorie> searchDistinctPrototypeAccessorie (Accessorie accessorieMask, List<Accessorie> accessories) {
        return getResultList(getAccessorieSearchEqualQuery (accessorieMask, accessories));    
    }
        
	/**
     * Searches a list of Accessorie entity 
     * @param Accessorie positiveMask
     * @param Accessorie negativeMask
     * @return List
     */
    public List<Accessorie> searchPrototypeAccessorie(Accessorie positiveMask, Accessorie negativeMask) {
	    return getResultList(getAccessorieSearchEqualQuery (positiveMask, negativeMask));  
    }

    /**
    * return a string query search on a Accessorie prototype
    */
    protected String getAccessorieSelectQuery (String where, Accessorie orderMask, QuerySortOrder sortOrder) {
       return getAccessorieSelectQuery (where, findOrder (orderMask, sortOrder));
    }
    protected String getAccessorieSelectQuery (String where, String order) {
       StringBuffer query = new StringBuffer();
       query.append ("SELECT accessorie FROM Accessorie accessorie ");
       return (order!=null)? getHQuery(query.toString(), where, order):getHQuery(query.toString(), where);
    }
    /**
    * return a jql query search on a Accessorie prototype
    */
    protected String getSearchEqualQuery (Accessorie accessorie) {
       return getAccessorieSelectQuery (getWhereEqualWhereQueryChunk(accessorie),null);
    }
    protected String getWhereEqualWhereQueryChunk (Accessorie accessorie) {
       return getWhereEqualWhereQueryChunk(accessorie, false);
    }
    /**
    * return a jql query search on a Accessorie with any prototype
    */
    protected String getSearchEqualAnyQuery (Accessorie accessorie) {
       return getAccessorieSelectQuery (getWhereEqualAnyWhereQueryChunk(accessorie), null);   
    }
    protected String getWhereEqualAnyWhereQueryChunk (Accessorie accessorie) {
       return getWhereEqualAnyWhereQueryChunk(accessorie, false);   
    }

    /**
    * return a jql search for a list of Accessorie prototype
    */
    protected String getAccessorieSearchEqualQuery (Accessorie accessorieMask, List<Accessorie> accessories) {
        boolean isOrSet = false;
        StringBuffer query = new StringBuffer();
        if (accessorieMask !=null)
           query.append (getAccessorieMaskWhat (accessorieMask));
        query.append (" FROM Accessorie accessorie ");
        StringBuffer queryWhere = new StringBuffer();
        for (Accessorie accessorie : accessories) {
           if (!isAllNull(accessorie)) {        
	           queryWhere.append (getQueryOR (isOrSet));
	           isOrSet = true;
	           queryWhere.append (" ("+getWhereEqualWhereQueryChunk(accessorie, false)+") ");
           }
        }
	    return getHQuery(query.toString(), queryWhere.toString());
    }	

    
    protected String getAccessorieMaskWhat (Accessorie accessorieMask) {
        boolean isCommaSet = false;
        StringBuffer query = new StringBuffer("SELECT DISTINCT ");
        if (accessorieMask.getAccessorieId() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" accessorieId ");
        }
        if (accessorieMask.getName() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" name ");
        }
        if (accessorieMask.getDescription() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" description ");
        }
        if (accessorieMask.getBrand() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" brand ");
        }
        if (accessorieMask.getColor() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" color ");
        }
        if (accessorieMask.getSerialNumber() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" serialNumber ");
        }
        if (accessorieMask.getRegion() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" region ");
        }
        if (accessorieMask.getSubRegionCode() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" subRegionCode ");
        }
        if (accessorieMask.getReleaseDate() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" releaseDate ");
        }
        if (accessorieMask.getAcquiringDate() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" acquiringDate ");
        }
        if (accessorieMask.getAcquiringPrice() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" acquiringPrice ");
        }
        if (accessorieMask.getAcquiredPriceFree() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" acquiredPriceFree ");
        }
        if (accessorieMask.getAcquiredPriceUnknown() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" acquiredPriceUnknown ");
        }
        if (accessorieMask.getAcquiringSellerName() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" acquiringSellerName ");
        }
        if (accessorieMask.getAcquiringPlace() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" acquiringPlace ");
        }
        if (accessorieMask.getLocation() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" location ");
        }
        if (accessorieMask.getHasBox() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" hasBox ");
        }
        if (accessorieMask.getHasManual() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" hasManual ");
        }
        if (accessorieMask.getHasInserts() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" hasInserts ");
        }
        if (accessorieMask.getIsSealed() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" isSealed ");
        }
        if (accessorieMask.getIsNew() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" isNew ");
        }
        if (accessorieMask.getIsCompleteInBox() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" isCompleteInBox ");
        }
        if (accessorieMask.getHardwareStateRating() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" hardwareStateRating ");
        }
        if (accessorieMask.getBoxStateRating() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" boxStateRating ");
        }
        if (accessorieMask.getManualStateRating() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" manualStateRating ");
        }
        if (accessorieMask.getComment() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" comment ");
        }
        if (accessorieMask.getBarcode() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" barcode ");
        }
        if (!isCommaSet)
           return "";
	    return query.toString();
    }
    
    protected String getWhereEqualAnyWhereQueryChunk (Accessorie accessorie, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (accessorie, isAndSet, false);	
	}
	
    protected String getWhereEqualWhereQueryChunk (Accessorie accessorie, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (accessorie, isAndSet, true);
	}
	
    protected String getSearchEqualWhereQueryChunk (Accessorie accessorie, boolean isAndSet, boolean isAll) {
        StringBuffer query = new StringBuffer();
        if (accessorie.getAccessorieId() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.accessorieId = "+ accessorie.getAccessorieId() + " ");
        }
        if (accessorie.getName() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.name = '"+ accessorie.getName()+"' ");
        }
        if (accessorie.getDescription() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.description = '"+ accessorie.getDescription()+"' ");
        }
        if (accessorie.getBrand_() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.brand_ = "+ accessorie.getBrand_() + " ");
        }
        if (accessorie.getColor_() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.color_ = "+ accessorie.getColor_() + " ");
        }
        if (accessorie.getSerialNumber() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.serialNumber = '"+ accessorie.getSerialNumber()+"' ");
        }
        if (accessorie.getRegion_() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.region_ = "+ accessorie.getRegion_() + " ");
        }
        if (accessorie.getSubRegionCode() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.subRegionCode = '"+ accessorie.getSubRegionCode()+"' ");
        }
        if (accessorie.getReleaseDate() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.releaseDate = '"+ accessorie.getReleaseDate()+"' ");
        }
        if (accessorie.getAcquiringDate() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.acquiringDate = '"+ accessorie.getAcquiringDate()+"' ");
        }
        if (accessorie.getAcquiringPrice() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.acquiringPrice = "+ accessorie.getAcquiringPrice() + " ");
        }
        if (accessorie.getAcquiredPriceFree() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.acquiredPriceFree = '"+ accessorie.getAcquiredPriceFree()+"' ");
        }
        if (accessorie.getAcquiredPriceUnknown() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.acquiredPriceUnknown = '"+ accessorie.getAcquiredPriceUnknown()+"' ");
        }
        if (accessorie.getAcquiringSellerName() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.acquiringSellerName = '"+ accessorie.getAcquiringSellerName()+"' ");
        }
        if (accessorie.getAcquiringPlace() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.acquiringPlace = '"+ accessorie.getAcquiringPlace()+"' ");
        }
        if (accessorie.getLocation_() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.location_ = "+ accessorie.getLocation_() + " ");
        }
        if (accessorie.getHasBox() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.hasBox = '"+ accessorie.getHasBox()+"' ");
        }
        if (accessorie.getHasManual() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.hasManual = '"+ accessorie.getHasManual()+"' ");
        }
        if (accessorie.getHasInserts() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.hasInserts = '"+ accessorie.getHasInserts()+"' ");
        }
        if (accessorie.getIsSealed() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.isSealed = '"+ accessorie.getIsSealed()+"' ");
        }
        if (accessorie.getIsNew() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.isNew = '"+ accessorie.getIsNew()+"' ");
        }
        if (accessorie.getIsCompleteInBox() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.isCompleteInBox = '"+ accessorie.getIsCompleteInBox()+"' ");
        }
        if (accessorie.getHardwareStateRating() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.hardwareStateRating = "+ accessorie.getHardwareStateRating() + " ");
        }
        if (accessorie.getBoxStateRating() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.boxStateRating = "+ accessorie.getBoxStateRating() + " ");
        }
        if (accessorie.getManualStateRating() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.manualStateRating = "+ accessorie.getManualStateRating() + " ");
        }
        if (accessorie.getComment() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.comment = '"+ accessorie.getComment()+"' ");
        }
        if (accessorie.getBarcode() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" accessorie.barcode = '"+ accessorie.getBarcode()+"' ");
        }
	    return query.toString();
    }

    protected String findOrder (Accessorie orderMask, QuerySortOrder sortOrder) {
        if (orderMask!=null) {
            String orderColumn = getFirstNotNullColumnOtherWiseNull(orderMask);
            if (orderColumn!=null)
               return orderColumn + " " + sortOrder;
        }
        return "";
    }

	@Override
    protected String findWhere (Accessorie accessorie, boolean isAndSet, boolean isAll, OperandType operandType, Boolean caseSensitive) {
		return findWhere (null, accessorie, isAndSet, isAll, operandType, caseSensitive);
	}
	
	protected static String findWhere (String alias, Accessorie accessorie, boolean isAndSet, boolean isAll, OperandType operandType, boolean caseSensitive) {
        if (alias==null)
			alias = "accessorie";
		StringBuffer query = new StringBuffer();
		String operand = getOperand (operandType);
		String evaluatorPrefix = getEvaluatorPrefix (operandType);		
		String evaluatorSuffix = getEvaluatorSuffix (operandType);		
        if (accessorie.getAccessorieId() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".accessorieId = "+ accessorie.getAccessorieId() + " ");
        }
        if (accessorie.getName() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = accessorie.getName();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".name) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".name "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (accessorie.getDescription() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".description = '"+ accessorie.getDescription()+"' ");
        }
        if (accessorie.getBrand_() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".brand_ = "+ accessorie.getBrand_() + " ");
        }
        if (accessorie.getColor_() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".color_ = "+ accessorie.getColor_() + " ");
        }
        if (accessorie.getSerialNumber() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = accessorie.getSerialNumber();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".serialNumber) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".serialNumber "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (accessorie.getRegion_() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".region_ = "+ accessorie.getRegion_() + " ");
        }
        if (accessorie.getSubRegionCode() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = accessorie.getSubRegionCode();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".subRegionCode) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".subRegionCode "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (accessorie.getReleaseDate() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".releaseDate = '"+ accessorie.getReleaseDate()+"' ");
        }
        if (accessorie.getAcquiringDate() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".acquiringDate = '"+ accessorie.getAcquiringDate()+"' ");
        }
        if (accessorie.getAcquiringPrice() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".acquiringPrice = "+ accessorie.getAcquiringPrice() + " ");
        }
        if (accessorie.getAcquiredPriceFree() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".acquiredPriceFree = '"+ accessorie.getAcquiredPriceFree()+"' ");
        }
        if (accessorie.getAcquiredPriceUnknown() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".acquiredPriceUnknown = '"+ accessorie.getAcquiredPriceUnknown()+"' ");
        }
        if (accessorie.getAcquiringSellerName() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = accessorie.getAcquiringSellerName();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".acquiringSellerName) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".acquiringSellerName "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (accessorie.getAcquiringPlace() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = accessorie.getAcquiringPlace();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".acquiringPlace) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".acquiringPlace "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (accessorie.getLocation_() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".location_ = "+ accessorie.getLocation_() + " ");
        }
        if (accessorie.getHasBox() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".hasBox = '"+ accessorie.getHasBox()+"' ");
        }
        if (accessorie.getHasManual() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".hasManual = '"+ accessorie.getHasManual()+"' ");
        }
        if (accessorie.getHasInserts() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = accessorie.getHasInserts();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".hasInserts) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".hasInserts "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (accessorie.getIsSealed() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".isSealed = '"+ accessorie.getIsSealed()+"' ");
        }
        if (accessorie.getIsNew() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".isNew = '"+ accessorie.getIsNew()+"' ");
        }
        if (accessorie.getIsCompleteInBox() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".isCompleteInBox = '"+ accessorie.getIsCompleteInBox()+"' ");
        }
        if (accessorie.getHardwareStateRating() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".hardwareStateRating = "+ accessorie.getHardwareStateRating() + " ");
        }
        if (accessorie.getBoxStateRating() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".boxStateRating = "+ accessorie.getBoxStateRating() + " ");
        }
        if (accessorie.getManualStateRating() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".manualStateRating = "+ accessorie.getManualStateRating() + " ");
        }
        if (accessorie.getComment() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = accessorie.getComment();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".comment) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".comment "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (accessorie.getBarcode() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".barcode = '"+ accessorie.getBarcode()+"' ");
        }
        return query.toString();
    }
	
	protected String getFirstNotNullColumnOtherWiseNull (Accessorie mask) {
        if (mask == null) return null;
        if (mask.getAccessorieId() != null) return "accessorieId";
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
    * return a jql search on a Accessorie prototype with positive and negative beans
    */
    protected String getAccessorieSearchEqualQuery (Accessorie positiveMask, Accessorie negativeMask) {
		StringBuffer query = new StringBuffer();    	
		query.append(getSelectFrom());
		query.append(getAccessoriePositiveNegativeCriteria(positiveMask, negativeMask));
		return query.toString();
	}

	protected String getAccessoriePositiveNegativeCriteria (Accessorie positiveMask, Accessorie negativeMask) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        if (positiveMask!=null && positiveMask.getAccessorieId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.accessorieId = "+ positiveMask.getAccessorieId() + " ");
        } 
		if (negativeMask!=null && negativeMask.getAccessorieId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.accessorieId is null ");
        }
        if (positiveMask!=null && positiveMask.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.name = '"+ positiveMask.getName()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.name is null ");
        }
        if (positiveMask!=null && positiveMask.getDescription() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.description = '"+ positiveMask.getDescription()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getDescription() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.description is null ");
        }
        if (positiveMask!=null && positiveMask.getBrand_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.brand_ = "+ positiveMask.getBrand_() + " ");
        } 
		if (negativeMask!=null && negativeMask.getBrand_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.brand_ is null ");
        }
        if (positiveMask!=null && positiveMask.getColor_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.color_ = "+ positiveMask.getColor_() + " ");
        } 
		if (negativeMask!=null && negativeMask.getColor_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.color_ is null ");
        }
        if (positiveMask!=null && positiveMask.getSerialNumber() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.serialNumber = '"+ positiveMask.getSerialNumber()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getSerialNumber() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.serialNumber is null ");
        }
        if (positiveMask!=null && positiveMask.getRegion_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.region_ = "+ positiveMask.getRegion_() + " ");
        } 
		if (negativeMask!=null && negativeMask.getRegion_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.region_ is null ");
        }
        if (positiveMask!=null && positiveMask.getSubRegionCode() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.subRegionCode = '"+ positiveMask.getSubRegionCode()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getSubRegionCode() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.subRegionCode is null ");
        }
        if (positiveMask!=null && positiveMask.getReleaseDate() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.releaseDate = '"+ positiveMask.getReleaseDate()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getReleaseDate() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.releaseDate is null ");
        }
        if (positiveMask!=null && positiveMask.getAcquiringDate() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.acquiringDate = '"+ positiveMask.getAcquiringDate()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getAcquiringDate() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.acquiringDate is null ");
        }
        if (positiveMask!=null && positiveMask.getAcquiringPrice() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.acquiringPrice = "+ positiveMask.getAcquiringPrice() + " ");
        } 
		if (negativeMask!=null && negativeMask.getAcquiringPrice() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.acquiringPrice is null ");
        }
        if (positiveMask!=null && positiveMask.getAcquiredPriceFree() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.acquiredPriceFree = '"+ positiveMask.getAcquiredPriceFree()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getAcquiredPriceFree() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.acquiredPriceFree is null ");
        }
        if (positiveMask!=null && positiveMask.getAcquiredPriceUnknown() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.acquiredPriceUnknown = '"+ positiveMask.getAcquiredPriceUnknown()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getAcquiredPriceUnknown() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.acquiredPriceUnknown is null ");
        }
        if (positiveMask!=null && positiveMask.getAcquiringSellerName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.acquiringSellerName = '"+ positiveMask.getAcquiringSellerName()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getAcquiringSellerName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.acquiringSellerName is null ");
        }
        if (positiveMask!=null && positiveMask.getAcquiringPlace() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.acquiringPlace = '"+ positiveMask.getAcquiringPlace()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getAcquiringPlace() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.acquiringPlace is null ");
        }
        if (positiveMask!=null && positiveMask.getLocation_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.location_ = "+ positiveMask.getLocation_() + " ");
        } 
		if (negativeMask!=null && negativeMask.getLocation_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.location_ is null ");
        }
        if (positiveMask!=null && positiveMask.getHasBox() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.hasBox = '"+ positiveMask.getHasBox()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getHasBox() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.hasBox is null ");
        }
        if (positiveMask!=null && positiveMask.getHasManual() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.hasManual = '"+ positiveMask.getHasManual()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getHasManual() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.hasManual is null ");
        }
        if (positiveMask!=null && positiveMask.getHasInserts() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.hasInserts = '"+ positiveMask.getHasInserts()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getHasInserts() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.hasInserts is null ");
        }
        if (positiveMask!=null && positiveMask.getIsSealed() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.isSealed = '"+ positiveMask.getIsSealed()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getIsSealed() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.isSealed is null ");
        }
        if (positiveMask!=null && positiveMask.getIsNew() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.isNew = '"+ positiveMask.getIsNew()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getIsNew() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.isNew is null ");
        }
        if (positiveMask!=null && positiveMask.getIsCompleteInBox() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.isCompleteInBox = '"+ positiveMask.getIsCompleteInBox()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getIsCompleteInBox() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.isCompleteInBox is null ");
        }
        if (positiveMask!=null && positiveMask.getHardwareStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.hardwareStateRating = "+ positiveMask.getHardwareStateRating() + " ");
        } 
		if (negativeMask!=null && negativeMask.getHardwareStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.hardwareStateRating is null ");
        }
        if (positiveMask!=null && positiveMask.getBoxStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.boxStateRating = "+ positiveMask.getBoxStateRating() + " ");
        } 
		if (negativeMask!=null && negativeMask.getBoxStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.boxStateRating is null ");
        }
        if (positiveMask!=null && positiveMask.getManualStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.manualStateRating = "+ positiveMask.getManualStateRating() + " ");
        } 
		if (negativeMask!=null && negativeMask.getManualStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.manualStateRating is null ");
        }
        if (positiveMask!=null && positiveMask.getComment() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.comment = '"+ positiveMask.getComment()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getComment() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.comment is null ");
        }
        if (positiveMask!=null && positiveMask.getBarcode() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" accessorie.barcode = '"+ positiveMask.getBarcode()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getBarcode() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" accessorie.barcode is null ");
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
    public AccessorieJPAImpl (EntityManager emForRecursiveDao) {
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
     * Inserts a Accessorie entity with cascade of its children
     * @param Accessorie accessorie
     */
    public void insertAccessorieWithCascade(Accessorie accessorie) {
    	AccessorieJPAImpl accessoriejpaimpl = new AccessorieJPAImpl(getEntityManager());
    	accessoriejpaimpl.insertAccessorieWithCascade(accessoriejpaimpl.getEntityManagerForRecursiveDao(), accessorie);
    }
     
    public void insertAccessorieWithCascade(EntityManager emForRecursiveDao, Accessorie accessorie) {
       insertAccessorie(emForRecursiveDao, accessorie);
       if (!accessorie.getPhotoAccessorieViaAccessorieIdPk().isEmpty()) {
          PhotoJPAImpl photoextendedjpaimpl = new PhotoJPAImpl (emForRecursiveDao);
          for (Photo _photoAccessorieViaAccessorieIdPk : accessorie.getPhotoAccessorieViaAccessorieIdPk()) {
             photoextendedjpaimpl.insertPhotoWithCascade(emForRecursiveDao, _photoAccessorieViaAccessorieIdPk);
          }
       } 
    }
        
    /**
     * Inserts a list of Accessorie entity with cascade of its children
     * @param List<Accessorie> accessories
     */
    public void insertAccessoriesWithCascade(List<Accessorie> accessories) {
       for (Accessorie accessorie : accessories) {
          insertAccessorieWithCascade(accessorie);
       }
    } 
        
    /**
     * lookup Accessorie entity Accessorie, criteria and max result number
     */
    public List<Accessorie> lookupAccessorie(Accessorie accessorie, Criteria criteria, Integer numberOfResult, EntityManager em) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT accessorie FROM Accessorie accessorie ");
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
    
    public List<Accessorie> lookupAccessorie(Accessorie accessorie, Criteria criteria, Integer numberOfResult) {
		return lookupAccessorie(accessorie, criteria, numberOfResult, getEntityManager());
    }

    public Integer updateNotNullOnlyAccessorie (Accessorie accessorie, Criteria criteria) {
        String queryWhat = getUpdateNotNullOnlyAccessorieQueryChunkPrototype (accessorie);
        StringBuffer query = new StringBuffer (queryWhat);
        boolean isWhereSet = false;
        for (Criterion criterion : criteria.getClauseCriterions()) {
            query.append (getQueryWHERE_AND (isWhereSet));
            isWhereSet = true;   
            query.append(criterion.getExpression());			
        }  
        Query jpaQuery = getEntityManager().createQuery(query.toString());
        isWhereSet = false;
        if (accessorie.getAccessorieId() != null) {
           jpaQuery.setParameter ("accessorieId", accessorie.getAccessorieId());
        }   
        if (accessorie.getName() != null) {
           jpaQuery.setParameter ("name", accessorie.getName());
        }   
        if (accessorie.getDescription() != null) {
           jpaQuery.setParameter ("description", accessorie.getDescription());
        }   
        if (accessorie.getBrand() != null) {
           jpaQuery.setParameter ("brand", accessorie.getBrand());
        }   
        if (accessorie.getColor() != null) {
           jpaQuery.setParameter ("color", accessorie.getColor());
        }   
        if (accessorie.getSerialNumber() != null) {
           jpaQuery.setParameter ("serialNumber", accessorie.getSerialNumber());
        }   
        if (accessorie.getRegion() != null) {
           jpaQuery.setParameter ("region", accessorie.getRegion());
        }   
        if (accessorie.getSubRegionCode() != null) {
           jpaQuery.setParameter ("subRegionCode", accessorie.getSubRegionCode());
        }   
        if (accessorie.getReleaseDate() != null) {
           jpaQuery.setParameter ("releaseDate", accessorie.getReleaseDate());
        }   
        if (accessorie.getAcquiringDate() != null) {
           jpaQuery.setParameter ("acquiringDate", accessorie.getAcquiringDate());
        }   
        if (accessorie.getAcquiringPrice() != null) {
           jpaQuery.setParameter ("acquiringPrice", accessorie.getAcquiringPrice());
        }   
        if (accessorie.getAcquiredPriceFree() != null) {
           jpaQuery.setParameter ("acquiredPriceFree", accessorie.getAcquiredPriceFree());
        }   
        if (accessorie.getAcquiredPriceUnknown() != null) {
           jpaQuery.setParameter ("acquiredPriceUnknown", accessorie.getAcquiredPriceUnknown());
        }   
        if (accessorie.getAcquiringSellerName() != null) {
           jpaQuery.setParameter ("acquiringSellerName", accessorie.getAcquiringSellerName());
        }   
        if (accessorie.getAcquiringPlace() != null) {
           jpaQuery.setParameter ("acquiringPlace", accessorie.getAcquiringPlace());
        }   
        if (accessorie.getLocation() != null) {
           jpaQuery.setParameter ("location", accessorie.getLocation());
        }   
        if (accessorie.getHasBox() != null) {
           jpaQuery.setParameter ("hasBox", accessorie.getHasBox());
        }   
        if (accessorie.getHasManual() != null) {
           jpaQuery.setParameter ("hasManual", accessorie.getHasManual());
        }   
        if (accessorie.getHasInserts() != null) {
           jpaQuery.setParameter ("hasInserts", accessorie.getHasInserts());
        }   
        if (accessorie.getIsSealed() != null) {
           jpaQuery.setParameter ("isSealed", accessorie.getIsSealed());
        }   
        if (accessorie.getIsNew() != null) {
           jpaQuery.setParameter ("isNew", accessorie.getIsNew());
        }   
        if (accessorie.getIsCompleteInBox() != null) {
           jpaQuery.setParameter ("isCompleteInBox", accessorie.getIsCompleteInBox());
        }   
        if (accessorie.getHardwareStateRating() != null) {
           jpaQuery.setParameter ("hardwareStateRating", accessorie.getHardwareStateRating());
        }   
        if (accessorie.getBoxStateRating() != null) {
           jpaQuery.setParameter ("boxStateRating", accessorie.getBoxStateRating());
        }   
        if (accessorie.getManualStateRating() != null) {
           jpaQuery.setParameter ("manualStateRating", accessorie.getManualStateRating());
        }   
        if (accessorie.getComment() != null) {
           jpaQuery.setParameter ("comment", accessorie.getComment());
        }   
        if (accessorie.getBarcode() != null) {
           jpaQuery.setParameter ("barcode", accessorie.getBarcode());
        }   
		return jpaQuery.executeUpdate();
    }
	
	public Accessorie affectAccessorie (Accessorie accessorie) {
	    return referAccessorie (accessorie, null, false);		    
	}
		
	/**
	 * Assign the first accessorie retrieved corresponding to the accessorie criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no accessorie corresponding in the database. Then accessorie is inserted and returned with its primary key(s). 
	 */
	public Accessorie assignAccessorie (Accessorie accessorie) {
		return referAccessorie (accessorie, null, true);
	}

	/**
	 * Assign the first accessorie retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no accessorie corresponding in the database. 
	 * Then accessorie is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public Accessorie assignAccessorie (Accessorie accessorie, Accessorie mask) {
		return referAccessorie (accessorie, mask, true);
	}

	public Accessorie referAccessorie (Accessorie accessorie, Accessorie mask, boolean isAssign) {
		accessorie = assignBlankToNull (accessorie);
		if (isAllNull(accessorie))
			return null;
		else {
			List<Accessorie> list;
			if (mask==null)
				list = searchPrototypeAccessorie(accessorie);
			else
				list = searchPrototypeAccessorie(mask);
			if (list.isEmpty()) {
			    if (isAssign)
			       insertAccessorie(accessorie);
			    else
				   return null;
			}
			else if (list.size()==1)
				accessorie.copy(list.get(0));
			else 
				//TODO log error
				accessorie.copy(list.get(0));
		}
		return accessorie;		    
	}

   public Accessorie assignAccessorieUseCache (Accessorie accessorie) {
      return referAccessorieUseCache (accessorie, true);
   }
      		
   public Accessorie affectAccessorieUseCache (Accessorie accessorie) {
      return referAccessorieUseCache (accessorie, false);
   }
      		
   public Accessorie referAccessorieUseCache (Accessorie accessorie, boolean isAssign) {
	  String key = getCacheKey(null, accessorie, null, "assignAccessorie");
      Accessorie accessorieCache = (Accessorie)simpleCache.get(key);
      if (accessorieCache==null) {
         accessorieCache = referAccessorie (accessorie, null, isAssign);
         if (key!=null)
         	simpleCache.put(key, accessorieCache);
      }
      accessorie.copy(accessorieCache);
      return accessorieCache;
   }	

	private String getCacheKey (Accessorie accessorieWhat, Accessorie positiveAccessorie, Accessorie negativeAccessorie, String queryKey) {
	    StringBuffer sb = new StringBuffer();
	    sb.append(queryKey);
	    if (accessorieWhat!=null)
	       sb.append(accessorieWhat.toStringWithParents());
	    if (positiveAccessorie!=null)
	       sb.append(positiveAccessorie.toStringWithParents());
	    if (negativeAccessorie!=null)
	       sb.append(negativeAccessorie.toStringWithParents());
	    return sb.toString();
	}
	
    public Accessorie partialLoadWithParentFirstAccessorie(Accessorie accessorieWhat, Accessorie positiveAccessorie, Accessorie negativeAccessorie){
		List <Accessorie> list = partialLoadWithParentAccessorie(accessorieWhat, positiveAccessorie, negativeAccessorie);
		return (!list.isEmpty())?(Accessorie)list.get(0):null;
    }
    
    public Accessorie partialLoadWithParentFirstAccessorieUseCache(Accessorie accessorieWhat, Accessorie positiveAccessorie, Accessorie negativeAccessorie, Boolean useCache){
		List <Accessorie> list = partialLoadWithParentAccessorieUseCache(accessorieWhat, positiveAccessorie, negativeAccessorie, useCache);
		return (!list.isEmpty())?(Accessorie)list.get(0):null;
    }
	
	public Accessorie partialLoadWithParentFirstAccessorieUseCacheOnResult(Accessorie accessorieWhat, Accessorie positiveAccessorie, Accessorie negativeAccessorie, Boolean useCache){
		List <Accessorie> list = partialLoadWithParentAccessorieUseCacheOnResult(accessorieWhat, positiveAccessorie, negativeAccessorie, useCache);
		return (!list.isEmpty())?(Accessorie)list.get(0):null;
    }
	//
	protected List<Accessorie> partialLoadWithParentAccessorie(Accessorie accessorieWhat, Accessorie positiveAccessorie, Accessorie negativeAccessorie, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentAccessorie(accessorieWhat, positiveAccessorie, negativeAccessorie, new QuerySelectInit(), nbOfResult, useCache);
	}	  

	protected List partialLoadWithParentAccessorieQueryResult (Accessorie accessorieWhat, Accessorie positiveAccessorie, Accessorie negativeAccessorie, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentAccessorieQueryResult (accessorieWhat, positiveAccessorie, negativeAccessorie, new QuerySelectInit(), nbOfResult, useCache);
	}	
    
    public List<Accessorie> getDistinctAccessorie(Accessorie accessorieWhat, Accessorie positiveAccessorie, Accessorie negativeAccessorie) {
		 return partialLoadWithParentAccessorie(accessorieWhat, positiveAccessorie, negativeAccessorie, new QuerySelectDistinctInit(), null, false);
	}
	
	public List<Accessorie> partialLoadWithParentAccessorie(Accessorie accessorieWhat, Accessorie positiveAccessorie, Accessorie negativeAccessorie) {
		 return partialLoadWithParentAccessorie(accessorieWhat, positiveAccessorie, negativeAccessorie, new QuerySelectInit(), null, false);
	}	
  
	public List<Accessorie> partialLoadWithParentAccessorieUseCacheOnResult(Accessorie accessorieWhat, Accessorie positiveAccessorie, Accessorie negativeAccessorie, Boolean useCache) {
		String key = getCacheKey(accessorieWhat, positiveAccessorie, negativeAccessorie, "partialLoadWithParentAccessorie");
		List<Accessorie> list = (List<Accessorie>)simpleCache.get(key);
		if (list==null || list.isEmpty()) {
			list = partialLoadWithParentAccessorie(accessorieWhat, positiveAccessorie, negativeAccessorie);
			if (!list.isEmpty())
			   simpleCache.put(key, list);
		}
		return list;	
	}	

	public List<Accessorie> partialLoadWithParentAccessorieUseCache(Accessorie accessorieWhat, Accessorie positiveAccessorie, Accessorie negativeAccessorie, Boolean useCache) {
		String key = getCacheKey(accessorieWhat, positiveAccessorie, negativeAccessorie, "partialLoadWithParentAccessorie");
		List<Accessorie> list = (List<Accessorie>)simpleCache.get(key);
		if (list==null) {
			list = partialLoadWithParentAccessorie(accessorieWhat, positiveAccessorie, negativeAccessorie);
			simpleCache.put(key, list);
		}
		return list;	
	}	
	
	private List<Accessorie> handleLoadWithParentAccessorie(Map beanPath, List list, Accessorie accessorieWhat) {
	    return handleLoadWithParentAccessorie(beanPath, list, accessorieWhat, true);  
	}
	
	private List<Accessorie> handleLoadWithParentAccessorie(Map beanPath, List list, Accessorie accessorieWhat, boolean isHql) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentAccessorieWithOneElementInRow(list, beanPath, accessorieWhat, isHql);
		}
		return handlePartialLoadWithParentAccessorie(list, beanPath, accessorieWhat, isHql);	
	}
	
    	// to set in super class	
	protected void populateAccessorie (Accessorie accessorie, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(accessorie, beanPath, value);
	}
	
	protected void populateAccessorieFromSQL (Accessorie accessorie, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(accessorie, beanPath, value);
	}
    	// to set in super class BEWARE: genericity is only one level!!!!! first level is a copy second level is a reference!!! change to accessorie.clone() instead
	private Accessorie cloneAccessorie (Accessorie accessorie) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		//return (Accessorie) BeanUtils.cloneBeanObject(accessorie);
	   if (accessorie==null) return new Accessorie();
	   return accessorie.clone();
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
	
    public List<Accessorie> countDistinct (Accessorie whatMask, Accessorie whereEqCriteria) {
       return partialLoadWithParentAccessorie(whatMask, whereEqCriteria, null, new QuerySelectCountInit("accessorie"), null, false);
    }   
  	
    public Long count(Accessorie whereEqCriteria) {
	    return count(null, whereEqCriteria, EntityMatchType.ALL, OperandType.EQUALS, true); 
/*        Query query = getEntityManager().createQuery(getSelectCountPrototype(whereEqCriteria));
        List<Long> list = query.getResultList();
    	if (!list.isEmpty()) {
            return list.get(0);
    	}
    	return 0L;
*/
    }


    public Long count(Accessorie whatMask, Accessorie whereCriteria, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
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

	protected String countQuery (Accessorie accessorie, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
        String what = "SELECT count(*) FROM Accessorie accessorie ";
		return findQuery (accessorie, null, what, matchType, operandType, caseSensitivenessType, null);
    }
	

   private List getFirstResultWhereConditionsAre (Accessorie accessorie) {
      return partialLoadWithParentAccessorieQueryResult(getDefaultAccessorieWhat(), accessorie, null, 1, false);	
   }
   
   protected Accessorie getDefaultAccessorieWhat() {
      Accessorie accessorie = new Accessorie();
      accessorie.setAccessorieId(Integer.valueOf(-1));
      return accessorie;
   }
   
	public Accessorie getFirstAccessorie (Accessorie accessorie) {
		if (isAllNull(accessorie))
			return null;
		else {
			List<Accessorie> list = searchPrototype (accessorie, 1);
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
    * checks if the Accessorie entity exists
    */           
    public boolean existsAccessorie (Accessorie accessorie) {
       if (getFirstAccessorie(accessorie)!=null)
          return true;
       return false;  
    }
        
    public boolean existsAccessorieWhereConditionsAre (Accessorie accessorie) {
       if (getFirstResultWhereConditionsAre (accessorie).isEmpty())
          return false;
       return true;  
    }

	private int countPartialField (Accessorie accessorie) {
	   int cpt = 0;
       if (accessorie.getAccessorieId() != null) {
          cpt++;
       }
       if (accessorie.getName() != null) {
          cpt++;
       }
       if (accessorie.getDescription() != null) {
          cpt++;
       }
       if (accessorie.getBrand_() != null) {
          cpt++;
       }
       if (accessorie.getColor_() != null) {
          cpt++;
       }
       if (accessorie.getSerialNumber() != null) {
          cpt++;
       }
       if (accessorie.getRegion_() != null) {
          cpt++;
       }
       if (accessorie.getSubRegionCode() != null) {
          cpt++;
       }
       if (accessorie.getReleaseDate() != null) {
          cpt++;
       }
       if (accessorie.getAcquiringDate() != null) {
          cpt++;
       }
       if (accessorie.getAcquiringPrice() != null) {
          cpt++;
       }
       if (accessorie.getAcquiredPriceFree() != null) {
          cpt++;
       }
       if (accessorie.getAcquiredPriceUnknown() != null) {
          cpt++;
       }
       if (accessorie.getAcquiringSellerName() != null) {
          cpt++;
       }
       if (accessorie.getAcquiringPlace() != null) {
          cpt++;
       }
       if (accessorie.getLocation_() != null) {
          cpt++;
       }
       if (accessorie.getHasBox() != null) {
          cpt++;
       }
       if (accessorie.getHasManual() != null) {
          cpt++;
       }
       if (accessorie.getHasInserts() != null) {
          cpt++;
       }
       if (accessorie.getIsSealed() != null) {
          cpt++;
       }
       if (accessorie.getIsNew() != null) {
          cpt++;
       }
       if (accessorie.getIsCompleteInBox() != null) {
          cpt++;
       }
       if (accessorie.getHardwareStateRating() != null) {
          cpt++;
       }
       if (accessorie.getBoxStateRating() != null) {
          cpt++;
       }
       if (accessorie.getManualStateRating() != null) {
          cpt++;
       }
       if (accessorie.getComment() != null) {
          cpt++;
       }
       if (accessorie.getBarcode() != null) {
          cpt++;
       }
       return cpt;
	}   

	public List<Accessorie> partialLoadWithParentAccessorie(Accessorie what, Accessorie positiveAccessorie, Accessorie negativeAccessorie, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		Map beanPath = new Hashtable();
		List list = partialLoadWithParentAccessorieJPAQueryResult (what, positiveAccessorie, negativeAccessorie, queryWhatInit, beanPath, nbOfResult, useCache);
		return handlePartialLoadWithParentResult(what, list, beanPath);
	}
	
	public List<Accessorie> handlePartialLoadWithParentResult(Accessorie what, List list, Map beanPath) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentAccessorieWithOneElementInRow(list, beanPath, what, true);
		}
		return handlePartialLoadWithParentAccessorie(list, beanPath, what, true);
	}	

	private List partialLoadWithParentAccessorieQueryResult(Accessorie accessorieWhat, Accessorie positiveAccessorie, Accessorie negativeAccessorie, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		return partialLoadWithParentAccessorieJPAQueryResult (accessorieWhat, positiveAccessorie, negativeAccessorie, queryWhatInit, new Hashtable(), nbOfResult, useCache);
    }	
  
	private List partialLoadWithParentAccessorieJPAQueryResult(Accessorie accessorieWhat, Accessorie positiveAccessorie, Accessorie negativeAccessorie, QueryWhatInit queryWhatInit, Map beanPath, Integer nbOfResult, Boolean useCache) {
		Query hquery = getPartialLoadWithParentJPAQuery (accessorieWhat, positiveAccessorie, negativeAccessorie, beanPath, queryWhatInit, nbOfResult);
		return hquery.getResultList();
    }	
   /**
    * @returns an JPA Hsql query based on entity Accessorie and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPAQuery (Accessorie accessorieWhat, Accessorie positiveAccessorie, Accessorie negativeAccessorie, Map beanPath, QueryWhatInit queryWhatInit, Integer nbOfResult) {
	   Query query = getPartialLoadWithParentJPARawQuery (accessorieWhat, positiveAccessorie, negativeAccessorie, beanPath, queryWhatInit);
	   if (nbOfResult!=null)
	      query.setMaxResults(nbOfResult);
	   return query;
    }
  	
   /**
    * @returns an JPA Raw Hsql query based on entity Accessorie and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPARawQuery (Accessorie accessorieWhat, Accessorie positiveAccessorie, Accessorie negativeAccessorie, Map beanPath, QueryWhatInit queryWhatInit) {
	   return getEntityManager().createQuery(getPartialLoadWithParentRawHsqlQuery (accessorieWhat, positiveAccessorie, negativeAccessorie, beanPath, queryWhatInit));
    }
	
	private List<Accessorie> handlePartialLoadWithParentAccessorie(List<Object[]> list, Map<Integer, String> beanPath, Accessorie accessorieWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentAccessorie(list, beanPath, accessorieWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentAccessorie, message:"+ex.getMessage());
			return new ArrayList<Accessorie>();
		}
    }

	private List<Accessorie> handlePartialLoadWithParentAccessorieWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, Accessorie accessorieWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentAccessorieWithOneElementInRow(list, beanPath, accessorieWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentAccessorieWithOneElementInRow, message:"+ex.getMessage());
			return new ArrayList<Accessorie>();
		}
    }
    	
	 private List<Accessorie> convertPartialLoadWithParentAccessorie(List<Object[]> list, Map<Integer, String> beanPath, Accessorie accessorieWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<Accessorie> resultList = new ArrayList<Accessorie>();
		 for (Object[] row : list) {		
		    Accessorie accessorie = cloneAccessorie (accessorieWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populateAccessorie (accessorie, row[(Integer)entry.getKey()], (String)entry.getValue());
		    }
		    resultList.add(accessorie);
		 }
		 return resultList;		
	 }	
    
	 private List<Accessorie> convertPartialLoadWithParentAccessorieWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, Accessorie accessorieWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<Accessorie> resultList = new ArrayList<Accessorie>();
		 for (Object row : list) {		
		    Accessorie accessorie = cloneAccessorie (accessorieWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populateAccessorie (accessorie, row, (String)entry.getValue());
		    }
		    resultList.add(accessorie);
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
	public String getPartialLoadWithParentRawHsqlQuery (Accessorie accessorie, Accessorie positiveAccessorie, Accessorie negativeAccessorie, Map beanPath, QueryWhatInit queryWhatInit) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentAccessorieQuery (accessorie, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
		Hashtable aliasWhereHt = new Hashtable();
		String where = getPartialLoadWithParentWhereQuery (positiveAccessorie, null, aliasWhatHt, aliasWhereHt, null, null);
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
	public String findPartialLoadWithParentRawHsqlQuery (Accessorie whatMask, Accessorie criteriaMask, Map beanPath, QueryWhatInit queryWhatInit,  Accessorie orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentAccessorieQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
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
	public String countPartialLoadWithParentRawHsqlQuery (Accessorie whatMask, Accessorie criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
		Map beanPath = new Hashtable();
		Hashtable aliasWhatHt = new Hashtable();
		// used to initiate the how part of the what
		getPartialLoadWithParentAccessorieQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", new QuerySelectInit());
		String what = "select count(accessorie) ";
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
    	
	public String findPartialQuery (Accessorie whatMask, Accessorie criteriaMask, Accessorie orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Map beanPath) {
        QueryWhatInit queryWhatInit = new QuerySelectInit();
        return findPartialLoadWithParentRawHsqlQuery(whatMask, criteriaMask, beanPath, queryWhatInit, orderMask, matchType, operandType, caseSensitivenessType,  sortOrder);
    }
	
	/**
    * partial on a single entity load enables to specify the fields you want to load explicitly
    */         
	public List<Accessorie> partialLoadAccessorie(Accessorie accessorie, Accessorie positiveAccessorie, Accessorie negativeAccessorie) {
	    Query hquery = getEntityManager().createQuery(getPartialLoadAccessorieQuery (accessorie, positiveAccessorie, negativeAccessorie));
		int countPartialField = countPartialField(accessorie);
		if (countPartialField==0) 
			return new ArrayList<Accessorie>();
		List list = hquery.getResultList();
		Iterator iter = list.iterator();
		List<Accessorie> returnList = new ArrayList<Accessorie>();
		while(iter.hasNext()) {
			int index = 0;
			Object[] row;
			if (countPartialField==1) {
				row = new Object[1];
				row[0] = iter.next();
				} 
			else 
				row = (Object[]) iter.next();
			Accessorie accessorieResult = new Accessorie();
			if (accessorie.getAccessorieId() != null) {
                accessorieResult.setAccessorieId((Integer) row[index]);
				index++;
			}
			if (accessorie.getName() != null) {
                accessorieResult.setName((String) row[index]);
				index++;
			}
			if (accessorie.getDescription() != null) {
                accessorieResult.setDescription((String) row[index]);
				index++;
			}
			if (accessorie.getBrand_() != null) {
                accessorieResult.setBrand_((Integer) row[index]);
				index++;
			}
			if (accessorie.getColor_() != null) {
                accessorieResult.setColor_((Integer) row[index]);
				index++;
			}
			if (accessorie.getSerialNumber() != null) {
                accessorieResult.setSerialNumber((String) row[index]);
				index++;
			}
			if (accessorie.getRegion_() != null) {
                accessorieResult.setRegion_((Integer) row[index]);
				index++;
			}
			if (accessorie.getSubRegionCode() != null) {
                accessorieResult.setSubRegionCode((String) row[index]);
				index++;
			}
			if (accessorie.getReleaseDate() != null) {
                accessorieResult.setReleaseDate((java.util.Date) row[index]);
				index++;
			}
			if (accessorie.getAcquiringDate() != null) {
                accessorieResult.setAcquiringDate((java.util.Date) row[index]);
				index++;
			}
			if (accessorie.getAcquiringPrice() != null) {
                accessorieResult.setAcquiringPrice((java.math.BigDecimal) row[index]);
				index++;
			}
			if (accessorie.getAcquiredPriceFree() != null) {
                accessorieResult.setAcquiredPriceFree((Boolean) row[index]);
				index++;
			}
			if (accessorie.getAcquiredPriceUnknown() != null) {
                accessorieResult.setAcquiredPriceUnknown((Boolean) row[index]);
				index++;
			}
			if (accessorie.getAcquiringSellerName() != null) {
                accessorieResult.setAcquiringSellerName((String) row[index]);
				index++;
			}
			if (accessorie.getAcquiringPlace() != null) {
                accessorieResult.setAcquiringPlace((String) row[index]);
				index++;
			}
			if (accessorie.getLocation_() != null) {
                accessorieResult.setLocation_((Integer) row[index]);
				index++;
			}
			if (accessorie.getHasBox() != null) {
                accessorieResult.setHasBox((Boolean) row[index]);
				index++;
			}
			if (accessorie.getHasManual() != null) {
                accessorieResult.setHasManual((Boolean) row[index]);
				index++;
			}
			if (accessorie.getHasInserts() != null) {
                accessorieResult.setHasInserts((String) row[index]);
				index++;
			}
			if (accessorie.getIsSealed() != null) {
                accessorieResult.setIsSealed((Boolean) row[index]);
				index++;
			}
			if (accessorie.getIsNew() != null) {
                accessorieResult.setIsNew((Boolean) row[index]);
				index++;
			}
			if (accessorie.getIsCompleteInBox() != null) {
                accessorieResult.setIsCompleteInBox((Boolean) row[index]);
				index++;
			}
			if (accessorie.getHardwareStateRating() != null) {
                accessorieResult.setHardwareStateRating((Integer) row[index]);
				index++;
			}
			if (accessorie.getBoxStateRating() != null) {
                accessorieResult.setBoxStateRating((Integer) row[index]);
				index++;
			}
			if (accessorie.getManualStateRating() != null) {
                accessorieResult.setManualStateRating((Integer) row[index]);
				index++;
			}
			if (accessorie.getComment() != null) {
                accessorieResult.setComment((String) row[index]);
				index++;
			}
			if (accessorie.getBarcode() != null) {
                accessorieResult.setBarcode((String) row[index]);
				index++;
			}
			returnList.add(accessorieResult);
        }
	    return returnList;
	}

	public static String getPartialLoadWithParentWhereQuery (
	   Accessorie criteriaMask, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias,
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
	   Accessorie accessorie, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias) {
	   if (accessorie==null)
	      return "";
	   String alias = null;
	   if (aliasWhereHt == null) {
	      aliasWhereHt = new Hashtable();
	   } 
	   if (isLookedUp(accessorie)){
	      alias = getNextAlias (aliasWhereHt, accessorie);
		  aliasWhereHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (accessorie.getAccessorieId() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".accessorieId = "+ accessorie.getAccessorieId() + " ");
       }
       if (accessorie.getName() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".name = '"+ accessorie.getName()+"' ");
       }
       if (accessorie.getDescription() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".description = '"+ accessorie.getDescription()+"' ");
       }
       if (accessorie.getBrand() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".brand = "+ accessorie.getBrand() + " ");
       }
       if (accessorie.getColor() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".color = "+ accessorie.getColor() + " ");
       }
       if (accessorie.getSerialNumber() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".serialNumber = '"+ accessorie.getSerialNumber()+"' ");
       }
       if (accessorie.getRegion() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".region = "+ accessorie.getRegion() + " ");
       }
       if (accessorie.getSubRegionCode() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".subRegionCode = '"+ accessorie.getSubRegionCode()+"' ");
       }
       if (accessorie.getReleaseDate() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".releaseDate = '"+ accessorie.getReleaseDate()+"' ");
       }
       if (accessorie.getAcquiringDate() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".acquiringDate = '"+ accessorie.getAcquiringDate()+"' ");
       }
       if (accessorie.getAcquiringPrice() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".acquiringPrice = "+ accessorie.getAcquiringPrice() + " ");
       }
       if (accessorie.getAcquiredPriceFree() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".acquiredPriceFree = '"+ accessorie.getAcquiredPriceFree()+"' ");
       }
       if (accessorie.getAcquiredPriceUnknown() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".acquiredPriceUnknown = '"+ accessorie.getAcquiredPriceUnknown()+"' ");
       }
       if (accessorie.getAcquiringSellerName() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".acquiringSellerName = '"+ accessorie.getAcquiringSellerName()+"' ");
       }
       if (accessorie.getAcquiringPlace() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".acquiringPlace = '"+ accessorie.getAcquiringPlace()+"' ");
       }
       if (accessorie.getLocation() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".location = "+ accessorie.getLocation() + " ");
       }
       if (accessorie.getHasBox() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".hasBox = '"+ accessorie.getHasBox()+"' ");
       }
       if (accessorie.getHasManual() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".hasManual = '"+ accessorie.getHasManual()+"' ");
       }
       if (accessorie.getHasInserts() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".hasInserts = '"+ accessorie.getHasInserts()+"' ");
       }
       if (accessorie.getIsSealed() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".isSealed = '"+ accessorie.getIsSealed()+"' ");
       }
       if (accessorie.getIsNew() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".isNew = '"+ accessorie.getIsNew()+"' ");
       }
       if (accessorie.getIsCompleteInBox() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".isCompleteInBox = '"+ accessorie.getIsCompleteInBox()+"' ");
       }
       if (accessorie.getHardwareStateRating() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".hardwareStateRating = "+ accessorie.getHardwareStateRating() + " ");
       }
       if (accessorie.getBoxStateRating() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".boxStateRating = "+ accessorie.getBoxStateRating() + " ");
       }
       if (accessorie.getManualStateRating() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".manualStateRating = "+ accessorie.getManualStateRating() + " ");
       }
       if (accessorie.getComment() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".comment = '"+ accessorie.getComment()+"' ");
       }
       if (accessorie.getBarcode() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".barcode = '"+ accessorie.getBarcode()+"' ");
       }
       if (accessorie.getBrand()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ProducerJPAImpl.getPartialLoadWithParentWhereQuery(
		      accessorie.getBrand(), 
			  isWhereSet, aliasHt, aliasWhereHt, alias, "brand");
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  }  	  
	   }
       if (accessorie.getColor()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl.getPartialLoadWithParentWhereQuery(
		      accessorie.getColor(), 
			  isWhereSet, aliasHt, aliasWhereHt, alias, "color");
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  }  	  
	   }
       if (accessorie.getLocation()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.LocationJPAImpl.getPartialLoadWithParentWhereQuery(
		      accessorie.getLocation(), 
			  isWhereSet, aliasHt, aliasWhereHt, alias, "location");
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  }  	  
	   }
       if (accessorie.getRegion()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl.getPartialLoadWithParentWhereQuery(
		      accessorie.getRegion(), 
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
	
    public static String getPartialLoadWithParentAccessorieQuery (
	   Accessorie accessorie, Boolean isWhereSet, Hashtable aliasHt, String childAlias, String childFKAlias, Map beanPath, String rootPath, QueryWhatInit queryWhatInit) {
	   if (accessorie==null)
	      return "";
	   String alias = null;
	   if (aliasHt == null) {
	      aliasHt = new Hashtable();
	   } 
	   if (isLookedUp(accessorie)){
	      alias = getNextAlias (aliasHt, accessorie);
		  aliasHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (accessorie.getAccessorieId() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"accessorieId");
          query.append(" "+alias+".accessorieId ");
       }
       if (accessorie.getName() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"name");
          query.append(" "+alias+".name ");
       }
       if (accessorie.getDescription() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"description");
          query.append(" "+alias+".description ");
       }
       if (accessorie.getBrand() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"brand");
          query.append(" "+alias+".brand ");
       }
       if (accessorie.getColor() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"color");
          query.append(" "+alias+".color ");
       }
       if (accessorie.getSerialNumber() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"serialNumber");
          query.append(" "+alias+".serialNumber ");
       }
       if (accessorie.getRegion() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"region");
          query.append(" "+alias+".region ");
       }
       if (accessorie.getSubRegionCode() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"subRegionCode");
          query.append(" "+alias+".subRegionCode ");
       }
       if (accessorie.getReleaseDate() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"releaseDate");
          query.append(" "+alias+".releaseDate ");
       }
       if (accessorie.getAcquiringDate() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"acquiringDate");
          query.append(" "+alias+".acquiringDate ");
       }
       if (accessorie.getAcquiringPrice() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"acquiringPrice");
          query.append(" "+alias+".acquiringPrice ");
       }
       if (accessorie.getAcquiredPriceFree() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"acquiredPriceFree");
          query.append(" "+alias+".acquiredPriceFree ");
       }
       if (accessorie.getAcquiredPriceUnknown() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"acquiredPriceUnknown");
          query.append(" "+alias+".acquiredPriceUnknown ");
       }
       if (accessorie.getAcquiringSellerName() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"acquiringSellerName");
          query.append(" "+alias+".acquiringSellerName ");
       }
       if (accessorie.getAcquiringPlace() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"acquiringPlace");
          query.append(" "+alias+".acquiringPlace ");
       }
       if (accessorie.getLocation() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"location");
          query.append(" "+alias+".location ");
       }
       if (accessorie.getHasBox() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"hasBox");
          query.append(" "+alias+".hasBox ");
       }
       if (accessorie.getHasManual() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"hasManual");
          query.append(" "+alias+".hasManual ");
       }
       if (accessorie.getHasInserts() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"hasInserts");
          query.append(" "+alias+".hasInserts ");
       }
       if (accessorie.getIsSealed() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"isSealed");
          query.append(" "+alias+".isSealed ");
       }
       if (accessorie.getIsNew() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"isNew");
          query.append(" "+alias+".isNew ");
       }
       if (accessorie.getIsCompleteInBox() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"isCompleteInBox");
          query.append(" "+alias+".isCompleteInBox ");
       }
       if (accessorie.getHardwareStateRating() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"hardwareStateRating");
          query.append(" "+alias+".hardwareStateRating ");
       }
       if (accessorie.getBoxStateRating() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"boxStateRating");
          query.append(" "+alias+".boxStateRating ");
       }
       if (accessorie.getManualStateRating() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"manualStateRating");
          query.append(" "+alias+".manualStateRating ");
       }
       if (accessorie.getComment() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"comment");
          query.append(" "+alias+".comment ");
       }
       if (accessorie.getBarcode() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"barcode");
          query.append(" "+alias+".barcode ");
       }
       if (accessorie.getBrand()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ProducerJPAImpl.getPartialLoadWithParentProducerQuery(
		      accessorie.getBrand(), 
			  isWhereSet, aliasHt, alias, "brand", beanPath, rootPath+"brand.", queryWhatInit);
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  } 
	   }  
       if (accessorie.getColor()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl.getPartialLoadWithParentValueListQuery(
		      accessorie.getColor(), 
			  isWhereSet, aliasHt, alias, "color", beanPath, rootPath+"color.", queryWhatInit);
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  } 
	   }  
       if (accessorie.getLocation()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.LocationJPAImpl.getPartialLoadWithParentLocationQuery(
		      accessorie.getLocation(), 
			  isWhereSet, aliasHt, alias, "location", beanPath, rootPath+"location.", queryWhatInit);
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  } 
	   }  
       if (accessorie.getRegion()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl.getPartialLoadWithParentValueListQuery(
		      accessorie.getRegion(), 
			  isWhereSet, aliasHt, alias, "region", beanPath, rootPath+"region.", queryWhatInit);
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  } 
	   }  
//       query.append(getAccessorieSearchEqualQuery (positiveAccessorie, negativeAccessorie));
	   return query.toString(); 
    }
	
	protected static String getAliasConnection(String existingAlias, String childAlias, String childFKAlias) {
		if (childAlias==null)
		   return "";
		return childAlias+"."+childFKAlias+" = "+existingAlias+"."+"accessorieId";
	}
	
	protected static String getAliasKey (String alias) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return "Accessorie|"+alias;
	}
	
	protected static String getAliasKeyAlias (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return StringUtils.substringAfter(aliasKey, "|");
	}
	
	protected static String getAliasKeyDomain (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
	  return StringUtils.substringBefore(aliasKey, "|");
	}
	
	protected static String getNextAlias (Hashtable aliasHt, Accessorie accessorie) {
		int cptSameAlias = 0;
		Enumeration<String> _keys = aliasHt.keys();
		while (_keys.hasMoreElements()) {
			String _key = _keys.nextElement();
			if (_key.startsWith("accessorie"))
				cptSameAlias++;
		}
		if (cptSameAlias==0)
			return "accessorie";
		else
			return "accessorie_"+cptSameAlias;
	}
	
	
	protected static boolean isLookedUp (Accessorie accessorie) {
	   if (accessorie==null)
		  return false;
       if (accessorie.getAccessorieId() != null) {
	      return true;
       }
       if (accessorie.getName() != null) {
	      return true;
       }
       if (accessorie.getDescription() != null) {
	      return true;
       }
       if (accessorie.getBrand() != null) {
	      return true;
       }
       if (accessorie.getColor() != null) {
	      return true;
       }
       if (accessorie.getSerialNumber() != null) {
	      return true;
       }
       if (accessorie.getRegion() != null) {
	      return true;
       }
       if (accessorie.getSubRegionCode() != null) {
	      return true;
       }
       if (accessorie.getReleaseDate() != null) {
	      return true;
       }
       if (accessorie.getAcquiringDate() != null) {
	      return true;
       }
       if (accessorie.getAcquiringPrice() != null) {
	      return true;
       }
       if (accessorie.getAcquiredPriceFree() != null) {
	      return true;
       }
       if (accessorie.getAcquiredPriceUnknown() != null) {
	      return true;
       }
       if (accessorie.getAcquiringSellerName() != null) {
	      return true;
       }
       if (accessorie.getAcquiringPlace() != null) {
	      return true;
       }
       if (accessorie.getLocation() != null) {
	      return true;
       }
       if (accessorie.getHasBox() != null) {
	      return true;
       }
       if (accessorie.getHasManual() != null) {
	      return true;
       }
       if (accessorie.getHasInserts() != null) {
	      return true;
       }
       if (accessorie.getIsSealed() != null) {
	      return true;
       }
       if (accessorie.getIsNew() != null) {
	      return true;
       }
       if (accessorie.getIsCompleteInBox() != null) {
	      return true;
       }
       if (accessorie.getHardwareStateRating() != null) {
	      return true;
       }
       if (accessorie.getBoxStateRating() != null) {
	      return true;
       }
       if (accessorie.getManualStateRating() != null) {
	      return true;
       }
       if (accessorie.getComment() != null) {
	      return true;
       }
       if (accessorie.getBarcode() != null) {
	      return true;
       }
       if (accessorie.getBrand()!=null) {
	      return true;
	   }  
       if (accessorie.getColor()!=null) {
	      return true;
	   }  
       if (accessorie.getLocation()!=null) {
	      return true;
	   }  
       if (accessorie.getRegion()!=null) {
	      return true;
	   }  
       return false;   
	}
	
    public String getPartialLoadAccessorieQuery(
	   Accessorie accessorie, 
	   Accessorie positiveAccessorie, 
	   Accessorie negativeAccessorie) {
       boolean isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (accessorie.getAccessorieId() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" accessorieId ");
       }
       if (accessorie.getName() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" name ");
       }
       if (accessorie.getDescription() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" description ");
       }
       if (accessorie.getBrand_() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" brand_ ");
       }
       if (accessorie.getColor_() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" color_ ");
       }
       if (accessorie.getSerialNumber() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" serialNumber ");
       }
       if (accessorie.getRegion_() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" region_ ");
       }
       if (accessorie.getSubRegionCode() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" subRegionCode ");
       }
       if (accessorie.getReleaseDate() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" releaseDate ");
       }
       if (accessorie.getAcquiringDate() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" acquiringDate ");
       }
       if (accessorie.getAcquiringPrice() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" acquiringPrice ");
       }
       if (accessorie.getAcquiredPriceFree() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" acquiredPriceFree ");
       }
       if (accessorie.getAcquiredPriceUnknown() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" acquiredPriceUnknown ");
       }
       if (accessorie.getAcquiringSellerName() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" acquiringSellerName ");
       }
       if (accessorie.getAcquiringPlace() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" acquiringPlace ");
       }
       if (accessorie.getLocation_() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" location_ ");
       }
       if (accessorie.getHasBox() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" hasBox ");
       }
       if (accessorie.getHasManual() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" hasManual ");
       }
       if (accessorie.getHasInserts() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" hasInserts ");
       }
       if (accessorie.getIsSealed() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" isSealed ");
       }
       if (accessorie.getIsNew() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" isNew ");
       }
       if (accessorie.getIsCompleteInBox() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" isCompleteInBox ");
       }
       if (accessorie.getHardwareStateRating() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" hardwareStateRating ");
       }
       if (accessorie.getBoxStateRating() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" boxStateRating ");
       }
       if (accessorie.getManualStateRating() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" manualStateRating ");
       }
       if (accessorie.getComment() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" comment ");
       }
       if (accessorie.getBarcode() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" barcode ");
       }
	   query.append(getFromEntity());
       query.append(getAccessoriePositiveNegativeCriteria (positiveAccessorie, negativeAccessorie));
	   return query.toString(); 
    }
	
	public List<Accessorie> searchPrototypeWithCacheAccessorie(Accessorie accessorie) {
		SimpleCache simpleCache = new SimpleCache();
		List<Accessorie> list = (List<Accessorie>)simpleCache.get(accessorie.toString());
		if (list==null) {
			list = searchPrototypeAccessorie(accessorie);
			simpleCache.put(accessorie.toString(), list);
		}
		return list;
	}

    public List<Accessorie> loadGraph(Accessorie graphMaskWhat, List<Accessorie> whereMask) {
        return loadGraphOneLevel(graphMaskWhat, whereMask);
    }

	public List<Accessorie> loadGraphOneLevel(Accessorie graphMaskWhat, List<Accessorie> whereMask) {
		//first get roots element from where list mask
		// this brings the level 0 of the graph (root level)
 		graphMaskWhat.setAccessorieId(graphMaskWhat.integerMask__);
		List<Accessorie> accessories = searchPrototypeAccessorie (whereMask);
		// for each sub level perform the search with a subquery then reassemble
		// 1. get all sublevel queries
		// 2. perform queries on the correct dao
		// 3. reassemble
		return getLoadGraphOneLevel (graphMaskWhat, accessories);
	}

	private List<Accessorie> copy(List<Accessorie> inputs) {
		List<Accessorie> l = new ArrayList<Accessorie>();
		for (Accessorie input : inputs) {
			Accessorie copy = new Accessorie();
			copy.copy(input);
			l.add(copy);
		}
		return l;
	}
	   
	private List<Accessorie> getLoadGraphOneLevel (Accessorie graphMaskWhat, List<Accessorie> parents) {
	    return loadGraphFromParentKey (graphMaskWhat, parents);
	} 
	
	public List<Accessorie> loadGraphFromParentKey (Accessorie graphMaskWhat, List<Accessorie> parents) {
		//foreach children:
		//check if not empty take first
		parents = copy (parents); //working with detached entities to avoid unnecessary sql calls
		if (parents==null || parents.isEmpty())
		   return parents;
		List<String> ids = getPk (parents);
		if (graphMaskWhat.getPhotoAccessorieViaAccessorieIdPk()!=null && !graphMaskWhat.getPhotoAccessorieViaAccessorieIdPk().isEmpty()) {
			for (Photo childWhat : graphMaskWhat.getPhotoAccessorieViaAccessorieIdPk()) {
				childWhat.setAccessorieIdPk_(graphMaskWhat.integerMask__); // add to the what mask, usefull for reconciliation
				PhotoJPAImpl photoextendedjpaimpl = new PhotoJPAImpl ();
				List<Photo> children = photoextendedjpaimpl.lookupPhoto(childWhat, getFkCriteria(" accessorieId ", ids), null, getEntityManager());
				reassemblePhoto (children, parents);				
				break;
			}
		}
		return parents;
	}
	
	private void reassemblePhoto (List<Photo> children, List<Accessorie> parents) {
		for (Photo child : children) {
			for (Accessorie parent : parents) {
				if (parent.getAccessorieId()!=null && parent.getAccessorieId().toString().equals(child.getAccessorieIdPk()+"")) {
					parent.addPhotoAccessorieViaAccessorieIdPk(child); 
					child.setAccessorieIdPk(parent);
					break;
				}
			}
		}
	}
	
	private List<String> getPk(List<Accessorie> input) {
		List<String> s = new ArrayList<String>();
		for (Accessorie t : input) {
			s.add(t.getAccessorieId()+"");
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
	public void find (QueryData<Accessorie> data) {
		EntityCriteria<Accessorie> filter = data.getEntityCriteria();
		Accessorie entityWhat = data.getEntityWhat();
		Accessorie criteriaMask = filter.getEntity();
		int start = data.getStart();
		int max = data.getMax();
		EntitySort<Accessorie> entitySort = data.getEntitySort();
		QuerySortOrder sortOrder = entitySort.getOrder();
		Accessorie sortMask = entitySort.getEntity();	

		List<Accessorie> results = find(entityWhat, criteriaMask, sortMask, filter.getMatchType(), filter.getOperandType(), filter.getCaseSensitivenessType(), sortOrder, start, max);
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
     * return a list of Accessorie entities 
     */
    public List<Accessorie> getList () {
        //first lightweight implementation
        return searchPrototypeAccessorie(new Accessorie());
    }
    /**
     * return a list of Accessorie entities and sort
     */
    public List<Accessorie> getList (Accessorie orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(new Accessorie(), orderMask, sortOrder, null);
    }
    /**
     * return a list of Accessorie entities and sort based on a Accessorie prototype
     */
    public List<Accessorie> list (Accessorie mask, Accessorie orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(mask, orderMask, sortOrder, null);
    }

	@Override
    protected String getSelectFrom() {
        return "SELECT accessorie "+getFromEntity();
    }

    protected String getFromEntity() {
        return " FROM Accessorie accessorie ";
    }

    @Override
    protected String getQuerySelectFromEntity() {
        return getSelectFrom();
    }
	



}
