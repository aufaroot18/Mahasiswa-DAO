package com.example.aufa18.praktikumsembilan;

/**
 * Created by aufa18 on 13/01/18.
 */

public class Mahasiswa {
    private String id;
    private String nim;
    private String nama;
    private String jurusan;

    public Mahasiswa(String id, String nim, String nama, String jurusan) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    @Override
    public String toString() {
        return getNama() + getJurusan();
    }
}
