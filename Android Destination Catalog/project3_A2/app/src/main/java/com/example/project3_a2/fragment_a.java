package com.example.project3_a2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class fragment_a extends Fragment {
    private ListView listView;
    private fragmentAlistener listener;

    public interface fragmentAlistener {
        void onListClick(int position);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1, container, false);

        final String[] listItems = {"Lincoln Park Zoo", "Navy Pier", "Museum of Science and Industry", "Art Institute of Chicago", "Wrigley Field", "Sox Park", "Chicago Theater"};
        listView = v.findViewById(R.id.listview);

        ArrayAdapter<String> listviewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(listviewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                listener.onListClick(position);

                /*
                if(position == 0){
                    String url0 = "https://www.lpzoo.org/";
                    Intent i0 = new Intent(Intent.ACTION_VIEW);
                    i0.setData(Uri.parse(url0));
                    startActivity(i0);
                }
                if(position == 1){
                    String url0 = "https://www.lpzoo.org/";
                    Intent i0 = new Intent(Intent.ACTION_VIEW);
                    i0.setData(Uri.parse(url0));
                    startActivity(i0);
                }
                if(position == 2){
                    String url0 = "https://www.lpzoo.org/";
                    Intent i0 = new Intent(Intent.ACTION_VIEW);
                    i0.setData(Uri.parse(url0));
                    startActivity(i0);
                }
                if(position == 3){
                    String url0 = "https://www.lpzoo.org/";
                    Intent i0 = new Intent(Intent.ACTION_VIEW);
                    i0.setData(Uri.parse(url0));
                    startActivity(i0);
                }
                if(position == 4){
                    String url0 = "https://www.lpzoo.org/";
                    Intent i0 = new Intent(Intent.ACTION_VIEW);
                    i0.setData(Uri.parse(url0));
                    startActivity(i0);
                }

                 */
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof fragmentAlistener){
            listener = (fragmentAlistener) context;
        }
        else{
            throw new RuntimeException(context.toString() + "must implement fragmentAlistener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
