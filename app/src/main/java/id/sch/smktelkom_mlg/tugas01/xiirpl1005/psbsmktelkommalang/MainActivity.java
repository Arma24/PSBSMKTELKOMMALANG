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

    private void doClick() {
        String nama = etNama.getText().toString();
        String umur = etUmur.getText().toString();
        String sekolah = etSekolah.getText().toString();
        String hasil2 = "Hobi Anda             : ";
        int startlen = hasil2.length();
        String hasil4 = null;

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
        } else if (nama.length() <= 5) {
            etNama.setError("Minimal 5 karakter");
        } else {
            etNama.setError(null);
        }

        if (nama.isEmpty()) {
            etUmur.setError("Umur belum diisi");
        } else if (nama.length() != 2) {
            etUmur.setError("Umur Anda salah");
        } else {
            etUmur.setError(null);
        }
        tvHasil1.setText("Nama                      : " + nama +
                "\nAnda berumur       : " + umur + " tahun");
        if (sekolah.isEmpty()) {
            etSekolah.setError("Asal sekolah belum diisi");
        }
        tvHasil2.setText("Asal Sekolah         : " + sekolah);
        tvHasil3.setText("Asal Kota               : " + spKota.getSelectedItem().toString());

        if (rgJRS.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJRS.getCheckedRadioButtonId());
            hasil4 = rb.getText().toString();
        }
        if (hasil4 == null) {
            tvHasil4.setText("Jurusan                 : Tidak memilih jurusan");
        } else {
            tvHasil4.setText("Jurusan                 : " + hasil4);
        }

        if (cbBSK.isChecked()) hasil2 += cbBSK.getText() + " ";
        if (cbFTL.isChecked()) hasil2 += cbFTL.getText() + " ";
        if (cbVOLI.isChecked()) hasil2 += cbVOLI.getText() + " ";

        if (hasil2.length() == startlen) hasil2 += "Tidak memiliki hobi";
        tvHasil5.setText(hasil2);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) nHobi += 1;
        else nHobi -= 1;

        tvHobi.setText("Hobi");
    }
}
