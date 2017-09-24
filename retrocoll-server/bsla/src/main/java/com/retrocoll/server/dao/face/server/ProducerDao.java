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


import com.retrocoll.server.domain.server.Producer;
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
 * <p>Title: ProducerDao</p>
 *
 * <p>Description: Interface of a Data access object dealing with ProducerDao
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching producer objects</p>
 *
 */
public interface ProducerDao extends GenericDao<Producer>{

    /**
     * Inserts a Producer entity Producer 
     * @param Producer producer
     */
    public void insertProducer(Producer producer) ;

    /**
     * Updates a Producer entity 
     * @param Producer producer
     */
    public Producer updateProducer(Producer producer) ;

    /**
     * Updates a Producer entity with only the attributes set into Producer.
     * Remark: The primary keys cannot be update by this methods, nor are the attributes that must be set to null.
     * @param Producer producer
     */
    public Integer updateNotNullOnlyProducer(Producer producer) ;
    
    public Integer updateNotNullOnlyPrototypeProducer(Producer producer, Producer prototypeCriteria);
    
     /**
     * Saves a Producer entity 
     * @param Producer producer
     */
    public void saveProducer(Producer producer);
    
    /**
     * Deletes a Producer entity 
     * @param Producer producer
     */
    public void deleteProducer(Producer producer) ;
  
    
    /**
     * Loads the Producer entity which is related to an instance of
     * Producer
     * @param java.lang.Integer producerId
     * @return Producer The Producer entity
     */
     public Producer loadProducer(java.lang.Integer producerId);   
        
    /**
     * Loads the Producer entity which is related to an instance of
     * Producer
     * @param java.lang.Integer ProducerId
     * @return Producer The Producer entity
     */
    public Producer loadFullFirstLevelProducer(Producer producer);    
     
    /**
     * Loads the Producer entity which is related to an instance of
     * Producer and its dependent one to many objects
     * @param java.lang.Integer producerId
     * @return Producer The Producer entity
     */
    public Producer loadFullFirstLevelProducer(java.lang.Integer producerId);       

     
     /**
     * Inserts a Producer entity with cascade of its children
     * @param Producer producer
     */
    public void insertProducerWithCascade(Producer producer) ;
    
    /**
     * Inserts a list of Producer entity with cascade of its children
     * @param List<Producer> producers
     */
    public void insertProducersWithCascade(List<Producer> producers) ;        
   
    /**
     * lookup Producer entity Producer, criteria and max result number
     */
    public List<Producer> lookupProducer(Producer producer, Criteria criteria, Integer numberOfResult);
	
	public Integer updateNotNullOnlyProducer (Producer producer, Criteria criteria);

	/**
	 * Affect the first producer retrieved corresponding to the producer criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 */
    public Producer affectProducer (Producer producer);
    
    public Producer affectProducerUseCache (Producer producer);
    	
	/**
	 * Assign the first producer retrieved corresponding to the producer criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no producer corresponding in the database. Then producer is inserted and returned with its primary key(s). 
	 */
    public Producer assignProducer (Producer producer);

	/**
	 * Assign the first producer retrieved corresponding to the mask criteria.
	 * Blank criteria are mapped to null.
	 * If no criteria is found, null is returned.
	 * If there is no producer corresponding in the database. 
	 * Then producer is inserted and returned with its primary key(s). 
	 * Mask servers usually to set unique keys or the semantic reference
	 */
    public Producer assignProducer (Producer producer, Producer mask);
	
    public Producer assignProducerUseCache (Producer producer);
         
    /**
    * return the first Producer entity found
    */           
    public Producer getFirstProducer (Producer producer);
    
    /**
    * checks if the Producer entity exists
    */           
    public boolean existsProducer (Producer producer);    
    
    public boolean existsProducerWhereConditionsAre (Producer producer);

    /**
    * partial load enables to specify the fields you want to load explicitly
    */            
    public List<Producer> partialLoadProducer(Producer producer, Producer positiveProducer, Producer negativeProducer);

    /**
    * partial load with parent entities
    * variation (list, first, distinct decorator)
    * variation2 (with cache)
    */
    public List<Producer> partialLoadWithParentProducer(Producer producer, Producer positiveProducer, Producer negativeProducer);

    public List<Producer> partialLoadWithParentProducerUseCache(Producer producer, Producer positiveProducer, Producer negativeProducer, Boolean useCache);

    public List<Producer> partialLoadWithParentProducerUseCacheOnResult(Producer producer, Producer positiveProducer, Producer negativeProducer, Boolean useCache);

    /**
    * variation first
    */
    public Producer partialLoadWithParentFirstProducer(Producer producerWhat, Producer positiveProducer, Producer negativeProducer);
    
    public Producer partialLoadWithParentFirstProducerUseCache(Producer producerWhat, Producer positiveProducer, Producer negativeProducer, Boolean useCache);

    public Producer partialLoadWithParentFirstProducerUseCacheOnResult(Producer producerWhat, Producer positiveProducer, Producer negativeProducer, Boolean useCache);

    /**
    * variation distinct
    */
    public List<Producer> getDistinctProducer(Producer producerWhat, Producer positiveProducer, Producer negativeProducer);


    /**
    * search on prototype with cache
    */
    public List<Producer> searchPrototypeWithCacheProducer (Producer producer);

    public List<Producer> searchPrototypeProducer(Producer producer) ;  
	
    public List<Producer> searchPrototypeProducer(Producer positiveMask, Producer negativeMask) ;  
	
    public List<Producer> searchPrototypeAnyProducer(Producer producer) ;

    public List<Producer> find (Producer criteriaMask, EntityMatchType matchType, OperandType operandType, Boolean caseSensitivenessType) ;

    /**
     * Searches a list of distinct Producer entity based on a Producer mask and a list of Producer containing Producer matching criteria
     * @param Producer producer
     * @param List<Producer> producers
     * @return List<Producer>
     */
    public List<Producer> searchDistinctPrototypeProducer(Producer producerMask, List<Producer> producers) ;    

	public List<Producer> countDistinct (Producer whatMask, Producer whereEqCriteria);
	
	public Long count (Producer whereEqCriteria);
	
	public List<Producer> loadGraph(Producer graphMaskWhat, List<Producer> whereMask);  
	
	public List<Producer> loadGraphFromParentKey (Producer graphMaskWhat, List<Producer> parents); 
	
    /**
     * return a list of Producer entities 
     */
    public List<Producer> getList ();
        
    public List<Producer> getList (Producer orderMask, QuerySortOrder sortOrder);

    public List<Producer> list (Producer mask, Producer orderMask, QuerySortOrder sortOrder);

	public void find (QueryData<Producer> data);


}
