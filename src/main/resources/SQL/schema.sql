CREATE TABLE "Parts" (
                                "article" bigint NOT NULL,
                                "avaliableCount" bigint NOT NULL,
                                "name" varchar(255) NOT NULL,
                                "price" bigint NOT NULL,
                                CONSTRAINT "Parts_pk" PRIMARY KEY ("article")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Order_parts" (
                                      "orderNumber" bigint NOT NULL,
                                      "partArticle" bigint NOT NULL,
                                      "invoiceNumber" bigint NOT NULL,
                                      "amount" bigint NOT NULL,
                                      CONSTRAINT "Order_parts_pk" PRIMARY KEY ("orderNumber")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Invoices" (
                                   "invoiceNumber" bigint NOT NULL,
                                   "customerId" bigint NOT NULL,
                                   "carVinNumber" varchar(255) NOT NULL,
                                   "employeeId" bigint NOT NULL,
                                   "description" varchar(255) NOT NULL,
                                   CONSTRAINT "Invoices_pk" PRIMARY KEY ("invoiceNumber")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Car_list" (
                                   "carId" bigint NOT NULL,
                                   "make" varchar(255) NOT NULL,
                                   "model" varchar(255) NOT NULL,
                                   "horsePower" bigint NOT NULL,
                                   "fuel" varchar(255) NOT NULL,
                                   "color" varchar(255) NOT NULL,
                                   CONSTRAINT "Car_list_pk" PRIMARY KEY ("carId")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Available_cars" (
                                         "VinNumber" varchar(255) NOT NULL,
                                         "carId" bigint NOT NULL,
                                         "price" bigint NOT NULL,
                                         "status" varchar(255) NOT NULL,
                                         CONSTRAINT "Available_cars_pk" PRIMARY KEY ("VinNumber")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Order" (
                                "orderId" bigint NOT NULL,
                                "customerId" bigint NOT NULL,
                                "carVinNumber" varchar(255) NOT NULL,
                                "orderStatus" varchar(255) NOT NULL,
                                CONSTRAINT "Order_pk" PRIMARY KEY ("orderId")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Customer" (
                                   "customerId" bigint NOT NULL,
                                   "isBlocked" BOOLEAN NOT NULL,
                                   CONSTRAINT "Customer_pk" PRIMARY KEY ("customerId")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Employee" (
                                   "employeeId" bigint NOT NULL,
                                   "positionId" bigint NOT NULL,
                                   CONSTRAINT "Employee_pk" PRIMARY KEY ("employeeId")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Position" (
                                   "positionId" bigint NOT NULL,
                                   "positionName" varchar(255) NOT NULL,
                                   "salary" bigint NOT NULL,
                                   CONSTRAINT "Position_pk" PRIMARY KEY ("positionId")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Human" (
                                "humanId" bigint NOT NULL,
                                "name" varchar(255) NOT NULL,
                                "lastName" varchar(255) NOT NULL,
                                "surname" varchar(255) NOT NULL,
                                "phoneNumber" bigint NOT NULL,
                                "email" varchar(255) NOT NULL,
                                "status" varchar(255) NOT NULL,
                                CONSTRAINT "Human_pk" PRIMARY KEY ("humanId")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Testdrive_list" (
                                         "testDriveNumber" bigint NOT NULL,
                                         "time" TIME NOT NULL,
                                         "customerId" bigint NOT NULL,
                                         "employeeId" bigint NOT NULL,
                                         "carVinNumber" varchar(255) NOT NULL,
                                         CONSTRAINT "Testdrive_list_pk" PRIMARY KEY ("testDriveNumber")
) WITH (
      OIDS=FALSE
    );




ALTER TABLE "Order_parts" ADD CONSTRAINT "Order_parts_fk0" FOREIGN KEY ("partArticle") REFERENCES "Parts"("article");
ALTER TABLE "Order_parts" ADD CONSTRAINT "Order_parts_fk1" FOREIGN KEY ("invoiceNumber") REFERENCES "Invoices"("invoiceNumber");

ALTER TABLE "Invoices" ADD CONSTRAINT "Invoices_fk0" FOREIGN KEY ("customerId") REFERENCES "Customer"("customerId");
ALTER TABLE "Invoices" ADD CONSTRAINT "Invoices_fk1" FOREIGN KEY ("employeeId") REFERENCES "Employee"("employeeId");


ALTER TABLE "Available_cars" ADD CONSTRAINT "Available_cars_fk0" FOREIGN KEY ("carId") REFERENCES "Car_list"("carId");

ALTER TABLE "Order" ADD CONSTRAINT "Order_fk0" FOREIGN KEY ("customerId") REFERENCES "Customer"("customerId");
ALTER TABLE "Order" ADD CONSTRAINT "Order_fk1" FOREIGN KEY ("carVinNumber") REFERENCES "Available_cars"("VinNumber");

ALTER TABLE "Customer" ADD CONSTRAINT "Customer_fk0" FOREIGN KEY ("customerId") REFERENCES "Human"("humanId");

ALTER TABLE "Employee" ADD CONSTRAINT "Employee_fk0" FOREIGN KEY ("employeeId") REFERENCES "Human"("humanId");
ALTER TABLE "Employee" ADD CONSTRAINT "Employee_fk1" FOREIGN KEY ("positionId") REFERENCES "Position"("positionId");



ALTER TABLE "Testdrive_list" ADD CONSTRAINT "Testdrive_list_fk0" FOREIGN KEY ("customerId") REFERENCES "Customer"("customerId");
ALTER TABLE "Testdrive_list" ADD CONSTRAINT "Testdrive_list_fk1" FOREIGN KEY ("employeeId") REFERENCES "Employee"("employeeId");
ALTER TABLE "Testdrive_list" ADD CONSTRAINT "Testdrive_list_fk2" FOREIGN KEY ("carVinNumber") REFERENCES "Available_cars"("VinNumber");











