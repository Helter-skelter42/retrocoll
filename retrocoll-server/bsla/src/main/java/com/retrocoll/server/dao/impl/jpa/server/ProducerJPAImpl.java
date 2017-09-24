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

import com.retrocoll.server.dao.face.server.ProducerDao;
import com.retrocoll.server.domain.server.Producer;

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
 * <p>Title: ProducerJPAImpl</p>
 *
 * <p>Description: Interface of a Data access object dealing with ProducerJPAImpl
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching ProducerJPAImpl objects</p>
 *
 */


@org.springframework.stereotype.Repository(value="producerDao")

public class ProducerJPAImpl extends ServerGenericDaoJpaImpl<Producer> implements ProducerDao {
	public ProducerJPAImpl () {}
	
    /**
     * Inserts a Producer entity 
     * @param Producer producer
     */
    public void insertProducer(Producer producer) {
       entityManager.persist(producer);
    }

    protected void insertProducer(EntityManager emForRecursiveDao, Producer producer) {
       emForRecursiveDao.persist(producer);
    } 

    /**
     * Updates a Producer entity 
     * @param Producer producer
     */
    public Producer updateProducer(Producer producer) {
       return entityManager.merge(producer);
    }

	/**
     * Updates a Producer entity with only the attributes set into Producer.
	 * The primary keys are to be set for this method to operate.
	 * This is a performance friendly feature, which remove the udibiquous full load and full update when an
	 * update is issued
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param Producer producer
    */ 
    @Transactional
    public Integer updateNotNullOnlyProducer(Producer producer) {
        Query jpaQuery = getEntityManager().createQuery(getUpdateNotNullOnlyProducerQueryChunk(producer));
        if (producer.getProducerId() != null) {
           jpaQuery.setParameter ("producerId", producer.getProducerId());
        }   
        if (producer.getName() != null) {
           jpaQuery.setParameter ("name", producer.getName());
        }   
        if (producer.getDesciption() != null) {
           jpaQuery.setParameter ("desciption", producer.getDesciption());
        }   
        if (producer.getLogo() != null) {
           jpaQuery.setParameter ("logo", producer.getLogo());
        }   
		return jpaQuery.executeUpdate();
    }

