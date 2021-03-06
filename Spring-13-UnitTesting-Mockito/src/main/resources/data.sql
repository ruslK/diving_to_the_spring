INSERT INTO roles (insert_date_time, insert_user_id, is_deleted, last_update_date_time, lust_update_user_id,
                   description)
VALUES ('2021-01-05 00:00:00', 1, false, '2021-01-05 00:00:00', 1, 'Admin'),
       ('2021-01-05 00:00:00', 1, false, '2021-01-05 00:00:00', 1, 'Manager'),
       ('2021-01-05 00:00:00', 1, false, '2021-01-05 00:00:00', 1, 'Employee');


INSERT INTO users (insert_date_time, insert_user_id, is_deleted, last_update_date_time, lust_update_user_id, first_name,
                   last_name, user_name, phone, password, enabled, role_id, gender)
values ('2021-01-05 00:00:00', 1, false, '2021-01-05 00:00:00', 1, 'Mikaa', 'Submit', 'Mikaa@submit', '4564564545',
        'password', true, 2, 'MALE'),
       ('2021-01-05 00:00:00', 1, false, '2021-01-05 00:00:00', 1, 'Alex', 'Someone', 'Alex@Someone', '4564564545',
        'password', true, 2, 'MALE'),
       ('2021-01-05 00:00:00', 1, false, '2021-01-05 00:00:00', 1, 'Sara', 'Jones', 'Sara@Jones', '4564564545',
        'password', true, 2, 'FEMALE');


INSERT INTO projects (insert_date_time, insert_user_id, is_deleted, last_update_date_time, lust_update_user_id,
                      project_name, project_code, start_date, end_date,
                      project_details, project_status, user_id, complete_count, in_complete_count)
values ('2021-01-05 00:00:00', 1, false, '2021-01-05 00:00:00', 1, 'Selenium', 'SDET-001', '05/05/2020', '07/05/2020',
        'SDET Course', 'OPEN', 1, 0, 0),
       ('2021-01-05 00:00:00', 1, false, '2021-01-05 00:00:00', 1, 'JAVA_001', 'SDET-002', '05/05/2020', '07/05/2020',
        'SDET Course', 'IN_PROGRESS', 2, 0, 0);
