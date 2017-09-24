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


import com.retrocoll.server.domain.server.Location;
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
 * <p>Title: LocationDao</p>
 *
 * <p>Description: Interface of a Data access object dealing with LocationDao
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching location objects</p>
 *
 */
public interface LocationDao extends GenericDao<Location>{

    /**
     * Inserts a Location entity Location 
     * @param Location location
     */
    public void insertLocation(Location location) ;

    /**
     * Updates a Location entity 
     * @param Location location
     */
    public Location updateLocation(Location location) ;

    /**
     * Updates a Location entity with only the attributes set into Location.
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param Location location
     */
    public Integer updateNotNullOnlyLocation(Location location) ;
    
    public Integer updateNotNullOnlyPrototypeLocation(Location location, Location prototypeCriteria);
    
     /**
     * Saves a Location entity 
     * @param Location location
     */
    public void saveLocation(Location location);
    
    /**
     * Deletes a Location entity 
     * @param Location location
     */
    public void deleteLocation(Location location) ;
  
    
    /**
     * Loads the Location entity which is related to an instance of
     * Location
     * @param java.lang.Integer locationId
     * @return Location The Location entity
     */
     public Location loadLocation(java.lang.Integer locationId);   
        
    /**
     * Loads the Location entity which is related to an instance of
     * Location
     * @param java.lang.Integer LocationId
     * @return Location The Location entity
     */
    public Location loadFullFirstLevelLocation(Location location);    
     
    /**
     * Loads the Location entity which is related to an instance of
     * Location and its dependent one to many objects
     * @param java.lang.Integer locationId
     * @return Location The Location entity
     */
    public Location loadFullFirstLevelLocation(java.lang.Integer locationId);       

     
     /**
     * Inserts a Location entity with cascade of its children
     * @param Location location
     */
    public void insertLocationWithCascade(Location location) ;
    
    /**
     * Inserts a list of Location entity with cascade of its children
     * @param List<Location> locations
     */
    public void insertLocationsWithCascade(List<Location> locations) ;        
   
    /**
     * lookup Location entity Location, criteria and max result number
     */
    public List<Location> lookupLocation(Location location, Criteria criteria, Integer numberOfResult);
	
	public Integer updateNotNullOnlyLocation (Location location, Criteria criteria);

	/**
	 * Affect the first location retrieved corresponding to the location criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 */
    public Location affectLocation (Location location);
    
    public Location affectLocationUseCache (Location location);
    	
	/**
	 * Assign the first location retrieved corresponding to the location criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no location corresponding in the database. Then location is inserted and returned with its primary key(s). 
	 */
    public Location assignLocation (Location location);

	/**
	 * Assign the first location retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no location corresponding in the database. 
	 * Then location is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public Location assignLocation (Location location, Location mask);
	
    public Location assignLocationUseCache (Location location);
         
    /**
    * return the first Location entity found
    */           
    public Location getFirstLocation (Location location);
    
    /**
    * checks if the Location entity exists
    */           
    public boolean existsLocation (Location location);    
    
    public boolean existsLocationWhereConditionsAre (Location location);

    /**
    * partial load enables to specify the fields you want to load explicitly
    */            
    public List<Location> partialLoadLocation(Location location, Location positiveLocation, Location negativeLocation);

    /**
    * partial load with parent entities
    * variation (list, first, distinct decorator)
    * variation2 (with cache)
    */
    public List<Location> partialLoadWithParentLocation(Location location, Location positiveLocation, Location negativeLocation);

    public List<Location> partialLoadWithParentLocationUseCache(Location location, Location positiveLocation, Location negativeLocation, Boolean useCache);

    public List<Location> partialLoadWithParentLocationUseCacheOnResult(Location location, Location positiveLocation, Location negativeLocation, Boolean useCache);

    /**
    * variation first
    */
    public Location partialLoadWithParentFirstLocation(Location locationWhat, Location positiveLocation, Location negativeLocation);
    
    public Location partialLoadWithParentFirstLocationUseCache(Location locationWhat, Location positiveLocation, Location negativeLocation, Boolean useCache);

    public Location partialLoadWithParentFirstLocationUseCacheOnResult(Location locationWhat, Location positiveLocation, Location negativeLocation, Boolean useCache);

    /**
    * variation distinct
    */
    public List<Location> getDistinctLocation(Location locationWhat, Location positiveLocation, Location negativeLocation);


    /**
    * search on prototype with cache
    */
    public List<Location> searchPrototypeWithCacheLocation (Location location);

    public List<Location> searchPrototypeLocation(Location location) ;  
	
    public List<Location> searchPrototypeLocation(Location positiveMask, Location negativeMask) ;  
	
    public List<Location> searchPrototypeAnyLocation(Location location) ;

    public List<Location> find (Location criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) ;

    /**
     * Searches a list of distinct Location entity based on a Location mask and a list of Location containing Location matching criteria
     * @param Location location
     * @param List<Location> locations
     * @return List<Location>
     */
    public List<Location> searchDistinctPrototypeLocation(Location locationMask, List<Location> locations) ;    

	public List<Location> countDistinct (Location whatMask, Location whereEqCriteria);
	
	public Long count (Location whereEqCriteria);
	
	public List<Location> loadGraph(Location graphMaskWhat, List<Location> whereMask);  
	
	public List<Location> loadGraphFromParentKey (Location graphMaskWhat, List<Location> parents); 
	
    /**
     * return a list of Location entities 
     */
    public List<Location> getList ();
        
    public List<Location> getList (Location orderMask, QuerySortOrder sortOrder);

    public List<Location> list (Location mask, Location orderMask, QuerySortOrder sortOrder);

	public void find (QueryData<Location> data);


}
