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

import com.retrocoll.server.dao.face.server.SoftwareDao;
import com.retrocoll.server.domain.server.Software;
import com.retrocoll.server.domain.server.ValueList;
import com.retrocoll.server.domain.server.Location;
import com.retrocoll.server.domain.server.Producer;
import com.retrocoll.server.domain.server.Producer;
import com.retrocoll.server.domain.server.ValueList;
import com.retrocoll.server.domain.server.ValueList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.retrocoll.server.dao.impl.ServerGenericDaoJpaImpl;


import com.retrocoll.server.domain.server.Photo;
import com.retrocoll.server.dao.impl.jpa.server.PhotoJPAImpl;
import com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl;
import com.retrocoll.server.dao.impl.jpa.server.LocationJPAImpl;
import com.retrocoll.server.dao.impl.jpa.server.ProducerJPAImpl;
import com.retrocoll.server.dao.impl.jpa.server.ProducerJPAImpl;
import com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl;
import com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl;
/**
 *
 * <p>Title: SoftwareJPAImpl</p>
 *
 * <p>Description: Interface of a Data access object dealing with SoftwareJPAImpl
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching SoftwareJPAImpl objects</p>
 *
 */


@org.springframework.stereotype.Repository(value="softwareDao")

public class SoftwareJPAImpl extends ServerGenericDaoJpaImpl<Software> implements SoftwareDao {
	public SoftwareJPAImpl () {}
	
    /**
     * Inserts a Software entity 
     * @param Software software
     */
    public void insertSoftware(Software software) {
       entityManager.persist(software);
    }

    protected void insertSoftware(EntityManager emForRecursiveDao, Software software) {
       emForRecursiveDao.persist(software);
    } 

    /**
     * Updates a Software entity 
     * @param Software software
     */
    public Software updateSoftware(Software software) {
       return entityManager.merge(software);
    }

	/**
     * Updates a Software entity with only the attributes set into Software.
	 * The primary keys are to be set for this method to operate.
	 * This is a performance friendly feature, which remove the udibiquous full load and full update when an
	 * update is issued
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param Software software
    */ 
    @Transactional
    public Integer updateNotNullOnlySoftware(Software software) {
        Query jpaQuery = getEntityManager().createQuery(getUpdateNotNullOnlySoftwareQueryChunk(software));
        if (software.getSoftwareId() != null) {
           jpaQuery.setParameter ("softwareId", software.getSoftwareId());
        }   
        if (software.getDevelopper_() != null) {
           jpaQuery.setParameter ("developper_", software.getDevelopper_());
        }   
        if (software.getEditor_() != null) {
           jpaQuery.setParameter ("editor_", software.getEditor_());
        }   
        if (software.getName() != null) {
           jpaQuery.setParameter ("name", software.getName());
        }   
        if (software.getDescription() != null) {
           jpaQuery.setParameter ("description", software.getDescription());
        }   
        if (software.getConsole_() != null) {
           jpaQuery.setParameter ("console_", software.getConsole_());
        }   
        if (software.getStyle_() != null) {
           jpaQuery.setParameter ("style_", software.getStyle_());
        }   
        if (software.getSerialNumber() != null) {
           jpaQuery.setParameter ("serialNumber", software.getSerialNumber());
        }   
        if (software.getRegion_() != null) {
           jpaQuery.setParameter ("region_", software.getRegion_());
        }   
        if (software.getSubRegionCode() != null) {
           jpaQuery.setParameter ("subRegionCode", software.getSubRegionCode());
        }   
        if (software.getReleaseDate() != null) {
           jpaQuery.setParameter ("releaseDate", software.getReleaseDate());
        }   
        if (software.getAcquiringDate() != null) {
           jpaQuery.setParameter ("acquiringDate", software.getAcquiringDate());
        }   
        if (software.getAcquiringPrice() != null) {
           jpaQuery.setParameter ("acquiringPrice", software.getAcquiringPrice());
        }   
        if (software.getAcquiredPriceFree() != null) {
           jpaQuery.setParameter ("acquiredPriceFree", software.getAcquiredPriceFree());
        }   
        if (software.getAcquiredPriceUnknown() != null) {
           jpaQuery.setParameter ("acquiredPriceUnknown", software.getAcquiredPriceUnknown());
        }   
        if (software.getAcquiringSellerName() != null) {
           jpaQuery.setParameter ("acquiringSellerName", software.getAcquiringSellerName());
        }   
        if (software.getAcquiringPlace() != null) {
           jpaQuery.setParameter ("acquiringPlace", software.getAcquiringPlace());
        }   
        if (software.getLocation_() != null) {
           jpaQuery.setParameter ("location_", software.getLocation_());
        }   
        if (software.getHasBox() != null) {
           jpaQuery.setParameter ("hasBox", software.getHasBox());
        }   
        if (software.getHasManual() != null) {
           jpaQuery.setParameter ("hasManual", software.getHasManual());
        }   
        if (software.getHasInserts() != null) {
           jpaQuery.setParameter ("hasInserts", software.getHasInserts());
        }   
        if (software.getIsSealed() != null) {
           jpaQuery.setParameter ("isSealed", software.getIsSealed());
        }   
        if (software.getIsNew() != null) {
           jpaQuery.setParameter ("isNew", software.getIsNew());
        }   
        if (software.getIsCompleteInBox() != null) {
           jpaQuery.setParameter ("isCompleteInBox", software.getIsCompleteInBox());
        }   
        if (software.getSoftwareStateRating() != null) {
           jpaQuery.setParameter ("softwareStateRating", software.getSoftwareStateRating());
        }   
        if (software.getBoxStateRating() != null) {
           jpaQuery.setParameter ("boxStateRating", software.getBoxStateRating());
        }   
        if (software.getManualStateRating() != null) {
           jpaQuery.setParameter ("manualStateRating", software.getManualStateRating());
        }   
        if (software.getComment() != null) {
           jpaQuery.setParameter ("comment", software.getComment());
        }   
        if (software.getBarcode() != null) {
           jpaQuery.setParameter ("barcode", software.getBarcode());
        }   
		return jpaQuery.executeUpdate();
    }

