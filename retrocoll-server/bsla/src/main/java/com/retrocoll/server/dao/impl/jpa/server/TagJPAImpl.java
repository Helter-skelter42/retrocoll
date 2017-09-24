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

import com.retrocoll.server.dao.face.server.TagDao;
import com.retrocoll.server.domain.server.Tag;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.retrocoll.server.dao.impl.ServerGenericDaoJpaImpl;


/**
 *
 * <p>Title: TagJPAImpl</p>
 *
 * <p>Description: Interface of a Data access object dealing with TagJPAImpl
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching TagJPAImpl objects</p>
 *
 */


@org.springframework.stereotype.Repository(value="tagDao")

public class TagJPAImpl extends ServerGenericDaoJpaImpl<Tag> implements TagDao {
	public TagJPAImpl () {}
	
    /**
     * Inserts a Tag entity 
     * @param Tag tag
     */
    public void insertTag(Tag tag) {
       entityManager.persist(tag);
    }

    protected void insertTag(EntityManager emForRecursiveDao, Tag tag) {
       emForRecursiveDao.persist(tag);
    } 

    /**
     * Updates a Tag entity 
     * @param Tag tag
     */
    public Tag updateTag(Tag tag) {
       return entityManager.merge(tag);
    }

	/**
     * Updates a Tag entity with only the attributes set into Tag.
	 * The primary keys are to be set for this method to operate.
	 * This is a performance friendly feature, which remove the udibiquous full load and full update when an
	 * update is issued
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param Tag tag
    */ 
    @Transactional
    public Integer updateNotNullOnlyTag(Tag tag) {
        Query jpaQuery = getEntityManager().createQuery(getUpdateNotNullOnlyTagQueryChunk(tag));
		return jpaQuery.executeUpdate();
    }

    protected String getUpdateNotNullOnlyTagQueryChunkPrototype (Tag tag) {
        boolean isSetSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update Tag tag ");
        if (isSetSet==false)
			throw new IllegalArgumentException("tag mask should contain updatable fields");
        return query.toString();
    }
    
