CREATE TABLE booking(  
id INT AUTO_INCREMENT  PRIMARY KEY,  
userid INT NOT NULL,  
moviename VARCHAR(50) NOT NULL,
date VARCHAR(50),
totalcost INT
); 
CREATE TABLE theatre(  
id INT AUTO_INCREMENT  PRIMARY KEY,
moviename VARCHAR(50) NOT NULL,
time VARCHAR(50),
seatsavailable INT,
cost INT,
date VARCHAR(50)); 

