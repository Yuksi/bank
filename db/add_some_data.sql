use bank;

insert into clients(name, address, age) values ('Ivan Ivanov', 'Ivanova street, 5', 30);
insert into clients(name, address, age) values ('Petr Petrov', 'Petrova street, 5', 30);
insert into clients(name, address, age) values ('Sidor Sidorov', 'Sidorova street, 5', 30);

insert into accounts(client_id,sum) values (1,1000000);
insert into accounts(client_id,sum) values (1,100);
insert into accounts(client_id,sum) values (2,2000);
insert into accounts(client_id,sum) values (3,3000);
insert into accounts(client_id,sum) values (3,6000);

insert into transactions(sender_acc_id, getter_acc_id, amount, add_date) values (1,2,100,'2017-01-01 01:01:01');
insert into transactions(sender_acc_id, getter_acc_id, amount, add_date) values (2,1,200,'2017-02-02 02:02:02');
insert into transactions(sender_acc_id, getter_acc_id, amount, add_date) values (1,2,800,'2017-08-08 08:08:08');
insert into transactions(getter_acc_id, amount, add_date) values (1,500,'2017-05-05 05:05:05');
insert into transactions(sender_acc_id, amount, add_date) values (2,600,'2017-06-06 06:06:06');
commit;

exit;