    protected String getUpdateNotNullOnlyTagQueryChunk (Tag tag) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer(getUpdateNotNullOnlyTagQueryChunkPrototype(tag));
        if (isWhereSet==false)
			throw new IllegalArgumentException("tag mask should contain primary key");
        return query.toString();
    }
    
                
	protected Tag assignBlankToNull (Tag tag) {
        if (tag==null)
			return null;
		return tag;
	}
	
	protected boolean isAllNull (Tag tag) {
	    if (tag==null)
			return true;
		return true;
	}
		
    @Transactional
    public Integer updateNotNullOnlyPrototypeTag(Tag tag, Tag prototypeCriteria) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update Tag tag ");
		isWhereSet = false; 
        Query jpaQuery = getEntityManager().createQuery(query.toString());
		return jpaQuery.executeUpdate();
    }
     
     /**
     * Saves a Tag entity 
     * @param Tag tag
     */
    public void saveTag(Tag tag) {
       //entityManager.persist(tag);
       if (entityManager.contains(tag)) {
          entityManager.merge(tag);
       } else {
          entityManager.persist(tag);
       }
       entityManager.flush(); 
    }
       
    /**
     * Deletes a Tag entity 
     * @param Tag tag
     */
    public void deleteTag(Tag tag) {
      entityManager.remove(tag);
    }
    
    /**
     * Loads the Tag entity which is related to an instance of
     * Tag
     * @param Long id
     * @return Tag The Tag entity
     
    public Tag loadTag(Long id) {
    	return (Tag)entityManager.get(Tag.class, id);
    }
*/
  
    /**
     * Loads the Tag entity which is related to an instance of
     * Tag
     * @param java.lang.Integer TagId
     * @return Tag The Tag entity
     */
    public Tag loadTag(java.lang.Integer tagId) {
    	return (Tag)entityManager.find(Tag.class, tagId);
    }
    
    /**
     * Loads the Tag entity which is related to an instance of
     * Tag and its dependent one to many objects
     * @param Long id
     * @return Tag The Tag entity
     */
    public Tag loadFullFirstLevelTag(java.lang.Integer tagId) {
        List list = getResultList(
                     "SELECT tag FROM Tag tag "
                     + " WHERE tag.tagId = "+tagId
               );
         if (list!=null && !list.isEmpty())
            return (Tag)list.get(0);
         return null;
    	//return null;//(Tag) entityManager.queryForObject("loadFullFirstLevelTag", id);
    }

    /**
     * Loads the Tag entity which is related to an instance of
     * Tag
     * @param Tag tag
     * @return Tag The Tag entity
     */
    public Tag loadFullFirstLevelTag(Tag tag) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT tag FROM Tag tag ");
        List list = getResultList(query.toString());
        if (list!=null && !list.isEmpty())
           return (Tag)list.get(0);    
        return null;
    }  

    /**
     * Searches a list of Tag entity 
     * @param Tag tag
     * @return List
     */  
    public List<Tag> searchPrototypeTag(Tag tag) {
       return searchPrototype (tag, null);
    }  
	
    public List<Tag> searchPrototypeAnyTag(Tag tag) {
       return searchPrototypeAny (tag, null);
    }  

	// indirection
    public List<Tag> find (Tag criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
       return find (criteriaMask, matchType, operandType, caseSensitivenessType, null, null); 
	}
	
	// indirection
	protected List<Tag> find (Tag criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, Integer startPosition, Integer maxResults) {
       return find (criteriaMask, null, matchType, operandType, caseSensitivenessType, null, startPosition, maxResults); 
    }
	
	// indirection
	protected List<Tag> find (Tag criteriaMask, Tag orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
       return find (null, criteriaMask, orderMask, matchType, operandType, caseSensitivenessType, sortOrder, startPosition, maxResults);
    }
	
	// main find implementation
	protected List<Tag> find (Tag whatMask, Tag criteriaMask, Tag orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
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
    public String findQuery (Tag criteriaMask, Tag orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String what = "SELECT tag FROM Tag tag ";
		return findQuery (criteriaMask, orderMask, what, matchType, operandType, caseSensitivenessType, sortOrder);
    }

    protected String findQuery (Tag criteriaMask, Tag orderMask, String what, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String queryWhere = findWhere (criteriaMask, false, isAll(matchType), operandType, caseSensitivenessType);
		String queryOrder = findOrder (orderMask, sortOrder);
	    return getHQuery(what, queryWhere, queryOrder);
    }
	
    protected List<Tag> searchPrototype (Tag tag, Tag orderMask, QuerySortOrder sortOrder, Integer maxResults) {
       return searchPrototype(getTagSelectQuery (getWhereEqualWhereQueryChunk(tag), orderMask, sortOrder), maxResults);
    }

    protected List<Tag> searchPrototype (Tag tag, Integer maxResults) {
       return searchPrototype(tag, null, null, maxResults);
    }
    
    protected List<Tag> searchPrototypeAny (Tag tag, Integer maxResults) { 
       return searchPrototype(getSearchEqualAnyQuery (tag), maxResults);
    }
    
    protected List<Tag> searchPrototype (String query, Integer maxResults) { 
       Query hquery = getEntityManager().createQuery(query);
       if (maxResults!=null)
          hquery.setMaxResults(maxResults);
       return hquery.getResultList();
    }

    public List<Tag> searchPrototypeTag (List<Tag> tags) {
       return searchPrototype (tags, null);
    }

    protected List<Tag> searchPrototype (List<Tag> tags, Integer maxResults) {    
	   return getResultList(getTagSearchEqualQuery (null, tags));
	}    

    protected List<Tag> getResultList (String query) {    
	   Query hquery = entityManager.createQuery(query);            
	   return hquery.getResultList();
	}    
 

    public List<Tag> searchDistinctPrototypeTag (Tag tagMask, List<Tag> tags) {
        return getResultList(getTagSearchEqualQuery (tagMask, tags));    
    }
        
	/**
     * Searches a list of Tag entity 
     * @param Tag positiveMask
     * @param Tag negativeMask
     * @return List
     */
    public List<Tag> searchPrototypeTag(Tag positiveMask, Tag negativeMask) {
	    return getResultList(getTagSearchEqualQuery (positiveMask, negativeMask));  
    }

    /**
    * return a string query search on a Tag prototype
    */
    protected String getTagSelectQuery (String where, Tag orderMask, QuerySortOrder sortOrder) {
       return getTagSelectQuery (where, findOrder (orderMask, sortOrder));
    }
    protected String getTagSelectQuery (String where, String order) {
       StringBuffer query = new StringBuffer();
       query.append ("SELECT tag FROM Tag tag ");
       return (order!=null)? getHQuery(query.toString(), where, order):getHQuery(query.toString(), where);
    }
    /**
    * return a jql query search on a Tag prototype
    */
    protected String getSearchEqualQuery (Tag tag) {
       return getTagSelectQuery (getWhereEqualWhereQueryChunk(tag),null);
    }
    protected String getWhereEqualWhereQueryChunk (Tag tag) {
       return getWhereEqualWhereQueryChunk(tag, false);
    }
    /**
    * return a jql query search on a Tag with any prototype
    */
    protected String getSearchEqualAnyQuery (Tag tag) {
       return getTagSelectQuery (getWhereEqualAnyWhereQueryChunk(tag), null);   
    }
    protected String getWhereEqualAnyWhereQueryChunk (Tag tag) {
       return getWhereEqualAnyWhereQueryChunk(tag, false);   
    }

    /**
    * return a jql search for a list of Tag prototype
    */
    protected String getTagSearchEqualQuery (Tag tagMask, List<Tag> tags) {
        boolean isOrSet = false;
        StringBuffer query = new StringBuffer();
        if (tagMask !=null)
           query.append (getTagMaskWhat (tagMask));
        query.append (" FROM Tag tag ");
        StringBuffer queryWhere = new StringBuffer();
        for (Tag tag : tags) {
           if (!isAllNull(tag)) {        
	           queryWhere.append (getQueryOR (isOrSet));
	           isOrSet = true;
	           queryWhere.append (" ("+getWhereEqualWhereQueryChunk(tag, false)+") ");
           }
        }
	    return getHQuery(query.toString(), queryWhere.toString());
    }	

    
    protected String getTagMaskWhat (Tag tagMask) {
        boolean isCommaSet = false;
        StringBuffer query = new StringBuffer("SELECT DISTINCT ");
        if (!isCommaSet)
           return "";
	    return query.toString();
    }
    
    protected String getWhereEqualAnyWhereQueryChunk (Tag tag, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (tag, isAndSet, false);	
	}
	
    protected String getWhereEqualWhereQueryChunk (Tag tag, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (tag, isAndSet, true);
	}
	
    protected String getSearchEqualWhereQueryChunk (Tag tag, boolean isAndSet, boolean isAll) {
        StringBuffer query = new StringBuffer();
	    return query.toString();
    }

    protected String findOrder (Tag orderMask, QuerySortOrder sortOrder) {
        if (orderMask!=null) {
            String orderColumn = getFirstNotNullColumnOtherWiseNull(orderMask);
            if (orderColumn!=null)
               return orderColumn + " " + sortOrder;
        }
        return "";
    }

	@Override
    protected String findWhere (Tag tag, boolean isAndSet, boolean isAll, OperandType operandType, Boolean caseSensitive) {
		return findWhere (null, tag, isAndSet, isAll, operandType, caseSensitive);
	}
	
	protected static String findWhere (String alias, Tag tag, boolean isAndSet, boolean isAll, OperandType operandType, boolean caseSensitive) {
        if (alias==null)
			alias = "tag";
		StringBuffer query = new StringBuffer();
		String operand = getOperand (operandType);
		String evaluatorPrefix = getEvaluatorPrefix (operandType);		
		String evaluatorSuffix = getEvaluatorSuffix (operandType);		
        return query.toString();
    }
	
	protected String getFirstNotNullColumnOtherWiseNull (Tag mask) {
        if (mask == null) return null;
        return null;	
	}
    
    /**
    * return a jql search on a Tag prototype with positive and negative beans
    */
    protected String getTagSearchEqualQuery (Tag positiveMask, Tag negativeMask) {
		StringBuffer query = new StringBuffer();    	
		query.append(getSelectFrom());
		query.append(getTagPositiveNegativeCriteria(positiveMask, negativeMask));
		return query.toString();
	}

	protected String getTagPositiveNegativeCriteria (Tag positiveMask, Tag negativeMask) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
	    return query.toString();
    }
 
	
	
    private Logger log = Logger.getLogger(this.getClass());
    
    private SimpleCache simpleCache = new SimpleCache();
    private EntityManager emForRecursiveDao; // dao that needs other dao in a recursive manner not support by spring configuration

    /**
     * generic to move after in superclass
     */
    public TagJPAImpl (EntityManager emForRecursiveDao) {
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
     * Inserts a Tag entity with cascade of its children
     * @param Tag tag
     */
    public void insertTagWithCascade(Tag tag) {
    	TagJPAImpl tagjpaimpl = new TagJPAImpl(getEntityManager());
    	tagjpaimpl.insertTagWithCascade(tagjpaimpl.getEntityManagerForRecursiveDao(), tag);
    }
     
    public void insertTagWithCascade(EntityManager emForRecursiveDao, Tag tag) {
       insertTag(emForRecursiveDao, tag);
    }
        
    /**
     * Inserts a list of Tag entity with cascade of its children
     * @param List<Tag> tags
     */
    public void insertTagsWithCascade(List<Tag> tags) {
       for (Tag tag : tags) {
          insertTagWithCascade(tag);
       }
    } 
        
    /**
     * lookup Tag entity Tag, criteria and max result number
     */
    public List<Tag> lookupTag(Tag tag, Criteria criteria, Integer numberOfResult, EntityManager em) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT tag FROM Tag tag ");
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
    
    public List<Tag> lookupTag(Tag tag, Criteria criteria, Integer numberOfResult) {
		return lookupTag(tag, criteria, numberOfResult, getEntityManager());
    }

    public Integer updateNotNullOnlyTag (Tag tag, Criteria criteria) {
        String queryWhat = getUpdateNotNullOnlyTagQueryChunkPrototype (tag);
        StringBuffer query = new StringBuffer (queryWhat);
        boolean isWhereSet = false;
        for (Criterion criterion : criteria.getClauseCriterions()) {
            query.append (getQueryWHERE_AND (isWhereSet));
            isWhereSet = true;   
            query.append(criterion.getExpression());			
        }  
        Query jpaQuery = getEntityManager().createQuery(query.toString());
        isWhereSet = false;
		return jpaQuery.executeUpdate();
    }
	
	public Tag affectTag (Tag tag) {
	    return referTag (tag, null, false);		    
	}
		
	/**
	 * Assign the first tag retrieved corresponding to the tag criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no tag corresponding in the database. Then tag is inserted and returned with its primary key(s). 
	 */
	public Tag assignTag (Tag tag) {
		return referTag (tag, null, true);
	}

	/**
	 * Assign the first tag retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no tag corresponding in the database. 
	 * Then tag is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public Tag assignTag (Tag tag, Tag mask) {
		return referTag (tag, mask, true);
	}

	public Tag referTag (Tag tag, Tag mask, boolean isAssign) {
		tag = assignBlankToNull (tag);
		if (isAllNull(tag))
			return null;
		else {
			List<Tag> list;
			if (mask==null)
				list = searchPrototypeTag(tag);
			else
				list = searchPrototypeTag(mask);
			if (list.isEmpty()) {
			    if (isAssign)
			       insertTag(tag);
			    else
				   return null;
			}
			else if (list.size()==1)
				tag.copy(list.get(0));
			else 
				//TODO log error
				tag.copy(list.get(0));
		}
		return tag;		    
	}

   public Tag assignTagUseCache (Tag tag) {
      return referTagUseCache (tag, true);
   }
      		
   public Tag affectTagUseCache (Tag tag) {
      return referTagUseCache (tag, false);
   }
      		
   public Tag referTagUseCache (Tag tag, boolean isAssign) {
	  String key = getCacheKey(null, tag, null, "assignTag");
      Tag tagCache = (Tag)simpleCache.get(key);
      if (tagCache==null) {
         tagCache = referTag (tag, null, isAssign);
         if (key!=null)
         	simpleCache.put(key, tagCache);
      }
      tag.copy(tagCache);
      return tagCache;
   }	

	private String getCacheKey (Tag tagWhat, Tag positiveTag, Tag negativeTag, String queryKey) {
	    StringBuffer sb = new StringBuffer();
	    sb.append(queryKey);
	    if (tagWhat!=null)
	       sb.append(tagWhat.toStringWithParents());
	    if (positiveTag!=null)
	       sb.append(positiveTag.toStringWithParents());
	    if (negativeTag!=null)
	       sb.append(negativeTag.toStringWithParents());
	    return sb.toString();
	}
	
    public Tag partialLoadWithParentFirstTag(Tag tagWhat, Tag positiveTag, Tag negativeTag){
		List <Tag> list = partialLoadWithParentTag(tagWhat, positiveTag, negativeTag);
		return (!list.isEmpty())?(Tag)list.get(0):null;
    }
    
    public Tag partialLoadWithParentFirstTagUseCache(Tag tagWhat, Tag positiveTag, Tag negativeTag, Boolean useCache){
		List <Tag> list = partialLoadWithParentTagUseCache(tagWhat, positiveTag, negativeTag, useCache);
		return (!list.isEmpty())?(Tag)list.get(0):null;
    }
	
	public Tag partialLoadWithParentFirstTagUseCacheOnResult(Tag tagWhat, Tag positiveTag, Tag negativeTag, Boolean useCache){
		List <Tag> list = partialLoadWithParentTagUseCacheOnResult(tagWhat, positiveTag, negativeTag, useCache);
		return (!list.isEmpty())?(Tag)list.get(0):null;
    }
	//
	protected List<Tag> partialLoadWithParentTag(Tag tagWhat, Tag positiveTag, Tag negativeTag, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentTag(tagWhat, positiveTag, negativeTag, new QuerySelectInit(), nbOfResult, useCache);
	}	  

	protected List partialLoadWithParentTagQueryResult (Tag tagWhat, Tag positiveTag, Tag negativeTag, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentTagQueryResult (tagWhat, positiveTag, negativeTag, new QuerySelectInit(), nbOfResult, useCache);
	}	
    
    public List<Tag> getDistinctTag(Tag tagWhat, Tag positiveTag, Tag negativeTag) {
		 return partialLoadWithParentTag(tagWhat, positiveTag, negativeTag, new QuerySelectDistinctInit(), null, false);
	}
	
	public List<Tag> partialLoadWithParentTag(Tag tagWhat, Tag positiveTag, Tag negativeTag) {
		 return partialLoadWithParentTag(tagWhat, positiveTag, negativeTag, new QuerySelectInit(), null, false);
	}	
  
	public List<Tag> partialLoadWithParentTagUseCacheOnResult(Tag tagWhat, Tag positiveTag, Tag negativeTag, Boolean useCache) {
		String key = getCacheKey(tagWhat, positiveTag, negativeTag, "partialLoadWithParentTag");
		List<Tag> list = (List<Tag>)simpleCache.get(key);
		if (list==null || list.isEmpty()) {
			list = partialLoadWithParentTag(tagWhat, positiveTag, negativeTag);
			if (!list.isEmpty())
			   simpleCache.put(key, list);
		}
		return list;	
	}	

	public List<Tag> partialLoadWithParentTagUseCache(Tag tagWhat, Tag positiveTag, Tag negativeTag, Boolean useCache) {
		String key = getCacheKey(tagWhat, positiveTag, negativeTag, "partialLoadWithParentTag");
		List<Tag> list = (List<Tag>)simpleCache.get(key);
		if (list==null) {
			list = partialLoadWithParentTag(tagWhat, positiveTag, negativeTag);
			simpleCache.put(key, list);
		}
		return list;	
	}	
	
	private List<Tag> handleLoadWithParentTag(Map beanPath, List list, Tag tagWhat) {
	    return handleLoadWithParentTag(beanPath, list, tagWhat, true);  
	}
	
	private List<Tag> handleLoadWithParentTag(Map beanPath, List list, Tag tagWhat, boolean isHql) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentTagWithOneElementInRow(list, beanPath, tagWhat, isHql);
		}
		return handlePartialLoadWithParentTag(list, beanPath, tagWhat, isHql);	
	}
	
    	// to set in super class	
	protected void populateTag (Tag tag, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(tag, beanPath, value);
	}
	
	protected void populateTagFromSQL (Tag tag, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(tag, beanPath, value);
	}
    	// to set in super class BEWARE: genericity is only one level!!!!! first level is a copy second level is a reference!!! change to tag.clone() instead
	private Tag cloneTag (Tag tag) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		//return (Tag) BeanUtils.cloneBeanObject(tag);
	   if (tag==null) return new Tag();
	   return tag.clone();
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
	
    public List<Tag> countDistinct (Tag whatMask, Tag whereEqCriteria) {
       return partialLoadWithParentTag(whatMask, whereEqCriteria, null, new QuerySelectCountInit("tag"), null, false);
    }   
  	
    public Long count(Tag whereEqCriteria) {
	    return count(null, whereEqCriteria, EntityMatchType.ALL, OperandType.EQUALS, true); 
/*        Query query = getEntityManager().createQuery(getSelectCountPrototype(whereEqCriteria));
        List<Long> list = query.getResultList();
    	if (!list.isEmpty()) {
            return list.get(0);
    	}
    	return 0L;
*/
    }


    public Long count(Tag whatMask, Tag whereCriteria, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
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

	protected String countQuery (Tag tag, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
        String what = "SELECT count(*) FROM Tag tag ";
		return findQuery (tag, null, what, matchType, operandType, caseSensitivenessType, null);
    }
	

   private List getFirstResultWhereConditionsAre (Tag tag) {
      return partialLoadWithParentTagQueryResult(getDefaultTagWhat(), tag, null, 1, false);	
   }
   
   protected Tag getDefaultTagWhat() {
      Tag tag = new Tag();
	// default what clause for composite pk is not yet supported - Contribution welcomed!
      return tag;
   }
   
	public Tag getFirstTag (Tag tag) {
		if (isAllNull(tag))
			return null;
		else {
			List<Tag> list = searchPrototype (tag, 1);
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
    * checks if the Tag entity exists
    */           
    public boolean existsTag (Tag tag) {
       if (getFirstTag(tag)!=null)
          return true;
       return false;  
    }
        
    public boolean existsTagWhereConditionsAre (Tag tag) {
       if (getFirstResultWhereConditionsAre (tag).isEmpty())
          return false;
       return true;  
    }

	private int countPartialField (Tag tag) {
	   int cpt = 0;
       if (tag.getTagId_() != null) {
          cpt++;
       }
       if (tag.getName_() != null) {
          cpt++;
       }
       return cpt;
	}   

	public List<Tag> partialLoadWithParentTag(Tag what, Tag positiveTag, Tag negativeTag, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		Map beanPath = new Hashtable();
		List list = partialLoadWithParentTagJPAQueryResult (what, positiveTag, negativeTag, queryWhatInit, beanPath, nbOfResult, useCache);
		return handlePartialLoadWithParentResult(what, list, beanPath);
	}
	
	public List<Tag> handlePartialLoadWithParentResult(Tag what, List list, Map beanPath) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentTagWithOneElementInRow(list, beanPath, what, true);
		}
		return handlePartialLoadWithParentTag(list, beanPath, what, true);
	}	

	private List partialLoadWithParentTagQueryResult(Tag tagWhat, Tag positiveTag, Tag negativeTag, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		return partialLoadWithParentTagJPAQueryResult (tagWhat, positiveTag, negativeTag, queryWhatInit, new Hashtable(), nbOfResult, useCache);
    }	
  
	private List partialLoadWithParentTagJPAQueryResult(Tag tagWhat, Tag positiveTag, Tag negativeTag, QueryWhatInit queryWhatInit, Map beanPath, Integer nbOfResult, Boolean useCache) {
		Query hquery = getPartialLoadWithParentJPAQuery (tagWhat, positiveTag, negativeTag, beanPath, queryWhatInit, nbOfResult);
		return hquery.getResultList();
    }	
   /**
    * @returns an JPA Hsql query based on entity Tag and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPAQuery (Tag tagWhat, Tag positiveTag, Tag negativeTag, Map beanPath, QueryWhatInit queryWhatInit, Integer nbOfResult) {
	   Query query = getPartialLoadWithParentJPARawQuery (tagWhat, positiveTag, negativeTag, beanPath, queryWhatInit);
	   if (nbOfResult!=null)
	      query.setMaxResults(nbOfResult);
	   return query;
    }
  	
   /**
    * @returns an JPA Raw Hsql query based on entity Tag and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPARawQuery (Tag tagWhat, Tag positiveTag, Tag negativeTag, Map beanPath, QueryWhatInit queryWhatInit) {
	   return getEntityManager().createQuery(getPartialLoadWithParentRawHsqlQuery (tagWhat, positiveTag, negativeTag, beanPath, queryWhatInit));
    }
	
	private List<Tag> handlePartialLoadWithParentTag(List<Object[]> list, Map<Integer, String> beanPath, Tag tagWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentTag(list, beanPath, tagWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentTag, message:"+ex.getMessage());
			return new ArrayList<Tag>();
		}
    }

	private List<Tag> handlePartialLoadWithParentTagWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, Tag tagWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentTagWithOneElementInRow(list, beanPath, tagWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentTagWithOneElementInRow, message:"+ex.getMessage());
			return new ArrayList<Tag>();
		}
    }
    	
	 private List<Tag> convertPartialLoadWithParentTag(List<Object[]> list, Map<Integer, String> beanPath, Tag tagWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<Tag> resultList = new ArrayList<Tag>();
		 for (Object[] row : list) {		
		    Tag tag = cloneTag (tagWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populateTag (tag, row[(Integer)entry.getKey()], (String)entry.getValue());
		    }
		    resultList.add(tag);
		 }
		 return resultList;		
	 }	
    
	 private List<Tag> convertPartialLoadWithParentTagWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, Tag tagWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<Tag> resultList = new ArrayList<Tag>();
		 for (Object row : list) {		
		    Tag tag = cloneTag (tagWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populateTag (tag, row, (String)entry.getValue());
		    }
		    resultList.add(tag);
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
	public String getPartialLoadWithParentRawHsqlQuery (Tag tag, Tag positiveTag, Tag negativeTag, Map beanPath, QueryWhatInit queryWhatInit) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentTagQuery (tag, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
		Hashtable aliasWhereHt = new Hashtable();
		String where = getPartialLoadWithParentWhereQuery (positiveTag, null, aliasWhatHt, aliasWhereHt, null, null);
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
	public String findPartialLoadWithParentRawHsqlQuery (Tag whatMask, Tag criteriaMask, Map beanPath, QueryWhatInit queryWhatInit,  Tag orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentTagQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
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
	public String countPartialLoadWithParentRawHsqlQuery (Tag whatMask, Tag criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
		Map beanPath = new Hashtable();
		Hashtable aliasWhatHt = new Hashtable();
		// used to initiate the how part of the what
		getPartialLoadWithParentTagQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", new QuerySelectInit());
		String what = "select count(tag) ";
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
    	
	public String findPartialQuery (Tag whatMask, Tag criteriaMask, Tag orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Map beanPath) {
        QueryWhatInit queryWhatInit = new QuerySelectInit();
        return findPartialLoadWithParentRawHsqlQuery(whatMask, criteriaMask, beanPath, queryWhatInit, orderMask, matchType, operandType, caseSensitivenessType,  sortOrder);
    }
	
	/**
    * partial on a single entity load enables to specify the fields you want to load explicitly
    */         
	public List<Tag> partialLoadTag(Tag tag, Tag positiveTag, Tag negativeTag) {
	    Query hquery = getEntityManager().createQuery(getPartialLoadTagQuery (tag, positiveTag, negativeTag));
		int countPartialField = countPartialField(tag);
		if (countPartialField==0) 
			return new ArrayList<Tag>();
		List list = hquery.getResultList();
		Iterator iter = list.iterator();
		List<Tag> returnList = new ArrayList<Tag>();
		while(iter.hasNext()) {
			int index = 0;
			Object[] row;
			if (countPartialField==1) {
				row = new Object[1];
				row[0] = iter.next();
				} 
			else 
				row = (Object[]) iter.next();
			Tag tagResult = new Tag();
			if (tag.getTagId_() != null) {
                tagResult.setTagId_((Integer) row[index]);
				index++;
			}
			if (tag.getName_() != null) {
                tagResult.setName_((String) row[index]);
				index++;
			}
			returnList.add(tagResult);
        }
	    return returnList;
	}

	public static String getPartialLoadWithParentWhereQuery (
	   Tag criteriaMask, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias,
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
	   Tag tag, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias) {
	   if (tag==null)
	      return "";
	   String alias = null;
	   if (aliasWhereHt == null) {
	      aliasWhereHt = new Hashtable();
	   } 
	   if (isLookedUp(tag)){
	      alias = getNextAlias (aliasWhereHt, tag);
		  aliasWhereHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
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
	
    public static String getPartialLoadWithParentTagQuery (
	   Tag tag, Boolean isWhereSet, Hashtable aliasHt, String childAlias, String childFKAlias, Map beanPath, String rootPath, QueryWhatInit queryWhatInit) {
	   if (tag==null)
	      return "";
	   String alias = null;
	   if (aliasHt == null) {
	      aliasHt = new Hashtable();
	   } 
	   if (isLookedUp(tag)){
	      alias = getNextAlias (aliasHt, tag);
		  aliasHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
//       query.append(getTagSearchEqualQuery (positiveTag, negativeTag));
	   return query.toString(); 
    }
	
	protected static String getAliasConnection(String existingAlias, String childAlias, String childFKAlias) {
		if (childAlias==null)
		   return "";
		return childAlias+"."+childFKAlias+" = "+existingAlias+"."+"tagId";
	}
	
	protected static String getAliasKey (String alias) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return "Tag|"+alias;
	}
	
	protected static String getAliasKeyAlias (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return StringUtils.substringAfter(aliasKey, "|");
	}
	
	protected static String getAliasKeyDomain (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
	  return StringUtils.substringBefore(aliasKey, "|");
	}
	
	protected static String getNextAlias (Hashtable aliasHt, Tag tag) {
		int cptSameAlias = 0;
		Enumeration<String> _keys = aliasHt.keys();
		while (_keys.hasMoreElements()) {
			String _key = _keys.nextElement();
			if (_key.startsWith("tag"))
				cptSameAlias++;
		}
		if (cptSameAlias==0)
			return "tag";
		else
			return "tag_"+cptSameAlias;
	}
	
	
	protected static boolean isLookedUp (Tag tag) {
	   if (tag==null)
		  return false;
       return false;   
	}
	
    public String getPartialLoadTagQuery(
	   Tag tag, 
	   Tag positiveTag, 
	   Tag negativeTag) {
       boolean isWhereSet = false;
       StringBuffer query = new StringBuffer();
	   query.append(getFromEntity());
       query.append(getTagPositiveNegativeCriteria (positiveTag, negativeTag));
	   return query.toString(); 
    }
	
	public List<Tag> searchPrototypeWithCacheTag(Tag tag) {
		SimpleCache simpleCache = new SimpleCache();
		List<Tag> list = (List<Tag>)simpleCache.get(tag.toString());
		if (list==null) {
			list = searchPrototypeTag(tag);
			simpleCache.put(tag.toString(), list);
		}
		return list;
	}

    public List<Tag> loadGraph(Tag graphMaskWhat, List<Tag> whereMask) {
        return loadGraphOneLevel(graphMaskWhat, whereMask);
    }

	public List<Tag> loadGraphOneLevel(Tag graphMaskWhat, List<Tag> whereMask) {
		//first get roots element from where list mask
		// this brings the level 0 of the graph (root level)
 		// default what clause for composite pk is not yet supported - Contribution welcomed!
		List<Tag> tags = searchPrototypeTag (whereMask);
		// for each sub level perform the search with a subquery then reassemble
		// 1. get all sublevel queries
		// 2. perform queries on the correct dao
		// 3. reassemble
		return getLoadGraphOneLevel (graphMaskWhat, tags);
	}

	private List<Tag> copy(List<Tag> inputs) {
		List<Tag> l = new ArrayList<Tag>();
		for (Tag input : inputs) {
			Tag copy = new Tag();
			copy.copy(input);
			l.add(copy);
		}
		return l;
	}
	   
	private List<Tag> getLoadGraphOneLevel (Tag graphMaskWhat, List<Tag> parents) {
	    return loadGraphFromParentKey (graphMaskWhat, parents);
	} 
	
	public List<Tag> loadGraphFromParentKey (Tag graphMaskWhat, List<Tag> parents) {
		//foreach children:
		//check if not empty take first
		parents = copy (parents); //working with detached entities to avoid unnecessary sql calls
		if (parents==null || parents.isEmpty())
		   return parents;
		List<String> ids = getPk (parents);
		return parents;
	}
	
	private List<String> getPk(List<Tag> input) {
		List<String> s = new ArrayList<String>();
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
	public void find (QueryData<Tag> data) {
		EntityCriteria<Tag> filter = data.getEntityCriteria();
		Tag entityWhat = data.getEntityWhat();
		Tag criteriaMask = filter.getEntity();
		int start = data.getStart();
		int max = data.getMax();
		EntitySort<Tag> entitySort = data.getEntitySort();
		QuerySortOrder sortOrder = entitySort.getOrder();
		Tag sortMask = entitySort.getEntity();	

		List<Tag> results = find(entityWhat, criteriaMask, sortMask, filter.getMatchType(), filter.getOperandType(), filter.getCaseSensitivenessType(), sortOrder, start, max);
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
     * return a list of Tag entities 
     */
    public List<Tag> getList () {
        //first lightweight implementation
        return searchPrototypeTag(new Tag());
    }
    /**
     * return a list of Tag entities and sort
     */
    public List<Tag> getList (Tag orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(new Tag(), orderMask, sortOrder, null);
    }
    /**
     * return a list of Tag entities and sort based on a Tag prototype
     */
    public List<Tag> list (Tag mask, Tag orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(mask, orderMask, sortOrder, null);
    }

	@Override
    protected String getSelectFrom() {
        return "SELECT tag "+getFromEntity();
    }

    protected String getFromEntity() {
        return " FROM Tag tag ";
    }

    @Override
    protected String getQuerySelectFromEntity() {
        return getSelectFrom();
    }
	



}
