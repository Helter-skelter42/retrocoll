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
 * <p>Title: User</p>
 *
 * <p>Description: Domain Object describing a User entity</p>
 *
 */
@Entity (name="User")
@Table (name="\"user\"")
@NamedQueries ({
	 @NamedQuery(name=User.FIND_ALL, query="SELECT a FROM User a")
	,@NamedQuery(name=User.FIND_BY_USERNAME, query="SELECT a FROM User a WHERE a.username = :username")
	,@NamedQuery(name=User.FIND_BY_USERNAME_CONTAINING, query="SELECT a FROM User a WHERE a.username like :username")
	,@NamedQuery(name=User.FIND_BY_PASSWORD, query="SELECT a FROM User a WHERE a.password = :password")
	,@NamedQuery(name=User.FIND_BY_PASSWORD_CONTAINING, query="SELECT a FROM User a WHERE a.password like :password")
	,@NamedQuery(name=User.FIND_BY_CREATETIME, query="SELECT a FROM User a WHERE a.createTime = :createTime")
})
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(namespace="com.retrocoll.server.domain.server", name = "User")
@XmlRootElement(namespace="com.retrocoll.server.domain.server")

public class User extends AbstractDomainObject {
    private static final long serialVersionUID = 1L;
    public static final String FIND_ALL = "User.findAll";
    public static final String FIND_BY_USERNAME = "User.findByUsername";
    public static final String FIND_BY_USERNAME_CONTAINING ="User.findByUsernameContaining";
    public static final String FIND_BY_PASSWORD = "User.findByPassword";
    public static final String FIND_BY_PASSWORD_CONTAINING ="User.findByPasswordContaining";
    public static final String FIND_BY_CREATETIME = "User.findByCreateTime";
	
    @Id @Column(name="EMAIL" ,length=255) 
    @XmlElement (name="email")
    private String email;

//MP-MANAGED-ADDED-AREA-BEGINNING @USERNAME-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @USERNAME-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-USERNAME@
    @Column(name="USERNAME"  , length=16 , nullable=false , unique=false)
    @XmlElement (name="username")
    private String username; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @PASSWORD-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @PASSWORD-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-PASSWORD@
    @Column(name="PASSWORD"  , length=32 , nullable=false , unique=false)
    @XmlElement (name="password")
    private String password; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @CREATE_TIME-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @CREATE_TIME-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-CREATE_TIME@
    @Column(name="CREATE_TIME"   , nullable=true , unique=false)
    @XmlElement (name="create-time")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createTime; 
//MP-MANAGED-UPDATABLE-ENDING

    /**
    * Default constructor
    */
    public User() {
    }

	/**
	* All field constructor 
	*/
    public User(
       String username,
       String email,
       String password,
       java.util.Date createTime) {
	 this(
       username,
       email,
       password,
       createTime
	 ,true);
	}
    
	public User(
       String username,
       String email,
       String password,
       java.util.Date createTime	
    , boolean setRelationship) {
       //primary keys
       setEmail (email);
       //attributes
       setUsername (username);
       setPassword (password);
       setCreateTime (createTime);
       //parents
    }

	public User flat() {
	   return new User(
          getUsername(),
          getEmail(),
          getPassword(),
          getCreateTime()
       , false
	   );
	}

    /**
    * display semanticReference with attribute inside class
    */
	public String display() {
	  StringBuffer sb = new StringBuffer();
      if (this.getUsername()!=null)
         sb.append (this.getUsername() +" " ); 
      if (this.getEmail()!=null)
         sb.append (this.getEmail() +" " ); 
      if (this.getPassword()!=null)
         sb.append (this.getPassword() +" " ); 
      if (this.getCreateTime()!=null)
         sb.append (this.getCreateTime() +" " ); 
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
            .append("email", email)
            .append("username", username)
            .append("password", password)
            .append("createTime", createTime)
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
		if (!(object instanceof User)) return false;
		User user = (User) object;
		if (user.email==null || !user.email.equals(email)) return false;
		return true;
	}    

	public boolean equalsMask(Object object) {
		if (object == null) return false;	
		if (object == this) return true;
		if (!(object instanceof User)) return false;
		User user = (User) object;
		if (email!=null && user.email!=null && !user.email.equals(email)) return false;
		if ((user.email!=null && email==null) || (user.email==null && email!=null)) return false;
		if (username!=null && user.username!=null && !user.username.equals(username)) return false;
		if ((user.username!=null && username==null) || (user.username==null && username!=null)) return false;
		if (password!=null && user.password!=null && !user.password.equals(password)) return false;
		if ((user.password!=null && password==null) || (user.password==null && password!=null)) return false;
		if (createTime!=null && user.createTime!=null && !user.createTime.equals(createTime)) return false;
		if ((user.createTime!=null && createTime==null) || (user.createTime==null && createTime!=null)) return false;
		return true;
	}

	public User clone() {
        User user = flat();
        return user;
	}
	
	public void copy (User user) {
		if (user!=null) {
			setEmail (user.getEmail());
			setUsername (user.getUsername());
			setPassword (user.getPassword());
			setCreateTime (user.getCreateTime());
		}
	}
	
	public static User fullMask() {
		return new User(
			stringMask__ ,
			stringMask__ ,
			stringMask__ ,
			timestampMask__ 		);
	}

    public User maskString(Map<String, String> filter) {
        for (Entry<String, String> set : filter.entrySet()) {
            mask(set.getKey(), getEntry(set.getKey(), set.getValue()));
        }
        return this;
    }
    
    public Object getEntry(String pattern, String value) {
        if(pattern==null || value==null) return null;
        if ("username".equals(pattern))
           return value;
        if ("email".equals(pattern))
           return value;
        if ("password".equals(pattern))
           return value;
    	if ("createTime".equals(pattern))
           return new Date(value);
        return null;
    }	
				
    public User mask(Map<String, Object> filter) {
        for (Entry<String, Object> set : filter.entrySet()) {
            mask(set.getKey(), set.getValue());
        }
        return this;
    }
    
    public User mask(String pattern, Object value) {
        if(pattern==null || value==null) return this;
        if ("username".equals(pattern)) {
           setUsername(value.toString());
		   return this;
		}
        if ("email".equals(pattern)) {
           setEmail(value.toString());
		   return this;
		}
        if ("password".equals(pattern)) {
           setPassword(value.toString());
		   return this;
		}
		if ("createTime".equals(pattern)) {
           setCreateTime((Date)value);
		   return this;
		}
        return this;
    }

    public User mask(String pattern) {
        if(pattern==null) return this;
        if ("username".equals(pattern))
           setUsername(stringMask__);
        if ("email".equals(pattern))
           setEmail(stringMask__);
        if ("password".equals(pattern))
           setPassword(stringMask__);
        return this;
    }

	public void assignNullToBlank () {
        if (StringUtils.isEmpty(getUsername()))
           setUsername(null);
        if (StringUtils.isEmpty(getEmail()))
           setEmail(null);
        if (StringUtils.isEmpty(getPassword()))
           setPassword(null);
	}

    public String getEmail() {
        return email;
    }
    public void setEmail (String email) {
        this.email =  email;
    }
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-USERNAME@
    public String getUsername() {
        return username;
    }
    public void setUsername (String username) {
        this.username =  username;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-PASSWORD@
    public String getPassword() {
        return password;
    }
    public void setPassword (String password) {
        this.password =  password;
    }
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-CREATE_TIME@
    public java.util.Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime (java.util.Date createTime) {
        this.createTime =  createTime;
    }
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-user@
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-user@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
