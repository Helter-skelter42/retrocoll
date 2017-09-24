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

import com.retrocoll.server.dao.face.server.UserDao;
import com.retrocoll.server.domain.server.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.retrocoll.server.dao.impl.ServerGenericDaoJpaImpl;


/**
 *
 * <p>Title: UserJPAImpl</p>
 *
 * <p>Description: Interface of a Data access object dealing with UserJPAImpl
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching UserJPAImpl objects</p>
 *
 */


@org.springframework.stereotype.Repository(value="userDao")

public class UserJPAImpl extends ServerGenericDaoJpaImpl<User> implements UserDao {
	public UserJPAImpl () {}
	
    /**
     * Inserts a User entity 
     * @param User user
     */
    public void insertUser(User user) {
       entityManager.persist(user);
    }

    protected void insertUser(EntityManager emForRecursiveDao, User user) {
       emForRecursiveDao.persist(user);
    } 

    /**
     * Updates a User entity 
     * @param User user
     */
    public User updateUser(User user) {
       return entityManager.merge(user);
    }

	/**
     * Updates a User entity with only the attributes set into User.
	 * The primary keys are to be set for this method to operate.
	 * This is a performance friendly feature, which remove the udibiquous full load and full update when an
	 * update is issued
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param User user
    */ 
    @Transactional
    public Integer updateNotNullOnlyUser(User user) {
        Query jpaQuery = getEntityManager().createQuery(getUpdateNotNullOnlyUserQueryChunk(user));
        if (user.getUsername() != null) {
           jpaQuery.setParameter ("username", user.getUsername());
        }   
        if (user.getEmail() != null) {
           jpaQuery.setParameter ("email", user.getEmail());
        }   
        if (user.getPassword() != null) {
           jpaQuery.setParameter ("password", user.getPassword());
        }   
        if (user.getCreateTime() != null) {
           jpaQuery.setParameter ("createTime", user.getCreateTime());
        }   
		return jpaQuery.executeUpdate();
    }

