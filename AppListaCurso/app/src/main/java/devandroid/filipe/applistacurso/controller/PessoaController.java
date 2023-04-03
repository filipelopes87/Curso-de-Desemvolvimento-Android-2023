package devandroid.filipe.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.filipe.applistacurso.model.Pessoa;
import devandroid.filipe.applistacurso.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVIp;
    public static final String NOME_PREFERENCES = "pref_listaVip";

    public PessoaController(MainActivity mainActivity) {

        preferences =
                mainActivity.getSharedPreferences(NOME_PREFERENCES,0);
        listaVIp = preferences.edit();
    }




    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller","Controller Iniciado...");
        return super.toString();
    }

    public void salvar(Pessoa pessoa) {
        Log.d("MVC_Controller","Salvo: "+pessoa.toString());

        listaVIp.putString("primeiroNome",pessoa.getPrimeiroNome());
        listaVIp.putString("sobreNome",pessoa.getSobreNome());
        listaVIp.putString("cursoDesejado",pessoa.getCursoDesejado());
        listaVIp.putString("telefoneContato",pessoa.getTelefoneContato());
        listaVIp.apply();
    }

    public Pessoa buscar(Pessoa pessoa){

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome","NA"));
        pessoa.setSobreNome(preferences.getString("sobreNome","NA"));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado","NA"));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato","NA"));
        return pessoa;

    }

    public void limpar(){

        listaVIp.clear();
        listaVIp.apply();

    }
}

