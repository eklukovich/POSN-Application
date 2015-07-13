package com.posn.main.friends;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


public class FriendsArrayAdapter extends ArrayAdapter<ListViewFriendItem>
	{

		private LayoutInflater mInflater;

		private ArrayList<ListViewFriendItem> values;
		ArrayList<ListViewFriendItem> selectedContacts = new ArrayList<ListViewFriendItem>();


		public enum RowType {
			ACCEPTED_FRIEND_ITEM, PENDING_FRIEND_ITEM, REQUEST_FRIEND_ITEM, NO_REQUEST_FRIEND_ITEM, HEADER_ITEM
		}


		public FriendsArrayAdapter(Context context, ArrayList<ListViewFriendItem> values)
			{
				super(context, 0, values);
				mInflater = LayoutInflater.from(context);

				this.values = values;
				System.out.println(values.size());
				System.out.println(this.values.size());

			}


		@Override
		public int getViewTypeCount()
			{
				return RowType.values().length;

			}


		@Override
		public int getItemViewType(int position)
			{
				return getItem(position).getViewType();
			}


		@Override
		public View getView(int position, View convertView, ViewGroup parent)
			{
				return getItem(position).getView(mInflater, convertView);
			}


		@Override
		public boolean isEnabled(int position)
			{
				if (!getItem(position).isClickable())
					{
						return false;
					}
				return true;
			}
	}