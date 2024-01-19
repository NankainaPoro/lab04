package g313.vakulenko.lab04;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Массивы CheckBox, EditText
    CheckBox[] chk = new CheckBox[4];
    EditText[] num = new EditText[4];
    EditText[] price = new EditText[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация элементов массивов
        chk[0] = findViewById(R.id.chk_apple);
        chk[1] = findViewById(R.id.chk_strawberry);
        chk[2] = findViewById(R.id.chk_blueberry);
        chk[3] = findViewById(R.id.chk_potatoes);

        num[0] = findViewById(R.id.txt_apple);
        num[1] = findViewById(R.id.txt_strawberry);
        num[2] = findViewById(R.id.txt_blueberry);
        num[3] = findViewById(R.id.txt_potatoes);

        price[0] = findViewById(R.id.txt_appleprice);
        price[1] = findViewById(R.id.txt_strawberryprice);
        price[2] = findViewById(R.id.txt_blueberryprice);
        price[3] = findViewById(R.id.txt_potatoesprice);
    }

    // Метод рассчета
    public void onCalc(View v) {
        float sum = 0.0f;
        boolean isSelected = false;

        // Проход по всем продуктам и расчет общей стоимости
        for (int i = 0; i < 4; i++) {
            if (chk[i].isChecked()) {
                isSelected = true;

                // Проверка на ввод пустых значений
                if (num[i].getText().toString().isEmpty() || price[i].getText().toString().isEmpty()) {
                    Toast.makeText(this, "Введите количество и цену для " + chk[i].getText().toString(), Toast.LENGTH_SHORT).show();
                    return;
                }

                int q = Integer.parseInt(num[i].getText().toString());
                float p = Float.parseFloat(price[i].getText().toString());
                float val = q * p;
                sum += val;

                // Вывод информации о продукте
                Toast.makeText(this, chk[i].getText().toString() + ": " + q + " шт. * " + p + " $ = " + val + " $", Toast.LENGTH_SHORT).show();
            }
        }

        // Проверка, был ли выбран хотя бы один продукт
        if (!isSelected) {
            Toast.makeText(this, "Выберите хотя бы один продукт", Toast.LENGTH_SHORT).show();
            return;
        }

        // Вывод общей стоимости покупок
        Toast.makeText(this, "Итого: " + sum + " $", Toast.LENGTH_SHORT).show();
    }
}