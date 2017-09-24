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
import com.retrocoll.server.domain.server.Software;

/**
 *
 * <p>Title: Producer</p>
 *
 * <p>Description: Domain Object describing a Producer entity</p>
 *
 */
@Entity (name="Producer")
@Table (name="\"producer\"")
@NamedQueries ({
	 @NamedQuery(name=Producer.FIND_ALL, query="SELECT a FROM Producer a")
	,@NamedQuery(name=Producer.FIND_BY_NAME, query="SELECT a FROM Producer a WHERE a.name = :name")
	,@NamedQuery(name=Producer.FIND_BY_NAME_CONTAINING, query="SELECT a FROM Producer a WHERE a.name like :name")
	,@NamedQuery(name=Producer.FIND_BY_DESCIPTION, query="SELECT a FROM Producer a WHERE a.desciption = :desciption")
	,@NamedQuery(name=Producer.FIND_BY_DESCIPTION_CONTAINING, query="SELECT a FROM Producer a WHERE a.desciption like :desciption")
	,@NamedQuery(name=Producer.FIND_BY_LOGO, query="SELECT a FROM Producer a WHERE a.logo = :logo")
	,@NamedQuery(name=Producer.FIND_BY_LOGO_CONTAINING, query="SELECT a FROM Producer a WHERE a.logo like :logo")
})
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(namespace="com.retrocoll.server.domain.server", name = "Producer")
@XmlRootElement(namespace="com.retrocoll.server.domain.server")

public class Producer extends AbstractDomainObject {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "Producer.findAll";
    public static final String FIND_BY_NAME = "Producer.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="Producer.findByNameContaining";
    public static final String FIND_BY_DESCIPTION = "Producer.findByDesciption";
    public static final String FIND_BY_DESCIPTION_CONTAINING ="Producer.findByDesciptionContaining";
    public static final String FIND_BY_LOGO = "Producer.findByLogo";
    public static final String FIND_BY_LOGO_CONTAINING ="Producer.findByLogoContaining";
	
