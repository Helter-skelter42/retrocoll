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

import com.retrocoll.server.dao.face.server.SettingsDao;
import com.retrocoll.server.domain.server.Settings;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.retrocoll.server.dao.impl.ServerGenericDaoJpaImpl;


/**
 *
 * <p>Title: SettingsJPAImpl</p>
 *
 * <p>Description: Interface of a Data access object dealing with SettingsJPAImpl
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching SettingsJPAImpl objects</p>
 *
 */


@org.springframework.stereotype.Repository(value="settingsDao")

public class SettingsJPAImpl extends ServerGenericDaoJpaImpl<Settings> implements SettingsDao {
	public SettingsJPAImpl () {}
	
    /**
     * Inserts a Settings entity 
     * @param Settings settings
     */
    public void insertSettings(Settings settings) {
       entityManager.persist(settings);
    }

    protected void insertSettings(EntityManager emForRecursiveDao, Settings settings) {
       emForRecursiveDao.persist(settings);
    } 

    /**
     * Updates a Settings entity 
     * @param Settings settings
     */
    public Settings updateSettings(Settings settings) {
       return entityManager.merge(settings);
    }

	/**
     * Updates a Settings entity with only the attributes set into Settings.
	 * The primary keys are to be set for this method to operate.
	 * This is a performance friendly feature, which remove the udibiquous full load and full update when an
	 * update is issued
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param Settings settings
    */ 
    @Transactional
    public Integer updateNotNullOnlySettings(Settings settings) {
        Query jpaQuery = getEntityManager().createQuery(getUpdateNotNullOnlySettingsQueryChunk(settings));
        if (settings.getName() != null) {
           jpaQuery.setParameter ("name", settings.getName());
        }   
        if (settings.getValue() != null) {
           jpaQuery.setParameter ("value", settings.getValue());
        }   
		return jpaQuery.executeUpdate();
    }

