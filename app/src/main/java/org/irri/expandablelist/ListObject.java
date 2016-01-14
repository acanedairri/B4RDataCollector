package org.irri.expandablelist;

import java.io.Serializable;
import java.util.ArrayList;

public class ListObject
  implements Serializable
{
  public boolean isCheckBoxSelected = false;
  public ArrayList<String> children = new ArrayList();
  public String title;
  public int _id = 0;
  public String traitCode;
  public boolean enabled;
  public ListObject()
  {
  }
  public boolean is_visible;
  public ListObject(String paramString)
  {
    this.title = paramString;
  }
  public boolean isMandatory = false;
}
