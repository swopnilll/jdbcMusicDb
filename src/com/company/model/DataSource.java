package com.company.model;

import com.company.utils.Constant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {

 private Connection connectionObject;

 public boolean open(){
     try {
         connectionObject = DriverManager.getConnection(Constant.CONNECTION_STRING);
         return true;
     }catch (SQLException e){
         System.out.println("Cannot connect to database: " + e.getMessage());
         return false;
     }
 };

 public void close() {
     try {
        if(connectionObject != null){
            connectionObject.close();
        }
     }catch (SQLException e){
         System.out.println("Could not close connection" +e.getMessage());
     }
 }

 public List<Artist> fetchAllArtist(int sortOder){

     StringBuilder sb = new StringBuilder("SELECT * FROM ");

     sb.append(Constant.TABLE_ARTISTS);

     if(sortOder != Constant.ORDER_BY_NONE){
         sb.append(" ORDER BY ");
         sb.append(Constant.COLUMN_ARTIST_NAME);
         sb.append(" COLLATE NOCASE ");
         if(sortOder == Constant.ORDER_BY_DESC){
             sb.append("DESC");
         }else{
             sb.append("ASC");
         }
     }

     try(Statement statement = connectionObject.createStatement();
         ResultSet resultSet = statement.executeQuery(sb.toString())){

         List<Artist> artists = new ArrayList<>();

         while (resultSet.next()){
             Artist artist = new Artist();

             artist.setId(resultSet.getInt(Constant.INDEX_ARTIST_ID));
             artist.setName(resultSet.getString(Constant.INDEX_ARTIST_NAME));

             artists.add(artist);
         }

         return  artists;

     }catch (SQLException e){
         System.out.println("Issue with Fetching results" + e.getMessage());
         return null;
     }
 }

}
