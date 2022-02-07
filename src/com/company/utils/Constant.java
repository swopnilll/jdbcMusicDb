package com.company.utils;

public class Constant {
    /**
     * Database name reference with constant variable.
     */
    public static final String DATABASE_NAME = "music.db";

    /**
     * Constant to hold the file path to Java application
     */
    public static final String javaApplicationFilePath = "Users/swopnilacharya/Documents/projects/java/javaJDBC/musicDb";

    /**
     * Connection string to connect java application with Database driver.
     * This string is fed into DriverManager.getConnection("connectionString");
     */
    public  static final String CONNECTION_STRING = "jdbc:sqlite:/" +javaApplicationFilePath+ "/" +DATABASE_NAME;

    /**
     * Constant for database table albums.
     */
    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    /**
     * Constant for database table artists.
     */
    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTISTS_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    /**
     * Constant for database table songs.
     */
    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONGS_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;

    /**
     * Constant for SORT BY.
     */
    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;


    public static final String QUERY_ALBUMS_BY_ARTIST_START =
            "SELECT " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME + " FROM " + TABLE_ALBUMS +
                    " INNER JOIN " +TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
                    " = " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_ID +
                    " WHERE " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + " = \"";
    public static final String QUERY_ALBUMS_BY_ARTIST_SORT =
            " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";

    /**
     * Define Constructor.
     */
    private Constant() { }  // Prevents instantiation
}