    protected String getUpdateNotNullOnlySettingsQueryChunkPrototype (Settings settings) {
        boolean isSetSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update Settings settings ");
        if (settings.getValue() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" settings.value = :value");
        }
        if (isSetSet==false)
			throw new IllegalArgumentException("settings mask should contain updatable fields");
        return query.toString();
    }
    
    protected String getUpdateNotNullOnlySettingsQueryChunk (Settings settings) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer(getUpdateNotNullOnlySettingsQueryChunkPrototype(settings));
        if (settings.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
			     query.append(" settings.name = :name");
        }
        if (isWhereSet==false)
			throw new IllegalArgumentException("settings mask should contain primary key");
        return query.toString();
    }
    
                
	protected Settings assignBlankToNull (Settings settings) {
        if (settings==null)
			return null;
        if (settings.getValue()!=null && settings.getValue().equals(""))
           settings.setValue((String)null);
		return settings;
	}
	
	protected boolean isAllNull (Settings settings) {
	    if (settings==null)
			return true;
        if (settings.getName()!=null) 
            return false;
        if (settings.getValue()!=null) 
            return false;
		return true;
	}
		
    @Transactional
    public Integer updateNotNullOnlyPrototypeSettings(Settings settings, Settings prototypeCriteria) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update Settings settings ");
        if (settings.getName() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" settings.name = '"+ settings.getName()+"' ");
        }
        if (settings.getValue() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" settings.value = '"+ settings.getValue()+"' ");
        }
		isWhereSet = false; 
        if (prototypeCriteria.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" settings.name = '"+ prototypeCriteria.getName()+"' ");
        }
        if (prototypeCriteria.getValue() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" settings.value = '"+ prototypeCriteria.getValue()+"' ");
        }
        Query jpaQuery = getEntityManager().createQuery(query.toString());
		return jpaQuery.executeUpdate();
    }
     
     /**
     * Saves a Settings entity 
     * @param Settings settings
     */
    public void saveSettings(Settings settings) {
       //entityManager.persist(settings);
       if (entityManager.contains(settings)) {
          entityManager.merge(settings);
       } else {
          entityManager.persist(settings);
       }
       entityManager.flush(); 
    }
       
    /**
     * Deletes a Settings entity 
     * @param Settings settings
     */
    public void deleteSettings(Settings settings) {
      entityManager.remove(settings);
    }
    
    /**
     * Loads the Settings entity which is related to an instance of
     * Settings
     * @param Long id
     * @return Settings The Settings entity
     
    public Settings loadSettings(Long id) {
    	return (Settings)entityManager.get(Settings.class, id);
    }
*/
  
    /**
     * Loads the Settings entity which is related to an instance of
     * Settings
     * @param java.lang.String Name
     * @return Settings The Settings entity
     */
    public Settings loadSettings(java.lang.String name) {
    	return (Settings)entityManager.find(Settings.class, name);
    }
    
    /**
     * Loads the Settings entity which is related to an instance of
     * Settings and its dependent one to many objects
     * @param Long id
     * @return Settings The Settings entity
     */
    public Settings loadFullFirstLevelSettings(java.lang.String name) {
        List list = getResultList(
                     "SELECT settings FROM Settings settings "
                     + " WHERE settings.name = "+name
               );
         if (list!=null && !list.isEmpty())
            return (Settings)list.get(0);
         return null;
    	//return null;//(Settings) entityManager.queryForObject("loadFullFirstLevelSettings", id);
    }

    /**
     * Loads the Settings entity which is related to an instance of
     * Settings
     * @param Settings settings
     * @return Settings The Settings entity
     */
    public Settings loadFullFirstLevelSettings(Settings settings) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT settings FROM Settings settings ");
        if (settings.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" settings.name = '"+ settings.getName()+"' ");
         }
        List list = getResultList(query.toString());
        if (list!=null && !list.isEmpty())
           return (Settings)list.get(0);    
        return null;
    }  

    /**
     * Searches a list of Settings entity 
     * @param Settings settings
     * @return List
     */  
    public List<Settings> searchPrototypeSettings(Settings settings) {
       return searchPrototype (settings, null);
    }  
	
    public List<Settings> searchPrototypeAnySettings(Settings settings) {
       return searchPrototypeAny (settings, null);
    }  

	// indirection
    public List<Settings> find (Settings criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
       return find (criteriaMask, matchType, operandType, caseSensitivenessType, null, null); 
	}
	
	// indirection
	protected List<Settings> find (Settings criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, Integer startPosition, Integer maxResults) {
       return find (criteriaMask, null, matchType, operandType, caseSensitivenessType, null, startPosition, maxResults); 
    }
	
	// indirection
	protected List<Settings> find (Settings criteriaMask, Settings orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
       return find (null, criteriaMask, orderMask, matchType, operandType, caseSensitivenessType, sortOrder, startPosition, maxResults);
    }
	
	// main find implementation
	protected List<Settings> find (Settings whatMask, Settings criteriaMask, Settings orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
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
    public String findQuery (Settings criteriaMask, Settings orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String what = "SELECT settings FROM Settings settings ";
		return findQuery (criteriaMask, orderMask, what, matchType, operandType, caseSensitivenessType, sortOrder);
    }

    protected String findQuery (Settings criteriaMask, Settings orderMask, String what, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String queryWhere = findWhere (criteriaMask, false, isAll(matchType), operandType, caseSensitivenessType);
		String queryOrder = findOrder (orderMask, sortOrder);
	    return getHQuery(what, queryWhere, queryOrder);
    }
	
    protected List<Settings> searchPrototype (Settings settings, Settings orderMask, QuerySortOrder sortOrder, Integer maxResults) {
       return searchPrototype(getSettingsSelectQuery (getWhereEqualWhereQueryChunk(settings), orderMask, sortOrder), maxResults);
    }

    protected List<Settings> searchPrototype (Settings settings, Integer maxResults) {
       return searchPrototype(settings, null, null, maxResults);
    }
    
    protected List<Settings> searchPrototypeAny (Settings settings, Integer maxResults) { 
       return searchPrototype(getSearchEqualAnyQuery (settings), maxResults);
    }
    
    protected List<Settings> searchPrototype (String query, Integer maxResults) { 
       Query hquery = getEntityManager().createQuery(query);
       if (maxResults!=null)
          hquery.setMaxResults(maxResults);
       return hquery.getResultList();
    }

    public List<Settings> searchPrototypeSettings (List<Settings> settingss) {
       return searchPrototype (settingss, null);
    }

    protected List<Settings> searchPrototype (List<Settings> settingss, Integer maxResults) {    
	   return getResultList(getSettingsSearchEqualQuery (null, settingss));
	}    

    protected List<Settings> getResultList (String query) {    
	   Query hquery = entityManager.createQuery(query);            
	   return hquery.getResultList();
	}    
 

    public List<Settings> searchDistinctPrototypeSettings (Settings settingsMask, List<Settings> settingss) {
        return getResultList(getSettingsSearchEqualQuery (settingsMask, settingss));    
    }
        
	/**
     * Searches a list of Settings entity 
     * @param Settings positiveMask
     * @param Settings negativeMask
     * @return List
     */
    public List<Settings> searchPrototypeSettings(Settings positiveMask, Settings negativeMask) {
	    return getResultList(getSettingsSearchEqualQuery (positiveMask, negativeMask));  
    }

    /**
    * return a string query search on a Settings prototype
    */
    protected String getSettingsSelectQuery (String where, Settings orderMask, QuerySortOrder sortOrder) {
       return getSettingsSelectQuery (where, findOrder (orderMask, sortOrder));
    }
    protected String getSettingsSelectQuery (String where, String order) {
       StringBuffer query = new StringBuffer();
       query.append ("SELECT settings FROM Settings settings ");
       return (order!=null)? getHQuery(query.toString(), where, order):getHQuery(query.toString(), where);
    }
    /**
    * return a jql query search on a Settings prototype
    */
    protected String getSearchEqualQuery (Settings settings) {
       return getSettingsSelectQuery (getWhereEqualWhereQueryChunk(settings),null);
    }
    protected String getWhereEqualWhereQueryChunk (Settings settings) {
       return getWhereEqualWhereQueryChunk(settings, false);
    }
    /**
    * return a jql query search on a Settings with any prototype
    */
    protected String getSearchEqualAnyQuery (Settings settings) {
       return getSettingsSelectQuery (getWhereEqualAnyWhereQueryChunk(settings), null);   
    }
    protected String getWhereEqualAnyWhereQueryChunk (Settings settings) {
       return getWhereEqualAnyWhereQueryChunk(settings, false);   
    }

    /**
    * return a jql search for a list of Settings prototype
    */
    protected String getSettingsSearchEqualQuery (Settings settingsMask, List<Settings> settingss) {
        boolean isOrSet = false;
        StringBuffer query = new StringBuffer();
        if (settingsMask !=null)
           query.append (getSettingsMaskWhat (settingsMask));
        query.append (" FROM Settings settings ");
        StringBuffer queryWhere = new StringBuffer();
        for (Settings settings : settingss) {
           if (!isAllNull(settings)) {        
	           queryWhere.append (getQueryOR (isOrSet));
	           isOrSet = true;
	           queryWhere.append (" ("+getWhereEqualWhereQueryChunk(settings, false)+") ");
           }
        }
	    return getHQuery(query.toString(), queryWhere.toString());
    }	

    
    protected String getSettingsMaskWhat (Settings settingsMask) {
        boolean isCommaSet = false;
        StringBuffer query = new StringBuffer("SELECT DISTINCT ");
        if (settingsMask.getName() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" name ");
        }
        if (settingsMask.getValue() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" value ");
        }
        if (!isCommaSet)
           return "";
	    return query.toString();
    }
    
    protected String getWhereEqualAnyWhereQueryChunk (Settings settings, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (settings, isAndSet, false);	
	}
	
    protected String getWhereEqualWhereQueryChunk (Settings settings, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (settings, isAndSet, true);
	}
	
    protected String getSearchEqualWhereQueryChunk (Settings settings, boolean isAndSet, boolean isAll) {
        StringBuffer query = new StringBuffer();
        if (settings.getName() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" settings.name = '"+ settings.getName()+"' ");
        }
        if (settings.getValue() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" settings.value = '"+ settings.getValue()+"' ");
        }
	    return query.toString();
    }

    protected String findOrder (Settings orderMask, QuerySortOrder sortOrder) {
        if (orderMask!=null) {
            String orderColumn = getFirstNotNullColumnOtherWiseNull(orderMask);
            if (orderColumn!=null)
               return orderColumn + " " + sortOrder;
        }
        return "";
    }

	@Override
    protected String findWhere (Settings settings, boolean isAndSet, boolean isAll, OperandType operandType, Boolean caseSensitive) {
		return findWhere (null, settings, isAndSet, isAll, operandType, caseSensitive);
	}
	
	protected static String findWhere (String alias, Settings settings, boolean isAndSet, boolean isAll, OperandType operandType, boolean caseSensitive) {
        if (alias==null)
			alias = "settings";
		StringBuffer query = new StringBuffer();
		String operand = getOperand (operandType);
		String evaluatorPrefix = getEvaluatorPrefix (operandType);		
		String evaluatorSuffix = getEvaluatorSuffix (operandType);		
        if (settings.getName() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = settings.getName();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".name) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".name "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (settings.getValue() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = settings.getValue();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".value) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".value "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        return query.toString();
    }
	
	protected String getFirstNotNullColumnOtherWiseNull (Settings mask) {
        if (mask == null) return null;
        if (mask.getName() != null) return "name";
        if (mask.getValue() != null) return "value";
        return null;	
	}
    
    /**
    * return a jql search on a Settings prototype with positive and negative beans
    */
    protected String getSettingsSearchEqualQuery (Settings positiveMask, Settings negativeMask) {
		StringBuffer query = new StringBuffer();    	
		query.append(getSelectFrom());
		query.append(getSettingsPositiveNegativeCriteria(positiveMask, negativeMask));
		return query.toString();
	}

	protected String getSettingsPositiveNegativeCriteria (Settings positiveMask, Settings negativeMask) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        if (positiveMask!=null && positiveMask.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" settings.name = '"+ positiveMask.getName()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getName() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" settings.name is null ");
        }
        if (positiveMask!=null && positiveMask.getValue() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" settings.value = '"+ positiveMask.getValue()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getValue() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" settings.value is null ");
        }
	    return query.toString();
    }
 
	
	
    private Logger log = Logger.getLogger(this.getClass());
    
    private SimpleCache simpleCache = new SimpleCache();
    private EntityManager emForRecursiveDao; // dao that needs other dao in a recursive manner not support by spring configuration

    /**
     * generic to move after in superclass
     */
    public SettingsJPAImpl (EntityManager emForRecursiveDao) {
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
     * Inserts a Settings entity with cascade of its children
     * @param Settings settings
     */
    public void insertSettingsWithCascade(Settings settings) {
    	SettingsJPAImpl settingsjpaimpl = new SettingsJPAImpl(getEntityManager());
    	settingsjpaimpl.insertSettingsWithCascade(settingsjpaimpl.getEntityManagerForRecursiveDao(), settings);
    }
     
    public void insertSettingsWithCascade(EntityManager emForRecursiveDao, Settings settings) {
       insertSettings(emForRecursiveDao, settings);
    }
        
    /**
     * Inserts a list of Settings entity with cascade of its children
     * @param List<Settings> settingss
     */
    public void insertSettingssWithCascade(List<Settings> settingss) {
       for (Settings settings : settingss) {
          insertSettingsWithCascade(settings);
       }
    } 
        
    /**
     * lookup Settings entity Settings, criteria and max result number
     */
    public List<Settings> lookupSettings(Settings settings, Criteria criteria, Integer numberOfResult, EntityManager em) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT settings FROM Settings settings ");
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
    
    public List<Settings> lookupSettings(Settings settings, Criteria criteria, Integer numberOfResult) {
		return lookupSettings(settings, criteria, numberOfResult, getEntityManager());
    }

    public Integer updateNotNullOnlySettings (Settings settings, Criteria criteria) {
        String queryWhat = getUpdateNotNullOnlySettingsQueryChunkPrototype (settings);
        StringBuffer query = new StringBuffer (queryWhat);
        boolean isWhereSet = false;
        for (Criterion criterion : criteria.getClauseCriterions()) {
            query.append (getQueryWHERE_AND (isWhereSet));
            isWhereSet = true;   
            query.append(criterion.getExpression());			
        }  
        Query jpaQuery = getEntityManager().createQuery(query.toString());
        isWhereSet = false;
        if (settings.getName() != null) {
           jpaQuery.setParameter ("name", settings.getName());
        }   
        if (settings.getValue() != null) {
           jpaQuery.setParameter ("value", settings.getValue());
        }   
		return jpaQuery.executeUpdate();
    }
	
	public Settings affectSettings (Settings settings) {
	    return referSettings (settings, null, false);		    
	}
		
	/**
	 * Assign the first settings retrieved corresponding to the settings criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no settings corresponding in the database. Then settings is inserted and returned with its primary key(s). 
	 */
	public Settings assignSettings (Settings settings) {
		return referSettings (settings, null, true);
	}

	/**
	 * Assign the first settings retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no settings corresponding in the database. 
	 * Then settings is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public Settings assignSettings (Settings settings, Settings mask) {
		return referSettings (settings, mask, true);
	}

	public Settings referSettings (Settings settings, Settings mask, boolean isAssign) {
		settings = assignBlankToNull (settings);
		if (isAllNull(settings))
			return null;
		else {
			List<Settings> list;
			if (mask==null)
				list = searchPrototypeSettings(settings);
			else
				list = searchPrototypeSettings(mask);
			if (list.isEmpty()) {
			    if (isAssign)
			       insertSettings(settings);
			    else
				   return null;
			}
			else if (list.size()==1)
				settings.copy(list.get(0));
			else 
				//TODO log error
				settings.copy(list.get(0));
		}
		return settings;		    
	}

   public Settings assignSettingsUseCache (Settings settings) {
      return referSettingsUseCache (settings, true);
   }
      		
   public Settings affectSettingsUseCache (Settings settings) {
      return referSettingsUseCache (settings, false);
   }
      		
   public Settings referSettingsUseCache (Settings settings, boolean isAssign) {
	  String key = getCacheKey(null, settings, null, "assignSettings");
      Settings settingsCache = (Settings)simpleCache.get(key);
      if (settingsCache==null) {
         settingsCache = referSettings (settings, null, isAssign);
         if (key!=null)
         	simpleCache.put(key, settingsCache);
      }
      settings.copy(settingsCache);
      return settingsCache;
   }	

	private String getCacheKey (Settings settingsWhat, Settings positiveSettings, Settings negativeSettings, String queryKey) {
	    StringBuffer sb = new StringBuffer();
	    sb.append(queryKey);
	    if (settingsWhat!=null)
	       sb.append(settingsWhat.toStringWithParents());
	    if (positiveSettings!=null)
	       sb.append(positiveSettings.toStringWithParents());
	    if (negativeSettings!=null)
	       sb.append(negativeSettings.toStringWithParents());
	    return sb.toString();
	}
	
    public Settings partialLoadWithParentFirstSettings(Settings settingsWhat, Settings positiveSettings, Settings negativeSettings){
		List <Settings> list = partialLoadWithParentSettings(settingsWhat, positiveSettings, negativeSettings);
		return (!list.isEmpty())?(Settings)list.get(0):null;
    }
    
    public Settings partialLoadWithParentFirstSettingsUseCache(Settings settingsWhat, Settings positiveSettings, Settings negativeSettings, Boolean useCache){
		List <Settings> list = partialLoadWithParentSettingsUseCache(settingsWhat, positiveSettings, negativeSettings, useCache);
		return (!list.isEmpty())?(Settings)list.get(0):null;
    }
	
	public Settings partialLoadWithParentFirstSettingsUseCacheOnResult(Settings settingsWhat, Settings positiveSettings, Settings negativeSettings, Boolean useCache){
		List <Settings> list = partialLoadWithParentSettingsUseCacheOnResult(settingsWhat, positiveSettings, negativeSettings, useCache);
		return (!list.isEmpty())?(Settings)list.get(0):null;
    }
	//
	protected List<Settings> partialLoadWithParentSettings(Settings settingsWhat, Settings positiveSettings, Settings negativeSettings, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentSettings(settingsWhat, positiveSettings, negativeSettings, new QuerySelectInit(), nbOfResult, useCache);
	}	  

	protected List partialLoadWithParentSettingsQueryResult (Settings settingsWhat, Settings positiveSettings, Settings negativeSettings, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentSettingsQueryResult (settingsWhat, positiveSettings, negativeSettings, new QuerySelectInit(), nbOfResult, useCache);
	}	
    
    public List<Settings> getDistinctSettings(Settings settingsWhat, Settings positiveSettings, Settings negativeSettings) {
		 return partialLoadWithParentSettings(settingsWhat, positiveSettings, negativeSettings, new QuerySelectDistinctInit(), null, false);
	}
	
	public List<Settings> partialLoadWithParentSettings(Settings settingsWhat, Settings positiveSettings, Settings negativeSettings) {
		 return partialLoadWithParentSettings(settingsWhat, positiveSettings, negativeSettings, new QuerySelectInit(), null, false);
	}	
  
	public List<Settings> partialLoadWithParentSettingsUseCacheOnResult(Settings settingsWhat, Settings positiveSettings, Settings negativeSettings, Boolean useCache) {
		String key = getCacheKey(settingsWhat, positiveSettings, negativeSettings, "partialLoadWithParentSettings");
		List<Settings> list = (List<Settings>)simpleCache.get(key);
		if (list==null || list.isEmpty()) {
			list = partialLoadWithParentSettings(settingsWhat, positiveSettings, negativeSettings);
			if (!list.isEmpty())
			   simpleCache.put(key, list);
		}
		return list;	
	}	

	public List<Settings> partialLoadWithParentSettingsUseCache(Settings settingsWhat, Settings positiveSettings, Settings negativeSettings, Boolean useCache) {
		String key = getCacheKey(settingsWhat, positiveSettings, negativeSettings, "partialLoadWithParentSettings");
		List<Settings> list = (List<Settings>)simpleCache.get(key);
		if (list==null) {
			list = partialLoadWithParentSettings(settingsWhat, positiveSettings, negativeSettings);
			simpleCache.put(key, list);
		}
		return list;	
	}	
	
	private List<Settings> handleLoadWithParentSettings(Map beanPath, List list, Settings settingsWhat) {
	    return handleLoadWithParentSettings(beanPath, list, settingsWhat, true);  
	}
	
	private List<Settings> handleLoadWithParentSettings(Map beanPath, List list, Settings settingsWhat, boolean isHql) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentSettingsWithOneElementInRow(list, beanPath, settingsWhat, isHql);
		}
		return handlePartialLoadWithParentSettings(list, beanPath, settingsWhat, isHql);	
	}
	
    	// to set in super class	
	protected void populateSettings (Settings settings, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(settings, beanPath, value);
	}
	
	protected void populateSettingsFromSQL (Settings settings, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(settings, beanPath, value);
	}
    	// to set in super class BEWARE: genericity is only one level!!!!! first level is a copy second level is a reference!!! change to settings.clone() instead
	private Settings cloneSettings (Settings settings) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		//return (Settings) BeanUtils.cloneBeanObject(settings);
	   if (settings==null) return new Settings();
	   return settings.clone();
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
	
    public List<Settings> countDistinct (Settings whatMask, Settings whereEqCriteria) {
       return partialLoadWithParentSettings(whatMask, whereEqCriteria, null, new QuerySelectCountInit("settings"), null, false);
    }   
  	
    public Long count(Settings whereEqCriteria) {
	    return count(null, whereEqCriteria, EntityMatchType.ALL, OperandType.EQUALS, true); 
/*        Query query = getEntityManager().createQuery(getSelectCountPrototype(whereEqCriteria));
        List<Long> list = query.getResultList();
    	if (!list.isEmpty()) {
            return list.get(0);
    	}
    	return 0L;
*/
    }


    public Long count(Settings whatMask, Settings whereCriteria, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
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

	protected String countQuery (Settings settings, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
        String what = "SELECT count(*) FROM Settings settings ";
		return findQuery (settings, null, what, matchType, operandType, caseSensitivenessType, null);
    }
	

   private List getFirstResultWhereConditionsAre (Settings settings) {
      return partialLoadWithParentSettingsQueryResult(getDefaultSettingsWhat(), settings, null, 1, false);	
   }
   
   protected Settings getDefaultSettingsWhat() {
      Settings settings = new Settings();
      settings.setName(new String());
      return settings;
   }
   
	public Settings getFirstSettings (Settings settings) {
		if (isAllNull(settings))
			return null;
		else {
			List<Settings> list = searchPrototype (settings, 1);
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
    * checks if the Settings entity exists
    */           
    public boolean existsSettings (Settings settings) {
       if (getFirstSettings(settings)!=null)
          return true;
       return false;  
    }
        
    public boolean existsSettingsWhereConditionsAre (Settings settings) {
       if (getFirstResultWhereConditionsAre (settings).isEmpty())
          return false;
       return true;  
    }

	private int countPartialField (Settings settings) {
	   int cpt = 0;
       if (settings.getName() != null) {
          cpt++;
       }
       if (settings.getValue() != null) {
          cpt++;
       }
       return cpt;
	}   

	public List<Settings> partialLoadWithParentSettings(Settings what, Settings positiveSettings, Settings negativeSettings, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		Map beanPath = new Hashtable();
		List list = partialLoadWithParentSettingsJPAQueryResult (what, positiveSettings, negativeSettings, queryWhatInit, beanPath, nbOfResult, useCache);
		return handlePartialLoadWithParentResult(what, list, beanPath);
	}
	
	public List<Settings> handlePartialLoadWithParentResult(Settings what, List list, Map beanPath) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentSettingsWithOneElementInRow(list, beanPath, what, true);
		}
		return handlePartialLoadWithParentSettings(list, beanPath, what, true);
	}	

	private List partialLoadWithParentSettingsQueryResult(Settings settingsWhat, Settings positiveSettings, Settings negativeSettings, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		return partialLoadWithParentSettingsJPAQueryResult (settingsWhat, positiveSettings, negativeSettings, queryWhatInit, new Hashtable(), nbOfResult, useCache);
    }	
  
	private List partialLoadWithParentSettingsJPAQueryResult(Settings settingsWhat, Settings positiveSettings, Settings negativeSettings, QueryWhatInit queryWhatInit, Map beanPath, Integer nbOfResult, Boolean useCache) {
		Query hquery = getPartialLoadWithParentJPAQuery (settingsWhat, positiveSettings, negativeSettings, beanPath, queryWhatInit, nbOfResult);
		return hquery.getResultList();
    }	
   /**
    * @returns an JPA Hsql query based on entity Settings and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPAQuery (Settings settingsWhat, Settings positiveSettings, Settings negativeSettings, Map beanPath, QueryWhatInit queryWhatInit, Integer nbOfResult) {
	   Query query = getPartialLoadWithParentJPARawQuery (settingsWhat, positiveSettings, negativeSettings, beanPath, queryWhatInit);
	   if (nbOfResult!=null)
	      query.setMaxResults(nbOfResult);
	   return query;
    }
  	
   /**
    * @returns an JPA Raw Hsql query based on entity Settings and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPARawQuery (Settings settingsWhat, Settings positiveSettings, Settings negativeSettings, Map beanPath, QueryWhatInit queryWhatInit) {
	   return getEntityManager().createQuery(getPartialLoadWithParentRawHsqlQuery (settingsWhat, positiveSettings, negativeSettings, beanPath, queryWhatInit));
    }
	
	private List<Settings> handlePartialLoadWithParentSettings(List<Object[]> list, Map<Integer, String> beanPath, Settings settingsWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentSettings(list, beanPath, settingsWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentSettings, message:"+ex.getMessage());
			return new ArrayList<Settings>();
		}
    }

	private List<Settings> handlePartialLoadWithParentSettingsWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, Settings settingsWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentSettingsWithOneElementInRow(list, beanPath, settingsWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentSettingsWithOneElementInRow, message:"+ex.getMessage());
			return new ArrayList<Settings>();
		}
    }
    	
	 private List<Settings> convertPartialLoadWithParentSettings(List<Object[]> list, Map<Integer, String> beanPath, Settings settingsWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<Settings> resultList = new ArrayList<Settings>();
		 for (Object[] row : list) {		
		    Settings settings = cloneSettings (settingsWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populateSettings (settings, row[(Integer)entry.getKey()], (String)entry.getValue());
		    }
		    resultList.add(settings);
		 }
		 return resultList;		
	 }	
    
	 private List<Settings> convertPartialLoadWithParentSettingsWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, Settings settingsWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<Settings> resultList = new ArrayList<Settings>();
		 for (Object row : list) {		
		    Settings settings = cloneSettings (settingsWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populateSettings (settings, row, (String)entry.getValue());
		    }
		    resultList.add(settings);
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
	public String getPartialLoadWithParentRawHsqlQuery (Settings settings, Settings positiveSettings, Settings negativeSettings, Map beanPath, QueryWhatInit queryWhatInit) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentSettingsQuery (settings, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
		Hashtable aliasWhereHt = new Hashtable();
		String where = getPartialLoadWithParentWhereQuery (positiveSettings, null, aliasWhatHt, aliasWhereHt, null, null);
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
	public String findPartialLoadWithParentRawHsqlQuery (Settings whatMask, Settings criteriaMask, Map beanPath, QueryWhatInit queryWhatInit,  Settings orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentSettingsQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
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
	public String countPartialLoadWithParentRawHsqlQuery (Settings whatMask, Settings criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
		Map beanPath = new Hashtable();
		Hashtable aliasWhatHt = new Hashtable();
		// used to initiate the how part of the what
		getPartialLoadWithParentSettingsQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", new QuerySelectInit());
		String what = "select count(settings) ";
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
    	
	public String findPartialQuery (Settings whatMask, Settings criteriaMask, Settings orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Map beanPath) {
        QueryWhatInit queryWhatInit = new QuerySelectInit();
        return findPartialLoadWithParentRawHsqlQuery(whatMask, criteriaMask, beanPath, queryWhatInit, orderMask, matchType, operandType, caseSensitivenessType,  sortOrder);
    }
	
	/**
    * partial on a single entity load enables to specify the fields you want to load explicitly
    */         
	public List<Settings> partialLoadSettings(Settings settings, Settings positiveSettings, Settings negativeSettings) {
	    Query hquery = getEntityManager().createQuery(getPartialLoadSettingsQuery (settings, positiveSettings, negativeSettings));
		int countPartialField = countPartialField(settings);
		if (countPartialField==0) 
			return new ArrayList<Settings>();
		List list = hquery.getResultList();
		Iterator iter = list.iterator();
		List<Settings> returnList = new ArrayList<Settings>();
		while(iter.hasNext()) {
			int index = 0;
			Object[] row;
			if (countPartialField==1) {
				row = new Object[1];
				row[0] = iter.next();
				} 
			else 
				row = (Object[]) iter.next();
			Settings settingsResult = new Settings();
			if (settings.getName() != null) {
                settingsResult.setName((String) row[index]);
				index++;
			}
			if (settings.getValue() != null) {
                settingsResult.setValue((String) row[index]);
				index++;
			}
			returnList.add(settingsResult);
        }
	    return returnList;
	}

	public static String getPartialLoadWithParentWhereQuery (
	   Settings criteriaMask, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias,
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
	   Settings settings, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias) {
	   if (settings==null)
	      return "";
	   String alias = null;
	   if (aliasWhereHt == null) {
	      aliasWhereHt = new Hashtable();
	   } 
	   if (isLookedUp(settings)){
	      alias = getNextAlias (aliasWhereHt, settings);
		  aliasWhereHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (settings.getName() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".name = '"+ settings.getName()+"' ");
       }
       if (settings.getValue() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".value = '"+ settings.getValue()+"' ");
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
	
    public static String getPartialLoadWithParentSettingsQuery (
	   Settings settings, Boolean isWhereSet, Hashtable aliasHt, String childAlias, String childFKAlias, Map beanPath, String rootPath, QueryWhatInit queryWhatInit) {
	   if (settings==null)
	      return "";
	   String alias = null;
	   if (aliasHt == null) {
	      aliasHt = new Hashtable();
	   } 
	   if (isLookedUp(settings)){
	      alias = getNextAlias (aliasHt, settings);
		  aliasHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (settings.getName() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"name");
          query.append(" "+alias+".name ");
       }
       if (settings.getValue() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"value");
          query.append(" "+alias+".value ");
       }
//       query.append(getSettingsSearchEqualQuery (positiveSettings, negativeSettings));
	   return query.toString(); 
    }
	
	protected static String getAliasConnection(String existingAlias, String childAlias, String childFKAlias) {
		if (childAlias==null)
		   return "";
		return childAlias+"."+childFKAlias+" = "+existingAlias+"."+"name";
	}
	
	protected static String getAliasKey (String alias) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return "Settings|"+alias;
	}
	
	protected static String getAliasKeyAlias (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return StringUtils.substringAfter(aliasKey, "|");
	}
	
	protected static String getAliasKeyDomain (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
	  return StringUtils.substringBefore(aliasKey, "|");
	}
	
	protected static String getNextAlias (Hashtable aliasHt, Settings settings) {
		int cptSameAlias = 0;
		Enumeration<String> _keys = aliasHt.keys();
		while (_keys.hasMoreElements()) {
			String _key = _keys.nextElement();
			if (_key.startsWith("settings"))
				cptSameAlias++;
		}
		if (cptSameAlias==0)
			return "settings";
		else
			return "settings_"+cptSameAlias;
	}
	
	
	protected static boolean isLookedUp (Settings settings) {
	   if (settings==null)
		  return false;
       if (settings.getName() != null) {
	      return true;
       }
       if (settings.getValue() != null) {
	      return true;
       }
       return false;   
	}
	
    public String getPartialLoadSettingsQuery(
	   Settings settings, 
	   Settings positiveSettings, 
	   Settings negativeSettings) {
       boolean isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (settings.getName() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" name ");
       }
       if (settings.getValue() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" value ");
       }
	   query.append(getFromEntity());
       query.append(getSettingsPositiveNegativeCriteria (positiveSettings, negativeSettings));
	   return query.toString(); 
    }
	
	public List<Settings> searchPrototypeWithCacheSettings(Settings settings) {
		SimpleCache simpleCache = new SimpleCache();
		List<Settings> list = (List<Settings>)simpleCache.get(settings.toString());
		if (list==null) {
			list = searchPrototypeSettings(settings);
			simpleCache.put(settings.toString(), list);
		}
		return list;
	}

    public List<Settings> loadGraph(Settings graphMaskWhat, List<Settings> whereMask) {
        return loadGraphOneLevel(graphMaskWhat, whereMask);
    }

	public List<Settings> loadGraphOneLevel(Settings graphMaskWhat, List<Settings> whereMask) {
		//first get roots element from where list mask
		// this brings the level 0 of the graph (root level)
 		graphMaskWhat.setName(graphMaskWhat.stringMask__);
		List<Settings> settingss = searchPrototypeSettings (whereMask);
		// for each sub level perform the search with a subquery then reassemble
		// 1. get all sublevel queries
		// 2. perform queries on the correct dao
		// 3. reassemble
		return getLoadGraphOneLevel (graphMaskWhat, settingss);
	}

	private List<Settings> copy(List<Settings> inputs) {
		List<Settings> l = new ArrayList<Settings>();
		for (Settings input : inputs) {
			Settings copy = new Settings();
			copy.copy(input);
			l.add(copy);
		}
		return l;
	}
	   
	private List<Settings> getLoadGraphOneLevel (Settings graphMaskWhat, List<Settings> parents) {
	    return loadGraphFromParentKey (graphMaskWhat, parents);
	} 
	
	public List<Settings> loadGraphFromParentKey (Settings graphMaskWhat, List<Settings> parents) {
		//foreach children:
		//check if not empty take first
		parents = copy (parents); //working with detached entities to avoid unnecessary sql calls
		if (parents==null || parents.isEmpty())
		   return parents;
		List<String> ids = getPk (parents);
		return parents;
	}
	
	private List<String> getPk(List<Settings> input) {
		List<String> s = new ArrayList<String>();
		for (Settings t : input) {
			s.add(t.getName()+"");
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
	public void find (QueryData<Settings> data) {
		EntityCriteria<Settings> filter = data.getEntityCriteria();
		Settings entityWhat = data.getEntityWhat();
		Settings criteriaMask = filter.getEntity();
		int start = data.getStart();
		int max = data.getMax();
		EntitySort<Settings> entitySort = data.getEntitySort();
		QuerySortOrder sortOrder = entitySort.getOrder();
		Settings sortMask = entitySort.getEntity();	

		List<Settings> results = find(entityWhat, criteriaMask, sortMask, filter.getMatchType(), filter.getOperandType(), filter.getCaseSensitivenessType(), sortOrder, start, max);
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
     * return a list of Settings entities 
     */
    public List<Settings> getList () {
        //first lightweight implementation
        return searchPrototypeSettings(new Settings());
    }
    /**
     * return a list of Settings entities and sort
     */
    public List<Settings> getList (Settings orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(new Settings(), orderMask, sortOrder, null);
    }
    /**
     * return a list of Settings entities and sort based on a Settings prototype
     */
    public List<Settings> list (Settings mask, Settings orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(mask, orderMask, sortOrder, null);
    }

	@Override
    protected String getSelectFrom() {
        return "SELECT settings "+getFromEntity();
    }

    protected String getFromEntity() {
        return " FROM Settings settings ";
    }

    @Override
    protected String getQuerySelectFromEntity() {
        return getSelectFrom();
    }
	



}
