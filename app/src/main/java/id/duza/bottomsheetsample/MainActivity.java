package id.duza.bottomsheetsample;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kennyc.bottomsheet.BottomSheet;
import com.kennyc.bottomsheet.BottomSheetListener;

public class MainActivity extends AppCompatActivity {

    private Button btnBottomSheet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();
        setupViewListener();
    }

    private void setupViewListener() {
        btnBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheet();
            }
        });
    }

    private void showBottomSheet() {
        new BottomSheet.Builder(this)
                .setSheet(R.menu.bottom_menu)
                .setTitle("Option")
                .setListener(new BottomSheetListener() {
                    @Override
                    public void onSheetShown(@NonNull BottomSheet bottomSheet) {

                    }

                    @Override
                    public void onSheetItemSelected(@NonNull BottomSheet bottomSheet, MenuItem menuItem) {
                        switch (menuItem.getItemId())   {
                            case R.id.menu_delete:
                                Toast.makeText(MainActivity.this, "Delete clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_edit:
                                Toast.makeText(MainActivity.this, "Edit clicked", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }

                    @Override
                    public void onSheetDismissed(@NonNull BottomSheet bottomSheet, @DismissEvent int i) {

                    }
                }).show();
    }

    private void setupView() {
        btnBottomSheet = (Button) findViewById(R.id.btn_show_bottom_sheet);
    }
}
