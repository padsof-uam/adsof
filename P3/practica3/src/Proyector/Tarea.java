package Proyector;

import java.util.ArrayList;
import java.util.List;


public class Tarea{
    double peso_optimista,peso_pesimista,peso_probable;
    int t_optimista,t_pesimista,t_probable;
    String nombre = new String();
    ArrayList <Tarea> consecuentes = new ArrayList<Tarea>();
    ArrayList <Tarea> antecedentes = new ArrayList<Tarea>();
    Tarea(int t_op, int t_pes, int t_prob,List<Tarea> consec,List<Tarea> antec ,String nombre,double peso_op, double peso_pes, double peso_prob){
        peso_optimista = peso_op;
        peso_pesimista = peso_pes;
        peso_probable = peso_prob;
        t_optimista = t_op;
        t_pesimista = t_pes;
        t_probable = t_prob;
        this.nombre = nombre;
        consecuentes.addAll(consec);
        antecedentes.addAll(antec);
    }

    double duracionEstimada = -1;
    public double getDuracionEstimada(){
        if (duracionEstimada == -1)
            duracionEstimada = (peso_optimista * t_optimista + peso_probable * t_probable + peso_pesimista * t_pesimista)/(peso_pesimista + peso_optimista+peso_probable);
        return duracionEstimada;
    }

    /**/

    double comienzoOptimista = -1;
    double finOptimista = -1;

    public double getComienzoOptimista()
    {
        if(comienzoOptimista == -1)
            calculaComienzoOptimista();

        return comienzoOptimista;
    }

    private void calculaComienzoOptimista()
    {
        double max = -1;
        for(Tarea t : antecedentes)
            if(t.getFinOptimista() > max)
                max = t.getFinOptimista();

        comienzoOptimista = max;
    }

    public double getFinOptimista()
    {
        if(finOptimista == -1)
            finOptimista = getComienzoOptimista() + t_optimista;
        return finOptimista;
    }
    /**/
    double comienzoPesimista = -1;
    double finPesimista = -1;

    public double getComienzoPesimista()
    {
        if(comienzoPesimista == -1)
            calculaComienzoPesimista();

        return comienzoPesimista;
    }

    private void calculaComienzoPesimista()
    {
        double max = -1;
        for(Tarea t : antecedentes)
            if(t.getFinPesimista() > max)
                max = t.getFinPesimista();

        comienzoPesimista = max;
    }

    public double getFinPesimista()
    {
        if(finPesimista == -1)
            finPesimista = getComienzoPesimista() + t_pesimista;
        return finPesimista;
    }

    public double getPeso_optimista() {
        return peso_optimista;
    }

    public double getPeso_pesimista() {
        return peso_pesimista;
    }

    public double getPeso_probable() {
        return peso_probable;
    }

    public void anadirTareaConsecuente(Tarea consecuente){
        consecuentes.add(consecuente);
    }

    public void anadirTareaAntecedente(Tarea antecedente){
        antecedentes.add(antecedente);
    }

    public ArrayList<Tarea> getAntecedentes(){
        return antecedentes;
    }
    public ArrayList<Tarea> getConsecuentes(){
        return consecuentes;
    }

    public int getT_optimista() {
        return t_optimista;
    }

    public int getT_pesimista() {
        return t_pesimista;
    }

    public int getT_probable() {
        return t_probable;
    }

    public String getNombre() {
        return nombre;
    }

}