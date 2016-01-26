package org.irri.entity;

import java.util.List;

/**
 * Created by ACañeda on 2016-01-20.
 */
public class ObservationData {


    /**
     * PLOT_KEY : 10110009116201512131013111
     * REP : 1
     * CODE : 152BH1216
     * PLOTNO : 216
     * ENTNO :
     * ENTCODE :
     * DESIGNATION :
     * PARENTAGE :
     * GENERATION :
     * QR_CODE :
     * FLDROW_CONT :
     * FLDCOL_CONT :
     * observations : [{"abbrev":"AG_SCOR_1_9","value":"9","variable":{"id":692,"href":"http://api.breeding4rice.irri.org/v1/variables/692"}},{"abbrev":"FLW_CONT","value":"102","variable":{"id":78,"href":"http://api.breeding4rice.irri.org/v1/variables/78"}}]
     */

    private String PLOT_KEY;
    private int REP;
    private String CODE;
    private int PLOTNO;
    private String ENTNO;
    private String ENTCODE;
    private String DESIGNATION;
    private String PARENTAGE;
    private String GENERATION;
    private String QR_CODE;
    private String FLDROW_CONT;
    private String FLDCOL_CONT;
    /**
     * abbrev : AG_SCOR_1_9
     * value : 9
     * variable : {"id":692,"href":"http://api.breeding4rice.irri.org/v1/variables/692"}
     */

    private List<ObservationsEntity> observations;

    public void setPLOT_KEY(String PLOT_KEY) {
        this.PLOT_KEY = PLOT_KEY;
    }

    public void setREP(int REP) {
        this.REP = REP;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public void setPLOTNO(int PLOTNO) {
        this.PLOTNO = PLOTNO;
    }

    public void setENTNO(String ENTNO) {
        this.ENTNO = ENTNO;
    }

    public void setENTCODE(String ENTCODE) {
        this.ENTCODE = ENTCODE;
    }

    public void setDESIGNATION(String DESIGNATION) {
        this.DESIGNATION = DESIGNATION;
    }

    public void setPARENTAGE(String PARENTAGE) {
        this.PARENTAGE = PARENTAGE;
    }

    public void setGENERATION(String GENERATION) {
        this.GENERATION = GENERATION;
    }

    public void setQR_CODE(String QR_CODE) {
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

    public int getREP() {
        return REP;
    }

    public String getCODE() {
        return CODE;
    }

    public int getPLOTNO() {
        return PLOTNO;
    }

    public String getENTNO() {
        return ENTNO;
    }

    public String getENTCODE() {
        return ENTCODE;
    }

    public String getDESIGNATION() {
        return DESIGNATION;
    }

    public String getPARENTAGE() {
        return PARENTAGE;
    }

    public String getGENERATION() {
        return GENERATION;
    }

    public String getQR_CODE() {
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
         * id : 692
         * href : http://api.breeding4rice.irri.org/v1/variables/692
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
