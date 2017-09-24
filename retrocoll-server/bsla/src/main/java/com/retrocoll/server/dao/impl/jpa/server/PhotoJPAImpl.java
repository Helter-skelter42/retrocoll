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

import com.retrocoll.server.dao.face.server.PhotoDao;
import com.retrocoll.server.domain.server.Photo;
import com.retrocoll.server.domain.server.Accessorie;
import com.retrocoll.server.domain.server.Hardware;
import com.retrocoll.server.domain.server.Software;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.retrocoll.server.dao.impl.ServerGenericDaoJpaImpl;


import com.retrocoll.server.dao.impl.jpa.server.AccessorieJPAImpl;
import com.retrocoll.server.dao.impl.jpa.server.HardwareJPAImpl;
import com.retrocoll.server.dao.impl.jpa.server.SoftwareJPAImpl;
/**
 *
 * <p>Title: PhotoJPAImpl</p>
 *
 * <p>Description: Interface of a Data access object dealing with PhotoJPAImpl
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching PhotoJPAImpl objects</p>
 *
 */


@org.springframework.stereotype.Repository(value="photoDao")

public class PhotoJPAImpl extends ServerGenericDaoJpaImpl<Photo> implements PhotoDao {
	public PhotoJPAImpl () {}
	
    /**
     * Inserts a Photo entity 
     * @param Photo photo
     */
    public void insertPhoto(Photo photo) {
       entityManager.persist(photo);
    }

    protected void insertPhoto(EntityManager emForRecursiveDao, Photo photo) {
       emForRecursiveDao.persist(photo);
    } 

    /**
     * Updates a Photo entity 
     * @param Photo photo
     */
    public Photo updatePhoto(Photo photo) {
       return entityManager.merge(photo);
    }

	/**
     * Updates a Photo entity with only the attributes set into Photo.
	 * The primary keys are to be set for this method to operate.
	 * This is a performance friendly feature, which remove the udibiquous full load and full update when an
	 * update is issued
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param Photo photo
    */ 
    @Transactional
    public Integer updateNotNullOnlyPhoto(Photo photo) {
        Query jpaQuery = getEntityManager().createQuery(getUpdateNotNullOnlyPhotoQueryChunk(photo));
        if (photo.getPhotoId() != null) {
           jpaQuery.setParameter ("photoId", photo.getPhotoId());
        }   
        if (photo.getPhoto() != null) {
           jpaQuery.setParameter ("photo", photo.getPhoto());
        }   
        if (photo.getName() != null) {
           jpaQuery.setParameter ("name", photo.getName());
        }   
        if (photo.getDescription() != null) {
           jpaQuery.setParameter ("description", photo.getDescription());
        }   
        if (photo.getHardwareIdFk_() != null) {
           jpaQuery.setParameter ("hardwareIdFk_", photo.getHardwareIdFk_());
        }   
        if (photo.getSoftwareIdPk_() != null) {
           jpaQuery.setParameter ("softwareIdPk_", photo.getSoftwareIdPk_());
        }   
        if (photo.getAccessorieIdPk_() != null) {
           jpaQuery.setParameter ("accessorieIdPk_", photo.getAccessorieIdPk_());
        }   
		return jpaQuery.executeUpdate();
    }

