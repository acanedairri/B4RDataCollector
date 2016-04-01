package org.irri.entity;

import java.util.List;

/**
 * Created by ACañeda on 2015-11-18.
 */
public class StudyMetadata {


    /**
     * http://api.breeding4rice.irri.org/v1/studies/2059/metadata
     * success : true
     * data : {"id":2059,"key":"1011000110620151217","program":"IRSEA","place":"IRRIHQ","phase":"F1","year":2015,"season":"Wet","name":"IRSEA-IRRIHQ-F1-2015-WS-7","title":"For crossing purposes. Selected specific plant number from F1 for MAS and use in crossing.","remarks":null,"metadata":[{"id":85235,"variable_id":{"value":"STUDY","href":"http://api.breeding4rice.irri.org/v1/variables/484"},"value":"F12015WS_IRSEA_SC2","remarks":null},{"id":85236,"variable_id":{"value":"STUDY_TYPE","href":"http://api.breeding4rice.irri.org/v1/variables/578"},"value":"Nursery","remarks":null},{"id":85237,"variable_id":{"value":"DESIGN","href":"http://api.breeding4rice.irri.org/v1/variables/104"},"value":"Systematic arrangement","remarks":null},{"id":85238,"variable_id":{"value":"REP_COUNT","href":"http://api.breeding4rice.irri.org/v1/variables/488"},"value":"1","remarks":null},{"id":85239,"variable_id":{"value":"AUTHOR","href":"http://api.breeding4rice.irri.org/v1/variables/1235"},"value":"18","remarks":null},{"id":85240,"variable_id":{"value":"PROCESS_PATH_ID","href":"http://api.breeding4rice.irri.org/v1/variables/1328"},"value":"192","remarks":null},{"id":85255,"variable_id":{"value":"ENTRY_COUNT_CONT","href":"http://api.breeding4rice.irri.org/v1/variables/102"},"value":"16","remarks":null}]}
     */

    private boolean success;
    /**
     * id : 2059
     * key : 1011000110620151217
     * program : IRSEA
     * place : IRRIHQ
     * phase : F1
     * year : 2015
     * season : Wet
     * name : IRSEA-IRRIHQ-F1-2015-WS-7
     * title : For crossing purposes. Selected specific plant number from F1 for MAS and use in crossing.
     * remarks : null
     * metadata : [{"id":85235,"variable_id":{"value":"STUDY","href":"http://api.breeding4rice.irri.org/v1/variables/484"},"value":"F12015WS_IRSEA_SC2","remarks":null},{"id":85236,"variable_id":{"value":"STUDY_TYPE","href":"http://api.breeding4rice.irri.org/v1/variables/578"},"value":"Nursery","remarks":null},{"id":85237,"variable_id":{"value":"DESIGN","href":"http://api.breeding4rice.irri.org/v1/variables/104"},"value":"Systematic arrangement","remarks":null},{"id":85238,"variable_id":{"value":"REP_COUNT","href":"http://api.breeding4rice.irri.org/v1/variables/488"},"value":"1","remarks":null},{"id":85239,"variable_id":{"value":"AUTHOR","href":"http://api.breeding4rice.irri.org/v1/variables/1235"},"value":"18","remarks":null},{"id":85240,"variable_id":{"value":"PROCESS_PATH_ID","href":"http://api.breeding4rice.irri.org/v1/variables/1328"},"value":"192","remarks":null},{"id":85255,"variable_id":{"value":"ENTRY_COUNT_CONT","href":"http://api.breeding4rice.irri.org/v1/variables/102"},"value":"16","remarks":null}]
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
        /**
         * id : 85235
         * variable_id : {"value":"STUDY","href":"http://api.breeding4rice.irri.org/v1/variables/484"}
         * value : F12015WS_IRSEA_SC2
         * remarks : null
         */

        private List<MetadataEntity> metadata;

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

        public void setMetadata(List<MetadataEntity> metadata) {
            this.metadata = metadata;
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
            if(title!=null) {
                return title;
            }else{
                return "";
            }
        }

        public Object getRemarks() {
            return remarks;
        }

        public List<MetadataEntity> getMetadata() {
            return metadata;
        }

        public static class MetadataEntity {
            private int id;
            /**
             * value : STUDY
             * href : http://api.breeding4rice.irri.org/v1/variables/484
             */

            private VariableIdEntity variable_id;
            private String value;
            private Object remarks;

            public void setId(int id) {
                this.id = id;
            }

            public void setVariable_id(VariableIdEntity variable_id) {
                this.variable_id = variable_id;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public void setRemarks(Object remarks) {
                this.remarks = remarks;
            }

            public int getId() {
                return id;
            }

            public VariableIdEntity getVariable_id() {
                return variable_id;
            }

            public String getValue() {
                return value;
            }

            public Object getRemarks() {
                return remarks;
            }

            public static class VariableIdEntity {
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
