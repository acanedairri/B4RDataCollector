package org.irri.entity;

import java.util.List;

/**
 * Created by ACañeda on 2015-12-18.
 */
public class VariableSet {



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
         * self : {"href":"http://api.breeding4rice.irri.org/dev/v1/variable-sets?accessToken=NdkOqgqdmGSAQhX7scjHuD7K0f4a35JSGGvsIkiV&limit=-1&sort=abbrev&page=1"}
         */

        private LinksEntity _links;
        /**
         * totalRows : 46
         * pageCount : 1
         * page : 1
         * limit : -1
         * offset : 0
         * sort : {"abbrev":"asc"}
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
             * href : http://api.breeding4rice.irri.org/dev/v1/variable-sets?accessToken=NdkOqgqdmGSAQhX7scjHuD7K0f4a35JSGGvsIkiV&limit=-1&sort=abbrev&page=1
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
             * abbrev : asc
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
                private String abbrev;

                public void setAbbrev(String abbrev) {
                    this.abbrev = abbrev;
                }

                public String getAbbrev() {
                    return abbrev;
                }
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
