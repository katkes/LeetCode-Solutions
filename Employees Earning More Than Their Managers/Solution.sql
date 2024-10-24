SELECT subord.name as Employee 
FROM Employee subord, Employee manager 
WHERE subord.salary > manager.salary AND manager.id = subord.managerId