    protected String getUpdateNotNullOnlySoftwareQueryChunkPrototype (Software software) {
        boolean isSetSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update Software software ");
        if (software.getDevelopper() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.developper = :developper");
        }
        if (software.getEditor() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.editor = :editor");
        }
        if (software.getName() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.name = :name");
        }
        if (software.getDescription() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.description = :description");
        }
        if (software.getConsole() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.console = :console");
        }
        if (software.getStyle() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.style = :style");
        }
        if (software.getSerialNumber() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.serialNumber = :serialNumber");
        }
        if (software.getRegion() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.region = :region");
        }
        if (software.getSubRegionCode() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.subRegionCode = :subRegionCode");
        }
        if (software.getReleaseDate() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.releaseDate = :releaseDate");
        }
        if (software.getAcquiringDate() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.acquiringDate = :acquiringDate");
        }
        if (software.getAcquiringPrice() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.acquiringPrice = :acquiringPrice");
        }
        if (software.getAcquiredPriceFree() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.acquiredPriceFree = :acquiredPriceFree");
        }
        if (software.getAcquiredPriceUnknown() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.acquiredPriceUnknown = :acquiredPriceUnknown");
        }
        if (software.getAcquiringSellerName() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.acquiringSellerName = :acquiringSellerName");
        }
        if (software.getAcquiringPlace() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.acquiringPlace = :acquiringPlace");
        }
        if (software.getLocation() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.location = :location");
        }
        if (software.getHasBox() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.hasBox = :hasBox");
        }
        if (software.getHasManual() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.hasManual = :hasManual");
        }
        if (software.getHasInserts() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.hasInserts = :hasInserts");
        }
        if (software.getIsSealed() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.isSealed = :isSealed");
        }
        if (software.getIsNew() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.isNew = :isNew");
        }
        if (software.getIsCompleteInBox() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.isCompleteInBox = :isCompleteInBox");
        }
        if (software.getSoftwareStateRating() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.softwareStateRating = :softwareStateRating");
        }
        if (software.getBoxStateRating() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.boxStateRating = :boxStateRating");
        }
        if (software.getManualStateRating() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.manualStateRating = :manualStateRating");
        }
        if (software.getComment() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.comment = :comment");
        }
        if (software.getBarcode() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" software.barcode = :barcode");
        }
        if (isSetSet==false)
			throw new IllegalArgumentException("software mask should contain updatable fields");
        return query.toString();
    }
    
    protected String getUpdateNotNullOnlySoftwareQueryChunk (Software software) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer(getUpdateNotNullOnlySoftwareQueryChunkPrototype(software));
        if (software.getSoftwareId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
			     query.append(" software.softwareId = :softwareId");
        }
        if (isWhereSet==false)
			throw new IllegalArgumentException("software mask should contain primary key");
        return query.toString();
    }
    
                
	protected Software assignBlankToNull (Software software) {
        if (software==null)
			return null;
        if (software.getName()!=null && software.getName().equals(""))
           software.setName((String)null);
        if (software.getDescription()!=null && software.getDescription().equals(""))
           software.setDescription((String)null);
        if (software.getSerialNumber()!=null && software.getSerialNumber().equals(""))
           software.setSerialNumber((String)null);
        if (software.getSubRegionCode()!=null && software.getSubRegionCode().equals(""))
           software.setSubRegionCode((String)null);
        if (software.getAcquiringSellerName()!=null && software.getAcquiringSellerName().equals(""))
           software.setAcquiringSellerName((String)null);
        if (software.getAcquiringPlace()!=null && software.getAcquiringPlace().equals(""))
           software.setAcquiringPlace((String)null);
        if (software.getHasInserts()!=null && software.getHasInserts().equals(""))
           software.setHasInserts((String)null);
        if (software.getComment()!=null && software.getComment().equals(""))
           software.setComment((String)null);
        if (software.getBarcode()!=null && software.getBarcode().equals(""))
           software.setBarcode((String)null);
		return software;
	}
	
	protected boolean isAllNull (Software software) {
	    if (software==null)
			return true;
        if (software.getSoftwareId()!=null) 
            return false;
        if (software.getDevelopper()!=null) 
            return false;
        if (software.getEditor()!=null) 
            return false;
        if (software.getName()!=null) 
            return false;
        if (software.getDescription()!=null) 
            return false;
        if (software.getConsole()!=null) 
            return false;
        if (software.getStyle()!=null) 
            return false;
        if (software.getSerialNumber()!=null) 
            return false;
        if (software.getRegion()!=null) 
            return false;
        if (software.getSubRegionCode()!=null) 
            return false;
        if (software.getReleaseDate()!=null) 
            return false;
        if (software.getAcquiringDate()!=null) 
            return false;
        if (software.getAcquiringPrice()!=null) 
            return false;
        if (software.getAcquiredPriceFree()!=null) 
            return false;
        if (software.getAcquiredPriceUnknown()!=null) 
            return false;
        if (software.getAcquiringSellerName()!=null) 
            return false;
        if (software.getAcquiringPlace()!=null) 
            return false;
        if (software.getLocation()!=null) 
            return false;
        if (software.getHasBox()!=null) 
            return false;
        if (software.getHasManual()!=null) 
            return false;
        if (software.getHasInserts()!=null) 
            return false;
        if (software.getIsSealed()!=null) 
            return false;
        if (software.getIsNew()!=null) 
            return false;
        if (software.getIsCompleteInBox()!=null) 
            return false;
        if (software.getSoftwareStateRating()!=null) 
            return false;
        if (software.getBoxStateRating()!=null) 
            return false;
        if (software.getManualStateRating()!=null) 
            return false;
        if (software.getComment()!=null) 
            return false;
        if (software.getBarcode()!=null) 
            return false;
		return true;
	}
		
    @Transactional
    public Integer updateNotNullOnlyPrototypeSoftware(Software software, Software prototypeCriteria) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update Software software ");
        if (software.getSoftwareId() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.softwareId = "+ software.getSoftwareId() + " ");
        }
        if (software.getDevelopper_() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.developper_ = "+ software.getDevelopper_() + " ");
        }
        if (software.getEditor_() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.editor_ = "+ software.getEditor_() + " ");
        }
        if (software.getName() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.name = '"+ software.getName()+"' ");
        }
        if (software.getDescription() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.description = '"+ software.getDescription()+"' ");
        }
        if (software.getConsole_() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.console_ = "+ software.getConsole_() + " ");
        }
        if (software.getStyle_() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.style_ = "+ software.getStyle_() + " ");
        }
        if (software.getSerialNumber() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.serialNumber = '"+ software.getSerialNumber()+"' ");
        }
        if (software.getRegion_() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.region_ = "+ software.getRegion_() + " ");
        }
        if (software.getSubRegionCode() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.subRegionCode = '"+ software.getSubRegionCode()+"' ");
        }
        if (software.getReleaseDate() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.releaseDate = '"+ software.getReleaseDate()+"' ");
        }
        if (software.getAcquiringDate() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.acquiringDate = '"+ software.getAcquiringDate()+"' ");
        }
        if (software.getAcquiringPrice() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.acquiringPrice = "+ software.getAcquiringPrice() + " ");
        }
        if (software.getAcquiredPriceFree() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.acquiredPriceFree = '"+ software.getAcquiredPriceFree()+"' ");
        }
        if (software.getAcquiredPriceUnknown() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.acquiredPriceUnknown = '"+ software.getAcquiredPriceUnknown()+"' ");
        }
        if (software.getAcquiringSellerName() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.acquiringSellerName = '"+ software.getAcquiringSellerName()+"' ");
        }
        if (software.getAcquiringPlace() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.acquiringPlace = '"+ software.getAcquiringPlace()+"' ");
        }
        if (software.getLocation_() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.location_ = "+ software.getLocation_() + " ");
        }
        if (software.getHasBox() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.hasBox = '"+ software.getHasBox()+"' ");
        }
        if (software.getHasManual() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.hasManual = '"+ software.getHasManual()+"' ");
        }
        if (software.getHasInserts() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.hasInserts = '"+ software.getHasInserts()+"' ");
        }
        if (software.getIsSealed() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.isSealed = '"+ software.getIsSealed()+"' ");
        }
        if (software.getIsNew() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.isNew = '"+ software.getIsNew()+"' ");
        }
        if (software.getIsCompleteInBox() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.isCompleteInBox = '"+ software.getIsCompleteInBox()+"' ");
        }
        if (software.getSoftwareStateRating() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.softwareStateRating = "+ software.getSoftwareStateRating() + " ");
        }
        if (software.getBoxStateRating() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.boxStateRating = "+ software.getBoxStateRating() + " ");
        }
        if (software.getManualStateRating() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.manualStateRating = "+ software.getManualStateRating() + " ");
        }
        if (software.getComment() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.comment = '"+ software.getComment()+"' ");
        }
        if (software.getBarcode() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" software.barcode = '"+ software.getBarcode()+"' ");
        }
		isWhereSet = false; 
        if (prototypeCriteria.getSoftwareId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.softwareId = "+ prototypeCriteria.getSoftwareId() + " ");
        }
        if (prototypeCriteria.getDevelopper_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.developper_ = "+ prototypeCriteria.getDevelopper_() + " ");
        }
        if (prototypeCriteria.getEditor_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.editor_ = "+ prototypeCriteria.getEditor_() + " ");
        }
        if (prototypeCriteria.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.name = '"+ prototypeCriteria.getName()+"' ");
        }
        if (prototypeCriteria.getDescription() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.description = '"+ prototypeCriteria.getDescription()+"' ");
        }
        if (prototypeCriteria.getConsole_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.console_ = "+ prototypeCriteria.getConsole_() + " ");
        }
        if (prototypeCriteria.getStyle_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.style_ = "+ prototypeCriteria.getStyle_() + " ");
        }
        if (prototypeCriteria.getSerialNumber() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.serialNumber = '"+ prototypeCriteria.getSerialNumber()+"' ");
        }
        if (prototypeCriteria.getRegion_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.region_ = "+ prototypeCriteria.getRegion_() + " ");
        }
        if (prototypeCriteria.getSubRegionCode() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.subRegionCode = '"+ prototypeCriteria.getSubRegionCode()+"' ");
        }
        if (prototypeCriteria.getReleaseDate() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.releaseDate = '"+ prototypeCriteria.getReleaseDate()+"' ");
        }
        if (prototypeCriteria.getAcquiringDate() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.acquiringDate = '"+ prototypeCriteria.getAcquiringDate()+"' ");
        }
        if (prototypeCriteria.getAcquiringPrice() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.acquiringPrice = "+ prototypeCriteria.getAcquiringPrice() + " ");
        }
        if (prototypeCriteria.getAcquiredPriceFree() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.acquiredPriceFree = '"+ prototypeCriteria.getAcquiredPriceFree()+"' ");
        }
        if (prototypeCriteria.getAcquiredPriceUnknown() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.acquiredPriceUnknown = '"+ prototypeCriteria.getAcquiredPriceUnknown()+"' ");
        }
        if (prototypeCriteria.getAcquiringSellerName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.acquiringSellerName = '"+ prototypeCriteria.getAcquiringSellerName()+"' ");
        }
        if (prototypeCriteria.getAcquiringPlace() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.acquiringPlace = '"+ prototypeCriteria.getAcquiringPlace()+"' ");
        }
        if (prototypeCriteria.getLocation_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.location_ = "+ prototypeCriteria.getLocation_() + " ");
        }
        if (prototypeCriteria.getHasBox() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.hasBox = '"+ prototypeCriteria.getHasBox()+"' ");
        }
        if (prototypeCriteria.getHasManual() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.hasManual = '"+ prototypeCriteria.getHasManual()+"' ");
        }
        if (prototypeCriteria.getHasInserts() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.hasInserts = '"+ prototypeCriteria.getHasInserts()+"' ");
        }
        if (prototypeCriteria.getIsSealed() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.isSealed = '"+ prototypeCriteria.getIsSealed()+"' ");
        }
        if (prototypeCriteria.getIsNew() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.isNew = '"+ prototypeCriteria.getIsNew()+"' ");
        }
        if (prototypeCriteria.getIsCompleteInBox() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.isCompleteInBox = '"+ prototypeCriteria.getIsCompleteInBox()+"' ");
        }
        if (prototypeCriteria.getSoftwareStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.softwareStateRating = "+ prototypeCriteria.getSoftwareStateRating() + " ");
        }
        if (prototypeCriteria.getBoxStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.boxStateRating = "+ prototypeCriteria.getBoxStateRating() + " ");
        }
        if (prototypeCriteria.getManualStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.manualStateRating = "+ prototypeCriteria.getManualStateRating() + " ");
        }
        if (prototypeCriteria.getComment() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.comment = '"+ prototypeCriteria.getComment()+"' ");
        }
        if (prototypeCriteria.getBarcode() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.barcode = '"+ prototypeCriteria.getBarcode()+"' ");
        }
        Query jpaQuery = getEntityManager().createQuery(query.toString());
		return jpaQuery.executeUpdate();
    }
     
     /**
     * Saves a Software entity 
     * @param Software software
     */
    public void saveSoftware(Software software) {
       //entityManager.persist(software);
       if (entityManager.contains(software)) {
          entityManager.merge(software);
       } else {
          entityManager.persist(software);
       }
       entityManager.flush(); 
    }
       
    /**
     * Deletes a Software entity 
     * @param Software software
     */
    public void deleteSoftware(Software software) {
      entityManager.remove(software);
    }
    
    /**
     * Loads the Software entity which is related to an instance of
     * Software
     * @param Long id
     * @return Software The Software entity
     
    public Software loadSoftware(Long id) {
    	return (Software)entityManager.get(Software.class, id);
    }
*/
  
    /**
     * Loads the Software entity which is related to an instance of
     * Software
     * @param java.lang.Integer SoftwareId
     * @return Software The Software entity
     */
    public Software loadSoftware(java.lang.Integer softwareId) {
    	return (Software)entityManager.find(Software.class, softwareId);
    }
    
    /**
     * Loads the Software entity which is related to an instance of
     * Software and its dependent one to many objects
     * @param Long id
     * @return Software The Software entity
     */
    public Software loadFullFirstLevelSoftware(java.lang.Integer softwareId) {
        List list = getResultList(
                     "SELECT software FROM Software software "
                     + " LEFT JOIN software.photoSoftwareViaSoftwareIdPk "   
                     + " WHERE software.softwareId = "+softwareId
               );
         if (list!=null && !list.isEmpty())
            return (Software)list.get(0);
         return null;
    	//return null;//(Software) entityManager.queryForObject("loadFullFirstLevelSoftware", id);
    }

    /**
     * Loads the Software entity which is related to an instance of
     * Software
     * @param Software software
     * @return Software The Software entity
     */
    public Software loadFullFirstLevelSoftware(Software software) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT software FROM Software software ");
        query.append (" LEFT JOIN software.photoSoftwareViaSoftwareIdPk ");
        if (software.getSoftwareId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.softwareId = "+ software.getSoftwareId() + " ");
         }
        List list = getResultList(query.toString());
        if (list!=null && !list.isEmpty())
           return (Software)list.get(0);    
        return null;
    }  

    /**
     * Searches a list of Software entity 
     * @param Software software
     * @return List
     */  
    public List<Software> searchPrototypeSoftware(Software software) {
       return searchPrototype (software, null);
    }  
	
    public List<Software> searchPrototypeAnySoftware(Software software) {
       return searchPrototypeAny (software, null);
    }  

	// indirection
    public List<Software> find (Software criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
       return find (criteriaMask, matchType, operandType, caseSensitivenessType, null, null); 
	}
	
	// indirection
	protected List<Software> find (Software criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, Integer startPosition, Integer maxResults) {
       return find (criteriaMask, null, matchType, operandType, caseSensitivenessType, null, startPosition, maxResults); 
    }
	
	// indirection
	protected List<Software> find (Software criteriaMask, Software orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
       return find (null, criteriaMask, orderMask, matchType, operandType, caseSensitivenessType, sortOrder, startPosition, maxResults);
    }
	
	// main find implementation
	protected List<Software> find (Software whatMask, Software criteriaMask, Software orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
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
    public String findQuery (Software criteriaMask, Software orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String what = "SELECT software FROM Software software ";
		return findQuery (criteriaMask, orderMask, what, matchType, operandType, caseSensitivenessType, sortOrder);
    }

    protected String findQuery (Software criteriaMask, Software orderMask, String what, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String queryWhere = findWhere (criteriaMask, false, isAll(matchType), operandType, caseSensitivenessType);
		String queryOrder = findOrder (orderMask, sortOrder);
	    return getHQuery(what, queryWhere, queryOrder);
    }
	
    protected List<Software> searchPrototype (Software software, Software orderMask, QuerySortOrder sortOrder, Integer maxResults) {
       return searchPrototype(getSoftwareSelectQuery (getWhereEqualWhereQueryChunk(software), orderMask, sortOrder), maxResults);
    }

    protected List<Software> searchPrototype (Software software, Integer maxResults) {
       return searchPrototype(software, null, null, maxResults);
    }
    
    protected List<Software> searchPrototypeAny (Software software, Integer maxResults) { 
       return searchPrototype(getSearchEqualAnyQuery (software), maxResults);
    }
    
    protected List<Software> searchPrototype (String query, Integer maxResults) { 
       Query hquery = getEntityManager().createQuery(query);
       if (maxResults!=null)
          hquery.setMaxResults(maxResults);
       return hquery.getResultList();
    }

    public List<Software> searchPrototypeSoftware (List<Software> softwares) {
       return searchPrototype (softwares, null);
    }

    protected List<Software> searchPrototype (List<Software> softwares, Integer maxResults) {    
	   return getResultList(getSoftwareSearchEqualQuery (null, softwares));
	}    

    protected List<Software> getResultList (String query) {    
	   Query hquery = entityManager.createQuery(query);            
	   return hquery.getResultList();
	}    
 

    public List<Software> searchDistinctPrototypeSoftware (Software softwareMask, List<Software> softwares) {
        return getResultList(getSoftwareSearchEqualQuery (softwareMask, softwares));    
    }
        
	/**
     * Searches a list of Software entity 
     * @param Software positiveMask
     * @param Software negativeMask
     * @return List
     */
    public List<Software> searchPrototypeSoftware(Software positiveMask, Software negativeMask) {
	    return getResultList(getSoftwareSearchEqualQuery (positiveMask, negativeMask));  
    }

    /**
    * return a string query search on a Software prototype
    */
    protected String getSoftwareSelectQuery (String where, Software orderMask, QuerySortOrder sortOrder) {
       return getSoftwareSelectQuery (where, findOrder (orderMask, sortOrder));
    }
    protected String getSoftwareSelectQuery (String where, String order) {
       StringBuffer query = new StringBuffer();
       query.append ("SELECT software FROM Software software ");
       return (order!=null)? getHQuery(query.toString(), where, order):getHQuery(query.toString(), where);
    }
    /**
    * return a jql query search on a Software prototype
    */
    protected String getSearchEqualQuery (Software software) {
       return getSoftwareSelectQuery (getWhereEqualWhereQueryChunk(software),null);
    }
    protected String getWhereEqualWhereQueryChunk (Software software) {
       return getWhereEqualWhereQueryChunk(software, false);
    }
    /**
    * return a jql query search on a Software with any prototype
    */
    protected String getSearchEqualAnyQuery (Software software) {
       return getSoftwareSelectQuery (getWhereEqualAnyWhereQueryChunk(software), null);   
    }
    protected String getWhereEqualAnyWhereQueryChunk (Software software) {
       return getWhereEqualAnyWhereQueryChunk(software, false);   
    }

    /**
    * return a jql search for a list of Software prototype
    */
    protected String getSoftwareSearchEqualQuery (Software softwareMask, List<Software> softwares) {
        boolean isOrSet = false;
        StringBuffer query = new StringBuffer();
        if (softwareMask !=null)
           query.append (getSoftwareMaskWhat (softwareMask));
        query.append (" FROM Software software ");
        StringBuffer queryWhere = new StringBuffer();
        for (Software software : softwares) {
           if (!isAllNull(software)) {        
	           queryWhere.append (getQueryOR (isOrSet));
	           isOrSet = true;
	           queryWhere.append (" ("+getWhereEqualWhereQueryChunk(software, false)+") ");
           }
        }
	    return getHQuery(query.toString(), queryWhere.toString());
    }	

    
    protected String getSoftwareMaskWhat (Software softwareMask) {
        boolean isCommaSet = false;
        StringBuffer query = new StringBuffer("SELECT DISTINCT ");
        if (softwareMask.getSoftwareId() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" softwareId ");
        }
        if (softwareMask.getDevelopper() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" developper ");
        }
        if (softwareMask.getEditor() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" editor ");
        }
        if (softwareMask.getName() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" name ");
        }
        if (softwareMask.getDescription() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" description ");
        }
        if (softwareMask.getConsole() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" console ");
        }
        if (softwareMask.getStyle() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" style ");
        }
        if (softwareMask.getSerialNumber() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" serialNumber ");
        }
        if (softwareMask.getRegion() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" region ");
        }
        if (softwareMask.getSubRegionCode() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" subRegionCode ");
        }
        if (softwareMask.getReleaseDate() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" releaseDate ");
        }
        if (softwareMask.getAcquiringDate() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" acquiringDate ");
        }
        if (softwareMask.getAcquiringPrice() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" acquiringPrice ");
        }
        if (softwareMask.getAcquiredPriceFree() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" acquiredPriceFree ");
        }
        if (softwareMask.getAcquiredPriceUnknown() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" acquiredPriceUnknown ");
        }
        if (softwareMask.getAcquiringSellerName() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" acquiringSellerName ");
        }
        if (softwareMask.getAcquiringPlace() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" acquiringPlace ");
        }
        if (softwareMask.getLocation() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" location ");
        }
        if (softwareMask.getHasBox() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" hasBox ");
        }
        if (softwareMask.getHasManual() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" hasManual ");
        }
        if (softwareMask.getHasInserts() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" hasInserts ");
        }
        if (softwareMask.getIsSealed() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" isSealed ");
        }
        if (softwareMask.getIsNew() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" isNew ");
        }
        if (softwareMask.getIsCompleteInBox() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" isCompleteInBox ");
        }
        if (softwareMask.getSoftwareStateRating() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" softwareStateRating ");
        }
        if (softwareMask.getBoxStateRating() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" boxStateRating ");
        }
        if (softwareMask.getManualStateRating() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" manualStateRating ");
        }
        if (softwareMask.getComment() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" comment ");
        }
        if (softwareMask.getBarcode() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" barcode ");
        }
        if (!isCommaSet)
           return "";
	    return query.toString();
    }
    
    protected String getWhereEqualAnyWhereQueryChunk (Software software, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (software, isAndSet, false);	
	}
	
    protected String getWhereEqualWhereQueryChunk (Software software, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (software, isAndSet, true);
	}
	
    protected String getSearchEqualWhereQueryChunk (Software software, boolean isAndSet, boolean isAll) {
        StringBuffer query = new StringBuffer();
        if (software.getSoftwareId() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.softwareId = "+ software.getSoftwareId() + " ");
        }
        if (software.getDevelopper_() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.developper_ = "+ software.getDevelopper_() + " ");
        }
        if (software.getEditor_() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.editor_ = "+ software.getEditor_() + " ");
        }
        if (software.getName() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.name = '"+ software.getName()+"' ");
        }
        if (software.getDescription() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.description = '"+ software.getDescription()+"' ");
        }
        if (software.getConsole_() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.console_ = "+ software.getConsole_() + " ");
        }
        if (software.getStyle_() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.style_ = "+ software.getStyle_() + " ");
        }
        if (software.getSerialNumber() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.serialNumber = '"+ software.getSerialNumber()+"' ");
        }
        if (software.getRegion_() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.region_ = "+ software.getRegion_() + " ");
        }
        if (software.getSubRegionCode() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.subRegionCode = '"+ software.getSubRegionCode()+"' ");
        }
        if (software.getReleaseDate() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.releaseDate = '"+ software.getReleaseDate()+"' ");
        }
        if (software.getAcquiringDate() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.acquiringDate = '"+ software.getAcquiringDate()+"' ");
        }
        if (software.getAcquiringPrice() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.acquiringPrice = "+ software.getAcquiringPrice() + " ");
        }
        if (software.getAcquiredPriceFree() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.acquiredPriceFree = '"+ software.getAcquiredPriceFree()+"' ");
        }
        if (software.getAcquiredPriceUnknown() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.acquiredPriceUnknown = '"+ software.getAcquiredPriceUnknown()+"' ");
        }
        if (software.getAcquiringSellerName() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.acquiringSellerName = '"+ software.getAcquiringSellerName()+"' ");
        }
        if (software.getAcquiringPlace() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.acquiringPlace = '"+ software.getAcquiringPlace()+"' ");
        }
        if (software.getLocation_() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.location_ = "+ software.getLocation_() + " ");
        }
        if (software.getHasBox() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.hasBox = '"+ software.getHasBox()+"' ");
        }
        if (software.getHasManual() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.hasManual = '"+ software.getHasManual()+"' ");
        }
        if (software.getHasInserts() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.hasInserts = '"+ software.getHasInserts()+"' ");
        }
        if (software.getIsSealed() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.isSealed = '"+ software.getIsSealed()+"' ");
        }
        if (software.getIsNew() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.isNew = '"+ software.getIsNew()+"' ");
        }
        if (software.getIsCompleteInBox() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.isCompleteInBox = '"+ software.getIsCompleteInBox()+"' ");
        }
        if (software.getSoftwareStateRating() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.softwareStateRating = "+ software.getSoftwareStateRating() + " ");
        }
        if (software.getBoxStateRating() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.boxStateRating = "+ software.getBoxStateRating() + " ");
        }
        if (software.getManualStateRating() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.manualStateRating = "+ software.getManualStateRating() + " ");
        }
        if (software.getComment() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.comment = '"+ software.getComment()+"' ");
        }
        if (software.getBarcode() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" software.barcode = '"+ software.getBarcode()+"' ");
        }
	    return query.toString();
    }

    protected String findOrder (Software orderMask, QuerySortOrder sortOrder) {
        if (orderMask!=null) {
            String orderColumn = getFirstNotNullColumnOtherWiseNull(orderMask);
            if (orderColumn!=null)
               return orderColumn + " " + sortOrder;
        }
        return "";
    }

	@Override
    protected String findWhere (Software software, boolean isAndSet, boolean isAll, OperandType operandType, Boolean caseSensitive) {
		return findWhere (null, software, isAndSet, isAll, operandType, caseSensitive);
	}
	
	protected static String findWhere (String alias, Software software, boolean isAndSet, boolean isAll, OperandType operandType, boolean caseSensitive) {
        if (alias==null)
			alias = "software";
		StringBuffer query = new StringBuffer();
		String operand = getOperand (operandType);
		String evaluatorPrefix = getEvaluatorPrefix (operandType);		
		String evaluatorSuffix = getEvaluatorSuffix (operandType);		
        if (software.getSoftwareId() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".softwareId = "+ software.getSoftwareId() + " ");
        }
        if (software.getDevelopper_() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".developper_ = "+ software.getDevelopper_() + " ");
        }
        if (software.getEditor_() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".editor_ = "+ software.getEditor_() + " ");
        }
        if (software.getName() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = software.getName();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".name) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".name "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (software.getDescription() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".description = '"+ software.getDescription()+"' ");
        }
        if (software.getConsole_() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".console_ = "+ software.getConsole_() + " ");
        }
        if (software.getStyle_() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".style_ = "+ software.getStyle_() + " ");
        }
        if (software.getSerialNumber() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = software.getSerialNumber();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".serialNumber) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".serialNumber "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (software.getRegion_() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".region_ = "+ software.getRegion_() + " ");
        }
        if (software.getSubRegionCode() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = software.getSubRegionCode();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".subRegionCode) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".subRegionCode "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (software.getReleaseDate() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".releaseDate = '"+ software.getReleaseDate()+"' ");
        }
        if (software.getAcquiringDate() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".acquiringDate = '"+ software.getAcquiringDate()+"' ");
        }
        if (software.getAcquiringPrice() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".acquiringPrice = "+ software.getAcquiringPrice() + " ");
        }
        if (software.getAcquiredPriceFree() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".acquiredPriceFree = '"+ software.getAcquiredPriceFree()+"' ");
        }
        if (software.getAcquiredPriceUnknown() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".acquiredPriceUnknown = '"+ software.getAcquiredPriceUnknown()+"' ");
        }
        if (software.getAcquiringSellerName() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = software.getAcquiringSellerName();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".acquiringSellerName) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".acquiringSellerName "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (software.getAcquiringPlace() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = software.getAcquiringPlace();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".acquiringPlace) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".acquiringPlace "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (software.getLocation_() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".location_ = "+ software.getLocation_() + " ");
        }
        if (software.getHasBox() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".hasBox = '"+ software.getHasBox()+"' ");
        }
        if (software.getHasManual() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".hasManual = '"+ software.getHasManual()+"' ");
        }
        if (software.getHasInserts() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = software.getHasInserts();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".hasInserts) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".hasInserts "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (software.getIsSealed() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".isSealed = '"+ software.getIsSealed()+"' ");
        }
        if (software.getIsNew() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".isNew = '"+ software.getIsNew()+"' ");
        }
        if (software.getIsCompleteInBox() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".isCompleteInBox = '"+ software.getIsCompleteInBox()+"' ");
        }
        if (software.getSoftwareStateRating() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".softwareStateRating = "+ software.getSoftwareStateRating() + " ");
        }
        if (software.getBoxStateRating() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".boxStateRating = "+ software.getBoxStateRating() + " ");
        }
        if (software.getManualStateRating() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".manualStateRating = "+ software.getManualStateRating() + " ");
        }
        if (software.getComment() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = software.getComment();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".comment) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".comment "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (software.getBarcode() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".barcode = '"+ software.getBarcode()+"' ");
        }
        return query.toString();
    }
	
	protected String getFirstNotNullColumnOtherWiseNull (Software mask) {
        if (mask == null) return null;
        if (mask.getSoftwareId() != null) return "softwareId";
        if (mask.getDevelopper_() != null) return "developper";
        if (mask.getEditor_() != null) return "editor";
        if (mask.getName() != null) return "name";
        if (mask.getDescription() != null) return "description";
        if (mask.getConsole_() != null) return "console";
        if (mask.getStyle_() != null) return "style";
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
        if (mask.getSoftwareStateRating() != null) return "softwareStateRating";
        if (mask.getBoxStateRating() != null) return "boxStateRating";
        if (mask.getManualStateRating() != null) return "manualStateRating";
        if (mask.getComment() != null) return "comment";
        if (mask.getBarcode() != null) return "barcode";
        return null;	
	}
    
    /**
    * return a jql search on a Software prototype with positive and negative beans
    */
    protected String getSoftwareSearchEqualQuery (Software positiveMask, Software negativeMask) {
		StringBuffer query = new StringBuffer();    	
		query.append(getSelectFrom());
		query.append(getSoftwarePositiveNegativeCriteria(positiveMask, negativeMask));
		return query.toString();
	}

	protected String getSoftwarePositiveNegativeCriteria (Software positiveMask, Software negativeMask) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        if (positiveMask!=null && positiveMask.getSoftwareId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.softwareId = "+ positiveMask.getSoftwareId() + " ");
        } 
		if (negativeMask!=null && negativeMask.getSoftwareId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.softwareId is null ");
        }
        if (positiveMask!=null && positiveMask.getDevelopper_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.developper_ = "+ positiveMask.getDevelopper_() + " ");
        } 
		if (negativeMask!=null && negativeMask.getDevelopper_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.developper_ is null ");
        }
        if (positiveMask!=null && positiveMask.getEditor_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.editor_ = "+ positiveMask.getEditor_() + " ");
        } 
		if (negativeMask!=null && negativeMask.getEditor_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.editor_ is null ");
        }
        if (positiveMask!=null && positiveMask.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.name = '"+ positiveMask.getName()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.name is null ");
        }
        if (positiveMask!=null && positiveMask.getDescription() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.description = '"+ positiveMask.getDescription()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getDescription() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.description is null ");
        }
        if (positiveMask!=null && positiveMask.getConsole_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.console_ = "+ positiveMask.getConsole_() + " ");
        } 
		if (negativeMask!=null && negativeMask.getConsole_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.console_ is null ");
        }
        if (positiveMask!=null && positiveMask.getStyle_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.style_ = "+ positiveMask.getStyle_() + " ");
        } 
		if (negativeMask!=null && negativeMask.getStyle_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.style_ is null ");
        }
        if (positiveMask!=null && positiveMask.getSerialNumber() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.serialNumber = '"+ positiveMask.getSerialNumber()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getSerialNumber() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.serialNumber is null ");
        }
        if (positiveMask!=null && positiveMask.getRegion_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.region_ = "+ positiveMask.getRegion_() + " ");
        } 
		if (negativeMask!=null && negativeMask.getRegion_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.region_ is null ");
        }
        if (positiveMask!=null && positiveMask.getSubRegionCode() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.subRegionCode = '"+ positiveMask.getSubRegionCode()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getSubRegionCode() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.subRegionCode is null ");
        }
        if (positiveMask!=null && positiveMask.getReleaseDate() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.releaseDate = '"+ positiveMask.getReleaseDate()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getReleaseDate() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.releaseDate is null ");
        }
        if (positiveMask!=null && positiveMask.getAcquiringDate() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.acquiringDate = '"+ positiveMask.getAcquiringDate()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getAcquiringDate() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.acquiringDate is null ");
        }
        if (positiveMask!=null && positiveMask.getAcquiringPrice() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.acquiringPrice = "+ positiveMask.getAcquiringPrice() + " ");
        } 
		if (negativeMask!=null && negativeMask.getAcquiringPrice() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.acquiringPrice is null ");
        }
        if (positiveMask!=null && positiveMask.getAcquiredPriceFree() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.acquiredPriceFree = '"+ positiveMask.getAcquiredPriceFree()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getAcquiredPriceFree() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.acquiredPriceFree is null ");
        }
        if (positiveMask!=null && positiveMask.getAcquiredPriceUnknown() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.acquiredPriceUnknown = '"+ positiveMask.getAcquiredPriceUnknown()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getAcquiredPriceUnknown() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.acquiredPriceUnknown is null ");
        }
        if (positiveMask!=null && positiveMask.getAcquiringSellerName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.acquiringSellerName = '"+ positiveMask.getAcquiringSellerName()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getAcquiringSellerName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.acquiringSellerName is null ");
        }
        if (positiveMask!=null && positiveMask.getAcquiringPlace() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.acquiringPlace = '"+ positiveMask.getAcquiringPlace()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getAcquiringPlace() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.acquiringPlace is null ");
        }
        if (positiveMask!=null && positiveMask.getLocation_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.location_ = "+ positiveMask.getLocation_() + " ");
        } 
		if (negativeMask!=null && negativeMask.getLocation_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.location_ is null ");
        }
        if (positiveMask!=null && positiveMask.getHasBox() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.hasBox = '"+ positiveMask.getHasBox()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getHasBox() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.hasBox is null ");
        }
        if (positiveMask!=null && positiveMask.getHasManual() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.hasManual = '"+ positiveMask.getHasManual()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getHasManual() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.hasManual is null ");
        }
        if (positiveMask!=null && positiveMask.getHasInserts() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.hasInserts = '"+ positiveMask.getHasInserts()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getHasInserts() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.hasInserts is null ");
        }
        if (positiveMask!=null && positiveMask.getIsSealed() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.isSealed = '"+ positiveMask.getIsSealed()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getIsSealed() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.isSealed is null ");
        }
        if (positiveMask!=null && positiveMask.getIsNew() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.isNew = '"+ positiveMask.getIsNew()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getIsNew() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.isNew is null ");
        }
        if (positiveMask!=null && positiveMask.getIsCompleteInBox() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.isCompleteInBox = '"+ positiveMask.getIsCompleteInBox()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getIsCompleteInBox() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.isCompleteInBox is null ");
        }
        if (positiveMask!=null && positiveMask.getSoftwareStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.softwareStateRating = "+ positiveMask.getSoftwareStateRating() + " ");
        } 
		if (negativeMask!=null && negativeMask.getSoftwareStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.softwareStateRating is null ");
        }
        if (positiveMask!=null && positiveMask.getBoxStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.boxStateRating = "+ positiveMask.getBoxStateRating() + " ");
        } 
		if (negativeMask!=null && negativeMask.getBoxStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.boxStateRating is null ");
        }
        if (positiveMask!=null && positiveMask.getManualStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.manualStateRating = "+ positiveMask.getManualStateRating() + " ");
        } 
		if (negativeMask!=null && negativeMask.getManualStateRating() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.manualStateRating is null ");
        }
        if (positiveMask!=null && positiveMask.getComment() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.comment = '"+ positiveMask.getComment()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getComment() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.comment is null ");
        }
        if (positiveMask!=null && positiveMask.getBarcode() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" software.barcode = '"+ positiveMask.getBarcode()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getBarcode() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" software.barcode is null ");
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
    public SoftwareJPAImpl (EntityManager emForRecursiveDao) {
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
     * Inserts a Software entity with cascade of its children
     * @param Software software
     */
    public void insertSoftwareWithCascade(Software software) {
    	SoftwareJPAImpl softwarejpaimpl = new SoftwareJPAImpl(getEntityManager());
    	softwarejpaimpl.insertSoftwareWithCascade(softwarejpaimpl.getEntityManagerForRecursiveDao(), software);
    }
     
    public void insertSoftwareWithCascade(EntityManager emForRecursiveDao, Software software) {
       insertSoftware(emForRecursiveDao, software);
       if (!software.getPhotoSoftwareViaSoftwareIdPk().isEmpty()) {
          PhotoJPAImpl photoextendedjpaimpl = new PhotoJPAImpl (emForRecursiveDao);
          for (Photo _photoSoftwareViaSoftwareIdPk : software.getPhotoSoftwareViaSoftwareIdPk()) {
             photoextendedjpaimpl.insertPhotoWithCascade(emForRecursiveDao, _photoSoftwareViaSoftwareIdPk);
          }
       } 
    }
        
    /**
     * Inserts a list of Software entity with cascade of its children
     * @param List<Software> softwares
     */
    public void insertSoftwaresWithCascade(List<Software> softwares) {
       for (Software software : softwares) {
          insertSoftwareWithCascade(software);
       }
    } 
        
    /**
     * lookup Software entity Software, criteria and max result number
     */
    public List<Software> lookupSoftware(Software software, Criteria criteria, Integer numberOfResult, EntityManager em) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT software FROM Software software ");
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
    
    public List<Software> lookupSoftware(Software software, Criteria criteria, Integer numberOfResult) {
		return lookupSoftware(software, criteria, numberOfResult, getEntityManager());
    }

    public Integer updateNotNullOnlySoftware (Software software, Criteria criteria) {
        String queryWhat = getUpdateNotNullOnlySoftwareQueryChunkPrototype (software);
        StringBuffer query = new StringBuffer (queryWhat);
        boolean isWhereSet = false;
        for (Criterion criterion : criteria.getClauseCriterions()) {
            query.append (getQueryWHERE_AND (isWhereSet));
            isWhereSet = true;   
            query.append(criterion.getExpression());			
        }  
        Query jpaQuery = getEntityManager().createQuery(query.toString());
        isWhereSet = false;
        if (software.getSoftwareId() != null) {
           jpaQuery.setParameter ("softwareId", software.getSoftwareId());
        }   
        if (software.getDevelopper() != null) {
           jpaQuery.setParameter ("developper", software.getDevelopper());
        }   
        if (software.getEditor() != null) {
           jpaQuery.setParameter ("editor", software.getEditor());
        }   
        if (software.getName() != null) {
           jpaQuery.setParameter ("name", software.getName());
        }   
        if (software.getDescription() != null) {
           jpaQuery.setParameter ("description", software.getDescription());
        }   
        if (software.getConsole() != null) {
           jpaQuery.setParameter ("console", software.getConsole());
        }   
        if (software.getStyle() != null) {
           jpaQuery.setParameter ("style", software.getStyle());
        }   
        if (software.getSerialNumber() != null) {
           jpaQuery.setParameter ("serialNumber", software.getSerialNumber());
        }   
        if (software.getRegion() != null) {
           jpaQuery.setParameter ("region", software.getRegion());
        }   
        if (software.getSubRegionCode() != null) {
           jpaQuery.setParameter ("subRegionCode", software.getSubRegionCode());
        }   
        if (software.getReleaseDate() != null) {
           jpaQuery.setParameter ("releaseDate", software.getReleaseDate());
        }   
        if (software.getAcquiringDate() != null) {
           jpaQuery.setParameter ("acquiringDate", software.getAcquiringDate());
        }   
        if (software.getAcquiringPrice() != null) {
           jpaQuery.setParameter ("acquiringPrice", software.getAcquiringPrice());
        }   
        if (software.getAcquiredPriceFree() != null) {
           jpaQuery.setParameter ("acquiredPriceFree", software.getAcquiredPriceFree());
        }   
        if (software.getAcquiredPriceUnknown() != null) {
           jpaQuery.setParameter ("acquiredPriceUnknown", software.getAcquiredPriceUnknown());
        }   
        if (software.getAcquiringSellerName() != null) {
           jpaQuery.setParameter ("acquiringSellerName", software.getAcquiringSellerName());
        }   
        if (software.getAcquiringPlace() != null) {
           jpaQuery.setParameter ("acquiringPlace", software.getAcquiringPlace());
        }   
        if (software.getLocation() != null) {
           jpaQuery.setParameter ("location", software.getLocation());
        }   
        if (software.getHasBox() != null) {
           jpaQuery.setParameter ("hasBox", software.getHasBox());
        }   
        if (software.getHasManual() != null) {
           jpaQuery.setParameter ("hasManual", software.getHasManual());
        }   
        if (software.getHasInserts() != null) {
           jpaQuery.setParameter ("hasInserts", software.getHasInserts());
        }   
        if (software.getIsSealed() != null) {
           jpaQuery.setParameter ("isSealed", software.getIsSealed());
        }   
        if (software.getIsNew() != null) {
           jpaQuery.setParameter ("isNew", software.getIsNew());
        }   
        if (software.getIsCompleteInBox() != null) {
           jpaQuery.setParameter ("isCompleteInBox", software.getIsCompleteInBox());
        }   
        if (software.getSoftwareStateRating() != null) {
           jpaQuery.setParameter ("softwareStateRating", software.getSoftwareStateRating());
        }   
        if (software.getBoxStateRating() != null) {
           jpaQuery.setParameter ("boxStateRating", software.getBoxStateRating());
        }   
        if (software.getManualStateRating() != null) {
           jpaQuery.setParameter ("manualStateRating", software.getManualStateRating());
        }   
        if (software.getComment() != null) {
           jpaQuery.setParameter ("comment", software.getComment());
        }   
        if (software.getBarcode() != null) {
           jpaQuery.setParameter ("barcode", software.getBarcode());
        }   
		return jpaQuery.executeUpdate();
    }
	
	public Software affectSoftware (Software software) {
	    return referSoftware (software, null, false);		    
	}
		
	/**
	 * Assign the first software retrieved corresponding to the software criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no software corresponding in the database. Then software is inserted and returned with its primary key(s). 
	 */
	public Software assignSoftware (Software software) {
		return referSoftware (software, null, true);
	}

	/**
	 * Assign the first software retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no software corresponding in the database. 
	 * Then software is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public Software assignSoftware (Software software, Software mask) {
		return referSoftware (software, mask, true);
	}

	public Software referSoftware (Software software, Software mask, boolean isAssign) {
		software = assignBlankToNull (software);
		if (isAllNull(software))
			return null;
		else {
			List<Software> list;
			if (mask==null)
				list = searchPrototypeSoftware(software);
			else
				list = searchPrototypeSoftware(mask);
			if (list.isEmpty()) {
			    if (isAssign)
			       insertSoftware(software);
			    else
				   return null;
			}
			else if (list.size()==1)
				software.copy(list.get(0));
			else 
				//TODO log error
				software.copy(list.get(0));
		}
		return software;		    
	}

   public Software assignSoftwareUseCache (Software software) {
      return referSoftwareUseCache (software, true);
   }
      		
   public Software affectSoftwareUseCache (Software software) {
      return referSoftwareUseCache (software, false);
   }
      		
   public Software referSoftwareUseCache (Software software, boolean isAssign) {
	  String key = getCacheKey(null, software, null, "assignSoftware");
      Software softwareCache = (Software)simpleCache.get(key);
      if (softwareCache==null) {
         softwareCache = referSoftware (software, null, isAssign);
         if (key!=null)
         	simpleCache.put(key, softwareCache);
      }
      software.copy(softwareCache);
      return softwareCache;
   }	

	private String getCacheKey (Software softwareWhat, Software positiveSoftware, Software negativeSoftware, String queryKey) {
	    StringBuffer sb = new StringBuffer();
	    sb.append(queryKey);
	    if (softwareWhat!=null)
	       sb.append(softwareWhat.toStringWithParents());
	    if (positiveSoftware!=null)
	       sb.append(positiveSoftware.toStringWithParents());
	    if (negativeSoftware!=null)
	       sb.append(negativeSoftware.toStringWithParents());
	    return sb.toString();
	}
	
    public Software partialLoadWithParentFirstSoftware(Software softwareWhat, Software positiveSoftware, Software negativeSoftware){
		List <Software> list = partialLoadWithParentSoftware(softwareWhat, positiveSoftware, negativeSoftware);
		return (!list.isEmpty())?(Software)list.get(0):null;
    }
    
    public Software partialLoadWithParentFirstSoftwareUseCache(Software softwareWhat, Software positiveSoftware, Software negativeSoftware, Boolean useCache){
		List <Software> list = partialLoadWithParentSoftwareUseCache(softwareWhat, positiveSoftware, negativeSoftware, useCache);
		return (!list.isEmpty())?(Software)list.get(0):null;
    }
	
	public Software partialLoadWithParentFirstSoftwareUseCacheOnResult(Software softwareWhat, Software positiveSoftware, Software negativeSoftware, Boolean useCache){
		List <Software> list = partialLoadWithParentSoftwareUseCacheOnResult(softwareWhat, positiveSoftware, negativeSoftware, useCache);
		return (!list.isEmpty())?(Software)list.get(0):null;
    }
	//
	protected List<Software> partialLoadWithParentSoftware(Software softwareWhat, Software positiveSoftware, Software negativeSoftware, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentSoftware(softwareWhat, positiveSoftware, negativeSoftware, new QuerySelectInit(), nbOfResult, useCache);
	}	  

	protected List partialLoadWithParentSoftwareQueryResult (Software softwareWhat, Software positiveSoftware, Software negativeSoftware, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentSoftwareQueryResult (softwareWhat, positiveSoftware, negativeSoftware, new QuerySelectInit(), nbOfResult, useCache);
	}	
    
    public List<Software> getDistinctSoftware(Software softwareWhat, Software positiveSoftware, Software negativeSoftware) {
		 return partialLoadWithParentSoftware(softwareWhat, positiveSoftware, negativeSoftware, new QuerySelectDistinctInit(), null, false);
	}
	
	public List<Software> partialLoadWithParentSoftware(Software softwareWhat, Software positiveSoftware, Software negativeSoftware) {
		 return partialLoadWithParentSoftware(softwareWhat, positiveSoftware, negativeSoftware, new QuerySelectInit(), null, false);
	}	
  
	public List<Software> partialLoadWithParentSoftwareUseCacheOnResult(Software softwareWhat, Software positiveSoftware, Software negativeSoftware, Boolean useCache) {
		String key = getCacheKey(softwareWhat, positiveSoftware, negativeSoftware, "partialLoadWithParentSoftware");
		List<Software> list = (List<Software>)simpleCache.get(key);
		if (list==null || list.isEmpty()) {
			list = partialLoadWithParentSoftware(softwareWhat, positiveSoftware, negativeSoftware);
			if (!list.isEmpty())
			   simpleCache.put(key, list);
		}
		return list;	
	}	

	public List<Software> partialLoadWithParentSoftwareUseCache(Software softwareWhat, Software positiveSoftware, Software negativeSoftware, Boolean useCache) {
		String key = getCacheKey(softwareWhat, positiveSoftware, negativeSoftware, "partialLoadWithParentSoftware");
		List<Software> list = (List<Software>)simpleCache.get(key);
		if (list==null) {
			list = partialLoadWithParentSoftware(softwareWhat, positiveSoftware, negativeSoftware);
			simpleCache.put(key, list);
		}
		return list;	
	}	
	
	private List<Software> handleLoadWithParentSoftware(Map beanPath, List list, Software softwareWhat) {
	    return handleLoadWithParentSoftware(beanPath, list, softwareWhat, true);  
	}
	
	private List<Software> handleLoadWithParentSoftware(Map beanPath, List list, Software softwareWhat, boolean isHql) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentSoftwareWithOneElementInRow(list, beanPath, softwareWhat, isHql);
		}
		return handlePartialLoadWithParentSoftware(list, beanPath, softwareWhat, isHql);	
	}
	
    	// to set in super class	
	protected void populateSoftware (Software software, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(software, beanPath, value);
	}
	
	protected void populateSoftwareFromSQL (Software software, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(software, beanPath, value);
	}
    	// to set in super class BEWARE: genericity is only one level!!!!! first level is a copy second level is a reference!!! change to software.clone() instead
	private Software cloneSoftware (Software software) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		//return (Software) BeanUtils.cloneBeanObject(software);
	   if (software==null) return new Software();
	   return software.clone();
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
	
    public List<Software> countDistinct (Software whatMask, Software whereEqCriteria) {
       return partialLoadWithParentSoftware(whatMask, whereEqCriteria, null, new QuerySelectCountInit("software"), null, false);
    }   
  	
    public Long count(Software whereEqCriteria) {
	    return count(null, whereEqCriteria, EntityMatchType.ALL, OperandType.EQUALS, true); 
/*        Query query = getEntityManager().createQuery(getSelectCountPrototype(whereEqCriteria));
        List<Long> list = query.getResultList();
    	if (!list.isEmpty()) {
            return list.get(0);
    	}
    	return 0L;
*/
    }


    public Long count(Software whatMask, Software whereCriteria, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
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

	protected String countQuery (Software software, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
        String what = "SELECT count(*) FROM Software software ";
		return findQuery (software, null, what, matchType, operandType, caseSensitivenessType, null);
    }
	

   private List getFirstResultWhereConditionsAre (Software software) {
      return partialLoadWithParentSoftwareQueryResult(getDefaultSoftwareWhat(), software, null, 1, false);	
   }
   
   protected Software getDefaultSoftwareWhat() {
      Software software = new Software();
      software.setSoftwareId(Integer.valueOf(-1));
      return software;
   }
   
	public Software getFirstSoftware (Software software) {
		if (isAllNull(software))
			return null;
		else {
			List<Software> list = searchPrototype (software, 1);
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
    * checks if the Software entity exists
    */           
    public boolean existsSoftware (Software software) {
       if (getFirstSoftware(software)!=null)
          return true;
       return false;  
    }
        
    public boolean existsSoftwareWhereConditionsAre (Software software) {
       if (getFirstResultWhereConditionsAre (software).isEmpty())
          return false;
       return true;  
    }

	private int countPartialField (Software software) {
	   int cpt = 0;
       if (software.getSoftwareId() != null) {
          cpt++;
       }
       if (software.getDevelopper_() != null) {
          cpt++;
       }
       if (software.getEditor_() != null) {
          cpt++;
       }
       if (software.getName() != null) {
          cpt++;
       }
       if (software.getDescription() != null) {
          cpt++;
       }
       if (software.getConsole_() != null) {
          cpt++;
       }
       if (software.getStyle_() != null) {
          cpt++;
       }
       if (software.getSerialNumber() != null) {
          cpt++;
       }
       if (software.getRegion_() != null) {
          cpt++;
       }
       if (software.getSubRegionCode() != null) {
          cpt++;
       }
       if (software.getReleaseDate() != null) {
          cpt++;
       }
       if (software.getAcquiringDate() != null) {
          cpt++;
       }
       if (software.getAcquiringPrice() != null) {
          cpt++;
       }
       if (software.getAcquiredPriceFree() != null) {
          cpt++;
       }
       if (software.getAcquiredPriceUnknown() != null) {
          cpt++;
       }
       if (software.getAcquiringSellerName() != null) {
          cpt++;
       }
       if (software.getAcquiringPlace() != null) {
          cpt++;
       }
       if (software.getLocation_() != null) {
          cpt++;
       }
       if (software.getHasBox() != null) {
          cpt++;
       }
       if (software.getHasManual() != null) {
          cpt++;
       }
       if (software.getHasInserts() != null) {
          cpt++;
       }
       if (software.getIsSealed() != null) {
          cpt++;
       }
       if (software.getIsNew() != null) {
          cpt++;
       }
       if (software.getIsCompleteInBox() != null) {
          cpt++;
       }
       if (software.getSoftwareStateRating() != null) {
          cpt++;
       }
       if (software.getBoxStateRating() != null) {
          cpt++;
       }
       if (software.getManualStateRating() != null) {
          cpt++;
       }
       if (software.getComment() != null) {
          cpt++;
       }
       if (software.getBarcode() != null) {
          cpt++;
       }
       return cpt;
	}   

	public List<Software> partialLoadWithParentSoftware(Software what, Software positiveSoftware, Software negativeSoftware, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		Map beanPath = new Hashtable();
		List list = partialLoadWithParentSoftwareJPAQueryResult (what, positiveSoftware, negativeSoftware, queryWhatInit, beanPath, nbOfResult, useCache);
		return handlePartialLoadWithParentResult(what, list, beanPath);
	}
	
	public List<Software> handlePartialLoadWithParentResult(Software what, List list, Map beanPath) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentSoftwareWithOneElementInRow(list, beanPath, what, true);
		}
		return handlePartialLoadWithParentSoftware(list, beanPath, what, true);
	}	

	private List partialLoadWithParentSoftwareQueryResult(Software softwareWhat, Software positiveSoftware, Software negativeSoftware, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		return partialLoadWithParentSoftwareJPAQueryResult (softwareWhat, positiveSoftware, negativeSoftware, queryWhatInit, new Hashtable(), nbOfResult, useCache);
    }	
  
	private List partialLoadWithParentSoftwareJPAQueryResult(Software softwareWhat, Software positiveSoftware, Software negativeSoftware, QueryWhatInit queryWhatInit, Map beanPath, Integer nbOfResult, Boolean useCache) {
		Query hquery = getPartialLoadWithParentJPAQuery (softwareWhat, positiveSoftware, negativeSoftware, beanPath, queryWhatInit, nbOfResult);
		return hquery.getResultList();
    }	
   /**
    * @returns an JPA Hsql query based on entity Software and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPAQuery (Software softwareWhat, Software positiveSoftware, Software negativeSoftware, Map beanPath, QueryWhatInit queryWhatInit, Integer nbOfResult) {
	   Query query = getPartialLoadWithParentJPARawQuery (softwareWhat, positiveSoftware, negativeSoftware, beanPath, queryWhatInit);
	   if (nbOfResult!=null)
	      query.setMaxResults(nbOfResult);
	   return query;
    }
  	
   /**
    * @returns an JPA Raw Hsql query based on entity Software and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPARawQuery (Software softwareWhat, Software positiveSoftware, Software negativeSoftware, Map beanPath, QueryWhatInit queryWhatInit) {
	   return getEntityManager().createQuery(getPartialLoadWithParentRawHsqlQuery (softwareWhat, positiveSoftware, negativeSoftware, beanPath, queryWhatInit));
    }
	
	private List<Software> handlePartialLoadWithParentSoftware(List<Object[]> list, Map<Integer, String> beanPath, Software softwareWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentSoftware(list, beanPath, softwareWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentSoftware, message:"+ex.getMessage());
			return new ArrayList<Software>();
		}
    }

	private List<Software> handlePartialLoadWithParentSoftwareWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, Software softwareWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentSoftwareWithOneElementInRow(list, beanPath, softwareWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentSoftwareWithOneElementInRow, message:"+ex.getMessage());
			return new ArrayList<Software>();
		}
    }
    	
	 private List<Software> convertPartialLoadWithParentSoftware(List<Object[]> list, Map<Integer, String> beanPath, Software softwareWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<Software> resultList = new ArrayList<Software>();
		 for (Object[] row : list) {		
		    Software software = cloneSoftware (softwareWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populateSoftware (software, row[(Integer)entry.getKey()], (String)entry.getValue());
		    }
		    resultList.add(software);
		 }
		 return resultList;		
	 }	
    
	 private List<Software> convertPartialLoadWithParentSoftwareWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, Software softwareWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<Software> resultList = new ArrayList<Software>();
		 for (Object row : list) {		
		    Software software = cloneSoftware (softwareWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populateSoftware (software, row, (String)entry.getValue());
		    }
		    resultList.add(software);
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
	public String getPartialLoadWithParentRawHsqlQuery (Software software, Software positiveSoftware, Software negativeSoftware, Map beanPath, QueryWhatInit queryWhatInit) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentSoftwareQuery (software, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
		Hashtable aliasWhereHt = new Hashtable();
		String where = getPartialLoadWithParentWhereQuery (positiveSoftware, null, aliasWhatHt, aliasWhereHt, null, null);
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
	public String findPartialLoadWithParentRawHsqlQuery (Software whatMask, Software criteriaMask, Map beanPath, QueryWhatInit queryWhatInit,  Software orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentSoftwareQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
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
	public String countPartialLoadWithParentRawHsqlQuery (Software whatMask, Software criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
		Map beanPath = new Hashtable();
		Hashtable aliasWhatHt = new Hashtable();
		// used to initiate the how part of the what
		getPartialLoadWithParentSoftwareQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", new QuerySelectInit());
		String what = "select count(software) ";
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
    	
	public String findPartialQuery (Software whatMask, Software criteriaMask, Software orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Map beanPath) {
        QueryWhatInit queryWhatInit = new QuerySelectInit();
        return findPartialLoadWithParentRawHsqlQuery(whatMask, criteriaMask, beanPath, queryWhatInit, orderMask, matchType, operandType, caseSensitivenessType,  sortOrder);
    }
	
	/**
    * partial on a single entity load enables to specify the fields you want to load explicitly
    */         
	public List<Software> partialLoadSoftware(Software software, Software positiveSoftware, Software negativeSoftware) {
	    Query hquery = getEntityManager().createQuery(getPartialLoadSoftwareQuery (software, positiveSoftware, negativeSoftware));
		int countPartialField = countPartialField(software);
		if (countPartialField==0) 
			return new ArrayList<Software>();
		List list = hquery.getResultList();
		Iterator iter = list.iterator();
		List<Software> returnList = new ArrayList<Software>();
		while(iter.hasNext()) {
			int index = 0;
			Object[] row;
			if (countPartialField==1) {
				row = new Object[1];
				row[0] = iter.next();
				} 
			else 
				row = (Object[]) iter.next();
			Software softwareResult = new Software();
			if (software.getSoftwareId() != null) {
                softwareResult.setSoftwareId((Integer) row[index]);
				index++;
			}
			if (software.getDevelopper_() != null) {
                softwareResult.setDevelopper_((Integer) row[index]);
				index++;
			}
			if (software.getEditor_() != null) {
                softwareResult.setEditor_((Integer) row[index]);
				index++;
			}
			if (software.getName() != null) {
                softwareResult.setName((String) row[index]);
				index++;
			}
			if (software.getDescription() != null) {
                softwareResult.setDescription((String) row[index]);
				index++;
			}
			if (software.getConsole_() != null) {
                softwareResult.setConsole_((Integer) row[index]);
				index++;
			}
			if (software.getStyle_() != null) {
                softwareResult.setStyle_((Integer) row[index]);
				index++;
			}
			if (software.getSerialNumber() != null) {
                softwareResult.setSerialNumber((String) row[index]);
				index++;
			}
			if (software.getRegion_() != null) {
                softwareResult.setRegion_((Integer) row[index]);
				index++;
			}
			if (software.getSubRegionCode() != null) {
                softwareResult.setSubRegionCode((String) row[index]);
				index++;
			}
			if (software.getReleaseDate() != null) {
                softwareResult.setReleaseDate((java.util.Date) row[index]);
				index++;
			}
			if (software.getAcquiringDate() != null) {
                softwareResult.setAcquiringDate((java.util.Date) row[index]);
				index++;
			}
			if (software.getAcquiringPrice() != null) {
                softwareResult.setAcquiringPrice((java.math.BigDecimal) row[index]);
				index++;
			}
			if (software.getAcquiredPriceFree() != null) {
                softwareResult.setAcquiredPriceFree((Boolean) row[index]);
				index++;
			}
			if (software.getAcquiredPriceUnknown() != null) {
                softwareResult.setAcquiredPriceUnknown((Boolean) row[index]);
				index++;
			}
			if (software.getAcquiringSellerName() != null) {
                softwareResult.setAcquiringSellerName((String) row[index]);
				index++;
			}
			if (software.getAcquiringPlace() != null) {
                softwareResult.setAcquiringPlace((String) row[index]);
				index++;
			}
			if (software.getLocation_() != null) {
                softwareResult.setLocation_((Integer) row[index]);
				index++;
			}
			if (software.getHasBox() != null) {
                softwareResult.setHasBox((Boolean) row[index]);
				index++;
			}
			if (software.getHasManual() != null) {
                softwareResult.setHasManual((Boolean) row[index]);
				index++;
			}
			if (software.getHasInserts() != null) {
                softwareResult.setHasInserts((String) row[index]);
				index++;
			}
			if (software.getIsSealed() != null) {
                softwareResult.setIsSealed((Boolean) row[index]);
				index++;
			}
			if (software.getIsNew() != null) {
                softwareResult.setIsNew((Boolean) row[index]);
				index++;
			}
			if (software.getIsCompleteInBox() != null) {
                softwareResult.setIsCompleteInBox((Boolean) row[index]);
				index++;
			}
			if (software.getSoftwareStateRating() != null) {
                softwareResult.setSoftwareStateRating((Integer) row[index]);
				index++;
			}
			if (software.getBoxStateRating() != null) {
                softwareResult.setBoxStateRating((Integer) row[index]);
				index++;
			}
			if (software.getManualStateRating() != null) {
                softwareResult.setManualStateRating((Integer) row[index]);
				index++;
			}
			if (software.getComment() != null) {
                softwareResult.setComment((String) row[index]);
				index++;
			}
			if (software.getBarcode() != null) {
                softwareResult.setBarcode((String) row[index]);
				index++;
			}
			returnList.add(softwareResult);
        }
	    return returnList;
	}

	public static String getPartialLoadWithParentWhereQuery (
	   Software criteriaMask, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias,
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
	   Software software, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias) {
	   if (software==null)
	      return "";
	   String alias = null;
	   if (aliasWhereHt == null) {
	      aliasWhereHt = new Hashtable();
	   } 
	   if (isLookedUp(software)){
	      alias = getNextAlias (aliasWhereHt, software);
		  aliasWhereHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (software.getSoftwareId() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".softwareId = "+ software.getSoftwareId() + " ");
       }
       if (software.getDevelopper() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".developper = "+ software.getDevelopper() + " ");
       }
       if (software.getEditor() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".editor = "+ software.getEditor() + " ");
       }
       if (software.getName() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".name = '"+ software.getName()+"' ");
       }
       if (software.getDescription() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".description = '"+ software.getDescription()+"' ");
       }
       if (software.getConsole() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".console = "+ software.getConsole() + " ");
       }
       if (software.getStyle() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".style = "+ software.getStyle() + " ");
       }
       if (software.getSerialNumber() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".serialNumber = '"+ software.getSerialNumber()+"' ");
       }
       if (software.getRegion() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".region = "+ software.getRegion() + " ");
       }
       if (software.getSubRegionCode() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".subRegionCode = '"+ software.getSubRegionCode()+"' ");
       }
       if (software.getReleaseDate() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".releaseDate = '"+ software.getReleaseDate()+"' ");
       }
       if (software.getAcquiringDate() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".acquiringDate = '"+ software.getAcquiringDate()+"' ");
       }
       if (software.getAcquiringPrice() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".acquiringPrice = "+ software.getAcquiringPrice() + " ");
       }
       if (software.getAcquiredPriceFree() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".acquiredPriceFree = '"+ software.getAcquiredPriceFree()+"' ");
       }
       if (software.getAcquiredPriceUnknown() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".acquiredPriceUnknown = '"+ software.getAcquiredPriceUnknown()+"' ");
       }
       if (software.getAcquiringSellerName() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".acquiringSellerName = '"+ software.getAcquiringSellerName()+"' ");
       }
       if (software.getAcquiringPlace() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".acquiringPlace = '"+ software.getAcquiringPlace()+"' ");
       }
       if (software.getLocation() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".location = "+ software.getLocation() + " ");
       }
       if (software.getHasBox() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".hasBox = '"+ software.getHasBox()+"' ");
       }
       if (software.getHasManual() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".hasManual = '"+ software.getHasManual()+"' ");
       }
       if (software.getHasInserts() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".hasInserts = '"+ software.getHasInserts()+"' ");
       }
       if (software.getIsSealed() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".isSealed = '"+ software.getIsSealed()+"' ");
       }
       if (software.getIsNew() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".isNew = '"+ software.getIsNew()+"' ");
       }
       if (software.getIsCompleteInBox() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".isCompleteInBox = '"+ software.getIsCompleteInBox()+"' ");
       }
       if (software.getSoftwareStateRating() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".softwareStateRating = "+ software.getSoftwareStateRating() + " ");
       }
       if (software.getBoxStateRating() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".boxStateRating = "+ software.getBoxStateRating() + " ");
       }
       if (software.getManualStateRating() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".manualStateRating = "+ software.getManualStateRating() + " ");
       }
       if (software.getComment() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".comment = '"+ software.getComment()+"' ");
       }
       if (software.getBarcode() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".barcode = '"+ software.getBarcode()+"' ");
       }
       if (software.getConsole()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl.getPartialLoadWithParentWhereQuery(
		      software.getConsole(), 
			  isWhereSet, aliasHt, aliasWhereHt, alias, "console");
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  }  	  
	   }
       if (software.getLocation()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.LocationJPAImpl.getPartialLoadWithParentWhereQuery(
		      software.getLocation(), 
			  isWhereSet, aliasHt, aliasWhereHt, alias, "location");
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  }  	  
	   }
       if (software.getEditor()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ProducerJPAImpl.getPartialLoadWithParentWhereQuery(
		      software.getEditor(), 
			  isWhereSet, aliasHt, aliasWhereHt, alias, "editor");
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  }  	  
	   }
       if (software.getDevelopper()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ProducerJPAImpl.getPartialLoadWithParentWhereQuery(
		      software.getDevelopper(), 
			  isWhereSet, aliasHt, aliasWhereHt, alias, "developper");
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  }  	  
	   }
       if (software.getRegion()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl.getPartialLoadWithParentWhereQuery(
		      software.getRegion(), 
			  isWhereSet, aliasHt, aliasWhereHt, alias, "region");
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  }  	  
	   }
       if (software.getStyle()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl.getPartialLoadWithParentWhereQuery(
		      software.getStyle(), 
			  isWhereSet, aliasHt, aliasWhereHt, alias, "style");
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
	
    public static String getPartialLoadWithParentSoftwareQuery (
	   Software software, Boolean isWhereSet, Hashtable aliasHt, String childAlias, String childFKAlias, Map beanPath, String rootPath, QueryWhatInit queryWhatInit) {
	   if (software==null)
	      return "";
	   String alias = null;
	   if (aliasHt == null) {
	      aliasHt = new Hashtable();
	   } 
	   if (isLookedUp(software)){
	      alias = getNextAlias (aliasHt, software);
		  aliasHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (software.getSoftwareId() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"softwareId");
          query.append(" "+alias+".softwareId ");
       }
       if (software.getDevelopper() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"developper");
          query.append(" "+alias+".developper ");
       }
       if (software.getEditor() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"editor");
          query.append(" "+alias+".editor ");
       }
       if (software.getName() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"name");
          query.append(" "+alias+".name ");
       }
       if (software.getDescription() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"description");
          query.append(" "+alias+".description ");
       }
       if (software.getConsole() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"console");
          query.append(" "+alias+".console ");
       }
       if (software.getStyle() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"style");
          query.append(" "+alias+".style ");
       }
       if (software.getSerialNumber() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"serialNumber");
          query.append(" "+alias+".serialNumber ");
       }
       if (software.getRegion() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"region");
          query.append(" "+alias+".region ");
       }
       if (software.getSubRegionCode() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"subRegionCode");
          query.append(" "+alias+".subRegionCode ");
       }
       if (software.getReleaseDate() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"releaseDate");
          query.append(" "+alias+".releaseDate ");
       }
       if (software.getAcquiringDate() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"acquiringDate");
          query.append(" "+alias+".acquiringDate ");
       }
       if (software.getAcquiringPrice() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"acquiringPrice");
          query.append(" "+alias+".acquiringPrice ");
       }
       if (software.getAcquiredPriceFree() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"acquiredPriceFree");
          query.append(" "+alias+".acquiredPriceFree ");
       }
       if (software.getAcquiredPriceUnknown() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"acquiredPriceUnknown");
          query.append(" "+alias+".acquiredPriceUnknown ");
       }
       if (software.getAcquiringSellerName() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"acquiringSellerName");
          query.append(" "+alias+".acquiringSellerName ");
       }
       if (software.getAcquiringPlace() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"acquiringPlace");
          query.append(" "+alias+".acquiringPlace ");
       }
       if (software.getLocation() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"location");
          query.append(" "+alias+".location ");
       }
       if (software.getHasBox() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"hasBox");
          query.append(" "+alias+".hasBox ");
       }
       if (software.getHasManual() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"hasManual");
          query.append(" "+alias+".hasManual ");
       }
       if (software.getHasInserts() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"hasInserts");
          query.append(" "+alias+".hasInserts ");
       }
       if (software.getIsSealed() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"isSealed");
          query.append(" "+alias+".isSealed ");
       }
       if (software.getIsNew() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"isNew");
          query.append(" "+alias+".isNew ");
       }
       if (software.getIsCompleteInBox() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"isCompleteInBox");
          query.append(" "+alias+".isCompleteInBox ");
       }
       if (software.getSoftwareStateRating() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"softwareStateRating");
          query.append(" "+alias+".softwareStateRating ");
       }
       if (software.getBoxStateRating() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"boxStateRating");
          query.append(" "+alias+".boxStateRating ");
       }
       if (software.getManualStateRating() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"manualStateRating");
          query.append(" "+alias+".manualStateRating ");
       }
       if (software.getComment() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"comment");
          query.append(" "+alias+".comment ");
       }
       if (software.getBarcode() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"barcode");
          query.append(" "+alias+".barcode ");
       }
       if (software.getConsole()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl.getPartialLoadWithParentValueListQuery(
		      software.getConsole(), 
			  isWhereSet, aliasHt, alias, "console", beanPath, rootPath+"console.", queryWhatInit);
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  } 
	   }  
       if (software.getLocation()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.LocationJPAImpl.getPartialLoadWithParentLocationQuery(
		      software.getLocation(), 
			  isWhereSet, aliasHt, alias, "location", beanPath, rootPath+"location.", queryWhatInit);
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  } 
	   }  
       if (software.getEditor()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ProducerJPAImpl.getPartialLoadWithParentProducerQuery(
		      software.getEditor(), 
			  isWhereSet, aliasHt, alias, "editor", beanPath, rootPath+"editor.", queryWhatInit);
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  } 
	   }  
       if (software.getDevelopper()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ProducerJPAImpl.getPartialLoadWithParentProducerQuery(
		      software.getDevelopper(), 
			  isWhereSet, aliasHt, alias, "developper", beanPath, rootPath+"developper.", queryWhatInit);
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  } 
	   }  
       if (software.getRegion()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl.getPartialLoadWithParentValueListQuery(
		      software.getRegion(), 
			  isWhereSet, aliasHt, alias, "region", beanPath, rootPath+"region.", queryWhatInit);
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  } 
	   }  
       if (software.getStyle()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.ValueListJPAImpl.getPartialLoadWithParentValueListQuery(
		      software.getStyle(), 
			  isWhereSet, aliasHt, alias, "style", beanPath, rootPath+"style.", queryWhatInit);
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  } 
	   }  