    protected String getUpdateNotNullOnlyUserQueryChunkPrototype (User user) {
        boolean isSetSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update User user ");
        if (user.getUsername() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" user.username = :username");
        }
        if (user.getPassword() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" user.password = :password");
        }
        if (user.getCreateTime() != null) {
           query.append (getQueryCommaSet (isSetSet));
           isSetSet = true; 
           query.append(" user.createTime = :createTime");
        }
        if (isSetSet==false)
			throw new IllegalArgumentException("user mask should contain updatable fields");
        return query.toString();
    }
    
    protected String getUpdateNotNullOnlyUserQueryChunk (User user) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer(getUpdateNotNullOnlyUserQueryChunkPrototype(user));
        if (user.getEmail() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
			     query.append(" user.email = :email");
        }
        if (isWhereSet==false)
			throw new IllegalArgumentException("user mask should contain primary key");
        return query.toString();
    }
    
                
	protected User assignBlankToNull (User user) {
        if (user==null)
			return null;
        if (user.getUsername()!=null && user.getUsername().equals(""))
           user.setUsername((String)null);
        if (user.getPassword()!=null && user.getPassword().equals(""))
           user.setPassword((String)null);
		return user;
	}
	
	protected boolean isAllNull (User user) {
	    if (user==null)
			return true;
        if (user.getUsername()!=null) 
            return false;
        if (user.getEmail()!=null) 
            return false;
        if (user.getPassword()!=null) 
            return false;
        if (user.getCreateTime()!=null) 
            return false;
		return true;
	}
		
    @Transactional
    public Integer updateNotNullOnlyPrototypeUser(User user, User prototypeCriteria) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append (" update User user ");
        if (user.getUsername() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" user.username = '"+ user.getUsername()+"' ");
        }
        if (user.getEmail() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" user.email = '"+ user.getEmail()+"' ");
        }
        if (user.getPassword() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" user.password = '"+ user.getPassword()+"' ");
        }
        if (user.getCreateTime() != null) {
           query.append (getQueryCommaSet (isWhereSet));
           isWhereSet = true; 
           query.append(" user.createTime = '"+ user.getCreateTime()+"' ");
        }
		isWhereSet = false; 
        if (prototypeCriteria.getUsername() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" user.username = '"+ prototypeCriteria.getUsername()+"' ");
        }
        if (prototypeCriteria.getEmail() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" user.email = '"+ prototypeCriteria.getEmail()+"' ");
        }
        if (prototypeCriteria.getPassword() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" user.password = '"+ prototypeCriteria.getPassword()+"' ");
        }
        if (prototypeCriteria.getCreateTime() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" user.createTime = '"+ prototypeCriteria.getCreateTime()+"' ");
        }
        Query jpaQuery = getEntityManager().createQuery(query.toString());
		return jpaQuery.executeUpdate();
    }
     
     /**
     * Saves a User entity 
     * @param User user
     */
    public void saveUser(User user) {
       //entityManager.persist(user);
       if (entityManager.contains(user)) {
          entityManager.merge(user);
       } else {
          entityManager.persist(user);
       }
       entityManager.flush(); 
    }
       
    /**
     * Deletes a User entity 
     * @param User user
     */
    public void deleteUser(User user) {
      entityManager.remove(user);
    }
    
    /**
     * Loads the User entity which is related to an instance of
     * User
     * @param Long id
     * @return User The User entity
     
    public User loadUser(Long id) {
    	return (User)entityManager.get(User.class, id);
    }
*/
  
    /**
     * Loads the User entity which is related to an instance of
     * User
     * @param java.lang.String Email
     * @return User The User entity
     */
    public User loadUser(java.lang.String email) {
    	return (User)entityManager.find(User.class, email);
    }
    
    /**
     * Loads the User entity which is related to an instance of
     * User and its dependent one to many objects
     * @param Long id
     * @return User The User entity
     */
    public User loadFullFirstLevelUser(java.lang.String email) {
        List list = getResultList(
                     "SELECT user FROM User user "
                     + " WHERE user.email = "+email
               );
         if (list!=null && !list.isEmpty())
            return (User)list.get(0);
         return null;
    	//return null;//(User) entityManager.queryForObject("loadFullFirstLevelUser", id);
    }

    /**
     * Loads the User entity which is related to an instance of
     * User
     * @param User user
     * @return User The User entity
     */
    public User loadFullFirstLevelUser(User user) {
        boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT user FROM User user ");
        if (user.getEmail() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" user.email = '"+ user.getEmail()+"' ");
         }
        List list = getResultList(query.toString());
        if (list!=null && !list.isEmpty())
           return (User)list.get(0);    
        return null;
    }  

    /**
     * Searches a list of User entity 
     * @param User user
     * @return List
     */  
    public List<User> searchPrototypeUser(User user) {
       return searchPrototype (user, null);
    }  
	
    public List<User> searchPrototypeAnyUser(User user) {
       return searchPrototypeAny (user, null);
    }  

	// indirection
    public List<User> find (User criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
       return find (criteriaMask, matchType, operandType, caseSensitivenessType, null, null); 
	}
	
	// indirection
	protected List<User> find (User criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, Integer startPosition, Integer maxResults) {
       return find (criteriaMask, null, matchType, operandType, caseSensitivenessType, null, startPosition, maxResults); 
    }
	
	// indirection
	protected List<User> find (User criteriaMask, User orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
       return find (null, criteriaMask, orderMask, matchType, operandType, caseSensitivenessType, sortOrder, startPosition, maxResults);
    }
	
	// main find implementation
	protected List<User> find (User whatMask, User criteriaMask, User orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Integer startPosition, Integer maxResults) {
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
    public String findQuery (User criteriaMask, User orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String what = "SELECT user FROM User user ";
		return findQuery (criteriaMask, orderMask, what, matchType, operandType, caseSensitivenessType, sortOrder);
    }

    protected String findQuery (User criteriaMask, User orderMask, String what, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
        String queryWhere = findWhere (criteriaMask, false, isAll(matchType), operandType, caseSensitivenessType);
		String queryOrder = findOrder (orderMask, sortOrder);
	    return getHQuery(what, queryWhere, queryOrder);
    }
	
    protected List<User> searchPrototype (User user, User orderMask, QuerySortOrder sortOrder, Integer maxResults) {
       return searchPrototype(getUserSelectQuery (getWhereEqualWhereQueryChunk(user), orderMask, sortOrder), maxResults);
    }

    protected List<User> searchPrototype (User user, Integer maxResults) {
       return searchPrototype(user, null, null, maxResults);
    }
    
    protected List<User> searchPrototypeAny (User user, Integer maxResults) { 
       return searchPrototype(getSearchEqualAnyQuery (user), maxResults);
    }
    
    protected List<User> searchPrototype (String query, Integer maxResults) { 
       Query hquery = getEntityManager().createQuery(query);
       if (maxResults!=null)
          hquery.setMaxResults(maxResults);
       return hquery.getResultList();
    }

    public List<User> searchPrototypeUser (List<User> users) {
       return searchPrototype (users, null);
    }

    protected List<User> searchPrototype (List<User> users, Integer maxResults) {    
	   return getResultList(getUserSearchEqualQuery (null, users));
	}    

    protected List<User> getResultList (String query) {    
	   Query hquery = entityManager.createQuery(query);            
	   return hquery.getResultList();
	}    
 

    public List<User> searchDistinctPrototypeUser (User userMask, List<User> users) {
        return getResultList(getUserSearchEqualQuery (userMask, users));    
    }
        
	/**
     * Searches a list of User entity 
     * @param User positiveMask
     * @param User negativeMask
     * @return List
     */
    public List<User> searchPrototypeUser(User positiveMask, User negativeMask) {
	    return getResultList(getUserSearchEqualQuery (positiveMask, negativeMask));  
    }

    /**
    * return a string query search on a User prototype
    */
    protected String getUserSelectQuery (String where, User orderMask, QuerySortOrder sortOrder) {
       return getUserSelectQuery (where, findOrder (orderMask, sortOrder));
    }
    protected String getUserSelectQuery (String where, String order) {
       StringBuffer query = new StringBuffer();
       query.append ("SELECT user FROM User user ");
       return (order!=null)? getHQuery(query.toString(), where, order):getHQuery(query.toString(), where);
    }
    /**
    * return a jql query search on a User prototype
    */
    protected String getSearchEqualQuery (User user) {
       return getUserSelectQuery (getWhereEqualWhereQueryChunk(user),null);
    }
    protected String getWhereEqualWhereQueryChunk (User user) {
       return getWhereEqualWhereQueryChunk(user, false);
    }
    /**
    * return a jql query search on a User with any prototype
    */
    protected String getSearchEqualAnyQuery (User user) {
       return getUserSelectQuery (getWhereEqualAnyWhereQueryChunk(user), null);   
    }
    protected String getWhereEqualAnyWhereQueryChunk (User user) {
       return getWhereEqualAnyWhereQueryChunk(user, false);   
    }

    /**
    * return a jql search for a list of User prototype
    */
    protected String getUserSearchEqualQuery (User userMask, List<User> users) {
        boolean isOrSet = false;
        StringBuffer query = new StringBuffer();
        if (userMask !=null)
           query.append (getUserMaskWhat (userMask));
        query.append (" FROM User user ");
        StringBuffer queryWhere = new StringBuffer();
        for (User user : users) {
           if (!isAllNull(user)) {        
	           queryWhere.append (getQueryOR (isOrSet));
	           isOrSet = true;
	           queryWhere.append (" ("+getWhereEqualWhereQueryChunk(user, false)+") ");
           }
        }
	    return getHQuery(query.toString(), queryWhere.toString());
    }	

    
    protected String getUserMaskWhat (User userMask) {
        boolean isCommaSet = false;
        StringBuffer query = new StringBuffer("SELECT DISTINCT ");
        if (userMask.getUsername() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" username ");
        }
        if (userMask.getEmail() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" email ");
        }
        if (userMask.getPassword() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" password ");
        }
        if (userMask.getCreateTime() != null) {
           query.append (getQueryComma (isCommaSet));
           isCommaSet = true;
           query.append(" createTime ");
        }
        if (!isCommaSet)
           return "";
	    return query.toString();
    }
    
    protected String getWhereEqualAnyWhereQueryChunk (User user, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (user, isAndSet, false);	
	}
	
    protected String getWhereEqualWhereQueryChunk (User user, boolean isAndSet) {
		return getSearchEqualWhereQueryChunk (user, isAndSet, true);
	}
	
    protected String getSearchEqualWhereQueryChunk (User user, boolean isAndSet, boolean isAll) {
        StringBuffer query = new StringBuffer();
        if (user.getUsername() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" user.username = '"+ user.getUsername()+"' ");
        }
        if (user.getEmail() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" user.email = '"+ user.getEmail()+"' ");
        }
        if (user.getPassword() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" user.password = '"+ user.getPassword()+"' ");
        }
        if (user.getCreateTime() != null) {
		   if (isAll)
			  query.append (getQueryAND (isAndSet));
		   else 
		      query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" user.createTime = '"+ user.getCreateTime()+"' ");
        }
	    return query.toString();
    }

    protected String findOrder (User orderMask, QuerySortOrder sortOrder) {
        if (orderMask!=null) {
            String orderColumn = getFirstNotNullColumnOtherWiseNull(orderMask);
            if (orderColumn!=null)
               return orderColumn + " " + sortOrder;
        }
        return "";
    }

	@Override
    protected String findWhere (User user, boolean isAndSet, boolean isAll, OperandType operandType, Boolean caseSensitive) {
		return findWhere (null, user, isAndSet, isAll, operandType, caseSensitive);
	}
	
	protected static String findWhere (String alias, User user, boolean isAndSet, boolean isAll, OperandType operandType, boolean caseSensitive) {
        if (alias==null)
			alias = "user";
		StringBuffer query = new StringBuffer();
		String operand = getOperand (operandType);
		String evaluatorPrefix = getEvaluatorPrefix (operandType);		
		String evaluatorSuffix = getEvaluatorSuffix (operandType);		
        if (user.getUsername() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = user.getUsername();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".username) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".username "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (user.getEmail() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = user.getEmail();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".email) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".email "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (user.getPassword() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           String value = user.getPassword();
           if (!caseSensitive) {
              value = value.toLowerCase();
              query.append(" lower("+alias+".password) "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
           }
           else
              query.append(" "+alias+".password "+operand+ "'"+evaluatorPrefix+value+evaluatorSuffix+"' ");
        }
        if (user.getCreateTime() != null) {
           if (isAll)
              query.append (getQueryAND (isAndSet));
           else 
              query.append (getQueryOR (isAndSet));
           isAndSet = true;
           query.append(" "+alias+".createTime = '"+ user.getCreateTime()+"' ");
        }
        return query.toString();
    }
	
	protected String getFirstNotNullColumnOtherWiseNull (User mask) {
        if (mask == null) return null;
        if (mask.getUsername() != null) return "username";
        if (mask.getEmail() != null) return "email";
        if (mask.getPassword() != null) return "password";
        if (mask.getCreateTime() != null) return "createTime";
        return null;	
	}
    
    /**
    * return a jql search on a User prototype with positive and negative beans
    */
    protected String getUserSearchEqualQuery (User positiveMask, User negativeMask) {
		StringBuffer query = new StringBuffer();    	
		query.append(getSelectFrom());
		query.append(getUserPositiveNegativeCriteria(positiveMask, negativeMask));
		return query.toString();
	}

	protected String getUserPositiveNegativeCriteria (User positiveMask, User negativeMask) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        if (positiveMask!=null && positiveMask.getUsername() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" user.username = '"+ positiveMask.getUsername()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getUsername() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" user.username is null ");
        }
        if (positiveMask!=null && positiveMask.getEmail() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" user.email = '"+ positiveMask.getEmail()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getEmail() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" user.email is null ");
        }
        if (positiveMask!=null && positiveMask.getPassword() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" user.password = '"+ positiveMask.getPassword()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getPassword() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" user.password is null ");
        }
        if (positiveMask!=null && positiveMask.getCreateTime() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;
           query.append(" user.createTime = '"+ positiveMask.getCreateTime()+"' ");
        } 
		if (negativeMask!=null && negativeMask.getCreateTime() != null) {
           query.append (getQueryWHERE_AND (isWhereSet));
           isWhereSet = true;   
           query.append(" user.createTime is null ");
        }
	    return query.toString();
    }
 
	
	
    private Logger log = Logger.getLogger(this.getClass());
    
    private SimpleCache simpleCache = new SimpleCache();
    private EntityManager emForRecursiveDao; // dao that needs other dao in a recursive manner not support by spring configuration

    /**
     * generic to move after in superclass
     */
    public UserJPAImpl (EntityManager emForRecursiveDao) {
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
     * Inserts a User entity with cascade of its children
     * @param User user
     */
    public void insertUserWithCascade(User user) {
    	UserJPAImpl userjpaimpl = new UserJPAImpl(getEntityManager());
    	userjpaimpl.insertUserWithCascade(userjpaimpl.getEntityManagerForRecursiveDao(), user);
    }
     
    public void insertUserWithCascade(EntityManager emForRecursiveDao, User user) {
       insertUser(emForRecursiveDao, user);
    }
        
    /**
     * Inserts a list of User entity with cascade of its children
     * @param List<User> users
     */
    public void insertUsersWithCascade(List<User> users) {
       for (User user : users) {
          insertUserWithCascade(user);
       }
    } 
        
    /**
     * lookup User entity User, criteria and max result number
     */
    public List<User> lookupUser(User user, Criteria criteria, Integer numberOfResult, EntityManager em) {
		boolean isWhereSet = false;
        StringBuffer query = new StringBuffer();
        query.append ("SELECT user FROM User user ");
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
    
    public List<User> lookupUser(User user, Criteria criteria, Integer numberOfResult) {
		return lookupUser(user, criteria, numberOfResult, getEntityManager());
    }

    public Integer updateNotNullOnlyUser (User user, Criteria criteria) {
        String queryWhat = getUpdateNotNullOnlyUserQueryChunkPrototype (user);
        StringBuffer query = new StringBuffer (queryWhat);
        boolean isWhereSet = false;
        for (Criterion criterion : criteria.getClauseCriterions()) {
            query.append (getQueryWHERE_AND (isWhereSet));
            isWhereSet = true;   
            query.append(criterion.getExpression());			
        }  
        Query jpaQuery = getEntityManager().createQuery(query.toString());
        isWhereSet = false;
        if (user.getUsername() != null) {
           jpaQuery.setParameter ("username", user.getUsername());
        }   
        if (user.getEmail() != null) {
           jpaQuery.setParameter ("email", user.getEmail());
        }   
        if (user.getPassword() != null) {
           jpaQuery.setParameter ("password", user.getPassword());
        }   
        if (user.getCreateTime() != null) {
           jpaQuery.setParameter ("createTime", user.getCreateTime());
        }   
		return jpaQuery.executeUpdate();
    }
	
	public User affectUser (User user) {
	    return referUser (user, null, false);		    
	}
		
	/**
	 * Assign the first user retrieved corresponding to the user criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no user corresponding in the database. Then user is inserted and returned with its primary key(s). 
	 */
	public User assignUser (User user) {
		return referUser (user, null, true);
	}

	/**
	 * Assign the first user retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no user corresponding in the database. 
	 * Then user is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public User assignUser (User user, User mask) {
		return referUser (user, mask, true);
	}

	public User referUser (User user, User mask, boolean isAssign) {
		user = assignBlankToNull (user);
		if (isAllNull(user))
			return null;
		else {
			List<User> list;
			if (mask==null)
				list = searchPrototypeUser(user);
			else
				list = searchPrototypeUser(mask);
			if (list.isEmpty()) {
			    if (isAssign)
			       insertUser(user);
			    else
				   return null;
			}
			else if (list.size()==1)
				user.copy(list.get(0));
			else 
				//TODO log error
				user.copy(list.get(0));
		}
		return user;		    
	}

   public User assignUserUseCache (User user) {
      return referUserUseCache (user, true);
   }
      		
   public User affectUserUseCache (User user) {
      return referUserUseCache (user, false);
   }
      		
   public User referUserUseCache (User user, boolean isAssign) {
	  String key = getCacheKey(null, user, null, "assignUser");
      User userCache = (User)simpleCache.get(key);
      if (userCache==null) {
         userCache = referUser (user, null, isAssign);
         if (key!=null)
         	simpleCache.put(key, userCache);
      }
      user.copy(userCache);
      return userCache;
   }	

	private String getCacheKey (User userWhat, User positiveUser, User negativeUser, String queryKey) {
	    StringBuffer sb = new StringBuffer();
	    sb.append(queryKey);
	    if (userWhat!=null)
	       sb.append(userWhat.toStringWithParents());
	    if (positiveUser!=null)
	       sb.append(positiveUser.toStringWithParents());
	    if (negativeUser!=null)
	       sb.append(negativeUser.toStringWithParents());
	    return sb.toString();
	}
	
    public User partialLoadWithParentFirstUser(User userWhat, User positiveUser, User negativeUser){
		List <User> list = partialLoadWithParentUser(userWhat, positiveUser, negativeUser);
		return (!list.isEmpty())?(User)list.get(0):null;
    }
    
    public User partialLoadWithParentFirstUserUseCache(User userWhat, User positiveUser, User negativeUser, Boolean useCache){
		List <User> list = partialLoadWithParentUserUseCache(userWhat, positiveUser, negativeUser, useCache);
		return (!list.isEmpty())?(User)list.get(0):null;
    }
	
	public User partialLoadWithParentFirstUserUseCacheOnResult(User userWhat, User positiveUser, User negativeUser, Boolean useCache){
		List <User> list = partialLoadWithParentUserUseCacheOnResult(userWhat, positiveUser, negativeUser, useCache);
		return (!list.isEmpty())?(User)list.get(0):null;
    }
	//
	protected List<User> partialLoadWithParentUser(User userWhat, User positiveUser, User negativeUser, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentUser(userWhat, positiveUser, negativeUser, new QuerySelectInit(), nbOfResult, useCache);
	}	  

	protected List partialLoadWithParentUserQueryResult (User userWhat, User positiveUser, User negativeUser, Integer nbOfResult, Boolean useCache) {
		 return partialLoadWithParentUserQueryResult (userWhat, positiveUser, negativeUser, new QuerySelectInit(), nbOfResult, useCache);
	}	
    
    public List<User> getDistinctUser(User userWhat, User positiveUser, User negativeUser) {
		 return partialLoadWithParentUser(userWhat, positiveUser, negativeUser, new QuerySelectDistinctInit(), null, false);
	}
	
	public List<User> partialLoadWithParentUser(User userWhat, User positiveUser, User negativeUser) {
		 return partialLoadWithParentUser(userWhat, positiveUser, negativeUser, new QuerySelectInit(), null, false);
	}	
  
	public List<User> partialLoadWithParentUserUseCacheOnResult(User userWhat, User positiveUser, User negativeUser, Boolean useCache) {
		String key = getCacheKey(userWhat, positiveUser, negativeUser, "partialLoadWithParentUser");
		List<User> list = (List<User>)simpleCache.get(key);
		if (list==null || list.isEmpty()) {
			list = partialLoadWithParentUser(userWhat, positiveUser, negativeUser);
			if (!list.isEmpty())
			   simpleCache.put(key, list);
		}
		return list;	
	}	

	public List<User> partialLoadWithParentUserUseCache(User userWhat, User positiveUser, User negativeUser, Boolean useCache) {
		String key = getCacheKey(userWhat, positiveUser, negativeUser, "partialLoadWithParentUser");
		List<User> list = (List<User>)simpleCache.get(key);
		if (list==null) {
			list = partialLoadWithParentUser(userWhat, positiveUser, negativeUser);
			simpleCache.put(key, list);
		}
		return list;	
	}	
	
	private List<User> handleLoadWithParentUser(Map beanPath, List list, User userWhat) {
	    return handleLoadWithParentUser(beanPath, list, userWhat, true);  
	}
	
	private List<User> handleLoadWithParentUser(Map beanPath, List list, User userWhat, boolean isHql) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentUserWithOneElementInRow(list, beanPath, userWhat, isHql);
		}
		return handlePartialLoadWithParentUser(list, beanPath, userWhat, isHql);	
	}
	
    	// to set in super class	
	protected void populateUser (User user, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(user, beanPath, value);
	}
	
	protected void populateUserFromSQL (User user, Object value, String beanPath) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	   BeanUtils.populateBeanObject(user, beanPath, value);
	}
    	// to set in super class BEWARE: genericity is only one level!!!!! first level is a copy second level is a reference!!! change to user.clone() instead
	private User cloneUser (User user) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		//return (User) BeanUtils.cloneBeanObject(user);
	   if (user==null) return new User();
	   return user.clone();
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
	
    public List<User> countDistinct (User whatMask, User whereEqCriteria) {
       return partialLoadWithParentUser(whatMask, whereEqCriteria, null, new QuerySelectCountInit("user"), null, false);
    }   
  	
    public Long count(User whereEqCriteria) {
	    return count(null, whereEqCriteria, EntityMatchType.ALL, OperandType.EQUALS, true); 
/*        Query query = getEntityManager().createQuery(getSelectCountPrototype(whereEqCriteria));
        List<Long> list = query.getResultList();
    	if (!list.isEmpty()) {
            return list.get(0);
    	}
    	return 0L;
*/
    }


    public Long count(User whatMask, User whereCriteria, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
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

	protected String countQuery (User user, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
        String what = "SELECT count(*) FROM User user ";
		return findQuery (user, null, what, matchType, operandType, caseSensitivenessType, null);
    }
	

   private List getFirstResultWhereConditionsAre (User user) {
      return partialLoadWithParentUserQueryResult(getDefaultUserWhat(), user, null, 1, false);	
   }
   
   protected User getDefaultUserWhat() {
      User user = new User();
      user.setEmail(new String());
      return user;
   }
   
	public User getFirstUser (User user) {
		if (isAllNull(user))
			return null;
		else {
			List<User> list = searchPrototype (user, 1);
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
    * checks if the User entity exists
    */           
    public boolean existsUser (User user) {
       if (getFirstUser(user)!=null)
          return true;
       return false;  
    }
        
    public boolean existsUserWhereConditionsAre (User user) {
       if (getFirstResultWhereConditionsAre (user).isEmpty())
          return false;
       return true;  
    }

	private int countPartialField (User user) {
	   int cpt = 0;
       if (user.getUsername() != null) {
          cpt++;
       }
       if (user.getEmail() != null) {
          cpt++;
       }
       if (user.getPassword() != null) {
          cpt++;
       }
       if (user.getCreateTime() != null) {
          cpt++;
       }
       return cpt;
	}   

	public List<User> partialLoadWithParentUser(User what, User positiveUser, User negativeUser, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		Map beanPath = new Hashtable();
		List list = partialLoadWithParentUserJPAQueryResult (what, positiveUser, negativeUser, queryWhatInit, beanPath, nbOfResult, useCache);
		return handlePartialLoadWithParentResult(what, list, beanPath);
	}
	
	public List<User> handlePartialLoadWithParentResult(User what, List list, Map beanPath) {
		if (beanPath.size()==1) {
			return handlePartialLoadWithParentUserWithOneElementInRow(list, beanPath, what, true);
		}
		return handlePartialLoadWithParentUser(list, beanPath, what, true);
	}	

	private List partialLoadWithParentUserQueryResult(User userWhat, User positiveUser, User negativeUser, QueryWhatInit queryWhatInit, Integer nbOfResult, Boolean useCache) {
		return partialLoadWithParentUserJPAQueryResult (userWhat, positiveUser, negativeUser, queryWhatInit, new Hashtable(), nbOfResult, useCache);
    }	
  
	private List partialLoadWithParentUserJPAQueryResult(User userWhat, User positiveUser, User negativeUser, QueryWhatInit queryWhatInit, Map beanPath, Integer nbOfResult, Boolean useCache) {
		Query hquery = getPartialLoadWithParentJPAQuery (userWhat, positiveUser, negativeUser, beanPath, queryWhatInit, nbOfResult);
		return hquery.getResultList();
    }	
   /**
    * @returns an JPA Hsql query based on entity User and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPAQuery (User userWhat, User positiveUser, User negativeUser, Map beanPath, QueryWhatInit queryWhatInit, Integer nbOfResult) {
	   Query query = getPartialLoadWithParentJPARawQuery (userWhat, positiveUser, negativeUser, beanPath, queryWhatInit);
	   if (nbOfResult!=null)
	      query.setMaxResults(nbOfResult);
	   return query;
    }
  	
   /**
    * @returns an JPA Raw Hsql query based on entity User and its parents and the maximum number of result
    */
	protected Query getPartialLoadWithParentJPARawQuery (User userWhat, User positiveUser, User negativeUser, Map beanPath, QueryWhatInit queryWhatInit) {
	   return getEntityManager().createQuery(getPartialLoadWithParentRawHsqlQuery (userWhat, positiveUser, negativeUser, beanPath, queryWhatInit));
    }
	
	private List<User> handlePartialLoadWithParentUser(List<Object[]> list, Map<Integer, String> beanPath, User userWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentUser(list, beanPath, userWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentUser, message:"+ex.getMessage());
			return new ArrayList<User>();
		}
    }

	private List<User> handlePartialLoadWithParentUserWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, User userWhat, boolean isJql) {
		try {
			return convertPartialLoadWithParentUserWithOneElementInRow(list, beanPath, userWhat);
		} catch (Exception ex) {
			log.error("Error conversion list from handlePartialLoadWithParentUserWithOneElementInRow, message:"+ex.getMessage());
			return new ArrayList<User>();
		}
    }
    	
	 private List<User> convertPartialLoadWithParentUser(List<Object[]> list, Map<Integer, String> beanPath, User userWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<User> resultList = new ArrayList<User>();
		 for (Object[] row : list) {		
		    User user = cloneUser (userWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populateUser (user, row[(Integer)entry.getKey()], (String)entry.getValue());
		    }
		    resultList.add(user);
		 }
		 return resultList;		
	 }	
    
	 private List<User> convertPartialLoadWithParentUserWithOneElementInRow(List<Object> list, Map<Integer, String> beanPath, User userWhat) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		 List<User> resultList = new ArrayList<User>();
		 for (Object row : list) {		
		    User user = cloneUser (userWhat);
		    Iterator<Entry<Integer, String>> iter = beanPath.entrySet().iterator();	
		    while (iter.hasNext()) {
		       Entry entry = iter.next();
		       populateUser (user, row, (String)entry.getValue());
		    }
		    resultList.add(user);
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
	public String getPartialLoadWithParentRawHsqlQuery (User user, User positiveUser, User negativeUser, Map beanPath, QueryWhatInit queryWhatInit) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentUserQuery (user, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
		Hashtable aliasWhereHt = new Hashtable();
		String where = getPartialLoadWithParentWhereQuery (positiveUser, null, aliasWhatHt, aliasWhereHt, null, null);
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
	public String findPartialLoadWithParentRawHsqlQuery (User whatMask, User criteriaMask, Map beanPath, QueryWhatInit queryWhatInit,  User orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder) {
		Hashtable aliasWhatHt = new Hashtable();
		String what = getPartialLoadWithParentUserQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", queryWhatInit);
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
	public String countPartialLoadWithParentRawHsqlQuery (User whatMask, User criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) {
		Map beanPath = new Hashtable();
		Hashtable aliasWhatHt = new Hashtable();
		// used to initiate the how part of the what
		getPartialLoadWithParentUserQuery (whatMask, null, aliasWhatHt, null, null, beanPath, "", new QuerySelectInit());
		String what = "select count(user) ";
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
    	
	public String findPartialQuery (User whatMask, User criteriaMask, User orderMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType, QuerySortOrder sortOrder, Map beanPath) {
        QueryWhatInit queryWhatInit = new QuerySelectInit();
        return findPartialLoadWithParentRawHsqlQuery(whatMask, criteriaMask, beanPath, queryWhatInit, orderMask, matchType, operandType, caseSensitivenessType,  sortOrder);
    }
	
	/**
    * partial on a single entity load enables to specify the fields you want to load explicitly
    */         
	public List<User> partialLoadUser(User user, User positiveUser, User negativeUser) {
	    Query hquery = getEntityManager().createQuery(getPartialLoadUserQuery (user, positiveUser, negativeUser));
		int countPartialField = countPartialField(user);
		if (countPartialField==0) 
			return new ArrayList<User>();
		List list = hquery.getResultList();
		Iterator iter = list.iterator();
		List<User> returnList = new ArrayList<User>();
		while(iter.hasNext()) {
			int index = 0;
			Object[] row;
			if (countPartialField==1) {
				row = new Object[1];
				row[0] = iter.next();
				} 
			else 
				row = (Object[]) iter.next();
			User userResult = new User();
			if (user.getUsername() != null) {
                userResult.setUsername((String) row[index]);
				index++;
			}
			if (user.getEmail() != null) {
                userResult.setEmail((String) row[index]);
				index++;
			}
			if (user.getPassword() != null) {
                userResult.setPassword((String) row[index]);
				index++;
			}
			if (user.getCreateTime() != null) {
                userResult.setCreateTime((java.util.Date) row[index]);
				index++;
			}
			returnList.add(userResult);
        }
	    return returnList;
	}

	public static String getPartialLoadWithParentWhereQuery (
	   User criteriaMask, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias,
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
	   User user, Boolean isWhereSet, Hashtable aliasHt, Hashtable aliasWhereHt, String childAlias, String childFKAlias) {
	   if (user==null)
	      return "";
	   String alias = null;
	   if (aliasWhereHt == null) {
	      aliasWhereHt = new Hashtable();
	   } 
	   if (isLookedUp(user)){
	      alias = getNextAlias (aliasWhereHt, user);
		  aliasWhereHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (user.getUsername() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".username = '"+ user.getUsername()+"' ");
       }
       if (user.getEmail() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".email = '"+ user.getEmail()+"' ");
       }
       if (user.getPassword() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".password = '"+ user.getPassword()+"' ");
       }
       if (user.getCreateTime() != null) {
           query.append (getQueryBLANK_AND (isWhereSet));
		   isWhereSet = true;
           query.append(" "+alias+".createTime = '"+ user.getCreateTime()+"' ");
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
	
    public static String getPartialLoadWithParentUserQuery (
	   User user, Boolean isWhereSet, Hashtable aliasHt, String childAlias, String childFKAlias, Map beanPath, String rootPath, QueryWhatInit queryWhatInit) {
	   if (user==null)
	      return "";
	   String alias = null;
	   if (aliasHt == null) {
	      aliasHt = new Hashtable();
	   } 
	   if (isLookedUp(user)){
	      alias = getNextAlias (aliasHt, user);
		  aliasHt.put (getAliasKey(alias), getAliasConnection(alias, childAlias, childFKAlias));
	   }
	   if (isWhereSet == null)
          isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (user.getUsername() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"username");
          query.append(" "+alias+".username ");
       }
       if (user.getEmail() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"email");
          query.append(" "+alias+".email ");
       }
       if (user.getPassword() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"password");
          query.append(" "+alias+".password ");
       }
       if (user.getCreateTime() != null) {
          query.append (queryWhatInit.getWhatInit (isWhereSet));
          isWhereSet = true; 
          beanPath.put(beanPath.size(), rootPath+"createTime");
          query.append(" "+alias+".createTime ");
       }
//       query.append(getUserSearchEqualQuery (positiveUser, negativeUser));
	   return query.toString(); 
    }
	
	protected static String getAliasConnection(String existingAlias, String childAlias, String childFKAlias) {
		if (childAlias==null)
		   return "";
		return childAlias+"."+childFKAlias+" = "+existingAlias+"."+"email";
	}
	
	protected static String getAliasKey (String alias) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return "User|"+alias;
	}
	
	protected static String getAliasKeyAlias (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
		return StringUtils.substringAfter(aliasKey, "|");
	}
	
	protected static String getAliasKeyDomain (String aliasKey) {
	  //TODO this is a temporary solution use a dedicated object in BslaHiberateDaoSupport
	  return StringUtils.substringBefore(aliasKey, "|");
	}
	
	protected static String getNextAlias (Hashtable aliasHt, User user) {
		int cptSameAlias = 0;
		Enumeration<String> _keys = aliasHt.keys();
		while (_keys.hasMoreElements()) {
			String _key = _keys.nextElement();
			if (_key.startsWith("user"))
				cptSameAlias++;
		}
		if (cptSameAlias==0)
			return "user";
		else
			return "user_"+cptSameAlias;
	}
	
	
	protected static boolean isLookedUp (User user) {
	   if (user==null)
		  return false;
       if (user.getUsername() != null) {
	      return true;
       }
       if (user.getEmail() != null) {
	      return true;
       }
       if (user.getPassword() != null) {
	      return true;
       }
       if (user.getCreateTime() != null) {
	      return true;
       }
       return false;   
	}
	
    public String getPartialLoadUserQuery(
	   User user, 
	   User positiveUser, 
	   User negativeUser) {
       boolean isWhereSet = false;
       StringBuffer query = new StringBuffer();
       if (user.getUsername() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" username ");
       }
       if (user.getEmail() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" email ");
       }
       if (user.getPassword() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" password ");
       }
       if (user.getCreateTime() != null) {
          query.append (getQuerySelectComma (isWhereSet));
          isWhereSet = true; 
          query.append(" createTime ");
       }
	   query.append(getFromEntity());
       query.append(getUserPositiveNegativeCriteria (positiveUser, negativeUser));
	   return query.toString(); 
    }
	
	public List<User> searchPrototypeWithCacheUser(User user) {
		SimpleCache simpleCache = new SimpleCache();
		List<User> list = (List<User>)simpleCache.get(user.toString());
		if (list==null) {
			list = searchPrototypeUser(user);
			simpleCache.put(user.toString(), list);
		}
		return list;
	}

    public List<User> loadGraph(User graphMaskWhat, List<User> whereMask) {
        return loadGraphOneLevel(graphMaskWhat, whereMask);
    }

	public List<User> loadGraphOneLevel(User graphMaskWhat, List<User> whereMask) {
		//first get roots element from where list mask
		// this brings the level 0 of the graph (root level)
 		graphMaskWhat.setEmail(graphMaskWhat.stringMask__);
		List<User> users = searchPrototypeUser (whereMask);
		// for each sub level perform the search with a subquery then reassemble
		// 1. get all sublevel queries
		// 2. perform queries on the correct dao
		// 3. reassemble
		return getLoadGraphOneLevel (graphMaskWhat, users);
	}

	private List<User> copy(List<User> inputs) {
		List<User> l = new ArrayList<User>();
		for (User input : inputs) {
			User copy = new User();
			copy.copy(input);
			l.add(copy);
		}
		return l;
	}
	   
	private List<User> getLoadGraphOneLevel (User graphMaskWhat, List<User> parents) {
	    return loadGraphFromParentKey (graphMaskWhat, parents);
	} 
	
	public List<User> loadGraphFromParentKey (User graphMaskWhat, List<User> parents) {
		//foreach children:
		//check if not empty take first
		parents = copy (parents); //working with detached entities to avoid unnecessary sql calls
		if (parents==null || parents.isEmpty())
		   return parents;
		List<String> ids = getPk (parents);
		return parents;
	}
	
	private List<String> getPk(List<User> input) {
		List<String> s = new ArrayList<String>();
		for (User t : input) {
			s.add(t.getEmail()+"");
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
	public void find (QueryData<User> data) {
		EntityCriteria<User> filter = data.getEntityCriteria();
		User entityWhat = data.getEntityWhat();
		User criteriaMask = filter.getEntity();
		int start = data.getStart();
		int max = data.getMax();
		EntitySort<User> entitySort = data.getEntitySort();
		QuerySortOrder sortOrder = entitySort.getOrder();
		User sortMask = entitySort.getEntity();	

		List<User> results = find(entityWhat, criteriaMask, sortMask, filter.getMatchType(), filter.getOperandType(), filter.getCaseSensitivenessType(), sortOrder, start, max);
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
     * return a list of User entities 
     */
    public List<User> getList () {
        //first lightweight implementation
        return searchPrototypeUser(new User());
    }
    /**
     * return a list of User entities and sort
     */
    public List<User> getList (User orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(new User(), orderMask, sortOrder, null);
    }
    /**
     * return a list of User entities and sort based on a User prototype
     */
    public List<User> list (User mask, User orderMask, QuerySortOrder sortOrder) {
        return searchPrototype(mask, orderMask, sortOrder, null);
    }

	@Override
    protected String getSelectFrom() {
        return "SELECT user "+getFromEntity();
    }

    protected String getFromEntity() {
        return " FROM User user ";
    }

    @Override
    protected String getQuerySelectFromEntity() {
        return getSelectFrom();
    }
	



}
