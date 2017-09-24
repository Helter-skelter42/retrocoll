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
import com.retrocoll.server.domain.server.Photo;
import com.retrocoll.server.domain.server.ValueList;
import com.retrocoll.server.domain.server.Location;
import com.retrocoll.server.domain.server.Producer;
import com.retrocoll.server.domain.server.Producer;
import com.retrocoll.server.domain.server.ValueList;
import com.retrocoll.server.domain.server.ValueList;
import com.retrocoll.server.domain.server.Hardware;
import com.retrocoll.server.domain.server.Tag;

/**
 *
 * <p>Title: Software</p>
 *
 * <p>Description: Domain Object describing a Software entity</p>
 *
 */
@Entity (name="Software")
@Table (name="\"software\"")
@NamedQueries ({
	 @NamedQuery(name=Software.FIND_ALL, query="SELECT a FROM Software a")
	,@NamedQuery(name=Software.FIND_BY_NAME, query="SELECT a FROM Software a WHERE a.name = :name")
	,@NamedQuery(name=Software.FIND_BY_NAME_CONTAINING, query="SELECT a FROM Software a WHERE a.name like :name")
	,@NamedQuery(name=Software.FIND_BY_DESCRIPTION, query="SELECT a FROM Software a WHERE a.description = :description")
	,@NamedQuery(name=Software.FIND_BY_DESCRIPTION_CONTAINING, query="SELECT a FROM Software a WHERE a.description like :description")
	,@NamedQuery(name=Software.FIND_BY_SERIALNUMBER, query="SELECT a FROM Software a WHERE a.serialNumber = :serialNumber")
	,@NamedQuery(name=Software.FIND_BY_SERIALNUMBER_CONTAINING, query="SELECT a FROM Software a WHERE a.serialNumber like :serialNumber")
	,@NamedQuery(name=Software.FIND_BY_SUBREGIONCODE, query="SELECT a FROM Software a WHERE a.subRegionCode = :subRegionCode")
	,@NamedQuery(name=Software.FIND_BY_SUBREGIONCODE_CONTAINING, query="SELECT a FROM Software a WHERE a.subRegionCode like :subRegionCode")
	,@NamedQuery(name=Software.FIND_BY_RELEASEDATE, query="SELECT a FROM Software a WHERE a.releaseDate = :releaseDate")
	,@NamedQuery(name=Software.FIND_BY_ACQUIRINGDATE, query="SELECT a FROM Software a WHERE a.acquiringDate = :acquiringDate")
	,@NamedQuery(name=Software.FIND_BY_ACQUIRINGPRICE, query="SELECT a FROM Software a WHERE a.acquiringPrice = :acquiringPrice")
	,@NamedQuery(name=Software.FIND_BY_ACQUIREDPRICEFREE, query="SELECT a FROM Software a WHERE a.acquiredPriceFree = :acquiredPriceFree")
	,@NamedQuery(name=Software.FIND_BY_ACQUIREDPRICEUNKNOWN, query="SELECT a FROM Software a WHERE a.acquiredPriceUnknown = :acquiredPriceUnknown")
	,@NamedQuery(name=Software.FIND_BY_ACQUIRINGSELLERNAME, query="SELECT a FROM Software a WHERE a.acquiringSellerName = :acquiringSellerName")
	,@NamedQuery(name=Software.FIND_BY_ACQUIRINGSELLERNAME_CONTAINING, query="SELECT a FROM Software a WHERE a.acquiringSellerName like :acquiringSellerName")
	,@NamedQuery(name=Software.FIND_BY_ACQUIRINGPLACE, query="SELECT a FROM Software a WHERE a.acquiringPlace = :acquiringPlace")
	,@NamedQuery(name=Software.FIND_BY_ACQUIRINGPLACE_CONTAINING, query="SELECT a FROM Software a WHERE a.acquiringPlace like :acquiringPlace")
	,@NamedQuery(name=Software.FIND_BY_HASBOX, query="SELECT a FROM Software a WHERE a.hasBox = :hasBox")
	,@NamedQuery(name=Software.FIND_BY_HASMANUAL, query="SELECT a FROM Software a WHERE a.hasManual = :hasManual")
	,@NamedQuery(name=Software.FIND_BY_HASINSERTS, query="SELECT a FROM Software a WHERE a.hasInserts = :hasInserts")
	,@NamedQuery(name=Software.FIND_BY_HASINSERTS_CONTAINING, query="SELECT a FROM Software a WHERE a.hasInserts like :hasInserts")
	,@NamedQuery(name=Software.FIND_BY_ISSEALED, query="SELECT a FROM Software a WHERE a.isSealed = :isSealed")
	,@NamedQuery(name=Software.FIND_BY_ISNEW, query="SELECT a FROM Software a WHERE a.isNew = :isNew")
	,@NamedQuery(name=Software.FIND_BY_ISCOMPLETEINBOX, query="SELECT a FROM Software a WHERE a.isCompleteInBox = :isCompleteInBox")
	,@NamedQuery(name=Software.FIND_BY_SOFTWARESTATERATING, query="SELECT a FROM Software a WHERE a.softwareStateRating = :softwareStateRating")
	,@NamedQuery(name=Software.FIND_BY_BOXSTATERATING, query="SELECT a FROM Software a WHERE a.boxStateRating = :boxStateRating")
	,@NamedQuery(name=Software.FIND_BY_MANUALSTATERATING, query="SELECT a FROM Software a WHERE a.manualStateRating = :manualStateRating")
	,@NamedQuery(name=Software.FIND_BY_COMMENT, query="SELECT a FROM Software a WHERE a.comment = :comment")
	,@NamedQuery(name=Software.FIND_BY_COMMENT_CONTAINING, query="SELECT a FROM Software a WHERE a.comment like :comment")
	,@NamedQuery(name=Software.FIND_BY_BARCODE, query="SELECT a FROM Software a WHERE a.barcode = :barcode")
	,@NamedQuery(name=Software.FIND_BY_BARCODE_CONTAINING, query="SELECT a FROM Software a WHERE a.barcode like :barcode")
})
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(namespace="com.retrocoll.server.domain.server", name = "Software")
@XmlRootElement(namespace="com.retrocoll.server.domain.server")

