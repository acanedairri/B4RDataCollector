package org.irri.entity;

import java.util.List;

/**
 * Created by ACañeda on 2016-01-20.
 */
public class ObservationData {


    /**
     * success : true
     * data : {"items":[{"PLOT_KEY":"10110001116201512181011611","PLOTNO":134,"PLOT_CODE":"134","REP":1,"ENTNO":116,"GID":4535966,"DESIGNATION":"IR14D141","ENTCODE":"V116","PARENTAGE":"IR10F214/KHO 456-6 ","GENERATION":"F7","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[{"abbrev":"BL_NURS_0_9","value":"3","variable":{"id":157,"href":"http://api.breeding4rice.irri.org/dev/v1/variables/157"}}]},{"PLOT_KEY":"10110001116201512181011511","PLOTNO":133,"PLOT_CODE":"133","REP":1,"ENTNO":115,"GID":4215864,"DESIGNATION":"IR14A435","ENTCODE":"V115","PARENTAGE":"IR BB 65/IR00A117//IR10A125","GENERATION":"F5","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[{"abbrev":"BL_NURS_0_9","value":"0","variable":{"id":157,"href":"http://api.breeding4rice.irri.org/dev/v1/variables/157"}}]},{"PLOT_KEY":"10110001116201512181011411","PLOTNO":132,"PLOT_CODE":"132","REP":1,"ENTNO":114,"GID":4391000,"DESIGNATION":"IR15A1340","ENTCODE":"V114","PARENTAGE":"IR09N526/IR 68450-36-3-2-2-3//IR08A192 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[{"abbrev":"BL_NURS_0_9","value":"0","variable":{"id":157,"href":"http://api.breeding4rice.irri.org/dev/v1/variables/157"}}]},{"PLOT_KEY":"10110001116201512181011311","PLOTNO":131,"PLOT_CODE":"131","REP":1,"ENTNO":113,"GID":4214872,"DESIGNATION":"IR13A536","ENTCODE":"V113","PARENTAGE":"IR09A228/IR02A201//IR07A234","GENERATION":"F5","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[{"abbrev":"BL_NURS_0_9","value":"1","variable":{"id":157,"href":"http://api.breeding4rice.irri.org/dev/v1/variables/157"}}]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":375,"PLOT_CODE":"375","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":285,"PLOT_CODE":"285","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[{"abbrev":"BL_NURS_0_9","value":"7","variable":{"id":157,"href":"http://api.breeding4rice.irri.org/dev/v1/variables/157"}}]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":399,"PLOT_CODE":"399","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":291,"PLOT_CODE":"291","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":165,"PLOT_CODE":"165","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":393,"PLOT_CODE":"393","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":327,"PLOT_CODE":"327","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":297,"PLOT_CODE":"297","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":139,"PLOT_CODE":"139","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":369,"PLOT_CODE":"369","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":303,"PLOT_CODE":"303","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024411","PLOTNO":286,"PLOT_CODE":"286","REP":1,"ENTNO":244,"GID":300257448,"DESIGNATION":"IR 72","ENTCODE":"V244","PARENTAGE":"IR 19661-9-2-3-3/IR 15795-199-3-3//IR 9129-209-2-2-2-1 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[{"abbrev":"BL_NURS_0_9","value":"4","variable":{"id":157,"href":"http://api.breeding4rice.irri.org/dev/v1/variables/157"}}]},{"PLOT_KEY":"10110001116201512181024411","PLOTNO":292,"PLOT_CODE":"292","REP":1,"ENTNO":244,"GID":300257448,"DESIGNATION":"IR 72","ENTCODE":"V244","PARENTAGE":"IR 19661-9-2-3-3/IR 15795-199-3-3//IR 9129-209-2-2-2-1 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024411","PLOTNO":298,"PLOT_CODE":"298","REP":1,"ENTNO":244,"GID":300257448,"DESIGNATION":"IR 72","ENTCODE":"V244","PARENTAGE":"IR 19661-9-2-3-3/IR 15795-199-3-3//IR 9129-209-2-2-2-1 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024411","PLOTNO":304,"PLOT_CODE":"304","REP":1,"ENTNO":244,"GID":300257448,"DESIGNATION":"IR 72","ENTCODE":"V244","PARENTAGE":"IR 19661-9-2-3-3/IR 15795-199-3-3//IR 9129-209-2-2-2-1 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024411","PLOTNO":310,"PLOT_CODE":"310","REP":1,"ENTNO":244,"GID":300257448,"DESIGNATION":"IR 72","ENTCODE":"V244","PARENTAGE":"IR 19661-9-2-3-3/IR 15795-199-3-3//IR 9129-209-2-2-2-1 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]}],"_links":{"self":{"href":"http://api.breeding4rice.irri.org/dev/v1/study/view-data-collection?id=2026&accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=1"},"next":{"href":"http://api.breeding4rice.irri.org/dev/v1/study/view-data-collection?id=2026&accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=2"},"last":{"href":"http://api.breeding4rice.irri.org/dev/v1/study/view-data-collection?id=2026&accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=21"}},"_meta":{"totalRows":402,"pageCount":21,"page":1,"limit":20,"offset":0,"sort":[]}}
     */

