**Controller** - пакет, в котором лежат все классы, связанные с внешним миром; те, которые ты вызываешь для запуска системы.

**Service** - все классы в которых происходит что-то, расчет, изменение и тому подобное.

**Repository** - классы для работы с базой данных.

---

The service layer can be interpreted a lot of ways, but it's usually where you have your core business processing logic, and sits below your MVC architecture, but above your data access architecture.

For example, you layer of a complete system may look like this:

1. View Layer: Your MVC framework & code of choice
2. Service Layer: Your Controller will call this layer's objects to get or update Models, or other requests.
3. Data Access Objects: These are abstractions that your service layer will call to get/update the data it needs. This layer will generally either call a Database or some other system (eg: LDAP server, web service, or NoSql-type DB)

The service layer would then be responsible for:
1. Retrieving and creating your 'Model' from various data sources (or data access objects).
2. Updating values across various repositories/resources.
3. Performing application-specific logic and manipulations, etc.

The Model you use in your MVC may or may not come from your services. You may want to take the results your service gives you and manipulate them into a model that's more specific to your medium (eg: a web page).

---

## **Model–view–controller (MVC)**
MVC is a software architectural pattern commonly used for developing user interfaces that divide the related program logic into three interconnected elements. This is done to separate internal representations of information from the ways information is presented to and accepted from the user.

Traditionally used for desktop graphical user interfaces (GUIs), this pattern became popular for designing web applications. Popular programming languages have MVC frameworks that facilitate the implementation of the pattern.

### **Model**

The central component of the pattern. It is the application's dynamic data structure, independent of the user interface. It directly manages the data, logic and rules of the application.

### **View**
Any representation of information such as a chart, diagram or table. Multiple views of the same information are possible, such as a bar chart for management and a tabular view for accountants.

### **Controller**
Accepts input and converts it to commands for the model or view.
In addition to dividing the application into these components, the model–view–controller design defines the interactions between them.

The **model** is responsible for managing the data of the application.
It receives user input from the **controller**.
The **view** renders presentation of the model in a particular format.
The **controller** responds to the user input and performs interactions on the data model objects. 