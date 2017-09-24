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
 * <p>Title: Photo</p>
 *
 * <p>Description: Domain Object describing a Photo entity</p>
 *
 */
@Entity (name="Photo")
@Table (name="\"photo\"")
@NamedQueries ({
	 @NamedQuery(name=Photo.FIND_ALL, query="SELECT a FROM Photo a")
	,@NamedQuery(name=Photo.FIND_BY_PHOTO, query="SELECT a FROM Photo a WHERE a.photo = :photo")
	,@NamedQuery(name=Photo.FIND_BY_PHOTO_CONTAINING, query="SELECT a FROM Photo a WHERE a.photo like :photo")
	,@NamedQuery(name=Photo.FIND_BY_NAME, query="SELECT a FROM Photo a WHERE a.name = :name")
	,@NamedQuery(name=Photo.FIND_BY_NAME_CONTAINING, query="SELECT a FROM Photo a WHERE a.name like :name")
	,@NamedQuery(name=Photo.FIND_BY_DESCRIPTION, query="SELECT a FROM Photo a WHERE a.description = :description")
	,@NamedQuery(name=Photo.FIND_BY_DESCRIPTION_CONTAINING, query="SELECT a FROM Photo a WHERE a.description like :description")
})
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(namespace="com.retrocoll.server.domain.server", name = "Photo")
@XmlRootElement(namespace="com.retrocoll.server.domain.server")

public class Photo extends AbstractDomainObject {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "Photo.findAll";
    public static final String FIND_BY_PHOTO = "Photo.findByPhoto";
    public static final String FIND_BY_PHOTO_CONTAINING ="Photo.findByPhotoContaining";
    public static final String FIND_BY_NAME = "Photo.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="Photo.findByNameContaining";
    public static final String FIND_BY_DESCRIPTION = "Photo.findByDescription";
    public static final String FIND_BY_DESCRIPTION_CONTAINING ="Photo.findByDescriptionContaining";
	
    @Id @Column(name="PHOTO_ID" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement (name="photo-id")
    private Integer photoId;

//MP-MANAGED-ADDED-AREA-BEGINNING @PHOTO-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @PHOTO-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-PHOTO@
    @Column(name="PHOTO"   , nullable=true , unique=false)
    @Lob @Basic(fetch=FetchType.LAZY) 
    @XmlElement (name="photo")
    private String photo; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @NAME-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @NAME-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-NAME@
    @Column(name="NAME"  , length=45 , nullable=true , unique=false)
    @XmlElement (name="name")
    private String name; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @DESCRIPTION-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @DESCRIPTION-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-DESCRIPTION@
    @Column(name="DESCRIPTION"  , length=45 , nullable=true , unique=false)
    @XmlElement (name="description")
    private String description; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="ACCESSORIE_ID_PK", referencedColumnName = "ACCESSORIE_ID" , nullable=true , unique=false , insertable=true, updatable=true) 
    @XmlElement (name="accessorieIdPkRef")
    private Accessorie accessorieIdPk;  

    @XmlElement (name="accessorie-id-pk")
    @Column(name="ACCESSORIE_ID_PK"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer accessorieIdPk_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="HARDWARE_ID_FK", referencedColumnName = "HARDWARE_ID" , nullable=true , unique=true  , insertable=true, updatable=true) 
    @XmlElement (name="hardwareIdFkRef")
    private Hardware hardwareIdFk;  

    @XmlElement (name="hardware-id-fk")
    @Column(name="HARDWARE_ID_FK"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer hardwareIdFk_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="SOFTWARE_ID_PK", referencedColumnName = "SOFTWARE_ID" , nullable=true , unique=true  , insertable=true, updatable=true) 
    @XmlElement (name="softwareIdPkRef")
    private Software softwareIdPk;  

