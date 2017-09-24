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


import com.retrocoll.server.domain.server.Photo;
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
 * <p>Title: PhotoDao</p>
 *
 * <p>Description: Interface of a Data access object dealing with PhotoDao
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching photo objects</p>
 *
 */
public interface PhotoDao extends GenericDao<Photo>{

    /**
     * Inserts a Photo entity Photo 
     * @param Photo photo
     */
    public void insertPhoto(Photo photo) ;

    /**
     * Updates a Photo entity 
     * @param Photo photo
     */
    public Photo updatePhoto(Photo photo) ;

    /**
     * Updates a Photo entity with only the attributes set into Photo.
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param Photo photo
     */
    public Integer updateNotNullOnlyPhoto(Photo photo) ;
    
    public Integer updateNotNullOnlyPrototypePhoto(Photo photo, Photo prototypeCriteria);
    
     /**
     * Saves a Photo entity 
     * @param Photo photo
     */
    public void savePhoto(Photo photo);
    
    /**
     * Deletes a Photo entity 
     * @param Photo photo
     */
    public void deletePhoto(Photo photo) ;
  
    
    /**
     * Loads the Photo entity which is related to an instance of
     * Photo
     * @param java.lang.Integer photoId
     * @return Photo The Photo entity
     */
     public Photo loadPhoto(java.lang.Integer photoId);   
        
    /**
     * Loads the Photo entity which is related to an instance of
     * Photo
     * @param java.lang.Integer PhotoId
     * @return Photo The Photo entity
     */
    public Photo loadFullFirstLevelPhoto(Photo photo);    
     
    /**
     * Loads the Photo entity which is related to an instance of
     * Photo and its dependent one to many objects
     * @param java.lang.Integer photoId
     * @return Photo The Photo entity
     */
    public Photo loadFullFirstLevelPhoto(java.lang.Integer photoId);       

     
     /**
     * Inserts a Photo entity with cascade of its children
     * @param Photo photo
     */
    public void insertPhotoWithCascade(Photo photo) ;
    
    /**
     * Inserts a list of Photo entity with cascade of its children
     * @param List<Photo> photos
     */
    public void insertPhotosWithCascade(List<Photo> photos) ;        
   
    /**
     * lookup Photo entity Photo, criteria and max result number
     */
    public List<Photo> lookupPhoto(Photo photo, Criteria criteria, Integer numberOfResult);
	
	public Integer updateNotNullOnlyPhoto (Photo photo, Criteria criteria);

	/**
	 * Affect the first photo retrieved corresponding to the photo criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 */
    public Photo affectPhoto (Photo photo);
    
    public Photo affectPhotoUseCache (Photo photo);
    	
	/**
	 * Assign the first photo retrieved corresponding to the photo criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no photo corresponding in the database. Then photo is inserted and returned with its primary key(s). 
	 */
    public Photo assignPhoto (Photo photo);

	/**
	 * Assign the first photo retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no photo corresponding in the database. 
	 * Then photo is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public Photo assignPhoto (Photo photo, Photo mask);
	
    public Photo assignPhotoUseCache (Photo photo);
         
    /**
    * return the first Photo entity found
    */           
    public Photo getFirstPhoto (Photo photo);
    
    /**
    * checks if the Photo entity exists
    */           
    public boolean existsPhoto (Photo photo);    
    
    public boolean existsPhotoWhereConditionsAre (Photo photo);

    /**
    * partial load enables to specify the fields you want to load explicitly
    */            
    public List<Photo> partialLoadPhoto(Photo photo, Photo positivePhoto, Photo negativePhoto);

    /**
    * partial load with parent entities
    * variation (list, first, distinct decorator)
    * variation2 (with cache)
    */
    public List<Photo> partialLoadWithParentPhoto(Photo photo, Photo positivePhoto, Photo negativePhoto);

    public List<Photo> partialLoadWithParentPhotoUseCache(Photo photo, Photo positivePhoto, Photo negativePhoto, Boolean useCache);

    public List<Photo> partialLoadWithParentPhotoUseCacheOnResult(Photo photo, Photo positivePhoto, Photo negativePhoto, Boolean useCache);

    /**
    * variation first
    */
    public Photo partialLoadWithParentFirstPhoto(Photo photoWhat, Photo positivePhoto, Photo negativePhoto);
    
    public Photo partialLoadWithParentFirstPhotoUseCache(Photo photoWhat, Photo positivePhoto, Photo negativePhoto, Boolean useCache);

    public Photo partialLoadWithParentFirstPhotoUseCacheOnResult(Photo photoWhat, Photo positivePhoto, Photo negativePhoto, Boolean useCache);

    /**
    * variation distinct
    */
    public List<Photo> getDistinctPhoto(Photo photoWhat, Photo positivePhoto, Photo negativePhoto);


    /**
    * search on prototype with cache
    */
    public List<Photo> searchPrototypeWithCachePhoto (Photo photo);

    public List<Photo> searchPrototypePhoto(Photo photo) ;  
	
    public List<Photo> searchPrototypePhoto(Photo positiveMask, Photo negativeMask) ;  
	
    public List<Photo> searchPrototypeAnyPhoto(Photo photo) ;

    public List<Photo> find (Photo criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) ;

    /**
     * Searches a list of distinct Photo entity based on a Photo mask and a list of Photo containing Photo matching criteria
     * @param Photo photo
     * @param List<Photo> photos
     * @return List<Photo>
     */
    public List<Photo> searchDistinctPrototypePhoto(Photo photoMask, List<Photo> photos) ;    

	public List<Photo> countDistinct (Photo whatMask, Photo whereEqCriteria);
	
	public Long count (Photo whereEqCriteria);
	
	public List<Photo> loadGraph(Photo graphMaskWhat, List<Photo> whereMask);  
	
	public List<Photo> loadGraphFromParentKey (Photo graphMaskWhat, List<Photo> parents); 
	
    /**
     * return a list of Photo entities 
     */
    public List<Photo> getList ();
        
    public List<Photo> getList (Photo orderMask, QuerySortOrder sortOrder);

    public List<Photo> list (Photo mask, Photo orderMask, QuerySortOrder sortOrder);

	public void find (QueryData<Photo> data);


}
