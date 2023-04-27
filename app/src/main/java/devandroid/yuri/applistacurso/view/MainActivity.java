package devandroid.yuri.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import devandroid.yuri.applistacurso.R;
import devandroid.yuri.applistacurso.model.Pessoa;

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
        //Atribuir dados para o objeto
        //Conforme o seu modelo, Template
        pessoa.setPrimeiroNome("Yuri");
        pessoa.setSobrenome("Vital");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("85989428855");

        outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("Yago");
        outraPessoa.setSobrenome("Vital");
        outraPessoa.setCursoDesejado("Java");
        outraPessoa.setTelefoneContato("85989444444");

        dadosPessoa = "Primeiro nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa += " sobrenome: ";
        dadosPessoa += pessoa.getSobrenome();
        dadosPessoa += " Curso desejado: ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += " Telefone de contato: ";
        dadosPessoa += pessoa.getTelefoneContato();

        dadosOutraPessoa = "Primeiro nome: ";
        dadosOutraPessoa += outraPessoa.getPrimeiroNome();
        dadosOutraPessoa += " sobrenome: ";
        dadosOutraPessoa += outraPessoa.getSobrenome();
        dadosOutraPessoa += " Curso desejado: ";
        dadosOutraPessoa += outraPessoa.getCursoDesejado();
        dadosOutraPessoa += " Telefone de contato: ";
        dadosOutraPessoa += outraPessoa.getTelefoneContato();


    }
}