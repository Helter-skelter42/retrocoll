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

import com.retrocoll.server.dao.face.server.ValueListDao;
import com.retrocoll.server.domain.server.ValueList;

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
 * <p>Title: ValueListJPAImpl</p>
 *
 * <p>Description: Interface of a Data access object dealing with ValueListJPAImpl
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching ValueListJPAImpl objects</p>
 *
 */


@org.springframework.stereotype.Repository(value="valueListDao")

public class ValueListJPAImpl extends ServerGenericDaoJpaImpl<ValueList> implements ValueListDao {
	public ValueListJPAImpl () {}
	
    /**
     * Inserts a ValueList entity 
     * @param ValueList valuelist
     */
    public void insertValueList(ValueList valuelist) {
       entityManager.persist(valuelist);
    }

    protected void insertValueList(EntityManager emForRecursiveDao, ValueList valuelist) {
       emForRecursiveDao.persist(valuelist);
    } 

    /**
     * Updates a ValueList entity 
     * @param ValueList valuelist
     */
    public ValueList updateValueList(ValueList valuelist) {
       return entityManager.merge(valuelist);
    }

	/**
     * Updates a ValueList entity with only the attributes set into ValueList.
	 * The primary keys are to be set for this method to operate.
	 * This is a performance friendly feature, which remove the udibiquous full load and full update when an
	 * update is issued
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param ValueList valuelist
    */ 
    @Transactional
    public Integer updateNotNullOnlyValueList(ValueList valuelist) {
        Query jpaQuery = getEntityManager().createQuery(getUpdateNotNullOnlyValueListQueryChunk(valuelist));
        if (valuelist.getValueId() != null) {
           jpaQuery.setParameter ("valueId", valuelist.getValueId());
        }   
        if (valuelist.getName() != null) {
           jpaQuery.setParameter ("name", valuelist.getName());
        }   
        if (valuelist.getGroup() != null) {
           jpaQuery.setParameter ("group", valuelist.getGroup());
        }   
		return jpaQuery.executeUpdate();
    }

