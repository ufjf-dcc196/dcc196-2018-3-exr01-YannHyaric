package exemplo02.dcc196.ufjf.packagebr.exercicio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Button btnAluno,btnServ,btnExt;
    private TextView numAlunos,numServ,numExt;
    private static int ALUNOS=0,SERVIDORES=0,EXTERNOS=0;
    private ArrayMap<EditText,EditText> alunos,servidores,externos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAluno=findViewById(R.id.btn_Aluno);
        btnServ=findViewById(R.id.btn_Servidor);
        btnExt=findViewById(R.id.btn_Externo);
        numAlunos=findViewById(R.id.numAlunos);
        numServ=findViewById(R.id.numServ);
        numExt=findViewById(R.id.numExt);

        btnAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aluno=new Intent(MainActivity.this,Aluno.class);
                startActivityForResult(aluno,MainActivity.ALUNOS);
                numAlunos.setText(Integer.toString(ALUNOS));
            }
        });
        btnServ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent servidor=new Intent(MainActivity.this,Servidor.class);
                startActivityForResult(servidor,MainActivity.SERVIDORES);
                numServ.setText(Integer.toString(SERVIDORES));
            }
        });
        btnExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent externo=new Intent(MainActivity.this,Externo.class);
                startActivityForResult(externo,MainActivity.EXTERNOS);
                numExt.setText(Integer.toString(EXTERNOS));
            }
        });

    }
}
