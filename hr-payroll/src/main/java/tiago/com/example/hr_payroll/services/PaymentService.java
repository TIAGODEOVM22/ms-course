package tiago.com.example.hr_payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tiago.com.example.hr_payroll.domain.Payment;
import tiago.com.example.hr_payroll.domain.Worker;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;


    public Payment getPayment(long workerId, int days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(workerId));

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

    /*dados mocado, sempre vai retornar Tiago, o que muda é a quantidade de dias e o total
    public Payment getPayment(long workerId, int days) {
       return new Payment("Tiago", 200.0, days);
    }*/


}
