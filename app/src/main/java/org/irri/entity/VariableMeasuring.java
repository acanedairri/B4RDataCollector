package org.irri.entity;

/**
 * Created by ACañeda on 2016-03-16.
 */
public class VariableMeasuring {


    int id;
    int variable_id;
    String abbrev;
    String label;
    String name;
    String data_type;
    String display_name;
    String scale_value;
    String is_selected;
    int order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVariable_id() {
        return variable_id;
    }

    public void setVariable_id(int variable_id) {
        this.variable_id = variable_id;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getScale_value() {
        return scale_value;
    }

    public void setScale_value(String scale_value) {
        this.scale_value = scale_value;
    }

    public String getIs_selected() {
        return is_selected;
    }

    public void setIs_selected(String is_selected) {
        this.is_selected = is_selected;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
