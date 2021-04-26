# code-example-repo

This repo demonstrates how to use... [INSERT MORE INFORMATION HERE]

## Try it yourself!

For modifying this application the latest version of your preferred IDE is recommend. IntelliJ is often the first the support latest Java features. IDE support is not required however, just the syntax highlighting can be distracting or misleading as newer Java features might not be recognized, or not interpreted correctly. 

The application can be modified and executed with updated code using either natively or with docker following the instructions below. 

### Running natively

To execute this application natively complete the following steps.

1. Download the Java [CURRENT VERSION] JDK: https://jdk.java.net/[CURRENT VERSION]

2. Installed and configure Java [CURRENT VERSION] as your default runtime.

	**Note:** It is recommended to use a utility that allows for the easy switching of JDK versions, such as [SDKMan](https://sdkman.io/) or [jenv](https://www.jenv.be/)).


3. From the root of this project run the following:

	```
	mvn clean package
	```

	**Note:** If you don't have Apache Maven installed on your system, update the above command with `./mvnw` on *nix systems or `mvnw` or Windows to use the included Maven wrapper

4. To execute the application run the following command:
	
	```
	java -jar target/*.jar
	```

### Running with Docker

To execute this application using Docker complete the following steps.

1. From the root of the project execute:

	```
	docker build . -t [docker tag]
	```

2. To execute the docker image run:
	
	```
	docker run -t [docker tag]
	```

## Questions & Issues

If you have questions about this demo or are running into an issue:

Twitter: [@BillyKorando](https://twitter.com/BillyKorando) 

Email: wkorando [at] gmail

## License & Attribution

Copyright (c) 2021 Billy Korando 

Source Code licensed under [MIT License](LICENSE)

Documentation, Slides, and any other creative works licensed under [Creative Commons Attribution-NonCommercial 4.0 International License](LICENSE.md)