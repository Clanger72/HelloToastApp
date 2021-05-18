package tech.gregori.hellotoastapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_COUNT = "tech.gregori.hellotoastapp.extra.count";
    private static final String COUNT = "COUNT";
    private static final String REPLAY_TEXT = "REPLAY_TEXT";

    private int count = 0; // contador
    private TextView showCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCount = findViewById(R.id.show_count); // atribui elemento à variável showCount
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        //Se há conteudo salvo no instanceState
        if(savedInstanceState != null){
            //obetem o valor count
            count = savedInstanceState.getInt(COUNT);
            //mostrar valor count
            showCount.setText(Integer.toString(count));
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(count != 0){ //se contador diferente de zero
            outState.putInt(COUNT, count); //armazena no state
        }
    }

    public void showToast(View view) {
        // criar o Toast com dados específicos
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show(); // mostrar o toast
    }

    public void countUp(View view) {
        // quando clicar no botão
        // incremente o contador
        count++;
        // mostre na tela o valor incrementado
        if (showCount != null) {
            showCount.setText(Integer.toString(count));
        }
    }

    public void countDown(View view) {
        count--;
        if (showCount != null) {
            showCount.setText(Integer.toString(count));
        }
    }

    public void sayHello(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_COUNT, count);
        startActivity(intent);
    }
}