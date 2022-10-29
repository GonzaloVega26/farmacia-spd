#drop database test;
#create database test;

USE test;
# Tabla Genero
INSERT INTO genero VALUES(1,"Masculino");
INSERT INTO genero VALUES(2,"Femenino");
INSERT INTO genero VALUES(3,"No Binario");
INSERT INTO genero VALUES(4,"Otro");

# Tabla Metodos de Pago

INSERT INTO metodo_pago VALUES(1,"Debito Efectivo");
INSERT INTO metodo_pago VALUES(2,"Debito Tarjeta");
INSERT INTO metodo_pago VALUES(3,"Debito Transferencia");
INSERT INTO metodo_pago VALUES(4,"Credito Tarjeta");

#Tabla Laboratorio
INSERT INTO laboratorio(nombre) VALUES("Baxter Argentina");
INSERT INTO laboratorio(nombre) VALUES("Pfizer Argentina");
INSERT INTO laboratorio(nombre) VALUES("Stiefel, S.A.");
INSERT INTO laboratorio(nombre) VALUES("Beta");
INSERT INTO laboratorio(nombre) VALUES("Bayer");
INSERT INTO laboratorio(nombre) VALUES("Boehringer Ingelheim Argentina");

# Tabla Domicilio
INSERT INTO domicilio (provincia,departamento,calle,numero,cp) VALUES("Mendoza","Maipu","Sarmiento",105,5513);
INSERT INTO domicilio (provincia,departamento,calle,numero,cp) VALUES("Mendoza","Godoy Cruz","San Martin",553,5501);
INSERT INTO domicilio (provincia,departamento,calle,numero,cp) VALUES("Mendoza","Las Heras","Chile",1002,5620);
INSERT INTO domicilio (provincia,departamento,calle,numero,cp) VALUES("Mendoza","Guaymallén","España",2350,5521);
INSERT INTO domicilio (provincia,departamento,calle,numero,cp) VALUES("Mendoza","SpringField","Siempre Viva",1530,6802);


# Tabla Empleado

INSERT INTO empleado(nombre,apellido,dni,fecha_nacimiento,mail,telefono,turno,salario,id_domicilio,id_genero)
 VALUES("Gonzalo","Vega",40370142,"1997-02-26","vega_g@gmail.com",2613420290,"MANIANA",80000,1,1);
INSERT INTO empleado(nombre,apellido,dni,fecha_nacimiento,mail,telefono,turno,salario,id_domicilio,id_genero)
VALUES("Franco","Albornoz",43501123,"1999-05-10","albornoz_f@gmail.com",2612365297,"TARDE",80000,2,1);
INSERT INTO empleado(nombre,apellido,dni,fecha_nacimiento,mail,telefono,turno,salario,id_domicilio,id_genero)
VALUES("Alberto","Bleuss",45025951,"2002-11-05","bleuss_a@gmail.com",2616954988,"MANIANA",80000,3,1);
INSERT INTO empleado(nombre,apellido,dni,fecha_nacimiento,mail,telefono,turno,salario,id_domicilio,id_genero)
VALUES("Ignacio","Ramett",42780139,"1997-02-26","rammet_i@gmail.com",261112346,"NOCHE",90000,4,1);
INSERT INTO empleado(nombre,apellido,dni,fecha_nacimiento,mail,telefono,turno,salario,id_domicilio,id_genero)
VALUES("Mary","Smith",35420142,"1992-06-29","smith_m@gmail.com",2616954988,"TARDE",120000,4,1);

# Tabla Cliente
INSERT INTO cliente(nombre,apellido,dni,fecha_nacimiento,mail,telefono,id_domicilio,id_genero)
VALUES("Mary","Smith",1234567890,"1982-06-29","smith_m@gmail.com",2616954988,2,1);
INSERT INTO cliente(nombre,apellido,dni,fecha_nacimiento,mail,telefono,id_domicilio,id_genero)
VALUES("Marge","Simpson",34123456,"1992-06-29","simpson_m@gmail.com",2616954988,5,2);
INSERT INTO cliente(nombre,apellido,dni,fecha_nacimiento,mail,telefono,id_domicilio,id_genero)
VALUES("Homero","Simpson",33123456,"1990-06-29","simpson_h@gmail.com",2616954988,5,1);
INSERT INTO cliente(nombre,apellido,dni,fecha_nacimiento,mail,telefono,id_domicilio,id_genero)
VALUES("Bart","Simpson",40123456,"2000-06-29","simpson_b@gmail.com",2616954988,5,1);
INSERT INTO cliente(nombre,apellido,dni,fecha_nacimiento,mail,telefono,id_domicilio,id_genero)
VALUES("Lisa","Simpson",41123456,"2002-06-29","simpson_l@gmail.com",2616954988,5,2);
INSERT INTO cliente(nombre,apellido,dni,fecha_nacimiento,mail,telefono,id_domicilio,id_genero)
VALUES("Maggie","Simpson",45123456,"2006-06-29","simpson_mag@gmail.com",2616954988,5,3);

