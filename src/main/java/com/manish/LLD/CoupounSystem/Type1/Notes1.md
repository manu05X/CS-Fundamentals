# Coupon System Code Structure


## 1. Class Diagram (Mermaid)

```mermaid
classDiagram
    class Cart {
        -String cartId
        -List<CartItem> items
        +getItems() List<CartItem>
    }

    class CartItem {
        -String productId
        -String productType
        -int quantity
        -double price
        +getProductType() String
        +getPrice() double
    }

    class Coupon {
        -String couponId
        -double discountAmount
        -List<Rule> rules
        -String ruleFormula
        +getDiscountAmount() double
        +isApplicable(Order order) boolean
    }

    class Order {
        -String orderId
        -User user
        -Cart cart
        -double totalAmount
        +getUser() User
        +getCart() Cart
        +getTotalAmount() double
    }

    class User {
        -String userId
        -String userType
        -List<String> pastPurchases
        +getUserType() String
        +getPastPurchases() List<String>
    }

    class Rule {
        <<interface>>
        +check(Order order) boolean
    }

    class ProductTypeRule {
        -String requiredTypeProduct
        +check(Order order) boolean
    }

    class UserRuleType {
        -String allowedUserType
        +check(Order order) boolean
    }

    class CouponRecommendation {
        <<interface>>
        +getCoupons(Order order) List<Coupon>
    }

    class CouponRecommendationImpl {
        -List<Coupon> availableCoupon
        -ExecutorService executorService
        +getCoupons(Order order) List<Coupon>
        +shutdown() void
    }

    Cart "1" -- "*" CartItem
    Order "1" -- "1" User
    Order "1" -- "1" Cart
    Coupon "1" -- "*" Rule
    CouponRecommendationImpl ..|> CouponRecommendation
    CouponRecommendationImpl "1" -- "*" Coupon
    ProductTypeRule ..|> Rule
    UserRuleType ..|> Rule
```


## 2. Database Schema Diagram
```mermaid
erDiagram
    USER ||--o{ ORDER : places
    USER {
        string user_id PK
        string user_type
    }
    
    ORDER ||--|{ CART_ITEM : contains
    ORDER {
        string order_id PK
        string user_id FK
        double total_amount
    }
    
    COUPON ||--o{ COUPON_RULE : has
    COUPON {
        string coupon_id PK
        double discount_amount
        string rule_formula
    }
    
    COUPON_RULE {
        int rule_id PK
        string coupon_id FK
        string rule_type
        string rule_value
    }
    
    CART_ITEM {
        string item_id PK
        string order_id FK
        string product_id
        string product_type
        int quantity
        double price
    }
```

## 3. State Diagram (Coupon Application Flow)

```mermaid
stateDiagram-v2
    [*] --> OrderCreated
    OrderCreated --> RulesEvaluation: Start processing
    RulesEvaluation --> ParallelEvaluation: For each coupon
    state ParallelEvaluation {
        [*] --> Rule1Check
        Rule1Check --> Rule2Check: if passed
        Rule2Check --> AllRulesPassed: if passed
        Rule1Check --> SomeRuleFailed: if failed
        Rule2Check --> SomeRuleFailed: if failed
    }
    AllRulesPassed --> CouponApplicable
    SomeRuleFailed --> CouponNotApplicable
    CouponApplicable --> [*]
    CouponNotApplicable --> [*]
```

## 4. Sequence Diagram (Main Flow)

```mermaid
sequenceDiagram
    participant Main
    participant CouponRecommendationImpl
    participant Coupon
    participant Rule
    
    Main->>CouponRecommendationImpl: getCoupons(order)
    activate CouponRecommendationImpl
    
    loop For each Coupon
        CouponRecommendationImpl->>Coupon: isApplicable(order)
        activate Coupon
        
        loop For each Rule in parallel
            Coupon->>Rule: check(order)
            activate Rule
            Rule-->>Coupon: true/false
            deactivate Rule
        end
        
        Coupon-->>CouponRecommendationImpl: applicability
        deactivate Coupon
    end
    
    CouponRecommendationImpl-->>Main: List<Coupon>
    deactivate CouponRecommendationImpl
```

## 5. Code Flow Diagram

