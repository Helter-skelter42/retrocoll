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
	* - time      : 2017/09/16 ap. J.-C. at 19:38:20 CEST
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
import com.retrocoll.server.domain.server.Photo;
import com.retrocoll.server.domain.server.Producer;
import com.retrocoll.server.domain.server.ValueList;
import com.retrocoll.server.domain.server.Location;
import com.retrocoll.server.domain.server.ValueList;
import com.retrocoll.server.domain.server.Hardware;
import com.retrocoll.server.domain.server.Tag;

/**
 *
 * <p>Title: Accessorie</p>
 *
 * <p>Description: Domain Object describing a Accessorie entity</p>
 *
 */
@Entity (name="Accessorie")
@Table (name="\"accessorie\"")
@NamedQueries ({
	 @NamedQuery(name=Accessorie.FIND_ALL, query="SELECT a FROM Accessorie a")
	,@NamedQuery(name=Accessorie.FIND_BY_NAME, query="SELECT a FROM Accessorie a WHERE a.name = :name")
	,@NamedQuery(name=Accessorie.FIND_BY_NAME_CONTAINING, query="SELECT a FROM Accessorie a WHERE a.name like :name")
	,@NamedQuery(name=Accessorie.FIND_BY_DESCRIPTION, query="SELECT a FROM Accessorie a WHERE a.description = :description")
	,@NamedQuery(name=Accessorie.FIND_BY_DESCRIPTION_CONTAINING, query="SELECT a FROM Accessorie a WHERE a.description like :description")
	,@NamedQuery(name=Accessorie.FIND_BY_SERIALNUMBER, query="SELECT a FROM Accessorie a WHERE a.serialNumber = :serialNumber")
	,@NamedQuery(name=Accessorie.FIND_BY_SERIALNUMBER_CONTAINING, query="SELECT a FROM Accessorie a WHERE a.serialNumber like :serialNumber")
	,@NamedQuery(name=Accessorie.FIND_BY_SUBREGIONCODE, query="SELECT a FROM Accessorie a WHERE a.subRegionCode = :subRegionCode")
	,@NamedQuery(name=Accessorie.FIND_BY_SUBREGIONCODE_CONTAINING, query="SELECT a FROM Accessorie a WHERE a.subRegionCode like :subRegionCode")
	,@NamedQuery(name=Accessorie.FIND_BY_RELEASEDATE, query="SELECT a FROM Accessorie a WHERE a.releaseDate = :releaseDate")
	,@NamedQuery(name=Accessorie.FIND_BY_ACQUIRINGDATE, query="SELECT a FROM Accessorie a WHERE a.acquiringDate = :acquiringDate")
	,@NamedQuery(name=Accessorie.FIND_BY_ACQUIRINGPRICE, query="SELECT a FROM Accessorie a WHERE a.acquiringPrice = :acquiringPrice")
	,@NamedQuery(name=Accessorie.FIND_BY_ACQUIREDPRICEFREE, query="SELECT a FROM Accessorie a WHERE a.acquiredPriceFree = :acquiredPriceFree")
	,@NamedQuery(name=Accessorie.FIND_BY_ACQUIREDPRICEUNKNOWN, query="SELECT a FROM Accessorie a WHERE a.acquiredPriceUnknown = :acquiredPriceUnknown")
	,@NamedQuery(name=Accessorie.FIND_BY_ACQUIRINGSELLERNAME, query="SELECT a FROM Accessorie a WHERE a.acquiringSellerName = :acquiringSellerName")
	,@NamedQuery(name=Accessorie.FIND_BY_ACQUIRINGSELLERNAME_CONTAINING, query="SELECT a FROM Accessorie a WHERE a.acquiringSellerName like :acquiringSellerName")
	,@NamedQuery(name=Accessorie.FIND_BY_ACQUIRINGPLACE, query="SELECT a FROM Accessorie a WHERE a.acquiringPlace = :acquiringPlace")
	,@NamedQuery(name=Accessorie.FIND_BY_ACQUIRINGPLACE_CONTAINING, query="SELECT a FROM Accessorie a WHERE a.acquiringPlace like :acquiringPlace")
	,@NamedQuery(name=Accessorie.FIND_BY_HASBOX, query="SELECT a FROM Accessorie a WHERE a.hasBox = :hasBox")
	,@NamedQuery(name=Accessorie.FIND_BY_HASMANUAL, query="SELECT a FROM Accessorie a WHERE a.hasManual = :hasManual")
	,@NamedQuery(name=Accessorie.FIND_BY_HASINSERTS, query="SELECT a FROM Accessorie a WHERE a.hasInserts = :hasInserts")
	,@NamedQuery(name=Accessorie.FIND_BY_HASINSERTS_CONTAINING, query="SELECT a FROM Accessorie a WHERE a.hasInserts like :hasInserts")
	,@NamedQuery(name=Accessorie.FIND_BY_ISSEALED, query="SELECT a FROM Accessorie a WHERE a.isSealed = :isSealed")
	,@NamedQuery(name=Accessorie.FIND_BY_ISNEW, query="SELECT a FROM Accessorie a WHERE a.isNew = :isNew")
	,@NamedQuery(name=Accessorie.FIND_BY_ISCOMPLETEINBOX, query="SELECT a FROM Accessorie a WHERE a.isCompleteInBox = :isCompleteInBox")
	,@NamedQuery(name=Accessorie.FIND_BY_HARDWARESTATERATING, query="SELECT a FROM Accessorie a WHERE a.hardwareStateRating = :hardwareStateRating")
	,@NamedQuery(name=Accessorie.FIND_BY_BOXSTATERATING, query="SELECT a FROM Accessorie a WHERE a.boxStateRating = :boxStateRating")
	,@NamedQuery(name=Accessorie.FIND_BY_MANUALSTATERATING, query="SELECT a FROM Accessorie a WHERE a.manualStateRating = :manualStateRating")
	,@NamedQuery(name=Accessorie.FIND_BY_COMMENT, query="SELECT a FROM Accessorie a WHERE a.comment = :comment")
	,@NamedQuery(name=Accessorie.FIND_BY_COMMENT_CONTAINING, query="SELECT a FROM Accessorie a WHERE a.comment like :comment")
	,@NamedQuery(name=Accessorie.FIND_BY_BARCODE, query="SELECT a FROM Accessorie a WHERE a.barcode = :barcode")
	,@NamedQuery(name=Accessorie.FIND_BY_BARCODE_CONTAINING, query="SELECT a FROM Accessorie a WHERE a.barcode like :barcode")
})
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(namespace="com.retrocoll.server.domain.server", name = "Accessorie")
@XmlRootElement(namespace="com.retrocoll.server.domain.server")