    private boolean success;
    /**
     * items : [{"PLOT_KEY":"10110001116201512181011611","PLOTNO":134,"PLOT_CODE":"134","REP":1,"ENTNO":116,"GID":4535966,"DESIGNATION":"IR14D141","ENTCODE":"V116","PARENTAGE":"IR10F214/KHO 456-6 ","GENERATION":"F7","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[{"abbrev":"BL_NURS_0_9","value":"3","variable":{"id":157,"href":"http://api.breeding4rice.irri.org/dev/v1/variables/157"}}]},{"PLOT_KEY":"10110001116201512181011511","PLOTNO":133,"PLOT_CODE":"133","REP":1,"ENTNO":115,"GID":4215864,"DESIGNATION":"IR14A435","ENTCODE":"V115","PARENTAGE":"IR BB 65/IR00A117//IR10A125","GENERATION":"F5","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[{"abbrev":"BL_NURS_0_9","value":"0","variable":{"id":157,"href":"http://api.breeding4rice.irri.org/dev/v1/variables/157"}}]},{"PLOT_KEY":"10110001116201512181011411","PLOTNO":132,"PLOT_CODE":"132","REP":1,"ENTNO":114,"GID":4391000,"DESIGNATION":"IR15A1340","ENTCODE":"V114","PARENTAGE":"IR09N526/IR 68450-36-3-2-2-3//IR08A192 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[{"abbrev":"BL_NURS_0_9","value":"0","variable":{"id":157,"href":"http://api.breeding4rice.irri.org/dev/v1/variables/157"}}]},{"PLOT_KEY":"10110001116201512181011311","PLOTNO":131,"PLOT_CODE":"131","REP":1,"ENTNO":113,"GID":4214872,"DESIGNATION":"IR13A536","ENTCODE":"V113","PARENTAGE":"IR09A228/IR02A201//IR07A234","GENERATION":"F5","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[{"abbrev":"BL_NURS_0_9","value":"1","variable":{"id":157,"href":"http://api.breeding4rice.irri.org/dev/v1/variables/157"}}]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":375,"PLOT_CODE":"375","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":285,"PLOT_CODE":"285","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[{"abbrev":"BL_NURS_0_9","value":"7","variable":{"id":157,"href":"http://api.breeding4rice.irri.org/dev/v1/variables/157"}}]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":399,"PLOT_CODE":"399","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":291,"PLOT_CODE":"291","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":165,"PLOT_CODE":"165","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":393,"PLOT_CODE":"393","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":327,"PLOT_CODE":"327","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":297,"PLOT_CODE":"297","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":139,"PLOT_CODE":"139","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":369,"PLOT_CODE":"369","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024311","PLOTNO":303,"PLOT_CODE":"303","REP":1,"ENTNO":243,"GID":300257450,"DESIGNATION":"IR 50","ENTCODE":"V243","PARENTAGE":"IR 50/CO 43 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024411","PLOTNO":286,"PLOT_CODE":"286","REP":1,"ENTNO":244,"GID":300257448,"DESIGNATION":"IR 72","ENTCODE":"V244","PARENTAGE":"IR 19661-9-2-3-3/IR 15795-199-3-3//IR 9129-209-2-2-2-1 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[{"abbrev":"BL_NURS_0_9","value":"4","variable":{"id":157,"href":"http://api.breeding4rice.irri.org/dev/v1/variables/157"}}]},{"PLOT_KEY":"10110001116201512181024411","PLOTNO":292,"PLOT_CODE":"292","REP":1,"ENTNO":244,"GID":300257448,"DESIGNATION":"IR 72","ENTCODE":"V244","PARENTAGE":"IR 19661-9-2-3-3/IR 15795-199-3-3//IR 9129-209-2-2-2-1 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024411","PLOTNO":298,"PLOT_CODE":"298","REP":1,"ENTNO":244,"GID":300257448,"DESIGNATION":"IR 72","ENTCODE":"V244","PARENTAGE":"IR 19661-9-2-3-3/IR 15795-199-3-3//IR 9129-209-2-2-2-1 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024411","PLOTNO":304,"PLOT_CODE":"304","REP":1,"ENTNO":244,"GID":300257448,"DESIGNATION":"IR 72","ENTCODE":"V244","PARENTAGE":"IR 19661-9-2-3-3/IR 15795-199-3-3//IR 9129-209-2-2-2-1 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]},{"PLOT_KEY":"10110001116201512181024411","PLOTNO":310,"PLOT_CODE":"310","REP":1,"ENTNO":244,"GID":300257448,"DESIGNATION":"IR 72","ENTCODE":"V244","PARENTAGE":"IR 19661-9-2-3-3/IR 15795-199-3-3//IR 9129-209-2-2-2-1 ","GENERATION":"F6","QR_CODE":null,"FLDROW_CONT":"1","FLDCOL_CONT":"4","observations":[]}]
     * _links : {"self":{"href":"http://api.breeding4rice.irri.org/dev/v1/study/view-data-collection?id=2026&accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=1"},"next":{"href":"http://api.breeding4rice.irri.org/dev/v1/study/view-data-collection?id=2026&accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=2"},"last":{"href":"http://api.breeding4rice.irri.org/dev/v1/study/view-data-collection?id=2026&accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=21"}}
     * _meta : {"totalRows":402,"pageCount":21,"page":1,"limit":20,"offset":0,"sort":[]}
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
         * self : {"href":"http://api.breeding4rice.irri.org/dev/v1/study/view-data-collection?id=2026&accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=1"}
         * next : {"href":"http://api.breeding4rice.irri.org/dev/v1/study/view-data-collection?id=2026&accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=2"}
         * last : {"href":"http://api.breeding4rice.irri.org/dev/v1/study/view-data-collection?id=2026&accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=21"}
         */

