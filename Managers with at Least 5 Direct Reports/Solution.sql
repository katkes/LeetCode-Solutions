Select name  -- We want to get the name of employees
FROM Employee e1  
WHERE e1.id IN ( 
    Select managerId -- We want the manager who has at least 5 employees
    FROM Employee
    GROUP BY managerId -- Group by manager ids to see who has what manager and easy to count
    HAVING COUNT(*) >= 5 -- Each group must have at least 5 employees
)