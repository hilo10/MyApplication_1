package jp.co.hilo.myapplication_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<String> showLists = new ArrayList<String>();
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    protected  void onResume(){
        super.onResume();
        viewScreen();
    }

    public void viewScreen() {
        int cntItems = FuncPreference.loadCntItems( getApplicationContext() );
        if( cntItems == 0 ){
            return;
        }

        for( int i = 1; i <= cntItems; i++ ){
            showLists.add( FuncPreference.loadTitle( getApplicationContext(), i ) );
        }

        ListView lv = (ListView)findViewById(R.id.list_view);
        ArrayAdapter<String> adpt = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, showLists);
        lv.setAdapter(adpt);

        Button addBtn = (Button)findViewById(R.id.button_newReg);
        addBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent intent = new Intent( MainActivity.this, RegisterActivity.class );
                try{
                    startActivity( intent );
                } catch( Exception e ){
                    e.printStackTrace();
                }
                showLists.clear();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
