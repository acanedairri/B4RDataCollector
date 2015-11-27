package org.irri.entity;

import java.util.List;

/**
 * Created by ACañeda on 2015-11-10.
 *
 * call to ws api : http://api.breeding4rice.irri.org/v1/variables/scales?limit=20&type=observation&accessToken=<token>
 *
 */
public class Variable {



    private boolean success;


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
         * self : {"href":"http://api.breeding4rice.irri.org/v1/variables/scales?type=observation&accessToken=S07Pz1MQdW3F1g2V8Ty1cwoC1If2PHSGOpbo5gLB&page=1"}
         * next : {"href":"http://api.breeding4rice.irri.org/v1/variables/scales?type=observation&accessToken=S07Pz1MQdW3F1g2V8Ty1cwoC1If2PHSGOpbo5gLB&page=2"}
         * last : {"href":"http://api.breeding4rice.irri.org/v1/variables/scales?type=observation&accessToken=S07Pz1MQdW3F1g2V8Ty1cwoC1If2PHSGOpbo5gLB&page=35"}
         */

        private LinksEntity _links;
        /**
         * totalRows : 682
         * pageCount : 35
         * page : 1
         * limit : 20
         * offset : 0
         * sort : []
         */

        private MetaEntity _meta;
        /**
         * id : 130
         * abbrev : GRS_CONT
         * label : GRS RATIO
         * name : grain shape
         * data_type : float
         * member_data_type : null
         * not_null : false
         * type : observation
         * status : active
         * display_name : Grain shape (length-width ratio)
         * ontology_reference : CO_320:0000464
         * bibliographical_reference : Crop Ontology
         * property_id : {"value":131,"href":"http://api.breeding4rice.irri.org/v1/properties/131"}
         * method_id : {"value":188,"href":"http://api.breeding4rice.irri.org/v1/methods/188"}
         * scale_id : {"value":188,"href":"http://api.breeding4rice.irri.org/v1/scales/188"}
         * synonym : null
         * remarks : verified by weusebio

         * notes : null
         * description : An assay to determine the variation in the shape of the dehulled grain. [CO:rs]
         * default_value :
         * scales : {"id":188,"abbrev":"GRS_CONT_SCALE_536c34e7c551c","name":"GRS_CONT scale","unit":null,"type":"continuous","level":"nominal","description":null,"display_name":null,"remarks":null,"notes":null,"scale_value":null,"reference":null,"property_id":{"value":131,"href":"http://api.breeding4rice.irri.org/v1/properties/131"},"method_id":{"value":188,"href":"http://api.breeding4rice.irri.org/v1/methods/188"},"ontology_id":{"value":"CO_320:0000464","href":"http://api.breeding4rice.irri.org/v1/ontologies/CO_320:0000464"},"bibliographical_reference":"Crop Ontology - Rice Trait","values":[]}
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
             * href : http://api.breeding4rice.irri.org/v1/variables/scales?type=observation&accessToken=S07Pz1MQdW3F1g2V8Ty1cwoC1If2PHSGOpbo5gLB&page=1
             */

            private SelfEntity self;
            /**
             * href : http://api.breeding4rice.irri.org/v1/variables/scales?type=observation&accessToken=S07Pz1MQdW3F1g2V8Ty1cwoC1If2PHSGOpbo5gLB&page=2
             */

            private NextEntity next;
            /**
             * href : http://api.breeding4rice.irri.org/v1/variables/scales?type=observation&accessToken=S07Pz1MQdW3F1g2V8Ty1cwoC1If2PHSGOpbo5gLB&page=35
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
            private String ontology_reference;
            private String bibliographical_reference;
            /**
             * value : 131
             * href : http://api.breeding4rice.irri.org/v1/properties/131
             */

            private PropertyIdEntity property_id;
            /**
             * value : 188
             * href : http://api.breeding4rice.irri.org/v1/methods/188
             */

            private MethodIdEntity method_id;
            /**
             * value : 188
             * href : http://api.breeding4rice.irri.org/v1/scales/188
             */

            private ScaleIdEntity scale_id;
            private Object synonym;
            private String remarks;
            private Object notes;
            private String description;
            private String default_value;
            /**
             * id : 188
             * abbrev : GRS_CONT_SCALE_536c34e7c551c
             * name : GRS_CONT scale
             * unit : null
             * type : continuous
             * level : nominal
             * description : null
             * display_name : null
             * remarks : null
             * notes : null
             * scale_value : null
             * reference : null
             * property_id : {"value":131,"href":"http://api.breeding4rice.irri.org/v1/properties/131"}
             * method_id : {"value":188,"href":"http://api.breeding4rice.irri.org/v1/methods/188"}
             * ontology_id : {"value":"CO_320:0000464","href":"http://api.breeding4rice.irri.org/v1/ontologies/CO_320:0000464"}
             * bibliographical_reference : Crop Ontology - Rice Trait
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

            public void setOntology_reference(String ontology_reference) {
                this.ontology_reference = ontology_reference;
            }

            public void setBibliographical_reference(String bibliographical_reference) {
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

            public String getOntology_reference() {
                return ontology_reference;
            }

            public String getBibliographical_reference() {
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
                private Object remarks;
                private Object notes;
                private Object scale_value;
                private Object reference;
                /**
                 * value : 131
                 * href : http://api.breeding4rice.irri.org/v1/properties/131
                 */

                private PropertyIdEntity property_id;
                /**
                 * value : 188
                 * href : http://api.breeding4rice.irri.org/v1/methods/188
                 */

                private MethodIdEntity method_id;
                /**
                 * value : CO_320:0000464
                 * href : http://api.breeding4rice.irri.org/v1/ontologies/CO_320:0000464
                 */

                private OntologyIdEntity ontology_id;
                private String bibliographical_reference;
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

                public void setRemarks(Object remarks) {
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

                public void setBibliographical_reference(String bibliographical_reference) {
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

                public Object getRemarks() {
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

                public String getBibliographical_reference() {
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
                    private String value;
                    private String href;

                    public void setValue(String value) {
                        this.value = value;
                    }

                    public void setHref(String href) {
                        this.href = href;
                    }

                    public String getValue() {
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