public class Accessorie extends AbstractDomainObject {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "Accessorie.findAll";
    public static final String FIND_BY_NAME = "Accessorie.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="Accessorie.findByNameContaining";
    public static final String FIND_BY_DESCRIPTION = "Accessorie.findByDescription";
    public static final String FIND_BY_DESCRIPTION_CONTAINING ="Accessorie.findByDescriptionContaining";
    public static final String FIND_BY_SERIALNUMBER = "Accessorie.findBySerialNumber";
    public static final String FIND_BY_SERIALNUMBER_CONTAINING ="Accessorie.findBySerialNumberContaining";
    public static final String FIND_BY_SUBREGIONCODE = "Accessorie.findBySubRegionCode";
    public static final String FIND_BY_SUBREGIONCODE_CONTAINING ="Accessorie.findBySubRegionCodeContaining";
    public static final String FIND_BY_RELEASEDATE = "Accessorie.findByReleaseDate";
    public static final String FIND_BY_ACQUIRINGDATE = "Accessorie.findByAcquiringDate";
    public static final String FIND_BY_ACQUIRINGPRICE = "Accessorie.findByAcquiringPrice";
    public static final String FIND_BY_ACQUIREDPRICEFREE = "Accessorie.findByAcquiredPriceFree";
    public static final String FIND_BY_ACQUIREDPRICEUNKNOWN = "Accessorie.findByAcquiredPriceUnknown";
    public static final String FIND_BY_ACQUIRINGSELLERNAME = "Accessorie.findByAcquiringSellerName";
    public static final String FIND_BY_ACQUIRINGSELLERNAME_CONTAINING ="Accessorie.findByAcquiringSellerNameContaining";
    public static final String FIND_BY_ACQUIRINGPLACE = "Accessorie.findByAcquiringPlace";
    public static final String FIND_BY_ACQUIRINGPLACE_CONTAINING ="Accessorie.findByAcquiringPlaceContaining";
    public static final String FIND_BY_HASBOX = "Accessorie.findByHasBox";
    public static final String FIND_BY_HASMANUAL = "Accessorie.findByHasManual";
    public static final String FIND_BY_HASINSERTS = "Accessorie.findByHasInserts";
    public static final String FIND_BY_HASINSERTS_CONTAINING ="Accessorie.findByHasInsertsContaining";
    public static final String FIND_BY_ISSEALED = "Accessorie.findByIsSealed";
    public static final String FIND_BY_ISNEW = "Accessorie.findByIsNew";
    public static final String FIND_BY_ISCOMPLETEINBOX = "Accessorie.findByIsCompleteInBox";
    public static final String FIND_BY_HARDWARESTATERATING = "Accessorie.findByHardwareStateRating";
    public static final String FIND_BY_BOXSTATERATING = "Accessorie.findByBoxStateRating";
    public static final String FIND_BY_MANUALSTATERATING = "Accessorie.findByManualStateRating";
    public static final String FIND_BY_COMMENT = "Accessorie.findByComment";
    public static final String FIND_BY_COMMENT_CONTAINING ="Accessorie.findByCommentContaining";
    public static final String FIND_BY_BARCODE = "Accessorie.findByBarcode";
    public static final String FIND_BY_BARCODE_CONTAINING ="Accessorie.findByBarcodeContaining";
	
    @Id @Column(name="ACCESSORIE_ID" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement (name="accessorie-id")
    private Integer accessorieId;

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
    @Column(name="DESCRIPTION"   , nullable=true , unique=false)
    @Lob @Basic(fetch=FetchType.LAZY) 
    @XmlElement (name="description")
    private String description; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @SERIAL_NUMBER-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @SERIAL_NUMBER-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-SERIAL_NUMBER@
    @Column(name="SERIAL_NUMBER"  , length=45 , nullable=true , unique=false)
    @XmlElement (name="serial-number")
    private String serialNumber; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @SUB_REGION_CODE-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @SUB_REGION_CODE-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-SUB_REGION_CODE@
    @Column(name="SUB_REGION_CODE"  , length=45 , nullable=true , unique=false)
    @XmlElement (name="sub-region-code")
    private String subRegionCode; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @RELEASE_DATE-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @RELEASE_DATE-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-RELEASE_DATE@
    @Column(name="RELEASE_DATE"   , nullable=true , unique=false)
    @XmlElement (name="release-date")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date releaseDate; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @ACQUIRING_DATE-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @ACQUIRING_DATE-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-ACQUIRING_DATE@
    @Column(name="ACQUIRING_DATE"   , nullable=true , unique=false)
    @XmlElement (name="acquiring-date")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date acquiringDate; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @ACQUIRING_PRICE-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @ACQUIRING_PRICE-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-ACQUIRING_PRICE@
    @Column(name="ACQUIRING_PRICE"   , nullable=true , unique=false)
    @XmlElement (name="acquiring-price")
    private java.math.BigDecimal acquiringPrice; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @ACQUIRED_PRICE_FREE-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @ACQUIRED_PRICE_FREE-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-ACQUIRED_PRICE_FREE@
    @Column(name="ACQUIRED_PRICE_FREE"   , nullable=true , unique=false)
    @XmlElement (name="acquired-price-free")
    private Boolean acquiredPriceFree; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @ACQUIRED_PRICE_UNKNOWN-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @ACQUIRED_PRICE_UNKNOWN-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-ACQUIRED_PRICE_UNKNOWN@
    @Column(name="ACQUIRED_PRICE_UNKNOWN"   , nullable=true , unique=false)
    @XmlElement (name="acquired-price-unknown")
    private Boolean acquiredPriceUnknown; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @ACQUIRING_SELLER_NAME-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @ACQUIRING_SELLER_NAME-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-ACQUIRING_SELLER_NAME@
    @Column(name="ACQUIRING_SELLER_NAME"  , length=45 , nullable=true , unique=false)
    @XmlElement (name="acquiring-seller-name")
    private String acquiringSellerName; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @ACQUIRING_PLACE-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @ACQUIRING_PLACE-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-ACQUIRING_PLACE@
    @Column(name="ACQUIRING_PLACE"  , length=45 , nullable=true , unique=false)
    @XmlElement (name="acquiring-place")
    private String acquiringPlace; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @HAS_BOX-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @HAS_BOX-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-HAS_BOX@
    @Column(name="HAS_BOX"   , nullable=true , unique=false)
    @XmlElement (name="has-box")
    private Boolean hasBox; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @HAS_MANUAL-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @HAS_MANUAL-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-HAS_MANUAL@
    @Column(name="HAS_MANUAL"   , nullable=true , unique=false)
    @XmlElement (name="has-manual")
    private Boolean hasManual; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @HAS_INSERTS-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @HAS_INSERTS-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-HAS_INSERTS@
    @Column(name="HAS_INSERTS"  , length=45 , nullable=true , unique=false)
    @XmlElement (name="has-inserts")
    private String hasInserts; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @IS_SEALED-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @IS_SEALED-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-IS_SEALED@
    @Column(name="IS_SEALED"   , nullable=true , unique=false)
    @XmlElement (name="is-sealed")
    private Boolean isSealed; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @IS_NEW-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @IS_NEW-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-IS_NEW@
    @Column(name="IS_NEW"   , nullable=true , unique=false)
    @XmlElement (name="is-new")
    private Boolean isNew; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @IS_COMPLETE_IN_BOX-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @IS_COMPLETE_IN_BOX-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-IS_COMPLETE_IN_BOX@
    @Column(name="IS_COMPLETE_IN_BOX"   , nullable=true , unique=false)
    @XmlElement (name="is-complete-in-box")
    private Boolean isCompleteInBox; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @HARDWARE_STATE_RATING-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @HARDWARE_STATE_RATING-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-HARDWARE_STATE_RATING@
    @Column(name="HARDWARE_STATE_RATING"   , nullable=true , unique=false)
    @XmlElement (name="hardware-state-rating")
    private Integer hardwareStateRating; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @BOX_STATE_RATING-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @BOX_STATE_RATING-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-BOX_STATE_RATING@
    @Column(name="BOX_STATE_RATING"   , nullable=true , unique=false)
    @XmlElement (name="box-state-rating")
    private Integer boxStateRating; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @MANUAL_STATE_RATING-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @MANUAL_STATE_RATING-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-MANUAL_STATE_RATING@
    @Column(name="MANUAL_STATE_RATING"   , nullable=true , unique=false)
    @XmlElement (name="manual-state-rating")
    private Integer manualStateRating; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @COMMENT-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @COMMENT-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-COMMENT@
    @Column(name="COMMENT"  , length=45 , nullable=true , unique=false)
    @XmlElement (name="comment")
    private String comment; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @BARCODE-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @BARCODE-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-BARCODE@
    @Column(name="BARCODE"   , nullable=true , unique=false)
    @Lob @Basic(fetch=FetchType.LAZY) 
    @XmlElement (name="barcode")
    private String barcode; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="BRAND", referencedColumnName = "PRODUCER_ID" , nullable=true , unique=false , insertable=true, updatable=true) 
    @XmlElement (name="brandRef")
    private Producer brand;  

