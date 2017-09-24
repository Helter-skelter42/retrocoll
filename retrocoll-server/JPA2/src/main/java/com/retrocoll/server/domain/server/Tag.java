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
import com.retrocoll.server.domain.server.TagId;

/**
 *
 * <p>
 * Title: Tag
 * </p>
 *
 * <p>
 * Description: Domain Object describing a Tag entity
 * </p>
 *
 */
@Entity(name = "Tag")
@Table(name = "\"tag\"")
@NamedQueries({ @NamedQuery(name = Tag.FIND_ALL, query = "SELECT a FROM Tag a") })
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(namespace = "com.retrocoll.server.domain.server", name = "Tag")
@XmlRootElement(namespace = "com.retrocoll.server.domain.server")

public class Tag extends AbstractDomainObject {
	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL = "Tag.findAll";
	public static final String FIND_BY_TAGID_CONTAINING = "Tag.findByTagIdContaining";
	public static final String FIND_BY_NAME_CONTAINING = "Tag.findByNameContaining";

	@EmbeddedId
	public TagId tagId__;
	@Column(name = "TAG_ID", nullable = false, unique = false, insertable = false, updatable = false)
	private Integer tagId_;
	@Column(name = "NAME", length = 45, nullable = false, unique = false, insertable = false, updatable = false)
	private String name_;
	// MP-MANAGED-UPDATABLE-BEGINNING-DISABLE
	// @m2m-accessorieViaTagAccessorieByAccessorieIdFk-tag@
	@XmlTransient
	@ManyToMany
	@JoinTable(name = "TAG_ACCESSORIE", joinColumns = {@JoinColumn(name="TAG_ID_FK", referencedColumnName="TAG_ID")}, inverseJoinColumns = {@JoinColumn(name="ACCESSORIE_ID_FK", referencedColumnName="ACCESSORIE_ID")})
	private Set<Accessorie> accessorieViaTagAccessorieByAccessorieIdFk = new HashSet<Accessorie>();

	// MP-MANAGED-UPDATABLE-ENDING
	// MP-MANAGED-UPDATABLE-BEGINNING-DISABLE
	// @m2m-hardwareViaTagHardwareByHardwareIdFk-tag@
	@XmlTransient
	@ManyToMany
	@JoinTable(name = "TAG_HARDWARE", joinColumns = {@JoinColumn(name="TAG_ID_FK", referencedColumnName="TAG_ID")}, inverseJoinColumns = {@JoinColumn(name="HARDWARE_ID_FK", referencedColumnName="HARDWARE_ID")})
	private Set<Hardware> hardwareViaTagHardwareByHardwareIdFk = new HashSet<Hardware>();

