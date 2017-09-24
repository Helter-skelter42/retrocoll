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

import com.retrocoll.server.dao.face.server.LocationDao;
import com.retrocoll.server.domain.server.Location;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.retrocoll.server.dao.impl.ServerGenericDaoJpaImpl;


import com.retrocoll.server.domain.server.Accessorie;
import com.retrocoll.server.dao.impl.jpa.server.AccessorieJPAImpl;
import com.retrocoll.server.domain.server.Hardware;
import com.retrocoll.server.dao.impl.jpa.server.HardwareJPAImpl;
import com.retrocoll.server.domain.server.Software;
import com.retrocoll.server.dao.impl.jpa.server.SoftwareJPAImpl;
/**
 *
 * <p>Title: LocationJPAImpl</p>
 *
 * <p>Description: Interface of a Data access object dealing with LocationJPAImpl
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching LocationJPAImpl objects</p>
 *
 */


@org.springframework.stereotype.Repository(value="locationDao")

public class LocationJPAImpl extends ServerGenericDaoJpaImpl<Location> implements LocationDao {
	public LocationJPAImpl () {}
	
    /**
     * Inserts a Location entity 
     * @param Location location
     */
    public void insertLocation(Location location) {
       entityManager.persist(location);
    }

    protected void insertLocation(EntityManager emForRecursiveDao, Location location) {
       emForRecursiveDao.persist(location);
    } 

    /**
     * Updates a Location entity 
     * @param Location location
     */
    public Location updateLocation(Location location) {
       return entityManager.merge(location);
    }

	/**
     * Updates a Location entity with only the attributes set into Location.
	 * The primary keys are to be set for this method to operate.
	 * This is a performance friendly feature, which remove the udibiquous full load and full update when an
	 * update is issued
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param Location location
    */ 
    @Transactional
    public Integer updateNotNullOnlyLocation(Location location) {
        Query jpaQuery = getEntityManager().createQuery(getUpdateNotNullOnlyLocationQueryChunk(location));
        if (location.getLocationId() != null) {
           jpaQuery.setParameter ("locationId", location.getLocationId());
        }   
        if (location.getLocationName() != null) {
           jpaQuery.setParameter ("locationName", location.getLocationName());
        }   
		return jpaQuery.executeUpdate();
    }