    @Id @Column(name="PRODUCER_ID" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement (name="producer-id")
    private Integer producerId;

//MP-MANAGED-ADDED-AREA-BEGINNING @NAME-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @NAME-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-NAME@
    @Column(name="NAME"  , length=45 , nullable=true , unique=false)
    @XmlElement (name="name")
    private String name; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @DESCIPTION-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @DESCIPTION-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-DESCIPTION@
    @Column(name="DESCIPTION"   , nullable=true , unique=false)
    @Lob @Basic(fetch=FetchType.LAZY) 
    @XmlElement (name="desciption")
    private String desciption; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @LOGO-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @LOGO-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-LOGO@
    @Column(name="LOGO"   , nullable=true , unique=false)
    @Lob @Basic(fetch=FetchType.LAZY) 
    @XmlElement (name="logo")
    private String logo; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @accessorieProducerViaBrand-field-producer@
    @XmlElement (name="accessorieproducerviabrand")
    @OneToMany (targetEntity=com.retrocoll.server.domain.server.Accessorie.class, fetch=FetchType.LAZY, mappedBy="brand", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Accessorie> accessorieProducerViaBrand = new HashSet<Accessorie>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @hardwareProducerViaBrand-field-producer@
    @XmlElement (name="hardwareproducerviabrand")
    @OneToMany (targetEntity=com.retrocoll.server.domain.server.Hardware.class, fetch=FetchType.LAZY, mappedBy="brand", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Hardware> hardwareProducerViaBrand = new HashSet<Hardware>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @softwareProducerViaEditor-field-producer@
    @XmlElement (name="softwareproducerviaeditor")
    @OneToMany (targetEntity=com.retrocoll.server.domain.server.Software.class, fetch=FetchType.LAZY, mappedBy="editor", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Software> softwareProducerViaEditor = new HashSet<Software>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @softwareProducerViaDevelopper-field-producer@
    @XmlElement (name="softwareproducerviadevelopper")
    @OneToMany (targetEntity=com.retrocoll.server.domain.server.Software.class, fetch=FetchType.LAZY, mappedBy="developper", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Software> softwareProducerViaDevelopper = new HashSet<Software>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Producer() {
    }

	/**
	* All field constructor 
	*/
    public Producer(
       Integer producerId,
       String name,
       String desciption,
       String logo) {
	 this(
       producerId,
       name,
       desciption,
       logo
	 ,true);
	}
    
	public Producer(
       Integer producerId,
       String name,
       String desciption,
       String logo	
    , boolean setRelationship) {
       //primary keys
       setProducerId (producerId);
       //attributes
       setName (name);
       setDesciption (desciption);
       setLogo (logo);
       //parents
    }

	public Producer flat() {
	   return new Producer(
          getProducerId(),
          getName(),
          getDesciption(),
          getLogo()
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
      if (this.getDesciption()!=null)
         sb.append (this.getDesciption() +" " ); 
      if (this.getLogo()!=null)
         sb.append (this.getLogo() +" " ); 
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
            .append("producerId", producerId)
            .append("name", name)
            .append("desciption", desciption)
            .append("logo", logo)
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
		if (!(object instanceof Producer)) return false;
		Producer producer = (Producer) object;
		if (producer.producerId==null || !producer.producerId.equals(producerId)) return false;
		return true;
	}    

	public boolean equalsMask(Object object) {
		if (object == null) return false;	
		if (object == this) return true;
		if (!(object instanceof Producer)) return false;
		Producer producer = (Producer) object;
		if (producerId!=null && producer.producerId!=null && !producer.producerId.equals(producerId)) return false;
		if ((producer.producerId!=null && producerId==null) || (producer.producerId==null && producerId!=null)) return false;
		if (name!=null && producer.name!=null && !producer.name.equals(name)) return false;
		if ((producer.name!=null && name==null) || (producer.name==null && name!=null)) return false;
		if (desciption!=null && producer.desciption!=null && !producer.desciption.equals(desciption)) return false;
		if ((producer.desciption!=null && desciption==null) || (producer.desciption==null && desciption!=null)) return false;
		if (logo!=null && producer.logo!=null && !producer.logo.equals(logo)) return false;
		if ((producer.logo!=null && logo==null) || (producer.logo==null && logo!=null)) return false;
		return true;
	}

	public Producer clone() {
        Producer producer = flat();
        return producer;
	}
	
	public void copy (Producer producer) {
		if (producer!=null) {
			setProducerId (producer.getProducerId());
			setName (producer.getName());
			setDesciption (producer.getDesciption());
			setLogo (producer.getLogo());
		}
	}
	
	public static Producer fullMask() {
		return new Producer(
			integerMask__ ,
			stringMask__ ,
			null ,
			null 		);
	}

    public Producer maskString(Map<String, String> filter) {
        for (Entry<String, String> set : filter.entrySet()) {
            mask(set.getKey(), getEntry(set.getKey(), set.getValue()));
        }
        return this;
    }
    
    public Object getEntry(String pattern, String value) {
        if(pattern==null || value==null) return null;
    	if ("producerId".equals(pattern))
           return Integer.valueOf(value);
        if ("name".equals(pattern))
           return value;
    	if ("desciption".equals(pattern))
           return null;
    	if ("logo".equals(pattern))
           return null;
        return null;
    }	
				
    public Producer mask(Map<String, Object> filter) {
        for (Entry<String, Object> set : filter.entrySet()) {
            mask(set.getKey(), set.getValue());
        }
        return this;
    }
    
    public Producer mask(String pattern, Object value) {
        if(pattern==null || value==null) return this;
		if ("producerId".equals(pattern)) {
           setProducerId((Integer)value);
		   return this;
		}
        if ("name".equals(pattern)) {
           setName(value.toString());
		   return this;
		}
		if ("desciption".equals(pattern)) {
           setDesciption(null);
		   return this;
		}
		if ("logo".equals(pattern)) {
           setLogo(null);
		   return this;
		}
        return this;
    }

    public Producer mask(String pattern) {
        if(pattern==null) return this;
        if ("name".equals(pattern))
           setName(stringMask__);
        return this;
    }

	public void assignNullToBlank () {
        if (StringUtils.isEmpty(getName()))
           setName(null);
        if (StringUtils.isEmpty(getDesciption()))
           setDesciption(null);
        if (StringUtils.isEmpty(getLogo()))
           setLogo(null);
	}

    public Integer getProducerId() {
        return producerId;
    }
    public void setProducerId (Integer producerId) {
        this.producerId =  producerId;
    }
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-NAME@
    public String getName() {
        return name;
    }
    public void setName (String name) {
        this.name =  name;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-DESCIPTION@
    public String getDesciption() {
        return desciption;
    }
    public void setDesciption (String desciption) {
        this.desciption =  desciption;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-LOGO@
    public String getLogo() {
        return logo;
    }
    public void setLogo (String logo) {
        this.logo =  logo;
    }
//MP-MANAGED-UPDATABLE-ENDING


//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @accessorieProducerViaBrand-getter-producer@
    public Set<Accessorie> getAccessorieProducerViaBrand() {
        if (accessorieProducerViaBrand == null){
            accessorieProducerViaBrand = new HashSet<Accessorie>();
        }
        return accessorieProducerViaBrand;
    }

    public void setAccessorieProducerViaBrand (Set<Accessorie> accessorieProducerViaBrand) {
        this.accessorieProducerViaBrand = accessorieProducerViaBrand;
    }	
    
    public void addAccessorieProducerViaBrand (Accessorie element) {
    	    getAccessorieProducerViaBrand().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @hardwareProducerViaBrand-getter-producer@
    public Set<Hardware> getHardwareProducerViaBrand() {
        if (hardwareProducerViaBrand == null){
            hardwareProducerViaBrand = new HashSet<Hardware>();
        }
        return hardwareProducerViaBrand;
    }

    public void setHardwareProducerViaBrand (Set<Hardware> hardwareProducerViaBrand) {
        this.hardwareProducerViaBrand = hardwareProducerViaBrand;
    }	
    
    public void addHardwareProducerViaBrand (Hardware element) {
    	    getHardwareProducerViaBrand().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @softwareProducerViaEditor-getter-producer@
    public Set<Software> getSoftwareProducerViaEditor() {
        if (softwareProducerViaEditor == null){
            softwareProducerViaEditor = new HashSet<Software>();
        }
        return softwareProducerViaEditor;
    }

    public void setSoftwareProducerViaEditor (Set<Software> softwareProducerViaEditor) {
        this.softwareProducerViaEditor = softwareProducerViaEditor;
    }	
    
    public void addSoftwareProducerViaEditor (Software element) {
    	    getSoftwareProducerViaEditor().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @softwareProducerViaDevelopper-getter-producer@
    public Set<Software> getSoftwareProducerViaDevelopper() {
        if (softwareProducerViaDevelopper == null){
            softwareProducerViaDevelopper = new HashSet<Software>();
        }
        return softwareProducerViaDevelopper;
    }

    public void setSoftwareProducerViaDevelopper (Set<Software> softwareProducerViaDevelopper) {
        this.softwareProducerViaDevelopper = softwareProducerViaDevelopper;
    }	
    
    public void addSoftwareProducerViaDevelopper (Software element) {
    	    getSoftwareProducerViaDevelopper().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