public class Software extends AbstractDomainObject {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "Software.findAll";
    public static final String FIND_BY_NAME = "Software.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="Software.findByNameContaining";
    public static final String FIND_BY_DESCRIPTION = "Software.findByDescription";
    public static final String FIND_BY_DESCRIPTION_CONTAINING ="Software.findByDescriptionContaining";
    public static final String FIND_BY_SERIALNUMBER = "Software.findBySerialNumber";
    public static final String FIND_BY_SERIALNUMBER_CONTAINING ="Software.findBySerialNumberContaining";
    public static final String FIND_BY_SUBREGIONCODE = "Software.findBySubRegionCode";
    public static final String FIND_BY_SUBREGIONCODE_CONTAINING ="Software.findBySubRegionCodeContaining";
    public static final String FIND_BY_RELEASEDATE = "Software.findByReleaseDate";
    public static final String FIND_BY_ACQUIRINGDATE = "Software.findByAcquiringDate";
    public static final String FIND_BY_ACQUIRINGPRICE = "Software.findByAcquiringPrice";
    public static final String FIND_BY_ACQUIREDPRICEFREE = "Software.findByAcquiredPriceFree";
    public static final String FIND_BY_ACQUIREDPRICEUNKNOWN = "Software.findByAcquiredPriceUnknown";
    public static final String FIND_BY_ACQUIRINGSELLERNAME = "Software.findByAcquiringSellerName";
    public static final String FIND_BY_ACQUIRINGSELLERNAME_CONTAINING ="Software.findByAcquiringSellerNameContaining";
    public static final String FIND_BY_ACQUIRINGPLACE = "Software.findByAcquiringPlace";
    public static final String FIND_BY_ACQUIRINGPLACE_CONTAINING ="Software.findByAcquiringPlaceContaining";
    public static final String FIND_BY_HASBOX = "Software.findByHasBox";
    public static final String FIND_BY_HASMANUAL = "Software.findByHasManual";
    public static final String FIND_BY_HASINSERTS = "Software.findByHasInserts";
    public static final String FIND_BY_HASINSERTS_CONTAINING ="Software.findByHasInsertsContaining";
    public static final String FIND_BY_ISSEALED = "Software.findByIsSealed";
    public static final String FIND_BY_ISNEW = "Software.findByIsNew";
    public static final String FIND_BY_ISCOMPLETEINBOX = "Software.findByIsCompleteInBox";
    public static final String FIND_BY_SOFTWARESTATERATING = "Software.findBySoftwareStateRating";
    public static final String FIND_BY_BOXSTATERATING = "Software.findByBoxStateRating";
    public static final String FIND_BY_MANUALSTATERATING = "Software.findByManualStateRating";
    public static final String FIND_BY_COMMENT = "Software.findByComment";
    public static final String FIND_BY_COMMENT_CONTAINING ="Software.findByCommentContaining";
    public static final String FIND_BY_BARCODE = "Software.findByBarcode";
    public static final String FIND_BY_BARCODE_CONTAINING ="Software.findByBarcodeContaining";
	
