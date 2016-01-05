package org.irri.entity;

import java.util.List;

/**
 * Created by ACañeda on 2015-12-18.
 */
public class VariableSet {


    /**
     * success : true
     * data : {"items":[{"id":32,"abbrev":"FERT1_DATE_CONT","label":"FERT1 DATE","name":"FERTILIZER DATE - 1ST APPLICATION","data_type":"date","member_data_type":null,"not_null":false,"type":"metadata","status":"active","display_name":"Fertilizer application date for first application","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":412,"href":"http://api.breeding4rice.irri.org/v1/properties/412"},"method_id":{"value":76,"href":"http://api.breeding4rice.irri.org/v1/methods/76"},"scale_id":{"value":76,"href":"http://api.breeding4rice.irri.org/v1/scales/76"},"synonym":null,"remarks":"verified by CParducho","notes":null,"description":"Date of 1st fertilizer application","default_value":"","scales":{"id":76,"abbrev":"FERT1_DATE_CONT_SCALE_5358a1b888ab5","name":"FERT1_DATE_CONT scale","unit":null,"type":"discrete","level":"nominal","description":null,"display_name":null,"remarks":"verified by CParducho","notes":null,"scale_value":null,"reference":null,"property_id":{"value":412,"href":"http://api.breeding4rice.irri.org/v1/properties/412"},"method_id":{"value":76,"href":"http://api.breeding4rice.irri.org/v1/methods/76"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}},{"id":10,"abbrev":"SCT_SCOR","label":"AROMA","name":"aroma","data_type":"character varying","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Aroma","ontology_reference":"CO_320:0000103","bibliographical_reference":"Crop Ontology","property_id":{"value":401,"href":"http://api.breeding4rice.irri.org/v1/properties/401"},"method_id":{"value":54,"href":"http://api.breeding4rice.irri.org/v1/methods/54"},"scale_id":{"value":54,"href":"http://api.breeding4rice.irri.org/v1/scales/54"},"synonym":null,"remarks":"Descriptive scale from crop ontology.rnrnverified by recarpio","notes":null,"description":"The aroma of the cooked/uncooked grains. [CO:rs]","default_value":"","scales":{"id":54,"abbrev":"AROMA_SCALE_1","name":"aroma 1","unit":null,"type":"categorical","level":"nominal","description":"Descriptive scale from crop ontology.","display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":52,"href":"http://api.breeding4rice.irri.org/v1/properties/52"},"method_id":{"value":54,"href":"http://api.breeding4rice.irri.org/v1/methods/54"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[{"id":1262,"value":"none","order_number":1,"display_name":null,"description":"none","remarks":null},{"id":1263,"value":"slight","order_number":2,"display_name":null,"description":"slight","remarks":null},{"id":1264,"value":"moderate","order_number":3,"display_name":null,"description":"moderate","remarks":null},{"id":1265,"value":"strong","order_number":4,"display_name":null,"description":"strong","remarks":null}]}},{"id":197,"abbrev":"PNL_SCOR_1_9","label":"PnL 1-9","name":"Panicle length 1-9","data_type":"integer","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Panicle length scale (1=Very short,<11 cm; 3=Short,~15 cm; 5=Medium,~25 cm; 7=Long,~35 cm; 9=Very long,>40 cm)","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":204,"href":"http://api.breeding4rice.irri.org/v1/properties/204"},"method_id":{"value":278,"href":"http://api.breeding4rice.irri.org/v1/methods/278"},"scale_id":{"value":278,"href":"http://api.breeding4rice.irri.org/v1/scales/278"},"synonym":null,"remarks":"verified by weusebio","notes":null,"description":"Measurement from panicle base to tip. Expressed in cm. [CO:rs]","default_value":"","scales":{"id":278,"abbrev":"PNL_SCOR_1_9_SCALE_1","name":"panicle length 1","unit":null,"type":"categorical","level":"nominal","description":"scale values as prescribed in the Crop ontology rice trait","display_name":null,"remarks":"CO_320:0000242, Crop Ontology - Rice Traitrnverified by weusebio","notes":null,"scale_value":"1= Very short| <11 cmn3= Short| ~15 cmn5= Medium| ~25 cmn7= Long| ~35 cmn9= Very long| >40 cm #[RD:7.5.1]","reference":null,"property_id":{"value":204,"href":"http://api.breeding4rice.irri.org/v1/properties/204"},"method_id":{"value":278,"href":"http://api.breeding4rice.irri.org/v1/methods/278"},"ontology_id":{"value":"CO_320:0000242","href":"http://api.breeding4rice.irri.org/v1/ontologies/CO_320:0000242"},"bibliographical_reference":"Crop Ontology - Rice Trait","values":[{"id":655,"value":"3","order_number":2,"display_name":"Short","description":"~15 cm","remarks":null},{"id":656,"value":"5","order_number":3,"display_name":"Medium","description":"~25 cm","remarks":null},{"id":657,"value":"7","order_number":4,"display_name":"Long","description":"~35 cm","remarks":null},{"id":658,"value":"9","order_number":5,"display_name":"Very long","description":">40 cm","remarks":null},{"id":654,"value":"1","order_number":1,"display_name":"Very short","description":"<11 cm","remarks":null}]}},{"id":1467,"abbrev":"ADJAYLD_KG_CONT2","label":"ADJUSTED YIELD FROM HARVESTER","name":"Plotyield from harvester adjusted to 14% MC","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Plotyield From Harvester Adjusted To 14% MC","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":137,"href":"http://api.breeding4rice.irri.org/v1/properties/137"},"method_id":{"value":1169,"href":"http://api.breeding4rice.irri.org/v1/methods/1169"},"scale_id":{"value":1134,"href":"http://api.breeding4rice.irri.org/v1/scales/1134"},"synonym":null,"remarks":"added by C.Parducho","notes":null,"description":"Actual plot yield from harvester in kilograms adjusted to 14% moisture content","default_value":"","scales":{"id":1134,"abbrev":null,"name":null,"unit":null,"type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/properties"},"method_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/methods"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}},{"id":1469,"abbrev":"ADJAYLD_KG_CONT3","label":"ADJUSTED YIELD FROM HARVESTER 3","name":"Plotyield from harvester with MC from harvester","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Plotyield From Harvester With MC From Harvester","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":136,"href":"http://api.breeding4rice.irri.org/v1/properties/136"},"method_id":{"value":1171,"href":"http://api.breeding4rice.irri.org/v1/methods/1171"},"scale_id":{"value":1136,"href":"http://api.breeding4rice.irri.org/v1/scales/1136"},"synonym":null,"remarks":null,"notes":null,"description":"Computed using plotyield and MC from harvester","default_value":"","scales":{"id":1136,"abbrev":null,"name":null,"unit":null,"type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/properties"},"method_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/methods"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}},{"id":1470,"abbrev":"YLD_CONT_TON3","label":"Yld_TON3","name":"Grain yield in ton/ha3","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Grain Yield In Ton/ha3","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":136,"href":"http://api.breeding4rice.irri.org/v1/properties/136"},"method_id":{"value":1172,"href":"http://api.breeding4rice.irri.org/v1/methods/1172"},"scale_id":{"value":1137,"href":"http://api.breeding4rice.irri.org/v1/scales/1137"},"synonym":null,"remarks":null,"notes":null,"description":"Grainyield in ton/ha using plotyield from harvester","default_value":"","scales":{"id":1137,"abbrev":null,"name":null,"unit":null,"type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/properties"},"method_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/methods"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}},{"id":1471,"abbrev":"MF_HARV_CONT","label":"MF_HARV","name":"Moisture factor from harvester","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Moisture Factor From Harvester","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":191,"href":"http://api.breeding4rice.irri.org/v1/properties/191"},"method_id":{"value":1173,"href":"http://api.breeding4rice.irri.org/v1/methods/1173"},"scale_id":{"value":1138,"href":"http://api.breeding4rice.irri.org/v1/scales/1138"},"synonym":null,"remarks":null,"notes":null,"description":"Moisture factor computed for MC produced from harvester","default_value":"","scales":{"id":1138,"abbrev":null,"name":null,"unit":null,"type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/properties"},"method_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/methods"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}},{"id":672,"abbrev":"PNL10_CONT","label":"PnL10","name":"panicle length  of sample 10","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Panicle length in centimeters of plant sample 10","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":204,"href":"http://api.breeding4rice.irri.org/v1/properties/204"},"method_id":{"value":654,"href":"http://api.breeding4rice.irri.org/v1/methods/654"},"scale_id":{"value":651,"href":"http://api.breeding4rice.irri.org/v1/scales/651"},"synonym":null,"remarks":"verified by weusebio","notes":null,"description":"panicle length taken from plant sample 10","default_value":"","scales":{"id":651,"abbrev":null,"name":null,"unit":"cm","type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":"SES 4th:109, SES 5th:109rnverified by weusebio","notes":null,"scale_value":null,"reference":null,"property_id":{"value":204,"href":"http://api.breeding4rice.irri.org/v1/properties/204"},"method_id":{"value":654,"href":"http://api.breeding4rice.irri.org/v1/methods/654"},"ontology_id":{"value":"CO_320:0000476","href":"http://api.breeding4rice.irri.org/v1/ontologies/CO_320:0000476"},"bibliographical_reference":"Crop Ontology - Rice Trait","values":[]}},{"id":1472,"abbrev":"YLD_CONT_TON4","label":"Yld_TON4","name":"Grain yield in ton/ha4","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Grain Yield In Ton/ha4","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":136,"href":"http://api.breeding4rice.irri.org/v1/properties/136"},"method_id":{"value":1174,"href":"http://api.breeding4rice.irri.org/v1/methods/1174"},"scale_id":{"value":1139,"href":"http://api.breeding4rice.irri.org/v1/scales/1139"},"synonym":null,"remarks":null,"notes":null,"description":"Grainyield in ton/ha using plotyield from harvester and MC from manual measure","default_value":"","scales":{"id":1139,"abbrev":null,"name":null,"unit":null,"type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/properties"},"method_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/methods"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}},{"id":12,"abbrev":"AC_SES4_SCOR_1_2","label":"AC 1-2","name":"auricle color SES4","data_type":"integer","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Auricle Color SES4","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":53,"href":"http://api.breeding4rice.irri.org/v1/properties/53"},"method_id":{"value":56,"href":"http://api.breeding4rice.irri.org/v1/methods/56"},"scale_id":{"value":56,"href":"http://api.breeding4rice.irri.org/v1/scales/56"},"synonym":null,"remarks":"verified by weusebio","notes":null,"description":"Color of the auricle. [CO:rs]","default_value":"","scales":{"id":56,"abbrev":"AC_SCOR_0_2_SCALE_1","name":"auricle color 2","unit":null,"type":"categorical","level":"nominal","description":null,"display_name":null,"remarks":"SES4:103rnverified by weusebio","notes":null,"scale_value":"0= Absent (no auricles)n1= Light greenn2= Purple","reference":null,"property_id":{"value":53,"href":"http://api.breeding4rice.irri.org/v1/properties/53"},"method_id":{"value":56,"href":"http://api.breeding4rice.irri.org/v1/methods/56"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[{"id":27,"value":"2","order_number":2,"display_name":null,"description":"Purple","remarks":null},{"id":26,"value":"1","order_number":1,"display_name":null,"description":"Light green","remarks":null}]}},{"id":33,"abbrev":"DBI_CONT_CO","label":"DBI","name":"basal internode diameter","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"deprecated","display_name":"Basal Internode Diameter","ontology_reference":"CO_320:0000032","bibliographical_reference":"Crop Ontology","property_id":{"value":97,"href":"http://api.breeding4rice.irri.org/v1/properties/97"},"method_id":{"value":77,"href":"http://api.breeding4rice.irri.org/v1/methods/77"},"scale_id":{"value":77,"href":"http://api.breeding4rice.irri.org/v1/scales/77"},"synonym":null,"remarks":"deprecate","notes":null,"description":"Actual measurements in millimeters from the outer diameter of the stems (culms) at the basal portion of the main stem (culm). [CO:rs]","default_value":"","scales":{"id":77,"abbrev":"DBI_CONT_CO_SCALE_1","name":"basal internode diameter 1","unit":"mm","type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":"Measure in mm. [SES:107]","reference":null,"property_id":{"value":69,"href":"http://api.breeding4rice.irri.org/v1/properties/69"},"method_id":{"value":77,"href":"http://api.breeding4rice.irri.org/v1/methods/77"},"ontology_id":{"value":"CO_320:0000417","href":"http://api.breeding4rice.irri.org/v1/ontologies/CO_320:0000417"},"bibliographical_reference":"Crop Ontology - Rice Trait","values":[]}},{"id":13,"abbrev":"AC_SES5_SCOR_0_2","label":"AC SES5 0-2","name":"auricle color","data_type":"integer","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Auricle color scale from SES 5th ed.(0=absent (no auricle); 1=Light green; 2=Purple)","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":53,"href":"http://api.breeding4rice.irri.org/v1/properties/53"},"method_id":{"value":55,"href":"http://api.breeding4rice.irri.org/v1/methods/55"},"scale_id":{"value":55,"href":"http://api.breeding4rice.irri.org/v1/scales/55"},"synonym":null,"remarks":"verified by weusebio","notes":null,"description":"Color of the auricle. [CO:rs]","default_value":"","scales":{"id":55,"abbrev":"AC_SCOR_1_2_SCALE_1","name":"auricle color 1","unit":null,"type":"categorical","level":"nominal","description":"At growth stage: 4-5","display_name":null,"remarks":"SES5:103rnverified by weusebio","notes":null,"scale_value":"1= Light greenn2= Purple","reference":null,"property_id":{"value":53,"href":"http://api.breeding4rice.irri.org/v1/properties/53"},"method_id":{"value":55,"href":"http://api.breeding4rice.irri.org/v1/methods/55"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[{"id":23,"value":"0","order_number":1,"display_name":null,"description":"absent (no auricle)","remarks":null},{"id":24,"value":"1","order_number":2,"display_name":null,"description":"Light green","remarks":null},{"id":1534,"value":"2","order_number":3,"display_name":null,"description":"Purple","remarks":null}]}},{"id":19,"abbrev":"ANT_CONT","label":"ANT","name":"awn thickness","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Awn Thickness","ontology_reference":"CO_320:0000144","bibliographical_reference":"Crop Ontology","property_id":{"value":57,"href":"http://api.breeding4rice.irri.org/v1/properties/57"},"method_id":{"value":63,"href":"http://api.breeding4rice.irri.org/v1/methods/63"},"scale_id":{"value":63,"href":"http://api.breeding4rice.irri.org/v1/scales/63"},"synonym":null,"remarks":null,"notes":null,"description":null,"default_value":"","scales":{"id":63,"abbrev":"ANT_CONT_SCALE_1","name":"awn thickness 1","unit":null,"type":"continuous","level":null,"description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":"Measured in mm. [RD:7.4.12]","reference":null,"property_id":{"value":57,"href":"http://api.breeding4rice.irri.org/v1/properties/57"},"method_id":{"value":63,"href":"http://api.breeding4rice.irri.org/v1/methods/63"},"ontology_id":{"value":"CO_320:0000293","href":"http://api.breeding4rice.irri.org/v1/ontologies/CO_320:0000293"},"bibliographical_reference":"Crop Ontology - Rice Trait","values":[]}},{"id":1475,"abbrev":"YLD_CONT_TON5","label":"YLD_TON5","name":"Grain yield in ton/ha5","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Grain Yield In Ton/ha5","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":136,"href":"http://api.breeding4rice.irri.org/v1/properties/136"},"method_id":{"value":1177,"href":"http://api.breeding4rice.irri.org/v1/methods/1177"},"scale_id":{"value":1142,"href":"http://api.breeding4rice.irri.org/v1/scales/1142"},"synonym":null,"remarks":null,"notes":null,"description":"Grainyield in ton/ha using plotyield  and MC from manual measure","default_value":"","scales":{"id":1142,"abbrev":null,"name":null,"unit":null,"type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/properties"},"method_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/methods"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}},{"id":631,"abbrev":"PLTHGT_AVE","label":"PLTHGT AVG","name":"Average plant height","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"deprecated","display_name":"Average Plant Height","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":261,"href":"http://api.breeding4rice.irri.org/v1/properties/261"},"method_id":{"value":613,"href":"http://api.breeding4rice.irri.org/v1/methods/613"},"scale_id":{"value":610,"href":"http://api.breeding4rice.irri.org/v1/scales/610"},"synonym":null,"remarks":"verified by CParducho","notes":null,"description":"deprecated","default_value":"","scales":{"id":610,"abbrev":null,"name":null,"unit":null,"type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":"deprecated","notes":null,"scale_value":null,"reference":null,"property_id":{"value":261,"href":"http://api.breeding4rice.irri.org/v1/properties/261"},"method_id":{"value":613,"href":"http://api.breeding4rice.irri.org/v1/methods/613"},"ontology_id":{"value":"CO_320:0000480","href":"http://api.breeding4rice.irri.org/v1/ontologies/CO_320:0000480"},"bibliographical_reference":"Crop Ontology - Rice Trait","values":[]}},{"id":1477,"abbrev":"YLD_0_CONT5","label":"GYKGPHA in kg/ha with TPL used in DRT & RFSA","name":"GYKGPHA in kg/ha without MC but with TPL using different formula used by DRT and RFSA","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"GYKGPHA In Kg/ha Without MC But With TPL Using Different Formula Used By DRT And RFSA","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":137,"href":"http://api.breeding4rice.irri.org/v1/properties/137"},"method_id":{"value":1179,"href":"http://api.breeding4rice.irri.org/v1/methods/1179"},"scale_id":{"value":1144,"href":"http://api.breeding4rice.irri.org/v1/scales/1144"},"synonym":null,"remarks":null,"notes":null,"description":"GYKGPHA without Moisture Content (MC) but with Total Plotyield (TPL) using a different formyula used by DRT and RFSA. ","default_value":"","scales":{"id":1144,"abbrev":null,"name":null,"unit":null,"type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/properties"},"method_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/methods"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}},{"id":1478,"abbrev":"YLD_0_CONT5_ENT","label":"Average of GYKGPHA in kg/ha with TPL","name":"Average of GYKGPHA in kg/ha with TPL","data_type":"float","member_data_type":"float","not_null":false,"type":"observation","status":"active","display_name":"Average Of GYKGPHA In Kg/ha With TPL","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":136,"href":"http://api.breeding4rice.irri.org/v1/properties/136"},"method_id":{"value":1180,"href":"http://api.breeding4rice.irri.org/v1/methods/1180"},"scale_id":{"value":1145,"href":"http://api.breeding4rice.irri.org/v1/scales/1145"},"synonym":null,"remarks":null,"notes":null,"description":"Average of GYKGPHA in kg/ha without MC but with TPL using different formula used by DRT and RFSA","default_value":"","scales":{"id":1145,"abbrev":null,"name":null,"unit":"kg/ha","type":"continuous","level":"nominal","description":"Average of GYKGPHA in kg/ha with TPL","display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/properties"},"method_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/methods"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}},{"id":93,"abbrev":"DRT8_SPIK_1_9","label":"DRT8","name":"drought recovery","data_type":"integer","member_data_type":null,"not_null":false,"type":"observation","status":"deprecated","display_name":"Drought Recovery","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":101,"href":"http://api.breeding4rice.irri.org/v1/properties/101"},"method_id":{"value":141,"href":"http://api.breeding4rice.irri.org/v1/methods/141"},"scale_id":{"value":141,"href":"http://api.breeding4rice.irri.org/v1/scales/141"},"synonym":null,"remarks":"Deprecate; Replace DRT8_SPIK_1_9 with DRR_SCOR_1_9rnrnverified by recarpio","notes":null,"description":"Drought sensitivity. Tolerance score at 9-10 bars","default_value":"","scales":{"id":141,"abbrev":"DRT8_SPIK_1_9_SCALE_1","name":"drought recovery 10","unit":null,"type":"categorical","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":"SCALE (spikelet fertility)^ 1= More than 80%n3= 61-80%n5= 41-60%n7= 11-40%n9= Less than 11%","reference":null,"property_id":{"value":101,"href":"http://api.breeding4rice.irri.org/v1/properties/101"},"method_id":{"value":141,"href":"http://api.breeding4rice.irri.org/v1/methods/141"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[{"id":310,"value":"1","order_number":1,"display_name":null,"description":"More than 80%","remarks":null},{"id":311,"value":"3","order_number":2,"display_name":null,"description":"61-80%","remarks":null},{"id":312,"value":"5","order_number":3,"display_name":null,"description":"41-60%","remarks":null},{"id":313,"value":"7","order_number":4,"display_name":null,"description":"11-40%","remarks":null},{"id":314,"value":"9","order_number":5,"display_name":null,"description":"Less than 11%","remarks":null}]}},{"id":86,"abbrev":"DRT4_SCOR_1_9","label":"DRT4","name":"drought recovery","data_type":"integer","member_data_type":null,"not_null":false,"type":"observation","status":"deprecated","display_name":"Drought Recovery","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":101,"href":"http://api.breeding4rice.irri.org/v1/properties/101"},"method_id":{"value":134,"href":"http://api.breeding4rice.irri.org/v1/methods/134"},"scale_id":{"value":134,"href":"http://api.breeding4rice.irri.org/v1/scales/134"},"synonym":null,"remarks":"Deprecate; Replace DRT4_SCOR_1_9 with DRR_SCOR_1_9rnrnverified by recarpio","notes":null,"description":"Drought resistance. Resistance score at early vegetative stage (40 DAS)","default_value":"","scales":{"id":134,"abbrev":"DRT2_SCOR_1_9_SCALE_1","name":"drought recovery 3","unit":null,"type":"categorical","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":"SCALE (plants recovered)^ 1= 90-100%n3= 70-89%n5= 40-69%n7= 20-39%n9= 0-19%","reference":null,"property_id":{"value":101,"href":"http://api.breeding4rice.irri.org/v1/properties/101"},"method_id":{"value":134,"href":"http://api.breeding4rice.irri.org/v1/methods/134"},"ontology_id":{"value":"CO_320:0000405","href":"http://api.breeding4rice.irri.org/v1/ontologies/CO_320:0000405"},"bibliographical_reference":"Crop Ontology - Rice Trait","values":[{"id":274,"value":"5","order_number":3,"display_name":null,"description":"40-69%","remarks":null},{"id":275,"value":"7","order_number":4,"display_name":null,"description":"20-39%","remarks":null},{"id":276,"value":"9","order_number":5,"display_name":null,"description":"0-19%","remarks":null},{"id":272,"value":"1","order_number":1,"display_name":null,"description":"90-100%","remarks":null},{"id":273,"value":"3","order_number":2,"display_name":null,"description":"70-89%","remarks":null}]}},{"id":94,"abbrev":"DRT9_SCOR_1_9","label":"DRT9","name":"drought recovery","data_type":"integer","member_data_type":null,"not_null":false,"type":"observation","status":"deprecated","display_name":"Drought Recovery","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":101,"href":"http://api.breeding4rice.irri.org/v1/properties/101"},"method_id":{"value":139,"href":"http://api.breeding4rice.irri.org/v1/methods/139"},"scale_id":{"value":139,"href":"http://api.breeding4rice.irri.org/v1/scales/139"},"synonym":null,"remarks":"Depricate; Replace RT9_SCOR_1_9 with DRR_SCOR_1_9rnrnverified by recarpio","notes":null,"description":"Drought recovery. Rate of recovery after exposure to 9-10 bars","default_value":"","scales":{"id":139,"abbrev":"DRT7_SPIK_1_9_SCALE_1","name":"drought recovery 8","unit":null,"type":"categorical","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":"SCALE (spikelet fertility)^ 1= More than 80%n3= 61-80%n5= 41-60%n7= 11-40%n9= Less than 11%","reference":null,"property_id":{"value":101,"href":"http://api.breeding4rice.irri.org/v1/properties/101"},"method_id":{"value":139,"href":"http://api.breeding4rice.irri.org/v1/methods/139"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[{"id":299,"value":"1","order_number":1,"display_name":null,"description":"More than 80%","remarks":null},{"id":300,"value":"3","order_number":2,"display_name":null,"description":"61-80%","remarks":null},{"id":301,"value":"5","order_number":3,"display_name":null,"description":"41-60%","remarks":null},{"id":302,"value":"7","order_number":4,"display_name":null,"description":"11-40%","remarks":null},{"id":303,"value":"9","order_number":5,"display_name":null,"description":"Less than 11%","remarks":null}]}},{"id":38,"abbrev":"BLAST","label":"BLAST","name":"blast","data_type":"integer","member_data_type":null,"not_null":false,"type":"observation","status":"deprecated","display_name":"Blast","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":73,"href":"http://api.breeding4rice.irri.org/v1/properties/73"},"method_id":{"value":83,"href":"http://api.breeding4rice.irri.org/v1/methods/83"},"scale_id":{"value":83,"href":"http://api.breeding4rice.irri.org/v1/scales/83"},"synonym":null,"remarks":"deprecated. Replaced with BL_NURS_0_9rnrnverified by CLotho","notes":null,"description":null,"default_value":"","scales":{"id":83,"abbrev":"BLAST_SCALE_1","name":"blast 1","unit":null,"type":"categorical","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":"0=SES Score Blast Nursery 0n1=SES Score Blast Nursery 1n3=SES Score Blast Nursery 3n5=SES Score Blast Nursery 5n7=SES Score Blast Nursery 7n9=SES Score Blast Nursery 9","reference":null,"property_id":{"value":73,"href":"http://api.breeding4rice.irri.org/v1/properties/73"},"method_id":{"value":83,"href":"http://api.breeding4rice.irri.org/v1/methods/83"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[{"id":92,"value":"1","order_number":2,"display_name":null,"description":"SES Score Blast Nursery 1","remarks":null},{"id":93,"value":"3","order_number":3,"display_name":null,"description":"SES Score Blast Nursery 3","remarks":null},{"id":94,"value":"5","order_number":4,"display_name":null,"description":"SES Score Blast Nursery 5","remarks":null},{"id":95,"value":"7","order_number":5,"display_name":null,"description":"SES Score Blast Nursery 7","remarks":null},{"id":91,"value":"0","order_number":1,"display_name":null,"description":"SES Score Blast Nursery 0","remarks":null},{"id":96,"value":"9","order_number":6,"display_name":null,"description":"SES Score Blast Nursery 9","remarks":null}]}}],"_links":{"self":{"href":"http://api.breeding4rice.irri.org/v1/variables/scales?type=observation&accessToken=HL47DjDoZvYVIAtan9zXcxiY5EBUgJTeWGctyi7k&page=1"},"next":{"href":"http://api.breeding4rice.irri.org/v1/variables/scales?type=observation&accessToken=HL47DjDoZvYVIAtan9zXcxiY5EBUgJTeWGctyi7k&page=2"},"last":{"href":"http://api.breeding4rice.irri.org/v1/variables/scales?type=observation&accessToken=HL47DjDoZvYVIAtan9zXcxiY5EBUgJTeWGctyi7k&page=35"}},"_meta":{"totalRows":685,"pageCount":35,"page":1,"limit":20,"offset":0,"sort":[]}}
     */

