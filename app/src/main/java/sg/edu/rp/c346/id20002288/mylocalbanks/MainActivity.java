package sg.edu.rp.c346.id20002288.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView dbs,ocbc,uob;
String wordClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbs=findViewById(R.id.tvdbs);
        ocbc=findViewById(R.id.tvocbc);
        uob=findViewById(R.id.tvuob);

        registerForContextMenu(dbs);
        registerForContextMenu(uob);
        registerForContextMenu(ocbc);
    }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0, R.string.web);
        menu.add(0,1,2, R.string.contact);
        menu.add(0,2,3, R.string.favcolour);

        if(v == dbs){
            wordClick=getString(R.string.dbswordclick);
        }
        else if(v == ocbc){
            wordClick=getString(R.string.ocbcwordclick);
        }
        else if(v == uob){
            wordClick=getString(R.string.uobwordclick);
        }
        }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==0){
            Toast.makeText(MainActivity.this, "Procceding to the website", Toast.LENGTH_LONG).show();
            if (wordClick.equalsIgnoreCase("dbs")) {
                Intent intentcall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbswebsite)));
                startActivity(intentcall);
            }
            else if (wordClick.equalsIgnoreCase("ocbc")) {
                Intent intentcall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcwebsite)));
                startActivity(intentcall);

            }
            else if (wordClick.equalsIgnoreCase("uob")) {
                Intent intentcall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobwebsite)));
                startActivity(intentcall);
            }



            }

        else if(item.getItemId()==1){
            Toast.makeText(MainActivity.this, "Procceding to Contacts", Toast.LENGTH_LONG).show();
            if (wordClick.equalsIgnoreCase("dbs")) {
                Intent intentcall =new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.tel) + getString(R.string.dbsno)));
                startActivity(intentcall);
            }
            else if (wordClick.equalsIgnoreCase("ocbc")) {
                Intent intentcall =new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.tel) + getString(R.string.ocbcno)));
                startActivity(intentcall);

            }
            else if (wordClick.equalsIgnoreCase("uob")) {
                Intent intentcall =new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.tel) + getString(R.string.uobno)));
                startActivity(intentcall);
            }



        }
        else if(item.getItemId()==2){
            if (wordClick.equalsIgnoreCase("dbs")) {
                if(dbs.getCurrentTextColor()== Color.BLACK){
                    dbs.setTextColor(Color.RED);

                }
                else if(dbs.getCurrentTextColor()== Color.RED){
                    dbs.setTextColor(Color.BLACK);
            }}
            else if (wordClick.equalsIgnoreCase("ocbc")) {
                    if(ocbc.getCurrentTextColor()== Color.BLACK){
                        ocbc.setTextColor(Color.RED);

                    }
                    else if(ocbc.getCurrentTextColor()== Color.RED){
                        ocbc.setTextColor(Color.BLACK);
                    }
                }



            else if (wordClick.equalsIgnoreCase("uob")) {
                if(uob.getCurrentTextColor()== Color.BLACK){
                    uob.setTextColor(Color.BLUE);

                }
                else if(uob.getCurrentTextColor()== Color.BLUE){
                    uob.setTextColor(Color.BLACK);
                }
            }
        }
        return super.onContextItemSelected(item);


    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    if(item.getItemId()==R.id.chi){
        dbs.setText(R.string.dbschi);
        ocbc.setText(R.string.ocbcchi);
        uob.setText(R.string.uobchi);

    }
        else if(item.getItemId()==R.id.eng){
            dbs.setText(R.string.dbscaps);
            ocbc.setText(R.string.ocbccaps);
            uob.setText(R.string.uobcpas);

        }
        return super.onOptionsItemSelected(item);
    }
}

