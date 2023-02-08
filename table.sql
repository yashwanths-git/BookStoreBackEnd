drop database book_store_db;


show databases;
show tables;



CREATE database book_store_db;
use book_store_db;


drop table book_sale;
drop table order_details;
drop table book_sale_user;




desc book_sale;
desc book_rent;
desc book_sale_user;
desc order_details;
desc rent_details;

select* from book_sale;
select* from order_details;
select* from book_sale_user;
select*from registered_user;

insert into book_sale values(101,"Mark Twain",549,"Adventures of Tom Sawyer",765);
insert into book_sale values(102,"Lewis Carrol",159,"Alice in Wonderland",550);
insert into book_sale values(103,"Kazi Nasrul Islam",119,"Agni Veena",430);
insert into book_sale values(104,"Jules Verne",19,"Around the World in eighty days",650);

insert into book_sale values(101,"Mark Twain",549,"Adventures of Tom Sawyer",765),(102,"Lewis Carrol",159,"Alice in Wonderland",550),(103,"Kazi Nasrul Islam",119,"Agni Veena",430),(104,"Jules Verne",19,"Around the World in eighty days",650);
UPDATE book_sale SET available_quantity =210 WHERE book_id =5;
