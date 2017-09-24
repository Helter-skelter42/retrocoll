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
	* - name      : DomainEntityJPA2Metamodel
	* - file name : DomainEntityJPA2Metamodel.vm
	* - time      : 2017/09/16 ap. J.-C. at 19:38:21 CEST
*/
package com.retrocoll.server.domain.server;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import com.retrocoll.server.domain.server.Photo;
import com.retrocoll.server.domain.server.Producer;
import com.retrocoll.server.domain.server.ValueList;
import com.retrocoll.server.domain.server.Location;
import com.retrocoll.server.domain.server.ValueList;
import com.retrocoll.server.domain.server.Hardware;
import com.retrocoll.server.domain.server.Tag;

@StaticMetamodel(Accessorie.class)
public class Accessorie_ {

    public static volatile SingularAttribute<Accessorie, Integer> accessorieId;

    public static volatile SingularAttribute<Accessorie, String> name;
    public static volatile SingularAttribute<Accessorie, String> description;
    public static volatile SingularAttribute<Accessorie, String> serialNumber;
    public static volatile SingularAttribute<Accessorie, String> subRegionCode;
    public static volatile SingularAttribute<Accessorie, Timestamp> releaseDate;
    public static volatile SingularAttribute<Accessorie, Timestamp> acquiringDate;
    public static volatile SingularAttribute<Accessorie, java.math.BigDecimal> acquiringPrice;
    public static volatile SingularAttribute<Accessorie, Boolean> acquiredPriceFree;
    public static volatile SingularAttribute<Accessorie, Boolean> acquiredPriceUnknown;
    public static volatile SingularAttribute<Accessorie, String> acquiringSellerName;
    public static volatile SingularAttribute<Accessorie, String> acquiringPlace;
    public static volatile SingularAttribute<Accessorie, Boolean> hasBox;
    public static volatile SingularAttribute<Accessorie, Boolean> hasManual;
    public static volatile SingularAttribute<Accessorie, String> hasInserts;
    public static volatile SingularAttribute<Accessorie, Boolean> isSealed;
    public static volatile SingularAttribute<Accessorie, Boolean> isNew;
    public static volatile SingularAttribute<Accessorie, Boolean> isCompleteInBox;
    public static volatile SingularAttribute<Accessorie, Integer> hardwareStateRating;
    public static volatile SingularAttribute<Accessorie, Integer> boxStateRating;
    public static volatile SingularAttribute<Accessorie, Integer> manualStateRating;
    public static volatile SingularAttribute<Accessorie, String> comment;
    public static volatile SingularAttribute<Accessorie, String> barcode;
    public static volatile SingularAttribute<Accessorie, Producer> brand;
    public static volatile SingularAttribute<Accessorie, Integer> brand_;
    public static volatile SingularAttribute<Accessorie, ValueList> color;
    public static volatile SingularAttribute<Accessorie, Integer> color_;
    public static volatile SingularAttribute<Accessorie, Location> location;
    public static volatile SingularAttribute<Accessorie, Integer> location_;
    public static volatile SingularAttribute<Accessorie, ValueList> region;
    public static volatile SingularAttribute<Accessorie, Integer> region_;

    public static volatile SetAttribute<Accessorie, Photo> photoAccessorieViaAccessorieIdPk;

    public static volatile SetAttribute<Accessorie, Hardware> hardwareViaHardwareAccessorieByHardwareIdFk;
    public static volatile SetAttribute<Accessorie, Tag> tagViaTagAccessorieByTagIdFk;

}
