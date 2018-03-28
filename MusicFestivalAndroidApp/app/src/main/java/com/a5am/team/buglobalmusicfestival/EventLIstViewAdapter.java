package com.a5am.team.buglobalmusicfestival;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.a5am.team.buglobalmusicfestival.DateBase.Event;

import java.util.List;

/**
 * Created by pro on 2018/3/28.
 *
 * This is the ListView adapter for showing the database.
 *
 * It's purpose is to test our database, check whether every database relate info is right
 *
 */

public class EventLIstViewAdapter extends BaseAdapter {

    private Context context;
    private List<Event> eventList;


    public static class ViewHolder{
        public TextView txtID;
        public TextView txtEvent;
        public TextView txtArtist;
        public TextView txtPlace;
        public TextView txtDate;
    }


    public EventLIstViewAdapter(Context context, List<Event> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Event events = eventList.get(position);
        if (events == null){
            return null;
        }

        ViewHolder holder = null;
        if (view != null){
            holder = (ViewHolder) view.getTag();
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.show_sql_data, null);

            holder = new ViewHolder();
            holder.txtID =  view.findViewById(R.id.txtID);
            holder.txtEvent = view.findViewById(R.id.txtEvent);
            holder.txtArtist = view.findViewById(R.id.txtArtist);
            holder.txtPlace = view.findViewById(R.id.txtPlace);
            holder.txtDate = view.findViewById(R.id.txtDate);

            view.setTag(holder);
        }

        holder.txtID.setText(events.id + "");
        holder.txtEvent.setText(events.event);
        holder.txtArtist.setText(events.artist);
        holder.txtPlace.setText(events.place);
        holder.txtDate.setText(events.date);

        return view;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }





}
