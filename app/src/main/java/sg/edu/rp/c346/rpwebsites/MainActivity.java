package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView tvCategory;
    TextView tvSubCategory;
    Spinner sCategory;
    Spinner sSubCategory;
    Button btnGo;
    ArrayList<String>alOptions;
    ArrayAdapter<String> aaOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCategory = findViewById(R.id.textViewSubCat);
        tvSubCategory = findViewById(R.id.textViewSubCat);
        sCategory=findViewById(R.id.spinner_Category);
        sSubCategory=findViewById(R.id.spinner_Sub_Category);
        btnGo = findViewById(R.id.buttonGO);

        alOptions = new ArrayList<>();
        aaOptions=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,alOptions);

        sSubCategory.setAdapter(aaOptions);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=sCategory.getSelectedItemPosition();
                int subpos = sSubCategory.getSelectedItemPosition();
                Intent intent=new Intent(MainActivity.this,CustomAdapter.class);
                alOptions.clear();


                if(pos ==0){
                    String[]strOptions = getResources().getStringArray(R.array.RP_SELECT);
                    alOptions.addAll(Arrays.asList(strOptions));
                    aaOptions.notifyDataSetChanged();
                    if(subpos==0){
                        intent.putExtra("url","https://www.rp.edu.sg/");
                        startActivity(intent);

                    }
                    else{
                        intent.putExtra("url","https://www.rp.edu.sg/sutdent-life");
                        startActivity(intent);
                    }

                }
                else{
                    String[]strOptions = getResources().getStringArray(R.array.SOI_SELECT);
                    alOptions.addAll(Arrays.asList(strOptions));
                    aaOptions.notifyDataSetChanged();
                    if(subpos==0){
                        intent.putExtra("url","https://www.rp.edu.sg/soi/full-time-diplomas/details/r47");
                        startActivity(intent);
                    }
                    else{
                        intent.putExtra("url","https://www.rp.edu.sg/soi/full-time-diplomas/details/r12");
                        startActivity(intent);
                    }
                }


//                String[][] sites ={
//                    {
//                            "http://www.rp.edu.sg",
//                            "??",
//
//                    },{
//                    "??",
//                    "??",
//            }
//            };
//            String url = sites[sCategory.getSelectedItemPosition()][sSubCategory.getSelectedItemPosition()];
        }
        });


    }
}
