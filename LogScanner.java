import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LogScanner {

	public static void main(String[] args) throws Exception {
		var welcomeMessage = """
				Welcome to log scanner!

				Enter the phrase you want to search for and the directory you want to search in.
				
				   Author: Billy Korando
				""";

		System.out.println(welcomeMessage);

		System.out.print("Term to search for: ");
		String searchTerm = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.print("Directory to search in: ");
		String rootDirectory = new BufferedReader(new InputStreamReader(System.in)).readLine();
		String fileType = selectFileType();

		Stream<Path> paths = Files.walk(Paths.get(rootDirectory));
		List<Path> logFiles = paths.filter(p -> p.toFile().isFile() && p.toString().endsWith(fileType)).toList();
		
		paths.close();

		record LogStatement(String fileName, String logMessage) {
		}

		var logStatements = new ArrayList<LogStatement>();
		for (Path p : logFiles) {
			String fileContents = Files.readString(p);
			Stream.of(fileContents.split("\n")).filter(l -> l.contains(searchTerm))
					.forEach(l -> logStatements.add(new LogStatement(p.getFileName().toString(), l)));
		}

		logStatements.stream().forEach(System.out::println);
	}

	private static String selectFileType() throws IOException {
		var fileMessage = """
				Select the type of file you'd like to search:
				1. .log
				2. .txt
				3. .md
				Your selection: """;
		System.out.print(fileMessage);

		var fileTypeSelection = new BufferedReader(new InputStreamReader(System.in)).readLine();
		return switch (fileTypeSelection) {
		case "1" -> ".log";
		case "2" -> ".txt";
		case "3" -> ".md";
		default -> {
			System.out.println("Invalid selection");
			yield selectFileType();
		}
		};
	}
}