    @XmlElement (name="brand")
    @Column(name="BRAND"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer brand_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="COLOR", referencedColumnName = "VALUE_ID" , nullable=true , unique=true  , insertable=true, updatable=true) 
    @XmlElement (name="colorRef")
    private ValueList color;  

    @XmlElement (name="color")
    @Column(name="COLOR"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer color_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="LOCATION", referencedColumnName = "LOCATION_ID" , nullable=true , unique=true  , insertable=true, updatable=true) 
    @XmlElement (name="locationRef")
    private Location location;  

    @XmlElement (name="location")
    @Column(name="LOCATION"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer location_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="REGION", referencedColumnName = "VALUE_ID" , nullable=true , unique=true  , insertable=true, updatable=true) 
    @XmlElement (name="regionRef")
    private ValueList region;  

    @XmlElement (name="region")
    @Column(name="REGION"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer region_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @photoAccessorieViaAccessorieIdPk-field-accessorie@
    @XmlElement (name="photoaccessorieviaaccessorieidpk")
    @OneToMany (targetEntity=com.retrocoll.server.domain.server.Photo.class, fetch=FetchType.LAZY, mappedBy="accessorieIdPk", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Photo> photoAccessorieViaAccessorieIdPk = new HashSet<Photo>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-hardwareViaHardwareAccessorieByHardwareIdFk-accessorie@
    @XmlTransient
    @ManyToMany
    @JoinTable(name="HARDWARE_ACCESSORIE", 
        joinColumns=@JoinColumn(name="ACCESSORIE_ID_FK"), 
        inverseJoinColumns=@JoinColumn(name="HARDWARE_ID_FK") 
    )
    private Set <Hardware> hardwareViaHardwareAccessorieByHardwareIdFk = new HashSet <Hardware> ();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-tagViaTagAccessorieByTagIdFk-accessorie@
    @XmlTransient
    @ManyToMany
    @JoinTable(name="TAG_ACCESSORIE", 
        joinColumns= {@JoinColumn(name="ACCESSORIE_ID_FK", referencedColumnName="ACCESSORIE_ID")}, 
        inverseJoinColumns= {@JoinColumn(name="TAG_ID_FK", referencedColumnName="TAG_ID")}
    )
    private Set <Tag> tagViaTagAccessorieByTagIdFk = new HashSet <Tag> ();

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Accessorie() {
    }

	/**
	* All field constructor 
	*/
    public Accessorie(
       Integer accessorieId,
       String name,
       String description,
       Integer brand,
       Integer color,
       String serialNumber,
       Integer region,
       String subRegionCode,
       java.util.Date releaseDate,
       java.util.Date acquiringDate,
       java.math.BigDecimal acquiringPrice,
       Boolean acquiredPriceFree,
       Boolean acquiredPriceUnknown,
       String acquiringSellerName,
       String acquiringPlace,
       Integer location,
       Boolean hasBox,
       Boolean hasManual,
       String hasInserts,
       Boolean isSealed,
       Boolean isNew,
       Boolean isCompleteInBox,
       Integer hardwareStateRating,
       Integer boxStateRating,
       Integer manualStateRating,
       String comment,
       String barcode) {
	 this(
       accessorieId,
       name,
       description,
       brand,
       color,
       serialNumber,
       region,
       subRegionCode,
       releaseDate,
       acquiringDate,
       acquiringPrice,
       acquiredPriceFree,
       acquiredPriceUnknown,
       acquiringSellerName,
       acquiringPlace,
       location,
       hasBox,
       hasManual,
       hasInserts,
       isSealed,
       isNew,
       isCompleteInBox,
       hardwareStateRating,
       boxStateRating,
       manualStateRating,
       comment,
       barcode
	 ,true);
	}
    
	public Accessorie(
       Integer accessorieId,
       String name,
       String description,
       Integer brand,
       Integer color,
       String serialNumber,
       Integer region,
       String subRegionCode,
       java.util.Date releaseDate,
       java.util.Date acquiringDate,
       java.math.BigDecimal acquiringPrice,
       Boolean acquiredPriceFree,
       Boolean acquiredPriceUnknown,
       String acquiringSellerName,
       String acquiringPlace,
       Integer location,
       Boolean hasBox,
       Boolean hasManual,
       String hasInserts,
       Boolean isSealed,
       Boolean isNew,
       Boolean isCompleteInBox,
       Integer hardwareStateRating,
       Integer boxStateRating,
       Integer manualStateRating,
       String comment,
       String barcode	
    , boolean setRelationship) {
       //primary keys
       setAccessorieId (accessorieId);
       //attributes
       setName (name);
       setDescription (description);
       setSerialNumber (serialNumber);
       setSubRegionCode (subRegionCode);
       setReleaseDate (releaseDate);
       setAcquiringDate (acquiringDate);
       setAcquiringPrice (acquiringPrice);
       setAcquiredPriceFree (acquiredPriceFree);
       setAcquiredPriceUnknown (acquiredPriceUnknown);
       setAcquiringSellerName (acquiringSellerName);
       setAcquiringPlace (acquiringPlace);
       setHasBox (hasBox);
       setHasManual (hasManual);
       setHasInserts (hasInserts);
       setIsSealed (isSealed);
       setIsNew (isNew);
       setIsCompleteInBox (isCompleteInBox);
       setHardwareStateRating (hardwareStateRating);
       setBoxStateRating (boxStateRating);
       setManualStateRating (manualStateRating);
       setComment (comment);
       setBarcode (barcode);
       //parents
       if (setRelationship && brand!=null) {
          this.brand = new Producer();
          this.brand.setProducerId(brand);
	      setBrand_ (brand);
       }
       if (setRelationship && color!=null) {
          this.color = new ValueList();
          this.color.setValueId(color);
	      setColor_ (color);
       }
       if (setRelationship && location!=null) {
          this.location = new Location();
          this.location.setLocationId(location);
	      setLocation_ (location);
       }
       if (setRelationship && region!=null) {
          this.region = new ValueList();
          this.region.setValueId(region);
	      setRegion_ (region);
       }
    }

	public Accessorie flat() {
	   return new Accessorie(
          getAccessorieId(),
          getName(),
          getDescription(),
          getBrand_(),
          getColor_(),
          getSerialNumber(),
          getRegion_(),
          getSubRegionCode(),
          getReleaseDate(),
          getAcquiringDate(),
          getAcquiringPrice(),
          getAcquiredPriceFree(),
          getAcquiredPriceUnknown(),
          getAcquiringSellerName(),
          getAcquiringPlace(),
          getLocation_(),
          getHasBox(),
          getHasManual(),
          getHasInserts(),
          getIsSealed(),
          getIsNew(),
          getIsCompleteInBox(),
          getHardwareStateRating(),
          getBoxStateRating(),
          getManualStateRating(),
          getComment(),
          getBarcode()
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
      if (this.getDescription()!=null)
         sb.append (this.getDescription() +" " ); 
      if (this.getSerialNumber()!=null)
         sb.append (this.getSerialNumber() +" - "); 
      if (this.getSubRegionCode()!=null)
         sb.append (this.getSubRegionCode() +" - "); 
      if (this.getReleaseDate()!=null)
         sb.append (this.getReleaseDate() +" - "); 
      if (this.getAcquiringDate()!=null)
         sb.append (this.getAcquiringDate() +" - "); 
      if (this.getAcquiringPrice()!=null)
         sb.append (this.getAcquiringPrice() +" - "); 
      if (this.getAcquiredPriceFree()!=null)
         sb.append (this.getAcquiredPriceFree() +" - "); 
      if (this.getAcquiredPriceUnknown()!=null)
         sb.append (this.getAcquiredPriceUnknown() +" - "); 
      if (this.getAcquiringSellerName()!=null)
         sb.append (this.getAcquiringSellerName() +" - "); 
      if (this.getAcquiringPlace()!=null)
         sb.append (this.getAcquiringPlace() +" - "); 
      if (this.getHasBox()!=null)
         sb.append (this.getHasBox() +" - "); 
      if (this.getHasManual()!=null)
         sb.append (this.getHasManual() +" - "); 
      if (this.getHasInserts()!=null)
         sb.append (this.getHasInserts() +" - "); 
      if (this.getIsSealed()!=null)
         sb.append (this.getIsSealed() +" - "); 
      if (this.getIsNew()!=null)
         sb.append (this.getIsNew() +" - "); 
      if (this.getIsCompleteInBox()!=null)
         sb.append (this.getIsCompleteInBox() +" - "); 
      if (this.getHardwareStateRating()!=null)
         sb.append (this.getHardwareStateRating() +" - "); 
      if (this.getBoxStateRating()!=null)
         sb.append (this.getBoxStateRating() +" - "); 
      if (this.getManualStateRating()!=null)
         sb.append (this.getManualStateRating() +" - "); 
      if (this.getComment()!=null)
         sb.append (this.getComment() +" - "); 
      if (this.getBarcode()!=null)
         sb.append (this.getBarcode() +" - "); 
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
            .append("accessorieId", accessorieId)
            .append("name", name)
            .append("description", description)
            .append("brand_", brand_)
            .append("color_", color_)
            .append("serialNumber", serialNumber)
            .append("region_", region_)
            .append("subRegionCode", subRegionCode)
            .append("releaseDate", releaseDate)
            .append("acquiringDate", acquiringDate)
            .append("acquiringPrice", acquiringPrice)
            .append("acquiredPriceFree", acquiredPriceFree)
            .append("acquiredPriceUnknown", acquiredPriceUnknown)
            .append("acquiringSellerName", acquiringSellerName)
            .append("acquiringPlace", acquiringPlace)
            .append("location_", location_)
            .append("hasBox", hasBox)
            .append("hasManual", hasManual)
            .append("hasInserts", hasInserts)
            .append("isSealed", isSealed)
            .append("isNew", isNew)
            .append("isCompleteInBox", isCompleteInBox)
            .append("hardwareStateRating", hardwareStateRating)
            .append("boxStateRating", boxStateRating)
            .append("manualStateRating", manualStateRating)
            .append("comment", comment)
            .append("barcode", barcode)
	 	;
	} 
		
	public String toString(Object object) {
	 	return getToStringBuilder(object).toString();
	} 
	
	public String toStringWithParents() {
	    ToStringBuilder toStringBuilder = getToStringBuilder(this);
        if (brand!=null)
            toStringBuilder.append("brand", brand.toStringWithParents());
        if (color!=null)
            toStringBuilder.append("color", color.toStringWithParents());
        if (location!=null)
            toStringBuilder.append("location", location.toStringWithParents());
        if (region!=null)
            toStringBuilder.append("region", region.toStringWithParents());
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
		if (!(object instanceof Accessorie)) return false;
		Accessorie accessorie = (Accessorie) object;
		if (accessorie.accessorieId==null || !accessorie.accessorieId.equals(accessorieId)) return false;
		return true;
	}    

	public boolean equalsMask(Object object) {
		if (object == null) return false;	
		if (object == this) return true;
		if (!(object instanceof Accessorie)) return false;
		Accessorie accessorie = (Accessorie) object;
		if (accessorieId!=null && accessorie.accessorieId!=null && !accessorie.accessorieId.equals(accessorieId)) return false;
		if ((accessorie.accessorieId!=null && accessorieId==null) || (accessorie.accessorieId==null && accessorieId!=null)) return false;
		if (name!=null && accessorie.name!=null && !accessorie.name.equals(name)) return false;
		if ((accessorie.name!=null && name==null) || (accessorie.name==null && name!=null)) return false;
		if (description!=null && accessorie.description!=null && !accessorie.description.equals(description)) return false;
		if ((accessorie.description!=null && description==null) || (accessorie.description==null && description!=null)) return false;
		if (brand!=null && accessorie.brand!=null && !accessorie.brand.equals(brand)) return false;
		if ((accessorie.brand!=null && brand==null) || (accessorie.brand==null && brand!=null)) return false;
		if (color!=null && accessorie.color!=null && !accessorie.color.equals(color)) return false;
		if ((accessorie.color!=null && color==null) || (accessorie.color==null && color!=null)) return false;
		if (serialNumber!=null && accessorie.serialNumber!=null && !accessorie.serialNumber.equals(serialNumber)) return false;
		if ((accessorie.serialNumber!=null && serialNumber==null) || (accessorie.serialNumber==null && serialNumber!=null)) return false;
		if (region!=null && accessorie.region!=null && !accessorie.region.equals(region)) return false;
		if ((accessorie.region!=null && region==null) || (accessorie.region==null && region!=null)) return false;
		if (subRegionCode!=null && accessorie.subRegionCode!=null && !accessorie.subRegionCode.equals(subRegionCode)) return false;
		if ((accessorie.subRegionCode!=null && subRegionCode==null) || (accessorie.subRegionCode==null && subRegionCode!=null)) return false;
		if (releaseDate!=null && accessorie.releaseDate!=null && !accessorie.releaseDate.equals(releaseDate)) return false;
		if ((accessorie.releaseDate!=null && releaseDate==null) || (accessorie.releaseDate==null && releaseDate!=null)) return false;
		if (acquiringDate!=null && accessorie.acquiringDate!=null && !accessorie.acquiringDate.equals(acquiringDate)) return false;
		if ((accessorie.acquiringDate!=null && acquiringDate==null) || (accessorie.acquiringDate==null && acquiringDate!=null)) return false;
		if (acquiringPrice!=null && accessorie.acquiringPrice!=null && !accessorie.acquiringPrice.equals(acquiringPrice)) return false;
		if ((accessorie.acquiringPrice!=null && acquiringPrice==null) || (accessorie.acquiringPrice==null && acquiringPrice!=null)) return false;
		if (acquiredPriceFree!=null && accessorie.acquiredPriceFree!=null && !accessorie.acquiredPriceFree.equals(acquiredPriceFree)) return false;
		if ((accessorie.acquiredPriceFree!=null && acquiredPriceFree==null) || (accessorie.acquiredPriceFree==null && acquiredPriceFree!=null)) return false;
		if (acquiredPriceUnknown!=null && accessorie.acquiredPriceUnknown!=null && !accessorie.acquiredPriceUnknown.equals(acquiredPriceUnknown)) return false;
		if ((accessorie.acquiredPriceUnknown!=null && acquiredPriceUnknown==null) || (accessorie.acquiredPriceUnknown==null && acquiredPriceUnknown!=null)) return false;
		if (acquiringSellerName!=null && accessorie.acquiringSellerName!=null && !accessorie.acquiringSellerName.equals(acquiringSellerName)) return false;
		if ((accessorie.acquiringSellerName!=null && acquiringSellerName==null) || (accessorie.acquiringSellerName==null && acquiringSellerName!=null)) return false;
		if (acquiringPlace!=null && accessorie.acquiringPlace!=null && !accessorie.acquiringPlace.equals(acquiringPlace)) return false;
		if ((accessorie.acquiringPlace!=null && acquiringPlace==null) || (accessorie.acquiringPlace==null && acquiringPlace!=null)) return false;
		if (location!=null && accessorie.location!=null && !accessorie.location.equals(location)) return false;
		if ((accessorie.location!=null && location==null) || (accessorie.location==null && location!=null)) return false;
		if (hasBox!=null && accessorie.hasBox!=null && !accessorie.hasBox.equals(hasBox)) return false;
		if ((accessorie.hasBox!=null && hasBox==null) || (accessorie.hasBox==null && hasBox!=null)) return false;
		if (hasManual!=null && accessorie.hasManual!=null && !accessorie.hasManual.equals(hasManual)) return false;
		if ((accessorie.hasManual!=null && hasManual==null) || (accessorie.hasManual==null && hasManual!=null)) return false;
		if (hasInserts!=null && accessorie.hasInserts!=null && !accessorie.hasInserts.equals(hasInserts)) return false;
		if ((accessorie.hasInserts!=null && hasInserts==null) || (accessorie.hasInserts==null && hasInserts!=null)) return false;
		if (isSealed!=null && accessorie.isSealed!=null && !accessorie.isSealed.equals(isSealed)) return false;
		if ((accessorie.isSealed!=null && isSealed==null) || (accessorie.isSealed==null && isSealed!=null)) return false;
		if (isNew!=null && accessorie.isNew!=null && !accessorie.isNew.equals(isNew)) return false;
		if ((accessorie.isNew!=null && isNew==null) || (accessorie.isNew==null && isNew!=null)) return false;
		if (isCompleteInBox!=null && accessorie.isCompleteInBox!=null && !accessorie.isCompleteInBox.equals(isCompleteInBox)) return false;
		if ((accessorie.isCompleteInBox!=null && isCompleteInBox==null) || (accessorie.isCompleteInBox==null && isCompleteInBox!=null)) return false;
		if (hardwareStateRating!=null && accessorie.hardwareStateRating!=null && !accessorie.hardwareStateRating.equals(hardwareStateRating)) return false;
		if ((accessorie.hardwareStateRating!=null && hardwareStateRating==null) || (accessorie.hardwareStateRating==null && hardwareStateRating!=null)) return false;
		if (boxStateRating!=null && accessorie.boxStateRating!=null && !accessorie.boxStateRating.equals(boxStateRating)) return false;
		if ((accessorie.boxStateRating!=null && boxStateRating==null) || (accessorie.boxStateRating==null && boxStateRating!=null)) return false;
		if (manualStateRating!=null && accessorie.manualStateRating!=null && !accessorie.manualStateRating.equals(manualStateRating)) return false;
		if ((accessorie.manualStateRating!=null && manualStateRating==null) || (accessorie.manualStateRating==null && manualStateRating!=null)) return false;
		if (comment!=null && accessorie.comment!=null && !accessorie.comment.equals(comment)) return false;
		if ((accessorie.comment!=null && comment==null) || (accessorie.comment==null && comment!=null)) return false;
		if (barcode!=null && accessorie.barcode!=null && !accessorie.barcode.equals(barcode)) return false;
		if ((accessorie.barcode!=null && barcode==null) || (accessorie.barcode==null && barcode!=null)) return false;
		return true;
	}

	public Accessorie clone() {
        Accessorie accessorie = flat();
        if (getBrand()!=null) 
            accessorie.setBrand (getBrand().clone());   
        if (getColor()!=null) 
            accessorie.setColor (getColor().clone());   
        if (getLocation()!=null) 
            accessorie.setLocation (getLocation().clone());   
        if (getRegion()!=null) 
            accessorie.setRegion (getRegion().clone());   
        return accessorie;
	}
	
	public void copy (Accessorie accessorie) {
		if (accessorie!=null) {
			setAccessorieId (accessorie.getAccessorieId());
			setName (accessorie.getName());
			setDescription (accessorie.getDescription());
			setBrand (accessorie.getBrand());
			setColor (accessorie.getColor());
			setSerialNumber (accessorie.getSerialNumber());
			setRegion (accessorie.getRegion());
			setSubRegionCode (accessorie.getSubRegionCode());
			setReleaseDate (accessorie.getReleaseDate());
			setAcquiringDate (accessorie.getAcquiringDate());
			setAcquiringPrice (accessorie.getAcquiringPrice());
			setAcquiredPriceFree (accessorie.getAcquiredPriceFree());
			setAcquiredPriceUnknown (accessorie.getAcquiredPriceUnknown());
			setAcquiringSellerName (accessorie.getAcquiringSellerName());
			setAcquiringPlace (accessorie.getAcquiringPlace());
			setLocation (accessorie.getLocation());
			setHasBox (accessorie.getHasBox());
			setHasManual (accessorie.getHasManual());
			setHasInserts (accessorie.getHasInserts());
			setIsSealed (accessorie.getIsSealed());
			setIsNew (accessorie.getIsNew());
			setIsCompleteInBox (accessorie.getIsCompleteInBox());
			setHardwareStateRating (accessorie.getHardwareStateRating());
			setBoxStateRating (accessorie.getBoxStateRating());
			setManualStateRating (accessorie.getManualStateRating());
			setComment (accessorie.getComment());
			setBarcode (accessorie.getBarcode());
		}
	}
	
	public static Accessorie fullMask() {
		return new Accessorie(
			integerMask__ ,
			stringMask__ ,
			null ,
			integerMask__ ,
			integerMask__ ,
			stringMask__ ,
			integerMask__ ,
			stringMask__ ,
			timestampMask__ ,
			timestampMask__ ,
			bigDecimalMask__ ,
			null ,
			null ,
			stringMask__ ,
			stringMask__ ,
			integerMask__ ,
			null ,
			null ,
			stringMask__ ,
			null ,
			null ,
			null ,
			integerMask__ ,
			integerMask__ ,
			integerMask__ ,
			stringMask__ ,
			null 		);
	}

    public Accessorie maskString(Map<String, String> filter) {
        for (Entry<String, String> set : filter.entrySet()) {
            mask(set.getKey(), getEntry(set.getKey(), set.getValue()));
        }
        return this;
    }
    
    public Object getEntry(String pattern, String value) {
        if(pattern==null || value==null) return null;
    	if ("accessorieId".equals(pattern))
           return Integer.valueOf(value);
        if ("name".equals(pattern))
           return value;
    	if ("description".equals(pattern))
           return null;
    	if ("brand".equals(pattern))
           return Integer.valueOf(value);
    	if ("color".equals(pattern))
           return Integer.valueOf(value);
        if ("serialNumber".equals(pattern))
           return value;
    	if ("region".equals(pattern))
           return Integer.valueOf(value);
        if ("subRegionCode".equals(pattern))
           return value;
    	if ("releaseDate".equals(pattern))
           return new Date(value);
    	if ("acquiringDate".equals(pattern))
           return new Date(value);
    	if ("acquiringPrice".equals(pattern))
           return java.math.BigDecimal.valueOf(Double.valueOf(value));
    	if ("acquiredPriceFree".equals(pattern))
           return null;
    	if ("acquiredPriceUnknown".equals(pattern))
           return null;
        if ("acquiringSellerName".equals(pattern))
           return value;
        if ("acquiringPlace".equals(pattern))
           return value;
    	if ("location".equals(pattern))
           return Integer.valueOf(value);
    	if ("hasBox".equals(pattern))
           return null;
    	if ("hasManual".equals(pattern))
           return null;
        if ("hasInserts".equals(pattern))
           return value;
    	if ("isSealed".equals(pattern))
           return null;
    	if ("isNew".equals(pattern))
           return null;
    	if ("isCompleteInBox".equals(pattern))
           return null;
    	if ("hardwareStateRating".equals(pattern))
           return Integer.valueOf(value);
    	if ("boxStateRating".equals(pattern))
           return Integer.valueOf(value);
    	if ("manualStateRating".equals(pattern))
           return Integer.valueOf(value);
        if ("comment".equals(pattern))
           return value;
    	if ("barcode".equals(pattern))
           return null;
        return null;
    }	
				
    public Accessorie mask(Map<String, Object> filter) {
        for (Entry<String, Object> set : filter.entrySet()) {
            mask(set.getKey(), set.getValue());
        }
        return this;
    }
    
    public Accessorie mask(String pattern, Object value) {
        if(pattern==null || value==null) return this;
		if ("accessorieId".equals(pattern)) {
           setAccessorieId((Integer)value);
		   return this;
		}
        if ("name".equals(pattern)) {
           setName(value.toString());
		   return this;
		}
		if ("description".equals(pattern)) {
           setDescription(null);
		   return this;
		}
		if ("brand".equals(pattern)) {
           setBrand_((Integer)value);
		   return this;
		}
		if ("color".equals(pattern)) {
           setColor_((Integer)value);
		   return this;
		}
        if ("serialNumber".equals(pattern)) {
           setSerialNumber(value.toString());
		   return this;
		}
		if ("region".equals(pattern)) {
           setRegion_((Integer)value);
		   return this;
		}
        if ("subRegionCode".equals(pattern)) {
           setSubRegionCode(value.toString());
		   return this;
		}
		if ("releaseDate".equals(pattern)) {
           setReleaseDate((Date)value);
		   return this;
		}
		if ("acquiringDate".equals(pattern)) {
           setAcquiringDate((Date)value);
		   return this;
		}
		if ("acquiringPrice".equals(pattern)) {
           setAcquiringPrice((java.math.BigDecimal)value);
		   return this;
		}
		if ("acquiredPriceFree".equals(pattern)) {
           setAcquiredPriceFree((Boolean)value);
		   return this;
		}
		if ("acquiredPriceUnknown".equals(pattern)) {
           setAcquiredPriceUnknown((Boolean)value);
		   return this;
		}
        if ("acquiringSellerName".equals(pattern)) {
           setAcquiringSellerName(value.toString());
		   return this;
		}
        if ("acquiringPlace".equals(pattern)) {
           setAcquiringPlace(value.toString());
		   return this;
		}
		if ("location".equals(pattern)) {
           setLocation_((Integer)value);
		   return this;
		}
		if ("hasBox".equals(pattern)) {
           setHasBox((Boolean)value);
		   return this;
		}
		if ("hasManual".equals(pattern)) {
           setHasManual((Boolean)value);
		   return this;
		}
        if ("hasInserts".equals(pattern)) {
           setHasInserts(value.toString());
		   return this;
		}
		if ("isSealed".equals(pattern)) {
           setIsSealed((Boolean)value);
		   return this;
		}
		if ("isNew".equals(pattern)) {
           setIsNew((Boolean)value);
		   return this;
		}
		if ("isCompleteInBox".equals(pattern)) {
           setIsCompleteInBox((Boolean)value);
		   return this;
		}
		if ("hardwareStateRating".equals(pattern)) {
           setHardwareStateRating((Integer)value);
		   return this;
		}
		if ("boxStateRating".equals(pattern)) {
           setBoxStateRating((Integer)value);
		   return this;
		}
		if ("manualStateRating".equals(pattern)) {
           setManualStateRating((Integer)value);
		   return this;
		}
        if ("comment".equals(pattern)) {
           setComment(value.toString());
		   return this;
		}
		if ("barcode".equals(pattern)) {
           setBarcode(null);
		   return this;
		}
        return this;
    }

    public Accessorie mask(String pattern) {
        if(pattern==null) return this;
        if ("name".equals(pattern))
           setName(stringMask__);
        if ("serialNumber".equals(pattern))
           setSerialNumber(stringMask__);
        if ("subRegionCode".equals(pattern))
           setSubRegionCode(stringMask__);
        if ("acquiringSellerName".equals(pattern))
           setAcquiringSellerName(stringMask__);
        if ("acquiringPlace".equals(pattern))
           setAcquiringPlace(stringMask__);
        if ("hasInserts".equals(pattern))
           setHasInserts(stringMask__);
        if ("comment".equals(pattern))
           setComment(stringMask__);
        return this;
    }

	public void assignNullToBlank () {
        if (StringUtils.isEmpty(getName()))
           setName(null);
        if (StringUtils.isEmpty(getDescription()))
           setDescription(null);
        if (StringUtils.isEmpty(getSerialNumber()))
           setSerialNumber(null);
        if (StringUtils.isEmpty(getSubRegionCode()))
           setSubRegionCode(null);
        if (StringUtils.isEmpty(getAcquiringSellerName()))
           setAcquiringSellerName(null);
        if (StringUtils.isEmpty(getAcquiringPlace()))
           setAcquiringPlace(null);
        if (StringUtils.isEmpty(getHasInserts()))
           setHasInserts(null);
        if (StringUtils.isEmpty(getComment()))
           setComment(null);
        if (StringUtils.isEmpty(getBarcode()))
           setBarcode(null);
	}

    public Integer getAccessorieId() {
        return accessorieId;
    }
    public void setAccessorieId (Integer accessorieId) {
        this.accessorieId =  accessorieId;
    }
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
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-SERIAL_NUMBER@
    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber (String serialNumber) {
        this.serialNumber =  serialNumber;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-SUB_REGION_CODE@
    public String getSubRegionCode() {
        return subRegionCode;
    }
    public void setSubRegionCode (String subRegionCode) {
        this.subRegionCode =  subRegionCode;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-RELEASE_DATE@
    public java.util.Date getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate (java.util.Date releaseDate) {
        this.releaseDate =  releaseDate;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-ACQUIRING_DATE@
    public java.util.Date getAcquiringDate() {
        return acquiringDate;
    }
    public void setAcquiringDate (java.util.Date acquiringDate) {
        this.acquiringDate =  acquiringDate;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-ACQUIRING_PRICE@
    public java.math.BigDecimal getAcquiringPrice() {
        return acquiringPrice;
    }
    public void setAcquiringPrice (java.math.BigDecimal acquiringPrice) {
        this.acquiringPrice =  acquiringPrice;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-ACQUIRED_PRICE_FREE@
    public Boolean getAcquiredPriceFree() {
        return acquiredPriceFree;
    }
    public void setAcquiredPriceFree (Boolean acquiredPriceFree) {
        this.acquiredPriceFree =  acquiredPriceFree;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-ACQUIRED_PRICE_UNKNOWN@
    public Boolean getAcquiredPriceUnknown() {
        return acquiredPriceUnknown;
    }
    public void setAcquiredPriceUnknown (Boolean acquiredPriceUnknown) {
        this.acquiredPriceUnknown =  acquiredPriceUnknown;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-ACQUIRING_SELLER_NAME@
    public String getAcquiringSellerName() {
        return acquiringSellerName;
    }
    public void setAcquiringSellerName (String acquiringSellerName) {
        this.acquiringSellerName =  acquiringSellerName;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-ACQUIRING_PLACE@
    public String getAcquiringPlace() {
        return acquiringPlace;
    }
    public void setAcquiringPlace (String acquiringPlace) {
        this.acquiringPlace =  acquiringPlace;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-HAS_BOX@
    public Boolean getHasBox() {
        return hasBox;
    }
    public void setHasBox (Boolean hasBox) {
        this.hasBox =  hasBox;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-HAS_MANUAL@
    public Boolean getHasManual() {
        return hasManual;
    }
    public void setHasManual (Boolean hasManual) {
        this.hasManual =  hasManual;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-HAS_INSERTS@
    public String getHasInserts() {
        return hasInserts;
    }
    public void setHasInserts (String hasInserts) {
        this.hasInserts =  hasInserts;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-IS_SEALED@
    public Boolean getIsSealed() {
        return isSealed;
    }
    public void setIsSealed (Boolean isSealed) {
        this.isSealed =  isSealed;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-IS_NEW@
    public Boolean getIsNew() {
        return isNew;
    }
    public void setIsNew (Boolean isNew) {
        this.isNew =  isNew;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-IS_COMPLETE_IN_BOX@
    public Boolean getIsCompleteInBox() {
        return isCompleteInBox;
    }
    public void setIsCompleteInBox (Boolean isCompleteInBox) {
        this.isCompleteInBox =  isCompleteInBox;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-HARDWARE_STATE_RATING@
    public Integer getHardwareStateRating() {
        return hardwareStateRating;
    }
    public void setHardwareStateRating (Integer hardwareStateRating) {
        this.hardwareStateRating =  hardwareStateRating;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-BOX_STATE_RATING@
    public Integer getBoxStateRating() {
        return boxStateRating;
    }
    public void setBoxStateRating (Integer boxStateRating) {
        this.boxStateRating =  boxStateRating;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-MANUAL_STATE_RATING@
    public Integer getManualStateRating() {
        return manualStateRating;
    }
    public void setManualStateRating (Integer manualStateRating) {
        this.manualStateRating =  manualStateRating;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-COMMENT@
    public String getComment() {
        return comment;
    }
    public void setComment (String comment) {
        this.comment =  comment;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-BARCODE@
    public String getBarcode() {
        return barcode;
    }
    public void setBarcode (String barcode) {
        this.barcode =  barcode;
    }
//MP-MANAGED-UPDATABLE-ENDING

    public Producer getBrand () {
    	return brand;
    }
	
    public void setBrand (Producer brand) {
    	this.brand = brand;
    }

    public Integer getBrand_() {
        return brand_;
    }
	
    public void setBrand_ (Integer brand) {
        this.brand_ =  brand;
    }
	
    public ValueList getColor () {
    	return color;
    }
	
    public void setColor (ValueList color) {
    	this.color = color;
    }

    public Integer getColor_() {
        return color_;
    }
	
    public void setColor_ (Integer color) {
        this.color_ =  color;
    }
	
    public Location getLocation () {
    	return location;
    }
	
    public void setLocation (Location location) {
    	this.location = location;
    }

    public Integer getLocation_() {
        return location_;
    }
	
    public void setLocation_ (Integer location) {
        this.location_ =  location;
    }
	
    public ValueList getRegion () {
    	return region;
    }
	
    public void setRegion (ValueList region) {
    	this.region = region;
    }

    public Integer getRegion_() {
        return region_;
    }
	
    public void setRegion_ (Integer region) {
        this.region_ =  region;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @hardwareAccessorieViaAccessorieByAccessorieId-getter-accessorie@
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @photoAccessorieViaAccessorieIdPk-getter-accessorie@
    public Set<Photo> getPhotoAccessorieViaAccessorieIdPk() {
        if (photoAccessorieViaAccessorieIdPk == null){
            photoAccessorieViaAccessorieIdPk = new HashSet<Photo>();
        }
        return photoAccessorieViaAccessorieIdPk;
    }

    public void setPhotoAccessorieViaAccessorieIdPk (Set<Photo> photoAccessorieViaAccessorieIdPk) {
        this.photoAccessorieViaAccessorieIdPk = photoAccessorieViaAccessorieIdPk;
    }	
    
    public void addPhotoAccessorieViaAccessorieIdPk (Photo element) {
    	    getPhotoAccessorieViaAccessorieIdPk().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @tagAccessorieViaAccessorieByAccessorieId-getter-accessorie@
//MP-MANAGED-UPDATABLE-ENDING

    public Set<Hardware> getHardwareViaHardwareAccessorieByHardwareIdFk() {
        if (hardwareViaHardwareAccessorieByHardwareIdFk == null){
            hardwareViaHardwareAccessorieByHardwareIdFk = new HashSet<Hardware>();
        }
        return hardwareViaHardwareAccessorieByHardwareIdFk;
    }

    public void setHardwareViaHardwareAccessorieByHardwareIdFk (Set<Hardware> hardwareViaHardwareAccessorieByHardwareIdFk) {
        this.hardwareViaHardwareAccessorieByHardwareIdFk = hardwareViaHardwareAccessorieByHardwareIdFk;
    }
    	
    public void addHardwareViaHardwareAccessorieByHardwareIdFk (Hardware element) {
        getHardwareViaHardwareAccessorieByHardwareIdFk().add(element);
    }
	
    public Set<Tag> getTagViaTagAccessorieByTagIdFk() {
        if (tagViaTagAccessorieByTagIdFk == null){
            tagViaTagAccessorieByTagIdFk = new HashSet<Tag>();
        }
        return tagViaTagAccessorieByTagIdFk;
    }

    public void setTagViaTagAccessorieByTagIdFk (Set<Tag> tagViaTagAccessorieByTagIdFk) {
        this.tagViaTagAccessorieByTagIdFk = tagViaTagAccessorieByTagIdFk;
    }
    	
    public void addTagViaTagAccessorieByTagIdFk (Tag element) {
        getTagViaTagAccessorieByTagIdFk().add(element);
    }
	


//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
