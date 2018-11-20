package com.unq.epers.bichomon_go_realtime_app.model;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Combate {
    private String retador;
    private String oponente;
    private Long fecha;

    public Combate() {
        //Constructor vacio para Firebase
    }

    public Combate(String retador, String oponente, Long fecha) {
        this.retador = retador;
        this.oponente = oponente;
        this.fecha = fecha;
    }

    public String getRetador() {
        return retador;
    }

    public void setRetador(String retador) {
        this.retador = retador;
    }

    public String getOponente() {
        return oponente;
    }

    public void setOponente(String oponente) {
        this.oponente = oponente;
    }

    public Long getFecha() {
        return fecha;
    }

    public void setFecha(Long fecha) {
        this.fecha = fecha;
    }
}
