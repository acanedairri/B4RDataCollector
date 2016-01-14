package org.irri.expandablelist;

import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.Serializable;

class ViewHolderRadio
  implements Serializable
{
  RadioButton radio;
  int position;
  TextView text;
  boolean value;
  ImageButton btnDelete;
}

