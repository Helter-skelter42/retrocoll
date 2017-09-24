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
import com.retrocoll.server.domain.server.Accessorie;
import com.retrocoll.server.domain.server.Accessorie;
import com.retrocoll.server.domain.server.Hardware;
import com.retrocoll.server.domain.server.Hardware;
import com.retrocoll.server.domain.server.Software;
import com.retrocoll.server.domain.server.Software;
import com.retrocoll.server.domain.server.Software;

/**
 *
 * <p>Title: ValueList</p>
 *
 * <p>Description: Domain Object describing a ValueList entity</p>
 *
 */
@Entity (name="ValueList")
@Table (name="\"value_list\"")
@NamedQueries ({
	 @NamedQuery(name=ValueList.FIND_ALL, query="SELECT a FROM ValueList a")
	,@NamedQuery(name=ValueList.FIND_BY_NAME, query="SELECT a FROM ValueList a WHERE a.name = :name")
	,@NamedQuery(name=ValueList.FIND_BY_NAME_CONTAINING, query="SELECT a FROM ValueList a WHERE a.name like :name")
	,@NamedQuery(name=ValueList.FIND_BY_GROUP, query="SELECT a FROM ValueList a WHERE a.group = :group")
	,@NamedQuery(name=ValueList.FIND_BY_GROUP_CONTAINING, query="SELECT a FROM ValueList a WHERE a.group like :group")
})
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(namespace="com.retrocoll.server.domain.server", name = "ValueList")
@XmlRootElement(namespace="com.retrocoll.server.domain.server")

public class ValueList extends AbstractDomainObject {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "ValueList.findAll";
    public static final String FIND_BY_NAME = "ValueList.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="ValueList.findByNameContaining";
    public static final String FIND_BY_GROUP = "ValueList.findByGroup";
    public static final String FIND_BY_GROUP_CONTAINING ="ValueList.findByGroupContaining";
	