        private LinksEntity _links;
        /**
         * totalRows : 402
         * pageCount : 21
         * page : 1
         * limit : 20
         * offset : 0
         * sort : []
         */

        private MetaEntity _meta;
        /**
         * PLOT_KEY : 10110001116201512181011611
         * PLOTNO : 134
         * PLOT_CODE : 134
         * REP : 1
         * ENTNO : 116
         * GID : 4535966
         * DESIGNATION : IR14D141
         * ENTCODE : V116
         * PARENTAGE : IR10F214/KHO 456-6
         * GENERATION : F7
         * QR_CODE : null
         * FLDROW_CONT : 1
         * FLDCOL_CONT : 4
         * observations : [{"abbrev":"BL_NURS_0_9","value":"3","variable":{"id":157,"href":"http://api.breeding4rice.irri.org/dev/v1/variables/157"}}]
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
             * href : http://api.breeding4rice.irri.org/dev/v1/study/view-data-collection?id=2026&accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=1
             */

            private SelfEntity self;
            /**
             * href : http://api.breeding4rice.irri.org/dev/v1/study/view-data-collection?id=2026&accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=2
             */

            private NextEntity next;
            /**
             * href : http://api.breeding4rice.irri.org/dev/v1/study/view-data-collection?id=2026&accessToken=T3kR7IffutamkJckRnddWHQD3SVbdkOlEsOMK5hX&page=21
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
            /**
             * abbrev : BL_NURS_0_9
             * value : 3
             * variable : {"id":157,"href":"http://api.breeding4rice.irri.org/dev/v1/variables/157"}
             */

            private List<ObservationsEntity> observations;

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

            public void setObservations(List<ObservationsEntity> observations) {
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

            public List<ObservationsEntity> getObservations() {
                return observations;
            }

            public static class ObservationsEntity {
                private String abbrev;
                private String value;
                /**
                 * id : 157
                 * href : http://api.breeding4rice.irri.org/dev/v1/variables/157
                 */

                private VariableEntity variable;

                public void setAbbrev(String abbrev) {
                    this.abbrev = abbrev;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public void setVariable(VariableEntity variable) {
                    this.variable = variable;
                }

                public String getAbbrev() {
                    return abbrev;
                }

                public String getValue() {
                    return value;
                }

                public VariableEntity getVariable() {
                    return variable;
                }

                public static class VariableEntity {
                    private int id;
                    private String href;

                    public void setId(int id) {
                        this.id = id;
                    }

                    public void setHref(String href) {
                        this.href = href;
                    }

                    public int getId() {
                        return id;
                    }

                    public String getHref() {
                        return href;
                    }
                }
            }
        }
    }
}
