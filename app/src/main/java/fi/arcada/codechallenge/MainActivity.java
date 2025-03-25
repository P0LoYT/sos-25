package fi.arcada.codechallenge;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView helloTextView;
    private TextView resultTextView;
    private ArrayList<Double> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helloTextView = findViewById(R.id.Hello);
        helloTextView.setText("Min app funkar v2.0");

        resultTextView = findViewById(R.id.resultTextView);
        numbers = new ArrayList<>();
        numbers.add(1.0);
        numbers.add(2.0);
        numbers.add(3.0);
        numbers.add(4.0);
        numbers.add(5.0);

        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(v -> calculate());
    }
    public class Statistics {
        public double calcSum(ArrayList<Double> numbers) {
            double sum = 0;
            for (int i = 0; i < numbers.size(); i++) {
                sum += numbers.get(i);
            }
            return sum;
        }
        public double calcMean(ArrayList<Double> numbers) {
            double sum = calcSum(numbers);
            return sum / numbers.size();
        }
    }
    public void calculate() {
        Statistics stats = new Statistics();
        double sum = stats.calcSum(numbers);
        double mean = stats.calcMean(numbers);
        resultTextView.setText("Sum: " + sum + "\nMean: " + mean);
    }
}