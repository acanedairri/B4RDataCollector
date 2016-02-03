package org.irri.entity;

import java.util.List;

/**
 * Created by ACañeda on 2016-02-02.
 */
public class VariableSetList {


    /**
     * success : true
     * data : {"items":[{"id":2,"abbrev":"AGRONOMIC","name":"agronomic trait","description":"Desc: Variable set containing all agronomic traits; Apps: none","display_name":"Agronomic Trait","ontology_reference":"CO_320:0000070","bibliographical_reference":null,"usage":"data_collection","remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":4,"abbrev":"DESIGN_FACTOR","name":"design factor","description":"Variable set that groups all experimental design variables.","display_name":"Design Factor","ontology_reference":null,"bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":8,"abbrev":"FIELD_MANAGEMENT","name":"field management","description":"The process of managing filed environment by various treatments. [CO:rs]","display_name":"Field Management","ontology_reference":null,"bibliographical_reference":null,"usage":null,"remarks":"CO_715:0000203","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":9,"abbrev":"GRAIN_QUALITY","name":"grain quality trait","description":"Variable set containing Grain Quality traits; \r\n\r\nApps: none","display_name":"Grain Quality Trait","ontology_reference":"CO_320:0000101","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":10,"abbrev":"HYBRID","name":"hybrid trait","description":"Variable set containing Hybid traits; \r\n\r\nApps: none","display_name":"Hybrid Trait","ontology_reference":"CO_320:0000123","bibliographical_reference":null,"usage":null,"remarks":null,"access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":12,"abbrev":"MORPHOLOGICAL","name":"morphological trait","description":"Variable set containing Morphological traits; .\r\n\r\nApps: none","display_name":"Morphological Trait","ontology_reference":"CO_320:0000001","bibliographical_reference":null,"usage":"data_collection","remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":20,"abbrev":"STRESS","name":"stress trait","description":"Variable set containing Stress related traits;\r\n\r\nApps: none","display_name":"Stress","ontology_reference":"CO_320:0000053","bibliographical_reference":null,"usage":"data_collection","remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":47,"abbrev":"CROPDAMAGE","name":"CROP DAMAGE (INSECT)","description":"Desc: Variable set containing Crop damage under insects traits; Apps: none","display_name":"CROP DAMAGE (INSECT)","ontology_reference":null,"bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":48,"abbrev":"CROPDAMAGE_DISEASE","name":"CROP DAMAGE (Disease)","description":"Desc: Variable set containing Crop damage under disease traits; \r\n\r\nApps: none","display_name":"CROP DAMAGE (Disease)","ontology_reference":null,"bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":61,"abbrev":"BIOTIC_STRESS_TRAIT","name":"biotic stress trait","description":" Variable set containing Biotic stress traits; \r\n\r\nApps: none","display_name":"biotic stress trait","ontology_reference":"CO_320:0000168","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":63,"abbrev":"DEEPWATER_STRESS_TRAIT","name":"deepwater stress trait","description":" Desc: Variable set containing deep water stress traits; \r\n\r\nApps: none","display_name":"deepwater stress trait","ontology_reference":"CO_320:0000164","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":66,"abbrev":"DROUGHT_STRESS_TRAIT","name":"drought stress trait","description":"Variable set containing Biotic stress traits; \r\n\r\nApps: none","display_name":"drought stress trait","ontology_reference":"CO_320:0000163","bibliographical_reference":null,"usage":null,"remarks":"cheked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":67,"abbrev":"PHYSIOCHEMICAL_STRESS_TRAIT","name":"physiochemical stress trait","description":"Variable set containing physiochemical stress trait; \r\n\r\nApps: none","display_name":"Physiochemical stress trait","ontology_reference":"CO_320:0000161","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":68,"abbrev":"TEMPERATURE_STRESS_TRAIT","name":"temperature stress trait","description":" Desc: Variable set containing temperature stress trait; \r\n\r\nApps: none","display_name":"temperature stress trait","ontology_reference":"CO_320:0000162","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":71,"abbrev":"FUNGAL_DESEASE","name":"fungal disease","description":"Variable set containing fungal disease traits; \r\n\r\nApps: none","display_name":"fungal disease","ontology_reference":"CO_320:0000170","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":72,"abbrev":"BACTERIAL_DESEASE","name":"bacterial disease","description":"Variable set containing bacterial disease traits \r\n\r\nApps: none","display_name":"bacterial disease","ontology_reference":"CO_320:0000169","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":73,"abbrev":"VIRAL_DESEASE","name":"viral disease","description":"Desc: Variable set containing viral disease traits; \r\n\r\nApps: none","display_name":"viral disease","ontology_reference":"CO_320:0000171","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":74,"abbrev":"INSECT_DAMAGE","name":"insect damage","description":"Variable set containing insect damage traits; \r\n\r\nApps: none","display_name":"insect damage","ontology_reference":"CO_320:0000172","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":75,"abbrev":"PLANTHOPPER_DAMAGE","name":"planthopper damage","description":"Variable set containing plant hopper damage traits; \r\n\r\nApps: none","display_name":"planthopper damage","ontology_reference":"CO_320:0000215","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":277,"abbrev":"SOIL_FACTOR","name":"Soil factor","description":"Variable set containing soil related properties; \r\n\r\nApps: none","display_name":"Soil factor","ontology_reference":"CO_715:0000080","bibliographical_reference":"Crop Ontology - Crop Research","usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]}],"_links":{"self":{"href":"http://api.breeding4rice.irri.org/dev/v1/variable-sets?accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=1"},"next":{"href":"http://api.breeding4rice.irri.org/dev/v1/variable-sets?accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=2"},"last":{"href":"http://api.breeding4rice.irri.org/dev/v1/variable-sets?accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=3"}},"_meta":{"totalRows":46,"pageCount":3,"page":1,"limit":20,"offset":0,"sort":[]}}
     */

