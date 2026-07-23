# 🛒 Mini Shopping Cart — Jakarta EE

> **Exam Project (DS)** — A Jakarta EE web application implementing a product catalog and session-based shopping cart, developed during a supervised exam on December 16, 2025.

---

## ✨ Features

- ➕ **Add a product** — form with name and price
- 📋 **List products** — view and delete products
- 🛒 **Shopping cart** — add products, view cart with subtotals and total
- ❌ **Remove from cart** — remove individual items
- 💾 **Session-based cart** — cart persists across pages during the session

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| [Java 25](https://openjdk.org/) | Primary language |
| [Jakarta Servlet 6.1](https://jakarta.ee/) | HTTP request handling |
| [JSP](https://jakarta.ee/) | Server-side HTML rendering |
| [Maven](https://maven.apache.org/) | Build tool |
| WAR packaging | Deployment on Tomcat |

---

## 🏗️ Architecture

MVC pattern with DAO layer:

```
src/main/java/mcu/ds16decembre2025aissyaboukraa/
├── model/
│   ├── Product.java        # id, name, price
│   └── CartItem.java       # product, quantity, subtotal
├── dao/
│   ├── ProductDAO.java     # in-memory product list (static)
│   └── CartDAO.java        # session cart management
└── servlet/
    ├── ProductServlet.java         # GET /products, POST /products, delete
    ├── CartServlet.java            # GET /cart (add & view)
    └── RemoveFromCartServlet.java  # GET /remove-from-cart
```

### Pages JSP

```
src/main/webapp/
├── index.jsp           # Home / navigation
├── add-product.jsp     # Add product form
├── list-products.jsp   # Product list with add-to-cart & delete
└── cart.jsp            # Cart with items, subtotals and total
```

---

## 🚀 Getting Started

### Prerequisites

- JDK 17+
- Apache Tomcat 10+
- Maven

### Run

```bash
# 1. Clone the repository
git clone https://github.com/aissouss/jee-shopping-cart-exam.git
cd jee-shopping-cart-exam

# 2. Build the WAR
./mvnw package

# 3. Deploy to Tomcat
# Copy target/*.war to Tomcat's webapps/ folder
# Then start Tomcat and open:
# http://localhost:8080/DS16decembre2025AissyaBOUKRAA-1.0-SNAPSHOT/
```

### With IntelliJ IDEA

1. Open the project
2. Configure a **Tomcat local server**
3. Add the WAR artifact
4. Click ▶ Run

---

## 📄 Endpoints

| Method | URL | Description |
|---|---|---|
| GET | `/products` | List all products |
| POST | `/products` | Add a new product |
| GET | `/products?action=delete&id=X` | Delete a product |
| GET | `/cart` | View cart |
| GET | `/cart?action=add&id=X` | Add product to cart |
| GET | `/remove-from-cart?id=X` | Remove item from cart |

---

## 🎓 Academic Context

This project was developed as a supervised exam (DS — Devoir Surveillé) on December 16, 2025, during the L3 Software Engineering program.

**Author:** Aissous  
[GitHub](https://github.com/aissouss)

---

## 📄 License

This project is for educational use only.
