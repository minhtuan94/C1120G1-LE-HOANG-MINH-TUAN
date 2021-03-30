package calculation.service.impl;

import calculation.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public long calculator(long num1, long num2, String calc) {
        long s = 0;
        switch (calc) {
            case "Addition(+)":
                s = num1 + num2;
                break;
            case "Subtraction(-)":
                s = num1 - num2;
                break;
            case "Multiplication(x)":
                s = num1 * num2;
                break;
            default:
                s = num1 / num2;
                break;
        }
        return s;
    }
}
