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

import com.retrocoll.server.domain.server.Accessorie;
import com.retrocoll.server.domain.server.Accessorie;
import com.retrocoll.server.domain.server.Hardware;
import com.retrocoll.server.domain.server.Hardware;
import com.retrocoll.server.domain.server.Software;
import com.retrocoll.server.domain.server.Software;
import com.retrocoll.server.domain.server.Software;

@StaticMetamodel(ValueList.class)
public class ValueList_ {

    public static volatile SingularAttribute<ValueList, Integer> valueId;

    public static volatile SingularAttribute<ValueList, String> name;
    public static volatile SingularAttribute<ValueList, String> group;

    public static volatile SetAttribute<ValueList, Accessorie> accessorieValueListViaColor;
    public static volatile SetAttribute<ValueList, Accessorie> accessorieValueListViaRegion;
    public static volatile SetAttribute<ValueList, Hardware> hardwareValueListViaColor;
    public static volatile SetAttribute<ValueList, Hardware> hardwareValueListViaRegion;
    public static volatile SetAttribute<ValueList, Software> softwareValueListViaConsole;
    public static volatile SetAttribute<ValueList, Software> softwareValueListViaRegion;
    public static volatile SetAttribute<ValueList, Software> softwareValueListViaStyle;


}
