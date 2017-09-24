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
	* - name      : DomainEntityJPA2EmbeddedId
	* - file name : DomainEntityJPA2EmbeddedId.vm
	* - time      : 2017/09/16 ap. J.-C. at 19:38:22 CEST
*/
package com.retrocoll.server.domain.server;

import java.io.*;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;

/**
 *
 * <p>Title: TagId</p>
 *
 * <p>Description: Embedded Id describing a TagId entity primary key</p>
 *
 */
@Embeddable
public class TagId implements Serializable {


    @Column(name="TAG_ID"  ,nullable=false)
    private Integer tagId;

    @Column(name="NAME" ,length=45 ,nullable=false)
    private String name;

	public Integer getTagId() {
        return tagId;
    }
	
    public void setTagId (Integer tagId) {
        this.tagId = tagId;
    }

	public String getName() {
        return name;
    }
	
    public void setName (String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        return obj.toString().equals(this.toString());
    }
 
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
 
    @Override
    public String toString() {
        return "TagId:" 
        + ":" + tagId
        + ":" + name
        ;
    }
    
}
