package org.irri.entity;

import java.io.Serializable;


public class FieldTraitModel  implements Serializable{
	@Override
	public String toString() {
		return "FieldTraitModel [id=" + id + ", TraitCode=" + TraitCode
				+ ", Description=" + Description + ", Property=" + Property
				+ ", Scale=" + Scale + ", Method=" + Method + ", DataType="
				+ DataType + ", DataGroup=" + DataGroup + ", Category="
				+ Category + ", TemplateGroup=" + TemplateGroup + ", Required="
				+ Required + ", Visible=" + Visible + ", InputType="
				+ InputType + ", InputOptions=" + InputOptions + ", Value="
				+ Value + ", isMandatory=" + isMandatory + ", InputProperty="
				+ InputProperty + "]";
	}

	private int id;

	private String TraitCode;

	private String Description;

	private String Property;

	private String Scale;

	private String Method;

	private String DataType;

	private String DataGroup;

	private String Category;

	private String TemplateGroup;

	private boolean Required;

	private boolean Visible;
	

	private String InputType;

	private String InputOptions;

	private String Value;

	private boolean isMandatory;

	private String InputProperty;
	
	public FieldTraitModel(){
		//REQUIRED BY ORMLite
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTraitCode() {
		return TraitCode;
	}
	public boolean isMandatory() {
		return isMandatory;
	}
	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}
	public String getInputProperty() {
		return InputProperty;
	}
	public void setInputProperty(String inputProperty) {
		InputProperty = inputProperty;
	}
	public void setTraitCode(String traitCode) {
		TraitCode = traitCode;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getProperty() {
		return Property;
	}
	public void setProperty(String property) {
		Property = property;
	}
	public String getScale() {
		return Scale;
	}
	public void setScale(String scale) {
		Scale = scale;
	}
	public String getMethod() {
		return Method;
	}
	public void setMethod(String method) {
		Method = method;
	}
	public String getDataType() {
		return DataType;
	}
	public void setDataType(String dataType) {
		DataType = dataType;
	}
	public String getDataGroup() {
		return DataGroup;
	}
	public void setDataGroup(String dataGroup) {
		DataGroup = dataGroup;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getTemplateGroup() {
		return TemplateGroup;
	}
	public void setTemplateGroup(String templateGroup) {
		TemplateGroup = templateGroup;
	}
	public boolean isRequired() {
		return Required;
	}
	public void setRequired(boolean required) {
		Required = required;
	}
	public String getInputType() {
		return InputType;
	}
	public void setInputType(String inputType) {
		InputType = inputType;
	}
	public String getInputOptions() {
		return InputOptions;
	}
	public void setInputOptions(String inputOptions) {
		InputOptions = inputOptions;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}

	public boolean isVisible() {
		return Visible;
	}
	public void setVisible(boolean visible) {
		Visible = visible;
	}

}
