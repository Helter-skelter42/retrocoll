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


import com.retrocoll.server.domain.server.Software;
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
 * <p>Title: SoftwareDao</p>
 *
 * <p>Description: Interface of a Data access object dealing with SoftwareDao
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching software objects</p>
 *
 */
public interface SoftwareDao extends GenericDao<Software>{

    /**
     * Inserts a Software entity Software 
     * @param Software software
     */
    public void insertSoftware(Software software) ;

    /**
     * Updates a Software entity 
     * @param Software software
     */
    public Software updateSoftware(Software software) ;

    /**
     * Updates a Software entity with only the attributes set into Software.
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param Software software
     */
    public Integer updateNotNullOnlySoftware(Software software) ;
    
    public Integer updateNotNullOnlyPrototypeSoftware(Software software, Software prototypeCriteria);
    
     /**
     * Saves a Software entity 
     * @param Software software
     */
    public void saveSoftware(Software software);
    
    /**
     * Deletes a Software entity 
     * @param Software software
     */
    public void deleteSoftware(Software software) ;
  
    
    /**
     * Loads the Software entity which is related to an instance of
     * Software
     * @param java.lang.Integer softwareId
     * @return Software The Software entity
     */
     public Software loadSoftware(java.lang.Integer softwareId);   
        
    /**
     * Loads the Software entity which is related to an instance of
     * Software
     * @param java.lang.Integer SoftwareId
     * @return Software The Software entity
     */
    public Software loadFullFirstLevelSoftware(Software software);    
     
    /**
     * Loads the Software entity which is related to an instance of
     * Software and its dependent one to many objects
     * @param java.lang.Integer softwareId
     * @return Software The Software entity
     */
    public Software loadFullFirstLevelSoftware(java.lang.Integer softwareId);       

     
     /**
     * Inserts a Software entity with cascade of its children
     * @param Software software
     */
    public void insertSoftwareWithCascade(Software software) ;
    
    /**
     * Inserts a list of Software entity with cascade of its children
     * @param List<Software> softwares
     */
    public void insertSoftwaresWithCascade(List<Software> softwares) ;        
   
    /**
     * lookup Software entity Software, criteria and max result number
     */
    public List<Software> lookupSoftware(Software software, Criteria criteria, Integer numberOfResult);
	
	public Integer updateNotNullOnlySoftware (Software software, Criteria criteria);

	/**
	 * Affect the first software retrieved corresponding to the software criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 */
    public Software affectSoftware (Software software);
    
    public Software affectSoftwareUseCache (Software software);
    	
	/**
	 * Assign the first software retrieved corresponding to the software criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no software corresponding in the database. Then software is inserted and returned with its primary key(s). 
	 */
    public Software assignSoftware (Software software);

	/**
	 * Assign the first software retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no software corresponding in the database. 
	 * Then software is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public Software assignSoftware (Software software, Software mask);
	
    public Software assignSoftwareUseCache (Software software);
         
    /**
    * return the first Software entity found
    */           
    public Software getFirstSoftware (Software software);
    
    /**
    * checks if the Software entity exists
    */           
    public boolean existsSoftware (Software software);    
    
    public boolean existsSoftwareWhereConditionsAre (Software software);

    /**
    * partial load enables to specify the fields you want to load explicitly
    */            
    public List<Software> partialLoadSoftware(Software software, Software positiveSoftware, Software negativeSoftware);

    /**
    * partial load with parent entities
    * variation (list, first, distinct decorator)
    * variation2 (with cache)
    */
    public List<Software> partialLoadWithParentSoftware(Software software, Software positiveSoftware, Software negativeSoftware);

    public List<Software> partialLoadWithParentSoftwareUseCache(Software software, Software positiveSoftware, Software negativeSoftware, Boolean useCache);

    public List<Software> partialLoadWithParentSoftwareUseCacheOnResult(Software software, Software positiveSoftware, Software negativeSoftware, Boolean useCache);

    /**
    * variation first
    */
    public Software partialLoadWithParentFirstSoftware(Software softwareWhat, Software positiveSoftware, Software negativeSoftware);
    
    public Software partialLoadWithParentFirstSoftwareUseCache(Software softwareWhat, Software positiveSoftware, Software negativeSoftware, Boolean useCache);

    public Software partialLoadWithParentFirstSoftwareUseCacheOnResult(Software softwareWhat, Software positiveSoftware, Software negativeSoftware, Boolean useCache);

    /**
    * variation distinct
    */
    public List<Software> getDistinctSoftware(Software softwareWhat, Software positiveSoftware, Software negativeSoftware);


    /**
    * search on prototype with cache
    */
    public List<Software> searchPrototypeWithCacheSoftware (Software software);

    public List<Software> searchPrototypeSoftware(Software software) ;  
	
    public List<Software> searchPrototypeSoftware(Software positiveMask, Software negativeMask) ;  
	
    public List<Software> searchPrototypeAnySoftware(Software software) ;

    public List<Software> find (Software criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) ;

    /**
     * Searches a list of distinct Software entity based on a Software mask and a list of Software containing Software matching criteria
     * @param Software software
     * @param List<Software> softwares
     * @return List<Software>
     */
    public List<Software> searchDistinctPrototypeSoftware(Software softwareMask, List<Software> softwares) ;    

	public List<Software> countDistinct (Software whatMask, Software whereEqCriteria);
	
	public Long count (Software whereEqCriteria);
	
	public List<Software> loadGraph(Software graphMaskWhat, List<Software> whereMask);  
	
	public List<Software> loadGraphFromParentKey (Software graphMaskWhat, List<Software> parents); 
	
    /**
     * return a list of Software entities 
     */
    public List<Software> getList ();
        
    public List<Software> getList (Software orderMask, QuerySortOrder sortOrder);

    public List<Software> list (Software mask, Software orderMask, QuerySortOrder sortOrder);

	public void find (QueryData<Software> data);


}
