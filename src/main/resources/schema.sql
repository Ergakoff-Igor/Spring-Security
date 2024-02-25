CREATE TABLE IF NOT EXISTS actTable
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    reportingPeriod varchar(10) NOT NULL,
    projectSection  varchar(10) NOT NULL,
    price           double      NOT NULL,
    status          varchar(30) NOT NULL
);