    @Id @Column(name="SOFTWARE_ID" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement (name="software-id")
    private Integer softwareId;

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

//MP-MANAGED-ADDED-AREA-BEGINNING @SOFTWARE_STATE_RATING-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @SOFTWARE_STATE_RATING-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-SOFTWARE_STATE_RATING@
    @Column(name="SOFTWARE_STATE_RATING"   , nullable=true , unique=false)
    @XmlElement (name="software-state-rating")
    private Integer softwareStateRating; 
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
    @JoinColumn(name="CONSOLE", referencedColumnName = "VALUE_ID" , nullable=true , unique=false , insertable=true, updatable=true) 
    @XmlElement (name="consoleRef")
    private ValueList console;  

    @XmlElement (name="console")
    @Column(name="CONSOLE"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer console_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="LOCATION", referencedColumnName = "LOCATION_ID" , nullable=true , unique=true  , insertable=true, updatable=true) 
    @XmlElement (name="locationRef")
    private Location location;  

    @XmlElement (name="location")
    @Column(name="LOCATION"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer location_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="EDITOR", referencedColumnName = "PRODUCER_ID" , nullable=true , unique=true  , insertable=true, updatable=true) 
    @XmlElement (name="editorRef")
    private Producer editor;  

    @XmlElement (name="editor")
    @Column(name="EDITOR"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer editor_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="DEVELOPPER", referencedColumnName = "PRODUCER_ID" , nullable=true , unique=true  , insertable=true, updatable=true) 
    @XmlElement (name="developperRef")
    private Producer developper;  

    @XmlElement (name="developper")
    @Column(name="DEVELOPPER"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer developper_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="REGION", referencedColumnName = "VALUE_ID" , nullable=true , unique=true  , insertable=true, updatable=true) 
    @XmlElement (name="regionRef")
    private ValueList region;  

    @XmlElement (name="region")
    @Column(name="REGION"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer region_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="STYLE", referencedColumnName = "VALUE_ID" , nullable=true , unique=true  , insertable=true, updatable=true) 
    @XmlElement (name="styleRef")
    private ValueList style;  

    @XmlElement (name="style")
    @Column(name="STYLE"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer style_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @photoSoftwareViaSoftwareIdPk-field-software@
    @XmlElement (name="photosoftwareviasoftwareidpk")
    @OneToMany (targetEntity=com.retrocoll.server.domain.server.Photo.class, fetch=FetchType.LAZY, mappedBy="softwareIdPk", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Photo> photoSoftwareViaSoftwareIdPk = new HashSet<Photo>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-hardwareViaHardwareSoftwareByHardwareIdFk-software@
    @XmlTransient
    @ManyToMany
    @JoinTable(name="HARDWARE_SOFTWARE", 
        joinColumns=@JoinColumn(name="SOFTWARE_ID_FK"), 
        inverseJoinColumns=@JoinColumn(name="HARDWARE_ID_FK") 
    )
    private Set <Hardware> hardwareViaHardwareSoftwareByHardwareIdFk = new HashSet <Hardware> ();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-tagViaTagSoftwareByTagIdFk-software@
    @XmlTransient
    @ManyToMany
    @JoinTable(name="TAG_SOFTWARE", 
        joinColumns= {@JoinColumn(name="SOFTWARE_ID_FK", referencedColumnName="SOFTWARE_ID")},
        inverseJoinColumns= {@JoinColumn(name="TAG_ID_FK", referencedColumnName="TAG_ID")} 
    )

    private Set <Tag> tagViaTagSoftwareByTagIdFk = new HashSet <Tag> ();

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Software() {
    }

	/**
	* All field constructor 
	*/
    public Software(
       Integer softwareId,
       Integer developper,
       Integer editor,
       String name,
       String description,
       Integer console,
       Integer style,
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
       Integer softwareStateRating,
       Integer boxStateRating,
       Integer manualStateRating,
       String comment,
       String barcode) {
	 this(
       softwareId,
       developper,
       editor,
       name,
       description,
       console,
       style,
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
       softwareStateRating,
       boxStateRating,
       manualStateRating,
       comment,
       barcode
	 ,true);
	}
    
	public Software(
       Integer softwareId,
       Integer developper,
       Integer editor,
       String name,
       String description,
       Integer console,
       Integer style,
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
       Integer softwareStateRating,
       Integer boxStateRating,
       Integer manualStateRating,
       String comment,
       String barcode	
    , boolean setRelationship) {
       //primary keys
       setSoftwareId (softwareId);
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
       setSoftwareStateRating (softwareStateRating);
       setBoxStateRating (boxStateRating);
       setManualStateRating (manualStateRating);
       setComment (comment);
       setBarcode (barcode);
       //parents
       if (setRelationship && console!=null) {
          this.console = new ValueList();
          this.console.setValueId(console);
	      setConsole_ (console);
       }
       if (setRelationship && location!=null) {
          this.location = new Location();
          this.location.setLocationId(location);
	      setLocation_ (location);
       }
       if (setRelationship && editor!=null) {
          this.editor = new Producer();
          this.editor.setProducerId(editor);
	      setEditor_ (editor);
       }
       if (setRelationship && developper!=null) {
          this.developper = new Producer();
          this.developper.setProducerId(developper);
	      setDevelopper_ (developper);
       }
       if (setRelationship && region!=null) {
          this.region = new ValueList();
          this.region.setValueId(region);
	      setRegion_ (region);
       }
       if (setRelationship && style!=null) {
          this.style = new ValueList();
          this.style.setValueId(style);
	      setStyle_ (style);
       }
    }

	public Software flat() {
	   return new Software(
          getSoftwareId(),
          getDevelopper_(),
          getEditor_(),
          getName(),
          getDescription(),
          getConsole_(),
          getStyle_(),
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
          getSoftwareStateRating(),
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
         sb.append (this.getName() +" - "); 
      if (this.getDescription()!=null)
         sb.append (this.getDescription() +" - "); 
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
      if (this.getSoftwareStateRating()!=null)
         sb.append (this.getSoftwareStateRating() +" - "); 
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
            .append("softwareId", softwareId)
            .append("developper_", developper_)
            .append("editor_", editor_)
            .append("name", name)
            .append("description", description)
            .append("console_", console_)
            .append("style_", style_)
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
            .append("softwareStateRating", softwareStateRating)
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
        if (console!=null)
            toStringBuilder.append("console", console.toStringWithParents());
        if (location!=null)
            toStringBuilder.append("location", location.toStringWithParents());
        if (editor!=null)
            toStringBuilder.append("editor", editor.toStringWithParents());
        if (developper!=null)
            toStringBuilder.append("developper", developper.toStringWithParents());
        if (region!=null)
            toStringBuilder.append("region", region.toStringWithParents());
        if (style!=null)
            toStringBuilder.append("style", style.toStringWithParents());
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
		if (!(object instanceof Software)) return false;
		Software software = (Software) object;
		if (software.softwareId==null || !software.softwareId.equals(softwareId)) return false;
		return true;
	}    

	public boolean equalsMask(Object object) {
		if (object == null) return false;	
		if (object == this) return true;
		if (!(object instanceof Software)) return false;
		Software software = (Software) object;
		if (softwareId!=null && software.softwareId!=null && !software.softwareId.equals(softwareId)) return false;
		if ((software.softwareId!=null && softwareId==null) || (software.softwareId==null && softwareId!=null)) return false;
		if (developper!=null && software.developper!=null && !software.developper.equals(developper)) return false;
		if ((software.developper!=null && developper==null) || (software.developper==null && developper!=null)) return false;
		if (editor!=null && software.editor!=null && !software.editor.equals(editor)) return false;
		if ((software.editor!=null && editor==null) || (software.editor==null && editor!=null)) return false;
		if (name!=null && software.name!=null && !software.name.equals(name)) return false;
		if ((software.name!=null && name==null) || (software.name==null && name!=null)) return false;
		if (description!=null && software.description!=null && !software.description.equals(description)) return false;
		if ((software.description!=null && description==null) || (software.description==null && description!=null)) return false;
		if (console!=null && software.console!=null && !software.console.equals(console)) return false;
		if ((software.console!=null && console==null) || (software.console==null && console!=null)) return false;
		if (style!=null && software.style!=null && !software.style.equals(style)) return false;
		if ((software.style!=null && style==null) || (software.style==null && style!=null)) return false;
		if (serialNumber!=null && software.serialNumber!=null && !software.serialNumber.equals(serialNumber)) return false;
		if ((software.serialNumber!=null && serialNumber==null) || (software.serialNumber==null && serialNumber!=null)) return false;
		if (region!=null && software.region!=null && !software.region.equals(region)) return false;
		if ((software.region!=null && region==null) || (software.region==null && region!=null)) return false;
		if (subRegionCode!=null && software.subRegionCode!=null && !software.subRegionCode.equals(subRegionCode)) return false;
		if ((software.subRegionCode!=null && subRegionCode==null) || (software.subRegionCode==null && subRegionCode!=null)) return false;
		if (releaseDate!=null && software.releaseDate!=null && !software.releaseDate.equals(releaseDate)) return false;
		if ((software.releaseDate!=null && releaseDate==null) || (software.releaseDate==null && releaseDate!=null)) return false;
		if (acquiringDate!=null && software.acquiringDate!=null && !software.acquiringDate.equals(acquiringDate)) return false;
		if ((software.acquiringDate!=null && acquiringDate==null) || (software.acquiringDate==null && acquiringDate!=null)) return false;
		if (acquiringPrice!=null && software.acquiringPrice!=null && !software.acquiringPrice.equals(acquiringPrice)) return false;
		if ((software.acquiringPrice!=null && acquiringPrice==null) || (software.acquiringPrice==null && acquiringPrice!=null)) return false;
		if (acquiredPriceFree!=null && software.acquiredPriceFree!=null && !software.acquiredPriceFree.equals(acquiredPriceFree)) return false;
		if ((software.acquiredPriceFree!=null && acquiredPriceFree==null) || (software.acquiredPriceFree==null && acquiredPriceFree!=null)) return false;
		if (acquiredPriceUnknown!=null && software.acquiredPriceUnknown!=null && !software.acquiredPriceUnknown.equals(acquiredPriceUnknown)) return false;
		if ((software.acquiredPriceUnknown!=null && acquiredPriceUnknown==null) || (software.acquiredPriceUnknown==null && acquiredPriceUnknown!=null)) return false;
		if (acquiringSellerName!=null && software.acquiringSellerName!=null && !software.acquiringSellerName.equals(acquiringSellerName)) return false;
		if ((software.acquiringSellerName!=null && acquiringSellerName==null) || (software.acquiringSellerName==null && acquiringSellerName!=null)) return false;
		if (acquiringPlace!=null && software.acquiringPlace!=null && !software.acquiringPlace.equals(acquiringPlace)) return false;
		if ((software.acquiringPlace!=null && acquiringPlace==null) || (software.acquiringPlace==null && acquiringPlace!=null)) return false;
		if (location!=null && software.location!=null && !software.location.equals(location)) return false;
		if ((software.location!=null && location==null) || (software.location==null && location!=null)) return false;
		if (hasBox!=null && software.hasBox!=null && !software.hasBox.equals(hasBox)) return false;
		if ((software.hasBox!=null && hasBox==null) || (software.hasBox==null && hasBox!=null)) return false;
		if (hasManual!=null && software.hasManual!=null && !software.hasManual.equals(hasManual)) return false;
		if ((software.hasManual!=null && hasManual==null) || (software.hasManual==null && hasManual!=null)) return false;
		if (hasInserts!=null && software.hasInserts!=null && !software.hasInserts.equals(hasInserts)) return false;
		if ((software.hasInserts!=null && hasInserts==null) || (software.hasInserts==null && hasInserts!=null)) return false;
		if (isSealed!=null && software.isSealed!=null && !software.isSealed.equals(isSealed)) return false;
		if ((software.isSealed!=null && isSealed==null) || (software.isSealed==null && isSealed!=null)) return false;
		if (isNew!=null && software.isNew!=null && !software.isNew.equals(isNew)) return false;
		if ((software.isNew!=null && isNew==null) || (software.isNew==null && isNew!=null)) return false;
		if (isCompleteInBox!=null && software.isCompleteInBox!=null && !software.isCompleteInBox.equals(isCompleteInBox)) return false;
		if ((software.isCompleteInBox!=null && isCompleteInBox==null) || (software.isCompleteInBox==null && isCompleteInBox!=null)) return false;
		if (softwareStateRating!=null && software.softwareStateRating!=null && !software.softwareStateRating.equals(softwareStateRating)) return false;
		if ((software.softwareStateRating!=null && softwareStateRating==null) || (software.softwareStateRating==null && softwareStateRating!=null)) return false;
		if (boxStateRating!=null && software.boxStateRating!=null && !software.boxStateRating.equals(boxStateRating)) return false;
		if ((software.boxStateRating!=null && boxStateRating==null) || (software.boxStateRating==null && boxStateRating!=null)) return false;
		if (manualStateRating!=null && software.manualStateRating!=null && !software.manualStateRating.equals(manualStateRating)) return false;
		if ((software.manualStateRating!=null && manualStateRating==null) || (software.manualStateRating==null && manualStateRating!=null)) return false;
		if (comment!=null && software.comment!=null && !software.comment.equals(comment)) return false;
		if ((software.comment!=null && comment==null) || (software.comment==null && comment!=null)) return false;
		if (barcode!=null && software.barcode!=null && !software.barcode.equals(barcode)) return false;
		if ((software.barcode!=null && barcode==null) || (software.barcode==null && barcode!=null)) return false;
		return true;
	}

	public Software clone() {
        Software software = flat();
        if (getConsole()!=null) 
            software.setConsole (getConsole().clone());   
        if (getLocation()!=null) 
            software.setLocation (getLocation().clone());   
        if (getEditor()!=null) 
            software.setEditor (getEditor().clone());   
        if (getDevelopper()!=null) 
            software.setDevelopper (getDevelopper().clone());   
        if (getRegion()!=null) 
            software.setRegion (getRegion().clone());   
        if (getStyle()!=null) 
            software.setStyle (getStyle().clone());   
        return software;
	}
	
	public void copy (Software software) {
		if (software!=null) {
			setSoftwareId (software.getSoftwareId());
			setDevelopper (software.getDevelopper());
			setEditor (software.getEditor());
			setName (software.getName());
			setDescription (software.getDescription());
			setConsole (software.getConsole());
			setStyle (software.getStyle());
			setSerialNumber (software.getSerialNumber());
			setRegion (software.getRegion());
			setSubRegionCode (software.getSubRegionCode());
			setReleaseDate (software.getReleaseDate());
			setAcquiringDate (software.getAcquiringDate());
			setAcquiringPrice (software.getAcquiringPrice());
			setAcquiredPriceFree (software.getAcquiredPriceFree());
			setAcquiredPriceUnknown (software.getAcquiredPriceUnknown());
			setAcquiringSellerName (software.getAcquiringSellerName());
			setAcquiringPlace (software.getAcquiringPlace());
			setLocation (software.getLocation());
			setHasBox (software.getHasBox());
			setHasManual (software.getHasManual());
			setHasInserts (software.getHasInserts());
			setIsSealed (software.getIsSealed());
			setIsNew (software.getIsNew());
			setIsCompleteInBox (software.getIsCompleteInBox());
			setSoftwareStateRating (software.getSoftwareStateRating());
			setBoxStateRating (software.getBoxStateRating());
			setManualStateRating (software.getManualStateRating());
			setComment (software.getComment());
			setBarcode (software.getBarcode());
		}
	}
	
	public static Software fullMask() {
		return new Software(
			integerMask__ ,
			integerMask__ ,
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

    public Software maskString(Map<String, String> filter) {
        for (Entry<String, String> set : filter.entrySet()) {
            mask(set.getKey(), getEntry(set.getKey(), set.getValue()));
        }
        return this;
    }
    
    public Object getEntry(String pattern, String value) {
        if(pattern==null || value==null) return null;
    	if ("softwareId".equals(pattern))
           return Integer.valueOf(value);
    	if ("developper".equals(pattern))
           return Integer.valueOf(value);
    	if ("editor".equals(pattern))
           return Integer.valueOf(value);
        if ("name".equals(pattern))
           return value;
    	if ("description".equals(pattern))
           return null;
    	if ("console".equals(pattern))
           return Integer.valueOf(value);
    	if ("style".equals(pattern))
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
    	if ("softwareStateRating".equals(pattern))
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
				
    public Software mask(Map<String, Object> filter) {
        for (Entry<String, Object> set : filter.entrySet()) {
            mask(set.getKey(), set.getValue());
        }
        return this;
    }
    
    public Software mask(String pattern, Object value) {
        if(pattern==null || value==null) return this;
		if ("softwareId".equals(pattern)) {
           setSoftwareId((Integer)value);
		   return this;
		}
		if ("developper".equals(pattern)) {
           setDevelopper_((Integer)value);
		   return this;
		}
		if ("editor".equals(pattern)) {
           setEditor_((Integer)value);
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
		if ("console".equals(pattern)) {
           setConsole_((Integer)value);
		   return this;
		}
		if ("style".equals(pattern)) {
           setStyle_((Integer)value);
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
		if ("softwareStateRating".equals(pattern)) {
           setSoftwareStateRating((Integer)value);
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

    public Software mask(String pattern) {
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

    public Integer getSoftwareId() {
        return softwareId;
    }
    public void setSoftwareId (Integer softwareId) {
        this.softwareId =  softwareId;
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
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-SOFTWARE_STATE_RATING@
    public Integer getSoftwareStateRating() {
        return softwareStateRating;
    }
    public void setSoftwareStateRating (Integer softwareStateRating) {
        this.softwareStateRating =  softwareStateRating;
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

    public ValueList getConsole () {
    	return console;
    }
	
    public void setConsole (ValueList console) {
    	this.console = console;
    }

    public Integer getConsole_() {
        return console_;
    }
	
    public void setConsole_ (Integer console) {
        this.console_ =  console;
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
	
    public Producer getEditor () {
    	return editor;
    }
	
    public void setEditor (Producer editor) {
    	this.editor = editor;
    }

    public Integer getEditor_() {
        return editor_;
    }
	
    public void setEditor_ (Integer editor) {
        this.editor_ =  editor;
    }
	
    public Producer getDevelopper () {
    	return developper;
    }
	
    public void setDevelopper (Producer developper) {
    	this.developper = developper;
    }

    public Integer getDevelopper_() {
        return developper_;
    }
	
    public void setDevelopper_ (Integer developper) {
        this.developper_ =  developper;
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
	
    public ValueList getStyle () {
    	return style;
    }
	
    public void setStyle (ValueList style) {
    	this.style = style;
    }

    public Integer getStyle_() {
        return style_;
    }
	
    public void setStyle_ (Integer style) {
        this.style_ =  style;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @hardwareSoftwareViaSoftwareBySoftwareId-getter-software@
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @photoSoftwareViaSoftwareIdPk-getter-software@
    public Set<Photo> getPhotoSoftwareViaSoftwareIdPk() {
        if (photoSoftwareViaSoftwareIdPk == null){
            photoSoftwareViaSoftwareIdPk = new HashSet<Photo>();
        }
        return photoSoftwareViaSoftwareIdPk;
    }

    public void setPhotoSoftwareViaSoftwareIdPk (Set<Photo> photoSoftwareViaSoftwareIdPk) {
        this.photoSoftwareViaSoftwareIdPk = photoSoftwareViaSoftwareIdPk;
    }	
    
    public void addPhotoSoftwareViaSoftwareIdPk (Photo element) {
    	    getPhotoSoftwareViaSoftwareIdPk().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @tagSoftwareViaSoftwareBySoftwareId-getter-software@
//MP-MANAGED-UPDATABLE-ENDING

    public Set<Hardware> getHardwareViaHardwareSoftwareByHardwareIdFk() {
        if (hardwareViaHardwareSoftwareByHardwareIdFk == null){
            hardwareViaHardwareSoftwareByHardwareIdFk = new HashSet<Hardware>();
        }
        return hardwareViaHardwareSoftwareByHardwareIdFk;
    }

    public void setHardwareViaHardwareSoftwareByHardwareIdFk (Set<Hardware> hardwareViaHardwareSoftwareByHardwareIdFk) {
        this.hardwareViaHardwareSoftwareByHardwareIdFk = hardwareViaHardwareSoftwareByHardwareIdFk;
    }
    	
    public void addHardwareViaHardwareSoftwareByHardwareIdFk (Hardware element) {
        getHardwareViaHardwareSoftwareByHardwareIdFk().add(element);
    }
	
    public Set<Tag> getTagViaTagSoftwareByTagIdFk() {
        if (tagViaTagSoftwareByTagIdFk == null){
            tagViaTagSoftwareByTagIdFk = new HashSet<Tag>();
        }
        return tagViaTagSoftwareByTagIdFk;
    }

    public void setTagViaTagSoftwareByTagIdFk (Set<Tag> tagViaTagSoftwareByTagIdFk) {
        this.tagViaTagSoftwareByTagIdFk = tagViaTagSoftwareByTagIdFk;
    }
    	
    public void addTagViaTagSoftwareByTagIdFk (Tag element) {
        getTagViaTagSoftwareByTagIdFk().add(element);
    }
	


//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
