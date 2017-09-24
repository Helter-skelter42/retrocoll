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


import com.retrocoll.server.domain.server.Settings;
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
 * <p>Title: SettingsDao</p>
 *
 * <p>Description: Interface of a Data access object dealing with SettingsDao
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching settings objects</p>
 *
 */
public interface SettingsDao extends GenericDao<Settings>{

    /**
     * Inserts a Settings entity Settings 
     * @param Settings settings
     */
    public void insertSettings(Settings settings) ;

    /**
     * Updates a Settings entity 
     * @param Settings settings
     */
    public Settings updateSettings(Settings settings) ;

    /**
     * Updates a Settings entity with only the attributes set into Settings.
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param Settings settings
     */
    public Integer updateNotNullOnlySettings(Settings settings) ;
    
    public Integer updateNotNullOnlyPrototypeSettings(Settings settings, Settings prototypeCriteria);
    
     /**
     * Saves a Settings entity 
     * @param Settings settings
     */
    public void saveSettings(Settings settings);
    
    /**
     * Deletes a Settings entity 
     * @param Settings settings
     */
    public void deleteSettings(Settings settings) ;
  
    
    /**
     * Loads the Settings entity which is related to an instance of
     * Settings
     * @param java.lang.String name
     * @return Settings The Settings entity
     */
     public Settings loadSettings(java.lang.String name);   
        
    /**
     * Loads the Settings entity which is related to an instance of
     * Settings
     * @param java.lang.String Name
     * @return Settings The Settings entity
     */
    public Settings loadFullFirstLevelSettings(Settings settings);    
     
    /**
     * Loads the Settings entity which is related to an instance of
     * Settings and its dependent one to many objects
     * @param java.lang.String name
     * @return Settings The Settings entity
     */
    public Settings loadFullFirstLevelSettings(java.lang.String name);       

     
     /**
     * Inserts a Settings entity with cascade of its children
     * @param Settings settings
     */
    public void insertSettingsWithCascade(Settings settings) ;
    
    /**
     * Inserts a list of Settings entity with cascade of its children
     * @param List<Settings> settingss
     */
    public void insertSettingssWithCascade(List<Settings> settingss) ;        
   
    /**
     * lookup Settings entity Settings, criteria and max result number
     */
    public List<Settings> lookupSettings(Settings settings, Criteria criteria, Integer numberOfResult);
	
	public Integer updateNotNullOnlySettings (Settings settings, Criteria criteria);

	/**
	 * Affect the first settings retrieved corresponding to the settings criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 */
    public Settings affectSettings (Settings settings);
    
    public Settings affectSettingsUseCache (Settings settings);
    	
	/**
	 * Assign the first settings retrieved corresponding to the settings criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no settings corresponding in the database. Then settings is inserted and returned with its primary key(s). 
	 */
    public Settings assignSettings (Settings settings);

	/**
	 * Assign the first settings retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no settings corresponding in the database. 
	 * Then settings is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public Settings assignSettings (Settings settings, Settings mask);
	
    public Settings assignSettingsUseCache (Settings settings);
         
    /**
    * return the first Settings entity found
    */           
    public Settings getFirstSettings (Settings settings);
    
    /**
    * checks if the Settings entity exists
    */           
    public boolean existsSettings (Settings settings);    
    
    public boolean existsSettingsWhereConditionsAre (Settings settings);

    /**
    * partial load enables to specify the fields you want to load explicitly
    */            
    public List<Settings> partialLoadSettings(Settings settings, Settings positiveSettings, Settings negativeSettings);

    /**
    * partial load with parent entities
    * variation (list, first, distinct decorator)
    * variation2 (with cache)
    */
    public List<Settings> partialLoadWithParentSettings(Settings settings, Settings positiveSettings, Settings negativeSettings);

    public List<Settings> partialLoadWithParentSettingsUseCache(Settings settings, Settings positiveSettings, Settings negativeSettings, Boolean useCache);

    public List<Settings> partialLoadWithParentSettingsUseCacheOnResult(Settings settings, Settings positiveSettings, Settings negativeSettings, Boolean useCache);

    /**
    * variation first
    */
    public Settings partialLoadWithParentFirstSettings(Settings settingsWhat, Settings positiveSettings, Settings negativeSettings);
    
    public Settings partialLoadWithParentFirstSettingsUseCache(Settings settingsWhat, Settings positiveSettings, Settings negativeSettings, Boolean useCache);

    public Settings partialLoadWithParentFirstSettingsUseCacheOnResult(Settings settingsWhat, Settings positiveSettings, Settings negativeSettings, Boolean useCache);

    /**
    * variation distinct
    */
    public List<Settings> getDistinctSettings(Settings settingsWhat, Settings positiveSettings, Settings negativeSettings);


    /**
    * search on prototype with cache
    */
    public List<Settings> searchPrototypeWithCacheSettings (Settings settings);

    public List<Settings> searchPrototypeSettings(Settings settings) ;  
	
    public List<Settings> searchPrototypeSettings(Settings positiveMask, Settings negativeMask) ;  
	
    public List<Settings> searchPrototypeAnySettings(Settings settings) ;

    public List<Settings> find (Settings criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) ;

    /**
     * Searches a list of distinct Settings entity based on a Settings mask and a list of Settings containing Settings matching criteria
     * @param Settings settings
     * @param List<Settings> settingss
     * @return List<Settings>
     */
    public List<Settings> searchDistinctPrototypeSettings(Settings settingsMask, List<Settings> settingss) ;    

	public List<Settings> countDistinct (Settings whatMask, Settings whereEqCriteria);
	
	public Long count (Settings whereEqCriteria);
	
	public List<Settings> loadGraph(Settings graphMaskWhat, List<Settings> whereMask);  
	
	public List<Settings> loadGraphFromParentKey (Settings graphMaskWhat, List<Settings> parents); 
	
    /**
     * return a list of Settings entities 
     */
    public List<Settings> getList ();
        
    public List<Settings> getList (Settings orderMask, QuerySortOrder sortOrder);

    public List<Settings> list (Settings mask, Settings orderMask, QuerySortOrder sortOrder);

	public void find (QueryData<Settings> data);


}
