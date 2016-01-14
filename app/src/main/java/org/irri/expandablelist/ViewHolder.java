package org.irri.expandablelist;

import android.widget.CheckBox;
import android.widget.TextView;

import java.io.Serializable;

class ViewHolder
  implements Serializable
{
  CheckBox checkbox;
  int position;
  TextView text;
  boolean value;
}

