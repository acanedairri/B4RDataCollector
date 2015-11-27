package org.irri.entity;

import java.util.List;

/**
 * Created by ACañeda on 2015-11-10.
 */
public class Study {

    /**
     * success : true
     * data : {"items":[{"id":1794,"key":"1011000911620151213","program":"IRSEA","place":"PH_BO_SG","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-PH_BO_SG-PYT-2015-WS-3","title":"Preliminary Yield Trials, Group1 (Early mat). Bohol field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1489,"key":"1011001010120151212","program":"IRSEA","place":"PH_BK_MR2","phase":"OYT","year":2015,"season":"Wet","name":"IRSEA-PH_BK_MR2-OYT-2015-WS-2","title":"Bukidnon Irrigated Trials OYT 2015WS","remarks":null,"author":"Santelices, Ronald"},{"id":1825,"key":"1011000113620151212","program":"IRSEA","place":"IRRIHQ","phase":"IYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-IYT-2015-WS-2","title":"2015WS Short Duration Yield Trial","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1789,"key":"1011000110320151219","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-9","title":"2015WS AWD_ Group 2","remarks":null,"author":"Lopena, Vitaliano"},{"id":1746,"key":"1011000110620151215","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-5","title":"F12015WS_NURSERY","remarks":null,"author":"Verdeprado, Holden"},{"id":1822,"key":"1011000110720151213","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-RGA-2015-WS-3","title":"TRB-GSR PROJECT","remarks":null,"author":"Verdeprado, Holden"},{"id":1868,"key":"1011000911620151212","program":"IRSEA","place":"PH_BO_SG","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-PH_BO_SG-PYT-2015-WS-2","title":"Preliminary Yield Trials, Group2 (Late mat). Bohol field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1861,"key":"1011000113120151214","program":"IRSEA","place":"IRRIHQ","phase":"PN","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PN-2015-WS-4","title":"2015WS Line Stage Testing","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1841,"key":"1011000111620151215","program":"IRSEA","place":"IRRIHQ","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PYT-2015-WS-5","title":"2015WS Rainfed cross testing yield trial under IRRI field environment","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1855,"key":"1011000113120151213","program":"IRSEA","place":"IRRIHQ","phase":"PN","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PN-2015-WS-3","title":"2015WS Line Stage Testing","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1521,"key":"1011000110620151212","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-2","title":"Furry's materials for Indonesia ","remarks":null,"author":"Verdeprado, Holden"},{"id":1520,"key":"1011000110120151213","program":"IRSEA","place":"IRRIHQ","phase":"OYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-OYT-2015-WS-3","title":null,"remarks":null,"author":"Verdeprado, Holden"},{"id":1888,"key":"1011000211620151213","program":"IRSEA","place":"PH_NE_SM2","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-PH_NE_SM2-PYT-2015-WS-3","title":"Preliminary Yield Trials 2015 Wet Season, Group 2. NE field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1603,"key":"1011000110620151213","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-3","title":"LXT2 landraces by elite","remarks":null,"author":"Verdeprado, Holden"},{"id":1621,"key":"1011000110620151214","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-4","title":"LXT1 elite by elite","remarks":null,"author":"Verdeprado, Holden"},{"id":1763,"key":"1011000111620151212","program":"IRSEA","place":"IRRIHQ","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PYT-2015-WS-2","title":"Preliminary Yield Trial (PYT) 2015WS, Group 1","remarks":null,"author":"Lopena, Vitaliano"},{"id":1764,"key":"1011000111620151213","program":"IRSEA","place":"IRRIHQ","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PYT-2015-WS-3","title":"Preliminary Yield Trial 2015WS, Group 2","remarks":null,"author":"Lopena, Vitaliano"},{"id":1766,"key":"1011000110320151213","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-3","title":"Advanced Yield Trial 2015WS, Group 2","remarks":null,"author":"Lopena, Vitaliano"},{"id":1765,"key":"1011000110320151212","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-2","title":"Advanced Yield Trial 2015WS, Group1","remarks":null,"author":"Lopena, Vitaliano"},{"id":1840,"key":"1011000113620151213","program":"IRSEA","place":"IRRIHQ","phase":"IYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-IYT-2015-WS-3","title":"2015WS Yield Trial for Student (Pan)","remarks":null,"author":"Mendoza, Rhulyx"}],"_links":{"self":{"href":"http://api.breeding4rice.irri.org/v1/studies?accessToken=00a8c82d46cf9f0745d5406478032d1234344&page=1"},"next":{"href":"http://api.breeding4rice.irri.org/v1/studies?accessToken=00a8c82d46cf9f0745d5406478032d1234344&page=2"},"last":{"href":"http://api.breeding4rice.irri.org/v1/studies?accessToken=00a8c82d46cf9f0745d5406478032d1234344&page=3"}},"_meta":{"totalRows":42,"pageCount":3,"page":1,"limit":20,"offset":0,"sort":[]}}
     */

