<h1 align="center">Hi there, I'm<a ></a> Kirill</a> 
<img src="https://github.com/blackcater/blackcater/raw/main/images/Hi.gif" height="32"/></h1>
<h3 align="center"> Student, Java Developer 🇷🇺 </h3>


# 📜 Java Web Application: Address Book

This is a JavaFX application for managing an address book, allowing users to add, delete, search, and display contacts. It uses MySQL for backend storage and adheres to an MVC architecture, separating the user interface, business logic, and data access layers.
## 📦 Installation

1. Clone repositories:
   
   ```bash
   git clone https://github.com/ktokar06/AddressBoock.git
   ```

2. Go to the project directory:
   
   ```bash
   cd AddressBoock
   ```
   
## 📋 Features
1. Add Contacts
  
Users can add contacts with the following details:

  -  Name
    
  -  Last Name
    
  -  Telephone
  
  -  Email
 
  -  Address
  
2. Delete Contacts

  - (Planned) Functionality for removing entries from the database.

3. Search Contacts

  - (Planned) Functionality to query the database for specific contacts.

4. Display All Contacts

  - (Planned) Displays all stored contacts in a tabular view.

5. Navigation Between Screens

  - Modular views for "Add", "Search", "Delete", and "Table" functions, seamlessly navigated using JavaFX's FXMLLoader.
    
## 🔍 Implementation Details
### Database Configuration

- The Configs class stores the database connection settings:

    ```java
    protected String dbHost = "localhost";
    protected String dbPort = "3306";
    protected String dbUser = "root";
    protected String dbPass = "1234";
    protected String dbName = "address";
    ```

- Database Connection

  The DataBase class establishes the connection using JDBC:

    ```java
    public DataBase() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.dbConnection = getConnection(connectionString, dbUser, dbPass);
    }
    ```
    
- User DAO (Data Access Object)
  
  Handles all interactions with the users table:

    ```java
    public boolean saveUser(Users users) {
        String insert = "INSERT INTO users(Name, LastName, Telephone, Mail, Address) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prSt = this.dataBase.getDbConnection().prepareStatement(insert);
            prSt.setString(1, users.getName());
            prSt.setString(2, users.getLastname());
            prSt.setString(3, users.getTelephone());
            prSt.setString(4, users.getMail());
            prSt.setString(5, users.getAddress());
            prSt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    ```

- User Model

    Encapsulates user data:

    ```java
    public class Users {
        private String Name;
        private String Lastname;
        private String Telephone;
        private String Mail;
        private String Address;
        // Getters, setters, and constructor omitted for brevity
    }
    ```

- AddController

  Handles the "Add User" screen logic:

    ```java
    AddUsers.setOnAction(event -> {
        Users user = new Users(
            Name.getText(), 
            LastName.getText(), 
            Phone.getText(), 
            Mail.getText(), 
            Address.getText()
        );
        try {
            UserDao userDao = new UserDao();
            userDao.saveUser(user);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    });
    ```
    
- Navigation Logic

  Implemented in the MainController, it dynamically loads new scenes:

    ```java
    public void openNewScene(String window) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
    ```


## Libraries

1. MySQL Connector
  Dependency:
    ```xml
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>
    ```
  
  Purpose:
  
  Used for connecting to the MySQL database via JDBC. This library facilitates interaction with the database,       including executing SQL queries and managing connections.
  
2. JavaFX
  Dependencies:
    ```xml
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>17.0.6</version>
    </dependency>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-fxml</artifactId>
        <version>17.0.6</version>
    </dependency>
    ```
    
   Purpose:
   
   javafx-controls: Provides basic UI components (buttons, text fields, tables, etc.) for developing user       interfaces.
   
   javafx-fxml: Enables the use of FXML files to define UI structure, simplifying development and separating code from layout design.
   
4. JUnit
  Dependencies:
    ```xml
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>${junit.version}</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>${junit.version}</version>
        <scope>test</scope>
    </dependency>
    ```
    
  Purpose:
  A library for unit testing. It is used to write and execute tests, ensuring the correctness of the   application's components. Version 5.9.2 provides modern annotations and features.
  
4. IntelliJ Annotations
  Dependency:
    ```xml
    <dependency>
        <groupId>org.jetbrains</groupId>
        <artifactId>annotations</artifactId>
        <version>13.0</version>
        <scope>compile</scope>
    </dependency>
    ```
    
  Purpose:
  A set of annotations from JetBrains (e.g., @NotNull, @Nullable) to enhance code readability and quality, as well as to prevent potential null-related errors.
  
## Plugins

1. Maven Compiler Plugin
  Dependency:
    ```xml
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.11.0</version>
        <configuration>
            <source>17</source>
            <target>17</target>
        </configuration>
    </plugin>
    ```
    
  Purpose:
  Ensures the project is compiled using Java version 17.
  
2. JavaFX Maven Plugin
  Dependency:

    ```xml
    <plugin>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-maven-plugin</artifactId>
        <version>0.0.8</version>
        <executions>
            <execution>
                <id>default-cli</id>
                <configuration>
                    <mainClass>com.example.addressboock/com.example.addressboock.HelloApplication</mainClass>
                </configuration>
            </execution>
        </executions>
    </plugin>
    ```
    
  Purpose:
  Enables direct execution of the JavaFX application through Maven (mvn clean javafx:run) and provides configuration for building the application.

## ^^^ 

This application is a foundational example of a CRUD-based address book using JavaFX and MySQL. It demonstrates modular design and clean separation of concerns, making it scalable for additional features.
