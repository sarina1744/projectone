# projectone
TITLE: projectone
=====================================================================================================
DESCRIPTION:
Set up the backend for an online store to buy items. Users can register and log in to add items to their cart. Then they can place orders. Registered users are stored in the Users table. Items that users can buy are stored in the Item table. User's cart are stored in the Cart table. User's orders are stored in the Orders table.
==================================================================================================
User stories:
- Users able to register and login to get the items to the cart.
- Users able to order.
- Authorized users able to access, delete, and update users.
- User's item are stored in item table.
- Cart table holds items of user.
- Order table holds user's cart.
======================================
Features Implemented:
- Login and logout for the users.
- Register new users.
- Get item, delete item, and add items.
- View cart, delete item in cart, and update cart.
- View order, delete order, and update order table.
===========================================================================
Requirements:
JDK 1.8
MAVEN
==========================================================================
Required steps for access:
Table Users:
1. View all users: GET http://ec2-18-221-51-74.us-east-2.compute.amazonaws.com:8090/users
 (no description required and anybody can access it)
2. Register new user: POST http://ec2-18-221-51-74.us-east-2.compute.amazonaws.com:8090/users 
(Body{"username","password","role"} is required and only ADMIN AND EMPLOYEE role is required)
3. Delete users: DELETE http://ec2-18-221-51-74.us-east-2.compute.amazonaws.com:8090/users/{id}
(Body{id} and authorized users are ADMIN AND EMPLOYEE)
4. Login : POST http://ec2-18-221-51-74.us-east-2.compute.amazonaws.com:8090/login
   (Body{"username", "password"})
5. Logout: POST http://ec2-18-221-51-74.us-east-2.compute.amazonaws.com:8090/logout
   (Body{"username", "password"})

Table Items:
1. View all items: GET http://ec2-18-221-51-74.us-east-2.compute.amazonaws.com:8090/items
2. Add items: POST http://ec2-18-221-51-74.us-east-2.compute.amazonaws.com:8090/items
   (Body:{"itemName", "itemPrice", "stockQuantity"} and authorized role is ADMIN AND EMPLOYEE)
3. Delete items: DELETE http://ec2-18-221-51-74.us-east-2.compute.amazonaws.com:8090/items/{id}
(Body:{"id} in URI and authorized login is required)
4. Updating items: POST http://ec2-18-221-51-74.us-east-2.compute.amazonaws.com:8090/items
   (Body:{"id","itemName","itemPrice","stockQuantity"} and authorized login is required)

Table Carts:
1. View all carts :GET http://ec2-18-221-51-74.us-east-2.compute.amazonaws.com:8090/carts
2. Add item in cart : POST http://ec2-18-221-51-74.us-east-2.compute.amazonaws.com:8090/carts
   (Body: {"item_id", "user_id", "item_quantity", "total"})
3. To find cart by ID : GET http://ec2-18-221-51-74.us-east-2.compute.amazonaws.com:8090/carts/{ID}
   (Body: {ID} in URI and authorzied role for deleting are ADMIN AND EMPLOYEE)
4. Deleting cart : DELETE http://ec2-18-221-51-74.us-east-2.compute.amazonaws.com:8090/carts/{ID}
   (Body : {ID} in URI)

Table Orders:
1. View the order list: GET http://ec2-18-221-51-74.us-east-2.compute.amazonaws.com:8090/orders
2. Add order list: POST http://ec2-18-221-51-74.us-east-2.compute.amazonaws.com:8090/orders
   (Body:{"order_id", "user_id", "total", "item_quantity"})
3. Delete the order: DELETE http://ec2-18-221-51-74.us-east-2.compute.amazonaws.com:8090/orders/{ID}
   (Body: {ID} in URI)
