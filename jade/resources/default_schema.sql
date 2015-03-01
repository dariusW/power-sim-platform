create table simulation (
  simulation_id VARCHAR(255),
  execution_date TIMESTAMP not null,
  simulation_step varchar(15) not null,
  simulation_start timestamp not null,
  simulation_end timestamp not null,
  configuration_url varchar(255) not null,
  constraint simulation_pk primary key (simulation_id, execution_date)
);

create table time_point (
  simulation_id varchar(255) not null,
  execution_date TIMESTAMP not null,
  time_id timestamp not null,
  foreign key (simulation_id, execution_date) references simulation (simulation_id, execution_date) on delete cascade,
  constraint time_pk primary key (simulation_id, execution_date, time_id)
);

create table agent_instance (
  simulation_id VARCHAR(255),
  execution_date TIMESTAMP not null,
  instance_id VARCHAR(255),
  agent_class VARCHAR(255) not null,
  constraint instance_pk primary key (simulation_id, execution_date, instance_id),  
  foreign key (simulation_id, execution_date) references simulation (simulation_id, execution_date) on delete cascade
); 

create table power_log (
  simulation_id VARCHAR(255),
  execution_date TIMESTAMP not null,
  time_id TIMESTAMP not null,
  instance_id VARCHAR(255),
  power number(10),
  delta varchar(10),
  consumption double,
  constraint power_pk primary key (simulation_id, execution_date, time_id, instance_id),
  foreign key (simulation_id, execution_date, time_id) references time_point (simulation_id, execution_date, time_id) on delete cascade,
  foreign key (simulation_id, execution_date, instance_id) references agent_instance (simulation_id, execution_date, instance_id) on delete cascade  
);

create table state_log (
  simulation_id VARCHAR(255),
  execution_date TIMESTAMP not null,
  time_id TIMESTAMP not null,
  instance_id VARCHAR(255),
  state varchar(255),
  constraint state_pk primary key (simulation_id, execution_date, time_id, instance_id),
  foreign key (simulation_id, execution_date, time_id) references time_point (simulation_id, execution_date, time_id) on delete cascade,
  foreign key (simulation_id, execution_date, instance_id) references agent_instance (simulation_id, execution_date, instance_id) on delete cascade  
);

create table variable_log (
  simulation_id VARCHAR(255),
  execution_date TIMESTAMP not null,
  time_id TIMESTAMP not null,
  instance_id VARCHAR(255),
  variable_id VARCHAR(255),
  prev_value varchar(255),
  new_value varchar(255),
  increment number(12),
  constraint variable_pk primary key (simulation_id, execution_date, time_id, instance_id, increment),
  foreign key (simulation_id, execution_date, time_id) references time_point (simulation_id, execution_date, time_id) on delete cascade,
  foreign key (simulation_id, execution_date, instance_id) references agent_instance (simulation_id, execution_date, instance_id) on delete cascade 
);