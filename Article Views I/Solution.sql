SELECT DISTINCT author_id as id -- We want to select author ids distinctly, naming them id
FROM Views -- We're selecting from the Views table
WHERE author_id = viewer_id -- We're looking for the instances where an author views their own article
ORDER BY author_id asc -- We're ordering the ids in ascending order