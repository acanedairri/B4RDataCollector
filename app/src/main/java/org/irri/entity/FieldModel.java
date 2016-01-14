package org.irri.entity;

import java.io.Serializable;



public class FieldModel implements Serializable{

	public String traitCode;
	public Object value;
	public boolean visible;
	public boolean required;
	public String type;
	public String options;
	public String label;
	public String category;
	public FieldTraitModel model;
}
