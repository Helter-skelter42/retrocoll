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
import com.retrocoll.server.domain.server.ValueList;
import com.retrocoll.server.domain.server.Location;
import com.retrocoll.server.domain.server.Producer;
import com.retrocoll.server.domain.server.Producer;
import com.retrocoll.server.domain.server.ValueList;
import com.retrocoll.server.domain.server.ValueList;
import com.retrocoll.server.domain.server.Hardware;
import com.retrocoll.server.domain.server.Tag;

@StaticMetamodel(Software.class)
public class Software_ {

    public static volatile SingularAttribute<Software, Integer> softwareId;

    public static volatile SingularAttribute<Software, String> name;
    public static volatile SingularAttribute<Software, String> description;
    public static volatile SingularAttribute<Software, String> serialNumber;
    public static volatile SingularAttribute<Software, String> subRegionCode;
    public static volatile SingularAttribute<Software, Timestamp> releaseDate;
    public static volatile SingularAttribute<Software, Timestamp> acquiringDate;
    public static volatile SingularAttribute<Software, java.math.BigDecimal> acquiringPrice;
    public static volatile SingularAttribute<Software, Boolean> acquiredPriceFree;
    public static volatile SingularAttribute<Software, Boolean> acquiredPriceUnknown;
    public static volatile SingularAttribute<Software, String> acquiringSellerName;
    public static volatile SingularAttribute<Software, String> acquiringPlace;
    public static volatile SingularAttribute<Software, Boolean> hasBox;
    public static volatile SingularAttribute<Software, Boolean> hasManual;
    public static volatile SingularAttribute<Software, String> hasInserts;
    public static volatile SingularAttribute<Software, Boolean> isSealed;
    public static volatile SingularAttribute<Software, Boolean> isNew;
    public static volatile SingularAttribute<Software, Boolean> isCompleteInBox;
    public static volatile SingularAttribute<Software, Integer> softwareStateRating;
    public static volatile SingularAttribute<Software, Integer> boxStateRating;
    public static volatile SingularAttribute<Software, Integer> manualStateRating;
    public static volatile SingularAttribute<Software, String> comment;
    public static volatile SingularAttribute<Software, String> barcode;
    public static volatile SingularAttribute<Software, ValueList> console;
    public static volatile SingularAttribute<Software, Integer> console_;
    public static volatile SingularAttribute<Software, Location> location;
    public static volatile SingularAttribute<Software, Integer> location_;
    public static volatile SingularAttribute<Software, Producer> editor;
    public static volatile SingularAttribute<Software, Integer> editor_;
    public static volatile SingularAttribute<Software, Producer> developper;
    public static volatile SingularAttribute<Software, Integer> developper_;
    public static volatile SingularAttribute<Software, ValueList> region;
    public static volatile SingularAttribute<Software, Integer> region_;
    public static volatile SingularAttribute<Software, ValueList> style;
    public static volatile SingularAttribute<Software, Integer> style_;

    public static volatile SetAttribute<Software, Photo> photoSoftwareViaSoftwareIdPk;

    public static volatile SetAttribute<Software, Hardware> hardwareViaHardwareSoftwareByHardwareIdFk;
    public static volatile SetAttribute<Software, Tag> tagViaTagSoftwareByTagIdFk;

}
