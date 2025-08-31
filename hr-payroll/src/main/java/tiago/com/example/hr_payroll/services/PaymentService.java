package tiago.com.example.hr_payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tiago.com.example.hr_payroll.domain.Payment;
import tiago.com.example.hr_payroll.domain.Worker;
import tiago.com.example.hr_payroll.feignclients.WorkerFeignClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    /*Usado somente de forma estatica*/
   /* @Value("${hr-worker.host}")
    private String workerHost;*/

    @Autowired
    private WorkerFeignClient workerFeignClient;

    /*@Autowired
    private RestTemplate restTemplate;*/

    /*O Feign é um cliente HTTP declarativo.
    em vez de você escrever código "manual" para fazer chamadas HTTP entre microserviços
    (abrindo RestTemplate ou WebClient), você só declara uma interface Java e o Spring gera toda a implementação para você.*/
    public Payment getPayment(long workerId, int days) {

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

   /* public Payment getPayment(long workerId, int days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(workerId));

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }*/

    /*dados mocado, sempre vai retornar Tiago, o que muda é a quantidade de dias e o total
    public Payment getPayment(long workerId, int days) {
       return new Payment("Tiago", 200.0, days);
    }*/


}
