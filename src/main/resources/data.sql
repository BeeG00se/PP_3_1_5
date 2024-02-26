INSERT INTO User (name, surname, password, user_id) VALUES ('user', 'surnameU', 'user', 1);
INSERT INTO User (name, surname, password, user_id) VALUES ('admin', 'surnameA', 'admin', 2);

INSERT INTO Role (name, role_id) VALUES ('USER', 1);
INSERT INTO Role (name, role_id) VALUES ('ADMIN', 2);

INSERT INTO User_role (user_user_id, role_role_id) VALUES (2, 2);
INSERT INTO User_role (user_user_id, role_role_id) VALUES (2, 1);
INSERT INTO User_role (user_user_id, role_role_id) VALUES (1, 1);