```mermaid
flowchart TD
    A[Main: Create Rules & Coupons] --> B[Create Test Data]
    B --> C[Initialize Recommendation Service]
    C --> D[Get Coupons for Order]
    D --> E[Parallel Evaluation Flow]
    
    subgraph E[Parallel Evaluation Flow]
        E1[For each Coupon in thread pool]
        E2[For each Rule in parallel stream]
        E3[Check rule conditions]
        E4[Combine results]
        
        E1 --> E2 --> E3 --> E4
    end
    
    E --> F[Filter Applicable Coupons]
    F --> G[Return Results]
    G --> H[Print Applicable Coupons]
```
---

# Coupon Recommendation System - Interview Questions

## 1. Design & Architecture
- How would you scale this system for 10 million daily users?
- What design patterns are used in this implementation? (Builder, Strategy, etc.)
- How would you modify this system to support real-time coupon updates?
- What are the trade-offs between `parallelStream()` vs. `ThreadPoolExecutor`?
- How would you make this system cloud-native?

## 2. Concurrency & Multithreading
- Why did you choose `parallelStream()` over traditional threading for rule evaluation?
- How does `ForkJoinPool` differ from `FixedThreadPool` in this use case?
- What happens if a rule evaluation throws an exception in parallel processing?
- How would you handle thread starvation in the coupon recommendation service?
- Explain how you would implement a circuit breaker for rule evaluation.

## 3. Performance Optimization
- How would you cache rule evaluation results? (e.g., Guava Cache, Redis)
- What metrics would you track to monitor system performance?
- How could you optimize the `ProductTypeRule` for large carts (e.g., 1000+ items)?
- Would database indexing help if rules were querying a database? How?
- How would you implement bulk coupon evaluation for batch processing?

## 4. Object-Oriented Principles
- Why is `Rule` an interface instead of an abstract class?
- How does polymorphism manifest in this design?
- What SOLID principles are demonstrated in the `CouponRecommendationImpl`?
- How would you extend this system to support composite rules (OR/NOT conditions)?
- Why are the model classes (User, Order) immutable? What are the advantages?

## 5. Testing
- How would you unit test `UserRuleType.check()`?
- What edge cases would you test for in `ProductTypeRule`?
- How would you simulate high load in integration tests?
- How would you mock dependencies for `CouponRecommendationImpl` tests?
- What test coverage metrics would you aim for in this system?

## 6. Error Handling & Resilience
- How would you handle a slow-running third-party rule evaluation?
- What retry strategies would you implement for flaky rules?
- How would you ensure coupon recommendations are consistent during partial failures?
- Would you implement a dead-letter queue for failed evaluations? How?
- How would you alert on anomalous rule evaluation times?

## 7. Database & Persistence
- How would you model these entities in a relational database?
- What NoSQL database would you use for this system? Why?
- How would you shard the coupon data if it grew to 1TB?
- What caching strategy would you use for frequently accessed coupons?
- How would you handle schema migrations for new rule types?

## 8. API Design (if exposed as service)
- How would you design a REST API for this coupon system?
- What HTTP status codes would you return for invalid coupon applications?
- How would you version the recommendation API?
- Would you use GraphQL for the coupon recommendation query? Why?
- How would you document the API for external consumers?

## 9. Advanced Java Concepts
- How does `CompletableFuture` improve upon the current thread pool approach?
- What Java memory management concerns exist in this implementation?
- How could Project Loom's virtual threads benefit this system?
- Would Java Records be suitable for any of these model classes? Which ones?
- How could you use the Java Flow API for reactive coupon recommendations?

## 10. Behavioral / System Design
- How would you explain this system to a non-technical stakeholder?
- If you had to rebuild this in 3 months, what would you do differently?
- How would you prioritize features if the product team requested:
    - Personalized coupons
    - Geo-based restrictions
    - Time-bound coupons
- What would you do if the business wanted to add AI-based dynamic pricing rules?
- How would you convince management to invest in a rule engine like Drools?

## Bonus: Scenario-Based Questions
- **At 3AM, the system slows down despite low traffic. What could be wrong?**  
  → Check scheduled jobs, DB maintenance, cache eviction policies.

- **Users report seeing applicable coupons disappear when refreshing. How to debug?**  
  → Race condition in parallel evaluation, add request correlation IDs.

- **A new rule type requires calling an external service with 500ms latency. How to adapt?**  
  → Implement async evaluation, caching, timeout fallbacks.

- **Business wants coupon fraud detection. Where would you add this logic?**  
  → As a pre-processing rule or post-recommendation filter.

- **How would you make this system GDPR-compliant for user data in rules?**  
  → Pseudonymization in logging, right-to-erasure support.
