SELECT product_id -- We want to return the prodcut id
FROM Products -- We're selecting from the Products table
WHERE low_fats = 'Y' AND recyclable = 'Y'; -- We want the product to both be low fat and recyclable