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
	* - name      : DB.API.ModelGenericDaoJpaImpl
	* - file name : DB.API.ModelGenericDaoJpaImpl.vm
	* - time      : 2017/09/16 ap. J.-C. at 19:38:22 CEST
*/
package com.retrocoll.server.dao.impl;

import net.sf.minuteProject.architecture.bsla.domain.AbstractDomainObject;
import net.sf.minuteProject.model.dao.jpa.GenericDaoJpaImpl;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class ServerGenericDaoJpaImpl <T extends AbstractDomainObject> extends GenericDaoJpaImpl<T> {

    @PersistenceContext (unitName = "server")
    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}