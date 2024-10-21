SELECT name, population, area -- We want to return the name, population and area of big countries
FROM World -- We're selecting from the World table
WHERE area >= 3000000 OR population >= 25000000 -- The requirement for a country to be big is if the area is bigger or equal to 3000000 or if the population is bigger or equal to 25000000