    private boolean success;
    /**
     * items : [{"id":2,"abbrev":"AGRONOMIC","name":"agronomic trait","description":"Desc: Variable set containing all agronomic traits; Apps: none","display_name":"Agronomic Trait","ontology_reference":"CO_320:0000070","bibliographical_reference":null,"usage":"data_collection","remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":4,"abbrev":"DESIGN_FACTOR","name":"design factor","description":"Variable set that groups all experimental design variables.","display_name":"Design Factor","ontology_reference":null,"bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":8,"abbrev":"FIELD_MANAGEMENT","name":"field management","description":"The process of managing filed environment by various treatments. [CO:rs]","display_name":"Field Management","ontology_reference":null,"bibliographical_reference":null,"usage":null,"remarks":"CO_715:0000203","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":9,"abbrev":"GRAIN_QUALITY","name":"grain quality trait","description":"Variable set containing Grain Quality traits; \r\n\r\nApps: none","display_name":"Grain Quality Trait","ontology_reference":"CO_320:0000101","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":10,"abbrev":"HYBRID","name":"hybrid trait","description":"Variable set containing Hybid traits; \r\n\r\nApps: none","display_name":"Hybrid Trait","ontology_reference":"CO_320:0000123","bibliographical_reference":null,"usage":null,"remarks":null,"access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":12,"abbrev":"MORPHOLOGICAL","name":"morphological trait","description":"Variable set containing Morphological traits; .\r\n\r\nApps: none","display_name":"Morphological Trait","ontology_reference":"CO_320:0000001","bibliographical_reference":null,"usage":"data_collection","remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":20,"abbrev":"STRESS","name":"stress trait","description":"Variable set containing Stress related traits;\r\n\r\nApps: none","display_name":"Stress","ontology_reference":"CO_320:0000053","bibliographical_reference":null,"usage":"data_collection","remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":47,"abbrev":"CROPDAMAGE","name":"CROP DAMAGE (INSECT)","description":"Desc: Variable set containing Crop damage under insects traits; Apps: none","display_name":"CROP DAMAGE (INSECT)","ontology_reference":null,"bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":48,"abbrev":"CROPDAMAGE_DISEASE","name":"CROP DAMAGE (Disease)","description":"Desc: Variable set containing Crop damage under disease traits; \r\n\r\nApps: none","display_name":"CROP DAMAGE (Disease)","ontology_reference":null,"bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":61,"abbrev":"BIOTIC_STRESS_TRAIT","name":"biotic stress trait","description":" Variable set containing Biotic stress traits; \r\n\r\nApps: none","display_name":"biotic stress trait","ontology_reference":"CO_320:0000168","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":63,"abbrev":"DEEPWATER_STRESS_TRAIT","name":"deepwater stress trait","description":" Desc: Variable set containing deep water stress traits; \r\n\r\nApps: none","display_name":"deepwater stress trait","ontology_reference":"CO_320:0000164","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":66,"abbrev":"DROUGHT_STRESS_TRAIT","name":"drought stress trait","description":"Variable set containing Biotic stress traits; \r\n\r\nApps: none","display_name":"drought stress trait","ontology_reference":"CO_320:0000163","bibliographical_reference":null,"usage":null,"remarks":"cheked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":67,"abbrev":"PHYSIOCHEMICAL_STRESS_TRAIT","name":"physiochemical stress trait","description":"Variable set containing physiochemical stress trait; \r\n\r\nApps: none","display_name":"Physiochemical stress trait","ontology_reference":"CO_320:0000161","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":68,"abbrev":"TEMPERATURE_STRESS_TRAIT","name":"temperature stress trait","description":" Desc: Variable set containing temperature stress trait; \r\n\r\nApps: none","display_name":"temperature stress trait","ontology_reference":"CO_320:0000162","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":71,"abbrev":"FUNGAL_DESEASE","name":"fungal disease","description":"Variable set containing fungal disease traits; \r\n\r\nApps: none","display_name":"fungal disease","ontology_reference":"CO_320:0000170","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":72,"abbrev":"BACTERIAL_DESEASE","name":"bacterial disease","description":"Variable set containing bacterial disease traits \r\n\r\nApps: none","display_name":"bacterial disease","ontology_reference":"CO_320:0000169","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":73,"abbrev":"VIRAL_DESEASE","name":"viral disease","description":"Desc: Variable set containing viral disease traits; \r\n\r\nApps: none","display_name":"viral disease","ontology_reference":"CO_320:0000171","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":74,"abbrev":"INSECT_DAMAGE","name":"insect damage","description":"Variable set containing insect damage traits; \r\n\r\nApps: none","display_name":"insect damage","ontology_reference":"CO_320:0000172","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":75,"abbrev":"PLANTHOPPER_DAMAGE","name":"planthopper damage","description":"Variable set containing plant hopper damage traits; \r\n\r\nApps: none","display_name":"planthopper damage","ontology_reference":"CO_320:0000215","bibliographical_reference":null,"usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]},{"id":277,"abbrev":"SOIL_FACTOR","name":"Soil factor","description":"Variable set containing soil related properties; \r\n\r\nApps: none","display_name":"Soil factor","ontology_reference":"CO_715:0000080","bibliographical_reference":"Crop Ontology - Crop Research","usage":null,"remarks":"checked by weusebio","access":{"type":"PUBLIC","permission":"READ and WRITE"},"collaborators":[]}]
     * _links : {"self":{"href":"http://api.breeding4rice.irri.org/dev/v1/variable-sets?accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=1"},"next":{"href":"http://api.breeding4rice.irri.org/dev/v1/variable-sets?accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=2"},"last":{"href":"http://api.breeding4rice.irri.org/dev/v1/variable-sets?accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=3"}}
     * _meta : {"totalRows":46,"pageCount":3,"page":1,"limit":20,"offset":0,"sort":[]}
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
         * self : {"href":"http://api.breeding4rice.irri.org/dev/v1/variable-sets?accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=1"}
         * next : {"href":"http://api.breeding4rice.irri.org/dev/v1/variable-sets?accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=2"}
         * last : {"href":"http://api.breeding4rice.irri.org/dev/v1/variable-sets?accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=3"}
         */

