DROP TABLE IF EXISTS mentors;
CREATE TABLE mentors
(
    id         INT GENERATED ALWAYS as IDENTITY,
    first_name varchar(48) NOT NULL,
    last_name  varchar(48) NOT NULL,
    primary key (id)
);

DROP TABLE IF EXISTS mentors_audit;
CREATE TABLE mentors_audit
(
    id        INT GENERATED ALWAYS as IDENTITY,
    mentor_id INT          NOT NULL,
    last_name varchar(48)  NOT NULL,
    change_on timestamp(6) NOT NULL,
    primary key (id)
);

insert into mentors (first_name, last_name)
values ('Mike', 'Smith');
insert into mentors (first_name, last_name)
values ('Tom', 'Hanks');



CREATE OR REPLACE FUNCTION log_lastName_Changes()
    returns TRIGGER
    language plpgsql
as
$$
begin
    IF NEW.last_name <> OLD.last_name THEN
        insert INTO mentors_audit(mentor_id, last_name, change_on)
        VALUES (OLD.id, OLD.last_name,
                now());
    end if;
    return new;
end;
$$;

CREATE TRIGGER last_name_change
    before update
    on mentors
    FOR EACH ROW
EXECUTE PROCEDURE log_lastName_Changes();

update mentors
set last_name = 'Test'
where id = 1;

-- Get list of the TRIGGERS
select *
from pg_trigger;

-- DROP TRIGGER
drop trigger if exists last_name_change on mentors;