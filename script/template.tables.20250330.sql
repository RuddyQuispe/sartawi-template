create table t_domain
(
    domain_id   smallint generated always as identity primary key,
    code        varchar(30) not null,
    name        varchar(30) not null,
    value       varchar(30) not null,
    description text        not null,
    last_user   varchar(30) not null,
    last_time   timestamp   not null
);

create table t_webservice
(
    webservice_id   smallint generated always as identity primary key,
    code            varchar(30)  not null unique,
    description     varchar(200) not null,
    enabled         boolean      not null,
    url             varchar(500) not null,
    content_type    varchar(200) not null,
    accept          varchar(200) not null,
    connect_timeout integer      not null,
    read_timeout    integer      not null,
    max_retry       smallint     null,
    enabled         boolean      not null,
    last_user       varchar(30)  not null,
    last_time       timestamp    not null
);


CREATE TABLE t_email
(
    email_id   smallint generated always as identity primary key,
    company_id smallint     null,
    code       varchar(50)  not null unique,
    reference  varchar(200) not null,
    title      varchar(200) not null,
    receiver   varchar(500) not null,
    body       text         not null,
    fields     text         null,
    last_user  varchar(30)  not null,
    last_time  timestamp    not null
);

create table t_user
(
    user_id    integer generated always as identity primary key,
    username   varchar(150) not null,
    user_login varchar(50)  not null unique,
    password   varchar(250) not null,
    enabled    boolean      not null default false,
    profile_id smallint     not null references t_profile,
    last_user  varchar(30)  not null,
    last_time  timestamp    not null
);

create table t_profile
(
    profile_id  integer generated always as identity primary key,
    name        varchar(50)  not null,
    description varchar(255) not null,
    enabled     boolean      not null,
    last_user   varchar(30)  not null,
    last_time   timestamp    not null
);

create table t_menu
(
    menu_id        smallint generated always as identity primary key,
    name           varchar(50)  not null,
    route          varchar(150) not null,
    icon           varchar(20)  not null,
    parent_menu_id smallint     null references t_menu
);

create table t_menu_profile
(
    menu_profile_id smallint generated always as identity primary key,
    menu_id         smallint not null references t_menu,
    profile_id      smallint not null references t_profile,
    enabled         boolean  not null default false,
    canCreate       boolean  not null,
    canUpdate       boolean  not null,
    canRead         boolean  not null
);

insert into t_profile (name, description, enabled, company_id, last_user, last_time)
values ('admin', 'rol principal', true, null, 'super', now());

insert into t_user (username, user_login, password, enabled, company_id, profile_id, last_user, last_time)
values ('ruddy quispe', 'rquispe', 'password', true, null, 1, 'super', now());

select *
from t_profile;
select *
from t_user;