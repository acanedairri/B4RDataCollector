package org.irri.entity;

import java.util.List;

/**
 * Created by ACañeda on 2015-11-10.
 */
public class Study {


    /**
     * success : true
     * data : {"items":[{"id":2178,"key":"1011000110320151220","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-10","study":"2015WSAYT_Grp1-Blast screening","title":"2015WSAYT_Grp1-Blast screening","remarks":null,"author":"Lopena, Vitaliano"},{"id":2179,"key":"1011000110320151221","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-11","study":"2015WSAYT_Grp2-Blast screening","title":"2015WSAYT-Grp2-Blast screening","remarks":null,"author":"Lopena, Vitaliano"},{"id":1765,"key":"1011000110320151212","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-2","study":"2015WSAYT_Grp1","title":"Advanced Yield Trial 2015WS, Group1","remarks":null,"author":"Lopena, Vitaliano"},{"id":1766,"key":"1011000110320151213","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-3","study":"2015WSAYT_Grp2","title":"Advanced Yield Trial 2015WS, Group 2","remarks":null,"author":"Lopena, Vitaliano"},{"id":1769,"key":"1011000110320151214","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-4","study":"2015WSDSR_Grp1","title":"2015WS DIrect SEEDED Rice (DSR)","remarks":null,"author":"Lopena, Vitaliano"},{"id":1771,"key":"1011000110320151215","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-5","study":"2015WSDSR_Grp2","title":"2015WS Direct Seeded Rice(DSR)_Group 2","remarks":null,"author":"Lopena, Vitaliano"},{"id":1785,"key":"1011000110320151216","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-6","study":"2015WSDSR-TP_Grp1","title":"2015WS DSR-Transplanted_Group 1","remarks":null,"author":"Lopena, Vitaliano"},{"id":1786,"key":"1011000110320151217","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-7","study":"2015WSDSR-TP_Grp2","title":"2015WS DSR-Transplanted_Group 2","remarks":null,"author":"Lopena, Vitaliano"},{"id":1788,"key":"1011000110320151218","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-8","study":"2015WSAWD_Grp1","title":"AWD 2015WS, Group 1","remarks":null,"author":"Lopena, Vitaliano"},{"id":1789,"key":"1011000110320151219","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-9","study":"2015WSAWD_Grp2","title":"2015WS AWD_ Group 2","remarks":null,"author":"Lopena, Vitaliano"},{"id":2338,"key":"1011000110320161121","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-AYT-2016-DS-11","study":"2016DSAYT_Grp2","title":"2016DS AYT_Grp2","remarks":null,"author":"Lopena, Vitaliano"},{"id":2247,"key":"1011000110320161112","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-AYT-2016-DS-2","study":"2016DS DSR_Grp1","title":"2016 DS DSR_Group 1","remarks":null,"author":"Lopena, Vitaliano"},{"id":2248,"key":"1011000110320161113","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-AYT-2016-DS-3","study":"2016DS DSR_Grp2","title":"2016DS DSR_Group 2","remarks":null,"author":"Lopena, Vitaliano"},{"id":2249,"key":"1011000110320161114","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-AYT-2016-DS-4","study":"2016DSAYT_DSR","title":"2016DS AYT_DSR","remarks":null,"author":"Lopena, Vitaliano"},{"id":2332,"key":"1011000110320161115","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-AYT-2016-DS-5","study":"2016DSAYT_Grp1","title":"Irrigated-SEA Advance Yield Trial for 2016 Dry Season. Group1","remarks":null,"author":"Lopena, Vitaliano"},{"id":2335,"key":"1011000110320161118","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-AYT-2016-DS-8","study":"2016DS DSR-TP_Grp1","title":"2016DS DSR-TP_Grp 1","remarks":null,"author":"Lopena, Vitaliano"},{"id":2336,"key":"1011000110320161119","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-AYT-2016-DS-9","study":"2016DS DSR-TP_Grp2","title":"2016DS DSR-TP_Grp2","remarks":null,"author":"Lopena, Vitaliano"},{"id":2458,"key":"1011000113720161176","program":"IRSEA","place":"IRRIHQ","phase":"CRS","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-CRS-2016-DS-66","study":null,"title":"test","remarks":null,"author":null},{"id":2459,"key":"1011000113720161177","program":"IRSEA","place":"IRRIHQ","phase":"CRS","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-CRS-2016-DS-67","study":null,"title":"TEST","remarks":null,"author":null},{"id":894,"key":"1011000110620151112","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Dry","name":"IRSEA-IRRIHQ-F1-2015-DS-2","study":null,"title":"2015DS_LxT2","remarks":null,"author":null},{"id":1521,"key":"1011000110620151212","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-2","study":"2015WS_STU","title":"Furry's materials for Indonesia ","remarks":null,"author":"Verdeprado, Holden"},{"id":1603,"key":"1011000110620151213","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-3","study":"2015WS_LxT2","title":"LXT2 landraces by elite","remarks":null,"author":"Verdeprado, Holden"},{"id":1621,"key":"1011000110620151214","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-4","study":"2015WS_LxT1","title":"LXT1 elite by elite","remarks":null,"author":"Verdeprado, Holden"},{"id":1746,"key":"1011000110620151215","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-5","study":"F12015WS_IRSEA_SC","title":"F12015WS_NURSERY","remarks":null,"author":"Verdeprado, Holden"},{"id":2059,"key":"1011000110620151217","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-7","study":"F12015WS_IRSEA_SC2","title":"For crossing purposes. Selected specific plant number from F1 for MAS and use in crossing.","remarks":null,"author":"Lotho, Connie"},{"id":2233,"key":"1011000110620161112","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-F1-2016-DS-2","study":"2016DSLxT","title":"2016DS_LxT  elite by elite","remarks":null,"author":"Verdeprado, Holden"},{"id":2359,"key":"1011000110620161113","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-F1-2016-DS-3","study":"F12016DS_IRSEA","title":"2016DS F1 Nursery","remarks":null,"author":"Verdeprado, Holden"},{"id":2255,"key":"1011000111020161112","program":"IRSEA","place":"IRRIHQ","phase":"F4","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-F4-2016-DS-2","study":"2016DS_BMCE BMS","title":"BMCE BMS 2016DS","remarks":null,"author":"Santelices, Ronald"},{"id":2254,"key":"1011000111020161113","program":"IRSEA","place":"IRRIHQ","phase":"F4","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-F4-2016-DS-3","study":"2016DS_BMCE BLK","title":"BMCE Bulk 2016 Dry Season","remarks":null,"author":"Santelices, Ronald"},{"id":1797,"key":"1011000111120151212","program":"IRSEA","place":"IRRIHQ","phase":"F5","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F5-2015-WS-2","study":"2015WSSPS","title":"2015WS Single Plant Selection","remarks":null,"author":"Mendoza, Rhulyx"},{"id":2324,"key":"1011000111220161112","program":"IRSEA","place":"IRRIHQ","phase":"F6","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-F6-2016-DS-2","study":"2016DSLST1","title":"2016DS Line Stage Testing","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1567,"key":"1011000110520151213","program":"IRSEA","place":"IRRIHQ","phase":"HB","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-HB-2015-WS-3","study":"2015WS HB Parents","title":null,"remarks":null,"author":"Verdeprado, Holden"},{"id":2166,"key":"1011000110520161112","program":"IRSEA","place":"IRRIHQ","phase":"HB","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-HB-2016-DS-2","study":"HB2016DS_IRSEA","title":"HB2016DS","remarks":null,"author":"Verdeprado, Holden"},{"id":1825,"key":"1011000113620151212","program":"IRSEA","place":"IRRIHQ","phase":"IYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-IYT-2015-WS-2","study":"2015WSM","title":"2015WS Short Duration Yield Trial","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1840,"key":"1011000113620151213","program":"IRSEA","place":"IRRIHQ","phase":"IYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-IYT-2015-WS-3","study":"2015WSP","title":"2015WS Yield Trial for Student (Pan)","remarks":null,"author":"Mendoza, Rhulyx"},{"id":2183,"key":"1011000113620161112","program":"IRSEA","place":"IRRIHQ","phase":"IYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-IYT-2016-DS-2","study":"2016DS STU2","title":"STU2 Project 2016 Dry Season","remarks":null,"author":"Santelices, Ronald"},{"id":2184,"key":"1011000113620161113","program":"IRSEA","place":"IRRIHQ","phase":"IYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-IYT-2016-DS-3","study":"2016DS_HLYT","title":"Heat lines Yield Trials 2016 Dry Season","remarks":null,"author":"Santelices, Ronald"},{"id":2224,"key":"1011000113620161114","program":"IRSEA","place":"IRRIHQ","phase":"IYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-IYT-2016-DS-4","study":"2016DSPLC","title":"Parent Line Comparison Trials 2016 Dry Season","remarks":null,"author":"Santelices, Ronald"},{"id":2323,"key":"1011000113620161115","program":"IRSEA","place":"IRRIHQ","phase":"IYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-IYT-2016-DS-5","study":"2016DSSDYT","title":"2016DS Short Duration Yield Trial","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1520,"key":"1011000110120151213","program":"IRSEA","place":"IRRIHQ","phase":"OYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-OYT-2015-WS-3","study":"2015WS_OYT2","title":null,"remarks":null,"author":"Verdeprado, Holden"},{"id":1697,"key":"1011000110120151215","program":"IRSEA","place":"IRRIHQ","phase":"OYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-OYT-2015-WS-5","study":"2015WSOYT_Grp1","title":"Observational Yield Trial","remarks":null,"author":"Santelices, Ronald"},{"id":1792,"key":"1011000110120151216","program":"IRSEA","place":"IRRIHQ","phase":"OYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-OYT-2015-WS-6","study":"2015WSOYT_Grp2","title":"Observational Yield Trials","remarks":null,"author":"Santelices, Ronald"},{"id":2181,"key":"1011000110120161112","program":"IRSEA","place":"IRRIHQ","phase":"OYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-OYT-2016-DS-2","study":"2016DSOYT ","title":"Observational Yield Trials 2016 Dry Season","remarks":null,"author":"Santelices, Ronald"},{"id":2232,"key":"1011000110120161113","program":"IRSEA","place":"IRRIHQ","phase":"OYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-OYT-2016-DS-3","study":"2016DS_OYT2","title":"2016DS_OYT2","remarks":null,"author":"Verdeprado, Holden"},{"id":1798,"key":"1011000113120151212","program":"IRSEA","place":"IRRIHQ","phase":"PN","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PN-2015-WS-2","study":"2015WSLST","title":"2015WS Line Stage Testing","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1855,"key":"1011000113120151213","program":"IRSEA","place":"IRRIHQ","phase":"PN","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PN-2015-WS-3","study":"2015WSLST2","title":"2015WS Line Stage Testing","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1861,"key":"1011000113120151214","program":"IRSEA","place":"IRRIHQ","phase":"PN","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PN-2015-WS-4","study":"2015WSLST3","title":"2015WS Line Stage Testing","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1763,"key":"1011000111620151212","program":"IRSEA","place":"IRRIHQ","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PYT-2015-WS-2","study":"2015WSPYT_Grp1","title":"Preliminary Yield Trial (PYT) 2015WS, Group 1","remarks":null,"author":"Lopena, Vitaliano"},{"id":1764,"key":"1011000111620151213","program":"IRSEA","place":"IRRIHQ","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PYT-2015-WS-3","study":"2015WSPYT_Grp2","title":"Preliminary Yield Trial 2015WS, Group 2","remarks":null,"author":"Lopena, Vitaliano"},{"id":1841,"key":"1011000111620151215","program":"IRSEA","place":"IRRIHQ","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PYT-2015-WS-5","study":"2015WSRFxT","title":"2015WS Rainfed cross testing yield trial under IRRI field environment","remarks":null,"author":"Mendoza, Rhulyx"},{"id":2026,"key":"1011000111620151218","program":"IRSEA","place":"IRRIHQ","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PYT-2015-WS-8","study":"2015WSPYT_Grp1 - Blast screening","title":"2015WSPYT_Grp1-Blast screening","remarks":null,"author":"Lopena, Vitaliano"},{"id":2177,"key":"1011000111620151219","program":"IRSEA","place":"IRRIHQ","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PYT-2015-WS-9","study":"2015WSPYT_Grp2-Blast screening","title":"2015WSPYT_Grp2-Blast screening","remarks":null,"author":"Lopena, Vitaliano"},{"id":2134,"key":"1011000111620161113","program":"IRSEA","place":"IRRIHQ","phase":"PYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-PYT-2016-DS-3","study":"2016DSPYT","title":"2016 DS PYT","remarks":null,"author":"Lopena, Vitaliano"},{"id":2163,"key":"1011000110720151120","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2015,"season":"Dry","name":"IRSEA-IRRIHQ-RGA-2015-DS-10","study":"Jean's population","title":"Jean's population","remarks":null,"author":"Collard, Bertrand"},{"id":1822,"key":"1011000110720151213","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-RGA-2015-WS-3","study":"TRB-GSR Project","title":"TRB-GSR PROJECT","remarks":null,"author":"Verdeprado, Holden"},{"id":2125,"key":"1011000110720151214","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-RGA-2015-WS-4","study":"BCN_4 Popn_2015WS","title":"Backcross Nursery with 4 Popn (SUB1 and Pi9)","remarks":null,"author":"Verdeprado, Holden"},{"id":2198,"key":"1011000110720151215","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-RGA-2015-WS-5","study":"AfricaRice Tanzania-CESD materials","title":"AfricaRice Tanzania-CESD materials for RGA","remarks":null,"author":"Lotho, Connie"},{"id":2016,"key":"1011000110720161112","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-RGA-2016-DS-2","study":"Improvement of Tong-il type rice ","title":"Improvement of Tong-il type rice","remarks":null,"author":"Shim, Jung-Hyun"},{"id":2221,"key":"1011000110720161113","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-RGA-2016-DS-3","study":"RGA LXT_From_ 2014WS - Batch 1","title":"RGA LXT from 2014WS","remarks":null,"author":"Verdeprado, Holden"},{"id":2223,"key":"1011000110720161114","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-RGA-2016-DS-4","study":"RGA LXT_1 (Elite by elite)  from 2015DS - Batch 1","title":"RGA LXT_1 (Elite by elite) from 2015DS","remarks":null,"author":"Verdeprado, Holden"},{"id":2225,"key":"1011000110720161115","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-RGA-2016-DS-5","study":"RGA LXT_1 (Elite by elite)  from 2015WS - Batch 1","title":"RGA LXT1 from 2015WS - Batch 1","remarks":null,"author":"Verdeprado, Holden"},{"id":2226,"key":"1011000110720161116","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-RGA-2016-DS-6","study":"RGA LXT_2 (Elite by landrace)  from 2015DS - Batch 1","title":"RGA LXT2 2015DS - Batch 1","remarks":null,"author":"Verdeprado, Holden"},{"id":2235,"key":"1011000113520161112","program":"IRSEA","place":"IRRIHQ","phase":"SEM","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-SEM-2016-DS-2","study":"2016DS IRSEA_NEW Xa and Tungro Source","title":"NEW Source for Xa and RTV genes","remarks":null,"author":"Verdeprado, Holden"},{"id":1889,"key":"1011001710320151212","program":"IRSEA","place":"MM_NY","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-MM_NY-AYT-2015-WS-2","study":"2015WSAYT_MMR","title":"2015WSAYT_MMR","remarks":null,"author":"Lopena, Vitaliano"},{"id":1799,"key":"1011001710120151212","program":"IRSEA","place":"MM_NY","phase":"OYT","year":2015,"season":"Wet","name":"IRSEA-MM_NY-OYT-2015-WS-2","study":"2015WSOYT_MMR","title":"2015WSOYT_MMR","remarks":null,"author":"Santelices, Ronald"},{"id":1800,"key":"1011001711620151212","program":"IRSEA","place":"MM_NY","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-MM_NY-PYT-2015-WS-2","study":"2015WSPYT_MMR_Grp1","title":"2015WSPYT_MMR_Grp1","remarks":null,"author":"Lopena, Vitaliano"},{"id":1801,"key":"1011001711620151213","program":"IRSEA","place":"MM_NY","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-MM_NY-PYT-2015-WS-3","study":"2015WSPYT_MMR_Grp2","title":"2015WSPYT_MMR_Grp2","remarks":null,"author":"Lopena, Vitaliano"},{"id":1988,"key":"1011000310320151212","program":"IRSEA","place":"PH_AN_RM","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-PH_AN_RM-AYT-2015-WS-2","study":"2015WSAYT_AGUSAN_Mod1","title":"Advanced Yield Trial 2015WS, Module 1. Agusan field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1989,"key":"1011000310320151213","program":"IRSEA","place":"PH_AN_RM","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-PH_AN_RM-AYT-2015-WS-3","study":"2015WSAYT_AGUSAN_Mod2","title":"Advanced Yield Trial 2015WS, Module 2. Agusan field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1489,"key":"1011001010120151212","program":"IRSEA","place":"PH_BK_MR2","phase":"OYT","year":2015,"season":"Wet","name":"IRSEA-PH_BK_MR2-OYT-2015-WS-2","study":"2015WSOYT_CMU","title":"Bukidnon Irrigated Trials OYT 2015WS","remarks":null,"author":"Santelices, Ronald"},{"id":2312,"key":"1011001010120161112","program":"IRSEA","place":"PH_BK_MR2","phase":"OYT","year":2016,"season":"Dry","name":"IRSEA-PH_BK_MR2-OYT-2016-DS-2","study":"2016DSOYT_CMU","title":"Observational Yield Trial 2016 Dry Season. CMU, Bukidnon field","remarks":null,"author":"Santelices, Ronald"},{"id":1868,"key":"1011000911620151212","program":"IRSEA","place":"PH_BO_SG","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-PH_BO_SG-PYT-2015-WS-2","study":"2015WSPYT_BOHOL_Grp2","title":"Preliminary Yield Trials, Group2 (Late mat). Bohol field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1794,"key":"1011000911620151213","program":"IRSEA","place":"PH_BO_SG","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-PH_BO_SG-PYT-2015-WS-3","study":"2015WSPYT_BOHOL_Grp1","title":"Preliminary Yield Trials, Group1 (Early mat). Bohol field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1981,"key":"1011000510320151212","program":"IRSEA","place":"PH_IB_SO","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-PH_IB_SO-AYT-2015-WS-2","study":"2015WSAYT_ISABELA_Mod1","title":"Advanced Yield Trial 2015WS, Module 1. Isabela field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1982,"key":"1011000510320151213","program":"IRSEA","place":"PH_IB_SO","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-PH_IB_SO-AYT-2015-WS-3","study":"2015WSAYT_ISABELA_Mod2","title":"Advanced Yield Trial 2015WS, Module 2. Isabela field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1990,"key":"1011000210320151212","program":"IRSEA","place":"PH_NE_SM2","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-PH_NE_SM2-AYT-2015-WS-2","study":"2015WSAYT_NE_Mod1","title":"Advanced Yield Trial 2015WS, Module 1. Nueva Ecija field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1991,"key":"1011000210320151213","program":"IRSEA","place":"PH_NE_SM2","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-PH_NE_SM2-AYT-2015-WS-3","study":"2015WSAYT_NE_Mod2","title":"Advanced Yield Trials 2015 Wet Season, Module 2. Nueva Ecija field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1793,"key":"1011000210120151212","program":"IRSEA","place":"PH_NE_SM2","phase":"OYT","year":2015,"season":"Wet","name":"IRSEA-PH_NE_SM2-OYT-2015-WS-2","study":"2015WSOYT_NE","title":"Observational Yield Trials","remarks":null,"author":"Santelices, Ronald"},{"id":2313,"key":"1011000210120161112","program":"IRSEA","place":"PH_NE_SM2","phase":"OYT","year":2016,"season":"Dry","name":"IRSEA-PH_NE_SM2-OYT-2016-DS-2","study":"2016DSOYT_NE","title":"Observational Yield trial 2016 Dry Season, Nueva Ecija field","remarks":null,"author":"Santelices, Ronald"},{"id":1796,"key":"1011000211620151212","program":"IRSEA","place":"PH_NE_SM2","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-PH_NE_SM2-PYT-2015-WS-2","study":"2015WSPYT_NE_Grp1","title":"Preliminary yield Trials","remarks":null,"author":"Lopena, Vitaliano"},{"id":1888,"key":"1011000211620151213","program":"IRSEA","place":"PH_NE_SM2","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-PH_NE_SM2-PYT-2015-WS-3","study":"2015WSPYT_NE_Grp2","title":"Preliminary Yield Trials 2015 Wet Season, Group 2. NE field","remarks":null,"author":"Lopena, Vitaliano"},{"id":2314,"key":"1011000211620161112","program":"IRSEA","place":"PH_NE_SM2","phase":"PYT","year":2016,"season":"Dry","name":"IRSEA-PH_NE_SM2-PYT-2016-DS-2","study":"2016DSPYT_NE_Grp1","title":"Preliminary Yield Trial 2016 Dry Season. Group 1. Nueva Ecija field","remarks":null,"author":"Lopena, Vitaliano"},{"id":2412,"key":"1011000211620161113","program":"IRSEA","place":"PH_NE_SM2","phase":"PYT","year":2016,"season":"Dry","name":"IRSEA-PH_NE_SM2-PYT-2016-DS-3","study":"2016DSPYT_NE_Grp2","title":"Preliminary Yield Trial 2016 Dry Season,Group 2 Nueva Ecija Field","remarks":null,"author":"Lopena, Vitaliano"}],"_links":{"self":{"href":"http://api.breeding4rice.irri.org/dev/v1/studies?accessToken=brQIpdtE7s4DnJq4BlbI76ppxyMKLY61r6DmjSwo&limit=-1&sort=name&page=1"}},"_meta":{"totalRows":83,"pageCount":1,"page":1,"limit":-1,"offset":0,"sort":{"name":"asc"}}}
     */

