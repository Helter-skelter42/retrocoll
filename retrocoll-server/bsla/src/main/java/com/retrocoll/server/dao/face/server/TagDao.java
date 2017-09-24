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


import com.retrocoll.server.domain.server.Tag;
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
 * <p>Title: TagDao</p>
 *
 * <p>Description: Interface of a Data access object dealing with TagDao
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching tag objects</p>
 *
 */
public interface TagDao extends GenericDao<Tag>{

    /**
     * Inserts a Tag entity Tag 
     * @param Tag tag
     */
    public void insertTag(Tag tag) ;

    /**
     * Updates a Tag entity 
     * @param Tag tag
     */
    public Tag updateTag(Tag tag) ;

    /**
     * Updates a Tag entity with only the attributes set into Tag.
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param Tag tag
     */
    public Integer updateNotNullOnlyTag(Tag tag) ;
    
    public Integer updateNotNullOnlyPrototypeTag(Tag tag, Tag prototypeCriteria);
    
     /**
     * Saves a Tag entity 
     * @param Tag tag
     */
    public void saveTag(Tag tag);
    
    /**
     * Deletes a Tag entity 
     * @param Tag tag
     */
    public void deleteTag(Tag tag) ;
  
    
    /**
     * Loads the Tag entity which is related to an instance of
     * Tag
     * @param java.lang.Integer tagId
     * @return Tag The Tag entity
     */
     public Tag loadTag(java.lang.Integer tagId);   
        
    /**
     * Loads the Tag entity which is related to an instance of
     * Tag
     * @param java.lang.Integer TagId
     * @return Tag The Tag entity
     */
    public Tag loadFullFirstLevelTag(Tag tag);    
     
    /**
     * Loads the Tag entity which is related to an instance of
     * Tag and its dependent one to many objects
     * @param java.lang.Integer tagId
     * @return Tag The Tag entity
     */
    public Tag loadFullFirstLevelTag(java.lang.Integer tagId);       

     
     /**
     * Inserts a Tag entity with cascade of its children
     * @param Tag tag
     */
    public void insertTagWithCascade(Tag tag) ;
    
    /**
     * Inserts a list of Tag entity with cascade of its children
     * @param List<Tag> tags
     */
    public void insertTagsWithCascade(List<Tag> tags) ;        
   
    /**
     * lookup Tag entity Tag, criteria and max result number
     */
    public List<Tag> lookupTag(Tag tag, Criteria criteria, Integer numberOfResult);
	
	public Integer updateNotNullOnlyTag (Tag tag, Criteria criteria);

	/**
	 * Affect the first tag retrieved corresponding to the tag criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 */
    public Tag affectTag (Tag tag);
    
    public Tag affectTagUseCache (Tag tag);
    	
	/**
	 * Assign the first tag retrieved corresponding to the tag criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no tag corresponding in the database. Then tag is inserted and returned with its primary key(s). 
	 */
    public Tag assignTag (Tag tag);

	/**
	 * Assign the first tag retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no tag corresponding in the database. 
	 * Then tag is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public Tag assignTag (Tag tag, Tag mask);
	
    public Tag assignTagUseCache (Tag tag);
         
    /**
    * return the first Tag entity found
    */           
    public Tag getFirstTag (Tag tag);
    
    /**
    * checks if the Tag entity exists
    */           
    public boolean existsTag (Tag tag);    
    
    public boolean existsTagWhereConditionsAre (Tag tag);

    /**
    * partial load enables to specify the fields you want to load explicitly
    */            
    public List<Tag> partialLoadTag(Tag tag, Tag positiveTag, Tag negativeTag);

    /**
    * partial load with parent entities
    * variation (list, first, distinct decorator)
    * variation2 (with cache)
    */
    public List<Tag> partialLoadWithParentTag(Tag tag, Tag positiveTag, Tag negativeTag);

    public List<Tag> partialLoadWithParentTagUseCache(Tag tag, Tag positiveTag, Tag negativeTag, Boolean useCache);

    public List<Tag> partialLoadWithParentTagUseCacheOnResult(Tag tag, Tag positiveTag, Tag negativeTag, Boolean useCache);

    /**
    * variation first
    */
    public Tag partialLoadWithParentFirstTag(Tag tagWhat, Tag positiveTag, Tag negativeTag);
    
    public Tag partialLoadWithParentFirstTagUseCache(Tag tagWhat, Tag positiveTag, Tag negativeTag, Boolean useCache);

    public Tag partialLoadWithParentFirstTagUseCacheOnResult(Tag tagWhat, Tag positiveTag, Tag negativeTag, Boolean useCache);

    /**
    * variation distinct
    */
    public List<Tag> getDistinctTag(Tag tagWhat, Tag positiveTag, Tag negativeTag);


    /**
    * search on prototype with cache
    */
    public List<Tag> searchPrototypeWithCacheTag (Tag tag);

    public List<Tag> searchPrototypeTag(Tag tag) ;  
	
    public List<Tag> searchPrototypeTag(Tag positiveMask, Tag negativeMask) ;  
	
    public List<Tag> searchPrototypeAnyTag(Tag tag) ;

    public List<Tag> find (Tag criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) ;

    /**
     * Searches a list of distinct Tag entity based on a Tag mask and a list of Tag containing Tag matching criteria
     * @param Tag tag
     * @param List<Tag> tags
     * @return List<Tag>
     */
    public List<Tag> searchDistinctPrototypeTag(Tag tagMask, List<Tag> tags) ;    

	public List<Tag> countDistinct (Tag whatMask, Tag whereEqCriteria);
	
	public Long count (Tag whereEqCriteria);
	
	public List<Tag> loadGraph(Tag graphMaskWhat, List<Tag> whereMask);  
	
	public List<Tag> loadGraphFromParentKey (Tag graphMaskWhat, List<Tag> parents); 
	
    /**
     * return a list of Tag entities 
     */
    public List<Tag> getList ();
        
    public List<Tag> getList (Tag orderMask, QuerySortOrder sortOrder);

    public List<Tag> list (Tag mask, Tag orderMask, QuerySortOrder sortOrder);

	public void find (QueryData<Tag> data);


}