    protected String getUpdateNotNullOnlyLocationQueryChunkPrototype (Location location) {
        boolean isSetSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update Location location ");
        if (location.getLocationName() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" location.locationName = :locationName");
        }
        if (isSetSet==false)
			throw new IllegalArgumentException("location mask should contain updatable fields");
        return query.toString();
    }
    
    protected String getUpdateNotNullOnlyLocationQueryChunk (Location location) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer(getUpdateNotNullOnlyLocationQueryChunkPrototype(location));
        if (location.getLocationId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
			     query.append(" location.locationId = :locationId");
        }
        if (isWhereSet==false)
			throw new IllegalArgumentException("location mask should contain primary key");
        return query.toString();
    }
    
                
	protected Location assignBlankToNull (Location location) {
        if (location==null)
			return null;
        if (location.getLocationName()!=null && location.getLocationName().equals(""))
           location.setLocationName((String)null);
		return location;
	}
	
	protected boolean isAllNull (Location location) {
	    if (location==null)
			return true;
        if (location.getLocationId()!=null) 
            return false;
        if (location.getLocationName()!=null) 
            return false;
		return true;
	}
		
    @Transactional
    public Integer updateNotNullOnlyPrototypeLocation(Location location, Location prototypeCriteria) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update Location location ");
        if (location.getLocationId() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" location.locationId = "+ location.getLocationId() + " ");
        }
        if (location.getLocationName() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" location.locationName = '"+ location.getLocationName()+"' ");
        }
		isWhereSet = false; 
        if (prototypeCriteria.getLocationId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" location.locationId = "+ prototypeCriteria.getLocationId() + " ");
        }
        if (prototypeCriteria.getLocationName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" location.locationName = '"+ prototypeCriteria.getLocationName()+"' ");
        }
        Query jpaQuery = getEntityManager().createQuery(query.toString());
		return jpaQuery.executeUpdate();
    }
     
     /**
     * Saves a Location entity 
     * @param Location location
     */
    public void saveLocation(Location location) {
       //entityManager.persist(location);
       if (entityManager.contains(location)) {
          entityManager.merge(location);
       } else {
          entityManager.persist(location);
       }
       entityManager.flush(); 
    }
       
    /**
     * Deletes a Location entity 
     * @param Location location
     */
    public void deleteLocation(Location location) {
      entityManager.remove(location);
    }
    
    /**
     * Loads the Location entity which is related to an instance of
     * Location
     * @param Long id
     * @return Location The Location entity
     
    public Location loadLocation(Long id) {
    	return (Location)entityManager.get(Location.class, id);
    }
*/
  
    /**
     * Loads the Location entity which is related to an instance of
     * Location
     * @param java.lang.Integer LocationId
     * @return Location The Location entity
     */
    public Location loadLocation(java.lang.Integer locationId) {
    	return (Location)entityManager.find(Location.class, locationId);
    }
    
    /**
     * Loads the Location entity which is related to an instance of
     * Location and its dependent one to many objects
     * @param Long id
     * @return Location The Location entity
     */
    public Location loadFullFirstLevelLocation(java.lang.Integer locationId) {
        List list = getResultList(
                     "SELECT location FROM Location location "
                     + " LEFT JOIN location.accessorieLocationViaLocation "   
                     + " LEFT JOIN location.hardwareLocationViaLocation "   
                     + " LEFT JOIN location.softwareLocationViaLocation "   
                     + " WHERE location.locationId = "+locationId
               );
         if (list!=null && !list.isEmpty())
            return (Location)list.get(0);
         return null;
    	//return null;//(Location) entityManager.queryForObject("loadFullFirstLevelLocation", id);
    }

    /**
     * Loads the Location entity which is related to an instance of
     * Location
     * @param Location location
     * @return Location The Location entity
     */
    public Location loadFullFirstLevelLocation(Location location) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT location FROM Location location ");
        query.append (" LEFT JOIN location.accessorieLocationViaLocation ");
        query.append (" LEFT JOIN location.hardwareLocationViaLocation ");
        query.append (" LEFT JOIN location.softwareLocationViaLocation ");
        if (location.getLocationId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" location.locationId = "+ location.getLocationId() + " ");
         }
        List list = getResultList(query.toString());
        if (list!=null && !list.isEmpty())
           return (Location)list.get(0);    
        return null;
    }  

    /**
     * Searches a list of Location entity 
     * @param Location location
     * @return List
     */  
    public List<Location> searchPrototypeLocation(Location location) {
       return searchPrototype (location, null);
    }  
	
    public List<Location> searchPrototypeAnyLocation(Location location) {
       return searchPrototypeAny (location, null);
    }  

	// indirection
    public List<Location> find (Location criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
       return find (criteriaMask, matchType, operandType, caseSensitivenessType, null, null); 
	}
	
	// indirection
	protected List<Location> find (Location criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, Integer startPosition, Integer maxResults) {
       return find (criteriaMask, null, matchType, operandType, caseSensitivenessType, null, startPosition, maxResults); 
    }
	
	// indirection
	protected List<Location> find (Location criteriaMask, Location orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
       return find (null, criteriaMask, orderMask, matchType, operandType, caseSensitivenessType, sortOrder, startPosition, maxResults);
    }
	
	// main find implementation
	protected List<Location> find (Location whatMask, Location criteriaMask, Location orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
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
    public String findQuery (Location criteriaMask, Location orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String what = "SELECT location FROM Location location ";
		return findQuery (criteriaMask, orderMask, what, matchType, operandType, caseSensitivenessType, sortOrder);
    }

    protected String findQuery (Location criteriaMask, Location orderMask, String what, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String queryWhere = findWhere (criteriaMask, false, isAll(matchType), operandType, caseSensitivenessType);
		String queryOrder = findOrder (orderMask, sortOrder);
	    return getHQuery(what, queryWhere, queryOrder);
    }
	
    protected List<Location> searchPrototype (Location location, Location orderMask, QuerySortOrder sortOrder, Integer maxResults) {
       return searchPrototype(getLocationSelectQuery (getWhereEqualWhereQueryChunk(location), orderMask, sortOrder), maxResults);
    }

    protected List<Location> searchPrototype (Location location, Integer maxResults) {
       return searchPrototype(location, null, null, maxResults);
    }
    
    protected List<Location> searchPrototypeAny (Location location, Integer maxResults) { 
       return searchPrototype(getSearchEqualAnyQuery (location), maxResults);
    }
    
    protected List<Location> searchPrototype (String query, Integer maxResults) { 
       Query hquery = getEntityManager().createQuery(query);
       if (maxResults!=null)
          hquery.setMaxResults(maxResults);
       return hquery.getResultList();
    }

    public List<Location> searchPrototypeLocation (List<Location> locations) {
       return searchPrototype (locations, null);
    }

    protected List<Location> searchPrototype (List<Location> locations, Integer maxResults) {    
	   return getResultList(getLocationSearchEqualQuery (null, locations));
	}    

    protected List<Location> getResultList (String query) {    
	   Query hquery = entityManager.createQuery(query);            
	   return hquery.getResultList();
	}    
 

    public List<Location> searchDistinctPrototypeLocation (Location locationMask, List<Location> locations) {
        return getResultList(getLocationSearchEqualQuery (locationMask, locations));    
    }
        
	/**
     * Searches a list of Location entity 
     * @param Location positiveMask
     * @param Location negativeMask
     * @return List
     */
    public List<Location> searchPrototypeLocation(Location positiveMask, Location negativeMask) {
	    return getResultList(getLocationSearchEqualQuery (positiveMask, negativeMask));  
    }

    /**
    * return a string query search on a Location prototype
    */
    protected String getLocationSelectQuery (String where, Location orderMask, QuerySortOrder sortOrder) {
       return getLocationSelectQuery (where, findOrder (orderMask, sortOrder));
    }
    protected String getLocationSelectQuery (String where, String order) {
       StringBuffer query = new StringBuffer();
       query.append ("SELECT location FROM Location location ");
       return (order!=null)? getHQuery(query.toString(), where, order):getHQuery(query.toString(), where);
    }
    /**
    * return a jql query search on a Location prototype
    */
    protected String getSearchEqualQuery (Location location) {
       return getLocationSelectQuery (getWhereEqualWhereQueryChunk(location),null);
    }
    protected String getWhereEqualWhereQueryChunk (Location location) {
       return getWhereEqualWhereQueryChunk(location, false);
    }
    /**
    * return a jql query search on a Location with any prototype
    */
    protected String getSearchEqualAnyQuery (Location location) {
       return getLocationSelectQuery (getWhereEqualAnyWhereQueryChunk(location), null);   
    }
    protected String getWhereEqualAnyWhereQueryChunk (Location location) {
       return getWhereEqualAnyWhereQueryChunk(location, false);   
    }

    /**
    * return a jql search for a list of Location prototype
    */
    protected String getLocationSearchEqualQuery (Location locationMask, List<Location> locations) {
        boolean isOrSet = false;
        StringBuffer query = new StringBuffer();
        if (locationMask !=null)
           query.append (getLocationMaskWhat (locationMask));
        query.append (" FROM Location location ");
        StringBuffer queryWhere = new StringBuffer();
        for (Location location : locations) {
           if (!isAllNull(location)) {        
	           queryWhere.append (getQueryOR (isOrSet));
	           isOrSet = true;
	           queryWhere.append (" ("+getWhereEqualWhereQueryChunk(location, false)+") ");
           }
        }
	    return getHQuery(query.toString(), queryWhere.toString());
    }	

    
    protected String getLocationMaskWhat (Location locationMask) {
        boolean isCommaSet = false;
        StringBuffer query = new StringBuffer("SELECT DISTINCT ");
        if (locationMask.getLocationId() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" locationId ");
        }
        if (locationMask.getLocationName() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" locationName ");
        }
        if (!isCommaSet)
           return "";
	    return query.toString();
    }
    
    protected String getWhereEqualAnyWhereQueryChunk (Location location, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (location, isAndSet, false);	
	}
	
    protected String getWhereEqualWhereQueryChunk (Location location, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (location, isAndSet, true);
	}
	
    protected String getSearchEqualWhereQueryChunk (Location location, boolean isAndSet, boolean isAll) {
        StringBuffer query = new StringBuffer();
        if (location.getLocationId() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" location.locationId = "+ location.getLocationId() + " ");
        }
        if (location.getLocationName() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" location.locationName = '"+ location.getLocationName()+"' ");
        }
	    return query.toString();
    }

    protected String findOrder (Location orderMask, QuerySortOrder sortOrder) {
        if (orderMask!=null) {
            String orderColumn = getFirstNotNullColumnOtherWiseNull(orderMask);
            if (orderColumn!=null)
               return orderColumn + " " + sortOrder;
        }
        return "";
    }

	@Override
    protected String findWhere (Location location, boolean isAndSet, boolean isAll, OperandType operandType, Boolean caseSensitive) {
		return findWhere (null, location, isAndSet, isAll, operandType, caseSensitive);
	}
	
	protected static String findWhere (String alias, Location location, boolean isAndSet, boolean isAll, OperandType operandType, boolean caseSensitive) {
        if (alias==null)
			alias = "location";
		StringBuffer query = new StringBuffer();
		String operand = getOperand (operandType);
		String evaluatorPrefix = getEvaluatorPrefix (operandType);		
		String evaluatorSuffix = getEvaluatorSuffix (operandType);		
        if (location.getLocationId() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".locationId = "+ location.getLocationId() + " ");
        }
        if (location.getLocationName() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = location.getLocationName();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".locationName) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".locationName "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        return query.toString();
    }
	
	protected String getFirstNotNullColumnOtherWiseNull (Location mask) {
        if (mask == null) return null;
        if (mask.getLocationId() != null) return "locationId";
        if (mask.getLocationName() != null) return "locationName";
        return null;	
	}
    
    /**
    * return a jql search on a Location prototype with positive and negative beans
    */
    protected String getLocationSearchEqualQuery (Location positiveMask, Location negativeMask) {
		StringBuffer query = new StringBuffer();    	
		query.append(getSelectFrom());
		query.append(getLocationPositiveNegativeCriteria(positiveMask, negativeMask));
		return query.toString();
	}

	protected String getLocationPositiveNegativeCriteria (Location positiveMask, Location negativeMask) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        if (positiveMask!=null && positiveMask.getLocationId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" location.locationId = "+ positiveMask.getLocationId() + " ");
        } 
		if (negativeMask!=null && negativeMask.getLocationId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" location.locationId is null ");
        }
        if (positiveMask!=null && positiveMask.getLocationName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" location.locationName = '"+ positiveMask.getLocationName()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getLocationName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" location.locationName is null ");
        }
	    return query.toString();
    }
 
	
	
    private Logger log = Logger.getLogger(this.getClass());
    
    private SimpleCache simpleCache = new SimpleCache();
    private AccessorieJPAImpl accessorieextendedjpaimpl;
    private HardwareJPAImpl hardwareextendedjpaimpl;
    private SoftwareJPAImpl softwareextendedjpaimpl;
    private EntityManager emForRecursiveDao; // dao that needs other dao in a recursive manner not support by spring configuration

    /**
     * generic to move after in superclass
     */
    public LocationJPAImpl (EntityManager emForRecursiveDao) {
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
     * Inserts a Location entity with cascade of its children
     * @param Location location
     */
    public void insertLocationWithCascade(Location location) {
    	LocationJPAImpl locationjpaimpl = new LocationJPAImpl(getEntityManager());
    	locationjpaimpl.insertLocationWithCascade(locationjpaimpl.getEntityManagerForRecursiveDao(), location);
    }
     
    public void insertLocationWithCascade(EntityManager emForRecursiveDao, Location location) {
       insertLocation(emForRecursiveDao, location);
       if (!location.getAccessorieLocationViaLocation().isEmpty()) {
          AccessorieJPAImpl accessorieextendedjpaimpl = new AccessorieJPAImpl (emForRecursiveDao);
          for (Accessorie _accessorieLocationViaLocation : location.getAccessorieLocationViaLocation()) {
             accessorieextendedjpaimpl.insertAccessorieWithCascade(emForRecursiveDao, _accessorieLocationViaLocation);
          }
       } 
       if (!location.getHardwareLocationViaLocation().isEmpty()) {
          HardwareJPAImpl hardwareextendedjpaimpl = new HardwareJPAImpl (emForRecursiveDao);
          for (Hardware _hardwareLocationViaLocation : location.getHardwareLocationViaLocation()) {
             hardwareextendedjpaimpl.insertHardwareWithCascade(emForRecursiveDao, _hardwareLocationViaLocation);
          }
       } 
       if (!location.getSoftwareLocationViaLocation().isEmpty()) {
          SoftwareJPAImpl softwareextendedjpaimpl = new SoftwareJPAImpl (emForRecursiveDao);
          for (Software _softwareLocationViaLocation : location.getSoftwareLocationViaLocation()) {
             softwareextendedjpaimpl.insertSoftwareWithCascade(emForRecursiveDao, _softwareLocationViaLocation);
          }
       } 
    }
        
    /**
     * Inserts a list of Location entity with cascade of its children
     * @param List<Location> locations
     */
    public void insertLocationsWithCascade(List<Location> locations) {
       for (Location location : locations) {
          insertLocationWithCascade(location);
       }
    } 
        
    /**
     * lookup Location entity Location, criteria and max result number
     */
    public List<Location> lookupLocation(Location location, Criteria criteria, Integer numberOfResult, EntityManager em) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT location FROM Location location ");
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
    
    public List<Location> lookupLocation(Location location, Criteria criteria, Integer numberOfResult) {
		return lookupLocation(location, criteria, numberOfResult, getEntityManager());
    }

    public Integer updateNotNullOnlyLocation (Location location, Criteria criteria) {
        String queryWhat = getUpdateNotNullOnlyLocationQueryChunkPrototype (location);
        StringBuffer query = new StringBuffer (queryWhat);
        boolean isWhereSet = false;
        for (Criterion criterion : criteria.getClauseCriterions()) {
            query.append (getQueryWHERE_AND (isWhereSet));
            isWhereSet = true;   
            query.append(criterion.getExpression());			
        }  
        Query jpaQuery = getEntityManager().createQuery(query.toString());
        isWhereSet = false;
        if (location.getLocationId() != null) {
           jpaQuery.setParameter ("locationId", location.getLocationId());
        }   
        if (location.getLocationName() != null) {
           jpaQuery.setParameter ("locationName", location.getLocationName());
        }   
		return jpaQuery.executeUpdate();
    }
	
	public Location affectLocation (Location location) {
	    return referLocation (location, null, false);		    
	}
		
	/**
	 * Assign the first location retrieved corresponding to the location criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no location corresponding in the database. Then location is inserted and returned with its primary key(s). 
	 */
	public Location assignLocation (Location location) {
		return referLocation (location, null, true);
	}

	/**
	 * Assign the first location retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no location corresponding in the database. 
	 * Then location is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public Location assignLocation (Location location, Location mask) {
		return referLocation (location, mask, true);
	}

	public Location referLocation (Location location, Location mask, boolean isAssign) {
		location = assignBlankToNull (location);
		if (isAllNull(location))
			return null;
		else {
			List<Location> list;
			if (mask==null)
				list = searchPrototypeLocation(location);
			else
				list = searchPrototypeLocation(mask);
			if (list.isEmpty()) {
			    if (isAssign)
			       insertLocation(location);
			    else
				   return null;
			}
			else if (list.size()==1)
				location.copy(list.get(0));
			else 
				//TODO log error
				location.copy(list.get(0));
		}
		return location;		    
	}

   public Location assignLocationUseCache (Location location) {
      return referLocationUseCache (location, true);
   }
      		
   public Location affectLocationUseCache (Location location) {
      return referLocationUseCache (location, false);
   }
      		
   public Location referLocationUseCache (Location location, boolean isAssign) {
	  String key = getCacheKey(null, location, null, "assignLocation");
      Location locationCache = (Location)simpleCache.get(key);
      if (locationCache==null) {
         locationCache = referLocation (location, null, isAssign);
         if (key!=null)
         	simpleCache.put(key, locationCache);
      }
      location.copy(locationCache);
      return locationCache;
   }	

	private String getCacheKey (Location locationWhat, Location positiveLocation, Location negativeLocation, String queryKey) {
	    StringBuffer sb = new StringBuffer();
	    sb.append(queryKey);
	    if (locationWhat!=null)
	       sb.append(locationWhat.toStringWithParents());
	    if (positiveLocation!=null)
	       sb.append(positiveLocation.toStringWithParents());
	    if (negativeLocation!=null)
	       sb.append(negativeLocation.toStringWithParents());
	    return sb.toString();
	}
	
    public Location partialLoadWithParentFirstLocation(Location locationWhat, Location positiveLocation, Location negativeLocation){
		List <Location> list = partialLoadWithParentLocation(locationWhat, positiveLocation, negativeLocation);
		return (!list.isEmpty())?(Location)list.get(0):null;
    }
    
    public Location partialLoadWithParentFirstLocationUseCache(Location locationWhat, Location positiveLocation, Location negativeLocation, Boolean useCache){
		List <Location> list = partialLoadWithParentLocationUseCache(locationWhat, positiveLocation, negativeLocation, useCache);
		return (!list.isEmpty())?(Location)list.get(0):null;
    }
	
	public Location partialLoadWithParentFirstLocationUseCacheOnResult(Location locationWhat, Location positiveLocation, Location negativeLocation, Boolean useCache){
		List <Location> list = partialLoadWithParentLocationUseCacheOnResult(locationWhat, positiveLocation, negativeLocation, useCache);
		return (!list.isEmpty())?(Location)list.get(0):null;
    }
	//
	protected List<Location> partialLoadWithParentLocation(Location locationWhat, Location positiveLocation, Location negativeLocation, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentLocation(locationWhat, positiveLocation, negativeLocation, new QuerySelectInit(), nbOfResult, useCache);
	}	  

	protected List partialLoadWithParentLocationQueryResult (Location locationWhat, Location positiveLocation, Location negativeLocation, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentLocationQueryResult (locationWhat, positiveLocation, negativeLocation, new QuerySelectInit(), nbOfResult, useCache);
	}	
    
    public List<Location> getDistinctLocation(Location locationWhat, Location positiveLocation, Location negativeLocation) {
		 return partialLoadWithParentLocation(locationWhat, positiveLocation, negativeLocation, new QuerySelectDistinctInit(), null, false);
	}
	
	public List<Location> partialLoadWithParentLocation(Location locationWhat, Location positiveLocation, Location negativeLocation) {
		 return partialLoadWithParentLocation(locationWhat, positiveLocation, negativeLocation, new QuerySelectInit(), null, false);
	}	
  
	public List<Location> partialLoadWithParentLocationUseCacheOnResult(Location locationWhat, Location positiveLocation, Location negativeLocation, Boolean useCache) {
		String key = getCacheKey(locationWhat, positiveLocation, negativeLocation, "partialLoadWithParentLocation");
		List<Location> list = (List<Location>)simpleCache.get(key);
		if (list==null || list.isEmpty()) {
			list = partialLoadWithParentLocation(locationWhat, positiveLocation, negativeLocation);
			if (!list.isEmpty())
			   simpleCache.put(key, list);
		}
		return list;	
	}	

	public List<Location> partialLoadWithParentLocationUseCache(Location locationWhat, Location positiveLocation, Location negativeLocation, Boolean useCache) {
		String key = getCacheKey(locationWhat, positiveLocation, negativeLocation, "partialLoadWithParentLocation");
		List<Location> list = (List<Location>)simpleCache.get(key);
		if (list==null) {
			list = partialLoadWithParentLocation(locationWhat, positiveLocation, negativeLocation);
			simpleCache.put(key, list);
		}
		return list;	
	}	
	
	private List<Location> handleLoadWithParentLocation(Map beanPath, List list, Location locationWhat) {
	    return handleLoadWithParentLocation(beanPath, list, locationWhat, true);  
	}
	
	private List<Location> handleLoadWithParentLocation(Map beanPath, List list, Location locationWhat, boolean isHql) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentLocationWithOneElementInRow(list, beanPath, locationWhat, isHql);
		}
		return handlePartialLoadWithParentLocation(list, beanPath, locationWhat, isHql);	
	}
	
    	// to set in super class	
	protected void populateLocation (Location location, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(location, beanPath, value);
	}
	
	protected void populateLocationFromSQL (Location location, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(location, beanPath, value);
	}
    	// to set in super class BEWARE: genericity is only one level!!!!! first level is a copy second level is a reference!!! change to location.clone() instead
	private Location cloneLocation (Location location) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		//return (Location) BeanUtils.cloneBeanObject(location);
	   if (location==null) return new Location();
	   return location.clone();
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
	
    public List<Location> countDistinct (Location whatMask, Location whereEqCriteria) {
       return partialLoadWithParentLocation(whatMask, whereEqCriteria, null, new QuerySelectCountInit("location"), null, false);
    }   
  	
    public Long count(Location whereEqCriteria) {
	    return count(null, whereEqCriteria, EntityMatchType.ALL, OperandType.EQUALS, true); 
/*        Query query = getEntityManager().createQuery(getSelectCountPrototype(whereEqCriteria));
        List<Long> list = query.getResultList();
    	if (!list.isEmpty()) {
            return list.get(0);
    	}
    	return 0L;
*/
    }


    public Long count(Location whatMask, Location whereCriteria, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
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

	protected String countQuery (Location location, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
        String what = "SELECT count(*) FROM Location location ";
		return findQuery (location, null, what, matchType, operandType, caseSensitivenessType, null);
    }
	

   private List getFirstResultWhereConditionsAre (Location location) {
      return partialLoadWithParentLocationQueryResult(getDefaultLocationWhat(), location, null, 1, false);	
   }
   
   protected Location getDefaultLocationWhat() {
      Location location = new Location();
      location.setLocationId(Integer.valueOf(-1));
      return location;
   }
   
	public Location getFirstLocation (Location location) {
		if (isAllNull(location))
			return null;
		else {
			List<Location> list = searchPrototype (location, 1);
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
    * checks if the Location entity exists
    */           
    public boolean existsLocation (Location location) {
       if (getFirstLocation(location)!=null)
          return true;
       return false;  
    }
        
    public boolean existsLocationWhereConditionsAre (Location location) {
       if (getFirstResultWhereConditionsAre (location).isEmpty())
          return false;
       return true;  
    }

	private int countPartialField (Location location) {
	   int cpt = 0;
       if (location.getLocationId() != null) {
          cpt++;
       }
       if (location.getLocationName() != null) {
          cpt++;
       }
       return cpt;
	}   

	public List<Location> partialLoadWithParentLocation(Location what, Location positiveLocation, Location negativeLocation, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		Map beanPath = new Hashtable();
		List list = partialLoadWithParentLocationJPAQueryResult (what, positiveLocation, negativeLocation, queryWhatInit, beanPath, nbOfResult, useCache);
		return handlePartialLoadWithParentResult(what, list, beanPath);
	}
	
	public List<Location> handlePartialLoadWithParentResult(Location what, List list, Map beanPath) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentLocationWithOneElementInRow(list, beanPath, what, true);
		}
		return handlePartialLoadWithParentLocation(list, beanPath, what, true);
	}	

	private List partialLoadWithParentLocationQueryResult(Location locationWhat, Location positiveLocation, Location negativeLocation, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		return partialLoadWithParentLocationJPAQueryResult (locationWhat, positiveLocation, negativeLocation, queryWhatInit, new Hashtable(), nbOfResult, useCache);
    }	
  
	private List partialLoadWithParentLocationJPAQueryResult(Location locationWhat, Location positiveLocation, Location negativeLocation, QueryWhatInit queryWhatInit, Map beanPath, Integer nbOfResult, Boolean useCache) {
		Query hquery = getPartialLoadWithParentJPAQuery (locationWhat, positiveLocation, negativeLocation, beanPath, queryWhatInit, nbOfResult);
		return hquery.getResultList();
    }	
   /**
    * @returns an JPA Hsql query based on entity Location and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPAQuery (Location locationWhat, Location positiveLocation, Location negativeLocation, Map beanPath, QueryWhatInit queryWhatInit, Integer nbOfResult) {
	   Query query = getPartialLoadWithParentJPARawQuery (locationWhat, positiveLocation, negativeLocation, beanPath, queryWhatInit);
	   if (nbOfResult!=null)
	      query.setMaxResults(nbOfResult);
	   return query;
    }
  	
   /**
    * @returns an JPA Raw Hsql query based on entity Location and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPARawQuery (Location locationWhat, Location positiveLocation, Location negativeLocation, Map beanPath, QueryWhatInit queryWhatInit) {
	   return getEntityManager().createQuery(getPartialLoadWithParentRawHsqlQuery (locationWhat, positiveLocation, negativeLocation, beanPath, queryWhatInit));
    }
	
	private List<Location> handlePartialLoadWithParentLocation(List<Object[]> list, Map<Integer, String> beanPath, Location locationWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentLocation(list, beanPath, locationWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentLocation, message:"+ex.getMessage());
			return new ArrayList<Location>();
		}
    }

	private List<Location> handlePartialLoadWithParentLocationWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, Location locationWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentLocationWithOneElementInRow(list, beanPath, locationWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentLocationWithOneElementInRow, message:"+ex.getMessage());
			return new ArrayList<Location>();
		}
    }
    	
	 private List<Location> convertPartialLoadWithParentLocation(List<Object[]> list, Map<Integer, String> beanPath, Location locationWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<Location> resultList = new ArrayList<Location>();
		 for (Object[] row : list) {		
		    Location location = cloneLocation (locationWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populateLocation (location, row[(Integer)entry.getKey()], (String)entry.getValue());
		    }
		    resultList.add(location);
		 }
		 return resultList;		
	 }	
    
	 private List<Location> convertPartialLoadWithParentLocationWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, Location locationWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<Location> resultList = new ArrayList<Location>();
		 for (Object row : list) {		
		    Location location = cloneLocation (locationWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populateLocation (location, row, (String)entry.getValue());
		    }
		    resultList.add(location);
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
	public String getPartialLoadWithParentRawHsqlQuery (Location location, Location positiveLocation, Location negativeLocation, Map beanPath, QueryWhatInit queryWhatInit) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentLocationQuery (location, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
		Hashtable aliasWhereHt = new Hashtable();
		String where = getPartialLoadWithParentWhereQuery (positiveLocation, null, aliasWhatHt, aliasWhereHt, null, null);
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
	public String findPartialLoadWithParentRawHsqlQuery (Location whatMask, Location criteriaMask, Map beanPath, QueryWhatInit queryWhatInit,  Location orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentLocationQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
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
	public String countPartialLoadWithParentRawHsqlQuery (Location whatMask, Location criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
		Map beanPath = new Hashtable();
		Hashtable aliasWhatHt = new Hashtable();
		// used to initiate the how part of the what
		getPartialLoadWithParentLocationQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", new QuerySelectInit());
		String what = "select count(location) ";
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
    	
	public String findPartialQuery (Location whatMask, Location criteriaMask, Location orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Map beanPath) {
        QueryWhatInit queryWhatInit = new QuerySelectInit();
        return findPartialLoadWithParentRawHsqlQuery(whatMask, criteriaMask, beanPath, queryWhatInit, orderMask, matchType, operandType, caseSensitivenessType,  sortOrder);
    }
	
	/**
    * partial on a single entity load enables to specify the fields you want to load explicitly
    */         
	public List<Location> partialLoadLocation(Location location, Location positiveLocation, Location negativeLocation) {
	    Query hquery = getEntityManager().createQuery(getPartialLoadLocationQuery (location, positiveLocation, negativeLocation));
		int countPartialField = countPartialField(location);
		if (countPartialField==0) 
			return new ArrayList<Location>();
		List list = hquery.getResultList();
		Iterator iter = list.iterator();
		List<Location> returnList = new ArrayList<Location>();
		while(iter.hasNext()) {
			int index = 0;
			Object[] row;
			if (countPartialField==1) {
				row = new Object[1];
				row[0] = iter.next();
				} 
			else 
				row = (Object[]) iter.next();
			Location locationResult = new Location();
			if (location.getLocationId() != null) {
                locationResult.setLocationId((Integer) row[index]);
				index++;
			}
			if (location.getLocationName() != null) {
                locationResult.setLocationName((String) row[index]);
				index++;
			}
			returnList.add(locationResult);
        }
	    return returnList;
	}

	public static String getPartialLoadWithParentWhereQuery (
	   Location criteriaMask, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias,
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
	   Location location, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias) {
	   if (location==null)
	      return "";
	   String alias = null;
	   if (aliasWhereHt == null) {
	      aliasWhereHt = new Hashtable();
	   } 
	   if (isLookedUp(location)){
	      alias = getNextAlias (aliasWhereHt, location);
		  aliasWhereHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (location.getLocationId() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".locationId = "+ location.getLocationId() + " ");
       }
       if (location.getLocationName() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".locationName = '"+ location.getLocationName()+"' ");
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
	
    public static String getPartialLoadWithParentLocationQuery (
	   Location location, Boolean isWhereSet, Hashtable aliasHt, String childAlias, String childFKAlias, Map beanPath, String rootPath, QueryWhatInit queryWhatInit) {
	   if (location==null)
	      return "";
	   String alias = null;
	   if (aliasHt == null) {
	      aliasHt = new Hashtable();
	   } 
	   if (isLookedUp(location)){
	      alias = getNextAlias (aliasHt, location);
		  aliasHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (location.getLocationId() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"locationId");
          query.append(" "+alias+".locationId ");
       }
       if (location.getLocationName() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"locationName");
          query.append(" "+alias+".locationName ");
       }
//       query.append(getLocationSearchEqualQuery (positiveLocation, negativeLocation));
	   return query.toString(); 
    }
	
	protected static String getAliasConnection(String existingAlias, String childAlias, String childFKAlias) {
		if (childAlias==null)
		   return "";
		return childAlias+"."+childFKAlias+" = "+existingAlias+"."+"locationId";
	}
	
	protected static String getAliasKey (String alias) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return "Location|"+alias;
	}
	
	protected static String getAliasKeyAlias (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return StringUtils.substringAfter(aliasKey, "|");
	}
	
	protected static String getAliasKeyDomain (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
	  return StringUtils.substringBefore(aliasKey, "|");
	}
	
	protected static String getNextAlias (Hashtable aliasHt, Location location) {
		int cptSameAlias = 0;
		Enumeration<String> _keys = aliasHt.keys();
		while (_keys.hasMoreElements()) {
			String _key = _keys.nextElement();
			if (_key.startsWith("location"))
				cptSameAlias++;
		}
		if (cptSameAlias==0)
			return "location";
		else
			return "location_"+cptSameAlias;
	}
	
	
	protected static boolean isLookedUp (Location location) {
	   if (location==null)
		  return false;
       if (location.getLocationId() != null) {
	      return true;
       }
       if (location.getLocationName() != null) {
	      return true;
       }
       return false;   
	}
	
    public String getPartialLoadLocationQuery(
	   Location location, 
	   Location positiveLocation, 
	   Location negativeLocation) {
       boolean isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (location.getLocationId() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" locationId ");
       }
       if (location.getLocationName() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" locationName ");
       }
	   query.append(getFromEntity());
       query.append(getLocationPositiveNegativeCriteria (positiveLocation, negativeLocation));
	   return query.toString(); 
    }
	
	public List<Location> searchPrototypeWithCacheLocation(Location location) {
		SimpleCache simpleCache = new SimpleCache();
		List<Location> list = (List<Location>)simpleCache.get(location.toString());
		if (list==null) {
			list = searchPrototypeLocation(location);
			simpleCache.put(location.toString(), list);
		}
		return list;
	}

    public List<Location> loadGraph(Location graphMaskWhat, List<Location> whereMask) {
        return loadGraphOneLevel(graphMaskWhat, whereMask);
    }

	public List<Location> loadGraphOneLevel(Location graphMaskWhat, List<Location> whereMask) {
		//first get roots element from where list mask
		// this brings the level 0 of the graph (root level)
 		graphMaskWhat.setLocationId(graphMaskWhat.integerMask__);
		List<Location> locations = searchPrototypeLocation (whereMask);
		// for each sub level perform the search with a subquery then reassemble
		// 1. get all sublevel queries
		// 2. perform queries on the correct dao
		// 3. reassemble
		return getLoadGraphOneLevel (graphMaskWhat, locations);
	}

	private List<Location> copy(List<Location> inputs) {
		List<Location> l = new ArrayList<Location>();
		for (Location input : inputs) {
			Location copy = new Location();
			copy.copy(input);
			l.add(copy);
		}
		return l;
	}
	   
	private List<Location> getLoadGraphOneLevel (Location graphMaskWhat, List<Location> parents) {
	    return loadGraphFromParentKey (graphMaskWhat, parents);
	} 
	
	public List<Location> loadGraphFromParentKey (Location graphMaskWhat, List<Location> parents) {
		//foreach children:
		//check if not empty take first
		parents = copy (parents); //working with detached entities to avoid unnecessary sql calls
		if (parents==null || parents.isEmpty())
		   return parents;
		List<String> ids = getPk (parents);
		if (graphMaskWhat.getAccessorieLocationViaLocation()!=null && !graphMaskWhat.getAccessorieLocationViaLocation().isEmpty()) {
			for (Accessorie childWhat : graphMaskWhat.getAccessorieLocationViaLocation()) {
				childWhat.setLocation_(graphMaskWhat.integerMask__); // add to the what mask, usefull for reconciliation
				AccessorieJPAImpl accessorieextendedjpaimpl = new AccessorieJPAImpl ();
				List<Accessorie> children = accessorieextendedjpaimpl.lookupAccessorie(childWhat, getFkCriteria(" locationId ", ids), null, getEntityManager());
				reassembleAccessorie (children, parents);				
				break;
			}
		}
		if (graphMaskWhat.getHardwareLocationViaLocation()!=null && !graphMaskWhat.getHardwareLocationViaLocation().isEmpty()) {
			for (Hardware childWhat : graphMaskWhat.getHardwareLocationViaLocation()) {
				childWhat.setLocation_(graphMaskWhat.integerMask__); // add to the what mask, usefull for reconciliation
				HardwareJPAImpl hardwareextendedjpaimpl = new HardwareJPAImpl ();
				List<Hardware> children = hardwareextendedjpaimpl.lookupHardware(childWhat, getFkCriteria(" locationId ", ids), null, getEntityManager());
				reassembleHardware (children, parents);				
				break;
			}
		}
		if (graphMaskWhat.getSoftwareLocationViaLocation()!=null && !graphMaskWhat.getSoftwareLocationViaLocation().isEmpty()) {
			for (Software childWhat : graphMaskWhat.getSoftwareLocationViaLocation()) {
				childWhat.setLocation_(graphMaskWhat.integerMask__); // add to the what mask, usefull for reconciliation
				SoftwareJPAImpl softwareextendedjpaimpl = new SoftwareJPAImpl ();
				List<Software> children = softwareextendedjpaimpl.lookupSoftware(childWhat, getFkCriteria(" locationId ", ids), null, getEntityManager());
				reassembleSoftware (children, parents);				
				break;
			}
		}
		return parents;
	}
	
	private void reassembleAccessorie (List<Accessorie> children, List<Location> parents) {
		for (Accessorie child : children) {
			for (Location parent : parents) {
				if (parent.getLocationId()!=null && parent.getLocationId().toString().equals(child.getLocation()+"")) {
					parent.addAccessorieLocationViaLocation(child); 
					child.setLocation(parent);
					break;
				}
			}
		}
	}
	
	private void reassembleHardware (List<Hardware> children, List<Location> parents) {
		for (Hardware child : children) {
			for (Location parent : parents) {
				if (parent.getLocationId()!=null && parent.getLocationId().toString().equals(child.getLocation()+"")) {
					parent.addHardwareLocationViaLocation(child); 
					child.setLocation(parent);
					break;
				}
			}
		}
	}
	
	private void reassembleSoftware (List<Software> children, List<Location> parents) {
		for (Software child : children) {
			for (Location parent : parents) {
				if (parent.getLocationId()!=null && parent.getLocationId().toString().equals(child.getLocation()+"")) {
					parent.addSoftwareLocationViaLocation(child); 
					child.setLocation(parent);
					break;
				}
			}
		}
	}
	
	private List<String> getPk(List<Location> input) {
		List<String> s = new ArrayList<String>();
		for (Location t : input) {
			s.add(t.getLocationId()+"");
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
	public void find (QueryData<Location> data) {
		EntityCriteria<Location> filter = data.getEntityCriteria();
		Location entityWhat = data.getEntityWhat();
		Location criteriaMask = filter.getEntity();
		int start = data.getStart();
		int max = data.getMax();
		EntitySort<Location> entitySort = data.getEntitySort();
		QuerySortOrder sortOrder = entitySort.getOrder();
		Location sortMask = entitySort.getEntity();	

		List<Location> results = find(entityWhat, criteriaMask, sortMask, filter.getMatchType(), filter.getOperandType(), filter.getCaseSensitivenessType(), sortOrder, start, max);
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
	
    public void setAccessorieJPAImpl (AccessorieJPAImpl accessorieextendedjpaimpl) {
       this.accessorieextendedjpaimpl = accessorieextendedjpaimpl;
    }
    
    public AccessorieJPAImpl getAccessorieJPAImpl () {
       return accessorieextendedjpaimpl;
    }
    
    public void setHardwareJPAImpl (HardwareJPAImpl hardwareextendedjpaimpl) {
       this.hardwareextendedjpaimpl = hardwareextendedjpaimpl;
    }
    
    public HardwareJPAImpl getHardwareJPAImpl () {
       return hardwareextendedjpaimpl;
    }
    
    public void setSoftwareJPAImpl (SoftwareJPAImpl softwareextendedjpaimpl) {
       this.softwareextendedjpaimpl = softwareextendedjpaimpl;
    }
    
    public SoftwareJPAImpl getSoftwareJPAImpl () {
       return softwareextendedjpaimpl;
    }
    

    /**
     * return a list of Location entities 
     */
    public List<Location> getList () {
        //first lightweight implementation
        return searchPrototypeLocation(new Location());
    }
    /**
     * return a list of Location entities and sort
     */
    public List<Location> getList (Location orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(new Location(), orderMask, sortOrder, null);
    }
    /**
     * return a list of Location entities and sort based on a Location prototype
     */
    public List<Location> list (Location mask, Location orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(mask, orderMask, sortOrder, null);
    }

	@Override
    protected String getSelectFrom() {
        return "SELECT location "+getFromEntity();
    }

    protected String getFromEntity() {
        return " FROM Location location ";
    }

    @Override
    protected String getQuerySelectFromEntity() {
        return getSelectFrom();
    }
	



}