	// MP-MANAGED-UPDATABLE-ENDING
	// MP-MANAGED-UPDATABLE-BEGINNING-DISABLE
	// @m2m-softwareViaTagSoftwareBySoftwareIdFk-tag@
	@XmlTransient
	@ManyToMany
	@JoinTable(name = "TAG_SOFTWARE", joinColumns = {
			@JoinColumn(name = "TAG_ID_FK", referencedColumnName = "TAG_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "SOFTWARE_ID_FK", referencedColumnName = "SOFTWARE_ID") })
	private Set<Software> softwareViaTagSoftwareBySoftwareIdFk = new HashSet<Software>();

	// MP-MANAGED-UPDATABLE-ENDING
	/**
	 * Default constructor
	 */
	public Tag() {
	}

	/**
	 * All field constructor
	 */
	public Tag(Integer tagId, String name) {
		this(tagId, name, true);
	}

	public Tag(Integer tagId, String name, boolean setRelationship) {
		// primary keys
		this.tagId__ = new TagId();
		this.tagId__.setTagId(tagId);
		this.tagId__.setName(name);
		// attributes
		// parents
	}

	public Tag flat() {
		return new Tag(getTagId__().getTagId(), getTagId__().getName(), false);
	}

	/**
	 * display semanticReference with attribute inside class
	 */
	public String display() {
		StringBuffer sb = new StringBuffer();
		if (this.getName_() != null)
			sb.append(this.getName_() + " ");
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
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("tagId_", tagId_).append("name_",
				name_);
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
		return new HashCodeBuilder(17, 31).append(display()).toHashCode();
	}

	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (object == this)
			return true;
		if (!(object instanceof Tag))
			return false;
		Tag tag = (Tag) object;
		// not supported yet for composite pk
		return true;
	}

	public boolean equalsMask(Object object) {
		if (object == null)
			return false;
		if (object == this)
			return true;
		if (!(object instanceof Tag))
			return false;
		Tag tag = (Tag) object;
		// not supported yet for composite pk
		return true;
	}

	public Tag clone() {
		Tag tag = flat();
		return tag;
	}

	public void copy(Tag tag) {
		if (tag != null) {
			setTagId_(tag.getTagId_());
			setName_(tag.getName_());
		}
	}

	public static Tag fullMask() {
		return new Tag(integerMask__, stringMask__);
	}

	public Tag maskString(Map<String, String> filter) {
		for (Entry<String, String> set : filter.entrySet()) {
			mask(set.getKey(), getEntry(set.getKey(), set.getValue()));
		}
		return this;
	}

	public Object getEntry(String pattern, String value) {
		if (pattern == null || value == null)
			return null;
		if ("tagId".equals(pattern))
			return Integer.valueOf(value);
		if ("name".equals(pattern))
			return value;
		return null;
	}

	public Tag mask(Map<String, Object> filter) {
		for (Entry<String, Object> set : filter.entrySet()) {
			mask(set.getKey(), set.getValue());
		}
		return this;
	}

	public Tag mask(String pattern, Object value) {
		if (pattern == null || value == null)
			return this;
		if ("tagId".equals(pattern)) {
			setTagId_((Integer) value);
			return this;
		}
		if ("name".equals(pattern)) {
			setName_(value.toString());
			return this;
		}
		return this;
	}

	public Tag mask(String pattern) {
		if (pattern == null)
			return this;
		if ("name".equals(pattern))
			setName_(stringMask__);
		return this;
	}

	public void assignNullToBlank() {
		if (StringUtils.isEmpty(getName_()))
			setName_(null);
	}

	public TagId getTagId__() {
		if (tagId__ == null)
			tagId__ = new TagId();
		return tagId__;
	}

	public void setTagId__(TagId tagId__) {
		this.tagId__ = tagId__;
	}

	public Integer getTagId_() {
		return tagId_;
	}

	public void setTagId_(Integer tagId) {
		this.tagId_ = tagId;
	}

	public String getName_() {
		return name_;
	}

	public void setName_(String name) {
		this.name_ = name;
	}

	// MP-MANAGED-UPDATABLE-BEGINNING-DISABLE
	// @tagAccessorieViaTagByTagId-getter-tag@
	// MP-MANAGED-UPDATABLE-ENDING
	// MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @tagHardwareViaTagByTagId-getter-tag@
	// MP-MANAGED-UPDATABLE-ENDING
	// MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @tagSoftwareViaTagByTagId-getter-tag@
	// MP-MANAGED-UPDATABLE-ENDING

	public Set<Accessorie> getAccessorieViaTagAccessorieByAccessorieIdFk() {
		if (accessorieViaTagAccessorieByAccessorieIdFk == null) {
			accessorieViaTagAccessorieByAccessorieIdFk = new HashSet<Accessorie>();
		}
		return accessorieViaTagAccessorieByAccessorieIdFk;
	}

	public void setAccessorieViaTagAccessorieByAccessorieIdFk(
			Set<Accessorie> accessorieViaTagAccessorieByAccessorieIdFk) {
		this.accessorieViaTagAccessorieByAccessorieIdFk = accessorieViaTagAccessorieByAccessorieIdFk;
	}

	public void addAccessorieViaTagAccessorieByAccessorieIdFk(Accessorie element) {
		getAccessorieViaTagAccessorieByAccessorieIdFk().add(element);
	}

	public Set<Hardware> getHardwareViaTagHardwareByHardwareIdFk() {
		if (hardwareViaTagHardwareByHardwareIdFk == null) {
			hardwareViaTagHardwareByHardwareIdFk = new HashSet<Hardware>();
		}
		return hardwareViaTagHardwareByHardwareIdFk;
	}

	public void setHardwareViaTagHardwareByHardwareIdFk(Set<Hardware> hardwareViaTagHardwareByHardwareIdFk) {
		this.hardwareViaTagHardwareByHardwareIdFk = hardwareViaTagHardwareByHardwareIdFk;
	}

	public void addHardwareViaTagHardwareByHardwareIdFk(Hardware element) {
		getHardwareViaTagHardwareByHardwareIdFk().add(element);
	}

	public Set<Software> getSoftwareViaTagSoftwareBySoftwareIdFk() {
		if (softwareViaTagSoftwareBySoftwareIdFk == null) {
			softwareViaTagSoftwareBySoftwareIdFk = new HashSet<Software>();
		}
		return softwareViaTagSoftwareBySoftwareIdFk;
	}

	public void setSoftwareViaTagSoftwareBySoftwareIdFk(Set<Software> softwareViaTagSoftwareBySoftwareIdFk) {
		this.softwareViaTagSoftwareBySoftwareIdFk = softwareViaTagSoftwareBySoftwareIdFk;
	}

	public void addSoftwareViaTagSoftwareBySoftwareIdFk(Software element) {
		getSoftwareViaTagSoftwareBySoftwareIdFk().add(element);
	}

	// MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
	// MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
