package jp.suntech.c21009.myconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonListener listener = new ButtonListener();

        Button btConfirm = findViewById(R.id.btConfirm);
        btConfirm.setOnClickListener(listener);

        Button btSend = findViewById(R.id.btSend);
        btSend.setOnClickListener(listener);

        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText name = findViewById(R.id.etName);
            EditText mtitle = findViewById(R.id.etMTitle);
            EditText mail = findViewById(R.id.etMail);
            EditText comment = findViewById(R.id.etComment);

            String Name = name.getText().toString();
            String MTitle = mtitle.getText().toString();
            String Mail = mail.getText().toString();
            String Comment = comment.getText().toString();

            String show = "送信内容\n\n名前:" + Name + "\nメールタイトル:" + MTitle
                    + "\nメールアドレス:" + Mail + "\n質問内容:" + Comment;

            int id = view.getId();

            switch (id) {
                case R.id.btConfirm:
                    OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
                    Bundle args = new Bundle();
                    args.putString("message",show);
                    dialogFragment.setArguments(args);
                    dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
                    break;

                case R.id.btSend:
                    Toast.makeText(MainActivity.this, show, Toast.LENGTH_LONG).show();
                    break;

                case R.id.btClear:
                    name.setText("");
                    mtitle.setText("");
                    mail.setText("");
                    comment.setText("");
                    break;
            }
        }
    }
}