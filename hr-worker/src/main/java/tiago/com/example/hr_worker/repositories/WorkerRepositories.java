package tiago.com.example.hr_worker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tiago.com.example.hr_worker.entities.Worker;

public interface WorkerRepositories extends JpaRepository<Worker, Long> {



}