    protected String getUpdateNotNullOnlyProducerQueryChunkPrototype (Producer producer) {
        boolean isSetSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update Producer producer ");
        if (producer.getName() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" producer.name = :name");
        }
        if (producer.getDesciption() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" producer.desciption = :desciption");
        }
        if (producer.getLogo() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" producer.logo = :logo");
        }
        if (isSetSet==false)
			throw new IllegalArgumentException("producer mask should contain updatable fields");
        return query.toString();
    }
    
    protected String getUpdateNotNullOnlyProducerQueryChunk (Producer producer) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer(getUpdateNotNullOnlyProducerQueryChunkPrototype(producer));
        if (producer.getProducerId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
			     query.append(" producer.producerId = :producerId");
        }
        if (isWhereSet==false)
			throw new IllegalArgumentException("producer mask should contain primary key");
        return query.toString();
    }
    
                
	protected Producer assignBlankToNull (Producer producer) {
        if (producer==null)
			return null;
        if (producer.getName()!=null && producer.getName().equals(""))
           producer.setName((String)null);
        if (producer.getDesciption()!=null && producer.getDesciption().equals(""))
           producer.setDesciption((String)null);
        if (producer.getLogo()!=null && producer.getLogo().equals(""))
           producer.setLogo((String)null);
		return producer;
	}
	
	protected boolean isAllNull (Producer producer) {
	    if (producer==null)
			return true;
        if (producer.getProducerId()!=null) 
            return false;
        if (producer.getName()!=null) 
            return false;
        if (producer.getDesciption()!=null) 
            return false;
        if (producer.getLogo()!=null) 
            return false;
		return true;
	}
		
    @Transactional
    public Integer updateNotNullOnlyPrototypeProducer(Producer producer, Producer prototypeCriteria) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update Producer producer ");
        if (producer.getProducerId() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" producer.producerId = "+ producer.getProducerId() + " ");
        }
        if (producer.getName() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" producer.name = '"+ producer.getName()+"' ");
        }
        if (producer.getDesciption() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" producer.desciption = '"+ producer.getDesciption()+"' ");
        }
        if (producer.getLogo() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" producer.logo = '"+ producer.getLogo()+"' ");
        }
		isWhereSet = false; 
        if (prototypeCriteria.getProducerId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" producer.producerId = "+ prototypeCriteria.getProducerId() + " ");
        }
        if (prototypeCriteria.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" producer.name = '"+ prototypeCriteria.getName()+"' ");
        }
        if (prototypeCriteria.getDesciption() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" producer.desciption = '"+ prototypeCriteria.getDesciption()+"' ");
        }
        if (prototypeCriteria.getLogo() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" producer.logo = '"+ prototypeCriteria.getLogo()+"' ");
        }
        Query jpaQuery = getEntityManager().createQuery(query.toString());
		return jpaQuery.executeUpdate();
    }
     
     /**
     * Saves a Producer entity 
     * @param Producer producer
     */
    public void saveProducer(Producer producer) {
       //entityManager.persist(producer);
       if (entityManager.contains(producer)) {
          entityManager.merge(producer);
       } else {
          entityManager.persist(producer);
       }
       entityManager.flush(); 
    }
       
    /**
     * Deletes a Producer entity 
     * @param Producer producer
     */
    public void deleteProducer(Producer producer) {
      entityManager.remove(producer);
    }
    
    /**
     * Loads the Producer entity which is related to an instance of
     * Producer
     * @param Long id
     * @return Producer The Producer entity
     
    public Producer loadProducer(Long id) {
    	return (Producer)entityManager.get(Producer.class, id);
    }
*/
  
    /**
     * Loads the Producer entity which is related to an instance of
     * Producer
     * @param java.lang.Integer ProducerId
     * @return Producer The Producer entity
     */
    public Producer loadProducer(java.lang.Integer producerId) {
    	return (Producer)entityManager.find(Producer.class, producerId);
    }
    
    /**
     * Loads the Producer entity which is related to an instance of
     * Producer and its dependent one to many objects
     * @param Long id
     * @return Producer The Producer entity
     */
    public Producer loadFullFirstLevelProducer(java.lang.Integer producerId) {
        List list = getResultList(
                     "SELECT producer FROM Producer producer "
                     + " LEFT JOIN producer.accessorieProducerViaBrand "   
                     + " LEFT JOIN producer.hardwareProducerViaBrand "   
                     + " LEFT JOIN producer.softwareProducerViaEditor "   
                     + " LEFT JOIN producer.softwareProducerViaDevelopper "   
                     + " WHERE producer.producerId = "+producerId
               );
         if (list!=null && !list.isEmpty())
            return (Producer)list.get(0);
         return null;
    	//return null;//(Producer) entityManager.queryForObject("loadFullFirstLevelProducer", id);
    }

    /**
     * Loads the Producer entity which is related to an instance of
     * Producer
     * @param Producer producer
     * @return Producer The Producer entity
     */
    public Producer loadFullFirstLevelProducer(Producer producer) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT producer FROM Producer producer ");
        query.append (" LEFT JOIN producer.accessorieProducerViaBrand ");
        query.append (" LEFT JOIN producer.hardwareProducerViaBrand ");
        query.append (" LEFT JOIN producer.softwareProducerViaEditor ");
        query.append (" LEFT JOIN producer.softwareProducerViaDevelopper ");
        if (producer.getProducerId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" producer.producerId = "+ producer.getProducerId() + " ");
         }
        List list = getResultList(query.toString());
        if (list!=null && !list.isEmpty())
           return (Producer)list.get(0);    
        return null;
    }  

    /**
     * Searches a list of Producer entity 
     * @param Producer producer
     * @return List
     */  
    public List<Producer> searchPrototypeProducer(Producer producer) {
       return searchPrototype (producer, null);
    }  
	
    public List<Producer> searchPrototypeAnyProducer(Producer producer) {
       return searchPrototypeAny (producer, null);
    }  

	// indirection
    public List<Producer> find (Producer criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
       return find (criteriaMask, matchType, operandType, caseSensitivenessType, null, null); 
	}
	
	// indirection
	protected List<Producer> find (Producer criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, Integer startPosition, Integer maxResults) {
       return find (criteriaMask, null, matchType, operandType, caseSensitivenessType, null, startPosition, maxResults); 
    }
	
	// indirection
	protected List<Producer> find (Producer criteriaMask, Producer orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
       return find (null, criteriaMask, orderMask, matchType, operandType, caseSensitivenessType, sortOrder, startPosition, maxResults);
    }
	
	// main find implementation
	protected List<Producer> find (Producer whatMask, Producer criteriaMask, Producer orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
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
    public String findQuery (Producer criteriaMask, Producer orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String what = "SELECT producer FROM Producer producer ";
		return findQuery (criteriaMask, orderMask, what, matchType, operandType, caseSensitivenessType, sortOrder);
    }

    protected String findQuery (Producer criteriaMask, Producer orderMask, String what, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String queryWhere = findWhere (criteriaMask, false, isAll(matchType), operandType, caseSensitivenessType);
		String queryOrder = findOrder (orderMask, sortOrder);
	    return getHQuery(what, queryWhere, queryOrder);
    }
	
    protected List<Producer> searchPrototype (Producer producer, Producer orderMask, QuerySortOrder sortOrder, Integer maxResults) {
       return searchPrototype(getProducerSelectQuery (getWhereEqualWhereQueryChunk(producer), orderMask, sortOrder), maxResults);
    }

    protected List<Producer> searchPrototype (Producer producer, Integer maxResults) {
       return searchPrototype(producer, null, null, maxResults);
    }
    
    protected List<Producer> searchPrototypeAny (Producer producer, Integer maxResults) { 
       return searchPrototype(getSearchEqualAnyQuery (producer), maxResults);
    }
    
    protected List<Producer> searchPrototype (String query, Integer maxResults) { 
       Query hquery = getEntityManager().createQuery(query);
       if (maxResults!=null)
          hquery.setMaxResults(maxResults);
       return hquery.getResultList();
    }

    public List<Producer> searchPrototypeProducer (List<Producer> producers) {
       return searchPrototype (producers, null);
    }

    protected List<Producer> searchPrototype (List<Producer> producers, Integer maxResults) {    
	   return getResultList(getProducerSearchEqualQuery (null, producers));
	}    

    protected List<Producer> getResultList (String query) {    
	   Query hquery = entityManager.createQuery(query);            
	   return hquery.getResultList();
	}    
 

    public List<Producer> searchDistinctPrototypeProducer (Producer producerMask, List<Producer> producers) {
        return getResultList(getProducerSearchEqualQuery (producerMask, producers));    
    }
        
	/**
     * Searches a list of Producer entity 
     * @param Producer positiveMask
     * @param Producer negativeMask
     * @return List
     */
    public List<Producer> searchPrototypeProducer(Producer positiveMask, Producer negativeMask) {
	    return getResultList(getProducerSearchEqualQuery (positiveMask, negativeMask));  
    }

    /**
    * return a string query search on a Producer prototype
    */
    protected String getProducerSelectQuery (String where, Producer orderMask, QuerySortOrder sortOrder) {
       return getProducerSelectQuery (where, findOrder (orderMask, sortOrder));
    }
    protected String getProducerSelectQuery (String where, String order) {
       StringBuffer query = new StringBuffer();
       query.append ("SELECT producer FROM Producer producer ");
       return (order!=null)? getHQuery(query.toString(), where, order):getHQuery(query.toString(), where);
    }
    /**
    * return a jql query search on a Producer prototype
    */
    protected String getSearchEqualQuery (Producer producer) {
       return getProducerSelectQuery (getWhereEqualWhereQueryChunk(producer),null);
    }
    protected String getWhereEqualWhereQueryChunk (Producer producer) {
       return getWhereEqualWhereQueryChunk(producer, false);
    }
    /**
    * return a jql query search on a Producer with any prototype
    */
    protected String getSearchEqualAnyQuery (Producer producer) {
       return getProducerSelectQuery (getWhereEqualAnyWhereQueryChunk(producer), null);   
    }
    protected String getWhereEqualAnyWhereQueryChunk (Producer producer) {
       return getWhereEqualAnyWhereQueryChunk(producer, false);   
    }

    /**
    * return a jql search for a list of Producer prototype
    */
    protected String getProducerSearchEqualQuery (Producer producerMask, List<Producer> producers) {
        boolean isOrSet = false;
        StringBuffer query = new StringBuffer();
        if (producerMask !=null)
           query.append (getProducerMaskWhat (producerMask));
        query.append (" FROM Producer producer ");
        StringBuffer queryWhere = new StringBuffer();
        for (Producer producer : producers) {
           if (!isAllNull(producer)) {        
	           queryWhere.append (getQueryOR (isOrSet));
	           isOrSet = true;
	           queryWhere.append (" ("+getWhereEqualWhereQueryChunk(producer, false)+") ");
           }
        }
	    return getHQuery(query.toString(), queryWhere.toString());
    }	

    
    protected String getProducerMaskWhat (Producer producerMask) {
        boolean isCommaSet = false;
        StringBuffer query = new StringBuffer("SELECT DISTINCT ");
        if (producerMask.getProducerId() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" producerId ");
        }
        if (producerMask.getName() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" name ");
        }
        if (producerMask.getDesciption() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" desciption ");
        }
        if (producerMask.getLogo() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" logo ");
        }
        if (!isCommaSet)
           return "";
	    return query.toString();
    }
    
    protected String getWhereEqualAnyWhereQueryChunk (Producer producer, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (producer, isAndSet, false);	
	}
	
    protected String getWhereEqualWhereQueryChunk (Producer producer, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (producer, isAndSet, true);
	}
	
    protected String getSearchEqualWhereQueryChunk (Producer producer, boolean isAndSet, boolean isAll) {
        StringBuffer query = new StringBuffer();
        if (producer.getProducerId() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" producer.producerId = "+ producer.getProducerId() + " ");
        }
        if (producer.getName() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" producer.name = '"+ producer.getName()+"' ");
        }
        if (producer.getDesciption() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" producer.desciption = '"+ producer.getDesciption()+"' ");
        }
        if (producer.getLogo() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" producer.logo = '"+ producer.getLogo()+"' ");
        }
	    return query.toString();
    }

    protected String findOrder (Producer orderMask, QuerySortOrder sortOrder) {
        if (orderMask!=null) {
            String orderColumn = getFirstNotNullColumnOtherWiseNull(orderMask);
            if (orderColumn!=null)
               return orderColumn + " " + sortOrder;
        }
        return "";
    }

	@Override
    protected String findWhere (Producer producer, boolean isAndSet, boolean isAll, OperandType operandType, Boolean caseSensitive) {
		return findWhere (null, producer, isAndSet, isAll, operandType, caseSensitive);
	}
	
	protected static String findWhere (String alias, Producer producer, boolean isAndSet, boolean isAll, OperandType operandType, boolean caseSensitive) {
        if (alias==null)
			alias = "producer";
		StringBuffer query = new StringBuffer();
		String operand = getOperand (operandType);
		String evaluatorPrefix = getEvaluatorPrefix (operandType);		
		String evaluatorSuffix = getEvaluatorSuffix (operandType);		
        if (producer.getProducerId() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".producerId = "+ producer.getProducerId() + " ");
        }
        if (producer.getName() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = producer.getName();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".name) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".name "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (producer.getDesciption() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".desciption = '"+ producer.getDesciption()+"' ");
        }
        if (producer.getLogo() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".logo = '"+ producer.getLogo()+"' ");
        }
        return query.toString();
    }
	
	protected String getFirstNotNullColumnOtherWiseNull (Producer mask) {
        if (mask == null) return null;
        if (mask.getProducerId() != null) return "producerId";
        if (mask.getName() != null) return "name";
        if (mask.getDesciption() != null) return "desciption";
        if (mask.getLogo() != null) return "logo";
        return null;	
	}
    
    /**
    * return a jql search on a Producer prototype with positive and negative beans
    */
    protected String getProducerSearchEqualQuery (Producer positiveMask, Producer negativeMask) {
		StringBuffer query = new StringBuffer();    	
		query.append(getSelectFrom());
		query.append(getProducerPositiveNegativeCriteria(positiveMask, negativeMask));
		return query.toString();
	}

	protected String getProducerPositiveNegativeCriteria (Producer positiveMask, Producer negativeMask) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        if (positiveMask!=null && positiveMask.getProducerId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" producer.producerId = "+ positiveMask.getProducerId() + " ");
        } 
		if (negativeMask!=null && negativeMask.getProducerId() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" producer.producerId is null ");
        }
        if (positiveMask!=null && positiveMask.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" producer.name = '"+ positiveMask.getName()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" producer.name is null ");
        }
        if (positiveMask!=null && positiveMask.getDesciption() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" producer.desciption = '"+ positiveMask.getDesciption()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getDesciption() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" producer.desciption is null ");
        }
        if (positiveMask!=null && positiveMask.getLogo() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" producer.logo = '"+ positiveMask.getLogo()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getLogo() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" producer.logo is null ");
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
    public ProducerJPAImpl (EntityManager emForRecursiveDao) {
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
     * Inserts a Producer entity with cascade of its children
     * @param Producer producer
     */
    public void insertProducerWithCascade(Producer producer) {
    	ProducerJPAImpl producerjpaimpl = new ProducerJPAImpl(getEntityManager());
    	producerjpaimpl.insertProducerWithCascade(producerjpaimpl.getEntityManagerForRecursiveDao(), producer);
    }
     
    public void insertProducerWithCascade(EntityManager emForRecursiveDao, Producer producer) {
       insertProducer(emForRecursiveDao, producer);
       if (!producer.getAccessorieProducerViaBrand().isEmpty()) {
          AccessorieJPAImpl accessorieextendedjpaimpl = new AccessorieJPAImpl (emForRecursiveDao);
          for (Accessorie _accessorieProducerViaBrand : producer.getAccessorieProducerViaBrand()) {
             accessorieextendedjpaimpl.insertAccessorieWithCascade(emForRecursiveDao, _accessorieProducerViaBrand);
          }
       } 
       if (!producer.getHardwareProducerViaBrand().isEmpty()) {
          HardwareJPAImpl hardwareextendedjpaimpl = new HardwareJPAImpl (emForRecursiveDao);
          for (Hardware _hardwareProducerViaBrand : producer.getHardwareProducerViaBrand()) {
             hardwareextendedjpaimpl.insertHardwareWithCascade(emForRecursiveDao, _hardwareProducerViaBrand);
          }
       } 
       if (!producer.getSoftwareProducerViaEditor().isEmpty()) {
          SoftwareJPAImpl softwareextendedjpaimpl = new SoftwareJPAImpl (emForRecursiveDao);
          for (Software _softwareProducerViaEditor : producer.getSoftwareProducerViaEditor()) {
             softwareextendedjpaimpl.insertSoftwareWithCascade(emForRecursiveDao, _softwareProducerViaEditor);
          }
       } 
       if (!producer.getSoftwareProducerViaDevelopper().isEmpty()) {
          SoftwareJPAImpl softwareextendedjpaimpl = new SoftwareJPAImpl (emForRecursiveDao);
          for (Software _softwareProducerViaDevelopper : producer.getSoftwareProducerViaDevelopper()) {
             softwareextendedjpaimpl.insertSoftwareWithCascade(emForRecursiveDao, _softwareProducerViaDevelopper);
          }
       } 
    }
        
    /**
     * Inserts a list of Producer entity with cascade of its children
     * @param List<Producer> producers
     */
    public void insertProducersWithCascade(List<Producer> producers) {
       for (Producer producer : producers) {
          insertProducerWithCascade(producer);
       }
    } 
        
    /**
     * lookup Producer entity Producer, criteria and max result number
     */
    public List<Producer> lookupProducer(Producer producer, Criteria criteria, Integer numberOfResult, EntityManager em) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT producer FROM Producer producer ");
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
    
    public List<Producer> lookupProducer(Producer producer, Criteria criteria, Integer numberOfResult) {
		return lookupProducer(producer, criteria, numberOfResult, getEntityManager());
    }

    public Integer updateNotNullOnlyProducer (Producer producer, Criteria criteria) {
        String queryWhat = getUpdateNotNullOnlyProducerQueryChunkPrototype (producer);
        StringBuffer query = new StringBuffer (queryWhat);
        boolean isWhereSet = false;
        for (Criterion criterion : criteria.getClauseCriterions()) {
            query.append (getQueryWHERE_AND (isWhereSet));
            isWhereSet = true;   
            query.append(criterion.getExpression());			
        }  
        Query jpaQuery = getEntityManager().createQuery(query.toString());
        isWhereSet = false;
        if (producer.getProducerId() != null) {
           jpaQuery.setParameter ("producerId", producer.getProducerId());
        }   
        if (producer.getName() != null) {
           jpaQuery.setParameter ("name", producer.getName());
        }   
        if (producer.getDesciption() != null) {
           jpaQuery.setParameter ("desciption", producer.getDesciption());
        }   
        if (producer.getLogo() != null) {
           jpaQuery.setParameter ("logo", producer.getLogo());
        }   
		return jpaQuery.executeUpdate();
    }
	
	public Producer affectProducer (Producer producer) {
	    return referProducer (producer, null, false);		    
	}
		
	/**
	 * Assign the first producer retrieved corresponding to the producer criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no producer corresponding in the database. Then producer is inserted and returned with its primary key(s). 
	 */
	public Producer assignProducer (Producer producer) {
		return referProducer (producer, null, true);
	}

	/**
	 * Assign the first producer retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no producer corresponding in the database. 
	 * Then producer is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public Producer assignProducer (Producer producer, Producer mask) {
		return referProducer (producer, mask, true);
	}

	public Producer referProducer (Producer producer, Producer mask, boolean isAssign) {
		producer = assignBlankToNull (producer);
		if (isAllNull(producer))
			return null;
		else {
			List<Producer> list;
			if (mask==null)
				list = searchPrototypeProducer(producer);
			else
				list = searchPrototypeProducer(mask);
			if (list.isEmpty()) {
			    if (isAssign)
			       insertProducer(producer);
			    else
				   return null;
			}
			else if (list.size()==1)
				producer.copy(list.get(0));
			else 
				//TODO log error
				producer.copy(list.get(0));
		}
		return producer;		    
	}

   public Producer assignProducerUseCache (Producer producer) {
      return referProducerUseCache (producer, true);
   }
      		
   public Producer affectProducerUseCache (Producer producer) {
      return referProducerUseCache (producer, false);
   }
      		
   public Producer referProducerUseCache (Producer producer, boolean isAssign) {
	  String key = getCacheKey(null, producer, null, "assignProducer");
      Producer producerCache = (Producer)simpleCache.get(key);
      if (producerCache==null) {
         producerCache = referProducer (producer, null, isAssign);
         if (key!=null)
         	simpleCache.put(key, producerCache);
      }
      producer.copy(producerCache);
      return producerCache;
   }	

	private String getCacheKey (Producer producerWhat, Producer positiveProducer, Producer negativeProducer, String queryKey) {
	    StringBuffer sb = new StringBuffer();
	    sb.append(queryKey);
	    if (producerWhat!=null)
	       sb.append(producerWhat.toStringWithParents());
	    if (positiveProducer!=null)
	       sb.append(positiveProducer.toStringWithParents());
	    if (negativeProducer!=null)
	       sb.append(negativeProducer.toStringWithParents());
	    return sb.toString();
	}
	
    public Producer partialLoadWithParentFirstProducer(Producer producerWhat, Producer positiveProducer, Producer negativeProducer){
		List <Producer> list = partialLoadWithParentProducer(producerWhat, positiveProducer, negativeProducer);
		return (!list.isEmpty())?(Producer)list.get(0):null;
    }
    
    public Producer partialLoadWithParentFirstProducerUseCache(Producer producerWhat, Producer positiveProducer, Producer negativeProducer, Boolean useCache){
		List <Producer> list = partialLoadWithParentProducerUseCache(producerWhat, positiveProducer, negativeProducer, useCache);
		return (!list.isEmpty())?(Producer)list.get(0):null;
    }
	
	public Producer partialLoadWithParentFirstProducerUseCacheOnResult(Producer producerWhat, Producer positiveProducer, Producer negativeProducer, Boolean useCache){
		List <Producer> list = partialLoadWithParentProducerUseCacheOnResult(producerWhat, positiveProducer, negativeProducer, useCache);
		return (!list.isEmpty())?(Producer)list.get(0):null;
    }
	//
	protected List<Producer> partialLoadWithParentProducer(Producer producerWhat, Producer positiveProducer, Producer negativeProducer, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentProducer(producerWhat, positiveProducer, negativeProducer, new QuerySelectInit(), nbOfResult, useCache);
	}	  

	protected List partialLoadWithParentProducerQueryResult (Producer producerWhat, Producer positiveProducer, Producer negativeProducer, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentProducerQueryResult (producerWhat, positiveProducer, negativeProducer, new QuerySelectInit(), nbOfResult, useCache);
	}	
    
    public List<Producer> getDistinctProducer(Producer producerWhat, Producer positiveProducer, Producer negativeProducer) {
		 return partialLoadWithParentProducer(producerWhat, positiveProducer, negativeProducer, new QuerySelectDistinctInit(), null, false);
	}
	
	public List<Producer> partialLoadWithParentProducer(Producer producerWhat, Producer positiveProducer, Producer negativeProducer) {
		 return partialLoadWithParentProducer(producerWhat, positiveProducer, negativeProducer, new QuerySelectInit(), null, false);
	}	
  
	public List<Producer> partialLoadWithParentProducerUseCacheOnResult(Producer producerWhat, Producer positiveProducer, Producer negativeProducer, Boolean useCache) {
		String key = getCacheKey(producerWhat, positiveProducer, negativeProducer, "partialLoadWithParentProducer");
		List<Producer> list = (List<Producer>)simpleCache.get(key);
		if (list==null || list.isEmpty()) {
			list = partialLoadWithParentProducer(producerWhat, positiveProducer, negativeProducer);
			if (!list.isEmpty())
			   simpleCache.put(key, list);
		}
		return list;	
	}	

	public List<Producer> partialLoadWithParentProducerUseCache(Producer producerWhat, Producer positiveProducer, Producer negativeProducer, Boolean useCache) {
		String key = getCacheKey(producerWhat, positiveProducer, negativeProducer, "partialLoadWithParentProducer");
		List<Producer> list = (List<Producer>)simpleCache.get(key);
		if (list==null) {
			list = partialLoadWithParentProducer(producerWhat, positiveProducer, negativeProducer);
			simpleCache.put(key, list);
		}
		return list;	
	}	
	
	private List<Producer> handleLoadWithParentProducer(Map beanPath, List list, Producer producerWhat) {
	    return handleLoadWithParentProducer(beanPath, list, producerWhat, true);  
	}
	
	private List<Producer> handleLoadWithParentProducer(Map beanPath, List list, Producer producerWhat, boolean isHql) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentProducerWithOneElementInRow(list, beanPath, producerWhat, isHql);
		}
		return handlePartialLoadWithParentProducer(list, beanPath, producerWhat, isHql);	
	}
	
    	// to set in super class	
	protected void populateProducer (Producer producer, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(producer, beanPath, value);
	}
	
	protected void populateProducerFromSQL (Producer producer, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(producer, beanPath, value);
	}
    	// to set in super class BEWARE: genericity is only one level!!!!! first level is a copy second level is a reference!!! change to producer.clone() instead
	private Producer cloneProducer (Producer producer) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		//return (Producer) BeanUtils.cloneBeanObject(producer);
	   if (producer==null) return new Producer();
	   return producer.clone();
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
	
    public List<Producer> countDistinct (Producer whatMask, Producer whereEqCriteria) {
       return partialLoadWithParentProducer(whatMask, whereEqCriteria, null, new QuerySelectCountInit("producer"), null, false);
    }   
  	
    public Long count(Producer whereEqCriteria) {
	    return count(null, whereEqCriteria, EntityMatchType.ALL, OperandType.EQUALS, true); 
/*        Query query = getEntityManager().createQuery(getSelectCountPrototype(whereEqCriteria));
        List<Long> list = query.getResultList();
    	if (!list.isEmpty()) {
            return list.get(0);
    	}
    	return 0L;
*/
    }


    public Long count(Producer whatMask, Producer whereCriteria, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
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

	protected String countQuery (Producer producer, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
        String what = "SELECT count(*) FROM Producer producer ";
		return findQuery (producer, null, what, matchType, operandType, caseSensitivenessType, null);
    }
	

   private List getFirstResultWhereConditionsAre (Producer producer) {
      return partialLoadWithParentProducerQueryResult(getDefaultProducerWhat(), producer, null, 1, false);	
   }
   
   protected Producer getDefaultProducerWhat() {
      Producer producer = new Producer();
      producer.setProducerId(Integer.valueOf(-1));
      return producer;
   }
   
	public Producer getFirstProducer (Producer producer) {
		if (isAllNull(producer))
			return null;
		else {
			List<Producer> list = searchPrototype (producer, 1);
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
    * checks if the Producer entity exists
    */           
    public boolean existsProducer (Producer producer) {
       if (getFirstProducer(producer)!=null)
          return true;
       return false;  
    }
        
    public boolean existsProducerWhereConditionsAre (Producer producer) {
       if (getFirstResultWhereConditionsAre (producer).isEmpty())
          return false;
       return true;  
    }

	private int countPartialField (Producer producer) {
	   int cpt = 0;
       if (producer.getProducerId() != null) {
          cpt++;
       }
       if (producer.getName() != null) {
          cpt++;
       }
       if (producer.getDesciption() != null) {
          cpt++;
       }
       if (producer.getLogo() != null) {
          cpt++;
       }
       return cpt;
	}   

	public List<Producer> partialLoadWithParentProducer(Producer what, Producer positiveProducer, Producer negativeProducer, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		Map beanPath = new Hashtable();
		List list = partialLoadWithParentProducerJPAQueryResult (what, positiveProducer, negativeProducer, queryWhatInit, beanPath, nbOfResult, useCache);
		return handlePartialLoadWithParentResult(what, list, beanPath);
	}
	
	public List<Producer> handlePartialLoadWithParentResult(Producer what, List list, Map beanPath) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentProducerWithOneElementInRow(list, beanPath, what, true);
		}
		return handlePartialLoadWithParentProducer(list, beanPath, what, true);
	}	

	private List partialLoadWithParentProducerQueryResult(Producer producerWhat, Producer positiveProducer, Producer negativeProducer, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		return partialLoadWithParentProducerJPAQueryResult (producerWhat, positiveProducer, negativeProducer, queryWhatInit, new Hashtable(), nbOfResult, useCache);
    }	
  
	private List partialLoadWithParentProducerJPAQueryResult(Producer producerWhat, Producer positiveProducer, Producer negativeProducer, QueryWhatInit queryWhatInit, Map beanPath, Integer nbOfResult, Boolean useCache) {
		Query hquery = getPartialLoadWithParentJPAQuery (producerWhat, positiveProducer, negativeProducer, beanPath, queryWhatInit, nbOfResult);
		return hquery.getResultList();
    }	
   /**
    * @returns an JPA Hsql query based on entity Producer and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPAQuery (Producer producerWhat, Producer positiveProducer, Producer negativeProducer, Map beanPath, QueryWhatInit queryWhatInit, Integer nbOfResult) {
	   Query query = getPartialLoadWithParentJPARawQuery (producerWhat, positiveProducer, negativeProducer, beanPath, queryWhatInit);
	   if (nbOfResult!=null)
	      query.setMaxResults(nbOfResult);
	   return query;
    }
  	
   /**
    * @returns an JPA Raw Hsql query based on entity Producer and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPARawQuery (Producer producerWhat, Producer positiveProducer, Producer negativeProducer, Map beanPath, QueryWhatInit queryWhatInit) {
	   return getEntityManager().createQuery(getPartialLoadWithParentRawHsqlQuery (producerWhat, positiveProducer, negativeProducer, beanPath, queryWhatInit));
    }
	
	private List<Producer> handlePartialLoadWithParentProducer(List<Object[]> list, Map<Integer, String> beanPath, Producer producerWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentProducer(list, beanPath, producerWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentProducer, message:"+ex.getMessage());
			return new ArrayList<Producer>();
		}
    }

	private List<Producer> handlePartialLoadWithParentProducerWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, Producer producerWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentProducerWithOneElementInRow(list, beanPath, producerWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentProducerWithOneElementInRow, message:"+ex.getMessage());
			return new ArrayList<Producer>();
		}
    }
    	
	 private List<Producer> convertPartialLoadWithParentProducer(List<Object[]> list, Map<Integer, String> beanPath, Producer producerWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<Producer> resultList = new ArrayList<Producer>();
		 for (Object[] row : list) {		
		    Producer producer = cloneProducer (producerWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populateProducer (producer, row[(Integer)entry.getKey()], (String)entry.getValue());
		    }
		    resultList.add(producer);
		 }
		 return resultList;		
	 }	
    
	 private List<Producer> convertPartialLoadWithParentProducerWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, Producer producerWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<Producer> resultList = new ArrayList<Producer>();
		 for (Object row : list) {		
		    Producer producer = cloneProducer (producerWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populateProducer (producer, row, (String)entry.getValue());
		    }
		    resultList.add(producer);
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
	public String getPartialLoadWithParentRawHsqlQuery (Producer producer, Producer positiveProducer, Producer negativeProducer, Map beanPath, QueryWhatInit queryWhatInit) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentProducerQuery (producer, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
		Hashtable aliasWhereHt = new Hashtable();
		String where = getPartialLoadWithParentWhereQuery (positiveProducer, null, aliasWhatHt, aliasWhereHt, null, null);
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
	public String findPartialLoadWithParentRawHsqlQuery (Producer whatMask, Producer criteriaMask, Map beanPath, QueryWhatInit queryWhatInit,  Producer orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentProducerQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
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
	public String countPartialLoadWithParentRawHsqlQuery (Producer whatMask, Producer criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
		Map beanPath = new Hashtable();
		Hashtable aliasWhatHt = new Hashtable();
		// used to initiate the how part of the what
		getPartialLoadWithParentProducerQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", new QuerySelectInit());
		String what = "select count(producer) ";
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
    	
	public String findPartialQuery (Producer whatMask, Producer criteriaMask, Producer orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Map beanPath) {
        QueryWhatInit queryWhatInit = new QuerySelectInit();
        return findPartialLoadWithParentRawHsqlQuery(whatMask, criteriaMask, beanPath, queryWhatInit, orderMask, matchType, operandType, caseSensitivenessType,  sortOrder);
    }
	
	/**
    * partial on a single entity load enables to specify the fields you want to load explicitly
    */         
	public List<Producer> partialLoadProducer(Producer producer, Producer positiveProducer, Producer negativeProducer) {
	    Query hquery = getEntityManager().createQuery(getPartialLoadProducerQuery (producer, positiveProducer, negativeProducer));
		int countPartialField = countPartialField(producer);
		if (countPartialField==0) 
			return new ArrayList<Producer>();
		List list = hquery.getResultList();
		Iterator iter = list.iterator();
		List<Producer> returnList = new ArrayList<Producer>();
		while(iter.hasNext()) {
			int index = 0;
			Object[] row;
			if (countPartialField==1) {
				row = new Object[1];
				row[0] = iter.next();
				} 
			else 
				row = (Object[]) iter.next();
			Producer producerResult = new Producer();
			if (producer.getProducerId() != null) {
                producerResult.setProducerId((Integer) row[index]);
				index++;
			}
			if (producer.getName() != null) {
                producerResult.setName((String) row[index]);
				index++;
			}
			if (producer.getDesciption() != null) {
                producerResult.setDesciption((String) row[index]);
				index++;
			}
			if (producer.getLogo() != null) {
                producerResult.setLogo((String) row[index]);
				index++;
			}
			returnList.add(producerResult);
        }
	    return returnList;
	}

	public static String getPartialLoadWithParentWhereQuery (
	   Producer criteriaMask, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias,
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
	   Producer producer, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias) {
	   if (producer==null)
	      return "";
	   String alias = null;
	   if (aliasWhereHt == null) {
	      aliasWhereHt = new Hashtable();
	   } 
	   if (isLookedUp(producer)){
	      alias = getNextAlias (aliasWhereHt, producer);
		  aliasWhereHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (producer.getProducerId() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".producerId = "+ producer.getProducerId() + " ");
       }
       if (producer.getName() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".name = '"+ producer.getName()+"' ");
       }
       if (producer.getDesciption() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".desciption = '"+ producer.getDesciption()+"' ");
       }
       if (producer.getLogo() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".logo = '"+ producer.getLogo()+"' ");
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
	
    public static String getPartialLoadWithParentProducerQuery (
	   Producer producer, Boolean isWhereSet, Hashtable aliasHt, String childAlias, String childFKAlias, Map beanPath, String rootPath, QueryWhatInit queryWhatInit) {
	   if (producer==null)
	      return "";
	   String alias = null;
	   if (aliasHt == null) {
	      aliasHt = new Hashtable();
	   } 
	   if (isLookedUp(producer)){
	      alias = getNextAlias (aliasHt, producer);
		  aliasHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (producer.getProducerId() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"producerId");
          query.append(" "+alias+".producerId ");
       }
       if (producer.getName() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"name");
          query.append(" "+alias+".name ");
       }
       if (producer.getDesciption() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"desciption");
          query.append(" "+alias+".desciption ");
       }
       if (producer.getLogo() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"logo");
          query.append(" "+alias+".logo ");
       }
