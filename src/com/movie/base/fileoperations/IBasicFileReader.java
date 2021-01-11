package com.movie.base.fileoperations;

public interface IBasicFileReader {

    //
    String fileRead(String path);

    //Java 8
    default void fileWrite(){

        System.out.println();
    }
}
