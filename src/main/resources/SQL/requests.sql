/*Задача 1.1 Вывести всех пользователей, статус которых "Active*/
SELECT * from "Human" where status='Active';

/*Задача 1.2 Вывести марку, модель, количество лошадиных сил, топливо и цвет тех машин, у которых больше 500 лс*/
SELECT make, model, "horsePower", fuel, color from "Car_list" where "horsePower">500;

/*Задача 2.1  Вывести марку, модель и цвет машины, которая доступна в автосалоне на данный момент*/
SELECT Cl.make, Cl.model, Cl.color FROM "Available_cars" ac join "Car_list" Cl on ac."carId" = Cl."carId" where ac."status" = 'available';

/*Задача 2.2 Вывести имя, фамилию, номер телефона тех клиентов, статус которых "Заблокирован*/
SELECT h.name, h.surname, h."phoneNumber" from "Human" h join "Customer" C on h."humanId" = C."customerId" where C."isBlocked"=true;

/*Задача 2.3 Вывести список заказанных деталей с указанием наименования детали, ее количества и номера заказов, на которые эти детали были заказаны.*/
SELECT p.name, op.amount, op."invoiceNumber"
FROM "Order_parts" op
         JOIN "Parts" p ON op."partArticle" = p.article;

/*Задача 3.1 Вывести имена, фамилии и номера телефонов тех работников, которые являются контролерами качества*/
SELECT h.name, h.surname, h."phoneNumber"
FROM "Employee" e
    join "Position" p on e."positionId" = p."positionId"
    join "Human" H on e."employeeId" = H."humanId"
    where p."positionName"='Контролер качества';

/*Задача 3.2 Вывести марку, модель и цвет машины, доступной для тест драйва*/

SELECT Cl.make, Cl.model, Cl.color FROM "Available_cars" Ac
        join "Car_list" Cl on Cl."carId" = Ac."carId"
        join "Testdrive_list" Tl on Ac."VinNumber" = Tl."carVinNumber"
        where Ac.status='available';