    private boolean success;
    /**
     * items : [{"id":32,"abbrev":"FERT1_DATE_CONT","label":"FERT1 DATE","name":"FERTILIZER DATE - 1ST APPLICATION","data_type":"date","member_data_type":null,"not_null":false,"type":"metadata","status":"active","display_name":"Fertilizer application date for first application","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":412,"href":"http://api.breeding4rice.irri.org/v1/properties/412"},"method_id":{"value":76,"href":"http://api.breeding4rice.irri.org/v1/methods/76"},"scale_id":{"value":76,"href":"http://api.breeding4rice.irri.org/v1/scales/76"},"synonym":null,"remarks":"verified by CParducho","notes":null,"description":"Date of 1st fertilizer application","default_value":"","scales":{"id":76,"abbrev":"FERT1_DATE_CONT_SCALE_5358a1b888ab5","name":"FERT1_DATE_CONT scale","unit":null,"type":"discrete","level":"nominal","description":null,"display_name":null,"remarks":"verified by CParducho","notes":null,"scale_value":null,"reference":null,"property_id":{"value":412,"href":"http://api.breeding4rice.irri.org/v1/properties/412"},"method_id":{"value":76,"href":"http://api.breeding4rice.irri.org/v1/methods/76"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}},{"id":10,"abbrev":"SCT_SCOR","label":"AROMA","name":"aroma","data_type":"character varying","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Aroma","ontology_reference":"CO_320:0000103","bibliographical_reference":"Crop Ontology","property_id":{"value":401,"href":"http://api.breeding4rice.irri.org/v1/properties/401"},"method_id":{"value":54,"href":"http://api.breeding4rice.irri.org/v1/methods/54"},"scale_id":{"value":54,"href":"http://api.breeding4rice.irri.org/v1/scales/54"},"synonym":null,"remarks":"Descriptive scale from crop ontology.rnrnverified by recarpio","notes":null,"description":"The aroma of the cooked/uncooked grains. [CO:rs]","default_value":"","scales":{"id":54,"abbrev":"AROMA_SCALE_1","name":"aroma 1","unit":null,"type":"categorical","level":"nominal","description":"Descriptive scale from crop ontology.","display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":52,"href":"http://api.breeding4rice.irri.org/v1/properties/52"},"method_id":{"value":54,"href":"http://api.breeding4rice.irri.org/v1/methods/54"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[{"id":1262,"value":"none","order_number":1,"display_name":null,"description":"none","remarks":null},{"id":1263,"value":"slight","order_number":2,"display_name":null,"description":"slight","remarks":null},{"id":1264,"value":"moderate","order_number":3,"display_name":null,"description":"moderate","remarks":null},{"id":1265,"value":"strong","order_number":4,"display_name":null,"description":"strong","remarks":null}]}},{"id":197,"abbrev":"PNL_SCOR_1_9","label":"PnL 1-9","name":"Panicle length 1-9","data_type":"integer","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Panicle length scale (1=Very short,<11 cm; 3=Short,~15 cm; 5=Medium,~25 cm; 7=Long,~35 cm; 9=Very long,>40 cm)","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":204,"href":"http://api.breeding4rice.irri.org/v1/properties/204"},"method_id":{"value":278,"href":"http://api.breeding4rice.irri.org/v1/methods/278"},"scale_id":{"value":278,"href":"http://api.breeding4rice.irri.org/v1/scales/278"},"synonym":null,"remarks":"verified by weusebio","notes":null,"description":"Measurement from panicle base to tip. Expressed in cm. [CO:rs]","default_value":"","scales":{"id":278,"abbrev":"PNL_SCOR_1_9_SCALE_1","name":"panicle length 1","unit":null,"type":"categorical","level":"nominal","description":"scale values as prescribed in the Crop ontology rice trait","display_name":null,"remarks":"CO_320:0000242, Crop Ontology - Rice Traitrnverified by weusebio","notes":null,"scale_value":"1= Very short| <11 cmn3= Short| ~15 cmn5= Medium| ~25 cmn7= Long| ~35 cmn9= Very long| >40 cm #[RD:7.5.1]","reference":null,"property_id":{"value":204,"href":"http://api.breeding4rice.irri.org/v1/properties/204"},"method_id":{"value":278,"href":"http://api.breeding4rice.irri.org/v1/methods/278"},"ontology_id":{"value":"CO_320:0000242","href":"http://api.breeding4rice.irri.org/v1/ontologies/CO_320:0000242"},"bibliographical_reference":"Crop Ontology - Rice Trait","values":[{"id":655,"value":"3","order_number":2,"display_name":"Short","description":"~15 cm","remarks":null},{"id":656,"value":"5","order_number":3,"display_name":"Medium","description":"~25 cm","remarks":null},{"id":657,"value":"7","order_number":4,"display_name":"Long","description":"~35 cm","remarks":null},{"id":658,"value":"9","order_number":5,"display_name":"Very long","description":">40 cm","remarks":null},{"id":654,"value":"1","order_number":1,"display_name":"Very short","description":"<11 cm","remarks":null}]}},{"id":1467,"abbrev":"ADJAYLD_KG_CONT2","label":"ADJUSTED YIELD FROM HARVESTER","name":"Plotyield from harvester adjusted to 14% MC","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Plotyield From Harvester Adjusted To 14% MC","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":137,"href":"http://api.breeding4rice.irri.org/v1/properties/137"},"method_id":{"value":1169,"href":"http://api.breeding4rice.irri.org/v1/methods/1169"},"scale_id":{"value":1134,"href":"http://api.breeding4rice.irri.org/v1/scales/1134"},"synonym":null,"remarks":"added by C.Parducho","notes":null,"description":"Actual plot yield from harvester in kilograms adjusted to 14% moisture content","default_value":"","scales":{"id":1134,"abbrev":null,"name":null,"unit":null,"type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/properties"},"method_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/methods"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}},{"id":1469,"abbrev":"ADJAYLD_KG_CONT3","label":"ADJUSTED YIELD FROM HARVESTER 3","name":"Plotyield from harvester with MC from harvester","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Plotyield From Harvester With MC From Harvester","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":136,"href":"http://api.breeding4rice.irri.org/v1/properties/136"},"method_id":{"value":1171,"href":"http://api.breeding4rice.irri.org/v1/methods/1171"},"scale_id":{"value":1136,"href":"http://api.breeding4rice.irri.org/v1/scales/1136"},"synonym":null,"remarks":null,"notes":null,"description":"Computed using plotyield and MC from harvester","default_value":"","scales":{"id":1136,"abbrev":null,"name":null,"unit":null,"type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/properties"},"method_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/methods"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}},{"id":1470,"abbrev":"YLD_CONT_TON3","label":"Yld_TON3","name":"Grain yield in ton/ha3","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Grain Yield In Ton/ha3","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":136,"href":"http://api.breeding4rice.irri.org/v1/properties/136"},"method_id":{"value":1172,"href":"http://api.breeding4rice.irri.org/v1/methods/1172"},"scale_id":{"value":1137,"href":"http://api.breeding4rice.irri.org/v1/scales/1137"},"synonym":null,"remarks":null,"notes":null,"description":"Grainyield in ton/ha using plotyield from harvester","default_value":"","scales":{"id":1137,"abbrev":null,"name":null,"unit":null,"type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/properties"},"method_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/methods"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}},{"id":1471,"abbrev":"MF_HARV_CONT","label":"MF_HARV","name":"Moisture factor from harvester","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Moisture Factor From Harvester","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":191,"href":"http://api.breeding4rice.irri.org/v1/properties/191"},"method_id":{"value":1173,"href":"http://api.breeding4rice.irri.org/v1/methods/1173"},"scale_id":{"value":1138,"href":"http://api.breeding4rice.irri.org/v1/scales/1138"},"synonym":null,"remarks":null,"notes":null,"description":"Moisture factor computed for MC produced from harvester","default_value":"","scales":{"id":1138,"abbrev":null,"name":null,"unit":null,"type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/properties"},"method_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/methods"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}},{"id":672,"abbrev":"PNL10_CONT","label":"PnL10","name":"panicle length  of sample 10","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Panicle length in centimeters of plant sample 10","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":204,"href":"http://api.breeding4rice.irri.org/v1/properties/204"},"method_id":{"value":654,"href":"http://api.breeding4rice.irri.org/v1/methods/654"},"scale_id":{"value":651,"href":"http://api.breeding4rice.irri.org/v1/scales/651"},"synonym":null,"remarks":"verified by weusebio","notes":null,"description":"panicle length taken from plant sample 10","default_value":"","scales":{"id":651,"abbrev":null,"name":null,"unit":"cm","type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":"SES 4th:109, SES 5th:109rnverified by weusebio","notes":null,"scale_value":null,"reference":null,"property_id":{"value":204,"href":"http://api.breeding4rice.irri.org/v1/properties/204"},"method_id":{"value":654,"href":"http://api.breeding4rice.irri.org/v1/methods/654"},"ontology_id":{"value":"CO_320:0000476","href":"http://api.breeding4rice.irri.org/v1/ontologies/CO_320:0000476"},"bibliographical_reference":"Crop Ontology - Rice Trait","values":[]}},{"id":1472,"abbrev":"YLD_CONT_TON4","label":"Yld_TON4","name":"Grain yield in ton/ha4","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Grain Yield In Ton/ha4","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":136,"href":"http://api.breeding4rice.irri.org/v1/properties/136"},"method_id":{"value":1174,"href":"http://api.breeding4rice.irri.org/v1/methods/1174"},"scale_id":{"value":1139,"href":"http://api.breeding4rice.irri.org/v1/scales/1139"},"synonym":null,"remarks":null,"notes":null,"description":"Grainyield in ton/ha using plotyield from harvester and MC from manual measure","default_value":"","scales":{"id":1139,"abbrev":null,"name":null,"unit":null,"type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/properties"},"method_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/methods"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}},{"id":12,"abbrev":"AC_SES4_SCOR_1_2","label":"AC 1-2","name":"auricle color SES4","data_type":"integer","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Auricle Color SES4","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":53,"href":"http://api.breeding4rice.irri.org/v1/properties/53"},"method_id":{"value":56,"href":"http://api.breeding4rice.irri.org/v1/methods/56"},"scale_id":{"value":56,"href":"http://api.breeding4rice.irri.org/v1/scales/56"},"synonym":null,"remarks":"verified by weusebio","notes":null,"description":"Color of the auricle. [CO:rs]","default_value":"","scales":{"id":56,"abbrev":"AC_SCOR_0_2_SCALE_1","name":"auricle color 2","unit":null,"type":"categorical","level":"nominal","description":null,"display_name":null,"remarks":"SES4:103rnverified by weusebio","notes":null,"scale_value":"0= Absent (no auricles)n1= Light greenn2= Purple","reference":null,"property_id":{"value":53,"href":"http://api.breeding4rice.irri.org/v1/properties/53"},"method_id":{"value":56,"href":"http://api.breeding4rice.irri.org/v1/methods/56"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[{"id":27,"value":"2","order_number":2,"display_name":null,"description":"Purple","remarks":null},{"id":26,"value":"1","order_number":1,"display_name":null,"description":"Light green","remarks":null}]}},{"id":33,"abbrev":"DBI_CONT_CO","label":"DBI","name":"basal internode diameter","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"deprecated","display_name":"Basal Internode Diameter","ontology_reference":"CO_320:0000032","bibliographical_reference":"Crop Ontology","property_id":{"value":97,"href":"http://api.breeding4rice.irri.org/v1/properties/97"},"method_id":{"value":77,"href":"http://api.breeding4rice.irri.org/v1/methods/77"},"scale_id":{"value":77,"href":"http://api.breeding4rice.irri.org/v1/scales/77"},"synonym":null,"remarks":"deprecate","notes":null,"description":"Actual measurements in millimeters from the outer diameter of the stems (culms) at the basal portion of the main stem (culm). [CO:rs]","default_value":"","scales":{"id":77,"abbrev":"DBI_CONT_CO_SCALE_1","name":"basal internode diameter 1","unit":"mm","type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":"Measure in mm. [SES:107]","reference":null,"property_id":{"value":69,"href":"http://api.breeding4rice.irri.org/v1/properties/69"},"method_id":{"value":77,"href":"http://api.breeding4rice.irri.org/v1/methods/77"},"ontology_id":{"value":"CO_320:0000417","href":"http://api.breeding4rice.irri.org/v1/ontologies/CO_320:0000417"},"bibliographical_reference":"Crop Ontology - Rice Trait","values":[]}},{"id":13,"abbrev":"AC_SES5_SCOR_0_2","label":"AC SES5 0-2","name":"auricle color","data_type":"integer","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Auricle color scale from SES 5th ed.(0=absent (no auricle); 1=Light green; 2=Purple)","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":53,"href":"http://api.breeding4rice.irri.org/v1/properties/53"},"method_id":{"value":55,"href":"http://api.breeding4rice.irri.org/v1/methods/55"},"scale_id":{"value":55,"href":"http://api.breeding4rice.irri.org/v1/scales/55"},"synonym":null,"remarks":"verified by weusebio","notes":null,"description":"Color of the auricle. [CO:rs]","default_value":"","scales":{"id":55,"abbrev":"AC_SCOR_1_2_SCALE_1","name":"auricle color 1","unit":null,"type":"categorical","level":"nominal","description":"At growth stage: 4-5","display_name":null,"remarks":"SES5:103rnverified by weusebio","notes":null,"scale_value":"1= Light greenn2= Purple","reference":null,"property_id":{"value":53,"href":"http://api.breeding4rice.irri.org/v1/properties/53"},"method_id":{"value":55,"href":"http://api.breeding4rice.irri.org/v1/methods/55"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[{"id":23,"value":"0","order_number":1,"display_name":null,"description":"absent (no auricle)","remarks":null},{"id":24,"value":"1","order_number":2,"display_name":null,"description":"Light green","remarks":null},{"id":1534,"value":"2","order_number":3,"display_name":null,"description":"Purple","remarks":null}]}},{"id":19,"abbrev":"ANT_CONT","label":"ANT","name":"awn thickness","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Awn Thickness","ontology_reference":"CO_320:0000144","bibliographical_reference":"Crop Ontology","property_id":{"value":57,"href":"http://api.breeding4rice.irri.org/v1/properties/57"},"method_id":{"value":63,"href":"http://api.breeding4rice.irri.org/v1/methods/63"},"scale_id":{"value":63,"href":"http://api.breeding4rice.irri.org/v1/scales/63"},"synonym":null,"remarks":null,"notes":null,"description":null,"default_value":"","scales":{"id":63,"abbrev":"ANT_CONT_SCALE_1","name":"awn thickness 1","unit":null,"type":"continuous","level":null,"description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":"Measured in mm. [RD:7.4.12]","reference":null,"property_id":{"value":57,"href":"http://api.breeding4rice.irri.org/v1/properties/57"},"method_id":{"value":63,"href":"http://api.breeding4rice.irri.org/v1/methods/63"},"ontology_id":{"value":"CO_320:0000293","href":"http://api.breeding4rice.irri.org/v1/ontologies/CO_320:0000293"},"bibliographical_reference":"Crop Ontology - Rice Trait","values":[]}},{"id":1475,"abbrev":"YLD_CONT_TON5","label":"YLD_TON5","name":"Grain yield in ton/ha5","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"Grain Yield In Ton/ha5","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":136,"href":"http://api.breeding4rice.irri.org/v1/properties/136"},"method_id":{"value":1177,"href":"http://api.breeding4rice.irri.org/v1/methods/1177"},"scale_id":{"value":1142,"href":"http://api.breeding4rice.irri.org/v1/scales/1142"},"synonym":null,"remarks":null,"notes":null,"description":"Grainyield in ton/ha using plotyield  and MC from manual measure","default_value":"","scales":{"id":1142,"abbrev":null,"name":null,"unit":null,"type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/properties"},"method_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/methods"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}},{"id":631,"abbrev":"PLTHGT_AVE","label":"PLTHGT AVG","name":"Average plant height","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"deprecated","display_name":"Average Plant Height","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":261,"href":"http://api.breeding4rice.irri.org/v1/properties/261"},"method_id":{"value":613,"href":"http://api.breeding4rice.irri.org/v1/methods/613"},"scale_id":{"value":610,"href":"http://api.breeding4rice.irri.org/v1/scales/610"},"synonym":null,"remarks":"verified by CParducho","notes":null,"description":"deprecated","default_value":"","scales":{"id":610,"abbrev":null,"name":null,"unit":null,"type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":"deprecated","notes":null,"scale_value":null,"reference":null,"property_id":{"value":261,"href":"http://api.breeding4rice.irri.org/v1/properties/261"},"method_id":{"value":613,"href":"http://api.breeding4rice.irri.org/v1/methods/613"},"ontology_id":{"value":"CO_320:0000480","href":"http://api.breeding4rice.irri.org/v1/ontologies/CO_320:0000480"},"bibliographical_reference":"Crop Ontology - Rice Trait","values":[]}},{"id":1477,"abbrev":"YLD_0_CONT5","label":"GYKGPHA in kg/ha with TPL used in DRT & RFSA","name":"GYKGPHA in kg/ha without MC but with TPL using different formula used by DRT and RFSA","data_type":"float","member_data_type":null,"not_null":false,"type":"observation","status":"active","display_name":"GYKGPHA In Kg/ha Without MC But With TPL Using Different Formula Used By DRT And RFSA","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":137,"href":"http://api.breeding4rice.irri.org/v1/properties/137"},"method_id":{"value":1179,"href":"http://api.breeding4rice.irri.org/v1/methods/1179"},"scale_id":{"value":1144,"href":"http://api.breeding4rice.irri.org/v1/scales/1144"},"synonym":null,"remarks":null,"notes":null,"description":"GYKGPHA without Moisture Content (MC) but with Total Plotyield (TPL) using a different formyula used by DRT and RFSA. ","default_value":"","scales":{"id":1144,"abbrev":null,"name":null,"unit":null,"type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/properties"},"method_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/methods"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}},{"id":1478,"abbrev":"YLD_0_CONT5_ENT","label":"Average of GYKGPHA in kg/ha with TPL","name":"Average of GYKGPHA in kg/ha with TPL","data_type":"float","member_data_type":"float","not_null":false,"type":"observation","status":"active","display_name":"Average Of GYKGPHA In Kg/ha With TPL","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":136,"href":"http://api.breeding4rice.irri.org/v1/properties/136"},"method_id":{"value":1180,"href":"http://api.breeding4rice.irri.org/v1/methods/1180"},"scale_id":{"value":1145,"href":"http://api.breeding4rice.irri.org/v1/scales/1145"},"synonym":null,"remarks":null,"notes":null,"description":"Average of GYKGPHA in kg/ha without MC but with TPL using different formula used by DRT and RFSA","default_value":"","scales":{"id":1145,"abbrev":null,"name":null,"unit":"kg/ha","type":"continuous","level":"nominal","description":"Average of GYKGPHA in kg/ha with TPL","display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/properties"},"method_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/methods"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}},{"id":93,"abbrev":"DRT8_SPIK_1_9","label":"DRT8","name":"drought recovery","data_type":"integer","member_data_type":null,"not_null":false,"type":"observation","status":"deprecated","display_name":"Drought Recovery","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":101,"href":"http://api.breeding4rice.irri.org/v1/properties/101"},"method_id":{"value":141,"href":"http://api.breeding4rice.irri.org/v1/methods/141"},"scale_id":{"value":141,"href":"http://api.breeding4rice.irri.org/v1/scales/141"},"synonym":null,"remarks":"Deprecate; Replace DRT8_SPIK_1_9 with DRR_SCOR_1_9rnrnverified by recarpio","notes":null,"description":"Drought sensitivity. Tolerance score at 9-10 bars","default_value":"","scales":{"id":141,"abbrev":"DRT8_SPIK_1_9_SCALE_1","name":"drought recovery 10","unit":null,"type":"categorical","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":"SCALE (spikelet fertility)^ 1= More than 80%n3= 61-80%n5= 41-60%n7= 11-40%n9= Less than 11%","reference":null,"property_id":{"value":101,"href":"http://api.breeding4rice.irri.org/v1/properties/101"},"method_id":{"value":141,"href":"http://api.breeding4rice.irri.org/v1/methods/141"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[{"id":310,"value":"1","order_number":1,"display_name":null,"description":"More than 80%","remarks":null},{"id":311,"value":"3","order_number":2,"display_name":null,"description":"61-80%","remarks":null},{"id":312,"value":"5","order_number":3,"display_name":null,"description":"41-60%","remarks":null},{"id":313,"value":"7","order_number":4,"display_name":null,"description":"11-40%","remarks":null},{"id":314,"value":"9","order_number":5,"display_name":null,"description":"Less than 11%","remarks":null}]}},{"id":86,"abbrev":"DRT4_SCOR_1_9","label":"DRT4","name":"drought recovery","data_type":"integer","member_data_type":null,"not_null":false,"type":"observation","status":"deprecated","display_name":"Drought Recovery","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":101,"href":"http://api.breeding4rice.irri.org/v1/properties/101"},"method_id":{"value":134,"href":"http://api.breeding4rice.irri.org/v1/methods/134"},"scale_id":{"value":134,"href":"http://api.breeding4rice.irri.org/v1/scales/134"},"synonym":null,"remarks":"Deprecate; Replace DRT4_SCOR_1_9 with DRR_SCOR_1_9rnrnverified by recarpio","notes":null,"description":"Drought resistance. Resistance score at early vegetative stage (40 DAS)","default_value":"","scales":{"id":134,"abbrev":"DRT2_SCOR_1_9_SCALE_1","name":"drought recovery 3","unit":null,"type":"categorical","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":"SCALE (plants recovered)^ 1= 90-100%n3= 70-89%n5= 40-69%n7= 20-39%n9= 0-19%","reference":null,"property_id":{"value":101,"href":"http://api.breeding4rice.irri.org/v1/properties/101"},"method_id":{"value":134,"href":"http://api.breeding4rice.irri.org/v1/methods/134"},"ontology_id":{"value":"CO_320:0000405","href":"http://api.breeding4rice.irri.org/v1/ontologies/CO_320:0000405"},"bibliographical_reference":"Crop Ontology - Rice Trait","values":[{"id":274,"value":"5","order_number":3,"display_name":null,"description":"40-69%","remarks":null},{"id":275,"value":"7","order_number":4,"display_name":null,"description":"20-39%","remarks":null},{"id":276,"value":"9","order_number":5,"display_name":null,"description":"0-19%","remarks":null},{"id":272,"value":"1","order_number":1,"display_name":null,"description":"90-100%","remarks":null},{"id":273,"value":"3","order_number":2,"display_name":null,"description":"70-89%","remarks":null}]}},{"id":94,"abbrev":"DRT9_SCOR_1_9","label":"DRT9","name":"drought recovery","data_type":"integer","member_data_type":null,"not_null":false,"type":"observation","status":"deprecated","display_name":"Drought Recovery","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":101,"href":"http://api.breeding4rice.irri.org/v1/properties/101"},"method_id":{"value":139,"href":"http://api.breeding4rice.irri.org/v1/methods/139"},"scale_id":{"value":139,"href":"http://api.breeding4rice.irri.org/v1/scales/139"},"synonym":null,"remarks":"Depricate; Replace RT9_SCOR_1_9 with DRR_SCOR_1_9rnrnverified by recarpio","notes":null,"description":"Drought recovery. Rate of recovery after exposure to 9-10 bars","default_value":"","scales":{"id":139,"abbrev":"DRT7_SPIK_1_9_SCALE_1","name":"drought recovery 8","unit":null,"type":"categorical","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":"SCALE (spikelet fertility)^ 1= More than 80%n3= 61-80%n5= 41-60%n7= 11-40%n9= Less than 11%","reference":null,"property_id":{"value":101,"href":"http://api.breeding4rice.irri.org/v1/properties/101"},"method_id":{"value":139,"href":"http://api.breeding4rice.irri.org/v1/methods/139"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[{"id":299,"value":"1","order_number":1,"display_name":null,"description":"More than 80%","remarks":null},{"id":300,"value":"3","order_number":2,"display_name":null,"description":"61-80%","remarks":null},{"id":301,"value":"5","order_number":3,"display_name":null,"description":"41-60%","remarks":null},{"id":302,"value":"7","order_number":4,"display_name":null,"description":"11-40%","remarks":null},{"id":303,"value":"9","order_number":5,"display_name":null,"description":"Less than 11%","remarks":null}]}},{"id":38,"abbrev":"BLAST","label":"BLAST","name":"blast","data_type":"integer","member_data_type":null,"not_null":false,"type":"observation","status":"deprecated","display_name":"Blast","ontology_reference":null,"bibliographical_reference":null,"property_id":{"value":73,"href":"http://api.breeding4rice.irri.org/v1/properties/73"},"method_id":{"value":83,"href":"http://api.breeding4rice.irri.org/v1/methods/83"},"scale_id":{"value":83,"href":"http://api.breeding4rice.irri.org/v1/scales/83"},"synonym":null,"remarks":"deprecated. Replaced with BL_NURS_0_9rnrnverified by CLotho","notes":null,"description":null,"default_value":"","scales":{"id":83,"abbrev":"BLAST_SCALE_1","name":"blast 1","unit":null,"type":"categorical","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":"0=SES Score Blast Nursery 0n1=SES Score Blast Nursery 1n3=SES Score Blast Nursery 3n5=SES Score Blast Nursery 5n7=SES Score Blast Nursery 7n9=SES Score Blast Nursery 9","reference":null,"property_id":{"value":73,"href":"http://api.breeding4rice.irri.org/v1/properties/73"},"method_id":{"value":83,"href":"http://api.breeding4rice.irri.org/v1/methods/83"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[{"id":92,"value":"1","order_number":2,"display_name":null,"description":"SES Score Blast Nursery 1","remarks":null},{"id":93,"value":"3","order_number":3,"display_name":null,"description":"SES Score Blast Nursery 3","remarks":null},{"id":94,"value":"5","order_number":4,"display_name":null,"description":"SES Score Blast Nursery 5","remarks":null},{"id":95,"value":"7","order_number":5,"display_name":null,"description":"SES Score Blast Nursery 7","remarks":null},{"id":91,"value":"0","order_number":1,"display_name":null,"description":"SES Score Blast Nursery 0","remarks":null},{"id":96,"value":"9","order_number":6,"display_name":null,"description":"SES Score Blast Nursery 9","remarks":null}]}}]
     * _links : {"self":{"href":"http://api.breeding4rice.irri.org/v1/variables/scales?type=observation&accessToken=HL47DjDoZvYVIAtan9zXcxiY5EBUgJTeWGctyi7k&page=1"},"next":{"href":"http://api.breeding4rice.irri.org/v1/variables/scales?type=observation&accessToken=HL47DjDoZvYVIAtan9zXcxiY5EBUgJTeWGctyi7k&page=2"},"last":{"href":"http://api.breeding4rice.irri.org/v1/variables/scales?type=observation&accessToken=HL47DjDoZvYVIAtan9zXcxiY5EBUgJTeWGctyi7k&page=35"}}
     * _meta : {"totalRows":685,"pageCount":35,"page":1,"limit":20,"offset":0,"sort":[]}
     */