    private boolean success;
    /**
     * items : [{"id":2178,"key":"1011000110320151220","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-10","study":"2015WSAYT_Grp1-Blast screening","title":"2015WSAYT_Grp1-Blast screening","remarks":null,"author":"Lopena, Vitaliano"},{"id":2179,"key":"1011000110320151221","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-11","study":"2015WSAYT_Grp2-Blast screening","title":"2015WSAYT-Grp2-Blast screening","remarks":null,"author":"Lopena, Vitaliano"},{"id":1765,"key":"1011000110320151212","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-2","study":"2015WSAYT_Grp1","title":"Advanced Yield Trial 2015WS, Group1","remarks":null,"author":"Lopena, Vitaliano"},{"id":1766,"key":"1011000110320151213","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-3","study":"2015WSAYT_Grp2","title":"Advanced Yield Trial 2015WS, Group 2","remarks":null,"author":"Lopena, Vitaliano"},{"id":1769,"key":"1011000110320151214","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-4","study":"2015WSDSR_Grp1","title":"2015WS DIrect SEEDED Rice (DSR)","remarks":null,"author":"Lopena, Vitaliano"},{"id":1771,"key":"1011000110320151215","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-5","study":"2015WSDSR_Grp2","title":"2015WS Direct Seeded Rice(DSR)_Group 2","remarks":null,"author":"Lopena, Vitaliano"},{"id":1785,"key":"1011000110320151216","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-6","study":"2015WSDSR-TP_Grp1","title":"2015WS DSR-Transplanted_Group 1","remarks":null,"author":"Lopena, Vitaliano"},{"id":1786,"key":"1011000110320151217","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-7","study":"2015WSDSR-TP_Grp2","title":"2015WS DSR-Transplanted_Group 2","remarks":null,"author":"Lopena, Vitaliano"},{"id":1788,"key":"1011000110320151218","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-8","study":"2015WSAWD_Grp1","title":"AWD 2015WS, Group 1","remarks":null,"author":"Lopena, Vitaliano"},{"id":1789,"key":"1011000110320151219","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-9","study":"2015WSAWD_Grp2","title":"2015WS AWD_ Group 2","remarks":null,"author":"Lopena, Vitaliano"},{"id":2338,"key":"1011000110320161121","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-AYT-2016-DS-11","study":"2016DSAYT_Grp2","title":"2016DS AYT_Grp2","remarks":null,"author":"Lopena, Vitaliano"},{"id":2247,"key":"1011000110320161112","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-AYT-2016-DS-2","study":"2016DS DSR_Grp1","title":"2016 DS DSR_Group 1","remarks":null,"author":"Lopena, Vitaliano"},{"id":2248,"key":"1011000110320161113","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-AYT-2016-DS-3","study":"2016DS DSR_Grp2","title":"2016DS DSR_Group 2","remarks":null,"author":"Lopena, Vitaliano"},{"id":2249,"key":"1011000110320161114","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-AYT-2016-DS-4","study":"2016DSAYT_DSR","title":"2016DS AYT_DSR","remarks":null,"author":"Lopena, Vitaliano"},{"id":2332,"key":"1011000110320161115","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-AYT-2016-DS-5","study":"2016DSAYT_Grp1","title":"Irrigated-SEA Advance Yield Trial for 2016 Dry Season. Group1","remarks":null,"author":"Lopena, Vitaliano"},{"id":2335,"key":"1011000110320161118","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-AYT-2016-DS-8","study":"2016DS DSR-TP_Grp1","title":"2016DS DSR-TP_Grp 1","remarks":null,"author":"Lopena, Vitaliano"},{"id":2336,"key":"1011000110320161119","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-AYT-2016-DS-9","study":"2016DS DSR-TP_Grp2","title":"2016DS DSR-TP_Grp2","remarks":null,"author":"Lopena, Vitaliano"},{"id":2458,"key":"1011000113720161176","program":"IRSEA","place":"IRRIHQ","phase":"CRS","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-CRS-2016-DS-66","study":null,"title":"test","remarks":null,"author":null},{"id":2459,"key":"1011000113720161177","program":"IRSEA","place":"IRRIHQ","phase":"CRS","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-CRS-2016-DS-67","study":null,"title":"TEST","remarks":null,"author":null},{"id":894,"key":"1011000110620151112","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Dry","name":"IRSEA-IRRIHQ-F1-2015-DS-2","study":null,"title":"2015DS_LxT2","remarks":null,"author":null},{"id":1521,"key":"1011000110620151212","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-2","study":"2015WS_STU","title":"Furry's materials for Indonesia ","remarks":null,"author":"Verdeprado, Holden"},{"id":1603,"key":"1011000110620151213","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-3","study":"2015WS_LxT2","title":"LXT2 landraces by elite","remarks":null,"author":"Verdeprado, Holden"},{"id":1621,"key":"1011000110620151214","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-4","study":"2015WS_LxT1","title":"LXT1 elite by elite","remarks":null,"author":"Verdeprado, Holden"},{"id":1746,"key":"1011000110620151215","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-5","study":"F12015WS_IRSEA_SC","title":"F12015WS_NURSERY","remarks":null,"author":"Verdeprado, Holden"},{"id":2059,"key":"1011000110620151217","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-7","study":"F12015WS_IRSEA_SC2","title":"For crossing purposes. Selected specific plant number from F1 for MAS and use in crossing.","remarks":null,"author":"Lotho, Connie"},{"id":2233,"key":"1011000110620161112","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-F1-2016-DS-2","study":"2016DSLxT","title":"2016DS_LxT  elite by elite","remarks":null,"author":"Verdeprado, Holden"},{"id":2359,"key":"1011000110620161113","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-F1-2016-DS-3","study":"F12016DS_IRSEA","title":"2016DS F1 Nursery","remarks":null,"author":"Verdeprado, Holden"},{"id":2255,"key":"1011000111020161112","program":"IRSEA","place":"IRRIHQ","phase":"F4","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-F4-2016-DS-2","study":"2016DS_BMCE BMS","title":"BMCE BMS 2016DS","remarks":null,"author":"Santelices, Ronald"},{"id":2254,"key":"1011000111020161113","program":"IRSEA","place":"IRRIHQ","phase":"F4","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-F4-2016-DS-3","study":"2016DS_BMCE BLK","title":"BMCE Bulk 2016 Dry Season","remarks":null,"author":"Santelices, Ronald"},{"id":1797,"key":"1011000111120151212","program":"IRSEA","place":"IRRIHQ","phase":"F5","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F5-2015-WS-2","study":"2015WSSPS","title":"2015WS Single Plant Selection","remarks":null,"author":"Mendoza, Rhulyx"},{"id":2324,"key":"1011000111220161112","program":"IRSEA","place":"IRRIHQ","phase":"F6","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-F6-2016-DS-2","study":"2016DSLST1","title":"2016DS Line Stage Testing","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1567,"key":"1011000110520151213","program":"IRSEA","place":"IRRIHQ","phase":"HB","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-HB-2015-WS-3","study":"2015WS HB Parents","title":null,"remarks":null,"author":"Verdeprado, Holden"},{"id":2166,"key":"1011000110520161112","program":"IRSEA","place":"IRRIHQ","phase":"HB","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-HB-2016-DS-2","study":"HB2016DS_IRSEA","title":"HB2016DS","remarks":null,"author":"Verdeprado, Holden"},{"id":1825,"key":"1011000113620151212","program":"IRSEA","place":"IRRIHQ","phase":"IYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-IYT-2015-WS-2","study":"2015WSM","title":"2015WS Short Duration Yield Trial","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1840,"key":"1011000113620151213","program":"IRSEA","place":"IRRIHQ","phase":"IYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-IYT-2015-WS-3","study":"2015WSP","title":"2015WS Yield Trial for Student (Pan)","remarks":null,"author":"Mendoza, Rhulyx"},{"id":2183,"key":"1011000113620161112","program":"IRSEA","place":"IRRIHQ","phase":"IYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-IYT-2016-DS-2","study":"2016DS STU2","title":"STU2 Project 2016 Dry Season","remarks":null,"author":"Santelices, Ronald"},{"id":2184,"key":"1011000113620161113","program":"IRSEA","place":"IRRIHQ","phase":"IYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-IYT-2016-DS-3","study":"2016DS_HLYT","title":"Heat lines Yield Trials 2016 Dry Season","remarks":null,"author":"Santelices, Ronald"},{"id":2224,"key":"1011000113620161114","program":"IRSEA","place":"IRRIHQ","phase":"IYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-IYT-2016-DS-4","study":"2016DSPLC","title":"Parent Line Comparison Trials 2016 Dry Season","remarks":null,"author":"Santelices, Ronald"},{"id":2323,"key":"1011000113620161115","program":"IRSEA","place":"IRRIHQ","phase":"IYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-IYT-2016-DS-5","study":"2016DSSDYT","title":"2016DS Short Duration Yield Trial","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1520,"key":"1011000110120151213","program":"IRSEA","place":"IRRIHQ","phase":"OYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-OYT-2015-WS-3","study":"2015WS_OYT2","title":null,"remarks":null,"author":"Verdeprado, Holden"},{"id":1697,"key":"1011000110120151215","program":"IRSEA","place":"IRRIHQ","phase":"OYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-OYT-2015-WS-5","study":"2015WSOYT_Grp1","title":"Observational Yield Trial","remarks":null,"author":"Santelices, Ronald"},{"id":1792,"key":"1011000110120151216","program":"IRSEA","place":"IRRIHQ","phase":"OYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-OYT-2015-WS-6","study":"2015WSOYT_Grp2","title":"Observational Yield Trials","remarks":null,"author":"Santelices, Ronald"},{"id":2181,"key":"1011000110120161112","program":"IRSEA","place":"IRRIHQ","phase":"OYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-OYT-2016-DS-2","study":"2016DSOYT ","title":"Observational Yield Trials 2016 Dry Season","remarks":null,"author":"Santelices, Ronald"},{"id":2232,"key":"1011000110120161113","program":"IRSEA","place":"IRRIHQ","phase":"OYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-OYT-2016-DS-3","study":"2016DS_OYT2","title":"2016DS_OYT2","remarks":null,"author":"Verdeprado, Holden"},{"id":1798,"key":"1011000113120151212","program":"IRSEA","place":"IRRIHQ","phase":"PN","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PN-2015-WS-2","study":"2015WSLST","title":"2015WS Line Stage Testing","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1855,"key":"1011000113120151213","program":"IRSEA","place":"IRRIHQ","phase":"PN","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PN-2015-WS-3","study":"2015WSLST2","title":"2015WS Line Stage Testing","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1861,"key":"1011000113120151214","program":"IRSEA","place":"IRRIHQ","phase":"PN","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PN-2015-WS-4","study":"2015WSLST3","title":"2015WS Line Stage Testing","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1763,"key":"1011000111620151212","program":"IRSEA","place":"IRRIHQ","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PYT-2015-WS-2","study":"2015WSPYT_Grp1","title":"Preliminary Yield Trial (PYT) 2015WS, Group 1","remarks":null,"author":"Lopena, Vitaliano"},{"id":1764,"key":"1011000111620151213","program":"IRSEA","place":"IRRIHQ","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PYT-2015-WS-3","study":"2015WSPYT_Grp2","title":"Preliminary Yield Trial 2015WS, Group 2","remarks":null,"author":"Lopena, Vitaliano"},{"id":1841,"key":"1011000111620151215","program":"IRSEA","place":"IRRIHQ","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PYT-2015-WS-5","study":"2015WSRFxT","title":"2015WS Rainfed cross testing yield trial under IRRI field environment","remarks":null,"author":"Mendoza, Rhulyx"},{"id":2026,"key":"1011000111620151218","program":"IRSEA","place":"IRRIHQ","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PYT-2015-WS-8","study":"2015WSPYT_Grp1 - Blast screening","title":"2015WSPYT_Grp1-Blast screening","remarks":null,"author":"Lopena, Vitaliano"},{"id":2177,"key":"1011000111620151219","program":"IRSEA","place":"IRRIHQ","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PYT-2015-WS-9","study":"2015WSPYT_Grp2-Blast screening","title":"2015WSPYT_Grp2-Blast screening","remarks":null,"author":"Lopena, Vitaliano"},{"id":2134,"key":"1011000111620161113","program":"IRSEA","place":"IRRIHQ","phase":"PYT","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-PYT-2016-DS-3","study":"2016DSPYT","title":"2016 DS PYT","remarks":null,"author":"Lopena, Vitaliano"},{"id":2163,"key":"1011000110720151120","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2015,"season":"Dry","name":"IRSEA-IRRIHQ-RGA-2015-DS-10","study":"Jean's population","title":"Jean's population","remarks":null,"author":"Collard, Bertrand"},{"id":1822,"key":"1011000110720151213","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-RGA-2015-WS-3","study":"TRB-GSR Project","title":"TRB-GSR PROJECT","remarks":null,"author":"Verdeprado, Holden"},{"id":2125,"key":"1011000110720151214","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-RGA-2015-WS-4","study":"BCN_4 Popn_2015WS","title":"Backcross Nursery with 4 Popn (SUB1 and Pi9)","remarks":null,"author":"Verdeprado, Holden"},{"id":2198,"key":"1011000110720151215","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-RGA-2015-WS-5","study":"AfricaRice Tanzania-CESD materials","title":"AfricaRice Tanzania-CESD materials for RGA","remarks":null,"author":"Lotho, Connie"},{"id":2016,"key":"1011000110720161112","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-RGA-2016-DS-2","study":"Improvement of Tong-il type rice ","title":"Improvement of Tong-il type rice","remarks":null,"author":"Shim, Jung-Hyun"},{"id":2221,"key":"1011000110720161113","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-RGA-2016-DS-3","study":"RGA LXT_From_ 2014WS - Batch 1","title":"RGA LXT from 2014WS","remarks":null,"author":"Verdeprado, Holden"},{"id":2223,"key":"1011000110720161114","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-RGA-2016-DS-4","study":"RGA LXT_1 (Elite by elite)  from 2015DS - Batch 1","title":"RGA LXT_1 (Elite by elite) from 2015DS","remarks":null,"author":"Verdeprado, Holden"},{"id":2225,"key":"1011000110720161115","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-RGA-2016-DS-5","study":"RGA LXT_1 (Elite by elite)  from 2015WS - Batch 1","title":"RGA LXT1 from 2015WS - Batch 1","remarks":null,"author":"Verdeprado, Holden"},{"id":2226,"key":"1011000110720161116","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-RGA-2016-DS-6","study":"RGA LXT_2 (Elite by landrace)  from 2015DS - Batch 1","title":"RGA LXT2 2015DS - Batch 1","remarks":null,"author":"Verdeprado, Holden"},{"id":2235,"key":"1011000113520161112","program":"IRSEA","place":"IRRIHQ","phase":"SEM","year":2016,"season":"Dry","name":"IRSEA-IRRIHQ-SEM-2016-DS-2","study":"2016DS IRSEA_NEW Xa and Tungro Source","title":"NEW Source for Xa and RTV genes","remarks":null,"author":"Verdeprado, Holden"},{"id":1889,"key":"1011001710320151212","program":"IRSEA","place":"MM_NY","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-MM_NY-AYT-2015-WS-2","study":"2015WSAYT_MMR","title":"2015WSAYT_MMR","remarks":null,"author":"Lopena, Vitaliano"},{"id":1799,"key":"1011001710120151212","program":"IRSEA","place":"MM_NY","phase":"OYT","year":2015,"season":"Wet","name":"IRSEA-MM_NY-OYT-2015-WS-2","study":"2015WSOYT_MMR","title":"2015WSOYT_MMR","remarks":null,"author":"Santelices, Ronald"},{"id":1800,"key":"1011001711620151212","program":"IRSEA","place":"MM_NY","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-MM_NY-PYT-2015-WS-2","study":"2015WSPYT_MMR_Grp1","title":"2015WSPYT_MMR_Grp1","remarks":null,"author":"Lopena, Vitaliano"},{"id":1801,"key":"1011001711620151213","program":"IRSEA","place":"MM_NY","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-MM_NY-PYT-2015-WS-3","study":"2015WSPYT_MMR_Grp2","title":"2015WSPYT_MMR_Grp2","remarks":null,"author":"Lopena, Vitaliano"},{"id":1988,"key":"1011000310320151212","program":"IRSEA","place":"PH_AN_RM","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-PH_AN_RM-AYT-2015-WS-2","study":"2015WSAYT_AGUSAN_Mod1","title":"Advanced Yield Trial 2015WS, Module 1. Agusan field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1989,"key":"1011000310320151213","program":"IRSEA","place":"PH_AN_RM","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-PH_AN_RM-AYT-2015-WS-3","study":"2015WSAYT_AGUSAN_Mod2","title":"Advanced Yield Trial 2015WS, Module 2. Agusan field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1489,"key":"1011001010120151212","program":"IRSEA","place":"PH_BK_MR2","phase":"OYT","year":2015,"season":"Wet","name":"IRSEA-PH_BK_MR2-OYT-2015-WS-2","study":"2015WSOYT_CMU","title":"Bukidnon Irrigated Trials OYT 2015WS","remarks":null,"author":"Santelices, Ronald"},{"id":2312,"key":"1011001010120161112","program":"IRSEA","place":"PH_BK_MR2","phase":"OYT","year":2016,"season":"Dry","name":"IRSEA-PH_BK_MR2-OYT-2016-DS-2","study":"2016DSOYT_CMU","title":"Observational Yield Trial 2016 Dry Season. CMU, Bukidnon field","remarks":null,"author":"Santelices, Ronald"},{"id":1868,"key":"1011000911620151212","program":"IRSEA","place":"PH_BO_SG","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-PH_BO_SG-PYT-2015-WS-2","study":"2015WSPYT_BOHOL_Grp2","title":"Preliminary Yield Trials, Group2 (Late mat). Bohol field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1794,"key":"1011000911620151213","program":"IRSEA","place":"PH_BO_SG","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-PH_BO_SG-PYT-2015-WS-3","study":"2015WSPYT_BOHOL_Grp1","title":"Preliminary Yield Trials, Group1 (Early mat). Bohol field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1981,"key":"1011000510320151212","program":"IRSEA","place":"PH_IB_SO","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-PH_IB_SO-AYT-2015-WS-2","study":"2015WSAYT_ISABELA_Mod1","title":"Advanced Yield Trial 2015WS, Module 1. Isabela field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1982,"key":"1011000510320151213","program":"IRSEA","place":"PH_IB_SO","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-PH_IB_SO-AYT-2015-WS-3","study":"2015WSAYT_ISABELA_Mod2","title":"Advanced Yield Trial 2015WS, Module 2. Isabela field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1990,"key":"1011000210320151212","program":"IRSEA","place":"PH_NE_SM2","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-PH_NE_SM2-AYT-2015-WS-2","study":"2015WSAYT_NE_Mod1","title":"Advanced Yield Trial 2015WS, Module 1. Nueva Ecija field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1991,"key":"1011000210320151213","program":"IRSEA","place":"PH_NE_SM2","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-PH_NE_SM2-AYT-2015-WS-3","study":"2015WSAYT_NE_Mod2","title":"Advanced Yield Trials 2015 Wet Season, Module 2. Nueva Ecija field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1793,"key":"1011000210120151212","program":"IRSEA","place":"PH_NE_SM2","phase":"OYT","year":2015,"season":"Wet","name":"IRSEA-PH_NE_SM2-OYT-2015-WS-2","study":"2015WSOYT_NE","title":"Observational Yield Trials","remarks":null,"author":"Santelices, Ronald"},{"id":2313,"key":"1011000210120161112","program":"IRSEA","place":"PH_NE_SM2","phase":"OYT","year":2016,"season":"Dry","name":"IRSEA-PH_NE_SM2-OYT-2016-DS-2","study":"2016DSOYT_NE","title":"Observational Yield trial 2016 Dry Season, Nueva Ecija field","remarks":null,"author":"Santelices, Ronald"},{"id":1796,"key":"1011000211620151212","program":"IRSEA","place":"PH_NE_SM2","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-PH_NE_SM2-PYT-2015-WS-2","study":"2015WSPYT_NE_Grp1","title":"Preliminary yield Trials","remarks":null,"author":"Lopena, Vitaliano"},{"id":1888,"key":"1011000211620151213","program":"IRSEA","place":"PH_NE_SM2","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-PH_NE_SM2-PYT-2015-WS-3","study":"2015WSPYT_NE_Grp2","title":"Preliminary Yield Trials 2015 Wet Season, Group 2. NE field","remarks":null,"author":"Lopena, Vitaliano"},{"id":2314,"key":"1011000211620161112","program":"IRSEA","place":"PH_NE_SM2","phase":"PYT","year":2016,"season":"Dry","name":"IRSEA-PH_NE_SM2-PYT-2016-DS-2","study":"2016DSPYT_NE_Grp1","title":"Preliminary Yield Trial 2016 Dry Season. Group 1. Nueva Ecija field","remarks":null,"author":"Lopena, Vitaliano"},{"id":2412,"key":"1011000211620161113","program":"IRSEA","place":"PH_NE_SM2","phase":"PYT","year":2016,"season":"Dry","name":"IRSEA-PH_NE_SM2-PYT-2016-DS-3","study":"2016DSPYT_NE_Grp2","title":"Preliminary Yield Trial 2016 Dry Season,Group 2 Nueva Ecija Field","remarks":null,"author":"Lopena, Vitaliano"}]
     * _links : {"self":{"href":"http://api.breeding4rice.irri.org/dev/v1/studies?accessToken=brQIpdtE7s4DnJq4BlbI76ppxyMKLY61r6DmjSwo&limit=-1&sort=name&page=1"}}
     * _meta : {"totalRows":83,"pageCount":1,"page":1,"limit":-1,"offset":0,"sort":{"name":"asc"}}
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
         * self : {"href":"http://api.breeding4rice.irri.org/dev/v1/studies?accessToken=brQIpdtE7s4DnJq4BlbI76ppxyMKLY61r6DmjSwo&limit=-1&sort=name&page=1"}
         */

