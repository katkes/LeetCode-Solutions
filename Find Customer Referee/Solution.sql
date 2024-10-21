SELECT name -- We want to return the name of customers 
FROM Customer -- We're selecting from the Customer tables
WHERE referee_id != 2 or referee_id is null; -- The conditions is that the referee isn't 2, we have null values which are valid and to be included