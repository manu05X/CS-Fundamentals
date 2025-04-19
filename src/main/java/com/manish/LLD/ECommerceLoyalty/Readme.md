# Gamification Service for E-Commerce Platform

## Problem Statement

Design a service that adds gamification elements to an e-commerce platform. This service will track user transactions, allowing users to purchase products, redeem existing points during purchases (with constraints based on user level), and earn new points from those purchases.

The service should incentivize purchases and engagement using points and levels, and it should be designed to be flexible and extensible.

---

## Functionalities Required

### 1. Onboard User
- Onboard user to our platform
- Command: `onboard <user_name>`

---

### 2. User Points
- Users earn points for every purchase.
- The service calculates points based on the user's level and the purchase amount:
    - For every ₹100 spent, users earn:
        - **Bronze**: 10 points
        - **Silver**: 12.5 points
        - **Gold**: 15 points
- Users can view their current point balance.

---

### 3. User Levels
- Users progress through levels based on accumulated points:
    - **Bronze**: 0 - 499 points
    - **Silver**: 500 - 999 points
    - **Gold**: 1000+ points
- Each level has associated benefits (redemption limits and point earning rates).

---

### 4. Purchase Products with Points Redemption

- Users can purchase products.
- Users can redeem existing points to pay for a portion of the purchase.

#### Redemption Rules
| Level   | Max Redemption % | Max Points Redeemable |
|---------|------------------|------------------------|
| Bronze  | 5%               | 200 points             |
| Silver  | 10%              | 500 points             |
| Gold    | 15%              | 1000 points            |

- Users can choose to redeem less than or equal to points eligible for redemption.
- Users **also** earn points on the remaining amount paid with actual money (based on their level and the ₹100 = 10 points rule).
- Command: `purchase <user_name> <order_amount> <points_to_redeem>`

---

### 5. Get User's Stats
- User can view their current level and points.
- Command: `getUserStats <user_name>`

---

### 6. Personalized Discount (Bonus Feature)

- Calculate a personalized discount for each user on their current purchase based on their past purchase history.

#### Discount Calculation Rules:
- If the user has placed more than **3 orders**, apply a **5% discount** on the current purchase.
- If the user's total spending is greater than **₹10,000**, apply a **10% discount**.
- If both conditions are true, apply a **12% discount**.
- The discount is applied **after** any point redemption.
- The discount should be **capped at ₹750.00**.
- After redemption of this offer, eligibility is reset (will again require at least 3 orders or spend at least ₹10,000 to re-qualify).

---

## Sample Test Cases

### 1. Bronze Purchase
- **Input**: `purchase user1 800.00 0`
- **Verify**:
    - Points Calculation: (800 / 100) * 10 = 80 points
- **Output**:  
  `Purchase successful. Points added: 80. Total payable amount: 800.00. Current points: 80. Current level: Bronze`  
  `orders count: 1`

---

### 2. Bronze Purchase (Not Enough Points)
- **Input**: `purchase user1 4200.00 100`
- **Output**:  
  `Purchase Failed. Not enough points to redeem`

---

### 3. Bronze Purchase (Approaching Silver)
- **Input**: `purchase user1 4200.00 0`
- **Verify**:
    - Points Calculation: (4200 / 100) * 10 = 420 points
- **Output**:  
  `Purchase successful. Points added: 420. Total payable amount: 4200.00. Current points: 500. Current level: Silver`  
  `orders count: 2`

---

### 4. Silver Purchase (With Redemption)
- **Input**: `purchase user1 3000.00 300`
- **Verify**:
    - Redemption allowed: Yes (Silver max redemption: 500)
    - Amount after redemption: 3000 - 300 = 2700
    - Points Calculation: (2700 / 100) * 12.5 = 337.5 points
- **Output**:  
  `Purchase successful. Points redeemed: 300. Points added: 337.5. Total payable amount: 2700.00. Current points: 537.5. Current level: Silver`  
  `orders count: 3`

---

### 5. Silver Purchase (Approaching Gold)
- **Input**: `purchase user1 5000.00 0`
- **Verify**:
    - Points Calculation: (5000 / 100) * 12.5 = 625.0 points
- **Output**:  
  `Purchase successful. Points added: 625.0. Total payable amount: 5000.00. Current points: 1162.5. Current level: Gold`

---

### 6. Gold Purchase (With Redemption, Discount) [Bonus Feature]
- **Assume** user1 now qualifies for a 5% discount (orders > 3).
- **Input**: `purchase user1 12000.00 800`
- **Verify**:
    - Redemption allowed: Yes (Gold max redemption: 1000)
    - Amount after redemption: 12000 - 800 = 11200
    - Discount Calculation: 11200 * 0.05 = 560.0
    - Amount after discount: 11200 - 560 = 10640.0
    - Points Calculation: (10640 / 100) * 15 = 1596.0
- **Output**:  
  `Purchase successful. Points redeemed: 800. Points added: 1596.0. Discount applied: 560.0. Total payable amount: 10640.0. Current points: 1958.5. Current level: Gold`  
  `orders count: 5`

---

### 7. Final Points Check
- **Input**: `getUserStats user1`
- **Output**:  
  `user1 has 1958.5 points. Current level: Gold`

---

## Guidelines

- **Time**: 90 mins
- Write **modular** and **clean** code.
- A **driver program/main class/test case** is needed to test out the code with multiple test cases.
- Keep **input parsing simple**.
- **Evaluation Criteria**:
    - Functionally correct and demoable code
    - Code readability
    - Proper Entity Modelling
    - Modularity & Extensibility
    - Separation of Concerns & Abstractions
    - Use of design patterns wherever applicable
- **No external databases** like MySQL. Use only **in-memory data structures**.
- No UI is needed.
- Bonus feature is **optional** and should be done **after** the core features are complete.
- **Use of Gen AI or any automated tool to write code is prohibited**.


---

### Input Commands

## Available Commands

```bash
onboard <username>               - Register new user  
purchase <user> <amount> <points> - Make purchase  
getUserStats <user>             - View user status  
test                            - Run test cases  
help                            - Show this help  
exit                            - Quit program

> onboard manish  
User manish onboarded successfully.

> purchase manish 800.00 0  
Purchase successful. Points added: 80.0. Total payable amount: 800.00. Current points: 80.0. Current level: BRONZE. Orders count: 1

> purchase manish 4200.00 100  
Purchase failed. Not enough points to redeem.

> purchase manish 4200.00 0  
Purchase successful. Points added: 420.0. Total payable amount: 4200.00. Current points: 500.0. Current level: SILVER. Orders count: 2

> purchase manish 3000.00 300  
Purchase successful. Points redeemed: 300.0. Points added: 337.5. Total payable amount: 2700.00. Current points: 537.5. Current level: SILVER. Orders count: 3

> purchase manish 5000.00 0  
Purchase successful. Points added: 625.0. Total payable amount: 5000.00. Current points: 1162.5. Current level: GOLD. Orders count: 4

> purchase manish 12000.00 800  
Purchase successful. Points redeemed: 800.0. Points added: 1567.5. Discount applied: 750.0. Total payable amount: 10450.00. Current points: 1930.0. Current level: GOLD. Orders count: 5

> getUserStats manish  
manish has 1930.0 points. Current level: GOLD.

```