    protected String getUpdateNotNullOnlyPhotoQueryChunkPrototype (Photo photo) {
        boolean isSetSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update Photo photo ");
        if (photo.getPhoto() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" photo.photo = :photo");
        }
        if (photo.getName() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" photo.name = :name");
        }
        if (photo.getDescription() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" photo.description = :description");
        }
        if (photo.getHardwareIdFk() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" photo.hardwareIdFk = :hardwareIdFk");
        }
        if (photo.getSoftwareIdPk() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" photo.softwareIdPk = :softwareIdPk");
        }
        if (photo.getAccessorieIdPk() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" photo.accessorieIdPk = :accessorieIdPk");
        }
        if (isSetSet==false)
			throw new IllegalArgumentException("photo mask should contain updatable fields");
        return query.toString();
    }
    
    protected String getUpdateNotNullOnlyPhotoQueryChunk (Photo photo) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer(getUpdateNotNullOnlyPhotoQueryChunkPrototype(photo));
        if (photo.getPhotoId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
			     query.append(" photo.photoId = :photoId");
        }
        if (isWhereSet==false)
			throw new IllegalArgumentException("photo mask should contain primary key");
        return query.toString();
    }
    
                
	protected Photo assignBlankToNull (Photo photo) {
        if (photo==null)
			return null;
        if (photo.getPhoto()!=null && photo.getPhoto().equals(""))
           photo.setPhoto((String)null);
        if (photo.getName()!=null && photo.getName().equals(""))
           photo.setName((String)null);
        if (photo.getDescription()!=null && photo.getDescription().equals(""))
           photo.setDescription((String)null);
		return photo;
	}
	
	protected boolean isAllNull (Photo photo) {
	    if (photo==null)
			return true;
        if (photo.getPhotoId()!=null) 
            return false;
        if (photo.getPhoto()!=null) 
            return false;
        if (photo.getName()!=null) 
            return false;
        if (photo.getDescription()!=null) 
            return false;
        if (photo.getHardwareIdFk()!=null) 
            return false;
        if (photo.getSoftwareIdPk()!=null) 
            return false;
        if (photo.getAccessorieIdPk()!=null) 
            return false;
		return true;
	}
		
    @Transactional
    public Integer updateNotNullOnlyPrototypePhoto(Photo photo, Photo prototypeCriteria) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update Photo photo ");
        if (photo.getPhotoId() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" photo.photoId = "+ photo.getPhotoId() + " ");
        }
        if (photo.getPhoto() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" photo.photo = '"+ photo.getPhoto()+"' ");
        }
        if (photo.getName() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" photo.name = '"+ photo.getName()+"' ");
        }
        if (photo.getDescription() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" photo.description = '"+ photo.getDescription()+"' ");
        }
        if (photo.getHardwareIdFk_() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" photo.hardwareIdFk_ = "+ photo.getHardwareIdFk_() + " ");
        }
        if (photo.getSoftwareIdPk_() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" photo.softwareIdPk_ = "+ photo.getSoftwareIdPk_() + " ");
        }
        if (photo.getAccessorieIdPk_() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" photo.accessorieIdPk_ = "+ photo.getAccessorieIdPk_() + " ");
        }
		isWhereSet = false; 
        if (prototypeCriteria.getPhotoId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" photo.photoId = "+ prototypeCriteria.getPhotoId() + " ");
        }
        if (prototypeCriteria.getPhoto() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" photo.photo = '"+ prototypeCriteria.getPhoto()+"' ");
        }
        if (prototypeCriteria.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" photo.name = '"+ prototypeCriteria.getName()+"' ");
        }
        if (prototypeCriteria.getDescription() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" photo.description = '"+ prototypeCriteria.getDescription()+"' ");
        }
        if (prototypeCriteria.getHardwareIdFk_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" photo.hardwareIdFk_ = "+ prototypeCriteria.getHardwareIdFk_() + " ");
        }
        if (prototypeCriteria.getSoftwareIdPk_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" photo.softwareIdPk_ = "+ prototypeCriteria.getSoftwareIdPk_() + " ");
        }
        if (prototypeCriteria.getAccessorieIdPk_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" photo.accessorieIdPk_ = "+ prototypeCriteria.getAccessorieIdPk_() + " ");
        }
        Query jpaQuery = getEntityManager().createQuery(query.toString());
		return jpaQuery.executeUpdate();
    }
     
     /**
     * Saves a Photo entity 
     * @param Photo photo
     */
    public void savePhoto(Photo photo) {
       //entityManager.persist(photo);
       if (entityManager.contains(photo)) {
          entityManager.merge(photo);
       } else {
          entityManager.persist(photo);
       }
       entityManager.flush(); 
    }
       
    /**
     * Deletes a Photo entity 
     * @param Photo photo
     */
    public void deletePhoto(Photo photo) {
      entityManager.remove(photo);
    }
    
    /**
     * Loads the Photo entity which is related to an instance of
     * Photo
     * @param Long id
     * @return Photo The Photo entity
     
    public Photo loadPhoto(Long id) {
    	return (Photo)entityManager.get(Photo.class, id);
    }
*/
  
    /**
     * Loads the Photo entity which is related to an instance of
     * Photo
     * @param java.lang.Integer PhotoId
     * @return Photo The Photo entity
     */
    public Photo loadPhoto(java.lang.Integer photoId) {
    	return (Photo)entityManager.find(Photo.class, photoId);
    }
    
    /**
     * Loads the Photo entity which is related to an instance of
     * Photo and its dependent one to many objects
     * @param Long id
     * @return Photo The Photo entity
     */
    public Photo loadFullFirstLevelPhoto(java.lang.Integer photoId) {
        List list = getResultList(
                     "SELECT photo FROM Photo photo "
                     + " WHERE photo.photoId = "+photoId
               );
         if (list!=null && !list.isEmpty())
            return (Photo)list.get(0);
         return null;
    	//return null;//(Photo) entityManager.queryForObject("loadFullFirstLevelPhoto", id);
    }

    /**
     * Loads the Photo entity which is related to an instance of
     * Photo
     * @param Photo photo
     * @return Photo The Photo entity
     */
    public Photo loadFullFirstLevelPhoto(Photo photo) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT photo FROM Photo photo ");
        if (photo.getPhotoId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" photo.photoId = "+ photo.getPhotoId() + " ");
         }
        List list = getResultList(query.toString());
        if (list!=null && !list.isEmpty())
           return (Photo)list.get(0);    
        return null;
    }  

    /**
     * Searches a list of Photo entity 
     * @param Photo photo
     * @return List
     */  
    public List<Photo> searchPrototypePhoto(Photo photo) {
       return searchPrototype (photo, null);
    }  
	
    public List<Photo> searchPrototypeAnyPhoto(Photo photo) {
       return searchPrototypeAny (photo, null);
    }  

	// indirection
    public List<Photo> find (Photo criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
       return find (criteriaMask, matchType, operandType, caseSensitivenessType, null, null); 
	}
	
	// indirection
	protected List<Photo> find (Photo criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, Integer startPosition, Integer maxResults) {
       return find (criteriaMask, null, matchType, operandType, caseSensitivenessType, null, startPosition, maxResults); 
    }
	
	// indirection
	protected List<Photo> find (Photo criteriaMask, Photo orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
       return find (null, criteriaMask, orderMask, matchType, operandType, caseSensitivenessType, sortOrder, startPosition, maxResults);
    }
	
	// main find implementation
	protected List<Photo> find (Photo whatMask, Photo criteriaMask, Photo orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
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
    public String findQuery (Photo criteriaMask, Photo orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String what = "SELECT photo FROM Photo photo ";
		return findQuery (criteriaMask, orderMask, what, matchType, operandType, caseSensitivenessType, sortOrder);
    }

    protected String findQuery (Photo criteriaMask, Photo orderMask, String what, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String queryWhere = findWhere (criteriaMask, false, isAll(matchType), operandType, caseSensitivenessType);
		String queryOrder = findOrder (orderMask, sortOrder);
	    return getHQuery(what, queryWhere, queryOrder);
    }
	
    protected List<Photo> searchPrototype (Photo photo, Photo orderMask, QuerySortOrder sortOrder, Integer maxResults) {
       return searchPrototype(getPhotoSelectQuery (getWhereEqualWhereQueryChunk(photo), orderMask, sortOrder), maxResults);
    }

    protected List<Photo> searchPrototype (Photo photo, Integer maxResults) {
       return searchPrototype(photo, null, null, maxResults);
    }
    
    protected List<Photo> searchPrototypeAny (Photo photo, Integer maxResults) { 
       return searchPrototype(getSearchEqualAnyQuery (photo), maxResults);
    }
    
    protected List<Photo> searchPrototype (String query, Integer maxResults) { 
       Query hquery = getEntityManager().createQuery(query);
       if (maxResults!=null)
          hquery.setMaxResults(maxResults);
       return hquery.getResultList();
    }

    public List<Photo> searchPrototypePhoto (List<Photo> photos) {
       return searchPrototype (photos, null);
    }

    protected List<Photo> searchPrototype (List<Photo> photos, Integer maxResults) {    
	   return getResultList(getPhotoSearchEqualQuery (null, photos));
	}    

    protected List<Photo> getResultList (String query) {    
	   Query hquery = entityManager.createQuery(query);            
	   return hquery.getResultList();
	}    
 

    public List<Photo> searchDistinctPrototypePhoto (Photo photoMask, List<Photo> photos) {
        return getResultList(getPhotoSearchEqualQuery (photoMask, photos));    
    }
        
	/**
     * Searches a list of Photo entity 
     * @param Photo positiveMask
     * @param Photo negativeMask
     * @return List
     */
    public List<Photo> searchPrototypePhoto(Photo positiveMask, Photo negativeMask) {
	    return getResultList(getPhotoSearchEqualQuery (positiveMask, negativeMask));  
    }

    /**
    * return a string query search on a Photo prototype
    */
    protected String getPhotoSelectQuery (String where, Photo orderMask, QuerySortOrder sortOrder) {
       return getPhotoSelectQuery (where, findOrder (orderMask, sortOrder));
    }
    protected String getPhotoSelectQuery (String where, String order) {
       StringBuffer query = new StringBuffer();
       query.append ("SELECT photo FROM Photo photo ");
       return (order!=null)? getHQuery(query.toString(), where, order):getHQuery(query.toString(), where);
    }
    /**
    * return a jql query search on a Photo prototype
    */
    protected String getSearchEqualQuery (Photo photo) {
       return getPhotoSelectQuery (getWhereEqualWhereQueryChunk(photo),null);
    }
    protected String getWhereEqualWhereQueryChunk (Photo photo) {
       return getWhereEqualWhereQueryChunk(photo, false);
    }
    /**
    * return a jql query search on a Photo with any prototype
    */
    protected String getSearchEqualAnyQuery (Photo photo) {
       return getPhotoSelectQuery (getWhereEqualAnyWhereQueryChunk(photo), null);   
    }
    protected String getWhereEqualAnyWhereQueryChunk (Photo photo) {
       return getWhereEqualAnyWhereQueryChunk(photo, false);   
    }

    /**
    * return a jql search for a list of Photo prototype
    */
    protected String getPhotoSearchEqualQuery (Photo photoMask, List<Photo> photos) {
        boolean isOrSet = false;
        StringBuffer query = new StringBuffer();
        if (photoMask !=null)
           query.append (getPhotoMaskWhat (photoMask));
        query.append (" FROM Photo photo ");
        StringBuffer queryWhere = new StringBuffer();
        for (Photo photo : photos) {
           if (!isAllNull(photo)) {        
	           queryWhere.append (getQueryOR (isOrSet));
	           isOrSet = true;
	           queryWhere.append (" ("+getWhereEqualWhereQueryChunk(photo, false)+") ");
           }
        }
	    return getHQuery(query.toString(), queryWhere.toString());
    }	

    
    protected String getPhotoMaskWhat (Photo photoMask) {
        boolean isCommaSet = false;
        StringBuffer query = new StringBuffer("SELECT DISTINCT ");
        if (photoMask.getPhotoId() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" photoId ");
        }
        if (photoMask.getPhoto() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" photo ");
        }
        if (photoMask.getName() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" name ");
        }
        if (photoMask.getDescription() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" description ");
        }
        if (photoMask.getHardwareIdFk() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" hardwareIdFk ");
        }
        if (photoMask.getSoftwareIdPk() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" softwareIdPk ");
        }
        if (photoMask.getAccessorieIdPk() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" accessorieIdPk ");
        }
        if (!isCommaSet)
           return "";
	    return query.toString();
    }
    
    protected String getWhereEqualAnyWhereQueryChunk (Photo photo, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (photo, isAndSet, false);	
	}
	
    protected String getWhereEqualWhereQueryChunk (Photo photo, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (photo, isAndSet, true);
	}
	
    protected String getSearchEqualWhereQueryChunk (Photo photo, boolean isAndSet, boolean isAll) {
        StringBuffer query = new StringBuffer();
        if (photo.getPhotoId() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" photo.photoId = "+ photo.getPhotoId() + " ");
        }
        if (photo.getPhoto() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" photo.photo = '"+ photo.getPhoto()+"' ");
        }
        if (photo.getName() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" photo.name = '"+ photo.getName()+"' ");
        }
        if (photo.getDescription() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" photo.description = '"+ photo.getDescription()+"' ");
        }
        if (photo.getHardwareIdFk_() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" photo.hardwareIdFk_ = "+ photo.getHardwareIdFk_() + " ");
        }
        if (photo.getSoftwareIdPk_() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" photo.softwareIdPk_ = "+ photo.getSoftwareIdPk_() + " ");
        }
        if (photo.getAccessorieIdPk_() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" photo.accessorieIdPk_ = "+ photo.getAccessorieIdPk_() + " ");
        }
	    return query.toString();
    }

    protected String findOrder (Photo orderMask, QuerySortOrder sortOrder) {
        if (orderMask!=null) {
            String orderColumn = getFirstNotNullColumnOtherWiseNull(orderMask);
            if (orderColumn!=null)
               return orderColumn + " " + sortOrder;
        }
        return "";
    }

	@Override
    protected String findWhere (Photo photo, boolean isAndSet, boolean isAll, OperandType operandType, Boolean caseSensitive) {
		return findWhere (null, photo, isAndSet, isAll, operandType, caseSensitive);
	}
	
	protected static String findWhere (String alias, Photo photo, boolean isAndSet, boolean isAll, OperandType operandType, boolean caseSensitive) {
        if (alias==null)
			alias = "photo";
		StringBuffer query = new StringBuffer();
		String operand = getOperand (operandType);
		String evaluatorPrefix = getEvaluatorPrefix (operandType);		
		String evaluatorSuffix = getEvaluatorSuffix (operandType);		
        if (photo.getPhotoId() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".photoId = "+ photo.getPhotoId() + " ");
        }
        if (photo.getPhoto() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".photo = '"+ photo.getPhoto()+"' ");
        }
        if (photo.getName() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = photo.getName();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".name) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".name "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (photo.getDescription() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = photo.getDescription();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".description) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".description "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (photo.getHardwareIdFk_() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".hardwareIdFk_ = "+ photo.getHardwareIdFk_() + " ");
        }
        if (photo.getSoftwareIdPk_() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".softwareIdPk_ = "+ photo.getSoftwareIdPk_() + " ");
        }
        if (photo.getAccessorieIdPk_() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".accessorieIdPk_ = "+ photo.getAccessorieIdPk_() + " ");
        }
        return query.toString();
    }
	
	protected String getFirstNotNullColumnOtherWiseNull (Photo mask) {
        if (mask == null) return null;
        if (mask.getPhotoId() != null) return "photoId";
        if (mask.getPhoto() != null) return "photo";
        if (mask.getName() != null) return "name";
        if (mask.getDescription() != null) return "description";
        if (mask.getHardwareIdFk_() != null) return "hardwareIdFk";
        if (mask.getSoftwareIdPk_() != null) return "softwareIdPk";
        if (mask.getAccessorieIdPk_() != null) return "accessorieIdPk";
        return null;	
	}
    
    /**
    * return a jql search on a Photo prototype with positive and negative beans
    */
    protected String getPhotoSearchEqualQuery (Photo positiveMask, Photo negativeMask) {
		StringBuffer query = new StringBuffer();    	
		query.append(getSelectFrom());
		query.append(getPhotoPositiveNegativeCriteria(positiveMask, negativeMask));
		return query.toString();
	}

	protected String getPhotoPositiveNegativeCriteria (Photo positiveMask, Photo negativeMask) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        if (positiveMask!=null && positiveMask.getPhotoId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" photo.photoId = "+ positiveMask.getPhotoId() + " ");
        } 
		if (negativeMask!=null && negativeMask.getPhotoId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" photo.photoId is null ");
        }
        if (positiveMask!=null && positiveMask.getPhoto() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" photo.photo = '"+ positiveMask.getPhoto()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getPhoto() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" photo.photo is null ");
        }
        if (positiveMask!=null && positiveMask.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" photo.name = '"+ positiveMask.getName()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" photo.name is null ");
        }
        if (positiveMask!=null && positiveMask.getDescription() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" photo.description = '"+ positiveMask.getDescription()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getDescription() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" photo.description is null ");
        }
        if (positiveMask!=null && positiveMask.getHardwareIdFk_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" photo.hardwareIdFk_ = "+ positiveMask.getHardwareIdFk_() + " ");
        } 
		if (negativeMask!=null && negativeMask.getHardwareIdFk_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" photo.hardwareIdFk_ is null ");
        }
        if (positiveMask!=null && positiveMask.getSoftwareIdPk_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" photo.softwareIdPk_ = "+ positiveMask.getSoftwareIdPk_() + " ");
        } 
		if (negativeMask!=null && negativeMask.getSoftwareIdPk_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" photo.softwareIdPk_ is null ");
        }
        if (positiveMask!=null && positiveMask.getAccessorieIdPk_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" photo.accessorieIdPk_ = "+ positiveMask.getAccessorieIdPk_() + " ");
        } 
		if (negativeMask!=null && negativeMask.getAccessorieIdPk_() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" photo.accessorieIdPk_ is null ");
        }
	    return query.toString();
    }
 
	
	
    private Logger log = Logger.getLogger(this.getClass());
    
    private SimpleCache simpleCache = new SimpleCache();
    private EntityManager emForRecursiveDao; // dao that needs other dao in a recursive manner not support by spring configuration

    /**
     * generic to move after in superclass
     */
    public PhotoJPAImpl (EntityManager emForRecursiveDao) {
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
     * Inserts a Photo entity with cascade of its children
     * @param Photo photo
     */
    public void insertPhotoWithCascade(Photo photo) {
    	PhotoJPAImpl photojpaimpl = new PhotoJPAImpl(getEntityManager());
    	photojpaimpl.insertPhotoWithCascade(photojpaimpl.getEntityManagerForRecursiveDao(), photo);
    }
     
    public void insertPhotoWithCascade(EntityManager emForRecursiveDao, Photo photo) {
       insertPhoto(emForRecursiveDao, photo);
    }
        
    /**
     * Inserts a list of Photo entity with cascade of its children
     * @param List<Photo> photos
     */
    public void insertPhotosWithCascade(List<Photo> photos) {
       for (Photo photo : photos) {
          insertPhotoWithCascade(photo);
       }
    } 
        
    /**
     * lookup Photo entity Photo, criteria and max result number
     */
    public List<Photo> lookupPhoto(Photo photo, Criteria criteria, Integer numberOfResult, EntityManager em) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT photo FROM Photo photo ");
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
    
    public List<Photo> lookupPhoto(Photo photo, Criteria criteria, Integer numberOfResult) {
		return lookupPhoto(photo, criteria, numberOfResult, getEntityManager());
    }

    public Integer updateNotNullOnlyPhoto (Photo photo, Criteria criteria) {
        String queryWhat = getUpdateNotNullOnlyPhotoQueryChunkPrototype (photo);
        StringBuffer query = new StringBuffer (queryWhat);
        boolean isWhereSet = false;
        for (Criterion criterion : criteria.getClauseCriterions()) {
            query.append (getQueryWHERE_AND (isWhereSet));
            isWhereSet = true;   
            query.append(criterion.getExpression());			
        }  
        Query jpaQuery = getEntityManager().createQuery(query.toString());
        isWhereSet = false;
        if (photo.getPhotoId() != null) {
           jpaQuery.setParameter ("photoId", photo.getPhotoId());
        }   
        if (photo.getPhoto() != null) {
           jpaQuery.setParameter ("photo", photo.getPhoto());
        }   
        if (photo.getName() != null) {
           jpaQuery.setParameter ("name", photo.getName());
        }   
        if (photo.getDescription() != null) {
           jpaQuery.setParameter ("description", photo.getDescription());
        }   
        if (photo.getHardwareIdFk() != null) {
           jpaQuery.setParameter ("hardwareIdFk", photo.getHardwareIdFk());
        }   
        if (photo.getSoftwareIdPk() != null) {
           jpaQuery.setParameter ("softwareIdPk", photo.getSoftwareIdPk());
        }   
        if (photo.getAccessorieIdPk() != null) {
           jpaQuery.setParameter ("accessorieIdPk", photo.getAccessorieIdPk());
        }   
		return jpaQuery.executeUpdate();
    }
	
	public Photo affectPhoto (Photo photo) {
	    return referPhoto (photo, null, false);		    
	}
		
	/**
	 * Assign the first photo retrieved corresponding to the photo criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no photo corresponding in the database. Then photo is inserted and returned with its primary key(s). 
	 */
	public Photo assignPhoto (Photo photo) {
		return referPhoto (photo, null, true);
	}

	/**
	 * Assign the first photo retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no photo corresponding in the database. 
	 * Then photo is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public Photo assignPhoto (Photo photo, Photo mask) {
		return referPhoto (photo, mask, true);
	}

	public Photo referPhoto (Photo photo, Photo mask, boolean isAssign) {
		photo = assignBlankToNull (photo);
		if (isAllNull(photo))
			return null;
		else {
			List<Photo> list;
			if (mask==null)
				list = searchPrototypePhoto(photo);
			else
				list = searchPrototypePhoto(mask);
			if (list.isEmpty()) {
			    if (isAssign)
			       insertPhoto(photo);
			    else
				   return null;
			}
			else if (list.size()==1)
				photo.copy(list.get(0));
			else 
				//TODO log error
				photo.copy(list.get(0));
		}
		return photo;		    
	}

   public Photo assignPhotoUseCache (Photo photo) {
      return referPhotoUseCache (photo, true);
   }
      		
   public Photo affectPhotoUseCache (Photo photo) {
      return referPhotoUseCache (photo, false);
   }
      		
   public Photo referPhotoUseCache (Photo photo, boolean isAssign) {
	  String key = getCacheKey(null, photo, null, "assignPhoto");
      Photo photoCache = (Photo)simpleCache.get(key);
      if (photoCache==null) {
         photoCache = referPhoto (photo, null, isAssign);
         if (key!=null)
         	simpleCache.put(key, photoCache);
      }
      photo.copy(photoCache);
      return photoCache;
   }	

	private String getCacheKey (Photo photoWhat, Photo positivePhoto, Photo negativePhoto, String queryKey) {
	    StringBuffer sb = new StringBuffer();
	    sb.append(queryKey);
	    if (photoWhat!=null)
	       sb.append(photoWhat.toStringWithParents());
	    if (positivePhoto!=null)
	       sb.append(positivePhoto.toStringWithParents());
	    if (negativePhoto!=null)
	       sb.append(negativePhoto.toStringWithParents());
	    return sb.toString();
	}
	
    public Photo partialLoadWithParentFirstPhoto(Photo photoWhat, Photo positivePhoto, Photo negativePhoto){
		List <Photo> list = partialLoadWithParentPhoto(photoWhat, positivePhoto, negativePhoto);
		return (!list.isEmpty())?(Photo)list.get(0):null;
    }
    
    public Photo partialLoadWithParentFirstPhotoUseCache(Photo photoWhat, Photo positivePhoto, Photo negativePhoto, Boolean useCache){
		List <Photo> list = partialLoadWithParentPhotoUseCache(photoWhat, positivePhoto, negativePhoto, useCache);
		return (!list.isEmpty())?(Photo)list.get(0):null;
    }
	
	public Photo partialLoadWithParentFirstPhotoUseCacheOnResult(Photo photoWhat, Photo positivePhoto, Photo negativePhoto, Boolean useCache){
		List <Photo> list = partialLoadWithParentPhotoUseCacheOnResult(photoWhat, positivePhoto, negativePhoto, useCache);
		return (!list.isEmpty())?(Photo)list.get(0):null;
    }
	//
	protected List<Photo> partialLoadWithParentPhoto(Photo photoWhat, Photo positivePhoto, Photo negativePhoto, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentPhoto(photoWhat, positivePhoto, negativePhoto, new QuerySelectInit(), nbOfResult, useCache);
	}	  

	protected List partialLoadWithParentPhotoQueryResult (Photo photoWhat, Photo positivePhoto, Photo negativePhoto, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentPhotoQueryResult (photoWhat, positivePhoto, negativePhoto, new QuerySelectInit(), nbOfResult, useCache);
	}	
    
    public List<Photo> getDistinctPhoto(Photo photoWhat, Photo positivePhoto, Photo negativePhoto) {
		 return partialLoadWithParentPhoto(photoWhat, positivePhoto, negativePhoto, new QuerySelectDistinctInit(), null, false);
	}
	
	public List<Photo> partialLoadWithParentPhoto(Photo photoWhat, Photo positivePhoto, Photo negativePhoto) {
		 return partialLoadWithParentPhoto(photoWhat, positivePhoto, negativePhoto, new QuerySelectInit(), null, false);
	}	
  
	public List<Photo> partialLoadWithParentPhotoUseCacheOnResult(Photo photoWhat, Photo positivePhoto, Photo negativePhoto, Boolean useCache) {
		String key = getCacheKey(photoWhat, positivePhoto, negativePhoto, "partialLoadWithParentPhoto");
		List<Photo> list = (List<Photo>)simpleCache.get(key);
		if (list==null || list.isEmpty()) {
			list = partialLoadWithParentPhoto(photoWhat, positivePhoto, negativePhoto);
			if (!list.isEmpty())
			   simpleCache.put(key, list);
		}
		return list;	
	}	

	public List<Photo> partialLoadWithParentPhotoUseCache(Photo photoWhat, Photo positivePhoto, Photo negativePhoto, Boolean useCache) {
		String key = getCacheKey(photoWhat, positivePhoto, negativePhoto, "partialLoadWithParentPhoto");
		List<Photo> list = (List<Photo>)simpleCache.get(key);
		if (list==null) {
			list = partialLoadWithParentPhoto(photoWhat, positivePhoto, negativePhoto);
			simpleCache.put(key, list);
		}
		return list;	
	}	
	
	private List<Photo> handleLoadWithParentPhoto(Map beanPath, List list, Photo photoWhat) {
	    return handleLoadWithParentPhoto(beanPath, list, photoWhat, true);  
	}
	
	private List<Photo> handleLoadWithParentPhoto(Map beanPath, List list, Photo photoWhat, boolean isHql) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentPhotoWithOneElementInRow(list, beanPath, photoWhat, isHql);
		}
		return handlePartialLoadWithParentPhoto(list, beanPath, photoWhat, isHql);	
	}
	
    	// to set in super class	
	protected void populatePhoto (Photo photo, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(photo, beanPath, value);
	}
	
	protected void populatePhotoFromSQL (Photo photo, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(photo, beanPath, value);
	}
    	// to set in super class BEWARE: genericity is only one level!!!!! first level is a copy second level is a reference!!! change to photo.clone() instead
	private Photo clonePhoto (Photo photo) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		//return (Photo) BeanUtils.cloneBeanObject(photo);
	   if (photo==null) return new Photo();
	   return photo.clone();
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
	
    public List<Photo> countDistinct (Photo whatMask, Photo whereEqCriteria) {
       return partialLoadWithParentPhoto(whatMask, whereEqCriteria, null, new QuerySelectCountInit("photo"), null, false);
    }   
  	
    public Long count(Photo whereEqCriteria) {
	    return count(null, whereEqCriteria, EntityMatchType.ALL, OperandType.EQUALS, true); 
/*        Query query = getEntityManager().createQuery(getSelectCountPrototype(whereEqCriteria));
        List<Long> list = query.getResultList();
    	if (!list.isEmpty()) {
            return list.get(0);
    	}
    	return 0L;
*/
    }


    public Long count(Photo whatMask, Photo whereCriteria, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
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

	protected String countQuery (Photo photo, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
        String what = "SELECT count(*) FROM Photo photo ";
		return findQuery (photo, null, what, matchType, operandType, caseSensitivenessType, null);
    }
	

   private List getFirstResultWhereConditionsAre (Photo photo) {
      return partialLoadWithParentPhotoQueryResult(getDefaultPhotoWhat(), photo, null, 1, false);	
   }
   
   protected Photo getDefaultPhotoWhat() {
      Photo photo = new Photo();
      photo.setPhotoId(Integer.valueOf(-1));
      return photo;
   }
   
	public Photo getFirstPhoto (Photo photo) {
		if (isAllNull(photo))
			return null;
		else {
			List<Photo> list = searchPrototype (photo, 1);
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
    * checks if the Photo entity exists
    */           
    public boolean existsPhoto (Photo photo) {
       if (getFirstPhoto(photo)!=null)
          return true;
       return false;  
    }
        
    public boolean existsPhotoWhereConditionsAre (Photo photo) {
       if (getFirstResultWhereConditionsAre (photo).isEmpty())
          return false;
       return true;  
    }

	private int countPartialField (Photo photo) {
	   int cpt = 0;
       if (photo.getPhotoId() != null) {
          cpt++;
       }
       if (photo.getPhoto() != null) {
          cpt++;
       }
       if (photo.getName() != null) {
          cpt++;
       }
       if (photo.getDescription() != null) {
          cpt++;
       }
       if (photo.getHardwareIdFk_() != null) {
          cpt++;
       }
       if (photo.getSoftwareIdPk_() != null) {
          cpt++;
       }
       if (photo.getAccessorieIdPk_() != null) {
          cpt++;
       }
       return cpt;
	}   

	public List<Photo> partialLoadWithParentPhoto(Photo what, Photo positivePhoto, Photo negativePhoto, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		Map beanPath = new Hashtable();
		List list = partialLoadWithParentPhotoJPAQueryResult (what, positivePhoto, negativePhoto, queryWhatInit, beanPath, nbOfResult, useCache);
		return handlePartialLoadWithParentResult(what, list, beanPath);
	}
	
	public List<Photo> handlePartialLoadWithParentResult(Photo what, List list, Map beanPath) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentPhotoWithOneElementInRow(list, beanPath, what, true);
		}
		return handlePartialLoadWithParentPhoto(list, beanPath, what, true);
	}	

	private List partialLoadWithParentPhotoQueryResult(Photo photoWhat, Photo positivePhoto, Photo negativePhoto, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		return partialLoadWithParentPhotoJPAQueryResult (photoWhat, positivePhoto, negativePhoto, queryWhatInit, new Hashtable(), nbOfResult, useCache);
    }	
  
	private List partialLoadWithParentPhotoJPAQueryResult(Photo photoWhat, Photo positivePhoto, Photo negativePhoto, QueryWhatInit queryWhatInit, Map beanPath, Integer nbOfResult, Boolean useCache) {
		Query hquery = getPartialLoadWithParentJPAQuery (photoWhat, positivePhoto, negativePhoto, beanPath, queryWhatInit, nbOfResult);
		return hquery.getResultList();
    }	
   /**
    * @returns an JPA Hsql query based on entity Photo and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPAQuery (Photo photoWhat, Photo positivePhoto, Photo negativePhoto, Map beanPath, QueryWhatInit queryWhatInit, Integer nbOfResult) {
	   Query query = getPartialLoadWithParentJPARawQuery (photoWhat, positivePhoto, negativePhoto, beanPath, queryWhatInit);
	   if (nbOfResult!=null)
	      query.setMaxResults(nbOfResult);
	   return query;
    }
  	
   /**
    * @returns an JPA Raw Hsql query based on entity Photo and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPARawQuery (Photo photoWhat, Photo positivePhoto, Photo negativePhoto, Map beanPath, QueryWhatInit queryWhatInit) {
	   return getEntityManager().createQuery(getPartialLoadWithParentRawHsqlQuery (photoWhat, positivePhoto, negativePhoto, beanPath, queryWhatInit));
    }
	
	private List<Photo> handlePartialLoadWithParentPhoto(List<Object[]> list, Map<Integer, String> beanPath, Photo photoWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentPhoto(list, beanPath, photoWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentPhoto, message:"+ex.getMessage());
			return new ArrayList<Photo>();
		}
    }

	private List<Photo> handlePartialLoadWithParentPhotoWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, Photo photoWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentPhotoWithOneElementInRow(list, beanPath, photoWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentPhotoWithOneElementInRow, message:"+ex.getMessage());
			return new ArrayList<Photo>();
		}
    }
    	
	 private List<Photo> convertPartialLoadWithParentPhoto(List<Object[]> list, Map<Integer, String> beanPath, Photo photoWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<Photo> resultList = new ArrayList<Photo>();
		 for (Object[] row : list) {		
		    Photo photo = clonePhoto (photoWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populatePhoto (photo, row[(Integer)entry.getKey()], (String)entry.getValue());
		    }
		    resultList.add(photo);
		 }
		 return resultList;		
	 }	
    
	 private List<Photo> convertPartialLoadWithParentPhotoWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, Photo photoWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<Photo> resultList = new ArrayList<Photo>();
		 for (Object row : list) {		
		    Photo photo = clonePhoto (photoWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populatePhoto (photo, row, (String)entry.getValue());
		    }
		    resultList.add(photo);
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
	public String getPartialLoadWithParentRawHsqlQuery (Photo photo, Photo positivePhoto, Photo negativePhoto, Map beanPath, QueryWhatInit queryWhatInit) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentPhotoQuery (photo, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
		Hashtable aliasWhereHt = new Hashtable();
		String where = getPartialLoadWithParentWhereQuery (positivePhoto, null, aliasWhatHt, aliasWhereHt, null, null);
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
	public String findPartialLoadWithParentRawHsqlQuery (Photo whatMask, Photo criteriaMask, Map beanPath, QueryWhatInit queryWhatInit,  Photo orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentPhotoQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
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
	public String countPartialLoadWithParentRawHsqlQuery (Photo whatMask, Photo criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
		Map beanPath = new Hashtable();
		Hashtable aliasWhatHt = new Hashtable();
		// used to initiate the how part of the what
		getPartialLoadWithParentPhotoQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", new QuerySelectInit());
		String what = "select count(photo) ";
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
    	
	public String findPartialQuery (Photo whatMask, Photo criteriaMask, Photo orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Map beanPath) {
        QueryWhatInit queryWhatInit = new QuerySelectInit();
        return findPartialLoadWithParentRawHsqlQuery(whatMask, criteriaMask, beanPath, queryWhatInit, orderMask, matchType, operandType, caseSensitivenessType,  sortOrder);
    }
	
	/**
    * partial on a single entity load enables to specify the fields you want to load explicitly
    */         
	public List<Photo> partialLoadPhoto(Photo photo, Photo positivePhoto, Photo negativePhoto) {
	    Query hquery = getEntityManager().createQuery(getPartialLoadPhotoQuery (photo, positivePhoto, negativePhoto));
		int countPartialField = countPartialField(photo);
		if (countPartialField==0) 
			return new ArrayList<Photo>();
		List list = hquery.getResultList();
		Iterator iter = list.iterator();
		List<Photo> returnList = new ArrayList<Photo>();
		while(iter.hasNext()) {
			int index = 0;
			Object[] row;
			if (countPartialField==1) {
				row = new Object[1];
				row[0] = iter.next();
				} 
			else 
				row = (Object[]) iter.next();
			Photo photoResult = new Photo();
			if (photo.getPhotoId() != null) {
                photoResult.setPhotoId((Integer) row[index]);
				index++;
			}
			if (photo.getPhoto() != null) {
                photoResult.setPhoto((String) row[index]);
				index++;
			}
			if (photo.getName() != null) {
                photoResult.setName((String) row[index]);
				index++;
			}
			if (photo.getDescription() != null) {
                photoResult.setDescription((String) row[index]);
				index++;
			}
			if (photo.getHardwareIdFk_() != null) {
                photoResult.setHardwareIdFk_((Integer) row[index]);
				index++;
			}
			if (photo.getSoftwareIdPk_() != null) {
                photoResult.setSoftwareIdPk_((Integer) row[index]);
				index++;
			}
			if (photo.getAccessorieIdPk_() != null) {
                photoResult.setAccessorieIdPk_((Integer) row[index]);
				index++;
			}
			returnList.add(photoResult);
        }
	    return returnList;
	}

	public static String getPartialLoadWithParentWhereQuery (
	   Photo criteriaMask, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias,
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
	   Photo photo, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias) {
	   if (photo==null)
	      return "";
	   String alias = null;
	   if (aliasWhereHt == null) {
	      aliasWhereHt = new Hashtable();
	   } 
	   if (isLookedUp(photo)){
	      alias = getNextAlias (aliasWhereHt, photo);
		  aliasWhereHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (photo.getPhotoId() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".photoId = "+ photo.getPhotoId() + " ");
       }
       if (photo.getPhoto() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".photo = '"+ photo.getPhoto()+"' ");
       }
       if (photo.getName() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".name = '"+ photo.getName()+"' ");
       }
       if (photo.getDescription() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".description = '"+ photo.getDescription()+"' ");
       }
       if (photo.getHardwareIdFk() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".hardwareIdFk = "+ photo.getHardwareIdFk() + " ");
       }
       if (photo.getSoftwareIdPk() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".softwareIdPk = "+ photo.getSoftwareIdPk() + " ");
       }
       if (photo.getAccessorieIdPk() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".accessorieIdPk = "+ photo.getAccessorieIdPk() + " ");
       }
       if (photo.getAccessorieIdPk()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.AccessorieJPAImpl.getPartialLoadWithParentWhereQuery(
		      photo.getAccessorieIdPk(), 
			  isWhereSet, aliasHt, aliasWhereHt, alias, "accessorieIdPk");
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  }  	  
	   }
       if (photo.getHardwareIdFk()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.HardwareJPAImpl.getPartialLoadWithParentWhereQuery(
		      photo.getHardwareIdFk(), 
			  isWhereSet, aliasHt, aliasWhereHt, alias, "hardwareIdFk");
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  }  	  
	   }
       if (photo.getSoftwareIdPk()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.SoftwareJPAImpl.getPartialLoadWithParentWhereQuery(
		      photo.getSoftwareIdPk(), 
			  isWhereSet, aliasHt, aliasWhereHt, alias, "softwareIdPk");
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
	
    public static String getPartialLoadWithParentPhotoQuery (
	   Photo photo, Boolean isWhereSet, Hashtable aliasHt, String childAlias, String childFKAlias, Map beanPath, String rootPath, QueryWhatInit queryWhatInit) {
	   if (photo==null)
	      return "";
	   String alias = null;
	   if (aliasHt == null) {
	      aliasHt = new Hashtable();
	   } 
	   if (isLookedUp(photo)){
	      alias = getNextAlias (aliasHt, photo);
		  aliasHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (photo.getPhotoId() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"photoId");
          query.append(" "+alias+".photoId ");
       }
       if (photo.getPhoto() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"photo");
          query.append(" "+alias+".photo ");
       }
       if (photo.getName() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"name");
          query.append(" "+alias+".name ");
       }
       if (photo.getDescription() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"description");
          query.append(" "+alias+".description ");
       }
       if (photo.getHardwareIdFk() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"hardwareIdFk");
          query.append(" "+alias+".hardwareIdFk ");
       }
       if (photo.getSoftwareIdPk() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"softwareIdPk");
          query.append(" "+alias+".softwareIdPk ");
       }
       if (photo.getAccessorieIdPk() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"accessorieIdPk");
          query.append(" "+alias+".accessorieIdPk ");
       }
       if (photo.getAccessorieIdPk()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.AccessorieJPAImpl.getPartialLoadWithParentAccessorieQuery(
		      photo.getAccessorieIdPk(), 
			  isWhereSet, aliasHt, alias, "accessorieIdPk", beanPath, rootPath+"accessorieIdPk.", queryWhatInit);
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  } 
	   }  
       if (photo.getHardwareIdFk()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.HardwareJPAImpl.getPartialLoadWithParentHardwareQuery(
		      photo.getHardwareIdFk(), 
			  isWhereSet, aliasHt, alias, "hardwareIdFk", beanPath, rootPath+"hardwareIdFk.", queryWhatInit);
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  } 
	   }  
       if (photo.getSoftwareIdPk()!=null) {
	      String chunck = com.retrocoll.server.dao.impl.jpa.server.SoftwareJPAImpl.getPartialLoadWithParentSoftwareQuery(
		      photo.getSoftwareIdPk(), 
			  isWhereSet, aliasHt, alias, "softwareIdPk", beanPath, rootPath+"softwareIdPk.", queryWhatInit);
		  if (chunck!=null && !chunck.equals("")) {
		     query.append(chunck);
		     isWhereSet=true;
		  } 
	   }  
