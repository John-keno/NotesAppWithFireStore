package hacine.mohamed.abdelhakim.cloudfirestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView tx , dx , px  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();
       String t =  extras.getString("t");
        String d =  extras.getString("d");
        int p = extras.getInt("p");
        px= findViewById(R.id.idp);
        tx= findViewById(R.id.idt);
        dx= findViewById(R.id.idd);


        tx.setText(t);
        dx.setText(d);
        px.setText(String.valueOf(p));
    }
}