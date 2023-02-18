CREATE TABLE "Car" (
                       "Id" bigint NOT NULL,
                       "make" varchar(255) NOT NULL,
                       "model" varchar(255) NOT NULL,
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
                         "id" serial NOT NULL,
                         "userId" serial NOT NULL,
                         "carId" serial NOT NULL,
                         "totalPrice" serial NOT NULL,
                         CONSTRAINT "Order_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
      );



CREATE TABLE "Employees" (
                             "id" serial NOT NULL,
                             "name" serial(255) NOT NULL,
                             "surname" serial(255) NOT NULL,
                             "positionId" serial(255) NOT NULL,
                             "email" serial(255) NOT NULL,
                             CONSTRAINT "Employees_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
      );



CREATE TABLE "Positions" (
                             "id" serial NOT NULL,
                             "salary" serial NOT NULL,
                             "positionName" serial(255) NOT NULL,
                             CONSTRAINT "Positions_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
      );



CREATE TABLE "Parts" (
                         "id" serial NOT NULL,
                         "name" serial(255) NOT NULL,
                         "amount" serial(255) NOT NULL,
                         "price" serial(255) NOT NULL,
                         CONSTRAINT "Parts_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
      );



CREATE TABLE "Invoices" (
                            "id" serial NOT NULL,
                            "customerId" serial NOT NULL,
                            "carId" serial NOT NULL,
                            "parts" serial NOT NULL,
                            "engineerId" serial NOT NULL,
                            CONSTRAINT "Invoices_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
      );



CREATE TABLE "testDriveList" (
                                 "id" serial NOT NULL,
                                 "customerId" serial NOT NULL,
                                 "carId" serial NOT NULL,
                                 "managerId" serial NOT NULL,
                                 "time" serial NOT NULL,
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