//       query.append(getPhotoSearchEqualQuery (positivePhoto, negativePhoto));
	   return query.toString(); 
    }
	
	protected static String getAliasConnection(String existingAlias, String childAlias, String childFKAlias) {
		if (childAlias==null)
		   return "";
		return childAlias+"."+childFKAlias+" = "+existingAlias+"."+"photoId";
	}
	
	protected static String getAliasKey (String alias) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return "Photo|"+alias;
	}
	
	protected static String getAliasKeyAlias (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return StringUtils.substringAfter(aliasKey, "|");
	}
	
	protected static String getAliasKeyDomain (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
	  return StringUtils.substringBefore(aliasKey, "|");
	}
	
	protected static String getNextAlias (Hashtable aliasHt, Photo photo) {
		int cptSameAlias = 0;
		Enumeration<String> _keys = aliasHt.keys();
		while (_keys.hasMoreElements()) {
			String _key = _keys.nextElement();
			if (_key.startsWith("photo"))
				cptSameAlias++;
		}
		if (cptSameAlias==0)
			return "photo";
		else
			return "photo_"+cptSameAlias;
	}
	
	
	protected static boolean isLookedUp (Photo photo) {
	   if (photo==null)
		  return false;
       if (photo.getPhotoId() != null) {
	      return true;
       }
       if (photo.getPhoto() != null) {
	      return true;
       }
       if (photo.getName() != null) {
	      return true;
       }
       if (photo.getDescription() != null) {
	      return true;
       }
       if (photo.getHardwareIdFk() != null) {
	      return true;
       }
       if (photo.getSoftwareIdPk() != null) {
	      return true;
       }
       if (photo.getAccessorieIdPk() != null) {
	      return true;
       }
       if (photo.getAccessorieIdPk()!=null) {
	      return true;
	   }  
       if (photo.getHardwareIdFk()!=null) {
	      return true;
	   }  
       if (photo.getSoftwareIdPk()!=null) {
	      return true;
	   }  
       return false;   
	}
	
    public String getPartialLoadPhotoQuery(
	   Photo photo, 
	   Photo positivePhoto, 
	   Photo negativePhoto) {
       boolean isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (photo.getPhotoId() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" photoId ");
       }
       if (photo.getPhoto() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" photo ");
       }
       if (photo.getName() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" name ");
       }
       if (photo.getDescription() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" description ");
       }
       if (photo.getHardwareIdFk_() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" hardwareIdFk_ ");
       }
       if (photo.getSoftwareIdPk_() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" softwareIdPk_ ");
       }
       if (photo.getAccessorieIdPk_() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" accessorieIdPk_ ");
       }
	   query.append(getFromEntity());
       query.append(getPhotoPositiveNegativeCriteria (positivePhoto, negativePhoto));
	   return query.toString(); 
    }
	
	public List<Photo> searchPrototypeWithCachePhoto(Photo photo) {
		SimpleCache simpleCache = new SimpleCache();
		List<Photo> list = (List<Photo>)simpleCache.get(photo.toString());
		if (list==null) {
			list = searchPrototypePhoto(photo);
			simpleCache.put(photo.toString(), list);
		}
		return list;
	}

    public List<Photo> loadGraph(Photo graphMaskWhat, List<Photo> whereMask) {
        return loadGraphOneLevel(graphMaskWhat, whereMask);
    }

	public List<Photo> loadGraphOneLevel(Photo graphMaskWhat, List<Photo> whereMask) {
		//first get roots element from where list mask
		// this brings the level 0 of the graph (root level)
 		graphMaskWhat.setPhotoId(graphMaskWhat.integerMask__);
		List<Photo> photos = searchPrototypePhoto (whereMask);
		// for each sub level perform the search with a subquery then reassemble
		// 1. get all sublevel queries
		// 2. perform queries on the correct dao
		// 3. reassemble
		return getLoadGraphOneLevel (graphMaskWhat, photos);
	}

	private List<Photo> copy(List<Photo> inputs) {
		List<Photo> l = new ArrayList<Photo>();
		for (Photo input : inputs) {
			Photo copy = new Photo();
			copy.copy(input);
			l.add(copy);
		}
		return l;
	}
	   
	private List<Photo> getLoadGraphOneLevel (Photo graphMaskWhat, List<Photo> parents) {
	    return loadGraphFromParentKey (graphMaskWhat, parents);
	} 
	
	public List<Photo> loadGraphFromParentKey (Photo graphMaskWhat, List<Photo> parents) {
		//foreach children:
		//check if not empty take first
		parents = copy (parents); //working with detached entities to avoid unnecessary sql calls
		if (parents==null || parents.isEmpty())
		   return parents;
		List<String> ids = getPk (parents);
		return parents;
	}
	
	private List<String> getPk(List<Photo> input) {
		List<String> s = new ArrayList<String>();
		for (Photo t : input) {
			s.add(t.getPhotoId()+"");
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
	public void find (QueryData<Photo> data) {
		EntityCriteria<Photo> filter = data.getEntityCriteria();
		Photo entityWhat = data.getEntityWhat();
		Photo criteriaMask = filter.getEntity();
		int start = data.getStart();
		int max = data.getMax();
		EntitySort<Photo> entitySort = data.getEntitySort();
		QuerySortOrder sortOrder = entitySort.getOrder();
		Photo sortMask = entitySort.getEntity();	

		List<Photo> results = find(entityWhat, criteriaMask, sortMask, filter.getMatchType(), filter.getOperandType(), filter.getCaseSensitivenessType(), sortOrder, start, max);
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
	

    /**
     * return a list of Photo entities 
     */
    public List<Photo> getList () {
        //first lightweight implementation
        return searchPrototypePhoto(new Photo());
    }
    /**
     * return a list of Photo entities and sort
     */
    public List<Photo> getList (Photo orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(new Photo(), orderMask, sortOrder, null);
    }
    /**
     * return a list of Photo entities and sort based on a Photo prototype
     */
    public List<Photo> list (Photo mask, Photo orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(mask, orderMask, sortOrder, null);
    }

	@Override
    protected String getSelectFrom() {
        return "SELECT photo "+getFromEntity();
    }

    protected String getFromEntity() {
        return " FROM Photo photo ";
    }

    @Override
    protected String getQuerySelectFromEntity() {
        return getSelectFrom();
    }
	



}
