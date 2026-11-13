PRAGMA foreign_key=ON;
BEGIN TRANSACTION;
INSERT INTO CLIENTES (id, nombre, matricula, telefono) VALUES
    (1, 'Juan García', '1234ABC', '600123456'),
    (2, 'María López', '5678DEF', '611234567'),
    (3, 'Pedro Sánchez', '9012GHI', '622345678'),
    (4, 'Laura Martín', '3456JKL', '633456789'),
    (5, 'Carlos Pérez', '7890MNO', '644567890');
INSERT INTO pagos (id, idCliente, fechaRepostajes, importe, litros, combustible) VALUES
    (1, 1, '01/11/2026', 50.00, 35.5, 'Gasolina 95'),
    (2, 2, '02/11/2026', 65.00, 45.2, 'Diésel'),
    (3, 3, '03/11/2026', 40.00, 28.0, 'Gasolina 98'),
    (4, 1, '05/11/2026', 55.00, 38.5, 'Gasolina 95'),
    (5, 4, '06/11/2026', 70.00, 48.0, 'Diésel'),
    (6, 5, '07/11/2026', 45.00, 31.5, 'Gasolina 95'),
    (7, 2, '08/11/2026', 60.00, 42.0, 'Diésel'),
    (8, 3, '09/11/2026', 52.00, 36.0, 'Gasolina 98'),
    (9, 4, '10/11/2026', 48.00, 33.0, 'Diésel'),
    (10, 5, '11/11/2026', 75.00, 52.0, 'Gasolina 95');

COMMIT;

