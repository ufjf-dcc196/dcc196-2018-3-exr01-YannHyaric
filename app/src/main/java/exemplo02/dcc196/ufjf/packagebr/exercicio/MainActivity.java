package exemplo02.dcc196.ufjf.packagebr.exercicio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity {
    public static final String NOME = "nome", INFO = "info";
    public static int REQUEST = 1;
    private static int tipo = 0;
    private Button btnAluno, btnServ, btnExt;
    private TextView numAlunos, numServ, numExt;
    private ArrayList<String[]> alunos, servidores, externos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alunos = new ArrayList<>();
        servidores = new ArrayList<>();
        externos = new ArrayList<>();
        btnAluno = findViewById(R.id.btn_Aluno);
        btnServ = findViewById(R.id.btn_Servidor);
        btnExt = findViewById(R.id.btn_Externo);
        numAlunos = findViewById(R.id.numAlunos);
        numServ = findViewById(R.id.numServ);
        numExt = findViewById(R.id.numExt);

        btnAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aluno = new Intent(MainActivity.this, Aluno.class);
                tipo = 1;
                startActivityForResult(aluno, MainActivity.REQUEST);
            }
        });
        btnServ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent servidor = new Intent(MainActivity.this, Servidor.class);
                tipo = 2;
                startActivityForResult(servidor, MainActivity.REQUEST);
            }
        });
        btnExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent externo = new Intent(MainActivity.this, Externo.class);
                tipo = 3;
                startActivityForResult(externo, MainActivity.REQUEST);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String tam;
        String[] temp = new String[2];
        if (requestCode == MainActivity.REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            Bundle resultado = data.getExtras();
            temp[0] = resultado.getString(NOME);
            temp[1] = resultado.getString(INFO);
            switch (tipo) {
                case 1:
                    alunos.add(temp);
                    tam = Integer.toString(alunos.size());
                    numAlunos.setText("Alunos: " + tam);
                    break;
                case 2:
                    servidores.add(temp);
                    tam = Integer.toString(servidores.size());
                    numServ.setText("Servidores: " + tam);
                    break;
                case 3:
                    externos.add(temp);
                    tam = Integer.toString(externos.size());
                    numExt.setText("Externos" + tam);
                    break;
                default:
                    break;
            }
        }
    }
}
