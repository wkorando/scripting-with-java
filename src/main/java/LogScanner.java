import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

public class LogScanner {

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		var welcomeMessage = """
				Welcome to log scanner!

				Enter the phrase you want to search for and the directory you want to search in.
				""";

		System.out.println(welcomeMessage);

		System.out.print("Term to search for: ");
		var searchTerm = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.print("Directory to search in: ");
		var rootDirectory = new BufferedReader(new InputStreamReader(System.in)).readLine();

		var paths = Files.walk(Paths.get(rootDirectory));
		var logFiles = paths.filter(p -> p.toFile().isFile()).filter(p -> p.toString().endsWith(".log")).toList();
		paths.close();

		final record LogStatement(String fileName, String logMessage) {
		}

		var logStatements = new ArrayList<>();
		for (Path p : logFiles) {
			String fileContents = Files.readString(p);
			Stream.of(fileContents.split("\n")).filter(l -> l.contains(searchTerm))
					.forEach(l -> logStatements.add(new LogStatement(p.getFileName().toString(), l)));
		}

		logStatements.stream().forEach(System.out::println);
	}
}