//       query.append(getSoftwareSearchEqualQuery (positiveSoftware, negativeSoftware));
	   return query.toString(); 
    }
	
	protected static String getAliasConnection(String existingAlias, String childAlias, String childFKAlias) {
		if (childAlias==null)
		   return "";
		return childAlias+"."+childFKAlias+" = "+existingAlias+"."+"softwareId";
	}
	
	protected static String getAliasKey (String alias) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return "Software|"+alias;
	}
	
	protected static String getAliasKeyAlias (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return StringUtils.substringAfter(aliasKey, "|");
	}
	
	protected static String getAliasKeyDomain (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
	  return StringUtils.substringBefore(aliasKey, "|");
	}
	
	protected static String getNextAlias (Hashtable aliasHt, Software software) {
		int cptSameAlias = 0;
		Enumeration<String> _keys = aliasHt.keys();
		while (_keys.hasMoreElements()) {
			String _key = _keys.nextElement();
			if (_key.startsWith("software"))
				cptSameAlias++;
		}
		if (cptSameAlias==0)
			return "software";
		else
			return "software_"+cptSameAlias;
	}
	
	
	protected static boolean isLookedUp (Software software) {
	   if (software==null)
		  return false;
       if (software.getSoftwareId() != null) {
	      return true;
       }
       if (software.getDevelopper() != null) {
	      return true;
       }
       if (software.getEditor() != null) {
	      return true;
       }
       if (software.getName() != null) {
	      return true;
       }
       if (software.getDescription() != null) {
	      return true;
       }
       if (software.getConsole() != null) {
	      return true;
       }
       if (software.getStyle() != null) {
	      return true;
       }
       if (software.getSerialNumber() != null) {
	      return true;
       }
       if (software.getRegion() != null) {
	      return true;
       }
       if (software.getSubRegionCode() != null) {
	      return true;
       }
       if (software.getReleaseDate() != null) {
	      return true;
       }
       if (software.getAcquiringDate() != null) {
	      return true;
       }
       if (software.getAcquiringPrice() != null) {
	      return true;
       }
       if (software.getAcquiredPriceFree() != null) {
	      return true;
       }
       if (software.getAcquiredPriceUnknown() != null) {
	      return true;
       }
       if (software.getAcquiringSellerName() != null) {
	      return true;
       }
       if (software.getAcquiringPlace() != null) {
	      return true;
       }
       if (software.getLocation() != null) {
	      return true;
       }
       if (software.getHasBox() != null) {
	      return true;
       }
       if (software.getHasManual() != null) {
	      return true;
       }
       if (software.getHasInserts() != null) {
	      return true;
       }
       if (software.getIsSealed() != null) {
	      return true;
       }
       if (software.getIsNew() != null) {
	      return true;
       }
       if (software.getIsCompleteInBox() != null) {
	      return true;
       }
       if (software.getSoftwareStateRating() != null) {
	      return true;
       }
       if (software.getBoxStateRating() != null) {
	      return true;
       }
       if (software.getManualStateRating() != null) {
	      return true;
       }
       if (software.getComment() != null) {
	      return true;
       }
       if (software.getBarcode() != null) {
	      return true;
       }
       if (software.getConsole()!=null) {
	      return true;
	   }  
       if (software.getLocation()!=null) {
	      return true;
	   }  
       if (software.getEditor()!=null) {
	      return true;
	   }  
       if (software.getDevelopper()!=null) {
	      return true;
	   }  
       if (software.getRegion()!=null) {
	      return true;
	   }  
       if (software.getStyle()!=null) {
	      return true;
	   }  
       return false;   
	}
	
    public String getPartialLoadSoftwareQuery(
	   Software software, 
	   Software positiveSoftware, 
	   Software negativeSoftware) {
       boolean isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (software.getSoftwareId() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" softwareId ");
       }
       if (software.getDevelopper_() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" developper_ ");
       }
       if (software.getEditor_() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" editor_ ");
       }
       if (software.getName() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" name ");
       }
       if (software.getDescription() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" description ");
       }
       if (software.getConsole_() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" console_ ");
       }
       if (software.getStyle_() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" style_ ");
       }
       if (software.getSerialNumber() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" serialNumber ");
       }
       if (software.getRegion_() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" region_ ");
       }
       if (software.getSubRegionCode() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" subRegionCode ");
       }
       if (software.getReleaseDate() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" releaseDate ");
       }
       if (software.getAcquiringDate() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" acquiringDate ");
       }
       if (software.getAcquiringPrice() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" acquiringPrice ");
       }
       if (software.getAcquiredPriceFree() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" acquiredPriceFree ");
       }
       if (software.getAcquiredPriceUnknown() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" acquiredPriceUnknown ");
       }
       if (software.getAcquiringSellerName() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" acquiringSellerName ");
       }
       if (software.getAcquiringPlace() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" acquiringPlace ");
       }
       if (software.getLocation_() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" location_ ");
       }
       if (software.getHasBox() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" hasBox ");
       }
       if (software.getHasManual() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" hasManual ");
       }
       if (software.getHasInserts() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" hasInserts ");
       }
       if (software.getIsSealed() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" isSealed ");
       }
       if (software.getIsNew() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" isNew ");
       }
       if (software.getIsCompleteInBox() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" isCompleteInBox ");
       }
       if (software.getSoftwareStateRating() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" softwareStateRating ");
       }
       if (software.getBoxStateRating() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" boxStateRating ");
       }
       if (software.getManualStateRating() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" manualStateRating ");
       }
       if (software.getComment() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" comment ");
       }
       if (software.getBarcode() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" barcode ");
       }
	   query.append(getFromEntity());
       query.append(getSoftwarePositiveNegativeCriteria (positiveSoftware, negativeSoftware));
	   return query.toString(); 
    }
	
	public List<Software> searchPrototypeWithCacheSoftware(Software software) {
		SimpleCache simpleCache = new SimpleCache();
		List<Software> list = (List<Software>)simpleCache.get(software.toString());
		if (list==null) {
			list = searchPrototypeSoftware(software);
			simpleCache.put(software.toString(), list);
		}
		return list;
	}

    public List<Software> loadGraph(Software graphMaskWhat, List<Software> whereMask) {
        return loadGraphOneLevel(graphMaskWhat, whereMask);
    }

	public List<Software> loadGraphOneLevel(Software graphMaskWhat, List<Software> whereMask) {
		//first get roots element from where list mask
		// this brings the level 0 of the graph (root level)
 		graphMaskWhat.setSoftwareId(graphMaskWhat.integerMask__);
		List<Software> softwares = searchPrototypeSoftware (whereMask);
		// for each sub level perform the search with a subquery then reassemble
		// 1. get all sublevel queries
		// 2. perform queries on the correct dao
		// 3. reassemble
		return getLoadGraphOneLevel (graphMaskWhat, softwares);
	}

	private List<Software> copy(List<Software> inputs) {
		List<Software> l = new ArrayList<Software>();
		for (Software input : inputs) {
			Software copy = new Software();
			copy.copy(input);
			l.add(copy);
		}
		return l;
	}
	   
	private List<Software> getLoadGraphOneLevel (Software graphMaskWhat, List<Software> parents) {
	    return loadGraphFromParentKey (graphMaskWhat, parents);
	} 
	
	public List<Software> loadGraphFromParentKey (Software graphMaskWhat, List<Software> parents) {
		//foreach children:
		//check if not empty take first
		parents = copy (parents); //working with detached entities to avoid unnecessary sql calls
		if (parents==null || parents.isEmpty())
		   return parents;
		List<String> ids = getPk (parents);
		if (graphMaskWhat.getPhotoSoftwareViaSoftwareIdPk()!=null && !graphMaskWhat.getPhotoSoftwareViaSoftwareIdPk().isEmpty()) {
			for (Photo childWhat : graphMaskWhat.getPhotoSoftwareViaSoftwareIdPk()) {
				childWhat.setSoftwareIdPk_(graphMaskWhat.integerMask__); // add to the what mask, usefull for reconciliation
				PhotoJPAImpl photoextendedjpaimpl = new PhotoJPAImpl ();
				List<Photo> children = photoextendedjpaimpl.lookupPhoto(childWhat, getFkCriteria(" softwareId ", ids), null, getEntityManager());
				reassemblePhoto (children, parents);				
				break;
			}
		}
		return parents;
	}
	
	private void reassemblePhoto (List<Photo> children, List<Software> parents) {
		for (Photo child : children) {
			for (Software parent : parents) {
				if (parent.getSoftwareId()!=null && parent.getSoftwareId().toString().equals(child.getSoftwareIdPk()+"")) {
					parent.addPhotoSoftwareViaSoftwareIdPk(child); 
					child.setSoftwareIdPk(parent);
					break;
				}
			}
		}
	}
	
	private List<String> getPk(List<Software> input) {
		List<String> s = new ArrayList<String>();
		for (Software t : input) {
			s.add(t.getSoftwareId()+"");
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
	public void find (QueryData<Software> data) {
		EntityCriteria<Software> filter = data.getEntityCriteria();
		Software entityWhat = data.getEntityWhat();
		Software criteriaMask = filter.getEntity();
		int start = data.getStart();
		int max = data.getMax();
		EntitySort<Software> entitySort = data.getEntitySort();
		QuerySortOrder sortOrder = entitySort.getOrder();
		Software sortMask = entitySort.getEntity();	

		List<Software> results = find(entityWhat, criteriaMask, sortMask, filter.getMatchType(), filter.getOperandType(), filter.getCaseSensitivenessType(), sortOrder, start, max);
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
     * return a list of Software entities 
     */
    public List<Software> getList () {
        //first lightweight implementation
        return searchPrototypeSoftware(new Software());
    }
    /**
     * return a list of Software entities and sort
     */
    public List<Software> getList (Software orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(new Software(), orderMask, sortOrder, null);
    }
    /**
     * return a list of Software entities and sort based on a Software prototype
     */
    public List<Software> list (Software mask, Software orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(mask, orderMask, sortOrder, null);
    }

	@Override
    protected String getSelectFrom() {
        return "SELECT software "+getFromEntity();
    }

    protected String getFromEntity() {
        return " FROM Software software ";
    }

    @Override
    protected String getQuerySelectFromEntity() {
        return getSelectFrom();
    }
	



}
