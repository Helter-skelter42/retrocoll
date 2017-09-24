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
	* - name      : REST.jackson.serializer.date
	* - file name : REST.jackson.serializer.date.vm
	* - time      : 2017/09/16 ap. J.-C. at 19:38:20 CEST
*/
package com.retrocoll.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JacksonDateSerializer extends JsonSerializer<Date> {

	public static final String FORMAT_DATE_TIME_US 			= "yyyy/MM/dd HH:mm:ss";
	public static final String FORMAT_DATE_TIME_EU 			= "dd/MM/yyyy HH:mm:ss";
	public static final String FORMAT_DATE_TIME_EU_RNDED 	= "dd/MM/yyyy HH:00:00";
	public static final String FORMAT_DATE_TIME_EU_235959 	= "dd/MM/yyyy 23:59:59";
	public static final String FORMAT_DATE_TIME_LOG 		= "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_DATE_TIME_SQL 		= "DD/MM/YYYY HH24:MI:SS";
	public static final String FORMAT_DATE_TIME_ISO_8601 	= "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
	public static final String FORMAT_DATE_US 				= "yyyy/MM/dd";
	public static final String FORMAT_DATE_EU 				= "dd/MM/yyyy";
	public static final String FORMAT_DATE_FULL				= "EEEE dd MMMM yyyy";
	public static final String FORMAT_TIME 					= "HH:mm:ss";
	public static final String FORMAT_TIME_235959 			= "23:59:59";

    @Override
    public void serialize(Date date, JsonGenerator jsonGen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jsonGen.writeString(new SimpleDateFormat(FORMAT_DATE_TIME_ISO_8601).format(date));
    }

}
