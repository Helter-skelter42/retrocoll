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


import com.retrocoll.server.domain.server.Accessorie;
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
 * <p>Title: AccessorieDao</p>
 *
 * <p>Description: Interface of a Data access object dealing with AccessorieDao
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching accessorie objects</p>
 *
 */
public interface AccessorieDao extends GenericDao<Accessorie>{

    /**
     * Inserts a Accessorie entity Accessorie 
     * @param Accessorie accessorie
     */
    public void insertAccessorie(Accessorie accessorie) ;

    /**
     * Updates a Accessorie entity 
     * @param Accessorie accessorie
     */
    public Accessorie updateAccessorie(Accessorie accessorie) ;

    /**
     * Updates a Accessorie entity with only the attributes set into Accessorie.
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param Accessorie accessorie
     */
    public Integer updateNotNullOnlyAccessorie(Accessorie accessorie) ;
    
    public Integer updateNotNullOnlyPrototypeAccessorie(Accessorie accessorie, Accessorie prototypeCriteria);
    
     /**
     * Saves a Accessorie entity 
     * @param Accessorie accessorie
     */
    public void saveAccessorie(Accessorie accessorie);
    
    /**
     * Deletes a Accessorie entity 
     * @param Accessorie accessorie
     */
    public void deleteAccessorie(Accessorie accessorie) ;
  
    
    /**
     * Loads the Accessorie entity which is related to an instance of
     * Accessorie
     * @param java.lang.Integer accessorieId
     * @return Accessorie The Accessorie entity
     */
     public Accessorie loadAccessorie(java.lang.Integer accessorieId);   
        
    /**
     * Loads the Accessorie entity which is related to an instance of
     * Accessorie
     * @param java.lang.Integer AccessorieId
     * @return Accessorie The Accessorie entity
     */
    public Accessorie loadFullFirstLevelAccessorie(Accessorie accessorie);    
     
    /**
     * Loads the Accessorie entity which is related to an instance of
     * Accessorie and its dependent one to many objects
     * @param java.lang.Integer accessorieId
     * @return Accessorie The Accessorie entity
     */
    public Accessorie loadFullFirstLevelAccessorie(java.lang.Integer accessorieId);       

     
     /**
     * Inserts a Accessorie entity with cascade of its children
     * @param Accessorie accessorie
     */
    public void insertAccessorieWithCascade(Accessorie accessorie) ;
    
    /**
     * Inserts a list of Accessorie entity with cascade of its children
     * @param List<Accessorie> accessories
     */
    public void insertAccessoriesWithCascade(List<Accessorie> accessories) ;        
   
    /**
     * lookup Accessorie entity Accessorie, criteria and max result number
     */
    public List<Accessorie> lookupAccessorie(Accessorie accessorie, Criteria criteria, Integer numberOfResult);
	
	public Integer updateNotNullOnlyAccessorie (Accessorie accessorie, Criteria criteria);

	/**
	 * Affect the first accessorie retrieved corresponding to the accessorie criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 */
    public Accessorie affectAccessorie (Accessorie accessorie);
    
    public Accessorie affectAccessorieUseCache (Accessorie accessorie);
    	
	/**
	 * Assign the first accessorie retrieved corresponding to the accessorie criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no accessorie corresponding in the database. Then accessorie is inserted and returned with its primary key(s). 
	 */
    public Accessorie assignAccessorie (Accessorie accessorie);

	/**
	 * Assign the first accessorie retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no accessorie corresponding in the database. 
	 * Then accessorie is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public Accessorie assignAccessorie (Accessorie accessorie, Accessorie mask);
	
    public Accessorie assignAccessorieUseCache (Accessorie accessorie);
         
    /**
    * return the first Accessorie entity found
    */           
    public Accessorie getFirstAccessorie (Accessorie accessorie);
    
    /**
    * checks if the Accessorie entity exists
    */           
    public boolean existsAccessorie (Accessorie accessorie);    
    
    public boolean existsAccessorieWhereConditionsAre (Accessorie accessorie);

    /**
    * partial load enables to specify the fields you want to load explicitly
    */            
    public List<Accessorie> partialLoadAccessorie(Accessorie accessorie, Accessorie positiveAccessorie, Accessorie negativeAccessorie);

    /**
    * partial load with parent entities
    * variation (list, first, distinct decorator)
    * variation2 (with cache)
    */
    public List<Accessorie> partialLoadWithParentAccessorie(Accessorie accessorie, Accessorie positiveAccessorie, Accessorie negativeAccessorie);

    public List<Accessorie> partialLoadWithParentAccessorieUseCache(Accessorie accessorie, Accessorie positiveAccessorie, Accessorie negativeAccessorie, Boolean useCache);

    public List<Accessorie> partialLoadWithParentAccessorieUseCacheOnResult(Accessorie accessorie, Accessorie positiveAccessorie, Accessorie negativeAccessorie, Boolean useCache);

    /**
    * variation first
    */
    public Accessorie partialLoadWithParentFirstAccessorie(Accessorie accessorieWhat, Accessorie positiveAccessorie, Accessorie negativeAccessorie);
    
    public Accessorie partialLoadWithParentFirstAccessorieUseCache(Accessorie accessorieWhat, Accessorie positiveAccessorie, Accessorie negativeAccessorie, Boolean useCache);

    public Accessorie partialLoadWithParentFirstAccessorieUseCacheOnResult(Accessorie accessorieWhat, Accessorie positiveAccessorie, Accessorie negativeAccessorie, Boolean useCache);

    /**
    * variation distinct
    */
    public List<Accessorie> getDistinctAccessorie(Accessorie accessorieWhat, Accessorie positiveAccessorie, Accessorie negativeAccessorie);


    /**
    * search on prototype with cache
    */
    public List<Accessorie> searchPrototypeWithCacheAccessorie (Accessorie accessorie);

    public List<Accessorie> searchPrototypeAccessorie(Accessorie accessorie) ;  
	
    public List<Accessorie> searchPrototypeAccessorie(Accessorie positiveMask, Accessorie negativeMask) ;  
	
    public List<Accessorie> searchPrototypeAnyAccessorie(Accessorie accessorie) ;

    public List<Accessorie> find (Accessorie criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) ;

    /**
     * Searches a list of distinct Accessorie entity based on a Accessorie mask and a list of Accessorie containing Accessorie matching criteria
     * @param Accessorie accessorie
     * @param List<Accessorie> accessories
     * @return List<Accessorie>
     */
    public List<Accessorie> searchDistinctPrototypeAccessorie(Accessorie accessorieMask, List<Accessorie> accessories) ;    

	public List<Accessorie> countDistinct (Accessorie whatMask, Accessorie whereEqCriteria);
	
	public Long count (Accessorie whereEqCriteria);
	
	public List<Accessorie> loadGraph(Accessorie graphMaskWhat, List<Accessorie> whereMask);  
	
	public List<Accessorie> loadGraphFromParentKey (Accessorie graphMaskWhat, List<Accessorie> parents); 
	
    /**
     * return a list of Accessorie entities 
     */
    public List<Accessorie> getList ();
        
    public List<Accessorie> getList (Accessorie orderMask, QuerySortOrder sortOrder);

    public List<Accessorie> list (Accessorie mask, Accessorie orderMask, QuerySortOrder sortOrder);

	public void find (QueryData<Accessorie> data);


}
