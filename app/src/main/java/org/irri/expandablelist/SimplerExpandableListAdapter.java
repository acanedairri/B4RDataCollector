package org.irri.expandablelist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import org.irri.activity.R;
import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;

import java.util.ArrayList;


public class SimplerExpandableListAdapter extends BaseExpandableListAdapter
{
  private ArrayList<String> childHeader;
  private ArrayList<ListObject> listData;
  private ArrayList<ViewHolder> lstHolders = new ArrayList<ViewHolder>();
  private Context mContext;
  private String studyName;

  @SuppressLint({"UseSparseArrays"})
  public SimplerExpandableListAdapter(Context paramContext, ArrayList<ListObject> paramArrayList, ArrayList<String> paramArrayList1,String studyName)
  {
    this.childHeader = paramArrayList1;
    this.mContext = paramContext;
    this.listData = paramArrayList;
    this.studyName=studyName;
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
  public ArrayList<ListObject> getItems()
  {
    ArrayList<ListObject> localArrayList = new ArrayList<ListObject>();
    for (int i = 0; ; i++)
    {
      if (i >= this.listData.size())
        return localArrayList;
/*      if (((ListObject)this.listData.get(i)).isCheckBoxSelected)*/
        localArrayList.add((ListObject)this.listData.get(i));
    }
  }
  

  public String getChild(int paramInt1, int paramInt2)
  {
    return (String)((ListObject)this.listData.get(paramInt1)).children.get(paramInt2);
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

  public View getGroupView(final int paramInt, boolean paramBoolean, final View paramView, ViewGroup paramViewGroup)
  {
    final View localView = ((LayoutInflater)this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.variable_expandable_list_group_layout, paramViewGroup, false);
    final ViewHolder localViewHolder = new ViewHolder();
    localViewHolder.text = ((TextView)localView.findViewById(R.id.group_title));
    localViewHolder.checkbox = ((CheckBox)localView.findViewById(R.id.group_checkbox));
    localViewHolder.position = paramInt;
    localViewHolder.checkbox.setTag(Integer.valueOf(paramInt));
    localViewHolder.checkbox.setOnCheckedChangeListener(new OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        listData.get(((Integer)paramAnonymousCompoundButton.getTag()).intValue()).isCheckBoxSelected = paramAnonymousBoolean;
        String abbrev= listData.get( localViewHolder.position).title;
        String is_selected=String.valueOf(listData.get( localViewHolder.position).isCheckBoxSelected);

        DatabaseMasterTool dbTool = new DatabaseMasterTool(mContext,studyName);
        dbTool.openStudyDatabase(studyName);
        SQLiteDatabase database = dbTool.getDatabase();
        StudyManager mgr = new StudyManager(database);
        mgr.updateVariableSet(abbrev,is_selected);
        dbTool.closeDB();

      }
    });
    localViewHolder.position = paramInt;
    localView.setTag(localViewHolder);
    this.lstHolders.add(localViewHolder);
    localViewHolder.checkbox.setChecked(((ListObject)this.listData.get(paramInt)).isCheckBoxSelected);
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
