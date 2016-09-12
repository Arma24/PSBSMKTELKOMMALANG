package id.sch.smktelkom_mlg.tugas01.xiirpl1005.psbsmktelkommalang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    EditText etNama, etUmur, etSekolah;
    Spinner spKota;
    RadioGroup rgJRS;
    CheckBox cbBSK,cbFTL, cbVOLI;
    Button bOK;
    TextView tvHasil1, tvHasil2, tvHasil3, tvHasil4, tvHasil5, tvHobi;
    int nHobi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama      =(EditText) findViewById(R.id.editTextNama);
        etUmur      =(EditText) findViewById(R.id.editTextUmur);
        etSekolah   =(EditText) findViewById(R.id.editTextSekolah);
        spKota      =(Spinner) findViewById(R.id.spinnerKota);
        rgJRS       =(RadioGroup) findViewById(R.id.radioGroupJRS);
        cbBSK       =(CheckBox) findViewById(R.id.checkBoxBSK);
        cbFTL       =(CheckBox) findViewById(R.id.checkBoxFTL);
        cbVOLI      =(CheckBox) findViewById(R.id.checkBoxVOLI);
        bOK         =(Button) findViewById(R.id.buttonOK);

        cbBSK.setOnCheckedChangeListener(this);
        cbFTL.setOnCheckedChangeListener(this);
        cbVOLI.setOnCheckedChangeListener(this);

        tvHasil1 = (TextView) findViewById(R.id.textViewHasil1);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        tvHasil4 = (TextView) findViewById(R.id.textViewHasil4);
        tvHasil5 = (TextView) findViewById(R.id.textViewHasil5);
        tvHobi = (TextView) findViewById(R.id.textViewHobi);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });



    }
}
