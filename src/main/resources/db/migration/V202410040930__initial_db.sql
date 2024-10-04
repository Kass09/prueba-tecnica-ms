INSERT INTO primas (amparo_id, minimum_age, maximum_age, prima_percentage) VALUES
(1, 18, 45, 0.02304),
(1, 46, 75, 0.02012),
(2, 18, 50, 0.18090),
(2, 51, 70, 0.16043),
(3, 18, 60, 0.14123),
(3, 61, 70, 0.15450),
(4, 18, 50, 0.12123),
(4, 51, 70, 0.13450);

INSERT INTO insured(type_identification_id, numb_identification, lastname, full_name, gender_id, birthdate)
	VALUES
	(1, '79000001', 'APELLIDO1', 'NOMBRE1', 1, '1945-01-10 00:00:00'),
	(1, '79000002', 'APELLIDO2', 'NOMBRE2', 1, '1950-01-10 00:00:00'),
	(1, '79000003', 'APELLIDO3', 'NOMBRE3', 1, '1955-01-10 00:00:00'),
	(2, '51000001', 'APELLIDO4', 'NOMBRE4', 2, '1955-01-10 00:00:00'),
	(2, '51000002', 'APELLIDO5', 'NOMBRE5', 2, '1960-01-10 00:00:00'),
	(2, '51000003', 'APELLIDO6', 'NOMBRE6', 2, '1965-01-10 00:00:00');