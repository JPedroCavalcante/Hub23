package com.guina.tasklist.TELAS;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.badge.BadgeUtils;
import com.guina.tasklist.R;

import java.util.Random;

public class FrasesActivity extends AppCompatActivity {
    private Button btnFrase;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frases);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        btnFrase = (Button) findViewById(R.id.btnNovaFrase);

        btnFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] frases = {
                        "Que o dia comece bem e termine ainda melhor.",
                        "Pra hoje: sorrisos bobos, uma mente tranquila e um coração cheio de paz.",
                        "Às vezes as coisas demoram, mas acontecem. O importante é saber esperar e não perder a fé!",
                        "Imagine uma nova história para a sua vida e acredite nela.",
                        "Nem todos os dias são bons, mas há algo bom em cada dia.",
                        "Sorria! Deus acaba de te dar um novo dia e coisas extraordinárias podem acontecer se você acreditar.",
                        "Levanta, sacode a poeira e dá a volta por cima.",
                        "Um pequeno pensamento positivo pela manhã pode mudar todo o seu dia.",
                        "Que os dias ruins se tornem raros e os bons virem rotina.",
                        "Todo dia é uma ocasião especial. Guarde apenas o que tem que ser guardado: lembranças, sorrisos, poemas, cheiros, saudades, momentos…",
                        "Cultive o amor, tristeza não dá flor.",
                        "Não se preocupe em entender, viver ultrapassa qualquer entendimento.",
                        "Seja a mudança que você deseja ver no mundo.",
                        "Só existem dois dias no ano em que nada pode ser feito. Um se chama ontem e o outro se chama amanhã, portanto hoje é o dia certo para amar, acreditar, fazer e principalmente viver.",
                        "A mudança que você quer está na decisão que você toma.",
                        "Viva sua vida com quem te deixa feliz e não com quem você tenha que agradar.",
                        "Na plenitude da felicidade, cada dia é uma vida inteira.",
                        "Sonhar, viver e todo dia agradecer.",
                        "Que o dia seja leve, que a tristeza seja breve e que o dia seja feliz.",
                        "A maior conquista da vida é estar em paz."

                };

                int numero = new Random().nextInt(20);

                TextView frase = findViewById(R.id.txtFrase);
                frase.setText(frases[numero]);
            }
        });

    }

}
