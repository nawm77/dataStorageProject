/*Заполнение таблицы Human*/
INSERT INTO "Human" ("humanId", "name", "lastName", "surname", "phoneNumber", "email", "status")
VALUES
    (1001, 'John', 'Smith', 'Johnson', 1234567890, 'johnsmith@example.com', 'Active'),
    (1002, 'Jane', 'Doe', 'Johnson', 2345678901, 'janedoe@example.com', 'Active'),
    (1003, 'Michael', 'Brown', 'Davis', 3456789012, 'michaelbrown@example.com', 'Inactive'),
    (1004, 'Emily', 'Taylor', 'Miller', 4567890123, 'emilytaylor@example.com', 'Active'),
    (1005, 'William', 'Anderson', 'Wilson', 5678901234, 'williamanderson@example.com', 'Active'),
    (2001, 'Elizabeth', 'Lee', 'Wilson', 6789012345, 'elizabethlee@example.com', 'Inactive'),
    (2002, 'James', 'Baker', 'King', 7890123456, 'jamesbaker@example.com', 'Active'),
    (2003, 'Olivia', 'Garcia', 'Lee', 8901234567, 'oliviagarcia@example.com', 'Active'),
    (2004, 'David', 'Jackson', 'Harris', 9012345678, 'davidjackson@example.com', 'Inactive'),
    (2005, 'Sophia', 'White', 'Harris', 1234567890, 'sophiawhite@example.com', 'Active');

INSERT INTO "Position" ("positionId", "positionName", "salary")
VALUES
    (1, 'Менеджер по продажам', 50000),
    (2, 'Автослесарь', 40000),
    (3, 'Мастер по ремонту двигателей', 60000),
    (4, 'Контролер качества', 45000),
    (5, 'Механик', 35000);

insert into "Customer" ("customerId", "isBlocked") VALUES (1001, false);
insert into "Customer" ("customerId", "isBlocked") VALUES (1002, false);
insert into "Customer" ("customerId", "isBlocked") VALUES (1003, false);
insert into "Customer" ("customerId", "isBlocked") VALUES (1004, false);
insert into "Customer" ("customerId", "isBlocked") VALUES (1005, true);

