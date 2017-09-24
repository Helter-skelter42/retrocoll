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
	* - name      : DomainEntityJPA2Annotation
	* - file name : DomainEntityJPA2Annotation.vm
	* - time      : 2017/09/16 ap. J.-C. at 19:38:21 CEST
*/
package com.retrocoll.server.domain.server;

//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import net.sf.minuteProject.architecture.bsla.domain.AbstractDomainObject;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * <p>Title: Settings</p>
 *
 * <p>Description: Domain Object describing a Settings entity</p>
 *
 */
@Entity (name="Settings")
@Table (name="\"settings\"")
@NamedQueries ({
	 @NamedQuery(name=Settings.FIND_ALL, query="SELECT a FROM Settings a")
	,@NamedQuery(name=Settings.FIND_BY_VALUE, query="SELECT a FROM Settings a WHERE a.value = :value")
	,@NamedQuery(name=Settings.FIND_BY_VALUE_CONTAINING, query="SELECT a FROM Settings a WHERE a.value like :value")
})
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(namespace="com.retrocoll.server.domain.server", name = "Settings")
@XmlRootElement(namespace="com.retrocoll.server.domain.server")

public class Settings extends AbstractDomainObject {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "Settings.findAll";
    public static final String FIND_BY_VALUE = "Settings.findByValue";
    public static final String FIND_BY_VALUE_CONTAINING ="Settings.findByValueContaining";
	
    @Id @Column(name="NAME" ,length=30) 
    @XmlElement (name="name")
    private String name;

//MP-MANAGED-ADDED-AREA-BEGINNING @VALUE-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @VALUE-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-VALUE@
    @Column(name="VALUE"  , length=150 , nullable=true , unique=false)
    @XmlElement (name="value")
    private String value; 
//MP-MANAGED-UPDATABLE-ENDING

    /**
    * Default constructor
    */
    public Settings() {
    }

	/**
	* All field constructor 
	*/
    public Settings(
       String name,
       String value) {
	 this(
       name,
       value
	 ,true);
	}
    
	public Settings(
       String name,
       String value	
    , boolean setRelationship) {
       //primary keys
       setName (name);
       //attributes
       setValue (value);
       //parents
    }

	public Settings flat() {
	   return new Settings(
          getName(),
          getValue()
       , false
	   );
	}

    /**
    * display semanticReference with attribute inside class
    */
	public String display() {
	  StringBuffer sb = new StringBuffer();
      if (this.getName()!=null)
         sb.append (this.getName() +" " ); 
      if (this.getValue()!=null)
         sb.append (this.getValue() +" " ); 
      return sb.toString();
	}
	
    public String getDisplay() {
		return display();
	}
    /**
    * toString implementation
    */
	public String toString() {
		return toString(this);
	}

	public ToStringBuilder getToStringBuilder(Object object) {
	 	return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("name", name)
            .append("value", value)
	 	;
	} 
		
	public String toString(Object object) {
	 	return getToStringBuilder(object).toString();
	} 
	
	public String toStringWithParents() {
	    ToStringBuilder toStringBuilder = getToStringBuilder(this);
	 	return toStringBuilder.toString();	
	}
	/**
    * hashCode implementation
    */
	public int hashCode() {
		return new HashCodeBuilder(17,31).
                append(display()).
                toHashCode();
	}
	
	public boolean equals(Object object) {
		if (object == null) return false;	
		if (object == this) return true;
		if (!(object instanceof Settings)) return false;
		Settings settings = (Settings) object;
		if (settings.name==null || !settings.name.equals(name)) return false;
		return true;
	}    

	public boolean equalsMask(Object object) {
		if (object == null) return false;	
		if (object == this) return true;
		if (!(object instanceof Settings)) return false;
		Settings settings = (Settings) object;
		if (name!=null && settings.name!=null && !settings.name.equals(name)) return false;
		if ((settings.name!=null && name==null) || (settings.name==null && name!=null)) return false;
		if (value!=null && settings.value!=null && !settings.value.equals(value)) return false;
		if ((settings.value!=null && value==null) || (settings.value==null && value!=null)) return false;
		return true;
	}

	public Settings clone() {
        Settings settings = flat();
        return settings;
	}
	
	public void copy (Settings settings) {
		if (settings!=null) {
			setName (settings.getName());
			setValue (settings.getValue());
		}
	}
	
	public static Settings fullMask() {
		return new Settings(
			stringMask__ ,
			stringMask__ 		);
	}

    public Settings maskString(Map<String, String> filter) {
        for (Entry<String, String> set : filter.entrySet()) {
            mask(set.getKey(), getEntry(set.getKey(), set.getValue()));
        }
        return this;
    }
    
    public Object getEntry(String pattern, String value) {
        if(pattern==null || value==null) return null;
        if ("name".equals(pattern))
           return value;
        if ("value".equals(pattern))
           return value;
        return null;
    }	
				
    public Settings mask(Map<String, Object> filter) {
        for (Entry<String, Object> set : filter.entrySet()) {
            mask(set.getKey(), set.getValue());
        }
        return this;
    }
    
    public Settings mask(String pattern, Object value) {
        if(pattern==null || value==null) return this;
        if ("name".equals(pattern)) {
           setName(value.toString());
		   return this;
		}
        if ("value".equals(pattern)) {
           setValue(value.toString());
		   return this;
		}
        return this;
    }

    public Settings mask(String pattern) {
        if(pattern==null) return this;
        if ("name".equals(pattern))
           setName(stringMask__);
        if ("value".equals(pattern))
           setValue(stringMask__);
        return this;
    }

	public void assignNullToBlank () {
        if (StringUtils.isEmpty(getName()))
           setName(null);
        if (StringUtils.isEmpty(getValue()))
           setValue(null);
	}

    public String getName() {
        return name;
    }
    public void setName (String name) {
        this.name =  name;
    }
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-VALUE@
    public String getValue() {
        return value;
    }
    public void setValue (String value) {
        this.value =  value;
    }
//MP-MANAGED-UPDATABLE-ENDING





//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