    protected String getUpdateNotNullOnlyValueListQueryChunkPrototype (ValueList valuelist) {
        boolean isSetSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update ValueList valuelist ");
        if (valuelist.getName() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" valuelist.name = :name");
        }
        if (valuelist.getGroup() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" valuelist.group = :group");
        }
        if (isSetSet==false)
			throw new IllegalArgumentException("valuelist mask should contain updatable fields");
        return query.toString();
    }
    
    protected String getUpdateNotNullOnlyValueListQueryChunk (ValueList valuelist) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer(getUpdateNotNullOnlyValueListQueryChunkPrototype(valuelist));
        if (valuelist.getValueId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
			     query.append(" valuelist.valueId = :valueId");
        }
        if (isWhereSet==false)
			throw new IllegalArgumentException("valuelist mask should contain primary key");
        return query.toString();
    }
    
                
	protected ValueList assignBlankToNull (ValueList valuelist) {
        if (valuelist==null)
			return null;
        if (valuelist.getName()!=null && valuelist.getName().equals(""))
           valuelist.setName((String)null);
        if (valuelist.getGroup()!=null && valuelist.getGroup().equals(""))
           valuelist.setGroup((String)null);
		return valuelist;
	}
	
	protected boolean isAllNull (ValueList valuelist) {
	    if (valuelist==null)
			return true;
        if (valuelist.getValueId()!=null) 
            return false;
        if (valuelist.getName()!=null) 
            return false;
        if (valuelist.getGroup()!=null) 
            return false;
		return true;
	}
		
    @Transactional
    public Integer updateNotNullOnlyPrototypeValueList(ValueList valuelist, ValueList prototypeCriteria) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update ValueList valuelist ");
        if (valuelist.getValueId() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" valuelist.valueId = "+ valuelist.getValueId() + " ");
        }
        if (valuelist.getName() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" valuelist.name = '"+ valuelist.getName()+"' ");
        }
        if (valuelist.getGroup() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" valuelist.group = '"+ valuelist.getGroup()+"' ");
        }
		isWhereSet = false; 
        if (prototypeCriteria.getValueId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" valuelist.valueId = "+ prototypeCriteria.getValueId() + " ");
        }
        if (prototypeCriteria.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" valuelist.name = '"+ prototypeCriteria.getName()+"' ");
        }
        if (prototypeCriteria.getGroup() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" valuelist.group = '"+ prototypeCriteria.getGroup()+"' ");
        }
        Query jpaQuery = getEntityManager().createQuery(query.toString());
		return jpaQuery.executeUpdate();
    }
     
     /**
     * Saves a ValueList entity 
     * @param ValueList valuelist
     */
    public void saveValueList(ValueList valuelist) {
       //entityManager.persist(valuelist);
       if (entityManager.contains(valuelist)) {
          entityManager.merge(valuelist);
       } else {
          entityManager.persist(valuelist);
       }
       entityManager.flush(); 
    }
       
    /**
     * Deletes a ValueList entity 
     * @param ValueList valuelist
     */
    public void deleteValueList(ValueList valuelist) {
      entityManager.remove(valuelist);
    }
    
    /**
     * Loads the ValueList entity which is related to an instance of
     * ValueList
     * @param Long id
     * @return ValueList The ValueList entity
     
    public ValueList loadValueList(Long id) {
    	return (ValueList)entityManager.get(ValueList.class, id);
    }
*/
  
    /**
     * Loads the ValueList entity which is related to an instance of
     * ValueList
     * @param java.lang.Integer ValueId
     * @return ValueList The ValueList entity
     */
    public ValueList loadValueList(java.lang.Integer valueId) {
    	return (ValueList)entityManager.find(ValueList.class, valueId);
    }
    
    /**
     * Loads the ValueList entity which is related to an instance of
     * ValueList and its dependent one to many objects
     * @param Long id
     * @return ValueList The ValueList entity
     */
    public ValueList loadFullFirstLevelValueList(java.lang.Integer valueId) {
        List list = getResultList(
                     "SELECT valuelist FROM ValueList valuelist "
                     + " LEFT JOIN valuelist.accessorieValueListViaColor "   
                     + " LEFT JOIN valuelist.accessorieValueListViaRegion "   
                     + " LEFT JOIN valuelist.hardwareValueListViaColor "   
                     + " LEFT JOIN valuelist.hardwareValueListViaRegion "   
                     + " LEFT JOIN valuelist.softwareValueListViaConsole "   
                     + " LEFT JOIN valuelist.softwareValueListViaRegion "   
                     + " LEFT JOIN valuelist.softwareValueListViaStyle "   
                     + " WHERE valuelist.valueId = "+valueId
               );
         if (list!=null && !list.isEmpty())
            return (ValueList)list.get(0);
         return null;
    	//return null;//(ValueList) entityManager.queryForObject("loadFullFirstLevelValueList", id);
    }

    /**
     * Loads the ValueList entity which is related to an instance of
     * ValueList
     * @param ValueList valuelist
     * @return ValueList The ValueList entity
     */
    public ValueList loadFullFirstLevelValueList(ValueList valuelist) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT valuelist FROM ValueList valuelist ");
        query.append (" LEFT JOIN valuelist.accessorieValueListViaColor ");
        query.append (" LEFT JOIN valuelist.accessorieValueListViaRegion ");
        query.append (" LEFT JOIN valuelist.hardwareValueListViaColor ");
        query.append (" LEFT JOIN valuelist.hardwareValueListViaRegion ");
        query.append (" LEFT JOIN valuelist.softwareValueListViaConsole ");
        query.append (" LEFT JOIN valuelist.softwareValueListViaRegion ");
        query.append (" LEFT JOIN valuelist.softwareValueListViaStyle ");
        if (valuelist.getValueId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" valuelist.valueId = "+ valuelist.getValueId() + " ");
         }
        List list = getResultList(query.toString());
        if (list!=null && !list.isEmpty())
           return (ValueList)list.get(0);    
        return null;
    }  

    /**
     * Searches a list of ValueList entity 
     * @param ValueList valuelist
     * @return List
     */  
    public List<ValueList> searchPrototypeValueList(ValueList valuelist) {
       return searchPrototype (valuelist, null);
    }  
	
    public List<ValueList> searchPrototypeAnyValueList(ValueList valuelist) {
       return searchPrototypeAny (valuelist, null);
    }  

	// indirection
    public List<ValueList> find (ValueList criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
       return find (criteriaMask, matchType, operandType, caseSensitivenessType, null, null); 
	}
	
	// indirection
	protected List<ValueList> find (ValueList criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, Integer startPosition, Integer maxResults) {
       return find (criteriaMask, null, matchType, operandType, caseSensitivenessType, null, startPosition, maxResults); 
    }
	
	// indirection
	protected List<ValueList> find (ValueList criteriaMask, ValueList orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
       return find (null, criteriaMask, orderMask, matchType, operandType, caseSensitivenessType, sortOrder, startPosition, maxResults);
    }
	
	// main find implementation
	protected List<ValueList> find (ValueList whatMask, ValueList criteriaMask, ValueList orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
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
    public String findQuery (ValueList criteriaMask, ValueList orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String what = "SELECT valuelist FROM ValueList valuelist ";
		return findQuery (criteriaMask, orderMask, what, matchType, operandType, caseSensitivenessType, sortOrder);
    }

    protected String findQuery (ValueList criteriaMask, ValueList orderMask, String what, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String queryWhere = findWhere (criteriaMask, false, isAll(matchType), operandType, caseSensitivenessType);
		String queryOrder = findOrder (orderMask, sortOrder);
	    return getHQuery(what, queryWhere, queryOrder);
    }
	
    protected List<ValueList> searchPrototype (ValueList valuelist, ValueList orderMask, QuerySortOrder sortOrder, Integer maxResults) {
       return searchPrototype(getValueListSelectQuery (getWhereEqualWhereQueryChunk(valuelist), orderMask, sortOrder), maxResults);
    }

    protected List<ValueList> searchPrototype (ValueList valuelist, Integer maxResults) {
       return searchPrototype(valuelist, null, null, maxResults);
    }
    
    protected List<ValueList> searchPrototypeAny (ValueList valuelist, Integer maxResults) { 
       return searchPrototype(getSearchEqualAnyQuery (valuelist), maxResults);
    }
    
    protected List<ValueList> searchPrototype (String query, Integer maxResults) { 
       Query hquery = getEntityManager().createQuery(query);
       if (maxResults!=null)
          hquery.setMaxResults(maxResults);
       return hquery.getResultList();
    }

    public List<ValueList> searchPrototypeValueList (List<ValueList> valuelists) {
       return searchPrototype (valuelists, null);
    }

    protected List<ValueList> searchPrototype (List<ValueList> valuelists, Integer maxResults) {    
	   return getResultList(getValueListSearchEqualQuery (null, valuelists));
	}    

    protected List<ValueList> getResultList (String query) {    
	   Query hquery = entityManager.createQuery(query);            
	   return hquery.getResultList();
	}    
 

    public List<ValueList> searchDistinctPrototypeValueList (ValueList valuelistMask, List<ValueList> valuelists) {
        return getResultList(getValueListSearchEqualQuery (valuelistMask, valuelists));    
    }
        
	/**
     * Searches a list of ValueList entity 
     * @param ValueList positiveMask
     * @param ValueList negativeMask
     * @return List
     */
    public List<ValueList> searchPrototypeValueList(ValueList positiveMask, ValueList negativeMask) {
	    return getResultList(getValueListSearchEqualQuery (positiveMask, negativeMask));  
    }

    /**
    * return a string query search on a ValueList prototype
    */
    protected String getValueListSelectQuery (String where, ValueList orderMask, QuerySortOrder sortOrder) {
       return getValueListSelectQuery (where, findOrder (orderMask, sortOrder));
    }
    protected String getValueListSelectQuery (String where, String order) {
       StringBuffer query = new StringBuffer();
       query.append ("SELECT valuelist FROM ValueList valuelist ");
       return (order!=null)? getHQuery(query.toString(), where, order):getHQuery(query.toString(), where);
    }
    /**
    * return a jql query search on a ValueList prototype
    */
    protected String getSearchEqualQuery (ValueList valuelist) {
       return getValueListSelectQuery (getWhereEqualWhereQueryChunk(valuelist),null);
    }
    protected String getWhereEqualWhereQueryChunk (ValueList valuelist) {
       return getWhereEqualWhereQueryChunk(valuelist, false);
    }
    /**
    * return a jql query search on a ValueList with any prototype
    */
    protected String getSearchEqualAnyQuery (ValueList valuelist) {
       return getValueListSelectQuery (getWhereEqualAnyWhereQueryChunk(valuelist), null);   
    }
    protected String getWhereEqualAnyWhereQueryChunk (ValueList valuelist) {
       return getWhereEqualAnyWhereQueryChunk(valuelist, false);   
    }

    /**
    * return a jql search for a list of ValueList prototype
    */
    protected String getValueListSearchEqualQuery (ValueList valuelistMask, List<ValueList> valuelists) {
        boolean isOrSet = false;
        StringBuffer query = new StringBuffer();
        if (valuelistMask !=null)
           query.append (getValueListMaskWhat (valuelistMask));
        query.append (" FROM ValueList valuelist ");
        StringBuffer queryWhere = new StringBuffer();
        for (ValueList valuelist : valuelists) {
           if (!isAllNull(valuelist)) {        
	           queryWhere.append (getQueryOR (isOrSet));
	           isOrSet = true;
	           queryWhere.append (" ("+getWhereEqualWhereQueryChunk(valuelist, false)+") ");
           }
        }
	    return getHQuery(query.toString(), queryWhere.toString());
    }	

    
    protected String getValueListMaskWhat (ValueList valuelistMask) {
        boolean isCommaSet = false;
        StringBuffer query = new StringBuffer("SELECT DISTINCT ");
        if (valuelistMask.getValueId() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" valueId ");
        }
        if (valuelistMask.getName() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" name ");
        }
        if (valuelistMask.getGroup() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" group ");
        }
        if (!isCommaSet)
           return "";
	    return query.toString();
    }
    
    protected String getWhereEqualAnyWhereQueryChunk (ValueList valuelist, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (valuelist, isAndSet, false);	
	}
	
    protected String getWhereEqualWhereQueryChunk (ValueList valuelist, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (valuelist, isAndSet, true);
	}
	
    protected String getSearchEqualWhereQueryChunk (ValueList valuelist, boolean isAndSet, boolean isAll) {
        StringBuffer query = new StringBuffer();
        if (valuelist.getValueId() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" valuelist.valueId = "+ valuelist.getValueId() + " ");
        }
        if (valuelist.getName() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" valuelist.name = '"+ valuelist.getName()+"' ");
        }
        if (valuelist.getGroup() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" valuelist.group = '"+ valuelist.getGroup()+"' ");
        }
	    return query.toString();
    }

    protected String findOrder (ValueList orderMask, QuerySortOrder sortOrder) {
        if (orderMask!=null) {
            String orderColumn = getFirstNotNullColumnOtherWiseNull(orderMask);
            if (orderColumn!=null)
               return orderColumn + " " + sortOrder;
        }
        return "";
    }

	@Override
    protected String findWhere (ValueList valuelist, boolean isAndSet, boolean isAll, OperandType operandType, Boolean caseSensitive) {
		return findWhere (null, valuelist, isAndSet, isAll, operandType, caseSensitive);
	}
	
	protected static String findWhere (String alias, ValueList valuelist, boolean isAndSet, boolean isAll, OperandType operandType, boolean caseSensitive) {
        if (alias==null)
			alias = "valuelist";
		StringBuffer query = new StringBuffer();
		String operand = getOperand (operandType);
		String evaluatorPrefix = getEvaluatorPrefix (operandType);		
		String evaluatorSuffix = getEvaluatorSuffix (operandType);		
        if (valuelist.getValueId() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".valueId = "+ valuelist.getValueId() + " ");
        }
        if (valuelist.getName() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = valuelist.getName();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".name) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".name "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (valuelist.getGroup() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = valuelist.getGroup();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".group) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".group "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        return query.toString();
    }
	
	protected String getFirstNotNullColumnOtherWiseNull (ValueList mask) {
        if (mask == null) return null;
        if (mask.getValueId() != null) return "valueId";
        if (mask.getName() != null) return "name";
        if (mask.getGroup() != null) return "group";
        return null;	
	}
    
    /**
    * return a jql search on a ValueList prototype with positive and negative beans
    */
    protected String getValueListSearchEqualQuery (ValueList positiveMask, ValueList negativeMask) {
		StringBuffer query = new StringBuffer();    	
		query.append(getSelectFrom());
		query.append(getValueListPositiveNegativeCriteria(positiveMask, negativeMask));
		return query.toString();
	}

	protected String getValueListPositiveNegativeCriteria (ValueList positiveMask, ValueList negativeMask) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        if (positiveMask!=null && positiveMask.getValueId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" valuelist.valueId = "+ positiveMask.getValueId() + " ");
        } 
		if (negativeMask!=null && negativeMask.getValueId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" valuelist.valueId is null ");
        }
        if (positiveMask!=null && positiveMask.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" valuelist.name = '"+ positiveMask.getName()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" valuelist.name is null ");
        }
        if (positiveMask!=null && positiveMask.getGroup() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" valuelist.group = '"+ positiveMask.getGroup()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getGroup() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" valuelist.group is null ");
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
    public ValueListJPAImpl (EntityManager emForRecursiveDao) {
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
     * Inserts a ValueList entity with cascade of its children
     * @param ValueList valuelist
     */
    public void insertValueListWithCascade(ValueList valuelist) {
    	ValueListJPAImpl valuelistjpaimpl = new ValueListJPAImpl(getEntityManager());
    	valuelistjpaimpl.insertValueListWithCascade(valuelistjpaimpl.getEntityManagerForRecursiveDao(), valuelist);
    }
     
    public void insertValueListWithCascade(EntityManager emForRecursiveDao, ValueList valuelist) {
       insertValueList(emForRecursiveDao, valuelist);
       if (!valuelist.getAccessorieValueListViaColor().isEmpty()) {
          AccessorieJPAImpl accessorieextendedjpaimpl = new AccessorieJPAImpl (emForRecursiveDao);
          for (Accessorie _accessorieValueListViaColor : valuelist.getAccessorieValueListViaColor()) {
             accessorieextendedjpaimpl.insertAccessorieWithCascade(emForRecursiveDao, _accessorieValueListViaColor);
          }
       } 
       if (!valuelist.getAccessorieValueListViaRegion().isEmpty()) {
          AccessorieJPAImpl accessorieextendedjpaimpl = new AccessorieJPAImpl (emForRecursiveDao);
          for (Accessorie _accessorieValueListViaRegion : valuelist.getAccessorieValueListViaRegion()) {
             accessorieextendedjpaimpl.insertAccessorieWithCascade(emForRecursiveDao, _accessorieValueListViaRegion);
          }
       } 
       if (!valuelist.getHardwareValueListViaColor().isEmpty()) {
          HardwareJPAImpl hardwareextendedjpaimpl = new HardwareJPAImpl (emForRecursiveDao);
          for (Hardware _hardwareValueListViaColor : valuelist.getHardwareValueListViaColor()) {
             hardwareextendedjpaimpl.insertHardwareWithCascade(emForRecursiveDao, _hardwareValueListViaColor);
          }
       } 
       if (!valuelist.getHardwareValueListViaRegion().isEmpty()) {
          HardwareJPAImpl hardwareextendedjpaimpl = new HardwareJPAImpl (emForRecursiveDao);
          for (Hardware _hardwareValueListViaRegion : valuelist.getHardwareValueListViaRegion()) {
             hardwareextendedjpaimpl.insertHardwareWithCascade(emForRecursiveDao, _hardwareValueListViaRegion);
          }
       } 
       if (!valuelist.getSoftwareValueListViaConsole().isEmpty()) {
          SoftwareJPAImpl softwareextendedjpaimpl = new SoftwareJPAImpl (emForRecursiveDao);
          for (Software _softwareValueListViaConsole : valuelist.getSoftwareValueListViaConsole()) {
             softwareextendedjpaimpl.insertSoftwareWithCascade(emForRecursiveDao, _softwareValueListViaConsole);
          }
       } 
       if (!valuelist.getSoftwareValueListViaRegion().isEmpty()) {
          SoftwareJPAImpl softwareextendedjpaimpl = new SoftwareJPAImpl (emForRecursiveDao);
          for (Software _softwareValueListViaRegion : valuelist.getSoftwareValueListViaRegion()) {
             softwareextendedjpaimpl.insertSoftwareWithCascade(emForRecursiveDao, _softwareValueListViaRegion);
          }
       } 
       if (!valuelist.getSoftwareValueListViaStyle().isEmpty()) {
          SoftwareJPAImpl softwareextendedjpaimpl = new SoftwareJPAImpl (emForRecursiveDao);
          for (Software _softwareValueListViaStyle : valuelist.getSoftwareValueListViaStyle()) {
             softwareextendedjpaimpl.insertSoftwareWithCascade(emForRecursiveDao, _softwareValueListViaStyle);
          }
       } 
    }
        
    /**
     * Inserts a list of ValueList entity with cascade of its children
     * @param List<ValueList> valuelists
     */
    public void insertValueListsWithCascade(List<ValueList> valuelists) {
       for (ValueList valuelist : valuelists) {
          insertValueListWithCascade(valuelist);
       }
    } 
        
    /**
     * lookup ValueList entity ValueList, criteria and max result number
     */
    public List<ValueList> lookupValueList(ValueList valuelist, Criteria criteria, Integer numberOfResult, EntityManager em) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT valuelist FROM ValueList valuelist ");
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
    
    public List<ValueList> lookupValueList(ValueList valuelist, Criteria criteria, Integer numberOfResult) {
		return lookupValueList(valuelist, criteria, numberOfResult, getEntityManager());
    }

    public Integer updateNotNullOnlyValueList (ValueList valuelist, Criteria criteria) {
        String queryWhat = getUpdateNotNullOnlyValueListQueryChunkPrototype (valuelist);
        StringBuffer query = new StringBuffer (queryWhat);
        boolean isWhereSet = false;
        for (Criterion criterion : criteria.getClauseCriterions()) {
            query.append (getQueryWHERE_AND (isWhereSet));
            isWhereSet = true;   
            query.append(criterion.getExpression());			
        }  
        Query jpaQuery = getEntityManager().createQuery(query.toString());
        isWhereSet = false;
        if (valuelist.getValueId() != null) {
           jpaQuery.setParameter ("valueId", valuelist.getValueId());
        }   
        if (valuelist.getName() != null) {
           jpaQuery.setParameter ("name", valuelist.getName());
        }   
        if (valuelist.getGroup() != null) {
           jpaQuery.setParameter ("group", valuelist.getGroup());
        }   
		return jpaQuery.executeUpdate();
    }
	
	public ValueList affectValueList (ValueList valuelist) {
	    return referValueList (valuelist, null, false);		    
	}
		
	/**
	 * Assign the first valuelist retrieved corresponding to the valuelist criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no valuelist corresponding in the database. Then valuelist is inserted and returned with its primary key(s). 
	 */
	public ValueList assignValueList (ValueList valuelist) {
		return referValueList (valuelist, null, true);
	}

	/**
	 * Assign the first valuelist retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no valuelist corresponding in the database. 
	 * Then valuelist is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public ValueList assignValueList (ValueList valuelist, ValueList mask) {
		return referValueList (valuelist, mask, true);
	}

	public ValueList referValueList (ValueList valuelist, ValueList mask, boolean isAssign) {
		valuelist = assignBlankToNull (valuelist);
		if (isAllNull(valuelist))
			return null;
		else {
			List<ValueList> list;
			if (mask==null)
				list = searchPrototypeValueList(valuelist);
			else
				list = searchPrototypeValueList(mask);
			if (list.isEmpty()) {
			    if (isAssign)
			       insertValueList(valuelist);
			    else
				   return null;
			}
			else if (list.size()==1)
				valuelist.copy(list.get(0));
			else 
				//TODO log error
				valuelist.copy(list.get(0));
		}
		return valuelist;		    
	}

   public ValueList assignValueListUseCache (ValueList valuelist) {
      return referValueListUseCache (valuelist, true);
   }
      		
   public ValueList affectValueListUseCache (ValueList valuelist) {
      return referValueListUseCache (valuelist, false);
   }
      		
   public ValueList referValueListUseCache (ValueList valuelist, boolean isAssign) {
	  String key = getCacheKey(null, valuelist, null, "assignValueList");
      ValueList valuelistCache = (ValueList)simpleCache.get(key);
      if (valuelistCache==null) {
         valuelistCache = referValueList (valuelist, null, isAssign);
         if (key!=null)
         	simpleCache.put(key, valuelistCache);
      }
      valuelist.copy(valuelistCache);
      return valuelistCache;
   }	

	private String getCacheKey (ValueList valuelistWhat, ValueList positiveValueList, ValueList negativeValueList, String queryKey) {
	    StringBuffer sb = new StringBuffer();
	    sb.append(queryKey);
	    if (valuelistWhat!=null)
	       sb.append(valuelistWhat.toStringWithParents());
	    if (positiveValueList!=null)
	       sb.append(positiveValueList.toStringWithParents());
	    if (negativeValueList!=null)
	       sb.append(negativeValueList.toStringWithParents());
	    return sb.toString();
	}
	
    public ValueList partialLoadWithParentFirstValueList(ValueList valuelistWhat, ValueList positiveValueList, ValueList negativeValueList){
		List <ValueList> list = partialLoadWithParentValueList(valuelistWhat, positiveValueList, negativeValueList);
		return (!list.isEmpty())?(ValueList)list.get(0):null;
    }
    
    public ValueList partialLoadWithParentFirstValueListUseCache(ValueList valuelistWhat, ValueList positiveValueList, ValueList negativeValueList, Boolean useCache){
		List <ValueList> list = partialLoadWithParentValueListUseCache(valuelistWhat, positiveValueList, negativeValueList, useCache);
		return (!list.isEmpty())?(ValueList)list.get(0):null;
    }
	
	public ValueList partialLoadWithParentFirstValueListUseCacheOnResult(ValueList valuelistWhat, ValueList positiveValueList, ValueList negativeValueList, Boolean useCache){
		List <ValueList> list = partialLoadWithParentValueListUseCacheOnResult(valuelistWhat, positiveValueList, negativeValueList, useCache);
		return (!list.isEmpty())?(ValueList)list.get(0):null;
    }
	//
	protected List<ValueList> partialLoadWithParentValueList(ValueList valuelistWhat, ValueList positiveValueList, ValueList negativeValueList, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentValueList(valuelistWhat, positiveValueList, negativeValueList, new QuerySelectInit(), nbOfResult, useCache);
	}	  

	protected List partialLoadWithParentValueListQueryResult (ValueList valuelistWhat, ValueList positiveValueList, ValueList negativeValueList, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentValueListQueryResult (valuelistWhat, positiveValueList, negativeValueList, new QuerySelectInit(), nbOfResult, useCache);
	}	
    
    public List<ValueList> getDistinctValueList(ValueList valuelistWhat, ValueList positiveValueList, ValueList negativeValueList) {
		 return partialLoadWithParentValueList(valuelistWhat, positiveValueList, negativeValueList, new QuerySelectDistinctInit(), null, false);
	}
	
	public List<ValueList> partialLoadWithParentValueList(ValueList valuelistWhat, ValueList positiveValueList, ValueList negativeValueList) {
		 return partialLoadWithParentValueList(valuelistWhat, positiveValueList, negativeValueList, new QuerySelectInit(), null, false);
	}	
  
	public List<ValueList> partialLoadWithParentValueListUseCacheOnResult(ValueList valuelistWhat, ValueList positiveValueList, ValueList negativeValueList, Boolean useCache) {
		String key = getCacheKey(valuelistWhat, positiveValueList, negativeValueList, "partialLoadWithParentValueList");
		List<ValueList> list = (List<ValueList>)simpleCache.get(key);
		if (list==null || list.isEmpty()) {
			list = partialLoadWithParentValueList(valuelistWhat, positiveValueList, negativeValueList);
			if (!list.isEmpty())
			   simpleCache.put(key, list);
		}
		return list;	
	}	

	public List<ValueList> partialLoadWithParentValueListUseCache(ValueList valuelistWhat, ValueList positiveValueList, ValueList negativeValueList, Boolean useCache) {
		String key = getCacheKey(valuelistWhat, positiveValueList, negativeValueList, "partialLoadWithParentValueList");
		List<ValueList> list = (List<ValueList>)simpleCache.get(key);
		if (list==null) {
			list = partialLoadWithParentValueList(valuelistWhat, positiveValueList, negativeValueList);
			simpleCache.put(key, list);
		}
		return list;	
	}	
	
	private List<ValueList> handleLoadWithParentValueList(Map beanPath, List list, ValueList valuelistWhat) {
	    return handleLoadWithParentValueList(beanPath, list, valuelistWhat, true);  
	}
	
	private List<ValueList> handleLoadWithParentValueList(Map beanPath, List list, ValueList valuelistWhat, boolean isHql) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentValueListWithOneElementInRow(list, beanPath, valuelistWhat, isHql);
		}
		return handlePartialLoadWithParentValueList(list, beanPath, valuelistWhat, isHql);	
	}
	
    	// to set in super class	
	protected void populateValueList (ValueList valuelist, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(valuelist, beanPath, value);
	}
	
	protected void populateValueListFromSQL (ValueList valuelist, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(valuelist, beanPath, value);
	}
    	// to set in super class BEWARE: genericity is only one level!!!!! first level is a copy second level is a reference!!! change to valuelist.clone() instead
	private ValueList cloneValueList (ValueList valuelist) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		//return (ValueList) BeanUtils.cloneBeanObject(valuelist);
	   if (valuelist==null) return new ValueList();
	   return valuelist.clone();
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
	
    public List<ValueList> countDistinct (ValueList whatMask, ValueList whereEqCriteria) {
       return partialLoadWithParentValueList(whatMask, whereEqCriteria, null, new QuerySelectCountInit("valuelist"), null, false);
    }   
  	
    public Long count(ValueList whereEqCriteria) {
	    return count(null, whereEqCriteria, EntityMatchType.ALL, OperandType.EQUALS, true); 
/*        Query query = getEntityManager().createQuery(getSelectCountPrototype(whereEqCriteria));
        List<Long> list = query.getResultList();
    	if (!list.isEmpty()) {
            return list.get(0);
    	}
    	return 0L;
*/
    }


    public Long count(ValueList whatMask, ValueList whereCriteria, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
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

	protected String countQuery (ValueList valuelist, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
        String what = "SELECT count(*) FROM ValueList valuelist ";
		return findQuery (valuelist, null, what, matchType, operandType, caseSensitivenessType, null);
    }
	

   private List getFirstResultWhereConditionsAre (ValueList valuelist) {
      return partialLoadWithParentValueListQueryResult(getDefaultValueListWhat(), valuelist, null, 1, false);	
   }
   
   protected ValueList getDefaultValueListWhat() {
      ValueList valuelist = new ValueList();
      valuelist.setValueId(Integer.valueOf(-1));
      return valuelist;
   }
   
	public ValueList getFirstValueList (ValueList valuelist) {
		if (isAllNull(valuelist))
			return null;
		else {
			List<ValueList> list = searchPrototype (valuelist, 1);
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
    * checks if the ValueList entity exists
    */           
    public boolean existsValueList (ValueList valuelist) {
       if (getFirstValueList(valuelist)!=null)
          return true;
       return false;  
    }
        
    public boolean existsValueListWhereConditionsAre (ValueList valuelist) {
       if (getFirstResultWhereConditionsAre (valuelist).isEmpty())
          return false;
       return true;  
    }

	private int countPartialField (ValueList valuelist) {
	   int cpt = 0;
       if (valuelist.getValueId() != null) {
          cpt++;
       }
       if (valuelist.getName() != null) {
          cpt++;
       }
       if (valuelist.getGroup() != null) {
          cpt++;
       }
       return cpt;
	}   

	public List<ValueList> partialLoadWithParentValueList(ValueList what, ValueList positiveValueList, ValueList negativeValueList, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		Map beanPath = new Hashtable();
		List list = partialLoadWithParentValueListJPAQueryResult (what, positiveValueList, negativeValueList, queryWhatInit, beanPath, nbOfResult, useCache);
		return handlePartialLoadWithParentResult(what, list, beanPath);
	}
	
	public List<ValueList> handlePartialLoadWithParentResult(ValueList what, List list, Map beanPath) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentValueListWithOneElementInRow(list, beanPath, what, true);
		}
		return handlePartialLoadWithParentValueList(list, beanPath, what, true);
	}	

	private List partialLoadWithParentValueListQueryResult(ValueList valuelistWhat, ValueList positiveValueList, ValueList negativeValueList, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		return partialLoadWithParentValueListJPAQueryResult (valuelistWhat, positiveValueList, negativeValueList, queryWhatInit, new Hashtable(), nbOfResult, useCache);
    }	
  
	private List partialLoadWithParentValueListJPAQueryResult(ValueList valuelistWhat, ValueList positiveValueList, ValueList negativeValueList, QueryWhatInit queryWhatInit, Map beanPath, Integer nbOfResult, Boolean useCache) {
		Query hquery = getPartialLoadWithParentJPAQuery (valuelistWhat, positiveValueList, negativeValueList, beanPath, queryWhatInit, nbOfResult);
		return hquery.getResultList();
    }	
   /**
    * @returns an JPA Hsql query based on entity ValueList and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPAQuery (ValueList valuelistWhat, ValueList positiveValueList, ValueList negativeValueList, Map beanPath, QueryWhatInit queryWhatInit, Integer nbOfResult) {
	   Query query = getPartialLoadWithParentJPARawQuery (valuelistWhat, positiveValueList, negativeValueList, beanPath, queryWhatInit);
	   if (nbOfResult!=null)
	      query.setMaxResults(nbOfResult);
	   return query;
    }
  	
   /**
    * @returns an JPA Raw Hsql query based on entity ValueList and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPARawQuery (ValueList valuelistWhat, ValueList positiveValueList, ValueList negativeValueList, Map beanPath, QueryWhatInit queryWhatInit) {
	   return getEntityManager().createQuery(getPartialLoadWithParentRawHsqlQuery (valuelistWhat, positiveValueList, negativeValueList, beanPath, queryWhatInit));
    }
	
	private List<ValueList> handlePartialLoadWithParentValueList(List<Object[]> list, Map<Integer, String> beanPath, ValueList valuelistWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentValueList(list, beanPath, valuelistWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentValueList, message:"+ex.getMessage());
			return new ArrayList<ValueList>();
		}
    }

	private List<ValueList> handlePartialLoadWithParentValueListWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, ValueList valuelistWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentValueListWithOneElementInRow(list, beanPath, valuelistWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentValueListWithOneElementInRow, message:"+ex.getMessage());
			return new ArrayList<ValueList>();
		}
    }
    	
	 private List<ValueList> convertPartialLoadWithParentValueList(List<Object[]> list, Map<Integer, String> beanPath, ValueList valuelistWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<ValueList> resultList = new ArrayList<ValueList>();
		 for (Object[] row : list) {		
		    ValueList valuelist = cloneValueList (valuelistWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populateValueList (valuelist, row[(Integer)entry.getKey()], (String)entry.getValue());
		    }
		    resultList.add(valuelist);
		 }
		 return resultList;		
	 }	
    
	 private List<ValueList> convertPartialLoadWithParentValueListWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, ValueList valuelistWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<ValueList> resultList = new ArrayList<ValueList>();
		 for (Object row : list) {		
		    ValueList valuelist = cloneValueList (valuelistWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populateValueList (valuelist, row, (String)entry.getValue());
		    }
		    resultList.add(valuelist);
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
	public String getPartialLoadWithParentRawHsqlQuery (ValueList valuelist, ValueList positiveValueList, ValueList negativeValueList, Map beanPath, QueryWhatInit queryWhatInit) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentValueListQuery (valuelist, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
		Hashtable aliasWhereHt = new Hashtable();
		String where = getPartialLoadWithParentWhereQuery (positiveValueList, null, aliasWhatHt, aliasWhereHt, null, null);
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
	public String findPartialLoadWithParentRawHsqlQuery (ValueList whatMask, ValueList criteriaMask, Map beanPath, QueryWhatInit queryWhatInit,  ValueList orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentValueListQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
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
	public String countPartialLoadWithParentRawHsqlQuery (ValueList whatMask, ValueList criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
		Map beanPath = new Hashtable();
		Hashtable aliasWhatHt = new Hashtable();
		// used to initiate the how part of the what
		getPartialLoadWithParentValueListQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", new QuerySelectInit());
		String what = "select count(valuelist) ";
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
    	
	public String findPartialQuery (ValueList whatMask, ValueList criteriaMask, ValueList orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Map beanPath) {
        QueryWhatInit queryWhatInit = new QuerySelectInit();
        return findPartialLoadWithParentRawHsqlQuery(whatMask, criteriaMask, beanPath, queryWhatInit, orderMask, matchType, operandType, caseSensitivenessType,  sortOrder);
    }
	
	/**
    * partial on a single entity load enables to specify the fields you want to load explicitly
    */         
	public List<ValueList> partialLoadValueList(ValueList valuelist, ValueList positiveValueList, ValueList negativeValueList) {
	    Query hquery = getEntityManager().createQuery(getPartialLoadValueListQuery (valuelist, positiveValueList, negativeValueList));
		int countPartialField = countPartialField(valuelist);
		if (countPartialField==0) 
			return new ArrayList<ValueList>();
		List list = hquery.getResultList();
		Iterator iter = list.iterator();
		List<ValueList> returnList = new ArrayList<ValueList>();
		while(iter.hasNext()) {
			int index = 0;
			Object[] row;
			if (countPartialField==1) {
				row = new Object[1];
				row[0] = iter.next();
				} 
			else 
				row = (Object[]) iter.next();
			ValueList valuelistResult = new ValueList();
			if (valuelist.getValueId() != null) {
                valuelistResult.setValueId((Integer) row[index]);
				index++;
			}
			if (valuelist.getName() != null) {
                valuelistResult.setName((String) row[index]);
				index++;
			}
			if (valuelist.getGroup() != null) {
                valuelistResult.setGroup((String) row[index]);
				index++;
			}
			returnList.add(valuelistResult);
        }
	    return returnList;
	}

	public static String getPartialLoadWithParentWhereQuery (
	   ValueList criteriaMask, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias,
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
	   ValueList valuelist, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias) {
	   if (valuelist==null)
	      return "";
	   String alias = null;
	   if (aliasWhereHt == null) {
	      aliasWhereHt = new Hashtable();
	   } 
	   if (isLookedUp(valuelist)){
	      alias = getNextAlias (aliasWhereHt, valuelist);
		  aliasWhereHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (valuelist.getValueId() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".valueId = "+ valuelist.getValueId() + " ");
       }
       if (valuelist.getName() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".name = '"+ valuelist.getName()+"' ");
       }
       if (valuelist.getGroup() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".group = '"+ valuelist.getGroup()+"' ");
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
	
    public static String getPartialLoadWithParentValueListQuery (
	   ValueList valuelist, Boolean isWhereSet, Hashtable aliasHt, String childAlias, String childFKAlias, Map beanPath, String rootPath, QueryWhatInit queryWhatInit) {
	   if (valuelist==null)
	      return "";
	   String alias = null;
	   if (aliasHt == null) {
	      aliasHt = new Hashtable();
	   } 
	   if (isLookedUp(valuelist)){
	      alias = getNextAlias (aliasHt, valuelist);
		  aliasHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (valuelist.getValueId() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"valueId");
          query.append(" "+alias+".valueId ");
       }
       if (valuelist.getName() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"name");
          query.append(" "+alias+".name ");
       }
       if (valuelist.getGroup() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"group");
          query.append(" "+alias+".group ");
       }