//       query.append(getProducerSearchEqualQuery (positiveProducer, negativeProducer));
	   return query.toString(); 
    }
	
	protected static String getAliasConnection(String existingAlias, String childAlias, String childFKAlias) {
		if (childAlias==null)
		   return "";
		return childAlias+"."+childFKAlias+" = "+existingAlias+"."+"producerId";
	}
	
	protected static String getAliasKey (String alias) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return "Producer|"+alias;
	}
	
	protected static String getAliasKeyAlias (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return StringUtils.substringAfter(aliasKey, "|");
	}
	
	protected static String getAliasKeyDomain (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
	  return StringUtils.substringBefore(aliasKey, "|");
	}
	
	protected static String getNextAlias (Hashtable aliasHt, Producer producer) {
		int cptSameAlias = 0;
		Enumeration<String> _keys = aliasHt.keys();
		while (_keys.hasMoreElements()) {
			String _key = _keys.nextElement();
			if (_key.startsWith("producer"))
				cptSameAlias++;
		}
		if (cptSameAlias==0)
			return "producer";
		else
			return "producer_"+cptSameAlias;
	}
	
	
	protected static boolean isLookedUp (Producer producer) {
	   if (producer==null)
		  return false;
       if (producer.getProducerId() != null) {
	      return true;
       }
       if (producer.getName() != null) {
	      return true;
       }
       if (producer.getDesciption() != null) {
	      return true;
       }
       if (producer.getLogo() != null) {
	      return true;
       }
       return false;   
	}
	
    public String getPartialLoadProducerQuery(
	   Producer producer, 
	   Producer positiveProducer, 
	   Producer negativeProducer) {
       boolean isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (producer.getProducerId() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" producerId ");
       }
       if (producer.getName() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" name ");
       }
       if (producer.getDesciption() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" desciption ");
       }
       if (producer.getLogo() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" logo ");
       }
	   query.append(getFromEntity());
       query.append(getProducerPositiveNegativeCriteria (positiveProducer, negativeProducer));
	   return query.toString(); 
    }
	
	public List<Producer> searchPrototypeWithCacheProducer(Producer producer) {
		SimpleCache simpleCache = new SimpleCache();
		List<Producer> list = (List<Producer>)simpleCache.get(producer.toString());
		if (list==null) {
			list = searchPrototypeProducer(producer);
			simpleCache.put(producer.toString(), list);
		}
		return list;
	}

    public List<Producer> loadGraph(Producer graphMaskWhat, List<Producer> whereMask) {
        return loadGraphOneLevel(graphMaskWhat, whereMask);
    }

	public List<Producer> loadGraphOneLevel(Producer graphMaskWhat, List<Producer> whereMask) {
		//first get roots element from where list mask
		// this brings the level 0 of the graph (root level)
 		graphMaskWhat.setProducerId(graphMaskWhat.integerMask__);
		List<Producer> producers = searchPrototypeProducer (whereMask);
		// for each sub level perform the search with a subquery then reassemble
		// 1. get all sublevel queries
		// 2. perform queries on the correct dao
		// 3. reassemble
		return getLoadGraphOneLevel (graphMaskWhat, producers);
	}

	private List<Producer> copy(List<Producer> inputs) {
		List<Producer> l = new ArrayList<Producer>();
		for (Producer input : inputs) {
			Producer copy = new Producer();
			copy.copy(input);
			l.add(copy);
		}
		return l;
	}
	   
	private List<Producer> getLoadGraphOneLevel (Producer graphMaskWhat, List<Producer> parents) {
	    return loadGraphFromParentKey (graphMaskWhat, parents);
	} 
	
	public List<Producer> loadGraphFromParentKey (Producer graphMaskWhat, List<Producer> parents) {
		//foreach children:
		//check if not empty take first
		parents = copy (parents); //working with detached entities to avoid unnecessary sql calls
		if (parents==null || parents.isEmpty())
		   return parents;
		List<String> ids = getPk (parents);
		if (graphMaskWhat.getAccessorieProducerViaBrand()!=null && !graphMaskWhat.getAccessorieProducerViaBrand().isEmpty()) {
			for (Accessorie childWhat : graphMaskWhat.getAccessorieProducerViaBrand()) {
				childWhat.setBrand_(graphMaskWhat.integerMask__); // add to the what mask, usefull for reconciliation
				AccessorieJPAImpl accessorieextendedjpaimpl = new AccessorieJPAImpl ();
				List<Accessorie> children = accessorieextendedjpaimpl.lookupAccessorie(childWhat, getFkCriteria(" producerId ", ids), null, getEntityManager());
				reassembleAccessorie (children, parents);				
				break;
			}
		}
		if (graphMaskWhat.getHardwareProducerViaBrand()!=null && !graphMaskWhat.getHardwareProducerViaBrand().isEmpty()) {
			for (Hardware childWhat : graphMaskWhat.getHardwareProducerViaBrand()) {
				childWhat.setBrand_(graphMaskWhat.integerMask__); // add to the what mask, usefull for reconciliation
				HardwareJPAImpl hardwareextendedjpaimpl = new HardwareJPAImpl ();
				List<Hardware> children = hardwareextendedjpaimpl.lookupHardware(childWhat, getFkCriteria(" producerId ", ids), null, getEntityManager());
				reassembleHardware (children, parents);				
				break;
			}
		}
		if (graphMaskWhat.getSoftwareProducerViaEditor()!=null && !graphMaskWhat.getSoftwareProducerViaEditor().isEmpty()) {
			for (Software childWhat : graphMaskWhat.getSoftwareProducerViaEditor()) {
				childWhat.setEditor_(graphMaskWhat.integerMask__); // add to the what mask, usefull for reconciliation
				SoftwareJPAImpl softwareextendedjpaimpl = new SoftwareJPAImpl ();
				List<Software> children = softwareextendedjpaimpl.lookupSoftware(childWhat, getFkCriteria(" producerId ", ids), null, getEntityManager());
				reassembleSoftware (children, parents);				
				break;
			}
		}
		return parents;
	}
	
	private void reassembleAccessorie (List<Accessorie> children, List<Producer> parents) {
		for (Accessorie child : children) {
			for (Producer parent : parents) {
				if (parent.getProducerId()!=null && parent.getProducerId().toString().equals(child.getBrand()+"")) {
					parent.addAccessorieProducerViaBrand(child); 
					child.setBrand(parent);
					break;
				}
			}
		}
	}
	
	private void reassembleHardware (List<Hardware> children, List<Producer> parents) {
		for (Hardware child : children) {
			for (Producer parent : parents) {
				if (parent.getProducerId()!=null && parent.getProducerId().toString().equals(child.getBrand()+"")) {
					parent.addHardwareProducerViaBrand(child); 
					child.setBrand(parent);
					break;
				}
			}
		}
	}
	
	private void reassembleSoftware (List<Software> children, List<Producer> parents) {
		for (Software child : children) {
			for (Producer parent : parents) {
				if (parent.getProducerId()!=null && parent.getProducerId().toString().equals(child.getEditor()+"")) {
					parent.addSoftwareProducerViaEditor(child); 
					child.setEditor(parent);
					break;
				}
			}
		}
	}
	
	private List<String> getPk(List<Producer> input) {
		List<String> s = new ArrayList<String>();
		for (Producer t : input) {
			s.add(t.getProducerId()+"");
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
	public void find (QueryData<Producer> data) {
		EntityCriteria<Producer> filter = data.getEntityCriteria();
		Producer entityWhat = data.getEntityWhat();
		Producer criteriaMask = filter.getEntity();
		int start = data.getStart();
		int max = data.getMax();
		EntitySort<Producer> entitySort = data.getEntitySort();
		QuerySortOrder sortOrder = entitySort.getOrder();
		Producer sortMask = entitySort.getEntity();	

		List<Producer> results = find(entityWhat, criteriaMask, sortMask, filter.getMatchType(), filter.getOperandType(), filter.getCaseSensitivenessType(), sortOrder, start, max);
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
     * return a list of Producer entities 
     */
    public List<Producer> getList () {
        //first lightweight implementation
        return searchPrototypeProducer(new Producer());
    }
    /**
     * return a list of Producer entities and sort
     */
    public List<Producer> getList (Producer orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(new Producer(), orderMask, sortOrder, null);
    }
    /**
     * return a list of Producer entities and sort based on a Producer prototype
     */
    public List<Producer> list (Producer mask, Producer orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(mask, orderMask, sortOrder, null);
    }

	@Override
    protected String getSelectFrom() {
        return "SELECT producer "+getFromEntity();
    }

    protected String getFromEntity() {
        return " FROM Producer producer ";
    }

    @Override
    protected String getQuerySelectFromEntity() {
        return getSelectFrom();
    }
	



}
