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
import com.retrocoll.server.domain.server.Hardware;
import com.retrocoll.server.domain.server.Software;

/**
 *
 * <p>Title: Location</p>
 *
 * <p>Description: Domain Object describing a Location entity</p>
 *
 */
@Entity (name="Location")
@Table (name="\"location\"")
@NamedQueries ({
	 @NamedQuery(name=Location.FIND_ALL, query="SELECT a FROM Location a")
	,@NamedQuery(name=Location.FIND_BY_LOCATIONNAME, query="SELECT a FROM Location a WHERE a.locationName = :locationName")
	,@NamedQuery(name=Location.FIND_BY_LOCATIONNAME_CONTAINING, query="SELECT a FROM Location a WHERE a.locationName like :locationName")
})
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(namespace="com.retrocoll.server.domain.server", name = "Location")
@XmlRootElement(namespace="com.retrocoll.server.domain.server")

public class Location extends AbstractDomainObject {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "Location.findAll";
    public static final String FIND_BY_LOCATIONNAME = "Location.findByLocationName";
    public static final String FIND_BY_LOCATIONNAME_CONTAINING ="Location.findByLocationNameContaining";
	
    @Id @Column(name="LOCATION_ID" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement (name="location-id")
    private Integer locationId;

//MP-MANAGED-ADDED-AREA-BEGINNING @LOCATION_NAME-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @LOCATION_NAME-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-LOCATION_NAME@
    @Column(name="LOCATION_NAME"  , length=45 , nullable=true , unique=false)
    @XmlElement (name="location-name")
    private String locationName; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @accessorieLocationViaLocation-field-location@
    @XmlElement (name="accessorielocationvialocation")
    @OneToMany (targetEntity=com.retrocoll.server.domain.server.Accessorie.class, fetch=FetchType.LAZY, mappedBy="location", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Accessorie> accessorieLocationViaLocation = new HashSet<Accessorie>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @hardwareLocationViaLocation-field-location@
    @XmlElement (name="hardwarelocationvialocation")
    @OneToMany (targetEntity=com.retrocoll.server.domain.server.Hardware.class, fetch=FetchType.LAZY, mappedBy="location", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Hardware> hardwareLocationViaLocation = new HashSet<Hardware>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @softwareLocationViaLocation-field-location@
    @XmlElement (name="softwarelocationvialocation")
    @OneToMany (targetEntity=com.retrocoll.server.domain.server.Software.class, fetch=FetchType.LAZY, mappedBy="location", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Software> softwareLocationViaLocation = new HashSet<Software>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Location() {
    }

	/**
	* All field constructor 
	*/
    public Location(
       Integer locationId,
       String locationName) {
	 this(
       locationId,
       locationName
	 ,true);
	}
    
	public Location(
       Integer locationId,
       String locationName	
    , boolean setRelationship) {
       //primary keys
       setLocationId (locationId);
       //attributes
       setLocationName (locationName);
       //parents
    }

	public Location flat() {
	   return new Location(
          getLocationId(),
          getLocationName()
       , false
	   );
	}

    /**
    * display semanticReference with attribute inside class
    */
	public String display() {
	  StringBuffer sb = new StringBuffer();
      if (this.getLocationName()!=null)
         sb.append (this.getLocationName() +" " ); 
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
            .append("locationId", locationId)
            .append("locationName", locationName)
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
		if (!(object instanceof Location)) return false;
		Location location = (Location) object;
		if (location.locationId==null || !location.locationId.equals(locationId)) return false;
		return true;
	}    

	public boolean equalsMask(Object object) {
		if (object == null) return false;	
		if (object == this) return true;
		if (!(object instanceof Location)) return false;
		Location location = (Location) object;
		if (locationId!=null && location.locationId!=null && !location.locationId.equals(locationId)) return false;
		if ((location.locationId!=null && locationId==null) || (location.locationId==null && locationId!=null)) return false;
		if (locationName!=null && location.locationName!=null && !location.locationName.equals(locationName)) return false;
		if ((location.locationName!=null && locationName==null) || (location.locationName==null && locationName!=null)) return false;
		return true;
	}

	public Location clone() {
        Location location = flat();
        return location;
	}
	
	public void copy (Location location) {
		if (location!=null) {
			setLocationId (location.getLocationId());
			setLocationName (location.getLocationName());
		}
	}
	
	public static Location fullMask() {
		return new Location(
			integerMask__ ,
			stringMask__ 		);
	}

    public Location maskString(Map<String, String> filter) {
        for (Entry<String, String> set : filter.entrySet()) {
            mask(set.getKey(), getEntry(set.getKey(), set.getValue()));
        }
        return this;
    }
    
    public Object getEntry(String pattern, String value) {
        if(pattern==null || value==null) return null;
    	if ("locationId".equals(pattern))
           return Integer.valueOf(value);
        if ("locationName".equals(pattern))
           return value;
        return null;
    }	
				
    public Location mask(Map<String, Object> filter) {
        for (Entry<String, Object> set : filter.entrySet()) {
            mask(set.getKey(), set.getValue());
        }
        return this;
    }
    
    public Location mask(String pattern, Object value) {
        if(pattern==null || value==null) return this;
		if ("locationId".equals(pattern)) {
           setLocationId((Integer)value);
		   return this;
		}
        if ("locationName".equals(pattern)) {
           setLocationName(value.toString());
		   return this;
		}
        return this;
    }

    public Location mask(String pattern) {
        if(pattern==null) return this;
        if ("locationName".equals(pattern))
           setLocationName(stringMask__);
        return this;
    }

	public void assignNullToBlank () {
        if (StringUtils.isEmpty(getLocationName()))
           setLocationName(null);
	}

    public Integer getLocationId() {
        return locationId;
    }
    public void setLocationId (Integer locationId) {
        this.locationId =  locationId;
    }
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-LOCATION_NAME@
    public String getLocationName() {
        return locationName;
    }
    public void setLocationName (String locationName) {
        this.locationName =  locationName;
    }
//MP-MANAGED-UPDATABLE-ENDING


//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @accessorieLocationViaLocation-getter-location@
    public Set<Accessorie> getAccessorieLocationViaLocation() {
        if (accessorieLocationViaLocation == null){
            accessorieLocationViaLocation = new HashSet<Accessorie>();
        }
        return accessorieLocationViaLocation;
    }

    public void setAccessorieLocationViaLocation (Set<Accessorie> accessorieLocationViaLocation) {
        this.accessorieLocationViaLocation = accessorieLocationViaLocation;
    }	
    
    public void addAccessorieLocationViaLocation (Accessorie element) {
    	    getAccessorieLocationViaLocation().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @hardwareLocationViaLocation-getter-location@
    public Set<Hardware> getHardwareLocationViaLocation() {
        if (hardwareLocationViaLocation == null){
            hardwareLocationViaLocation = new HashSet<Hardware>();
        }
        return hardwareLocationViaLocation;
    }

    public void setHardwareLocationViaLocation (Set<Hardware> hardwareLocationViaLocation) {
        this.hardwareLocationViaLocation = hardwareLocationViaLocation;
    }	
    
    public void addHardwareLocationViaLocation (Hardware element) {
    	    getHardwareLocationViaLocation().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @softwareLocationViaLocation-getter-location@
    public Set<Software> getSoftwareLocationViaLocation() {
        if (softwareLocationViaLocation == null){
            softwareLocationViaLocation = new HashSet<Software>();
        }
        return softwareLocationViaLocation;
    }

    public void setSoftwareLocationViaLocation (Set<Software> softwareLocationViaLocation) {
        this.softwareLocationViaLocation = softwareLocationViaLocation;
    }	
    
    public void addSoftwareLocationViaLocation (Software element) {
    	    getSoftwareLocationViaLocation().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
