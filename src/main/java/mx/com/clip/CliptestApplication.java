package mx.com.clip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mx.com.clip.exception.DataException;
import mx.com.clip.service.TransactionService;

/**
 * The Class CliptestApplication.
 *
 * @author Oliver Mar Ramirez
 */
@SpringBootApplication
public class CliptestApplication implements ApplicationRunner {

	/** The Transaction Service service. */
	@Autowired
	private TransactionService tService;

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(CliptestApplication.class, args);
	}

	/**
	 * Run.
	 *
	 * @param args
	 *            the args
	 * @throws Exception
	 *             the exception
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("No options arguments : {}" + args.getNonOptionArgs());
		final List<String> cleanArguments = cleanArguments(args.getNonOptionArgs());
		cleanArguments.forEach(System.out::println);
		this.proccessTransaction(cleanArguments);
	}

	/**
	 * Proccess transaction.
	 *
	 * @param cleanArguments
	 *            the clean arguments
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 * @throws DataException
	 *             the data exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void proccessTransaction(List<String> cleanArguments) throws IllegalArgumentException, DataException, IOException {
		try {
			if (cleanArguments.size() < 2 || cleanArguments.size() > 3) {
				throw new IllegalArgumentException("not a valid argument list  <user id> <operation> <json format transaction>/<transaction id>");
			}
			switch (cleanArguments.get(1)) {
			case "add":
				this.tService.add(cleanArguments);
				break;
			case "sum":
				this.tService.sum(cleanArguments);
				break;
			case "list":
				this.tService.list(cleanArguments);
				break;
			default:
				this.tService.show(cleanArguments);
			}
		} catch (final DataException | IOException e) {
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * Clean arguments.
	 *
	 * @param list
	 *            the list
	 * @return the list
	 */
	private static List<String> cleanArguments(List<String> list) {
		final List<String> cleaned = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains("{")) {
				String json = list.get(i);
				json = json.toLowerCase().replaceAll("\\{", "\\{\"").replaceAll(":", "\":\"").replaceAll(",", "\",\"").replaceAll("\\}", "\"\\}");
				cleaned.add(json);
				break;
			} else {
				cleaned.add(list.get(i).toLowerCase());
			}
		}
		return cleaned;
	}

}