    private boolean success;
    /**
     * items : [{"id":1794,"key":"1011000911620151213","program":"IRSEA","place":"PH_BO_SG","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-PH_BO_SG-PYT-2015-WS-3","title":"Preliminary Yield Trials, Group1 (Early mat). Bohol field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1489,"key":"1011001010120151212","program":"IRSEA","place":"PH_BK_MR2","phase":"OYT","year":2015,"season":"Wet","name":"IRSEA-PH_BK_MR2-OYT-2015-WS-2","title":"Bukidnon Irrigated Trials OYT 2015WS","remarks":null,"author":"Santelices, Ronald"},{"id":1825,"key":"1011000113620151212","program":"IRSEA","place":"IRRIHQ","phase":"IYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-IYT-2015-WS-2","title":"2015WS Short Duration Yield Trial","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1789,"key":"1011000110320151219","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-9","title":"2015WS AWD_ Group 2","remarks":null,"author":"Lopena, Vitaliano"},{"id":1746,"key":"1011000110620151215","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-5","title":"F12015WS_NURSERY","remarks":null,"author":"Verdeprado, Holden"},{"id":1822,"key":"1011000110720151213","program":"IRSEA","place":"IRRIHQ","phase":"RGA","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-RGA-2015-WS-3","title":"TRB-GSR PROJECT","remarks":null,"author":"Verdeprado, Holden"},{"id":1868,"key":"1011000911620151212","program":"IRSEA","place":"PH_BO_SG","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-PH_BO_SG-PYT-2015-WS-2","title":"Preliminary Yield Trials, Group2 (Late mat). Bohol field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1861,"key":"1011000113120151214","program":"IRSEA","place":"IRRIHQ","phase":"PN","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PN-2015-WS-4","title":"2015WS Line Stage Testing","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1841,"key":"1011000111620151215","program":"IRSEA","place":"IRRIHQ","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PYT-2015-WS-5","title":"2015WS Rainfed cross testing yield trial under IRRI field environment","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1855,"key":"1011000113120151213","program":"IRSEA","place":"IRRIHQ","phase":"PN","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PN-2015-WS-3","title":"2015WS Line Stage Testing","remarks":null,"author":"Mendoza, Rhulyx"},{"id":1521,"key":"1011000110620151212","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-2","title":"Furry's materials for Indonesia ","remarks":null,"author":"Verdeprado, Holden"},{"id":1520,"key":"1011000110120151213","program":"IRSEA","place":"IRRIHQ","phase":"OYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-OYT-2015-WS-3","title":null,"remarks":null,"author":"Verdeprado, Holden"},{"id":1888,"key":"1011000211620151213","program":"IRSEA","place":"PH_NE_SM2","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-PH_NE_SM2-PYT-2015-WS-3","title":"Preliminary Yield Trials 2015 Wet Season, Group 2. NE field","remarks":null,"author":"Lopena, Vitaliano"},{"id":1603,"key":"1011000110620151213","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-3","title":"LXT2 landraces by elite","remarks":null,"author":"Verdeprado, Holden"},{"id":1621,"key":"1011000110620151214","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-4","title":"LXT1 elite by elite","remarks":null,"author":"Verdeprado, Holden"},{"id":1763,"key":"1011000111620151212","program":"IRSEA","place":"IRRIHQ","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PYT-2015-WS-2","title":"Preliminary Yield Trial (PYT) 2015WS, Group 1","remarks":null,"author":"Lopena, Vitaliano"},{"id":1764,"key":"1011000111620151213","program":"IRSEA","place":"IRRIHQ","phase":"PYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-PYT-2015-WS-3","title":"Preliminary Yield Trial 2015WS, Group 2","remarks":null,"author":"Lopena, Vitaliano"},{"id":1766,"key":"1011000110320151213","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-3","title":"Advanced Yield Trial 2015WS, Group 2","remarks":null,"author":"Lopena, Vitaliano"},{"id":1765,"key":"1011000110320151212","program":"IRSEA","place":"IRRIHQ","phase":"AYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-AYT-2015-WS-2","title":"Advanced Yield Trial 2015WS, Group1","remarks":null,"author":"Lopena, Vitaliano"},{"id":1840,"key":"1011000113620151213","program":"IRSEA","place":"IRRIHQ","phase":"IYT","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-IYT-2015-WS-3","title":"2015WS Yield Trial for Student (Pan)","remarks":null,"author":"Mendoza, Rhulyx"}]
     * _links : {"self":{"href":"http://api.breeding4rice.irri.org/v1/studies?accessToken=00a8c82d46cf9f0745d5406478032d1234344&page=1"},"next":{"href":"http://api.breeding4rice.irri.org/v1/studies?accessToken=00a8c82d46cf9f0745d5406478032d1234344&page=2"},"last":{"href":"http://api.breeding4rice.irri.org/v1/studies?accessToken=00a8c82d46cf9f0745d5406478032d1234344&page=3"}}
     * _meta : {"totalRows":42,"pageCount":3,"page":1,"limit":20,"offset":0,"sort":[]}
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
         * self : {"href":"http://api.breeding4rice.irri.org/v1/studies?accessToken=00a8c82d46cf9f0745d5406478032d1234344&page=1"}
         * next : {"href":"http://api.breeding4rice.irri.org/v1/studies?accessToken=00a8c82d46cf9f0745d5406478032d1234344&page=2"}
         * last : {"href":"http://api.breeding4rice.irri.org/v1/studies?accessToken=00a8c82d46cf9f0745d5406478032d1234344&page=3"}
         */

        private LinksEntity _links;
        /**
         * totalRows : 42
         * pageCount : 3
         * page : 1
         * limit : 20
         * offset : 0
         * sort : []
         */

        private MetaEntity _meta;
        /**
         * id : 1794
         * key : 1011000911620151213
         * program : IRSEA
         * place : PH_BO_SG
         * phase : PYT
         * year : 2015
         * season : Wet
         * name : IRSEA-PH_BO_SG-PYT-2015-WS-3
         * title : Preliminary Yield Trials, Group1 (Early mat). Bohol field
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
             * href : http://api.breeding4rice.irri.org/v1/studies?accessToken=00a8c82d46cf9f0745d5406478032d1234344&page=1
             */

            private SelfEntity self;
            /**
             * href : http://api.breeding4rice.irri.org/v1/studies?accessToken=00a8c82d46cf9f0745d5406478032d1234344&page=2
             */

            private NextEntity next;
            /**
             * href : http://api.breeding4rice.irri.org/v1/studies?accessToken=00a8c82d46cf9f0745d5406478032d1234344&page=3
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
            private String key;
            private String program;
            private String place;
            private String phase;
            private int year;
            private String season;
            private String name;
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
