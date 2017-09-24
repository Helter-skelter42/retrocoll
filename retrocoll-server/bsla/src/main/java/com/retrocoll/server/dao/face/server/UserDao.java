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
	* - name      : BslaDaoInterfaceUML
	* - file name : DB.API.DaoInterface.vm
	* - time      : 2017/09/16 ap. J.-C. at 19:38:22 CEST
*/
package com.retrocoll.server.dao.face.server;


import com.retrocoll.server.domain.server.User;
import java.util.List;
import java.sql.*;
import net.sf.minuteProject.architecture.bsla.bean.criteria.PaginationCriteria;
import net.sf.minuteProject.model.dao.GenericDao;

import net.sf.minuteProject.architecture.filter.data.Criteria;
import net.sf.minuteProject.model.data.criteria.QueryData;
import net.sf.minuteProject.model.data.criteria.constant.QuerySortOrder;
import net.sf.minuteProject.model.data.criteria.constant.EntityMatchType;
import net.sf.minuteProject.model.data.criteria.constant.OperandType;


/**
 *
 * <p>Title: UserDao</p>
 *
 * <p>Description: Interface of a Data access object dealing with UserDao
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching user objects</p>
 *
 */
public interface UserDao extends GenericDao<User>{

    /**
     * Inserts a User entity User 
     * @param User user
     */
    public void insertUser(User user) ;

    /**
     * Updates a User entity 
     * @param User user
     */
    public User updateUser(User user) ;

    /**
     * Updates a User entity with only the attributes set into User.
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param User user
     */
    public Integer updateNotNullOnlyUser(User user) ;
    
    public Integer updateNotNullOnlyPrototypeUser(User user, User prototypeCriteria);
    
     /**
     * Saves a User entity 
     * @param User user
     */
    public void saveUser(User user);
    
    /**
     * Deletes a User entity 
     * @param User user
     */
    public void deleteUser(User user) ;
  
    
    /**
     * Loads the User entity which is related to an instance of
     * User
     * @param java.lang.String email
     * @return User The User entity
     */
     public User loadUser(java.lang.String email);   
        
    /**
     * Loads the User entity which is related to an instance of
     * User
     * @param java.lang.String Email
     * @return User The User entity
     */
    public User loadFullFirstLevelUser(User user);    
     
    /**
     * Loads the User entity which is related to an instance of
     * User and its dependent one to many objects
     * @param java.lang.String email
     * @return User The User entity
     */
    public User loadFullFirstLevelUser(java.lang.String email);       

     
     /**
     * Inserts a User entity with cascade of its children
     * @param User user
     */
    public void insertUserWithCascade(User user) ;
    
    /**
     * Inserts a list of User entity with cascade of its children
     * @param List<User> users
     */
    public void insertUsersWithCascade(List<User> users) ;        
   
    /**
     * lookup User entity User, criteria and max result number
     */
    public List<User> lookupUser(User user, Criteria criteria, Integer numberOfResult);
	
	public Integer updateNotNullOnlyUser (User user, Criteria criteria);

	/**
	 * Affect the first user retrieved corresponding to the user criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 */
    public User affectUser (User user);
    
    public User affectUserUseCache (User user);
    	
	/**
	 * Assign the first user retrieved corresponding to the user criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no user corresponding in the database. Then user is inserted and returned with its primary key(s). 
	 */
    public User assignUser (User user);

	/**
	 * Assign the first user retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no user corresponding in the database. 
	 * Then user is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public User assignUser (User user, User mask);
	
    public User assignUserUseCache (User user);
         
    /**
    * return the first User entity found
    */           
    public User getFirstUser (User user);
    
    /**
    * checks if the User entity exists
    */           
    public boolean existsUser (User user);    
    
    public boolean existsUserWhereConditionsAre (User user);

    /**
    * partial load enables to specify the fields you want to load explicitly
    */            
    public List<User> partialLoadUser(User user, User positiveUser, User negativeUser);

    /**
    * partial load with parent entities
    * variation (list, first, distinct decorator)
    * variation2 (with cache)
    */
    public List<User> partialLoadWithParentUser(User user, User positiveUser, User negativeUser);

    public List<User> partialLoadWithParentUserUseCache(User user, User positiveUser, User negativeUser, Boolean useCache);

    public List<User> partialLoadWithParentUserUseCacheOnResult(User user, User positiveUser, User negativeUser, Boolean useCache);

    /**
    * variation first
    */
    public User partialLoadWithParentFirstUser(User userWhat, User positiveUser, User negativeUser);
    
    public User partialLoadWithParentFirstUserUseCache(User userWhat, User positiveUser, User negativeUser, Boolean useCache);

    public User partialLoadWithParentFirstUserUseCacheOnResult(User userWhat, User positiveUser, User negativeUser, Boolean useCache);

    /**
    * variation distinct
    */
    public List<User> getDistinctUser(User userWhat, User positiveUser, User negativeUser);


    /**
    * search on prototype with cache
    */
    public List<User> searchPrototypeWithCacheUser (User user);

    public List<User> searchPrototypeUser(User user) ;  
	
    public List<User> searchPrototypeUser(User positiveMask, User negativeMask) ;  
	
    public List<User> searchPrototypeAnyUser(User user) ;

    public List<User> find (User criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) ;

    /**
     * Searches a list of distinct User entity based on a User mask and a list of User containing User matching criteria
     * @param User user
     * @param List<User> users
     * @return List<User>
     */
    public List<User> searchDistinctPrototypeUser(User userMask, List<User> users) ;    

	public List<User> countDistinct (User whatMask, User whereEqCriteria);
	
	public Long count (User whereEqCriteria);
	
	public List<User> loadGraph(User graphMaskWhat, List<User> whereMask);  
	
	public List<User> loadGraphFromParentKey (User graphMaskWhat, List<User> parents); 
	
    /**
     * return a list of User entities 
     */
    public List<User> getList ();
        
    public List<User> getList (User orderMask, QuerySortOrder sortOrder);

    public List<User> list (User mask, User orderMask, QuerySortOrder sortOrder);

	public void find (QueryData<User> data);


}