        private LinksEntity _links;
        /**
         * totalRows : 83
         * pageCount : 1
         * page : 1
         * limit : -1
         * offset : 0
         * sort : {"name":"asc"}
         */

        private MetaEntity _meta;
        /**
         * id : 2178
         * key : 1011000110320151220
         * program : IRSEA
         * place : IRRIHQ
         * phase : AYT
         * year : 2015
         * season : Wet
         * name : IRSEA-IRRIHQ-AYT-2015-WS-10
         * study : 2015WSAYT_Grp1-Blast screening
         * title : 2015WSAYT_Grp1-Blast screening
         * remarks : null
         * author : Lopena, Vitaliano
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
             * href : http://api.breeding4rice.irri.org/dev/v1/studies?accessToken=brQIpdtE7s4DnJq4BlbI76ppxyMKLY61r6DmjSwo&limit=-1&sort=name&page=1
             */

            private SelfEntity self;

            public void setSelf(SelfEntity self) {
                this.self = self;
            }

            public SelfEntity getSelf() {
                return self;
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
        }

        public static class MetaEntity {
            private int totalRows;
            private int pageCount;
            private int page;
            private int limit;
            private int offset;
            /**
             * name : asc
             */

            private SortEntity sort;

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

            public void setSort(SortEntity sort) {
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

            public SortEntity getSort() {
                return sort;
            }

            public static class SortEntity {
                private String name;

                public void setName(String name) {
                    this.name = name;
                }

                public String getName() {
                    return name;
                }
            }
        }

        public static class ItemsEntity {
            private int id;
            private String key;
            private String program;
            private String place;
            private String phase;
            private int year;
            private String season;
            private String name;
            private String study;
            private String title;
            private Object remarks;
            private String author;

            public void setId(int id) {
                this.id = id;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public void setProgram(String program) {
                this.program = program;
            }

            public void setPlace(String place) {
                this.place = place;
            }

            public void setPhase(String phase) {
                this.phase = phase;
            }

            public void setYear(int year) {
                this.year = year;
            }

            public void setSeason(String season) {
                this.season = season;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setStudy(String study) {
                this.study = study;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setRemarks(Object remarks) {
                this.remarks = remarks;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getId() {
                return id;
            }

            public String getKey() {
                return key;
            }

            public String getProgram() {
                return program;
            }

            public String getPlace() {
                return place;
            }

            public String getPhase() {
                return phase;
            }

            public int getYear() {
                return year;
            }

            public String getSeason() {
                return season;
            }

            public String getName() {
                return name;
            }

            public String getStudy() {
                return study;
            }

            public String getTitle() {
                return title;
            }

            public Object getRemarks() {
                return remarks;
            }

            public String getAuthor() {
                return author;
            }
        }
    }
}
