use bibliotecajava;

insert into catalogo_roles(rol,descripcion) values('Admin','Admin del sistema');
insert into catalogo_roles(rol,descripcion) values('Alumno','Usuario del tipo alumno');

insert into catalogo_roles(rol,descripcion) values('Profesor','Usuario del tipo profesor');

insert into usuario(id_carne,id_catalogo_roles,password,estado) values('admin',1,'admin123',1);

insert into datos_personales(id_carne,nombre,apellido,genero,email,telefono,direccion) values ('admin','Administradorito','Admon',1,'admin@admin.com','22231205','La casa del admin');

insert into parametros(mora_por_dia,dias_prestar_alumno,dias_prestar_profesor,cantidad_prestar_alumno,cantidad_prestar_profesor) values (0.50,3,6,3,5);