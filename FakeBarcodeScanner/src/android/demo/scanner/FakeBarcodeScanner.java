package android.demo.scanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FakeBarcodeScanner extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button scan = (Button) findViewById(R.id.scan);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText code = (EditText) findViewById(R.id.code);
                Intent result = new Intent();
                result.putExtra("code", code.getText().toString());
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}