    private DataEntity data;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity {
        /**
         * self : {"href":"http://api.breeding4rice.irri.org/v1/variables/scales?type=observation&accessToken=HL47DjDoZvYVIAtan9zXcxiY5EBUgJTeWGctyi7k&page=1"}
         * next : {"href":"http://api.breeding4rice.irri.org/v1/variables/scales?type=observation&accessToken=HL47DjDoZvYVIAtan9zXcxiY5EBUgJTeWGctyi7k&page=2"}
         * last : {"href":"http://api.breeding4rice.irri.org/v1/variables/scales?type=observation&accessToken=HL47DjDoZvYVIAtan9zXcxiY5EBUgJTeWGctyi7k&page=35"}
         */

        private LinksEntity _links;
        /**
         * totalRows : 685
         * pageCount : 35
         * page : 1
         * limit : 20
         * offset : 0
         * sort : []
         */

        private MetaEntity _meta;
        /**
         * id : 32
         * abbrev : FERT1_DATE_CONT
         * label : FERT1 DATE
         * name : FERTILIZER DATE - 1ST APPLICATION
         * data_type : date
         * member_data_type : null
         * not_null : false
         * type : metadata
         * status : active
         * display_name : Fertilizer application date for first application
         * ontology_reference : null
         * bibliographical_reference : null
         * property_id : {"value":412,"href":"http://api.breeding4rice.irri.org/v1/properties/412"}
         * method_id : {"value":76,"href":"http://api.breeding4rice.irri.org/v1/methods/76"}
         * scale_id : {"value":76,"href":"http://api.breeding4rice.irri.org/v1/scales/76"}
         * synonym : null
         * remarks : verified by CParducho
         * notes : null
         * description : Date of 1st fertilizer application
         * default_value :
         * scales : {"id":76,"abbrev":"FERT1_DATE_CONT_SCALE_5358a1b888ab5","name":"FERT1_DATE_CONT scale","unit":null,"type":"discrete","level":"nominal","description":null,"display_name":null,"remarks":"verified by CParducho","notes":null,"scale_value":null,"reference":null,"property_id":{"value":412,"href":"http://api.breeding4rice.irri.org/v1/properties/412"},"method_id":{"value":76,"href":"http://api.breeding4rice.irri.org/v1/methods/76"},"ontology_id":{"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"},"bibliographical_reference":null,"values":[]}
         */

        private List<ItemsEntity> items;

        public void set_links(LinksEntity _links) {
            this._links = _links;
        }

        public void set_meta(MetaEntity _meta) {
            this._meta = _meta;
        }

        public void setItems(List<ItemsEntity> items) {
            this.items = items;
        }

        public LinksEntity get_links() {
            return _links;
        }

        public MetaEntity get_meta() {
            return _meta;
        }

        public List<ItemsEntity> getItems() {
            return items;
        }

        public static class LinksEntity {
            /**
             * href : http://api.breeding4rice.irri.org/v1/variables/scales?type=observation&accessToken=HL47DjDoZvYVIAtan9zXcxiY5EBUgJTeWGctyi7k&page=1
             */

            private SelfEntity self;
            /**
             * href : http://api.breeding4rice.irri.org/v1/variables/scales?type=observation&accessToken=HL47DjDoZvYVIAtan9zXcxiY5EBUgJTeWGctyi7k&page=2
             */

            private NextEntity next;
            /**
             * href : http://api.breeding4rice.irri.org/v1/variables/scales?type=observation&accessToken=HL47DjDoZvYVIAtan9zXcxiY5EBUgJTeWGctyi7k&page=35
             */

            private LastEntity last;

            public void setSelf(SelfEntity self) {
                this.self = self;
            }

            public void setNext(NextEntity next) {
                this.next = next;
            }

            public void setLast(LastEntity last) {
                this.last = last;
            }

            public SelfEntity getSelf() {
                return self;
            }

            public NextEntity getNext() {
                return next;
            }

            public LastEntity getLast() {
                return last;
            }

            public static class SelfEntity {
                private String href;

                public void setHref(String href) {
                    this.href = href;
                }

                public String getHref() {
                    return href;
                }
            }

            public static class NextEntity {
                private String href;

                public void setHref(String href) {
                    this.href = href;
                }

                public String getHref() {
                    return href;
                }
            }

            public static class LastEntity {
                private String href;

                public void setHref(String href) {
                    this.href = href;
                }

                public String getHref() {
                    return href;
                }
            }
        }

        public static class MetaEntity {
            private int totalRows;
            private int pageCount;
            private int page;
            private int limit;
            private int offset;
            private List<?> sort;

            public void setTotalRows(int totalRows) {
                this.totalRows = totalRows;
            }

            public void setPageCount(int pageCount) {
                this.pageCount = pageCount;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public void setOffset(int offset) {
                this.offset = offset;
            }

            public void setSort(List<?> sort) {
                this.sort = sort;
            }

            public int getTotalRows() {
                return totalRows;
            }

            public int getPageCount() {
                return pageCount;
            }

            public int getPage() {
                return page;
            }

            public int getLimit() {
                return limit;
            }

            public int getOffset() {
                return offset;
            }

            public List<?> getSort() {
                return sort;
            }
        }

        public static class ItemsEntity {
            private int id;
            private String abbrev;
            private String label;
            private String name;
            private String data_type;
            private Object member_data_type;
            private boolean not_null;
            private String type;
            private String status;
            private String display_name;
            private Object ontology_reference;
            private Object bibliographical_reference;
            /**
             * value : 412
             * href : http://api.breeding4rice.irri.org/v1/properties/412
             */

            private PropertyIdEntity property_id;
            /**
             * value : 76
             * href : http://api.breeding4rice.irri.org/v1/methods/76
             */

            private MethodIdEntity method_id;
            /**
             * value : 76
             * href : http://api.breeding4rice.irri.org/v1/scales/76
             */

            private ScaleIdEntity scale_id;
            private Object synonym;
            private String remarks;
            private Object notes;
            private String description;
            private String default_value;
            /**
             * id : 76
             * abbrev : FERT1_DATE_CONT_SCALE_5358a1b888ab5
             * name : FERT1_DATE_CONT scale
             * unit : null
             * type : discrete
             * level : nominal
             * description : null
             * display_name : null
             * remarks : verified by CParducho
             * notes : null
             * scale_value : null
             * reference : null
             * property_id : {"value":412,"href":"http://api.breeding4rice.irri.org/v1/properties/412"}
             * method_id : {"value":76,"href":"http://api.breeding4rice.irri.org/v1/methods/76"}
             * ontology_id : {"value":null,"href":"http://api.breeding4rice.irri.org/v1/ontologies"}
             * bibliographical_reference : null
             * values : []
             */

            private ScalesEntity scales;

            public void setId(int id) {
                this.id = id;
            }

            public void setAbbrev(String abbrev) {
                this.abbrev = abbrev;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setData_type(String data_type) {
                this.data_type = data_type;
            }

            public void setMember_data_type(Object member_data_type) {
                this.member_data_type = member_data_type;
            }

            public void setNot_null(boolean not_null) {
                this.not_null = not_null;
            }

            public void setType(String type) {
                this.type = type;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public void setDisplay_name(String display_name) {
                this.display_name = display_name;
            }

            public void setOntology_reference(Object ontology_reference) {
                this.ontology_reference = ontology_reference;
            }

            public void setBibliographical_reference(Object bibliographical_reference) {
                this.bibliographical_reference = bibliographical_reference;
            }

            public void setProperty_id(PropertyIdEntity property_id) {
                this.property_id = property_id;
            }

            public void setMethod_id(MethodIdEntity method_id) {
                this.method_id = method_id;
            }

            public void setScale_id(ScaleIdEntity scale_id) {
                this.scale_id = scale_id;
            }

            public void setSynonym(Object synonym) {
                this.synonym = synonym;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public void setNotes(Object notes) {
                this.notes = notes;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public void setDefault_value(String default_value) {
                this.default_value = default_value;
            }

            public void setScales(ScalesEntity scales) {
                this.scales = scales;
            }

            public int getId() {
                return id;
            }

            public String getAbbrev() {
                return abbrev;
            }

            public String getLabel() {
                return label;
            }

            public String getName() {
                return name;
            }

            public String getData_type() {
                return data_type;
            }

            public Object getMember_data_type() {
                return member_data_type;
            }

            public boolean isNot_null() {
                return not_null;
            }

            public String getType() {
                return type;
            }

            public String getStatus() {
                return status;
            }

            public String getDisplay_name() {
                return display_name;
            }

            public Object getOntology_reference() {
                return ontology_reference;
            }

            public Object getBibliographical_reference() {
                return bibliographical_reference;
            }

            public PropertyIdEntity getProperty_id() {
                return property_id;
            }

            public MethodIdEntity getMethod_id() {
                return method_id;
            }

            public ScaleIdEntity getScale_id() {
                return scale_id;
            }

            public Object getSynonym() {
                return synonym;
            }

            public String getRemarks() {
                return remarks;
            }

            public Object getNotes() {
                return notes;
            }

            public String getDescription() {
                return description;
            }

            public String getDefault_value() {
                return default_value;
            }

            public ScalesEntity getScales() {
                return scales;
            }

            public static class PropertyIdEntity {
                private int value;
                private String href;

                public void setValue(int value) {
                    this.value = value;
                }

                public void setHref(String href) {
                    this.href = href;
                }

                public int getValue() {
                    return value;
                }

                public String getHref() {
                    return href;
                }
            }

            public static class MethodIdEntity {
                private int value;
                private String href;

                public void setValue(int value) {
                    this.value = value;
                }

                public void setHref(String href) {
                    this.href = href;
                }

                public int getValue() {
                    return value;
                }

                public String getHref() {
                    return href;
                }
            }

            public static class ScaleIdEntity {
                private int value;
                private String href;

                public void setValue(int value) {
                    this.value = value;
                }

                public void setHref(String href) {
                    this.href = href;
                }

                public int getValue() {
                    return value;
                }

                public String getHref() {
                    return href;
                }
            }

            public static class ScalesEntity {
                private int id;
                private String abbrev;
                private String name;
                private Object unit;
                private String type;
                private String level;
                private Object description;
                private Object display_name;
                private String remarks;
                private Object notes;
                private Object scale_value;
                private Object reference;
                /**
                 * value : 412
                 * href : http://api.breeding4rice.irri.org/v1/properties/412
                 */

                private PropertyIdEntity property_id;
                /**
                 * value : 76
                 * href : http://api.breeding4rice.irri.org/v1/methods/76
                 */

                private MethodIdEntity method_id;
                /**
                 * value : null
                 * href : http://api.breeding4rice.irri.org/v1/ontologies
                 */

                private OntologyIdEntity ontology_id;
                private Object bibliographical_reference;
                private List<?> values;

                public void setId(int id) {
                    this.id = id;
                }

                public void setAbbrev(String abbrev) {
                    this.abbrev = abbrev;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setUnit(Object unit) {
                    this.unit = unit;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public void setDescription(Object description) {
                    this.description = description;
                }

                public void setDisplay_name(Object display_name) {
                    this.display_name = display_name;
                }

                public void setRemarks(String remarks) {
                    this.remarks = remarks;
                }

                public void setNotes(Object notes) {
                    this.notes = notes;
                }

                public void setScale_value(Object scale_value) {
                    this.scale_value = scale_value;
                }

                public void setReference(Object reference) {
                    this.reference = reference;
                }

                public void setProperty_id(PropertyIdEntity property_id) {
                    this.property_id = property_id;
                }

                public void setMethod_id(MethodIdEntity method_id) {
                    this.method_id = method_id;
                }

                public void setOntology_id(OntologyIdEntity ontology_id) {
                    this.ontology_id = ontology_id;
                }

                public void setBibliographical_reference(Object bibliographical_reference) {
                    this.bibliographical_reference = bibliographical_reference;
                }

                public void setValues(List<?> values) {
                    this.values = values;
                }

                public int getId() {
                    return id;
                }

                public String getAbbrev() {
                    return abbrev;
                }

                public String getName() {
                    return name;
                }

                public Object getUnit() {
                    return unit;
                }

                public String getType() {
                    return type;
                }

                public String getLevel() {
                    return level;
                }

                public Object getDescription() {
                    return description;
                }

                public Object getDisplay_name() {
                    return display_name;
                }

                public String getRemarks() {
                    return remarks;
                }

                public Object getNotes() {
                    return notes;
                }

                public Object getScale_value() {
                    return scale_value;
                }

                public Object getReference() {
                    return reference;
                }

                public PropertyIdEntity getProperty_id() {
                    return property_id;
                }

                public MethodIdEntity getMethod_id() {
                    return method_id;
                }

                public OntologyIdEntity getOntology_id() {
                    return ontology_id;
                }

                public Object getBibliographical_reference() {
                    return bibliographical_reference;
                }

                public List<?> getValues() {
                    return values;
                }

                public static class PropertyIdEntity {
                    private int value;
                    private String href;

                    public void setValue(int value) {
                        this.value = value;
                    }

                    public void setHref(String href) {
                        this.href = href;
                    }

                    public int getValue() {
                        return value;
                    }

                    public String getHref() {
                        return href;
                    }
                }

                public static class MethodIdEntity {
                    private int value;
                    private String href;

                    public void setValue(int value) {
                        this.value = value;
                    }

                    public void setHref(String href) {
                        this.href = href;
                    }

                    public int getValue() {
                        return value;
                    }

                    public String getHref() {
                        return href;
                    }
                }

                public static class OntologyIdEntity {
                    private Object value;
                    private String href;

                    public void setValue(Object value) {
                        this.value = value;
                    }

                    public void setHref(String href) {
                        this.href = href;
                    }

                    public Object getValue() {
                        return value;
                    }

                    public String getHref() {
                        return href;
                    }
                }
            }
        }
    }
}