# Tabla Razon Social

INSERT INTO razon_social(nombre,cuit,data_fiscal,fecha_ini_actividad) VALUES("Farmadb SA","30-69213874-7","Responsable inscripto","2020-12-12");

# Tabla Medicamento

INSERT INTO medicamento(nombre,lote,stock,precio_unitario,es_recetado,fecha_venc,id_laboratorio) VALUES("Ibuprofeno 400mg",500,150,300,false,"2024-12-12",1);
INSERT INTO medicamento(nombre,lote,stock,precio_unitario,es_recetado,fecha_venc,id_laboratorio) VALUES("Ibuprofeno 600mg",510,100,450,false,"2024-12-12",1);
INSERT INTO medicamento(nombre,lote,stock,precio_unitario,es_recetado,fecha_venc,id_laboratorio) VALUES("Pervinox 150ml",400,20,600,false,"2034-2-24",2);
INSERT INTO medicamento(nombre,lote,stock,precio_unitario,es_recetado,fecha_venc,id_laboratorio) VALUES("Vic VapoRub",420,5,1200,true,"2022-5-5",3);
INSERT INTO medicamento(nombre,lote,stock,precio_unitario,es_recetado,fecha_venc,id_laboratorio) VALUES("Vic VapoRub",300,10,1400,true,"2025-1-12",5);
INSERT INTO medicamento(nombre,lote,stock,precio_unitario,es_recetado,fecha_venc,id_laboratorio) VALUES("Agua Oxigenada 500ml",20,23,700,false,"2023-12-12",4);


# Tabla Obra Social
INSERT INTO obra_social(id,nombre,mail,telefono) VALUES(1,"Medife", "medife_mail@gmail.com", "0800123456");
INSERT INTO obra_social(id,nombre,mail,telefono) VALUES(2,"OSDE", "osde_mail@gmail.com", "0800123456");
INSERT INTO obra_social(id,nombre,mail,telefono) VALUES(3,"Swiss Medical", "swiss_mail@gmail.com", "0800123456");
INSERT INTO obra_social(id,nombre,mail,telefono) VALUES(4,"Sancor Salud", "medife_mail@gmail.com", "0800123456");

# Tabla Cliente Has Obra Social
INSERT INTO cliente_obras_sociales(cliente_id,obras_sociales_id) VALUES(1,1);
INSERT INTO cliente_obras_sociales(cliente_id,obras_sociales_id) VALUES(1,2);
INSERT INTO cliente_obras_sociales(cliente_id,obras_sociales_id) VALUES(2,1);
INSERT INTO cliente_obras_sociales(cliente_id,obras_sociales_id) VALUES(3,3);
INSERT INTO cliente_obras_sociales(cliente_id,obras_sociales_id) VALUES(3,4);


# Tabla Plan Obra Social

INSERT INTO plan_obra_social VALUES(1,"1000");
INSERT INTO plan_obra_social VALUES(2,"1500");
INSERT INTO plan_obra_social VALUES(3,"3000");
INSERT INTO plan_obra_social VALUES(4,"3500");
INSERT INTO plan_obra_social VALUES(5,"5000");
INSERT INTO plan_obra_social VALUES(6,"Silver");
INSERT INTO plan_obra_social VALUES(7,"Gold");
INSERT INTO plan_obra_social VALUES(8,"Platinum");

# Tabla Plan Obra Social Has Obra Social
INSERT INTO obra_social_planes_obras_sociales VALUES(1,1);
INSERT INTO obra_social_planes_obras_sociales VALUES(1,2);
INSERT INTO obra_social_planes_obras_sociales VALUES(1,3);
INSERT INTO obra_social_planes_obras_sociales VALUES(1,4);
INSERT INTO obra_social_planes_obras_sociales VALUES(1,5);
INSERT INTO obra_social_planes_obras_sociales VALUES(2,6);
INSERT INTO obra_social_planes_obras_sociales VALUES(2,7);
INSERT INTO obra_social_planes_obras_sociales VALUES(2,8);