insert into "Employee" ("employeeId", "positionId") VALUES (2001, 1);
insert into "Employee" ("employeeId", "positionId") VALUES (2002, 2);
insert into "Employee" ("employeeId", "positionId") VALUES (2003, 3);
insert into "Employee" ("employeeId", "positionId") VALUES (2004, 4);
insert into "Employee" ("employeeId", "positionId") VALUES (2005, 5);
/*Заполнение таблицы Car list*/
INSERT INTO "Car_list" ("carId", make, model, "horsePower", fuel, color) VALUES (1001, 'Chevrolet', 'Silverado', 300, 'Gasoline', 'Red');
INSERT INTO "Car_list" ("carId", make, model, "horsePower", fuel, color) VALUES (1002, 'GMC', 'Yukon', 400, 'Gasoline', 'Black');
INSERT INTO "Car_list" ("carId", make, model, "horsePower", fuel, color) VALUES (1003, 'BMW', 'M5', 625, 'Gasoline', 'Black');
INSERT INTO "Car_list" ("carId", make, model, "horsePower", fuel, color) VALUES (1004, 'Chevrolet', 'Tahoe', 350, 'Gasoline', 'Blue');
INSERT INTO "Car_list" ("carId", make, model, "horsePower", fuel, color) VALUES (1005, 'Mercedes', 'E63', 612, 'Gasoline', 'Black');
INSERT INTO "Car_list" ("carId", make, model, "horsePower", fuel, color) VALUES (1006, 'Mercedes', 'E200', 184, 'Gasoline', 'Silver');
INSERT INTO "Car_list" ("carId", make, model, "horsePower", fuel, color) VALUES (1007, 'Ferrari', '812', 800, 'Gasoline', 'Orange');
INSERT INTO "Car_list" ("carId", make, model, "horsePower", fuel, color) VALUES (1008, 'Lamorghini', 'Huracan', 640, 'Gasoline', 'Yellow');
/*Заполнение таблицы Avaliable cars*/
insert into "Available_cars" ("VinNumber", "carId", price, status) values ('WBA5E51030G205660', 1003, 11000000, 'available');
insert into "Available_cars" ("VinNumber", "carId", price, status) values ('X4X5E123GH6673013', 1001, 3000000, 'available');
insert into "Available_cars" ("VinNumber", "carId", price, status) values ('WBANX707THAY66194', 1002, 5000000, 'available');
insert into "Available_cars" ("VinNumber", "carId", price, status) values ('E789AJCB48149HH57', 1004, 7000000, 'unavailable');
insert into "Available_cars" ("VinNumber", "carId", price, status) values ('TGK7798ASD1940101', 1005, 9800000, 'available');
insert into "Available_cars" ("VinNumber", "carId", price, status) values ('VINNUM18237418742', 1006, 4000000, 'available');
insert into "Available_cars" ("VinNumber", "carId", price, status) values ('VINTEST5567162438', 1007, 1900000, 'available');
insert into "Available_cars" ("VinNumber", "carId", price, status) values ('VINREL10923KHA198', 1008, 1800000, 'unavailable');
/*Заполнение таблицы с запчастями*/
INSERT INTO "Parts" (article, "avaliableCount", name, price) VALUES (123456, 50, 'Spark Plug', 5);
INSERT INTO "Parts" (article, "avaliableCount", name, price) VALUES (789012, 25, 'Oil Filter', 8);
INSERT INTO "Parts" (article, "avaliableCount", name, price) VALUES (345678, 10, 'Brake Pads', 25);
INSERT INTO "Parts" (article, "avaliableCount", name, price) VALUES (901234, 15, 'Air Filter', 12);
INSERT INTO "Parts" (article, "avaliableCount", name, price) VALUES (567890, 5, 'Fuel Pump', 50);
/*Заполнение таблицы с заказами в сервис*/
INSERT INTO "Invoices" ("invoiceNumber", "customerId", "carVinNumber", "employeeId", description) VALUES (5001, 1001, '1GCHK23295F841282', 2001, 'Oil Change');
INSERT INTO "Invoices" ("invoiceNumber", "customerId", "carVinNumber", "employeeId", description) VALUES (5002, 1002, '1GNSKJKC8FR120141', 2002, 'Brake Repair');
INSERT INTO "Invoices" ("invoiceNumber", "customerId", "carVinNumber", "employeeId", description) VALUES (5003, 1003, '5UXKR0C53H0U56808', 2003, 'Air Filter Replacement');
INSERT INTO "Invoices" ("invoiceNumber", "customerId", "carVinNumber", "employeeId", description) VALUES (5004, 1004, '1GCNCPEH2CZ150038', 2004, 'Fuel Pump Replacement');
INSERT INTO "Invoices" ("invoiceNumber", "customerId", "carVinNumber", "employeeId", description) VALUES (5005, 1005, 'JTHKD5BH2F2230787', 2005, 'Engine Diagnostic');
/*Заполнение таблицы с накладными для заказов в сервисе*/
INSERT INTO "Order_parts" ("orderNumber", "partArticle", "invoiceNumber", amount) VALUES (1001, 123456, 5001, 4);
INSERT INTO "Order_parts" ("orderNumber", "partArticle", "invoiceNumber", amount) VALUES (1002, 789012, 5001, 2);
INSERT INTO "Order_parts" ("orderNumber", "partArticle", "invoiceNumber", amount) VALUES (1003, 345678, 5002, 1);
INSERT INTO "Order_parts" ("orderNumber", "partArticle", "invoiceNumber", amount) VALUES (1004, 901234, 5003, 3);
INSERT INTO "Order_parts" ("orderNumber", "partArticle", "invoiceNumber", amount) VALUES (1005, 567890, 5004, 2);

INSERT INTO "Order_status" ("statusId", description) VALUES (0, 'Order accepted');
INSERT INTO "Order_status" ("statusId", description) VALUES (1, 'In production');
INSERT INTO "Order_status" ("statusId", description) VALUES (2, 'In delivery');
INSERT INTO "Order_status" ("statusId", description) VALUES (3, 'Delivered');

INSERT INTO "Order" ("orderId", "customerId", "carVinNumber", "orderStatusId") VALUES (1, 1001, 'WBA5E51030G205660', 0);
INSERT INTO "Order" ("orderId", "customerId", "carVinNumber", "orderStatusId") VALUES (2, 1001, 'X4X5E123GH6673013', 1);
INSERT INTO "Order" ("orderId", "customerId", "carVinNumber", "orderStatusId") VALUES (3, 1001, 'WBANX707THAY66194', 2);
INSERT INTO "Order" ("orderId", "customerId", "carVinNumber", "orderStatusId") VALUES (4, 1002, 'E789AJCB48149HH57', 3);
INSERT INTO "Order" ("orderId", "customerId", "carVinNumber", "orderStatusId") VALUES (5, 1003, 'TGK7798ASD1940101', 3);

INSERT INTO "Testdrive_list" ("testDriveNumber", time, "customerId", "employeeId", "carVinNumber") VALUES (1, '14:00:00', 1001, 2001, 'VINNUM18237418742');
INSERT INTO "Testdrive_list" ("testDriveNumber", time, "customerId", "employeeId", "carVinNumber") VALUES (2, '15:30:00', 1002, 2002, 'VINTEST5567162438');
INSERT INTO "Testdrive_list" ("testDriveNumber", time, "customerId", "employeeId", "carVinNumber") VALUES (3, '11:00:00', 1003, 2003, 'VINREL10923KHA198');