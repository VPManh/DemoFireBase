package com.example.a_demofirebase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Vegetable_Adapter extends BaseAdapter {
    private List<Vegetable> vegetableList;

    public Vegetable_Adapter(List<Vegetable> vegetableList) {
        this.vegetableList = vegetableList;
    }
        // hiển thị có bao nhiêu phần tử có trong list
    @Override
    public int getCount() {
        return vegetableList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

//    private class ViewHolder{
//        TextView tx_name,tx_mota;
//        ImageView img_anh;
//    }


    //trả về mỗi dòng cuar mỗi item của list
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        ViewHolder viewHolder;

//        if (convertView == null){
//            // LayoutInflater để chuyển đổi layout xml thanfh một đối tượng View
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(layout,null);
//
//            viewHolder = new ViewHolder();
//            //ánh xạ
//            viewHolder.tx_name = (TextView) convertView.findViewById(R.id.tx_name);
//            viewHolder.tx_mota = (TextView) convertView.findViewById(R.id.tx_title);
//            viewHolder.img_anh = (ImageView) convertView.findViewById(R.id.imgHinh);
//            convertView.setTag(viewHolder);
//        }
//        else {
//            viewHolder = (ViewHolder) convertView.getTag();
//        }


//        //gán giá trị
//        Vegetable vegetable = vegetableList.get(position);
//        viewHolder.tx_name.setText(vegetable.getName());
//        viewHolder.tx_mota.setText(vegetable.getTitle());
//        viewHolder.img_anh.setImageResource(vegetable.getHinhanh());


        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        }

        TextView tx_name = convertView.findViewById(R.id.tx_name);
        TextView tx_mota = convertView.findViewById(R.id.tx_title);
        ImageView img_anh = convertView.findViewById(R.id.imgHinh);


        //gắn giá trị
        Vegetable vegetable = vegetableList.get(position);
        if (!vegetableList.isEmpty()){
            tx_name.setText(vegetable.getName());
            tx_mota.setText(vegetable.getTitle());
            img_anh.setImageResource(vegetable.getHinhanh());
        }


        return convertView;
    }
}
