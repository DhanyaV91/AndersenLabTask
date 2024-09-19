# AndersenLabTask
Task for AndersenLab AQA job post

## Project Overview
This is a Maven-based Java project that demonstrates Automation for Registration page of Vikunja site. 

## Prerequisites
Before building and running the project, ensure you have the following installed on your machine:
- **Java Development Kit (JDK)** (version 1.8 or higher)
- **Maven** (version 3.x or higher)
- **Git** (optional, if you are cloning the repository)

### How to Check Installed Versions:
To check your installed versions of Java and Maven, run the following commands:

```bash
java -version
mvn -version
```

## Project Structure
The project follows the standard Maven project structure:

```
my-maven-project/
│
├── src/
│   ├── main/
│   │   ├── java/              # Java source files
├── pom.xml                    # Maven Project Object Model (POM) file
├── README.md                  # Project Documentation (this file)
```

## Setup Instructions

### 1. Clone the Repository
To clone the repository using Git, run the following command in your terminal:

```bash
git clone https://github.com/DhanyaV91/AndersenLabTask.git
cd AndersenLabTask
```

### 2. Build the Project

Open the project on InterlliJ or Eclipse using POM.xml so as to build the Maven dependencies.

Once inside the project directory, you can use Maven to build the project. Run:

Right-click on the Project -> RunAs -> Maven clean

### 4. Running Tests
To run the unit tests, use the following command:

Click on the Project -> Open the directory src/main/java -> AQATest -> Rigt-click on RegisterTest file -> RunAs -> TestNG


## Project Configuration
This project uses the following external dependencies, defined in the `pom.xml` file:

```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.7.0</version>
        <scope>test</scope>
    </dependency>
    <!-- Add other dependencies here -->
</dependencies>
```

## How to Contribute
If you would like to contribute to this project, follow these steps:
1. Fork the repository.
2. Create a new branch: `git checkout -b feature-name`.
3. Make your changes and commit them: `git commit -m "Feature description"`.
4. Push to the branch: `git push origin feature-name`.
5. Submit a pull request.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact
For any questions or feedback, feel free to reach out:
- **Email**: your-email@example.com
- **GitHub**: [yourusername](https://github.com/yourusername)

---

This template provides the basic sections you need for a good project documentation. You can modify it based on your project’s requirements.
