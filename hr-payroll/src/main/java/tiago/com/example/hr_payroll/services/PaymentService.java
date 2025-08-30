package tiago.com.example.hr_payroll.services;

import org.springframework.stereotype.Service;
import tiago.com.example.hr_payroll.domain.Payment;

@Service
public class PaymentService {

    /*dados mocado, sempre vai retornar Tiago, o que muda é a quantidade de dias e o total*/
    public Payment getPayment(long workerId, int days) {
       return new Payment("Tiago", 200.0, days);
    }

}
