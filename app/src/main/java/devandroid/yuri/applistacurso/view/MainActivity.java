package devandroid.yuri.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.yuri.applistacurso.R;
import devandroid.yuri.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    Pessoa outraPessoa;

    String dadosPessoa;
    String dadosOutraPessoa;

    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editNomeCurso;
    EditText editTelefoneContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        //Atribuir dados para o objeto
        //Conforme o seu modelo, Template
        //pessoa.setPrimeiroNome("Yuri");
        //pessoa.setSobrenome("Vital");
        //pessoa.setCursoDesejado("Android");
        //pessoa.setTelefoneContato("85989428855");

        outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("Yago");
        outraPessoa.setSobrenome("Vital");
        outraPessoa.setCursoDesejado("Java");
        outraPessoa.setTelefoneContato("85989444444");

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);


        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editNomeCurso.setText("");
                editTelefoneContato.setText("");
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(
                        editPrimeiroNome.getText().toString().length() != 0 |
                        editSobrenome.getText().toString().length() != 0 |
                        editNomeCurso.getText().toString().length() != 0 |
                        editTelefoneContato.getText().toString().length() != 0
                ) {
                    pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                    pessoa.setSobrenome(editSobrenome.getText().toString());
                    pessoa.setCursoDesejado(editNomeCurso.getText().toString());
                    pessoa.setTelefoneContato(editTelefoneContato.getText().toString());
                    Toast.makeText(MainActivity.this, "Salvo :" + pessoa.toString(), Toast.LENGTH_LONG).show();

                }

                Toast.makeText(MainActivity.this, "Preencha os campos para salvar" , Toast.LENGTH_LONG).show();

            }
        });
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });


        Log.i("POOAndroid", pessoa.toString());
        Log.i("POOAndroid", outraPessoa.toString());
    }

}