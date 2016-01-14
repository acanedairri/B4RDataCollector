package org.irri.expandablelist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import org.irri.activity.R;

import java.util.ArrayList;

public class ExpandableRadioListAdapter extends BaseExpandableListAdapter
{
  private ArrayList<String> childHeader;
  private ArrayList<ListObject> listData;
  private ArrayList<ViewHolderRadio> lstHolders = new ArrayList<ViewHolderRadio>();
  private Context mContext;
  private ListObject selectedItem = null;
  private ExpandableListActionListener actionListener;
  private boolean isDeleteVisible = true;
  @SuppressLint({"UseSparseArrays"})
  public ExpandableRadioListAdapter(Context paramContext, ArrayList<ListObject> paramArrayList, ArrayList<String> paramArrayList1)
  {
    this.childHeader = paramArrayList1;
    this.mContext = paramContext;
    this.listData = paramArrayList;
    isDeleteVisible = false;
  }
public void setSelected(String traitCode){
	for(ListObject lstObj : listData){
		lstObj.isCheckBoxSelected = lstObj.traitCode.equals(traitCode);
	}
    ExpandableRadioListAdapter.this.notifyDataSetChanged();
  }
public boolean isListEmpty(){
	return listData.isEmpty();
}
  
  public ExpandableRadioListAdapter(Context paramContext, ArrayList<ListObject> paramArrayList, ArrayList<String> paramArrayList1, ExpandableListActionListener listener)
  {
    this.childHeader = paramArrayList1;
    this.mContext = paramContext;
    this.listData = paramArrayList;
    this.isDeleteVisible = true;
    actionListener = listener;
  }
  public ArrayList<ListObject> getCheckedData()
  {
    ArrayList<ListObject> localArrayList = new ArrayList<ListObject>();
    for (int i = 0; ; i++)
    {
      if (i >= this.listData.size())
        return localArrayList;
      if (((ListObject)this.listData.get(i)).isCheckBoxSelected)
        localArrayList.add((ListObject)this.listData.get(i));
    }
  }

  public String getChild(int paramInt1, int paramInt2)
  {
    return (String)((ListObject)this.listData.get(paramInt1)).children.get(paramInt2);
  }
  public ListObject getSelectedItem(){
	 return selectedItem;
  }
  public long getChildId(int paramInt1, int paramInt2)
  {
    return 0L;
  }

  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView = ((LayoutInflater)this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.variable_expandable_list_child_layout, paramViewGroup, false);
    ChildViewHolder localChildViewHolder = new ChildViewHolder();
    localChildViewHolder.header = ((TextView)localView.findViewById(R.id.child_title));
    localChildViewHolder.content = ((TextView)localView.findViewById(R.id.child_content));
    localView.setTag(localChildViewHolder);
    localChildViewHolder.header.setText((String)this.childHeader.get(paramInt2) + "  :  ");
    localChildViewHolder.content.setText((CharSequence)((ListObject)this.listData.get(paramInt1)).children.get(paramInt2));
    return localView;
  }

  public int getChildrenCount(int paramInt)
  {
    return ((ListObject)this.listData.get(paramInt)).children.size();
  }

  public String[] getGroup(int paramInt)
  {
    String[] arrayOfString = new String[this.listData.size()];
    for (int i = 0; ; i++)
    {
      if (i >= this.listData.size())
        return arrayOfString;
      arrayOfString[i] = ((ListObject)this.listData.get(i)).title;
    }
  }

  public int getGroupCount()
  {
    return this.listData.size();
  }

  public long getGroupId(int paramInt)
  {
    return paramInt;
  }

  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView = ((LayoutInflater)this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.variable_radio_group, paramViewGroup, false);
    ViewHolderRadio localViewHolder = new ViewHolderRadio();
    localViewHolder.text = ((TextView)localView.findViewById(R.id.group_title));
    localViewHolder.radio = ((RadioButton)localView.findViewById(R.id.radio_group));
    localViewHolder.btnDelete = ((ImageButton) localView.findViewById(R.id.btnDelete));
    localViewHolder.position = paramInt;
    localViewHolder.radio.setTag(Integer.valueOf(paramInt));
    localViewHolder.btnDelete.setTag(Integer.valueOf(paramInt));
    localViewHolder.radio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
    	  
    	for(ListObject lstObj : listData){
    		lstObj.isCheckBoxSelected = false;
    	}
       listData.get(((Integer)paramAnonymousCompoundButton.getTag()).intValue()).isCheckBoxSelected = paramAnonymousBoolean;
       selectedItem = listData.get(((Integer)paramAnonymousCompoundButton.getTag()).intValue());
       ExpandableRadioListAdapter.this.notifyDataSetChanged();
      }
    });
    if(!isDeleteVisible)localViewHolder.btnDelete.setVisibility(View.INVISIBLE);
    else{
    	Log.d("DEBUG","onClick declared");
    	localViewHolder.btnDelete.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Log.d("DEBUG","onClick Delete called");
				actionListener.deleteRow(listData.get(((Integer)arg0.getTag()).intValue()));
				
			}
    		
    	});
    	localViewHolder.btnDelete.setFocusable(false);
    }
    localViewHolder.position = paramInt;
    localView.setTag(localViewHolder);
    this.lstHolders.add(localViewHolder);
    localViewHolder.radio.setChecked(((ListObject)this.listData.get(paramInt)).isCheckBoxSelected);
    localViewHolder.text.setText(((ListObject)this.listData.get(paramInt)).title);
    return localView;
  }

  public ArrayList<ListObject> getListData()
  {
    return this.listData;
  }

  public boolean hasStableIds()
  {
    return true;
  }

  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  
}
