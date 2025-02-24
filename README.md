## **BeachBodyE2EFramework by using Page Factory Design Pattern - Test Automation Framework**  

### **Overview**  
This project is a **Test Automation Framework** designed for testing the **Beachbody Ecommerce** application. The framework follows the **Page Factory (PF)** design pattern and integrates with 
various tools to ensure efficient and scalable test execution.

## **Project Architecture**  
The framework consists of multiple components that handle different aspects of test automation:  

### **1. BaseClass**  
- Manages **WebDriver initialization**.  
- Handles **properties file reading**.  
- Implements **BeforeSuite and AfterSuite** configurations.  

### **2. PageObjects**  
Contains the **Page Object Model (POM)** for different application pages:  
- **IndexPage.java**  
- **LoginPage.java**  
- **HomePage.java**  
- **ProductPage.java**  
- **AddToCartPage.java**  
- **OrderPage.java**  

### **3. ActionDriver**  
Includes reusable **utility methods** for:  
- Scrolling  
- Clicking  
- Sending Keys  
- Selecting dropdowns  
- Handling explicit waits  and more.

### **4. Utility Component**  
Handles additional utilities like:  
- **Screenshots**  
- **Extent Reports** for test reporting  
- **Logging**  
- **Listeners** for event handling  
- **DataProviders** for data-driven testing
- **Allure Reports** 

### **5. Configuration Files**  
Stores necessary configurations:  
- `POM.xml` - Maven dependencies  
- `extent-config.xml` - Reporting configuration  
- `log4j.xml` - Logging setup  
- `config.properties` - Application settings  
- `testng.xml` - Test execution setup  

### **6. Test Cases**  
Located in **com.mystore.testcases**, containing:  
- `LoginPageTest.java`  
- `HomePageTest.java`  
- `AddToCartPageTest.java`  
- `OrderTest.java`  
- `PaymentTest.java`  

### **7. Folders Structure**  
- **TestData/** - Stores test input data  
- **ScreenShot/** - Captures screenshots on failures  
- **Configuration/** - Contains all config files  
- **Drivers/** - WebDriver executables  
- **Logs/** - Stores log files  
- **ExtentReports/** - Stores HTML reports  

---

## **Tools & Technologies Used**  
| **Tool/Technology** | **Purpose** |  
|---------------------|------------|  
| **Java** | Programming language |  
| **Selenium WebDriver** | Browser automation |  
| **TestNG** | Test execution and assertions |  
| **Maven** | Dependency management |  
| **Extent Reports** | Test reporting |  
| **Log4j** | Logging |  
| **Git & GitHub** | Version control |  
| **Jenkins** | CI/CD |  

---

## **Execution Phases**  
1. **Development Phase**  
   - Implement Page Object Model (POM).  
   - Write reusable utilities.  
   - Set up test configurations.  
2. **Execution Phase**  
   - Run test cases using `testng.xml`.  
   - Generate logs and reports.  
3. **Continuous Integration (CI)**  
   - Push code to GitHub.  
   - Integrate with Jenkins for CI/CD.  

---

## **How to Run the Tests**  

### **1. Clone the Repository**  
```sh
git clone MyRepositoryname
cd MyProject
```

### **2. Install Dependencies**  
Ensure **Maven** is installed and run:  
mvn clean install


### **3. Run Tests with TestNG**  
mvn test


### **4. View Test Reports**  
- **Extent Reports**: Navigate to `ExtentReports/` directory.  
- **Screenshots**: Check `ScreenShot/` for failure screenshots.
- **Allure Reports**: Navigate to terminal and run the command  **allure serve allure-results**.
.  

## **Continuous Integration (CI/CD) Setup**  
- The framework supports integration with **Jenkins/GitHub Actions**.  
- Test execution can be automated using scheduled jobs.  

### **Contributors**  
- **Rohit Kumar** - QA Technical Lead  

Let me know if you want any modifications or enhancements!