        private LinksEntity _links;
        /**
         * totalRows : 46
         * pageCount : 3
         * page : 1
         * limit : 20
         * offset : 0
         * sort : []
         */

        private MetaEntity _meta;
        /**
         * id : 2
         * abbrev : AGRONOMIC
         * name : agronomic trait
         * description : Desc: Variable set containing all agronomic traits; Apps: none
         * display_name : Agronomic Trait
         * ontology_reference : CO_320:0000070
         * bibliographical_reference : null
         * usage : data_collection
         * remarks : checked by weusebio
         * access : {"type":"PUBLIC","permission":"READ and WRITE"}
         * collaborators : []
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
             * href : http://api.breeding4rice.irri.org/dev/v1/variable-sets?accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=1
             */

            private SelfEntity self;
            /**
             * href : http://api.breeding4rice.irri.org/dev/v1/variable-sets?accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=2
             */

            private NextEntity next;
            /**
             * href : http://api.breeding4rice.irri.org/dev/v1/variable-sets?accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=3
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
            private String name;
            private String description;
            private String display_name;
            private String ontology_reference;
            private Object bibliographical_reference;
            private String usage;
            private String remarks;
            /**
             * type : PUBLIC
             * permission : READ and WRITE
             */

            private AccessEntity access;
            private List<?> collaborators;

            public void setId(int id) {
                this.id = id;
            }

            public void setAbbrev(String abbrev) {
                this.abbrev = abbrev;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public void setDisplay_name(String display_name) {
                this.display_name = display_name;
            }

            public void setOntology_reference(String ontology_reference) {
                this.ontology_reference = ontology_reference;
            }

            public void setBibliographical_reference(Object bibliographical_reference) {
                this.bibliographical_reference = bibliographical_reference;
            }

            public void setUsage(String usage) {
                this.usage = usage;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public void setAccess(AccessEntity access) {
                this.access = access;
            }

            public void setCollaborators(List<?> collaborators) {
                this.collaborators = collaborators;
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

            public String getDescription() {
                return description;
            }

            public String getDisplay_name() {
                return display_name;
            }

            public String getOntology_reference() {
                return ontology_reference;
            }

            public Object getBibliographical_reference() {
                return bibliographical_reference;
            }

            public String getUsage() {
                return usage;
            }

            public String getRemarks() {
                return remarks;
            }

            public AccessEntity getAccess() {
                return access;
            }

            public List<?> getCollaborators() {
                return collaborators;
            }

            public static class AccessEntity {
                private String type;
                private String permission;

                public void setType(String type) {
                    this.type = type;
                }

                public void setPermission(String permission) {
                    this.permission = permission;
                }

                public String getType() {
                    return type;
                }

                public String getPermission() {
                    return permission;
                }
            }
        }
    }
}
