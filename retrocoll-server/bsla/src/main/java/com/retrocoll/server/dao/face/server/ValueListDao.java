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


import com.retrocoll.server.domain.server.ValueList;
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
 * <p>Title: ValueListDao</p>
 *
 * <p>Description: Interface of a Data access object dealing with ValueListDao
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching valueList objects</p>
 *
 */
public interface ValueListDao extends GenericDao<ValueList>{

    /**
     * Inserts a ValueList entity ValueList 
     * @param ValueList valueList
     */
    public void insertValueList(ValueList valueList) ;

    /**
     * Updates a ValueList entity 
     * @param ValueList valueList
     */
    public ValueList updateValueList(ValueList valueList) ;

    /**
     * Updates a ValueList entity with only the attributes set into ValueList.
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param ValueList valueList
     */
    public Integer updateNotNullOnlyValueList(ValueList valueList) ;
    
    public Integer updateNotNullOnlyPrototypeValueList(ValueList valueList, ValueList prototypeCriteria);
    
     /**
     * Saves a ValueList entity 
     * @param ValueList valueList
     */
    public void saveValueList(ValueList valueList);
    
    /**
     * Deletes a ValueList entity 
     * @param ValueList valueList
     */
    public void deleteValueList(ValueList valueList) ;
  
    
    /**
     * Loads the ValueList entity which is related to an instance of
     * ValueList
     * @param java.lang.Integer valueId
     * @return ValueList The ValueList entity
     */
     public ValueList loadValueList(java.lang.Integer valueId);   
        
    /**
     * Loads the ValueList entity which is related to an instance of
     * ValueList
     * @param java.lang.Integer ValueId
     * @return ValueList The ValueList entity
     */
    public ValueList loadFullFirstLevelValueList(ValueList valueList);    
     
    /**
     * Loads the ValueList entity which is related to an instance of
     * ValueList and its dependent one to many objects
     * @param java.lang.Integer valueId
     * @return ValueList The ValueList entity
     */
    public ValueList loadFullFirstLevelValueList(java.lang.Integer valueId);       

     
     /**
     * Inserts a ValueList entity with cascade of its children
     * @param ValueList valueList
     */
    public void insertValueListWithCascade(ValueList valueList) ;
    
    /**
     * Inserts a list of ValueList entity with cascade of its children
     * @param List<ValueList> valueLists
     */
    public void insertValueListsWithCascade(List<ValueList> valueLists) ;        
   
    /**
     * lookup ValueList entity ValueList, criteria and max result number
     */
    public List<ValueList> lookupValueList(ValueList valueList, Criteria criteria, Integer numberOfResult);
	
	public Integer updateNotNullOnlyValueList (ValueList valueList, Criteria criteria);

	/**
	 * Affect the first valueList retrieved corresponding to the valueList criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 */
    public ValueList affectValueList (ValueList valueList);
    
    public ValueList affectValueListUseCache (ValueList valueList);
    	
	/**
	 * Assign the first valueList retrieved corresponding to the valueList criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no valueList corresponding in the database. Then valueList is inserted and returned with its primary key(s). 
	 */
    public ValueList assignValueList (ValueList valueList);

	/**
	 * Assign the first valueList retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no valueList corresponding in the database. 
	 * Then valueList is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public ValueList assignValueList (ValueList valueList, ValueList mask);
	
    public ValueList assignValueListUseCache (ValueList valueList);
         
    /**
    * return the first ValueList entity found
    */           
    public ValueList getFirstValueList (ValueList valueList);
    
    /**
    * checks if the ValueList entity exists
    */           
    public boolean existsValueList (ValueList valueList);    
    
    public boolean existsValueListWhereConditionsAre (ValueList valueList);

    /**
    * partial load enables to specify the fields you want to load explicitly
    */            
    public List<ValueList> partialLoadValueList(ValueList valueList, ValueList positiveValueList, ValueList negativeValueList);

    /**
    * partial load with parent entities
    * variation (list, first, distinct decorator)
    * variation2 (with cache)
    */
    public List<ValueList> partialLoadWithParentValueList(ValueList valueList, ValueList positiveValueList, ValueList negativeValueList);

    public List<ValueList> partialLoadWithParentValueListUseCache(ValueList valueList, ValueList positiveValueList, ValueList negativeValueList, Boolean useCache);

    public List<ValueList> partialLoadWithParentValueListUseCacheOnResult(ValueList valueList, ValueList positiveValueList, ValueList negativeValueList, Boolean useCache);

    /**
    * variation first
    */
    public ValueList partialLoadWithParentFirstValueList(ValueList valueListWhat, ValueList positiveValueList, ValueList negativeValueList);
    
    public ValueList partialLoadWithParentFirstValueListUseCache(ValueList valueListWhat, ValueList positiveValueList, ValueList negativeValueList, Boolean useCache);

    public ValueList partialLoadWithParentFirstValueListUseCacheOnResult(ValueList valueListWhat, ValueList positiveValueList, ValueList negativeValueList, Boolean useCache);

    /**
    * variation distinct
    */
    public List<ValueList> getDistinctValueList(ValueList valueListWhat, ValueList positiveValueList, ValueList negativeValueList);


    /**
    * search on prototype with cache
    */
    public List<ValueList> searchPrototypeWithCacheValueList (ValueList valueList);

    public List<ValueList> searchPrototypeValueList(ValueList valueList) ;  
	
    public List<ValueList> searchPrototypeValueList(ValueList positiveMask, ValueList negativeMask) ;  
	
    public List<ValueList> searchPrototypeAnyValueList(ValueList valueList) ;

    public List<ValueList> find (ValueList criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) ;

    /**
     * Searches a list of distinct ValueList entity based on a ValueList mask and a list of ValueList containing ValueList matching criteria
     * @param ValueList valueList
     * @param List<ValueList> valueLists
     * @return List<ValueList>
     */
    public List<ValueList> searchDistinctPrototypeValueList(ValueList valueListMask, List<ValueList> valueLists) ;    

	public List<ValueList> countDistinct (ValueList whatMask, ValueList whereEqCriteria);
	
	public Long count (ValueList whereEqCriteria);
	
	public List<ValueList> loadGraph(ValueList graphMaskWhat, List<ValueList> whereMask);  
	
	public List<ValueList> loadGraphFromParentKey (ValueList graphMaskWhat, List<ValueList> parents); 
	
    /**
     * return a list of ValueList entities 
     */
    public List<ValueList> getList ();
        
    public List<ValueList> getList (ValueList orderMask, QuerySortOrder sortOrder);

    public List<ValueList> list (ValueList mask, ValueList orderMask, QuerySortOrder sortOrder);

	public void find (QueryData<ValueList> data);


}
