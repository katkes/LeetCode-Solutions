SELECT class -- We're returning the classes
FROM Courses C -- We're selecing from the courses table
GROUP BY C.class -- We want to group by class
HAVING COUNT(*) > 4 -- This is the restriction to have at least 5 students per course