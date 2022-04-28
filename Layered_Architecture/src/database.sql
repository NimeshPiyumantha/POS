
DROP DATABASE IF EXISTS company;
CREATE DATABASE IF NOT EXISTS company;
SHOW DATABASES;
use company;

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer` (
                            `id` varchar(30) NOT NULL,
                            `name` varchar(40) DEFAULT NULL,
                            `address` varchar(100) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO  Customer VALUES ('C-001','Nimesh','Hapugala');
INSERT INTO  Customer VALUES ('C-002','Pasan','Hapugala');
INSERT INTO  Customer VALUES ('C-003','Akila','Hapugala');

--
-- Dumping data for table `Customer`
--

--
-- Table structure for table `Item`
--

DROP TABLE IF EXISTS `Item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Item` (
                        `code` varchar(255) NOT NULL,
                        `description` varchar(255) DEFAULT NULL,
                        `qtyOnHand` int(10) DEFAULT NULL,
                        `unitPrice` decimal(10,2) DEFAULT NULL,
                        PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO  Item VALUES ('I-001','Toy-Car',300,2000);
INSERT INTO  Item VALUES ('I-002','Toy-Bike',300,1500);
INSERT INTO  Item VALUES ('I-003','Toy-wheel',310,1000);
--
-- Dumping data for table `Item`
--




DROP TABLE IF EXISTS `Orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Orders` (
                          `oid` varchar(255) NOT NULL,
                          `date` date DEFAULT NULL,
                          `customerID` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`oid`),
                          KEY `customerID` (`customerID`),
                          CONSTRAINT `Orders_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `Customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Table structure for table `OrderDetails`
--

DROP TABLE IF EXISTS `OrderDetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

CREATE TABLE `OrderDetails` (
                                `oid` varchar(255) NOT NULL,
                                `itemCode` varchar(255) NOT NULL,
                                `qty` int(10) DEFAULT NULL,
                                `unitPrice` decimal(10,2) DEFAULT NULL,
                                PRIMARY KEY (`oid`,`itemCode`),
                                KEY `itemCode` (`itemCode`),
                                CONSTRAINT `OrderDetails_ibfk_1` FOREIGN KEY (`oid`) REFERENCES `Orders` (`oid`) ON DELETE CASCADE ON UPDATE CASCADE,
                                CONSTRAINT `OrderDetails_ibfk_2` FOREIGN KEY (`itemCode`) REFERENCES `Item` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OrderDetails`
--

--
-- Table structure for table `Orders`
--