//       query.append(getValueListSearchEqualQuery (positiveValueList, negativeValueList));
	   return query.toString(); 
    }
	
	protected static String getAliasConnection(String existingAlias, String childAlias, String childFKAlias) {
		if (childAlias==null)
		   return "";
		return childAlias+"."+childFKAlias+" = "+existingAlias+"."+"valueId";
	}
	
	protected static String getAliasKey (String alias) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return "ValueList|"+alias;
	}
	
	protected static String getAliasKeyAlias (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return StringUtils.substringAfter(aliasKey, "|");
	}
	
	protected static String getAliasKeyDomain (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
	  return StringUtils.substringBefore(aliasKey, "|");
	}
	
	protected static String getNextAlias (Hashtable aliasHt, ValueList valuelist) {
		int cptSameAlias = 0;
		Enumeration<String> _keys = aliasHt.keys();
		while (_keys.hasMoreElements()) {
			String _key = _keys.nextElement();
			if (_key.startsWith("valuelist"))
				cptSameAlias++;
		}
		if (cptSameAlias==0)
			return "valuelist";
		else
			return "valuelist_"+cptSameAlias;
	}
	
	
	protected static boolean isLookedUp (ValueList valuelist) {
	   if (valuelist==null)
		  return false;
       if (valuelist.getValueId() != null) {
	      return true;
       }
       if (valuelist.getName() != null) {
	      return true;
       }
       if (valuelist.getGroup() != null) {
	      return true;
       }
       return false;   
	}
	
    public String getPartialLoadValueListQuery(
	   ValueList valuelist, 
	   ValueList positiveValueList, 
	   ValueList negativeValueList) {
       boolean isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (valuelist.getValueId() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" valueId ");
       }
       if (valuelist.getName() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" name ");
       }
       if (valuelist.getGroup() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" group ");
       }
	   query.append(getFromEntity());
       query.append(getValueListPositiveNegativeCriteria (positiveValueList, negativeValueList));
	   return query.toString(); 
    }
	
	public List<ValueList> searchPrototypeWithCacheValueList(ValueList valuelist) {
		SimpleCache simpleCache = new SimpleCache();
		List<ValueList> list = (List<ValueList>)simpleCache.get(valuelist.toString());
		if (list==null) {
			list = searchPrototypeValueList(valuelist);
			simpleCache.put(valuelist.toString(), list);
		}
		return list;
	}

    public List<ValueList> loadGraph(ValueList graphMaskWhat, List<ValueList> whereMask) {
        return loadGraphOneLevel(graphMaskWhat, whereMask);
    }

	public List<ValueList> loadGraphOneLevel(ValueList graphMaskWhat, List<ValueList> whereMask) {
		//first get roots element from where list mask
		// this brings the level 0 of the graph (root level)
 		graphMaskWhat.setValueId(graphMaskWhat.integerMask__);
		List<ValueList> valuelists = searchPrototypeValueList (whereMask);
		// for each sub level perform the search with a subquery then reassemble
		// 1. get all sublevel queries
		// 2. perform queries on the correct dao
		// 3. reassemble
		return getLoadGraphOneLevel (graphMaskWhat, valuelists);
	}

	private List<ValueList> copy(List<ValueList> inputs) {
		List<ValueList> l = new ArrayList<ValueList>();
		for (ValueList input : inputs) {
			ValueList copy = new ValueList();
			copy.copy(input);
			l.add(copy);
		}
		return l;
	}
	   
	private List<ValueList> getLoadGraphOneLevel (ValueList graphMaskWhat, List<ValueList> parents) {
	    return loadGraphFromParentKey (graphMaskWhat, parents);
	} 
	
	public List<ValueList> loadGraphFromParentKey (ValueList graphMaskWhat, List<ValueList> parents) {
		//foreach children:
		//check if not empty take first
		parents = copy (parents); //working with detached entities to avoid unnecessary sql calls
		if (parents==null || parents.isEmpty())
		   return parents;
		List<String> ids = getPk (parents);
		if (graphMaskWhat.getAccessorieValueListViaColor()!=null && !graphMaskWhat.getAccessorieValueListViaColor().isEmpty()) {
			for (Accessorie childWhat : graphMaskWhat.getAccessorieValueListViaColor()) {
				childWhat.setColor_(graphMaskWhat.integerMask__); // add to the what mask, usefull for reconciliation
				AccessorieJPAImpl accessorieextendedjpaimpl = new AccessorieJPAImpl ();
				List<Accessorie> children = accessorieextendedjpaimpl.lookupAccessorie(childWhat, getFkCriteria(" valueId ", ids), null, getEntityManager());
				reassembleAccessorie (children, parents);				
				break;
			}
		}
		if (graphMaskWhat.getHardwareValueListViaColor()!=null && !graphMaskWhat.getHardwareValueListViaColor().isEmpty()) {
			for (Hardware childWhat : graphMaskWhat.getHardwareValueListViaColor()) {
				childWhat.setColor_(graphMaskWhat.integerMask__); // add to the what mask, usefull for reconciliation
				HardwareJPAImpl hardwareextendedjpaimpl = new HardwareJPAImpl ();
				List<Hardware> children = hardwareextendedjpaimpl.lookupHardware(childWhat, getFkCriteria(" valueId ", ids), null, getEntityManager());
				reassembleHardware (children, parents);				
				break;
			}
		}
		if (graphMaskWhat.getSoftwareValueListViaConsole()!=null && !graphMaskWhat.getSoftwareValueListViaConsole().isEmpty()) {
			for (Software childWhat : graphMaskWhat.getSoftwareValueListViaConsole()) {
				childWhat.setConsole_(graphMaskWhat.integerMask__); // add to the what mask, usefull for reconciliation
				SoftwareJPAImpl softwareextendedjpaimpl = new SoftwareJPAImpl ();
				List<Software> children = softwareextendedjpaimpl.lookupSoftware(childWhat, getFkCriteria(" valueId ", ids), null, getEntityManager());
				reassembleSoftware (children, parents);				
				break;
			}
		}
		return parents;
	}
	
	private void reassembleAccessorie (List<Accessorie> children, List<ValueList> parents) {
		for (Accessorie child : children) {
			for (ValueList parent : parents) {
				if (parent.getValueId()!=null && parent.getValueId().toString().equals(child.getColor()+"")) {
					parent.addAccessorieValueListViaColor(child); 
					child.setColor(parent);
					break;
				}
			}
		}
	}
	
	private void reassembleHardware (List<Hardware> children, List<ValueList> parents) {
		for (Hardware child : children) {
			for (ValueList parent : parents) {
				if (parent.getValueId()!=null && parent.getValueId().toString().equals(child.getColor()+"")) {
					parent.addHardwareValueListViaColor(child); 
					child.setColor(parent);
					break;
				}
			}
		}
	}
	
	private void reassembleSoftware (List<Software> children, List<ValueList> parents) {
		for (Software child : children) {
			for (ValueList parent : parents) {
				if (parent.getValueId()!=null && parent.getValueId().toString().equals(child.getConsole()+"")) {
					parent.addSoftwareValueListViaConsole(child); 
					child.setConsole(parent);
					break;
				}
			}
		}
	}
	
	private List<String> getPk(List<ValueList> input) {
		List<String> s = new ArrayList<String>();
		for (ValueList t : input) {
			s.add(t.getValueId()+"");
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
	public void find (QueryData<ValueList> data) {
		EntityCriteria<ValueList> filter = data.getEntityCriteria();
		ValueList entityWhat = data.getEntityWhat();
		ValueList criteriaMask = filter.getEntity();
		int start = data.getStart();
		int max = data.getMax();
		EntitySort<ValueList> entitySort = data.getEntitySort();
		QuerySortOrder sortOrder = entitySort.getOrder();
		ValueList sortMask = entitySort.getEntity();	

		List<ValueList> results = find(entityWhat, criteriaMask, sortMask, filter.getMatchType(), filter.getOperandType(), filter.getCaseSensitivenessType(), sortOrder, start, max);
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
     * return a list of ValueList entities 
     */
    public List<ValueList> getList () {
        //first lightweight implementation
        return searchPrototypeValueList(new ValueList());
    }
    /**
     * return a list of ValueList entities and sort
     */
    public List<ValueList> getList (ValueList orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(new ValueList(), orderMask, sortOrder, null);
    }
    /**
     * return a list of ValueList entities and sort based on a ValueList prototype
     */
    public List<ValueList> list (ValueList mask, ValueList orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(mask, orderMask, sortOrder, null);
    }

	@Override
    protected String getSelectFrom() {
        return "SELECT valuelist "+getFromEntity();
    }

    protected String getFromEntity() {
        return " FROM ValueList valuelist ";
    }

    @Override
    protected String getQuerySelectFromEntity() {
        return getSelectFrom();
    }
	



}
