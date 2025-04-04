# Feed.Me: Food Ordering System

**Time:** 90 minutes

## Description
Implement an online food ordering system with the following features:

## Features
1. The system partners with restaurants where each has:
    - A menu with items and their prices
    - A rating (out of 5)
2. Each restaurant has a maximum order capacity:
    - Cannot accept new orders when at capacity
    - Capacity freed when orders are completed
3. Order lifecycle:
    - `ACCEPTED` orders can be marked `COMPLETED` by restaurant
    - `ACCEPTED` orders cannot be `CANCELLED`
4. Auto-assignment of orders to restaurants based on customer-specified criteria:
    - Examples: lowest cost, best rating
5. Order fulfillment:
    - Only assigned if all items can be fulfilled by a single restaurant
    - Otherwise, order is not accepted

## Requirements
1. Onboard new restaurants.
2. A restaurant should be able to update its menu. For simplicity, a restaurant can't delete
   an item from the menu.
3. Restaurants can mark `ACCEPTED` orders as `COMPLETED`. Orders once `ACCEPTED`.
4. Customer order placement with:
    - Items and quantities
    - Selection criteria
5. Order will be auto-assigned to a restaurant based on a selection criteria.
6. Implement all restaurant selection criteria.
7. **Bonus:** Restaurant should be able to update Capacity.
8. **Bonus:** Add one more selection criteria - remaining maximum capacity available for a restaurant. The restaurant with max remaining capacity should process the order.

## Technical Constraints
- Use in-memory store (no database/NoSQL)
- Must be demoable and functionally correct code.
- Use proper abstractions, separation of concerns, proper entity modeling.
- Use appropriate design patterns wherever required.
- Modular, extensible, readable, and testable code
- Proper exception handling is required.
- Restaurant selection criteria must be extensible.
- **Bonus:** Concurrency handling (BONUS / Good to have)

## Sample Test Cases

### 1. Onboard Restaurants
**R1**
```json
{
  "max_orders_that_can_be_processed_at_a_time": 5,
  "Menu": {
    "Veg Biryani": 100,
    "Chicken Biryani": 150
  },
  "rating": 4.5
}
```


**R2**
```json
{
  "max_orders_that_can_be_processed_at_a_time": 5,
  "menu": {
    "Chicken Biryani": 175,
    "Idli": 10,
    "Dosa": 50,
    "Veg Biryani": 80
  },
  "rating": 4
}
```

**R3**
```json
{
  "max_orders_that_can_be_processed_at_a_time": 1,
  "menu": {
    "Gobi Manchurian": 150,
    "Idli": 15,
    "Chicken Biryani": 175,
    "Dosa": 30
  },
  "rating": 4.9
}
```

### 2. Update Restaurant Menu
- **ADD:** `{Restaurant_1, add, Chicken65, 250}`

- **UPDATE:** `{Restaurant_2, update, Chicken Biryani, 150}`

### 3. Place Orders

**Order - 1**

- Input:
    ```json
    {
      "user": "Ashwin",
      "items": {
        "Idli": 3,
        "Dosa": 1
      },
      "selection": "Lowest cost"
    }

    ```
- **Output:** `Order assigned to R3`

**Order - 2**

- Input:
    ```json
      {
          "user": "Harish",
          "items": {
            "Idli": 3,
            "Dosa": 1
          },
          "selection": "Lowest cost"
      }
    ```
- **Output:** ` Order assigned to R2 (Not R3 since it has reached its full capacity from Order1) `


**Order - 3**

- Input:
    ```json
  
        {
          "user": "Shruthi",
          "items": {
            "Veg Biryani": 3
          },
          "selection": "Highest rating"
        }

    ```
- **Output:** `Order assigned to R1`


### 4. Update Order Status

- **R3** marks **Order1** as **COMPLETED**

**Order - 4**

- Input:
    ```json
    {
      "user": "Harish",
      "items": {
        "Idli": 3,
        "Dosa": 1
      },
      "selection": "Lowest cost"
    }

    ```
- **Output:** `Order assigned to R3 (since R3 has COMPLETED Order1) `

**Order - 5**

- Input:
    ```json
    {
      "user": "xyz",
      "items": {
        "Paneer Tikka": 1,
        "Idli": 1
      },
      "selection": "Lowest cost"
    }

    ```
- **Output:** `Order can’t be fulfilled (since none of the restaurants above serve Paneer Tikka)`