    @XmlElement (name="software-id-pk")
    @Column(name="SOFTWARE_ID_PK"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer softwareIdPk_;

    /**
    * Default constructor
    */
    public Photo() {
    }

	/**
	* All field constructor 
	*/
    public Photo(
       Integer photoId,
       String photo,
       String name,
       String description,
       Integer hardwareIdFk,
       Integer softwareIdPk,
       Integer accessorieIdPk) {
	 this(
       photoId,
       photo,
       name,
       description,
       hardwareIdFk,
       softwareIdPk,
       accessorieIdPk
	 ,true);
	}
    
	public Photo(
       Integer photoId,
       String photo,
       String name,
       String description,
       Integer hardwareIdFk,
       Integer softwareIdPk,
       Integer accessorieIdPk	
    , boolean setRelationship) {
       //primary keys
       setPhotoId (photoId);
       //attributes
       setPhoto (photo);
       setName (name);
       setDescription (description);
       //parents
       if (setRelationship && accessorieIdPk!=null) {
          this.accessorieIdPk = new Accessorie();
          this.accessorieIdPk.setAccessorieId(accessorieIdPk);
	      setAccessorieIdPk_ (accessorieIdPk);
       }
       if (setRelationship && hardwareIdFk!=null) {
          this.hardwareIdFk = new Hardware();
          this.hardwareIdFk.setHardwareId(hardwareIdFk);
	      setHardwareIdFk_ (hardwareIdFk);
       }
       if (setRelationship && softwareIdPk!=null) {
          this.softwareIdPk = new Software();
          this.softwareIdPk.setSoftwareId(softwareIdPk);
	      setSoftwareIdPk_ (softwareIdPk);
       }
    }

	public Photo flat() {
	   return new Photo(
          getPhotoId(),
          getPhoto(),
          getName(),
          getDescription(),
          getHardwareIdFk_(),
          getSoftwareIdPk_(),
          getAccessorieIdPk_()
       , false
	   );
	}

    /**
    * display semanticReference with attribute inside class
    */
	public String display() {
	  StringBuffer sb = new StringBuffer();
      if (this.getPhoto()!=null)
         sb.append (this.getPhoto() +" " ); 
      if (this.getName()!=null)
         sb.append (this.getName() +" " ); 
      if (this.getDescription()!=null)
         sb.append (this.getDescription() +" " ); 
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
            .append("photoId", photoId)
            .append("photo", photo)
            .append("name", name)
            .append("description", description)
            .append("hardwareIdFk_", hardwareIdFk_)
            .append("softwareIdPk_", softwareIdPk_)
            .append("accessorieIdPk_", accessorieIdPk_)
	 	;
	} 
		
	public String toString(Object object) {
	 	return getToStringBuilder(object).toString();
	} 
	
	public String toStringWithParents() {
	    ToStringBuilder toStringBuilder = getToStringBuilder(this);
        if (accessorieIdPk!=null)
            toStringBuilder.append("accessorieIdPk", accessorieIdPk.toStringWithParents());
        if (hardwareIdFk!=null)
            toStringBuilder.append("hardwareIdFk", hardwareIdFk.toStringWithParents());
        if (softwareIdPk!=null)
            toStringBuilder.append("softwareIdPk", softwareIdPk.toStringWithParents());
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
		if (!(object instanceof Photo)) return false;
		Photo photo = (Photo) object;
		if (photo.photoId==null || !photo.photoId.equals(photoId)) return false;
		return true;
	}    

	public boolean equalsMask(Object object) {
		if (object == null) return false;	
		if (object == this) return true;
		if (!(object instanceof Photo)) return false;
		Photo photo = (Photo) object;
		if (photoId!=null && photo.photoId!=null && !photo.photoId.equals(photoId)) return false;
		if ((photo.photoId!=null && photoId==null) || (photo.photoId==null && photoId!=null)) return false;
		if (photo!=null && photo.photo!=null && !photo.photo.equals(photo)) return false;
		if ((photo.photo!=null && photo==null) || (photo.photo==null && photo!=null)) return false;
		if (name!=null && photo.name!=null && !photo.name.equals(name)) return false;
		if ((photo.name!=null && name==null) || (photo.name==null && name!=null)) return false;
		if (description!=null && photo.description!=null && !photo.description.equals(description)) return false;
		if ((photo.description!=null && description==null) || (photo.description==null && description!=null)) return false;
		if (hardwareIdFk!=null && photo.hardwareIdFk!=null && !photo.hardwareIdFk.equals(hardwareIdFk)) return false;
		if ((photo.hardwareIdFk!=null && hardwareIdFk==null) || (photo.hardwareIdFk==null && hardwareIdFk!=null)) return false;
		if (softwareIdPk!=null && photo.softwareIdPk!=null && !photo.softwareIdPk.equals(softwareIdPk)) return false;
		if ((photo.softwareIdPk!=null && softwareIdPk==null) || (photo.softwareIdPk==null && softwareIdPk!=null)) return false;
		if (accessorieIdPk!=null && photo.accessorieIdPk!=null && !photo.accessorieIdPk.equals(accessorieIdPk)) return false;
		if ((photo.accessorieIdPk!=null && accessorieIdPk==null) || (photo.accessorieIdPk==null && accessorieIdPk!=null)) return false;
		return true;
	}

	public Photo clone() {
        Photo photo = flat();
        if (getAccessorieIdPk()!=null) 
            photo.setAccessorieIdPk (getAccessorieIdPk().clone());   
        if (getHardwareIdFk()!=null) 
            photo.setHardwareIdFk (getHardwareIdFk().clone());   
        if (getSoftwareIdPk()!=null) 
            photo.setSoftwareIdPk (getSoftwareIdPk().clone());   
        return photo;
	}
	
	public void copy (Photo photo) {
		if (photo!=null) {
			setPhotoId (photo.getPhotoId());
			setPhoto (photo.getPhoto());
			setName (photo.getName());
			setDescription (photo.getDescription());
			setHardwareIdFk (photo.getHardwareIdFk());
			setSoftwareIdPk (photo.getSoftwareIdPk());
			setAccessorieIdPk (photo.getAccessorieIdPk());
		}
	}
	
	public static Photo fullMask() {
		return new Photo(
			integerMask__ ,
			null ,
			stringMask__ ,
			stringMask__ ,
			integerMask__ ,
			integerMask__ ,
			integerMask__ 		);
	}

    public Photo maskString(Map<String, String> filter) {
        for (Entry<String, String> set : filter.entrySet()) {
            mask(set.getKey(), getEntry(set.getKey(), set.getValue()));
        }
        return this;
    }
    
    public Object getEntry(String pattern, String value) {
        if(pattern==null || value==null) return null;
    	if ("photoId".equals(pattern))
           return Integer.valueOf(value);
    	if ("photo".equals(pattern))
           return null;
        if ("name".equals(pattern))
           return value;
        if ("description".equals(pattern))
           return value;
    	if ("hardwareIdFk".equals(pattern))
           return Integer.valueOf(value);
    	if ("softwareIdPk".equals(pattern))
           return Integer.valueOf(value);
    	if ("accessorieIdPk".equals(pattern))
           return Integer.valueOf(value);
        return null;
    }	
				
    public Photo mask(Map<String, Object> filter) {
        for (Entry<String, Object> set : filter.entrySet()) {
            mask(set.getKey(), set.getValue());
        }
        return this;
    }
    
    public Photo mask(String pattern, Object value) {
        if(pattern==null || value==null) return this;
		if ("photoId".equals(pattern)) {
           setPhotoId((Integer)value);
		   return this;
		}
		if ("photo".equals(pattern)) {
           setPhoto(null);
		   return this;
		}
        if ("name".equals(pattern)) {
           setName(value.toString());
		   return this;
		}
        if ("description".equals(pattern)) {
           setDescription(value.toString());
		   return this;
		}
		if ("hardwareIdFk".equals(pattern)) {
           setHardwareIdFk_((Integer)value);
		   return this;
		}
		if ("softwareIdPk".equals(pattern)) {
           setSoftwareIdPk_((Integer)value);
		   return this;
		}
		if ("accessorieIdPk".equals(pattern)) {
           setAccessorieIdPk_((Integer)value);
		   return this;
		}
        return this;
    }

    public Photo mask(String pattern) {
        if(pattern==null) return this;
        if ("name".equals(pattern))
           setName(stringMask__);
        if ("description".equals(pattern))
           setDescription(stringMask__);
        return this;
    }

	public void assignNullToBlank () {
        if (StringUtils.isEmpty(getPhoto()))
           setPhoto(null);
        if (StringUtils.isEmpty(getName()))
           setName(null);
        if (StringUtils.isEmpty(getDescription()))
           setDescription(null);
	}

    public Integer getPhotoId() {
        return photoId;
    }
    public void setPhotoId (Integer photoId) {
        this.photoId =  photoId;
    }
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-PHOTO@
    public String getPhoto() {
        return photo;
    }
    public void setPhoto (String photo) {
        this.photo =  photo;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-NAME@
    public String getName() {
        return name;
    }
    public void setName (String name) {
        this.name =  name;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-DESCRIPTION@
    public String getDescription() {
        return description;
    }
    public void setDescription (String description) {
        this.description =  description;
    }
//MP-MANAGED-UPDATABLE-ENDING

    public Accessorie getAccessorieIdPk () {
    	return accessorieIdPk;
    }
	
    public void setAccessorieIdPk (Accessorie accessorieIdPk) {
    	this.accessorieIdPk = accessorieIdPk;
    }

    public Integer getAccessorieIdPk_() {
        return accessorieIdPk_;
    }
	
    public void setAccessorieIdPk_ (Integer accessorieIdPk) {
        this.accessorieIdPk_ =  accessorieIdPk;
    }
	
    public Hardware getHardwareIdFk () {
    	return hardwareIdFk;
    }
	
    public void setHardwareIdFk (Hardware hardwareIdFk) {
    	this.hardwareIdFk = hardwareIdFk;
    }

    public Integer getHardwareIdFk_() {
        return hardwareIdFk_;
    }
	
    public void setHardwareIdFk_ (Integer hardwareIdFk) {
        this.hardwareIdFk_ =  hardwareIdFk;
    }
	
    public Software getSoftwareIdPk () {
    	return softwareIdPk;
    }
	
    public void setSoftwareIdPk (Software softwareIdPk) {
    	this.softwareIdPk = softwareIdPk;
    }

    public Integer getSoftwareIdPk_() {
        return softwareIdPk_;
    }
	
    public void setSoftwareIdPk_ (Integer softwareIdPk) {
        this.softwareIdPk_ =  softwareIdPk;
    }
	




//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