    @Id @Column(name="VALUE_ID" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement (name="value-id")
    private Integer valueId;

//MP-MANAGED-ADDED-AREA-BEGINNING @NAME-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @NAME-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-NAME@
    @Column(name="NAME"  , length=45 , nullable=false , unique=false)
    @XmlElement (name="name")
    private String name; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @GROUP-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @GROUP-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-GROUP@
    @Column(name="GROUP"  , length=45 , nullable=false , unique=false)
    @XmlElement (name="group")
    private String group; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @accessorieValueListViaColor-field-value_list@
    @XmlElement (name="accessorievaluelistviacolor")
    @OneToMany (targetEntity=com.retrocoll.server.domain.server.Accessorie.class, fetch=FetchType.LAZY, mappedBy="color", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Accessorie> accessorieValueListViaColor = new HashSet<Accessorie>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @accessorieValueListViaRegion-field-value_list@
    @XmlElement (name="accessorievaluelistviaregion")
    @OneToMany (targetEntity=com.retrocoll.server.domain.server.Accessorie.class, fetch=FetchType.LAZY, mappedBy="region", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Accessorie> accessorieValueListViaRegion = new HashSet<Accessorie>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @hardwareValueListViaColor-field-value_list@
    @XmlElement (name="hardwarevaluelistviacolor")
    @OneToMany (targetEntity=com.retrocoll.server.domain.server.Hardware.class, fetch=FetchType.LAZY, mappedBy="color", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Hardware> hardwareValueListViaColor = new HashSet<Hardware>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @hardwareValueListViaRegion-field-value_list@
    @XmlElement (name="hardwarevaluelistviaregion")
    @OneToMany (targetEntity=com.retrocoll.server.domain.server.Hardware.class, fetch=FetchType.LAZY, mappedBy="region", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Hardware> hardwareValueListViaRegion = new HashSet<Hardware>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @softwareValueListViaConsole-field-value_list@
    @XmlElement (name="softwarevaluelistviaconsole")
    @OneToMany (targetEntity=com.retrocoll.server.domain.server.Software.class, fetch=FetchType.LAZY, mappedBy="console", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Software> softwareValueListViaConsole = new HashSet<Software>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @softwareValueListViaRegion-field-value_list@
    @XmlElement (name="softwarevaluelistviaregion")
    @OneToMany (targetEntity=com.retrocoll.server.domain.server.Software.class, fetch=FetchType.LAZY, mappedBy="region", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Software> softwareValueListViaRegion = new HashSet<Software>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @softwareValueListViaStyle-field-value_list@
    @XmlElement (name="softwarevaluelistviastyle")
    @OneToMany (targetEntity=com.retrocoll.server.domain.server.Software.class, fetch=FetchType.LAZY, mappedBy="style", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Software> softwareValueListViaStyle = new HashSet<Software>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public ValueList() {
    }

	/**
	* All field constructor 
	*/
    public ValueList(
       Integer valueId,
       String name,
       String group) {
	 this(
       valueId,
       name,
       group
	 ,true);
	}
    
	public ValueList(
       Integer valueId,
       String name,
       String group	
    , boolean setRelationship) {
       //primary keys
       setValueId (valueId);
       //attributes
       setName (name);
       setGroup (group);
       //parents
    }

	public ValueList flat() {
	   return new ValueList(
          getValueId(),
          getName(),
          getGroup()
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
      if (this.getGroup()!=null)
         sb.append (this.getGroup() +" " ); 
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
            .append("valueId", valueId)
            .append("name", name)
            .append("group", group)
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
		if (!(object instanceof ValueList)) return false;
		ValueList valuelist = (ValueList) object;
		if (valuelist.valueId==null || !valuelist.valueId.equals(valueId)) return false;
		return true;
	}    

	public boolean equalsMask(Object object) {
		if (object == null) return false;	
		if (object == this) return true;
		if (!(object instanceof ValueList)) return false;
		ValueList valuelist = (ValueList) object;
		if (valueId!=null && valuelist.valueId!=null && !valuelist.valueId.equals(valueId)) return false;
		if ((valuelist.valueId!=null && valueId==null) || (valuelist.valueId==null && valueId!=null)) return false;
		if (name!=null && valuelist.name!=null && !valuelist.name.equals(name)) return false;
		if ((valuelist.name!=null && name==null) || (valuelist.name==null && name!=null)) return false;
		if (group!=null && valuelist.group!=null && !valuelist.group.equals(group)) return false;
		if ((valuelist.group!=null && group==null) || (valuelist.group==null && group!=null)) return false;
		return true;
	}

	public ValueList clone() {
        ValueList valuelist = flat();
        return valuelist;
	}
	
	public void copy (ValueList valuelist) {
		if (valuelist!=null) {
			setValueId (valuelist.getValueId());
			setName (valuelist.getName());
			setGroup (valuelist.getGroup());
		}
	}
	
	public static ValueList fullMask() {
		return new ValueList(
			integerMask__ ,
			stringMask__ ,
			stringMask__ 		);
	}

    public ValueList maskString(Map<String, String> filter) {
        for (Entry<String, String> set : filter.entrySet()) {
            mask(set.getKey(), getEntry(set.getKey(), set.getValue()));
        }
        return this;
    }
    
    public Object getEntry(String pattern, String value) {
        if(pattern==null || value==null) return null;
    	if ("valueId".equals(pattern))
           return Integer.valueOf(value);
        if ("name".equals(pattern))
           return value;
        if ("group".equals(pattern))
           return value;
        return null;
    }	
				
    public ValueList mask(Map<String, Object> filter) {
        for (Entry<String, Object> set : filter.entrySet()) {
            mask(set.getKey(), set.getValue());
        }
        return this;
    }
    
    public ValueList mask(String pattern, Object value) {
        if(pattern==null || value==null) return this;
		if ("valueId".equals(pattern)) {
           setValueId((Integer)value);
		   return this;
		}
        if ("name".equals(pattern)) {
           setName(value.toString());
		   return this;
		}
        if ("group".equals(pattern)) {
           setGroup(value.toString());
		   return this;
		}
        return this;
    }

    public ValueList mask(String pattern) {
        if(pattern==null) return this;
        if ("name".equals(pattern))
           setName(stringMask__);
        if ("group".equals(pattern))
           setGroup(stringMask__);
        return this;
    }

	public void assignNullToBlank () {
        if (StringUtils.isEmpty(getName()))
           setName(null);
        if (StringUtils.isEmpty(getGroup()))
           setGroup(null);
	}

    public Integer getValueId() {
        return valueId;
    }
    public void setValueId (Integer valueId) {
        this.valueId =  valueId;
    }
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-NAME@
    public String getName() {
        return name;
    }
    public void setName (String name) {
        this.name =  name;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-GROUP@
    public String getGroup() {
        return group;
    }
    public void setGroup (String group) {
        this.group =  group;
    }
//MP-MANAGED-UPDATABLE-ENDING


//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @accessorieValueListViaColor-getter-value_list@
    public Set<Accessorie> getAccessorieValueListViaColor() {
        if (accessorieValueListViaColor == null){
            accessorieValueListViaColor = new HashSet<Accessorie>();
        }
        return accessorieValueListViaColor;
    }

    public void setAccessorieValueListViaColor (Set<Accessorie> accessorieValueListViaColor) {
        this.accessorieValueListViaColor = accessorieValueListViaColor;
    }	
    
    public void addAccessorieValueListViaColor (Accessorie element) {
    	    getAccessorieValueListViaColor().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @accessorieValueListViaRegion-getter-value_list@
    public Set<Accessorie> getAccessorieValueListViaRegion() {
        if (accessorieValueListViaRegion == null){
            accessorieValueListViaRegion = new HashSet<Accessorie>();
        }
        return accessorieValueListViaRegion;
    }

    public void setAccessorieValueListViaRegion (Set<Accessorie> accessorieValueListViaRegion) {
        this.accessorieValueListViaRegion = accessorieValueListViaRegion;
    }	
    
    public void addAccessorieValueListViaRegion (Accessorie element) {
    	    getAccessorieValueListViaRegion().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @hardwareValueListViaColor-getter-value_list@
    public Set<Hardware> getHardwareValueListViaColor() {
        if (hardwareValueListViaColor == null){
            hardwareValueListViaColor = new HashSet<Hardware>();
        }
        return hardwareValueListViaColor;
    }

    public void setHardwareValueListViaColor (Set<Hardware> hardwareValueListViaColor) {
        this.hardwareValueListViaColor = hardwareValueListViaColor;
    }	
    
    public void addHardwareValueListViaColor (Hardware element) {
    	    getHardwareValueListViaColor().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @hardwareValueListViaRegion-getter-value_list@
    public Set<Hardware> getHardwareValueListViaRegion() {
        if (hardwareValueListViaRegion == null){
            hardwareValueListViaRegion = new HashSet<Hardware>();
        }
        return hardwareValueListViaRegion;
    }

    public void setHardwareValueListViaRegion (Set<Hardware> hardwareValueListViaRegion) {
        this.hardwareValueListViaRegion = hardwareValueListViaRegion;
    }	
    
    public void addHardwareValueListViaRegion (Hardware element) {
    	    getHardwareValueListViaRegion().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @softwareValueListViaConsole-getter-value_list@
    public Set<Software> getSoftwareValueListViaConsole() {
        if (softwareValueListViaConsole == null){
            softwareValueListViaConsole = new HashSet<Software>();
        }
        return softwareValueListViaConsole;
    }

    public void setSoftwareValueListViaConsole (Set<Software> softwareValueListViaConsole) {
        this.softwareValueListViaConsole = softwareValueListViaConsole;
    }	
    
    public void addSoftwareValueListViaConsole (Software element) {
    	    getSoftwareValueListViaConsole().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @softwareValueListViaRegion-getter-value_list@
    public Set<Software> getSoftwareValueListViaRegion() {
        if (softwareValueListViaRegion == null){
            softwareValueListViaRegion = new HashSet<Software>();
        }
        return softwareValueListViaRegion;
    }

    public void setSoftwareValueListViaRegion (Set<Software> softwareValueListViaRegion) {
        this.softwareValueListViaRegion = softwareValueListViaRegion;
    }	
    
    public void addSoftwareValueListViaRegion (Software element) {
    	    getSoftwareValueListViaRegion().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @softwareValueListViaStyle-getter-value_list@
    public Set<Software> getSoftwareValueListViaStyle() {
        if (softwareValueListViaStyle == null){
            softwareValueListViaStyle = new HashSet<Software>();
        }
        return softwareValueListViaStyle;
    }

    public void setSoftwareValueListViaStyle (Set<Software> softwareValueListViaStyle) {
        this.softwareValueListViaStyle = softwareValueListViaStyle;
    }	
    
    public void addSoftwareValueListViaStyle (Software element) {
    	    getSoftwareValueListViaStyle().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
