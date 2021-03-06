package exemplo02.dcc196.ufjf.packagebr.exercicio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Aluno extends Activity {
    private EditText nome, matricula;
    private Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);
        nome = findViewById(R.id.edt_NomeAluno);
        matricula = findViewById(R.id.edt_Matricula);
        entrar = findViewById(R.id.btn_entrarAluno);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                if (nome.getText().length() > 0 && matricula.getText().length() > 0) {
                    result.putExtra(MainActivity.NOME, nome.getText().toString());
                    result.putExtra(MainActivity.INFO, matricula.getText().toString());
                    setResult(Activity.RESULT_OK, result);
                    finish();
                } else {
                    TextView erro = findViewById(R.id.error_aluno);
                    erro.setText("Os campos não podem ser vazios");
                }
            }
        });
    }
}
