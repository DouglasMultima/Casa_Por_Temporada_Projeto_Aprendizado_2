package com.example.casaportemporada.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.casaportemporada.R;
import com.example.casaportemporada.model.Filtro;

public class FiltrarAnunciosActivity extends AppCompatActivity {

    private TextView text_quarto;
    private TextView text_banheiro;
    private TextView text_garagem;

    private SeekBar sb_quarto;
    private SeekBar sb_banheiro;
    private SeekBar sb_garagem;

    private int qtd_quarto;
    private int qtd_banheiro;
    private int qtd_garagem;

    private Filtro filtro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtrar_anuncios);

        iniciaComponentes();

        Bundle bundle = getIntent().getExtras();
        if(bundle != null ){
            filtro = (Filtro) bundle.getSerializable("filtro");
            if(filtro != null){
                configFiltros();
            }


        }


        configCliques();
        configSb();

    }

    private void configFiltros(){
        sb_quarto.setProgress(filtro.getQtdQuarto());
        sb_banheiro.setProgress(filtro.getQtdBanheiro());
        sb_garagem.setProgress(filtro.getQtdGaragem());

        text_quarto.setText(filtro.getQtdQuarto() + " quartos ou mais");
        text_banheiro.setText(filtro.getQtdBanheiro() + " banheiros ou mais");
        text_garagem.setText(filtro.getQtdGaragem() + " garagem ou mais");


        qtd_quarto = filtro.getQtdQuarto();
        qtd_banheiro = filtro.getQtdBanheiro();
        qtd_garagem = filtro.getQtdGaragem();

    }

    public void filtrar(View view){

        if(filtro == null) filtro = new Filtro();

        if(qtd_quarto > 0) filtro.setQtdQuarto(qtd_quarto);
        if(qtd_banheiro >0) filtro.setQtdBanheiro(qtd_banheiro);
        if(qtd_garagem >0) filtro.setQtdGaragem(qtd_garagem);

        if(qtd_quarto>0 || qtd_banheiro > 0 || qtd_garagem>0){

            Intent intent = new Intent();
            intent.putExtra("filtro",filtro);
            setResult(RESULT_OK,intent);

        }

        finish();


    }

    private void configSb(){
        sb_quarto.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                text_quarto.setText(progress + " quartos ou mais");
                qtd_quarto = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_banheiro.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                text_banheiro.setText(progress + " banheiros ou mais");
                qtd_banheiro = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_garagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                text_garagem.setText(progress + " garagem ou mais");
                qtd_garagem = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void limparFiltro(View view){

        qtd_quarto = 0;
        qtd_banheiro = 0;
        qtd_garagem = 0;



        finish();

    }

    private void configCliques(){

        findViewById(R.id.ib_voltar).setOnClickListener(view -> finish());

    }
    private void iniciaComponentes(){

        TextView text_titulo = findViewById(R.id.text_titulo);
        text_titulo.setText("Filtrar");


        text_quarto = findViewById(R.id.text_quarto);
        text_banheiro = findViewById(R.id.text_banheiro);
        text_garagem = findViewById(R.id.text_garagem);

        sb_quarto = findViewById(R.id.sb_quarto);
        sb_banheiro = findViewById(R.id.sb_banheiro);
        sb_garagem = findViewById(R.id.sb_garagem);

    }
}