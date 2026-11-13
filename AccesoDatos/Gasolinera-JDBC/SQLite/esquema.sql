PRAGMA foreign_keys=ON;
CREATE TABLE IF NOT EXISTS CLIENTES (
     id INTEGER primary key NOT NULL  CHECK(id>0),
    nombre TEXT NOT NULL CHECK(length(trim(nombre))>0),
    matricula TEXT unique NOT NULL CHECK(length(trim(matricula))>0),
    telefono TEXT  NOT NULL CHECK(length(trim(telefono))>0)
);
create table if not exists pagos (
    id INTEGER primary key NOT NULL  CHECK(id>0),
    idCliente INTEGER  CHECK(idCliente>0),
    fechaRepostajes TEXT NOT NULL CHECK(length(trim(fechaRepostajes))>0),
    importe REAL NOT NULL  CHECK(importe>0),
    litros REAL NOT NULL CHECK(litros>0),
    combustible TEXT NOT NULL CHECK(length(trim(combustible))>0),
    foreign key (idCliente)REFERENCES CLIENTES(id)
);