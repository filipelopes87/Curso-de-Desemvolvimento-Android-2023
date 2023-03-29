package devandroid.filipe.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import devandroid.filipe.applistacurso.R;
import devandroid.filipe.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    Pessoa outraPessoa;

    String dadosPessoa;
    String dadosOutraPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Filipe");
        pessoa.setSobreNome("Lopes");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("16 991288574");

        outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("Paulo");
        outraPessoa.setSobreNome("Rocha");
        outraPessoa.setCursoDesejado("Java");
        outraPessoa.setTelefoneContato("16 885285525");

        dadosPessoa = "Primeiro Nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSobreNome();
        dadosPessoa += " Curso Desejado; ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += " Telefone de Contato: ";
        dadosPessoa += pessoa.getTelefoneContato();

        dadosOutraPessoa = "Primeiro Nome: ";
        dadosOutraPessoa += outraPessoa.getPrimeiroNome();
        dadosOutraPessoa += " Sobrenome: ";
        dadosOutraPessoa += outraPessoa.getSobreNome();
        dadosOutraPessoa += " Curso Desejado; ";
        dadosOutraPessoa += outraPessoa.getCursoDesejado();
        dadosOutraPessoa += " Telefone de Contato: ";
        dadosOutraPessoa += outraPessoa.getTelefoneContato();

        // Outra maneira de lançar o que tiver acima
        Log.i("PooAndroid",pessoa.toString());
        Log.i("PooAndroid",outraPessoa.toString());

    }

}