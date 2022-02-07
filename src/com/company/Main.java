package com.company;

import com.company.model.Artist;
import com.company.model.DataSource;
import com.company.utils.Constant;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();

        if(!dataSource.open()){
            System.out.println("Cant open datasource");
            return;
        }

        List<Artist> artists = dataSource.fetchAllArtist(Constant.ORDER_BY_ASC);

        if(artists == null){
            System.out.println("No artist !");
            return;
        }

        for(Artist artist: artists){
            System.out.println("ID = " +artist.getId()+ ", Name = " +artist.getName());
        }

        List<String> albumsListForArtist = dataSource.queryAlbumsForArtist("Iron Maiden", Constant.ORDER_BY_DESC);

        for(String album: albumsListForArtist){
            System.out.println(album);
        }

        dataSource.close();
    }
}
