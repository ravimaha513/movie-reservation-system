package com.movie.base.initialization;

public class ScreenRow {

    Character row;
    String rowNum;

    public ScreenRow(Character row, String rowNum) {
        this.row = row;
        this.rowNum = rowNum;
    }

    public Character getRow() {
        return row;
    }

    public void setRow(Character row) {
        this.row = row;
    }

    public String getRowNum() {
        return rowNum;
    }

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    @Override
    public String toString() {
        return "{" +
                "row=" + row +
                ", rowNum='" + rowNum + '\'' +
                '}';
    }
}
