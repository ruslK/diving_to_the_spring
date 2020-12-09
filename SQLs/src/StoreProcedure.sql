CREATE OR REPLACE procedure update_department(emp_id int)
    language plpgsql
as
$$
begin
    update employees
    set department = 'Toys'
    where employee_id = emp_id;
    commit;
end
$$;


call update_department(1);
select department
from employees
where employee_id = 1;


CREATE OR REPLACE procedure transfer(sender int, receiver int, amount decimal)
    language plpgsql
as
$$
begin
    update employees set salary = salary - amount where employee_id = sender;
    update employees set salary = salary + amount where employee_id = receiver;
    commit;
end;
$$;

select employee_id, salary
from employees
order by employee_id;
call transfer(1, 2, 10000);