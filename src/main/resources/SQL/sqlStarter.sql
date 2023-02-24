CREATE TABLE "Car" (
                       "Id" bigint NOT NULL,
                       "make" varchar(255) NOT NULL,
                       "model" varchar(255) NOT NULL,
                       "fuel" varchar(255) NOT NULL,
                       "horsePower" bigint NOT NULL,
                       "price" bigint NOT NULL,
                       "isAvailable" boolean NOT NULL,
                       CONSTRAINT "Car_pk" PRIMARY KEY ("Id")
) WITH (
      OIDS=FALSE
      );



CREATE TABLE "Customer" (
                            "id" bigint NOT NULL,
                            "name" varchar(255) NOT NULL,
                            "surname" varchar(255) NOT NULL,
                            "email" varchar(255) NOT NULL,
                            "balance" bigint NOT NULL,
                            CONSTRAINT "Customer_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
      );



CREATE TABLE "Order" (
                         "id" bigint NOT NULL,
                         "userId" bigint NOT NULL,
                         "carId" bigint NOT NULL,
                         "totalPrice" bigint NOT NULL,
                         CONSTRAINT "Order_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
      );



CREATE TABLE "Employees" (
                             "id" bigint NOT NULL,
                             "name" varchar(255) NOT NULL,
                             "surname" varchar(255) NOT NULL,
                             "positionId" bigint NOT NULL,
                             "email" varchar(255) NOT NULL,
                             CONSTRAINT "Employees_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
      );



CREATE TABLE "Positions" (
                             "id" bigint NOT NULL,
                             "salary" bigint NOT NULL,
                             "positionName" varchar(255) NOT NULL,
                             CONSTRAINT "Positions_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
      );



CREATE TABLE "Parts" (
                         "id" bigint NOT NULL,
                         "name" varchar(255) NOT NULL,
                         "amount" bigint NOT NULL,
                         "price" bigint NOT NULL,
                         CONSTRAINT "Parts_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
      );



CREATE TABLE "Invoices" (
                            "id" bigint NOT NULL,
                            "customerId" bigint NOT NULL,
                            "carId" bigint NOT NULL,
                            "parts" json NOT NULL,
                            "engineerId" bigint NOT NULL,
                            CONSTRAINT "Invoices_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
      );



CREATE TABLE "testDriveList" (
                                 "id" bigint NOT NULL,
                                 "customerId" bigint NOT NULL,
                                 "carId" bigint NOT NULL,
                                 "managerId" bigint NOT NULL,
                                 "time" time NOT NULL,
                                 CONSTRAINT "testDriveList_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
      );





ALTER TABLE "Order" ADD CONSTRAINT "Order_fk0" FOREIGN KEY ("userId") REFERENCES "Customer"("id");
ALTER TABLE "Order" ADD CONSTRAINT "Order_fk1" FOREIGN KEY ("carId") REFERENCES "Car"("Id");

ALTER TABLE "Employees" ADD CONSTRAINT "Employees_fk0" FOREIGN KEY ("positionId") REFERENCES "Positions"("id");



ALTER TABLE "Invoices" ADD CONSTRAINT "Invoices_fk0" FOREIGN KEY ("customerId") REFERENCES "Customer"("id");
ALTER TABLE "Invoices" ADD CONSTRAINT "Invoices_fk1" FOREIGN KEY ("carId") REFERENCES "Car"("Id");
ALTER TABLE "Invoices" ADD CONSTRAINT "Invoices_fk2" FOREIGN KEY ("engineerId") REFERENCES "Employees"("id");

ALTER TABLE "testDriveList" ADD CONSTRAINT "testDriveList_fk0" FOREIGN KEY ("customerId") REFERENCES "Customer"("id");
ALTER TABLE "testDriveList" ADD CONSTRAINT "testDriveList_fk1" FOREIGN KEY ("carId") REFERENCES "Car"("Id");
ALTER TABLE "testDriveList" ADD CONSTRAINT "testDriveList_fk2" FOREIGN KEY ("managerId") REFERENCES "Employees"("id");












