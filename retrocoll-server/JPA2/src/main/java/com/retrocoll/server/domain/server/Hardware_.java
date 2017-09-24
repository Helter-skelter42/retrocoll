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
import com.retrocoll.server.domain.server.Accessorie;
import com.retrocoll.server.domain.server.Software;
import com.retrocoll.server.domain.server.Tag;

@StaticMetamodel(Hardware.class)
public class Hardware_ {

    public static volatile SingularAttribute<Hardware, Integer> hardwareId;

    public static volatile SingularAttribute<Hardware, String> name;
    public static volatile SingularAttribute<Hardware, String> description;
    public static volatile SingularAttribute<Hardware, String> serialNumber;
    public static volatile SingularAttribute<Hardware, String> subRegionCode;
    public static volatile SingularAttribute<Hardware, Timestamp> releaseDate;
    public static volatile SingularAttribute<Hardware, Timestamp> acquiringDate;
    public static volatile SingularAttribute<Hardware, java.math.BigDecimal> acquiringPrice;
    public static volatile SingularAttribute<Hardware, Boolean> acquiredPriceFree;
    public static volatile SingularAttribute<Hardware, Boolean> acquiredPriceUnknown;
    public static volatile SingularAttribute<Hardware, String> acquiringSellerName;
    public static volatile SingularAttribute<Hardware, String> acquiringPlace;
    public static volatile SingularAttribute<Hardware, Boolean> hasBox;
    public static volatile SingularAttribute<Hardware, Boolean> hasManual;
    public static volatile SingularAttribute<Hardware, String> hasInserts;
    public static volatile SingularAttribute<Hardware, Boolean> isSealed;
    public static volatile SingularAttribute<Hardware, Boolean> isNew;
    public static volatile SingularAttribute<Hardware, Boolean> isCompleteInBox;
    public static volatile SingularAttribute<Hardware, Integer> hardwareStateRating;
    public static volatile SingularAttribute<Hardware, Integer> boxStateRating;
    public static volatile SingularAttribute<Hardware, Integer> manualStateRating;
    public static volatile SingularAttribute<Hardware, String> comment;
    public static volatile SingularAttribute<Hardware, String> barcode;
    public static volatile SingularAttribute<Hardware, Producer> brand;
    public static volatile SingularAttribute<Hardware, Integer> brand_;
    public static volatile SingularAttribute<Hardware, ValueList> color;
    public static volatile SingularAttribute<Hardware, Integer> color_;
    public static volatile SingularAttribute<Hardware, Location> location;
    public static volatile SingularAttribute<Hardware, Integer> location_;
    public static volatile SingularAttribute<Hardware, ValueList> region;
    public static volatile SingularAttribute<Hardware, Integer> region_;

    public static volatile SetAttribute<Hardware, Photo> photoHardwareViaHardwareIdFk;

    public static volatile SetAttribute<Hardware, Accessorie> accessorieViaHardwareAccessorieByAccessorieIdFk;
    public static volatile SetAttribute<Hardware, Software> softwareViaHardwareSoftwareBySoftwareIdFk;
    public static volatile SetAttribute<Hardware, Tag> tagViaTagHardwareByTagIdFk;

}
