package Team.KTX.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KtxReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(KtxReservationApplication.class, args);
	}

}
