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


import com.retrocoll.server.domain.server.Hardware;
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
 * <p>Title: HardwareDao</p>
 *
 * <p>Description: Interface of a Data access object dealing with HardwareDao
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching hardware objects</p>
 *
 */
public interface HardwareDao extends GenericDao<Hardware>{

    /**
     * Inserts a Hardware entity Hardware 
     * @param Hardware hardware
     */
    public void insertHardware(Hardware hardware) ;

    /**
     * Updates a Hardware entity 
     * @param Hardware hardware
     */
    public Hardware updateHardware(Hardware hardware) ;

    /**
     * Updates a Hardware entity with only the attributes set into Hardware.
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param Hardware hardware
     */
    public Integer updateNotNullOnlyHardware(Hardware hardware) ;
    
    public Integer updateNotNullOnlyPrototypeHardware(Hardware hardware, Hardware prototypeCriteria);
    
     /**
     * Saves a Hardware entity 
     * @param Hardware hardware
     */
    public void saveHardware(Hardware hardware);
    
    /**
     * Deletes a Hardware entity 
     * @param Hardware hardware
     */
    public void deleteHardware(Hardware hardware) ;
  
    
    /**
     * Loads the Hardware entity which is related to an instance of
     * Hardware
     * @param java.lang.Integer hardwareId
     * @return Hardware The Hardware entity
     */
     public Hardware loadHardware(java.lang.Integer hardwareId);   
        
    /**
     * Loads the Hardware entity which is related to an instance of
     * Hardware
     * @param java.lang.Integer HardwareId
     * @return Hardware The Hardware entity
     */
    public Hardware loadFullFirstLevelHardware(Hardware hardware);    
     
    /**
     * Loads the Hardware entity which is related to an instance of
     * Hardware and its dependent one to many objects
     * @param java.lang.Integer hardwareId
     * @return Hardware The Hardware entity
     */
    public Hardware loadFullFirstLevelHardware(java.lang.Integer hardwareId);       

     
     /**
     * Inserts a Hardware entity with cascade of its children
     * @param Hardware hardware
     */
    public void insertHardwareWithCascade(Hardware hardware) ;
    
    /**
     * Inserts a list of Hardware entity with cascade of its children
     * @param List<Hardware> hardwares
     */
    public void insertHardwaresWithCascade(List<Hardware> hardwares) ;        
   
    /**
     * lookup Hardware entity Hardware, criteria and max result number
     */
    public List<Hardware> lookupHardware(Hardware hardware, Criteria criteria, Integer numberOfResult);
	
	public Integer updateNotNullOnlyHardware (Hardware hardware, Criteria criteria);

	/**
	 * Affect the first hardware retrieved corresponding to the hardware criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 */
    public Hardware affectHardware (Hardware hardware);
    
    public Hardware affectHardwareUseCache (Hardware hardware);
    	
	/**
	 * Assign the first hardware retrieved corresponding to the hardware criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no hardware corresponding in the database. Then hardware is inserted and returned with its primary key(s). 
	 */
    public Hardware assignHardware (Hardware hardware);

	/**
	 * Assign the first hardware retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no hardware corresponding in the database. 
	 * Then hardware is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public Hardware assignHardware (Hardware hardware, Hardware mask);
	
    public Hardware assignHardwareUseCache (Hardware hardware);
         
    /**
    * return the first Hardware entity found
    */           
    public Hardware getFirstHardware (Hardware hardware);
    
    /**
    * checks if the Hardware entity exists
    */           
    public boolean existsHardware (Hardware hardware);    
    
    public boolean existsHardwareWhereConditionsAre (Hardware hardware);

    /**
    * partial load enables to specify the fields you want to load explicitly
    */            
    public List<Hardware> partialLoadHardware(Hardware hardware, Hardware positiveHardware, Hardware negativeHardware);

    /**
    * partial load with parent entities
    * variation (list, first, distinct decorator)
    * variation2 (with cache)
    */
    public List<Hardware> partialLoadWithParentHardware(Hardware hardware, Hardware positiveHardware, Hardware negativeHardware);

    public List<Hardware> partialLoadWithParentHardwareUseCache(Hardware hardware, Hardware positiveHardware, Hardware negativeHardware, Boolean useCache);

    public List<Hardware> partialLoadWithParentHardwareUseCacheOnResult(Hardware hardware, Hardware positiveHardware, Hardware negativeHardware, Boolean useCache);

    /**
    * variation first
    */
    public Hardware partialLoadWithParentFirstHardware(Hardware hardwareWhat, Hardware positiveHardware, Hardware negativeHardware);
    
    public Hardware partialLoadWithParentFirstHardwareUseCache(Hardware hardwareWhat, Hardware positiveHardware, Hardware negativeHardware, Boolean useCache);

    public Hardware partialLoadWithParentFirstHardwareUseCacheOnResult(Hardware hardwareWhat, Hardware positiveHardware, Hardware negativeHardware, Boolean useCache);

    /**
    * variation distinct
    */
    public List<Hardware> getDistinctHardware(Hardware hardwareWhat, Hardware positiveHardware, Hardware negativeHardware);


    /**
    * search on prototype with cache
    */
    public List<Hardware> searchPrototypeWithCacheHardware (Hardware hardware);

    public List<Hardware> searchPrototypeHardware(Hardware hardware) ;  
	
    public List<Hardware> searchPrototypeHardware(Hardware positiveMask, Hardware negativeMask) ;  
	
    public List<Hardware> searchPrototypeAnyHardware(Hardware hardware) ;

    public List<Hardware> find (Hardware criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) ;

    /**
     * Searches a list of distinct Hardware entity based on a Hardware mask and a list of Hardware containing Hardware matching criteria
     * @param Hardware hardware
     * @param List<Hardware> hardwares
     * @return List<Hardware>
     */
    public List<Hardware> searchDistinctPrototypeHardware(Hardware hardwareMask, List<Hardware> hardwares) ;    

	public List<Hardware> countDistinct (Hardware whatMask, Hardware whereEqCriteria);
	
	public Long count (Hardware whereEqCriteria);
	
	public List<Hardware> loadGraph(Hardware graphMaskWhat, List<Hardware> whereMask);  
	
	public List<Hardware> loadGraphFromParentKey (Hardware graphMaskWhat, List<Hardware> parents); 
	
    /**
     * return a list of Hardware entities 
     */
    public List<Hardware> getList ();
        
    public List<Hardware> getList (Hardware orderMask, QuerySortOrder sortOrder);

    public List<Hardware> list (Hardware mask, Hardware orderMask, QuerySortOrder sortOrder);

	public void find (QueryData<Hardware> data);


}
