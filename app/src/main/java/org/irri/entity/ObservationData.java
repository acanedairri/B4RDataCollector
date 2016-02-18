package org.irri.entity;

import java.util.List;

/**
 * Created by ACañeda on 2016-01-20.
 */
public class ObservationData{


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
         * self : {"href":"http://api.breeding4rice.irri.org/dev/v1/study/view-data-collection?id=2026&accessToken=ESw9caCyes8TTR55MbeJT8UBTuve51ktB6MnonKl&sort=plotno&limit=-1&page=1"}
         */

        private LinksEntity _links;
        /**
         * totalRows : 402
         * pageCount : 1
         * page : 1
         * limit : -1
         * offset : 0
         * sort : {"plotno":"asc"}
         */

        private MetaEntity _meta;
        /**
         * PLOT_KEY : 10110001116201512181024311
         * PLOTNO : 1
         * PLOT_CODE : 1
         * REP : 1
         * ENTNO : 243
         * GID : 300257450
         * DESIGNATION : IR 50
         * ENTCODE : V243
         * PARENTAGE : IR 50/CO 43
         * GENERATION : F6
         * QR_CODE : null
         * FLDROW_CONT : 1
         * FLDCOL_CONT : 4
         * observations : []
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
             * href : http://api.breeding4rice.irri.org/dev/v1/study/view-data-collection?id=2026&accessToken=ESw9caCyes8TTR55MbeJT8UBTuve51ktB6MnonKl&sort=plotno&limit=-1&page=1
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
             * plotno : asc
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
                private String plotno;

                public void setPlotno(String plotno) {
                    this.plotno = plotno;
                }

                public String getPlotno() {
                    return plotno;
                }
            }
        }

        public static class ItemsEntity {
            private String PLOT_KEY;
            private int PLOTNO;
            private String PLOT_CODE;
            private int REP;
            private int ENTNO;
            private int GID;
            private String DESIGNATION;
            private String ENTCODE;
            private String PARENTAGE;
            private String GENERATION;
            private Object QR_CODE;
            private String FLDROW_CONT;
            private String FLDCOL_CONT;
            private List<?> observations;

            public void setPLOT_KEY(String PLOT_KEY) {
                this.PLOT_KEY = PLOT_KEY;
            }

            public void setPLOTNO(int PLOTNO) {
                this.PLOTNO = PLOTNO;
            }

            public void setPLOT_CODE(String PLOT_CODE) {
                this.PLOT_CODE = PLOT_CODE;
            }

            public void setREP(int REP) {
                this.REP = REP;
            }

            public void setENTNO(int ENTNO) {
                this.ENTNO = ENTNO;
            }

            public void setGID(int GID) {
                this.GID = GID;
            }

            public void setDESIGNATION(String DESIGNATION) {
                this.DESIGNATION = DESIGNATION;
            }

            public void setENTCODE(String ENTCODE) {
                this.ENTCODE = ENTCODE;
            }

            public void setPARENTAGE(String PARENTAGE) {
                this.PARENTAGE = PARENTAGE;
            }

            public void setGENERATION(String GENERATION) {
                this.GENERATION = GENERATION;
            }

            public void setQR_CODE(Object QR_CODE) {
                this.QR_CODE = QR_CODE;
            }

            public void setFLDROW_CONT(String FLDROW_CONT) {
                this.FLDROW_CONT = FLDROW_CONT;
            }

            public void setFLDCOL_CONT(String FLDCOL_CONT) {
                this.FLDCOL_CONT = FLDCOL_CONT;
            }

            public void setObservations(List<?> observations) {
                this.observations = observations;
            }

            public String getPLOT_KEY() {
                return PLOT_KEY;
            }

            public int getPLOTNO() {
                return PLOTNO;
            }

            public String getPLOT_CODE() {
                return PLOT_CODE;
            }

            public int getREP() {
                return REP;
            }

            public int getENTNO() {
                return ENTNO;
            }

            public int getGID() {
                return GID;
            }

            public String getDESIGNATION() {
                return DESIGNATION;
            }

            public String getENTCODE() {
                return ENTCODE;
            }

            public String getPARENTAGE() {
                return PARENTAGE;
            }

            public String getGENERATION() {
                return GENERATION;
            }

            public Object getQR_CODE() {
                return QR_CODE;
            }

            public String getFLDROW_CONT() {
                return FLDROW_CONT;
            }

            public String getFLDCOL_CONT() {
                return FLDCOL_CONT;
            }

            public List<?> getObservations() {
                return observations;
            }
        }
    }
}
